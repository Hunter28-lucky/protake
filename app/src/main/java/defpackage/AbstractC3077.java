package defpackage;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.AbstractC2162;
import kotlinx.coroutines.RunnableC2161;

/* compiled from: EventLoop.kt */
/* renamed from: ҭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3077 extends AbstractC2333 {
    /* renamed from: ކ */
    public abstract Thread mo7434();

    /* renamed from: އ, reason: contains not printable characters */
    public final void m10645(long j, AbstractC2162.AbstractRunnableC2163 abstractRunnableC2163) {
        RunnableC2161.f7926.m7450(j, abstractRunnableC2163);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m10646() {
        Thread threadMo7434 = mo7434();
        if (Thread.currentThread() != threadMo7434) {
            C3782.m12100();
            LockSupport.unpark(threadMo7434);
        }
    }
}
