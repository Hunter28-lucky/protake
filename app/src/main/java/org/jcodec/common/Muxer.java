package org.jcodec.common;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface Muxer {
    MuxerTrack addAudioTrack(Codec codec, AudioCodecMeta audioCodecMeta);

    MuxerTrack addVideoTrack(Codec codec, VideoCodecMeta videoCodecMeta);

    void finish() throws IOException;
}
