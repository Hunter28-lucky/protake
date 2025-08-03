package net.sourceforge.jaad.aac.filterbank;

import defpackage.C5138;
import defpackage.InterfaceC2711;
import defpackage.InterfaceC3922;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public class FilterBank implements SyntaxConstants, InterfaceC2711, InterfaceC3922 {
    private final float[][] LONG_WINDOWS;
    private final float[][] SHORT_WINDOWS;
    private final float[] buf;
    private final int length;
    private final C5138 mdctLong;
    private final C5138 mdctShort;
    private final int mid;
    private final float[][] overlaps;
    private final int shortLen;
    private final int trans;

    /* renamed from: net.sourceforge.jaad.aac.filterbank.FilterBank$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2197 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f8060;

        static {
            int[] iArr = new int[ICSInfo.WindowSequence.values().length];
            f8060 = iArr;
            try {
                iArr[ICSInfo.WindowSequence.ONLY_LONG_SEQUENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8060[ICSInfo.WindowSequence.LONG_START_SEQUENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8060[ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8060[ICSInfo.WindowSequence.LONG_STOP_SEQUENCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FilterBank(boolean z, int i) throws AACException {
        if (z) {
            this.length = SyntaxConstants.WINDOW_SMALL_LEN_LONG;
            this.shortLen = 120;
            this.LONG_WINDOWS = new float[][]{InterfaceC2711.f10030, InterfaceC3922.f13548};
            this.SHORT_WINDOWS = new float[][]{InterfaceC2711.f10031, InterfaceC3922.f13549};
        } else {
            this.length = 1024;
            this.shortLen = 128;
            this.LONG_WINDOWS = new float[][]{InterfaceC2711.f10028, InterfaceC3922.f13546};
            this.SHORT_WINDOWS = new float[][]{InterfaceC2711.f10029, InterfaceC3922.f13547};
        }
        int i2 = this.length;
        int i3 = this.shortLen;
        this.mid = (i2 - i3) / 2;
        this.trans = i3 / 2;
        this.mdctShort = new C5138(i3 * 2);
        this.mdctLong = new C5138(this.length * 2);
        this.overlaps = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, this.length);
        this.buf = new float[this.length * 2];
    }

    public float[] getOverlap(int i) {
        return this.overlaps[i];
    }

    public void process(ICSInfo.WindowSequence windowSequence, int i, int i2, float[] fArr, float[] fArr2, int i3) {
        float[] fArr3 = this.overlaps[i3];
        int i4 = C2197.f8060[windowSequence.ordinal()];
        int i5 = 0;
        if (i4 == 1) {
            this.mdctLong.m15048(fArr, 0, this.buf, 0);
            for (int i6 = 0; i6 < this.length; i6++) {
                fArr2[i6] = fArr3[i6] + (this.buf[i6] * this.LONG_WINDOWS[i2][i6]);
            }
            while (true) {
                int i7 = this.length;
                if (i5 >= i7) {
                    return;
                }
                fArr3[i5] = this.buf[i7 + i5] * this.LONG_WINDOWS[i][(i7 - 1) - i5];
                i5++;
            }
        } else if (i4 == 2) {
            this.mdctLong.m15048(fArr, 0, this.buf, 0);
            for (int i8 = 0; i8 < this.length; i8++) {
                fArr2[i8] = fArr3[i8] + (this.buf[i8] * this.LONG_WINDOWS[i2][i8]);
            }
            for (int i9 = 0; i9 < this.mid; i9++) {
                fArr3[i9] = this.buf[this.length + i9];
            }
            int i10 = 0;
            while (true) {
                int i11 = this.shortLen;
                if (i10 >= i11) {
                    break;
                }
                int i12 = this.mid;
                fArr3[i12 + i10] = this.buf[this.length + i12 + i10] * this.SHORT_WINDOWS[i][(i11 - i10) - 1];
                i10++;
            }
            while (true) {
                int i13 = this.mid;
                if (i5 >= i13) {
                    return;
                }
                fArr3[i13 + this.shortLen + i5] = 0.0f;
                i5++;
            }
        } else if (i4 == 3) {
            for (int i14 = 0; i14 < 8; i14++) {
                C5138 c5138 = this.mdctShort;
                int i15 = this.shortLen;
                c5138.m15048(fArr, i14 * i15, this.buf, i14 * 2 * i15);
            }
            for (int i16 = 0; i16 < this.mid; i16++) {
                fArr2[i16] = fArr3[i16];
            }
            int i17 = 0;
            while (true) {
                int i18 = this.shortLen;
                if (i17 >= i18) {
                    break;
                }
                int i19 = this.mid;
                float f = fArr3[i19 + i17];
                float[] fArr4 = this.buf;
                float f2 = fArr4[i17];
                float[][] fArr5 = this.SHORT_WINDOWS;
                fArr2[i19 + i17] = f + (f2 * fArr5[i2][i17]);
                float f3 = fArr3[(i18 * 1) + i19 + i17];
                float f4 = fArr4[(i18 * 1) + i17];
                float[] fArr6 = fArr5[i];
                fArr2[(i18 * 1) + i19 + i17] = f3 + (f4 * fArr6[(i18 - 1) - i17]) + (fArr4[(i18 * 2) + i17] * fArr6[i17]);
                fArr2[(i18 * 2) + i19 + i17] = fArr3[(i18 * 2) + i19 + i17] + (fArr4[(i18 * 3) + i17] * fArr6[(i18 - 1) - i17]) + (fArr4[(i18 * 4) + i17] * fArr6[i17]);
                fArr2[(i18 * 3) + i19 + i17] = fArr3[(i18 * 3) + i19 + i17] + (fArr4[(i18 * 5) + i17] * fArr6[(i18 - 1) - i17]) + (fArr4[(i18 * 6) + i17] * fArr6[i17]);
                if (i17 < this.trans) {
                    fArr2[(i18 * 4) + i19 + i17] = fArr3[i19 + (i18 * 4) + i17] + (fArr4[(i18 * 7) + i17] * fArr6[(i18 - 1) - i17]) + (fArr4[(i18 * 8) + i17] * fArr6[i17]);
                }
                i17++;
            }
            int i20 = 0;
            while (true) {
                int i21 = this.shortLen;
                if (i20 >= i21) {
                    break;
                }
                if (i20 >= this.trans) {
                    int i22 = ((this.mid + (i21 * 4)) + i20) - this.length;
                    float[] fArr7 = this.buf;
                    float f5 = fArr7[(i21 * 7) + i20];
                    float[] fArr8 = this.SHORT_WINDOWS[i];
                    fArr3[i22] = (f5 * fArr8[(i21 - 1) - i20]) + (fArr7[(i21 * 8) + i20] * fArr8[i20]);
                }
                int i23 = this.mid;
                int i24 = this.length;
                float[] fArr9 = this.buf;
                float f6 = fArr9[(i21 * 9) + i20];
                float[] fArr10 = this.SHORT_WINDOWS[i];
                fArr3[(((i21 * 5) + i23) + i20) - i24] = (f6 * fArr10[(i21 - 1) - i20]) + (fArr9[(i21 * 10) + i20] * fArr10[i20]);
                fArr3[(((i21 * 6) + i23) + i20) - i24] = (fArr9[(i21 * 11) + i20] * fArr10[(i21 - 1) - i20]) + (fArr9[(i21 * 12) + i20] * fArr10[i20]);
                fArr3[(((i21 * 7) + i23) + i20) - i24] = (fArr9[(i21 * 13) + i20] * fArr10[(i21 - 1) - i20]) + (fArr9[(i21 * 14) + i20] * fArr10[i20]);
                fArr3[((i23 + (i21 * 8)) + i20) - i24] = fArr9[(i21 * 15) + i20] * fArr10[(i21 - 1) - i20];
                i20++;
            }
            while (true) {
                int i25 = this.mid;
                if (i5 >= i25) {
                    return;
                }
                fArr3[i25 + this.shortLen + i5] = 0.0f;
                i5++;
            }
        } else {
            if (i4 != 4) {
                return;
            }
            this.mdctLong.m15048(fArr, 0, this.buf, 0);
            for (int i26 = 0; i26 < this.mid; i26++) {
                fArr2[i26] = fArr3[i26];
            }
            for (int i27 = 0; i27 < this.shortLen; i27++) {
                int i28 = this.mid;
                fArr2[i28 + i27] = fArr3[i28 + i27] + (this.buf[i28 + i27] * this.SHORT_WINDOWS[i2][i27]);
            }
            int i29 = 0;
            while (true) {
                int i30 = this.mid;
                if (i29 >= i30) {
                    break;
                }
                int i31 = this.shortLen;
                fArr2[i30 + i31 + i29] = fArr3[i30 + i31 + i29] + this.buf[i30 + i31 + i29];
                i29++;
            }
            while (true) {
                int i32 = this.length;
                if (i5 >= i32) {
                    return;
                }
                fArr3[i5] = this.buf[i32 + i5] * this.LONG_WINDOWS[i][(i32 - 1) - i5];
                i5++;
            }
        }
    }

    public void processLTP(ICSInfo.WindowSequence windowSequence, int i, int i2, float[] fArr, float[] fArr2) {
        int i3 = C2197.f8060[windowSequence.ordinal()];
        if (i3 != 1) {
            int i4 = 0;
            if (i3 == 2) {
                for (int i5 = 0; i5 < this.length; i5++) {
                    this.buf[i5] = fArr[i5] * this.LONG_WINDOWS[i2][i5];
                }
                for (int i6 = 0; i6 < this.mid; i6++) {
                    float[] fArr3 = this.buf;
                    int i7 = this.length;
                    fArr3[i6 + i7] = fArr[i7 + i6];
                }
                int i8 = 0;
                while (true) {
                    int i9 = this.shortLen;
                    if (i8 >= i9) {
                        break;
                    }
                    float[] fArr4 = this.buf;
                    int i10 = this.length;
                    int i11 = this.mid;
                    fArr4[i8 + i10 + i11] = fArr[i10 + i8 + i11] * this.SHORT_WINDOWS[i][(i9 - 1) - i8];
                    i8++;
                }
                while (true) {
                    int i12 = this.mid;
                    if (i4 >= i12) {
                        break;
                    }
                    this.buf[this.length + i4 + i12 + this.shortLen] = 0.0f;
                    i4++;
                }
            } else if (i3 == 4) {
                for (int i13 = 0; i13 < this.mid; i13++) {
                    this.buf[i13] = 0.0f;
                }
                for (int i14 = 0; i14 < this.shortLen; i14++) {
                    float[] fArr5 = this.buf;
                    int i15 = this.mid;
                    fArr5[i14 + i15] = fArr[i15 + i14] * this.SHORT_WINDOWS[i2][i14];
                }
                int i16 = 0;
                while (true) {
                    int i17 = this.mid;
                    if (i16 >= i17) {
                        break;
                    }
                    float[] fArr6 = this.buf;
                    int i18 = this.shortLen;
                    fArr6[i16 + i17 + i18] = fArr[i17 + i16 + i18];
                    i16++;
                }
                while (true) {
                    int i19 = this.length;
                    if (i4 >= i19) {
                        break;
                    }
                    this.buf[i4 + i19] = fArr[i4 + i19] * this.LONG_WINDOWS[i][(i19 - 1) - i4];
                    i4++;
                }
            }
        } else {
            for (int i20 = this.length - 1; i20 >= 0; i20--) {
                float[] fArr7 = this.buf;
                float f = fArr[i20];
                float[][] fArr8 = this.LONG_WINDOWS;
                fArr7[i20] = f * fArr8[i2][i20];
                int i21 = this.length;
                fArr7[i20 + i21] = fArr[i20 + i21] * fArr8[i][(i21 - 1) - i20];
            }
        }
        this.mdctLong.m15049(this.buf, fArr2);
    }
}
