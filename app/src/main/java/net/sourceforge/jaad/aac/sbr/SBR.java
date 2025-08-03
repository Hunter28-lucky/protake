package net.sourceforge.jaad.aac.sbr;

import defpackage.C3247;
import defpackage.C3509;
import defpackage.C3986;
import defpackage.C4144;
import defpackage.C4406;
import defpackage.InterfaceC2327;
import defpackage.InterfaceC2848;
import defpackage.a1;
import defpackage.s0;
import java.lang.reflect.Array;
import java.util.Arrays;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.ps.PS;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public class SBR implements InterfaceC2848, SyntaxConstants, InterfaceC2327 {
    public int[][][] E;
    public float[][][] E_curr;
    public float[][][] E_orig;
    public int[][] E_prev;
    public int[] GQ_ringbuf_index;
    public float[][][] G_temp_prev;
    public int[] L_E;
    public int[] L_E_prev;
    public int[] L_Q;
    public int M;
    public int M_prev;
    public int N_Q;
    public int N_high;
    public int N_low;
    public int N_master;
    public int[][][] Q;
    public float[][][] Q_div;
    public float[][][] Q_div2;
    public int[][] Q_prev;
    public float[][][] Q_temp_prev;
    public boolean Reset;
    public float[][][][] Xsbr;
    public int[] abs_bord_lead;
    public int[] abs_bord_trail;
    public int[] bs_abs_bord_0;
    public int[] bs_abs_bord_1;
    public int[][] bs_add_harmonic;
    public boolean[] bs_add_harmonic_flag;
    public boolean[] bs_add_harmonic_flag_prev;
    public int[][] bs_add_harmonic_prev;
    public boolean bs_alter_scale;
    public boolean bs_alter_scale_prev;
    public boolean bs_amp_res;
    public boolean bs_coupling;
    public int bs_crc_flag;
    public int[][] bs_df_env;
    public int[][] bs_df_noise;
    public boolean bs_extended_data;
    public int bs_extension_data;
    public int bs_extension_id;
    public int[] bs_frame_class;
    public int bs_freq_scale;
    public int bs_freq_scale_prev;
    public boolean bs_header_flag;
    public boolean bs_interpol_freq;
    public int[][] bs_invf_mode;
    public int[][] bs_invf_mode_prev;
    public int bs_limiter_bands;
    public int bs_limiter_gains;
    public int bs_noise_bands;
    public int bs_noise_bands_prev;
    public int[] bs_num_rel_0;
    public int[] bs_num_rel_1;
    public int[] bs_pointer;
    public int bs_protocol_version;
    public int[][] bs_rel_bord;
    public int[][] bs_rel_bord_0;
    public int[][] bs_rel_bord_1;
    public int bs_samplerate_mode;
    public int bs_sbr_crc_bits;
    public boolean bs_smoothing_mode;
    public int bs_start_freq;
    public int bs_start_freq_prev;
    public int bs_stop_freq;
    public int bs_stop_freq_prev;
    public int bs_xover_band;
    public int bs_xover_band_prev;
    public int bsco;
    public int bsco_prev;
    public float[][] bwArray;
    public float[][] bwArray_prev;
    private final boolean downSampledSBR;
    public int[][] f;
    public int[] f_prev;
    public int[][] f_table_lim;
    public int[] f_table_noise;
    public int[][] f_table_res;
    public int frame;
    public int header_count;
    public int[] index_noise_prev;
    public boolean just_seeked;
    public int k0;
    public int kx;
    public int kx_prev;
    public int[] l_A;
    public int[] l_A_prev;
    public int maxAACLine;
    public int[] n_rel_lead;
    public int[] n_rel_trail;
    public int noPatches;
    public int numTimeSlots;
    public int numTimeSlotsRate;
    public int[] patchNoSubbands;
    public int[] patchStartSubband;
    public int[] prevEnvIsShort;
    public PS ps;
    public boolean psResetFlag;
    public boolean ps_used;
    public int[] psi_is_prev;
    public C3986[] qmfa;
    public s0[] qmfs;
    public int rate;
    public int ret;
    public final SampleFrequency sample_rate;
    public boolean stereo;
    public int tHFAdj;
    public int tHFGen;
    public int[][] t_E;
    public int[][] t_Q;
    public int[] table_map_k_to_g;
    public boolean[] amp_res = new boolean[2];
    public int[] N_L = new int[4];
    public int[] n = new int[2];
    public int[] f_master = new int[64];

    public SBR(boolean z, boolean z2, SampleFrequency sampleFrequency, boolean z3) {
        Class cls = Integer.TYPE;
        this.f_table_res = (int[][]) Array.newInstance((Class<?>) cls, 2, 64);
        this.f_table_noise = new int[64];
        this.f_table_lim = (int[][]) Array.newInstance((Class<?>) cls, 4, 64);
        this.table_map_k_to_g = new int[64];
        this.abs_bord_lead = new int[2];
        this.abs_bord_trail = new int[2];
        this.n_rel_lead = new int[2];
        this.n_rel_trail = new int[2];
        this.L_E = new int[2];
        this.L_E_prev = new int[2];
        this.L_Q = new int[2];
        this.t_E = (int[][]) Array.newInstance((Class<?>) cls, 2, 6);
        this.t_Q = (int[][]) Array.newInstance((Class<?>) cls, 2, 3);
        this.f = (int[][]) Array.newInstance((Class<?>) cls, 2, 6);
        this.f_prev = new int[2];
        Class cls2 = Float.TYPE;
        this.G_temp_prev = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 5, 64);
        this.Q_temp_prev = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 5, 64);
        this.GQ_ringbuf_index = new int[2];
        this.E = (int[][][]) Array.newInstance((Class<?>) cls, 2, 64, 5);
        this.E_prev = (int[][]) Array.newInstance((Class<?>) cls, 2, 64);
        this.E_orig = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 64, 5);
        this.E_curr = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 64, 5);
        this.Q = (int[][][]) Array.newInstance((Class<?>) cls, 2, 64, 2);
        this.Q_div = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 64, 2);
        this.Q_div2 = (float[][][]) Array.newInstance((Class<?>) cls2, 2, 64, 2);
        this.Q_prev = (int[][]) Array.newInstance((Class<?>) cls, 2, 64);
        this.l_A = new int[2];
        this.l_A_prev = new int[2];
        this.bs_invf_mode = (int[][]) Array.newInstance((Class<?>) cls, 2, 5);
        this.bs_invf_mode_prev = (int[][]) Array.newInstance((Class<?>) cls, 2, 5);
        this.bwArray = (float[][]) Array.newInstance((Class<?>) cls2, 2, 64);
        this.bwArray_prev = (float[][]) Array.newInstance((Class<?>) cls2, 2, 64);
        this.patchNoSubbands = new int[64];
        this.patchStartSubband = new int[64];
        this.bs_add_harmonic = (int[][]) Array.newInstance((Class<?>) cls, 2, 64);
        this.bs_add_harmonic_prev = (int[][]) Array.newInstance((Class<?>) cls, 2, 64);
        this.index_noise_prev = new int[2];
        this.psi_is_prev = new int[2];
        this.prevEnvIsShort = new int[2];
        this.qmfa = new C3986[2];
        this.qmfs = new s0[2];
        this.Xsbr = (float[][][][]) Array.newInstance((Class<?>) cls2, 2, 40, 64, 2);
        this.bs_add_harmonic_flag = new boolean[2];
        this.bs_add_harmonic_flag_prev = new boolean[2];
        this.bs_frame_class = new int[2];
        this.bs_rel_bord = (int[][]) Array.newInstance((Class<?>) cls, 2, 9);
        this.bs_rel_bord_0 = (int[][]) Array.newInstance((Class<?>) cls, 2, 9);
        this.bs_rel_bord_1 = (int[][]) Array.newInstance((Class<?>) cls, 2, 9);
        this.bs_pointer = new int[2];
        this.bs_abs_bord_0 = new int[2];
        this.bs_abs_bord_1 = new int[2];
        this.bs_num_rel_0 = new int[2];
        this.bs_num_rel_1 = new int[2];
        this.bs_df_env = (int[][]) Array.newInstance((Class<?>) cls, 2, 9);
        this.bs_df_noise = (int[][]) Array.newInstance((Class<?>) cls, 2, 3);
        this.downSampledSBR = z3;
        this.stereo = z2;
        this.sample_rate = sampleFrequency;
        this.bs_freq_scale = 2;
        this.bs_alter_scale = true;
        this.bs_noise_bands = 2;
        this.bs_limiter_bands = 2;
        this.bs_limiter_gains = 2;
        this.bs_interpol_freq = true;
        this.bs_smoothing_mode = true;
        this.bs_start_freq = 5;
        this.bs_amp_res = true;
        this.bs_samplerate_mode = 1;
        int[] iArr = this.prevEnvIsShort;
        iArr[0] = -1;
        iArr[1] = -1;
        this.header_count = 0;
        this.Reset = true;
        this.tHFGen = 8;
        this.tHFAdj = 2;
        this.bsco = 0;
        this.bsco_prev = 0;
        this.M_prev = 0;
        this.bs_start_freq_prev = -1;
        if (z) {
            this.numTimeSlotsRate = 30;
            this.numTimeSlots = 15;
        } else {
            this.numTimeSlotsRate = 32;
            this.numTimeSlots = 16;
        }
        int[] iArr2 = this.GQ_ringbuf_index;
        iArr2[0] = 0;
        iArr2[1] = 0;
        if (!z2) {
            this.qmfa[0] = new C3986(32);
            this.qmfs[0] = new s0(z3 ? 32 : 64);
            this.qmfs[1] = null;
        } else {
            this.qmfa[0] = new C3986(32);
            this.qmfa[1] = new C3986(32);
            this.qmfs[0] = new s0(z3 ? 32 : 64);
            this.qmfs[1] = new s0(z3 ? 32 : 64);
        }
    }

    private int decodeHuffman(IBitStream iBitStream, int[][] iArr) throws AACException {
        int i = 0;
        while (i >= 0) {
            i = iArr[i][iBitStream.readBit()];
        }
        return i + 64;
    }

    private void invf_mode(IBitStream iBitStream, int i) throws AACException {
        for (int i2 = 0; i2 < this.N_Q; i2++) {
            this.bs_invf_mode[i][i2] = iBitStream.readBits(2);
        }
    }

    private int sbr_channel_pair_element(IBitStream iBitStream) throws AACException {
        if (iBitStream.readBool()) {
            iBitStream.readBits(4);
            iBitStream.readBits(4);
        }
        boolean bool = iBitStream.readBool();
        this.bs_coupling = bool;
        if (bool) {
            int iSbr_grid = sbr_grid(iBitStream, 0);
            if (iSbr_grid > 0) {
                return iSbr_grid;
            }
            int[] iArr = this.bs_frame_class;
            iArr[1] = iArr[0];
            int[] iArr2 = this.L_E;
            iArr2[1] = iArr2[0];
            int[] iArr3 = this.L_Q;
            iArr3[1] = iArr3[0];
            int[] iArr4 = this.bs_pointer;
            iArr4[1] = iArr4[0];
            for (int i = 0; i <= this.L_E[0]; i++) {
                int[][] iArr5 = this.t_E;
                iArr5[1][i] = iArr5[0][i];
                int[][] iArr6 = this.f;
                iArr6[1][i] = iArr6[0][i];
            }
            for (int i2 = 0; i2 <= this.L_Q[0]; i2++) {
                int[][] iArr7 = this.t_Q;
                iArr7[1][i2] = iArr7[0][i2];
            }
            sbr_dtdf(iBitStream, 0);
            sbr_dtdf(iBitStream, 1);
            invf_mode(iBitStream, 0);
            for (int i3 = 0; i3 < this.N_Q; i3++) {
                int[][] iArr8 = this.bs_invf_mode;
                iArr8[1][i3] = iArr8[0][i3];
            }
            sbr_envelope(iBitStream, 0);
            sbr_noise(iBitStream, 0);
            sbr_envelope(iBitStream, 1);
            sbr_noise(iBitStream, 1);
            Arrays.fill(this.bs_add_harmonic[0], 0, 64, 0);
            Arrays.fill(this.bs_add_harmonic[1], 0, 64, 0);
            this.bs_add_harmonic_flag[0] = iBitStream.readBool();
            if (this.bs_add_harmonic_flag[0]) {
                sinusoidal_coding(iBitStream, 0);
            }
            this.bs_add_harmonic_flag[1] = iBitStream.readBool();
            if (this.bs_add_harmonic_flag[1]) {
                sinusoidal_coding(iBitStream, 1);
            }
        } else {
            int[] iArr9 = new int[6];
            int[] iArr10 = new int[3];
            int i4 = this.L_E[0];
            int i5 = this.L_Q[0];
            int i6 = this.bs_frame_class[0];
            for (int i7 = 0; i7 < i4; i7++) {
                iArr9[i7] = this.t_E[0][i7];
            }
            for (int i8 = 0; i8 < i5; i8++) {
                iArr10[i8] = this.t_Q[0][i8];
            }
            int iSbr_grid2 = sbr_grid(iBitStream, 0);
            if (iSbr_grid2 > 0) {
                return iSbr_grid2;
            }
            int iSbr_grid3 = sbr_grid(iBitStream, 1);
            if (iSbr_grid3 > 0) {
                this.bs_frame_class[0] = i6;
                this.L_E[0] = i4;
                this.L_Q[0] = i5;
                for (int i9 = 0; i9 < 6; i9++) {
                    this.t_E[0][i9] = iArr9[i9];
                }
                for (int i10 = 0; i10 < 3; i10++) {
                    this.t_Q[0][i10] = iArr10[i10];
                }
                return iSbr_grid3;
            }
            sbr_dtdf(iBitStream, 0);
            sbr_dtdf(iBitStream, 1);
            invf_mode(iBitStream, 0);
            invf_mode(iBitStream, 1);
            sbr_envelope(iBitStream, 0);
            sbr_envelope(iBitStream, 1);
            sbr_noise(iBitStream, 0);
            sbr_noise(iBitStream, 1);
            Arrays.fill(this.bs_add_harmonic[0], 0, 64, 0);
            Arrays.fill(this.bs_add_harmonic[1], 0, 64, 0);
            this.bs_add_harmonic_flag[0] = iBitStream.readBool();
            if (this.bs_add_harmonic_flag[0]) {
                sinusoidal_coding(iBitStream, 0);
            }
            this.bs_add_harmonic_flag[1] = iBitStream.readBool();
            if (this.bs_add_harmonic_flag[1]) {
                sinusoidal_coding(iBitStream, 1);
            }
        }
        C3509.m11454(this, 0);
        C3509.m11454(this, 1);
        if (this.bs_coupling) {
            C3509.m11457(this);
        }
        boolean bool2 = iBitStream.readBool();
        this.bs_extended_data = bool2;
        if (bool2) {
            int bits = iBitStream.readBits(4);
            if (bits == 15) {
                bits += iBitStream.readBits(8);
            }
            int i11 = bits * 8;
            while (i11 > 7) {
                int bits2 = iBitStream.readBits(2);
                this.bs_extension_id = bits2;
                int iSbr_extension = 2 + sbr_extension(iBitStream, bits2, i11);
                if (iSbr_extension > i11) {
                    return 1;
                }
                i11 -= iSbr_extension;
            }
            if (i11 > 0) {
                iBitStream.readBits(i11);
            }
        }
        return 0;
    }

    private int sbr_data(IBitStream iBitStream) throws AACException {
        this.rate = this.bs_samplerate_mode != 0 ? 2 : 1;
        if (this.stereo) {
            int iSbr_channel_pair_element = sbr_channel_pair_element(iBitStream);
            if (iSbr_channel_pair_element > 0) {
                return iSbr_channel_pair_element;
            }
            return 0;
        }
        int iSbr_single_channel_element = sbr_single_channel_element(iBitStream);
        if (iSbr_single_channel_element > 0) {
            return iSbr_single_channel_element;
        }
        return 0;
    }

    private void sbr_dtdf(IBitStream iBitStream, int i) throws AACException {
        for (int i2 = 0; i2 < this.L_E[i]; i2++) {
            this.bs_df_env[i][i2] = iBitStream.readBit();
        }
        for (int i3 = 0; i3 < this.L_Q[i]; i3++) {
            this.bs_df_noise[i][i3] = iBitStream.readBit();
        }
    }

    private void sbr_envelope(IBitStream iBitStream, int i) throws AACException {
        int[][] iArr;
        int[][] iArr2;
        int i2;
        if (this.L_E[i] == 1 && this.bs_frame_class[i] == 0) {
            this.amp_res[i] = false;
        } else {
            this.amp_res[i] = this.bs_amp_res;
        }
        if (this.bs_coupling && i == 1) {
            if (this.amp_res[i]) {
                iArr = InterfaceC2327.f8847;
                iArr2 = InterfaceC2327.f8848;
            } else {
                iArr = InterfaceC2327.f8843;
                iArr2 = InterfaceC2327.f8844;
            }
            i2 = 1;
        } else {
            if (this.amp_res[i]) {
                iArr = InterfaceC2327.f8845;
                iArr2 = InterfaceC2327.f8846;
            } else {
                iArr = InterfaceC2327.f8841;
                iArr2 = InterfaceC2327.f8842;
            }
            i2 = 0;
        }
        for (int i3 = 0; i3 < this.L_E[i]; i3++) {
            if (this.bs_df_env[i][i3] == 0) {
                if (this.bs_coupling && i == 1) {
                    if (this.amp_res[i]) {
                        this.E[i][0][i3] = iBitStream.readBits(5) << i2;
                    } else {
                        this.E[i][0][i3] = iBitStream.readBits(6) << i2;
                    }
                } else if (this.amp_res[i]) {
                    this.E[i][0][i3] = iBitStream.readBits(6) << i2;
                } else {
                    this.E[i][0][i3] = iBitStream.readBits(7) << i2;
                }
                for (int i4 = 1; i4 < this.n[this.f[i][i3]]; i4++) {
                    this.E[i][i4][i3] = decodeHuffman(iBitStream, iArr2) << i2;
                }
            } else {
                for (int i5 = 0; i5 < this.n[this.f[i][i3]]; i5++) {
                    this.E[i][i5][i3] = decodeHuffman(iBitStream, iArr) << i2;
                }
            }
        }
        C3509.m11455(this, i);
    }

    private int sbr_extension(IBitStream iBitStream, int i, int i2) throws AACException {
        if (i != 2) {
            this.bs_extension_data = iBitStream.readBits(6);
            return 6;
        }
        if (this.ps == null) {
            this.ps = new PS(this.sample_rate, this.numTimeSlotsRate);
        }
        if (this.psResetFlag) {
            this.ps.header_read = false;
        }
        int iDecode = this.ps.decode(iBitStream);
        if (!this.ps_used && this.ps.header_read) {
            this.ps_used = true;
        }
        if (this.ps.header_read) {
            this.psResetFlag = false;
        }
        return iDecode;
    }

    private int sbr_grid(IBitStream iBitStream, int i) throws AACException {
        int iMin;
        int i2;
        int i3;
        int i4;
        int i5 = this.L_E[i];
        int i6 = this.L_Q[i];
        int[] iArr = this.bs_frame_class;
        int i7 = iArr[i];
        iArr[i] = iBitStream.readBits(2);
        int i8 = this.bs_frame_class[i];
        if (i8 == 0) {
            iMin = Math.min(1 << iBitStream.readBits(2), 5);
            int bit = iBitStream.readBit();
            for (int i9 = 0; i9 < iMin; i9++) {
                this.f[i][i9] = bit;
            }
            this.abs_bord_lead[i] = 0;
            this.abs_bord_trail[i] = this.numTimeSlots;
            this.n_rel_lead[i] = iMin - 1;
            this.n_rel_trail[i] = 0;
        } else if (i8 == 1) {
            int bits = iBitStream.readBits(2) + this.numTimeSlots;
            iMin = iBitStream.readBits(2) + 1;
            int i10 = 0;
            while (true) {
                i2 = iMin - 1;
                if (i10 >= i2) {
                    break;
                }
                this.bs_rel_bord[i][i10] = (iBitStream.readBits(2) * 2) + 2;
                i10++;
            }
            this.bs_pointer[i] = iBitStream.readBits(sbr_log2(iMin + 1));
            for (int i11 = 0; i11 < iMin; i11++) {
                this.f[i][(iMin - i11) - 1] = iBitStream.readBit();
            }
            this.abs_bord_lead[i] = 0;
            this.abs_bord_trail[i] = bits;
            this.n_rel_lead[i] = 0;
            this.n_rel_trail[i] = i2;
        } else if (i8 == 2) {
            int bits2 = iBitStream.readBits(2);
            iMin = iBitStream.readBits(2) + 1;
            int i12 = 0;
            while (true) {
                i3 = iMin - 1;
                if (i12 >= i3) {
                    break;
                }
                this.bs_rel_bord[i][i12] = (iBitStream.readBits(2) * 2) + 2;
                i12++;
            }
            this.bs_pointer[i] = iBitStream.readBits(sbr_log2(iMin + 1));
            for (int i13 = 0; i13 < iMin; i13++) {
                this.f[i][i13] = iBitStream.readBit();
            }
            this.abs_bord_lead[i] = bits2;
            this.abs_bord_trail[i] = this.numTimeSlots;
            this.n_rel_lead[i] = i3;
            this.n_rel_trail[i] = 0;
        } else if (i8 != 3) {
            iMin = 0;
        } else {
            int bits3 = iBitStream.readBits(2);
            int bits4 = iBitStream.readBits(2) + this.numTimeSlots;
            this.bs_num_rel_0[i] = iBitStream.readBits(2);
            this.bs_num_rel_1[i] = iBitStream.readBits(2);
            iMin = Math.min(5, this.bs_num_rel_0[i] + this.bs_num_rel_1[i] + 1);
            for (int i14 = 0; i14 < this.bs_num_rel_0[i]; i14++) {
                this.bs_rel_bord_0[i][i14] = (iBitStream.readBits(2) * 2) + 2;
            }
            int i15 = 0;
            while (true) {
                i4 = this.bs_num_rel_1[i];
                if (i15 >= i4) {
                    break;
                }
                this.bs_rel_bord_1[i][i15] = (iBitStream.readBits(2) * 2) + 2;
                i15++;
            }
            this.bs_pointer[i] = iBitStream.readBits(sbr_log2(this.bs_num_rel_0[i] + i4 + 2));
            for (int i16 = 0; i16 < iMin; i16++) {
                this.f[i][i16] = iBitStream.readBit();
            }
            this.abs_bord_lead[i] = bits3;
            this.abs_bord_trail[i] = bits4;
            this.n_rel_lead[i] = this.bs_num_rel_0[i];
            this.n_rel_trail[i] = this.bs_num_rel_1[i];
        }
        if (this.bs_frame_class[i] == 3) {
            this.L_E[i] = Math.min(iMin, 5);
        } else {
            this.L_E[i] = Math.min(iMin, 4);
        }
        int i17 = this.L_E[i];
        if (i17 <= 0) {
            return 1;
        }
        if (i17 > 1) {
            this.L_Q[i] = 2;
        } else {
            this.L_Q[i] = 1;
        }
        int iM1 = a1.m1(this, i);
        if (iM1 <= 0) {
            a1.m3(this, i);
            return 0;
        }
        this.bs_frame_class[i] = i7;
        this.L_E[i] = i5;
        this.L_Q[i] = i6;
        return iM1;
    }

    private void sbr_header(IBitStream iBitStream) throws AACException {
        this.header_count++;
        this.bs_amp_res = iBitStream.readBool();
        this.bs_start_freq = iBitStream.readBits(4);
        this.bs_stop_freq = iBitStream.readBits(4);
        this.bs_xover_band = iBitStream.readBits(3);
        iBitStream.readBits(2);
        boolean bool = iBitStream.readBool();
        boolean bool2 = iBitStream.readBool();
        if (bool) {
            this.bs_freq_scale = iBitStream.readBits(2);
            this.bs_alter_scale = iBitStream.readBool();
            this.bs_noise_bands = iBitStream.readBits(2);
        } else {
            this.bs_freq_scale = 2;
            this.bs_alter_scale = true;
            this.bs_noise_bands = 2;
        }
        if (bool2) {
            this.bs_limiter_bands = iBitStream.readBits(2);
            this.bs_limiter_gains = iBitStream.readBits(2);
            this.bs_interpol_freq = iBitStream.readBool();
            this.bs_smoothing_mode = iBitStream.readBool();
            return;
        }
        this.bs_limiter_bands = 2;
        this.bs_limiter_gains = 2;
        this.bs_interpol_freq = true;
        this.bs_smoothing_mode = true;
    }

    private int sbr_log2(int i) {
        int[] iArr = {0, 0, 1, 2, 2, 3, 3, 3, 3, 4};
        if (i >= 10 || i < 0) {
            return 0;
        }
        return iArr[i];
    }

    private void sbr_noise(IBitStream iBitStream, int i) throws AACException {
        int[][] iArr;
        int[][] iArr2;
        int i2;
        if (this.bs_coupling && i == 1) {
            iArr = InterfaceC2327.f8850;
            iArr2 = InterfaceC2327.f8848;
            i2 = 1;
        } else {
            iArr = InterfaceC2327.f8849;
            iArr2 = InterfaceC2327.f8846;
            i2 = 0;
        }
        for (int i3 = 0; i3 < this.L_Q[i]; i3++) {
            if (this.bs_df_noise[i][i3] == 0) {
                if (!this.bs_coupling || i == 1) {
                    this.Q[i][0][i3] = iBitStream.readBits(5) << i2;
                } else {
                    this.Q[i][0][i3] = iBitStream.readBits(5) << i2;
                }
                for (int i4 = 1; i4 < this.N_Q; i4++) {
                    this.Q[i][i4][i3] = decodeHuffman(iBitStream, iArr2) << i2;
                }
            } else {
                for (int i5 = 0; i5 < this.N_Q; i5++) {
                    this.Q[i][i5][i3] = decodeHuffman(iBitStream, iArr) << i2;
                }
            }
        }
        C3509.m11456(this, i);
    }

    private int sbr_process_channel(float[] fArr, float[][][] fArr2, int i, boolean z) {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        this.bsco = 0;
        if (z) {
            this.qmfa[i].m12850(this, fArr, this.Xsbr[i], this.tHFGen, 32);
        } else {
            this.qmfa[i].m12850(this, fArr, this.Xsbr[i], this.tHFGen, this.kx);
        }
        if (z) {
            z2 = z;
            i2 = 0;
        } else {
            float[][][] fArr3 = this.Xsbr[i];
            C4406.m13603(this, fArr3, fArr3, i);
            int iM13125 = C4144.m13125(this, this.Xsbr[i], i);
            i2 = iM13125;
            z2 = iM13125 > 0 ? true : z;
        }
        if (this.just_seeked || z2) {
            for (int i9 = 0; i9 < this.numTimeSlotsRate; i9++) {
                int i10 = 0;
                while (true) {
                    if (i10 >= 32) {
                        break;
                    }
                    float[] fArr4 = fArr2[i9][i10];
                    float[][][] fArr5 = this.Xsbr[i];
                    int i11 = this.tHFAdj;
                    fArr4[0] = fArr5[i9 + i11][i10][0];
                    fArr4[1] = fArr5[i11 + i9][i10][1];
                    i10++;
                }
                for (i3 = 32; i3 < 64; i3++) {
                    float[] fArr6 = fArr2[i9][i3];
                    fArr6[0] = 0.0f;
                    fArr6[1] = 0.0f;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.numTimeSlotsRate; i12++) {
                if (i12 < this.t_E[i][0]) {
                    i4 = this.kx_prev;
                    i5 = this.M_prev;
                    i6 = this.bsco_prev;
                } else {
                    i4 = this.kx;
                    i5 = this.M;
                    i6 = this.bsco;
                }
                int i13 = 0;
                while (true) {
                    i7 = i4 + i6;
                    if (i13 >= i7) {
                        break;
                    }
                    float[] fArr7 = fArr2[i12][i13];
                    float[][][] fArr8 = this.Xsbr[i];
                    int i14 = this.tHFAdj;
                    fArr7[0] = fArr8[i12 + i14][i13][0];
                    fArr7[1] = fArr8[i14 + i12][i13][1];
                    i13++;
                }
                int i15 = i7;
                while (true) {
                    i8 = i4 + i5;
                    if (i15 >= i8) {
                        break;
                    }
                    float[] fArr9 = fArr2[i12][i15];
                    float[][][] fArr10 = this.Xsbr[i];
                    int i16 = this.tHFAdj;
                    fArr9[0] = fArr10[i12 + i16][i15][0];
                    fArr9[1] = fArr10[i16 + i12][i15][1];
                    i15++;
                }
                for (int iMax = Math.max(i7, i8); iMax < 64; iMax++) {
                    float[] fArr11 = fArr2[i12][iMax];
                    fArr11[0] = 0.0f;
                    fArr11[1] = 0.0f;
                }
            }
        }
        return i2;
    }

    private void sbr_save_matrix(int i) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = this.tHFGen;
            if (i3 >= i2) {
                break;
            }
            for (int i4 = 0; i4 < 64; i4++) {
                float[][][] fArr = this.Xsbr[i];
                float[] fArr2 = fArr[i3][i4];
                int i5 = this.numTimeSlotsRate;
                fArr2[0] = fArr[i3 + i5][i4][0];
                fArr2[1] = fArr[i5 + i3][i4][1];
            }
            i3++;
        }
        while (i2 < 40) {
            for (int i6 = 0; i6 < 64; i6++) {
                float[] fArr3 = this.Xsbr[i][i2][i6];
                fArr3[0] = 0.0f;
                fArr3[1] = 0.0f;
            }
            i2++;
        }
    }

    private int sbr_save_prev_data(int i) {
        this.kx_prev = this.kx;
        this.M_prev = this.M;
        this.bsco_prev = this.bsco;
        int[] iArr = this.L_E_prev;
        int[] iArr2 = this.L_E;
        iArr[i] = iArr2[i];
        int i2 = iArr2[i];
        if (i2 <= 0) {
            return 19;
        }
        this.f_prev[i] = this.f[i][i2 - 1];
        for (int i3 = 0; i3 < 49; i3++) {
            this.E_prev[i][i3] = this.E[i][i3][this.L_E[i] - 1];
            this.Q_prev[i][i3] = this.Q[i][i3][this.L_Q[i] - 1];
        }
        for (int i4 = 0; i4 < 49; i4++) {
            this.bs_add_harmonic_prev[i][i4] = this.bs_add_harmonic[i][i4];
        }
        this.bs_add_harmonic_flag_prev[i] = this.bs_add_harmonic_flag[i];
        if (this.l_A[i] == this.L_E[i]) {
            this.prevEnvIsShort[i] = 0;
        } else {
            this.prevEnvIsShort[i] = -1;
        }
        return 0;
    }

    private int sbr_single_channel_element(IBitStream iBitStream) throws AACException {
        if (iBitStream.readBool()) {
            iBitStream.readBits(4);
        }
        int iSbr_grid = sbr_grid(iBitStream, 0);
        if (iSbr_grid > 0) {
            return iSbr_grid;
        }
        sbr_dtdf(iBitStream, 0);
        invf_mode(iBitStream, 0);
        sbr_envelope(iBitStream, 0);
        sbr_noise(iBitStream, 0);
        C3509.m11454(this, 0);
        Arrays.fill(this.bs_add_harmonic[0], 0, 64, 0);
        Arrays.fill(this.bs_add_harmonic[1], 0, 64, 0);
        this.bs_add_harmonic_flag[0] = iBitStream.readBool();
        if (this.bs_add_harmonic_flag[0]) {
            sinusoidal_coding(iBitStream, 0);
        }
        boolean bool = iBitStream.readBool();
        this.bs_extended_data = bool;
        if (bool) {
            int bits = iBitStream.readBits(4);
            if (bits == 15) {
                bits += iBitStream.readBits(8);
            }
            int i = bits * 8;
            boolean z = false;
            while (i > 7) {
                int bits2 = iBitStream.readBits(2);
                this.bs_extension_id = bits2;
                if (bits2 == 2) {
                    if (z) {
                        this.bs_extension_id = 3;
                    } else {
                        z = true;
                    }
                }
                int iSbr_extension = 2 + sbr_extension(iBitStream, this.bs_extension_id, i);
                if (iSbr_extension > i) {
                    return 1;
                }
                i -= iSbr_extension;
            }
            if (i > 0) {
                iBitStream.readBits(i);
            }
        }
        return 0;
    }

    private void sinusoidal_coding(IBitStream iBitStream, int i) throws AACException {
        for (int i2 = 0; i2 < this.N_high; i2++) {
            this.bs_add_harmonic[i][i2] = iBitStream.readBit();
        }
    }

    public int _process(float[] fArr, float[] fArr2, boolean z) {
        boolean z2;
        float[][][] fArr3 = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, 32, 64, 2);
        if (!this.stereo) {
            return 21;
        }
        int i = this.ret;
        if (i != 0 || this.header_count == 0) {
            if (i != 0 && this.Reset) {
                this.bs_start_freq_prev = -1;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            this.just_seeked = true;
        } else {
            this.just_seeked = false;
        }
        this.ret = i + sbr_process_channel(fArr, fArr3, 0, z2);
        if (this.downSampledSBR) {
            this.qmfs[0].m8209(this, fArr3, fArr);
        } else {
            this.qmfs[0].m8210(this, fArr3, fArr);
        }
        this.ret += sbr_process_channel(fArr2, fArr3, 1, z2);
        if (this.downSampledSBR) {
            this.qmfs[1].m8209(this, fArr3, fArr2);
        } else {
            this.qmfs[1].m8210(this, fArr3, fArr2);
        }
        if (this.bs_header_flag) {
            this.just_seeked = false;
        }
        if (this.header_count != 0 && this.ret == 0) {
            int iSbr_save_prev_data = sbr_save_prev_data(0);
            if (iSbr_save_prev_data != 0) {
                return iSbr_save_prev_data;
            }
            int iSbr_save_prev_data2 = sbr_save_prev_data(1);
            if (iSbr_save_prev_data2 != 0) {
                return iSbr_save_prev_data2;
            }
        }
        sbr_save_matrix(0);
        sbr_save_matrix(1);
        this.frame++;
        return 0;
    }

    public int calc_sbr_tables(int i, int i2, int i3, int i4, boolean z, int i5) {
        int iM10912 = C3247.m10912(i, i3, this.sample_rate);
        this.k0 = iM10912;
        int iM10913 = C3247.m10913(i2, this.sample_rate, iM10912);
        return (((this.sample_rate.getFrequency() < 48000 ? this.sample_rate.getFrequency() > 32000 ? iM10913 - this.k0 <= 45 : iM10913 - this.k0 <= 48 : iM10913 - this.k0 <= 32) ? 0 : 1) + (i4 == 0 ? C3247.m10911(this, this.k0, iM10913, z) : C3247.m10910(this, this.k0, iM10913, i4, z))) + C3247.m10906(this, i5, iM10913) > 0 ? 1 : 0;
    }

    public int decode(IBitStream iBitStream, int i) throws AACException {
        int iSbr_data;
        int i2;
        long position = iBitStream.getPosition();
        if (iBitStream.readBits(4) == 14) {
            this.bs_sbr_crc_bits = iBitStream.readBits(10);
        }
        int i3 = this.bs_start_freq;
        int i4 = this.bs_samplerate_mode;
        int i5 = this.bs_stop_freq;
        int i6 = this.bs_freq_scale;
        boolean z = this.bs_alter_scale;
        int i7 = this.bs_xover_band;
        boolean bool = iBitStream.readBool();
        this.bs_header_flag = bool;
        if (bool) {
            sbr_header(iBitStream);
        }
        sbr_reset();
        if (this.header_count != 0) {
            if (this.Reset || (this.bs_header_flag && this.just_seeked)) {
                i2 = i7;
                if (calc_sbr_tables(this.bs_start_freq, this.bs_stop_freq, this.bs_samplerate_mode, this.bs_freq_scale, this.bs_alter_scale, this.bs_xover_band) > 0) {
                    calc_sbr_tables(i3, i5, i4, i6, z, i2);
                }
            } else {
                i2 = i7;
            }
            iSbr_data = sbr_data(iBitStream);
            if (iSbr_data > 0 && (this.Reset || (this.bs_header_flag && this.just_seeked))) {
                calc_sbr_tables(i3, i5, i4, i6, z, i2);
            }
        } else {
            iSbr_data = 1;
        }
        int position2 = (int) (iBitStream.getPosition() - position);
        int i8 = i * 8;
        if (i8 < position2) {
            throw new AACException("frame overread");
        }
        int i9 = i8 - position2;
        while (i9 > 7) {
            iBitStream.readBits(8);
            i9 -= 8;
        }
        iBitStream.readBits(i9);
        return iSbr_data;
    }

    public boolean isPSUsed() {
        return this.ps_used;
    }

    public int process(float[] fArr, boolean z) {
        boolean z2;
        int iSbr_save_prev_data;
        float[][][] fArr2 = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, 32, 64, 2);
        if (this.stereo) {
            return 21;
        }
        int i = this.ret;
        if (i != 0 || this.header_count == 0) {
            if (i != 0 && this.Reset) {
                this.bs_start_freq_prev = -1;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            this.just_seeked = true;
        } else {
            this.just_seeked = false;
        }
        this.ret = i + sbr_process_channel(fArr, fArr2, 0, z2);
        if (this.downSampledSBR) {
            this.qmfs[0].m8209(this, fArr2, fArr);
        } else {
            this.qmfs[0].m8210(this, fArr2, fArr);
        }
        if (this.bs_header_flag) {
            this.just_seeked = false;
        }
        if (this.header_count != 0 && this.ret == 0 && (iSbr_save_prev_data = sbr_save_prev_data(0)) != 0) {
            return iSbr_save_prev_data;
        }
        sbr_save_matrix(0);
        this.frame++;
        return 0;
    }

    public int processPS(float[] fArr, float[] fArr2, boolean z) {
        boolean z2;
        int iSbr_save_prev_data;
        Class cls = Float.TYPE;
        float[][][] fArr3 = (float[][][]) Array.newInstance((Class<?>) cls, 38, 64, 2);
        float[][][] fArr4 = (float[][][]) Array.newInstance((Class<?>) cls, 38, 64, 2);
        if (this.stereo) {
            return 21;
        }
        int i = this.ret;
        if (i != 0 || this.header_count == 0) {
            if (i != 0 && this.Reset) {
                this.bs_start_freq_prev = -1;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            this.just_seeked = true;
        } else {
            this.just_seeked = false;
        }
        s0[] s0VarArr = this.qmfs;
        if (s0VarArr[1] == null) {
            s0VarArr[1] = new s0(this.downSampledSBR ? 32 : 64);
        }
        this.ret += sbr_process_channel(fArr, fArr3, 0, z2);
        for (int i2 = this.numTimeSlotsRate; i2 < this.numTimeSlotsRate + 6; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                float[] fArr5 = fArr3[i2][i3];
                float[][][] fArr6 = this.Xsbr[0];
                int i4 = this.tHFAdj;
                fArr5[0] = fArr6[i4 + i2][i3][0];
                fArr5[1] = fArr6[i4 + i2][i3][1];
            }
        }
        this.ps.process(fArr3, fArr4);
        if (this.downSampledSBR) {
            this.qmfs[0].m8209(this, fArr3, fArr);
            this.qmfs[1].m8209(this, fArr4, fArr2);
        } else {
            this.qmfs[0].m8210(this, fArr3, fArr);
            this.qmfs[1].m8210(this, fArr4, fArr2);
        }
        if (this.bs_header_flag) {
            this.just_seeked = false;
        }
        if (this.header_count != 0 && this.ret == 0 && (iSbr_save_prev_data = sbr_save_prev_data(0)) != 0) {
            return iSbr_save_prev_data;
        }
        sbr_save_matrix(0);
        this.frame++;
        return 0;
    }

    public void sbrReset() {
        C3986 c3986 = this.qmfa[0];
        if (c3986 != null) {
            c3986.m12849();
        }
        C3986 c39862 = this.qmfa[1];
        if (c39862 != null) {
            c39862.m12849();
        }
        s0 s0Var = this.qmfs[0];
        if (s0Var != null) {
            s0Var.m8208();
        }
        s0 s0Var2 = this.qmfs[1];
        if (s0Var2 != null) {
            s0Var2.m8208();
        }
        int i = 0;
        while (i < 5) {
            float[] fArr = this.G_temp_prev[0][i];
            if (fArr != null) {
                Arrays.fill(fArr, 0.0f);
            }
            float[] fArr2 = this.G_temp_prev[1][i];
            if (fArr2 != null) {
                Arrays.fill(fArr2, 0.0f);
            }
            float[] fArr3 = this.Q_temp_prev[0][i];
            if (fArr3 != null) {
                Arrays.fill(fArr3, 0.0f);
            }
            float[] fArr4 = this.Q_temp_prev[1][i];
            if (fArr4 != null) {
                Arrays.fill(fArr4, 0.0f);
            }
            i++;
        }
        for (int i2 = 0; i2 < 40; i2++) {
            for (int i3 = 0; i3 < 64; i3++) {
                float[][][][] fArr5 = this.Xsbr;
                float[] fArr6 = fArr5[0][i2][i];
                fArr6[0] = 0.0f;
                fArr6[1] = 0.0f;
                float[] fArr7 = fArr5[1][i2][i];
                fArr7[0] = 0.0f;
                fArr7[1] = 0.0f;
            }
        }
        int[] iArr = this.GQ_ringbuf_index;
        iArr[0] = 0;
        iArr[1] = 0;
        this.header_count = 0;
        this.Reset = true;
        int[] iArr2 = this.L_E_prev;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.bs_freq_scale = 2;
        this.bs_alter_scale = true;
        this.bs_noise_bands = 2;
        this.bs_limiter_bands = 2;
        this.bs_limiter_gains = 2;
        this.bs_interpol_freq = true;
        this.bs_smoothing_mode = true;
        this.bs_start_freq = 5;
        this.bs_amp_res = true;
        this.bs_samplerate_mode = 1;
        int[] iArr3 = this.prevEnvIsShort;
        iArr3[0] = -1;
        iArr3[1] = -1;
        this.bsco = 0;
        this.bsco_prev = 0;
        this.M_prev = 0;
        this.bs_start_freq_prev = -1;
        int[] iArr4 = this.f_prev;
        iArr4[0] = 0;
        iArr4[1] = 0;
        for (int i4 = 0; i4 < 49; i4++) {
            int[][] iArr5 = this.E_prev;
            iArr5[0][i4] = 0;
            int[][] iArr6 = this.Q_prev;
            iArr6[0][i4] = 0;
            iArr5[1][i4] = 0;
            iArr6[1][i4] = 0;
            int[][] iArr7 = this.bs_add_harmonic_prev;
            iArr7[0][i4] = 0;
            iArr7[1][i4] = 0;
        }
        boolean[] zArr = this.bs_add_harmonic_flag_prev;
        zArr[0] = false;
        zArr[1] = false;
    }

    public void sbr_reset() {
        int i = this.bs_start_freq;
        if (i == this.bs_start_freq_prev && this.bs_stop_freq == this.bs_stop_freq_prev && this.bs_freq_scale == this.bs_freq_scale_prev && this.bs_alter_scale == this.bs_alter_scale_prev && this.bs_xover_band == this.bs_xover_band_prev && this.bs_noise_bands == this.bs_noise_bands_prev) {
            this.Reset = false;
        } else {
            this.Reset = true;
        }
        this.bs_start_freq_prev = i;
        this.bs_stop_freq_prev = this.bs_stop_freq;
        this.bs_freq_scale_prev = this.bs_freq_scale;
        this.bs_alter_scale_prev = this.bs_alter_scale;
        this.bs_xover_band_prev = this.bs_xover_band;
        this.bs_noise_bands_prev = this.bs_noise_bands;
    }
}
