package defpackage;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class nc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static long f8056 = -1;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized boolean m7645() {
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f8056 >= 3000) {
            f8056 = jElapsedRealtime;
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
