package org.jcodec.common;

import java.io.Closeable;
import java.util.List;

/* loaded from: classes2.dex */
public interface Demuxer extends Closeable {
    List<? extends DemuxerTrack> getAudioTracks();

    List<? extends DemuxerTrack> getTracks();

    List<? extends DemuxerTrack> getVideoTracks();
}
