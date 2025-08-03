package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4056;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2697;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC5247;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWithLatestFrom<T, U, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<? super T, ? super U, ? extends R> f7194;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Publisher<? extends U> f7195;

    public static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements InterfaceC2697<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;
        public final InterfaceC5247<? super T, ? super U, ? extends R> combiner;
        public final Subscriber<? super R> downstream;
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<Subscription> other = new AtomicReference<>();

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
            this.downstream = subscriber;
            this.combiner = interfaceC5247;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (mo6426(t)) {
                return;
            }
            this.upstream.get().request(1L);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6663(Throwable th) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6664(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.other, subscription);
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            U u = get();
            if (u != null) {
                try {
                    this.downstream.onNext(C4246.m13353(this.combiner.apply(t, u), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
            return false;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$Ϳ, reason: contains not printable characters */
    public final class C2062 implements InterfaceC3899<U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final WithLatestFromSubscriber<T, U, R> f7196;

        public C2062(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.f7196 = withLatestFromSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f7196.m6663(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            this.f7196.lazySet(u);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (this.f7196.m6664(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableWithLatestFrom(AbstractC3630<T> abstractC3630, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, Publisher<? extends U> publisher) {
        super(abstractC3630);
        this.f7194 = interfaceC5247;
        this.f7195 = publisher;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(c4056, this.f7194);
        c4056.onSubscribe(withLatestFromSubscriber);
        this.f7195.subscribe(new C2062(withLatestFromSubscriber));
        this.f11385.subscribe((InterfaceC3899) withLatestFromSubscriber);
    }
}
