package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3899;
import defpackage.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7026;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7027;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7028;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC3809 f7029;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements InterfaceC3899<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public Throwable error;
        public final InterfaceC3809 onOverflow;
        public boolean outputFused;
        public final InterfaceC2475<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public Subscription upstream;

        public BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i, boolean z, boolean z2, InterfaceC3809 interfaceC3809) {
            this.downstream = subscriber;
            this.onOverflow = interfaceC3809;
            this.delayError = z2;
            this.queue = z ? new d<>(i) : new SpscArrayQueue<>(i);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.queue.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                m6543();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th);
            } else {
                m6543();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                if (this.outputFused) {
                    this.downstream.onNext(null);
                    return;
                } else {
                    m6543();
                    return;
                }
            }
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.outputFused || !SubscriptionHelper.validate(j)) {
                return;
            }
            C5153.m15069(this.requested, j);
            m6543();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6543() {
            if (getAndIncrement() == 0) {
                InterfaceC2475<T> interfaceC2475 = this.queue;
                Subscriber<? super T> subscriber = this.downstream;
                int iAddAndGet = 1;
                while (!m6544(this.done, interfaceC2475.isEmpty(), subscriber)) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        T tPoll = interfaceC2475.poll();
                        boolean z2 = tPoll == null;
                        if (m6544(z, z2, subscriber)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(tPoll);
                        j2++;
                    }
                    if (j2 == j && m6544(this.done, interfaceC2475.isEmpty(), subscriber)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m6544(boolean z, boolean z2, Subscriber<? super T> subscriber) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.delayError) {
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
    }

    public FlowableOnBackpressureBuffer(AbstractC3630<T> abstractC3630, int i, boolean z, boolean z2, InterfaceC3809 interfaceC3809) {
        super(abstractC3630);
        this.f7026 = i;
        this.f7027 = z;
        this.f7028 = z2;
        this.f7029 = interfaceC3809;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new BackpressureBufferSubscriber(subscriber, this.f7026, this.f7027, this.f7028, this.f7029));
    }
}
