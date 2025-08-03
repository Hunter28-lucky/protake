package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C4056;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSamplePublisher<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f7108;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<?> f7109;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7110;

    public static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public volatile boolean done;
        public final AtomicInteger wip;

        public SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6614() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                m6617();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo6615() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    m6617();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        /* renamed from: Ԩ */
        public void mo6614() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        /* renamed from: ԫ */
        public void mo6615() {
            m6617();
        }
    }

    public static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        public final Subscriber<? super T> downstream;
        public final Publisher<?> sampler;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<Subscription> other = new AtomicReference<>();

        public SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.downstream = subscriber;
            this.sampler = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            mo6614();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.other);
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new C2052(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6616() {
            this.upstream.cancel();
            mo6614();
        }

        /* renamed from: Ԩ */
        public abstract void mo6614();

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6617() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    C5153.m15073(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6618(Throwable th) {
            this.upstream.cancel();
            this.downstream.onError(th);
        }

        /* renamed from: ԫ */
        public abstract void mo6615();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6619(Subscription subscription) {
            SubscriptionHelper.setOnce(this.other, subscription, Long.MAX_VALUE);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSamplePublisher$Ϳ, reason: contains not printable characters */
    public static final class C2052<T> implements InterfaceC3899<Object> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final SamplePublisherSubscriber<T> f7111;

        public C2052(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.f7111 = samplePublisherSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f7111.m6616();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f7111.m6618(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.f7111.mo6615();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.f7111.m6619(subscription);
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.f7108 = publisher;
        this.f7109 = publisher2;
        this.f7110 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        if (this.f7110) {
            this.f7108.subscribe(new SampleMainEmitLast(c4056, this.f7109));
        } else {
            this.f7108.subscribe(new SampleMainNoLast(c4056, this.f7109));
        }
    }
}
