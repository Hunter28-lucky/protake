package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC2892;
import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4056;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.UnicastProcessor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRetryWhen<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super AbstractC3630<Throwable>, ? extends Publisher<?>> f7107;

    public static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        public RetryWhenSubscriber(Subscriber<? super T> subscriber, AbstractC2892<Throwable> abstractC2892, Subscription subscription) {
            super(subscriber, abstractC2892, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            m6584(th);
        }
    }

    public FlowableRetryWhen(AbstractC3630<T> abstractC3630, InterfaceC2368<? super AbstractC3630<Throwable>, ? extends Publisher<?>> interfaceC2368) {
        super(abstractC3630);
        this.f7107 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        AbstractC2892<T> abstractC2892M10260 = UnicastProcessor.m7027(8).m10260();
        try {
            Publisher publisher = (Publisher) C4246.m13353(this.f7107.apply(abstractC2892M10260), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.f11385);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(c4056, abstractC2892M10260, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            subscriber.onSubscribe(retryWhenSubscriber);
            publisher.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
