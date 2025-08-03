package org.jcodec.common;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface SeekableDemuxerTrack extends DemuxerTrack {
    long getCurFrame();

    boolean gotoFrame(long j) throws IOException;

    boolean gotoSyncFrame(long j) throws IOException;

    void seek(double d) throws IOException;
}
