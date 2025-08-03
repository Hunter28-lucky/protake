package org.jcodec.common.dct;

import org.jcodec.scale.ImageConvert;

/* loaded from: classes2.dex */
public class SlowDCT extends DCT {
    public static final SlowDCT INSTANCE = new SlowDCT();
    private static final double rSqrt2 = 1.0d / Math.sqrt(2.0d);

    @Override // org.jcodec.common.dct.DCT
    public int[] decode(int[] iArr) {
        int[] iArr2 = new int[64];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 8;
            if (i >= 8) {
                return iArr2;
            }
            int i4 = 0;
            while (i4 < i3) {
                double dCos = 0.0d;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i3) {
                    double d = i5 == 0 ? rSqrt2 : 1.0d;
                    int i7 = 0;
                    while (i7 < i3) {
                        dCos += (i7 == 0 ? rSqrt2 : 1.0d) * d * iArr[i6] * Math.cos(((((i4 * 2) + 1) * i7) * 3.141592653589793d) / 16.0d) * Math.cos(((((i * 2) + 1) * i5) * 3.141592653589793d) / 16.0d);
                        i6++;
                        i7++;
                        i4 = i4;
                        i = i;
                        i3 = 8;
                    }
                    i5++;
                    i3 = 8;
                }
                iArr2[i2] = ImageConvert.icrop((int) Math.round((dCos * 0.25d) + 128.0d));
                i4++;
                i2++;
                i = i;
                i3 = 8;
            }
            i++;
        }
    }

    @Override // org.jcodec.common.dct.DCT
    public short[] encode(byte[] bArr) {
        short[] sArr = new short[64];
        int i = 0;
        while (true) {
            int i2 = 8;
            if (i >= 8) {
                break;
            }
            int i3 = 0;
            while (i3 < i2) {
                float fCos = 0.0f;
                int i4 = 0;
                while (i4 < i2) {
                    int i5 = 0;
                    while (i5 < i2) {
                        int i6 = i3;
                        fCos = (float) (fCos + (bArr[(i4 * 8) + i5] * Math.cos((i4 + 0.5d) * 0.39269908169872414d * i) * Math.cos((i5 + 0.5d) * 0.39269908169872414d * i6)));
                        i5++;
                        i3 = i6;
                        i2 = 8;
                    }
                    i4++;
                    i2 = 8;
                }
                int i7 = i3;
                sArr[(i * 8) + i7] = (byte) fCos;
                i3 = i7 + 1;
                i2 = 8;
            }
            i++;
        }
        sArr[0] = (byte) (sArr[0] / 8.0f);
        double dSqrt = Math.sqrt(2.0d);
        int i8 = 1;
        for (int i9 = 8; i8 < i9; i9 = 8) {
            sArr[i8] = (byte) ((sArr[0] * dSqrt) / 8.0d);
            int i10 = i8 * 8;
            sArr[i10] = (byte) ((sArr[0] * dSqrt) / 8.0d);
            for (int i11 = 1; i11 < 8; i11++) {
                sArr[i10 + i11] = (byte) (sArr[0] / 4.0f);
            }
            i8++;
        }
        return sArr;
    }
}
