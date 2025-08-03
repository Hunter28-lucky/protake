package org.jcodec.common.model;

import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;

/* loaded from: classes2.dex */
public class AudioFrame extends AudioBuffer {
    private long duration;
    private int frameNo;
    private long pts;
    private long timescale;

    public AudioFrame(ByteBuffer byteBuffer, AudioFormat audioFormat, int i, long j, long j2, long j3, int i2) {
        super(byteBuffer, audioFormat, i);
        this.pts = j;
        this.duration = j2;
        this.timescale = j3;
        this.frameNo = i2;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getFrameNo() {
        return this.frameNo;
    }

    public long getPts() {
        return this.pts;
    }

    public long getTimescale() {
        return this.timescale;
    }
}
