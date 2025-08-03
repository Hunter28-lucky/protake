package defpackage;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes.dex */
public class vd {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static xc f8697 = null;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f8698 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized String m8491(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        m8492(context);
        xc xcVar = f8697;
        if (xcVar != null) {
            try {
                return xcVar.a(context);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8492(Context context) {
        if (f8697 != null || f8698) {
            return;
        }
        synchronized (vd.class) {
            if (f8697 == null && !f8698) {
                f8697 = gb.m6086(context);
                f8698 = true;
            }
        }
    }
}
