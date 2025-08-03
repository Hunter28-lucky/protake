package org.jcodec.containers.mps;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.TapeTimecode;

/* loaded from: classes2.dex */
public class MPEGPacket extends Packet {
    private int gop;
    private long offset;
    private ByteBuffer seq;
    private int timecode;

    public MPEGPacket(ByteBuffer byteBuffer, long j, int i, long j2, long j3, Packet.FrameType frameType, TapeTimecode tapeTimecode) {
        super(byteBuffer, j, i, j2, j3, frameType, tapeTimecode, 0);
    }

    public int getGOP() {
        return this.gop;
    }

    public long getOffset() {
        return this.offset;
    }

    public ByteBuffer getSeq() {
        return this.seq;
    }

    public int getTimecode() {
        return this.timecode;
    }
}
