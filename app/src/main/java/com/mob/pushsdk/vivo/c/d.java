package com.mob.pushsdk.vivo.c;

import com.mob.tools.log.NLog;

/* loaded from: classes2.dex */
public class d {
    private static d b;
    private NLog a;
    private final int c = -1;

    private d() {
        b();
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    private void b() {
        try {
            c();
        } catch (Throwable unused) {
        }
    }

    private void c() {
        try {
            this.a = NLog.getInstance("MobPush-VIVO");
        } catch (Throwable unused) {
        }
    }

    public final int b(Throwable th) {
        try {
            if (a.b(this.a)) {
                return this.a.log(6, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int b(Object obj, Object... objArr) {
        try {
            if (a.b(this.a)) {
                return this.a.log(6, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Throwable th) {
        try {
            if (a.b(this.a)) {
                return this.a.log(3, th);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(Object obj, Object... objArr) {
        try {
            if (a.b(this.a)) {
                return this.a.log(3, obj, objArr);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int a(String str) {
        try {
            if (a.b(this.a)) {
                return this.a.log(4, str, new Object[0]);
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
