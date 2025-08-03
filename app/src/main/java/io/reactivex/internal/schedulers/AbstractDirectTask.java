package io.reactivex.internal.schedulers;

import defpackage.InterfaceC4478;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements InterfaceC4478 {
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final FutureTask<Void> f7645;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final FutureTask<Void> f7646;
    public final Runnable runnable;
    public Thread runner;

    static {
        Runnable runnable = Functions.f6797;
        f7645 = new FutureTask<>(runnable, null);
        f7646 = new FutureTask<>(runnable, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f7645 || future == (futureTask = f7646) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.runner != Thread.currentThread());
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == f7645 || future == f7646;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m6985(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f7645) {
                return;
            }
            if (future2 == f7646) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
