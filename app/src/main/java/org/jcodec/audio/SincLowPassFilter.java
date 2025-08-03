package org.jcodec.audio;

/* loaded from: classes2.dex */
public class SincLowPassFilter extends ConvolutionFilter {
    private double cutoffFreq;
    private int kernelSize;

    public SincLowPassFilter(int i, double d) {
        this.kernelSize = i;
        this.cutoffFreq = d;
    }

    public static SincLowPassFilter createSincLowPassFilter(double d) {
        return new SincLowPassFilter(40, d);
    }

    public static SincLowPassFilter createSincLowPassFilter2(int i, int i2) {
        return new SincLowPassFilter(40, i / i2);
    }

    @Override // org.jcodec.audio.ConvolutionFilter
    public double[] buildKernel() {
        double d;
        double[] dArr = new double[this.kernelSize];
        double d2 = 0.0d;
        int i = 0;
        while (true) {
            int i2 = this.kernelSize;
            if (i >= i2) {
                break;
            }
            if (i - (i2 / 2) != 0) {
                d = d2;
                dArr[i] = (Math.sin((this.cutoffFreq * 6.283185307179586d) * (i - (i2 / 2))) / (i - (r10 / 2))) * (0.54d - (Math.cos((i * 6.283185307179586d) / this.kernelSize) * 0.46d));
            } else {
                d = d2;
                dArr[i] = this.cutoffFreq * 6.283185307179586d;
            }
            d2 = d + dArr[i];
            i++;
        }
        double d3 = d2;
        for (int i3 = 0; i3 < this.kernelSize; i3++) {
            dArr[i3] = dArr[i3] / d3;
        }
        return dArr;
    }
}
