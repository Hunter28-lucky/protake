package org.jcodec.audio;

import java.io.IOException;
import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
public class Audio {

    public static class DummyFilter implements AudioFilter {
        private int nInputs;

        public DummyFilter(int i) {
            this.nInputs = i;
        }

        @Override // org.jcodec.audio.AudioFilter
        public void filter(FloatBuffer[] floatBufferArr, long[] jArr, FloatBuffer[] floatBufferArr2) {
            for (int i = 0; i < floatBufferArr.length; i++) {
                if (floatBufferArr2[i].remaining() >= floatBufferArr[i].remaining()) {
                    floatBufferArr2[i].put(floatBufferArr[i]);
                } else {
                    FloatBuffer floatBufferDuplicate = floatBufferArr[i].duplicate();
                    floatBufferDuplicate.limit(floatBufferArr[i].position() + floatBufferArr2[i].remaining());
                    floatBufferArr2[i].put(floatBufferDuplicate);
                }
            }
        }

        @Override // org.jcodec.audio.AudioFilter
        public int getDelay() {
            return 0;
        }

        @Override // org.jcodec.audio.AudioFilter
        public int getNInputs() {
            return this.nInputs;
        }

        @Override // org.jcodec.audio.AudioFilter
        public int getNOutputs() {
            return this.nInputs;
        }
    }

    public static void filterTransfer(AudioSource audioSource, AudioFilter audioFilter, AudioSink audioSink) throws IOException {
        if (audioFilter.getNInputs() != 1) {
            throw new IllegalArgumentException("Audio filter has # inputs != 1");
        }
        if (audioFilter.getNOutputs() != 1) {
            throw new IllegalArgumentException("Audio filter has # outputs != 1");
        }
        if (audioFilter.getDelay() != 0) {
            throw new IllegalArgumentException("Audio filter has delay");
        }
        FloatBuffer[] floatBufferArr = {FloatBuffer.allocate(4096)};
        FloatBuffer[] floatBufferArr2 = {FloatBuffer.allocate(8192)};
        long[] jArr = new long[1];
        while (audioSource.readFloat(floatBufferArr[0]) != -1) {
            floatBufferArr[0].flip();
            audioFilter.filter(floatBufferArr, jArr, floatBufferArr2);
            jArr[0] = jArr[0] + floatBufferArr[0].position();
            rotate(floatBufferArr[0]);
            floatBufferArr2[0].flip();
            audioSink.writeFloat(floatBufferArr2[0]);
            floatBufferArr2[0].clear();
        }
    }

    public static void print(FloatBuffer floatBuffer) {
        FloatBuffer floatBufferDuplicate = floatBuffer.duplicate();
        while (floatBufferDuplicate.hasRemaining()) {
            System.out.print(String.format("%.3f,", Float.valueOf(floatBufferDuplicate.get())));
        }
        System.out.println();
    }

    public static void rotate(FloatBuffer floatBuffer) {
        int i = 0;
        while (floatBuffer.hasRemaining()) {
            floatBuffer.put(i, floatBuffer.get());
            i++;
        }
        floatBuffer.position(i);
        floatBuffer.limit(floatBuffer.capacity());
    }

    public static void transfer(AudioSource audioSource, AudioSink audioSink) throws IOException {
        filterTransfer(audioSource, new DummyFilter(1), audioSink);
    }
}
