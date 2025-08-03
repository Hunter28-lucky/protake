package org.jcodec.common.dct;

/* loaded from: classes2.dex */
public class SimpleIDCT10Bit {
    public static final int C0 = 23170;
    public static final int C1 = 32138;
    public static final int C2 = 27246;
    public static final int C3 = 18205;
    public static final int C4 = 6393;
    public static final int C5 = 30274;
    public static final int C6 = 12540;
    public static int COL_SHIFT = 20;
    private static final int ROUND_COL = 8192;
    private static final int ROUND_ROW = 32768;
    public static int ROW_SHIFT = 15;
    private static final int SHIFT_COL = 14;
    private static final int SHIFT_ROW = 16;
    public static int W1 = 90901;
    public static int W2 = 85627;
    public static int W3 = 77062;
    public static int W4 = 65535;
    public static int W5 = 51491;
    public static int W6 = 35468;
    public static int W7 = 18081;

    private static void fdctCol(int[] iArr, int i) {
        int i2 = i + 0;
        int i3 = iArr[i2];
        int i4 = i + 56;
        int i5 = iArr[i4];
        int i6 = i3 - i5;
        int i7 = i + 8;
        int i8 = iArr[i7];
        int i9 = i + 48;
        int i10 = iArr[i9];
        int i11 = i8 - i10;
        int i12 = i + 16;
        int i13 = iArr[i12];
        int i14 = i + 40;
        int i15 = iArr[i14];
        int i16 = i13 - i15;
        int i17 = i + 24;
        int i18 = iArr[i17];
        int i19 = i + 32;
        int i20 = iArr[i19];
        int i21 = i18 - i20;
        int i22 = i3 + i5;
        int i23 = i18 + i20;
        int i24 = i8 + i10;
        int i25 = i13 + i15;
        int i26 = i22 - i23;
        int i27 = i24 - i25;
        int i28 = (i22 + i23) * C0;
        int i29 = (i24 + i25) * C0;
        int i30 = i26 * C5;
        int i31 = i27 * C6;
        int i32 = i26 * C6;
        int i33 = i27 * C5;
        iArr[i7] = (((((i6 * C1) + (i11 * C2)) + (i16 * C3)) + (i21 * C4)) + 8192) >> 14;
        iArr[i17] = (((((i6 * C2) - (i11 * C4)) - (i16 * C1)) - (i21 * C3)) + 8192) >> 14;
        iArr[i14] = (((((i6 * C3) - (i11 * C1)) + (i16 * C4)) + (i21 * C2)) + 8192) >> 14;
        iArr[i4] = (((((i6 * C4) - (i11 * C3)) + (i16 * C2)) - (i21 * C1)) + 8192) >> 14;
        iArr[i2] = ((i28 + i29) + 8192) >> 14;
        iArr[i12] = ((i30 + i31) + 8192) >> 14;
        iArr[i19] = ((i28 - i29) + 8192) >> 14;
        iArr[i9] = ((i32 - i33) + 8192) >> 14;
    }

    public static void fdctProres10(int[] iArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            fdctCol(iArr, i + i2);
        }
        for (int i3 = 0; i3 < 64; i3 += 8) {
            fdctRow(iArr, i + i3);
        }
    }

    private static void fdctRow(int[] iArr, int i) {
        int i2 = i + 0;
        int i3 = iArr[i2];
        int i4 = i + 7;
        int i5 = iArr[i4];
        int i6 = i3 - i5;
        int i7 = i + 1;
        int i8 = iArr[i7];
        int i9 = i + 6;
        int i10 = iArr[i9];
        int i11 = i8 - i10;
        int i12 = i + 2;
        int i13 = iArr[i12];
        int i14 = i + 5;
        int i15 = iArr[i14];
        int i16 = i13 - i15;
        int i17 = i + 3;
        int i18 = iArr[i17];
        int i19 = i + 4;
        int i20 = iArr[i19];
        int i21 = i18 - i20;
        int i22 = i3 + i5;
        int i23 = i18 + i20;
        int i24 = i8 + i10;
        int i25 = i13 + i15;
        int i26 = i22 - i23;
        int i27 = i24 - i25;
        int i28 = (i22 + i23) * C0;
        int i29 = (i24 + i25) * C0;
        int i30 = i26 * C5;
        int i31 = i27 * C6;
        int i32 = i26 * C6;
        int i33 = i27 * C5;
        iArr[i7] = (((((i6 * C1) + (i11 * C2)) + (i16 * C3)) + (i21 * C4)) + 32768) >> 16;
        iArr[i17] = (((((i6 * C2) - (i11 * C4)) - (i16 * C1)) - (i21 * C3)) + 32768) >> 16;
        iArr[i14] = (((((i6 * C3) - (i11 * C1)) + (i16 * C4)) + (i21 * C2)) + 32768) >> 16;
        iArr[i4] = (((((i6 * C4) - (i11 * C3)) + (i16 * C2)) - (i21 * C1)) + 32768) >> 16;
        iArr[i2] = ((i28 + i29) + 32768) >> 16;
        iArr[i12] = ((i30 + i31) + 32768) >> 16;
        iArr[i19] = ((i28 - i29) + 32768) >> 16;
        iArr[i9] = ((i32 - i33) + 32768) >> 16;
    }

    public static final void idct10(int[] iArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            idctRow(iArr, (i2 << 3) + i);
        }
        for (int i3 = 0; i3 < 8; i3++) {
            idctCol(iArr, i + i3);
        }
    }

    private static final void idctCol(int[] iArr, int i) {
        int i2 = W4;
        int i3 = iArr[i + 0];
        int i4 = COL_SHIFT;
        int i5 = (i3 + ((1 << (i4 - 1)) / i2)) * i2;
        int i6 = W2;
        int i7 = i + 16;
        int i8 = iArr[i7];
        int i9 = (i6 * i8) + i5;
        int i10 = W6;
        int i11 = (i10 * i8) + i5;
        int i12 = ((-i10) * i8) + i5;
        int i13 = i5 + ((-i6) * i8);
        int i14 = W1;
        int i15 = i + 8;
        int i16 = iArr[i15];
        int i17 = W3;
        int i18 = W5;
        int i19 = W7;
        int i20 = i + 24;
        int i21 = iArr[i20];
        int i22 = (i14 * i16) + (i17 * i21);
        int i23 = (i17 * i16) + ((-i19) * i21);
        int i24 = (i18 * i16) + ((-i14) * i21);
        int i25 = (i16 * i19) + ((-i18) * i21);
        int i26 = i + 32;
        int i27 = iArr[i26];
        if (i27 != 0) {
            i11 += (-i2) * i27;
            i12 += (-i2) * i27;
            i13 += i2 * i27;
            i9 += i2 * i27;
        }
        int i28 = i + 40;
        int i29 = iArr[i28];
        if (i29 != 0) {
            i23 += (-i14) * i29;
            i24 += i19 * i29;
            i25 += i29 * i17;
            i22 += i18 * i29;
        }
        int i30 = i + 48;
        int i31 = iArr[i30];
        if (i31 != 0) {
            i11 += (-i6) * i31;
            i12 += i6 * i31;
            i13 += (-i10) * i31;
            i9 += i10 * i31;
        }
        int i32 = i + 56;
        int i33 = iArr[i32];
        if (i33 != 0) {
            i22 += i19 * i33;
            i23 += (-i18) * i33;
            i24 += i17 * i33;
            i25 += (-i14) * i33;
        }
        iArr[i] = (i9 + i22) >> i4;
        iArr[i15] = (i11 + i23) >> i4;
        iArr[i7] = (i12 + i24) >> i4;
        iArr[i20] = (i13 + i25) >> i4;
        iArr[i26] = (i13 - i25) >> i4;
        iArr[i28] = (i12 - i24) >> i4;
        iArr[i30] = (i11 - i23) >> i4;
        iArr[i32] = (i9 - i22) >> i4;
    }

    private static final void idctRow(int[] iArr, int i) {
        int i2 = W4;
        int i3 = iArr[i] * i2;
        int i4 = ROW_SHIFT;
        int i5 = i3 + (1 << (i4 - 1));
        int i6 = W2;
        int i7 = i + 2;
        int i8 = iArr[i7];
        int i9 = (i6 * i8) + i5;
        int i10 = W6;
        int i11 = (i10 * i8) + i5;
        int i12 = i5 - (i10 * i8);
        int i13 = i5 - (i8 * i6);
        int i14 = W1;
        int i15 = i + 1;
        int i16 = iArr[i15];
        int i17 = W3;
        int i18 = i + 3;
        int i19 = iArr[i18];
        int i20 = (i14 * i16) + (i17 * i19);
        int i21 = W7;
        int i22 = (i17 * i16) + ((-i21) * i19);
        int i23 = W5;
        int i24 = (i23 * i16) + ((-i14) * i19);
        int i25 = (i16 * i21) + ((-i23) * i19);
        int i26 = i + 4;
        int i27 = iArr[i26];
        if (i27 != 0 || iArr[i + 5] != 0 || iArr[i + 6] != 0 || iArr[i + 7] != 0) {
            int i28 = iArr[i + 6];
            int i29 = i9 + (i2 * i27) + (i10 * i28);
            i11 += ((-i2) * i27) - (i6 * i28);
            i12 += ((-i2) * i27) + (i6 * i28);
            i13 += (i2 * i27) - (i10 * i28);
            int i30 = iArr[i + 5];
            int i31 = iArr[i + 7];
            i20 = i20 + (i23 * i30) + (i21 * i31);
            i22 = i22 + ((-i14) * i30) + ((-i23) * i31);
            i24 = i24 + (i21 * i30) + (i17 * i31);
            i25 = i25 + (i17 * i30) + ((-i14) * i31);
            i9 = i29;
        }
        iArr[i + 0] = (i9 + i20) >> i4;
        iArr[i + 7] = (i9 - i20) >> i4;
        iArr[i15] = (i11 + i22) >> i4;
        iArr[i + 6] = (i11 - i22) >> i4;
        iArr[i7] = (i12 + i24) >> i4;
        iArr[i + 5] = (i12 - i24) >> i4;
        iArr[i18] = (i13 + i25) >> i4;
        iArr[i26] = (i13 - i25) >> i4;
    }
}
