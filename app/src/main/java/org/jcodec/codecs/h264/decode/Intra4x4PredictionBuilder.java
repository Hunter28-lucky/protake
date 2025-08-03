package org.jcodec.codecs.h264.decode;

import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Intra4x4PredictionBuilder {
    public static void predictDC(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        int i4;
        int i5;
        byte b;
        if (z && z2) {
            int i6 = i + i2;
            i4 = ((((((((bArr[i3] + bArr[i3 + 1]) + bArr[i3 + 2]) + bArr[i3 + 3]) + bArr2[i6]) + bArr2[i6 + 1]) + bArr2[i6 + 2]) + bArr2[i6 + 3]) + 4) >> 3;
        } else {
            if (z) {
                i5 = bArr[i3] + bArr[i3 + 1] + bArr[i3 + 2];
                b = bArr[i3 + 3];
            } else if (z2) {
                int i7 = i + i2;
                i5 = bArr2[i7] + bArr2[i7 + 1] + bArr2[i7 + 2];
                b = bArr2[i7 + 3];
            } else {
                i4 = 0;
            }
            i4 = ((i5 + b) + 2) >> 2;
        }
        int i8 = (i3 << 4) + i2;
        int i9 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            bArr3[i8] = (byte) MathUtil.clip(iArr[i9] + i4, -128, 127);
            bArr3[i8 + 1] = (byte) MathUtil.clip(iArr[i9 + 1] + i4, -128, 127);
            bArr3[i8 + 2] = (byte) MathUtil.clip(iArr[i9 + 2] + i4, -128, 127);
            bArr3[i8 + 3] = (byte) MathUtil.clip(iArr[i9 + 3] + i4, -128, 127);
            i8 += 16;
            i9 += 4;
        }
    }

    public static void predictDiagonalDownLeft(int[] iArr, boolean z, boolean z2, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        int i4 = i + i2;
        byte b5 = bArr[i4 + 3];
        if (z2) {
            b = bArr[i4 + 4];
            b2 = bArr[i4 + 5];
            b3 = bArr[i4 + 6];
            b4 = bArr[i4 + 7];
        } else {
            b = b5;
            b2 = b;
            b3 = b2;
            b4 = b3;
        }
        byte b6 = bArr[i4];
        byte b7 = bArr[i4 + 2];
        byte b8 = bArr[i4 + 1];
        int i5 = (((b6 + b7) + (b8 << 1)) + 2) >> 2;
        int i6 = (((b8 + b5) + (b7 << 1)) + 2) >> 2;
        int i7 = (((b7 + b) + (b5 << 1)) + 2) >> 2;
        int i8 = (((b5 + b2) + (b << 1)) + 2) >> 2;
        int i9 = (((b + b3) + (b2 << 1)) + 2) >> 2;
        int i10 = (((b2 + b4) + (b3 << 1)) + 2) >> 2;
        int i11 = (i3 << 4) + i2;
        bArr2[i11] = (byte) MathUtil.clip(iArr[0] + i5, -128, 127);
        bArr2[i11 + 1] = (byte) MathUtil.clip(iArr[1] + i6, -128, 127);
        bArr2[i11 + 2] = (byte) MathUtil.clip(iArr[2] + i7, -128, 127);
        bArr2[i11 + 3] = (byte) MathUtil.clip(iArr[3] + i8, -128, 127);
        bArr2[i11 + 16] = (byte) MathUtil.clip(iArr[4] + i6, -128, 127);
        bArr2[i11 + 17] = (byte) MathUtil.clip(iArr[5] + i7, -128, 127);
        bArr2[i11 + 18] = (byte) MathUtil.clip(iArr[6] + i8, -128, 127);
        bArr2[i11 + 19] = (byte) MathUtil.clip(iArr[7] + i9, -128, 127);
        bArr2[i11 + 32] = (byte) MathUtil.clip(iArr[8] + i7, -128, 127);
        bArr2[i11 + 33] = (byte) MathUtil.clip(iArr[9] + i8, -128, 127);
        bArr2[i11 + 34] = (byte) MathUtil.clip(iArr[10] + i9, -128, 127);
        bArr2[i11 + 35] = (byte) MathUtil.clip(iArr[11] + i10, -128, 127);
        bArr2[i11 + 48] = (byte) MathUtil.clip(iArr[12] + i8, -128, 127);
        bArr2[i11 + 49] = (byte) MathUtil.clip(iArr[13] + i9, -128, 127);
        bArr2[i11 + 50] = (byte) MathUtil.clip(iArr[14] + i10, -128, 127);
        bArr2[i11 + 51] = (byte) MathUtil.clip(iArr[15] + (((b3 + (b4 * 3)) + 2) >> 2), -128, 127);
    }

    public static void predictDiagonalDownRight(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        int i4 = (i3 << 4) + i2;
        int i5 = i + i2;
        byte b = bArr2[i5];
        int i6 = i3 >> 2;
        byte b2 = bArr3[i6];
        int i7 = ((((b2 * 2) + b) + bArr[i3]) + 2) >> 2;
        int i8 = b2 + (bArr2[i5 + 0] << 1);
        int i9 = i5 + 1;
        byte b3 = bArr2[i9];
        int i10 = ((i8 + b3) + 2) >> 2;
        int i11 = i5 + 2;
        byte b4 = bArr2[i11];
        int i12 = (((b + (b3 << 1)) + b4) + 2) >> 2;
        int i13 = (((b3 + (b4 << 1)) + bArr2[i5 + 3]) + 2) >> 2;
        bArr4[i4] = (byte) MathUtil.clip(iArr[0] + i7, -128, 127);
        bArr4[i4 + 1] = (byte) MathUtil.clip(iArr[1] + i10, -128, 127);
        bArr4[i4 + 2] = (byte) MathUtil.clip(iArr[2] + i12, -128, 127);
        bArr4[i4 + 3] = (byte) MathUtil.clip(iArr[3] + i13, -128, 127);
        byte b5 = bArr3[i6];
        int i14 = i3 + 1;
        int i15 = ((((bArr[i3] << 1) + b5) + bArr[i14]) + 2) >> 2;
        byte b6 = bArr2[i5];
        byte b7 = bArr2[i9];
        int i16 = (((b6 + (b7 << 1)) + bArr2[i11]) + 2) >> 2;
        bArr4[i4 + 16] = (byte) MathUtil.clip(iArr[4] + i15, -128, 127);
        bArr4[i4 + 17] = (byte) MathUtil.clip(iArr[5] + i7, -128, 127);
        bArr4[i4 + 18] = (byte) MathUtil.clip(iArr[6] + ((((b5 + (b6 << 1)) + b7) + 2) >> 2), -128, 127);
        bArr4[i4 + 19] = (byte) MathUtil.clip(iArr[7] + i16, -128, 127);
        byte b8 = bArr[i3 + 0];
        byte b9 = bArr[i14];
        int i17 = i3 + 2;
        int i18 = (((b8 + (b9 << 1)) + bArr[i17]) + 2) >> 2;
        byte b10 = bArr3[i6];
        int i19 = ((((bArr[i3] << 1) + b10) + b9) + 2) >> 2;
        int i20 = (((b10 + (bArr2[i5] << 1)) + bArr2[i9]) + 2) >> 2;
        bArr4[i4 + 32] = (byte) MathUtil.clip(iArr[8] + i18, -128, 127);
        bArr4[i4 + 33] = (byte) MathUtil.clip(iArr[9] + i19, -128, 127);
        bArr4[i4 + 34] = (byte) MathUtil.clip(iArr[10] + i7, -128, 127);
        bArr4[i4 + 35] = (byte) MathUtil.clip(iArr[11] + i20, -128, 127);
        byte b11 = bArr[i14];
        byte b12 = bArr[i17];
        int i21 = ((((b12 << 1) + b11) + bArr[i3 + 3]) + 2) >> 2;
        byte b13 = bArr[i3];
        int i22 = ((((b11 << 1) + b13) + b12) + 2) >> 2;
        int i23 = (((bArr3[i6] + (b13 << 1)) + b11) + 2) >> 2;
        bArr4[i4 + 48] = (byte) MathUtil.clip(iArr[12] + i21, -128, 127);
        bArr4[i4 + 49] = (byte) MathUtil.clip(iArr[13] + i22, -128, 127);
        bArr4[i4 + 50] = (byte) MathUtil.clip(iArr[14] + i23, -128, 127);
        bArr4[i4 + 51] = (byte) MathUtil.clip(iArr[15] + i7, -128, 127);
    }

    public static void predictHorizontal(int[] iArr, boolean z, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        int i4 = (i3 << 4) + i2;
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            byte b = bArr[i3 + i6];
            bArr2[i4] = (byte) MathUtil.clip(iArr[i5] + b, -128, 127);
            bArr2[i4 + 1] = (byte) MathUtil.clip(iArr[i5 + 1] + b, -128, 127);
            bArr2[i4 + 2] = (byte) MathUtil.clip(iArr[i5 + 2] + b, -128, 127);
            bArr2[i4 + 3] = (byte) MathUtil.clip(iArr[i5 + 3] + b, -128, 127);
            i5 += 4;
            i4 += 16;
        }
    }

    public static void predictHorizontalDown(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        byte b = bArr3[i3 >> 2];
        byte b2 = bArr[i3];
        int i4 = ((b + b2) + 1) >> 1;
        int i5 = i + i2;
        byte b3 = bArr2[i5 + 0];
        int i6 = ((((b * 2) + b2) + b3) + 2) >> 2;
        byte b4 = bArr2[i5 + 1];
        int i7 = ((((b3 * 2) + b) + b4) + 2) >> 2;
        int i8 = (((b3 + (b4 * 2)) + bArr2[i5 + 2]) + 2) >> 2;
        byte b5 = bArr[i3 + 1];
        int i9 = ((b2 + b5) + 1) >> 1;
        int i10 = (((b + (b2 * 2)) + b5) + 2) >> 2;
        byte b6 = bArr[i3 + 2];
        int i11 = ((b5 + b6) + 1) >> 1;
        int i12 = (((b2 + (b5 * 2)) + b6) + 2) >> 2;
        byte b7 = bArr[i3 + 3];
        int i13 = ((b6 + b7) + 1) >> 1;
        int i14 = (((b5 + (b6 * 2)) + b7) + 2) >> 2;
        int i15 = (i3 << 4) + i2;
        bArr4[i15] = (byte) MathUtil.clip(iArr[0] + i4, -128, 127);
        bArr4[i15 + 1] = (byte) MathUtil.clip(iArr[1] + i6, -128, 127);
        bArr4[i15 + 2] = (byte) MathUtil.clip(iArr[2] + i7, -128, 127);
        bArr4[i15 + 3] = (byte) MathUtil.clip(iArr[3] + i8, -128, 127);
        bArr4[i15 + 16] = (byte) MathUtil.clip(iArr[4] + i9, -128, 127);
        bArr4[i15 + 17] = (byte) MathUtil.clip(iArr[5] + i10, -128, 127);
        bArr4[i15 + 18] = (byte) MathUtil.clip(iArr[6] + i4, -128, 127);
        bArr4[i15 + 19] = (byte) MathUtil.clip(iArr[7] + i6, -128, 127);
        bArr4[i15 + 32] = (byte) MathUtil.clip(iArr[8] + i11, -128, 127);
        bArr4[i15 + 33] = (byte) MathUtil.clip(iArr[9] + i12, -128, 127);
        bArr4[i15 + 34] = (byte) MathUtil.clip(iArr[10] + i9, -128, 127);
        bArr4[i15 + 35] = (byte) MathUtil.clip(iArr[11] + i10, -128, 127);
        bArr4[i15 + 48] = (byte) MathUtil.clip(iArr[12] + i13, -128, 127);
        bArr4[i15 + 49] = (byte) MathUtil.clip(iArr[13] + i14, -128, 127);
        bArr4[i15 + 50] = (byte) MathUtil.clip(iArr[14] + i11, -128, 127);
        bArr4[i15 + 51] = (byte) MathUtil.clip(iArr[15] + i12, -128, 127);
    }

    public static void predictHorizontalUp(int[] iArr, boolean z, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        byte b = bArr[i3];
        byte b2 = bArr[i3 + 1];
        int i4 = ((b + b2) + 1) >> 1;
        byte b3 = bArr[i3 + 2];
        int i5 = (((b + (b2 << 1)) + b3) + 2) >> 2;
        int i6 = ((b2 + b3) + 1) >> 1;
        byte b4 = bArr[i3 + 3];
        int i7 = (((b2 + (b3 << 1)) + b4) + 2) >> 2;
        int i8 = ((b3 + b4) + 1) >> 1;
        int i9 = (((b3 + (b4 << 1)) + b4) + 2) >> 2;
        int i10 = (i3 << 4) + i2;
        bArr2[i10] = (byte) MathUtil.clip(iArr[0] + i4, -128, 127);
        bArr2[i10 + 1] = (byte) MathUtil.clip(iArr[1] + i5, -128, 127);
        bArr2[i10 + 2] = (byte) MathUtil.clip(iArr[2] + i6, -128, 127);
        bArr2[i10 + 3] = (byte) MathUtil.clip(iArr[3] + i7, -128, 127);
        bArr2[i10 + 16] = (byte) MathUtil.clip(iArr[4] + i6, -128, 127);
        bArr2[i10 + 17] = (byte) MathUtil.clip(iArr[5] + i7, -128, 127);
        bArr2[i10 + 18] = (byte) MathUtil.clip(iArr[6] + i8, -128, 127);
        bArr2[i10 + 19] = (byte) MathUtil.clip(iArr[7] + i9, -128, 127);
        bArr2[i10 + 32] = (byte) MathUtil.clip(iArr[8] + i8, -128, 127);
        bArr2[i10 + 33] = (byte) MathUtil.clip(iArr[9] + i9, -128, 127);
        bArr2[i10 + 34] = (byte) MathUtil.clip(iArr[10] + b4, -128, 127);
        bArr2[i10 + 35] = (byte) MathUtil.clip(iArr[11] + b4, -128, 127);
        bArr2[i10 + 48] = (byte) MathUtil.clip(iArr[12] + b4, -128, 127);
        bArr2[i10 + 49] = (byte) MathUtil.clip(iArr[13] + b4, -128, 127);
        bArr2[i10 + 50] = (byte) MathUtil.clip(iArr[14] + b4, -128, 127);
        bArr2[i10 + 51] = (byte) MathUtil.clip(iArr[15] + b4, -128, 127);
    }

    public static void predictVertical(int[] iArr, boolean z, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        int i4 = (i3 << 4) + i2;
        int i5 = i + i2;
        int i6 = i4;
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            bArr2[i6] = (byte) MathUtil.clip(iArr[i7] + bArr[i5], -128, 127);
            bArr2[i6 + 1] = (byte) MathUtil.clip(iArr[i7 + 1] + bArr[i5 + 1], -128, 127);
            bArr2[i6 + 2] = (byte) MathUtil.clip(iArr[i7 + 2] + bArr[i5 + 2], -128, 127);
            bArr2[i6 + 3] = (byte) MathUtil.clip(iArr[i7 + 3] + bArr[i5 + 3], -128, 127);
            i7 += 4;
            i6 += 16;
        }
    }

    public static void predictVerticalLeft(int[] iArr, boolean z, boolean z2, byte[] bArr, int i, int i2, int i3, byte[] bArr2) {
        byte b;
        byte b2;
        byte b3;
        int i4 = i + i2;
        byte b4 = bArr[i4 + 3];
        if (z2) {
            b = bArr[i4 + 4];
            b2 = bArr[i4 + 5];
            b3 = bArr[i4 + 6];
        } else {
            b = b4;
            b2 = b;
            b3 = b2;
        }
        byte b5 = bArr[i4];
        byte b6 = bArr[i4 + 1];
        int i5 = ((b5 + b6) + 1) >> 1;
        byte b7 = bArr[i4 + 2];
        int i6 = ((b6 + b7) + 1) >> 1;
        int i7 = ((b7 + b4) + 1) >> 1;
        int i8 = ((b4 + b) + 1) >> 1;
        int i9 = ((b + b2) + 1) >> 1;
        int i10 = (((b5 + (b6 * 2)) + b7) + 2) >> 2;
        int i11 = (((b6 + (b7 * 2)) + b4) + 2) >> 2;
        int i12 = (((b7 + (b4 * 2)) + b) + 2) >> 2;
        int i13 = (((b4 + (b * 2)) + b2) + 2) >> 2;
        int i14 = (((b + (b2 * 2)) + b3) + 2) >> 2;
        int i15 = (i3 << 4) + i2;
        bArr2[i15] = (byte) MathUtil.clip(iArr[0] + i5, -128, 127);
        bArr2[i15 + 1] = (byte) MathUtil.clip(iArr[1] + i6, -128, 127);
        bArr2[i15 + 2] = (byte) MathUtil.clip(iArr[2] + i7, -128, 127);
        bArr2[i15 + 3] = (byte) MathUtil.clip(iArr[3] + i8, -128, 127);
        bArr2[i15 + 16] = (byte) MathUtil.clip(iArr[4] + i10, -128, 127);
        bArr2[i15 + 17] = (byte) MathUtil.clip(iArr[5] + i11, -128, 127);
        bArr2[i15 + 18] = (byte) MathUtil.clip(iArr[6] + i12, -128, 127);
        bArr2[i15 + 19] = (byte) MathUtil.clip(iArr[7] + i13, -128, 127);
        bArr2[i15 + 32] = (byte) MathUtil.clip(iArr[8] + i6, -128, 127);
        bArr2[i15 + 33] = (byte) MathUtil.clip(iArr[9] + i7, -128, 127);
        bArr2[i15 + 34] = (byte) MathUtil.clip(iArr[10] + i8, -128, 127);
        bArr2[i15 + 35] = (byte) MathUtil.clip(iArr[11] + i9, -128, 127);
        bArr2[i15 + 48] = (byte) MathUtil.clip(iArr[12] + i11, -128, 127);
        bArr2[i15 + 49] = (byte) MathUtil.clip(iArr[13] + i12, -128, 127);
        bArr2[i15 + 50] = (byte) MathUtil.clip(iArr[14] + i13, -128, 127);
        bArr2[i15 + 51] = (byte) MathUtil.clip(iArr[15] + i14, -128, 127);
    }

    public static void predictVerticalRight(int[] iArr, boolean z, boolean z2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        byte b = bArr3[i3 >> 2];
        int i4 = i + i2;
        byte b2 = bArr2[i4 + 0];
        int i5 = ((b + b2) + 1) >> 1;
        byte b3 = bArr2[i4 + 1];
        int i6 = ((b2 + b3) + 1) >> 1;
        byte b4 = bArr2[i4 + 2];
        int i7 = ((b3 + b4) + 1) >> 1;
        byte b5 = bArr2[i4 + 3];
        int i8 = ((b4 + b5) + 1) >> 1;
        byte b6 = bArr[i3];
        int i9 = ((((b * 2) + b6) + b2) + 2) >> 2;
        int i10 = ((((b2 * 2) + b) + b3) + 2) >> 2;
        int i11 = (((b2 + (b3 * 2)) + b4) + 2) >> 2;
        int i12 = (((b3 + (b4 * 2)) + b5) + 2) >> 2;
        byte b7 = bArr[i3 + 1];
        int i13 = (((b + (b6 * 2)) + b7) + 2) >> 2;
        int i14 = (((b6 + (b7 * 2)) + bArr[i3 + 2]) + 2) >> 2;
        int i15 = (i3 << 4) + i2;
        bArr4[i15] = (byte) MathUtil.clip(iArr[0] + i5, -128, 127);
        bArr4[i15 + 1] = (byte) MathUtil.clip(iArr[1] + i6, -128, 127);
        bArr4[i15 + 2] = (byte) MathUtil.clip(iArr[2] + i7, -128, 127);
        bArr4[i15 + 3] = (byte) MathUtil.clip(iArr[3] + i8, -128, 127);
        bArr4[i15 + 16] = (byte) MathUtil.clip(iArr[4] + i9, -128, 127);
        bArr4[i15 + 17] = (byte) MathUtil.clip(iArr[5] + i10, -128, 127);
        bArr4[i15 + 18] = (byte) MathUtil.clip(iArr[6] + i11, -128, 127);
        bArr4[i15 + 19] = (byte) MathUtil.clip(iArr[7] + i12, -128, 127);
        bArr4[i15 + 32] = (byte) MathUtil.clip(iArr[8] + i13, -128, 127);
        bArr4[i15 + 33] = (byte) MathUtil.clip(iArr[9] + i5, -128, 127);
        bArr4[i15 + 34] = (byte) MathUtil.clip(iArr[10] + i6, -128, 127);
        bArr4[i15 + 35] = (byte) MathUtil.clip(iArr[11] + i7, -128, 127);
        bArr4[i15 + 48] = (byte) MathUtil.clip(iArr[12] + i14, -128, 127);
        bArr4[i15 + 49] = (byte) MathUtil.clip(iArr[13] + i9, -128, 127);
        bArr4[i15 + 50] = (byte) MathUtil.clip(iArr[14] + i10, -128, 127);
        bArr4[i15 + 51] = (byte) MathUtil.clip(iArr[15] + i11, -128, 127);
    }

    public static void predictWithMode(int i, int[] iArr, boolean z, boolean z2, boolean z3, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, byte[] bArr4) {
        switch (i) {
            case 0:
                predictVertical(iArr, z2, bArr2, i2, i3, i4, bArr4);
                break;
            case 1:
                predictHorizontal(iArr, z, bArr, i2, i3, i4, bArr4);
                break;
            case 2:
                predictDC(iArr, z, z2, bArr, bArr2, i2, i3, i4, bArr4);
                break;
            case 3:
                predictDiagonalDownLeft(iArr, z2, z3, bArr2, i2, i3, i4, bArr4);
                break;
            case 4:
                predictDiagonalDownRight(iArr, z, z2, bArr, bArr2, bArr3, i2, i3, i4, bArr4);
                break;
            case 5:
                predictVerticalRight(iArr, z, z2, bArr, bArr2, bArr3, i2, i3, i4, bArr4);
                break;
            case 6:
                predictHorizontalDown(iArr, z, z2, bArr, bArr2, bArr3, i2, i3, i4, bArr4);
                break;
            case 7:
                predictVerticalLeft(iArr, z2, z3, bArr2, i2, i3, i4, bArr4);
                break;
            case 8:
                predictHorizontalUp(iArr, z, bArr, i2, i3, i4, bArr4);
                break;
        }
        int i5 = i2 + i3;
        int i6 = (i4 << 4) + i3;
        int i7 = i6 + 3;
        int i8 = i5 + 3;
        bArr3[i4 >> 2] = bArr2[i8];
        bArr[i4] = bArr4[i7];
        bArr[i4 + 1] = bArr4[i7 + 16];
        bArr[i4 + 2] = bArr4[i7 + 32];
        bArr[i4 + 3] = bArr4[i7 + 48];
        int i9 = i6 + 48;
        bArr2[i5] = bArr4[i9];
        bArr2[i5 + 1] = bArr4[i9 + 1];
        bArr2[i5 + 2] = bArr4[i9 + 2];
        bArr2[i8] = bArr4[i9 + 3];
    }
}
