package net.sourceforge.jaad.aac.ps;

import defpackage.C4121;
import defpackage.InterfaceC3459;
import defpackage.InterfaceC3634;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.syntax.IBitStream;

/* loaded from: classes2.dex */
public class PS implements InterfaceC3634, InterfaceC3459 {
    public float[] P_PeakDecayNrg;
    public float[] P_SmoothPeakDecayDiffNrg_prev;
    public float[] P_prev;
    public float alpha_decay;
    public float alpha_smooth;
    public int decay_cutoff;
    public int[] delay_D;
    public float[][][] delay_Qmf;
    public float[][][][] delay_Qmf_ser;
    public float[][][] delay_SubQmf;
    public float[][][][] delay_SubQmf_ser;
    public int[] delay_buf_index_delay;
    public int[] delay_buf_index_ser;
    public boolean enable_ext;
    public boolean enable_icc;
    public boolean enable_iid;
    public boolean enable_ipdopd;
    public int frame_class;
    public int[] group_border;
    public float[][] h11_prev;
    public float[][] h12_prev;
    public float[][] h21_prev;
    public float[][] h22_prev;
    public boolean header_read;
    public C4121 hyb;
    public int[][] icc_index;
    public int icc_mode;
    public int[][] iid_index;
    public int iid_mode;
    public int[][] ipd_index;
    public int[] ipd_index_1;
    public int[] ipd_index_2;
    public int ipd_mode;
    public float[][][] ipd_prev;
    public int[] map_group2bk;
    public int nr_allpass_bands;
    public int nr_icc_par;
    public int nr_iid_par;
    public int nr_ipdopd_par;
    public int nr_par_bands;
    public int numTimeSlotsRate;
    public int num_env;
    public int num_groups;
    public int num_hybrid_groups;
    public int[] num_sample_delay_ser;
    public int[][] opd_index;
    public int[] opd_index_1;
    public int[] opd_index_2;
    public float[][][] opd_prev;
    public int phase_hist;
    public int ps_data_available;
    public int saved_delay;
    public boolean use34hybrid_bands;
    public int[] border_position = new int[6];
    public boolean[] iid_dt = new boolean[5];
    public boolean[] icc_dt = new boolean[5];
    public boolean[] ipd_dt = new boolean[5];
    public boolean[] opd_dt = new boolean[5];
    public int[] iid_index_prev = new int[34];
    public int[] icc_index_prev = new int[34];
    public int[] ipd_index_prev = new int[17];
    public int[] opd_index_prev = new int[17];

    public PS(SampleFrequency sampleFrequency, int i) {
        Class cls = Integer.TYPE;
        this.iid_index = (int[][]) Array.newInstance((Class<?>) cls, 5, 34);
        this.icc_index = (int[][]) Array.newInstance((Class<?>) cls, 5, 34);
        this.ipd_index = (int[][]) Array.newInstance((Class<?>) cls, 5, 17);
        this.opd_index = (int[][]) Array.newInstance((Class<?>) cls, 5, 17);
        this.ipd_index_1 = new int[17];
        this.opd_index_1 = new int[17];
        this.ipd_index_2 = new int[17];
        this.opd_index_2 = new int[17];
        this.delay_buf_index_ser = new int[3];
        this.num_sample_delay_ser = new int[3];
        this.delay_D = new int[64];
        this.delay_buf_index_delay = new int[64];
        Class cls2 = Float.TYPE;
        this.delay_Qmf = (float[][][]) Array.newInstance((Class<?>) cls2, 14, 64, 2);
        this.delay_SubQmf = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 32, 2);
        this.delay_Qmf_ser = (float[][][][]) Array.newInstance((Class<?>) cls2, 3, 5, 64, 2);
        this.delay_SubQmf_ser = (float[][][][]) Array.newInstance((Class<?>) cls2, 3, 5, 32, 2);
        this.P_PeakDecayNrg = new float[34];
        this.P_prev = new float[34];
        this.P_SmoothPeakDecayDiffNrg_prev = new float[34];
        this.h11_prev = (float[][]) Array.newInstance((Class<?>) cls2, 50, 2);
        this.h12_prev = (float[][]) Array.newInstance((Class<?>) cls2, 50, 2);
        this.h21_prev = (float[][]) Array.newInstance((Class<?>) cls2, 50, 2);
        this.h22_prev = (float[][]) Array.newInstance((Class<?>) cls2, 50, 2);
        this.ipd_prev = (float[][][]) Array.newInstance((Class<?>) cls2, 20, 2, 2);
        this.opd_prev = (float[][][]) Array.newInstance((Class<?>) cls2, 20, 2, 2);
        this.hyb = new C4121(i);
        this.numTimeSlotsRate = i;
        this.ps_data_available = 0;
        this.saved_delay = 0;
        for (int i2 = 0; i2 < 64; i2++) {
            this.delay_buf_index_delay[i2] = 0;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            this.delay_buf_index_ser[i3] = 0;
            this.num_sample_delay_ser[i3] = InterfaceC3634.f12598[i3];
        }
        this.nr_allpass_bands = 22;
        this.alpha_decay = 0.7659283f;
        this.alpha_smooth = 0.25f;
        for (int i4 = 0; i4 < 35; i4++) {
            this.delay_D[i4] = 14;
        }
        for (int i5 = 35; i5 < 64; i5++) {
            this.delay_D[i5] = 1;
        }
        for (int i6 = 0; i6 < 50; i6++) {
            float[] fArr = this.h11_prev[i6];
            fArr[0] = 1.0f;
            float[] fArr2 = this.h12_prev[i6];
            fArr2[1] = 1.0f;
            fArr[0] = 1.0f;
            fArr2[1] = 1.0f;
        }
        this.phase_hist = 0;
        for (int i7 = 0; i7 < 20; i7++) {
            float[][] fArr3 = this.ipd_prev[i7];
            float[] fArr4 = fArr3[0];
            fArr4[0] = 0.0f;
            fArr4[1] = 0.0f;
            float[] fArr5 = fArr3[1];
            fArr5[0] = 0.0f;
            fArr5[1] = 0.0f;
            float[][] fArr6 = this.opd_prev[i7];
            float[] fArr7 = fArr6[0];
            fArr7[0] = 0.0f;
            fArr7[1] = 0.0f;
            float[] fArr8 = fArr6[1];
            fArr8[0] = 0.0f;
            fArr8[1] = 0.0f;
        }
    }

    private int delta_clip(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private void delta_decode(boolean z, int[] iArr, int[] iArr2, boolean z2, int i, int i2, int i3, int i4) {
        if (!z) {
            for (int i5 = 0; i5 < i; i5++) {
                iArr[i5] = 0;
            }
        } else if (z2) {
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = iArr2[i6 * i2] + iArr[i6];
                iArr[i6] = i7;
                iArr[i6] = delta_clip(i7, i3, i4);
            }
        } else {
            int i8 = iArr[0] + 0;
            iArr[0] = i8;
            iArr[0] = delta_clip(i8, i3, i4);
            for (int i9 = 1; i9 < i; i9++) {
                int i10 = iArr[i9 - 1] + iArr[i9];
                iArr[i9] = i10;
                iArr[i9] = delta_clip(i10, i3, i4);
            }
        }
        if (i2 == 2) {
            for (int i11 = (i << 1) - 1; i11 > 0; i11--) {
                iArr[i11] = iArr[i11 >> 1];
            }
        }
    }

    private void delta_modulo_decode(boolean z, int[] iArr, int[] iArr2, boolean z2, int i, int i2, int i3) {
        if (!z) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = 0;
            }
        } else if (z2) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = iArr2[i5 * i2] + iArr[i5];
                iArr[i5] = i6;
                iArr[i5] = i6 & i3;
            }
        } else {
            int i7 = iArr[0] + 0;
            iArr[0] = i7;
            iArr[0] = i7 & i3;
            for (int i8 = 1; i8 < i; i8++) {
                int i9 = iArr[i8 - 1] + iArr[i8];
                iArr[i8] = i9;
                iArr[i8] = i9 & i3;
            }
        }
        if (i2 == 2) {
            iArr[0] = 0;
            for (int i10 = (i << 1) - 1; i10 > 0; i10--) {
                iArr[i10] = iArr[i10 >> 1];
            }
        }
    }

    private void huff_data(IBitStream iBitStream, boolean z, int i, int[][] iArr, int[][] iArr2, int[] iArr3) throws AACException {
        if (z) {
            for (int i2 = 0; i2 < i; i2++) {
                iArr3[i2] = ps_huff_dec(iBitStream, iArr);
            }
        } else {
            iArr3[0] = ps_huff_dec(iBitStream, iArr2);
            for (int i3 = 1; i3 < i; i3++) {
                iArr3[i3] = ps_huff_dec(iBitStream, iArr2);
            }
        }
    }

    private float magnitude_c(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private void map20indexto34(int[] iArr, int i) {
        int i2 = (iArr[0] + iArr[1]) / 2;
        iArr[1] = i2;
        iArr[2] = i2;
        iArr[3] = i2;
        int i3 = (i2 + i2) / 2;
        iArr[4] = i3;
        iArr[5] = i2;
        iArr[6] = i3;
        iArr[7] = i3;
        iArr[8] = i2;
        iArr[9] = i2;
        iArr[10] = i3;
        iArr[11] = i3;
        iArr[12] = i2;
        iArr[13] = i2;
        iArr[14] = i2;
        iArr[15] = i2;
        iArr[16] = i3;
        if (i == 34) {
            iArr[17] = i3;
            iArr[18] = i2;
            iArr[19] = i2;
            iArr[20] = i2;
            iArr[21] = i2;
            iArr[22] = i2;
            iArr[23] = i2;
            iArr[24] = i3;
            iArr[25] = i3;
            iArr[26] = i3;
            iArr[27] = i3;
            iArr[28] = i2;
            iArr[29] = i2;
            iArr[30] = i2;
            iArr[31] = i2;
            iArr[32] = i2;
            iArr[33] = i2;
        }
    }

    private void ps_data_decode() {
        int i;
        int i2;
        int i3;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (this.ps_data_available == 0) {
            this.num_env = 0;
        }
        int i4 = 0;
        while (true) {
            i = this.num_env;
            i2 = 1;
            if (i4 >= i) {
                break;
            }
            int i5 = this.iid_mode;
            int i6 = i5 < 3 ? 7 : 15;
            if (i4 == 0) {
                iArr = this.iid_index_prev;
                iArr3 = this.icc_index_prev;
                iArr4 = this.ipd_index_prev;
                iArr2 = this.opd_index_prev;
            } else {
                int i7 = i4 - 1;
                iArr = this.iid_index[i7];
                int[] iArr5 = this.icc_index[i7];
                int[] iArr6 = this.ipd_index[i7];
                iArr2 = this.opd_index[i7];
                iArr3 = iArr5;
                iArr4 = iArr6;
            }
            delta_decode(this.enable_iid, this.iid_index[i4], iArr, this.iid_dt[i4], this.nr_iid_par, (i5 == 0 || i5 == 3) ? 2 : 1, -i6, i6);
            boolean z = this.enable_icc;
            int[] iArr7 = this.icc_index[i4];
            boolean z2 = this.icc_dt[i4];
            int i8 = this.nr_icc_par;
            int i9 = this.icc_mode;
            delta_decode(z, iArr7, iArr3, z2, i8, (i9 == 0 || i9 == 3) ? 2 : 1, 0, 7);
            delta_modulo_decode(this.enable_ipdopd, this.ipd_index[i4], iArr4, this.ipd_dt[i4], this.nr_ipdopd_par, 1, 7);
            delta_modulo_decode(this.enable_ipdopd, this.opd_index[i4], iArr2, this.opd_dt[i4], this.nr_ipdopd_par, 1, 7);
            i4++;
        }
        if (i == 0) {
            this.num_env = 1;
            if (this.enable_iid) {
                for (int i10 = 0; i10 < 34; i10++) {
                    this.iid_index[0][i10] = this.iid_index_prev[i10];
                }
            } else {
                for (int i11 = 0; i11 < 34; i11++) {
                    this.iid_index[0][i11] = 0;
                }
            }
            if (this.enable_icc) {
                for (int i12 = 0; i12 < 34; i12++) {
                    this.icc_index[0][i12] = this.icc_index_prev[i12];
                }
            } else {
                for (int i13 = 0; i13 < 34; i13++) {
                    this.icc_index[0][i13] = 0;
                }
            }
            if (this.enable_ipdopd) {
                for (int i14 = 0; i14 < 17; i14++) {
                    this.ipd_index[0][i14] = this.ipd_index_prev[i14];
                    this.opd_index[0][i14] = this.opd_index_prev[i14];
                }
            } else {
                for (int i15 = 0; i15 < 17; i15++) {
                    this.ipd_index[0][i15] = 0;
                    this.opd_index[0][i15] = 0;
                }
            }
        }
        for (int i16 = 0; i16 < 34; i16++) {
            this.iid_index_prev[i16] = this.iid_index[this.num_env - 1][i16];
        }
        for (int i17 = 0; i17 < 34; i17++) {
            this.icc_index_prev[i17] = this.icc_index[this.num_env - 1][i17];
        }
        for (int i18 = 0; i18 < 17; i18++) {
            int[] iArr8 = this.ipd_index_prev;
            int[][] iArr9 = this.ipd_index;
            int i19 = this.num_env;
            iArr8[i18] = iArr9[i19 - 1][i18];
            this.opd_index_prev[i18] = this.opd_index[i19 - 1][i18];
        }
        this.ps_data_available = 0;
        if (this.frame_class != 0) {
            int[] iArr10 = this.border_position;
            iArr10[0] = 0;
            if (iArr10[this.num_env] < this.numTimeSlotsRate) {
                for (int i20 = 0; i20 < 34; i20++) {
                    int[][] iArr11 = this.iid_index;
                    int i21 = this.num_env;
                    iArr11[i21][i20] = iArr11[i21 - 1][i20];
                    int[][] iArr12 = this.icc_index;
                    iArr12[i21][i20] = iArr12[i21 - 1][i20];
                }
                for (int i22 = 0; i22 < 17; i22++) {
                    int[][] iArr13 = this.ipd_index;
                    int i23 = this.num_env;
                    iArr13[i23][i22] = iArr13[i23 - 1][i22];
                    int[][] iArr14 = this.opd_index;
                    iArr14[i23][i22] = iArr14[i23 - 1][i22];
                }
                int i24 = this.num_env + 1;
                this.num_env = i24;
                this.border_position[i24] = this.numTimeSlotsRate;
            }
            int i25 = 1;
            while (true) {
                int i26 = this.num_env;
                if (i25 >= i26) {
                    break;
                }
                int i27 = this.numTimeSlotsRate - (i26 - i25);
                int[] iArr15 = this.border_position;
                int i28 = iArr15[i25];
                if (i28 > i27) {
                    iArr15[i25] = i27;
                } else {
                    int i29 = iArr15[i25 - 1] + 1;
                    if (i28 < i29) {
                        iArr15[i25] = i29;
                    }
                }
                i25++;
            }
        } else {
            this.border_position[0] = 0;
            while (true) {
                i3 = this.num_env;
                if (i2 >= i3) {
                    break;
                }
                this.border_position[i2] = (this.numTimeSlotsRate * i2) / i3;
                i2++;
            }
            this.border_position[i3] = this.numTimeSlotsRate;
        }
        if (this.use34hybrid_bands) {
            for (int i30 = 0; i30 < this.num_env; i30++) {
                int i31 = this.iid_mode;
                if (i31 != 2 && i31 != 5) {
                    map20indexto34(this.iid_index[i30], 34);
                }
                int i32 = this.icc_mode;
                if (i32 != 2 && i32 != 5) {
                    map20indexto34(this.icc_index[i30], 34);
                }
                int i33 = this.ipd_mode;
                if (i33 != 2 && i33 != 5) {
                    map20indexto34(this.ipd_index[i30], 17);
                    map20indexto34(this.opd_index[i30], 17);
                }
            }
        }
    }

    private void ps_decorrelate(float[][][] fArr, float[][][] fArr2, float[][][] fArr3, float[][][] fArr4) {
        int i;
        float f;
        float f2;
        int i2;
        char c;
        float[] fArr5;
        float[] fArr6;
        char c2;
        char c3;
        char c4;
        int i3;
        int i4 = 3;
        int[] iArr = new int[3];
        Class cls = Float.TYPE;
        float[][] fArr7 = (float[][]) Array.newInstance((Class<?>) cls, 32, 34);
        float[][] fArr8 = (float[][]) Array.newInstance((Class<?>) cls, 32, 34);
        float[] fArr9 = new float[2];
        float[][] fArr10 = this.use34hybrid_bands ? InterfaceC3634.f12606 : InterfaceC3634.f12605;
        char c5 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            for (int i6 = 0; i6 < 34; i6++) {
                fArr7[i5][i6] = 0.0f;
            }
        }
        int i7 = 0;
        while (true) {
            i = 1;
            if (i7 >= this.num_groups) {
                break;
            }
            int i8 = this.map_group2bk[i7] & (-4097);
            int i9 = i7 < this.num_hybrid_groups ? this.group_border[i7] + 1 : this.group_border[i7 + 1];
            for (int i10 = this.group_border[i7]; i10 < i9; i10++) {
                for (int i11 = this.border_position[0]; i11 < this.border_position[this.num_env]; i11++) {
                    if (i7 < this.num_hybrid_groups) {
                        float[] fArr11 = fArr3[i11][i10];
                        fArr9[0] = fArr11[0];
                        fArr9[1] = fArr11[1];
                    } else {
                        float[] fArr12 = fArr[i11][i10];
                        fArr9[0] = fArr12[0];
                        fArr9[1] = fArr12[1];
                    }
                    float[] fArr13 = fArr7[i11];
                    float f3 = fArr13[i8];
                    float f4 = fArr9[0];
                    float f5 = fArr9[1];
                    fArr13[i8] = f3 + (f4 * f4) + (f5 * f5);
                }
            }
            i7++;
        }
        int i12 = 0;
        while (true) {
            f = 1.0f;
            if (i12 >= this.nr_par_bands) {
                break;
            }
            for (int i13 = this.border_position[c5]; i13 < this.border_position[this.num_env]; i13++) {
                float[] fArr14 = this.P_PeakDecayNrg;
                float f6 = fArr14[i12] * this.alpha_decay;
                fArr14[i12] = f6;
                float[] fArr15 = fArr7[i13];
                float f7 = fArr15[i12];
                if (f6 < f7) {
                    fArr14[i12] = f7;
                }
                float[] fArr16 = this.P_SmoothPeakDecayDiffNrg_prev;
                float f8 = fArr16[i12];
                float f9 = (fArr14[i12] - fArr15[i12]) - f8;
                float f10 = this.alpha_smooth;
                float f11 = f8 + (f9 * f10);
                fArr16[i12] = f11;
                float[] fArr17 = this.P_prev;
                float f12 = fArr17[i12];
                float f13 = f12 + ((fArr15[i12] - f12) * f10);
                fArr17[i12] = f13;
                float f14 = f11 * 1.5f;
                if (f14 <= f13) {
                    fArr8[i13][i12] = 1.0f;
                } else {
                    fArr8[i13][i12] = f13 / f14;
                }
            }
            i12++;
            c5 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < this.num_groups) {
            int i16 = i14 < this.num_hybrid_groups ? this.group_border[i14] + i : this.group_border[i14 + 1];
            int i17 = this.group_border[i14];
            while (i17 < i16) {
                float[] fArr18 = new float[i4];
                if (i14 < this.num_hybrid_groups || i17 <= (i3 = this.decay_cutoff)) {
                    f2 = f;
                } else {
                    int i18 = i3 - i17;
                    f2 = i18 <= -20 ? 0.0f : (i18 * 0.05f) + f;
                }
                for (int i19 = 0; i19 < i4; i19++) {
                    fArr18[i19] = InterfaceC3634.f12593[i19] * f2;
                }
                int i20 = this.saved_delay;
                for (int i21 = 0; i21 < i4; i21++) {
                    iArr[i21] = this.delay_buf_index_ser[i21];
                }
                int i22 = this.border_position[0];
                while (i22 < this.border_position[this.num_env]) {
                    float[] fArr19 = new float[2];
                    float[] fArr20 = new float[2];
                    float[] fArr21 = new float[2];
                    int i23 = this.num_hybrid_groups;
                    if (i14 < i23) {
                        float[] fArr22 = fArr3[i22][i17];
                        fArr9[0] = fArr22[0];
                        fArr9[i] = fArr22[i];
                    } else {
                        float[] fArr23 = fArr[i22][i17];
                        fArr9[0] = fArr23[0];
                        fArr9[i] = fArr23[i];
                    }
                    if (i17 <= this.nr_allpass_bands || i14 < i23) {
                        i2 = i16;
                        float[] fArr24 = new float[2];
                        if (i14 < i23) {
                            float[] fArr25 = this.delay_SubQmf[i20][i17];
                            c = 0;
                            fArr20[0] = fArr25[0];
                            fArr20[1] = fArr25[1];
                            fArr25[0] = fArr9[0];
                            fArr25[1] = fArr9[1];
                            float[] fArr26 = fArr10[i17];
                            fArr24[0] = fArr26[0];
                            fArr24[1] = fArr26[1];
                        } else {
                            c = 0;
                            float[] fArr27 = this.delay_Qmf[i20][i17];
                            fArr20[0] = fArr27[0];
                            fArr20[1] = fArr27[1];
                            fArr27[0] = fArr9[0];
                            fArr27[1] = fArr9[1];
                            float[] fArr28 = InterfaceC3634.f12604[i17];
                            fArr24[0] = fArr28[0];
                            fArr24[1] = fArr28[1];
                        }
                        float f15 = fArr19[c] * fArr24[c];
                        float f16 = fArr20[1];
                        float f17 = fArr24[1];
                        float f18 = f15 + (f16 * f17);
                        fArr19[c] = f18;
                        float f19 = (f16 * fArr24[c]) - (fArr20[c] * f17);
                        fArr19[1] = f19;
                        fArr21[c] = f18;
                        fArr21[1] = f19;
                        int i24 = 0;
                        while (i24 < 3) {
                            float[] fArr29 = new float[2];
                            int i25 = this.num_hybrid_groups;
                            if (i14 < i25) {
                                fArr6 = fArr9;
                                float[] fArr30 = this.delay_SubQmf_ser[i24][iArr[i24]][i17];
                                c2 = 0;
                                fArr20[0] = fArr30[0];
                                c3 = 1;
                                fArr20[1] = fArr30[1];
                                if (this.use34hybrid_bands) {
                                    float[] fArr31 = InterfaceC3634.f12609[i17][i24];
                                    fArr29[0] = fArr31[0];
                                    fArr29[1] = fArr31[1];
                                } else {
                                    float[] fArr32 = InterfaceC3634.f12608[i17][i24];
                                    fArr29[0] = fArr32[0];
                                    fArr29[1] = fArr32[1];
                                }
                            } else {
                                fArr6 = fArr9;
                                c2 = 0;
                                c3 = 1;
                                float[] fArr33 = this.delay_Qmf_ser[i24][iArr[i24]][i17];
                                fArr20[0] = fArr33[0];
                                fArr20[1] = fArr33[1];
                                float[] fArr34 = InterfaceC3634.f12607[i17][i24];
                                fArr29[0] = fArr34[0];
                                fArr29[1] = fArr34[1];
                            }
                            float f20 = fArr20[c2] * fArr29[c2];
                            float f21 = fArr20[c3];
                            float f22 = fArr29[c3];
                            float f23 = f20 + (f21 * f22);
                            fArr19[c2] = f23;
                            float f24 = (f21 * fArr29[c2]) - (fArr20[c2] * f22);
                            fArr19[c3] = f24;
                            float f25 = f23 + (-(fArr18[i24] * fArr21[c2]));
                            fArr19[c2] = f25;
                            float f26 = f24 + (-(fArr18[i24] * fArr21[c3]));
                            fArr19[c3] = f26;
                            float f27 = fArr21[c2] + (fArr18[i24] * f25);
                            float f28 = fArr21[c3] + (fArr18[i24] * f26);
                            if (i14 < i25) {
                                float[] fArr35 = this.delay_SubQmf_ser[i24][iArr[i24]][i17];
                                c4 = 0;
                                fArr35[0] = f27;
                                fArr35[c3] = f28;
                            } else {
                                c4 = 0;
                                float[] fArr36 = this.delay_Qmf_ser[i24][iArr[i24]][i17];
                                fArr36[0] = f27;
                                fArr36[c3] = f28;
                            }
                            fArr21[c4] = fArr19[c4];
                            fArr21[c3] = fArr19[c3];
                            i24++;
                            fArr9 = fArr6;
                        }
                        fArr5 = fArr9;
                    } else {
                        float[] fArr37 = this.delay_Qmf[this.delay_buf_index_delay[i17]][i17];
                        float f29 = fArr37[0];
                        fArr19[0] = f29;
                        float f30 = fArr37[1];
                        fArr19[1] = f30;
                        fArr21[0] = f29;
                        fArr21[1] = f30;
                        fArr37[0] = fArr9[0];
                        fArr37[1] = fArr9[1];
                        fArr5 = fArr9;
                        i2 = i16;
                    }
                    int i26 = this.map_group2bk[i14] & (-4097);
                    float[] fArr38 = fArr8[i22];
                    float f31 = fArr38[i26] * fArr21[0];
                    fArr21[0] = f31;
                    float f32 = fArr38[i26] * fArr21[1];
                    fArr21[1] = f32;
                    int i27 = this.num_hybrid_groups;
                    if (i14 < i27) {
                        float[] fArr39 = fArr4[i22][i17];
                        fArr39[0] = f31;
                        fArr39[1] = f32;
                    } else {
                        float[] fArr40 = fArr2[i22][i17];
                        fArr40[0] = f31;
                        fArr40[1] = f32;
                    }
                    int i28 = i20 + 1;
                    i20 = i28 >= 2 ? 0 : i28;
                    if (i17 > this.nr_allpass_bands && i14 >= i27) {
                        int[] iArr2 = this.delay_buf_index_delay;
                        int i29 = iArr2[i17] + 1;
                        iArr2[i17] = i29;
                        if (i29 >= this.delay_D[i17]) {
                            iArr2[i17] = 0;
                        }
                    }
                    int i30 = 0;
                    for (int i31 = 3; i30 < i31; i31 = 3) {
                        int i32 = iArr[i30] + 1;
                        iArr[i30] = i32;
                        if (i32 >= this.num_sample_delay_ser[i30]) {
                            iArr[i30] = 0;
                        }
                        i30++;
                    }
                    i22++;
                    i = 1;
                    i16 = i2;
                    fArr9 = fArr5;
                }
                i17++;
                i15 = i20;
                i16 = i16;
                fArr9 = fArr9;
                i4 = 3;
                f = 1.0f;
            }
            i14++;
            fArr9 = fArr9;
            i4 = 3;
            f = 1.0f;
        }
        this.saved_delay = i15;
        for (int i33 = 0; i33 < 3; i33++) {
            this.delay_buf_index_ser[i33] = iArr[i33];
        }
    }

    private int ps_extension(IBitStream iBitStream, int i, int i2) throws AACException {
        long position = iBitStream.getPosition();
        if (i == 0) {
            boolean bool = iBitStream.readBool();
            this.enable_ipdopd = bool;
            if (bool) {
                for (int i3 = 0; i3 < this.num_env; i3++) {
                    this.ipd_dt[i3] = iBitStream.readBool();
                    huff_data(iBitStream, this.ipd_dt[i3], this.nr_ipdopd_par, InterfaceC3459.f11948, InterfaceC3459.f11947, this.ipd_index[i3]);
                    this.opd_dt[i3] = iBitStream.readBool();
                    huff_data(iBitStream, this.opd_dt[i3], this.nr_ipdopd_par, InterfaceC3459.f11950, InterfaceC3459.f11949, this.opd_index[i3]);
                }
            }
            iBitStream.readBit();
        }
        return (int) (iBitStream.getPosition() - position);
    }

    private int ps_huff_dec(IBitStream iBitStream, int[][] iArr) throws AACException {
        int i = 0;
        while (i >= 0) {
            i = iArr[i][iBitStream.readBit()];
        }
        return i + 31;
    }

    private void ps_mix_phase(float[][][] fArr, float[][][] fArr2, float[][][] fArr3, float[][][] fArr4) {
        int i;
        float[] fArr5;
        int i2;
        float[] fArr6;
        float[] fArr7;
        float f;
        float f2;
        float f3;
        float f4;
        char c;
        char c2;
        char c3;
        float f5;
        float f6;
        float f7;
        float[] fArr8 = new float[2];
        float[] fArr9 = new float[2];
        float[] fArr10 = new float[2];
        float[] fArr11 = new float[2];
        float[] fArr12 = new float[2];
        float[] fArr13 = new float[2];
        float[] fArr14 = new float[2];
        float[] fArr15 = new float[2];
        float[] fArr16 = new float[2];
        float[] fArr17 = new float[2];
        float[] fArr18 = new float[2];
        float[] fArr19 = new float[2];
        float[] fArr20 = new float[2];
        float[] fArr21 = new float[2];
        float[] fArr22 = new float[2];
        float[] fArr23 = new float[2];
        if (this.iid_mode >= 3) {
            i = 15;
            fArr5 = InterfaceC3634.f12623;
        } else {
            i = 7;
            fArr5 = InterfaceC3634.f12622;
        }
        int i3 = this.ipd_mode;
        int i4 = (i3 == 0 || i3 == 3) ? 11 : this.nr_ipdopd_par;
        int i5 = 0;
        while (i5 < this.num_groups) {
            int i6 = this.map_group2bk[i5] & (-4097);
            float[] fArr24 = fArr18;
            float[] fArr25 = fArr17;
            int i7 = i5 < this.num_hybrid_groups ? this.group_border[i5] + 1 : this.group_border[i5 + 1];
            int i8 = 0;
            while (i8 < this.num_env) {
                float[] fArr26 = fArr16;
                if (this.icc_mode < 3) {
                    int i9 = this.iid_index[i8][i6];
                    float f8 = fArr5[i + i9];
                    float f9 = fArr5[i - i9];
                    float[] fArr27 = InterfaceC3634.f12610;
                    i2 = i5;
                    int i10 = this.icc_index[i8][i6];
                    float f10 = fArr27[i10];
                    float f11 = InterfaceC3634.f12611[i10];
                    fArr6 = fArr23;
                    fArr7 = fArr22;
                    if (this.iid_mode >= 3) {
                        if (i9 < 0) {
                            f5 = InterfaceC3634.f12614[-i9][i10];
                            f7 = InterfaceC3634.f12615[-i9][i10];
                            f6 = -f7;
                            float f12 = f5 * f10;
                            float f13 = f6 * f11;
                            float f14 = f6 * f10;
                            float f15 = f5 * f11;
                            fArr8[0] = (f12 - f13) * f9;
                            fArr9[0] = (f12 + f13) * f8;
                            fArr10[0] = f9 * (f14 + f15);
                            fArr11[0] = f8 * (f14 - f15);
                            c = 0;
                        } else {
                            f5 = InterfaceC3634.f12614[i9][i10];
                            f6 = InterfaceC3634.f12615[i9][i10];
                            float f122 = f5 * f10;
                            float f132 = f6 * f11;
                            float f142 = f6 * f10;
                            float f152 = f5 * f11;
                            fArr8[0] = (f122 - f132) * f9;
                            fArr9[0] = (f122 + f132) * f8;
                            fArr10[0] = f9 * (f142 + f152);
                            fArr11[0] = f8 * (f142 - f152);
                            c = 0;
                        }
                    } else if (i9 < 0) {
                        f5 = InterfaceC3634.f12612[-i9][i10];
                        f7 = InterfaceC3634.f12613[-i9][i10];
                        f6 = -f7;
                        float f1222 = f5 * f10;
                        float f1322 = f6 * f11;
                        float f1422 = f6 * f10;
                        float f1522 = f5 * f11;
                        fArr8[0] = (f1222 - f1322) * f9;
                        fArr9[0] = (f1222 + f1322) * f8;
                        fArr10[0] = f9 * (f1422 + f1522);
                        fArr11[0] = f8 * (f1422 - f1522);
                        c = 0;
                    } else {
                        f5 = InterfaceC3634.f12612[i9][i10];
                        f6 = InterfaceC3634.f12613[i9][i10];
                        float f12222 = f5 * f10;
                        float f13222 = f6 * f11;
                        float f14222 = f6 * f10;
                        float f15222 = f5 * f11;
                        fArr8[0] = (f12222 - f13222) * f9;
                        fArr9[0] = (f12222 + f13222) * f8;
                        fArr10[0] = f9 * (f14222 + f15222);
                        fArr11[0] = f8 * (f14222 - f15222);
                        c = 0;
                    }
                } else {
                    i2 = i5;
                    fArr6 = fArr23;
                    fArr7 = fArr22;
                    if (this.iid_mode >= 3) {
                        int iAbs = Math.abs(this.iid_index[i8][i6]);
                        float[][] fArr28 = InterfaceC3634.f12617;
                        int i11 = this.iid_index[i8][i6];
                        float[] fArr29 = fArr28[i + i11];
                        int i12 = this.icc_index[i8][i6];
                        f3 = fArr29[i12];
                        f = fArr28[30 - (i11 + i)][i12];
                        f4 = InterfaceC3634.f12619[iAbs][i12];
                        f2 = InterfaceC3634.f12621[iAbs][i12];
                    } else {
                        int iAbs2 = Math.abs(this.iid_index[i8][i6]);
                        float[][] fArr30 = InterfaceC3634.f12616;
                        int i13 = this.iid_index[i8][i6];
                        float[] fArr31 = fArr30[i + i13];
                        int i14 = this.icc_index[i8][i6];
                        float f16 = fArr31[i14];
                        f = fArr30[14 - (i13 + i)][i14];
                        float f17 = InterfaceC3634.f12618[iAbs2][i14];
                        f2 = InterfaceC3634.f12620[iAbs2][i14];
                        f3 = f16;
                        f4 = f17;
                    }
                    c = 0;
                    fArr8[0] = f3 * f4 * 1.4142135f;
                    fArr9[0] = f4 * f * 1.4142135f;
                    fArr10[0] = (-f3) * f2 * 1.4142135f;
                    fArr11[0] = f * f2 * 1.4142135f;
                }
                if (!this.enable_ipdopd || i6 >= i4) {
                    c2 = c;
                } else {
                    int i15 = this.phase_hist;
                    float[] fArr32 = this.ipd_prev[i6][i15];
                    fArr20[c] = fArr32[c] * 0.25f;
                    fArr20[1] = fArr32[1] * 0.25f;
                    float[] fArr33 = this.opd_prev[i6][i15];
                    fArr21[c] = fArr33[c] * 0.25f;
                    fArr21[1] = fArr33[1] * 0.25f;
                    float[] fArr34 = InterfaceC3634.f12624;
                    fArr32[c] = fArr34[Math.abs(this.ipd_index[i8][i6])];
                    float[] fArr35 = this.ipd_prev[i6][i15];
                    float[] fArr36 = InterfaceC3634.f12625;
                    fArr35[1] = fArr36[Math.abs(this.ipd_index[i8][i6])];
                    c2 = 0;
                    this.opd_prev[i6][i15][0] = fArr34[Math.abs(this.opd_index[i8][i6])];
                    this.opd_prev[i6][i15][1] = fArr36[Math.abs(this.opd_index[i8][i6])];
                    float f18 = fArr20[0];
                    float[][] fArr37 = this.ipd_prev[i6];
                    float[] fArr38 = fArr37[i15];
                    fArr20[0] = f18 + fArr38[0];
                    fArr20[1] = fArr20[1] + fArr38[1];
                    float f19 = fArr21[0];
                    float[][] fArr39 = this.opd_prev[i6];
                    float[] fArr40 = fArr39[i15];
                    fArr21[0] = f19 + fArr40[0];
                    fArr21[1] = fArr21[1] + fArr40[1];
                    if (i15 == 0) {
                        i15 = 2;
                    }
                    int i16 = i15 - 1;
                    float f20 = fArr20[0];
                    float[] fArr41 = fArr37[i16];
                    fArr20[0] = f20 + (fArr41[0] * 0.5f);
                    fArr20[1] = fArr20[1] + (fArr41[1] * 0.5f);
                    float f21 = fArr21[0];
                    float[] fArr42 = fArr39[i16];
                    fArr21[0] = f21 + (fArr42[0] * 0.5f);
                    fArr21[1] = fArr21[1] + (fArr42[1] * 0.5f);
                    float fMagnitude_c = magnitude_c(fArr21);
                    float fMagnitude_c2 = magnitude_c(fArr20);
                    if (fMagnitude_c != 0.0f) {
                        fArr7[0] = fArr21[0] / fMagnitude_c;
                        fArr7[1] = fArr21[1] / fMagnitude_c;
                    } else {
                        fArr7[0] = 0.0f;
                        fArr7[1] = 0.0f;
                    }
                    float f22 = fMagnitude_c * fMagnitude_c2;
                    if (f22 != 0.0f) {
                        float f23 = fArr21[0];
                        float f24 = fArr20[0];
                        float f25 = fArr21[1];
                        float f26 = fArr20[1];
                        fArr6[0] = ((f23 * f24) + (f25 * f26)) / f22;
                        fArr6[1] = ((f25 * f24) - (f23 * f26)) / f22;
                    } else {
                        fArr6[0] = 0.0f;
                        fArr6[1] = 0.0f;
                    }
                    float f27 = fArr8[0];
                    fArr8[1] = fArr7[1] * f27;
                    fArr9[1] = fArr9[0] * fArr6[1];
                    fArr10[1] = fArr10[0] * fArr7[1];
                    fArr11[1] = fArr11[0] * fArr6[1];
                    fArr8[0] = f27 * fArr7[0];
                    fArr9[0] = fArr9[0] * fArr6[0];
                    fArr10[0] = fArr10[0] * fArr7[0];
                    fArr11[0] = fArr11[0] * fArr6[0];
                }
                int[] iArr = this.border_position;
                int i17 = i8 + 1;
                int i18 = iArr[i17];
                int i19 = iArr[i8];
                float f28 = i18 - i19;
                float f29 = fArr8[c2];
                float[] fArr43 = this.h11_prev[i2];
                fArr26[c2] = (f29 - fArr43[c2]) / f28;
                float f30 = fArr9[c2];
                int i20 = i;
                float[] fArr44 = this.h12_prev[i2];
                fArr25[c2] = (f30 - fArr44[c2]) / f28;
                float f31 = fArr10[c2];
                float[] fArr45 = this.h21_prev[i2];
                fArr24[c2] = (f31 - fArr45[c2]) / f28;
                float f32 = fArr11[c2];
                float[] fArr46 = fArr21;
                float[] fArr47 = this.h22_prev[i2];
                fArr19[c2] = (f32 - fArr47[c2]) / f28;
                fArr12[c2] = fArr43[c2];
                fArr13[c2] = fArr44[c2];
                fArr14[c2] = fArr45[c2];
                fArr15[c2] = fArr47[c2];
                fArr43[c2] = fArr8[c2];
                fArr44[c2] = fArr9[c2];
                fArr45[c2] = fArr10[c2];
                fArr47[c2] = fArr11[c2];
                if (this.enable_ipdopd && i6 < i4) {
                    fArr26[1] = (fArr8[1] - fArr43[1]) / f28;
                    fArr25[1] = (fArr9[1] - fArr44[1]) / f28;
                    fArr24[1] = (fArr10[1] - fArr45[1]) / f28;
                    fArr19[1] = (fArr11[1] - fArr47[1]) / f28;
                    fArr12[1] = fArr43[1];
                    fArr13[1] = fArr44[1];
                    fArr14[1] = fArr45[1];
                    fArr15[1] = fArr47[1];
                    if ((this.map_group2bk[i2] & 4096) != 0) {
                        fArr26[1] = -fArr26[1];
                        fArr25[1] = -fArr25[1];
                        fArr24[1] = -fArr24[1];
                        fArr19[1] = -fArr19[1];
                        fArr12[1] = -fArr12[1];
                        fArr13[1] = -fArr13[1];
                        fArr14[1] = -fArr14[1];
                        fArr15[1] = -fArr15[1];
                    }
                    fArr43[1] = fArr8[1];
                    fArr44[1] = fArr9[1];
                    fArr45[1] = fArr10[1];
                    fArr47[1] = fArr11[1];
                }
                int i21 = i19;
                while (i21 < this.border_position[i17]) {
                    fArr12[0] = fArr12[0] + fArr26[0];
                    fArr13[0] = fArr13[0] + fArr25[0];
                    fArr14[0] = fArr14[0] + fArr24[0];
                    fArr15[0] = fArr15[0] + fArr19[0];
                    if (this.enable_ipdopd && i6 < i4) {
                        fArr12[1] = fArr12[1] + fArr26[1];
                        fArr13[1] = fArr13[1] + fArr25[1];
                        fArr14[1] = fArr14[1] + fArr24[1];
                        fArr15[1] = fArr15[1] + fArr19[1];
                    }
                    int i22 = this.group_border[i2];
                    int i23 = i7;
                    while (i22 < i23) {
                        float[] fArr48 = new float[2];
                        float[] fArr49 = new float[2];
                        int i24 = this.num_hybrid_groups;
                        int i25 = i2;
                        if (i25 < i24) {
                            float[] fArr50 = fArr3[i21][i22];
                            c3 = 0;
                            fArr48[0] = fArr50[0];
                            fArr48[1] = fArr50[1];
                            float[] fArr51 = fArr4[i21][i22];
                            fArr49[0] = fArr51[0];
                            fArr49[1] = fArr51[1];
                        } else {
                            c3 = 0;
                            float[] fArr52 = fArr[i21][i22];
                            fArr48[0] = fArr52[0];
                            fArr48[1] = fArr52[1];
                            float[] fArr53 = fArr2[i21][i22];
                            fArr49[0] = fArr53[0];
                            fArr49[1] = fArr53[1];
                        }
                        fArr20[c3] = (fArr12[c3] * fArr48[c3]) + (fArr14[c3] * fArr49[c3]);
                        fArr20[1] = (fArr12[c3] * fArr48[1]) + (fArr14[c3] * fArr49[1]);
                        fArr46[c3] = (fArr13[c3] * fArr48[c3]) + (fArr15[c3] * fArr49[c3]);
                        fArr46[1] = (fArr13[c3] * fArr48[1]) + (fArr15[c3] * fArr49[1]);
                        float[] fArr54 = fArr8;
                        if (this.enable_ipdopd && i6 < i4) {
                            float f33 = fArr20[c3];
                            float f34 = fArr12[1];
                            float f35 = fArr48[1] * f34;
                            float f36 = fArr14[1];
                            fArr20[c3] = f33 - (f35 + (fArr49[1] * f36));
                            fArr20[1] = fArr20[1] + (f34 * fArr48[c3]) + (f36 * fArr49[c3]);
                            float f37 = fArr46[c3];
                            float f38 = fArr13[1];
                            float f39 = fArr48[1] * f38;
                            float f40 = fArr15[1];
                            fArr46[c3] = f37 - (f39 + (fArr49[1] * f40));
                            fArr46[1] = fArr46[1] + (f38 * fArr48[c3]) + (f40 * fArr49[c3]);
                        }
                        if (i25 < i24) {
                            float[] fArr55 = fArr3[i21][i22];
                            fArr55[c3] = fArr20[c3];
                            fArr55[1] = fArr20[1];
                            float[] fArr56 = fArr4[i21][i22];
                            fArr56[c3] = fArr46[c3];
                            fArr56[1] = fArr46[1];
                        } else {
                            float[] fArr57 = fArr[i21][i22];
                            fArr57[c3] = fArr20[c3];
                            fArr57[1] = fArr20[1];
                            float[] fArr58 = fArr2[i21][i22];
                            fArr58[c3] = fArr46[c3];
                            fArr58[1] = fArr46[1];
                        }
                        i22++;
                        i2 = i25;
                        fArr8 = fArr54;
                    }
                    i21++;
                    i7 = i23;
                }
                int i26 = i7;
                int i27 = i2;
                float[] fArr59 = fArr8;
                int i28 = this.phase_hist + 1;
                this.phase_hist = i28;
                if (i28 == 2) {
                    this.phase_hist = 0;
                }
                i5 = i27;
                fArr8 = fArr59;
                fArr16 = fArr26;
                i = i20;
                fArr21 = fArr46;
                fArr22 = fArr7;
                i7 = i26;
                i8 = i17;
                fArr23 = fArr6;
            }
            i5++;
            fArr18 = fArr24;
            fArr8 = fArr8;
            fArr17 = fArr25;
            i = i;
            fArr21 = fArr21;
        }
    }

    public int decode(IBitStream iBitStream) throws AACException {
        long position = iBitStream.getPosition();
        if (iBitStream.readBool()) {
            this.header_read = true;
            this.use34hybrid_bands = false;
            boolean bool = iBitStream.readBool();
            this.enable_iid = bool;
            if (bool) {
                int bits = iBitStream.readBits(3);
                this.iid_mode = bits;
                this.nr_iid_par = InterfaceC3634.f12589[bits];
                this.nr_ipdopd_par = InterfaceC3634.f12591[bits];
                if (bits == 2 || bits == 5) {
                    this.use34hybrid_bands = true;
                }
                this.ipd_mode = bits;
            }
            boolean bool2 = iBitStream.readBool();
            this.enable_icc = bool2;
            if (bool2) {
                int bits2 = iBitStream.readBits(3);
                this.icc_mode = bits2;
                this.nr_icc_par = InterfaceC3634.f12590[bits2];
                if (bits2 == 2 || bits2 == 5) {
                    this.use34hybrid_bands = true;
                }
            }
            this.enable_ext = iBitStream.readBool();
        }
        if (!this.header_read) {
            this.ps_data_available = 0;
            return 1;
        }
        this.frame_class = iBitStream.readBit();
        int bits3 = iBitStream.readBits(2);
        int[][] iArr = InterfaceC3634.f12592;
        int i = this.frame_class;
        this.num_env = iArr[i][bits3];
        if (i != 0) {
            for (int i2 = 1; i2 < this.num_env + 1; i2++) {
                this.border_position[i2] = iBitStream.readBits(5) + 1;
            }
        }
        if (this.enable_iid) {
            for (int i3 = 0; i3 < this.num_env; i3++) {
                this.iid_dt[i3] = iBitStream.readBool();
                if (this.iid_mode < 3) {
                    huff_data(iBitStream, this.iid_dt[i3], this.nr_iid_par, InterfaceC3459.f11942, InterfaceC3459.f11941, this.iid_index[i3]);
                } else {
                    huff_data(iBitStream, this.iid_dt[i3], this.nr_iid_par, InterfaceC3459.f11944, InterfaceC3459.f11943, this.iid_index[i3]);
                }
            }
        }
        if (this.enable_icc) {
            for (int i4 = 0; i4 < this.num_env; i4++) {
                this.icc_dt[i4] = iBitStream.readBool();
                huff_data(iBitStream, this.icc_dt[i4], this.nr_icc_par, InterfaceC3459.f11946, InterfaceC3459.f11945, this.icc_index[i4]);
            }
        }
        if (this.enable_ext) {
            int bits4 = iBitStream.readBits(4);
            if (bits4 == 15) {
                bits4 += iBitStream.readBits(8);
            }
            int iPs_extension = bits4 * 8;
            while (iPs_extension > 7) {
                int i5 = iPs_extension - 2;
                iPs_extension = i5 - ps_extension(iBitStream, iBitStream.readBits(2), i5);
            }
            iBitStream.skipBits(iPs_extension);
        }
        int position2 = (int) (iBitStream.getPosition() - position);
        this.ps_data_available = 1;
        return position2;
    }

    public int process(float[][][] fArr, float[][][] fArr2) {
        Class cls = Float.TYPE;
        float[][][] fArr3 = (float[][][]) Array.newInstance((Class<?>) cls, 32, 32, 2);
        float[][][] fArr4 = (float[][][]) Array.newInstance((Class<?>) cls, 32, 32, 2);
        ps_data_decode();
        boolean z = this.use34hybrid_bands;
        if (z) {
            this.group_border = InterfaceC3634.f12595;
            this.map_group2bk = InterfaceC3634.f12597;
            this.num_groups = 50;
            this.num_hybrid_groups = 32;
            this.nr_par_bands = 34;
            this.decay_cutoff = 5;
        } else {
            this.group_border = InterfaceC3634.f12594;
            this.map_group2bk = InterfaceC3634.f12596;
            this.num_groups = 22;
            this.num_hybrid_groups = 10;
            this.nr_par_bands = 20;
            this.decay_cutoff = 3;
        }
        this.hyb.m13088(fArr, fArr3, z, this.numTimeSlotsRate);
        ps_decorrelate(fArr, fArr2, fArr3, fArr4);
        ps_mix_phase(fArr, fArr2, fArr3, fArr4);
        this.hyb.m13089(fArr, fArr3, this.use34hybrid_bands, this.numTimeSlotsRate);
        this.hyb.m13089(fArr2, fArr4, this.use34hybrid_bands, this.numTimeSlotsRate);
        return 0;
    }
}
