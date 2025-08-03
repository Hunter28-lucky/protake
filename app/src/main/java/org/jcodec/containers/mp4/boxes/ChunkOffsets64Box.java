package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ChunkOffsets64Box extends FullBox {
    private long[] chunkOffsets;

    public ChunkOffsets64Box(Header header) {
        super(header);
    }

    public static ChunkOffsets64Box createChunkOffsets64Box(long[] jArr) {
        ChunkOffsets64Box chunkOffsets64Box = new ChunkOffsets64Box(Header.createHeader(fourcc(), 0L));
        chunkOffsets64Box.chunkOffsets = jArr;
        return chunkOffsets64Box;
    }

    public static String fourcc() {
        return "co64";
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.chunkOffsets.length);
        int i = 0;
        while (true) {
            long[] jArr = this.chunkOffsets;
            if (i >= jArr.length) {
                return;
            }
            byteBuffer.putLong(jArr[i]);
            i++;
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return (this.chunkOffsets.length * 8) + 16;
    }

    public long[] getChunkOffsets() {
        return this.chunkOffsets;
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        int i = byteBuffer.getInt();
        this.chunkOffsets = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.chunkOffsets[i2] = byteBuffer.getLong();
        }
    }

    public void setChunkOffsets(long[] jArr) {
        this.chunkOffsets = jArr;
    }
}
