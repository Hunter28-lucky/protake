package org.jcodec.movtool;

import java.io.File;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.BoxUtil;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

/* loaded from: classes2.dex */
public class SetPAR {
    public static void main1(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            System.out.println("Syntax: setpasp <movie> <num:den>");
            System.exit(-1);
        }
        final Rational rational = Rational.parse(strArr[1]);
        new InplaceMP4Editor().modify(new File(strArr[0]), new MP4Edit() { // from class: org.jcodec.movtool.SetPAR.1
            @Override // org.jcodec.movtool.MP4Edit
            public void apply(MovieBox movieBox) {
                TrakBox videoTrack = movieBox.getVideoTrack();
                videoTrack.setPAR(rational);
                Box box = ((SampleDescriptionBox) NodeBox.findFirstPath(videoTrack, SampleDescriptionBox.class, Box.path("mdia.minf.stbl.stsd"))).getBoxes().get(0);
                if (box == null || !(box instanceof VideoSampleEntry)) {
                    return;
                }
                VideoSampleEntry videoSampleEntry = (VideoSampleEntry) box;
                int width = videoSampleEntry.getWidth();
                int height = videoSampleEntry.getHeight();
                int num = (rational.getNum() * width) / rational.getDen();
                videoTrack.getTrackHeader().setWidth(num);
                if (BoxUtil.containsBox(videoTrack, "tapt")) {
                    videoTrack.setAperture(new Size(width, height), new Size(num, height));
                }
            }

            @Override // org.jcodec.movtool.MP4Edit
            public void applyToFragment(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
                throw new RuntimeException("Unsupported");
            }
        });
    }
}
