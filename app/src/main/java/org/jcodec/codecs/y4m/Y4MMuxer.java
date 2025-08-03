package org.jcodec.codecs.y4m;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class Y4MMuxer implements Muxer, MuxerTrack {
    public static final byte[] frameTag = "FRAME\n".getBytes();
    private WritableByteChannel ch;
    private boolean headerWritten;
    private VideoCodecMeta meta;

    public Y4MMuxer(WritableByteChannel writableByteChannel) {
        this.ch = writableByteChannel;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        throw new RuntimeException("Y4M doesn't support audio");
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        if (!this.headerWritten) {
            writeHeader();
            this.headerWritten = true;
        }
        this.ch.write(ByteBuffer.wrap(frameTag));
        this.ch.write(packet.data.duplicate());
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        this.meta = videoCodecMeta;
        return this;
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
    }

    public void writeHeader() throws IOException {
        Size size = this.meta.getSize();
        this.ch.write(ByteBuffer.wrap(String.format("YUV4MPEG2 W%d H%d F25:1 Ip A0:0 C420jpeg XYSCSS=420JPEG\n", Integer.valueOf(size.getWidth()), Integer.valueOf(size.getHeight())).getBytes()));
    }
}
