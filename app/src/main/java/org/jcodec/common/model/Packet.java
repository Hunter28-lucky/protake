package org.jcodec.common.model;

import java.nio.ByteBuffer;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class Packet {
    public static final Comparator<Packet> FRAME_ASC = new Comparator<Packet>() { // from class: org.jcodec.common.model.Packet.1
        @Override // java.util.Comparator
        public int compare(Packet packet, Packet packet2) {
            if (packet == null && packet2 == null) {
                return 0;
            }
            if (packet == null) {
                return -1;
            }
            if (packet2 == null) {
                return 1;
            }
            long j = packet.frameNo;
            long j2 = packet2.frameNo;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    };
    public ByteBuffer data;
    public int displayOrder;
    public long duration;
    public long frameNo;
    public FrameType frameType;
    public long pts;
    public TapeTimecode tapeTimecode;
    public int timescale;

    public enum FrameType {
        KEY,
        INTER,
        UNKNOWN
    }

    public Packet(ByteBuffer byteBuffer, long j, int i, long j2, long j3, FrameType frameType, TapeTimecode tapeTimecode, int i2) {
        this.data = byteBuffer;
        this.pts = j;
        this.timescale = i;
        this.duration = j2;
        this.frameNo = j3;
        this.frameType = frameType;
        this.tapeTimecode = tapeTimecode;
        this.displayOrder = i2;
    }

    public static Packet createPacket(ByteBuffer byteBuffer, long j, int i, long j2, long j3, FrameType frameType, TapeTimecode tapeTimecode) {
        return new Packet(byteBuffer, j, i, j2, j3, frameType, tapeTimecode, 0);
    }

    public static Packet createPacketWithData(Packet packet, ByteBuffer byteBuffer) {
        return new Packet(byteBuffer, packet.pts, packet.timescale, packet.duration, packet.frameNo, packet.frameType, packet.tapeTimecode, packet.displayOrder);
    }

    public ByteBuffer getData() {
        return this.data.duplicate();
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public long getDuration() {
        return this.duration;
    }

    public double getDurationD() {
        return this.duration / this.timescale;
    }

    public long getFrameNo() {
        return this.frameNo;
    }

    public FrameType getFrameType() {
        return this.frameType;
    }

    public long getPts() {
        return this.pts;
    }

    public double getPtsD() {
        return this.pts / this.timescale;
    }

    public RationalLarge getPtsR() {
        return RationalLarge.R(this.pts, this.timescale);
    }

    public TapeTimecode getTapeTimecode() {
        return this.tapeTimecode;
    }

    public int getTimescale() {
        return this.timescale;
    }

    public boolean isKeyFrame() {
        return this.frameType == FrameType.KEY;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setFrameType(FrameType frameType) {
        this.frameType = frameType;
    }

    public void setPts(long j) {
        this.pts = j;
    }

    public void setTapeTimecode(TapeTimecode tapeTimecode) {
        this.tapeTimecode = tapeTimecode;
    }

    public void setTimescale(int i) {
        this.timescale = i;
    }
}
