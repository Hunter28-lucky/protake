package org.jcodec.common;

import androidx.exifinterface.media.ExifInterface;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class Fourcc {
    public static final int ftyp = intFourcc("ftyp");
    public static final int free = intFourcc("free");
    public static final int moov = intFourcc("moov");
    public static final int mdat = intFourcc("mdat");
    public static final int wide = intFourcc("wide");

    public static int intFourcc(String str) {
        byte[] bytes = Platform.getBytes(str);
        return makeInt(bytes[0], bytes[1], bytes[2], bytes[3]);
    }

    public static int makeInt(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & ExifInterface.MARKER) << 16) | ((b3 & ExifInterface.MARKER) << 8) | (b4 & ExifInterface.MARKER);
    }
}
