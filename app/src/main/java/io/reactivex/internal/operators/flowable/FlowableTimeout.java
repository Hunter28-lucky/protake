package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTimeout<T, U, V> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<U> f7159;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<V>> f7160;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Publisher<? extends T> f7161;

    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements InterfaceC3899<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 8708641127342403073L;
        public final long idx;
        public final InterfaceC2055 parent;

        public TimeoutConsumer(long j, InterfaceC2055 interfaceC2055) {
            this.idx = j;
            this.parent = interfaceC2055;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.parent.mo6644(this.idx);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                C3671.m11803(th);
            } else {
                lazySet(subscriptionHelper);
                this.parent.mo6645(this.idx, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.parent.mo6644(this.idx);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements InterfaceC3899<T>, InterfaceC2055 {
        private static final long serialVersionUID = 3764492702657003550L;
        public long consumed;
        public final Subscriber<? super T> downstream;
        public Publisher<? extends T> fallback;
        public final AtomicLong index;
        public final InterfaceC2368<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        public final SequentialDisposable task;
        public final AtomicReference<Subscription> upstream;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super T, ? extends Publisher<?>> interfaceC2368, Publisher<? extends T> publisher) {
            super(true);
            this.downstream = subscriber;
            this.itemTimeoutIndicator = interfaceC2368;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
            this.fallback = publisher;
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    InterfaceC4478 interfaceC4478 = this.task.get();
                    if (interfaceC4478 != null) {
                        interfaceC4478.dispose();
                    }
                    this.consumed++;
                    this.downstream.onNext(t);
                    try {
                        Publisher publisher = (Publisher) C4246.m13353(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.m6311(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                m7015(subscription);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.InterfaceC2057
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6644(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                long j2 = this.consumed;
                if (j2 != 0) {
                    m7014(j2);
                }
                publisher.subscribe(new FlowableTimeoutTimed.C2056(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.InterfaceC2055
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6645(long j, Throwable th) {
            if (!this.index.compareAndSet(j, Long.MAX_VALUE)) {
                C3671.m11803(th);
            } else {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
            }
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m6646(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.m6311(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription, InterfaceC2055 {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> downstream;
        public final InterfaceC2368<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super T, ? extends Publisher<?>> interfaceC2368) {
            this.downstream = subscriber;
            this.itemTimeoutIndicator = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
            } else {
                this.task.dispose();
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    InterfaceC4478 interfaceC4478 = this.task.get();
                    if (interfaceC4478 != null) {
                        interfaceC4478.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        Publisher publisher = (Publisher) C4246.m13353(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.m6311(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.upstream.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
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

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.InterfaceC2057
        /* renamed from: Ϳ */
        public void mo6644(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.InterfaceC2055
        /* renamed from: Ԩ */
        public void mo6645(long j, Throwable th) {
            if (!compareAndSet(j, Long.MAX_VALUE)) {
                C3671.m11803(th);
            } else {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6647(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.m6311(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeout$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2055 extends FlowableTimeoutTimed.InterfaceC2057 {
        /* renamed from: Ԩ */
        void mo6645(long j, Throwable th);
    }

    public FlowableTimeout(AbstractC3630<T> abstractC3630, Publisher<U> publisher, InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368, Publisher<? extends T> publisher2) {
        super(abstractC3630);
        this.f7159 = publisher;
        this.f7160 = interfaceC2368;
        this.f7161 = publisher2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f7161 == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f7160);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.m6647(this.f7159);
            this.f11385.subscribe((InterfaceC3899) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f7160, this.f7161);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.m6646(this.f7159);
        this.f11385.subscribe((InterfaceC3899) timeoutFallbackSubscriber);
    }
}
