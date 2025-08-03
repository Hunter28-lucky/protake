package org.jcodec.audio;

import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
public abstract class ConvolutionFilter implements AudioFilter {
    private double[] kernel;

    public abstract double[] buildKernel();

    @Override // org.jcodec.audio.AudioFilter
    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != 1) {
            throw new IllegalArgumentException(getClass().getName() + " filter is designed to work only on one input");
        }
        if (floatBufferArr2.length != 1) {
            throw new IllegalArgumentException(getClass().getName() + " filter is designed to work only on one output");
        }
        FloatBuffer floatBuffer = floatBufferArr[0];
        FloatBuffer floatBuffer2 = floatBufferArr2[0];
        if (this.kernel == null) {
            this.kernel = buildKernel();
        }
        if (floatBuffer2.remaining() < floatBuffer.remaining() - this.kernel.length) {
            throw new IllegalArgumentException("Output buffer is too small");
        }
        int iRemaining = floatBuffer.remaining();
        double[] dArr = this.kernel;
        if (iRemaining <= dArr.length) {
            throw new IllegalArgumentException("Input buffer should contain > kernel lenght (" + this.kernel.length + ") samples.");
        }
        int length = dArr.length / 2;
        int iPosition = floatBuffer.position() + length;
        while (iPosition < floatBuffer.limit() - length) {
            double d = 0.0d;
            int i = 0;
            while (true) {
                double[] dArr2 = this.kernel;
                if (i < dArr2.length) {
                    d += dArr2[i] * floatBuffer.get((iPosition + i) - length);
                    i++;
                }
            }
            floatBuffer2.put((float) d);
            iPosition++;
        }
        floatBuffer.position(iPosition - length);
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getDelay() {
        if (this.kernel == null) {
            this.kernel = buildKernel();
        }
        return this.kernel.length / 2;
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
