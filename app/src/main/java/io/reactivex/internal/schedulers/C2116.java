package io.reactivex.internal.schedulers;

import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C5290;
import defpackage.CallableC4889;
import defpackage.InterfaceC2806;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* renamed from: io.reactivex.internal.schedulers.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2116 extends AbstractC4585.AbstractC4588 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final ScheduledExecutorService f7665;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public volatile boolean f7666;

    public C2116(ThreadFactory threadFactory) {
        this.f7665 = C5290.m15332(threadFactory);
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        if (this.f7666) {
            return;
        }
        this.f7666 = true;
        this.f7665.shutdownNow();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f7666;
    }

    @Override // defpackage.AbstractC4585.AbstractC4588
    /* renamed from: Ԩ */
    public InterfaceC4478 mo6990(Runnable runnable) {
        return mo6991(runnable, 0L, null);
    }

    @Override // defpackage.AbstractC4585.AbstractC4588
    /* renamed from: ԩ */
    public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f7666 ? EmptyDisposable.INSTANCE : m6995(runnable, j, timeUnit, null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public ScheduledRunnable m6995(Runnable runnable, long j, TimeUnit timeUnit, InterfaceC2806 interfaceC2806) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(C3671.m11805(runnable), interfaceC2806);
        if (interfaceC2806 != null && !interfaceC2806.mo9333(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.m6994(j <= 0 ? this.f7665.submit((Callable) scheduledRunnable) : this.f7665.schedule((Callable) scheduledRunnable, j, timeUnit));
        } catch (RejectedExecutionException e2) {
            if (interfaceC2806 != null) {
                interfaceC2806.mo9334(scheduledRunnable);
            }
            C3671.m11803(e2);
        }
        return scheduledRunnable;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4478 m6996(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(C3671.m11805(runnable));
        try {
            scheduledDirectTask.m6985(j <= 0 ? this.f7665.submit(scheduledDirectTask) : this.f7665.schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            C3671.m11803(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4478 m6997(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable runnableM11805 = C3671.m11805(runnable);
        if (j2 <= 0) {
            CallableC4889 callableC4889 = new CallableC4889(runnableM11805, this.f7665);
            try {
                callableC4889.m14611(j <= 0 ? this.f7665.submit(callableC4889) : this.f7665.schedule(callableC4889, j, timeUnit));
                return callableC4889;
            } catch (RejectedExecutionException e2) {
                C3671.m11803(e2);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableM11805);
        try {
            scheduledDirectPeriodicTask.m6985(this.f7665.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            C3671.m11803(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m6998() {
        if (this.f7666) {
            return;
        }
        this.f7666 = true;
        this.f7665.shutdown();
    }
}
