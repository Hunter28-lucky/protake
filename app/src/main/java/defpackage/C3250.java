package defpackage;

import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;

/* compiled from: FFT.java */
/* renamed from: ն, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3250 implements InterfaceC4323 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f11421;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final float[][] f11422;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final float[][] f11423;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float[] f11424;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] f11425;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float[] f11426;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float[] f11427;

    /* renamed from: ֏, reason: contains not printable characters */
    public float[] f11428;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float[] f11429;

    public C3250(int i) throws AACException {
        this.f11421 = i;
        if (i == 60) {
            this.f11422 = InterfaceC4323.f14807;
        } else if (i == 64) {
            this.f11422 = InterfaceC4323.f14805;
        } else if (i == 480) {
            this.f11422 = InterfaceC4323.f14806;
        } else {
            if (i != 512) {
                throw new AACException("unexpected FFT length: " + i);
            }
            this.f11422 = InterfaceC4323.f14804;
        }
        this.f11423 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 2);
        this.f11424 = new float[2];
        this.f11425 = new float[2];
        this.f11426 = new float[2];
        this.f11427 = new float[2];
        this.f11428 = new float[2];
        this.f11429 = new float[2];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m10917(float[][] fArr, boolean z) {
        char c = z ? (char) 2 : (char) 1;
        int i = z ? this.f11421 : 1;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = this.f11421;
            if (i2 >= i4) {
                break;
            }
            float[] fArr2 = this.f11423[i2];
            float[] fArr3 = fArr[i3];
            fArr2[0] = fArr3[0];
            fArr2[1] = fArr3[1];
            while (true) {
                i4 >>= 1;
                if (i3 < i4 || i4 <= 0) {
                    break;
                } else {
                    i3 -= i4;
                }
            }
            i3 += i4;
            i2++;
        }
        for (int i5 = 0; i5 < this.f11421; i5++) {
            float[] fArr4 = fArr[i5];
            float[] fArr5 = this.f11423[i5];
            fArr4[0] = fArr5[0];
            fArr4[1] = fArr5[1];
        }
        for (int i6 = 0; i6 < this.f11421; i6 += 4) {
            float[] fArr6 = this.f11424;
            float[] fArr7 = fArr[i6];
            float f = fArr7[0];
            float[] fArr8 = fArr[i6 + 1];
            fArr6[0] = f + fArr8[0];
            fArr6[1] = fArr7[1] + fArr8[1];
            float[] fArr9 = this.f11425;
            float[] fArr10 = fArr[i6 + 2];
            float f2 = fArr10[0];
            float[] fArr11 = fArr[i6 + 3];
            fArr9[0] = f2 + fArr11[0];
            fArr9[1] = fArr10[1] + fArr11[1];
            float[] fArr12 = this.f11426;
            fArr12[0] = fArr7[0] - fArr8[0];
            fArr12[1] = fArr7[1] - fArr8[1];
            float[] fArr13 = this.f11427;
            fArr13[0] = fArr10[0] - fArr11[0];
            fArr13[1] = fArr10[1] - fArr11[1];
            fArr7[0] = fArr6[0] + fArr9[0];
            fArr7[1] = fArr6[1] + fArr9[1];
            fArr10[0] = fArr6[0] - fArr9[0];
            fArr10[1] = fArr6[1] - fArr9[1];
            float[] fArr14 = this.f11428;
            fArr14[0] = fArr12[0] - fArr13[1];
            fArr14[1] = fArr12[1] + fArr13[0];
            float[] fArr15 = this.f11429;
            float f3 = fArr12[0] + fArr13[1];
            fArr15[0] = f3;
            float f4 = fArr12[1] - fArr13[0];
            fArr15[1] = f4;
            if (z) {
                fArr8[0] = f3;
                fArr8[1] = f4;
                fArr11[0] = fArr14[0];
                fArr11[1] = fArr14[1];
            } else {
                fArr8[0] = fArr14[0];
                fArr8[1] = fArr14[1];
                fArr11[0] = fArr15[0];
                fArr11[1] = fArr15[1];
            }
        }
        int i7 = 4;
        while (true) {
            int i8 = this.f11421;
            if (i7 >= i8) {
                return;
            }
            int i9 = i7 << 1;
            int i10 = i8 / i9;
            for (int i11 = 0; i11 < this.f11421; i11 += i9) {
                for (int i12 = 0; i12 < i7; i12++) {
                    float[] fArr16 = this.f11422[i12 * i10];
                    float f5 = fArr16[0];
                    float f6 = fArr16[c];
                    float[] fArr17 = fArr[i7 + i11 + i12];
                    float f7 = fArr17[0];
                    float f8 = fArr17[1];
                    float f9 = (f7 * f5) - (f8 * f6);
                    float f10 = (f7 * f6) + (f8 * f5);
                    float[] fArr18 = fArr[i11 + i12];
                    float f11 = i;
                    fArr17[0] = (fArr18[0] - f9) * f11;
                    fArr17[1] = (fArr18[1] - f10) * f11;
                    fArr18[0] = (fArr18[0] + f9) * f11;
                    fArr18[1] = (fArr18[1] + f10) * f11;
                }
            }
            i7 = i9;
        }
    }
}
