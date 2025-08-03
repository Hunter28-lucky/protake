package org.jcodec.containers.mp4;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;

/* loaded from: classes2.dex */
public class SampleOffsetUtils {
    public static int getChunkBySample(int i, ChunkOffsetsBox chunkOffsetsBox, SampleToChunkBox sampleToChunkBox) {
        int length = chunkOffsetsBox.getChunkOffsets().length;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= length) {
            int samplesInChunk = getSamplesInChunk(i2, sampleToChunkBox) + i3;
            if (i >= i3 && i < samplesInChunk) {
                return i2;
            }
            i2++;
            i3 = samplesInChunk;
        }
        return -1;
    }

    public static int getFirstSampleAtChunk(int i, SampleToChunkBox sampleToChunkBox, ChunkOffsetsBox chunkOffsetsBox) {
        int length = chunkOffsetsBox.getChunkOffsets().length;
        int samplesInChunk = 0;
        for (int i2 = 1; i2 <= length && i2 != i; i2++) {
            samplesInChunk += getSamplesInChunk(i2, sampleToChunkBox);
        }
        return samplesInChunk;
    }

    public static ByteBuffer getSampleData(int i, File file) throws IOException {
        MediaInfoBox minf = MP4Util.parseMovie(file).getAudioTracks().get(0).getMdia().getMinf();
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) NodeBox.findFirstPath(minf, ChunkOffsetsBox.class, Box.path("stbl.stco"));
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) NodeBox.findFirstPath(minf, SampleToChunkBox.class, Box.path("stbl.stsc"));
        SampleSizesBox sampleSizesBox = (SampleSizesBox) NodeBox.findFirstPath(minf, SampleSizesBox.class, Box.path("stbl.stsz"));
        long sampleOffset = getSampleOffset(i, sampleToChunkBox, chunkOffsetsBox, sampleSizesBox);
        MappedByteBuffer mappedByteBufferMapFile = NIOUtils.mapFile(file);
        mappedByteBufferMapFile.position((int) sampleOffset);
        mappedByteBufferMapFile.limit(mappedByteBufferMapFile.position() + sampleSizesBox.getSizes()[i]);
        return mappedByteBufferMapFile;
    }

    public static long getSampleOffset(int i, SampleToChunkBox sampleToChunkBox, ChunkOffsetsBox chunkOffsetsBox, SampleSizesBox sampleSizesBox) {
        int chunkBySample = getChunkBySample(i, chunkOffsetsBox, sampleToChunkBox);
        long j = chunkOffsetsBox.getChunkOffsets()[chunkBySample - 1];
        int[] sizes = sampleSizesBox.getSizes();
        for (int firstSampleAtChunk = getFirstSampleAtChunk(chunkBySample, sampleToChunkBox, chunkOffsetsBox); firstSampleAtChunk < i; firstSampleAtChunk++) {
            j += sizes[firstSampleAtChunk];
        }
        return j;
    }

    public static int getSamplesInChunk(int i, SampleToChunkBox sampleToChunkBox) {
        int count = 0;
        for (SampleToChunkBox.SampleToChunkEntry sampleToChunkEntry : sampleToChunkBox.getSampleToChunk()) {
            if (sampleToChunkEntry.getFirst() > i) {
                return count;
            }
            count = sampleToChunkEntry.getCount();
        }
        return count;
    }
}
