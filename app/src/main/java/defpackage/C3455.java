package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.C2116;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* renamed from: ز, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3455 extends AbstractC4585 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C3457 f11927;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final RxThreadFactory f11928;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final int f11929 = m11279(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C3458 f11930;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ThreadFactory f11931;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final AtomicReference<C3457> f11932;

    /* compiled from: ComputationScheduler.java */
    /* renamed from: ز$Ϳ, reason: contains not printable characters */
    public static final class C3456 extends AbstractC4585.AbstractC4588 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C4465 f11933;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2527 f11934;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C4465 f11935;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final C3458 f11936;

        /* renamed from: ԯ, reason: contains not printable characters */
        public volatile boolean f11937;

        public C3456(C3458 c3458) {
            this.f11936 = c3458;
            C4465 c4465 = new C4465();
            this.f11933 = c4465;
            C2527 c2527 = new C2527();
            this.f11934 = c2527;
            C4465 c44652 = new C4465();
            this.f11935 = c44652;
            c44652.mo9333(c4465);
            c44652.mo9333(c2527);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f11937) {
                return;
            }
            this.f11937 = true;
            this.f11935.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11937;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: Ԩ */
        public InterfaceC4478 mo6990(Runnable runnable) {
            return this.f11937 ? EmptyDisposable.INSTANCE : this.f11936.m6995(runnable, 0L, TimeUnit.MILLISECONDS, this.f11933);
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.f11937 ? EmptyDisposable.INSTANCE : this.f11936.m6995(runnable, j, timeUnit, this.f11934);
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: ز$Ԩ, reason: contains not printable characters */
    public static final class C3457 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f11938;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3458[] f11939;

        /* renamed from: ԩ, reason: contains not printable characters */
        public long f11940;

        public C3457(int i, ThreadFactory threadFactory) {
            this.f11938 = i;
            this.f11939 = new C3458[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f11939[i2] = new C3458(threadFactory);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C3458 m11281() {
            int i = this.f11938;
            if (i == 0) {
                return C3455.f11930;
            }
            C3458[] c3458Arr = this.f11939;
            long j = this.f11940;
            this.f11940 = 1 + j;
            return c3458Arr[(int) (j % i)];
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m11282() {
            for (C3458 c3458 : this.f11939) {
                c3458.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: ز$Ԫ, reason: contains not printable characters */
    public static final class C3458 extends C2116 {
        public C3458(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        C3458 c3458 = new C3458(new RxThreadFactory("RxComputationShutdown"));
        f11930 = c3458;
        c3458.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f11928 = rxThreadFactory;
        C3457 c3457 = new C3457(0, rxThreadFactory);
        f11927 = c3457;
        c3457.m11282();
    }

    public C3455() {
        this(f11928);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m11279(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C3456(this.f11932.get().m11281());
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f11932.get().m11281().m6996(runnable, j, timeUnit);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԫ */
    public InterfaceC4478 mo6989(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f11932.get().m11281().m6997(runnable, j, j2, timeUnit);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԭ */
    public void mo7000() {
        C3457 c3457;
        C3457 c34572;
        do {
            c3457 = this.f11932.get();
            c34572 = f11927;
            if (c3457 == c34572) {
                return;
            }
        } while (!C4905.m14631(this.f11932, c3457, c34572));
        c3457.m11282();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m11280() {
        C3457 c3457 = new C3457(f11929, this.f11931);
        if (C4905.m14631(this.f11932, f11927, c3457)) {
            return;
        }
        c3457.m11282();
    }

    public C3455(ThreadFactory threadFactory) {
        this.f11931 = threadFactory;
        this.f11932 = new AtomicReference<>(f11927);
        m11280();
    }
}
