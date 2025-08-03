package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSubscribeOn<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7135;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7136;

    public static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        public final Subscriber<? super T> downstream;
        public final boolean nonScheduledRequests;
        public Publisher<T> source;
        public final AbstractC4585.AbstractC4588 worker;
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber$Ϳ, reason: contains not printable characters */
        public static final class RunnableC2054 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final Subscription f7137;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final long f7138;

            public RunnableC2054(Subscription subscription, long j) {
                this.f7137 = subscription;
                this.f7138 = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7137.request(this.f7138);
            }
        }

        public SubscribeOnSubscriber(Subscriber<? super T> subscriber, AbstractC4585.AbstractC4588 abstractC4588, Publisher<T> publisher, boolean z) {
            this.downstream = subscriber;
            this.worker = abstractC4588;
            this.source = publisher;
            this.nonScheduledRequests = !z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                long andSet = this.requested.getAndSet(0L);
                if (andSet != 0) {
                    m6634(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = this.upstream.get();
                if (subscription != null) {
                    m6634(j, subscription);
                    return;
                }
                C5153.m15069(this.requested, j);
                Subscription subscription2 = this.upstream.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0L);
                    if (andSet != 0) {
                        m6634(andSet, subscription2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6634(long j, Subscription subscription) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                subscription.request(j);
            } else {
                this.worker.mo6990(new RunnableC2054(subscription, j));
            }
        }
    }

    public FlowableSubscribeOn(AbstractC3630<T> abstractC3630, AbstractC4585 abstractC4585, boolean z) {
        super(abstractC3630);
        this.f7135 = abstractC4585;
        this.f7136 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = this.f7135.mo6986();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, abstractC4588Mo6986, this.f11385, this.f7136);
        subscriber.onSubscribe(subscribeOnSubscriber);
        abstractC4588Mo6986.mo6990(subscribeOnSubscriber);
    }
}
