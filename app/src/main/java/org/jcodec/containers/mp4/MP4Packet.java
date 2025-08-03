package org.jcodec.containers.mp4;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.TapeTimecode;

/* loaded from: classes2.dex */
public class MP4Packet extends Packet {
    private int entryNo;
    private long fileOff;
    private long mediaPts;
    private boolean psync;
    private int size;

    public MP4Packet(ByteBuffer byteBuffer, long j, int i, long j2, long j3, Packet.FrameType frameType, TapeTimecode tapeTimecode, int i2, long j4, int i3, long j5, int i4, boolean z) {
        super(byteBuffer, j, i, j2, j3, frameType, tapeTimecode, i2);
        this.mediaPts = j4;
        this.entryNo = i3;
        this.fileOff = j5;
        this.size = i4;
        this.psync = z;
    }

    public static MP4Packet createMP4Packet(ByteBuffer byteBuffer, long j, int i, long j2, long j3, Packet.FrameType frameType, TapeTimecode tapeTimecode, int i2, long j4, int i3) {
        return new MP4Packet(byteBuffer, j, i, j2, j3, frameType, tapeTimecode, i2, j4, i3, 0L, 0, false);
    }

    public static MP4Packet createMP4PacketWithData(MP4Packet mP4Packet, ByteBuffer byteBuffer) {
        return createMP4Packet(byteBuffer, mP4Packet.pts, mP4Packet.timescale, mP4Packet.duration, mP4Packet.frameNo, mP4Packet.frameType, mP4Packet.tapeTimecode, mP4Packet.displayOrder, mP4Packet.mediaPts, mP4Packet.entryNo);
    }

    public static MP4Packet createMP4PacketWithTimecode(MP4Packet mP4Packet, TapeTimecode tapeTimecode) {
        return createMP4Packet(mP4Packet.data, mP4Packet.pts, mP4Packet.timescale, mP4Packet.duration, mP4Packet.frameNo, mP4Packet.frameType, tapeTimecode, mP4Packet.displayOrder, mP4Packet.mediaPts, mP4Packet.entryNo);
    }

    public int getEntryNo() {
        return this.entryNo;
    }

    public long getFileOff() {
        return this.fileOff;
    }

    public long getMediaPts() {
        return this.mediaPts;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isPsync() {
        return this.psync;
    }
}
