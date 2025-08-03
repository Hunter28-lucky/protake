package org.jcodec.audio;

import java.nio.FloatBuffer;
import org.jcodec.common.AudioFormat;

/* loaded from: classes2.dex */
public class ChannelSplit implements AudioFilter {
    private AudioFormat format;

    public ChannelSplit(AudioFormat audioFormat) {
        this.format = audioFormat;
    }

    @Override // org.jcodec.audio.AudioFilter
    public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
        if (floatBufferArr.length != 1) {
            throw new IllegalArgumentException("Channel split invoked on more then one input");
        }
        if (floatBufferArr2.length != this.format.getChannels()) {
            throw new IllegalArgumentException("Channel split must be supplied with " + this.format.getChannels() + " output buffers to hold the channels.");
        }
        FloatBuffer floatBuffer = floatBufferArr[0];
        int iRemaining = floatBuffer.remaining() / floatBufferArr2.length;
        for (int i = 0; i < floatBufferArr2.length; i++) {
            if (floatBufferArr2[i].remaining() < iRemaining) {
                throw new IllegalArgumentException("Supplied buffer for " + i + "th channel doesn't have sufficient space to put the samples ( required: " + iRemaining + ", actual: " + floatBufferArr2[i].remaining() + ")");
            }
        }
        while (floatBuffer.remaining() >= this.format.getChannels()) {
            for (FloatBuffer floatBuffer2 : floatBufferArr2) {
                floatBuffer2.put(floatBuffer.get());
            }
        }
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getDelay() {
        return 0;
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNInputs() {
        return 1;
    }

    @Override // org.jcodec.audio.AudioFilter
    public int getNOutputs() {
        return this.format.getChannels();
    }
}
