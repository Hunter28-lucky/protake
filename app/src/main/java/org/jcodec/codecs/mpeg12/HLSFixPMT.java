package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mps.MTSUtils;

/* loaded from: classes2.dex */
public class HLSFixPMT {
    private static void exit(String str) {
        System.err.println("Syntax: hls_fixpmt <hls package location>");
        System.err.println(str);
        System.exit(-1);
    }

    public static void fixPAT(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        MTSUtils.parseSection(byteBuffer);
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        while (byteBuffer.remaining() > 4) {
            short s = byteBuffer.getShort();
            short s2 = byteBuffer.getShort();
            if (s != 0) {
                byteBufferDuplicate2.putShort(s);
                byteBufferDuplicate2.putShort(s2);
            }
        }
        if (byteBufferDuplicate2.position() != byteBuffer.position()) {
            ByteBuffer byteBufferDuplicate3 = byteBufferDuplicate.duplicate();
            byteBufferDuplicate3.get();
            byteBufferDuplicate3.putShort((short) ((((byteBufferDuplicate2.position() - byteBufferDuplicate.position()) + 1) & 4095) | 45056));
            CRC32 crc32 = new CRC32();
            byteBufferDuplicate.limit(byteBufferDuplicate2.position());
            crc32.update(NIOUtils.toArray(byteBufferDuplicate));
            byteBufferDuplicate2.putInt((int) crc32.getValue());
            while (byteBufferDuplicate2.hasRemaining()) {
                byteBufferDuplicate2.put((byte) -1);
            }
        }
    }

    public static void main1(String[] strArr) throws Throwable {
        if (strArr.length < 1) {
            exit("Please specify package location");
        }
        File file = new File(strArr[0]);
        if (!file.isDirectory()) {
            exit("Not an HLS package, expected a folder");
        }
        File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: org.jcodec.codecs.mpeg12.HLSFixPMT.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(".ts");
            }
        });
        HLSFixPMT hLSFixPMT = new HLSFixPMT();
        for (File file2 : fileArrListFiles) {
            System.err.println("Processing: " + file2.getName());
            hLSFixPMT.fix(file2);
        }
    }

    public void fix(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[TsConstants.TS_PACKET_SIZE];
            while (randomAccessFile.read(bArr) == 188) {
                Preconditions.checkState(71 == (bArr[0] & ExifInterface.MARKER));
                int i = ((bArr[1] & ExifInterface.MARKER) << 8) | (bArr[2] & ExifInterface.MARKER);
                int i2 = i & 8191;
                int i3 = (i >> 14) & 1;
                int i4 = ((bArr[3] & ExifInterface.MARKER) & 32) != 0 ? (bArr[4] & ExifInterface.MARKER) + 1 : 0;
                if (i3 == 1) {
                    i4 += (bArr[i4 + 4] & ExifInterface.MARKER) + 1;
                }
                if (i2 == 0) {
                    if (i3 == 0) {
                        throw new RuntimeException("PAT spans multiple TS packets, not supported!!!!!!");
                    }
                    fixPAT(ByteBuffer.wrap(bArr, i4 + 4, 184 - i4));
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - 188);
                    randomAccessFile.write(bArr);
                }
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }
}
