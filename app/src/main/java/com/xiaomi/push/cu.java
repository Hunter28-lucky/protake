package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes2.dex */
public class cu {
    private static cm a;

    /* renamed from: a, reason: collision with other field name */
    private static cn f5691a;

    public static void a(Context context, fb fbVar) {
        if (m5318b(context)) {
            if (a == null) {
                a = new cm(context);
            }
            if (f5691a == null) {
                f5691a = new cn(context);
            }
            cm cmVar = a;
            fbVar.a(cmVar, cmVar);
            cn cnVar = f5691a;
            fbVar.b(cnVar, cnVar);
            a("startStats");
        }
    }

    public static void b(Context context, fb fbVar) {
        cm cmVar = a;
        if (cmVar != null) {
            fbVar.a(cmVar);
            a = null;
        }
        cn cnVar = f5691a;
        if (cnVar != null) {
            fbVar.b(cnVar);
            f5691a = null;
        }
        a("stopStats");
    }

    public static void c(Context context) {
        a("onPing");
        if (m5318b(context)) {
            cx.c(context, System.currentTimeMillis(), m5317a(context));
        }
    }

    public static void d(Context context) {
        a("onPong");
        if (m5318b(context)) {
            cx.d(context, System.currentTimeMillis(), m5317a(context));
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private static boolean m5318b(Context context) {
        return cl.a(context);
    }

    public static void a(Context context) {
        a("onSendMsg");
        if (m5318b(context)) {
            cx.a(context, System.currentTimeMillis(), m5317a(context));
        }
    }

    public static void b(Context context) {
        a("onReceiveMsg");
        if (m5318b(context)) {
            cx.b(context, System.currentTimeMillis(), m5317a(context));
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5317a(Context context) {
        return i.m5684b(context);
    }

    public static void a(String str) {
        cl.a("Push-PowerStats", str);
    }
}
