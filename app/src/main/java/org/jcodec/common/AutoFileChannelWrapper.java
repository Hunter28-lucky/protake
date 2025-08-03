package org.jcodec.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jcodec.common.io.AutoPool;
import org.jcodec.common.io.AutoResource;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class AutoFileChannelWrapper implements SeekableByteChannel, AutoResource {
    private static final long THRESHOLD = 5000;
    private long accessTime;
    private FileChannel ch;
    private long curTime = System.currentTimeMillis();
    private File file;
    private long savedPos;

    public AutoFileChannelWrapper(File file) throws IOException {
        this.file = file;
        AutoPool.getInstance().add(this);
        ensureOpen();
    }

    private void ensureOpen() throws IOException {
        this.accessTime = this.curTime;
        FileChannel fileChannel = this.ch;
        if (fileChannel == null || !fileChannel.isOpen()) {
            FileChannel channel = new FileInputStream(this.file).getChannel();
            this.ch = channel;
            channel.position(this.savedPos);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        FileChannel fileChannel = this.ch;
        if (fileChannel == null || !fileChannel.isOpen()) {
            return;
        }
        this.savedPos = this.ch.position();
        this.ch.close();
        this.ch = null;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        FileChannel fileChannel = this.ch;
        return fileChannel != null && fileChannel.isOpen();
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public long position() throws IOException {
        ensureOpen();
        return this.ch.position();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int i = this.ch.read(byteBuffer);
        this.savedPos = this.ch.position();
        return i;
    }

    @Override // org.jcodec.common.io.AutoResource
    public void setCurTime(long j) {
        this.curTime = j;
        FileChannel fileChannel = this.ch;
        if (fileChannel == null || !fileChannel.isOpen() || j - this.accessTime <= THRESHOLD) {
            return;
        }
        try {
            close();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public SeekableByteChannel setPosition(long j) throws IOException {
        ensureOpen();
        this.ch.position(j);
        this.savedPos = j;
        return this;
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public long size() throws IOException {
        ensureOpen();
        return this.ch.size();
    }

    @Override // org.jcodec.common.io.SeekableByteChannel
    public SeekableByteChannel truncate(long j) throws IOException {
        ensureOpen();
        this.ch.truncate(j);
        this.savedPos = this.ch.position();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        int iWrite = this.ch.write(byteBuffer);
        this.savedPos = this.ch.position();
        return iWrite;
    }
}
