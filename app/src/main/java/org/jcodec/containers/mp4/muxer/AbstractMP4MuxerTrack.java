package org.jcodec.containers.mp4.muxer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.api.UnhandledStateException;
import org.jcodec.common.MuxerTrack;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.MP4TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ClearApertureBox;
import org.jcodec.containers.mp4.boxes.DataInfoBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.EditListBox;
import org.jcodec.containers.mp4.boxes.EncodedPixelBox;
import org.jcodec.containers.mp4.boxes.GenericMediaInfoBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NameBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.ProductionApertureBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.TimecodeMediaInfoBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

/* loaded from: classes2.dex */
public abstract class AbstractMP4MuxerTrack implements MuxerTrack {
    public static final int NO_TIMESCALE_SET = -1;
    public long chunkDuration;
    public List<Edit> edits;
    public boolean finished;
    private String name;
    public SeekableByteChannel out;
    public Rational tgtChunkDuration;
    public Unit tgtChunkDurationUnit;
    public int trackId;
    public MP4TrackType type;
    public int samplesInLastChunk = -1;
    public int chunkNo = 0;
    public List<ByteBuffer> curChunk = new ArrayList();
    public List<SampleToChunkBox.SampleToChunkEntry> samplesInChunks = new ArrayList();
    public List<SampleEntry> sampleEntries = new ArrayList();
    public int _timescale = -1;

    public AbstractMP4MuxerTrack(int i, MP4TrackType mP4TrackType) {
        this.trackId = i;
        this.type = mP4TrackType;
    }

    public void addDref(NodeBox nodeBox) {
        DataInfoBox dataInfoBoxCreateDataInfoBox = DataInfoBox.createDataInfoBox();
        nodeBox.add(dataInfoBoxCreateDataInfoBox);
        DataRefBox dataRefBoxCreateDataRefBox = DataRefBox.createDataRefBox();
        dataInfoBoxCreateDataInfoBox.add(dataRefBoxCreateDataRefBox);
        dataRefBoxCreateDataRefBox.add(Box.createLeafBox(Header.createHeader("alis", 0L), ByteBuffer.wrap(new byte[]{0, 0, 0, 1})));
    }

    public AbstractMP4MuxerTrack addSampleEntry(SampleEntry sampleEntry) {
        Preconditions.checkState(!this.finished, "The muxer track has finished muxing");
        this.sampleEntries.add(sampleEntry);
        return this;
    }

    public abstract Box finish(MovieHeaderBox movieHeaderBox) throws IOException;

    public Size getDisplayDimensions() {
        int height;
        List<SampleEntry> list = this.sampleEntries;
        int num = 0;
        if (list == null || list.isEmpty() || !(this.sampleEntries.get(0) instanceof VideoSampleEntry)) {
            height = 0;
        } else {
            VideoSampleEntry videoSampleEntry = (VideoSampleEntry) this.sampleEntries.get(0);
            PixelAspectExt pixelAspectExt = (PixelAspectExt) NodeBox.findFirst(videoSampleEntry, PixelAspectExt.class, PixelAspectExt.fourcc());
            Rational rational = pixelAspectExt != null ? pixelAspectExt.getRational() : new Rational(1, 1);
            num = (rational.getNum() * videoSampleEntry.getWidth()) / rational.getDen();
            height = videoSampleEntry.getHeight();
        }
        return new Size(num, height);
    }

    public List<SampleEntry> getEntries() {
        return this.sampleEntries;
    }

    public int getTimescale() {
        return this._timescale;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public abstract long getTrackTotalDuration();

    public MP4TrackType getType() {
        return this.type;
    }

    public boolean isAudio() {
        return this.type == MP4TrackType.SOUND;
    }

    public boolean isTimecode() {
        return this.type == MP4TrackType.TIMECODE;
    }

    public boolean isVideo() {
        return this.type == MP4TrackType.VIDEO;
    }

    public void mediaHeader(MediaInfoBox mediaInfoBox, MP4TrackType mP4TrackType) {
        if (MP4TrackType.VIDEO == mP4TrackType) {
            VideoMediaHeaderBox videoMediaHeaderBoxCreateVideoMediaHeaderBox = VideoMediaHeaderBox.createVideoMediaHeaderBox(0, 0, 0, 0);
            videoMediaHeaderBoxCreateVideoMediaHeaderBox.setFlags(1);
            mediaInfoBox.add(videoMediaHeaderBoxCreateVideoMediaHeaderBox);
            return;
        }
        if (MP4TrackType.SOUND == mP4TrackType) {
            SoundMediaHeaderBox soundMediaHeaderBoxCreateSoundMediaHeaderBox = SoundMediaHeaderBox.createSoundMediaHeaderBox();
            soundMediaHeaderBoxCreateSoundMediaHeaderBox.setFlags(1);
            mediaInfoBox.add(soundMediaHeaderBoxCreateSoundMediaHeaderBox);
        } else {
            if (MP4TrackType.TIMECODE == mP4TrackType) {
                NodeBox nodeBox = new NodeBox(new Header("gmhd"));
                nodeBox.add(GenericMediaInfoBox.createGenericMediaInfoBox());
                NodeBox nodeBox2 = new NodeBox(new Header("tmcd"));
                nodeBox.add(nodeBox2);
                nodeBox2.add(TimecodeMediaInfoBox.createTimecodeMediaInfoBox((short) 0, (short) 0, (short) 12, new short[]{0, 0, 0}, new short[]{255, 255, 255}, "Lucida Grande"));
                mediaInfoBox.add(nodeBox);
                return;
            }
            if (MP4TrackType.DATA == mP4TrackType) {
                return;
            }
            throw new UnhandledStateException("Handler " + mP4TrackType.getHandler() + " not supported");
        }
    }

    public void putEdits(TrakBox trakBox) {
        if (this.edits != null) {
            NodeBox nodeBox = new NodeBox(new Header("edts"));
            nodeBox.add(EditListBox.createEditListBox(this.edits));
            trakBox.add(nodeBox);
        }
    }

    public void putName(TrakBox trakBox) {
        if (this.name != null) {
            NodeBox nodeBox = new NodeBox(new Header("udta"));
            nodeBox.add(NameBox.createNameBox(this.name));
            trakBox.add(nodeBox);
        }
    }

    public void setEdits(List<Edit> list) {
        this.edits = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public AbstractMP4MuxerTrack setOut(SeekableByteChannel seekableByteChannel) {
        this.out = seekableByteChannel;
        return this;
    }

    public void setTgtChunkDuration(Rational rational, Unit unit) {
        this.tgtChunkDuration = rational;
        this.tgtChunkDurationUnit = unit;
    }

    public void tapt(TrakBox trakBox) {
        Size displayDimensions = getDisplayDimensions();
        if (this.type == MP4TrackType.VIDEO) {
            NodeBox nodeBox = new NodeBox(new Header("tapt"));
            nodeBox.add(ClearApertureBox.createClearApertureBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            nodeBox.add(ProductionApertureBox.createProductionApertureBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            nodeBox.add(EncodedPixelBox.createEncodedPixelBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            trakBox.add(nodeBox);
        }
    }
}
