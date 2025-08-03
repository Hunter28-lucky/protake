package com.mob.pushsdk.vivo;

import com.mob.pushsdk.vivo.c.d;

/* loaded from: classes2.dex */
public class PushVivo {
    public static void init(String str, String str2) {
        try {
            a.a().a(str, str2);
        } catch (Throwable th) {
            d.a().a(th);
        }
    }

    public static boolean isSupportPush() {
        try {
            return a.a().d();
        } catch (Throwable th) {
            d.a().a(th);
            return false;
        }
    }

    public static void restartPush() {
        try {
            a.a().b();
        } catch (Throwable th) {
            d.a().a(th);
        }
    }

    public static void stopPush() {
        try {
            a.a().c();
        } catch (Throwable th) {
            d.a().a(th);
        }
    }
}
