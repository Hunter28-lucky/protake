package org.jcodec.movtool;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mp4.BoxFactory;
import org.jcodec.containers.mp4.BoxUtil;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;

/* loaded from: classes2.dex */
public class Undo {
    private boolean isMoov(SeekableByteChannel seekableByteChannel, MP4Util.Atom atom) throws IOException {
        seekableByteChannel.setPosition(atom.getOffset() + atom.getHeader().headerSize());
        try {
            Box box = BoxUtil.parseBox(NIOUtils.fetchFromChannel(seekableByteChannel, (int) atom.getHeader().getSize()), Header.createHeader("moov", atom.getHeader().getSize()), BoxFactory.getDefault());
            if (box instanceof MovieBox) {
                return BoxUtil.containsBox((NodeBox) box, "mvhd");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        r0.add(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<org.jcodec.containers.mp4.MP4Util.Atom> list(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L53
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L53
            org.jcodec.common.io.FileChannelWrapper r1 = org.jcodec.common.io.NIOUtils.readableChannel(r2)     // Catch: java.lang.Throwable -> L53
            java.util.List r6 = org.jcodec.containers.mp4.MP4Util.getRootAtoms(r1)     // Catch: java.lang.Throwable -> L53
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L53
        L17:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L53
            if (r2 == 0) goto L4f
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L53
            org.jcodec.containers.mp4.MP4Util$Atom r2 = (org.jcodec.containers.mp4.MP4Util.Atom) r2     // Catch: java.lang.Throwable -> L53
            java.lang.String r3 = "free"
            org.jcodec.containers.mp4.boxes.Header r4 = r2.getHeader()     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = r4.getFourcc()     // Catch: java.lang.Throwable -> L53
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L3c
            boolean r3 = r5.isMoov(r1, r2)     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L3c
            r0.add(r2)     // Catch: java.lang.Throwable -> L53
        L3c:
            java.lang.String r3 = "moov"
            org.jcodec.containers.mp4.boxes.Header r4 = r2.getHeader()     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = r4.getFourcc()     // Catch: java.lang.Throwable -> L53
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L17
            r0.add(r2)     // Catch: java.lang.Throwable -> L53
        L4f:
            org.jcodec.common.io.IOUtils.closeQuietly(r1)
            return r0
        L53:
            r6 = move-exception
            org.jcodec.common.io.IOUtils.closeQuietly(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.movtool.Undo.list(java.lang.String):java.util.List");
    }

    public static void main1(String[] strArr) throws Throwable {
        if (strArr.length < 1) {
            System.err.println("Syntax: qt-undo [-l] <movie>");
            System.err.println("\t-l\t\tList all the previous versions of this movie.");
            System.exit(-1);
        }
        Undo undo = new Undo();
        if (!"-l".equals(strArr[0])) {
            undo.undo(strArr[0]);
            return;
        }
        List<MP4Util.Atom> list = undo.list(strArr[1]);
        System.out.println((list.size() - 1) + " versions.");
    }

    private void undo(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        List<MP4Util.Atom> list = list(str);
        if (list.size() < 2) {
            System.err.println("Nowhere to rollback.");
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "rw");
        } catch (Throwable th) {
            th = th;
        }
        try {
            randomAccessFile.seek(list.get(list.size() - 2).getOffset() + 4);
            randomAccessFile.write(new byte[]{109, 111, 111, 118});
            randomAccessFile.seek(list.get(list.size() - 1).getOffset() + 4);
            randomAccessFile.write(new byte[]{102, 114, 101, 101});
            IOUtils.closeQuietly(randomAccessFile);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            IOUtils.closeQuietly(randomAccessFile2);
            throw th;
        }
    }
}
