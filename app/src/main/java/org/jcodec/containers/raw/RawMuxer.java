package org.jcodec.containers.raw;

import java.io.IOException;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class RawMuxer implements Muxer, MuxerTrack {
    private SeekableByteChannel ch;
    private boolean hasAudio;
    private boolean hasVideo;

    public RawMuxer(SeekableByteChannel seekableByteChannel) {
        this.ch = seekableByteChannel;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        if (this.hasVideo) {
            throw new RuntimeException("Raw muxer supports either video or audio track but not both.");
        }
        this.hasAudio = true;
        return this;
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        this.ch.write(packet.getData().duplicate());
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        if (this.hasAudio) {
            throw new RuntimeException("Raw muxer supports either video or audio track but not both.");
        }
        this.hasVideo = true;
        return this;
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
    }
}
