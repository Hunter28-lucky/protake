package org.jcodec.movtool;

import java.util.Iterator;
import java.util.List;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;

/* loaded from: classes2.dex */
public class CompoundMP4Edit implements MP4Edit {
    private List<MP4Edit> edits;

    public CompoundMP4Edit(List<MP4Edit> list) {
        this.edits = list;
    }

    @Override // org.jcodec.movtool.MP4Edit
    public void apply(MovieBox movieBox) {
        Iterator<MP4Edit> it = this.edits.iterator();
        while (it.hasNext()) {
            it.next().apply(movieBox);
        }
    }

    @Override // org.jcodec.movtool.MP4Edit
    public void applyToFragment(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
        Iterator<MP4Edit> it = this.edits.iterator();
        while (it.hasNext()) {
            it.next().applyToFragment(movieBox, movieFragmentBoxArr);
        }
    }
}
