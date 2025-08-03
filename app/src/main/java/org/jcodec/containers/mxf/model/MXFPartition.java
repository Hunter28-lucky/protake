package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class MXFPartition {
    private boolean closed;
    private boolean complete;
    private long essenceFilePos;
    private long essenceLength;
    private MXFPartitionPack pack;

    public MXFPartition(MXFPartitionPack mXFPartitionPack, long j, boolean z, boolean z2, long j2) {
        this.pack = mXFPartitionPack;
        this.essenceFilePos = j;
        this.closed = z;
        this.complete = z2;
        this.essenceLength = j2;
    }

    public static MXFPartition read(UL ul, ByteBuffer byteBuffer, long j, long j2) {
        boolean z = (ul.get(14) & 1) == 0;
        boolean z2 = ul.get(14) > 2;
        MXFPartitionPack mXFPartitionPack = new MXFPartitionPack(ul);
        mXFPartitionPack.readBuf(byteBuffer);
        long jRoundToKag = roundToKag(mXFPartitionPack.getThisPartition() + j, mXFPartitionPack.getKagSize()) + roundToKag(mXFPartitionPack.getHeaderByteCount(), mXFPartitionPack.getKagSize()) + roundToKag(mXFPartitionPack.getIndexByteCount(), mXFPartitionPack.getKagSize());
        return new MXFPartition(mXFPartitionPack, jRoundToKag, z, z2, j2 - jRoundToKag);
    }

    public static long roundToKag(long j, int i) {
        long j2 = i;
        long j3 = (j / j2) * j2;
        return j3 == j ? j3 : j3 + j2;
    }

    public long getEssenceFilePos() {
        return this.essenceFilePos;
    }

    public long getEssenceLength() {
        return this.essenceLength;
    }

    public MXFPartitionPack getPack() {
        return this.pack;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isComplete() {
        return this.complete;
    }
}
