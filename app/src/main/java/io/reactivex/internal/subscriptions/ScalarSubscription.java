package io.reactivex.internal.subscriptions;

import defpackage.InterfaceC2968;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements InterfaceC2968<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    public final Subscriber<? super T> subscriber;
    public final T value;

    public ScalarSubscription(Subscriber<? super T> subscriber, T t) {
        this.subscriber = subscriber;
        this.value = t;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
        lazySet(1);
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC4851
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            Subscriber<? super T> subscriber = this.subscriber;
            subscriber.onNext(this.value);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }

    @Override // defpackage.InterfaceC3460
    /* renamed from: ԩ */
    public int mo6310(int i) {
        return i & 1;
    }
}
