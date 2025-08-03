package org.jcodec.codecs.wav;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jcodec.audio.AudioSink;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.AudioUtil;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class WavOutput implements Closeable {
    public AudioFormat format;
    public WavHeader header;
    public SeekableByteChannel out;
    public int written;

    public static class Sink implements AudioSink, Closeable {
        private WavOutput out;

        public Sink(WavOutput wavOutput) {
            this.out = wavOutput;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.out.close();
        }

        public void write(int[] iArr, int i) throws IOException {
            int iMin = Math.min(iArr.length, i);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.out.format.samplesToBytes(iMin));
            AudioUtil.fromInt(iArr, iMin, this.out.format, byteBufferAllocate);
            byteBufferAllocate.flip();
            this.out.write(byteBufferAllocate);
        }

        @Override // org.jcodec.audio.AudioSink
        public void writeFloat(FloatBuffer floatBuffer) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.out.format.samplesToBytes(floatBuffer.remaining()));
            AudioUtil.fromFloat(floatBuffer, this.out.format, byteBufferAllocate);
            byteBufferAllocate.flip();
            this.out.write(byteBufferAllocate);
        }
    }

    public static class WavOutFile extends WavOutput {
        public WavOutFile(File file, AudioFormat audioFormat) throws IOException {
            super(NIOUtils.writableChannel(file), audioFormat);
        }

        @Override // org.jcodec.codecs.wav.WavOutput, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            NIOUtils.closeQuietly(this.out);
        }
    }

    public WavOutput(SeekableByteChannel seekableByteChannel, AudioFormat audioFormat) throws IOException {
        this.out = seekableByteChannel;
        this.format = audioFormat;
        WavHeader wavHeaderCreateWavHeader = WavHeader.createWavHeader(audioFormat, 0);
        this.header = wavHeaderCreateWavHeader;
        wavHeaderCreateWavHeader.write(seekableByteChannel);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.setPosition(0L);
        AudioFormat audioFormat = this.format;
        WavHeader.createWavHeader(audioFormat, audioFormat.bytesToFrames(this.written)).write(this.out);
        NIOUtils.closeQuietly(this.out);
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        this.written += this.out.write(byteBuffer);
    }
}
