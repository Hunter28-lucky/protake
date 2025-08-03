package defpackage;

import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.sbr.SBR;

/* compiled from: HFGeneration.java */
/* renamed from: ଚ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4406 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int[] f15181 = {21, 23, 32, 43, 46, 64, 85, 93, 128, 0, 0, 0};

    /* compiled from: HFGeneration.java */
    /* renamed from: ଚ$Ϳ, reason: contains not printable characters */
    public static class C4407 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float[] f15182 = new float[2];

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float[] f15183 = new float[2];

        /* renamed from: ԩ, reason: contains not printable characters */
        public float[] f15184 = new float[2];

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float[] f15185 = new float[2];

        /* renamed from: ԫ, reason: contains not printable characters */
        public float[] f15186 = new float[2];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f15187;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13600(SBR sbr, C4407 c4407, float[][][] fArr, int i, int i2) {
        int i3 = sbr.tHFAdj;
        float[] fArr2 = fArr[i3 - 2][i];
        float f = fArr2[0];
        float f2 = fArr2[1];
        float[] fArr3 = fArr[i3 - 1][i];
        float f3 = fArr3[0];
        float f4 = fArr3[1];
        float f5 = 0.0f;
        int i4 = i3;
        float f6 = f2;
        float f7 = f;
        float f8 = f4;
        float f9 = f3;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (i4 < i2 + i3) {
            float[] fArr4 = fArr[i4][i];
            float f14 = fArr4[0];
            float f15 = fArr4[1];
            f5 += (f14 * f9) + (f15 * f8);
            f10 += (f15 * f9) - (f14 * f8);
            f12 += (f14 * f7) + (f15 * f6);
            f13 += (f7 * f15) - (f6 * f14);
            f11 += (f9 * f9) + (f8 * f8);
            i4++;
            f7 = f9;
            f6 = f8;
            f9 = f14;
            f8 = f15;
        }
        float[] fArr5 = c4407.f15185;
        fArr5[0] = (f5 - ((f9 * f7) + (f8 * f6))) + (f3 * f) + (f4 * f2);
        fArr5[1] = (f10 - ((f8 * f7) - (f9 * f6))) + ((f4 * f) - (f3 * f2));
        float[] fArr6 = c4407.f15186;
        fArr6[0] = (f11 - ((f7 * f7) + (f6 * f6))) + (f * f) + (f2 * f2);
        float[] fArr7 = c4407.f15182;
        fArr7[0] = f5;
        fArr7[1] = f10;
        float[] fArr8 = c4407.f15183;
        fArr8[0] = f12;
        fArr8[1] = f13;
        c4407.f15184[0] = f11;
        float f16 = f11 * fArr6[0];
        float f17 = fArr5[0];
        float f18 = fArr5[1];
        c4407.f15187 = f16 - (0.99999905f * ((f17 * f17) + (f18 * f18)));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13601(SBR sbr, int i) {
        for (int i2 = 0; i2 < sbr.N_Q; i2++) {
            sbr.bwArray[i][i2] = m13604(sbr.bs_invf_mode[i][i2], sbr.bs_invf_mode_prev[i][i2]);
            float[] fArr = sbr.bwArray[i];
            float f = fArr[i2];
            float[] fArr2 = sbr.bwArray_prev[i];
            float f2 = fArr2[i2];
            if (f < f2) {
                fArr[i2] = (f * 0.75f) + (f2 * 0.25f);
            } else {
                fArr[i2] = (f * 0.90625f) + (f2 * 0.09375f);
            }
            if (fArr[i2] < 0.015625f) {
                fArr[i2] = 0.0f;
            }
            if (fArr[i2] >= 0.99609375f) {
                fArr[i2] = 0.99609375f;
            }
            fArr2[i2] = fArr[i2];
            sbr.bs_invf_mode_prev[i][i2] = sbr.bs_invf_mode[i][i2];
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m13602(SBR sbr, float[][][] fArr, float[][] fArr2, float[][] fArr3, int i) {
        C4407 c4407 = new C4407();
        m13600(sbr, c4407, fArr, i, sbr.numTimeSlotsRate + 6);
        float f = c4407.f15187;
        if (f == 0.0f) {
            float[] fArr4 = fArr3[i];
            fArr4[0] = 0.0f;
            fArr4[1] = 0.0f;
        } else {
            float f2 = 1.0f / f;
            float[] fArr5 = fArr3[i];
            float[] fArr6 = c4407.f15182;
            float f3 = fArr6[0];
            float[] fArr7 = c4407.f15185;
            float f4 = f3 * fArr7[0];
            float f5 = fArr6[1];
            float f6 = fArr7[1];
            float[] fArr8 = c4407.f15183;
            float f7 = fArr8[0];
            float[] fArr9 = c4407.f15184;
            fArr5[0] = ((f4 - (f5 * f6)) - (f7 * fArr9[0])) * f2;
            fArr5[1] = (((f5 * fArr7[0]) + (fArr6[0] * f6)) - (fArr8[1] * fArr9[0])) * f2;
        }
        float f8 = c4407.f15184[0];
        if (f8 == 0.0f) {
            float[] fArr10 = fArr2[i];
            fArr10[0] = 0.0f;
            fArr10[1] = 0.0f;
        } else {
            float f9 = 1.0f / f8;
            float[] fArr11 = fArr2[i];
            float[] fArr12 = c4407.f15182;
            float f10 = fArr12[0];
            float[] fArr13 = fArr3[i];
            float f11 = fArr13[0];
            float[] fArr14 = c4407.f15185;
            float f12 = f10 + (f11 * fArr14[0]);
            float f13 = fArr13[1];
            float f14 = fArr14[1];
            fArr11[0] = (-(f12 + (f13 * f14))) * f9;
            fArr11[1] = (-((fArr12[1] + (f13 * fArr14[0])) - (fArr13[0] * f14))) * f9;
        }
        float[] fArr15 = fArr2[i];
        float f15 = fArr15[0];
        float f16 = fArr15[1];
        if ((f15 * f15) + (f16 * f16) < 16.0f) {
            float[] fArr16 = fArr3[i];
            float f17 = fArr16[0];
            float f18 = fArr16[1];
            if ((f17 * f17) + (f18 * f18) < 16.0f) {
                return;
            }
        }
        fArr15[0] = 0.0f;
        fArr15[1] = 0.0f;
        float[] fArr17 = fArr3[i];
        fArr17[0] = 0.0f;
        fArr17[1] = 0.0f;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13603(SBR sbr, float[][][] fArr, float[][][] fArr2, int i) {
        Class cls = Float.TYPE;
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) cls, 64, 2);
        float[][] fArr4 = (float[][]) Array.newInstance((Class<?>) cls, 64, 2);
        int i2 = sbr.tHFAdj;
        int[] iArr = sbr.t_E[i];
        int i3 = 0;
        int i4 = iArr[0];
        int i5 = iArr[sbr.L_E[i]];
        m13601(sbr, i);
        if (i == 0 && sbr.Reset) {
            m13605(sbr);
        }
        for (int i6 = 0; i6 < sbr.noPatches; i6++) {
            int i7 = i3;
            while (i7 < sbr.patchNoSubbands[i6]) {
                int i8 = sbr.kx + i7;
                for (int i9 = i3; i9 < i6; i9++) {
                    i8 += sbr.patchNoSubbands[i9];
                }
                int i10 = sbr.patchStartSubband[i6] + i7;
                float f = sbr.bwArray[i][sbr.table_map_k_to_g[i8]];
                float f2 = f * f;
                if (f2 > 0.0f) {
                    m13602(sbr, fArr, fArr3, fArr4, i10);
                    float[] fArr5 = fArr3[i10];
                    float f3 = fArr5[i3] * f;
                    float[] fArr6 = fArr4[i10];
                    float f4 = fArr6[i3] * f2;
                    float f5 = fArr5[1] * f;
                    float f6 = fArr6[1] * f2;
                    float[] fArr7 = fArr[(i4 - 2) + i2][i10];
                    float f7 = fArr7[i3];
                    float[] fArr8 = fArr[(i4 - 1) + i2][i10];
                    float f8 = fArr8[i3];
                    float f9 = fArr7[1];
                    float f10 = fArr8[1];
                    int i11 = i4;
                    while (i11 < i5) {
                        int i12 = i11 + i2;
                        float[] fArr9 = fArr[i12][i10];
                        float f11 = fArr9[0];
                        float f12 = fArr9[1];
                        float[] fArr10 = fArr2[i12][i8];
                        fArr10[0] = f11 + ((((f3 * f8) - (f5 * f10)) + (f4 * f7)) - (f6 * f9));
                        fArr10[1] = f12 + (f5 * f8) + (f3 * f10) + (f7 * f6) + (f9 * f4);
                        i11++;
                        f9 = f10;
                        f7 = f8;
                        f10 = f12;
                        f8 = f11;
                    }
                } else {
                    for (int i13 = i4; i13 < i5; i13++) {
                        int i14 = i13 + i2;
                        float[] fArr11 = fArr2[i14][i8];
                        float[] fArr12 = fArr[i14][i10];
                        fArr11[0] = fArr12[0];
                        fArr11[1] = fArr12[1];
                    }
                }
                i7++;
                i3 = 0;
            }
        }
        if (sbr.Reset) {
            C3247.m10909(sbr);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static float m13604(int i, int i2) {
        if (i == 1) {
            return i2 == 0 ? 0.6f : 0.75f;
        }
        if (i == 2) {
            return 0.9f;
        }
        if (i != 3) {
            return i2 == 1 ? 0.6f : 0.0f;
        }
        return 0.98f;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m13605(SBR sbr) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5 = sbr.k0;
        int i6 = sbr.kx;
        int i7 = f15181[sbr.sample_rate.getIndex()];
        sbr.noPatches = 0;
        if (i7 < sbr.kx + sbr.M) {
            int i8 = 0;
            i = 0;
            while (sbr.f_master[i8] < i7) {
                i = i8 + 1;
                i8 = i;
            }
        } else {
            i = sbr.N_master;
        }
        if (sbr.N_master == 0) {
            sbr.noPatches = 0;
            sbr.patchNoSubbands[0] = 0;
            sbr.patchStartSubband[0] = 0;
            return;
        }
        do {
            int i9 = i + 1;
            do {
                i9--;
                i2 = sbr.f_master[i9];
                i3 = sbr.k0;
                i4 = ((i2 - 2) + i3) % 2;
            } while (i2 > ((i3 - 1) + i5) - i4);
            sbr.patchNoSubbands[sbr.noPatches] = Math.max(i2 - i6, 0);
            int[] iArr2 = sbr.patchStartSubband;
            int i10 = sbr.noPatches;
            int i11 = sbr.k0 - i4;
            iArr = sbr.patchNoSubbands;
            iArr2[i10] = i11 - iArr[i10];
            if (iArr[i10] > 0) {
                sbr.noPatches = i10 + 1;
                i5 = i2;
                i6 = i5;
            } else {
                i5 = sbr.kx;
            }
            if (sbr.f_master[i] - i2 < 3) {
                i = sbr.N_master;
            }
        } while (i2 != sbr.kx + sbr.M);
        int i12 = sbr.noPatches;
        if (iArr[i12 - 1] < 3 && i12 > 1) {
            sbr.noPatches = i12 - 1;
        }
        sbr.noPatches = Math.min(sbr.noPatches, 5);
    }
}
