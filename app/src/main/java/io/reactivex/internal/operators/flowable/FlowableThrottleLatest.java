package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableThrottleLatest<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7155;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7156;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7157;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7158;

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public final boolean emitLast;
        public long emitted;
        public Throwable error;
        public final AtomicReference<T> latest = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final long timeout;
        public volatile boolean timerFired;
        public boolean timerRunning;
        public final TimeUnit unit;
        public Subscription upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, boolean z) {
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
            this.emitLast = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6643();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6643();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.latest.set(t);
            m6643();
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
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            m6643();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6643() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.latest;
            AtomicLong atomicLong = this.requested;
            Subscriber<? super T> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.error != null) {
                    atomicReference.lazySet(null);
                    subscriber.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                boolean z2 = atomicReference.get() == null;
                if (z) {
                    if (z2 || !this.emitLast) {
                        atomicReference.lazySet(null);
                        subscriber.onComplete();
                    } else {
                        T andSet = atomicReference.getAndSet(null);
                        long j = this.emitted;
                        if (j != atomicLong.get()) {
                            this.emitted = j + 1;
                            subscriber.onNext(andSet);
                            subscriber.onComplete();
                        } else {
                            subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                        }
                    }
                    this.worker.dispose();
                    return;
                }
                if (z2) {
                    if (this.timerFired) {
                        this.timerRunning = false;
                        this.timerFired = false;
                    }
                } else if (!this.timerRunning || this.timerFired) {
                    T andSet2 = atomicReference.getAndSet(null);
                    long j2 = this.emitted;
                    if (j2 == atomicLong.get()) {
                        this.upstream.cancel();
                        subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                        this.worker.dispose();
                        return;
                    } else {
                        subscriber.onNext(andSet2);
                        this.emitted = j2 + 1;
                        this.timerFired = false;
                        this.timerRunning = true;
                        this.worker.mo6991(this, this.timeout, this.unit);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }
    }

    public FlowableThrottleLatest(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(abstractC3630);
        this.f7155 = j;
        this.f7156 = timeUnit;
        this.f7157 = abstractC4585;
        this.f7158 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new ThrottleLatestSubscriber(subscriber, this.f7155, this.f7156, this.f7157.mo6986(), this.f7158));
    }
}
