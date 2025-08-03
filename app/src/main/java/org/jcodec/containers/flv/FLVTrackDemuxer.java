package org.jcodec.containers.flv;

import com.xiaomi.clientreport.data.Config;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import org.jcodec.common.Codec;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.TrackType;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.flv.FLVTag;

/* loaded from: classes2.dex */
public class FLVTrackDemuxer {
    private static final int MAX_CRAWL_DISTANCE_SEC = 10;
    private SeekableByteChannel _in;
    private FLVDemuxerTrack audio;
    private FLVReader demuxer;
    private LinkedList<FLVTag> packets = new LinkedList<>();
    private FLVDemuxerTrack video;

    public static class FLVDemuxerTrack implements SeekableDemuxerTrack {
        private Codec codec;
        private byte[] codecPrivate;
        private int curFrame;
        private FLVTrackDemuxer demuxer;
        private LongArrayList framePositions = LongArrayList.createLongArrayList();
        private FLVTag.Type type;

        public FLVDemuxerTrack(FLVTrackDemuxer fLVTrackDemuxer, FLVTag.Type type) throws IOException {
            this.demuxer = fLVTrackDemuxer;
            this.type = type;
            this.codec = fLVTrackDemuxer.nextFrameI(type, false).getTagHeader().getCodec();
        }

        private Packet toPacket(FLVTag fLVTag) {
            return null;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public long getCurFrame() {
            return this.curFrame;
        }

        @Override // org.jcodec.common.DemuxerTrack
        public DemuxerTrackMeta getMeta() {
            return new DemuxerTrackMeta(this.type == FLVTag.Type.VIDEO ? TrackType.VIDEO : TrackType.AUDIO, this.codec, 0.0d, null, 0, ByteBuffer.wrap(this.codecPrivate), null, null);
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoFrame(long j) throws IOException {
            if (j >= this.framePositions.size()) {
                return false;
            }
            this.demuxer.resetToPosition(this.framePositions.get((int) j));
            return true;
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public boolean gotoSyncFrame(long j) {
            throw new RuntimeException();
        }

        @Override // org.jcodec.common.DemuxerTrack
        public Packet nextFrame() throws IOException {
            FLVTag fLVTagNextFrameI = this.demuxer.nextFrameI(this.type, true);
            this.framePositions.add(fLVTagNextFrameI.getPosition());
            return toPacket(fLVTagNextFrameI);
        }

        public Packet pickFrame() throws IOException {
            return toPacket(this.demuxer.nextFrameI(this.type, false));
        }

        public Packet prevFrame() throws IOException {
            return toPacket(this.demuxer.prevFrameI(this.type, true));
        }

        @Override // org.jcodec.common.SeekableDemuxerTrack
        public void seek(double d) throws IOException {
            this.demuxer.seekI(d);
        }
    }

    public FLVTrackDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this._in = seekableByteChannel;
        seekableByteChannel.setPosition(0L);
        this.demuxer = new FLVReader(seekableByteChannel);
        this.video = new FLVDemuxerTrack(this, FLVTag.Type.VIDEO);
        this.audio = new FLVDemuxerTrack(this, FLVTag.Type.AUDIO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FLVTag nextFrameI(FLVTag.Type type, boolean z) throws IOException {
        FLVTag nextPacket;
        Iterator<FLVTag> it = this.packets.iterator();
        while (it.hasNext()) {
            FLVTag next = it.next();
            if (next.getType() == type) {
                if (z) {
                    it.remove();
                }
                return next;
            }
        }
        while (true) {
            nextPacket = this.demuxer.readNextPacket();
            if (nextPacket == null || nextPacket.getType() == type) {
                break;
            }
            this.packets.add(nextPacket);
        }
        if (!z) {
            this.packets.add(nextPacket);
        }
        return nextPacket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FLVTag prevFrameI(FLVTag.Type type, boolean z) throws IOException {
        FLVTag prevPacket;
        ListIterator<FLVTag> listIterator = this.packets.listIterator();
        while (listIterator.hasPrevious()) {
            FLVTag fLVTagPrevious = listIterator.previous();
            if (fLVTagPrevious.getType() == type) {
                if (z) {
                    listIterator.remove();
                }
                return fLVTagPrevious;
            }
        }
        while (true) {
            prevPacket = this.demuxer.readPrevPacket();
            if (prevPacket == null || prevPacket.getType() == type) {
                break;
            }
            this.packets.add(0, prevPacket);
        }
        if (!z) {
            this.packets.add(0, prevPacket);
        }
        return prevPacket;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetToPosition(long j) throws IOException {
        this._in.setPosition(j);
        this.demuxer.reset();
        this.packets.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekI(double d) throws IOException {
        FLVTag nextPacket;
        FLVTag nextPacket2;
        this.packets.clear();
        do {
            nextPacket = this.demuxer.readNextPacket();
            if (nextPacket == null) {
                break;
            }
        } while (nextPacket.getPtsD() == 0.0d);
        if (nextPacket == null) {
            return;
        }
        this._in.setPosition(nextPacket.getPosition() + Config.DEFAULT_MAX_FILE_LENGTH);
        this.demuxer.reposition();
        double position = (int) ((r4.getPosition() - nextPacket.getPosition()) / (this.demuxer.readNextPacket().getPtsD() - nextPacket.getPtsD()));
        this._in.setPosition(nextPacket.getPosition() + ((long) ((d - nextPacket.getPtsD()) * position)));
        this.demuxer.reposition();
        for (int i = 0; i < 5; i++) {
            FLVTag nextPacket3 = this.demuxer.readNextPacket();
            double ptsD = d - nextPacket3.getPtsD();
            if (ptsD > 0.0d && ptsD < 10.0d) {
                System.out.println("Crawling forward: " + ptsD);
                do {
                    nextPacket2 = this.demuxer.readNextPacket();
                    if (nextPacket2 == null) {
                        break;
                    }
                } while (nextPacket2.getPtsD() < d);
                if (nextPacket2 != null) {
                    this.packets.add(nextPacket3);
                    return;
                }
                return;
            }
            if (ptsD < 0.0d && ptsD > -10.0d) {
                System.out.println("Overshoot by: " + (-ptsD));
                this._in.setPosition(nextPacket3.getPosition() + ((long) ((ptsD - 1.0d) * position)));
                this.demuxer.reposition();
            }
        }
    }

    public DemuxerTrack getAudioTrack() {
        return this.video;
    }

    public DemuxerTrack[] getTracks() {
        return new DemuxerTrack[]{this.video, this.audio};
    }

    public DemuxerTrack getVideoTrack() {
        return this.video;
    }
}
