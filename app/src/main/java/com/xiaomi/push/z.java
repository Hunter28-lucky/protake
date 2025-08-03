package com.xiaomi.push;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes2.dex */
public class z {
    public static int a(byte[] bArr) {
        if (bArr.length != 4) {
            throw new IllegalArgumentException("the length of bytes must be 4");
        }
        return (bArr[3] & ExifInterface.MARKER) | 0 | ((bArr[0] & ExifInterface.MARKER) << 24) | ((bArr[1] & ExifInterface.MARKER) << 16) | ((bArr[2] & ExifInterface.MARKER) << 8);
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }
}
