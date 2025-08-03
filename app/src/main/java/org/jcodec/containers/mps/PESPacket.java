package org.jcodec.containers.mps;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class PESPacket {
    public ByteBuffer data;
    public long dts;
    public int length;
    public long pos;
    public long pts;
    public int streamId;

    public PESPacket(ByteBuffer byteBuffer, long j, int i, int i2, long j2, long j3) {
        this.data = byteBuffer;
        this.pts = j;
        this.streamId = i;
        this.length = i2;
        this.pos = j2;
        this.dts = j3;
    }
}
