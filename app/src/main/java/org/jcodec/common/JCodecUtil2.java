package org.jcodec.common;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class JCodecUtil2 {
    public static byte[] asciiString(String str) {
        return Platform.getBytes(str);
    }

    public static int[] getAsIntArray(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        int[] iArr = new int[i];
        byteBuffer.get(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = bArr[i2] & ExifInterface.MARKER;
        }
        return iArr;
    }

    public static int readBER32(ByteBuffer byteBuffer) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = byteBuffer.get();
            i = (i << 7) | (b & Byte.MAX_VALUE);
            if (((b & ExifInterface.MARKER) >> 7) == 0) {
                break;
            }
        }
        return i;
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\.[^\\.]+$", "");
    }

    public static void writeBER32(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >> 21) | 128));
        byteBuffer.put((byte) ((i >> 14) | 128));
        byteBuffer.put((byte) ((i >> 7) | 128));
        byteBuffer.put((byte) (i & 127));
    }

    public static void writeBER32Var(ByteBuffer byteBuffer, int i) {
        int iLog2 = MathUtil.log2(i);
        for (int i2 = 0; i2 < 4 && iLog2 > 0; i2++) {
            iLog2 -= 7;
            int i3 = i >> iLog2;
            if (iLog2 > 0) {
                i3 |= 128;
            }
            byteBuffer.put((byte) i3);
        }
    }
}
