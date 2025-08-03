package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRepeat<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7081;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements InterfaceC3899<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Subscriber<? super T> downstream;
        public long produced;
        public long remaining;
        public final SubscriptionArbiter sa;
        public final Publisher<? extends T> source;

        public RepeatSubscriber(Subscriber<? super T> subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.remaining = j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                m6582();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.sa.m7015(subscription);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6582() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sa.m7012()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0L;
                        this.sa.m7014(j);
                    }
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public FlowableRepeat(AbstractC3630<T> abstractC3630, long j) {
        super(abstractC3630);
        this.f7081 = j;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        long j = this.f7081;
        new RepeatSubscriber(subscriber, j != Long.MAX_VALUE ? j - 1 : Long.MAX_VALUE, subscriptionArbiter, this.f11385).m6582();
    }
}
