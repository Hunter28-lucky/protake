package org.jcodec.common.dct;

/* loaded from: classes2.dex */
public class DCTRef {
    public static double[] coefficients = new double[64];

    static {
        int i = 0;
        while (true) {
            if (i >= 8) {
                return;
            }
            coefficients[i] = Math.sqrt(0.125d);
            for (int i2 = 8; i2 < 64; i2 += 8) {
                coefficients[i2 + i] = Math.cos(((i2 * (i + 0.5d)) * 3.141592653589793d) / 64.0d) * 0.5d;
            }
            i++;
        }
    }

    public static void fdct(int[] iArr, int i) {
        double[] dArr = new double[64];
        for (int i2 = 0; i2 < 64; i2 += 8) {
            for (int i3 = 0; i3 < 8; i3++) {
                double d = 0.0d;
                for (int i4 = 0; i4 < 8; i4++) {
                    d += coefficients[i2 + i4] * iArr[(i4 * 8) + i3 + i];
                }
                dArr[i2 + i3] = d * 4.0d;
            }
        }
        for (int i5 = 0; i5 < 8; i5++) {
            for (int i6 = 0; i6 < 64; i6 += 8) {
                double d2 = 0.0d;
                for (int i7 = 0; i7 < 8; i7++) {
                    d2 += dArr[i6 + i7] * coefficients[(i5 * 8) + i7];
                }
                iArr[i6 + i5 + i] = (int) (d2 + 0.499999999999d);
            }
        }
    }

    public static void idct(int[] iArr, int i) {
        double[] dArr = new double[64];
        for (int i2 = 0; i2 < 64; i2 += 8) {
            for (int i3 = 0; i3 < 8; i3++) {
                double d = 0.0d;
                for (int i4 = 0; i4 < 8; i4++) {
                    d += iArr[i2 + i4] * coefficients[(i4 * 8) + i3];
                }
                dArr[i2 + i3] = d;
            }
        }
        for (int i5 = 0; i5 < 8; i5++) {
            for (int i6 = 0; i6 < 8; i6++) {
                double d2 = 0.0d;
                for (int i7 = 0; i7 < 64; i7 += 8) {
                    d2 += coefficients[i7 + i5] * dArr[i7 + i6];
                }
                iArr[(i5 * 8) + i6] = (int) (d2 + 0.5d);
            }
        }
    }
}
