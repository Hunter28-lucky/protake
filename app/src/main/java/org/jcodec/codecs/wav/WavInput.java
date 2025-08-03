package org.jcodec.codecs.wav;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.audio.AudioSource;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class WavInput implements Closeable {
    public ReadableByteChannel _in;
    public AudioFormat format;
    public WavHeader header;
    public byte[] prevBuf;

    public static class Source implements AudioSource, Closeable {
        private AudioFormat format;
        private int pos;
        private WavInput src;

        public Source(WavInput wavInput) {
            this.src = wavInput;
            this.format = wavInput.getFormat();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.src.close();
        }

        @Override // org.jcodec.audio.AudioSource
        public AudioFormat getFormat() {
            return this.src.getFormat();
        }

        public int read(int[] iArr, int i) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.format.samplesToBytes(Math.min(i, iArr.length)));
            int i2 = this.src.read(byteBufferAllocate);
            byteBufferAllocate.flip();
            AudioUtil.toInt(this.format, byteBufferAllocate, iArr);
            return this.format.bytesToFrames(i2);
        }

        @Override // org.jcodec.audio.AudioSource
        public int readFloat(FloatBuffer floatBuffer) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.format.samplesToBytes(floatBuffer.remaining()));
            int i = this.src.read(byteBufferAllocate);
            if (i == -1) {
                return -1;
            }
            byteBufferAllocate.flip();
            AudioUtil.toFloat(this.format, byteBufferAllocate, floatBuffer);
            int iBytesToFrames = this.format.bytesToFrames(i);
            this.pos += iBytesToFrames;
            return iBytesToFrames;
        }
    }

    public static class WavFile extends WavInput {
        public WavFile(File file) throws IOException {
            super(NIOUtils.readableChannel(file));
        }

        @Override // org.jcodec.codecs.wav.WavInput, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this._in.close();
        }
    }

    public WavInput(ReadableByteChannel readableByteChannel) throws IOException {
        WavHeader channel = WavHeader.readChannel(readableByteChannel);
        this.header = channel;
        this.format = channel.getFormat();
        this._in = readableByteChannel;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this._in.close();
    }

    public AudioFormat getFormat() {
        return this.format;
    }

    public WavHeader getHeader() {
        return this.header;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        AudioFormat audioFormat = this.format;
        return NIOUtils.readL(this._in, byteBuffer, audioFormat.framesToBytes(audioFormat.bytesToFrames(byteBuffer.remaining())));
    }
}
