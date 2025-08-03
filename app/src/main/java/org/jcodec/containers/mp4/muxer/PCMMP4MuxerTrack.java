package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.Preconditions;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
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
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class PCMMP4MuxerTrack extends AbstractMP4MuxerTrack {
    private LongArrayList chunkOffsets;
    private int frameDuration;
    private int frameSize;
    private int framesInCurChunk;
    private int totalFrames;

    public PCMMP4MuxerTrack(int i, AudioFormat audioFormat) {
        super(i, MP4TrackType.SOUND);
        this.chunkOffsets = LongArrayList.createLongArrayList();
        this.frameDuration = 1;
        this.frameSize = (audioFormat.getSampleSizeInBits() >> 3) * audioFormat.getChannels();
        addSampleEntry(AudioSampleEntry.audioSampleEntryPCM(audioFormat));
        this._timescale = audioFormat.getSampleRate();
        setTgtChunkDuration(new Rational(1, 2), Unit.SEC);
    }

    private void outChunk() throws IOException {
        if (this.framesInCurChunk == 0) {
            return;
        }
        this.chunkOffsets.add(this.out.position());
        Iterator<ByteBuffer> it = this.curChunk.iterator();
        while (it.hasNext()) {
            this.out.write(it.next());
        }
        this.curChunk.clear();
        int i = this.samplesInLastChunk;
        if (i == -1 || this.framesInCurChunk != i) {
            this.samplesInChunks.add(new SampleToChunkBox.SampleToChunkEntry(this.chunkNo + 1, this.framesInCurChunk, 1));
        }
        this.samplesInLastChunk = this.framesInCurChunk;
        this.chunkNo++;
        this.framesInCurChunk = 0;
        this.chunkDuration = 0L;
    }

    private void outChunkIfNeeded() throws IOException {
        Unit unit = this.tgtChunkDurationUnit;
        Unit unit2 = Unit.FRAME;
        Preconditions.checkState(unit == unit2 || unit == Unit.SEC, "");
        if (this.tgtChunkDurationUnit == unit2 && this.framesInCurChunk * this.tgtChunkDuration.getDen() == this.tgtChunkDuration.getNum()) {
            outChunk();
            return;
        }
        if (this.tgtChunkDurationUnit == Unit.SEC) {
            long j = this.chunkDuration;
            if (j <= 0 || j * this.tgtChunkDuration.getDen() < this.tgtChunkDuration.getNum() * this._timescale) {
                return;
            }
            outChunk();
        }
    }

    @Override // org.jcodec.common.MuxerTrack
    public void addFrame(Packet packet) throws IOException {
        addSamples(packet.getData().duplicate());
    }

    public void addSamples(ByteBuffer byteBuffer) throws IOException {
        this.curChunk.add(byteBuffer);
        int iRemaining = byteBuffer.remaining() / this.frameSize;
        this.totalFrames += iRemaining;
        this.framesInCurChunk += iRemaining;
        this.chunkDuration += iRemaining * this.frameDuration;
        outChunkIfNeeded();
    }

    @Override // org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        outChunk();
        this.finished = true;
        TrakBox trakBoxCreateTrakBox = TrakBox.createTrakBox();
        Size displayDimensions = getDisplayDimensions();
        TrackHeaderBox trackHeaderBoxCreateTrackHeaderBox = TrackHeaderBox.createTrackHeaderBox(this.trackId, ((movieHeaderBox.getTimescale() * this.totalFrames) * this.frameDuration) / this._timescale, displayDimensions.getWidth(), displayDimensions.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0L, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
        trackHeaderBoxCreateTrackHeaderBox.setFlags(15);
        trakBoxCreateTrakBox.add(trackHeaderBoxCreateTrackHeaderBox);
        tapt(trakBoxCreateTrakBox);
        MediaBox mediaBoxCreateMediaBox = MediaBox.createMediaBox();
        trakBoxCreateTrakBox.add(mediaBoxCreateMediaBox);
        mediaBoxCreateMediaBox.add(MediaHeaderBox.createMediaHeaderBox(this._timescale, this.totalFrames * this.frameDuration, 0, new Date().getTime(), new Date().getTime(), 0));
        mediaBoxCreateMediaBox.add(HandlerBox.createHandlerBox("mhlr", this.type.getHandler(), "appl", 0, 0));
        MediaInfoBox mediaInfoBoxCreateMediaInfoBox = MediaInfoBox.createMediaInfoBox();
        mediaBoxCreateMediaBox.add(mediaInfoBoxCreateMediaInfoBox);
        mediaHeader(mediaInfoBoxCreateMediaInfoBox, this.type);
        mediaInfoBoxCreateMediaInfoBox.add(HandlerBox.createHandlerBox("dhlr", "url ", "appl", 0, 0));
        addDref(mediaInfoBoxCreateMediaInfoBox);
        NodeBox nodeBox = new NodeBox(new Header("stbl"));
        mediaInfoBoxCreateMediaInfoBox.add(nodeBox);
        putEdits(trakBoxCreateTrakBox);
        putName(trakBoxCreateTrakBox);
        nodeBox.add(SampleDescriptionBox.createSampleDescriptionBox((SampleEntry[]) this.sampleEntries.toArray(new SampleEntry[0])));
        nodeBox.add(SampleToChunkBox.createSampleToChunkBox((SampleToChunkBox.SampleToChunkEntry[]) this.samplesInChunks.toArray(new SampleToChunkBox.SampleToChunkEntry[0])));
        nodeBox.add(SampleSizesBox.createSampleSizesBox(this.frameSize, this.totalFrames));
        nodeBox.add(TimeToSampleBox.createTimeToSampleBox(new TimeToSampleBox.TimeToSampleEntry[]{new TimeToSampleBox.TimeToSampleEntry(this.totalFrames, this.frameDuration)}));
        nodeBox.add(ChunkOffsets64Box.createChunkOffsets64Box(this.chunkOffsets.toArray()));
        return trakBoxCreateTrakBox;
    }

    @Override // org.jcodec.containers.mp4.muxer.AbstractMP4MuxerTrack
    public long getTrackTotalDuration() {
        return this.totalFrames * this.frameDuration;
    }
}
