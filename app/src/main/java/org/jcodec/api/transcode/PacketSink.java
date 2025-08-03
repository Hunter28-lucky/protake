package org.jcodec.api.transcode;

import java.io.IOException;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public interface PacketSink {
    void outputAudioPacket(Packet packet, AudioCodecMeta audioCodecMeta) throws IOException;

    void outputVideoPacket(Packet packet, VideoCodecMeta videoCodecMeta) throws IOException;
}
