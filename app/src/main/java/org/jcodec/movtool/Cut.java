package org.jcodec.movtool;

import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.StringUtils;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.BoxFactory;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class Cut {

    public static class Slice {
        private double inSec;
        private double outSec;

        public Slice(double d, double d2) {
            this.inSec = d;
            this.outSec = d2;
        }
    }

    public static void main1(String[] strArr) throws Exception {
        FileChannelWrapper fileChannelWrapperWritableChannel;
        FileChannelWrapper fileChannelWrapper;
        List<MP4Util.Movie> listCut;
        if (strArr.length < 1) {
            System.out.println("Syntax: cut [-command arg]...[-command arg] [-self] <movie file>\n\tCreates a reference movie out of the file and applies a set of changes specified by the commands to it.");
            System.exit(-1);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        boolean z = false;
        while (true) {
            fileChannelWrapperWritableChannel = null;
            if (!"-cut".equals(strArr[i])) {
                if (!"-self".equals(strArr[i])) {
                    break;
                }
                i++;
                z = true;
            } else {
                String[] strArrSplitS = StringUtils.splitS(strArr[i + 1], Constants.COLON_SEPARATOR);
                arrayList.add(new Slice(Integer.parseInt(strArrSplitS[0]), Integer.parseInt(strArrSplitS[1])));
                if (strArrSplitS.length > 2) {
                    arrayList2.add(strArrSplitS[2]);
                } else {
                    arrayList2.add(null);
                }
                i += 2;
            }
        }
        File file = new File(strArr[i]);
        ArrayList arrayList3 = new ArrayList();
        try {
            FileChannelWrapper fileChannelWrapper2 = NIOUtils.readableChannel(file);
            try {
                MP4Util.Movie movieCreateRefFullMovie = MP4Util.createRefFullMovie(fileChannelWrapper2, "file://" + file.getCanonicalPath());
                if (z) {
                    fileChannelWrapperWritableChannel = NIOUtils.writableChannel(new File(file.getParentFile(), JCodecUtil2.removeExtension(file.getName()) + ".self.mov"));
                    listCut = new Cut().cut(movieCreateRefFullMovie, arrayList);
                    new Strip().strip(movieCreateRefFullMovie.getMoov());
                    new Flatten().flattenChannel(movieCreateRefFullMovie, fileChannelWrapperWritableChannel);
                } else {
                    fileChannelWrapperWritableChannel = NIOUtils.writableChannel(new File(file.getParentFile(), JCodecUtil2.removeExtension(file.getName()) + ".ref.mov"));
                    listCut = new Cut().cut(movieCreateRefFullMovie, arrayList);
                    MP4Util.writeFullMovie(fileChannelWrapperWritableChannel, movieCreateRefFullMovie);
                }
                saveSlices(listCut, arrayList2, file.getParentFile());
                if (fileChannelWrapper2 != null) {
                    fileChannelWrapper2.close();
                }
                if (fileChannelWrapperWritableChannel != null) {
                    fileChannelWrapperWritableChannel.close();
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    ((SeekableByteChannel) it.next()).close();
                }
            } catch (Throwable th) {
                th = th;
                fileChannelWrapper = fileChannelWrapperWritableChannel;
                fileChannelWrapperWritableChannel = fileChannelWrapper2;
                if (fileChannelWrapperWritableChannel != null) {
                    fileChannelWrapperWritableChannel.close();
                }
                if (fileChannelWrapper != null) {
                    fileChannelWrapper.close();
                }
                Iterator it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    ((SeekableByteChannel) it2.next()).close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = null;
        }
    }

    private static void saveSlices(List<MP4Util.Movie> list, List<String> list2, File file) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            if (list2.get(i) != null) {
                FileChannelWrapper fileChannelWrapperWritableChannel = null;
                try {
                    fileChannelWrapperWritableChannel = NIOUtils.writableChannel(new File(file, list2.get(i)));
                    MP4Util.writeFullMovie(fileChannelWrapperWritableChannel, list.get(i));
                } finally {
                    NIOUtils.closeQuietly(fileChannelWrapperWritableChannel);
                }
            }
        }
    }

    private void selectInner(List<Edit> list, Slice slice, MovieBox movieBox, TrakBox trakBox) {
        long timescale = (long) (movieBox.getTimescale() * slice.inSec);
        long timescale2 = (long) (movieBox.getTimescale() * slice.outSec);
        ListIterator<Edit> listIterator = list.listIterator();
        long duration = 0;
        while (listIterator.hasNext()) {
            Edit next = listIterator.next();
            if (next.getDuration() + duration <= timescale || duration >= timescale2) {
                listIterator.remove();
            }
            duration += next.getDuration();
        }
    }

    private void selectOuter(List<Edit> list, List<Slice> list2, MovieBox movieBox, TrakBox trakBox) {
        int size = list2.size();
        long[] jArr = new long[size];
        long[] jArr2 = new long[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            jArr[i] = (long) (list2.get(i).inSec * movieBox.getTimescale());
            jArr2[i] = (long) (list2.get(i).outSec * movieBox.getTimescale());
        }
        long duration = 0;
        ListIterator<Edit> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Edit next = listIterator.next();
            for (int i2 = 0; i2 < size; i2++) {
                if (next.getDuration() + duration > jArr[i2] && duration < jArr2[i2]) {
                    listIterator.remove();
                }
            }
            duration += next.getDuration();
        }
    }

    private void split(List<Edit> list, double d, MovieBox movieBox, TrakBox trakBox) {
        Util.split(movieBox, trakBox, (long) (d * movieBox.getTimescale()));
    }

    public List<MP4Util.Movie> cut(MP4Util.Movie movie, List<Slice> list) {
        MovieBox moov = movie.getMoov();
        TrakBox videoTrack = moov.getVideoTrack();
        if (videoTrack != null && videoTrack.getTimescale() != moov.getTimescale()) {
            moov.fixTimescale(videoTrack.getTimescale());
        }
        for (TrakBox trakBox : moov.getTracks()) {
            Util.forceEditList(moov, trakBox);
            List<Edit> edits = trakBox.getEdits();
            for (Slice slice : list) {
                split(edits, slice.inSec, moov, trakBox);
                split(edits, slice.outSec, moov, trakBox);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Slice slice2 : list) {
            MovieBox movieBox = (MovieBox) NodeBox.cloneBox(moov, 16777216, BoxFactory.getDefault());
            for (TrakBox trakBox2 : movieBox.getTracks()) {
                selectInner(trakBox2.getEdits(), slice2, moov, trakBox2);
            }
            arrayList.add(new MP4Util.Movie(movie.getFtyp(), movieBox));
        }
        long jMax = 0;
        for (TrakBox trakBox3 : moov.getTracks()) {
            selectOuter(trakBox3.getEdits(), list, moov, trakBox3);
            trakBox3.setEdits(trakBox3.getEdits());
            jMax = Math.max(jMax, trakBox3.getDuration());
        }
        moov.setDuration(jMax);
        return arrayList;
    }
}
