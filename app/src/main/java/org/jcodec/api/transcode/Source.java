package org.jcodec.api.transcode;

import java.io.IOException;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.VideoCodecMeta;

/* loaded from: classes2.dex */
public interface Source {
    void finish();

    AudioCodecMeta getAudioCodecMeta();

    AudioFrameWithPacket getNextAudioFrame() throws IOException;

    VideoFrameWithPacket getNextVideoFrame() throws IOException;

    VideoCodecMeta getVideoCodecMeta();

    boolean haveAudio();

    void init(PixelStore pixelStore) throws IOException;

    boolean isAudio();

    boolean isVideo();

    void seekFrames(int i) throws IOException;

    void setOption(Options options, Object obj);
}
