package org.jcodec.scale;

import java.lang.reflect.Array;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class LanczosResampler extends BaseResampler {
    private static final int _nTaps = 6;
    private double _scaleFactorX;
    private double _scaleFactorY;
    private int precision;
    private short[][] tapsXs;
    private short[][] tapsYs;

    public LanczosResampler(Size size, Size size2) {
        super(size, size2);
        this.precision = 256;
        this._scaleFactorX = size2.getWidth() / size.getWidth();
        this._scaleFactorY = size2.getHeight() / size.getHeight();
        this.tapsXs = (short[][]) Array.newInstance((Class<?>) Short.TYPE, this.precision, 6);
        this.tapsYs = (short[][]) Array.newInstance((Class<?>) Short.TYPE, this.precision, 6);
        buildTaps(6, this.precision, this._scaleFactorX, this.tapsXs);
        buildTaps(6, this.precision, this._scaleFactorY, this.tapsYs);
    }

    private static void buildTaps(int i, int i2, double d, short[][] sArr) {
        double[] dArr = new double[i];
        for (int i3 = 0; i3 < i2; i3++) {
            double d2 = i3 / i2;
            int i4 = ((-i) / 2) + 1;
            int i5 = 0;
            while (i4 < (i / 2) + 1) {
                double d3 = (-d2) + i4;
                dArr[i5] = sinc(d * d3 * 3.141592653589793d) * d * Math.sin(((d3 * 3.141592653589793d) / (i - 1)) + 1.5707963267948966d);
                i4++;
                i5++;
            }
            BaseResampler.normalizeAndGenerateFixedPrecision(dArr, 7, sArr[i3]);
        }
    }

    private static double sinc(double d) {
        if (d == 0.0d) {
            return 1.0d;
        }
        return Math.sin(d) / d;
    }

    @Override // org.jcodec.scale.BaseResampler
    public short[] getTapsX(int i) {
        return this.tapsXs[((int) ((i * r0) / this._scaleFactorX)) % this.precision];
    }

    @Override // org.jcodec.scale.BaseResampler
    public short[] getTapsY(int i) {
        return this.tapsYs[((int) ((i * r0) / this._scaleFactorY)) % this.precision];
    }

    @Override // org.jcodec.scale.BaseResampler
    public int nTaps() {
        return 6;
    }
}
