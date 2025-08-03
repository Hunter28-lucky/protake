package org.jcodec.codecs.h264.encode;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.decode.deblock.DeblockingFilter;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MBDeblocker {
    public static int[][] LOOKUP_IDX_P_V = {new int[]{3, 7, 11, 15}, new int[]{0, 4, 8, 12}, new int[]{1, 5, 9, 13}, new int[]{2, 6, 10, 14}};
    public static int[][] LOOKUP_IDX_Q_V = {new int[]{0, 4, 8, 12}, new int[]{1, 5, 9, 13}, new int[]{2, 6, 10, 14}, new int[]{3, 7, 11, 15}};
    public static int[][] LOOKUP_IDX_P_H = {new int[]{12, 13, 14, 15}, new int[]{0, 1, 2, 3}, new int[]{4, 5, 6, 7}, new int[]{8, 9, 10, 11}};
    public static int[][] LOOKUP_IDX_Q_H = {new int[]{0, 1, 2, 3}, new int[]{4, 5, 6, 7}, new int[]{8, 9, 10, 11}, new int[]{12, 13, 14, 15}};
    private static int[][] BS_I = {new int[]{4, 4, 4, 4}, new int[]{3, 3, 3, 3}, new int[]{3, 3, 3, 3}, new int[]{3, 3, 3, 3}};
    private static int[][] P_POS_V = buildPPosV();
    private static int[][] Q_POS_V = buildQPosV();
    private static int[][] P_POS_H = buildPPosH();
    private static int[][] Q_POS_H = buildQPosH();
    private static int[][] P_POS_V_CHR = buildPPosVChr();
    private static int[][] Q_POS_V_CHR = buildQPosVChr();
    private static int[][] P_POS_H_CHR = buildPPosHChr();
    private static int[][] Q_POS_H_CHR = buildQPosHChr();

    private static int[][] buildPPosH() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 16);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                iArr[i][i2] = (i << 6) + i2 + 48;
            }
        }
        return iArr;
    }

    private static int[][] buildPPosHChr() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 8);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                iArr[i][i2] = (i << 4) + i2 + 8;
            }
        }
        return iArr;
    }

    private static int[][] buildPPosV() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 16);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                iArr[i][i2] = (i2 << 4) + (i << 2) + 3;
            }
        }
        return iArr;
    }

    private static int[][] buildPPosVChr() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 8);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                iArr[i][i2] = (i2 << 3) + (i << 1) + 1;
            }
        }
        return iArr;
    }

    private static int[][] buildQPosH() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 16);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                iArr[i][i2] = (i << 6) + i2;
            }
        }
        return iArr;
    }

    private static int[][] buildQPosHChr() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 8);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                iArr[i][i2] = (i << 4) + i2;
            }
        }
        return iArr;
    }

    private static int[][] buildQPosV() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 16);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 16; i2++) {
                iArr[i][i2] = (i2 << 4) + (i << 2);
            }
        }
        return iArr;
    }

    private static int[][] buildQPosVChr() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 8);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                iArr[i][i2] = (i2 << 3) + (i << 1);
            }
        }
        return iArr;
    }

    public static void calcStrengthForBlocks(EncodedMB encodedMB, EncodedMB encodedMB2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        if (encodedMB2 != null) {
            for (int i = 0; i < 4; i++) {
                iArr[0][i] = encodedMB2.getType().isIntra() ? 4 : MathUtil.max3(strengthMv(encodedMB2.getMx()[iArr2[0][i]], encodedMB.getMx()[iArr3[0][i]]), strengthMv(encodedMB2.getMy()[iArr2[0][i]], encodedMB.getMy()[iArr3[0][i]]), strengthNc(encodedMB2.getNc()[iArr2[0][i]], encodedMB.getNc()[iArr3[0][i]]));
            }
        }
        for (int i2 = 1; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                iArr[i2][i3] = MathUtil.max3(strengthMv(encodedMB.getMx()[iArr2[i2][i3]], encodedMB.getMx()[iArr3[i2][i3]]), strengthMv(encodedMB.getMy()[iArr2[i2][i3]], encodedMB.getMy()[iArr3[i2][i3]]), strengthNc(encodedMB.getNc()[iArr2[i2][i3]], encodedMB.getNc()[iArr3[i2][i3]]));
            }
        }
    }

    private void deblockBorder(int[] iArr, int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[][] iArr2, int[][] iArr3, boolean z) {
        int i4 = z ? 16 : 1;
        int i5 = i4 * 2;
        int i6 = i4 * 3;
        for (int i7 = 0; i7 < 4; i7++) {
            int i8 = iArr[i7];
            if (i8 == 4) {
                int i9 = i7 << 2;
                int i10 = 0;
                while (i10 < 4) {
                    int i11 = iArr2[i2][i9];
                    int i12 = iArr3[i3][i9];
                    filterBs4(i, i, bArr, bArr2, i11 - i6, i11 - i5, i11 - i4, i11, i12, i12 + i4, i12 + i5, i12 + i6);
                    i10++;
                    i9++;
                }
            } else if (i8 > 0) {
                int i13 = i7 << 2;
                int i14 = 0;
                while (i14 < 4) {
                    int i15 = iArr[i7];
                    int i16 = iArr2[i2][i13];
                    int i17 = iArr3[i3][i13];
                    filterBs(i15, i, i, bArr, bArr2, i16 - i5, i16 - i4, i16, i17, i17 + i4, i17 + i5);
                    i14++;
                    i13++;
                }
            }
        }
    }

    private void deblockBorderChroma(int[] iArr, int i, byte[] bArr, int i2, byte[] bArr2, int i3, int[][] iArr2, int[][] iArr3, boolean z) {
        int i4 = z ? 8 : 1;
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = iArr[i5];
            if (i6 == 4) {
                int i7 = i5 << 1;
                int i8 = 0;
                while (i8 < 2) {
                    int i9 = iArr2[i2][i7];
                    int i10 = iArr3[i3][i7];
                    filterBs4Chr(i, i, bArr, bArr2, i9 - i4, i9, i10, i10 + i4);
                    i8++;
                    i7++;
                }
            } else if (i6 > 0) {
                int i11 = i5 << 1;
                int i12 = 0;
                while (i12 < 2) {
                    int i13 = iArr[i5];
                    int i14 = iArr2[i2][i11];
                    int i15 = iArr3[i3][i11];
                    filterBsChr(i13, i, i, bArr, bArr2, i14 - i4, i14, i15, i15 + i4);
                    i12++;
                    i11++;
                }
            }
        }
    }

    private static int strengthMv(int i, int i2) {
        return Math.abs(i - i2) >= 4 ? 1 : 0;
    }

    private static int strengthNc(int i, int i2) {
        return (i > 0 || i2 > 0) ? 2 : 0;
    }

    public void _filterBs(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        int i10;
        boolean z2;
        byte b = bArr[i5];
        byte b2 = bArr[i6];
        byte b3 = bArr2[i7];
        byte b4 = bArr2[i8];
        int i11 = DeblockingFilter.alphaTab[i2];
        int i12 = DeblockingFilter.betaTab[i3];
        if (Math.abs(b2 - b3) < i11 && Math.abs(b - b2) < i12 && Math.abs(b4 - b3) < i12) {
            int i13 = DeblockingFilter.tcs[i - 1][i2];
            if (z) {
                i10 = i13 + 1;
                z2 = false;
            } else {
                int iAbs = Math.abs(bArr[i4] - b2);
                int iAbs2 = Math.abs(bArr2[i9] - b3);
                i10 = (iAbs < i12 ? 1 : 0) + i13 + (iAbs2 < i12 ? 1 : 0);
                boolean z3 = iAbs < i12;
                z2 = iAbs2 < i12;
                z = z3;
            }
            int i14 = ((((b3 - b2) << 2) + (b - b4)) + 4) >> 3;
            int i15 = -i10;
            if (i14 < i15) {
                i10 = i15;
            } else if (i14 <= i10) {
                i10 = i14;
            }
            int i16 = b2 + i10;
            if (i16 < -128) {
                i16 = -128;
            }
            int i17 = b3 - i10;
            if (i17 < -128) {
                i17 = -128;
            }
            if (z) {
                int i18 = ((bArr[i4] + (((b2 + b3) + 1) >> 1)) - (b << 1)) >> 1;
                int i19 = -i13;
                if (i18 < i19) {
                    i18 = i19;
                } else if (i18 > i13) {
                    i18 = i13;
                }
                bArr[i5] = (byte) MathUtil.clip(b + i18, -128, 127);
            }
            if (z2) {
                int i20 = ((bArr2[i9] + (((b2 + b3) + 1) >> 1)) - (b4 << 1)) >> 1;
                int i21 = -i13;
                if (i20 < i21) {
                    i13 = i21;
                } else if (i20 <= i13) {
                    i13 = i20;
                }
                bArr2[i8] = (byte) MathUtil.clip(b4 + i13, -128, 127);
            }
            bArr2[i7] = (byte) MathUtil.clip(i17, -128, 127);
            bArr[i6] = (byte) MathUtil.clip(i16, -128, 127);
        }
    }

    public void _filterBs4(int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z) {
        boolean z2;
        byte b = bArr[i6];
        byte b2 = bArr2[i7];
        byte b3 = bArr[i5];
        byte b4 = bArr2[i8];
        int i11 = DeblockingFilter.alphaTab[i];
        int i12 = DeblockingFilter.betaTab[i2];
        int i13 = b - b2;
        boolean z3 = false;
        if (Math.abs(i13) < i11 && Math.abs(b3 - b) < i12 && Math.abs(b4 - b2) < i12) {
            if (z) {
                z2 = false;
            } else {
                int iAbs = Math.abs(bArr[i4] - b);
                int iAbs2 = Math.abs(bArr2[i9] - b2);
                boolean z4 = iAbs < i12 && Math.abs(i13) < (i11 >> 2) + 2;
                z2 = iAbs2 < i12 && Math.abs(i13) < (i11 >> 2) + 2;
                z3 = z4;
            }
            if (z3) {
                byte b5 = bArr[i3];
                byte b6 = bArr[i4];
                bArr[i6] = (byte) MathUtil.clip(((((((b3 * 2) + b6) + (b * 2)) + (b2 * 2)) + b4) + 4) >> 3, -128, 127);
                bArr[i5] = (byte) MathUtil.clip(((((b6 + b3) + b) + b2) + 2) >> 2, -128, 127);
                bArr[i4] = (byte) MathUtil.clip(((((((b5 * 2) + (b6 * 3)) + b3) + b) + b2) + 4) >> 3, -128, 127);
            } else {
                bArr[i6] = (byte) MathUtil.clip(((((b3 * 2) + b) + b4) + 2) >> 2, -128, 127);
            }
            if (!z2 || z) {
                bArr2[i7] = (byte) MathUtil.clip(((((b4 * 2) + b2) + b3) + 2) >> 2, -128, 127);
                return;
            }
            byte b7 = bArr2[i9];
            int i14 = (((((b3 + (b * 2)) + (b2 * 2)) + (b4 * 2)) + b7) + 4) >> 3;
            int i15 = ((((b + b2) + b4) + b7) + 2) >> 2;
            int i16 = ((((((bArr2[i10] * 2) + (b7 * 3)) + b4) + b2) + b) + 4) >> 3;
            bArr2[i7] = (byte) MathUtil.clip(i14, -128, 127);
            bArr2[i8] = (byte) MathUtil.clip(i15, -128, 127);
            bArr2[i9] = (byte) MathUtil.clip(i16, -128, 127);
        }
    }

    public void deblockMBGeneric(EncodedMB encodedMB, EncodedMB encodedMB2, EncodedMB encodedMB3, int[][] iArr, int[][] iArr2) {
        Picture pixels = encodedMB.getPixels();
        if (encodedMB2 != null) {
            Picture pixels2 = encodedMB2.getPixels();
            int iClip = MathUtil.clip(((encodedMB2.getQp() + encodedMB.getQp()) + 1) >> 1, 0, 51);
            deblockBorder(iArr[0], iClip, pixels2.getPlaneData(0), 3, pixels.getPlaneData(0), 0, P_POS_V, Q_POS_V, false);
            deblockBorderChroma(iArr[0], iClip, pixels2.getPlaneData(1), 3, pixels.getPlaneData(1), 0, P_POS_V_CHR, Q_POS_V_CHR, false);
            deblockBorderChroma(iArr[0], iClip, pixels2.getPlaneData(2), 3, pixels.getPlaneData(2), 0, P_POS_V_CHR, Q_POS_V_CHR, false);
        }
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            int i3 = i;
            deblockBorder(iArr[i2], encodedMB.getQp(), pixels.getPlaneData(0), i3, pixels.getPlaneData(0), i2, P_POS_V, Q_POS_V, false);
            deblockBorderChroma(iArr[i2], encodedMB.getQp(), pixels.getPlaneData(1), i3, pixels.getPlaneData(1), i2, P_POS_V_CHR, Q_POS_V_CHR, false);
            deblockBorderChroma(iArr[i2], encodedMB.getQp(), pixels.getPlaneData(2), i3, pixels.getPlaneData(2), i2, P_POS_V_CHR, Q_POS_V_CHR, false);
            i = i2;
        }
        if (encodedMB3 != null) {
            Picture pixels3 = encodedMB3.getPixels();
            int iClip2 = MathUtil.clip(((encodedMB3.getQp() + encodedMB.getQp()) + 1) >> 1, 0, 51);
            deblockBorder(iArr2[0], iClip2, pixels3.getPlaneData(0), 3, pixels.getPlaneData(0), 0, P_POS_H, Q_POS_H, true);
            deblockBorderChroma(iArr2[0], iClip2, pixels3.getPlaneData(1), 3, pixels.getPlaneData(1), 0, P_POS_H_CHR, Q_POS_H_CHR, true);
            deblockBorderChroma(iArr2[0], iClip2, pixels3.getPlaneData(2), 3, pixels.getPlaneData(2), 0, P_POS_H_CHR, Q_POS_H_CHR, true);
        }
        int i4 = 0;
        while (i4 < 3) {
            int i5 = i4 + 1;
            int i6 = i4;
            deblockBorder(iArr2[i5], encodedMB.getQp(), pixels.getPlaneData(0), i6, pixels.getPlaneData(0), i5, P_POS_H, Q_POS_H, true);
            deblockBorderChroma(iArr2[i5], encodedMB.getQp(), pixels.getPlaneData(1), i6, pixels.getPlaneData(1), i5, P_POS_H_CHR, Q_POS_H_CHR, true);
            deblockBorderChroma(iArr2[i5], encodedMB.getQp(), pixels.getPlaneData(2), i6, pixels.getPlaneData(2), i5, P_POS_H_CHR, Q_POS_H_CHR, true);
            i4 = i5;
        }
    }

    public void deblockMBI(EncodedMB encodedMB, EncodedMB encodedMB2, EncodedMB encodedMB3) {
        int[][] iArr = BS_I;
        deblockMBGeneric(encodedMB, encodedMB2, encodedMB3, iArr, iArr);
    }

    public void deblockMBP(EncodedMB encodedMB, EncodedMB encodedMB2, EncodedMB encodedMB3) {
        Class cls = Integer.TYPE;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, 4, 4);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, 4, 4);
        calcStrengthForBlocks(encodedMB, encodedMB2, iArr, LOOKUP_IDX_P_V, LOOKUP_IDX_Q_V);
        calcStrengthForBlocks(encodedMB, encodedMB3, iArr2, LOOKUP_IDX_P_H, LOOKUP_IDX_Q_H);
        deblockMBGeneric(encodedMB, encodedMB2, encodedMB3, iArr, iArr2);
    }

    public void filterBs(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, int i8, int i9) {
        _filterBs(i, i2, i3, bArr, bArr2, i4, i5, i6, i7, i8, i9, false);
    }

    public void filterBs4(int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        _filterBs4(i, i2, bArr, bArr2, i3, i4, i5, i6, i7, i8, i9, i10, false);
    }

    public void filterBs4Chr(int i, int i2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5, int i6) {
        _filterBs4(i, i2, bArr, bArr2, -1, -1, i3, i4, i5, i6, -1, -1, true);
    }

    public void filterBsChr(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7) {
        _filterBs(i, i2, i3, bArr, bArr2, -1, i4, i5, i6, i7, -1, true);
    }
}
