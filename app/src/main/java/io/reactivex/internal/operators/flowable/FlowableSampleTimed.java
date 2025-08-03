package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C4056;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSampleTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7112;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7113;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7114;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7115;

    public static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger wip;

        public SampleTimedEmitLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(subscriber, j, timeUnit, abstractC4585);
            this.wip = new AtomicInteger(1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                m6622();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6620() {
            m6622();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(subscriber, j, timeUnit, abstractC4585);
        }

        @Override // java.lang.Runnable
        public void run() {
            m6622();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        /* renamed from: Ԩ */
        public void mo6620() {
            this.downstream.onComplete();
        }
    }

    public static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements InterfaceC3899<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final Subscriber<? super T> downstream;
        public final long period;
        public final AbstractC4585 scheduler;
        public final TimeUnit unit;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final SequentialDisposable timer = new SequentialDisposable();

        public SampleTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.downstream = subscriber;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = abstractC4585;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            m6621();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            m6621();
            mo6620();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            m6621();
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
                SequentialDisposable sequentialDisposable = this.timer;
                AbstractC4585 abstractC4585 = this.scheduler;
                long j = this.period;
                sequentialDisposable.m6311(abstractC4585.mo6989(this, j, j, this.unit));
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6621() {
            DisposableHelper.dispose(this.timer);
        }

        /* renamed from: Ԩ */
        public abstract void mo6620();

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6622() {
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
    }

    public FlowableSampleTimed(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(abstractC3630);
        this.f7112 = j;
        this.f7113 = timeUnit;
        this.f7114 = abstractC4585;
        this.f7115 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        C4056 c4056 = new C4056(subscriber);
        if (this.f7115) {
            this.f11385.subscribe((InterfaceC3899) new SampleTimedEmitLast(c4056, this.f7112, this.f7113, this.f7114));
        } else {
            this.f11385.subscribe((InterfaceC3899) new SampleTimedNoLast(c4056, this.f7112, this.f7113, this.f7114));
        }
    }
}
