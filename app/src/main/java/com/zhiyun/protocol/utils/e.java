package com.zhiyun.protocol.utils;

/* loaded from: classes2.dex */
public class e {
    public static int a(int i) {
        return (i >>> 8) & 15;
    }

    public static int a(int i, int i2, int i3) {
        return ((i >> 4) << 12) | ((i2 & 15) << 8) | i3;
    }

    public static int b(int i) {
        return (i >>> 8) & 240;
    }

    public static int c(int i) {
        return i & 255;
    }
}
