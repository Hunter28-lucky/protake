package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FutureObserver.java */
/* renamed from: ڬ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class FutureC3572<T> extends CountDownLatch implements InterfaceC5102<T>, Future<T>, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f12449;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f12450;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<InterfaceC4478> f12451;

    public FutureC3572() {
        super(1);
        this.f12451 = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC4478 interfaceC4478;
        DisposableHelper disposableHelper;
        do {
            interfaceC4478 = this.f12451.get();
            if (interfaceC4478 == this || interfaceC4478 == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!C4905.m14631(this.f12451, interfaceC4478, disposableHelper));
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
        Throwable th = this.f12450;
        if (th == null) {
            return this.f12449;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f12451.get());
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        InterfaceC4478 interfaceC4478;
        if (this.f12449 == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            interfaceC4478 = this.f12451.get();
            if (interfaceC4478 == this || interfaceC4478 == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!C4905.m14631(this.f12451, interfaceC4478, this));
        countDown();
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        InterfaceC4478 interfaceC4478;
        if (this.f12450 != null) {
            C3671.m11803(th);
            return;
        }
        this.f12450 = th;
        do {
            interfaceC4478 = this.f12451.get();
            if (interfaceC4478 == this || interfaceC4478 == DisposableHelper.DISPOSED) {
                C3671.m11803(th);
                return;
            }
        } while (!C4905.m14631(this.f12451, interfaceC4478, this));
        countDown();
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.f12449 == null) {
            this.f12449 = t;
        } else {
            this.f12451.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this.f12451, interfaceC4478);
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
            Throwable th = this.f12450;
            if (th == null) {
                return this.f12449;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
