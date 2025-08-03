package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.NodeBox;

/* loaded from: classes2.dex */
public class MovDump {
    private static void dumpHeader(File file, File file2) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        FileChannelWrapper fileChannelWrapper2;
        FileChannelWrapper fileChannelWrapperWritableChannel = null;
        try {
            fileChannelWrapper2 = NIOUtils.readableChannel(file2);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            fileChannelWrapperWritableChannel = NIOUtils.writableChannel(file);
            for (MP4Util.Atom atom : MP4Util.getRootAtoms(fileChannelWrapper2)) {
                String fourcc = atom.getHeader().getFourcc();
                if ("moov".equals(fourcc) || "ftyp".equals(fourcc)) {
                    atom.copy(fileChannelWrapper2, fileChannelWrapperWritableChannel);
                }
            }
            IOUtils.closeQuietly(fileChannelWrapper2);
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
        } catch (Throwable th2) {
            th = th2;
            FileChannelWrapper fileChannelWrapper3 = fileChannelWrapperWritableChannel;
            fileChannelWrapperWritableChannel = fileChannelWrapper2;
            fileChannelWrapper = fileChannelWrapper3;
            IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            IOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    private static Box findDeep(NodeBox nodeBox, String str) {
        Box boxFindDeep;
        for (Box box : nodeBox.getBoxes()) {
            if (str.equalsIgnoreCase(box.getFourcc())) {
                return box;
            }
            if ((box instanceof NodeBox) && (boxFindDeep = findDeep((NodeBox) box, str)) != null) {
                return boxFindDeep;
            }
        }
        return null;
    }

    public static void main1(String[] strArr) throws Exception {
        if (strArr.length < 1) {
            System.out.println("Syntax: movdump [options] <filename>");
            System.out.println("Options: \n\t-f <filename> save header to a file\n\t-a <atom name> dump only a specific atom\n");
            return;
        }
        int i = 0;
        File file = null;
        String str = null;
        while (i < strArr.length) {
            if (!"-f".equals(strArr[i])) {
                if (!"-a".equals(strArr[i])) {
                    break;
                }
                int i2 = i + 1;
                str = strArr[i2];
                i = i2 + 1;
            } else {
                int i3 = i + 1;
                file = new File(strArr[i3]);
                i = i3 + 1;
            }
        }
        File file2 = new File(strArr[i]);
        if (file != null) {
            dumpHeader(file, file2);
        }
        if (str == null) {
            System.out.println(print(file2));
            return;
        }
        String strPrintAtom = printAtom(file2, str);
        if (strPrintAtom != null) {
            System.out.println(strPrintAtom);
        }
    }

    public static String print(File file) throws IOException {
        return MP4Util.parseMovie(file).toString();
    }

    public static String printAtom(File file, String str) throws IOException {
        Box boxFindDeep = findDeep(MP4Util.parseMovie(file), str);
        if (boxFindDeep != null) {
            return boxFindDeep.toString();
        }
        System.out.println("Atom " + str + " not found.");
        return null;
    }
}
