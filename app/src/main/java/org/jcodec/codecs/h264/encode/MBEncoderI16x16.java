package org.jcodec.codecs.h264.encode;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.CoeffTransformer;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.SaveRestore;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBEncoderI16x16 implements SaveRestore {
    private static int[] DUMMY = new int[16];
    private CAVLC[] cavlc;
    private byte[][] leftRow;
    private byte[][] topLine;

    public MBEncoderI16x16(CAVLC[] cavlcArr, byte[][] bArr, byte[][] bArr2) {
        this.cavlc = cavlcArr;
        this.leftRow = bArr;
        this.topLine = bArr2;
    }

    private void chroma(Picture picture, int i, int i2, BitWriter bitWriter, int i3, Picture picture2) {
        int i4 = i << 3;
        int i5 = i2 << 3;
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 4, 16);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 4, 16);
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 16);
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 16);
        predictChroma(picture, iArr, bArr, 1, i4, i5);
        predictChroma(picture, iArr2, bArr2, 2, i4, i5);
        CAVLC[] cavlcArr = this.cavlc;
        CAVLC cavlc = cavlcArr[1];
        CAVLC cavlc2 = cavlcArr[2];
        MBType mBType = MBType.I_16x16;
        chromaResidual(picture, i, i2, bitWriter, i3, iArr, iArr2, cavlc, cavlc2, mBType, mBType);
        putChroma(picture2.getData()[1], 1, i4, i5, iArr, bArr);
        putChroma(picture2.getData()[2], 2, i4, i5, iArr2, bArr2);
    }

    private void chromaPredBlk0(int i, int i2, int i3, byte[] bArr) {
        int i4 = i3 & 7;
        int iChromaPredOne = (i2 == 0 || i3 == 0) ? i2 != 0 ? chromaPredOne(this.leftRow[i], i4) : i3 != 0 ? chromaPredOne(this.topLine[i], i2) : 0 : chromaPredTwo(this.leftRow[i], this.topLine[i], i4, i2);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr[i5] = (byte) (bArr[i5] + iChromaPredOne);
        }
    }

    private void chromaPredBlk1(int i, int i2, int i3, byte[] bArr) {
        int iChromaPredOne = i3 != 0 ? chromaPredOne(this.topLine[i], i2 + 4) : i2 != 0 ? chromaPredOne(this.leftRow[i], i3 & 7) : 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = (byte) (bArr[i4] + iChromaPredOne);
        }
    }

    private void chromaPredBlk2(int i, int i2, int i3, byte[] bArr) {
        int iChromaPredOne = i2 != 0 ? chromaPredOne(this.leftRow[i], (i3 & 7) + 4) : i3 != 0 ? chromaPredOne(this.topLine[i], i2) : 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            bArr[i4] = (byte) (bArr[i4] + iChromaPredOne);
        }
    }

    private void chromaPredBlk3(int i, int i2, int i3, byte[] bArr) {
        int i4 = i3 & 7;
        int iChromaPredOne = (i2 == 0 || i3 == 0) ? i2 != 0 ? chromaPredOne(this.leftRow[i], i4 + 4) : i3 != 0 ? chromaPredOne(this.topLine[i], i2 + 4) : 0 : chromaPredTwo(this.leftRow[i], this.topLine[i], i4 + 4, i2 + 4);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr[i5] = (byte) (bArr[i5] + iChromaPredOne);
        }
    }

    private final int chromaPredOne(byte[] bArr, int i) {
        return ((((bArr[i] + bArr[i + 1]) + bArr[i + 2]) + bArr[i + 3]) + 2) >> 2;
    }

    private final int chromaPredTwo(byte[] bArr, byte[] bArr2, int i, int i2) {
        return ((((((((bArr[i] + bArr[i + 1]) + bArr[i + 2]) + bArr[i + 3]) + bArr2[i2]) + bArr2[i2 + 1]) + bArr2[i2 + 2]) + bArr2[i2 + 3]) + 4) >> 3;
    }

    public static void chromaResidual(Picture picture, int i, int i2, BitWriter bitWriter, int i3, int[][] iArr, int[][] iArr2, CAVLC cavlc, CAVLC cavlc2, MBType mBType, MBType mBType2) {
        transformChroma(iArr);
        transformChroma(iArr2);
        int[] iArrExtractDC = extractDC(iArr);
        int[] iArrExtractDC2 = extractDC(iArr2);
        int i4 = i << 1;
        int i5 = i2 << 1;
        writeDC(cavlc, i, i2, bitWriter, i3, i4, i5, iArrExtractDC, mBType, mBType2);
        writeDC(cavlc2, i, i2, bitWriter, i3, i4, i5, iArrExtractDC2, mBType, mBType2);
        writeAC(cavlc, i, i2, bitWriter, i4, i5, iArr, i3, mBType, mBType2, DUMMY);
        writeAC(cavlc2, i, i2, bitWriter, i4, i5, iArr2, i3, mBType, mBType2, DUMMY);
        restorePlane(iArrExtractDC, iArr, i3);
        restorePlane(iArrExtractDC2, iArr2, i3);
    }

    private static int[] extractDC(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            int[] iArr3 = iArr[i];
            iArr2[i] = iArr3[0];
            iArr3[0] = 0;
        }
        return iArr2;
    }

    private void luma(Picture picture, int i, int i2, BitWriter bitWriter, int i3, Picture picture2, CAVLC cavlc) {
        int i4 = i << 4;
        int i5 = i2 << 4;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 16);
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 16);
        lumaDCPred(i4, i5, bArr);
        transform(picture, 0, iArr, bArr, i4, i5);
        int[] iArrExtractDC = extractDC(iArr);
        int i6 = i << 2;
        int i7 = i2 << 2;
        MBType mBType = MBType.I_16x16;
        writeDC(cavlc, i, i2, bitWriter, i3, i6, i7, iArrExtractDC, mBType, mBType);
        writeAC(cavlc, i, i2, bitWriter, i6, i7, iArr, i3, mBType, mBType, DUMMY);
        restorePlane(iArrExtractDC, iArr, i3);
        for (int i8 = 0; i8 < iArr.length; i8++) {
            MBEncoderHelper.putBlk(picture2.getPlaneData(0), iArr[i8], bArr[i8], 4, H264Const.BLK_X[i8], H264Const.BLK_Y[i8], 4, 4);
        }
    }

    private void lumaDCPred(int i, int i2, byte[][] bArr) {
        int iSumByte;
        int iSumByte3;
        if (i == 0 && i2 == 0) {
            iSumByte = 0;
        } else {
            if (i2 == 0) {
                iSumByte3 = ArrayUtil.sumByte(this.leftRow[0]);
            } else if (i == 0) {
                iSumByte3 = ArrayUtil.sumByte3(this.topLine[0], i, 16);
            } else {
                iSumByte = ((ArrayUtil.sumByte(this.leftRow[0]) + ArrayUtil.sumByte3(this.topLine[0], i, 16)) + 16) >> 5;
            }
            iSumByte = (iSumByte3 + 8) >> 4;
        }
        for (byte[] bArr2 : bArr) {
            int i3 = 0;
            while (true) {
                if (i3 < bArr2.length) {
                    bArr2[i3] = (byte) (bArr2[i3] + iSumByte);
                    i3++;
                }
            }
        }
    }

    private void predictChroma(Picture picture, int[][] iArr, byte[][] bArr, int i, int i2, int i3) {
        chromaPredBlk0(i, i2, i3, bArr[0]);
        chromaPredBlk1(i, i2, i3, bArr[1]);
        chromaPredBlk2(i, i2, i3, bArr[2]);
        chromaPredBlk3(i, i2, i3, bArr[3]);
        MBEncoderHelper.takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i2, i3, iArr[0], bArr[0], 4, 4);
        int i4 = i2 + 4;
        MBEncoderHelper.takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i4, i3, iArr[1], bArr[1], 4, 4);
        int i5 = i3 + 4;
        MBEncoderHelper.takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i2, i5, iArr[2], bArr[2], 4, 4);
        MBEncoderHelper.takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i4, i5, iArr[3], bArr[3], 4, 4);
    }

    private void putChroma(byte[] bArr, int i, int i2, int i3, int[][] iArr, byte[][] bArr2) {
        MBEncoderHelper.putBlk(bArr, iArr[0], bArr2[0], 3, 0, 0, 4, 4);
        MBEncoderHelper.putBlk(bArr, iArr[1], bArr2[1], 3, 4, 0, 4, 4);
        MBEncoderHelper.putBlk(bArr, iArr[2], bArr2[2], 3, 0, 4, 4, 4);
        MBEncoderHelper.putBlk(bArr, iArr[3], bArr2[3], 3, 4, 4, 4, 4);
    }

    private static void restorePlane(int[] iArr, int[][] iArr2, int i) {
        if (iArr.length == 4) {
            CoeffTransformer.invDC2x2(iArr);
            CoeffTransformer.dequantizeDC2x2(iArr, i, null);
        } else if (iArr.length == 8) {
            CoeffTransformer.invDC4x2(iArr);
            CoeffTransformer.dequantizeDC4x2(iArr, i);
        } else {
            CoeffTransformer.invDC4x4(iArr);
            CoeffTransformer.dequantizeDC4x4(iArr, i, null);
            CoeffTransformer.reorderDC4x4(iArr);
        }
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            CoeffTransformer.dequantizeAC(iArr2[i2], i, null);
            int[] iArr3 = iArr2[i2];
            iArr3[0] = iArr[i2];
            CoeffTransformer.idct4x4(iArr3);
        }
    }

    private void transform(Picture picture, int i, int[][] iArr, byte[][] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int[] iArr2 = iArr[i4];
            MBEncoderHelper.takeSubtract(picture.getPlaneData(i), picture.getPlaneWidth(i), picture.getPlaneHeight(i), i2 + H264Const.BLK_X[i4], i3 + H264Const.BLK_Y[i4], iArr2, bArr[i4], 4, 4);
            CoeffTransformer.fdct4x4(iArr2);
        }
    }

    private static void transformChroma(int[][] iArr) {
        for (int i = 0; i < 4; i++) {
            CoeffTransformer.fdct4x4(iArr[i]);
        }
    }

    private static void writeAC(CAVLC cavlc, int i, int i2, BitWriter bitWriter, int i3, int i4, int[][] iArr, int i5, MBType mBType, MBType mBType2, int[] iArr2) {
        for (int i6 = 0; i6 < iArr.length; i6++) {
            CoeffTransformer.quantizeAC(iArr[i6], i5);
            iArr2[H264Const.BLK_INV_MAP[i6]] = CAVLC.totalCoeff(cavlc.writeACBlock(bitWriter, i3 + H264Const.MB_BLK_OFF_LEFT[i6], i4 + H264Const.MB_BLK_OFF_TOP[i6], mBType, mBType2, iArr[i6], H264Const.totalZeros16, 1, 15, CoeffTransformer.zigzag4x4));
        }
    }

    private static void writeDC(CAVLC cavlc, int i, int i2, BitWriter bitWriter, int i3, int i4, int i5, int[] iArr, MBType mBType, MBType mBType2) {
        if (iArr.length == 4) {
            CoeffTransformer.quantizeDC2x2(iArr, i3);
            CoeffTransformer.fvdDC2x2(iArr);
            cavlc.writeChrDCBlock(bitWriter, iArr, H264Const.totalZeros4, 0, iArr.length, new int[]{0, 1, 2, 3});
        } else if (iArr.length == 8) {
            CoeffTransformer.quantizeDC4x2(iArr, i3);
            CoeffTransformer.fvdDC4x2(iArr);
            cavlc.writeChrDCBlock(bitWriter, iArr, H264Const.totalZeros8, 0, iArr.length, new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        } else {
            CoeffTransformer.reorderDC4x4(iArr);
            CoeffTransformer.quantizeDC4x4(iArr, i3);
            CoeffTransformer.fvdDC4x4(iArr);
            cavlc.writeLumaDCBlock(bitWriter, i4, i5, mBType, mBType2, iArr, H264Const.totalZeros16, 0, 16, CoeffTransformer.zigzag4x4);
        }
    }

    public void encodeMacroblock(Picture picture, int i, int i2, BitWriter bitWriter, EncodedMB encodedMB, EncodedMB encodedMB2, EncodedMB encodedMB3, int i3, int i4) {
        CAVLCWriter.writeUE(bitWriter, 0);
        CAVLCWriter.writeSE(bitWriter, i4);
        encodedMB.setType(MBType.I_16x16);
        encodedMB.setQp(i3);
        luma(picture, i, i2, bitWriter, i3, encodedMB.getPixels(), this.cavlc[0]);
        chroma(picture, i, i2, bitWriter, i3, encodedMB.getPixels());
        new MBDeblocker().deblockMBI(encodedMB, encodedMB2, encodedMB3);
    }

    public int getCbpChroma(Picture picture, int i, int i2) {
        return 2;
    }

    public int getCbpLuma(Picture picture, int i, int i2) {
        return 15;
    }

    public int getPredMode(Picture picture, int i, int i2) {
        return 2;
    }

    @Override // org.jcodec.common.SaveRestore
    public void restore() {
        int i = 0;
        while (true) {
            CAVLC[] cavlcArr = this.cavlc;
            if (i >= cavlcArr.length) {
                return;
            }
            cavlcArr[i].restore();
            i++;
        }
    }

    @Override // org.jcodec.common.SaveRestore
    public void save() {
        int i = 0;
        while (true) {
            CAVLC[] cavlcArr = this.cavlc;
            if (i >= cavlcArr.length) {
                return;
            }
            cavlcArr[i].save();
            i++;
        }
    }
}
