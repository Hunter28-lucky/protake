package org.jcodec.containers.mp4.demuxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.Codec;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.TrackType;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class PCMMP4DemuxerTrack extends AbstractMP4DemuxerTrack {
    private int defaultSampleSize;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int posShift;
    public int totalFrames;

    public PCMMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) {
        super(trakBox);
        this.movie = movieBox;
        this.input = seekableByteChannel;
        this.defaultSampleSize = ((SampleSizesBox) NodeBox.findFirstPath(trakBox, SampleSizesBox.class, Box.path("mdia.minf.stbl.stsz"))).getDefaultSize();
        int i = 0;
        int i2 = 1;
        while (true) {
            SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr = this.sampleToChunks;
            if (i2 >= sampleToChunkEntryArr.length) {
                this.totalFrames += sampleToChunkEntryArr[sampleToChunkEntryArr.length - 1].getCount() * (this.chunkOffsets.length - i);
                return;
            }
            int i3 = i2 - 1;
            int first = (int) (sampleToChunkEntryArr[i2].getFirst() - this.sampleToChunks[i3].getFirst());
            this.totalFrames += this.sampleToChunks[i3].getCount() * first;
            i += first;
            i2++;
        }
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public long getFrameCount() {
        return this.totalFrames;
    }

    public int getFrameSize() {
        SampleEntry sampleEntry = this.sampleEntries[this.sampleToChunks[this.stscInd].getEntry() - 1];
        return ((sampleEntry instanceof AudioSampleEntry) && this.defaultSampleSize == 0) ? ((AudioSampleEntry) sampleEntry).calcFrameSize() : this.defaultSampleSize;
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack, org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return new DemuxerTrackMeta(TrackType.AUDIO, Codec.codecByFourcc(getFourcc()), this.duration / this.timescale, null, this.totalFrames, null, null, AudioCodecMeta.fromAudioFormat(((AudioSampleEntry) getSampleEntries()[0]).getFormat()));
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public synchronized MP4Packet getNextFrame(ByteBuffer byteBuffer) throws IOException {
        if (this.stcoInd >= this.chunkOffsets.length) {
            return null;
        }
        int frameSize = getFrameSize();
        int entry = this.sampleToChunks[this.stscInd].getEntry();
        int count = this.sampleToChunks[this.stscInd].getCount() * frameSize;
        long j = this.chunkOffsets[this.stcoInd];
        int i = this.posShift;
        long j2 = j + i;
        int i2 = count - i;
        ByteBuffer packetData = readPacketData(this.input, byteBuffer, j2, i2);
        long j3 = this.pts;
        long j4 = i2 / frameSize;
        shiftPts(j4);
        MP4Packet mP4Packet = new MP4Packet(packetData, QTTimeUtil.mediaToEdited(this.box, j3, this.movie.getTimescale()), this.timescale, (int) (this.pts - j3), this.curFrame, Packet.FrameType.KEY, null, 0, j3, entry - 1, j2, i2, true);
        this.curFrame += j4;
        this.posShift = 0;
        this.stcoInd = this.stcoInd + 1;
        int i3 = this.stscInd;
        SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr = this.sampleToChunks;
        if (i3 < sampleToChunkEntryArr.length - 1 && r1 + 1 == sampleToChunkEntryArr[i3 + 1].getFirst()) {
            this.stscInd++;
        }
        return mP4Packet;
    }

    @Override // org.jcodec.common.SeekableDemuxerTrack
    public boolean gotoSyncFrame(long j) {
        return gotoFrame(j);
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        return getNextFrame(ByteBuffer.allocate((this.sampleToChunks[this.stscInd].getCount() * getFrameSize()) - this.posShift));
    }

    @Override // org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack
    public void seekPointer(long j) {
        this.stcoInd = 0;
        this.stscInd = 0;
        this.curFrame = 0L;
        while (true) {
            long count = this.curFrame + this.sampleToChunks[this.stscInd].getCount();
            if (count > j) {
                this.posShift = (int) ((j - this.curFrame) * getFrameSize());
                this.curFrame = j;
                return;
            } else {
                this.curFrame = count;
                nextChunk();
            }
        }
    }
}
