package defpackage;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolManager.java */
/* renamed from: ݷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3768 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C3768 f13004;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f13005;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f13006;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f13007;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4726 f13008;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4726 f13009;

    public C3768() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f13005 = iAvailableProcessors;
        this.f13006 = iAvailableProcessors + (-1) > 0 ? iAvailableProcessors - 1 : 1;
        this.f13007 = (iAvailableProcessors * 2) + 1;
        int i = this.f13006;
        int i2 = this.f13007;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f13008 = new C4726(i, i2, 0L, timeUnit, new PriorityBlockingQueue());
        this.f13009 = new C4726(1, 1, 0L, timeUnit, new PriorityBlockingQueue());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m12063(AbstractRunnableC4803 abstractRunnableC4803) {
        m12065().m12066().execute(abstractRunnableC4803);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m12064(AbstractRunnableC4803 abstractRunnableC4803) {
        m12065().m12067().execute(abstractRunnableC4803);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C3768 m12065() {
        if (f13004 == null) {
            f13004 = new C3768();
        }
        return f13004;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4726 m12066() {
        if (this.f13008 == null) {
            this.f13008 = new C4726(this.f13006, this.f13007, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue());
        }
        return this.f13008;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4726 m12067() {
        if (this.f13009 == null) {
            this.f13009 = new C4726(1, 1, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue());
        }
        return this.f13009;
    }
}
