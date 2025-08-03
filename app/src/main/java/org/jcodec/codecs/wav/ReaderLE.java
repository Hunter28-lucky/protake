package org.jcodec.codecs.wav;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class ReaderLE {
    public static int readInt(InputStream inputStream) throws IOException {
        long j = inputStream.read();
        long j2 = inputStream.read();
        long j3 = inputStream.read();
        long j4 = inputStream.read();
        if (j4 == -1 || j3 == -1 || j2 == -1 || j == -1) {
            return -1;
        }
        return (int) ((j4 << 24) + (j3 << 16) + (j2 << 8) + j);
    }

    public static long readLong(InputStream inputStream) throws IOException {
        long j = inputStream.read();
        long j2 = inputStream.read();
        long j3 = inputStream.read();
        long j4 = inputStream.read();
        long j5 = inputStream.read();
        long j6 = inputStream.read();
        long j7 = inputStream.read();
        if (inputStream.read() == -1 || j7 == -1 || j6 == -1 || j5 == -1 || j4 == -1 || j3 == -1 || j2 == -1 || j == -1) {
            return -1L;
        }
        return (int) ((r14 << 56) + (j7 << 48) + (j6 << 40) + (j5 << 32) + (j4 << 24) + (j3 << 16) + (j2 << 8) + j);
    }

    public static short readShort(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        int i2 = inputStream.read();
        if (i2 == -1 || i == -1) {
            return (short) -1;
        }
        return (short) ((i2 << 8) + i);
    }
}
