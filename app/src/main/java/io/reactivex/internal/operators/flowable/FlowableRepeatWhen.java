package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2892;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4056;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRepeatWhen<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super AbstractC3630<Object>, ? extends Publisher<?>> f7083;

    public static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RepeatWhenSubscriber(Subscriber<? super T> subscriber, AbstractC2892<Object> abstractC2892, Subscription subscription) {
            super(subscriber, abstractC2892, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            m6584(0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.receiver.cancel();
            this.downstream.onError(th);
        }
    }

    public static final class WhenReceiver<T, U> extends AtomicInteger implements InterfaceC3899<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;
        public final Publisher<T> source;
        public WhenSourceSubscriber<T, U> subscriber;
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public WhenReceiver(Publisher<T> publisher) {
            this.source = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.subscriber.cancel();
            this.subscriber.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.subscriber.cancel();
            this.subscriber.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.upstream.get() != SubscriptionHelper.CANCELLED) {
                    this.source.subscribe(this.subscriber);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }
    }

    public static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements InterfaceC3899<T> {
        private static final long serialVersionUID = -5604623027276966720L;
        public final Subscriber<? super T> downstream;
        public final AbstractC2892<U> processor;
        private long produced;
        public final Subscription receiver;

        public WhenSourceSubscriber(Subscriber<? super T> subscriber, AbstractC2892<U> abstractC2892, Subscription subscription) {
            super(false);
            this.downstream = subscriber;
            this.processor = abstractC2892;
            this.receiver = subscription;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.receiver.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            m7015(subscription);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final void m6584(U u) {
            m7015(EmptySubscription.INSTANCE);
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                m7014(j);
            }
            this.receiver.request(1L);
            this.processor.onNext(u);
        }
    }

    public FlowableRepeatWhen(AbstractC3630<T> abstractC3630, InterfaceC2368<? super AbstractC3630<Object>, ? extends Publisher<?>> interfaceC2368) {
        super(abstractC3630);
        this.f7083 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        AbstractC2892<T> abstractC2892M10260 = UnicastProcessor.m7027(8).m10260();
        try {
            Publisher publisher = (Publisher) C4246.m13353(this.f7083.apply(abstractC2892M10260), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.f11385);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(c4056, abstractC2892M10260, whenReceiver);
            whenReceiver.subscriber = repeatWhenSubscriber;
            subscriber.onSubscribe(repeatWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
