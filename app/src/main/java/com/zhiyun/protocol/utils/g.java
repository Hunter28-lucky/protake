package com.zhiyun.protocol.utils;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class g {
    static {
        Charset.forName("utf-8");
    }

    public static boolean a(String str) {
        return (str == null || "".equals(str)) ? false : true;
    }
}
