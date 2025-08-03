package org.jcodec.codecs.h264;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.h264.io.write.SliceHeaderWriter;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

/* loaded from: classes2.dex */
public class H264Utils {

    public static class Mv {
        public static int mvC(int i, int i2) {
            return i2 == 0 ? mvX(i) : mvY(i);
        }

        public static int mvRef(int i) {
            return i >> 26;
        }

        public static int mvX(int i) {
            return (i << 18) >> 18;
        }

        public static int mvY(int i) {
            return (i << 6) >> 20;
        }

        public static int packMv(int i, int i2, int i3) {
            return (i & 16383) | ((i2 & 4095) << 14) | ((i3 & 63) << 26);
        }
    }

    public static class MvList {
        private static final int NA = Mv.packMv(0, 0, -1);
        private int[] list;

        public MvList(int i) {
            this.list = new int[i << 1];
            clear();
        }

        public void clear() {
            int i = 0;
            while (true) {
                int[] iArr = this.list;
                if (i >= iArr.length) {
                    return;
                }
                int i2 = NA;
                iArr[i + 1] = i2;
                iArr[i] = i2;
                i += 2;
            }
        }

        public void copyPair(int i, MvList mvList, int i2) {
            int[] iArr = this.list;
            int i3 = i << 1;
            int[] iArr2 = mvList.list;
            int i4 = i2 << 1;
            iArr[i3] = iArr2[i4];
            iArr[i3 + 1] = iArr2[i4 + 1];
        }

        public int getMv(int i, int i2) {
            return this.list[(i << 1) + i2];
        }

        public int mv0R(int i) {
            return Mv.mvRef(this.list[i << 1]);
        }

        public int mv0X(int i) {
            return Mv.mvX(this.list[i << 1]);
        }

        public int mv0Y(int i) {
            return Mv.mvY(this.list[i << 1]);
        }

        public int mv1R(int i) {
            return Mv.mvRef(this.list[(i << 1) + 1]);
        }

        public int mv1X(int i) {
            return Mv.mvX(this.list[(i << 1) + 1]);
        }

        public int mv1Y(int i) {
            return Mv.mvY(this.list[(i << 1) + 1]);
        }

        public void setMv(int i, int i2, int i3) {
            this.list[(i << 1) + i2] = i3;
        }

        public void setPair(int i, int i2, int i3) {
            int[] iArr = this.list;
            int i4 = i << 1;
            iArr[i4] = i2;
            iArr[i4 + 1] = i3;
        }
    }

    public static class MvList2D {
        private static final int NA = Mv.packMv(0, 0, -1);
        private int height;
        private int[] list;
        private int stride;
        private int width;

        public MvList2D(int i, int i2) {
            int i3 = i << 1;
            this.list = new int[i3 * i2];
            this.stride = i3;
            this.width = i;
            this.height = i2;
            clear();
        }

        public void clear() {
            int i = 0;
            while (true) {
                int[] iArr = this.list;
                if (i >= iArr.length) {
                    return;
                }
                int i2 = NA;
                iArr[i + 1] = i2;
                iArr[i] = i2;
                i += 2;
            }
        }

        public int getHeight() {
            return this.height;
        }

        public int getMv(int i, int i2, int i3) {
            return this.list[(i << 1) + (this.stride * i2) + i3];
        }

        public int getWidth() {
            return this.width;
        }

        public int mv0R(int i, int i2) {
            return Mv.mvRef(this.list[(i << 1) + (this.stride * i2)]);
        }

        public int mv0X(int i, int i2) {
            return Mv.mvX(this.list[(i << 1) + (this.stride * i2)]);
        }

        public int mv0Y(int i, int i2) {
            return Mv.mvY(this.list[(i << 1) + (this.stride * i2)]);
        }

        public int mv1R(int i, int i2) {
            return Mv.mvRef(this.list[(i << 1) + (this.stride * i2) + 1]);
        }

        public int mv1X(int i, int i2) {
            return Mv.mvX(this.list[(i << 1) + (this.stride * i2) + 1]);
        }

        public int mv1Y(int i, int i2) {
            return Mv.mvY(this.list[(i << 1) + (this.stride * i2) + 1]);
        }

        public void setMv(int i, int i2, int i3, int i4) {
            this.list[(i << 1) + (this.stride * i2) + i3] = i4;
        }
    }

    public static abstract class SliceHeaderTweaker {
        public List<PictureParameterSet> pps;
        public List<SeqParameterSet> sps;

        private void copyDataCABAC(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, BitReader bitReader, BitWriter bitWriter) {
            if (bitReader.curBit() != 0) {
                if ((1 << ((int) (8 - r0))) - 1 != bitReader.readNBit(8 - ((int) r0))) {
                    throw new RuntimeException("Invalid CABAC padding");
                }
            }
            if (bitWriter.curBit() != 0) {
                bitWriter.writeNBit(255, 8 - bitWriter.curBit());
            }
            bitWriter.flush();
            bitReader.stop();
            byteBuffer2.put(byteBuffer);
        }

        private void copyDataCAVLC(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, BitReader bitReader, BitWriter bitWriter) {
            int iCurBit = 8 - bitWriter.curBit();
            if (iCurBit != 0) {
                bitWriter.writeNBit(bitReader.readNBit(iCurBit), iCurBit);
            }
            bitWriter.flush();
            int iCurBit2 = bitReader.curBit();
            if (iCurBit2 == 0) {
                bitReader.stop();
                byteBuffer2.put(byteBuffer);
                return;
            }
            int i = 8 - iCurBit2;
            int nBit = bitReader.readNBit(i);
            bitReader.stop();
            while (byteBuffer.hasRemaining()) {
                int i2 = nBit << iCurBit2;
                nBit = byteBuffer.get() & ExifInterface.MARKER;
                byteBuffer2.put((byte) (i2 | (nBit >> i)));
            }
            byteBuffer2.put((byte) (nBit << iCurBit2));
        }

        private SliceHeader part2(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, ByteBuffer byteBuffer3, BitReader bitReader, SliceHeader sliceHeader) {
            BitWriter bitWriter = new BitWriter(byteBuffer2);
            SliceHeaderReader.readPart2(sliceHeader, nALUnit, seqParameterSet, pictureParameterSet, bitReader);
            tweak(sliceHeader);
            SliceHeaderWriter.write(sliceHeader, nALUnit.type == NALUnitType.IDR_SLICE, nALUnit.nal_ref_idc, bitWriter);
            if (pictureParameterSet.entropyCodingModeFlag) {
                copyDataCABAC(byteBuffer, byteBuffer2, bitReader, bitWriter);
            } else {
                copyDataCAVLC(byteBuffer, byteBuffer2, bitReader, bitWriter);
            }
            byteBuffer3.limit(byteBuffer2.position());
            H264Utils.escapeNALinplace(byteBuffer3);
            byteBuffer2.position(byteBuffer3.limit());
            return sliceHeader;
        }

        public SliceHeader run(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit) {
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            H264Utils.unescapeNAL(byteBuffer);
            BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
            SliceHeader part1 = SliceHeaderReader.readPart1(bitReaderCreateBitReader);
            PictureParameterSet pictureParameterSetFindPPS = H264Utils.findPPS(this.pps, part1.picParameterSetId);
            return part2(byteBuffer, byteBuffer2, nALUnit, H264Utils.findSPS(this.sps, pictureParameterSetFindPPS.picParameterSetId), pictureParameterSetFindPPS, byteBufferDuplicate, bitReaderCreateBitReader, part1);
        }

        public SliceHeader runSpsPps(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            H264Utils.unescapeNAL(byteBuffer);
            BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
            return part2(byteBuffer, byteBuffer2, nALUnit, seqParameterSet, pictureParameterSet, byteBufferDuplicate, bitReaderCreateBitReader, SliceHeaderReader.readPart1(bitReaderCreateBitReader));
        }

        public abstract void tweak(SliceHeader sliceHeader);
    }

    public static ByteBuffer avcCToAnnexB(AvcCBox avcCBox) {
        return saveCodecPrivate(avcCBox.getSpsList(), avcCBox.getPpsList());
    }

    public static AvcCBox createAvcC(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        seqParameterSet.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        escapeNALinplace(byteBufferAllocate);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(512);
        pictureParameterSet.write(byteBufferAllocate2);
        byteBufferAllocate2.flip();
        escapeNALinplace(byteBufferAllocate2);
        return AvcCBox.createAvcCBox(seqParameterSet.profileIdc, 0, seqParameterSet.levelIdc, i, Arrays.asList(byteBufferAllocate), Arrays.asList(byteBufferAllocate2));
    }

    public static AvcCBox createAvcCFromBytes(ByteBuffer byteBuffer) {
        return createAvcCFromPS(getRawSPS(byteBuffer.duplicate()), getRawPPS(byteBuffer.duplicate()), 4);
    }

    public static AvcCBox createAvcCFromList(List<SeqParameterSet> list, List<PictureParameterSet> list2, int i) {
        List<ByteBuffer> listSaveSPS = saveSPS(list);
        List<ByteBuffer> listSavePPS = savePPS(list2);
        SeqParameterSet seqParameterSet = list.get(0);
        return AvcCBox.createAvcCBox(seqParameterSet.profileIdc, 0, seqParameterSet.levelIdc, i, listSaveSPS, listSavePPS);
    }

    public static AvcCBox createAvcCFromPS(List<ByteBuffer> list, List<ByteBuffer> list2, int i) {
        SeqParameterSet sps = readSPS(NIOUtils.duplicate(list.get(0)));
        return AvcCBox.createAvcCBox(sps.profileIdc, 0, sps.levelIdc, i, list, list2);
    }

    public static SampleEntry createMOVSampleEntryFromAvcC(AvcCBox avcCBox) {
        SeqParameterSet seqParameterSet = SeqParameterSet.read(avcCBox.getSpsList().get(0).duplicate());
        int i = seqParameterSet.picWidthInMbsMinus1;
        SeqParameterSet.getPicHeightInMbs(seqParameterSet);
        VideoSampleEntry videoSampleEntry = VideoSampleEntry.videoSampleEntry("avc1", getPicSize(seqParameterSet), "JCodec");
        videoSampleEntry.add(avcCBox);
        return videoSampleEntry;
    }

    public static SampleEntry createMOVSampleEntryFromBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        return createMOVSampleEntryFromSpsPpsList(Arrays.asList(byteBuffer), Arrays.asList(byteBuffer2), i);
    }

    public static SampleEntry createMOVSampleEntryFromBytes(ByteBuffer byteBuffer) {
        return createMOVSampleEntryFromSpsPpsList(getRawSPS(byteBuffer.duplicate()), getRawPPS(byteBuffer.duplicate()), 4);
    }

    public static SampleEntry createMOVSampleEntryFromSpsPps(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(512);
        seqParameterSet.write(byteBufferAllocate);
        pictureParameterSet.write(byteBufferAllocate2);
        byteBufferAllocate.flip();
        byteBufferAllocate2.flip();
        return createMOVSampleEntryFromBuffer(byteBufferAllocate, byteBufferAllocate2, i);
    }

    public static SampleEntry createMOVSampleEntryFromSpsPpsList(List<ByteBuffer> list, List<ByteBuffer> list2, int i) {
        return createMOVSampleEntryFromAvcC(createAvcCFromPS(list, list2, i));
    }

    public static ByteBuffer decodeMOVPacket(ByteBuffer byteBuffer, AvcCBox avcCBox) {
        if (avcCBox.getNalLengthSize() != 4) {
            return joinNALUnits(splitMOVPacket(byteBuffer, avcCBox));
        }
        decodeMOVPacketInplace(byteBuffer, avcCBox);
        return byteBuffer;
    }

    public static void decodeMOVPacketInplace(ByteBuffer byteBuffer, AvcCBox avcCBox) {
        if (avcCBox.getNalLengthSize() != 4) {
            throw new IllegalArgumentException("Can only inplace decode AVC MOV packet with nal_length_size = 4.");
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBufferDuplicate.remaining() >= 4) {
            int i = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() - 4);
            byteBufferDuplicate.putInt(1);
            byteBufferDuplicate.position(byteBufferDuplicate.position() + i);
        }
    }

    public static void dumpFrame(FileChannelWrapper fileChannelWrapper, SeqParameterSet[] seqParameterSetArr, PictureParameterSet[] pictureParameterSetArr, List<ByteBuffer> list) throws IOException {
        for (SeqParameterSet seqParameterSet : seqParameterSetArr) {
            NIOUtils.writeInt(fileChannelWrapper, 1);
            NIOUtils.writeByte(fileChannelWrapper, (byte) 103);
            fileChannelWrapper.write(writeSPS(seqParameterSet, 128));
        }
        for (PictureParameterSet pictureParameterSet : pictureParameterSetArr) {
            NIOUtils.writeInt(fileChannelWrapper, 1);
            NIOUtils.writeByte(fileChannelWrapper, (byte) 104);
            fileChannelWrapper.write(writePPS(pictureParameterSet, 256));
        }
        for (ByteBuffer byteBuffer : list) {
            NIOUtils.writeInt(fileChannelWrapper, 1);
            fileChannelWrapper.write(byteBuffer.duplicate());
        }
    }

    public static ByteBuffer encodeMOVPacket(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        int iRemaining = 0;
        while (true) {
            ByteBuffer byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate);
            if (byteBufferNextNALUnit == null) {
                break;
            }
            arrayList.add(byteBufferNextNALUnit);
            iRemaining += byteBufferNextNALUnit.remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((arrayList.size() * 4) + iRemaining);
        for (ByteBuffer byteBuffer2 : arrayList) {
            byteBufferAllocate.putInt(byteBuffer2.remaining());
            byteBufferAllocate.put(byteBuffer2);
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static void encodeMOVPacketInplace(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        int iPosition = byteBufferDuplicate2.position();
        while (true) {
            ByteBuffer byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate);
            if (byteBufferNextNALUnit == null) {
                return;
            }
            byteBufferDuplicate2.position(iPosition);
            byteBufferDuplicate2.putInt(byteBufferNextNALUnit.remaining());
            iPosition += byteBufferNextNALUnit.remaining() + 4;
        }
    }

    public static final void escapeNAL(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte b = byteBuffer.get();
        byte b2 = byteBuffer.get();
        byteBuffer2.put(b);
        byteBuffer2.put(b2);
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            if (b == 0 && b2 == 0 && (b3 & ExifInterface.MARKER) <= 3) {
                byteBuffer2.put((byte) 3);
                b = 3;
            } else {
                b = b2;
            }
            byteBuffer2.put(b3);
            b2 = b3;
        }
    }

    public static final void escapeNALinplace(ByteBuffer byteBuffer) {
        int[] iArrSearchEscapeLocations = searchEscapeLocations(byteBuffer);
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.limit() + iArrSearchEscapeLocations.length);
        int iLimit2 = byteBuffer.limit() - 1;
        int i = iLimit - 1;
        int length = iArrSearchEscapeLocations.length - 1;
        while (iLimit2 >= byteBuffer.position()) {
            byteBuffer.put(iLimit2, byteBuffer.get(i));
            if (length >= 0 && iArrSearchEscapeLocations[length] == i) {
                iLimit2--;
                byteBuffer.put(iLimit2, (byte) 3);
                length--;
            }
            iLimit2--;
            i--;
        }
    }

    public static PictureParameterSet findPPS(List<PictureParameterSet> list, int i) {
        for (PictureParameterSet pictureParameterSet : list) {
            if (pictureParameterSet.picParameterSetId == i) {
                return pictureParameterSet;
            }
        }
        return null;
    }

    public static SeqParameterSet findSPS(List<SeqParameterSet> list, int i) {
        for (SeqParameterSet seqParameterSet : list) {
            if (seqParameterSet.seqParameterSetId == i) {
                return seqParameterSet;
            }
        }
        return null;
    }

    public static ByteBuffer getAvcCData(AvcCBox avcCBox) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2048);
        avcCBox.doWrite(byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static Size getPicSize(SeqParameterSet seqParameterSet) {
        int i = (seqParameterSet.picWidthInMbsMinus1 + 1) << 4;
        int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(seqParameterSet) << 4;
        if (seqParameterSet.frameCroppingFlag) {
            int i2 = seqParameterSet.frameCropLeftOffset + seqParameterSet.frameCropRightOffset;
            ColorSpace colorSpace = seqParameterSet.chromaFormatIdc;
            i -= i2 << colorSpace.compWidth[1];
            picHeightInMbs -= (seqParameterSet.frameCropTopOffset + seqParameterSet.frameCropBottomOffset) << colorSpace.compHeight[1];
        }
        return new Size(i, picHeightInMbs);
    }

    public static List<ByteBuffer> getRawNALUnitsOfType(ByteBuffer byteBuffer, NALUnitType nALUnitType) {
        ArrayList arrayList = new ArrayList();
        for (ByteBuffer byteBuffer2 : splitFrame(byteBuffer.duplicate())) {
            if (NALUnit.read(byteBuffer2).type == nALUnitType) {
                arrayList.add(byteBuffer2);
            }
        }
        return arrayList;
    }

    public static List<ByteBuffer> getRawPPS(ByteBuffer byteBuffer) {
        return getRawNALUnitsOfType(byteBuffer, NALUnitType.PPS);
    }

    public static List<ByteBuffer> getRawSPS(ByteBuffer byteBuffer) {
        return getRawNALUnitsOfType(byteBuffer, NALUnitType.SPS);
    }

    public static final ByteBuffer gotoNALUnit(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.order(ByteOrder.BIG_ENDIAN);
        int i = -1;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            i = (i << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            if ((16777215 & i) == 1) {
                byteBuffer.position(byteBuffer.position() - (i == 1 ? 4 : 3));
                byteBufferSlice.limit(byteBuffer.position() - iPosition);
            }
        }
        return byteBufferSlice;
    }

    public static final ByteBuffer gotoNALUnitWithArray(ByteBuffer byteBuffer) {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int iPosition = byteBuffer.position();
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.order(ByteOrder.BIG_ENDIAN);
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
        int iLimit = byteBuffer.limit() + byteBuffer.arrayOffset();
        int i2 = iArrayOffset;
        while (i2 < iLimit) {
            byte b = bArrArray[i2];
            int i3 = 3;
            if ((b & 254) == 0) {
                while (b == 0) {
                    i2++;
                    if (i2 >= iLimit) {
                        break;
                    }
                    b = bArrArray[i2];
                }
                if (b == 1 && (i = i2 - iArrayOffset) >= 2 && bArrArray[i2 - 1] == 0 && bArrArray[i2 - 2] == 0) {
                    if (i >= 3 && bArrArray[i2 - 3] == 0) {
                        i3 = 4;
                    }
                    byteBuffer.position(((i2 + 1) - byteBuffer.arrayOffset()) - i3);
                    byteBufferSlice.limit(byteBuffer.position() - iPosition);
                    return byteBufferSlice;
                }
            }
            i2 += 3;
        }
        byteBuffer.position(byteBuffer.limit());
        return byteBufferSlice;
    }

    public static boolean iFrame(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferNextNALUnit;
        NALUnitType nALUnitType;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        do {
            byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate);
            if (byteBufferNextNALUnit == null) {
                return false;
            }
            nALUnitType = NALUnit.read(byteBufferNextNALUnit).type;
            if (nALUnitType == NALUnitType.IDR_SLICE) {
                break;
            }
        } while (nALUnitType != NALUnitType.NON_IDR_SLICE);
        unescapeNAL(byteBufferNextNALUnit);
        return SliceHeaderReader.readPart1(BitReader.createBitReader(byteBufferNextNALUnit)).sliceType == SliceType.I;
    }

    public static boolean idrSlice(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            if (NALUnit.read(it.next().duplicate()).type == NALUnitType.IDR_SLICE) {
                return true;
            }
        }
        return false;
    }

    public static boolean isByteBufferIDRSlice(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferNextNALUnit;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        do {
            byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate);
            if (byteBufferNextNALUnit == null) {
                return false;
            }
        } while (NALUnit.read(byteBufferNextNALUnit).type != NALUnitType.IDR_SLICE);
        return true;
    }

    public static ByteBuffer joinNALUnits(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        int iRemaining = 0;
        while (it.hasNext()) {
            iRemaining += it.next().remaining() + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        joinNALUnitsToBuffer(list, byteBufferAllocate);
        return byteBufferAllocate;
    }

    public static void joinNALUnitsToBuffer(List<ByteBuffer> list, ByteBuffer byteBuffer) {
        for (ByteBuffer byteBuffer2 : list) {
            byteBuffer.putInt(1);
            byteBuffer.put(byteBuffer2.duplicate());
        }
    }

    public static ByteBuffer nextNALUnit(ByteBuffer byteBuffer) {
        skipToNALUnit(byteBuffer);
        return byteBuffer.hasArray() ? gotoNALUnitWithArray(byteBuffer) : gotoNALUnit(byteBuffer);
    }

    public static AvcCBox parseAVCC(VideoSampleEntry videoSampleEntry) {
        Box boxFindFirst = NodeBox.findFirst(videoSampleEntry, Box.class, "avcC");
        return boxFindFirst instanceof AvcCBox ? (AvcCBox) boxFindFirst : parseAVCCFromBuffer(((Box.LeafBox) boxFindFirst).getData().duplicate());
    }

    public static AvcCBox parseAVCCFromBuffer(ByteBuffer byteBuffer) {
        return AvcCBox.parseAvcCBox(byteBuffer);
    }

    private static void putNAL(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer2.remaining() * 2);
        escapeNAL(byteBuffer2, byteBufferAllocate);
        byteBufferAllocate.flip();
        byteBuffer.putInt(1);
        byteBuffer.put((byte) i);
        byteBuffer.put(byteBufferAllocate);
    }

    private static int readLen(ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            return byteBuffer.get() & ExifInterface.MARKER;
        }
        if (i == 2) {
            return byteBuffer.getShort() & 65535;
        }
        if (i == 3) {
            return (byteBuffer.get() & ExifInterface.MARKER) | ((byteBuffer.getShort() & 65535) << 8);
        }
        if (i == 4) {
            return byteBuffer.getInt();
        }
        throw new IllegalArgumentException("NAL Unit length size can not be " + i);
    }

    public static PictureParameterSet readPPS(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = NIOUtils.duplicate(byteBuffer);
        unescapeNAL(byteBufferDuplicate);
        return PictureParameterSet.read(byteBufferDuplicate);
    }

    public static List<PictureParameterSet> readPPSFromBufferList(List<ByteBuffer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(readPPS(NIOUtils.duplicate(it.next())));
        }
        return arrayList;
    }

    public static SeqParameterSet readSPS(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = NIOUtils.duplicate(byteBuffer);
        unescapeNAL(byteBufferDuplicate);
        return SeqParameterSet.read(byteBufferDuplicate);
    }

    public static List<SeqParameterSet> readSPSFromBufferList(List<ByteBuffer> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(readSPS(NIOUtils.duplicate(it.next())));
        }
        return arrayList;
    }

    public static ByteBuffer saveCodecPrivate(List<ByteBuffer> list, List<ByteBuffer> list2) {
        Iterator<ByteBuffer> it = list.iterator();
        int iRemaining = 0;
        while (it.hasNext()) {
            iRemaining += it.next().remaining() + 5;
        }
        Iterator<ByteBuffer> it2 = list2.iterator();
        while (it2.hasNext()) {
            iRemaining += it2.next().remaining() + 5;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        for (ByteBuffer byteBuffer : list) {
            byteBufferAllocate.putInt(1);
            byteBufferAllocate.put((byte) 103);
            byteBufferAllocate.put(byteBuffer.duplicate());
        }
        for (ByteBuffer byteBuffer2 : list2) {
            byteBufferAllocate.putInt(1);
            byteBufferAllocate.put((byte) 104);
            byteBufferAllocate.put(byteBuffer2.duplicate());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static List<ByteBuffer> savePPS(List<PictureParameterSet> list) {
        ArrayList arrayList = new ArrayList();
        for (PictureParameterSet pictureParameterSet : list) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
            pictureParameterSet.write(byteBufferAllocate);
            byteBufferAllocate.flip();
            escapeNALinplace(byteBufferAllocate);
            arrayList.add(byteBufferAllocate);
        }
        return arrayList;
    }

    public static void saveRawFrame(ByteBuffer byteBuffer, AvcCBox avcCBox, File file) throws IOException {
        FileChannelWrapper fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
        saveStreamParams(avcCBox, fileChannelWrapperWritableChannel);
        fileChannelWrapperWritableChannel.write(byteBuffer.duplicate());
        fileChannelWrapperWritableChannel.close();
    }

    public static List<ByteBuffer> saveSPS(List<SeqParameterSet> list) {
        ArrayList arrayList = new ArrayList();
        for (SeqParameterSet seqParameterSet : list) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
            seqParameterSet.write(byteBufferAllocate);
            byteBufferAllocate.flip();
            escapeNALinplace(byteBufferAllocate);
            arrayList.add(byteBufferAllocate);
        }
        return arrayList;
    }

    public static void saveStreamParams(AvcCBox avcCBox, SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        for (ByteBuffer byteBuffer : avcCBox.getSpsList()) {
            seekableByteChannel.write(ByteBuffer.wrap(new byte[]{0, 0, 0, 1, 103}));
            escapeNAL(byteBuffer.duplicate(), byteBufferAllocate);
            byteBufferAllocate.flip();
            seekableByteChannel.write(byteBufferAllocate);
            byteBufferAllocate.clear();
        }
        for (ByteBuffer byteBuffer2 : avcCBox.getPpsList()) {
            seekableByteChannel.write(ByteBuffer.wrap(new byte[]{0, 0, 0, 1, 104}));
            escapeNAL(byteBuffer2.duplicate(), byteBufferAllocate);
            byteBufferAllocate.flip();
            seekableByteChannel.write(byteBufferAllocate);
            byteBufferAllocate.clear();
        }
    }

    private static int[] searchEscapeLocations(ByteBuffer byteBuffer) {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int i = byteBufferDuplicate.getShort();
        while (byteBufferDuplicate.hasRemaining()) {
            byte b = byteBufferDuplicate.get();
            if (i == 0 && (b & (-4)) == 0) {
                intArrayListCreateIntArrayList.add(byteBufferDuplicate.position() - 1);
                i = 3;
            }
            i = ((i << 8) & 65535) | (b & ExifInterface.MARKER);
        }
        return intArrayListCreateIntArrayList.toArray();
    }

    public static final void skipToNALUnit(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int i = -1;
            while (byteBuffer.hasRemaining()) {
                i = (i << 8) | (byteBuffer.get() & ExifInterface.MARKER);
                if ((16777215 & i) == 1) {
                    byteBuffer.position(byteBuffer.position());
                    return;
                }
            }
        }
    }

    public static List<ByteBuffer> splitFrame(ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteBuffer byteBufferNextNALUnit = nextNALUnit(byteBuffer);
            if (byteBufferNextNALUnit == null) {
                return arrayList;
            }
            arrayList.add(byteBufferNextNALUnit);
        }
    }

    public static List<ByteBuffer> splitMOVPacket(ByteBuffer byteBuffer, AvcCBox avcCBox) {
        int len;
        ArrayList arrayList = new ArrayList();
        int nalLengthSize = avcCBox.getNalLengthSize();
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBufferDuplicate.remaining() >= nalLengthSize && (len = readLen(byteBufferDuplicate, nalLengthSize)) != 0) {
            arrayList.add(NIOUtils.read(byteBufferDuplicate, len));
        }
        return arrayList;
    }

    public static void toNAL(ByteBuffer byteBuffer, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(512);
        seqParameterSet.write(byteBufferAllocate);
        pictureParameterSet.write(byteBufferAllocate2);
        byteBufferAllocate.flip();
        byteBufferAllocate2.flip();
        putNAL(byteBuffer, byteBufferAllocate, 103);
        putNAL(byteBuffer, byteBufferAllocate2, 104);
    }

    public static void toNALList(ByteBuffer byteBuffer, List<ByteBuffer> list, List<ByteBuffer> list2) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            putNAL(byteBuffer, it.next(), 103);
        }
        Iterator<ByteBuffer> it2 = list2.iterator();
        while (it2.hasNext()) {
            putNAL(byteBuffer, it2.next(), 104);
        }
    }

    public static final void unescapeNAL(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 2) {
            return;
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        byte b = byteBufferDuplicate.get();
        byteBufferDuplicate2.put(b);
        byte b2 = byteBufferDuplicate.get();
        byteBufferDuplicate2.put(b2);
        while (byteBufferDuplicate.hasRemaining()) {
            byte b3 = byteBufferDuplicate.get();
            if (b != 0 || b2 != 0 || b3 != 3) {
                byteBufferDuplicate2.put(b3);
            }
            b = b2;
            b2 = b3;
        }
        byteBuffer.limit(byteBufferDuplicate2.position());
    }

    public static void wipePS(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, List<ByteBuffer> list, List<ByteBuffer> list2) {
        ByteBuffer byteBufferNextNALUnit;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBufferDuplicate.hasRemaining() && (byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate)) != null) {
            NALUnitType nALUnitType = NALUnit.read(byteBufferNextNALUnit.duplicate()).type;
            if (nALUnitType == NALUnitType.PPS) {
                if (list2 != null) {
                    list2.add(NIOUtils.duplicate(byteBufferNextNALUnit));
                }
            } else if (nALUnitType == NALUnitType.SPS) {
                if (list != null) {
                    list.add(NIOUtils.duplicate(byteBufferNextNALUnit));
                }
            } else if (byteBuffer2 != null) {
                byteBuffer2.putInt(1);
                byteBuffer2.put(byteBufferNextNALUnit);
            }
        }
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public static void wipePSinplace(ByteBuffer byteBuffer, Collection<ByteBuffer> collection, Collection<ByteBuffer> collection2) {
        ByteBuffer byteBufferNextNALUnit;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBufferDuplicate.hasRemaining() && (byteBufferNextNALUnit = nextNALUnit(byteBufferDuplicate)) != null) {
            NALUnitType nALUnitType = NALUnit.read(byteBufferNextNALUnit).type;
            if (nALUnitType == NALUnitType.PPS) {
                if (collection2 != null) {
                    collection2.add(NIOUtils.duplicate(byteBufferNextNALUnit));
                }
                byteBuffer.position(byteBufferDuplicate.position());
            } else if (nALUnitType == NALUnitType.SPS) {
                if (collection != null) {
                    collection.add(NIOUtils.duplicate(byteBufferNextNALUnit));
                }
                byteBuffer.position(byteBufferDuplicate.position());
            } else if (nALUnitType == NALUnitType.IDR_SLICE || nALUnitType == NALUnitType.NON_IDR_SLICE) {
                return;
            }
        }
    }

    public static ByteBuffer writePPS(PictureParameterSet pictureParameterSet, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i + 8);
        pictureParameterSet.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        escapeNALinplace(byteBufferAllocate);
        return byteBufferAllocate;
    }

    public static List<ByteBuffer> writePPSList(List<PictureParameterSet> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<PictureParameterSet> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(writePPS(it.next(), 64));
        }
        return arrayList;
    }

    public static ByteBuffer writeSPS(SeqParameterSet seqParameterSet, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i + 8);
        seqParameterSet.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        escapeNALinplace(byteBufferAllocate);
        return byteBufferAllocate;
    }

    public static List<ByteBuffer> writeSPSList(List<SeqParameterSet> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<SeqParameterSet> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(writeSPS(it.next(), 256));
        }
        return arrayList;
    }
}
