package org.jcodec.movtool;

import java.io.File;
import java.util.Arrays;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ClipRegionBox;
import org.jcodec.containers.mp4.boxes.LoadSettingsBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Paste {
    public long[] tv;

    private int[][] findMatches(TrakBox[] trakBoxArr, TrakBox[] trakBoxArr2) {
        int[] iArr = new int[trakBoxArr.length];
        int[] iArr2 = new int[trakBoxArr2.length];
        Arrays.fill(iArr, -1);
        Arrays.fill(iArr2, -1);
        for (int i = 0; i < trakBoxArr.length; i++) {
            if (iArr[i] == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 >= trakBoxArr2.length) {
                        break;
                    }
                    if (iArr2[i2] == -1 && matches(trakBoxArr[i], trakBoxArr2[i2])) {
                        iArr[i] = i2;
                        iArr2[i2] = i;
                        break;
                    }
                    i2++;
                }
            }
        }
        return new int[][]{iArr, iArr2};
    }

    private long getFrameTv(TrakBox trakBox, int i) {
        if (this.tv == null) {
            this.tv = Util.getTimevalues(trakBox);
        }
        return this.tv[i];
    }

    public static void main1(String[] strArr) throws Exception {
        FileChannelWrapper fileChannelWrapper;
        FileChannelWrapper fileChannelWrapperWritableChannel;
        if (strArr.length < 2) {
            System.out.println("Syntax: paste <to movie> <from movie> [second]");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        FileChannelWrapper fileChannelWrapper2 = null;
        try {
            File file2 = new File(file.getParentFile(), file.getName().replaceAll("\\.mov$", "") + ".paste.mov");
            Platform.deleteFile(file2);
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file2);
            try {
                FileChannelWrapper fileChannelWrapperWritableChannel2 = NIOUtils.writableChannel(file);
                try {
                    File file3 = new File(strArr[1]);
                    fileChannelWrapper2 = NIOUtils.readableChannel(file3);
                    MP4Util.Movie movieCreateRefFullMovie = MP4Util.createRefFullMovie(fileChannelWrapperWritableChannel2, "file://" + file.getCanonicalPath());
                    MP4Util.Movie movieCreateRefFullMovie2 = MP4Util.createRefFullMovie(fileChannelWrapper2, "file://" + file3.getCanonicalPath());
                    new Strip().strip(movieCreateRefFullMovie2.getMoov());
                    if (strArr.length > 2) {
                        new Paste().paste(movieCreateRefFullMovie.getMoov(), movieCreateRefFullMovie2.getMoov(), Double.parseDouble(strArr[2]));
                    } else {
                        new Paste().addToMovie(movieCreateRefFullMovie.getMoov(), movieCreateRefFullMovie2.getMoov());
                    }
                    MP4Util.writeFullMovie(fileChannelWrapperWritableChannel, movieCreateRefFullMovie);
                    if (fileChannelWrapperWritableChannel2 != null) {
                        fileChannelWrapperWritableChannel2.close();
                    }
                    if (fileChannelWrapper2 != null) {
                        fileChannelWrapper2.close();
                    }
                    if (fileChannelWrapperWritableChannel != null) {
                        fileChannelWrapperWritableChannel.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileChannelWrapper = fileChannelWrapper2;
                    fileChannelWrapper2 = fileChannelWrapperWritableChannel2;
                    if (fileChannelWrapper2 != null) {
                        fileChannelWrapper2.close();
                    }
                    if (fileChannelWrapper != null) {
                        fileChannelWrapper.close();
                    }
                    if (fileChannelWrapperWritableChannel != null) {
                        fileChannelWrapperWritableChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannelWrapper = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannelWrapper = null;
            fileChannelWrapperWritableChannel = null;
        }
    }

    private boolean matchClip(TrakBox trakBox, TrakBox trakBox2) {
        ClipRegionBox clipRegionBox = (ClipRegionBox) NodeBox.findFirstPath(trakBox, ClipRegionBox.class, Box.path("clip.crgn"));
        ClipRegionBox clipRegionBox2 = (ClipRegionBox) NodeBox.findFirstPath(trakBox2, ClipRegionBox.class, Box.path("clip.crgn"));
        return (clipRegionBox == null || clipRegionBox2 == null) ? clipRegionBox == null && clipRegionBox2 == null : clipRegionBox.getRgnSize() == clipRegionBox2.getRgnSize() && clipRegionBox.getX() == clipRegionBox2.getX() && clipRegionBox.getY() == clipRegionBox2.getY() && clipRegionBox.getWidth() == clipRegionBox2.getWidth() && clipRegionBox.getHeight() == clipRegionBox2.getHeight();
    }

    private boolean matchHeaders(TrakBox trakBox, TrakBox trakBox2) {
        TrackHeaderBox trackHeader = trakBox.getTrackHeader();
        TrackHeaderBox trackHeader2 = trakBox2.getTrackHeader();
        return ("vide".equals(trakBox.getHandlerType()) && Platform.arrayEqualsInt(trackHeader.getMatrix(), trackHeader2.getMatrix()) && trackHeader.getLayer() == trackHeader2.getLayer() && trackHeader.getWidth() == trackHeader2.getWidth() && trackHeader.getHeight() == trackHeader2.getHeight()) || ("soun".equals(trakBox.getHandlerType()) && trackHeader.getVolume() == trackHeader2.getVolume()) || "tmcd".equals(trakBox.getHandlerType());
    }

    private boolean matchLoad(TrakBox trakBox, TrakBox trakBox2) {
        LoadSettingsBox loadSettingsBox = (LoadSettingsBox) NodeBox.findFirst(trakBox, LoadSettingsBox.class, "load");
        LoadSettingsBox loadSettingsBox2 = (LoadSettingsBox) NodeBox.findFirst(trakBox2, LoadSettingsBox.class, "load");
        return (loadSettingsBox == null || loadSettingsBox2 == null) ? loadSettingsBox == null && loadSettingsBox2 == null : loadSettingsBox.getPreloadStartTime() == loadSettingsBox2.getPreloadStartTime() && loadSettingsBox.getPreloadDuration() == loadSettingsBox2.getPreloadDuration() && loadSettingsBox.getPreloadFlags() == loadSettingsBox2.getPreloadFlags() && loadSettingsBox.getDefaultHints() == loadSettingsBox2.getDefaultHints();
    }

    private boolean matchMediaHeader(TrakBox trakBox, TrakBox trakBox2) {
        VideoMediaHeaderBox videoMediaHeaderBox = (VideoMediaHeaderBox) NodeBox.findFirstPath(trakBox, VideoMediaHeaderBox.class, Box.path("mdia.minf.vmhd"));
        VideoMediaHeaderBox videoMediaHeaderBox2 = (VideoMediaHeaderBox) NodeBox.findFirstPath(trakBox2, VideoMediaHeaderBox.class, Box.path("mdia.minf.vmhd"));
        if ((videoMediaHeaderBox != null && videoMediaHeaderBox2 == null) || (videoMediaHeaderBox == null && videoMediaHeaderBox2 != null)) {
            return false;
        }
        if (videoMediaHeaderBox != null && videoMediaHeaderBox2 != null) {
            return videoMediaHeaderBox.getGraphicsMode() == videoMediaHeaderBox2.getGraphicsMode() && videoMediaHeaderBox.getbOpColor() == videoMediaHeaderBox2.getbOpColor() && videoMediaHeaderBox.getgOpColor() == videoMediaHeaderBox2.getgOpColor() && videoMediaHeaderBox.getrOpColor() == videoMediaHeaderBox2.getrOpColor();
        }
        SoundMediaHeaderBox soundMediaHeaderBox = (SoundMediaHeaderBox) NodeBox.findFirstPath(trakBox, SoundMediaHeaderBox.class, Box.path("mdia.minf.smhd"));
        SoundMediaHeaderBox soundMediaHeaderBox2 = (SoundMediaHeaderBox) NodeBox.findFirstPath(trakBox2, SoundMediaHeaderBox.class, Box.path("mdia.minf.smhd"));
        if ((soundMediaHeaderBox != null || soundMediaHeaderBox2 == null) && (soundMediaHeaderBox == null || soundMediaHeaderBox2 != null)) {
            return soundMediaHeaderBox == null || soundMediaHeaderBox2 == null || soundMediaHeaderBox.getBalance() == soundMediaHeaderBox.getBalance();
        }
        return false;
    }

    private boolean matchSampleSizes(TrakBox trakBox, TrakBox trakBox2) {
        return ((SampleSizesBox) NodeBox.findFirstPath(trakBox, SampleSizesBox.class, Box.path("mdia.minf.stbl.stsz"))).getDefaultSize() == ((SampleSizesBox) NodeBox.findFirstPath(trakBox, SampleSizesBox.class, Box.path("mdia.minf.stbl.stsz"))).getDefaultSize();
    }

    private boolean matches(TrakBox trakBox, TrakBox trakBox2) {
        return trakBox.getHandlerType().equals(trakBox2.getHandlerType()) && matchHeaders(trakBox, trakBox2) && matchSampleSizes(trakBox, trakBox2) && matchMediaHeader(trakBox, trakBox2) && matchClip(trakBox, trakBox2) && matchLoad(trakBox, trakBox2);
    }

    public void addToMovie(MovieBox movieBox, MovieBox movieBox2) {
        for (TrakBox trakBox : movieBox2.getTracks()) {
            movieBox.appendTrack(movieBox.importTrack(movieBox2, trakBox));
        }
    }

    public void paste(MovieBox movieBox, MovieBox movieBox2, double d) {
        TrakBox videoTrack = movieBox.getVideoTrack();
        if (videoTrack != null && videoTrack.getTimescale() != movieBox.getTimescale()) {
            movieBox.fixTimescale(videoTrack.getTimescale());
        }
        long timescale = (long) (movieBox.getTimescale() * d);
        Util.forceEditListMov(movieBox);
        Util.forceEditListMov(movieBox2);
        TrakBox[] tracks = movieBox2.getTracks();
        TrakBox[] tracks2 = movieBox.getTracks();
        int[][] iArrFindMatches = findMatches(tracks, tracks2);
        for (int i = 0; i < iArrFindMatches[0].length; i++) {
            TrakBox trakBoxImportTrack = movieBox.importTrack(movieBox2, tracks[i]);
            int i2 = iArrFindMatches[0][i];
            if (i2 != -1) {
                Util.insertTo(movieBox, tracks2[i2], trakBoxImportTrack, timescale);
            } else {
                movieBox.appendTrack(trakBoxImportTrack);
                Util.shift(movieBox, trakBoxImportTrack, timescale);
            }
        }
        int i3 = 0;
        while (true) {
            int[] iArr = iArrFindMatches[1];
            if (i3 >= iArr.length) {
                movieBox.updateDuration();
                return;
            } else {
                if (iArr[i3] == -1) {
                    Util.spread(movieBox, tracks2[i3], timescale, movieBox.rescale(movieBox2.getDuration(), movieBox2.getTimescale()));
                }
                i3++;
            }
        }
    }
}
