package org.jcodec.containers.mps;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public interface MPEGDemuxer extends Demuxer {

    public interface MPEGDemuxerTrack extends DemuxerTrack {
        @Override // org.jcodec.common.DemuxerTrack
        DemuxerTrackMeta getMeta();

        List<PESPacket> getPending();

        int getSid();

        void ignore();

        Packet nextFrameWithBuffer(ByteBuffer byteBuffer) throws IOException;
    }

    @Override // org.jcodec.common.Demuxer
    List<? extends MPEGDemuxerTrack> getAudioTracks();

    @Override // org.jcodec.common.Demuxer
    List<? extends MPEGDemuxerTrack> getTracks();

    @Override // org.jcodec.common.Demuxer
    List<? extends MPEGDemuxerTrack> getVideoTracks();
}
