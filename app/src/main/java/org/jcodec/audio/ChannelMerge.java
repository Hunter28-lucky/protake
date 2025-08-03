package org.jcodec.audio;

import java.nio.FloatBuffer;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Preconditions;

/* loaded from: classes2.dex */
public class ChannelMerge implements AudioFilter {
    private AudioFormat format;

    public ChannelMerge(AudioFormat audioFormat) {
        this.format = audioFormat;
    }

    @Override // org.jcodec.audio.AudioFilter
    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != this.format.getChannels()) {
            throw new IllegalArgumentException("Channel merge must be supplied with " + this.format.getChannels() + " input buffers to hold the channels.");
        }
        if (floatBufferArr2.length != 1) {
            throw new IllegalArgumentException("Channel merget invoked on more then one output");
        }
        FloatBuffer floatBuffer = floatBufferArr2[0];
        int iRemaining = Integer.MAX_VALUE;
        for (int i = 0; i < floatBufferArr.length; i++) {
            if (floatBufferArr[i].remaining() < iRemaining) {
                iRemaining = floatBufferArr[i].remaining();
            }
        }
        for (FloatBuffer floatBuffer2 : floatBufferArr) {
            Preconditions.checkState(floatBuffer2.remaining() == iRemaining);
        }
        if (floatBuffer.remaining() >= floatBufferArr.length * iRemaining) {
            for (int i2 = 0; i2 < iRemaining; i2++) {
                for (FloatBuffer floatBuffer3 : floatBufferArr) {
                    floatBuffer.put(floatBuffer3.get());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Supplied output buffer is not big enough to hold " + iRemaining + " * " + floatBufferArr.length + " = " + (iRemaining * floatBufferArr.length) + " output samples.");
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getDelay() {
        return 0;
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNInputs() {
        return this.format.getChannels();
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNOutputs() {
        return 1;
    }
}
