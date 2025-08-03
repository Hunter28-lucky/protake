package org.jcodec.containers.mp4.demuxer;

import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class TimecodeMP4DemuxerTrack {
    private TrakBox box;
    private long[] chunkOffsets;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int[] sampleCache;
    private SampleToChunkBox.SampleToChunkEntry[] sampleToChunks;
    private TimeToSampleBox.TimeToSampleEntry[] timeToSamples;
    private TimecodeSampleEntry tse;

    public TimecodeMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) throws IOException {
        this.box = trakBox;
        this.input = seekableByteChannel;
        this.movie = movieBox;
        NodeBox stbl = trakBox.getMdia().getMinf().getStbl();
        TimeToSampleBox timeToSampleBox = (TimeToSampleBox) NodeBox.findFirst(stbl, TimeToSampleBox.class, "stts");
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) NodeBox.findFirst(stbl, SampleToChunkBox.class, "stsc");
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) NodeBox.findFirst(stbl, ChunkOffsetsBox.class, "stco");
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) NodeBox.findFirst(stbl, ChunkOffsets64Box.class, "co64");
        this.timeToSamples = timeToSampleBox.getEntries();
        this.chunkOffsets = chunkOffsetsBox != null ? chunkOffsetsBox.getChunkOffsets() : chunkOffsets64Box.getChunkOffsets();
        SampleToChunkBox.SampleToChunkEntry[] sampleToChunk = sampleToChunkBox.getSampleToChunk();
        this.sampleToChunks = sampleToChunk;
        long[] jArr = this.chunkOffsets;
        if (jArr.length == 1) {
            cacheSamples(sampleToChunk, jArr);
        }
        this.tse = (TimecodeSampleEntry) this.box.getSampleEntries()[0];
    }

    private static TapeTimecode _getTimecode(int i, int i2, TimecodeSampleEntry timecodeSampleEntry) {
        return TapeTimecode.tapeTimecode(i2 + i, timecodeSampleEntry.isDropFrame(), timecodeSampleEntry.getNumFrames() & ExifInterface.MARKER);
    }

    private void cacheSamples(SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr, long[] jArr) throws IOException {
        synchronized (this.input) {
            IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
            int i = 0;
            for (int i2 = 0; i2 < jArr.length; i2++) {
                int count = sampleToChunkEntryArr[i].getCount();
                if (i < sampleToChunkEntryArr.length - 1) {
                    int i3 = i + 1;
                    if (i2 + 1 >= sampleToChunkEntryArr[i3].getFirst()) {
                        i = i3;
                    }
                }
                this.input.setPosition(jArr[i2]);
                ByteBuffer byteBufferFetchFromChannel = NIOUtils.fetchFromChannel(this.input, count * 4);
                for (int i4 = 0; i4 < count; i4++) {
                    intArrayListCreateIntArrayList.add(byteBufferFetchFromChannel.getInt());
                }
            }
            this.sampleCache = intArrayListCreateIntArrayList.toArray();
        }
    }

    private int getTimecodeSample(int i) throws IOException {
        int i2;
        int[] iArr = this.sampleCache;
        if (iArr != null) {
            return iArr[i];
        }
        synchronized (this.input) {
            int i3 = 0;
            while (true) {
                SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr = this.sampleToChunks;
                if (i3 >= sampleToChunkEntryArr.length || i < sampleToChunkEntryArr[i3].getCount()) {
                    break;
                }
                i -= this.sampleToChunks[i3].getCount();
                i3++;
            }
            long jMin = this.chunkOffsets[i3] + (Math.min(i, this.sampleToChunks[i3].getCount() - 1) << 2);
            if (this.input.position() != jMin) {
                this.input.setPosition(jMin);
            }
            i2 = NIOUtils.fetchFromChannel(this.input, 4).getInt();
        }
        return i2;
    }

    private static boolean isValidTimeCode(String str) {
        return (str == null || str.trim().equals("") || !Pattern.compile("[0-9][0-9]:[0-5][0-9]:[0-5][0-9]:[0-2][0-9]").matcher(str).matches()) ? false : true;
    }

    public TrakBox getBox() {
        return this.box;
    }

    public int getStartTimecode() throws IOException {
        return getTimecodeSample(0);
    }

    public MP4Packet getTimecode(MP4Packet mP4Packet) throws IOException {
        TrakBox trakBox = this.box;
        long jEditedToMedia = QTTimeUtil.editedToMedia(trakBox, trakBox.rescale(mP4Packet.getPts(), mP4Packet.getTimescale()), this.movie.getTimescale());
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < this.sampleCache.length - 1) {
            long sampleDuration = this.timeToSamples[i2].getSampleDuration();
            if (jEditedToMedia < sampleDuration) {
                break;
            }
            jEditedToMedia -= sampleDuration;
            i3++;
            TimeToSampleBox.TimeToSampleEntry[] timeToSampleEntryArr = this.timeToSamples;
            if (i2 < timeToSampleEntryArr.length - 1 && i3 >= timeToSampleEntryArr[i2].getSampleCount()) {
                i2++;
            }
            i++;
        }
        return MP4Packet.createMP4PacketWithTimecode(mP4Packet, _getTimecode(getTimecodeSample(i), ((int) (((((jEditedToMedia * 2) * this.tse.getTimescale()) / this.box.getTimescale()) / this.tse.getFrameDuration()) + 1)) / 2, this.tse));
    }

    public int parseTimecode(String str) {
        String[] strArrSplit = str.split(Constants.COLON_SEPARATOR);
        byte numFrames = ((TimecodeSampleEntry) NodeBox.findFirstPath(this.box, TimecodeSampleEntry.class, Box.path("mdia.minf.stbl.stsd.tmcd"))).getNumFrames();
        return Integer.parseInt(strArrSplit[3]) + (Integer.parseInt(strArrSplit[2]) * numFrames) + (Integer.parseInt(strArrSplit[1]) * 60 * numFrames) + (Integer.parseInt(strArrSplit[0]) * 3600 * numFrames);
    }

    public int timeCodeToFrameNo(String str) throws Exception {
        if (!isValidTimeCode(str)) {
            return -1;
        }
        int timecode = parseTimecode(str.trim()) - this.sampleCache[0];
        long numFrames = this.tse.getNumFrames();
        return (int) ((QTTimeUtil.mediaToEdited(this.box, (timecode * this.tse.getTimescale()) / numFrames, this.movie.getTimescale()) * numFrames) / this.box.getTimescale());
    }
}
