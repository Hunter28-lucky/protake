package org.jcodec.common.io;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferSeekableByteChannel implements SeekableByteChannel {
    private ByteBuffer backing;
    private int contentLength;
    private boolean open = true;

    public ByteBufferSeekableByteChannel(ByteBuffer byteBuffer, int i) {
        this.backing = byteBuffer;
        this.contentLength = i;
    }

    public static ByteBufferSeekableByteChannel readFromByteBuffer(ByteBuffer byteBuffer) {
        return new ByteBufferSeekableByteChannel(byteBuffer, byteBuffer.remaining());
    }

    public static ByteBufferSeekableByteChannel writeToByteBuffer(ByteBuffer byteBuffer) {
        return new ByteBufferSeekableByteChannel(byteBuffer, 0);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.open = false;
    }

    public ByteBuffer getContents() {
        ByteBuffer byteBufferDuplicate = this.backing.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(this.contentLength);
        return byteBufferDuplicate;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.open;
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public long position() throws IOException {
        return this.backing.position();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!this.backing.hasRemaining() || this.contentLength <= 0) {
            return -1;
        }
        int iMin = Math.min(Math.min(this.backing.remaining(), byteBuffer.remaining()), this.contentLength);
        byteBuffer.put(NIOUtils.read(this.backing, iMin));
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return iMin;
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public SeekableByteChannel setPosition(long j) throws IOException {
        this.backing.position((int) j);
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return this;
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public long size() throws IOException {
        return this.contentLength;
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public SeekableByteChannel truncate(long j) throws IOException {
        this.contentLength = (int) j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int iMin = Math.min(this.backing.remaining(), byteBuffer.remaining());
        this.backing.put(NIOUtils.read(byteBuffer, iMin));
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return iMin;
    }
}
