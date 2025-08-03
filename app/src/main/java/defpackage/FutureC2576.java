package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureSingleObserver.java */
/* renamed from: ɘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class FutureC2576<T> extends CountDownLatch implements InterfaceC4782<T>, Future<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f9585;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f9586;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4478> f9587;

    public FutureC2576() {
        super(1);
        this.f9587 = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC4478 interfaceC4478;
        DisposableHelper disposableHelper;
        do {
            interfaceC4478 = this.f9587.get();
            if (interfaceC4478 == this || interfaceC4478 == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!C4905.m14631(this.f9587, interfaceC4478, disposableHelper));
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
        }
        countDown();
        return true;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            C2336.m8748();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f9586;
        if (th == null) {
            return this.f9585;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f9587.get());
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        InterfaceC4478 interfaceC4478;
        do {
            interfaceC4478 = this.f9587.get();
            if (interfaceC4478 == DisposableHelper.DISPOSED) {
                C3671.m11803(th);
                return;
            }
            this.f9586 = th;
        } while (!C4905.m14631(this.f9587, interfaceC4478, this));
        countDown();
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this.f9587, interfaceC4478);
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        InterfaceC4478 interfaceC4478 = this.f9587.get();
        if (interfaceC4478 == DisposableHelper.DISPOSED) {
            return;
        }
        this.f9585 = t;
        C4905.m14631(this.f9587, interfaceC4478, this);
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            C2336.m8748();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.m7023(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f9586;
            if (th == null) {
                return this.f9585;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
