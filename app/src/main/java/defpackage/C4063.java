package defpackage;

import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.ICSInfo;

/* compiled from: IMDCT.java */
/* renamed from: घ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4063 implements InterfaceC2801, InterfaceC5021, v8 {

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final float[][] f14104 = {v8.f8681, v8.f8683};

    /* renamed from: ކ, reason: contains not printable characters */
    public static final float[][] f14105 = {v8.f8682, v8.f8684};

    /* renamed from: ހ, reason: contains not printable characters */
    public final int f14106;

    /* renamed from: ށ, reason: contains not printable characters */
    public final int f14107;

    /* renamed from: ނ, reason: contains not printable characters */
    public final int f14108;

    /* renamed from: ރ, reason: contains not printable characters */
    public final int f14109;

    /* renamed from: ބ, reason: contains not printable characters */
    public final int f14110;

    /* compiled from: IMDCT.java */
    /* renamed from: घ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4064 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f14111;

        static {
            int[] iArr = new int[ICSInfo.WindowSequence.values().length];
            f14111 = iArr;
            try {
                iArr[ICSInfo.WindowSequence.ONLY_LONG_SEQUENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14111[ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14111[ICSInfo.WindowSequence.LONG_START_SEQUENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14111[ICSInfo.WindowSequence.LONG_STOP_SEQUENCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C4063(int i) {
        this.f14106 = i;
        int i2 = i / 4;
        this.f14108 = i2;
        int i3 = i / 8;
        this.f14107 = i3;
        int i4 = i3 / 4;
        this.f14109 = i4;
        this.f14110 = (i2 - i4) / 2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12996(float[] fArr, float[] fArr2, float[] fArr3, int i) throws AACException {
        float[][] fArr4;
        float[][] fArr5;
        int i2;
        int i3 = i / 2;
        if (i == 256) {
            fArr4 = InterfaceC5021.f16784;
            fArr5 = InterfaceC5021.f16786;
        } else {
            if (i != 32) {
                throw new AACException("gain control: unexpected IMDCT length");
            }
            fArr4 = InterfaceC5021.f16785;
            fArr5 = InterfaceC5021.f16787;
        }
        float[] fArr6 = new float[i];
        for (int i4 = 0; i4 < i3; i4++) {
            fArr6[i4] = fArr[i4 * 2];
        }
        for (int i5 = i3; i5 < i; i5++) {
            fArr6[i5] = -fArr[((i * 2) - 1) - (i5 * 2)];
        }
        float[][] fArr7 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i3, 2);
        for (int i6 = 0; i6 < i3; i6++) {
            float[] fArr8 = fArr7[i6];
            float[] fArr9 = fArr4[i6];
            int i7 = i6 * 2;
            float f = fArr9[0] * fArr6[i7];
            float f2 = fArr9[1];
            int i8 = i7 + 1;
            fArr8[0] = f - (fArr6[i8] * f2);
            fArr8[1] = (fArr9[0] * fArr6[i8]) + (f2 * fArr6[i7]);
        }
        C4356.m13511(fArr7, i3);
        for (int i9 = 0; i9 < i3; i9++) {
            float[] fArr10 = fArr5[i9];
            float f3 = fArr10[0];
            float[] fArr11 = fArr7[i9];
            float f4 = f3 * fArr11[0];
            float f5 = fArr10[1];
            float[] fArr12 = fArr7[(i3 - 1) - i9];
            fArr6[i9] = f4 + (f5 * fArr12[0]) + (fArr10[2] * fArr11[1]) + (fArr10[3] * fArr12[1]);
            fArr6[(i - 1) - i9] = (((fArr10[2] * fArr11[0]) - (fArr10[3] * fArr12[0])) - (fArr10[0] * fArr11[1])) + (fArr10[1] * fArr12[1]);
        }
        System.arraycopy(fArr6, i3, fArr2, 0, i3);
        while (true) {
            i2 = (i * 3) / 2;
            if (i3 >= i2) {
                break;
            }
            fArr2[i3] = -fArr6[(i2 - 1) - i3];
            i3++;
        }
        for (int i10 = i2; i10 < i * 2; i10++) {
            fArr2[i10] = -fArr6[i10 - i2];
        }
        for (int i11 = 0; i11 < i; i11++) {
            fArr2[i11] = fArr2[i11] * fArr3[i11];
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m12997(float[] fArr, float[] fArr2, int i, int i2, ICSInfo.WindowSequence windowSequence) throws AACException {
        float[] fArr3 = new float[this.f14106];
        if (windowSequence.equals(ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE)) {
            for (int i3 = 0; i3 < 4; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    int i5 = 0;
                    while (true) {
                        int i6 = this.f14109;
                        if (i5 < i6) {
                            if (i3 % 2 == 0) {
                                fArr3[(this.f14108 * i3) + (i6 * i4) + i5] = fArr[(this.f14107 * i4) + (i6 * i3) + i5];
                            } else {
                                fArr3[(this.f14108 * i3) + (i6 * i4) + i5] = fArr[((((this.f14107 * i4) + (i6 * i3)) + i6) - 1) - i5];
                            }
                            i5++;
                        }
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < 4; i7++) {
                int i8 = 0;
                while (true) {
                    int i9 = this.f14108;
                    if (i8 < i9) {
                        if (i7 % 2 == 0) {
                            fArr3[(i9 * i7) + i8] = fArr[(i9 * i7) + i8];
                        } else {
                            fArr3[(i9 * i7) + i8] = fArr[(((i9 * i7) + i9) - 1) - i8];
                        }
                        i8++;
                    }
                }
            }
        }
        for (int i10 = 0; i10 < 4; i10++) {
            m12998(fArr3, fArr2, windowSequence, i, i2, i10);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m12998(float[] fArr, float[] fArr2, ICSInfo.WindowSequence windowSequence, int i, int i2, int i3) throws AACException {
        int i4;
        int i5;
        int i6 = this.f14108;
        float[] fArr3 = new float[i6];
        float[] fArr4 = new float[i6 * 2];
        float[] fArr5 = new float[i6 * 2];
        int i7 = this.f14109;
        float[] fArr6 = new float[i7 * 2];
        float[] fArr7 = new float[i7 * 2];
        int i8 = C4064.f14111[windowSequence.ordinal()];
        int i9 = 0;
        if (i8 == 1) {
            int i10 = 0;
            while (true) {
                int i11 = this.f14108;
                if (i10 >= i11) {
                    break;
                }
                float[][] fArr8 = f14104;
                fArr5[i10] = fArr8[i2][i10];
                fArr5[((i11 * 2) - 1) - i10] = fArr8[i][i10];
                i10++;
            }
        } else if (i8 == 2) {
            int i12 = 0;
            while (true) {
                int i13 = this.f14109;
                if (i12 >= i13) {
                    break;
                }
                float[][] fArr9 = f14105;
                fArr6[i12] = fArr9[i2][i12];
                float[] fArr10 = fArr9[i];
                fArr6[((i13 * 2) - 1) - i12] = fArr10[i12];
                fArr7[i12] = fArr10[i12];
                fArr7[((i13 * 2) - 1) - i12] = fArr10[i12];
                i12++;
            }
        } else if (i8 == 3) {
            for (int i14 = 0; i14 < this.f14108; i14++) {
                fArr5[i14] = f14104[i2][i14];
            }
            for (int i15 = 0; i15 < this.f14110; i15++) {
                fArr5[this.f14108 + i15] = 1.0f;
            }
            int i16 = 0;
            while (true) {
                int i17 = this.f14109;
                if (i16 >= i17) {
                    break;
                }
                fArr5[this.f14110 + i16 + this.f14108] = f14105[i][(i17 - 1) - i16];
                i16++;
            }
            int i18 = 0;
            while (true) {
                int i19 = this.f14110;
                if (i18 >= i19) {
                    break;
                }
                fArr5[i19 + i18 + this.f14108 + this.f14109] = 0.0f;
                i18++;
            }
        } else if (i8 == 4) {
            for (int i20 = 0; i20 < this.f14110; i20++) {
                fArr5[i20] = 0.0f;
            }
            for (int i21 = 0; i21 < this.f14109; i21++) {
                fArr5[this.f14110 + i21] = f14105[i2][i21];
            }
            int i22 = 0;
            while (true) {
                int i23 = this.f14110;
                if (i22 >= i23) {
                    break;
                }
                fArr5[i23 + i22 + this.f14109] = 1.0f;
                i22++;
            }
            int i24 = 0;
            while (true) {
                int i25 = this.f14108;
                if (i24 >= i25) {
                    break;
                }
                int i26 = this.f14110;
                fArr5[i24 + i26 + this.f14109 + i26] = f14104[i][(i25 - 1) - i24];
                i24++;
            }
        }
        if (windowSequence.equals(ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE)) {
            for (int i27 = 0; i27 < 8; i27++) {
                int i28 = 0;
                while (true) {
                    i5 = this.f14109;
                    if (i28 >= i5) {
                        break;
                    }
                    fArr3[i28] = fArr[(this.f14108 * i3) + (i5 * i27) + i28];
                    i28++;
                }
                if (i27 == 0) {
                    System.arraycopy(fArr6, 0, fArr5, 0, i5 * 2);
                } else {
                    System.arraycopy(fArr7, 0, fArr5, 0, i5 * 2);
                }
                m12996(fArr3, fArr4, fArr5, this.f14109);
                int i29 = 0;
                while (true) {
                    int i30 = this.f14109;
                    if (i29 < i30 * 2) {
                        fArr2[(this.f14108 * i3 * 2) + (i30 * i27 * 2) + i29] = fArr4[i29] / 32.0f;
                        i29++;
                    }
                }
            }
            return;
        }
        int i31 = 0;
        while (true) {
            i4 = this.f14108;
            if (i31 >= i4) {
                break;
            }
            fArr3[i31] = fArr[(i4 * i3) + i31];
            i31++;
        }
        m12996(fArr3, fArr4, fArr5, i4);
        while (true) {
            int i32 = this.f14108;
            if (i9 >= i32 * 2) {
                return;
            }
            fArr2[(i32 * i3 * 2) + i9] = fArr4[i9] / 256.0f;
            i9++;
        }
    }
}
