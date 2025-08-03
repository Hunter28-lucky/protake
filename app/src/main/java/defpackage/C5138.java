package defpackage;

import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;

/* compiled from: MDCT.java */
/* renamed from: ဦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5138 implements InterfaceC2807 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f17060;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f17061;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f17062;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f17063;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final float[][] f17064;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C3250 f17065;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final float[][] f17066;

    /* renamed from: ֏, reason: contains not printable characters */
    public final float[] f17067;

    public C5138(int i) throws AACException {
        this.f17060 = i;
        this.f17061 = i >> 1;
        int i2 = i >> 2;
        this.f17062 = i2;
        this.f17063 = i >> 3;
        if (i != 240) {
            if (i == 256) {
                this.f17064 = InterfaceC2807.f10237;
            } else if (i == 1920) {
                this.f17064 = InterfaceC2807.f10238;
            } else if (i == 2048) {
                this.f17064 = InterfaceC2807.f10236;
            }
            this.f17065 = new C3250(i2);
            this.f17066 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i2, 2);
            this.f17067 = new float[2];
            return;
        }
        this.f17064 = InterfaceC2807.f10239;
        throw new AACException("unsupported MDCT length: " + i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15048(float[] fArr, int i, float[] fArr2, int i2) {
        for (int i3 = 0; i3 < this.f17062; i3++) {
            float[] fArr3 = this.f17066[i3];
            int i4 = i3 * 2;
            int i5 = i + i4;
            float f = fArr[i5];
            float[] fArr4 = this.f17064[i3];
            float f2 = fArr4[0];
            int i6 = this.f17061;
            fArr3[1] = (f * f2) + (fArr[((i + i6) - 1) - i4] * fArr4[1]);
            fArr3[0] = (fArr[((i + i6) - 1) - i4] * f2) - (fArr[i5] * fArr4[1]);
        }
        this.f17065.m10917(this.f17066, false);
        for (int i7 = 0; i7 < this.f17062; i7++) {
            float[] fArr5 = this.f17067;
            float[] fArr6 = this.f17066[i7];
            float f3 = fArr6[0];
            fArr5[0] = f3;
            float f4 = fArr6[1];
            fArr5[1] = f4;
            float[] fArr7 = this.f17064[i7];
            float f5 = fArr7[0];
            fArr6[1] = (f4 * f5) + (fArr7[1] * f3);
            fArr6[0] = (f3 * f5) - (fArr5[1] * fArr7[1]);
        }
        int i8 = 0;
        while (true) {
            int i9 = this.f17063;
            if (i8 >= i9) {
                return;
            }
            int i10 = i8 * 2;
            float[][] fArr8 = this.f17066;
            fArr2[i2 + i10] = fArr8[i9 + i8][1];
            fArr2[i2 + 2 + i10] = fArr8[i9 + 1 + i8][1];
            fArr2[i2 + 1 + i10] = -fArr8[(i9 - 1) - i8][0];
            fArr2[i2 + 3 + i10] = -fArr8[(i9 - 2) - i8][0];
            int i11 = this.f17062;
            float[] fArr9 = fArr8[i8];
            fArr2[i2 + i11 + i10] = fArr9[0];
            float[] fArr10 = fArr8[i8 + 1];
            fArr2[i2 + i11 + 2 + i10] = fArr10[0];
            fArr2[i2 + i11 + 1 + i10] = -fArr8[(i11 - 1) - i8][1];
            fArr2[i2 + i11 + 3 + i10] = -fArr8[(i11 - 2) - i8][1];
            int i12 = this.f17061;
            fArr2[i2 + i12 + i10] = fArr8[i9 + i8][0];
            fArr2[i2 + i12 + 2 + i10] = fArr8[i9 + 1 + i8][0];
            fArr2[i2 + i12 + 1 + i10] = -fArr8[(i9 - 1) - i8][1];
            fArr2[i2 + i12 + 3 + i10] = -fArr8[(i9 - 2) - i8][1];
            fArr2[i2 + i12 + i11 + i10] = -fArr9[1];
            fArr2[i2 + i12 + i11 + 2 + i10] = -fArr10[1];
            fArr2[i2 + i12 + i11 + 1 + i10] = fArr8[(i11 - 1) - i8][0];
            fArr2[i2 + i12 + i11 + 3 + i10] = fArr8[(i11 - 2) - i8][0];
            i8 += 2;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m15049(float[] fArr, float[] fArr2) {
        int i = 0;
        while (true) {
            int i2 = this.f17063;
            if (i >= i2) {
                break;
            }
            int i3 = i << 1;
            float[] fArr3 = this.f17067;
            int i4 = this.f17060;
            int i5 = this.f17062;
            float f = fArr[((i4 - i5) - 1) - i3] + fArr[(i4 - i5) + i3];
            fArr3[0] = f;
            float f2 = fArr[i5 + i3] - fArr[(i5 - 1) - i3];
            fArr3[1] = f2;
            float[][] fArr4 = this.f17066;
            float[] fArr5 = fArr4[i];
            float[][] fArr6 = this.f17064;
            float[] fArr7 = fArr6[i];
            float f3 = f * fArr7[0];
            float f4 = fArr7[1];
            float f5 = f3 + (f2 * f4);
            fArr5[0] = f5;
            float f6 = (f2 * fArr7[0]) - (fArr3[0] * f4);
            fArr5[1] = f6;
            fArr5[0] = f5 * i4;
            fArr5[1] = f6 * i4;
            int i6 = this.f17061;
            float f7 = fArr[(i6 - 1) - i3] - fArr[i3];
            fArr3[0] = f7;
            float f8 = fArr[i6 + i3] + fArr[(i4 - 1) - i3];
            fArr3[1] = f8;
            fArr4[i + i2][0] = (f7 * fArr6[i + i2][0]) + (fArr6[i + i2][1] * f8);
            fArr4[i + i2][1] = (f8 * fArr6[i + i2][0]) - (fArr3[0] * fArr6[i + i2][1]);
            float[] fArr8 = fArr4[i + i2];
            fArr8[0] = fArr8[0] * i4;
            float[] fArr9 = fArr4[i2 + i];
            fArr9[1] = fArr9[1] * i4;
            i++;
        }
        this.f17065.m10917(this.f17066, true);
        for (int i7 = 0; i7 < this.f17062; i7++) {
            int i8 = i7 << 1;
            float[] fArr10 = this.f17067;
            float[] fArr11 = this.f17066[i7];
            float f9 = fArr11[0];
            float[] fArr12 = this.f17064[i7];
            float f10 = f9 * fArr12[0];
            float f11 = fArr11[1];
            float f12 = fArr12[1];
            float f13 = f10 + (f11 * f12);
            fArr10[0] = f13;
            fArr10[1] = (f11 * fArr12[0]) - (fArr11[0] * f12);
            fArr2[i8] = -f13;
            int i9 = this.f17061;
            fArr2[(i9 - 1) - i8] = fArr10[1];
            fArr2[i9 + i8] = -fArr10[1];
            fArr2[(this.f17060 - 1) - i8] = fArr10[0];
        }
    }
}
