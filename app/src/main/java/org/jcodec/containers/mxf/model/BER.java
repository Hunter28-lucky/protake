package org.jcodec.containers.mxf.model;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class BER {
    public static final byte ASN_LONG_LEN = Byte.MIN_VALUE;

    public static final long decodeLength(SeekableByteChannel seekableByteChannel) throws IOException {
        int i = NIOUtils.readByte(seekableByteChannel) & ExifInterface.MARKER;
        if ((i & (-128)) <= 0) {
            return i & 255;
        }
        int i2 = i & 127;
        if (i2 == 0) {
            throw new IOException("Indefinite lengths are not supported");
        }
        if (i2 > 8) {
            throw new IOException("Data length > 4 bytes are not supported!");
        }
        byte[] nByte = NIOUtils.readNByte(seekableByteChannel, i2);
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j = (j << 8) | (nByte[i3] & ExifInterface.MARKER);
        }
        if (j >= 0) {
            return j;
        }
        throw new IOException("mxflib does not support data lengths > 2^63");
    }

    public static long decodeLengthBuf(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & ExifInterface.MARKER;
        if ((i & (-128)) <= 0) {
            return i & 255;
        }
        int i2 = i & 127;
        if (i2 == 0) {
            throw new RuntimeException("Indefinite lengths are not supported");
        }
        if (i2 > 8) {
            throw new RuntimeException("Data length > 8 bytes are not supported!");
        }
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j = (j << 8) | (byteBuffer.get() & ExifInterface.MARKER);
        }
        if (j >= 0) {
            return j;
        }
        throw new RuntimeException("mxflib does not support data lengths > 2^63");
    }
}
