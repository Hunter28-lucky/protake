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
public final class FlowableSkipLastTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7129;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7130;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7131;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f7132;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean f7133;

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
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

        public SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
            this.downstream = subscriber;
            this.time = j;
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
            this.done = true;
            m6633();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6633();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.queue.m5884(Long.valueOf(this.scheduler.m14050(this.unit)), t);
            m6633();
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
                m6633();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6632(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
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
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6633() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            d<Object> dVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            AbstractC4585 abstractC4585 = this.scheduler;
            long j = this.time;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z2 = this.done;
                    Long l = (Long) dVar.m5885();
                    boolean z3 = l == null;
                    boolean z4 = (z3 || l.longValue() <= abstractC4585.m14050(timeUnit) - j) ? z3 : true;
                    if (m6632(z2, z4, subscriber, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    dVar.poll();
                    subscriber.onNext(dVar.poll());
                    j3++;
                }
                if (j3 != 0) {
                    C5153.m15073(this.requested, j3);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    public FlowableSkipLastTimed(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
        super(abstractC3630);
        this.f7129 = j;
        this.f7130 = timeUnit;
        this.f7131 = abstractC4585;
        this.f7132 = i;
        this.f7133 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new SkipLastTimedSubscriber(subscriber, this.f7129, this.f7130, this.f7131, this.f7132, this.f7133));
    }
}
