package io.reactivex.internal.schedulers;

import defpackage.AbstractC4585;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C5290;
import defpackage.CallableC4889;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* renamed from: io.reactivex.internal.schedulers.Ԩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2117 extends AbstractC4585 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final RxThreadFactory f7667;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final ScheduledExecutorService f7668;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ThreadFactory f7669;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final AtomicReference<ScheduledExecutorService> f7670;

    /* compiled from: SingleScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.Ԩ$Ϳ, reason: contains not printable characters */
    public static final class C2118 extends AbstractC4585.AbstractC4588 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final ScheduledExecutorService f7671;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2527 f7672 = new C2527();

        /* renamed from: ԭ, reason: contains not printable characters */
        public volatile boolean f7673;

        public C2118(ScheduledExecutorService scheduledExecutorService) {
            this.f7671 = scheduledExecutorService;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f7673) {
                return;
            }
            this.f7673 = true;
            this.f7672.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7673;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f7673) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(C3671.m11805(runnable), this.f7672);
            this.f7672.mo9333(scheduledRunnable);
            try {
                scheduledRunnable.m6994(j <= 0 ? this.f7671.submit((Callable) scheduledRunnable) : this.f7671.schedule((Callable) scheduledRunnable, j, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e2) {
                dispose();
                C3671.m11803(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f7668 = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f7667 = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public C2117() {
        this(f7667);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static ScheduledExecutorService m6999(ThreadFactory threadFactory) {
        return C5290.m15332(threadFactory);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C2118(this.f7670.get());
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(C3671.m11805(runnable));
        try {
            scheduledDirectTask.m6985(j <= 0 ? this.f7670.get().submit(scheduledDirectTask) : this.f7670.get().schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            C3671.m11803(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԫ */
    public InterfaceC4478 mo6989(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableM11805 = C3671.m11805(runnable);
        if (j2 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableM11805);
            try {
                scheduledDirectPeriodicTask.m6985(this.f7670.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e2) {
                C3671.m11803(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = this.f7670.get();
        CallableC4889 callableC4889 = new CallableC4889(runnableM11805, scheduledExecutorService);
        try {
            callableC4889.m14611(j <= 0 ? scheduledExecutorService.submit(callableC4889) : scheduledExecutorService.schedule(callableC4889, j, timeUnit));
            return callableC4889;
        } catch (RejectedExecutionException e3) {
            C3671.m11803(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԭ, reason: contains not printable characters */
    public void mo7000() {
        ScheduledExecutorService andSet;
        ScheduledExecutorService scheduledExecutorService = this.f7670.get();
        ScheduledExecutorService scheduledExecutorService2 = f7668;
        if (scheduledExecutorService == scheduledExecutorService2 || (andSet = this.f7670.getAndSet(scheduledExecutorService2)) == scheduledExecutorService2) {
            return;
        }
        andSet.shutdownNow();
    }

    public C2117(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f7670 = atomicReference;
        this.f7669 = threadFactory;
        atomicReference.lazySet(m6999(threadFactory));
    }
}
