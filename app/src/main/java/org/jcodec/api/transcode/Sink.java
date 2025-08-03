package org.jcodec.api.transcode;

import java.io.IOException;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public interface Sink {
    void finish() throws IOException;

    ColorSpace getInputColor();

    void init() throws IOException;

    boolean isAudio();

    boolean isVideo();

    void outputAudioFrame(AudioFrameWithPacket audioFrameWithPacket) throws IOException;

    void outputVideoFrame(VideoFrameWithPacket videoFrameWithPacket) throws IOException;

    void setOption(Options options, Object obj);
}
