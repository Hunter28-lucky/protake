package org.jcodec.api.transcode;

import java.io.IOException;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public interface PacketSource {
    Packet inputAudioPacket() throws IOException;

    Packet inputVideoPacket() throws IOException;
}
