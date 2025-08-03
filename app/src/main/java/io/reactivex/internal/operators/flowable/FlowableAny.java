package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4178;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableAny<T> extends AbstractC3232<T, Boolean> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f6859;

    public static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -2311252482644620661L;
        public boolean done;
        public final InterfaceC4178<? super T> predicate;
        public Subscription upstream;

        public AnySubscriber(Subscriber<? super Boolean> subscriber, InterfaceC4178<? super T> interfaceC4178) {
            super(subscriber);
            this.predicate = interfaceC4178;
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
            m7008(Boolean.FALSE);
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
                if (this.predicate.test(t)) {
                    this.done = true;
                    this.upstream.cancel();
                    m7008(Boolean.TRUE);
                }
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

    public FlowableAny(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        super(abstractC3630);
        this.f6859 = interfaceC4178;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new AnySubscriber(subscriber, this.f6859));
    }
}
