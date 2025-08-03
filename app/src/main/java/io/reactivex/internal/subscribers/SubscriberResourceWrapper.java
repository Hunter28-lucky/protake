package io.reactivex.internal.subscribers;

import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<InterfaceC4478> implements InterfaceC3899<T>, InterfaceC4478, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    public final Subscriber<? super T> downstream;
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            this.downstream.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.upstream.get().request(j);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m7007(InterfaceC4478 interfaceC4478) {
        DisposableHelper.set(this, interfaceC4478);
    }
}
