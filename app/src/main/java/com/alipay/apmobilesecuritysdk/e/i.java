package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import defpackage.ua;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";

    /* renamed from: e, reason: collision with root package name */
    public static String f17634e = "";
    public static Map<String, String> f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f.containsKey(str2)) {
            String str3 = f.get(str2);
            if (ua.m8373(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized void a() {
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            a = bVar.a;
            b = bVar.b;
            c = bVar.c;
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            a = cVar.a;
            b = cVar.b;
            d = cVar.d;
            f17634e = cVar.f17632e;
            c = cVar.c;
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f.containsKey(str3)) {
            f.remove(str3);
        }
        f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long jA;
        boolean z;
        try {
            jA = h.a(context);
        } catch (Throwable unused) {
        }
        if (jA < 0) {
            jA = 86400000;
        }
        try {
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        z = Math.abs(System.currentTimeMillis() - h.h(context, str)) < jA;
        return z;
    }

    public static synchronized String b() {
        return a;
    }

    public static void b(String str) {
        a = str;
    }

    public static synchronized String c() {
        return b;
    }

    public static void c(String str) {
        b = str;
    }

    public static synchronized String d() {
        return d;
    }

    public static void d(String str) {
        c = str;
    }

    public static synchronized String e() {
        return f17634e;
    }

    public static void e(String str) {
        d = str;
    }

    public static synchronized String f() {
        return c;
    }

    public static void f(String str) {
        f17634e = str;
    }

    public static synchronized c g() {
        return new c(a, b, c, d, f17634e);
    }

    public static void h() {
        f.clear();
        a = "";
        b = "";
        d = "";
        f17634e = "";
        c = "";
    }
}
