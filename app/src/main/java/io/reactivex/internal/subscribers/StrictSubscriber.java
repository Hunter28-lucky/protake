package io.reactivex.internal.subscribers;

import defpackage.C4217;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public class StrictSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.done) {
            return;
        }
        SubscriptionHelper.cancel(this.upstream);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.done = true;
        C4217.m13297(this.downstream, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.done = true;
        C4217.m13299(this.downstream, th, this, this.error);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        C4217.m13301(this.downstream, t, this, this.error);
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.once.compareAndSet(false, true)) {
            this.downstream.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (j > 0) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }
}
