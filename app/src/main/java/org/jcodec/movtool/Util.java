package org.jcodec.movtool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.model.Rational;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class Util {

    public static class Pair<T> {
        private T a;
        private T b;

        public Pair(T t, T t2) {
            this.a = t;
            this.b = t2;
        }

        public T getA() {
            return this.a;
        }

        public T getB() {
            return this.b;
        }
    }

    private static void appendChunkOffsets(TrakBox trakBox, TrakBox trakBox2) {
        ChunkOffsetsBox stco = trakBox.getStco();
        ChunkOffsets64Box co64 = trakBox.getCo64();
        ChunkOffsetsBox stco2 = trakBox2.getStco();
        ChunkOffsets64Box co642 = trakBox2.getCo64();
        long[] chunkOffsets = stco == null ? co64.getChunkOffsets() : stco.getChunkOffsets();
        long[] chunkOffsets2 = stco2 == null ? co642.getChunkOffsets() : stco2.getChunkOffsets();
        NodeBox nodeBox = (NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"));
        nodeBox.removeChildren(new String[]{"stco", "co64"});
        nodeBox.add((co64 == null && co642 == null) ? ChunkOffsetsBox.createChunkOffsetsBox(ArrayUtil.addAllLong(chunkOffsets, chunkOffsets2)) : ChunkOffsets64Box.createChunkOffsets64Box(ArrayUtil.addAllLong(chunkOffsets, chunkOffsets2)));
    }

    private static void appendDrefs(TrakBox trakBox, TrakBox trakBox2) {
        ((DataRefBox) NodeBox.findFirstPath(trakBox, DataRefBox.class, Box.path("mdia.minf.dinf.dref"))).getBoxes().addAll(((DataRefBox) NodeBox.findFirstPath(trakBox2, DataRefBox.class, Box.path("mdia.minf.dinf.dref"))).getBoxes());
    }

    private static void appendEdits(TrakBox trakBox, TrakBox trakBox2, int i) {
        Iterator<Edit> it = trakBox2.getEdits().iterator();
        while (it.hasNext()) {
            it.next().shift(trakBox.getMediaDuration());
        }
        trakBox.getEdits().addAll(i, trakBox2.getEdits());
        trakBox.setEdits(trakBox.getEdits());
    }

    private static int appendEntries(TrakBox trakBox, TrakBox trakBox2) {
        appendDrefs(trakBox, trakBox2);
        SampleEntry[] sampleEntries = trakBox.getSampleEntries();
        SampleEntry[] sampleEntries2 = trakBox2.getSampleEntries();
        SampleDescriptionBox sampleDescriptionBoxCreateSampleDescriptionBox = SampleDescriptionBox.createSampleDescriptionBox(sampleEntries);
        for (SampleEntry sampleEntry : sampleEntries2) {
            sampleEntry.setDrefInd((short) (sampleEntry.getDrefInd() + sampleEntries.length));
            sampleDescriptionBoxCreateSampleDescriptionBox.add(sampleEntry);
        }
        ((NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"))).replace("stsd", sampleDescriptionBoxCreateSampleDescriptionBox);
        return sampleEntries.length;
    }

    private static void appendSampleSizes(TrakBox trakBox, TrakBox trakBox2) {
        SampleSizesBox stsz = trakBox.getStsz();
        SampleSizesBox stsz2 = trakBox2.getStsz();
        if (stsz.getDefaultSize() != stsz2.getDefaultSize()) {
            throw new IllegalArgumentException("Can't append to track that has different default sample size");
        }
        ((NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"))).replace("stsz", stsz.getDefaultSize() > 0 ? SampleSizesBox.createSampleSizesBox(stsz.getDefaultSize(), stsz.getCount() + stsz2.getCount()) : SampleSizesBox.createSampleSizesBox2(ArrayUtil.addAllInt(stsz.getSizes(), stsz2.getSizes())));
    }

    private static void appendSampleToChunk(TrakBox trakBox, TrakBox trakBox2, int i) {
        SampleToChunkBox stsc = trakBox.getStsc();
        SampleToChunkBox.SampleToChunkEntry[] sampleToChunk = trakBox2.getStsc().getSampleToChunk();
        SampleToChunkBox.SampleToChunkEntry[] sampleToChunkEntryArr = new SampleToChunkBox.SampleToChunkEntry[sampleToChunk.length];
        for (int i2 = 0; i2 < sampleToChunk.length; i2++) {
            sampleToChunkEntryArr[i2] = new SampleToChunkBox.SampleToChunkEntry(sampleToChunk[i2].getFirst() + stsc.getSampleToChunk().length, sampleToChunk[i2].getCount(), sampleToChunk[i2].getEntry() + i);
        }
        ((NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"))).replace("stsc", SampleToChunkBox.createSampleToChunkBox((SampleToChunkBox.SampleToChunkEntry[]) ArrayUtil.addAllObj(stsc.getSampleToChunk(), sampleToChunkEntryArr)));
    }

    private static void appendTimeToSamples(TrakBox trakBox, TrakBox trakBox2) {
        ((NodeBox) NodeBox.findFirstPath(trakBox, NodeBox.class, Box.path("mdia.minf.stbl"))).replace("stts", TimeToSampleBox.createTimeToSampleBox((TimeToSampleBox.TimeToSampleEntry[]) ArrayUtil.addAllObj(trakBox.getStts().getEntries(), trakBox2.getStts().getEntries())));
    }

    public static void appendTo(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2) {
        appendToInternal(movieBox, trakBox, trakBox2);
        appendEdits(trakBox, trakBox2, trakBox.getEdits().size());
        updateDuration(trakBox, trakBox2);
    }

    private static void appendToInternal(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2) {
        int iAppendEntries = appendEntries(trakBox, trakBox2);
        appendChunkOffsets(trakBox, trakBox2);
        appendTimeToSamples(trakBox, trakBox2);
        appendSampleToChunk(trakBox, trakBox2, iAppendEntries);
        appendSampleSizes(trakBox, trakBox2);
    }

    public static List<Edit> editsOnEdits(Rational rational, List<Edit> list, List<Edit> list2) {
        ArrayList arrayList = new ArrayList();
        List<Edit> arrayList2 = new ArrayList<>(list);
        for (Edit edit : list2) {
            long jMultiplyLong = rational.multiplyLong(edit.getMediaTime());
            Pair<List<Edit>> pairSplitEdits = splitEdits(splitEdits(arrayList2, rational.flip(), jMultiplyLong).getB(), rational.flip(), jMultiplyLong + edit.getDuration());
            arrayList.addAll(pairSplitEdits.getA());
            arrayList2 = pairSplitEdits.getB();
        }
        return arrayList;
    }

    public static void forceEditList(MovieBox movieBox, TrakBox trakBox) {
        List<Edit> edits = trakBox.getEdits();
        if (edits == null || edits.size() == 0) {
            MovieHeaderBox movieHeaderBox = (MovieHeaderBox) NodeBox.findFirst(movieBox, MovieHeaderBox.class, "mvhd");
            ArrayList arrayList = new ArrayList();
            trakBox.setEdits(arrayList);
            arrayList.add(new Edit((int) movieHeaderBox.getDuration(), 0L, 1.0f));
            trakBox.setEdits(arrayList);
        }
    }

    public static void forceEditListMov(MovieBox movieBox) {
        for (TrakBox trakBox : movieBox.getTracks()) {
            forceEditList(movieBox, trakBox);
        }
    }

    public static long[] getTimevalues(TrakBox trakBox) {
        TimeToSampleBox.TimeToSampleEntry[] entries = trakBox.getStts().getEntries();
        int sampleCount = 0;
        for (TimeToSampleBox.TimeToSampleEntry timeToSampleEntry : entries) {
            sampleCount += timeToSampleEntry.getSampleCount();
        }
        long[] jArr = new long[sampleCount + 1];
        int i = 0;
        for (int i2 = 0; i2 < entries.length; i2++) {
            int i3 = 0;
            while (i3 < entries[i2].getSampleCount()) {
                int i4 = i + 1;
                jArr[i4] = jArr[i] + entries[i2].getSampleDuration();
                i3++;
                i = i4;
            }
        }
        return jArr;
    }

    private static void insertEdits(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2, long j) {
        appendEdits(trakBox, trakBox2, split(movieBox, trakBox, j).getA().size());
    }

    public static void insertTo(MovieBox movieBox, TrakBox trakBox, TrakBox trakBox2, long j) {
        appendToInternal(movieBox, trakBox, trakBox2);
        insertEdits(movieBox, trakBox, trakBox2, j);
        updateDuration(trakBox, trakBox2);
    }

    public static void shift(MovieBox movieBox, TrakBox trakBox, long j) {
        trakBox.getEdits().add(0, new Edit(j, -1L, 1.0f));
    }

    public static Pair<List<Edit>> split(MovieBox movieBox, TrakBox trakBox, long j) {
        return splitEdits(trakBox.getEdits(), new Rational(trakBox.getTimescale(), movieBox.getTimescale()), j);
    }

    public static Pair<List<Edit>> splitEdits(List<Edit> list, Rational rational, long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ListIterator<Edit> listIterator = list.listIterator();
        long duration = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            Edit next = listIterator.next();
            if (next.getDuration() + duration > j) {
                int i = (int) (j - duration);
                int iMultiplyS = rational.multiplyS(i);
                long j2 = i;
                Edit edit = new Edit(j2, next.getMediaTime(), 1.0f);
                Edit edit2 = new Edit(next.getDuration() - j2, iMultiplyS + next.getMediaTime(), 1.0f);
                listIterator.remove();
                if (edit.getDuration() > 0) {
                    listIterator.add(edit);
                    arrayList.add(edit);
                }
                if (edit2.getDuration() > 0) {
                    listIterator.add(edit2);
                    arrayList2.add(edit2);
                }
            } else {
                arrayList.add(next);
                duration += next.getDuration();
            }
        }
        while (listIterator.hasNext()) {
            arrayList2.add(listIterator.next());
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static void spread(MovieBox movieBox, TrakBox trakBox, long j, long j2) {
        trakBox.getEdits().add(split(movieBox, trakBox, j).getA().size(), new Edit(j2, -1L, 1.0f));
    }

    private static void updateDuration(TrakBox trakBox, TrakBox trakBox2) {
        MediaHeaderBox mediaHeaderBox = (MediaHeaderBox) NodeBox.findFirstPath(trakBox, MediaHeaderBox.class, Box.path("mdia.mdhd"));
        mediaHeaderBox.setDuration(mediaHeaderBox.getDuration() + ((MediaHeaderBox) NodeBox.findFirstPath(trakBox2, MediaHeaderBox.class, Box.path("mdia.mdhd"))).getDuration());
    }
}
