package com.zhiyun.protocol.utils;

/* loaded from: classes2.dex */
public class Arrays {
    public static byte[] a(byte[] bArr, byte[]... bArr2) {
        int length = bArr.length;
        for (byte[] bArr3 : bArr2) {
            length += bArr3.length;
        }
        byte[] bArrCopyOf = java.util.Arrays.copyOf(bArr, length);
        int length2 = bArr.length;
        for (byte[] bArr4 : bArr2) {
            System.arraycopy(bArr4, 0, bArrCopyOf, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArrCopyOf;
    }

    public static byte[] concatBytes(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, bArr2, bArr3);
    }

    public static byte[] sub(byte[] bArr, int i, int i2) {
        return java.util.Arrays.copyOfRange(bArr, i, i2 + i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return java.util.Arrays.copyOfRange(bArr, i, bArr.length);
    }
}
