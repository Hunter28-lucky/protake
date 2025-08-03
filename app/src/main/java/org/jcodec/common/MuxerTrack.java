package org.jcodec.common;

import java.io.IOException;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public interface MuxerTrack {
    void addFrame(Packet packet) throws IOException;
}
