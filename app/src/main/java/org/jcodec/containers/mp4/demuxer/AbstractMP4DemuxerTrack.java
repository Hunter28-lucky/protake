package org.jcodec.containers.mp4.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.EditListBox;
import org.jcodec.containers.mp4.boxes.NameBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public abstract class AbstractMP4DemuxerTrack implements SeekableDemuxerTrack {
    public TrakBox box;
    public long[] chunkOffsets;
    public long curFrame;
    public long duration;
    private int no;
    public long pts;
    public SampleEntry[] sampleEntries;
    public SampleToChunkBox.SampleToChunkEntry[] sampleToChunks;
    public int stcoInd;
    public int stscInd;
    public int sttsInd;
    public int sttsSubInd;
    public TimeToSampleBox.TimeToSampleEntry[] timeToSamples;
    public int timescale;
    private MP4TrackType type;

    public AbstractMP4DemuxerTrack(TrakBox trakBox) {
        this.no = trakBox.getTrackHeader().getNo();
        this.type = TrakBox.getTrackType(trakBox);
        this.sampleEntries = (SampleEntry[]) NodeBox.findAllPath(trakBox, SampleEntry.class, new String[]{"mdia", "minf", "stbl", "stsd", null});
        NodeBox stbl = trakBox.getMdia().getMinf().getStbl();
        TimeToSampleBox timeToSampleBox = (TimeToSampleBox) NodeBox.findFirst(stbl, TimeToSampleBox.class, "stts");
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) NodeBox.findFirst(stbl, SampleToChunkBox.class, "stsc");
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) NodeBox.findFirst(stbl, ChunkOffsetsBox.class, "stco");
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) NodeBox.findFirst(stbl, ChunkOffsets64Box.class, "co64");
        this.timeToSamples = timeToSampleBox.getEntries();
        this.sampleToChunks = sampleToChunkBox.getSampleToChunk();
        this.chunkOffsets = chunkOffsetsBox != null ? chunkOffsetsBox.getChunkOffsets() : chunkOffsets64Box.getChunkOffsets();
        int i = 0;
        while (true) {
            TimeToSampleBox.TimeToSampleEntry[] timeToSampleEntryArr = this.timeToSamples;
            if (i >= timeToSampleEntryArr.length) {
                this.box = trakBox;
                this.timescale = trakBox.getTimescale();
                return;
            } else {
                TimeToSampleBox.TimeToSampleEntry timeToSampleEntry = timeToSampleEntryArr[i];
                this.duration += timeToSampleEntry.getSampleCount() * timeToSampleEntry.getSampleDuration();
                i++;
            }
        }
    }

    private void seekFrame(long j) {
        this.sttsSubInd = 0;
        this.sttsInd = 0;
        this.pts = 0;
        shiftPts(j);
    }

    public boolean canSeek(long j) {
        return j >= 0 && j < this.duration;
    }

    public ByteBuffer convertPacket(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public TrakBox getBox() {
        return this.box;
    }

    @Override // org.jcodec.common.SeekableDemuxerTrack
    public long getCurFrame() {
        return this.curFrame;
    }

    public RationalLarge getDuration() {
        return new RationalLarge(this.box.getMediaDuration(), this.box.getTimescale());
    }

    public List<Edit> getEdits() {
        EditListBox editListBox = (EditListBox) NodeBox.findFirstPath(this.box, EditListBox.class, Box.path("edts.elst"));
        if (editListBox != null) {
            return editListBox.getEdits();
        }
        return null;
    }

    public String getFourcc() {
        SampleEntry[] sampleEntries = getSampleEntries();
        SampleEntry sampleEntry = (sampleEntries == null || sampleEntries.length == 0) ? null : sampleEntries[0];
        if (sampleEntry == null) {
            return null;
        }
        return sampleEntry.getHeader().getFourcc();
    }

    public abstract long getFrameCount();

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return MP4DemuxerTrackMeta.fromTrack(this);
    }

    public String getName() {
        NameBox nameBox = (NameBox) NodeBox.findFirstPath(this.box, NameBox.class, Box.path("udta.name"));
        if (nameBox != null) {
            return nameBox.getName();
        }
        return null;
    }

    public abstract MP4Packet getNextFrame(ByteBuffer byteBuffer) throws IOException;

    public int getNo() {
        return this.no;
    }

    public SampleEntry[] getSampleEntries() {
        return this.sampleEntries;
    }

    public long getTimescale() {
        return this.timescale;
    }

    public MP4TrackType getType() {
        return this.type;
    }

    @Override // org.jcodec.common.SeekableDemuxerTrack
    public synchronized boolean gotoFrame(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("negative frame number");
        }
        if (j >= getFrameCount()) {
            return false;
        }
        if (j == this.curFrame) {
            return true;
        }
        seekPointer(j);
        seekFrame(j);
        return true;
    }

    public void nextChunk() {
        int i = this.stcoInd;
        if (i >= this.chunkOffsets.length) {
            return;
        }
        this.stcoInd = i + 1;
        int i2 = this.stscInd;
        int i3 = i2 + 1;
        SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr = this.sampleToChunks;
        if (i3 >= sampleToChunkEntryArr.length || r0 + 1 != sampleToChunkEntryArr[i2 + 1].getFirst()) {
            return;
        }
        this.stscInd++;
    }

    public int pts2Sample(long j, int i) {
        long j2 = (j * this.timescale) / i;
        int i2 = 0;
        int sampleCount = 0;
        while (true) {
            TimeToSampleBox.TimeToSampleEntry[] timeToSampleEntryArr = this.timeToSamples;
            if (i2 >= timeToSampleEntryArr.length - 1) {
                break;
            }
            long sampleCount2 = timeToSampleEntryArr[i2].getSampleCount() * this.timeToSamples[i2].getSampleDuration();
            if (j2 < sampleCount2) {
                break;
            }
            j2 -= sampleCount2;
            sampleCount += this.timeToSamples[i2].getSampleCount();
            i2++;
        }
        return sampleCount + ((int) (j2 / this.timeToSamples[i2].getSampleDuration()));
    }

    public ByteBuffer readPacketData(SeekableByteChannel seekableByteChannel, ByteBuffer byteBuffer, long j, int i) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        synchronized (seekableByteChannel) {
            seekableByteChannel.setPosition(j);
            NIOUtils.readL(seekableByteChannel, byteBufferDuplicate, i);
        }
        byteBufferDuplicate.flip();
        return byteBufferDuplicate;
    }

    @Override // org.jcodec.common.SeekableDemuxerTrack
    public void seek(double d) {
        seekPts((long) (d * this.timescale));
    }

    public abstract void seekPointer(long j);

    public synchronized boolean seekPts(long j) {
        long sampleCount = 0;
        if (j < 0) {
            throw new IllegalArgumentException("Seeking to negative pts");
        }
        int sampleCount2 = 0;
        if (j >= this.duration) {
            return false;
        }
        this.sttsInd = 0;
        while (j > (this.timeToSamples[this.sttsInd].getSampleCount() * this.timeToSamples[this.sttsInd].getSampleDuration()) + sampleCount) {
            if (this.sttsInd >= this.timeToSamples.length - 1) {
                break;
            }
            sampleCount += r5[r2].getSampleCount() * this.timeToSamples[this.sttsInd].getSampleDuration();
            sampleCount2 += this.timeToSamples[this.sttsInd].getSampleCount();
            this.sttsInd++;
        }
        this.sttsSubInd = (int) ((j - sampleCount) / this.timeToSamples[this.sttsInd].getSampleDuration());
        this.pts = sampleCount + (this.timeToSamples[this.sttsInd].getSampleDuration() * this.sttsSubInd);
        seekPointer(sampleCount2 + r8);
        return true;
    }

    public void shiftPts(long j) {
        this.pts -= this.sttsSubInd * this.timeToSamples[this.sttsInd].getSampleDuration();
        this.sttsSubInd = (int) (this.sttsSubInd + j);
        while (true) {
            int i = this.sttsInd;
            TimeToSampleBox.TimeToSampleEntry[] timeToSampleEntryArr = this.timeToSamples;
            if (i >= timeToSampleEntryArr.length - 1 || this.sttsSubInd < timeToSampleEntryArr[i].getSampleCount()) {
                break;
            }
            this.pts += this.timeToSamples[this.sttsInd].getSegmentDuration();
            this.sttsSubInd -= this.timeToSamples[this.sttsInd].getSampleCount();
            this.sttsInd++;
        }
        this.pts += this.sttsSubInd * this.timeToSamples[this.sttsInd].getSampleDuration();
    }
}
