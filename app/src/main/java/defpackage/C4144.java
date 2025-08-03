package defpackage;

import androidx.core.app.FrameMetricsAggregator;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.sbr.SBR;

/* compiled from: HFAdjustment.java */
/* renamed from: ঌ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4144 implements InterfaceC2848, InterfaceC3911 {

    /* renamed from: ޣ, reason: contains not printable characters */
    public static final float[] f14362 = {0.0318305f, 0.11516383f, 0.2181695f, 0.30150282f, 0.33333334f};

    /* renamed from: ޤ, reason: contains not printable characters */
    public static final int[] f14363 = {1, 0, -1, 0};

    /* renamed from: ޥ, reason: contains not printable characters */
    public static final int[] f14364 = {0, 1, 0, -1};

    /* renamed from: ޱ, reason: contains not printable characters */
    public static final float[] f14365 = {0.5f, 1.0f, 2.0f, 1.0E10f};

    /* renamed from: ޠ, reason: contains not printable characters */
    public float[][] f14366;

    /* renamed from: ޡ, reason: contains not printable characters */
    public float[][] f14367;

    /* renamed from: ޢ, reason: contains not printable characters */
    public float[][] f14368;

    public C4144() {
        Class cls = Float.TYPE;
        this.f14366 = (float[][]) Array.newInstance((Class<?>) cls, 5, 49);
        this.f14367 = (float[][]) Array.newInstance((Class<?>) cls, 5, 49);
        this.f14368 = (float[][]) Array.newInstance((Class<?>) cls, 5, 49);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13122(SBR sbr, C4144 c4144, int i) {
        float[] fArr = new float[49];
        float[] fArr2 = new float[49];
        float[] fArr3 = new float[49];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < sbr.L_E[i]) {
            float f = (i3 == sbr.l_A[i] || i3 == sbr.prevEnvIsShort[i]) ? 0.0f : 1.0f;
            int iM13124 = m13124(sbr, i, i3, i2);
            int i5 = i3 + 1;
            int i6 = i4 + 1;
            if (sbr.t_E[i][i5] > sbr.t_Q[i][i6]) {
                i4 = i6;
            }
            int i7 = i2;
            int i8 = i7;
            int i9 = i8;
            int i10 = i9;
            int i11 = i10;
            while (true) {
                int[] iArr = sbr.N_L;
                int i12 = sbr.bs_limiter_bands;
                if (i7 < iArr[i12]) {
                    int[] iArr2 = sbr.f_table_lim[i12];
                    int i13 = iArr2[i7];
                    int i14 = i7 + 1;
                    int i15 = iArr2[i14];
                    int i16 = i13;
                    float f2 = 0.0f;
                    float f3 = 0.0f;
                    while (i16 < i15) {
                        int i17 = i13;
                        int i18 = iM13124;
                        int i19 = i14;
                        int i20 = i8 + 1;
                        if (sbr.kx + i16 == sbr.f_table_res[sbr.f[i][i3]][i20]) {
                            i8 = i20;
                        }
                        f2 += sbr.E_orig[i][i8][i3];
                        f3 += sbr.E_curr[i][i16][i3];
                        i16++;
                        i13 = i17;
                        iM13124 = i18;
                        i14 = i19;
                    }
                    int i21 = i13;
                    int i22 = i14;
                    float f4 = f2 + 1.0E-12f;
                    float fMin = Math.min((f4 / (f3 + 1.0E-12f)) * f14365[sbr.bs_limiter_gains], 1.0E10f);
                    int i23 = i21;
                    int iM131242 = iM13124;
                    float f5 = 0.0f;
                    while (i23 < i15) {
                        int i24 = iM131242;
                        int i25 = sbr.kx;
                        int i26 = i5;
                        int i27 = i8;
                        int i28 = i9 + 1;
                        if (i23 + i25 == sbr.f_table_noise[i28]) {
                            i9 = i28;
                        }
                        int i29 = i10 + 1;
                        if (i25 + i23 == sbr.f_table_res[sbr.f[i][i3]][i29]) {
                            iM131242 = m13124(sbr, i, i3, i29);
                            i10 = i29;
                        } else {
                            iM131242 = i24;
                        }
                        int i30 = sbr.kx;
                        int i31 = i23 + i30;
                        int i32 = i15;
                        int[] iArr3 = sbr.f_table_res[1];
                        int i33 = i11 + 1;
                        if (i31 == iArr3[i33]) {
                            i11 = i33;
                        }
                        int i34 = sbr.l_A[i];
                        int i35 = ((i3 >= i34 || (sbr.bs_add_harmonic_prev[i][i11] != 0 && sbr.bs_add_harmonic_flag_prev[i])) && i30 + i23 == ((iArr3[i11 + 1] + iArr3[i11]) >> 1)) ? sbr.bs_add_harmonic[i][i11] : 0;
                        float f6 = sbr.Q_div[i][i9][i4];
                        float f7 = sbr.Q_div2[i][i9][i4];
                        int i36 = i4;
                        float[] fArr4 = sbr.E_orig[i][i10];
                        float f8 = fArr4[i3];
                        float f9 = f8 * f7;
                        if (i35 == 0) {
                            fArr3[i23] = 0.0f;
                        } else {
                            float f10 = f8 * f6;
                            fArr3[i23] = f10;
                            f5 += f10;
                        }
                        float f11 = fArr4[i3];
                        float[] fArr5 = fArr3;
                        float[] fArr6 = sbr.E_curr[i][i23];
                        float f12 = f11 / (fArr6[i3] + 1.0f);
                        if (iM131242 == 0 && f == 1.0f) {
                            f12 *= f6;
                        } else if (iM131242 == 1) {
                            f12 *= f7;
                        }
                        if (fMin > f12) {
                            fArr[i23] = f9;
                            fArr2[i23] = f12;
                        } else {
                            fArr[i23] = (f9 * fMin) / f12;
                            fArr2[i23] = fMin;
                        }
                        f5 += fArr6[i3] * fArr2[i23];
                        if (i35 == 0 && i3 != i34) {
                            f5 += fArr[i23];
                        }
                        i23++;
                        i5 = i26;
                        i8 = i27;
                        i15 = i32;
                        i4 = i36;
                        fArr3 = fArr5;
                    }
                    float[] fArr7 = fArr3;
                    int i37 = i15;
                    int i38 = i4;
                    int i39 = iM131242;
                    int i40 = i5;
                    int i41 = i8;
                    float fMin2 = Math.min(f4 / (f5 + 1.0E-12f), 2.5118864f);
                    for (int i42 = i21; i42 < i37; i42++) {
                        c4144.f14366[i3][i42] = (float) Math.sqrt(fArr2[i42] * fMin2);
                        c4144.f14367[i3][i42] = (float) Math.sqrt(fArr[i42] * fMin2);
                        if (fArr7[i42] != 0.0f) {
                            c4144.f14368[i3][i42] = (float) Math.sqrt(r8 * fMin2);
                        } else {
                            c4144.f14368[i3][i42] = 0.0f;
                        }
                    }
                    iM13124 = i39;
                    i7 = i22;
                    i5 = i40;
                    i8 = i41;
                    i4 = i38;
                    fArr3 = fArr7;
                }
            }
            i3 = i5;
            i2 = 0;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m13123(SBR sbr, C4144 c4144, float[][][] fArr, int i) {
        if (sbr.bs_interpol_freq) {
            int i2 = 0;
            while (i2 < sbr.L_E[i]) {
                int[] iArr = sbr.t_E[i];
                int i3 = iArr[i2];
                int i4 = i2 + 1;
                int i5 = iArr[i4];
                float f = i5 - i3;
                if (f == 0.0f) {
                    f = 1.0f;
                }
                for (int i6 = 0; i6 < sbr.M; i6++) {
                    float f2 = 0.0f;
                    for (int i7 = sbr.tHFAdj + i3; i7 < sbr.tHFAdj + i5; i7++) {
                        float[][] fArr2 = fArr[i7];
                        int i8 = sbr.kx;
                        f2 += (fArr2[i6 + i8][0] * fArr2[i6 + i8][0]) + (fArr2[i6 + i8][1] * fArr2[i8 + i6][1]);
                    }
                    sbr.E_curr[i][i6][i2] = f2 / f;
                }
                i2 = i4;
            }
        } else {
            for (int i9 = 0; i9 < sbr.L_E[i]; i9++) {
                int i10 = 0;
                while (true) {
                    int[] iArr2 = sbr.n;
                    int i11 = sbr.f[i][i9];
                    if (i10 < iArr2[i11]) {
                        int[] iArr3 = sbr.f_table_res[i11];
                        int i12 = iArr3[i10];
                        i10++;
                        int i13 = iArr3[i10];
                        for (int i14 = i12; i14 < i13; i14++) {
                            int[] iArr4 = sbr.t_E[i];
                            int i15 = iArr4[i9];
                            int i16 = iArr4[i9 + 1];
                            float f3 = (i16 - i15) * (i13 - i12);
                            if (f3 == 0.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = 0.0f;
                            for (int i17 = i15 + sbr.tHFAdj; i17 < sbr.tHFAdj + i16; i17++) {
                                for (int i18 = i12; i18 < i13; i18++) {
                                    float[] fArr3 = fArr[i17][i18];
                                    float f5 = fArr3[0];
                                    float f6 = fArr3[1];
                                    f4 += (f5 * f5) + (f6 * f6);
                                }
                            }
                            sbr.E_curr[i][i14 - sbr.kx][i9] = f4 / f3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m13124(SBR sbr, int i, int i2, int i3) {
        if (sbr.f[i][i2] != 1) {
            int i4 = i3 * 2;
            int i5 = sbr.N_high;
            int i6 = ((i3 + 1) * 2) - ((i5 & 1) != 0 ? 1 : 0);
            for (int i7 = i4 - ((i5 & 1) != 0 ? 1 : 0); i7 < i6; i7++) {
                if ((i2 >= sbr.l_A[i] || (sbr.bs_add_harmonic_prev[i][i7] != 0 && sbr.bs_add_harmonic_flag_prev[i])) && sbr.bs_add_harmonic[i][i7] == 1) {
                    return 1;
                }
            }
        } else if (i2 >= sbr.l_A[i] || (sbr.bs_add_harmonic_prev[i][i3] != 0 && sbr.bs_add_harmonic_flag_prev[i])) {
            return sbr.bs_add_harmonic[i][i3];
        }
        return 0;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m13125(SBR sbr, float[][][] fArr, int i) {
        C4144 c4144 = new C4144();
        int i2 = sbr.bs_frame_class[i];
        if (i2 == 0) {
            sbr.l_A[i] = -1;
        } else if (i2 == 2) {
            int i3 = sbr.bs_pointer[i];
            if (i3 > 1) {
                sbr.l_A[i] = i3 - 1;
            } else {
                sbr.l_A[i] = -1;
            }
        } else {
            int i4 = sbr.bs_pointer[i];
            if (i4 == 0) {
                sbr.l_A[i] = -1;
            } else {
                sbr.l_A[i] = (sbr.L_E[i] + 1) - i4;
            }
        }
        if (m13123(sbr, c4144, fArr, i) > 0) {
            return 1;
        }
        m13122(sbr, c4144, i);
        m13126(sbr, c4144, fArr, i);
        return 0;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m13126(SBR sbr, C4144 c4144, float[][][] fArr, int i) {
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        int i5 = 1;
        int i6 = 0;
        if (sbr.Reset) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = sbr.index_noise_prev[i];
            i3 = 0;
        }
        int i7 = sbr.psi_is_prev[i];
        int i8 = 0;
        while (i8 < sbr.L_E[i]) {
            int i9 = (i8 == sbr.l_A[i] || i8 == sbr.prevEnvIsShort[i]) ? i5 : i6;
            int i10 = 4;
            int i11 = sbr.bs_smoothing_mode ? i6 : 4;
            if (i9 != 0) {
                i11 = i6;
            }
            if (i3 != 0) {
                for (int i12 = i6; i12 < 4; i12++) {
                    System.arraycopy(c4144.f14366[i8], i6, sbr.G_temp_prev[i][i12], i6, sbr.M);
                    System.arraycopy(c4144.f14367[i8], i6, sbr.Q_temp_prev[i][i12], i6, sbr.M);
                }
                sbr.GQ_ringbuf_index[i] = 4;
                i3 = i6;
            }
            int i13 = sbr.t_E[i][i8];
            while (true) {
                i4 = i8 + 1;
                if (i13 < sbr.t_E[i][i4]) {
                    System.arraycopy(c4144.f14366[i8], i6, sbr.G_temp_prev[i][sbr.GQ_ringbuf_index[i]], i6, sbr.M);
                    System.arraycopy(c4144.f14367[i8], i6, sbr.Q_temp_prev[i][sbr.GQ_ringbuf_index[i]], i6, sbr.M);
                    int i14 = i6;
                    while (i14 < sbr.M) {
                        float f3 = 0.0f;
                        if (i11 != 0) {
                            int i15 = sbr.GQ_ringbuf_index[i];
                            f2 = 0.0f;
                            f = 0.0f;
                            while (i6 <= i10) {
                                float f4 = f14362[i6];
                                i15 += i5;
                                if (i15 >= 5) {
                                    i15 -= 5;
                                }
                                f += sbr.G_temp_prev[i][i15][i14] * f4;
                                f2 += sbr.Q_temp_prev[i][i15][i14] * f4;
                                i6++;
                                i10 = 4;
                            }
                        } else {
                            float[][] fArr2 = sbr.G_temp_prev[i];
                            int i16 = sbr.GQ_ringbuf_index[i];
                            f = fArr2[i16][i14];
                            f2 = sbr.Q_temp_prev[i][i16][i14];
                        }
                        float[] fArr3 = c4144.f14368[i8];
                        if (fArr3[i14] == 0.0f && i9 == 0) {
                            f3 = f2;
                        }
                        i2 = (i2 + 1) & FrameMetricsAggregator.EVERY_DURATION;
                        int i17 = sbr.tHFAdj;
                        float[][] fArr4 = fArr[i13 + i17];
                        int i18 = sbr.kx;
                        float[] fArr5 = fArr4[i14 + i18];
                        float f5 = fArr[i13 + i17][i14 + i18][0] * f;
                        float[] fArr6 = InterfaceC3911.f13530[i2];
                        fArr5[0] = f5 + (fArr6[0] * f3);
                        if (sbr.bs_extension_id == 3 && sbr.bs_extension_data == 42) {
                            fArr[i13 + i17][i14 + i18][0] = 1.642832E7f;
                        }
                        fArr[i13 + i17][i14 + i18][1] = (f * fArr[i13 + i17][i14 + i18][1]) + (f3 * fArr6[1]);
                        int i19 = ((i14 + i18) & 1) != 0 ? -1 : 1;
                        float f6 = fArr3[i14] * f14363[i7];
                        float[] fArr7 = fArr[i13 + i17][i14 + i18];
                        fArr7[0] = fArr7[0] + f6;
                        float f7 = i19 * fArr3[i14] * f14364[i7];
                        float[] fArr8 = fArr[i17 + i13][i18 + i14];
                        fArr8[1] = fArr8[1] + f7;
                        i14++;
                        i5 = 1;
                        i6 = 0;
                        i10 = 4;
                    }
                    int i20 = i5;
                    i7 = (i7 + 1) & 3;
                    int[] iArr = sbr.GQ_ringbuf_index;
                    int i21 = iArr[i] + i20;
                    iArr[i] = i21;
                    if (i21 >= 5) {
                        i6 = 0;
                        iArr[i] = 0;
                    } else {
                        i6 = 0;
                    }
                    i13++;
                    i5 = i20;
                    i10 = 4;
                }
            }
            i8 = i4;
        }
        sbr.index_noise_prev[i] = i2;
        sbr.psi_is_prev[i] = i7;
    }
}
