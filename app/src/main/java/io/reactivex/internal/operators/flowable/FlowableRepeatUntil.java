package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.InterfaceC2881;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRepeatUntil<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2881 f7082;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements InterfaceC3899<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final Subscriber<? super T> downstream;
        public long produced;
        public final SubscriptionArbiter sa;
        public final Publisher<? extends T> source;
        public final InterfaceC2881 stop;

        public RepeatSubscriber(Subscriber<? super T> subscriber, InterfaceC2881 interfaceC2881, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.sa = subscriptionArbiter;
            this.source = publisher;
            this.stop = interfaceC2881;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                if (this.stop.mo6378()) {
                    this.downstream.onComplete();
                } else {
                    m6583();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
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
        public void m6583() {
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

    public FlowableRepeatUntil(AbstractC3630<T> abstractC3630, InterfaceC2881 interfaceC2881) {
        super(abstractC3630);
        this.f7082 = interfaceC2881;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.f7082, subscriptionArbiter, this.f11385).m6583();
    }
}
