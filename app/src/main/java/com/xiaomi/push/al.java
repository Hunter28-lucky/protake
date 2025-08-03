package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
class al {
    private static volatile boolean a = false;

    private static void a(Class<?> cls, Context context) {
        if (a) {
            return;
        }
        try {
            a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> clsA = s.a(context, "com.bun.miitmdid.core.JLibrary");
            if (clsA == null) {
                return false;
            }
            a(clsA, context);
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("mdid:check error " + th);
            return false;
        }
    }
}
