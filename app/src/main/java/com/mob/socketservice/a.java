package com.mob.socketservice;

/* loaded from: classes2.dex */
public final class a {
    public static void a(int i, byte[] bArr) {
        a(i, bArr, 0);
    }

    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2] = (byte) ((i >> 24) & 255);
    }
}
