package org.jcodec.codecs.vpx;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.VideoEncoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class VP8Encoder extends VideoEncoder {
    private VPXBitstream bitstream;
    private ByteBuffer dataBuffer;
    private ByteBuffer headerBuffer;
    private byte[][] leftRow;
    private VPXQuantizer quantizer;
    private RateControl rc;
    private int[] tmp = new int[16];
    private byte[][] topLine;

    public VP8Encoder(RateControl rateControl) {
        this.rc = rateControl;
    }

    private int[] calcSegmentProbs(int[] iArr) {
        int[] iArr2 = new int[3];
        for (int i : iArr) {
            if (i == 0) {
                iArr2[0] = iArr2[0] + 1;
                iArr2[1] = iArr2[1] + 1;
            } else if (i == 1) {
                iArr2[0] = iArr2[0] + 1;
            } else if (i == 2) {
                iArr2[2] = iArr2[2] + 1;
            }
        }
        for (int i2 = 0; i2 < 3; i2++) {
            iArr2[i2] = MathUtil.clip((iArr2[i2] << 8) / iArr.length, 1, 255);
        }
        return iArr2;
    }

    private void chroma(Picture picture, int i, int i2, VPXBooleanEncoder vPXBooleanEncoder, int i3, Picture picture2) {
        int i4 = i << 3;
        int i5 = i2 << 3;
        byte bChromaPredBlk = chromaPredBlk(1, i4, i5);
        byte bChromaPredBlk2 = chromaPredBlk(2, i4, i5);
        int[][] iArrTransformChroma = transformChroma(picture, 1, i3, i4, i5, picture2, bChromaPredBlk);
        int[][] iArrTransformChroma2 = transformChroma(picture, 2, i3, i4, i5, picture2, bChromaPredBlk2);
        writeChroma(1, i, i2, vPXBooleanEncoder, iArrTransformChroma, i3);
        writeChroma(2, i, i2, vPXBooleanEncoder, iArrTransformChroma2, i3);
        restorePlaneChroma(iArrTransformChroma, i3);
        putChroma(picture2.getData()[1], 1, i4, i5, iArrTransformChroma, bChromaPredBlk);
        restorePlaneChroma(iArrTransformChroma2, i3);
        putChroma(picture2.getData()[2], 2, i4, i5, iArrTransformChroma2, bChromaPredBlk2);
    }

    private byte chromaPredBlk(int i, int i2, int i3) {
        int i4 = i3 & 7;
        if (i2 != 0 && i3 != 0) {
            return chromaPredTwo(this.leftRow[i], this.topLine[i], i4, i2);
        }
        if (i2 != 0) {
            return chromaPredOne(this.leftRow[i], i4);
        }
        if (i3 != 0) {
            return chromaPredOne(this.topLine[i], i2);
        }
        return (byte) 0;
    }

    private final byte chromaPredOne(byte[] bArr, int i) {
        return (byte) (((((((((bArr[i] + bArr[i + 1]) + bArr[i + 2]) + bArr[i + 3]) + bArr[i + 4]) + bArr[i + 5]) + bArr[i + 6]) + bArr[i + 7]) + 4) >> 3);
    }

    private final byte chromaPredTwo(byte[] bArr, byte[] bArr2, int i, int i2) {
        return (byte) (((((((((((((((((bArr[i] + bArr[i + 1]) + bArr[i + 2]) + bArr[i + 3]) + bArr[i + 4]) + bArr[i + 5]) + bArr[i + 6]) + bArr[i + 7]) + bArr2[i2]) + bArr2[i2 + 1]) + bArr2[i2 + 2]) + bArr2[i2 + 3]) + bArr2[i2 + 4]) + bArr2[i2 + 5]) + bArr2[i2 + 6]) + bArr2[i2 + 7]) + 8) >> 4);
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

    public static VP8Encoder createVP8Encoder(int i) {
        return new VP8Encoder(new NopRateControl(i));
    }

    private int[] extractDC(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = iArr[i][0];
        }
        return iArr2;
    }

    private void initValue(byte[][] bArr, byte b) {
        Arrays.fill(bArr[0], b);
        Arrays.fill(bArr[1], b);
        Arrays.fill(bArr[2], b);
    }

    private void luma(Picture picture, int i, int i2, VPXBooleanEncoder vPXBooleanEncoder, int i3, Picture picture2) {
        int i4 = i << 4;
        int i5 = i2 << 4;
        int[][] iArrTransform = transform(picture, 0, i3, i4, i5);
        int[] iArrExtractDC = extractDC(iArrTransform);
        writeLumaDC(i, i2, vPXBooleanEncoder, i3, iArrExtractDC);
        writeLumaAC(i, i2, vPXBooleanEncoder, iArrTransform, i3);
        restorePlaneLuma(iArrExtractDC, iArrTransform, i3);
        putLuma(picture2.getPlaneData(0), lumaDCPred(i4, i5), iArrTransform, 4);
    }

    private byte lumaDCPred(int i, int i2) {
        int iSumByte;
        int iSumByte3;
        if (i == 0 && i2 == 0) {
            return (byte) 0;
        }
        if (i2 == 0) {
            iSumByte3 = ArrayUtil.sumByte(this.leftRow[0]);
        } else {
            if (i != 0) {
                iSumByte = ((ArrayUtil.sumByte(this.leftRow[0]) + ArrayUtil.sumByte3(this.topLine[0], i, 16)) + 16) >> 5;
                return (byte) iSumByte;
            }
            iSumByte3 = ArrayUtil.sumByte3(this.topLine[0], i, 16);
        }
        iSumByte = (iSumByte3 + 8) >> 4;
        return (byte) iSumByte;
    }

    private void prepareBuffers(int i, int i2) {
        int i3 = (i2 * i2) << 10;
        int i4 = (i * i2) + 256;
        ByteBuffer byteBuffer = this.headerBuffer;
        if (byteBuffer == null || byteBuffer.capacity() < i4) {
            this.headerBuffer = ByteBuffer.allocate(i4);
        } else {
            this.headerBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.dataBuffer;
        if (byteBuffer2 == null || byteBuffer2.capacity() < i3) {
            this.dataBuffer = ByteBuffer.allocate(i3);
        } else {
            this.dataBuffer.clear();
        }
    }

    private void putBlk(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4) {
        int i5 = 1 << i2;
        int i6 = (i4 << i2) + i3;
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            bArr[i6] = (byte) MathUtil.clip(iArr[i7] + i, -128, 127);
            bArr[i6 + 1] = (byte) MathUtil.clip(iArr[i7 + 1] + i, -128, 127);
            bArr[i6 + 2] = (byte) MathUtil.clip(iArr[i7 + 2] + i, -128, 127);
            bArr[i6 + 3] = (byte) MathUtil.clip(iArr[i7 + 3] + i, -128, 127);
            i7 += 4;
            i6 += i5;
        }
    }

    private void putChroma(byte[] bArr, int i, int i2, int i3, int[][] iArr, int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            putBlk(bArr, i4, iArr[i5], 3, (i5 & 1) << 2, (i5 >> 1) << 2);
        }
    }

    private void putLuma(byte[] bArr, int i, int[][] iArr, int i2) {
        for (int i3 = 0; i3 < iArr.length; i3++) {
            putBlk(bArr, i, iArr[i3], i2, (i3 & 3) << 2, i3 & (-4));
        }
    }

    private void restorePlaneChroma(int[][] iArr, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.quantizer.dequantizeUV(iArr[i2], i);
            VPXDCT.idct4x4(iArr[i2]);
        }
    }

    private void restorePlaneLuma(int[] iArr, int[][] iArr2, int i) {
        this.quantizer.dequantizeY2(iArr, i);
        VPXDCT.iwalsh4x4(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            this.quantizer.dequantizeY(iArr2[i2], i);
            int[] iArr3 = iArr2[i2];
            iArr3[0] = iArr[i2];
            VPXDCT.idct4x4(iArr3);
        }
    }

    private final void takeSubtract(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (i3 + 4 >= i || i4 + 4 >= i2) {
            takeSubtractUnsafe(bArr, i, i2, i3, i4, iArr, i5);
        } else {
            takeSubtractSafe(bArr, i, i2, i3, i4, iArr, i5);
        }
    }

    private final void takeSubtractSafe(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        int i6 = (i4 * i) + i3;
        int i7 = 0;
        int i8 = 0;
        while (i7 < 4) {
            iArr[i8] = bArr[i6] - i5;
            iArr[i8 + 1] = bArr[i6 + 1] - i5;
            iArr[i8 + 2] = bArr[i6 + 2] - i5;
            iArr[i8 + 3] = bArr[i6 + 3] - i5;
            i7++;
            i6 += i;
            i8 += 4;
        }
    }

    private final void takeSubtractUnsafe(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        int i10 = i4;
        while (true) {
            i6 = i4 + 4;
            if (i10 >= Math.min(i6, i2)) {
                break;
            }
            int iMin = (i10 * i) + Math.min(i3, i);
            int i11 = i3;
            while (true) {
                i8 = i3 + 4;
                if (i11 >= Math.min(i8, i)) {
                    break;
                }
                iArr[i9] = bArr[iMin] - i5;
                i11++;
                i9++;
                iMin++;
            }
            int i12 = iMin - 1;
            while (i11 < i8) {
                iArr[i9] = bArr[i12] - i5;
                i11++;
                i9++;
            }
            i10++;
        }
        while (i10 < i6) {
            int iMin2 = ((i2 * i) - i) + Math.min(i3, i);
            int i13 = i3;
            while (true) {
                i7 = i3 + 4;
                if (i13 >= Math.min(i7, i)) {
                    break;
                }
                iArr[i9] = bArr[iMin2] - i5;
                i13++;
                i9++;
                iMin2++;
            }
            int i14 = iMin2 - 1;
            while (i13 < i7) {
                iArr[i9] = bArr[i14] - i5;
                i13++;
                i9++;
            }
            i10++;
        }
    }

    private int[][] transform(Picture picture, int i, int i2, int i3, int i4) {
        byte bLumaDCPred = lumaDCPred(i3, i4);
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 16);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int[] iArr2 = iArr[i5];
            takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i3 + ((i5 & 3) << 2), i4 + (i5 & (-4)), iArr2, bLumaDCPred);
            VPXDCT.fdct4x4(iArr2);
        }
        return iArr;
    }

    private int[][] transformChroma(Picture picture, int i, int i2, int i3, int i4, Picture picture2, int i5) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 16);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i3 + ((i6 & 1) << 2), i4 + ((i6 >> 1) << 2), iArr[i6], i5);
            VPXDCT.fdct4x4(iArr[i6]);
        }
        return iArr;
    }

    private void writeChroma(int i, int i2, int i3, VPXBooleanEncoder vPXBooleanEncoder, int[][] iArr, int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            this.quantizer.quantizeUV(iArr[i5], i4);
            this.bitstream.encodeCoeffsDCTUV(vPXBooleanEncoder, zigzag(iArr[i5], this.tmp), i, i2, i5 & 1, i5 >> 1);
        }
    }

    private void writeHeader(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int i4 = (i3 << 5) | 16 | 0 | 0;
        byteBuffer.put((byte) (i4 & 255));
        byteBuffer.put((byte) ((i4 >> 8) & 255));
        byteBuffer.put((byte) ((i4 >> 16) & 255));
        byteBuffer.put((byte) -99);
        byteBuffer.put((byte) 1);
        byteBuffer.put(ExifInterface.START_CODE);
        byteBuffer.putShort((short) i);
        byteBuffer.putShort((short) i2);
    }

    private void writeHeader2(VPXBooleanEncoder vPXBooleanEncoder, int[] iArr, int[] iArr2) {
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 1);
        vPXBooleanEncoder.writeBit(128, 1);
        vPXBooleanEncoder.writeBit(128, 1);
        vPXBooleanEncoder.writeBit(128, 1);
        for (int i : iArr) {
            vPXBooleanEncoder.writeBit(128, 1);
            writeInt(vPXBooleanEncoder, i, 7);
            vPXBooleanEncoder.writeBit(128, 0);
        }
        for (int length = iArr.length; length < 4; length++) {
            vPXBooleanEncoder.writeBit(128, 0);
        }
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        for (int i2 = 0; i2 < 3; i2++) {
            vPXBooleanEncoder.writeBit(128, 1);
            writeInt(vPXBooleanEncoder, iArr2[i2], 8);
        }
        vPXBooleanEncoder.writeBit(128, 0);
        writeInt(vPXBooleanEncoder, 1, 6);
        writeInt(vPXBooleanEncoder, 0, 3);
        vPXBooleanEncoder.writeBit(128, 0);
        writeInt(vPXBooleanEncoder, 0, 2);
        writeInt(vPXBooleanEncoder, iArr[0], 7);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        vPXBooleanEncoder.writeBit(128, 0);
        int[][][][] iArr3 = VPXConst.tokenProbUpdateFlagProbs;
        for (int i3 = 0; i3 < iArr3.length; i3++) {
            for (int i4 = 0; i4 < iArr3[i3].length; i4++) {
                for (int i5 = 0; i5 < iArr3[i3][i4].length; i5++) {
                    int i6 = 0;
                    while (true) {
                        int[] iArr4 = iArr3[i3][i4][i5];
                        if (i6 < iArr4.length) {
                            vPXBooleanEncoder.writeBit(iArr4[i6], 0);
                            i6++;
                        }
                    }
                }
            }
        }
        vPXBooleanEncoder.writeBit(128, 0);
    }

    private void writeLumaAC(int i, int i2, VPXBooleanEncoder vPXBooleanEncoder, int[][] iArr, int i3) {
        for (int i4 = 0; i4 < 16; i4++) {
            this.quantizer.quantizeY(iArr[i4], i3);
            this.bitstream.encodeCoeffsDCT15(vPXBooleanEncoder, zigzag(iArr[i4], this.tmp), i, i4 & 3, i4 >> 2);
        }
    }

    private void writeLumaDC(int i, int i2, VPXBooleanEncoder vPXBooleanEncoder, int i3, int[] iArr) {
        VPXDCT.walsh4x4(iArr);
        this.quantizer.quantizeY2(iArr, i3);
        this.bitstream.encodeCoeffsWHT(vPXBooleanEncoder, zigzag(iArr, this.tmp), i);
    }

    private void writeSegmetId(VPXBooleanEncoder vPXBooleanEncoder, int i, int[] iArr) {
        int i2 = (i >> 1) & 1;
        vPXBooleanEncoder.writeBit(iArr[0], i2);
        vPXBooleanEncoder.writeBit(iArr[i2 + 1], i & 1);
    }

    private int[] zigzag(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 16; i++) {
            iArr2[i] = iArr[VPXConst.zigzag[i]];
        }
        return iArr2;
    }

    @Override // org.jcodec.common.VideoEncoder
    public VideoEncoder.EncodedFrame encodeFrame(Picture picture, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        int width = (picture.getWidth() + 15) >> 4;
        int height = (picture.getHeight() + 15) >> 4;
        prepareBuffers(width, height);
        this.bitstream = new VPXBitstream(VPXConst.tokenDefaultBinProbs, width);
        int i = 0;
        byte[][] bArr = {new byte[16], new byte[8], new byte[8]};
        this.leftRow = bArr;
        int i2 = width << 3;
        this.topLine = new byte[][]{new byte[width << 4], new byte[i2], new byte[i2]};
        initValue(bArr, (byte) 1);
        initValue(this.topLine, (byte) -1);
        this.quantizer = new VPXQuantizer();
        Picture pictureCreate = Picture.create(16, 16, ColorSpace.YUV420);
        int[] segmentQps = this.rc.getSegmentQps();
        VPXBooleanEncoder vPXBooleanEncoder = new VPXBooleanEncoder(this.dataBuffer);
        int[] iArr = new int[width * height];
        int i3 = 0;
        int i4 = 0;
        while (i4 < height) {
            initValue(this.leftRow, (byte) 1);
            int i5 = i3;
            int i6 = i;
            while (i6 < width) {
                int iPosition = vPXBooleanEncoder.position();
                int segment = this.rc.getSegment();
                iArr[i5] = segment;
                int i7 = i6;
                int i8 = i4;
                luma(picture, i6, i4, vPXBooleanEncoder, segmentQps[segment], pictureCreate);
                chroma(picture, i7, i8, vPXBooleanEncoder, segmentQps[segment], pictureCreate);
                this.rc.report(vPXBooleanEncoder.position() - iPosition);
                collectPredictors(pictureCreate, i7);
                i6 = i7 + 1;
                i5++;
                iArr = iArr;
                i4 = i8;
            }
            i4++;
            i3 = i5;
            i = 0;
        }
        int[] iArr2 = iArr;
        vPXBooleanEncoder.stop();
        this.dataBuffer.flip();
        VPXBooleanEncoder vPXBooleanEncoder2 = new VPXBooleanEncoder(this.headerBuffer);
        int[] iArrCalcSegmentProbs = calcSegmentProbs(iArr2);
        writeHeader2(vPXBooleanEncoder2, segmentQps, iArrCalcSegmentProbs);
        int i9 = 0;
        for (int i10 = 0; i10 < height; i10++) {
            int i11 = 0;
            while (i11 < width) {
                writeSegmetId(vPXBooleanEncoder2, iArr2[i9], iArrCalcSegmentProbs);
                vPXBooleanEncoder2.writeBit(145, 1);
                vPXBooleanEncoder2.writeBit(156, 0);
                vPXBooleanEncoder2.writeBit(163, 0);
                vPXBooleanEncoder2.writeBit(142, 0);
                i11++;
                i9++;
            }
        }
        vPXBooleanEncoder2.stop();
        this.headerBuffer.flip();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        writeHeader(byteBufferDuplicate, picture.getWidth(), picture.getHeight(), this.headerBuffer.remaining());
        byteBufferDuplicate.put(this.headerBuffer);
        byteBufferDuplicate.put(this.dataBuffer);
        byteBufferDuplicate.flip();
        return new VideoEncoder.EncodedFrame(byteBufferDuplicate, true);
    }

    @Override // org.jcodec.common.VideoEncoder
    public int estimateBufferSize(Picture picture) {
        return (picture.getWidth() * picture.getHeight()) / 2;
    }

    @Override // org.jcodec.common.VideoEncoder
    public ColorSpace[] getSupportedColorSpaces() {
        return new ColorSpace[]{ColorSpace.YUV420J};
    }

    public void writeInt(VPXBooleanEncoder vPXBooleanEncoder, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            vPXBooleanEncoder.writeBit(128, (i >> i3) & 1);
        }
    }
}
