package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class n1 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final long f8040 = w0.m8501("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int f8041 = w0.m8500("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final int f8042;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final int f8043;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final long f8044;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static AbstractC5014 f8045;

    static {
        int iM8500 = w0.m8500("kotlinx.coroutines.scheduler.core.pool.size", C4542.m13943(u0.m8329(), 2), 1, 0, 8, null);
        f8042 = iM8500;
        f8043 = w0.m8500("kotlinx.coroutines.scheduler.max.pool.size", C4542.m13947(u0.m8329() * 128, iM8500, 2097150), 0, 2097150, 4, null);
        f8044 = TimeUnit.SECONDS.toNanos(w0.m8501("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f8045 = C4543.f15562;
    }
}
