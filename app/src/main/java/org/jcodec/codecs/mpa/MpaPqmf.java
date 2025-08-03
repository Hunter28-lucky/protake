package org.jcodec.codecs.mpa;

import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MpaPqmf {
    private static final double MY_PI = 3.141592653589793d;
    private static final float[] bf16;
    private static final float[] bf32;
    private static final float[] bf8;
    private static final float cos11_32;
    private static final float cos11_64;
    private static final float cos13_32;
    private static final float cos13_64;
    private static final float cos15_32;
    private static final float cos15_64;
    private static final float cos17_64;
    private static final float cos19_64;
    private static final float cos1_16;
    private static final float cos1_32;
    private static final float cos1_4;
    private static final float cos1_64;
    private static final float cos1_8;
    private static final float cos21_64;
    private static final float cos23_64;
    private static final float cos25_64;
    private static final float cos27_64;
    private static final float cos29_64;
    private static final float cos31_64;
    private static final float cos3_16;
    private static final float cos3_32;
    private static final float cos3_64;
    private static final float cos3_8;
    private static final float cos5_16;
    private static final float cos5_32;
    private static final float cos5_64;
    private static final float cos7_16;
    private static final float cos7_32;
    private static final float cos7_64;
    private static final float cos9_32;
    private static final float cos9_64;

    static {
        float fCos = (float) (1.0d / (Math.cos(0.04908738521234052d) * 2.0d));
        cos1_64 = fCos;
        float fCos2 = (float) (1.0d / (Math.cos(0.14726215563702155d) * 2.0d));
        cos3_64 = fCos2;
        float fCos3 = (float) (1.0d / (Math.cos(0.2454369260617026d) * 2.0d));
        cos5_64 = fCos3;
        float fCos4 = (float) (1.0d / (Math.cos(0.3436116964863836d) * 2.0d));
        cos7_64 = fCos4;
        float fCos5 = (float) (1.0d / (Math.cos(0.44178646691106466d) * 2.0d));
        cos9_64 = fCos5;
        float fCos6 = (float) (1.0d / (Math.cos(0.5399612373357456d) * 2.0d));
        cos11_64 = fCos6;
        float fCos7 = (float) (1.0d / (Math.cos(0.6381360077604268d) * 2.0d));
        cos13_64 = fCos7;
        float fCos8 = (float) (1.0d / (Math.cos(0.7363107781851077d) * 2.0d));
        cos15_64 = fCos8;
        float fCos9 = (float) (1.0d / (Math.cos(0.8344855486097889d) * 2.0d));
        cos17_64 = fCos9;
        float fCos10 = (float) (1.0d / (Math.cos(0.9326603190344698d) * 2.0d));
        cos19_64 = fCos10;
        float fCos11 = (float) (1.0d / (Math.cos(1.030835089459151d) * 2.0d));
        cos21_64 = fCos11;
        float fCos12 = (float) (1.0d / (Math.cos(1.1290098598838318d) * 2.0d));
        cos23_64 = fCos12;
        float fCos13 = (float) (1.0d / (Math.cos(1.227184630308513d) * 2.0d));
        cos25_64 = fCos13;
        float fCos14 = (float) (1.0d / (Math.cos(1.325359400733194d) * 2.0d));
        cos27_64 = fCos14;
        float fCos15 = (float) (1.0d / (Math.cos(1.423534171157875d) * 2.0d));
        cos29_64 = fCos15;
        float fCos16 = (float) (1.0d / (Math.cos(1.521708941582556d) * 2.0d));
        cos31_64 = fCos16;
        float fCos17 = (float) (1.0d / (Math.cos(0.09817477042468103d) * 2.0d));
        cos1_32 = fCos17;
        float fCos18 = (float) (1.0d / (Math.cos(0.2945243112740431d) * 2.0d));
        cos3_32 = fCos18;
        float fCos19 = (float) (1.0d / (Math.cos(0.4908738521234052d) * 2.0d));
        cos5_32 = fCos19;
        float fCos20 = (float) (1.0d / (Math.cos(0.6872233929727672d) * 2.0d));
        cos7_32 = fCos20;
        float fCos21 = (float) (1.0d / (Math.cos(0.8835729338221293d) * 2.0d));
        cos9_32 = fCos21;
        float fCos22 = (float) (1.0d / (Math.cos(1.0799224746714913d) * 2.0d));
        cos11_32 = fCos22;
        float fCos23 = (float) (1.0d / (Math.cos(1.2762720155208536d) * 2.0d));
        cos13_32 = fCos23;
        float fCos24 = (float) (1.0d / (Math.cos(1.4726215563702154d) * 2.0d));
        cos15_32 = fCos24;
        float fCos25 = (float) (1.0d / (Math.cos(0.19634954084936207d) * 2.0d));
        cos1_16 = fCos25;
        float fCos26 = (float) (1.0d / (Math.cos(0.5890486225480862d) * 2.0d));
        cos3_16 = fCos26;
        float fCos27 = (float) (1.0d / (Math.cos(0.9817477042468103d) * 2.0d));
        cos5_16 = fCos27;
        float fCos28 = (float) (1.0d / (Math.cos(1.3744467859455345d) * 2.0d));
        cos7_16 = fCos28;
        cos1_8 = (float) (1.0d / (Math.cos(0.39269908169872414d) * 2.0d));
        cos3_8 = (float) (1.0d / (Math.cos(1.1780972450961724d) * 2.0d));
        cos1_4 = (float) (1.0d / (Math.cos(0.7853981633974483d) * 2.0d));
        bf32 = new float[]{fCos, fCos2, fCos3, fCos4, fCos5, fCos6, fCos7, fCos8, fCos9, fCos10, fCos11, fCos12, fCos13, fCos14, fCos15, fCos16};
        bf16 = new float[]{fCos17, fCos18, fCos19, fCos20, fCos21, fCos22, fCos23, fCos24};
        bf8 = new float[]{fCos25, fCos26, fCos27, fCos28};
    }

    private static void butterfly16H(float[] fArr) {
        for (int i = 0; i < 8; i++) {
            int i2 = i + 16;
            float f = fArr[i2];
            int i3 = 31 - i;
            float f2 = fArr[i3];
            fArr[i2] = f + f2;
            fArr[i3] = (-(f - f2)) * bf16[i];
        }
    }

    private static void butterfly16L(float[] fArr) {
        for (int i = 0; i < 8; i++) {
            float f = fArr[i];
            int i2 = 15 - i;
            float f2 = fArr[i2];
            fArr[i] = f + f2;
            fArr[i2] = (f - f2) * bf16[i];
        }
    }

    private static void butterfly2H(float[] fArr, int i) {
        int i2 = i + 2;
        float f = fArr[i2];
        int i3 = i + 3;
        float f2 = fArr[i3];
        fArr[i2] = f + f2;
        fArr[i3] = (-(f - f2)) * cos1_4;
    }

    private static void butterfly2L(float[] fArr, int i) {
        float f = fArr[i];
        int i2 = i + 1;
        float f2 = fArr[i2];
        fArr[i + 0] = f + f2;
        fArr[i2] = (f - f2) * cos1_4;
    }

    private static void butterfly32(float[] fArr) {
        for (int i = 0; i < 16; i++) {
            float f = fArr[i];
            int i2 = 31 - i;
            float f2 = fArr[i2];
            fArr[i] = f + f2;
            fArr[i2] = (f - f2) * bf32[i];
        }
    }

    private static void butterfly4H(float[] fArr, int i) {
        int i2 = i + 4;
        float f = fArr[i2];
        int i3 = i + 7;
        float f2 = fArr[i3];
        fArr[i2] = f + f2;
        fArr[i3] = (-(f - f2)) * cos1_8;
        int i4 = i + 5;
        float f3 = fArr[i4];
        int i5 = i + 6;
        float f4 = fArr[i5];
        fArr[i4] = f3 + f4;
        fArr[i5] = (-(f3 - f4)) * cos3_8;
    }

    private static void butterfly4L(float[] fArr, int i) {
        float f = fArr[i];
        int i2 = i + 3;
        float f2 = fArr[i2];
        fArr[i + 0] = f + f2;
        fArr[i2] = (f - f2) * cos1_8;
        int i3 = i + 1;
        float f3 = fArr[i3];
        int i4 = i + 2;
        float f4 = fArr[i4];
        fArr[i3] = f3 + f4;
        fArr[i4] = (f3 - f4) * cos3_8;
    }

    private static void butterfly8H(float[] fArr, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 8 + i2;
            float f = fArr[i3];
            int i4 = (i + 15) - i2;
            float f2 = fArr[i4];
            fArr[i3] = f + f2;
            fArr[i4] = (-(f - f2)) * bf8[i2];
        }
    }

    private static void butterfly8L(float[] fArr, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + i2;
            float f = fArr[i3];
            int i4 = (i + 7) - i2;
            float f2 = fArr[i4];
            fArr[i3] = f + f2;
            fArr[i4] = (f - f2) * bf8[i2];
        }
    }

    public static void computeButterfly(int i, float[] fArr) {
        butterfly32(fArr);
        butterfly16L(fArr);
        butterfly16H(fArr);
        butterfly8L(fArr, 0);
        butterfly8H(fArr, 0);
        butterfly8L(fArr, 16);
        butterfly8H(fArr, 16);
        for (int i2 = 0; i2 < 32; i2 += 8) {
            butterfly4L(fArr, i2);
            butterfly4H(fArr, i2);
        }
        for (int i3 = 0; i3 < 32; i3 += 4) {
            butterfly2L(fArr, i3);
            butterfly2H(fArr, i3);
        }
        float f = fArr[14];
        float f2 = fArr[15];
        float f3 = ((-f) - f2) - fArr[10];
        float f4 = fArr[11];
        float f5 = f3 - f4;
        float f6 = fArr[29];
        float f7 = fArr[31];
        float f8 = f6 + f7 + fArr[25];
        float f9 = f8 + fArr[17];
        float f10 = fArr[21];
        float f11 = fArr[23];
        float f12 = f8 + f10 + f11;
        float f13 = f4 + f2;
        float f14 = fArr[13];
        float f15 = f2 + f14 + fArr[9];
        float f16 = fArr[7];
        float f17 = f16 + fArr[5];
        float f18 = f7 + f11;
        float f19 = fArr[27];
        float f20 = f18 + f19;
        float f21 = fArr[19];
        float f22 = f7 + f19 + f21;
        float f23 = (-fArr[26]) - f19;
        float f24 = fArr[30];
        float f25 = (f23 - f24) - f7;
        float f26 = -fArr[24];
        float f27 = fArr[28];
        float f28 = ((f26 - f27) - f24) - f7;
        float f29 = fArr[20];
        float f30 = fArr[22];
        float f31 = f29 + f30 + f11;
        float f32 = fArr[0];
        float f33 = fArr[1];
        float f34 = fArr[2];
        float f35 = fArr[3];
        float f36 = fArr[4];
        float f37 = fArr[6];
        float f38 = fArr[8];
        float f39 = fArr[12];
        float f40 = fArr[16];
        float f41 = fArr[18];
        fArr[0] = f33;
        fArr[1] = f9;
        fArr[2] = f15;
        fArr[3] = f12;
        fArr[4] = f17;
        fArr[5] = f20 + f10 + f6;
        fArr[6] = f13 + f14;
        fArr[7] = f22 + f6;
        fArr[8] = f35;
        fArr[9] = f22;
        fArr[10] = f13;
        fArr[11] = f20;
        fArr[12] = f16;
        fArr[13] = f18;
        fArr[14] = f2;
        fArr[15] = f7;
        fArr[16] = (-f9) - f24;
        fArr[17] = (-f15) - f;
        fArr[18] = ((-f12) - f30) - f24;
        fArr[19] = (-f17) - f37;
        float f42 = f25 - f6;
        fArr[20] = ((f42 - f10) - f30) - f11;
        fArr[21] = f5 - f14;
        fArr[22] = (f42 - f41) - f21;
        fArr[23] = (-f35) - f34;
        float f43 = f25 - f27;
        fArr[24] = (f43 - f41) - f21;
        fArr[25] = f5 - f39;
        fArr[26] = f43 - f31;
        fArr[27] = ((-f37) - f16) - f36;
        fArr[28] = f28 - f31;
        fArr[29] = (((-f) - f2) - f39) - f38;
        fArr[30] = f28 - f40;
        fArr[31] = -f32;
    }

    public static void computeFilter(int i, float[] fArr, short[] sArr, int i2, float f) {
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4++) {
            int i5 = i4 << 4;
            float f2 = fArr[((i + 16) & 15) + i3];
            float[] fArr2 = MpaConst.dp;
            sArr[i2 + i4] = (short) MathUtil.clip((int) (((f2 * fArr2[i5 + 0]) + (fArr[((i + 15) & 15) + i3] * fArr2[i5 + 1]) + (fArr[((i + 14) & 15) + i3] * fArr2[i5 + 2]) + (fArr[((i + 13) & 15) + i3] * fArr2[i5 + 3]) + (fArr[((i + 12) & 15) + i3] * fArr2[i5 + 4]) + (fArr[((i + 11) & 15) + i3] * fArr2[i5 + 5]) + (fArr[((i + 10) & 15) + i3] * fArr2[i5 + 6]) + (fArr[((i + 9) & 15) + i3] * fArr2[i5 + 7]) + (fArr[((i + 8) & 15) + i3] * fArr2[i5 + 8]) + (fArr[((i + 7) & 15) + i3] * fArr2[i5 + 9]) + (fArr[((i + 6) & 15) + i3] * fArr2[i5 + 10]) + (fArr[((i + 5) & 15) + i3] * fArr2[i5 + 11]) + (fArr[((i + 4) & 15) + i3] * fArr2[i5 + 12]) + (fArr[((i + 3) & 15) + i3] * fArr2[i5 + 13]) + (fArr[((i + 2) & 15) + i3] * fArr2[i5 + 14]) + (fArr[((i + 1) & 15) + i3] * fArr2[i5 + 15])) * f), -32768, 32767);
            i3 += 16;
        }
    }
}
