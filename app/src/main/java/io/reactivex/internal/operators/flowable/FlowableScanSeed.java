package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC5247;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableScanSeed<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f7116;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<R> f7117;

    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;
        public final InterfaceC5247<R, ? super T, R> accumulator;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final InterfaceC2475<R> queue;
        public final AtomicLong requested;
        public Subscription upstream;
        public R value;

        public ScanSeedSubscriber(Subscriber<? super R> subscriber, InterfaceC5247<R, ? super T, R> interfaceC5247, R r, int i) {
            this.downstream = subscriber;
            this.accumulator = interfaceC5247;
            this.value = r;
            this.prefetch = i;
            this.limit = i - (i >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6623();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.error = th;
            this.done = true;
            m6623();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) C4246.m13353(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                m6623();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch - 1);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6623();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6623() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            InterfaceC2475<R> interfaceC2475 = this.queue;
            int i = this.limit;
            int i2 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        interfaceC2475.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        interfaceC2475.clear();
                        subscriber.onError(th);
                        return;
                    }
                    R rPoll = interfaceC2475.poll();
                    boolean z2 = rPoll == null;
                    if (z && z2) {
                        subscriber.onComplete();
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(rPoll);
                    j2++;
                    i2++;
                    if (i2 == i) {
                        this.upstream.request(i);
                        i2 = 0;
                    }
                }
                if (j2 == j && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        interfaceC2475.clear();
                        subscriber.onError(th2);
                        return;
                    } else if (interfaceC2475.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0) {
                    C5153.m15073(this.requested, j2);
                }
                this.consumed = i2;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    public FlowableScanSeed(AbstractC3630<T> abstractC3630, Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        super(abstractC3630);
        this.f7116 = interfaceC5247;
        this.f7117 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        try {
            this.f11385.subscribe((InterfaceC3899) new ScanSeedSubscriber(subscriber, this.f7116, C4246.m13353(this.f7117.call(), "The seed supplied is null"), AbstractC3630.bufferSize()));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
