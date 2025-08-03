package org.jcodec.codecs.mpa;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class Mp3Mdct {
    private static final float cos075 = 0.9914449f;
    private static final float cos225 = 0.9238795f;
    private static final float cos300 = 0.8660254f;
    private static final float cos375 = 0.7933533f;
    private static final float cos450 = 0.70710677f;
    private static final float cos525 = 0.6087614f;
    private static final float cos600 = 0.5f;
    private static final float cos675 = 0.38268343f;
    private static final float cos825 = 0.13052619f;
    private static final float factor36pt0 = 0.34729636f;
    private static final float factor36pt1 = 1.5320889f;
    private static final float factor36pt2 = 1.8793852f;
    private static final float factor36pt3 = 1.7320508f;
    private static final float factor36pt4 = 1.9696155f;
    private static final float factor36pt5 = 1.2855753f;
    private static final float factor36pt6 = 0.6840403f;
    private static final float factor12pt1 = 0.5176381f;
    private static final float factor12pt0 = 1.9318516f;
    private static final float[] factor36 = {0.5019099f, factor12pt1, 0.55168897f, 0.61038727f, 0.8717234f, 1.1831008f, factor12pt0, 5.7368565f};
    private static final float[] factor12 = {0.5043145f, 0.5411961f, 0.6302362f, 0.8213398f, 1.306563f, 3.830649f};
    private static float[] tmp = new float[16];

    private static void imdct12(float[] fArr, float[] fArr2, int i, int i2) {
        int i3;
        int i4 = i2 + 15;
        int i5 = i2 + 12;
        int i6 = i4;
        int i7 = i5;
        while (true) {
            i3 = i2 + 3;
            if (i6 < i3) {
                break;
            }
            fArr[i6] = fArr[i6] + fArr[i7];
            i6 -= 3;
            i7 -= 3;
        }
        int i8 = i2 + 9;
        fArr[i4] = fArr[i4] + fArr[i8];
        fArr[i8] = fArr[i8] + fArr[i3];
        float f = fArr[i5];
        float f2 = fArr[i2 + 6] * cos300;
        float f3 = fArr[i2 + 0] + (f * 0.5f);
        float[] fArr3 = tmp;
        float f4 = fArr[i2] - f;
        fArr3[1] = f4;
        float f5 = f3 + f2;
        int i9 = 0;
        fArr3[0] = f5;
        float f6 = f3 - f2;
        fArr3[2] = f6;
        float f7 = fArr[i4];
        float f8 = fArr[i8] * cos300;
        float f9 = fArr[i3];
        float f10 = (0.5f * f7) + f9;
        float f11 = f9 - f7;
        fArr3[4] = f11;
        float f12 = f10 + f8;
        fArr3[5] = f12;
        float f13 = f10 - f8;
        fArr3[3] = f13;
        float f14 = f13 * factor12pt0;
        fArr3[3] = f14;
        float f15 = f11 * cos450;
        fArr3[4] = f15;
        float f16 = f12 * factor12pt1;
        fArr3[5] = f16;
        fArr3[0] = f5 + f16;
        fArr3[5] = f5 - f16;
        fArr3[1] = f4 + f15;
        fArr3[4] = f4 - f15;
        fArr3[2] = f6 + f14;
        fArr3[3] = f6 - f14;
        for (int i10 = 0; i10 < 6; i10++) {
            float[] fArr4 = tmp;
            fArr4[i10] = fArr4[i10] * factor12[i10];
        }
        float[] fArr5 = tmp;
        float f17 = fArr5[0];
        fArr5[8] = (-f17) * cos375;
        fArr5[9] = (-f17) * cos525;
        float f18 = fArr5[1];
        fArr5[7] = (-f18) * cos225;
        fArr5[10] = (-f18) * cos675;
        float f19 = fArr5[2];
        fArr5[6] = (-f19) * cos075;
        fArr5[11] = (-f19) * cos825;
        float f20 = fArr5[3];
        fArr5[0] = f20;
        float f21 = fArr5[4];
        fArr5[1] = cos675 * f21;
        float f22 = fArr5[5];
        fArr5[2] = cos525 * f22;
        fArr5[3] = (-f22) * cos375;
        fArr5[4] = (-f21) * cos225;
        fArr5[5] = (-f20) * cos075;
        fArr5[0] = f20 * cos825;
        int i11 = i + 6;
        while (i9 < 12) {
            fArr2[i11] = fArr2[i11] + tmp[i9];
            i9++;
            i11++;
        }
    }

    public static void oneLong(float[] fArr, float[] fArr2) {
        for (int i = 17; i > 0; i--) {
            fArr[i] = fArr[i] + fArr[i - 1];
        }
        for (int i2 = 17; i2 > 2; i2 -= 2) {
            fArr[i2] = fArr[i2] + fArr[i2 - 2];
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < 2) {
            float f = fArr[i3];
            float f2 = f + f;
            int i5 = i3 + 12;
            float f3 = fArr[i5] + f2;
            float f4 = fArr[i3 + 6] * factor36pt3;
            float[] fArr3 = tmp;
            int i6 = i3 + 4;
            int i7 = i3 + 8;
            int i8 = i3 + 16;
            fArr3[i4 + 0] = (fArr[i6] * factor36pt2) + f3 + (fArr[i7] * factor36pt1) + (fArr[i8] * factor36pt0);
            float f5 = (f2 + fArr[i6]) - fArr[i7];
            float f6 = fArr[i5];
            fArr3[i4 + 1] = ((f5 - f6) - f6) - fArr[i8];
            fArr3[i4 + 2] = ((f3 - (fArr[i6] * factor36pt0)) - (fArr[i7] * factor36pt2)) + (fArr[i8] * factor36pt1);
            fArr3[i4 + 3] = ((f3 - (fArr[i6] * factor36pt1)) + (fArr[i7] * factor36pt0)) - (fArr[i8] * factor36pt2);
            int i9 = i3 + 2;
            int i10 = i3 + 10;
            int i11 = i3 + 14;
            fArr3[i4 + 4] = (fArr[i9] * factor36pt4) + f4 + (fArr[i10] * factor36pt5) + (fArr[i11] * factor36pt6);
            fArr3[i4 + 5] = ((fArr[i9] - fArr[i10]) - fArr[i11]) * factor36pt3;
            fArr3[i4 + 6] = (((fArr[i9] * factor36pt5) - f4) - (fArr[i10] * factor36pt6)) + (fArr[i11] * factor36pt4);
            fArr3[i4 + 7] = (((fArr[i9] * factor36pt6) - f4) + (fArr[i10] * factor36pt4)) - (fArr[i11] * factor36pt5);
            i3++;
            i4 += 8;
        }
        int i12 = 0;
        int i13 = 12;
        int i14 = 4;
        int i15 = 8;
        while (i12 < 4) {
            float[] fArr4 = tmp;
            float f7 = fArr4[i12];
            float f8 = fArr4[i15];
            fArr4[i12] = fArr4[i14] + f7;
            fArr4[i14] = f7 - fArr4[i14];
            float f9 = fArr4[i15] + fArr4[i13];
            float[] fArr5 = factor36;
            fArr4[i15] = f9 * fArr5[i12];
            fArr4[i13] = (f8 - fArr4[i13]) * fArr5[7 - i12];
            i12++;
            i14++;
            i15++;
            i13++;
        }
        for (int i16 = 0; i16 < 4; i16++) {
            int i17 = 26 - i16;
            float[] fArr6 = tmp;
            int i18 = i16 + 8;
            fArr2[i17] = fArr6[i16] + fArr6[i18];
            int i19 = 8 - i16;
            fArr2[i19] = fArr6[i18] - fArr6[i16];
            fArr2[i16 + 27] = fArr2[i17];
            fArr2[i16 + 9] = -fArr2[i19];
        }
        for (int i20 = 0; i20 < 4; i20++) {
            int i21 = 21 - i20;
            float[] fArr7 = tmp;
            int i22 = 7 - i20;
            int i23 = 15 - i20;
            fArr2[i21] = fArr7[i22] + fArr7[i23];
            int i24 = 3 - i20;
            fArr2[i24] = fArr7[i23] - fArr7[i22];
            fArr2[i20 + 32] = fArr2[i21];
            fArr2[i20 + 14] = -fArr2[i24];
        }
        float f10 = (((fArr[0] - fArr[4]) + fArr[8]) - fArr[12]) + fArr[16];
        float f11 = ((((fArr[1] - fArr[5]) + fArr[9]) - fArr[13]) + fArr[17]) * cos450;
        float f12 = f11 - f10;
        fArr2[4] = f12;
        fArr2[13] = -f12;
        float f13 = f10 + f11;
        fArr2[22] = f13;
        fArr2[31] = f13;
    }

    public static void threeShort(float[] fArr, float[] fArr2) {
        Arrays.fill(fArr2, 0.0f);
        int i = 0;
        int i2 = 0;
        while (i < 3) {
            imdct12(fArr, fArr2, i2, i);
            i++;
            i2 += 6;
        }
    }
}
