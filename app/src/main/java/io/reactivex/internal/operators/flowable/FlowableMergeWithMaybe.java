package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C5153;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5216;
import defpackage.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableMergeWithMaybe<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3517<? extends T> f7021;

    public static final class MergeWithObserver<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        public volatile boolean cancelled;
        public int consumed;
        public final Subscriber<? super T> downstream;
        public long emitted;
        public final int limit;
        public volatile boolean mainDone;
        public volatile int otherState;
        public final int prefetch;
        public volatile InterfaceC2475<T> queue;
        public T singleItem;
        public final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public static final class OtherObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5216<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // defpackage.InterfaceC5216
            public void onComplete() {
                this.parent.m6530();
            }

            @Override // defpackage.InterfaceC5216
            public void onError(Throwable th) {
                this.parent.m6531(th);
            }

            @Override // defpackage.InterfaceC5216
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC5216
            public void onSuccess(T t) {
                this.parent.m6532(t);
            }
        }

        public MergeWithObserver(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
            int iBufferSize = AbstractC3630.bufferSize();
            this.prefetch = iBufferSize;
            this.limit = iBufferSize - (iBufferSize >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.mainDone = true;
            m6527();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this.otherObserver);
                m6527();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    InterfaceC2475<T> interfaceC2475 = this.queue;
                    if (interfaceC2475 == null || interfaceC2475.isEmpty()) {
                        this.emitted = j + 1;
                        this.downstream.onNext(t);
                        int i = this.consumed + 1;
                        if (i == this.limit) {
                            this.consumed = 0;
                            this.mainSubscription.get().request(i);
                        } else {
                            this.consumed = i;
                        }
                    } else {
                        interfaceC2475.offer(t);
                    }
                } else {
                    m6529().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                m6529().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6528();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.mainSubscription, subscription, this.prefetch);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            C5153.m15069(this.requested, j);
            m6527();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6527() {
            if (getAndIncrement() == 0) {
                m6528();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6528() {
            Subscriber<? super T> subscriber = this.downstream;
            long j = this.emitted;
            int i = this.consumed;
            int i2 = this.limit;
            int i3 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.m7019());
                        return;
                    }
                    int i4 = this.otherState;
                    if (i4 == i3) {
                        T t = this.singleItem;
                        this.singleItem = null;
                        this.otherState = 2;
                        subscriber.onNext(t);
                        j++;
                    } else {
                        boolean z = this.mainDone;
                        InterfaceC2475<T> interfaceC2475 = this.queue;
                        a aVarPoll = interfaceC2475 != null ? interfaceC2475.poll() : null;
                        boolean z2 = aVarPoll == null;
                        if (z && z2 && i4 == 2) {
                            this.queue = null;
                            subscriber.onComplete();
                            return;
                        } else {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(aVarPoll);
                            j++;
                            i++;
                            if (i == i2) {
                                this.mainSubscription.get().request(i2);
                                i = 0;
                            }
                            i3 = 1;
                        }
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    }
                    if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.m7019());
                        return;
                    }
                    boolean z3 = this.mainDone;
                    InterfaceC2475<T> interfaceC24752 = this.queue;
                    boolean z4 = interfaceC24752 == null || interfaceC24752.isEmpty();
                    if (z3 && z4 && this.otherState == 2) {
                        this.queue = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                this.emitted = j;
                this.consumed = i;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i3 = 1;
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public InterfaceC2475<T> m6529() {
            InterfaceC2475<T> interfaceC2475 = this.queue;
            if (interfaceC2475 != null) {
                return interfaceC2475;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(AbstractC3630.bufferSize());
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6530() {
            this.otherState = 2;
            m6527();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6531(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                SubscriptionHelper.cancel(this.mainSubscription);
                m6527();
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6532(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    this.emitted = j + 1;
                    this.downstream.onNext(t);
                    this.otherState = 2;
                } else {
                    this.singleItem = t;
                    this.otherState = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6528();
        }
    }

    public FlowableMergeWithMaybe(AbstractC3630<T> abstractC3630, InterfaceC3517<? extends T> interfaceC3517) {
        super(abstractC3630);
        this.f7021 = interfaceC3517;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.f11385.subscribe((InterfaceC3899) mergeWithObserver);
        this.f7021.mo11463(mergeWithObserver.otherObserver);
    }
}
