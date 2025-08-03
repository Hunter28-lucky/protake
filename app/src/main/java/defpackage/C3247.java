package defpackage;

import java.util.Arrays;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.sbr.SBR;

/* compiled from: FBT.java */
/* renamed from: մ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3247 implements InterfaceC2848 {

    /* renamed from: ޠ, reason: contains not printable characters */
    public static final int[] f11414 = {13, 15, 20, 21, 23, 32, 32, 35, 48, 64, 70, 96};

    /* renamed from: ޡ, reason: contains not printable characters */
    public static final int[][] f11415 = {new int[]{0, 2, 4, 6, 8, 11, 14, 18, 22, 26, 31, 37, 44, 51}, new int[]{0, 2, 4, 6, 8, 11, 14, 18, 22, 26, 31, 36, 42, 49}, new int[]{0, 2, 4, 6, 8, 11, 14, 17, 21, 25, 29, 34, 39, 44}, new int[]{0, 2, 4, 6, 8, 11, 14, 17, 20, 24, 28, 33, 38, 43}, new int[]{0, 2, 4, 6, 8, 11, 14, 17, 20, 24, 28, 32, 36, 41}, new int[]{0, 2, 4, 6, 8, 10, 12, 14, 17, 20, 23, 26, 29, 32}, new int[]{0, 2, 4, 6, 8, 10, 12, 14, 17, 20, 23, 26, 29, 32}, new int[]{0, 1, 3, 5, 7, 9, 11, 13, 15, 17, 20, 23, 26, 29}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{0, -1, -2, -3, -4, -5, -6, -6, -6, -6, -6, -6, -6, -6}, new int[]{0, -3, -6, -9, -12, -15, -18, -20, -22, -24, -26, -28, -30, -32}};

    /* renamed from: ޢ, reason: contains not printable characters */
    public static final float[] f11416 = {1.327152f, 1.185093f, 1.119872f};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m10906(SBR sbr, int i, int i2) {
        int i3;
        int i4 = sbr.N_master;
        if (i4 <= i) {
            return 1;
        }
        int i5 = i4 - i;
        sbr.N_high = i5;
        int i6 = (i5 >> 1) + (i5 - ((i5 >> 1) << 1));
        sbr.N_low = i6;
        int[] iArr = sbr.n;
        iArr[0] = i6;
        iArr[1] = i5;
        int i7 = 0;
        while (true) {
            i3 = sbr.N_high;
            if (i7 > i3) {
                break;
            }
            sbr.f_table_res[1][i7] = sbr.f_master[i7 + i];
            i7++;
        }
        int[] iArr2 = sbr.f_table_res[1];
        int i8 = iArr2[i3];
        int i9 = iArr2[0];
        int i10 = i8 - i9;
        sbr.M = i10;
        sbr.kx = i9;
        if (i9 > 32 || i9 + i10 > 64) {
            return 1;
        }
        int i11 = (i3 & 1) != 0 ? 1 : 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 <= sbr.N_low) {
            i13 = i12 == 0 ? 0 : (i12 * 2) - i11;
            int[][] iArr3 = sbr.f_table_res;
            iArr3[0][i12] = iArr3[1][i13];
            i12++;
        }
        sbr.N_Q = 0;
        int i14 = sbr.bs_noise_bands;
        if (i14 == 0) {
            sbr.N_Q = 1;
        } else {
            int iMax = Math.max(1, m10907(0, i14, sbr.kx, i2));
            sbr.N_Q = iMax;
            sbr.N_Q = Math.min(5, iMax);
        }
        int i15 = 0;
        while (true) {
            int i16 = sbr.N_Q;
            if (i15 > i16) {
                break;
            }
            i13 = i15 == 0 ? 0 : i13 + ((sbr.N_low - i13) / ((i16 + 1) - i15));
            sbr.f_table_noise[i15] = sbr.f_table_res[0][i13];
            i15++;
        }
        for (int i17 = 0; i17 < 64; i17++) {
            int i18 = 0;
            while (true) {
                if (i18 < sbr.N_Q) {
                    int[] iArr4 = sbr.f_table_noise;
                    if (iArr4[i18] <= i17 && i17 < iArr4[i18 + 1]) {
                        sbr.table_map_k_to_g[i17] = i18;
                        break;
                    }
                    i18++;
                }
            }
        }
        return 0;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m10907(int i, int i2, int i3, int i4) {
        float fLog = (float) Math.log(2.0d);
        if (i != 0) {
            fLog *= 1.3f;
        }
        return (int) (((i2 * Math.log(i4 / i3)) / fLog) + 0.5d);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float m10908(int i, int i2, int i3) {
        return (float) Math.pow(i3 / i2, 1.0f / i);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m10909(SBR sbr) {
        int i;
        int i2;
        int[] iArr = sbr.f_table_lim[0];
        int[] iArr2 = sbr.f_table_res[0];
        int i3 = iArr2[0];
        int i4 = sbr.kx;
        iArr[0] = i3 - i4;
        iArr[1] = iArr2[sbr.N_low] - i4;
        sbr.N_L[0] = 1;
        for (int i5 = 1; i5 < 4; i5++) {
            int[] iArr3 = new int[100];
            int[] iArr4 = new int[64];
            iArr4[0] = sbr.kx;
            for (int i6 = 1; i6 <= sbr.noPatches; i6++) {
                int i7 = i6 - 1;
                iArr4[i6] = iArr4[i7] + sbr.patchNoSubbands[i7];
            }
            for (int i8 = 0; i8 <= sbr.N_low; i8++) {
                iArr3[i8] = sbr.f_table_res[0][i8];
            }
            int i9 = 1;
            while (true) {
                i = sbr.noPatches;
                if (i9 >= i) {
                    break;
                }
                iArr3[sbr.N_low + i9] = iArr4[i9];
                i9++;
            }
            Arrays.sort(iArr3, 0, i + sbr.N_low);
            int i10 = (sbr.noPatches + sbr.N_low) - 1;
            if (i10 < 0) {
                return;
            }
            int i11 = 1;
            while (i11 <= i10) {
                int i12 = i11 - 1;
                int i13 = iArr3[i12];
                if ((i13 != 0 ? iArr3[i11] / i13 : 0.0f) < f11416[i5 - 1]) {
                    if (iArr3[i11] != i13) {
                        boolean z = false;
                        for (int i14 = 0; i14 <= sbr.noPatches; i14++) {
                            if (iArr3[i11] == iArr4[i14]) {
                                z = true;
                            }
                        }
                        if (z) {
                            int i15 = 0;
                            boolean z2 = false;
                            while (true) {
                                i2 = sbr.noPatches;
                                if (i15 > i2) {
                                    break;
                                }
                                if (iArr3[i12] == iArr4[i15]) {
                                    z2 = true;
                                }
                                i15++;
                            }
                            if (!z2) {
                                int[] iArr5 = sbr.f_table_res[0];
                                int i16 = sbr.N_low;
                                iArr3[i12] = iArr5[i16];
                                Arrays.sort(iArr3, 0, i2 + i16);
                                i10--;
                            }
                        }
                    }
                    iArr3[i11] = sbr.f_table_res[0][sbr.N_low];
                    Arrays.sort(iArr3, 0, i10);
                    i10--;
                }
                i11++;
            }
            sbr.N_L[i5] = i10;
            for (int i17 = 0; i17 <= i10; i17++) {
                sbr.f_table_lim[i5][i17] = iArr3[i17] - sbr.kx;
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int m10910(SBR sbr, int i, int i2, int i3, boolean z) {
        int i4;
        boolean z2;
        int i5;
        int[] iArr = new int[64];
        int[] iArr2 = new int[64];
        int[] iArr3 = new int[64];
        int[] iArr4 = new int[64];
        int[] iArr5 = {6, 5, 4};
        if (i2 <= i) {
            sbr.N_master = 0;
            return 1;
        }
        int i6 = iArr5[i3 - 1];
        float f = i;
        if (i2 / f > 2.2449d) {
            i4 = i << 1;
            z2 = true;
        } else {
            i4 = i2;
            z2 = false;
        }
        int iMin = Math.min(m10907(0, i6, i, i4) * 2, 63);
        if (iMin <= 0) {
            return 1;
        }
        float fM10908 = m10908(iMin, i, i4);
        int i7 = (int) (f + 0.5f);
        int i8 = 0;
        while (i8 <= iMin) {
            f *= fM10908;
            int i9 = (int) (f + 0.5f);
            iArr[i8] = i9 - i7;
            i8++;
            i7 = i9;
        }
        Arrays.sort(iArr, 0, iMin);
        iArr3[0] = i;
        for (int i10 = 1; i10 <= iMin; i10++) {
            int i11 = i10 - 1;
            iArr3[i10] = iArr3[i11] + iArr[i11];
            if (iArr[i11] == 0) {
                return 1;
            }
        }
        if (!z2) {
            for (int i12 = 0; i12 <= iMin; i12++) {
                sbr.f_master[i12] = iArr3[i12];
            }
            sbr.N_master = iMin;
            sbr.N_master = Math.min(iMin, 64);
            return 0;
        }
        int iMin2 = Math.min(m10907(1, i6, i4, i2) * 2, 63);
        float fM109082 = m10908(iMin2, i4, i2);
        float f2 = i4;
        int i13 = (int) (f2 + 0.5f);
        int i14 = 0;
        while (true) {
            i5 = iMin2 - 1;
            if (i14 > i5) {
                break;
            }
            f2 *= fM109082;
            int i15 = (int) (f2 + 0.5f);
            iArr2[i14] = i15 - i13;
            i14++;
            i13 = i15;
        }
        int i16 = iMin - 1;
        if (iArr2[0] < iArr[i16]) {
            Arrays.sort(iArr2, 0, iMin2 + 1);
            int i17 = iArr[i16];
            int i18 = i17 - iArr2[0];
            iArr2[0] = i17;
            iArr2[i5] = iArr2[i5] - i18;
        }
        Arrays.sort(iArr2, 0, iMin2);
        iArr4[0] = i4;
        for (int i19 = 1; i19 <= iMin2; i19++) {
            int i20 = i19 - 1;
            iArr4[i19] = iArr4[i20] + iArr2[i20];
            if (iArr2[i20] == 0) {
                return 1;
            }
        }
        int i21 = iMin2 + iMin;
        sbr.N_master = i21;
        sbr.N_master = Math.min(i21, 64);
        for (int i22 = 0; i22 <= iMin; i22++) {
            sbr.f_master[i22] = iArr3[i22];
        }
        for (int i23 = iMin + 1; i23 <= sbr.N_master; i23++) {
            sbr.f_master[i23] = iArr4[i23 - iMin];
        }
        return 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m10911(SBR sbr, int i, int i2, boolean z) {
        int[] iArr = new int[64];
        if (i2 <= i) {
            sbr.N_master = 0;
            return 1;
        }
        int i3 = z ? 2 : 1;
        int iMin = Math.min((z ? ((i2 - i) + 2) >> 2 : (i2 - i) >> 1) << 1, 63);
        if (iMin <= 0) {
            return 1;
        }
        int i4 = i2 - ((iMin * i3) + i);
        for (int i5 = 0; i5 < iMin; i5++) {
            iArr[i5] = i3;
        }
        if (i4 != 0) {
            int i6 = i4 > 0 ? -1 : 1;
            int i7 = i4 > 0 ? iMin - 1 : 0;
            while (i4 != 0) {
                iArr[i7] = iArr[i7] - i6;
                i7 += i6;
                i4 += i6;
            }
        }
        sbr.f_master[0] = i;
        for (int i8 = 1; i8 <= iMin; i8++) {
            int[] iArr2 = sbr.f_master;
            int i9 = i8 - 1;
            iArr2[i8] = iArr2[i9] + iArr[i9];
        }
        sbr.N_master = iMin;
        sbr.N_master = Math.min(iMin, 64);
        return 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m10912(int i, int i2, SampleFrequency sampleFrequency) {
        return InterfaceC2848.f10332[sampleFrequency.getIndex()] + (i2 != 0 ? InterfaceC2848.f10334[InterfaceC2848.f10333[sampleFrequency.getIndex()]][i] : InterfaceC2848.f10334[6][i]);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int m10913(int i, SampleFrequency sampleFrequency, int i2) {
        return i == 15 ? Math.min(64, i2 * 3) : i == 14 ? Math.min(64, i2 * 2) : Math.min(64, f11414[sampleFrequency.getIndex()] + f11415[sampleFrequency.getIndex()][Math.min(i, 13)]);
    }
}
