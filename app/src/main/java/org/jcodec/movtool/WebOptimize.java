package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import org.jcodec.containers.mp4.MP4Util;

/* loaded from: classes2.dex */
public class WebOptimize {
    public static File hidFile(File file) {
        File file2 = new File(file.getParentFile(), "." + file.getName());
        if (!file2.exists()) {
            return file2;
        }
        int i = 1;
        while (true) {
            File parentFile = file.getParentFile();
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            sb.append(file.getName());
            sb.append(".");
            int i2 = i + 1;
            sb.append(i);
            File file3 = new File(parentFile, sb.toString());
            if (!file3.exists()) {
                return file3;
            }
            i = i2;
        }
    }

    public static void main1(String[] strArr) throws IOException {
        if (strArr.length < 1) {
            System.out.println("Syntax: optimize <movie>");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        File fileHidFile = hidFile(file);
        file.renameTo(fileHidFile);
        try {
            new Flatten().flatten(MP4Util.createRefFullMovieFromFile(fileHidFile), file);
        } catch (Throwable th) {
            th.printStackTrace();
            file.renameTo(new File(file.getParentFile(), file.getName() + ".error"));
            fileHidFile.renameTo(file);
        }
    }
}
