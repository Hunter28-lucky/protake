package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4217;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTakeUntil<T, U> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends U> f7151;

    public static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;
        public final Subscriber<? super T> downstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class OtherSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            public OtherSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                C4217.m13297(takeUntilMainSubscriber.downstream, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                SubscriptionHelper.cancel(TakeUntilMainSubscriber.this.upstream);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                C4217.m13299(takeUntilMainSubscriber.downstream, th, takeUntilMainSubscriber, takeUntilMainSubscriber.error);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            C4217.m13297(this.downstream, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            C4217.m13299(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            C4217.m13301(this.downstream, t, this, this.error);
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

    public FlowableTakeUntil(AbstractC3630<T> abstractC3630, Publisher<? extends U> publisher) {
        super(abstractC3630);
        this.f7151 = publisher;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.onSubscribe(takeUntilMainSubscriber);
        this.f7151.subscribe(takeUntilMainSubscriber.other);
        this.f11385.subscribe((InterfaceC3899) takeUntilMainSubscriber);
    }
}
