package org.jcodec.api.specific;

import org.jcodec.api.MediaInfo;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public interface ContainerAdaptor {
    byte[][] allocatePicture();

    boolean canSeek(Packet packet);

    Picture decodeFrame(Packet packet, byte[][] bArr);

    MediaInfo getMediaInfo();
}
