package org.jcodec.audio;

import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
public class LanczosInterpolator implements AudioFilter {
    private double rateStep;

    public LanczosInterpolator(int i, int i2) {
        this.rateStep = i / i2;
    }

    public static double lanczos(double d, int i) {
        if (d < (-i)) {
            return 0.0d;
        }
        double d2 = i;
        if (d > d2) {
            return 0.0d;
        }
        double d3 = 3.141592653589793d * d;
        return ((Math.sin(d3) * d2) * Math.sin(d3 / d2)) / ((9.869604401089358d * d) * d);
    }

    @Override // org.jcodec.audio.AudioFilter
    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        FloatBuffer floatBuffer;
        FloatBuffer floatBuffer2;
        int i;
        LanczosInterpolator lanczosInterpolator = this;
        if (floatBufferArr.length != 1) {
            throw new IllegalArgumentException(getClass().getName() + " filter is designed to work only on one input");
        }
        if (floatBufferArr2.length != 1) {
            throw new IllegalArgumentException(getClass().getName() + " filter is designed to work only on one output");
        }
        char c = 0;
        FloatBuffer floatBuffer3 = floatBufferArr[0];
        FloatBuffer floatBuffer4 = floatBufferArr2[0];
        if (floatBuffer4.remaining() < (floatBuffer3.remaining() - 6) / lanczosInterpolator.rateStep) {
            throw new IllegalArgumentException("Output buffer is too small");
        }
        if (floatBuffer3.remaining() <= 6) {
            throw new IllegalArgumentException("Input buffer should contain > 6 samples.");
        }
        int i2 = 0;
        while (true) {
            double d = lanczosInterpolator.rateStep;
            double dCeil = (((i2 * d) + 3.0d) + (Math.ceil(jArr[c] / d) * lanczosInterpolator.rateStep)) - jArr[c];
            int iFloor = (int) Math.floor(dCeil);
            int iCeil = (int) Math.ceil(dCeil);
            if (iFloor >= floatBuffer3.limit() - 3) {
                floatBuffer3.position(iFloor - 3);
                return;
            }
            double d2 = iFloor - dCeil;
            if (d2 < -0.001d) {
                double d3 = iCeil - dCeil;
                double dLanczos = lanczos(d2, 3);
                double dLanczos2 = lanczos(d3, 3);
                i = i2;
                double dLanczos3 = lanczos(d2 - 1.0d, 3);
                double dLanczos4 = lanczos(d3 + 1.0d, 3);
                double dLanczos5 = lanczos(d2 - 2.0d, 3);
                double dLanczos6 = lanczos(d3 + 2.0d, 3);
                floatBuffer = floatBuffer3;
                floatBuffer2 = floatBuffer4;
                floatBuffer2.put((float) (((floatBuffer.get(iCeil) * dLanczos2) + (floatBuffer.get(iCeil + 1) * dLanczos4) + (floatBuffer.get(iCeil + 2) * dLanczos6) + (floatBuffer.get(iFloor) * dLanczos) + (floatBuffer.get(iFloor - 1) * dLanczos3) + (floatBuffer.get(iFloor - 2) * dLanczos5)) * (1.0d / (((((dLanczos + dLanczos3) + dLanczos5) + dLanczos2) + dLanczos4) + dLanczos6))));
            } else {
                floatBuffer = floatBuffer3;
                floatBuffer2 = floatBuffer4;
                i = i2;
                floatBuffer2.put(floatBuffer.get(iFloor));
            }
            i2 = i + 1;
            lanczosInterpolator = this;
            floatBuffer4 = floatBuffer2;
            floatBuffer3 = floatBuffer;
            c = 0;
        }
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getDelay() {
        return 3;
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNInputs() {
        return 1;
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNOutputs() {
        return 1;
    }
}
