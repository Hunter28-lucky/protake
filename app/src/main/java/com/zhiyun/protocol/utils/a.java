package com.zhiyun.protocol.utils;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;

/* loaded from: classes2.dex */
public class a {
    private static byte a(byte b, byte b2) {
        return (byte) ((b & ExifInterface.MARKER) | (b2 & ExifInterface.MARKER));
    }

    public static byte a(int i) {
        return (byte) i;
    }

    public static byte[] a(byte b, boolean z) {
        byte b2 = (byte) ((b & 240) >> 4);
        byte b3 = (byte) (b & cb.m);
        byte[] bArr = new byte[2];
        bArr[0] = z ? b2 : b3;
        if (z) {
            b2 = b3;
        }
        bArr[1] = b2;
        return bArr;
    }

    public static byte[] a(int i, int i2, boolean z) {
        if (i2 > 4 || i2 < 1) {
            throw new IllegalArgumentException("bit must be between 1~4 !!!");
        }
        byte bA = a(i);
        byte b = b(i);
        byte bC = c(i);
        byte bD = d(i);
        byte[] bArr = new byte[i2];
        if (z) {
            if (i2 == 1) {
                bArr[0] = bA;
            } else if (i2 == 2) {
                bArr[0] = b;
                bArr[1] = bA;
            } else if (i2 == 3) {
                bArr[0] = bC;
                bArr[1] = b;
                bArr[2] = bA;
            } else if (i2 == 4) {
                bArr[0] = bD;
                bArr[1] = bC;
                bArr[2] = b;
                bArr[3] = bA;
            }
        } else if (i2 == 1) {
            bArr[0] = bA;
        } else if (i2 == 2) {
            bArr[0] = bA;
            bArr[1] = b;
        } else if (i2 == 3) {
            bArr[0] = bA;
            bArr[1] = b;
            bArr[2] = bC;
        } else if (i2 == 4) {
            bArr[0] = bA;
            bArr[1] = b;
            bArr[2] = bC;
            bArr[3] = bD;
        }
        return bArr;
    }

    public static byte b(int i) {
        return (byte) (i >> 8);
    }

    private static int b(byte b, byte b2) {
        return ((b & ExifInterface.MARKER) << 8) | (b2 & ExifInterface.MARKER);
    }

    public static short b(byte b, byte b2, boolean z) {
        return z ? c(b, b2) : c(b2, b);
    }

    public static byte c(int i) {
        return (byte) (i >> 16);
    }

    private static short c(byte b, byte b2) {
        return (short) ((b << 8) | (b2 & ExifInterface.MARKER));
    }

    public static byte d(int i) {
        return (byte) (i >> 24);
    }

    public static int a(byte b, byte b2, boolean z) {
        return z ? b(b, b2) : b(b2, b);
    }

    public static byte a(byte b, byte b2, boolean z, boolean z2) {
        byte b3 = z ? (byte) 4 : (byte) 0;
        return z2 ? a((byte) (b << b3), b2) : a((byte) (b2 << b3), b);
    }
}
