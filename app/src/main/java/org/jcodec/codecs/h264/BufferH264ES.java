package org.jcodec.codecs.h264;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class BufferH264ES implements DemuxerTrack, Demuxer {
    private ByteBuffer bb;
    private int prevFrameNum;
    private int prevFrameNumOffset;
    private int prevPicOrderCntLsb;
    private int prevPicOrderCntMsb;
    private IntObjectMap<PictureParameterSet> pps = new IntObjectMap<>();
    private IntObjectMap<SeqParameterSet> sps = new IntObjectMap<>();
    private int frameNo = 0;

    public BufferH264ES(ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
    }

    private int calcPOC0(NALUnit nALUnit, SliceHeader sliceHeader) {
        int i = sliceHeader.picOrderCntLsb;
        int i2 = 1 << (sliceHeader.sps.log2MaxPicOrderCntLsbMinus4 + 4);
        int i3 = this.prevPicOrderCntLsb;
        int i4 = (i >= i3 || i3 - i < i2 / 2) ? (i <= i3 || i - i3 <= i2 / 2) ? this.prevPicOrderCntMsb : this.prevPicOrderCntMsb - i2 : this.prevPicOrderCntMsb + i2;
        if (nALUnit.nal_ref_idc != 0) {
            this.prevPicOrderCntMsb = i4;
            this.prevPicOrderCntLsb = i;
        }
        return i4 + i;
    }

    private int calcPOC1(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        int i2;
        int i3;
        if (sliceHeader.sps.numRefFramesInPicOrderCntCycle == 0) {
            i = 0;
        }
        if (nALUnit.nal_ref_idc == 0 && i > 0) {
            i--;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            SeqParameterSet seqParameterSet = sliceHeader.sps;
            i2 = seqParameterSet.numRefFramesInPicOrderCntCycle;
            if (i4 >= i2) {
                break;
            }
            i5 += seqParameterSet.offsetForRefFrame[i4];
            i4++;
        }
        if (i > 0) {
            int i6 = i - 1;
            int i7 = i6 / i2;
            int i8 = i6 % i2;
            i3 = i7 * i5;
            for (int i9 = 0; i9 <= i8; i9++) {
                i3 += sliceHeader.sps.offsetForRefFrame[i9];
            }
        } else {
            i3 = 0;
        }
        if (nALUnit.nal_ref_idc == 0) {
            i3 += sliceHeader.sps.offsetForNonRefPic;
        }
        return i3 + sliceHeader.deltaPicOrderCnt[0];
    }

    private int calcPOC2(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        return nALUnit.nal_ref_idc == 0 ? (i * 2) - 1 : i * 2;
    }

    private int calcPoc(int i, NALUnit nALUnit, SliceHeader sliceHeader) {
        int i2 = sliceHeader.sps.picOrderCntType;
        return i2 == 0 ? calcPOC0(nALUnit, sliceHeader) : i2 == 1 ? calcPOC1(i, nALUnit, sliceHeader) : calcPOC2(i, nALUnit, sliceHeader);
    }

    private boolean detectGap(SliceHeader sliceHeader, int i) {
        int i2 = sliceHeader.frameNum;
        int i3 = this.prevFrameNum;
        return (i2 == i3 || i2 == (i3 + 1) % i) ? false : true;
    }

    private boolean detectMMCO5(RefPicMarking refPicMarking) {
        if (refPicMarking == null) {
            return false;
        }
        for (RefPicMarking.Instruction instruction : refPicMarking.getInstructions()) {
            if (instruction.getType() == RefPicMarking.InstrType.CLEAR) {
                return true;
            }
        }
        return false;
    }

    private Packet detectPoc(ByteBuffer byteBuffer, NALUnit nALUnit, SliceHeader sliceHeader) {
        int i = 1 << (sliceHeader.sps.log2MaxFrameNumMinus4 + 4);
        if (detectGap(sliceHeader, i)) {
            issueNonExistingPic(sliceHeader, i);
        }
        int iUpdateFrameNumber = updateFrameNumber(sliceHeader.frameNum, i, detectMMCO5(sliceHeader.refPicMarkingNonIDR));
        int iCalcPoc = nALUnit.type == NALUnitType.NON_IDR_SLICE ? calcPoc(iUpdateFrameNumber, nALUnit, sliceHeader) : 0;
        long j = iUpdateFrameNumber;
        int i2 = this.frameNo;
        this.frameNo = i2 + 1;
        return new Packet(byteBuffer, j, 1, 1L, i2, nALUnit.type == NALUnitType.IDR_SLICE ? Packet.FrameType.KEY : Packet.FrameType.INTER, null, iCalcPoc);
    }

    private void issueNonExistingPic(SliceHeader sliceHeader, int i) {
        this.prevFrameNum = (this.prevFrameNum + 1) % i;
    }

    private SliceHeader readSliceHeader(ByteBuffer byteBuffer, NALUnit nALUnit) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        SliceHeader part1 = SliceHeaderReader.readPart1(bitReaderCreateBitReader);
        PictureParameterSet pictureParameterSet = this.pps.get(part1.picParameterSetId);
        SliceHeaderReader.readPart2(part1, nALUnit, this.sps.get(pictureParameterSet.seqParameterSetId), pictureParameterSet, bitReaderCreateBitReader);
        return part1;
    }

    private boolean sameFrame(NALUnit nALUnit, NALUnit nALUnit2, SliceHeader sliceHeader, SliceHeader sliceHeader2) {
        if (sliceHeader.picParameterSetId != sliceHeader2.picParameterSetId || sliceHeader.frameNum != sliceHeader2.frameNum) {
            return false;
        }
        int i = sliceHeader.sps.picOrderCntType;
        if (i == 0 && sliceHeader.picOrderCntLsb != sliceHeader2.picOrderCntLsb) {
            return false;
        }
        if (i == 1) {
            int[] iArr = sliceHeader.deltaPicOrderCnt;
            int i2 = iArr[0];
            int[] iArr2 = sliceHeader2.deltaPicOrderCnt;
            if (i2 != iArr2[0] || iArr[1] != iArr2[1]) {
                return false;
            }
        }
        int i3 = nALUnit.nal_ref_idc;
        if ((i3 == 0 || nALUnit2.nal_ref_idc == 0) && i3 != nALUnit2.nal_ref_idc) {
            return false;
        }
        NALUnitType nALUnitType = nALUnit.type;
        NALUnitType nALUnitType2 = NALUnitType.IDR_SLICE;
        return (nALUnitType == nALUnitType2) == (nALUnit2.type == nALUnitType2) && sliceHeader.idrPicId == sliceHeader2.idrPicId;
    }

    private int updateFrameNumber(int i, int i2, boolean z) {
        int i3 = this.prevFrameNum > i ? this.prevFrameNumOffset + i2 : this.prevFrameNumOffset;
        int i4 = i3 + i;
        if (z) {
            i = 0;
        }
        this.prevFrameNum = i;
        this.prevFrameNumOffset = i3;
        return i4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return new ArrayList();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return null;
    }

    public PictureParameterSet[] getPps() {
        return this.pps.values(new PictureParameterSet[0]);
    }

    public SeqParameterSet[] getSps() {
        return this.sps.values(new SeqParameterSet[0]);
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        return getVideoTracks();
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() {
        ByteBuffer byteBufferDuplicate = this.bb.duplicate();
        NALUnit nALUnit = null;
        SliceHeader sliceHeader = null;
        while (true) {
            this.bb.mark();
            ByteBuffer byteBufferNextNALUnit = H264Utils.nextNALUnit(this.bb);
            if (byteBufferNextNALUnit == null) {
                break;
            }
            NALUnit nALUnit2 = NALUnit.read(byteBufferNextNALUnit);
            NALUnitType nALUnitType = nALUnit2.type;
            if (nALUnitType == NALUnitType.IDR_SLICE || nALUnitType == NALUnitType.NON_IDR_SLICE) {
                SliceHeader sliceHeader2 = readSliceHeader(byteBufferNextNALUnit, nALUnit2);
                if (nALUnit != null && sliceHeader != null && !sameFrame(nALUnit, nALUnit2, sliceHeader, sliceHeader2)) {
                    this.bb.reset();
                    break;
                }
                sliceHeader = sliceHeader2;
                nALUnit = nALUnit2;
            } else if (nALUnitType == NALUnitType.PPS) {
                PictureParameterSet pictureParameterSet = PictureParameterSet.read(byteBufferNextNALUnit);
                this.pps.put(pictureParameterSet.picParameterSetId, pictureParameterSet);
            } else if (nALUnitType == NALUnitType.SPS) {
                SeqParameterSet seqParameterSet = SeqParameterSet.read(byteBufferNextNALUnit);
                this.sps.put(seqParameterSet.seqParameterSetId, seqParameterSet);
            }
        }
        byteBufferDuplicate.limit(this.bb.position());
        if (sliceHeader == null) {
            return null;
        }
        return detectPoc(byteBufferDuplicate, nALUnit, sliceHeader);
    }
}
