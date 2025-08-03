package org.jcodec.codecs.wav;

import java.io.IOException;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class WavMuxer implements Muxer, MuxerTrack {
    private AudioFormat format;
    public WavHeader header;
    public SeekableByteChannel out;
    public int written;

    public WavMuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.out = seekableByteChannel;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        this.header = WavHeader.createWavHeader(audioCodecMeta.getFormat(), 0);
        this.format = audioCodecMeta.getFormat();
        try {
            this.header.write(this.out);
            return this;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        this.written += this.out.write(packet.getData());
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        return null;
    }

    public void close() throws IOException {
        this.out.setPosition(0L);
        AudioFormat audioFormat = this.format;
        WavHeader.createWavHeader(audioFormat, audioFormat.bytesToFrames(this.written)).write(this.out);
        NIOUtils.closeQuietly(this.out);
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
    }
}
