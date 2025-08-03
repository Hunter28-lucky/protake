package defpackage;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* renamed from: ม, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4904 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final double f16559 = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static double m14629(long j) {
        return (m14630() - j) * f16559;
    }

    @TargetApi(17)
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static long m14630() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
