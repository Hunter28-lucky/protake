package net.sourceforge.jaad.aac.gain;

import defpackage.C2577;
import defpackage.C4063;
import defpackage.InterfaceC2801;
import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class GainControl implements InterfaceC2801 {
    private final float[] _function;
    private final float[] buffer1;
    private final float[][] buffer2;
    private final int frameLen;
    private final C4063 imdct;
    private final int lbLong;
    private final int lbShort;
    private int[][][] level;
    private int[][][] location;
    private int maxBand;
    private final float[][] overlap;
    private final C2577 ipqf = new C2577();
    private int[][][] levelPrev = new int[0][][];
    private int[][][] locationPrev = new int[0][][];

    /* renamed from: net.sourceforge.jaad.aac.gain.GainControl$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2198 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f8061;

        static {
            int[] iArr = new int[ICSInfo.WindowSequence.values().length];
            f8061 = iArr;
            try {
                iArr[ICSInfo.WindowSequence.ONLY_LONG_SEQUENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8061[ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8061[ICSInfo.WindowSequence.LONG_START_SEQUENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8061[ICSInfo.WindowSequence.LONG_STOP_SEQUENCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public GainControl(int i) {
        this.frameLen = i;
        int i2 = i / 4;
        this.lbLong = i2;
        this.lbShort = i2 / 8;
        this.imdct = new C4063(i);
        this.buffer1 = new float[i / 2];
        Class cls = Float.TYPE;
        this.buffer2 = (float[][]) Array.newInstance((Class<?>) cls, 4, i2);
        this._function = new float[i2 * 2];
        this.overlap = (float[][]) Array.newInstance((Class<?>) cls, 4, i2 * 2);
    }

    private float calculateFMD(int i, int i2, boolean z, int i3, int i4, int[] iArr, float[] fArr, float[] fArr2) {
        int[] iArr2 = new int[i4 / 2];
        int[] iArr3 = z ? this.locationPrev[i][i2] : this.location[i][i2];
        int[] iArr4 = z ? this.levelPrev[i][i2] : this.level[i][i2];
        int length = iArr3.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            iArr[i6] = iArr3[i5] * 8;
            int gainChangePointID = getGainChangePointID(iArr4[i5]);
            if (gainChangePointID < 0) {
                fArr[i6] = 1.0f / ((float) Math.pow(2.0d, -gainChangePointID));
            } else {
                fArr[i6] = (float) Math.pow(2.0d, gainChangePointID);
            }
            i5 = i6;
        }
        iArr[0] = 0;
        if (length == 0) {
            fArr[0] = 1.0f;
        } else {
            fArr[0] = fArr[1];
        }
        float f = fArr[0];
        int i7 = length + 1;
        iArr[i7] = i3;
        fArr[i7] = 1.0f;
        for (int i8 = 0; i8 < i3; i8++) {
            iArr2[i8] = 0;
            for (int i9 = 0; i9 <= i7; i9++) {
                if (iArr[i9] <= i8) {
                    iArr2[i8] = i9;
                }
            }
        }
        for (int i10 = 0; i10 < i3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[i11];
            if (i10 < i12 || i10 > i12 + 7) {
                fArr2[i10] = fArr[i11 + 1];
            } else {
                fArr2[i10] = interpolateGain(fArr[i11], fArr[i11 + 1], i10 - i12);
            }
        }
        return f;
    }

    private void calculateFunctionData(int i, int i2, ICSInfo.WindowSequence windowSequence, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = new int[10];
        float[] fArr = new float[10];
        float[] fArr2 = new float[i];
        int i10 = i / 2;
        float[] fArr3 = new float[i10];
        float[] fArr4 = new float[i10];
        float[] fArr5 = new float[i10];
        int i11 = C2198.f8061[windowSequence.ordinal()];
        if (i11 == 1 || i11 == 2) {
            i4 = i10;
            i5 = i4;
            i6 = 0;
        } else if (i11 == 3) {
            i6 = i / 16;
            i4 = (i * 7) / 32;
            i5 = i10;
        } else if (i11 != 4) {
            i4 = 0;
            i6 = 0;
            i5 = 0;
        } else {
            i5 = i / 16;
            i4 = (i * 7) / 32;
            i6 = i10;
        }
        int i12 = i4;
        int i13 = i6;
        int i14 = i5;
        calculateFMD(i2, 0, true, i5, i, iArr, fArr, fArr3);
        float fCalculateFMD = calculateFMD(i2, windowSequence.equals(ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE) ? i3 : 0, false, i12, i, iArr, fArr, fArr4);
        if (windowSequence.equals(ICSInfo.WindowSequence.LONG_START_SEQUENCE) || windowSequence.equals(ICSInfo.WindowSequence.LONG_STOP_SEQUENCE)) {
            calculateFMD(i2, 1, false, i13, i, iArr, fArr, fArr5);
        }
        if (windowSequence.equals(ICSInfo.WindowSequence.LONG_STOP_SEQUENCE)) {
            i8 = i14;
            i7 = i12;
            i9 = (i10 - i8) - i7;
            for (int i15 = 0; i15 < i9; i15++) {
                fArr2[i15] = 1.0f;
            }
        } else {
            i7 = i12;
            i8 = i14;
            i9 = 0;
        }
        if (windowSequence.equals(ICSInfo.WindowSequence.ONLY_LONG_SEQUENCE) || windowSequence.equals(ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE)) {
            fArr[0] = 1.0f;
        }
        for (int i16 = 0; i16 < i8; i16++) {
            fArr2[i16 + i9] = fArr[0] * fCalculateFMD * fArr3[i16];
        }
        for (int i17 = 0; i17 < i7; i17++) {
            fArr2[i17 + i9 + i8] = fArr[0] * fArr4[i17];
        }
        if (windowSequence.equals(ICSInfo.WindowSequence.LONG_START_SEQUENCE)) {
            for (int i18 = 0; i18 < i13; i18++) {
                fArr2[i18 + i8 + i7] = fArr5[i18];
            }
            int i19 = (i10 - i7) - i13;
            for (int i20 = 0; i20 < i19; i20++) {
                fArr2[i20 + i8 + i7 + i13] = 1.0f;
            }
        } else if (windowSequence.equals(ICSInfo.WindowSequence.LONG_STOP_SEQUENCE)) {
            for (int i21 = 0; i21 < i13; i21++) {
                fArr2[i21 + i9 + i8 + i7] = fArr5[i21];
            }
        }
        for (int i22 = 0; i22 < i; i22++) {
            this._function[i22] = 1.0f / fArr2[i22];
        }
    }

    private void compensate(float[] fArr, float[][] fArr2, ICSInfo.WindowSequence windowSequence, int i) {
        if (windowSequence.equals(ICSInfo.WindowSequence.EIGHT_SHORT_SEQUENCE)) {
            for (int i2 = 0; i2 < 8; i2++) {
                calculateFunctionData(this.lbShort * 2, i, windowSequence, i2);
                int i3 = 0;
                while (true) {
                    int i4 = this.lbShort;
                    if (i3 >= i4 * 2) {
                        break;
                    }
                    int i5 = (this.lbLong * i * 2) + (i4 * i2 * 2) + i3;
                    fArr[i5] = fArr[i5] * this._function[i3];
                    i3++;
                }
                int i6 = 0;
                while (true) {
                    int i7 = this.lbShort;
                    if (i6 >= i7) {
                        break;
                    }
                    int i8 = this.lbLong;
                    int i9 = ((i8 * 7) / 16) + i6 + (i7 * i2);
                    int i10 = (i8 * i * 2) + (i7 * i2 * 2) + i6;
                    float[] fArr3 = this.overlap[i];
                    fArr3[i9] = fArr3[i9] + fArr[i10];
                    i6++;
                }
                int i11 = 0;
                while (true) {
                    int i12 = this.lbShort;
                    if (i11 < i12) {
                        int i13 = this.lbLong;
                        this.overlap[i][((i13 * 7) / 16) + i11 + ((i2 + 1) * i12)] = fArr[(i13 * i * 2) + (i2 * i12 * 2) + i12 + i11];
                        i11++;
                    }
                }
                int[][] iArr = this.locationPrev[i];
                int[] iArr2 = this.location[i][i2];
                iArr[0] = Platform.copyOfInt(iArr2, iArr2.length);
                int[][] iArr3 = this.levelPrev[i];
                int[] iArr4 = this.level[i][i2];
                iArr3[0] = Platform.copyOfInt(iArr4, iArr4.length);
            }
            System.arraycopy(this.overlap[i], 0, fArr2[i], 0, this.lbLong);
            float[] fArr4 = this.overlap[i];
            int i14 = this.lbLong;
            System.arraycopy(fArr4, i14, fArr4, 0, i14);
            return;
        }
        calculateFunctionData(this.lbLong * 2, i, windowSequence, 0);
        int i15 = 0;
        while (true) {
            int i16 = this.lbLong;
            if (i15 >= i16 * 2) {
                break;
            }
            int i17 = (i16 * i * 2) + i15;
            fArr[i17] = fArr[i17] * this._function[i15];
            i15++;
        }
        int i18 = 0;
        while (true) {
            int i19 = this.lbLong;
            if (i18 >= i19) {
                break;
            }
            fArr2[i][i18] = this.overlap[i][i18] + fArr[(i19 * i * 2) + i18];
            i18++;
        }
        int i20 = 0;
        while (true) {
            int i21 = this.lbLong;
            if (i20 >= i21) {
                boolean zEquals = windowSequence.equals(ICSInfo.WindowSequence.ONLY_LONG_SEQUENCE);
                int[][] iArr5 = this.locationPrev[i];
                int[] iArr6 = this.location[i][zEquals ? 1 : 0];
                iArr5[0] = Platform.copyOfInt(iArr6, iArr6.length);
                int[][] iArr7 = this.levelPrev[i];
                int[] iArr8 = this.level[i][zEquals ? 1 : 0];
                iArr7[0] = Platform.copyOfInt(iArr8, iArr8.length);
                return;
            }
            this.overlap[i][i20] = fArr[(i * i21 * 2) + i21 + i20];
            i20++;
        }
    }

    private int getGainChangePointID(int i) {
        for (int i2 = 0; i2 < 16; i2++) {
            if (i == InterfaceC2801.f10210[i2]) {
                return i2;
            }
        }
        return 0;
    }

    private float interpolateGain(float f, float f2, int i) {
        return (float) Math.pow(2.0d, (((8 - i) * ((float) (Math.log(f) / Math.log(2.0d)))) + (i * ((float) (Math.log(f2) / Math.log(2.0d))))) / 8.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void decode(net.sourceforge.jaad.aac.syntax.IBitStream r12, net.sourceforge.jaad.aac.syntax.ICSInfo.WindowSequence r13) throws net.sourceforge.jaad.aac.AACException {
        /*
            r11 = this;
            java.lang.Class<int[]> r0 = int[].class
            r1 = 2
            int r2 = r12.readBits(r1)
            r3 = 1
            int r2 = r2 + r3
            r11.maxBand = r2
            int[] r2 = net.sourceforge.jaad.aac.gain.GainControl.C2198.f8061
            int r13 = r13.ordinal()
            r13 = r2[r13]
            r2 = 3
            r4 = 5
            r5 = 4
            if (r13 == r3) goto L2a
            if (r13 == r1) goto L26
            if (r13 == r2) goto L22
            if (r13 == r5) goto L1f
            return
        L1f:
            r13 = r1
            r6 = r4
            goto L24
        L22:
            r13 = r1
            r6 = r13
        L24:
            r4 = r5
            goto L2c
        L26:
            r13 = 8
            r4 = r1
            goto L2b
        L2a:
            r13 = r3
        L2b:
            r6 = r4
        L2c:
            int r7 = r11.maxBand
            int[] r8 = new int[r1]
            r8[r3] = r13
            r9 = 0
            r8[r9] = r7
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r0, r8)
            int[][][] r7 = (int[][][]) r7
            r11.level = r7
            int r7 = r11.maxBand
            int[] r1 = new int[r1]
            r1[r3] = r13
            r1[r9] = r7
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r1)
            int[][][] r0 = (int[][][]) r0
            r11.location = r0
        L4d:
            int r0 = r11.maxBand
            if (r3 >= r0) goto L91
            r0 = r9
        L52:
            if (r0 >= r13) goto L8e
            int r1 = r12.readBits(r2)
            int[][][] r7 = r11.level
            r7 = r7[r3]
            int[] r8 = new int[r1]
            r7[r0] = r8
            int[][][] r7 = r11.location
            r7 = r7[r3]
            int[] r8 = new int[r1]
            r7[r0] = r8
            r7 = r9
        L69:
            if (r7 >= r1) goto L8b
            int[][][] r8 = r11.level
            r8 = r8[r3]
            r8 = r8[r0]
            int r10 = r12.readBits(r5)
            r8[r7] = r10
            if (r0 != 0) goto L7b
            r8 = r4
            goto L7c
        L7b:
            r8 = r6
        L7c:
            int[][][] r10 = r11.location
            r10 = r10[r3]
            r10 = r10[r0]
            int r8 = r12.readBits(r8)
            r10[r7] = r8
            int r7 = r7 + 1
            goto L69
        L8b:
            int r0 = r0 + 1
            goto L52
        L8e:
            int r3 = r3 + 1
            goto L4d
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.jaad.aac.gain.GainControl.decode(net.sourceforge.jaad.aac.syntax.IBitStream, net.sourceforge.jaad.aac.syntax.ICSInfo$WindowSequence):void");
    }

    public void process(float[] fArr, int i, int i2, ICSInfo.WindowSequence windowSequence) throws AACException {
        this.imdct.m12997(fArr, this.buffer1, i, i2, windowSequence);
        for (int i3 = 0; i3 < 4; i3++) {
            compensate(this.buffer1, this.buffer2, windowSequence, i3);
        }
        this.ipqf.m9436(this.buffer2, this.frameLen, this.maxBand, fArr);
    }
}
