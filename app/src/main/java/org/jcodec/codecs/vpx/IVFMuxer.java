package org.jcodec.codecs.vpx;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class IVFMuxer implements Muxer, MuxerTrack {
    private SeekableByteChannel ch;
    private Size dim;
    private int frameRate;
    private boolean headerWritten;
    private int nFrames;

    public IVFMuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.ch = seekableByteChannel;
    }

    private void writeHeader() throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(32);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.put((byte) 68);
        byteBufferAllocate.put((byte) 75);
        byteBufferAllocate.put((byte) 73);
        byteBufferAllocate.put((byte) 70);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 32);
        byteBufferAllocate.putInt(808996950);
        byteBufferAllocate.putShort((short) this.dim.getWidth());
        byteBufferAllocate.putShort((short) this.dim.getHeight());
        byteBufferAllocate.putInt(this.frameRate);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.clear();
        this.ch.write(byteBufferAllocate);
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        throw new RuntimeException("Video-only container");
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        if (!this.headerWritten) {
            this.frameRate = packet.getTimescale();
            writeHeader();
            this.headerWritten = true;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer data = packet.getData();
        byteBufferAllocate.putInt(data.remaining());
        byteBufferAllocate.putLong(this.nFrames);
        byteBufferAllocate.clear();
        this.ch.write(byteBufferAllocate);
        this.ch.write(data);
        this.nFrames++;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        if (this.dim != null) {
            throw new RuntimeException("IVF can not have multiple video tracks.");
        }
        this.dim = videoCodecMeta.getSize();
        return this;
    }

    public void close() throws IOException {
        this.ch.setPosition(24L);
        NIOUtils.writeIntLE(this.ch, this.nFrames);
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
    }
}
