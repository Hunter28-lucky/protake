package org.jcodec.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class DataReader implements Closeable {
    private static final int DEFAULT_BUFFER_SIZE = 1048576;
    private ByteBuffer buffer;
    private SeekableByteChannel channel;

    public DataReader(SeekableByteChannel seekableByteChannel, ByteOrder byteOrder, int i) {
        this.channel = seekableByteChannel;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        this.buffer = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.buffer.order(byteOrder);
    }

    public static DataReader createDataReader(SeekableByteChannel seekableByteChannel, ByteOrder byteOrder) {
        return new DataReader(seekableByteChannel, byteOrder, 1048576);
    }

    private void fetchIfNeeded(int i) throws IOException {
        if (this.buffer.remaining() < i) {
            moveRemainderToTheStart(this.buffer);
            this.channel.read(this.buffer);
            this.buffer.flip();
        }
    }

    private static void moveRemainderToTheStart(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        for (int i = 0; i < iRemaining; i++) {
            byteBuffer.put(i, byteBuffer.get());
        }
        byteBuffer.clear();
        byteBuffer.position(iRemaining);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.channel.close();
    }

    public long position() throws IOException {
        return (this.channel.position() - this.buffer.limit()) + this.buffer.position();
    }

    public byte readByte() throws IOException {
        fetchIfNeeded(1);
        return this.buffer.get();
    }

    public char readChar() throws IOException {
        fetchIfNeeded(2);
        return this.buffer.getChar();
    }

    public double readDouble() throws IOException {
        fetchIfNeeded(8);
        return this.buffer.getDouble();
    }

    public float readFloat() throws IOException {
        fetchIfNeeded(4);
        return this.buffer.getFloat();
    }

    public int readFully(byte[] bArr) throws IOException {
        return readFully3(bArr, 0, bArr.length);
    }

    public int readFully3(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i;
        while (i2 > 0) {
            fetchIfNeeded(i2);
            if (this.buffer.remaining() == 0) {
                break;
            }
            int iMin = Math.min(this.buffer.remaining(), i2);
            this.buffer.get(bArr, i3, iMin);
            i3 += iMin;
            i2 -= iMin;
        }
        return i3 - i;
    }

    public int readInt() throws IOException {
        fetchIfNeeded(4);
        return this.buffer.getInt();
    }

    public long readLong() throws IOException {
        fetchIfNeeded(8);
        return this.buffer.getLong();
    }

    public short readShort() throws IOException {
        fetchIfNeeded(2);
        return this.buffer.getShort();
    }

    public long setPosition(long j) throws IOException {
        int iPosition = (int) (j - (this.channel.position() - this.buffer.limit()));
        if (iPosition < 0 || iPosition >= this.buffer.limit()) {
            this.buffer.limit(0);
            this.channel.setPosition(j);
        } else {
            this.buffer.position(iPosition);
        }
        return position();
    }

    public long size() throws IOException {
        return this.channel.size();
    }

    public int skipBytes(int i) throws IOException {
        long jPosition = position();
        if (i < this.buffer.remaining()) {
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.position() + i);
        } else {
            setPosition(i + jPosition);
        }
        return (int) (position() - jPosition);
    }
}
