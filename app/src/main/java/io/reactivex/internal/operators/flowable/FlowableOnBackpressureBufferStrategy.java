package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C5153;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3899;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7030;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f7031;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final BackpressureOverflowStrategy f7032;

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        public final long bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Subscriber<? super T> downstream;
        public Throwable error;
        public final InterfaceC3809 onOverflow;
        public final BackpressureOverflowStrategy strategy;
        public Subscription upstream;
        public final AtomicLong requested = new AtomicLong();
        public final Deque<T> deque = new ArrayDeque();

        public OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, InterfaceC3809 interfaceC3809, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.downstream = subscriber;
            this.onOverflow = interfaceC3809;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                m6545(this.deque);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6546();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.error = th;
            this.done = true;
            m6546();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            boolean z2;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.bufferSize) {
                    int i = C2040.f7033[this.strategy.ordinal()];
                    if (i == 1) {
                        deque.pollLast();
                        deque.offer(t);
                    } else if (i == 2) {
                        deque.poll();
                        deque.offer(t);
                    }
                    z2 = false;
                    z = true;
                } else {
                    deque.offer(t);
                    z2 = false;
                }
            }
            if (!z) {
                if (!z2) {
                    m6546();
                    return;
                } else {
                    this.upstream.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            InterfaceC3809 interfaceC3809 = this.onOverflow;
            if (interfaceC3809 != null) {
                try {
                    interfaceC3809.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.upstream.cancel();
                    onError(th);
                }
            }
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
                m6546();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6545(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6546() {
            boolean zIsEmpty;
            T tPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            Subscriber<? super T> subscriber = this.downstream;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        m6545(deque);
                        return;
                    }
                    boolean z = this.done;
                    synchronized (deque) {
                        tPoll = deque.poll();
                    }
                    boolean z2 = tPoll == null;
                    if (z) {
                        Throwable th = this.error;
                        if (th != null) {
                            m6545(deque);
                            subscriber.onError(th);
                            return;
                        } else if (z2) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(tPoll);
                    j2++;
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        m6545(deque);
                        return;
                    }
                    boolean z3 = this.done;
                    synchronized (deque) {
                        zIsEmpty = deque.isEmpty();
                    }
                    if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            m6545(deque);
                            subscriber.onError(th2);
                            return;
                        } else if (zIsEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    C5153.m15073(this.requested, j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2040 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f7033;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            f7033 = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7033[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(AbstractC3630<T> abstractC3630, long j, InterfaceC3809 interfaceC3809, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(abstractC3630);
        this.f7030 = j;
        this.f7031 = interfaceC3809;
        this.f7032 = backpressureOverflowStrategy;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new OnBackpressureBufferStrategySubscriber(subscriber, this.f7031, this.f7032, this.f7030));
    }
}
