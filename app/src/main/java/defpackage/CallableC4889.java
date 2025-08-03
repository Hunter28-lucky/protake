package defpackage;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InstantPeriodicTask.java */
/* renamed from: ถ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class CallableC4889 implements Callable<Void>, InterfaceC4478 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final FutureTask<Void> f16515 = new FutureTask<>(Functions.f6797, null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Runnable f16516;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ExecutorService f16519;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Thread f16520;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<Future<?>> f16518 = new AtomicReference<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<Future<?>> f16517 = new AtomicReference<>();

    public CallableC4889(Runnable runnable, ExecutorService executorService) {
        this.f16516 = runnable;
        this.f16519 = executorService;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f16518;
        FutureTask<Void> futureTask = f16515;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f16520 != Thread.currentThread());
        }
        Future<?> andSet2 = this.f16517.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f16520 != Thread.currentThread());
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f16518.get() == f16515;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        this.f16520 = Thread.currentThread();
        try {
            this.f16516.run();
            m14612(this.f16519.submit(this));
            this.f16520 = null;
        } catch (Throwable th) {
            this.f16520 = null;
            C3671.m11803(th);
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14611(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f16518.get();
            if (future2 == f16515) {
                future.cancel(this.f16520 != Thread.currentThread());
                return;
            }
        } while (!C4905.m14631(this.f16518, future2, future));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m14612(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f16517.get();
            if (future2 == f16515) {
                future.cancel(this.f16520 != Thread.currentThread());
                return;
            }
        } while (!C4905.m14631(this.f16517, future2, future));
    }
}
