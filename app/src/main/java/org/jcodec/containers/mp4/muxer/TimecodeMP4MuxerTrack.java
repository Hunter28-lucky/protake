package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.Codec;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.movtool.Util;

/* loaded from: classes2.dex */
public class TimecodeMP4MuxerTrack extends CodecMP4MuxerTrack {
    private TapeTimecode firstTimecode;
    private int fpsEstimate;
    private List<Packet> gop;
    private List<Edit> lower;
    private TapeTimecode prevTimecode;
    private long sampleDuration;
    private long samplePts;
    private int tcFrames;

    public TimecodeMP4MuxerTrack(int i) {
        super(i, MP4TrackType.TIMECODE, Codec.TIMECODE);
        this.lower = new ArrayList();
        this.gop = new ArrayList();
    }

    private void addTimecodeInt(Packet packet) throws IOException {
        TapeTimecode tapeTimecode = packet.getTapeTimecode();
        boolean zIsGap = isGap(this.prevTimecode, tapeTimecode);
        this.prevTimecode = tapeTimecode;
        if (zIsGap) {
            outTimecodeSample();
            this.firstTimecode = tapeTimecode;
            this.fpsEstimate = tapeTimecode.isDropFrame() ? 30 : -1;
            this.samplePts += this.sampleDuration;
            this.sampleDuration = 0L;
            this.tcFrames = 0;
        }
        this.sampleDuration += packet.getDuration();
        this.tcFrames++;
    }

    private boolean isGap(TapeTimecode tapeTimecode, TapeTimecode tapeTimecode2) {
        if (tapeTimecode == null && tapeTimecode2 != null) {
            return true;
        }
        if (tapeTimecode == null) {
            return false;
        }
        if (tapeTimecode2 != null && tapeTimecode.isDropFrame() == tapeTimecode2.isDropFrame()) {
            return isTimeGap(tapeTimecode, tapeTimecode2);
        }
        return true;
    }

    private boolean isTimeGap(TapeTimecode tapeTimecode, TapeTimecode tapeTimecode2) {
        int sec = toSec(tapeTimecode2);
        int sec2 = sec - toSec(tapeTimecode);
        if (sec2 == 0) {
            int frame = tapeTimecode2.getFrame() - tapeTimecode.getFrame();
            int i = this.fpsEstimate;
            if (i != -1) {
                frame = (frame + i) % i;
            }
            if (frame == 1) {
                return false;
            }
        } else if (sec2 == 1) {
            if (this.fpsEstimate != -1) {
                if (tapeTimecode2.getFrame() == ((tapeTimecode2.isDropFrame() && sec % 60 == 0 && sec % 600 != 0) ? (byte) 2 : (byte) 0) && tapeTimecode.getFrame() == this.fpsEstimate - 1) {
                    return false;
                }
            } else if (tapeTimecode2.getFrame() == 0) {
                this.fpsEstimate = tapeTimecode.getFrame() + 1;
                return false;
            }
        }
        return true;
    }

    private void outTimecodeSample() throws IOException {
        long j = this.sampleDuration;
        if (j > 0) {
            if (this.firstTimecode == null) {
                this.lower.add(new Edit(j, -1L, 1.0f));
                return;
            }
            if (this.fpsEstimate == -1) {
                this.fpsEstimate = this.prevTimecode.getFrame() + 1;
            }
            this.sampleEntries.add(TimecodeSampleEntry.createTimecodeSampleEntry(this.firstTimecode.isDropFrame() ? 1 : 0, this._timescale, (int) (this.sampleDuration / this.tcFrames), this.fpsEstimate));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.putInt(toCounter(this.firstTimecode, this.fpsEstimate));
            byteBufferAllocate.flip();
            long j2 = this.samplePts;
            addFrame(MP4Packet.createMP4Packet(byteBufferAllocate, j2, this._timescale, this.sampleDuration, 0L, Packet.FrameType.KEY, null, 0, j2, this.sampleEntries.size() - 1));
            this.lower.add(new Edit(this.sampleDuration, this.samplePts, 1.0f));
        }
    }

    private void processGop() throws IOException {
        if (this.gop.size() > 0) {
            Iterator<Packet> it = sortByDisplay(this.gop).iterator();
            while (it.hasNext()) {
                addTimecodeInt(it.next());
            }
            this.gop.clear();
        }
    }

    private List<Packet> sortByDisplay(List<Packet> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<Packet>() { // from class: org.jcodec.containers.mp4.muxer.TimecodeMP4MuxerTrack.1
            @Override // java.util.Comparator
            public int compare(Packet packet, Packet packet2) {
                if (packet == null && packet2 == null) {
                    return 0;
                }
                if (packet == null) {
                    return -1;
                }
                if (packet2 != null && packet.getDisplayOrder() <= packet2.getDisplayOrder()) {
                    return packet.getDisplayOrder() == packet2.getDisplayOrder() ? 0 : -1;
                }
                return 1;
            }
        });
        return arrayList;
    }

    private int toCounter(TapeTimecode tapeTimecode, int i) {
        int sec = (toSec(tapeTimecode) * i) + tapeTimecode.getFrame();
        return tapeTimecode.isDropFrame() ? (int) (sec - (((sec / 18000) * 18) + ((((sec % 18000) - 2) / 1800) * 2))) : sec;
    }

    private static int toSec(TapeTimecode tapeTimecode) {
        return (tapeTimecode.getHour() * 3600) + (tapeTimecode.getMinute() * 60) + tapeTimecode.getSecond();
    }

    public void addTimecode(Packet packet) throws IOException {
        if (this._timescale == -1) {
            this._timescale = packet.getTimescale();
        }
        int i = this._timescale;
        if (i != -1 && i != packet.getTimescale()) {
            throw new RuntimeException("MP4 timecode track doesn't support timescale switching.");
        }
        if (packet.isKeyFrame()) {
            processGop();
        }
        this.gop.add(Packet.createPacketWithData(packet, null));
    }

    @Override // org.jcodec.containers.mp4.muxer.CodecMP4MuxerTrack, org.jcodec.containers.mp4.muxer.MP4MuxerTrack, org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        processGop();
        outTimecodeSample();
        if (this.sampleEntries.size() == 0) {
            return null;
        }
        if (this.edits != null) {
            this.edits = Util.editsOnEdits(new Rational(1, 1), this.lower, this.edits);
        } else {
            this.edits = this.lower;
        }
        return super.finish(movieHeaderBox);
    }
}
