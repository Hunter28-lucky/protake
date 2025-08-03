package org.jcodec.movtool;

import java.io.File;
import org.jcodec.containers.mp4.MP4Util;

/* loaded from: classes2.dex */
public class ReplaceMP4Editor {
    public void copy(File file, File file2, MP4Edit mP4Edit) throws Throwable {
        MP4Util.Movie movieCreateRefFullMovieFromFile = MP4Util.createRefFullMovieFromFile(file);
        mP4Edit.apply(movieCreateRefFullMovieFromFile.getMoov());
        new Flatten().flatten(movieCreateRefFullMovieFromFile, file2);
    }

    public void modifyOrReplace(File file, MP4Edit mP4Edit) throws Throwable {
        if (new InplaceMP4Editor().modify(file, mP4Edit)) {
            return;
        }
        replace(file, mP4Edit);
    }

    public void replace(File file, MP4Edit mP4Edit) throws Throwable {
        File file2 = new File(file.getParentFile(), "." + file.getName());
        copy(file, file2, mP4Edit);
        file2.renameTo(file);
    }
}
