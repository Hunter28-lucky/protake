package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f6922;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<U> f6923;

    public static final class MainSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 2259811067697317255L;
        public final Subscriber<? super T> downstream;
        public final Publisher<? extends T> main;
        public final MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            public OtherSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.m6424();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.downstream.onError(th);
                } else {
                    C3671.m11803(th);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                Subscription subscription = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    subscription.cancel();
                    MainSubscriber.this.m6424();
                }
            }

            @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                if (SubscriptionHelper.setOnce(this, subscription)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        public MainSubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.downstream = subscriber;
            this.main = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                SubscriptionHelper.deferredRequest(this.upstream, this, j);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6424() {
            this.main.subscribe(this);
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.f6922 = publisher;
        this.f6923 = publisher2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        MainSubscriber mainSubscriber = new MainSubscriber(subscriber, this.f6922);
        subscriber.onSubscribe(mainSubscriber);
        this.f6923.subscribe(mainSubscriber.other);
    }
}
