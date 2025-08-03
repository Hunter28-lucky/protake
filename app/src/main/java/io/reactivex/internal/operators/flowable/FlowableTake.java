package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTake<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7143;

    public static final class TakeSubscriber<T> extends AtomicBoolean implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        public boolean done;
        public final Subscriber<? super T> downstream;
        public final long limit;
        public long remaining;
        public Subscription upstream;

        public TakeSubscriber(Subscriber<? super T> subscriber, long j) {
            this.downstream = subscriber;
            this.limit = j;
            this.remaining = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.remaining;
            long j2 = j - 1;
            this.remaining = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.downstream.onNext(t);
                if (z) {
                    this.upstream.cancel();
                    onComplete();
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (this.limit != 0) {
                    this.downstream.onSubscribe(this);
                    return;
                }
                subscription.cancel();
                this.done = true;
                EmptySubscription.complete(this.downstream);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() || !compareAndSet(false, true) || j < this.limit) {
                    this.upstream.request(j);
                } else {
                    this.upstream.request(Long.MAX_VALUE);
                }
            }
        }
    }

    public FlowableTake(AbstractC3630<T> abstractC3630, long j) {
        super(abstractC3630);
        this.f7143 = j;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new TakeSubscriber(subscriber, this.f7143));
    }
}
