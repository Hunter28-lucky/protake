package org.jcodec.scale;

import java.lang.reflect.Array;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class BicubicResampler extends BaseResampler {
    private static double alpha = 0.6d;
    private short[][] horizontalTaps;
    private short[][] verticalTaps;

    public BicubicResampler(Size size, Size size2) {
        super(size, size2);
        this.horizontalTaps = buildFilterTaps(size2.getWidth(), size.getWidth());
        this.verticalTaps = buildFilterTaps(size2.getHeight(), size.getHeight());
    }

    private static short[][] buildFilterTaps(int i, int i2) {
        double d;
        int i3 = i;
        int i4 = i2;
        double[] dArr = new double[4];
        int i5 = 0;
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i3, 4);
        double d2 = i4;
        double d3 = i3;
        double d4 = d2 / d3;
        double d5 = d3 / d2;
        double d6 = 0.0d;
        while (i5 < i3) {
            double d7 = d6 - ((int) d6);
            int i6 = -1;
            while (i6 < 3) {
                double d8 = i6 - d7;
                if (i3 < i4) {
                    d8 *= d5;
                }
                double dAbs = Math.abs(d8);
                double d9 = dAbs * dAbs;
                double d10 = d9 * dAbs;
                if (d8 >= -1.0d && d8 <= 1.0d) {
                    double d11 = alpha;
                    dArr[i6 + 1] = ((2.0d - d11) * d10) + ((d11 - 3.0d) * d9) + 1.0d;
                    d = d5;
                } else if (d8 < -2.0d || d8 > 2.0d) {
                    d = d5;
                    dArr[i6 + 1] = 0.0d;
                    i6++;
                    i3 = i;
                    i4 = i2;
                    d5 = d;
                } else {
                    double d12 = alpha;
                    d = d5;
                    dArr[i6 + 1] = ((((-d12) * d10) + ((5.0d * d12) * d9)) - ((8.0d * d12) * dAbs)) + (d12 * 4.0d);
                }
                i6++;
                i3 = i;
                i4 = i2;
                d5 = d;
            }
            BaseResampler.normalizeAndGenerateFixedPrecision(dArr, 7, sArr[i5]);
            d6 += d4;
            i5++;
            i3 = i;
            i4 = i2;
        }
        return sArr;
    }

    @Override // org.jcodec.scale.BaseResampler
    public short[] getTapsX(int i) {
        return this.horizontalTaps[i];
    }

    @Override // org.jcodec.scale.BaseResampler
    public short[] getTapsY(int i) {
        return this.verticalTaps[i];
    }

    @Override // org.jcodec.scale.BaseResampler
    public int nTaps() {
        return 4;
    }
}
