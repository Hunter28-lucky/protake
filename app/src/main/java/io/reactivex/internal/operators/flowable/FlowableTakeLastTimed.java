package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import defpackage.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTakeLastTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7145;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7146;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7147;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7148;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f7149;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean f7150;

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final long count;
        public final boolean delayError;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public Throwable error;
        public final d<Object> queue;
        public final AtomicLong requested = new AtomicLong();
        public final AbstractC4585 scheduler;
        public final long time;
        public final TimeUnit unit;
        public Subscription upstream;

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
            this.downstream = subscriber;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = abstractC4585;
            this.queue = new d<>(i);
            this.delayError = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            m6642(this.scheduler.m14050(this.unit), this.queue);
            this.done = true;
            m6641();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.delayError) {
                m6642(this.scheduler.m14050(this.unit), this.queue);
            }
            this.error = th;
            this.done = true;
            m6641();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            d<Object> dVar = this.queue;
            long jM14050 = this.scheduler.m14050(this.unit);
            dVar.m5884(Long.valueOf(jM14050), t);
            m6642(jM14050, dVar);
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
                m6641();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6640(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z2) {
                if (!z) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6641() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            d<Object> dVar = this.queue;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            do {
                if (this.done) {
                    if (m6640(dVar.isEmpty(), subscriber, z)) {
                        return;
                    }
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        if (m6640(dVar.m5885() == null, subscriber, z)) {
                            return;
                        }
                        if (j != j2) {
                            dVar.poll();
                            subscriber.onNext(dVar.poll());
                            j2++;
                        } else if (j2 != 0) {
                            C5153.m15073(this.requested, j2);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6642(long j, d<Object> dVar) {
            long j2 = this.time;
            long j3 = this.count;
            boolean z = j3 == Long.MAX_VALUE;
            while (!dVar.isEmpty()) {
                if (((Long) dVar.m5885()).longValue() >= j - j2 && (z || (dVar.m5887() >> 1) <= j3)) {
                    return;
                }
                dVar.poll();
                dVar.poll();
            }
        }
    }

    public FlowableTakeLastTimed(AbstractC3630<T> abstractC3630, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
        super(abstractC3630);
        this.f7145 = j;
        this.f7146 = j2;
        this.f7147 = timeUnit;
        this.f7148 = abstractC4585;
        this.f7149 = i;
        this.f7150 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new TakeLastTimedSubscriber(subscriber, this.f7145, this.f7146, this.f7147, this.f7148, this.f7149, this.f7150));
    }
}
