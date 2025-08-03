package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC5324;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRetryBiPredicate<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super Integer, ? super Throwable> f7104;

    public static final class RetryBiSubscriber<T> extends AtomicInteger implements InterfaceC3899<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Subscriber<? super T> downstream;
        public final InterfaceC5324<? super Integer, ? super Throwable> predicate;
        public long produced;
        public int retries;
        public final SubscriptionArbiter sa;
        public final Publisher<? extends T> source;

        public RetryBiSubscriber(Subscriber<? super T> subscriber, InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.predicate = interfaceC5324;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324 = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (interfaceC5324.test(Integer.valueOf(i), th)) {
                    m6612();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
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
        public void m6612() {
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

    public FlowableRetryBiPredicate(AbstractC3630<T> abstractC3630, InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324) {
        super(abstractC3630);
        this.f7104 = interfaceC5324;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetryBiSubscriber(subscriber, this.f7104, subscriptionArbiter, this.f11385).m6612();
    }
}
