package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* compiled from: FutureSubscriber.java */
/* renamed from: Ⴖ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class FutureC5219<T> extends CountDownLatch implements InterfaceC3899<T>, Future<T>, Subscription {

    /* renamed from: ԫ, reason: contains not printable characters */
    public T f17288;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Throwable f17289;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AtomicReference<Subscription> f17290;

    public FutureC5219() {
        super(1);
        this.f17290 = new AtomicReference<>();
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.f17290.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!C4905.m14631(this.f17290, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
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
        Throwable th = this.f17289;
        if (th == null) {
            return this.f17288;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f17290.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription;
        if (this.f17288 == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.f17290.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!C4905.m14631(this.f17290, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = this.f17290.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                C3671.m11803(th);
                return;
            }
            this.f17289 = th;
        } while (!C4905.m14631(this.f17290, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f17288 == null) {
            this.f17288 = t;
        } else {
            this.f17290.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f17290, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
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
            Throwable th = this.f17289;
            if (th == null) {
                return this.f17288;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
