package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTakeLast<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7144;

    public static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        public volatile boolean cancelled;
        public final int count;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger wip = new AtomicInteger();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i) {
            this.downstream = subscriber;
            this.count = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6639();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6639();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6639() {
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.downstream;
                long jAddAndGet = this.requested.get();
                while (!this.cancelled) {
                    if (this.done) {
                        long j = 0;
                        while (j != jAddAndGet) {
                            if (this.cancelled) {
                                return;
                            }
                            T tPoll = poll();
                            if (tPoll == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onNext(tPoll);
                                j++;
                            }
                        }
                        if (j != 0 && jAddAndGet != Long.MAX_VALUE) {
                            jAddAndGet = this.requested.addAndGet(-j);
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public FlowableTakeLast(AbstractC3630<T> abstractC3630, int i) {
        super(abstractC3630);
        this.f7144 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new TakeLastSubscriber(subscriber, this.f7144));
    }
}
