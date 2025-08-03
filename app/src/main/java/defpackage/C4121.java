package defpackage;

import java.lang.reflect.Array;

/* compiled from: PSFilterbank.java */
/* renamed from: ॶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4121 implements InterfaceC3634 {

    /* renamed from: ޡ, reason: contains not printable characters */
    public int f14273;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int[] f14274 = {8, 2, 2};

    /* renamed from: ޣ, reason: contains not printable characters */
    public int[] f14275 = {12, 8, 4, 4, 4};

    /* renamed from: ޤ, reason: contains not printable characters */
    public float[][] f14276;

    /* renamed from: ޥ, reason: contains not printable characters */
    public float[][][] f14277;

    /* renamed from: ޱ, reason: contains not printable characters */
    public float[][][] f14278;

    public C4121(int i) {
        this.f14273 = i;
        int[] iArr = {i + 12, 2};
        Class cls = Float.TYPE;
        this.f14276 = (float[][]) Array.newInstance((Class<?>) cls, iArr);
        this.f14277 = (float[][][]) Array.newInstance((Class<?>) cls, 5, 2, 2);
        this.f14278 = (float[][][]) Array.newInstance((Class<?>) cls, this.f14273, 12, 2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13082(float[] fArr, float[] fArr2) {
        float f = fArr2[2] * 0.70710677f;
        float f2 = fArr2[0];
        float f3 = f2 - f;
        float f4 = f2 + f;
        float f5 = fArr2[1];
        float f6 = fArr2[3];
        float f7 = (f5 + f6) * (-0.9238795f);
        float f8 = (f5 * 1.306563f) + f7;
        float f9 = (f6 * (-0.5411961f)) - f7;
        fArr[3] = f4 - f9;
        fArr[0] = f4 + f9;
        fArr[2] = f3 - f8;
        fArr[1] = f3 + f8;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13083(int i, float[] fArr, float[][] fArr2, float[][][] fArr3) {
        int i2 = 0;
        while (i2 < i) {
            float f = fArr[0];
            float[] fArr4 = fArr2[i2 + 0];
            float f2 = fArr4[0];
            float[] fArr5 = fArr2[i2 + 12];
            float f3 = (f2 + fArr5[0]) * f;
            float f4 = fArr[1];
            int i3 = i2 + 1;
            float[] fArr6 = fArr2[i3];
            float f5 = fArr6[0];
            float[] fArr7 = fArr2[i2 + 11];
            float f6 = (f5 + fArr7[0]) * f4;
            float f7 = fArr[2];
            float[] fArr8 = fArr2[i2 + 2];
            float f8 = fArr8[0];
            float[] fArr9 = fArr2[i2 + 10];
            float f9 = (f8 + fArr9[0]) * f7;
            float f10 = fArr[3];
            float[] fArr10 = fArr2[i2 + 3];
            float f11 = fArr10[0];
            float[] fArr11 = fArr2[i2 + 9];
            float f12 = (f11 + fArr11[0]) * f10;
            float f13 = fArr[4];
            float[] fArr12 = fArr2[i2 + 4];
            float f14 = fArr12[0];
            float[] fArr13 = fArr2[i2 + 8];
            float f15 = (f14 + fArr13[0]) * f13;
            float f16 = fArr[5];
            float[] fArr14 = fArr2[i2 + 5];
            float f17 = fArr14[0];
            float[] fArr15 = fArr2[i2 + 7];
            float f18 = (f17 + fArr15[0]) * f16;
            float f19 = fArr[6];
            float[] fArr16 = fArr2[i2 + 6];
            float f20 = fArr16[0] * f19;
            float f21 = f * (fArr4[1] + fArr5[1]);
            float f22 = f4 * (fArr6[1] + fArr7[1]);
            float f23 = f7 * (fArr8[1] + fArr9[1]);
            float f24 = f10 * (fArr10[1] + fArr11[1]);
            float f25 = f13 * (fArr12[1] + fArr13[1]);
            float f26 = f16 * (fArr14[1] + fArr15[1]);
            float f27 = f19 * fArr16[1];
            float[][] fArr17 = fArr3[i2];
            float[] fArr18 = fArr17[0];
            fArr18[0] = f3 + f6 + f9 + f12 + f15 + f18 + f20;
            fArr18[1] = f21 + f22 + f23 + f24 + f25 + f26 + f27;
            float[] fArr19 = fArr17[1];
            fArr19[0] = (((((f3 - f6) + f9) - f12) + f15) - f18) + f20;
            fArr19[1] = (((((f21 - f22) + f23) - f24) + f25) - f26) + f27;
            i2 = i3;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m13084(int i, float[] fArr, float[][] fArr2, float[][][] fArr3) {
        float[] fArr4 = new float[2];
        float[] fArr5 = new float[2];
        float[] fArr6 = new float[2];
        float[] fArr7 = new float[2];
        int i2 = 0;
        while (i2 < i) {
            float f = fArr[2];
            float[] fArr8 = fArr2[i2 + 2];
            float f2 = fArr8[0];
            float[] fArr9 = fArr2[i2 + 10];
            float f3 = -((f2 + fArr9[0]) * f);
            float f4 = fArr[6];
            float[] fArr10 = fArr2[i2 + 6];
            fArr4[0] = f3 + (fArr10[0] * f4);
            float f5 = fArr[1];
            int i3 = i2 + 1;
            float[] fArr11 = fArr2[i3];
            float f6 = fArr11[0];
            float[] fArr12 = fArr2[i2 + 11];
            float f7 = f5 * (f6 + fArr12[0]);
            float f8 = fArr[3];
            float[] fArr13 = fArr2[i2 + 3];
            float f9 = fArr13[0];
            float[] fArr14 = fArr2[i2 + 9];
            float f10 = f7 + ((f9 + fArr14[0]) * f8);
            float f11 = fArr[5];
            float[] fArr15 = fArr2[i2 + 5];
            float f12 = fArr15[0];
            float[] fArr16 = fArr2[i2 + 7];
            fArr4[1] = (f10 - ((f12 + fArr16[0]) * f11)) * (-0.70710677f);
            float f13 = fArr[0];
            float[] fArr17 = fArr2[i2 + 0];
            float f14 = fArr17[1];
            float[] fArr18 = fArr2[i2 + 12];
            float f15 = f13 * (f14 - fArr18[1]);
            float f16 = fArr[4];
            float[] fArr19 = fArr2[i2 + 4];
            float f17 = fArr19[1];
            float[] fArr20 = fArr2[i2 + 8];
            fArr6[0] = f15 - ((f17 - fArr20[1]) * f16);
            fArr6[1] = (((fArr[1] * (fArr11[1] - fArr12[1])) - ((fArr13[1] - fArr14[1]) * f8)) - ((fArr15[1] - fArr16[1]) * f11)) * 0.70710677f;
            fArr5[0] = (fArr[0] * (fArr17[0] - fArr18[0])) - (f16 * (fArr19[0] - fArr20[0]));
            fArr5[1] = (((fArr[1] * (fArr11[0] - fArr12[0])) - ((fArr13[0] - fArr14[0]) * f8)) - ((fArr15[0] - fArr16[0]) * f11)) * 0.70710677f;
            fArr7[0] = (-(f * (fArr8[1] + fArr9[1]))) + (f4 * fArr10[1]);
            float f18 = (((fArr[1] * (fArr11[1] + fArr12[1])) + (f8 * (fArr13[1] + fArr14[1]))) - (f11 * (fArr15[1] + fArr16[1]))) * (-0.70710677f);
            fArr7[1] = f18;
            float[][] fArr21 = fArr3[i2];
            float[] fArr22 = fArr21[0];
            fArr22[0] = fArr4[0] + fArr4[1] + fArr6[0] + fArr6[1];
            fArr22[1] = ((-fArr5[0]) - fArr5[1]) + fArr7[0] + f18;
            float[] fArr23 = fArr21[1];
            fArr23[0] = ((fArr4[0] - fArr4[1]) - fArr6[0]) + fArr6[1];
            fArr23[1] = ((fArr5[0] - fArr5[1]) + fArr7[0]) - fArr7[1];
            float[] fArr24 = fArr21[2];
            fArr24[0] = ((fArr4[0] - fArr4[1]) + fArr6[0]) - fArr6[1];
            fArr24[1] = (((-fArr5[0]) + fArr5[1]) + fArr7[0]) - fArr7[1];
            float[] fArr25 = fArr21[3];
            fArr25[0] = ((fArr4[0] + fArr4[1]) - fArr6[0]) - fArr6[1];
            fArr25[1] = fArr5[0] + fArr5[1] + fArr7[0] + fArr7[1];
            i2 = i3;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m13085(float[] fArr, float[] fArr2) {
        float f = fArr2[3] * 0.70710677f;
        float f2 = fArr2[0];
        float f3 = f2 + f;
        float f4 = f2 - f;
        float f5 = fArr2[1];
        float f6 = fArr2[5];
        float f7 = (f5 - f6) * 0.70710677f;
        float f8 = fArr2[2] * 0.8660254f;
        float f9 = fArr2[4];
        float f10 = f8 + (0.5f * f9);
        float f11 = f10 - f9;
        float f12 = (f5 * 0.9659258f) + (f6 * 0.25881904f);
        float f13 = f12 - f7;
        fArr[0] = f3 + f12 + f10;
        fArr[1] = (f4 + f7) - f9;
        fArr[2] = (f13 + f4) - f11;
        fArr[3] = (f3 - f13) - f11;
        fArr[4] = (f3 - f7) - f9;
        fArr[5] = (f4 - f12) + f10;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m13086(int i, float[] fArr, float[][] fArr2, float[][][] fArr3) {
        float[] fArr4 = new float[6];
        float[] fArr5 = new float[6];
        float[] fArr6 = new float[6];
        float[] fArr7 = new float[6];
        float[] fArr8 = new float[6];
        float[] fArr9 = new float[6];
        float[] fArr10 = new float[6];
        float[] fArr11 = new float[6];
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < 6; i3++) {
                if (i3 == 0) {
                    float[] fArr12 = fArr2[i2 + 6];
                    float f = fArr12[0];
                    float f2 = fArr[6];
                    fArr4[0] = f * f2;
                    fArr5[0] = fArr12[1] * f2;
                } else {
                    int i4 = 6 - i3;
                    float[] fArr13 = fArr2[i3 + i2];
                    float f3 = fArr13[0];
                    float[] fArr14 = fArr2[(12 - i3) + i2];
                    fArr4[i4] = (f3 + fArr14[0]) * fArr[i3];
                    fArr5[i4] = (fArr13[1] + fArr14[1]) * fArr[i3];
                }
                float[] fArr15 = fArr2[i3 + i2];
                float f4 = fArr15[0];
                float[] fArr16 = fArr2[(12 - i3) + i2];
                fArr7[i3] = (f4 - fArr16[0]) * fArr[i3];
                fArr6[i3] = (fArr15[1] - fArr16[1]) * fArr[i3];
            }
            m13085(fArr8, fArr4);
            m13085(fArr9, fArr5);
            m13085(fArr10, fArr6);
            m13085(fArr11, fArr7);
            for (int i5 = 0; i5 < 6; i5 += 2) {
                float[][] fArr17 = fArr3[i2];
                float[] fArr18 = fArr17[i5];
                fArr18[0] = fArr8[i5] - fArr10[i5];
                fArr18[1] = fArr9[i5] + fArr11[i5];
                int i6 = i5 + 1;
                float[] fArr19 = fArr17[i6];
                fArr19[0] = fArr8[i6] + fArr10[i6];
                fArr19[1] = fArr9[i6] - fArr11[i6];
                float[] fArr20 = fArr17[10 - i5];
                fArr20[0] = fArr8[i6] - fArr10[i6];
                fArr20[1] = fArr9[i6] + fArr11[i6];
                float[] fArr21 = fArr17[11 - i5];
                fArr21[0] = fArr8[i5] + fArr10[i5];
                fArr21[1] = fArr9[i5] - fArr11[i5];
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m13087(int i, float[] fArr, float[][] fArr2, float[][][] fArr3) {
        float[] fArr4 = new float[4];
        float[] fArr5 = new float[4];
        float[] fArr6 = new float[4];
        float[] fArr7 = new float[4];
        float[] fArr8 = new float[4];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 6;
            fArr4[0] = fArr[6] * fArr2[i3][0];
            float f = fArr[5];
            int i4 = i2 + 5;
            float[] fArr9 = fArr2[i4];
            float f2 = fArr9[0];
            int i5 = i2 + 7;
            float[] fArr10 = fArr2[i5];
            fArr4[1] = (f2 + fArr10[0]) * f;
            float f3 = fArr[0];
            int i6 = i2 + 0;
            float[] fArr11 = fArr2[i6];
            float f4 = fArr11[0];
            int i7 = i2 + 12;
            float[] fArr12 = fArr2[i7];
            float f5 = -(f3 * (f4 + fArr12[0]));
            float f6 = fArr[4];
            int i8 = i2 + 4;
            float[] fArr13 = fArr2[i8];
            float f7 = fArr13[0];
            int i9 = i2 + 8;
            float[] fArr14 = fArr2[i9];
            fArr4[2] = f5 + ((f7 + fArr14[0]) * f6);
            float f8 = fArr[1];
            int i10 = i2 + 1;
            float[] fArr15 = fArr2[i10];
            float f9 = fArr15[0];
            int i11 = i2 + 11;
            float[] fArr16 = fArr2[i11];
            float f10 = -(f8 * (f9 + fArr16[0]));
            float f11 = fArr[3];
            int i12 = i2 + 3;
            float[] fArr17 = fArr2[i12];
            float f12 = fArr17[0];
            int i13 = i2 + 9;
            float[] fArr18 = fArr2[i13];
            fArr4[3] = f10 + (f11 * (f12 + fArr18[0]));
            fArr6[0] = f * (fArr10[1] - fArr9[1]);
            fArr6[1] = (fArr[0] * (fArr12[1] - fArr11[1])) + (f6 * (fArr14[1] - fArr13[1]));
            fArr6[2] = (fArr[1] * (fArr16[1] - fArr15[1])) + (fArr[3] * (fArr18[1] - fArr17[1]));
            int i14 = i2 + 10;
            int i15 = i2 + 2;
            fArr6[3] = fArr[2] * (fArr2[i14][1] - fArr2[i15][1]);
            for (int i16 = 0; i16 < 4; i16++) {
                fArr8[i16] = fArr4[i16] - fArr6[3 - i16];
            }
            m13082(fArr8, fArr8);
            float[][] fArr19 = fArr3[i2];
            fArr19[7][0] = fArr8[0];
            fArr19[5][0] = fArr8[2];
            fArr19[3][0] = fArr8[3];
            fArr19[1][0] = fArr8[1];
            for (int i17 = 0; i17 < 4; i17++) {
                fArr8[i17] = fArr4[i17] + fArr6[3 - i17];
            }
            m13082(fArr8, fArr8);
            float[][] fArr20 = fArr3[i2];
            fArr20[6][0] = fArr8[1];
            fArr20[4][0] = fArr8[3];
            fArr20[2][0] = fArr8[2];
            fArr20[0][0] = fArr8[0];
            fArr7[0] = fArr[6] * fArr2[i3][1];
            float f13 = fArr[5];
            float[] fArr21 = fArr2[i4];
            float f14 = fArr21[1];
            float[] fArr22 = fArr2[i5];
            fArr7[1] = (f14 + fArr22[1]) * f13;
            float f15 = fArr[0];
            float[] fArr23 = fArr2[i6];
            float f16 = fArr23[1];
            float[] fArr24 = fArr2[i7];
            float f17 = -(f15 * (f16 + fArr24[1]));
            float f18 = fArr[4];
            float[] fArr25 = fArr2[i8];
            float f19 = fArr25[1];
            float[] fArr26 = fArr2[i9];
            fArr7[2] = f17 + ((f19 + fArr26[1]) * f18);
            float f20 = fArr[1];
            float[] fArr27 = fArr2[i10];
            float f21 = fArr27[1];
            float[] fArr28 = fArr2[i11];
            float f22 = -(f20 * (f21 + fArr28[1]));
            float f23 = fArr[3];
            float[] fArr29 = fArr2[i12];
            float f24 = fArr29[1];
            float[] fArr30 = fArr2[i13];
            fArr7[3] = f22 + (f23 * (f24 + fArr30[1]));
            fArr5[0] = f13 * (fArr22[0] - fArr21[0]);
            fArr5[1] = (fArr[0] * (fArr24[0] - fArr23[0])) + (f18 * (fArr26[0] - fArr25[0]));
            fArr5[2] = (fArr[1] * (fArr28[0] - fArr27[0])) + (fArr[3] * (fArr30[0] - fArr29[0]));
            fArr5[3] = fArr[2] * (fArr2[i14][0] - fArr2[i15][0]);
            for (int i18 = 0; i18 < 4; i18++) {
                fArr8[i18] = fArr7[i18] + fArr5[3 - i18];
            }
            m13082(fArr8, fArr8);
            float[][] fArr31 = fArr3[i2];
            fArr31[7][1] = fArr8[0];
            fArr31[5][1] = fArr8[2];
            fArr31[3][1] = fArr8[3];
            fArr31[1][1] = fArr8[1];
            for (int i19 = 0; i19 < 4; i19++) {
                fArr8[i19] = fArr7[i19] - fArr5[3 - i19];
            }
            m13082(fArr8, fArr8);
            float[][] fArr32 = fArr3[i2];
            fArr32[6][1] = fArr8[1];
            fArr32[4][1] = fArr8[3];
            fArr32[2][1] = fArr8[2];
            fArr32[0][1] = fArr8[0];
            i2 = i10;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m13088(float[][][] fArr, float[][][] fArr2, boolean z, int i) {
        int i2 = z ? 5 : 3;
        int[] iArr = z ? this.f14275 : this.f14274;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < 12; i5++) {
                float[] fArr3 = this.f14276[i5];
                float[] fArr4 = this.f14277[i4][i5];
                fArr3[0] = fArr4[0];
                fArr3[1] = fArr4[1];
            }
            for (int i6 = 0; i6 < this.f14273; i6++) {
                float[] fArr5 = this.f14276[i6 + 12];
                float[] fArr6 = fArr[i6 + 6][i4];
                fArr5[0] = fArr6[0];
                fArr5[0] = fArr6[0];
            }
            for (int i7 = 0; i7 < 12; i7++) {
                float[] fArr7 = this.f14277[i4][i7];
                float[][] fArr8 = this.f14276;
                int i8 = this.f14273;
                fArr7[0] = fArr8[i8 + i7][0];
                fArr7[1] = fArr8[i8 + i7][1];
            }
            int i9 = iArr[i4];
            if (i9 == 2) {
                m13083(this.f14273, InterfaceC3634.f12600, this.f14276, this.f14278);
            } else if (i9 == 4) {
                m13084(this.f14273, InterfaceC3634.f12603, this.f14276, this.f14278);
            } else if (i9 == 8) {
                m13087(this.f14273, z ? InterfaceC3634.f12602 : InterfaceC3634.f12599, this.f14276, this.f14278);
            } else if (i9 == 12) {
                m13086(this.f14273, InterfaceC3634.f12601, this.f14276, this.f14278);
            }
            for (int i10 = 0; i10 < this.f14273; i10++) {
                for (int i11 = 0; i11 < iArr[i4]; i11++) {
                    float[] fArr9 = fArr2[i10][i3 + i11];
                    float[] fArr10 = this.f14278[i10][i11];
                    fArr9[0] = fArr10[0];
                    fArr9[1] = fArr10[1];
                }
            }
            i3 += iArr[i4];
        }
        if (z) {
            return;
        }
        for (int i12 = 0; i12 < i; i12++) {
            float[][] fArr11 = fArr2[i12];
            float[] fArr12 = fArr11[3];
            float f = fArr12[0];
            float[] fArr13 = fArr11[4];
            fArr12[0] = f + fArr13[0];
            fArr12[1] = fArr12[1] + fArr13[1];
            fArr13[0] = 0.0f;
            fArr13[1] = 0.0f;
            float[] fArr14 = fArr11[2];
            float f2 = fArr14[0];
            float[] fArr15 = fArr11[5];
            fArr14[0] = f2 + fArr15[0];
            fArr14[1] = fArr14[1] + fArr15[1];
            fArr15[0] = 0.0f;
            fArr15[1] = 0.0f;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m13089(float[][][] fArr, float[][][] fArr2, boolean z, int i) {
        int i2 = z ? 5 : 3;
        int[] iArr = z ? this.f14275 : this.f14274;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < this.f14273; i5++) {
                float[] fArr3 = fArr[i5][i4];
                fArr3[0] = 0.0f;
                fArr3[1] = 0.0f;
                for (int i6 = 0; i6 < iArr[i4]; i6++) {
                    float[] fArr4 = fArr[i5][i4];
                    float f = fArr4[0];
                    float[] fArr5 = fArr2[i5][i3 + i6];
                    fArr4[0] = f + fArr5[0];
                    fArr4[1] = fArr4[1] + fArr5[1];
                }
            }
            i3 += iArr[i4];
        }
    }
}
