package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4178;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRetryPredicate<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super Throwable> f7105;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7106;

    public static final class RetrySubscriber<T> extends AtomicInteger implements InterfaceC3899<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Subscriber<? super T> downstream;
        public final InterfaceC4178<? super Throwable> predicate;
        public long produced;
        public long remaining;
        public final SubscriptionArbiter sa;
        public final Publisher<? extends T> source;

        public RetrySubscriber(Subscriber<? super T> subscriber, long j, InterfaceC4178<? super Throwable> interfaceC4178, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.predicate = interfaceC4178;
            this.remaining = j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
                    m6613();
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
        public void m6613() {
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

    public FlowableRetryPredicate(AbstractC3630<T> abstractC3630, long j, InterfaceC4178<? super Throwable> interfaceC4178) {
        super(abstractC3630);
        this.f7105 = interfaceC4178;
        this.f7106 = j;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.f7106, this.f7105, subscriptionArbiter, this.f11385).m6613();
    }
}
