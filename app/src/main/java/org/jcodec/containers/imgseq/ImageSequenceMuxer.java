package org.jcodec.containers.imgseq;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.Muxer;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;
import org.jcodec.common.tools.MainUtils;

/* loaded from: classes2.dex */
public class ImageSequenceMuxer implements Muxer, MuxerTrack {
    private String fileNamePattern;
    private int frameNo;

    public ImageSequenceMuxer(String str) {
        this.fileNamePattern = str;
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta) {
        Logger.warn("Audio is not supported for image sequence muxer.");
        return null;
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        ByteBuffer data = packet.getData();
        String str = this.fileNamePattern;
        int i = this.frameNo;
        this.frameNo = i + 1;
        NIOUtils.writeTo(data, MainUtils.tildeExpand(String.format(str, Integer.valueOf(i))));
    }

    @Override // org.jcodec.common.Muxer
    public MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta) {
        return this;
    }

    @Override // org.jcodec.common.Muxer
    public void finish() throws IOException {
    }
}
