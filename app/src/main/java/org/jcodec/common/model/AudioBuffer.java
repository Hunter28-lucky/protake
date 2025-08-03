package org.jcodec.common.model;

import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;

/* loaded from: classes2.dex */
public class AudioBuffer {
    public ByteBuffer data;
    public AudioFormat format;
    public int nFrames;

    public AudioBuffer(ByteBuffer byteBuffer, AudioFormat audioFormat, int i) {
        this.data = byteBuffer;
        this.format = audioFormat;
        this.nFrames = i;
    }

    public ByteBuffer getData() {
        return this.data;
    }

    public AudioFormat getFormat() {
        return this.format;
    }

    public int getNFrames() {
        return this.nFrames;
    }
}
