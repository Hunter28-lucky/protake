package defpackage;

import java.util.Arrays;
import net.sourceforge.jaad.aac.sbr.SBR;

/* compiled from: AnalysisFilterbank.java */
/* renamed from: ࢰ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3986 implements InterfaceC4081 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float[] f13935;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f13936 = 0;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f13937;

    public C3986(int i) {
        this.f13937 = i;
        this.f13935 = new float[i * 2 * 10];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12849() {
        Arrays.fill(this.f13935, 0.0f);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m12850(SBR sbr, float[] fArr, float[][][] fArr2, int i, int i2) {
        char c;
        int i3 = 64;
        float[] fArr3 = new float[64];
        float[] fArr4 = new float[32];
        float[] fArr5 = new float[32];
        float[] fArr6 = new float[32];
        float[] fArr7 = new float[32];
        int i4 = 0;
        int i5 = 0;
        while (i4 < sbr.numTimeSlotsRate) {
            int i6 = 31;
            while (i6 >= 0) {
                float[] fArr8 = this.f13935;
                int i7 = this.f13936;
                int i8 = i5 + 1;
                float f = fArr[i5];
                fArr8[i7 + i6 + 320] = f;
                fArr8[i7 + i6] = f;
                i6--;
                i5 = i8;
            }
            int i9 = 0;
            while (i9 < i3) {
                float[] fArr9 = this.f13935;
                int i10 = this.f13936;
                float f2 = fArr9[i10 + i9];
                float[] fArr10 = InterfaceC4081.f14201;
                fArr3[i9] = (f2 * fArr10[i9 * 2]) + (fArr9[i10 + i9 + 64] * fArr10[(i9 + 64) * 2]) + (fArr9[i10 + i9 + 128] * fArr10[(i9 + 128) * 2]) + (fArr9[i10 + i9 + 192] * fArr10[(i9 + 192) * 2]) + (fArr9[i10 + i9 + 256] * fArr10[(i9 + 256) * 2]);
                i9++;
                i3 = 64;
            }
            int i11 = this.f13936 - 32;
            this.f13936 = i11;
            if (i11 < 0) {
                this.f13936 = 288;
            }
            fArr5[31] = fArr3[1];
            fArr4[0] = fArr3[0];
            int i12 = 1;
            for (int i13 = 31; i12 < i13; i13 = 31) {
                int i14 = i12 + 1;
                fArr5[31 - i12] = fArr3[i14];
                fArr4[i12] = -fArr3[64 - i12];
                i12 = i14;
            }
            fArr5[0] = fArr3[32];
            fArr4[31] = -fArr3[33];
            C3406.m11176(fArr4, fArr5, fArr6, fArr7);
            for (int i15 = 0; i15 < 16; i15++) {
                int i16 = i15 * 2;
                int i17 = i16 + 1;
                if (i17 < i2) {
                    float[][] fArr11 = fArr2[i4 + i];
                    float[] fArr12 = fArr11[i16];
                    fArr12[0] = fArr6[i15] * 2.0f;
                    fArr12[1] = fArr7[i15] * 2.0f;
                    float[] fArr13 = fArr11[i17];
                    int i18 = 31 - i15;
                    fArr13[0] = fArr7[i18] * (-2.0f);
                    fArr13[1] = fArr6[i18] * (-2.0f);
                } else {
                    if (i16 < i2) {
                        float[] fArr14 = fArr2[i4 + i][i16];
                        c = 0;
                        fArr14[0] = fArr6[i15] * 2.0f;
                        fArr14[1] = fArr7[i15] * 2.0f;
                    } else {
                        c = 0;
                        float[] fArr15 = fArr2[i4 + i][i16];
                        fArr15[0] = 0.0f;
                        fArr15[1] = 0.0f;
                    }
                    float[] fArr16 = fArr2[i4 + i][i17];
                    fArr16[c] = 0.0f;
                    fArr16[1] = 0.0f;
                }
            }
            i4++;
            i3 = 64;
        }
    }
}
