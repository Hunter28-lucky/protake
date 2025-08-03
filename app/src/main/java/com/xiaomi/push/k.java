package com.xiaomi.push;

import android.os.Build;

/* loaded from: classes2.dex */
public class k {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static String f6314a;

    public static synchronized String a() {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - a) > 86400000) {
            a = jCurrentTimeMillis;
            f6314a = Build.MODEL;
        }
        str = f6314a;
        if (str == null) {
            str = "";
        }
        return str;
    }
}
