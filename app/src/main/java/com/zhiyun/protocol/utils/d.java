package com.zhiyun.protocol.utils;

/* loaded from: classes2.dex */
public class d {
    private static byte a = 1;

    public static byte a() {
        byte b = a;
        if (b >= Byte.MAX_VALUE) {
            a = (byte) 1;
            return (byte) 1;
        }
        a = (byte) (b + 1);
        return b;
    }
}
