package io.reactivex.internal.subscribers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Subscription, InterfaceC4478 {
    private static final long serialVersionUID = -7251123623727029452L;
    public final int bufferSize;
    public int consumed;
    public final int limit;
    public final InterfaceC3809 onComplete;
    public final InterfaceC2857<? super Throwable> onError;
    public final InterfaceC2857<? super T> onNext;
    public final InterfaceC2857<? super Subscription> onSubscribe;

    public BoundedSubscriber(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC2857<? super Subscription> interfaceC28573, int i) {
        this.onNext = interfaceC2857;
        this.onError = interfaceC28572;
        this.onComplete = interfaceC3809;
        this.onSubscribe = interfaceC28573;
        this.bufferSize = i;
        this.limit = i - (i >> 2);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        cancel();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription == subscriptionHelper) {
            C3671.m11803(th);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
            int i = this.consumed + 1;
            if (i == this.limit) {
                this.consumed = 0;
                get().request(this.limit);
            } else {
                this.consumed = i;
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        get().request(j);
    }
}
