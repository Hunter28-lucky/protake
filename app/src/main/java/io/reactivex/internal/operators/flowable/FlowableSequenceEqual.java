package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5324;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqual<T> extends AbstractC3630<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T> f7118;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends T> f7119;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super T, ? super T> f7120;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7121;

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements InterfaceC2053 {
        private static final long serialVersionUID = -6178010334400373240L;
        public final InterfaceC5324<? super T, ? super T> comparer;
        public final AtomicThrowable error;
        public final EqualSubscriber<T> first;
        public final EqualSubscriber<T> second;
        public T v1;
        public T v2;
        public final AtomicInteger wip;

        public EqualCoordinator(Subscriber<? super Boolean> subscriber, int i, InterfaceC5324<? super T, ? super T> interfaceC5324) {
            super(subscriber);
            this.comparer = interfaceC5324;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber<>(this, i);
            this.second = new EqualSubscriber<>(this, i);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.first.m6628();
            this.second.m6628();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.InterfaceC2053
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6624(Throwable th) {
            if (this.error.m7018(th)) {
                mo6625();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.InterfaceC2053
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6625() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                InterfaceC4851<T> interfaceC4851 = this.first.queue;
                InterfaceC4851<T> interfaceC48512 = this.second.queue;
                if (interfaceC4851 != null && interfaceC48512 != null) {
                    while (!m7009()) {
                        if (this.error.get() != null) {
                            m6626();
                            this.downstream.onError(this.error.m7019());
                            return;
                        }
                        boolean z = this.first.done;
                        T tPoll = this.v1;
                        if (tPoll == null) {
                            try {
                                tPoll = interfaceC4851.poll();
                                this.v1 = tPoll;
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                m6626();
                                this.error.m7018(th);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                        boolean z2 = tPoll == null;
                        boolean z3 = this.second.done;
                        T tPoll2 = this.v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = interfaceC48512.poll();
                                this.v2 = tPoll2;
                            } catch (Throwable th2) {
                                C4089.m13026(th2);
                                m6626();
                                this.error.m7018(th2);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                        boolean z4 = tPoll2 == null;
                        if (z && z3 && z2 && z4) {
                            m7008(Boolean.TRUE);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            m6626();
                            m7008(Boolean.FALSE);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.comparer.test(tPoll, tPoll2)) {
                                    m6626();
                                    m7008(Boolean.FALSE);
                                    return;
                                } else {
                                    this.v1 = null;
                                    this.v2 = null;
                                    this.first.m6629();
                                    this.second.m6629();
                                }
                            } catch (Throwable th3) {
                                C4089.m13026(th3);
                                m6626();
                                this.error.m7018(th3);
                                this.downstream.onError(this.error.m7019());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (m7009()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    m6626();
                    this.downstream.onError(this.error.m7019());
                    return;
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6626() {
            this.first.m6628();
            this.first.clear();
            this.second.m6628();
            this.second.clear();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6627(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.first);
            publisher2.subscribe(this.second);
        }
    }

    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        public volatile boolean done;
        public final int limit;
        public final InterfaceC2053 parent;
        public final int prefetch;
        public long produced;
        public volatile InterfaceC4851<T> queue;
        public int sourceMode;

        public EqualSubscriber(InterfaceC2053 interfaceC2053, int i) {
            this.parent = interfaceC2053;
            this.limit = i - (i >> 2);
            this.prefetch = i;
        }

        public void clear() {
            InterfaceC4851<T> interfaceC4851 = this.queue;
            if (interfaceC4851 != null) {
                interfaceC4851.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            this.parent.mo6625();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.mo6624(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                this.parent.mo6625();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(3);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        this.parent.mo6625();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                subscription.request(this.prefetch);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6628() {
            SubscriptionHelper.cancel(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6629() {
            if (this.sourceMode != 1) {
                long j = this.produced + 1;
                if (j < this.limit) {
                    this.produced = j;
                } else {
                    this.produced = 0L;
                    get().request(j);
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSequenceEqual$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2053 {
        /* renamed from: Ϳ */
        void mo6624(Throwable th);

        /* renamed from: Ԩ */
        void mo6625();
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        this.f7118 = publisher;
        this.f7119 = publisher2;
        this.f7120 = interfaceC5324;
        this.f7121 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.f7121, this.f7120);
        subscriber.onSubscribe(equalCoordinator);
        equalCoordinator.m6627(this.f7118, this.f7119);
    }
}
