package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.common.biari.MDecoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.aso.MapManager;
import org.jcodec.codecs.h264.decode.aso.Mapper;
import org.jcodec.codecs.h264.io.CABAC;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class FrameReader {
    private IntObjectMap<SeqParameterSet> sps = new IntObjectMap<>();
    private IntObjectMap<PictureParameterSet> pps = new IntObjectMap<>();

    private SliceReader createSliceReader(ByteBuffer byteBuffer, NALUnit nALUnit) {
        MDecoder mDecoder;
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        SliceHeader part1 = SliceHeaderReader.readPart1(bitReaderCreateBitReader);
        PictureParameterSet pictureParameterSet = this.pps.get(part1.picParameterSetId);
        part1.pps = pictureParameterSet;
        SeqParameterSet seqParameterSet = this.sps.get(pictureParameterSet.seqParameterSetId);
        part1.sps = seqParameterSet;
        SliceHeaderReader.readPart2(part1, nALUnit, seqParameterSet, part1.pps, bitReaderCreateBitReader);
        Mapper mapper = new MapManager(part1.sps, part1.pps).getMapper(part1);
        CAVLC[] cavlcArr = {new CAVLC(part1.sps, part1.pps, 2, 2), new CAVLC(part1.sps, part1.pps, 1, 1), new CAVLC(part1.sps, part1.pps, 1, 1)};
        CABAC cabac = new CABAC(part1.sps.picWidthInMbsMinus1 + 1);
        if (part1.pps.entropyCodingModeFlag) {
            bitReaderCreateBitReader.terminate();
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 1024);
            cabac.initModels(iArr, part1.sliceType, part1.cabacInitIdc, part1.pps.picInitQpMinus26 + 26 + part1.sliceQpDelta);
            mDecoder = new MDecoder(byteBuffer, iArr);
        } else {
            mDecoder = null;
        }
        return new SliceReader(part1.pps, cabac, cavlcArr, mDecoder, bitReaderCreateBitReader, mapper, part1, nALUnit);
    }

    public void addPps(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferClone = NIOUtils.clone(byteBuffer);
        H264Utils.unescapeNAL(byteBufferClone);
        PictureParameterSet pictureParameterSet = PictureParameterSet.read(byteBufferClone);
        this.pps.put(pictureParameterSet.picParameterSetId, pictureParameterSet);
    }

    public void addPpsList(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            addPps(it.next());
        }
    }

    public void addSps(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferClone = NIOUtils.clone(byteBuffer);
        H264Utils.unescapeNAL(byteBufferClone);
        SeqParameterSet seqParameterSet = SeqParameterSet.read(byteBufferClone);
        this.sps.put(seqParameterSet.seqParameterSetId, seqParameterSet);
    }

    public void addSpsList(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            addSps(it.next());
        }
    }

    public List<SliceReader> readFrame(List<ByteBuffer> list) {
        ArrayList arrayList = new ArrayList();
        for (ByteBuffer byteBuffer : list) {
            NALUnit nALUnit = NALUnit.read(byteBuffer);
            H264Utils.unescapeNAL(byteBuffer);
            NALUnitType nALUnitType = NALUnitType.SPS;
            NALUnitType nALUnitType2 = nALUnit.type;
            if (nALUnitType == nALUnitType2) {
                SeqParameterSet seqParameterSet = SeqParameterSet.read(byteBuffer);
                this.sps.put(seqParameterSet.seqParameterSetId, seqParameterSet);
            } else if (NALUnitType.PPS == nALUnitType2) {
                PictureParameterSet pictureParameterSet = PictureParameterSet.read(byteBuffer);
                this.pps.put(pictureParameterSet.picParameterSetId, pictureParameterSet);
            } else if (NALUnitType.IDR_SLICE == nALUnitType2 || NALUnitType.NON_IDR_SLICE == nALUnitType2) {
                if (this.sps.size() == 0 || this.pps.size() == 0) {
                    Logger.warn("Skipping frame as no SPS/PPS have been seen so far...");
                    return null;
                }
                arrayList.add(createSliceReader(byteBuffer, nALUnit));
            }
        }
        return arrayList;
    }
}
