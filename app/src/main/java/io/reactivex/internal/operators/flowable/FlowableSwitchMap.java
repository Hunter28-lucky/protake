package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2930;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import defpackage.a;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSwitchMap<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f7139;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7140;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7141;

    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements InterfaceC3899<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;
        public final long index;
        public final SwitchMapSubscriber<T, R> parent;
        public volatile InterfaceC4851<R> queue;

        public SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.parent = switchMapSubscriber;
            this.index = j;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                this.done = true;
                switchMapSubscriber.m6638();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index != switchMapSubscriber.unique || !switchMapSubscriber.error.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
                switchMapSubscriber.done = true;
            }
            this.done = true;
            switchMapSubscriber.m6638();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
            if (this.index == switchMapSubscriber.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r)) {
                    switchMapSubscriber.m6638();
                } else {
                    onError(new MissingBackpressureException("Queue full?!"));
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.parent.m6638();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC2968;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6635() {
            SubscriptionHelper.cancel(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6636(long j) {
            if (this.fusionMode != 1) {
                get().request(j);
            }
        }
    }

    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -3491074160481096299L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapInnerSubscriber<Object, Object> f7142;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> mapper;
        public volatile long unique;
        public Subscription upstream;
        public final AtomicReference<SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable error = new AtomicThrowable();

        static {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber = new SwitchMapInnerSubscriber<>(null, -1L, 1);
            f7142 = switchMapInnerSubscriber;
            switchMapInnerSubscriber.m6635();
        }

        public SwitchMapSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            m6637();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6638();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done || !this.error.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6637();
            }
            this.done = true;
            m6638();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            if (this.done) {
                return;
            }
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.m6635();
            }
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.mapper.apply(t), "The publisher returned is null");
                SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j, this.bufferSize);
                do {
                    switchMapInnerSubscriber = this.active.get();
                    if (switchMapInnerSubscriber == f7142) {
                        return;
                    }
                } while (!C4905.m14631(this.active, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                publisher.subscribe(switchMapInnerSubscriber3);
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
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                if (this.unique == 0) {
                    this.upstream.request(Long.MAX_VALUE);
                } else {
                    m6638();
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6637() {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.active.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber3 = f7142;
            if (switchMapInnerSubscriber2 == switchMapInnerSubscriber3 || (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.active.getAndSet(switchMapInnerSubscriber3)) == switchMapInnerSubscriber3 || switchMapInnerSubscriber == null) {
                return;
            }
            switchMapInnerSubscriber.m6635();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6638() {
            boolean z;
            a aVarPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.done) {
                    if (this.delayErrors) {
                        if (this.active.get() == null) {
                            if (this.error.get() != null) {
                                subscriber.onError(this.error.m7019());
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else if (this.error.get() != null) {
                        m6637();
                        subscriber.onError(this.error.m7019());
                        return;
                    } else if (this.active.get() == null) {
                        subscriber.onComplete();
                        return;
                    }
                }
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
                InterfaceC4851<R> interfaceC4851 = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.queue : null;
                if (interfaceC4851 != null) {
                    if (switchMapInnerSubscriber.done) {
                        if (this.delayErrors) {
                            if (interfaceC4851.isEmpty()) {
                                C4905.m14631(this.active, switchMapInnerSubscriber, null);
                            }
                        } else if (this.error.get() != null) {
                            m6637();
                            subscriber.onError(this.error.m7019());
                            return;
                        } else if (interfaceC4851.isEmpty()) {
                            C4905.m14631(this.active, switchMapInnerSubscriber, null);
                        }
                    }
                    long j = this.requested.get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 != j) {
                            if (!this.cancelled) {
                                boolean z2 = switchMapInnerSubscriber.done;
                                try {
                                    aVarPoll = interfaceC4851.poll();
                                } catch (Throwable th) {
                                    C4089.m13026(th);
                                    switchMapInnerSubscriber.m6635();
                                    this.error.m7018(th);
                                    aVarPoll = null;
                                    z2 = true;
                                }
                                boolean z3 = aVarPoll == null;
                                if (switchMapInnerSubscriber != this.active.get()) {
                                    break;
                                }
                                if (z2) {
                                    if (!this.delayErrors) {
                                        if (this.error.get() == null) {
                                            if (z3) {
                                                C4905.m14631(this.active, switchMapInnerSubscriber, null);
                                                break;
                                            }
                                        } else {
                                            subscriber.onError(this.error.m7019());
                                            return;
                                        }
                                    } else if (z3) {
                                        C4905.m14631(this.active, switchMapInnerSubscriber, null);
                                        break;
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                                subscriber.onNext(aVarPoll);
                                j2++;
                            } else {
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    z = true;
                    if (j2 != 0 && !this.cancelled) {
                        if (j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        switchMapInnerSubscriber.m6636(j2);
                    }
                    if (z) {
                        continue;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            this.active.lazySet(null);
        }
    }

    public FlowableSwitchMap(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
        super(abstractC3630);
        this.f7139 = interfaceC2368;
        this.f7140 = i;
        this.f7141 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (C2930.m10333(this.f11385, subscriber, this.f7139)) {
            return;
        }
        this.f11385.subscribe((InterfaceC3899) new SwitchMapSubscriber(subscriber, this.f7139, this.f7140, this.f7141));
    }
}
