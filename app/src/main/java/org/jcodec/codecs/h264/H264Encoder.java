package org.jcodec.codecs.h264;

import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.encode.DumbRateControl;
import org.jcodec.codecs.h264.encode.EncodedMB;
import org.jcodec.codecs.h264.encode.MBEncoderHelper;
import org.jcodec.codecs.h264.encode.MBEncoderI16x16;
import org.jcodec.codecs.h264.encode.MBEncoderP16x16;
import org.jcodec.codecs.h264.encode.MotionEstimator;
import org.jcodec.codecs.h264.encode.RateControl;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.codecs.h264.io.write.SliceHeaderWriter;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class H264Encoder extends VideoEncoder {
    private static final int KEY_INTERVAL_DEFAULT = 25;
    private static final int MOTION_SEARCH_RANGE_DEFAULT = 16;
    private CAVLC[] cavlc;
    private int frameNumber;
    private byte[][] leftRow;
    private int maxFrameNumber;
    private int maxPOC;
    private MBEncoderI16x16 mbEncoderI16x16;
    private MBEncoderP16x16 mbEncoderP16x16;
    private EncodedMB outMB;
    private Picture picOut;
    private PictureParameterSet pps;
    private RateControl rc;
    private Picture ref;
    private SeqParameterSet sps;
    private EncodedMB[] topEncoded;
    private byte[][] topLine;
    private int keyInterval = 25;
    private int motionSearchRange = 16;

    public H264Encoder(RateControl rateControl) {
        this.rc = rateControl;
    }

    private void addToReference(int i, int i2) {
        if (i2 > 0) {
            MBEncoderHelper.putBlkPic(this.picOut, this.topEncoded[i].getPixels(), i << 4, (i2 - 1) << 4);
        }
        EncodedMB[] encodedMBArr = this.topEncoded;
        EncodedMB encodedMB = encodedMBArr[i];
        encodedMBArr[i] = this.outMB;
        this.outMB = encodedMB;
    }

    private void collectPredictors(Picture picture, int i) {
        System.arraycopy(picture.getPlaneData(0), 240, this.topLine[0], i << 4, 16);
        int i2 = i << 3;
        System.arraycopy(picture.getPlaneData(1), 56, this.topLine[1], i2, 8);
        System.arraycopy(picture.getPlaneData(2), 56, this.topLine[2], i2, 8);
        copyCol(picture.getPlaneData(0), 15, 16, this.leftRow[0]);
        copyCol(picture.getPlaneData(1), 7, 8, this.leftRow[1]);
        copyCol(picture.getPlaneData(2), 7, 8, this.leftRow[2]);
    }

    private void copyCol(byte[] bArr, int i, int i2, byte[] bArr2) {
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            bArr2[i3] = bArr[i];
            i += i2;
        }
    }

    public static H264Encoder createH264Encoder() {
        return new H264Encoder(new DumbRateControl());
    }

    private void encodeMacroblock(MBType mBType, Picture picture, int i, int i2, BitWriter bitWriter, int i3, int i4) {
        if (mBType == MBType.I_16x16) {
            this.mbEncoderI16x16.save();
            this.mbEncoderI16x16.encodeMacroblock(picture, i, i2, bitWriter, this.outMB, i > 0 ? this.topEncoded[i - 1] : null, i2 > 0 ? this.topEncoded[i] : null, i3 + i4, i4);
        } else if (mBType == MBType.P_16x16) {
            this.mbEncoderP16x16.save();
            this.mbEncoderP16x16.encodeMacroblock(picture, i, i2, bitWriter, this.outMB, i > 0 ? this.topEncoded[i - 1] : null, i2 > 0 ? this.topEncoded[i] : null, i3 + i4, i4);
        } else {
            throw new RuntimeException("Macroblock of type " + mBType + " is not supported.");
        }
    }

    private void encodeSlice(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, Picture picture, ByteBuffer byteBuffer, boolean z, int i, SliceType sliceType, int i2) {
        boolean z2;
        BitWriter bitWriterFork;
        int i3;
        int i4;
        int i5 = 0;
        if (!z || sliceType == SliceType.I) {
            z2 = z;
        } else {
            Logger.warn("Illegal value of idr = true when sliceType != I");
            z2 = false;
        }
        int i6 = 1;
        this.cavlc = new CAVLC[]{new CAVLC(seqParameterSet, pictureParameterSet, 2, 2), new CAVLC(seqParameterSet, pictureParameterSet, 1, 1), new CAVLC(seqParameterSet, pictureParameterSet, 1, 1)};
        this.mbEncoderI16x16 = new MBEncoderI16x16(this.cavlc, this.leftRow, this.topLine);
        this.mbEncoderP16x16 = new MBEncoderP16x16(seqParameterSet, this.ref, this.cavlc, new MotionEstimator(this.motionSearchRange));
        byteBuffer.putInt(1);
        new NALUnit(z2 ? NALUnitType.IDR_SLICE : NALUnitType.NON_IDR_SLICE, 3).write(byteBuffer);
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.sliceType = sliceType;
        if (z2) {
            sliceHeader.refPicMarkingIDR = new RefPicMarkingIDR(false, false);
        }
        sliceHeader.pps = pictureParameterSet;
        sliceHeader.sps = seqParameterSet;
        sliceHeader.picOrderCntLsb = (i << 1) % this.maxPOC;
        sliceHeader.frameNum = i % this.maxFrameNumber;
        sliceHeader.sliceQpDelta = i2 - (pictureParameterSet.picInitQpMinus26 + 26);
        BitWriter bitWriter = new BitWriter(ByteBuffer.allocate(picture.getWidth() * picture.getHeight()));
        SliceHeaderWriter.write(sliceHeader, z2, 2, bitWriter);
        int i7 = i2;
        int i8 = 0;
        while (i8 < seqParameterSet.picHeightInMapUnitsMinus1 + i6) {
            int i9 = i7;
            BitWriter bitWriter2 = bitWriter;
            int i10 = i5;
            while (i10 < seqParameterSet.picWidthInMbsMinus1 + i6) {
                SliceType sliceType2 = SliceType.P;
                if (sliceType == sliceType2) {
                    CAVLCWriter.writeUE(bitWriter2, i5);
                }
                MBType mBTypeSelectMBType = selectMBType(sliceType);
                if (mBTypeSelectMBType == MBType.I_16x16) {
                    CAVLCWriter.writeUE(bitWriter2, (sliceType == sliceType2 ? 5 : i5) + mBTypeSelectMBType.code() + ((this.mbEncoderI16x16.getCbpLuma(picture, i10, i8) / 15) * 12) + (this.mbEncoderI16x16.getCbpChroma(picture, i10, i8) * 4) + this.mbEncoderI16x16.getPredMode(picture, i10, i8));
                } else {
                    CAVLCWriter.writeUE(bitWriter2, mBTypeSelectMBType.code());
                }
                int iInitialQpDelta = this.rc.initialQpDelta();
                int i11 = i5;
                while (true) {
                    bitWriterFork = bitWriter2.fork();
                    i3 = i11 + iInitialQpDelta;
                    MBType mBType = mBTypeSelectMBType;
                    i4 = i10;
                    BitWriter bitWriter3 = bitWriter2;
                    encodeMacroblock(mBTypeSelectMBType, picture, i10, i8, bitWriterFork, i9, i3);
                    iInitialQpDelta = this.rc.accept(bitWriterFork.position() - bitWriter3.position());
                    if (iInitialQpDelta != 0) {
                        restoreMacroblock(mBType);
                    }
                    if (iInitialQpDelta == 0) {
                        break;
                    }
                    mBTypeSelectMBType = mBType;
                    i10 = i4;
                    i11 = i3;
                    bitWriter2 = bitWriter3;
                }
                i9 += i3;
                collectPredictors(this.outMB.getPixels(), i4);
                addToReference(i4, i8);
                i10 = i4 + 1;
                bitWriter2 = bitWriterFork;
                i5 = 0;
                i6 = 1;
            }
            i8++;
            i7 = i9;
            bitWriter = bitWriter2;
            i5 = 0;
            i6 = 1;
        }
        bitWriter.write1Bit(i6);
        bitWriter.flush();
        ByteBuffer buffer = bitWriter.getBuffer();
        buffer.flip();
        H264Utils.escapeNAL(buffer, byteBuffer);
    }

    private void putLastMBLine() {
        SeqParameterSet seqParameterSet = this.sps;
        int i = seqParameterSet.picWidthInMbsMinus1 + 1;
        int i2 = seqParameterSet.picHeightInMapUnitsMinus1 + 1;
        for (int i3 = 0; i3 < i; i3++) {
            MBEncoderHelper.putBlkPic(this.picOut, this.topEncoded[i3].getPixels(), i3 << 4, (i2 - 1) << 4);
        }
    }

    private void restoreMacroblock(MBType mBType) {
        if (mBType == MBType.I_16x16) {
            this.mbEncoderI16x16.restore();
            return;
        }
        if (mBType == MBType.P_16x16) {
            this.mbEncoderP16x16.restore();
            return;
        }
        throw new RuntimeException("Macroblock of type " + mBType + " is not supported.");
    }

    private MBType selectMBType(SliceType sliceType) {
        if (sliceType == SliceType.I) {
            return MBType.I_16x16;
        }
        if (sliceType == SliceType.P) {
            return MBType.P_16x16;
        }
        throw new RuntimeException("Unsupported slice type");
    }

    private void writePPS(ByteBuffer byteBuffer, PictureParameterSet pictureParameterSet) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        pictureParameterSet.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        H264Utils.escapeNAL(byteBufferAllocate, byteBuffer);
    }

    private void writeSPS(ByteBuffer byteBuffer, SeqParameterSet seqParameterSet) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1024);
        seqParameterSet.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        H264Utils.escapeNAL(byteBufferAllocate, byteBuffer);
    }

    public ByteBuffer doEncodeFrame(Picture picture, ByteBuffer byteBuffer, boolean z, int i, SliceType sliceType) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int iMin = Math.min(byteBufferDuplicate.remaining(), picture.getWidth() * picture.getHeight());
        int iStartPicture = this.rc.startPicture(picture.getSize(), iMin - (iMin >>> 6), sliceType);
        if (z) {
            this.sps = initSPS(new Size(picture.getCroppedWidth(), picture.getCroppedHeight()));
            this.pps = initPPS();
            SeqParameterSet seqParameterSet = this.sps;
            this.maxPOC = 1 << (seqParameterSet.log2MaxPicOrderCntLsbMinus4 + 4);
            this.maxFrameNumber = 1 << (seqParameterSet.log2MaxFrameNumMinus4 + 4);
        }
        if (z) {
            byteBufferDuplicate.putInt(1);
            new NALUnit(NALUnitType.SPS, 3).write(byteBufferDuplicate);
            writeSPS(byteBufferDuplicate, this.sps);
            byteBufferDuplicate.putInt(1);
            new NALUnit(NALUnitType.PPS, 3).write(byteBufferDuplicate);
            writePPS(byteBufferDuplicate, this.pps);
        }
        SeqParameterSet seqParameterSet2 = this.sps;
        int i2 = seqParameterSet2.picWidthInMbsMinus1 + 1;
        int i3 = seqParameterSet2.picHeightInMapUnitsMinus1 + 1;
        this.leftRow = new byte[][]{new byte[16], new byte[8], new byte[8]};
        int i4 = i2 << 4;
        int i5 = i2 << 3;
        this.topLine = new byte[][]{new byte[i4], new byte[i5], new byte[i5]};
        this.picOut = Picture.create(i4, i3 << 4, ColorSpace.YUV420J);
        this.outMB = new EncodedMB();
        this.topEncoded = new EncodedMB[i2];
        for (int i6 = 0; i6 < i2; i6++) {
            this.topEncoded[i6] = new EncodedMB();
        }
        encodeSlice(this.sps, this.pps, picture, byteBufferDuplicate, z, i, sliceType, iStartPicture);
        putLastMBLine();
        this.ref = this.picOut;
        byteBufferDuplicate.flip();
        return byteBufferDuplicate;
    }

    @Override // org.jcodec.common.VideoEncoder
    public VideoEncoder.EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        if (picture.getColor() != ColorSpace.YUV420J) {
            throw new IllegalArgumentException("Input picture color is not supported: " + picture.getColor());
        }
        if (this.frameNumber >= this.keyInterval) {
            this.frameNumber = 0;
        }
        int i = this.frameNumber;
        SliceType sliceType = i == 0 ? SliceType.I : SliceType.P;
        boolean z = i == 0;
        this.frameNumber = i + 1;
        return new VideoEncoder.EncodedFrame(doEncodeFrame(picture, byteBuffer, z, i, sliceType), z);
    }

    public ByteBuffer encodeIDRFrame(Picture picture, ByteBuffer byteBuffer) {
        this.frameNumber = 0;
        return doEncodeFrame(picture, byteBuffer, true, 0, SliceType.I);
    }

    public ByteBuffer encodePFrame(Picture picture, ByteBuffer byteBuffer) {
        int i = this.frameNumber + 1;
        this.frameNumber = i;
        return doEncodeFrame(picture, byteBuffer, true, i, SliceType.P);
    }

    @Override // org.jcodec.common.VideoEncoder
    public int estimateBufferSize(Picture picture) {
        return Math.max(65536, (picture.getWidth() * picture.getHeight()) / 2);
    }

    public int getKeyInterval() {
        return this.keyInterval;
    }

    public int getMotionSearchRange() {
        return this.motionSearchRange;
    }

    @Override // org.jcodec.common.VideoEncoder
    public ColorSpace[] getSupportedColorSpaces() {
        return new ColorSpace[]{ColorSpace.YUV420J};
    }

    public PictureParameterSet initPPS() {
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.picInitQpMinus26 = 0;
        return pictureParameterSet;
    }

    public SeqParameterSet initSPS(Size size) {
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.picWidthInMbsMinus1 = ((size.getWidth() + 15) >> 4) - 1;
        seqParameterSet.picHeightInMapUnitsMinus1 = ((size.getHeight() + 15) >> 4) - 1;
        seqParameterSet.chromaFormatIdc = ColorSpace.YUV420J;
        seqParameterSet.profileIdc = 66;
        seqParameterSet.levelIdc = 40;
        seqParameterSet.numRefFrames = 1;
        seqParameterSet.frameMbsOnlyFlag = true;
        seqParameterSet.log2MaxFrameNumMinus4 = Math.max(0, MathUtil.log2(this.keyInterval) - 3);
        int i = (seqParameterSet.picWidthInMbsMinus1 + 1) << 4;
        int i2 = (seqParameterSet.picHeightInMapUnitsMinus1 + 1) << 4;
        seqParameterSet.frameCroppingFlag = (i == size.getWidth() && i2 == size.getHeight()) ? false : true;
        seqParameterSet.frameCropRightOffset = ((i - size.getWidth()) + 1) >> 1;
        seqParameterSet.frameCropBottomOffset = ((i2 - size.getHeight()) + 1) >> 1;
        return seqParameterSet;
    }

    public void setKeyInterval(int i) {
        this.keyInterval = i;
    }

    public void setMotionSearchRange(int i) {
        this.motionSearchRange = i;
    }
}
