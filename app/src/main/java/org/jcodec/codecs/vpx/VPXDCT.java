package org.jcodec.codecs.vpx;

/* loaded from: classes2.dex */
public class VPXDCT {
    public static int cospi8sqrt2minus1 = 20091;
    public static int sinpi8sqrt2 = 35468;

    public static void fdct4x4(int[] iArr) {
        for (int i = 0; i < 16; i += 4) {
            int i2 = iArr[i];
            int i3 = i + 3;
            int i4 = iArr[i3];
            int i5 = (i2 + i4) << 3;
            int i6 = i + 1;
            int i7 = iArr[i6];
            int i8 = i + 2;
            int i9 = iArr[i8];
            int i10 = (i7 + i9) << 3;
            int i11 = (i7 - i9) << 3;
            int i12 = (i2 - i4) << 3;
            iArr[i] = i5 + i10;
            iArr[i8] = i5 - i10;
            iArr[i6] = (((i11 * 2217) + (i12 * 5352)) + 14500) >> 12;
            iArr[i3] = (((i12 * 2217) - (i11 * 5352)) + 7500) >> 12;
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
            iArr[i13] = ((i17 + i22) + 7) >> 4;
            iArr[i20] = ((i17 - i22) + 7) >> 4;
            iArr[i18] = ((((i23 * 2217) + (i24 * 5352)) + 12000) >> 16) + (i24 != 0 ? 1 : 0);
            iArr[i15] = (((i24 * 2217) - (i23 * 5352)) + 51000) >> 16;
        }
    }

    public static void idct4x4(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            int i3 = i + 8;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i2 - i4;
            int i7 = i + 4;
            int i8 = iArr[i7];
            int i9 = sinpi8sqrt2;
            int i10 = i + 12;
            int i11 = iArr[i10];
            int i12 = cospi8sqrt2minus1;
            int i13 = ((i8 * i9) >> 16) - (((i11 * i12) >> 16) + i11);
            int i14 = i8 + ((i12 * i8) >> 16) + ((i11 * i9) >> 16);
            iArr[i] = i5 + i14;
            iArr[i10] = i5 - i14;
            iArr[i7] = i6 + i13;
            iArr[i3] = i6 - i13;
        }
        for (int i15 = 0; i15 < 16; i15 += 4) {
            int i16 = iArr[i15];
            int i17 = i15 + 2;
            int i18 = iArr[i17];
            int i19 = i16 + i18;
            int i20 = i16 - i18;
            int i21 = i15 + 1;
            int i22 = iArr[i21];
            int i23 = sinpi8sqrt2;
            int i24 = i15 + 3;
            int i25 = iArr[i24];
            int i26 = cospi8sqrt2minus1;
            int i27 = ((i22 * i23) >> 16) - (((i25 * i26) >> 16) + i25);
            int i28 = i22 + ((i26 * i22) >> 16) + ((i25 * i23) >> 16);
            iArr[i15] = ((i19 + i28) + 4) >> 3;
            iArr[i24] = ((i19 - i28) + 4) >> 3;
            iArr[i21] = ((i20 + i27) + 4) >> 3;
            iArr[i17] = ((i20 - i27) + 4) >> 3;
        }
    }

    public static void iwalsh4x4(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            int i3 = i + 12;
            int i4 = iArr[i3];
            int i5 = i2 + i4;
            int i6 = i + 4;
            int i7 = iArr[i6];
            int i8 = i + 8;
            int i9 = iArr[i8];
            int i10 = i7 + i9;
            int i11 = i7 - i9;
            int i12 = i2 - i4;
            iArr[i] = i5 + i10;
            iArr[i6] = i11 + i12;
            iArr[i8] = i5 - i10;
            iArr[i3] = i12 - i11;
        }
        for (int i13 = 0; i13 < 16; i13 += 4) {
            int i14 = iArr[i13];
            int i15 = i13 + 3;
            int i16 = iArr[i15];
            int i17 = i14 + i16;
            int i18 = i13 + 1;
            int i19 = iArr[i18];
            int i20 = i13 + 2;
            int i21 = iArr[i20];
            int i22 = i19 + i21;
            int i23 = i19 - i21;
            int i24 = i14 - i16;
            iArr[i13] = ((i17 + i22) + 3) >> 3;
            iArr[i18] = ((i23 + i24) + 3) >> 3;
            iArr[i20] = ((i17 - i22) + 3) >> 3;
            iArr[i15] = ((i24 - i23) + 3) >> 3;
        }
    }

    public static void walsh4x4(int[] iArr) {
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= 16) {
                break;
            }
            int i3 = iArr[i];
            int i4 = i + 2;
            int i5 = iArr[i4];
            int i6 = (i3 + i5) << 2;
            int i7 = i + 1;
            int i8 = iArr[i7];
            int i9 = i + 3;
            int i10 = iArr[i9];
            int i11 = (i8 + i10) << 2;
            int i12 = (i8 - i10) << 2;
            int i13 = (i3 - i5) << 2;
            int i14 = i6 + i11;
            if (i6 == 0) {
                i2 = 0;
            }
            iArr[i] = i14 + i2;
            iArr[i7] = i13 + i12;
            iArr[i4] = i13 - i12;
            iArr[i9] = i6 - i11;
            i += 4;
        }
        for (int i15 = 0; i15 < 4; i15++) {
            int i16 = iArr[i15];
            int i17 = i15 + 8;
            int i18 = iArr[i17];
            int i19 = i16 + i18;
            int i20 = i15 + 4;
            int i21 = iArr[i20];
            int i22 = i15 + 12;
            int i23 = iArr[i22];
            int i24 = i21 + i23;
            int i25 = i21 - i23;
            int i26 = i16 - i18;
            int i27 = i19 + i24;
            int i28 = i26 + i25;
            int i29 = i26 - i25;
            int i30 = i19 - i24;
            int i31 = i27 + (i27 < 0 ? 1 : 0);
            int i32 = i28 + (i28 < 0 ? 1 : 0);
            int i33 = i29 + (i29 < 0 ? 1 : 0);
            int i34 = i30 < 0 ? 1 : 0;
            iArr[i15] = (i31 + 3) >> 3;
            iArr[i20] = (i32 + 3) >> 3;
            iArr[i17] = (i33 + 3) >> 3;
            iArr[i22] = ((i30 + i34) + 3) >> 3;
        }
    }
}
