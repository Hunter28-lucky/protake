package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.Chunk;
import org.jcodec.containers.mp4.ChunkReader;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Strip {
    private List<Edit> deepCopy(List<Edit> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Edit> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Edit.createEdit(it.next()));
        }
        return arrayList;
    }

    private boolean intersects(long j, long j2, long j3, long j4) {
        return (j >= j3 && j < j4) || (j2 >= j3 && j2 < j4) || ((j3 >= j && j3 < j2) || (j4 >= j && j4 < j2));
    }

    public static void main1(String[] strArr) throws Exception {
        FileChannelWrapper fileChannelWrapper;
        FileChannelWrapper fileChannelWrapper2;
        if (strArr.length < 2) {
            System.out.println("Syntax: strip <ref movie> <out movie>");
            System.exit(-1);
        }
        FileChannelWrapper fileChannelWrapperWritableChannel = null;
        try {
            fileChannelWrapper2 = NIOUtils.readableChannel(new File(strArr[0]));
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            File file = new File(strArr[1]);
            Platform.deleteFile(file);
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
            MP4Util.Movie movieCreateRefFullMovie = MP4Util.createRefFullMovie(fileChannelWrapper2, "file://" + new File(strArr[0]).getAbsolutePath());
            new Strip().strip(movieCreateRefFullMovie.getMoov());
            MP4Util.writeFullMovie(fileChannelWrapperWritableChannel, movieCreateRefFullMovie);
            if (fileChannelWrapper2 != null) {
                fileChannelWrapper2.close();
            }
            if (fileChannelWrapperWritableChannel != null) {
                fileChannelWrapperWritableChannel.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = fileChannelWrapperWritableChannel;
            fileChannelWrapperWritableChannel = fileChannelWrapper2;
            if (fileChannelWrapperWritableChannel != null) {
                fileChannelWrapperWritableChannel.close();
            }
            if (fileChannelWrapper != null) {
                fileChannelWrapper.close();
            }
            throw th;
        }
    }

    private long totalDuration(List<Chunk> list) {
        long duration = 0;
        while (list.iterator().hasNext()) {
            duration += r5.next().getDuration();
        }
        return duration;
    }

    public Box getChunkOffsets(List<Chunk> list) {
        long[] jArr = new long[list.size()];
        boolean z = false;
        int i = 0;
        for (Chunk chunk : list) {
            if (chunk.getOffset() >= 4294967296L) {
                z = true;
            }
            jArr[i] = chunk.getOffset();
            i++;
        }
        return z ? ChunkOffsets64Box.createChunkOffsets64Box(jArr) : ChunkOffsetsBox.createChunkOffsetsBox(jArr);
    }

    public SampleSizesBox getSampleSizes(List<Chunk> list) {
        int sampleSize = list.get(0).getSampleSize();
        int sampleCount = 0;
        for (Chunk chunk : list) {
            sampleCount += chunk.getSampleCount();
            if (sampleSize == 0 && chunk.getSampleSize() != 0) {
                throw new RuntimeException("Mixed sample sizes not supported");
            }
        }
        if (sampleSize > 0) {
            return SampleSizesBox.createSampleSizesBox(sampleSize, sampleCount);
        }
        int[] iArr = new int[sampleCount];
        int sampleCount2 = 0;
        for (Chunk chunk2 : list) {
            System.arraycopy(chunk2.getSampleSizes(), 0, iArr, sampleCount2, chunk2.getSampleCount());
            sampleCount2 += chunk2.getSampleCount();
        }
        return SampleSizesBox.createSampleSizesBox2(iArr);
    }

    public SampleToChunkBox getSamplesToChunk(List<Chunk> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Chunk> it = list.iterator();
        Chunk next = it.next();
        int sampleCount = next.getSampleCount();
        int entry = next.getEntry();
        int i = 1;
        int i2 = 1;
        while (it.hasNext()) {
            Chunk next2 = it.next();
            int sampleCount2 = next2.getSampleCount();
            int entry2 = next2.getEntry();
            if (sampleCount != sampleCount2 || entry != entry2) {
                arrayList.add(new SampleToChunkBox.SampleToChunkEntry(i2, sampleCount, entry));
                i2 += i;
                entry = entry2;
                i = 0;
                sampleCount = sampleCount2;
            }
            i++;
        }
        if (i > 0) {
            arrayList.add(new SampleToChunkBox.SampleToChunkEntry(i2, sampleCount, entry));
        }
        return SampleToChunkBox.createSampleToChunkBox((SampleToChunkBox.SampleToChunkEntry[]) arrayList.toArray(new SampleToChunkBox.SampleToChunkEntry[0]));
    }

    public TimeToSampleBox getTimeToSamples(List<Chunk> list) {
        ArrayList arrayList = new ArrayList();
        int sampleCount = 0;
        int sampleDur = -1;
        for (Chunk chunk : list) {
            if (chunk.getSampleDur() > 0) {
                if (sampleDur == -1 || sampleDur != chunk.getSampleDur()) {
                    if (sampleDur != -1) {
                        arrayList.add(new TimeToSampleBox.TimeToSampleEntry(sampleCount, sampleDur));
                    }
                    sampleDur = chunk.getSampleDur();
                    sampleCount = 0;
                }
                sampleCount += chunk.getSampleCount();
            } else {
                for (int i : chunk.getSampleDurs()) {
                    if (sampleDur == -1 || sampleDur != i) {
                        if (sampleDur != -1) {
                            arrayList.add(new TimeToSampleBox.TimeToSampleEntry(sampleCount, sampleDur));
                        }
                        sampleCount = 0;
                        sampleDur = i;
                    }
                    sampleCount++;
                }
            }
        }
        if (sampleCount > 0) {
            arrayList.add(new TimeToSampleBox.TimeToSampleEntry(sampleCount, sampleDur));
        }
        return TimeToSampleBox.createTimeToSampleBox((TimeToSampleBox.TimeToSampleEntry[]) arrayList.toArray(new TimeToSampleBox.TimeToSampleEntry[0]));
    }

    public void strip(MovieBox movieBox) throws IOException {
        for (TrakBox trakBox : movieBox.getTracks()) {
            stripTrack(movieBox, trakBox);
        }
    }

    public void stripTrack(MovieBox movieBox, TrakBox trakBox) {
        ChunkReader chunkReader = new ChunkReader(trakBox);
        List<Edit> edits = trakBox.getEdits();
        List<Edit> listDeepCopy = deepCopy(edits);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Chunk next = chunkReader.next();
            if (next == null) {
                NodeBox nodeBox = (NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"));
                nodeBox.replace("stts", getTimeToSamples(arrayList));
                nodeBox.replace("stsz", getSampleSizes(arrayList));
                nodeBox.replace("stsc", getSamplesToChunk(arrayList));
                nodeBox.removeChildren(new String[]{"stco", "co64"});
                nodeBox.add(getChunkOffsets(arrayList));
                ((MediaHeaderBox) NodeBox.findFirstPath(trakBox, MediaHeaderBox.class, Box.path("mdia.mdhd"))).setDuration(totalDuration(arrayList));
                return;
            }
            boolean zIntersects = false;
            for (Edit edit : listDeepCopy) {
                if (edit.getMediaTime() != -1) {
                    zIntersects = intersects(edit.getMediaTime(), edit.getMediaTime() + trakBox.rescale(edit.getDuration(), movieBox.getTimescale()), next.getStartTv(), next.getDuration() + next.getStartTv());
                    if (zIntersects) {
                        break;
                    }
                }
            }
            if (zIntersects) {
                arrayList.add(next);
            } else {
                for (int i = 0; i < listDeepCopy.size(); i++) {
                    if (listDeepCopy.get(i).getMediaTime() >= next.getStartTv() + next.getDuration()) {
                        edits.get(i).shift(-next.getDuration());
                    }
                }
            }
        }
    }
}
