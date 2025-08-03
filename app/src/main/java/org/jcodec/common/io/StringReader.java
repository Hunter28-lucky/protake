package org.jcodec.common.io;

import java.io.IOException;
import java.io.InputStream;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public abstract class StringReader {
    public static byte[] _sureRead(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        if (sureRead(inputStream, bArr, i) == i) {
            return bArr;
        }
        return null;
    }

    public static String readString(InputStream inputStream, int i) throws IOException {
        byte[] bArr_sureRead = _sureRead(inputStream, i);
        if (bArr_sureRead == null) {
            return null;
        }
        return Platform.stringFromBytes(bArr_sureRead);
    }

    public static int sureRead(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 == -1) {
                break;
            }
            i2 += i3;
        }
        return i2;
    }

    public static void sureSkip(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            j -= inputStream.skip(j);
        }
    }
}
