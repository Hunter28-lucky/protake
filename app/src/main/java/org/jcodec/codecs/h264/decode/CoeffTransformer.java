package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.common.ArrayUtil;

/* loaded from: classes2.dex */
public class CoeffTransformer {
    private static final int[][] quantCoeff;
    public static int[] zigzag4x4 = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};
    public static int[] invZigzag4x4 = new int[16];
    public static int[][] dequantCoef = {new int[]{10, 13, 10, 13, 13, 16, 13, 16, 10, 13, 10, 13, 13, 16, 13, 16}, new int[]{11, 14, 11, 14, 14, 18, 14, 18, 11, 14, 11, 14, 14, 18, 14, 18}, new int[]{13, 16, 13, 16, 16, 20, 16, 20, 13, 16, 13, 16, 16, 20, 16, 20}, new int[]{14, 18, 14, 18, 18, 23, 18, 23, 14, 18, 14, 18, 18, 23, 18, 23}, new int[]{16, 20, 16, 20, 20, 25, 20, 25, 16, 20, 16, 20, 20, 25, 20, 25}, new int[]{18, 23, 18, 23, 23, 29, 23, 29, 18, 23, 18, 23, 23, 29, 23, 29}};
    public static int[][] dequantCoef8x8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 64);
    public static int[][] initDequantCoeff8x8 = {new int[]{20, 18, 32, 19, 25, 24}, new int[]{22, 19, 35, 21, 28, 26}, new int[]{26, 23, 42, 24, 33, 31}, new int[]{28, 25, 45, 26, 35, 33}, new int[]{32, 28, 51, 30, 40, 38}, new int[]{36, 32, 58, 34, 46, 43}};
    public static int[] zigzag8x8 = {0, 1, 8, 16, 9, 2, 3, 10, 17, 24, 32, 25, 18, 11, 4, 5, 12, 19, 26, 33, 40, 48, 41, 34, 27, 20, 13, 6, 7, 14, 21, 28, 35, 42, 49, 56, 57, 50, 43, 36, 29, 22, 15, 23, 30, 37, 44, 51, 58, 59, 52, 45, 38, 31, 39, 46, 53, 60, 61, 54, 47, 55, 62, 63};
    public static int[] invZigzag8x8 = new int[64];

    static {
        for (int i = 0; i < 16; i++) {
            invZigzag4x4[zigzag4x4[i]] = i;
        }
        for (int i2 = 0; i2 < 64; i2++) {
            invZigzag8x8[zigzag8x8[i2]] = i2;
        }
        quantCoeff = new int[][]{new int[]{13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243, 13107, 8066, 13107, 8066, 8066, 5243, 8066, 5243}, new int[]{11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660, 11916, 7490, 11916, 7490, 7490, 4660, 7490, 4660}, new int[]{10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194, 10082, 6554, 10082, 6554, 6554, 4194, 6554, 4194}, new int[]{9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647, 9362, 5825, 9362, 5825, 5825, 3647, 5825, 3647}, new int[]{8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355, 8192, 5243, 8192, 5243, 5243, 3355, 5243, 3355}, new int[]{7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893, 7282, 4559, 7282, 4559, 4559, 2893, 4559, 2893}};
        for (int i3 = 0; i3 < 6; i3++) {
            Arrays.fill(dequantCoef8x8[i3], initDequantCoeff8x8[i3][5]);
            for (int i4 = 0; i4 < 8; i4 += 4) {
                for (int i5 = 0; i5 < 8; i5 += 4) {
                    dequantCoef8x8[i3][(i4 << 3) + i5] = initDequantCoeff8x8[i3][0];
                }
            }
            for (int i6 = 1; i6 < 8; i6 += 2) {
                for (int i7 = 1; i7 < 8; i7 += 2) {
                    dequantCoef8x8[i3][(i6 << 3) + i7] = initDequantCoeff8x8[i3][1];
                }
            }
            for (int i8 = 2; i8 < 8; i8 += 4) {
                for (int i9 = 2; i9 < 8; i9 += 4) {
                    dequantCoef8x8[i3][(i8 << 3) + i9] = initDequantCoeff8x8[i3][2];
                }
            }
            for (int i10 = 0; i10 < 8; i10 += 4) {
                for (int i11 = 1; i11 < 8; i11 += 2) {
                    dequantCoef8x8[i3][(i10 << 3) + i11] = initDequantCoeff8x8[i3][3];
                }
            }
            for (int i12 = 1; i12 < 8; i12 += 2) {
                for (int i13 = 0; i13 < 8; i13 += 4) {
                    dequantCoef8x8[i3][(i12 << 3) + i13] = initDequantCoeff8x8[i3][3];
                }
            }
            for (int i14 = 0; i14 < 8; i14 += 4) {
                for (int i15 = 2; i15 < 8; i15 += 4) {
                    dequantCoef8x8[i3][(i14 << 3) + i15] = initDequantCoeff8x8[i3][4];
                }
            }
            for (int i16 = 2; i16 < 8; i16 += 4) {
                for (int i17 = 0; i17 < 8; i17 += 4) {
                    dequantCoef8x8[i3][(i16 << 3) + i17] = initDequantCoeff8x8[i3][4];
                }
            }
        }
    }

    public static final void _idct4x4(int[] iArr, int[] iArr2) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = iArr[i];
            int i3 = i + 2;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i2 - i4;
            int i7 = i + 1;
            int i8 = iArr[i7];
            int i9 = i + 3;
            int i10 = iArr[i9];
            int i11 = (i8 >> 1) - i10;
            int i12 = i8 + (i10 >> 1);
            iArr2[i] = i5 + i12;
            iArr2[i7] = i6 + i11;
            iArr2[i3] = i6 - i11;
            iArr2[i9] = i5 - i12;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = iArr2[i13];
            int i15 = i13 + 8;
            int i16 = iArr2[i15];
            int i17 = i14 + i16;
            int i18 = i14 - i16;
            int i19 = i13 + 4;
            int i20 = iArr2[i19];
            int i21 = i13 + 12;
            int i22 = iArr2[i21];
            int i23 = (i20 >> 1) - i22;
            int i24 = i20 + (i22 >> 1);
            iArr2[i13] = i17 + i24;
            iArr2[i19] = i18 + i23;
            iArr2[i15] = i18 - i23;
            iArr2[i21] = i17 - i24;
        }
        for (int i25 = 0; i25 < 16; i25++) {
            iArr2[i25] = (iArr2[i25] + 32) >> 6;
        }
    }

    public static void dequantizeAC(int[] iArr, int i, int[] iArr2) {
        int i2 = i % 6;
        int i3 = 0;
        if (iArr2 == null) {
            int i4 = i / 6;
            while (i3 < 16) {
                iArr[i3] = (iArr[i3] * dequantCoef[i2][i3]) << i4;
                i3++;
            }
            return;
        }
        if (i >= 24) {
            int i5 = (i / 6) - 4;
            while (i3 < 16) {
                iArr[i3] = ((iArr[i3] * dequantCoef[i2][i3]) * iArr2[invZigzag4x4[i3]]) << i5;
                i3++;
            }
            return;
        }
        int i6 = i / 6;
        int i7 = 4 - i6;
        int i8 = 1 << (3 - i6);
        while (i3 < 16) {
            iArr[i3] = (((iArr[i3] * iArr2[invZigzag4x4[i3]]) * dequantCoef[i2][i3]) + i8) >> i7;
            i3++;
        }
    }

    public static void dequantizeAC8x8(int[] iArr, int i, int[] iArr2) {
        int i2 = i % 6;
        int i3 = 0;
        if (i >= 36) {
            int i4 = (i / 6) - 6;
            if (iArr2 == null) {
                while (i3 < 64) {
                    iArr[i3] = ((iArr[i3] * dequantCoef8x8[i2][i3]) << 4) << i4;
                    i3++;
                }
                return;
            } else {
                while (i3 < 64) {
                    iArr[i3] = ((iArr[i3] * dequantCoef8x8[i2][i3]) * iArr2[invZigzag8x8[i3]]) << i4;
                    i3++;
                }
                return;
            }
        }
        int i5 = i / 6;
        int i6 = 6 - i5;
        int i7 = 1 << (5 - i5);
        if (iArr2 == null) {
            while (i3 < 64) {
                iArr[i3] = ((iArr[i3] * (dequantCoef8x8[i2][i3] << 4)) + i7) >> i6;
                i3++;
            }
        } else {
            while (i3 < 64) {
                iArr[i3] = (((iArr[i3] * dequantCoef8x8[i2][i3]) * iArr2[invZigzag8x8[i3]]) + i7) >> i6;
                i3++;
            }
        }
    }

    public static void dequantizeDC2x2(int[] iArr, int i, int[] iArr2) {
        int i2 = i % 6;
        if (iArr2 == null) {
            int i3 = i / 6;
            for (int i4 = 0; i4 < 4; i4++) {
                iArr[i4] = ((iArr[i4] * dequantCoef[i2][0]) << i3) >> 1;
            }
            return;
        }
        if (i >= 24) {
            int i5 = (i / 6) - 4;
            for (int i6 = 0; i6 < 4; i6++) {
                iArr[i6] = (((iArr[i6] * dequantCoef[i2][0]) * iArr2[0]) << i5) >> 1;
            }
            return;
        }
        int i7 = i / 6;
        int i8 = 4 - i7;
        int i9 = 1 << (3 - i7);
        for (int i10 = 0; i10 < 4; i10++) {
            iArr[i10] = ((((iArr[i10] * dequantCoef[i2][0]) * iArr2[0]) + i9) >> i8) >> 1;
        }
    }

    public static void dequantizeDC4x2(int[] iArr, int i) {
    }

    public static void dequantizeDC4x4(int[] iArr, int i, int[] iArr2) {
        int i2 = i % 6;
        if (i >= 36) {
            int i3 = (i / 6) - 6;
            if (iArr2 == null) {
                for (int i4 = 0; i4 < 16; i4++) {
                    iArr[i4] = (iArr[i4] * (dequantCoef[i2][0] << 4)) << i3;
                }
                return;
            }
            for (int i5 = 0; i5 < 16; i5++) {
                iArr[i5] = ((iArr[i5] * dequantCoef[i2][0]) * iArr2[0]) << i3;
            }
            return;
        }
        int i6 = i / 6;
        int i7 = 6 - i6;
        int i8 = 1 << (5 - i6);
        if (iArr2 == null) {
            for (int i9 = 0; i9 < 16; i9++) {
                iArr[i9] = ((iArr[i9] * (dequantCoef[i2][0] << 4)) + i8) >> i7;
            }
            return;
        }
        for (int i10 = 0; i10 < 16; i10++) {
            iArr[i10] = (((iArr[i10] * dequantCoef[i2][0]) * iArr2[0]) + i8) >> i7;
        }
    }

    public static void fdct4x4(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = iArr[i];
            int i3 = i + 3;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i + 1;
            int i7 = iArr[i6];
            int i8 = i + 2;
            int i9 = iArr[i8];
            int i10 = i7 + i9;
            int i11 = i7 - i9;
            int i12 = i2 - i4;
            iArr[i] = i5 + i10;
            iArr[i6] = (i12 << 1) + i11;
            iArr[i8] = i5 - i10;
            iArr[i3] = i12 - (i11 << 1);
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = iArr[i13];
            int i15 = i13 + 12;
            int i16 = iArr[i15];
            int i17 = i14 + i16;
            int i18 = i13 + 4;
            int i19 = iArr[i18];
            int i20 = i13 + 8;
            int i21 = iArr[i20];
            int i22 = i19 + i21;
            int i23 = i19 - i21;
            int i24 = i14 - i16;
            iArr[i13] = i17 + i22;
            iArr[i18] = (i24 << 1) + i23;
            iArr[i20] = i17 - i22;
            iArr[i15] = i24 - (i23 << 1);
        }
    }

    public static void fvdDC2x2(int[] iArr) {
        invDC2x2(iArr);
    }

    public static void fvdDC4x2(int[] iArr) {
    }

    public static void fvdDC4x4(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = iArr[i];
            int i3 = i + 3;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i + 1;
            int i7 = iArr[i6];
            int i8 = i + 2;
            int i9 = iArr[i8];
            int i10 = i7 + i9;
            int i11 = i7 - i9;
            int i12 = i2 - i4;
            iArr[i] = i5 + i10;
            iArr[i6] = i12 + i11;
            iArr[i8] = i5 - i10;
            iArr[i3] = i12 - i11;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = iArr[i13];
            int i15 = i13 + 12;
            int i16 = iArr[i15];
            int i17 = i14 + i16;
            int i18 = i13 + 4;
            int i19 = iArr[i18];
            int i20 = i13 + 8;
            int i21 = iArr[i20];
            int i22 = i19 + i21;
            int i23 = i19 - i21;
            int i24 = i14 - i16;
            iArr[i13] = (i17 + i22) >> 1;
            iArr[i18] = (i23 + i24) >> 1;
            iArr[i20] = (i17 - i22) >> 1;
            iArr[i15] = (i24 - i23) >> 1;
        }
    }

    public static final void idct4x4(int[] iArr) {
        _idct4x4(iArr, iArr);
    }

    public static void idct8x8(int[] iArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 8) {
                break;
            }
            int i4 = iArr[i3];
            int i5 = i3 + 4;
            int i6 = iArr[i5];
            int i7 = i4 + i6;
            int i8 = i3 + 3;
            int i9 = iArr[i8];
            int i10 = i3 + 5;
            int i11 = iArr[i10];
            int i12 = i3 + 7;
            int i13 = iArr[i12];
            int i14 = (((-i9) + i11) - i13) - (i13 >> 1);
            int i15 = i4 - i6;
            int i16 = i3 + 1;
            int i17 = iArr[i16];
            int i18 = ((i17 + i13) - i9) - (i9 >> 1);
            int i19 = i3 + 2;
            int i20 = iArr[i19];
            int i21 = i3 + 6;
            int i22 = iArr[i21];
            int i23 = (i20 >> 1) - i22;
            int i24 = (-i17) + i13 + i11 + (i11 >> 1);
            int i25 = i20 + (i22 >> 1);
            int i26 = i9 + i11 + i17 + (i17 >> 1);
            int i27 = i7 + i25;
            int i28 = (i26 >> 2) + i14;
            int i29 = i15 + i23;
            int i30 = i18 + (i24 >> 2);
            int i31 = i15 - i23;
            int i32 = (i18 >> 2) - i24;
            int i33 = i7 - i25;
            int i34 = i26 - (i14 >> 2);
            iArr[i3] = i27 + i34;
            iArr[i16] = i29 + i32;
            iArr[i19] = i31 + i30;
            iArr[i8] = i33 + i28;
            iArr[i5] = i33 - i28;
            iArr[i10] = i31 - i30;
            iArr[i21] = i29 - i32;
            iArr[i12] = i27 - i34;
            i3 += 8;
            i2++;
        }
        int i35 = 0;
        for (i = 8; i35 < i; i = 8) {
            int i36 = iArr[i35];
            int i37 = i35 + 32;
            int i38 = iArr[i37];
            int i39 = i36 + i38;
            int i40 = i35 + 24;
            int i41 = iArr[i40];
            int i42 = i35 + 40;
            int i43 = iArr[i42];
            int i44 = i35 + 56;
            int i45 = iArr[i44];
            int i46 = (((-i41) + i43) - i45) - (i45 >> 1);
            int i47 = i36 - i38;
            int i48 = i35 + 8;
            int i49 = iArr[i48];
            int i50 = ((i49 + i45) - i41) - (i41 >> 1);
            int i51 = i35 + 16;
            int i52 = iArr[i51];
            int i53 = i35 + 48;
            int i54 = iArr[i53];
            int i55 = (i52 >> 1) - i54;
            int i56 = (-i49) + i45 + i43 + (i43 >> 1);
            int i57 = i52 + (i54 >> 1);
            int i58 = i41 + i43 + i49 + (i49 >> 1);
            int i59 = i39 + i57;
            int i60 = (i58 >> 2) + i46;
            int i61 = i47 + i55;
            int i62 = i50 + (i56 >> 2);
            int i63 = i47 - i55;
            int i64 = (i50 >> 2) - i56;
            int i65 = i39 - i57;
            int i66 = i58 - (i46 >> 2);
            iArr[i35] = i59 + i66;
            iArr[i48] = i61 + i64;
            iArr[i51] = i63 + i62;
            iArr[i40] = i65 + i60;
            iArr[i37] = i65 - i60;
            iArr[i42] = i63 - i62;
            iArr[i53] = i61 - i64;
            iArr[i44] = i59 - i66;
            i35++;
        }
        for (int i67 = 0; i67 < 64; i67++) {
            iArr[i67] = (iArr[i67] + 32) >> 6;
        }
    }

    public static void invDC2x2(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i + i2;
        int i4 = i - i2;
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = i5 + i6;
        int i8 = i5 - i6;
        iArr[0] = i3 + i7;
        iArr[1] = i4 + i8;
        iArr[2] = i3 - i7;
        iArr[3] = i4 - i8;
    }

    public static void invDC4x2(int[] iArr) {
    }

    public static void invDC4x4(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = iArr[i];
            int i3 = i + 2;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i2 - i4;
            int i7 = i + 1;
            int i8 = iArr[i7];
            int i9 = i + 3;
            int i10 = iArr[i9];
            int i11 = i8 - i10;
            int i12 = i8 + i10;
            iArr[i] = i5 + i12;
            iArr[i7] = i6 + i11;
            iArr[i3] = i6 - i11;
            iArr[i9] = i5 - i12;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = iArr[i13];
            int i15 = i13 + 8;
            int i16 = iArr[i15];
            int i17 = i14 + i16;
            int i18 = i14 - i16;
            int i19 = i13 + 4;
            int i20 = iArr[i19];
            int i21 = i13 + 12;
            int i22 = iArr[i21];
            int i23 = i20 - i22;
            int i24 = i20 + i22;
            iArr[i13] = i17 + i24;
            iArr[i19] = i18 + i23;
            iArr[i15] = i18 - i23;
            iArr[i21] = i17 - i24;
        }
    }

    public static void quantizeAC(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 4);
        int i5 = i2 + 15;
        int i6 = 0;
        if (i < 10) {
            while (i6 < 16) {
                int i7 = iArr[i6];
                int i8 = i7 >> 31;
                iArr[i6] = (Math.min(((((i7 ^ i8) - i8) * quantCoeff[i3][i6]) + i4) >> i5, 2063) ^ i8) - i8;
                i6++;
            }
            return;
        }
        while (i6 < 16) {
            int i9 = iArr[i6];
            int i10 = i9 >> 31;
            iArr[i6] = ((((((i9 ^ i10) - i10) * quantCoeff[i3][i6]) + i4) >> i5) ^ i10) - i10;
            i6++;
        }
    }

    public static void quantizeDC2x2(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 5);
        int i5 = i2 + 16;
        if (i < 4) {
            for (int i6 = 0; i6 < 4; i6++) {
                int i7 = iArr[i6];
                int i8 = i7 >> 31;
                iArr[i6] = (Math.min(((((i7 ^ i8) - i8) * quantCoeff[i3][0]) + i4) >> i5, 2063) ^ i8) - i8;
            }
            return;
        }
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = iArr[i9];
            int i11 = i10 >> 31;
            iArr[i9] = ((((((i10 ^ i11) - i11) * quantCoeff[i3][0]) + i4) >> i5) ^ i11) - i11;
        }
    }

    public static void quantizeDC4x2(int[] iArr, int i) {
    }

    public static void quantizeDC4x4(int[] iArr, int i) {
        int i2 = i / 6;
        int i3 = i % 6;
        int i4 = 682 << (i2 + 5);
        int i5 = i2 + 16;
        if (i < 10) {
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = iArr[i6];
                int i8 = i7 >> 31;
                iArr[i6] = (Math.min(((((i7 ^ i8) - i8) * quantCoeff[i3][0]) + i4) >> i5, 2063) ^ i8) - i8;
            }
            return;
        }
        for (int i9 = 0; i9 < 16; i9++) {
            int i10 = iArr[i9];
            int i11 = i10 >> 31;
            iArr[i9] = ((((((i10 ^ i11) - i11) * quantCoeff[i3][0]) + i4) >> i5) ^ i11) - i11;
        }
    }

    public static void reorderDC4x4(int[] iArr) {
        ArrayUtil.swap(iArr, 2, 4);
        ArrayUtil.swap(iArr, 3, 5);
        ArrayUtil.swap(iArr, 10, 12);
        ArrayUtil.swap(iArr, 11, 13);
    }
}
