package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC3899;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTimeoutTimed<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7162;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7163;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7164;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final Publisher<? extends T> f7165;

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements InterfaceC3899<T>, InterfaceC2057 {
        private static final long serialVersionUID = 3764492702657003550L;
        public long consumed;
        public final Subscriber<? super T> downstream;
        public Publisher<? extends T> fallback;
        public final AtomicLong index;
        public final SequentialDisposable task;
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<Subscription> upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, Publisher<? extends T> publisher) {
            super(true);
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
            this.fallback = publisher;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
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
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.downstream.onNext(t);
                    m6648(j2);
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
        /* renamed from: Ϳ */
        public void mo6644(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                long j2 = this.consumed;
                if (j2 != 0) {
                    m7014(j2);
                }
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                publisher.subscribe(new C2056(this.downstream, this));
                this.worker.dispose();
            }
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m6648(long j) {
            this.task.m6311(this.worker.mo6991(new RunnableC2058(j, this), this.timeout, this.unit));
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements InterfaceC3899<T>, Subscription, InterfaceC2057 {
        private static final long serialVersionUID = 3764492702657003550L;
        public final Subscriber<? super T> downstream;
        public final long timeout;
        public final TimeUnit unit;
        public final AbstractC4585.AbstractC4588 worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.downstream = subscriber;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    m6649(j2);
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
                this.downstream.onError(new TimeoutException(ExceptionHelper.m7023(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6649(long j) {
            this.task.m6311(this.worker.mo6991(new RunnableC2058(j, this), this.timeout, this.unit));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$Ϳ, reason: contains not printable characters */
    public static final class C2056<T> implements InterfaceC3899<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f7166;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final SubscriptionArbiter f7167;

        public C2056(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.f7166 = subscriber;
            this.f7167 = subscriptionArbiter;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f7166.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f7166.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f7166.onNext(t);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.f7167.m7015(subscription);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2057 {
        /* renamed from: Ϳ */
        void mo6644(long j);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$Ԫ, reason: contains not printable characters */
    public static final class RunnableC2058 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2057 f7168;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f7169;

        public RunnableC2058(long j, InterfaceC2057 interfaceC2057) {
            this.f7169 = j;
            this.f7168 = interfaceC2057;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7168.mo6644(this.f7169);
        }
    }

    public FlowableTimeoutTimed(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, Publisher<? extends T> publisher) {
        super(abstractC3630);
        this.f7162 = j;
        this.f7163 = timeUnit;
        this.f7164 = abstractC4585;
        this.f7165 = publisher;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f7165 == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f7162, this.f7163, this.f7164.mo6986());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.m6649(0L);
            this.f11385.subscribe((InterfaceC3899) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f7162, this.f7163, this.f7164.mo6986(), this.f7165);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.m6648(0L);
        this.f11385.subscribe((InterfaceC3899) timeoutFallbackSubscriber);
    }
}
