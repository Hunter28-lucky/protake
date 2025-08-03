package defpackage;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public final class e2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final e2 f6600 = new e2();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final ThreadLocal<AbstractC2333> f6601 = new ThreadLocal<>();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AbstractC2333 m5985() {
        ThreadLocal<AbstractC2333> threadLocal = f6601;
        AbstractC2333 abstractC2333 = threadLocal.get();
        if (abstractC2333 != null) {
            return abstractC2333;
        }
        AbstractC2333 abstractC2333M10195 = C2858.m10195();
        threadLocal.set(abstractC2333M10195);
        return abstractC2333M10195;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m5986() {
        f6601.set(null);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m5987(AbstractC2333 abstractC2333) {
        f6601.set(abstractC2333);
    }
}
