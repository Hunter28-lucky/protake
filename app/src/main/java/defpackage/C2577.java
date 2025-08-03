package defpackage;

import java.lang.reflect.Array;

/* compiled from: IPQF.java */
/* renamed from: ə, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2577 implements InterfaceC2801, InterfaceC3429 {

    /* renamed from: ހ, reason: contains not printable characters */
    public final float[] f9588 = new float[4];

    /* renamed from: ށ, reason: contains not printable characters */
    public final float[][] f9589;

    /* renamed from: ނ, reason: contains not printable characters */
    public final float[][] f9590;

    public C2577() {
        Class cls = Float.TYPE;
        this.f9589 = (float[][]) Array.newInstance((Class<?>) cls, 2, 24);
        this.f9590 = (float[][]) Array.newInstance((Class<?>) cls, 2, 24);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m9435(float[] fArr, float[] fArr2, int i) {
        for (int i2 = 0; i2 < 2; i2++) {
            int i3 = 0;
            while (i3 < 23) {
                float[] fArr3 = this.f9589[i2];
                int i4 = i3 + 1;
                fArr3[i3] = fArr3[i4];
                float[] fArr4 = this.f9590[i2];
                fArr4[i3] = fArr4[i4];
                i3 = i4;
            }
        }
        int i5 = 0;
        while (true) {
            float f = 0.0f;
            if (i5 >= 2) {
                break;
            }
            float f2 = 0.0f;
            for (int i6 = 0; i6 < 4; i6++) {
                f2 += InterfaceC3429.f11784[i5][i6] * fArr[i6];
            }
            this.f9589[i5][23] = f2;
            for (int i7 = 0; i7 < 4; i7++) {
                f += InterfaceC3429.f11785[i5][i7] * fArr[i7];
            }
            this.f9590[i5][23] = f;
            i5++;
        }
        for (int i8 = 0; i8 < 2; i8++) {
            float f3 = 0.0f;
            for (int i9 = 0; i9 < 12; i9++) {
                f3 += InterfaceC3429.f11786[i8][i9] * this.f9589[i8][23 - (i9 * 2)];
            }
            for (int i10 = 0; i10 < 12; i10++) {
                f3 += InterfaceC3429.f11787[i8][i10] * this.f9590[i8][22 - (i10 * 2)];
            }
            fArr2[i + i8] = f3;
            float f4 = 0.0f;
            for (int i11 = 0; i11 < 12; i11++) {
                f4 += InterfaceC3429.f11786[3 - i8][i11] * this.f9589[i8][23 - (i11 * 2)];
            }
            for (int i12 = 0; i12 < 12; i12++) {
                f4 -= InterfaceC3429.f11787[3 - i8][i12] * this.f9590[i8][22 - (i12 * 2)];
            }
            fArr2[((i + 4) - 1) - i8] = f4;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m9436(float[][] fArr, int i, int i2, float[] fArr2) {
        for (int i3 = 0; i3 < i; i3++) {
            fArr2[i3] = 0.0f;
        }
        for (int i4 = 0; i4 < i / 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                this.f9588[i5] = fArr[i5][i4];
            }
            m9435(this.f9588, fArr2, i4 * 4);
        }
    }
}
