package org.jcodec.codecs.h264.encode;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.BlockInterpolator;
import org.jcodec.codecs.h264.decode.CoeffTransformer;
import org.jcodec.codecs.h264.io.CAVLC;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.SaveRestore;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class MBEncoderP16x16 implements SaveRestore {
    private CAVLC[] cavlc;
    private BlockInterpolator interpolator;
    private MotionEstimator me;
    private int mvLeftX;
    private int mvLeftXSave;
    private int mvLeftY;
    private int mvLeftYSave;
    private int mvTopLeftX;
    private int mvTopLeftXSave;
    private int mvTopLeftY;
    private int mvTopLeftYSave;
    private int[] mvTopX;
    private int[] mvTopXSave;
    private int[] mvTopY;
    private int[] mvTopYSave;
    private Picture ref;
    private SeqParameterSet sps;

    public MBEncoderP16x16(SeqParameterSet seqParameterSet, Picture picture, CAVLC[] cavlcArr, MotionEstimator motionEstimator) {
        this.sps = seqParameterSet;
        this.cavlc = cavlcArr;
        this.ref = picture;
        this.me = motionEstimator;
        int i = seqParameterSet.picWidthInMbsMinus1;
        this.mvTopX = new int[i + 1];
        this.mvTopY = new int[i + 1];
        this.mvTopXSave = new int[i + 1];
        this.mvTopYSave = new int[i + 1];
        this.interpolator = new BlockInterpolator();
    }

    private void chroma(Picture picture, int[] iArr, int[] iArr2, int i, int i2, BitWriter bitWriter, int i3) {
        Class cls = Integer.TYPE;
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) cls, 4, 16);
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) cls, 4, 16);
        for (int i4 = 0; i4 < iArr3.length; i4++) {
            int i5 = 0;
            while (true) {
                int[] iArr5 = H264Const.PIX_MAP_SPLIT_2x2[i4];
                if (i5 < iArr5.length) {
                    iArr3[i4][i5] = iArr[iArr5[i5]];
                    i5++;
                }
            }
        }
        for (int i6 = 0; i6 < iArr4.length; i6++) {
            int i7 = 0;
            while (true) {
                int[] iArr6 = H264Const.PIX_MAP_SPLIT_2x2[i6];
                if (i7 < iArr6.length) {
                    iArr4[i6][i7] = iArr2[iArr6[i7]];
                    i7++;
                }
            }
        }
        CAVLC[] cavlcArr = this.cavlc;
        CAVLC cavlc = cavlcArr[1];
        CAVLC cavlc2 = cavlcArr[2];
        MBType mBType = MBType.P_16x16;
        MBEncoderI16x16.chromaResidual(picture, i, i2, bitWriter, i3, iArr3, iArr4, cavlc, cavlc2, mBType, mBType);
        for (int i8 = 0; i8 < iArr3.length; i8++) {
            int i9 = 0;
            while (true) {
                int[] iArr7 = H264Const.PIX_MAP_SPLIT_2x2[i8];
                if (i9 < iArr7.length) {
                    iArr[iArr7[i9]] = iArr3[i8][i9];
                    i9++;
                }
            }
        }
        for (int i10 = 0; i10 < iArr4.length; i10++) {
            int i11 = 0;
            while (true) {
                int[] iArr8 = H264Const.PIX_MAP_SPLIT_2x2[i10];
                if (i11 < iArr8.length) {
                    iArr2[iArr8[i11]] = iArr4[i10][i11];
                    i11++;
                }
            }
        }
    }

    private int decideRef() {
        return 0;
    }

    private int getCodedBlockPattern() {
        return 47;
    }

    private void luma(Picture picture, int[] iArr, int i, int i2, BitWriter bitWriter, int i3, int[] iArr2) {
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 16, 16);
        for (int i4 = 0; i4 < iArr3.length; i4++) {
            int i5 = 0;
            while (true) {
                int[] iArr4 = H264Const.PIX_MAP_SPLIT_4x4[i4];
                if (i5 < iArr4.length) {
                    iArr3[i4][i5] = iArr[iArr4[i5]];
                    i5++;
                }
            }
            CoeffTransformer.fdct4x4(iArr3[i4]);
        }
        writeAC(0, i, i2, bitWriter, i << 2, i2 << 2, iArr3, i3);
        for (int i6 = 0; i6 < iArr3.length; i6++) {
            CoeffTransformer.dequantizeAC(iArr3[i6], i3, null);
            CoeffTransformer.idct4x4(iArr3[i6]);
            int i7 = 0;
            while (true) {
                int[] iArr5 = H264Const.PIX_MAP_SPLIT_4x4[i6];
                if (i7 < iArr5.length) {
                    iArr[iArr5[i7]] = iArr3[i6][i7];
                    i7++;
                }
            }
        }
    }

    private int[] mvEstimate(Picture picture, int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[256];
        MBEncoderHelper.take(picture.getPlaneData(0), picture.getPlaneWidth(0), picture.getPlaneHeight(0), i << 4, i2 << 4, bArr, 16, 16);
        return this.me.estimate(this.ref, bArr, i, i2, i3, i4);
    }

    private void writeAC(int i, int i2, int i3, BitWriter bitWriter, int i4, int i5, int[][] iArr, int i6) {
        for (int i7 = 0; i7 < iArr.length; i7++) {
            int i8 = H264Const.BLK_INV_MAP[i7];
            CoeffTransformer.quantizeAC(iArr[i8], i6);
            CAVLC cavlc = this.cavlc[i];
            int i9 = i4 + H264Const.MB_BLK_OFF_LEFT[i7];
            int i10 = i5 + H264Const.MB_BLK_OFF_TOP[i7];
            MBType mBType = MBType.P_16x16;
            cavlc.writeACBlock(bitWriter, i9, i10, mBType, mBType, iArr[i8], H264Const.totalZeros16, 0, 16, CoeffTransformer.zigzag4x4);
        }
    }

    public void encodeMacroblock(Picture picture, int i, int i2, BitWriter bitWriter, EncodedMB encodedMB, EncodedMB encodedMB2, EncodedMB encodedMB3, int i3, int i4) {
        if (this.sps.numRefFrames > 1) {
            CAVLCWriter.writeTE(bitWriter, decideRef(), this.sps.numRefFrames - 1);
        }
        boolean z = i2 > 0 && i < this.sps.picWidthInMbsMinus1;
        boolean z2 = i > 0 && i2 > 0;
        int i5 = this.mvLeftX;
        int[] iArr = this.mvTopX;
        int iMedian = median(i5, iArr[i], z ? iArr[i + 1] : 0, z2 ? this.mvTopLeftX : 0, i > 0, i2 > 0, z, z2);
        int i6 = this.mvLeftY;
        int[] iArr2 = this.mvTopY;
        int iMedian2 = median(i6, iArr2[i], z ? iArr2[i + 1] : 0, z2 ? this.mvTopLeftY : 0, i > 0, i2 > 0, z, z2);
        int[] iArrMvEstimate = mvEstimate(picture, i, i2, iMedian, iMedian2);
        int[] iArr3 = this.mvTopX;
        this.mvTopLeftX = iArr3[i];
        int[] iArr4 = this.mvTopY;
        this.mvTopLeftY = iArr4[i];
        iArr3[i] = iArrMvEstimate[0];
        iArr4[i] = iArrMvEstimate[1];
        int i7 = iArrMvEstimate[0];
        this.mvLeftX = i7;
        this.mvLeftY = iArrMvEstimate[1];
        CAVLCWriter.writeSE(bitWriter, i7 - iMedian);
        CAVLCWriter.writeSE(bitWriter, iArrMvEstimate[1] - iMedian2);
        Picture pictureCreate = Picture.create(16, 16, this.sps.chromaFormatIdc);
        int[][] iArr5 = {new int[256], new int[64], new int[64]};
        int i8 = i << 6;
        int i9 = i2 << 6;
        this.interpolator.getBlockLuma(this.ref, pictureCreate, 0, i8 + iArrMvEstimate[0], i9 + iArrMvEstimate[1], 16, 16);
        BlockInterpolator.getBlockChroma(this.ref.getPlaneData(1), this.ref.getPlaneWidth(1), this.ref.getPlaneHeight(1), pictureCreate.getPlaneData(1), 0, pictureCreate.getPlaneWidth(1), i8 + iArrMvEstimate[0], i9 + iArrMvEstimate[1], 8, 8);
        BlockInterpolator.getBlockChroma(this.ref.getPlaneData(2), this.ref.getPlaneWidth(2), this.ref.getPlaneHeight(2), pictureCreate.getPlaneData(2), 0, pictureCreate.getPlaneWidth(2), i8 + iArrMvEstimate[0], i9 + iArrMvEstimate[1], 8, 8);
        MBEncoderHelper.takeSubtract(picture.getPlaneData(0), picture.getPlaneWidth(0), picture.getPlaneHeight(0), i << 4, i2 << 4, iArr5[0], pictureCreate.getPlaneData(0), 16, 16);
        int i10 = i << 3;
        int i11 = i2 << 3;
        MBEncoderHelper.takeSubtract(picture.getPlaneData(1), picture.getPlaneWidth(1), picture.getPlaneHeight(1), i10, i11, iArr5[1], pictureCreate.getPlaneData(1), 8, 8);
        MBEncoderHelper.takeSubtract(picture.getPlaneData(2), picture.getPlaneWidth(2), picture.getPlaneHeight(2), i10, i11, iArr5[2], pictureCreate.getPlaneData(2), 8, 8);
        CAVLCWriter.writeUE(bitWriter, H264Const.CODED_BLOCK_PATTERN_INTER_COLOR_INV[getCodedBlockPattern()]);
        CAVLCWriter.writeSE(bitWriter, i4);
        luma(picture, iArr5[0], i, i2, bitWriter, i3, encodedMB.getNc());
        chroma(picture, iArr5[1], iArr5[2], i, i2, bitWriter, i3);
        MBEncoderHelper.putBlk(encodedMB.getPixels().getPlaneData(0), iArr5[0], pictureCreate.getPlaneData(0), 4, 0, 0, 16, 16);
        MBEncoderHelper.putBlk(encodedMB.getPixels().getPlaneData(1), iArr5[1], pictureCreate.getPlaneData(1), 3, 0, 0, 8, 8);
        MBEncoderHelper.putBlk(encodedMB.getPixels().getPlaneData(2), iArr5[2], pictureCreate.getPlaneData(2), 3, 0, 0, 8, 8);
        Arrays.fill(encodedMB.getMx(), iArrMvEstimate[0]);
        Arrays.fill(encodedMB.getMy(), iArrMvEstimate[1]);
        encodedMB.setType(MBType.P_16x16);
        encodedMB.setQp(i3);
        new MBDeblocker().deblockMBP(encodedMB, encodedMB2, encodedMB3);
    }

    public int median(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        if (!z3) {
            i3 = i4;
            z3 = z4;
        }
        if (z && !z2 && !z3) {
            i2 = i;
            i3 = i2;
            z2 = z;
            z3 = z2;
        }
        if (!z) {
            i = 0;
        }
        if (!z2) {
            i2 = 0;
        }
        if (!z3) {
            i3 = 0;
        }
        return (((i + i2) + i3) - Math.min(Math.min(i, i2), i3)) - Math.max(Math.max(i, i2), i3);
    }

    @Override // org.jcodec.common.SaveRestore
    public void restore() {
        int i = 0;
        while (true) {
            CAVLC[] cavlcArr = this.cavlc;
            if (i >= cavlcArr.length) {
                int[] iArr = this.mvTopX;
                this.mvTopX = this.mvTopXSave;
                this.mvTopXSave = iArr;
                int[] iArr2 = this.mvTopY;
                this.mvTopY = this.mvTopYSave;
                this.mvTopYSave = iArr2;
                this.mvLeftX = this.mvLeftXSave;
                this.mvLeftY = this.mvLeftYSave;
                this.mvTopLeftX = this.mvTopLeftXSave;
                this.mvTopLeftY = this.mvTopLeftYSave;
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
                int[] iArr = this.mvTopX;
                System.arraycopy(iArr, 0, this.mvTopXSave, 0, iArr.length);
                int[] iArr2 = this.mvTopY;
                System.arraycopy(iArr2, 0, this.mvTopYSave, 0, iArr2.length);
                this.mvLeftXSave = this.mvLeftX;
                this.mvLeftYSave = this.mvLeftY;
                this.mvTopLeftXSave = this.mvTopLeftX;
                this.mvTopLeftYSave = this.mvTopLeftY;
                return;
            }
            cavlcArr[i].save();
            i++;
        }
    }
}
