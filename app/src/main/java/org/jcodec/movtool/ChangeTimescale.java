package org.jcodec.movtool;

import java.io.File;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

/* loaded from: classes2.dex */
public class ChangeTimescale {
    public static void main1(String[] strArr) throws Exception {
        if (strArr.length < 2) {
            System.out.println("Syntax: chts <movie> <timescale>");
            System.exit(-1);
        }
        final int i = Integer.parseInt(strArr[1]);
        if (i < 600) {
            System.out.println("Could not set timescale < 600");
            System.exit(-1);
        }
        new InplaceMP4Editor().modify(new File(strArr[0]), new MP4Edit() { // from class: org.jcodec.movtool.ChangeTimescale.1
            @Override // org.jcodec.movtool.MP4Edit
            public void apply(MovieBox movieBox) {
                TrakBox videoTrack = movieBox.getVideoTrack();
                int timescale = ((MediaHeaderBox) NodeBox.findFirstPath(videoTrack, MediaHeaderBox.class, Box.path("mdia.mdhd"))).getTimescale();
                int i2 = i;
                if (timescale <= i2) {
                    videoTrack.fixMediaTimescale(i2);
                    movieBox.fixTimescale(i);
                    return;
                }
                throw new RuntimeException("Old timescale (" + timescale + ") is greater then new timescale (" + i + "), not touching.");
            }

            @Override // org.jcodec.movtool.MP4Edit
            public void applyToFragment(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
                throw new RuntimeException("Unsupported");
            }
        });
    }
}
