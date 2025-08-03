package org.jcodec.containers.mkv.muxer;

import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mkv.boxes.MkvBlock;

/* loaded from: classes2.dex */
public class MKVMuxerTrack implements MuxerTrack {
    public static final int DEFAULT_TIMESCALE = 1000000000;
    public static final int MULTIPLIER = 1000;
    public static final int NANOSECONDS_IN_A_MILISECOND = 1000000;
    public String codecId;
    private int frameDuration;
    public int trackNo;
    public VideoCodecMeta videoMeta;
    public List<MkvBlock> trackBlocks = new ArrayList();
    public MKVMuxerTrackType type = MKVMuxerTrackType.VIDEO;

    public enum MKVMuxerTrackType {
        VIDEO
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) {
        MkvBlock mkvBlockKeyFrame = MkvBlock.keyFrame(this.trackNo, 0, packet.getData());
        mkvBlockKeyFrame.absoluteTimecode = packet.getPts() - 1;
        this.trackBlocks.add(mkvBlockKeyFrame);
    }

    public int getTimescale() {
        return 1000000;
    }

    public long getTrackNo() {
        return this.trackNo;
    }
}
