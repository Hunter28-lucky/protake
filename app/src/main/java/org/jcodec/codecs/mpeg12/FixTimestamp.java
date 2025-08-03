package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.containers.mps.MTSUtils;

/* loaded from: classes2.dex */
public abstract class FixTimestamp {
    /* JADX INFO: Access modifiers changed from: private */
    public boolean processPacket(boolean z, ByteBuffer byteBuffer, boolean z2, ByteBuffer byteBuffer2) {
        int i;
        if (z && !z2 && ((i = byteBuffer.getInt()) == 445 || (i >= 448 && i < 495))) {
            byteBuffer.getShort();
            int i2 = byteBuffer.get() & ExifInterface.MARKER;
            byteBuffer.position(byteBuffer.position() - 1);
            if ((i2 & 192) == 128) {
                fixMpeg2(i & 255, byteBuffer);
            } else {
                fixMpeg1(i & 255, byteBuffer);
            }
        }
        return true;
    }

    public abstract long doWithTimestamp(int i, long j, boolean z);

    public void fix(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                new MTSUtils.TSReader(true) { // from class: org.jcodec.codecs.mpeg12.FixTimestamp.1
                    @Override // org.jcodec.containers.mps.MTSUtils.TSReader
                    public boolean onPkt(int i, boolean z, ByteBuffer byteBuffer, long j, boolean z2, ByteBuffer byteBuffer2) {
                        return this.processPacket(z, byteBuffer, z2, byteBuffer2);
                    }
                }.readTsFile(new FileChannelWrapper(randomAccessFile2.getChannel()));
                randomAccessFile2.close();
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void fixMpeg1(int i, ByteBuffer byteBuffer) {
        int i2;
        int i3 = byteBuffer.getInt();
        while (true) {
            i2 = i3 & 255;
            if (i2 != 255) {
                break;
            } else {
                i3 = byteBuffer.get();
            }
        }
        if ((i2 & 192) == 64) {
            byteBuffer.get();
            i2 = byteBuffer.get() & ExifInterface.MARKER;
        }
        int i4 = i2 & 240;
        if (i4 == 32) {
            byteBuffer.position(byteBuffer.position() - 1);
            fixTs(i, byteBuffer, true);
        } else if (i4 != 48) {
            if (i2 != 15) {
                throw new RuntimeException("Invalid data");
            }
        } else {
            byteBuffer.position(byteBuffer.position() - 1);
            fixTs(i, byteBuffer, true);
            fixTs(i, byteBuffer, false);
        }
    }

    public void fixMpeg2(int i, ByteBuffer byteBuffer) {
        byteBuffer.get();
        int i2 = byteBuffer.get() & ExifInterface.MARKER;
        byteBuffer.get();
        int i3 = i2 & 192;
        if (i3 == 128) {
            fixTs(i, byteBuffer, true);
        } else if (i3 == 192) {
            fixTs(i, byteBuffer, true);
            fixTs(i, byteBuffer, false);
        }
    }

    public long fixTs(int i, ByteBuffer byteBuffer, boolean z) {
        long jDoWithTimestamp = doWithTimestamp(i, ((byteBuffer.get() & 14) << 29) | ((byteBuffer.get() & ExifInterface.MARKER) << 22) | (((byteBuffer.get() & ExifInterface.MARKER) >> 1) << 15) | ((byteBuffer.get() & ExifInterface.MARKER) << 7) | ((byteBuffer.get() & ExifInterface.MARKER) >> 1), z);
        byteBuffer.position(byteBuffer.position() - 5);
        byteBuffer.put((byte) ((r0 & 240) | (jDoWithTimestamp >>> 29) | 1));
        byteBuffer.put((byte) (jDoWithTimestamp >>> 22));
        byteBuffer.put((byte) ((jDoWithTimestamp >>> 14) | 1));
        byteBuffer.put((byte) (jDoWithTimestamp >>> 7));
        byteBuffer.put((byte) ((jDoWithTimestamp << 1) | 1));
        return jDoWithTimestamp;
    }

    public boolean isAudio(int i) {
        return i >= 191 && i <= 223;
    }

    public boolean isVideo(int i) {
        return i >= 224 && i <= 239;
    }
}
