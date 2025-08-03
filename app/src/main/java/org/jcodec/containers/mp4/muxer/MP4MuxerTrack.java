package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.Ints;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.Preconditions;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.HandlerBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MediaBox;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class MP4MuxerTrack extends AbstractMP4MuxerTrack {
    private boolean allIframes;
    private LongArrayList chunkOffsets;
    private List<CompositionOffsetsBox.LongEntry> compositionOffsets;
    private long curDuration;
    private int curFrame;
    private IntArrayList iframes;
    private long lastCompositionOffset;
    private long lastCompositionSamples;
    private int lastEntry;
    private long ptsEstimate;
    private long sameDurCount;
    private List<TimeToSampleBox.TimeToSampleEntry> sampleDurations;
    private IntArrayList sampleSizes;
    private TimecodeMP4MuxerTrack timecodeTrack;
    private long trackTotalDuration;

    public MP4MuxerTrack(int i, MP4TrackType mP4TrackType) {
        super(i, mP4TrackType);
        this.sameDurCount = 0L;
        this.curDuration = -1L;
        this.lastCompositionOffset = 0L;
        this.lastCompositionSamples = 0L;
        this.ptsEstimate = 0L;
        this.lastEntry = -1;
        this.allIframes = true;
        this.sampleDurations = new ArrayList();
        this.chunkOffsets = LongArrayList.createLongArrayList();
        this.sampleSizes = IntArrayList.createIntArrayList();
        this.iframes = IntArrayList.createIntArrayList();
        this.compositionOffsets = new ArrayList();
        setTgtChunkDuration(new Rational(1, 1), Unit.FRAME);
    }

    public static long minLongOffset(List<CompositionOffsetsBox.LongEntry> list) {
        Iterator<CompositionOffsetsBox.LongEntry> it = list.iterator();
        long jMin = Long.MAX_VALUE;
        while (it.hasNext()) {
            jMin = Math.min(jMin, it.next().getOffset());
        }
        return jMin;
    }

    public static int minOffset(List<CompositionOffsetsBox.Entry> list) {
        Iterator<CompositionOffsetsBox.Entry> it = list.iterator();
        int iMin = Integer.MAX_VALUE;
        while (it.hasNext()) {
            iMin = Math.min(iMin, it.next().getOffset());
        }
        return iMin;
    }

    private void outChunkIfNeeded(int i) throws IOException {
        Unit unit = this.tgtChunkDurationUnit;
        Unit unit2 = Unit.FRAME;
        Preconditions.checkState(unit == unit2 || unit == Unit.SEC);
        if (this.tgtChunkDurationUnit == unit2 && this.curChunk.size() * this.tgtChunkDuration.getDen() == this.tgtChunkDuration.getNum()) {
            outChunk(i);
            return;
        }
        if (this.tgtChunkDurationUnit == Unit.SEC) {
            long j = this.chunkDuration;
            if (j <= 0 || j * this.tgtChunkDuration.getDen() < this.tgtChunkDuration.getNum() * this._timescale) {
                return;
            }
            outChunk(i);
        }
    }

    private void processTimecode(Packet packet) throws IOException {
        TimecodeMP4MuxerTrack timecodeMP4MuxerTrack = this.timecodeTrack;
        if (timecodeMP4MuxerTrack != null) {
            timecodeMP4MuxerTrack.addTimecode(packet);
        }
    }

    private void putCompositionOffsets(NodeBox nodeBox) {
        if (this.compositionOffsets.size() > 0) {
            this.compositionOffsets.add(new CompositionOffsetsBox.LongEntry(this.lastCompositionSamples, this.lastCompositionOffset));
            long jMinLongOffset = minLongOffset(this.compositionOffsets);
            if (jMinLongOffset > 0) {
                Iterator<CompositionOffsetsBox.LongEntry> it = this.compositionOffsets.iterator();
                while (it.hasNext()) {
                    it.next().offset -= jMinLongOffset;
                }
            }
            CompositionOffsetsBox.LongEntry longEntry = this.compositionOffsets.get(0);
            if (longEntry.getOffset() > 0) {
                List<Edit> list = this.edits;
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.edits = arrayList;
                    arrayList.add(new Edit(this.trackTotalDuration, longEntry.getOffset(), 1.0f));
                } else {
                    for (Edit edit : list) {
                        edit.setMediaTime(edit.getMediaTime() + longEntry.getOffset());
                    }
                }
            }
            CompositionOffsetsBox.Entry[] entryArr = new CompositionOffsetsBox.Entry[this.compositionOffsets.size()];
            for (int i = 0; i < this.compositionOffsets.size(); i++) {
                CompositionOffsetsBox.LongEntry longEntry2 = this.compositionOffsets.get(i);
                entryArr[i] = new CompositionOffsetsBox.Entry(Ints.checkedCast(longEntry2.count), Ints.checkedCast(longEntry2.offset));
            }
            nodeBox.add(CompositionOffsetsBox.createCompositionOffsetsBox(entryArr));
        }
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        addFrameInternal(packet, 1);
        processTimecode(packet);
    }

    public void addFrameInternal(Packet packet, int i) throws IOException {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        if (this._timescale == -1) {
            this._timescale = packet.getTimescale();
        }
        if (this._timescale != packet.getTimescale()) {
            packet.setPts((packet.getPts() * this._timescale) / packet.getTimescale());
            packet.setDuration((packet.getPts() * this._timescale) / packet.getDuration());
        }
        if (this.type == MP4TrackType.VIDEO) {
            long pts = packet.getPts() - this.ptsEstimate;
            long j = this.lastCompositionOffset;
            if (pts != j) {
                long j2 = this.lastCompositionSamples;
                if (j2 > 0) {
                    this.compositionOffsets.add(new CompositionOffsetsBox.LongEntry(j2, j));
                }
                this.lastCompositionOffset = pts;
                this.lastCompositionSamples = 0L;
            }
            this.lastCompositionSamples++;
            this.ptsEstimate += packet.getDuration();
        }
        int i2 = this.lastEntry;
        if (i2 != -1 && i2 != i) {
            outChunk(i2);
            this.samplesInLastChunk = -1;
        }
        this.curChunk.add(packet.getData());
        if (packet.isKeyFrame()) {
            this.iframes.add(this.curFrame + 1);
        } else {
            this.allIframes = false;
        }
        this.curFrame++;
        this.chunkDuration += packet.getDuration();
        if (this.curDuration != -1) {
            long duration = packet.getDuration();
            long j3 = this.curDuration;
            if (duration != j3) {
                this.sampleDurations.add(new TimeToSampleBox.TimeToSampleEntry((int) this.sameDurCount, (int) j3));
                this.sameDurCount = 0L;
            }
        }
        this.curDuration = packet.getDuration();
        this.sameDurCount++;
        this.trackTotalDuration += packet.getDuration();
        outChunkIfNeeded(i);
        this.lastEntry = i;
    }

    @Override // org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        Preconditions.checkState(!this.finished, "The muxer track has finished muxing");
        outChunk(this.lastEntry);
        long j = this.sameDurCount;
        if (j > 0) {
            this.sampleDurations.add(new TimeToSampleBox.TimeToSampleEntry((int) j, (int) this.curDuration));
        }
        this.finished = true;
        TrakBox trakBoxCreateTrakBox = TrakBox.createTrakBox();
        Size displayDimensions = getDisplayDimensions();
        TrackHeaderBox trackHeaderBoxCreateTrackHeaderBox = TrackHeaderBox.createTrackHeaderBox(this.trackId, (movieHeaderBox.getTimescale() * this.trackTotalDuration) / this._timescale, displayDimensions.getWidth(), displayDimensions.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0L, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
        trackHeaderBoxCreateTrackHeaderBox.setFlags(15);
        trakBoxCreateTrakBox.add(trackHeaderBoxCreateTrackHeaderBox);
        tapt(trakBoxCreateTrakBox);
        MediaBox mediaBoxCreateMediaBox = MediaBox.createMediaBox();
        trakBoxCreateTrakBox.add(mediaBoxCreateMediaBox);
        mediaBoxCreateMediaBox.add(MediaHeaderBox.createMediaHeaderBox(this._timescale, this.trackTotalDuration, 0, new Date().getTime(), new Date().getTime(), 0));
        mediaBoxCreateMediaBox.add(HandlerBox.createHandlerBox("mhlr", this.type.getHandler(), "appl", 0, 0));
        MediaInfoBox mediaInfoBoxCreateMediaInfoBox = MediaInfoBox.createMediaInfoBox();
        mediaBoxCreateMediaBox.add(mediaInfoBoxCreateMediaInfoBox);
        mediaHeader(mediaInfoBoxCreateMediaInfoBox, this.type);
        mediaInfoBoxCreateMediaInfoBox.add(HandlerBox.createHandlerBox("dhlr", "url ", "appl", 0, 0));
        addDref(mediaInfoBoxCreateMediaInfoBox);
        NodeBox nodeBox = new NodeBox(new Header("stbl"));
        mediaInfoBoxCreateMediaInfoBox.add(nodeBox);
        putCompositionOffsets(nodeBox);
        putEdits(trakBoxCreateTrakBox);
        putName(trakBoxCreateTrakBox);
        nodeBox.add(SampleDescriptionBox.createSampleDescriptionBox((SampleEntry[]) this.sampleEntries.toArray(new SampleEntry[0])));
        nodeBox.add(SampleToChunkBox.createSampleToChunkBox((SampleToChunkBox.SampleToChunkEntry[]) this.samplesInChunks.toArray(new SampleToChunkBox.SampleToChunkEntry[0])));
        nodeBox.add(SampleSizesBox.createSampleSizesBox2(this.sampleSizes.toArray()));
        nodeBox.add(TimeToSampleBox.createTimeToSampleBox((TimeToSampleBox.TimeToSampleEntry[]) this.sampleDurations.toArray(new TimeToSampleBox.TimeToSampleEntry[0])));
        nodeBox.add(ChunkOffsets64Box.createChunkOffsets64Box(this.chunkOffsets.toArray()));
        if (!this.allIframes && this.iframes.size() > 0) {
            nodeBox.add(SyncSamplesBox.createSyncSamplesBox(this.iframes.toArray()));
        }
        return trakBoxCreateTrakBox;
    }

    public TimecodeMP4MuxerTrack getTimecodeTrack() {
        return this.timecodeTrack;
    }

    @Override // org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public long getTrackTotalDuration() {
        return this.trackTotalDuration;
    }

    public void outChunk(int i) throws IOException {
        if (this.curChunk.size() == 0) {
            return;
        }
        this.chunkOffsets.add(this.out.position());
        for (ByteBuffer byteBuffer : this.curChunk) {
            this.sampleSizes.add(byteBuffer.remaining());
            this.out.write(byteBuffer);
        }
        int i2 = this.samplesInLastChunk;
        if (i2 == -1 || i2 != this.curChunk.size()) {
            this.samplesInChunks.add(new SampleToChunkBox.SampleToChunkEntry(this.chunkNo + 1, this.curChunk.size(), i));
        }
        this.samplesInLastChunk = this.curChunk.size();
        this.chunkNo++;
        this.chunkDuration = 0L;
        this.curChunk.clear();
    }

    public void setTimecode(TimecodeMP4MuxerTrack timecodeMP4MuxerTrack) {
        this.timecodeTrack = timecodeMP4MuxerTrack;
    }
}
