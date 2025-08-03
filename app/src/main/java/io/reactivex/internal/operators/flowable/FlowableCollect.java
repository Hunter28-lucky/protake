package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC5246;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCollect<T, U> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends U> f6886;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5246<? super U, ? super T> f6887;

    public static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        public final InterfaceC5246<? super U, ? super T> collector;
        public boolean done;
        public final U u;
        public Subscription upstream;

        public CollectSubscriber(Subscriber<? super U> subscriber, U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
            super(subscriber);
            this.collector = interfaceC5246;
            this.u = u;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m7008(this.u);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.collector.accept(this.u, t);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollect(AbstractC3630<T> abstractC3630, Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        super(abstractC3630);
        this.f6886 = callable;
        this.f6887 = interfaceC5246;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.f11385.subscribe((InterfaceC3899) new CollectSubscriber(subscriber, C4246.m13353(this.f6886.call(), "The initial value supplied is null"), this.f6887));
        } catch (Throwable th) {
            EmptySubscription.error(th, subscriber);
        }
    }
}
