package org.jcodec.codecs.vpx;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public class VP8DCT {
    private static final int cospi8sqrt2minus1 = 20091;
    private static final int sinpi8sqrt2 = 35468;

    public static int[] decodeDCT(int[] iArr) {
        int[] iArr2 = new int[16];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 0;
            int i4 = iArr[i3];
            int i5 = i + 8;
            int i6 = iArr[i5];
            int i7 = i4 + i6;
            int i8 = i4 - i6;
            int i9 = i + 4;
            int i10 = iArr[i9];
            int i11 = (i10 * sinpi8sqrt2) >> 16;
            int i12 = i + 12;
            int i13 = iArr[i12];
            int i14 = i11 - (((i13 * cospi8sqrt2minus1) >> 16) + i13);
            int i15 = i10 + ((i10 * cospi8sqrt2minus1) >> 16) + ((i13 * sinpi8sqrt2) >> 16);
            iArr2[i3] = i7 + i15;
            iArr2[i12] = i7 - i15;
            iArr2[i9] = i8 + i14;
            iArr2[i5] = i8 - i14;
            i++;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < 4; i17++) {
            int i18 = i16 * 4;
            int i19 = i18 + 0;
            int i20 = iArr2[i19];
            int i21 = i18 + 2;
            int i22 = iArr2[i21];
            int i23 = i20 + i22;
            int i24 = i20 - i22;
            int i25 = i18 + 1;
            int i26 = iArr2[i25];
            int i27 = (i26 * sinpi8sqrt2) >> 16;
            int i28 = i18 + 3;
            int i29 = iArr2[i28];
            int i30 = i27 - (((i29 * cospi8sqrt2minus1) >> 16) + i29);
            int i31 = i26 + ((i26 * cospi8sqrt2minus1) >> 16) + ((i29 * sinpi8sqrt2) >> 16);
            iArr2[i19] = ((i23 + i31) + 4) >> 3;
            iArr2[i28] = ((i23 - i31) + 4) >> 3;
            iArr2[i25] = ((i24 + i30) + 4) >> 3;
            iArr2[i21] = ((i24 - i30) + 4) >> 3;
            i16++;
        }
        return iArr2;
    }

    public static int[] decodeWHT(int[] iArr) {
        int[] iArr2 = new int[16];
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, 4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 0;
            int i4 = iArr[i3];
            int i5 = i + 12;
            int i6 = iArr[i5];
            int i7 = i4 + i6;
            int i8 = i + 4;
            int i9 = iArr[i8];
            int i10 = i + 8;
            int i11 = iArr[i10];
            int i12 = i9 + i11;
            int i13 = i9 - i11;
            int i14 = i4 - i6;
            iArr2[i3] = i7 + i12;
            iArr2[i8] = i13 + i14;
            iArr2[i10] = i7 - i12;
            iArr2[i5] = i14 - i13;
            i++;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = i15 + 0;
            int i18 = iArr2[i17];
            int i19 = i15 + 3;
            int i20 = iArr2[i19];
            int i21 = i18 + i20;
            int i22 = i15 + 1;
            int i23 = iArr2[i22];
            int i24 = i15 + 2;
            int i25 = iArr2[i24];
            int i26 = i23 + i25;
            int i27 = i23 - i25;
            int i28 = i18 - i20;
            int i29 = ((i21 + i26) + 3) >> 3;
            iArr2[i17] = i29;
            int i30 = ((i27 + i28) + 3) >> 3;
            iArr2[i22] = i30;
            int i31 = ((i21 - i26) + 3) >> 3;
            iArr2[i24] = i31;
            int i32 = ((i28 - i27) + 3) >> 3;
            iArr2[i19] = i32;
            iArr3[0][i16] = i29;
            iArr3[1][i16] = i30;
            iArr3[2][i16] = i31;
            iArr3[3][i16] = i32;
            i15 += 4;
        }
        return iArr2;
    }

    public static int[] encodeDCT(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[i + 0];
            int i5 = iArr[i + 3];
            int i6 = (i4 + i5) << 3;
            int i7 = iArr[i + 1];
            int i8 = iArr[i + 2];
            int i9 = (i7 + i8) << 3;
            int i10 = (i7 - i8) << 3;
            int i11 = (i4 - i5) << 3;
            iArr2[i2 + 0] = i6 + i9;
            iArr2[i2 + 2] = i6 - i9;
            iArr2[i2 + 1] = (((i10 * 2217) + (i11 * 5352)) + 14500) >> 12;
            iArr2[i2 + 3] = (((i11 * 2217) - (i10 * 5352)) + 7500) >> 12;
            i += 4;
            i2 += 4;
        }
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < 4; i14++) {
            int i15 = iArr2[i12 + 0];
            int i16 = iArr2[i12 + 12];
            int i17 = i15 + i16;
            int i18 = iArr2[i12 + 4];
            int i19 = iArr2[i12 + 8];
            int i20 = i18 + i19;
            int i21 = i18 - i19;
            int i22 = i15 - i16;
            iArr2[i13 + 0] = ((i17 + i20) + 7) >> 4;
            iArr2[i13 + 8] = ((i17 - i20) + 7) >> 4;
            iArr2[i13 + 4] = ((((i21 * 2217) + (i22 * 5352)) + 12000) >> 16) + (i22 != 0 ? 1 : 0);
            iArr2[i13 + 12] = (((i22 * 2217) - (i21 * 5352)) + 51000) >> 16;
            i12++;
            i13++;
        }
        return iArr2;
    }

    public static int[] encodeWHT(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i >= 4) {
                break;
            }
            int i5 = iArr[i2 + 0];
            int i6 = iArr[i2 + 2];
            int i7 = (i5 + i6) << 2;
            int i8 = iArr[i2 + 1];
            int i9 = iArr[i2 + 3];
            int i10 = (i8 + i9) << 2;
            int i11 = (i8 - i9) << 2;
            int i12 = (i5 - i6) << 2;
            int i13 = i3 + 0;
            int i14 = i7 + i10;
            if (i7 == 0) {
                i4 = 0;
            }
            iArr2[i13] = i14 + i4;
            iArr2[i3 + 1] = i12 + i11;
            iArr2[i3 + 2] = i12 - i11;
            iArr2[i3 + 3] = i7 - i10;
            i2 += 4;
            i3 += 4;
            i++;
        }
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < 4; i17++) {
            int i18 = iArr2[i15 + 0];
            int i19 = iArr2[i15 + 8];
            int i20 = i18 + i19;
            int i21 = iArr2[i15 + 4];
            int i22 = iArr2[i15 + 12];
            int i23 = i21 + i22;
            int i24 = i21 - i22;
            int i25 = i18 - i19;
            int i26 = i20 + i23;
            int i27 = i25 + i24;
            int i28 = i25 - i24;
            int i29 = i20 - i23;
            int i30 = i26 + (i26 < 0 ? 1 : 0);
            int i31 = i27 + (i27 < 0 ? 1 : 0);
            int i32 = i28 + (i28 < 0 ? 1 : 0);
            int i33 = i29 + (i29 < 0 ? 1 : 0);
            iArr2[i16 + 0] = (i30 + 3) >> 3;
            iArr2[i16 + 4] = (i31 + 3) >> 3;
            iArr2[i16 + 8] = (i32 + 3) >> 3;
            iArr2[i16 + 12] = (i33 + 3) >> 3;
            i15++;
            i16++;
        }
        return iArr2;
    }
}
