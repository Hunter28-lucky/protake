package org.jcodec.common.tools;

import java.io.File;

/* loaded from: classes2.dex */
public class WavMerge {
    public static void main1(String[] strArr) throws Exception {
        if (strArr.length < 3) {
            System.out.println("wavmerge <output wav> <input wav> .... <input wav>");
            System.exit(-1);
        }
        File file = new File(strArr[0]);
        File[] fileArr = new File[strArr.length - 1];
        for (int i = 1; i < strArr.length; i++) {
            fileArr[i - 1] = new File(strArr[i]);
        }
        merge(file, fileArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r14 = java.nio.ByteBuffer.allocate(r2[0].getFormat().framesToBytes(4096) * r14.length);
        r7 = org.jcodec.codecs.wav.WavHeader.multiChannelWav(r2);
        r13 = org.jcodec.common.io.NIOUtils.writableChannel(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
    
        r7.write(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        r7 = 0;
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        if (r7 >= r3) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
    
        if (r1[r7] == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        r4[r7].clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r1[r7].read(r4[r7]) != (-1)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        org.jcodec.common.io.NIOUtils.closeQuietly(r1[r7]);
        r1[r7] = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        r4[r7].flip();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
    
        if (r8 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        org.jcodec.common.io.IOUtils.closeQuietly(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
    
        if (r6 >= r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        org.jcodec.common.io.IOUtils.closeQuietly(r1[r6]);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009a, code lost:
    
        r14.clear();
        org.jcodec.common.AudioUtil.interleave(r2[0].getFormat(), r4, r14);
        r14.flip();
        r13.write(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ad, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ae, code lost:
    
        r9 = r13;
        r13 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
    
        org.jcodec.common.io.IOUtils.closeQuietly(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b7, code lost:
    
        org.jcodec.common.io.IOUtils.closeQuietly(r1[r6]);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
    
        throw r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void merge(java.io.File r13, java.io.File[] r14) throws java.lang.Throwable {
        /*
            int r0 = r14.length
            java.nio.channels.ReadableByteChannel[] r1 = new java.nio.channels.ReadableByteChannel[r0]
            int r2 = r14.length
            org.jcodec.codecs.wav.WavHeader[] r2 = new org.jcodec.codecs.wav.WavHeader[r2]
            int r3 = r14.length
            java.nio.ByteBuffer[] r4 = new java.nio.ByteBuffer[r3]
            r5 = -1
            r6 = 0
            r8 = r5
            r7 = r6
        Ld:
            r9 = 0
            int r10 = r14.length     // Catch: java.lang.Throwable -> Lb1
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 >= r10) goto L47
            r10 = r14[r7]     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.common.io.FileChannelWrapper r10 = org.jcodec.common.io.NIOUtils.readableChannel(r10)     // Catch: java.lang.Throwable -> Lb1
            r1[r7] = r10     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.codecs.wav.WavHeader r10 = org.jcodec.codecs.wav.WavHeader.readChannel(r10)     // Catch: java.lang.Throwable -> Lb1
            if (r8 == r5) goto L30
            org.jcodec.codecs.wav.WavHeader$FmtChunk r12 = r10.fmt     // Catch: java.lang.Throwable -> Lb1
            short r12 = r12.bitsPerSample     // Catch: java.lang.Throwable -> Lb1
            if (r8 != r12) goto L28
            goto L30
        L28:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r14 = "Input files have different sample sizes"
            r13.<init>(r14)     // Catch: java.lang.Throwable -> Lb1
            throw r13     // Catch: java.lang.Throwable -> Lb1
        L30:
            org.jcodec.codecs.wav.WavHeader$FmtChunk r8 = r10.fmt     // Catch: java.lang.Throwable -> Lb1
            short r8 = r8.bitsPerSample     // Catch: java.lang.Throwable -> Lb1
            r2[r7] = r10     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.common.AudioFormat r10 = r10.getFormat()     // Catch: java.lang.Throwable -> Lb1
            int r10 = r10.framesToBytes(r11)     // Catch: java.lang.Throwable -> Lb1
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.allocate(r10)     // Catch: java.lang.Throwable -> Lb1
            r4[r7] = r10     // Catch: java.lang.Throwable -> Lb1
            int r7 = r7 + 1
            goto Ld
        L47:
            r7 = r2[r6]     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.common.AudioFormat r7 = r7.getFormat()     // Catch: java.lang.Throwable -> Lb1
            int r7 = r7.framesToBytes(r11)     // Catch: java.lang.Throwable -> Lb1
            int r14 = r14.length     // Catch: java.lang.Throwable -> Lb1
            int r7 = r7 * r14
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r7)     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.codecs.wav.WavHeader r7 = org.jcodec.codecs.wav.WavHeader.multiChannelWav(r2)     // Catch: java.lang.Throwable -> Lb1
            org.jcodec.common.io.FileChannelWrapper r13 = org.jcodec.common.io.NIOUtils.writableChannel(r13)     // Catch: java.lang.Throwable -> Lb1
            r7.write(r13)     // Catch: java.lang.Throwable -> Lad
        L62:
            r7 = r6
            r8 = r7
        L64:
            if (r7 >= r3) goto L8a
            r10 = r1[r7]     // Catch: java.lang.Throwable -> Lad
            if (r10 == 0) goto L87
            r10 = r4[r7]     // Catch: java.lang.Throwable -> Lad
            r10.clear()     // Catch: java.lang.Throwable -> Lad
            r10 = r1[r7]     // Catch: java.lang.Throwable -> Lad
            r11 = r4[r7]     // Catch: java.lang.Throwable -> Lad
            int r10 = r10.read(r11)     // Catch: java.lang.Throwable -> Lad
            if (r10 != r5) goto L81
            r10 = r1[r7]     // Catch: java.lang.Throwable -> Lad
            org.jcodec.common.io.NIOUtils.closeQuietly(r10)     // Catch: java.lang.Throwable -> Lad
            r1[r7] = r9     // Catch: java.lang.Throwable -> Lad
            goto L82
        L81:
            r8 = 1
        L82:
            r10 = r4[r7]     // Catch: java.lang.Throwable -> Lad
            r10.flip()     // Catch: java.lang.Throwable -> Lad
        L87:
            int r7 = r7 + 1
            goto L64
        L8a:
            if (r8 != 0) goto L9a
            org.jcodec.common.io.IOUtils.closeQuietly(r13)
        L8f:
            if (r6 >= r0) goto L99
            r13 = r1[r6]
            org.jcodec.common.io.IOUtils.closeQuietly(r13)
            int r6 = r6 + 1
            goto L8f
        L99:
            return
        L9a:
            r14.clear()     // Catch: java.lang.Throwable -> Lad
            r7 = r2[r6]     // Catch: java.lang.Throwable -> Lad
            org.jcodec.common.AudioFormat r7 = r7.getFormat()     // Catch: java.lang.Throwable -> Lad
            org.jcodec.common.AudioUtil.interleave(r7, r4, r14)     // Catch: java.lang.Throwable -> Lad
            r14.flip()     // Catch: java.lang.Throwable -> Lad
            r13.write(r14)     // Catch: java.lang.Throwable -> Lad
            goto L62
        Lad:
            r14 = move-exception
            r9 = r13
            r13 = r14
            goto Lb2
        Lb1:
            r13 = move-exception
        Lb2:
            org.jcodec.common.io.IOUtils.closeQuietly(r9)
        Lb5:
            if (r6 >= r0) goto Lbf
            r14 = r1[r6]
            org.jcodec.common.io.IOUtils.closeQuietly(r14)
            int r6 = r6 + 1
            goto Lb5
        Lbf:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.tools.WavMerge.merge(java.io.File, java.io.File[]):void");
    }
}
