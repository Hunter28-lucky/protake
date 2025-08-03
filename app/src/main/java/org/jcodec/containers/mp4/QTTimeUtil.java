package org.jcodec.containers.mp4;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.demuxer.TimecodeMP4DemuxerTrack;

/* loaded from: classes2.dex */
public class QTTimeUtil {
    public static long editedToMedia(TrakBox trakBox, long j, int i) {
        if (trakBox.getEdits() == null) {
            return j;
        }
        long j2 = 0;
        for (Edit edit : trakBox.getEdits()) {
            long jRescale = trakBox.rescale(edit.getDuration(), i) + j2;
            if (jRescale > j) {
                return (edit.getMediaTime() + j) - j2;
            }
            j2 = jRescale;
        }
        return j2;
    }

    public static String formatTimecode(TrakBox trakBox, int i) {
        byte numFrames = ((TimecodeSampleEntry) NodeBox.findFirstPath(trakBox, TimecodeSampleEntry.class, Box.path("mdia.minf.stbl.stsd.tmcd"))).getNumFrames();
        String str = String.format("%02d", Integer.valueOf(i % numFrames));
        int i2 = i / numFrames;
        String str2 = String.format("%02d", Integer.valueOf(i2 % 60)) + Constants.COLON_SEPARATOR + str;
        int i3 = i2 / 60;
        return String.format("%02d", Integer.valueOf(i3 / 60)) + Constants.COLON_SEPARATOR + (String.format("%02d", Integer.valueOf(i3 % 60)) + Constants.COLON_SEPARATOR + str2);
    }

    public static long frameToTimevalue(TrakBox trakBox, int i) {
        TimeToSampleBox.TimeToSampleEntry[] entries = ((TimeToSampleBox) NodeBox.findFirstPath(trakBox, TimeToSampleBox.class, Box.path("mdia.minf.stbl.stts"))).getEntries();
        long sampleCount = 0;
        int i2 = 0;
        while (i >= entries[i2].getSampleCount()) {
            i -= entries[i2].getSampleCount();
            sampleCount += entries[i2].getSampleCount() * entries[i2].getSampleDuration();
            i2++;
        }
        return sampleCount + (entries[i2].getSampleDuration() * i);
    }

    public static long getEditedDuration(TrakBox trakBox) {
        List<Edit> edits = trakBox.getEdits();
        if (edits == null) {
            return trakBox.getDuration();
        }
        long duration = 0;
        Iterator<Edit> it = edits.iterator();
        while (it.hasNext()) {
            duration += it.next().getDuration();
        }
        return duration;
    }

    public static long mediaToEdited(TrakBox trakBox, long j, int i) {
        if (trakBox.getEdits() == null) {
            return j;
        }
        long j2 = 0;
        for (Edit edit : trakBox.getEdits()) {
            if (j < edit.getMediaTime()) {
                return j2;
            }
            long jRescale = trakBox.rescale(edit.getDuration(), i);
            if (edit.getMediaTime() != -1 && j >= edit.getMediaTime() && j < edit.getMediaTime() + jRescale) {
                return j2 + (j - edit.getMediaTime());
            }
            j2 += jRescale;
        }
        return j2;
    }

    public static int qtPlayerFrameNo(MovieBox movieBox, int i) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        return tv2QTFrameNo(movieBox, mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale()));
    }

    public static String qtPlayerTime(MovieBox movieBox, int i) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        int iMediaToEdited = (int) (mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale()) / videoTrack.getTimescale());
        return String.format("%02d", Integer.valueOf(iMediaToEdited / 3600)) + "_" + String.format("%02d", Integer.valueOf((iMediaToEdited % 3600) / 60)) + "_" + String.format("%02d", Integer.valueOf(iMediaToEdited % 60));
    }

    public static String qtPlayerTimecode(TimecodeMP4DemuxerTrack timecodeMP4DemuxerTrack, RationalLarge rationalLarge, int i) throws IOException {
        TrakBox box = timecodeMP4DemuxerTrack.getBox();
        long timescale = box.getTimescale();
        return formatTimecode(timecodeMP4DemuxerTrack.getBox(), timecodeMP4DemuxerTrack.getStartTimecode() + timevalueToTimecodeFrame(timecodeMP4DemuxerTrack.getBox(), new RationalLarge(editedToMedia(box, rationalLarge.multiplyS(timescale), i), timescale), i));
    }

    public static String qtPlayerTimecodeFromMovie(MovieBox movieBox, TimecodeMP4DemuxerTrack timecodeMP4DemuxerTrack, int i) throws IOException {
        TrakBox videoTrack = movieBox.getVideoTrack();
        long jMediaToEdited = mediaToEdited(videoTrack, frameToTimevalue(videoTrack, i), movieBox.getTimescale());
        TrakBox box = timecodeMP4DemuxerTrack.getBox();
        long timescale = box.getTimescale();
        return formatTimecode(timecodeMP4DemuxerTrack.getBox(), timecodeMP4DemuxerTrack.getStartTimecode() + timevalueToTimecodeFrame(timecodeMP4DemuxerTrack.getBox(), new RationalLarge(editedToMedia(box, (jMediaToEdited * timescale) / videoTrack.getTimescale(), movieBox.getTimescale()), timescale), movieBox.getTimescale()));
    }

    public static int timevalueToFrame(TrakBox trakBox, long j) {
        TimeToSampleBox.TimeToSampleEntry[] entries = ((TimeToSampleBox) NodeBox.findFirstPath(trakBox, TimeToSampleBox.class, Box.path("mdia.minf.stbl.stts"))).getEntries();
        int i = 0;
        for (int i2 = 0; j > 0 && i2 < entries.length; i2++) {
            long sampleDuration = j / entries[i2].getSampleDuration();
            j -= entries[i2].getSampleCount() * entries[i2].getSampleDuration();
            long j2 = i;
            if (j > 0) {
                sampleDuration = entries[i2].getSampleCount();
            }
            i = (int) (j2 + sampleDuration);
        }
        return i;
    }

    public static int timevalueToTimecodeFrame(TrakBox trakBox, RationalLarge rationalLarge, int i) {
        TimecodeSampleEntry timecodeSampleEntry = (TimecodeSampleEntry) trakBox.getSampleEntries()[0];
        return ((int) (((rationalLarge.multiplyS(timecodeSampleEntry.getTimescale()) * 2) / timecodeSampleEntry.getFrameDuration()) + 1)) / 2;
    }

    public static int tv2QTFrameNo(MovieBox movieBox, long j) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        TrakBox timecodeTrack = movieBox.getTimecodeTrack();
        return (timecodeTrack == null || !BoxUtil.containsBox2(videoTrack, "tref", "tmcd")) ? timevalueToFrame(videoTrack, j) : timevalueToTimecodeFrame(timecodeTrack, new RationalLarge(j, videoTrack.getTimescale()), movieBox.getTimescale());
    }
}
