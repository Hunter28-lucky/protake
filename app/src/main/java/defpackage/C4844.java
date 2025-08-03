package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.schedulers.C2116;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;

/* compiled from: NewThreadScheduler.java */
/* renamed from: ර, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4844 extends AbstractC4585 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final RxThreadFactory f16354 = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ThreadFactory f16355;

    public C4844() {
        this(f16354);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C2116(this.f16355);
    }

    public C4844(ThreadFactory threadFactory) {
        this.f16355 = threadFactory;
    }
}
