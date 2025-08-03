package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2877;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import defpackage.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f6903;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6904;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f6905;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final ErrorMode f6906;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, Subscription, InterfaceC2877<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        public volatile boolean cancelled;
        public volatile InnerQueuedSubscriber<R> current;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public final ErrorMode errorMode;
        public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public final d<InnerQueuedSubscriber<R>> subscribers;
        public Subscription upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, int i2, ErrorMode errorMode) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.subscribers = new d<>(Math.min(i2, i));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            m6409();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            mo6405();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                mo6405();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    m6409();
                }
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
                int i = this.maxConcurrency;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                mo6405();
            }
        }

        @Override // defpackage.InterfaceC2877
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6404(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.m7005();
            mo6405();
        }

        @Override // defpackage.InterfaceC2877
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6405() {
            InnerQueuedSubscriber<R> innerQueuedSubscriberPoll;
            int i;
            boolean z;
            long j;
            long j2;
            InterfaceC4851<R> interfaceC4851M7003;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            Subscriber<? super R> subscriber = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.requested.get();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriberPoll = innerQueuedSubscriber;
                } else {
                    if (errorMode != ErrorMode.END && this.errors.get() != null) {
                        m6408();
                        subscriber.onError(this.errors.m7019());
                        return;
                    }
                    boolean z2 = this.done;
                    innerQueuedSubscriberPoll = this.subscribers.poll();
                    if (z2 && innerQueuedSubscriberPoll == null) {
                        Throwable thM7019 = this.errors.m7019();
                        if (thM7019 != null) {
                            subscriber.onError(thM7019);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (innerQueuedSubscriberPoll != null) {
                        this.current = innerQueuedSubscriberPoll;
                    }
                }
                if (innerQueuedSubscriberPoll == null || (interfaceC4851M7003 = innerQueuedSubscriberPoll.m7003()) == null) {
                    i = iAddAndGet;
                    z = false;
                    j = 0;
                    j2 = 0;
                } else {
                    j2 = 0;
                    while (true) {
                        i = iAddAndGet;
                        if (j2 == j3) {
                            break;
                        }
                        if (this.cancelled) {
                            m6408();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            m6408();
                            subscriber.onError(this.errors.m7019());
                            return;
                        }
                        boolean zM7002 = innerQueuedSubscriberPoll.m7002();
                        try {
                            R rPoll = interfaceC4851M7003.poll();
                            boolean z3 = rPoll == null;
                            if (zM7002 && z3) {
                                this.current = null;
                                this.upstream.request(1L);
                                innerQueuedSubscriberPoll = null;
                                z = true;
                                break;
                            }
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(rPoll);
                            j2++;
                            innerQueuedSubscriberPoll.m7004();
                            iAddAndGet = i;
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            m6408();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    z = false;
                    if (j2 == j3) {
                        if (this.cancelled) {
                            m6408();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            m6408();
                            subscriber.onError(this.errors.m7019());
                            return;
                        }
                        boolean zM70022 = innerQueuedSubscriberPoll.m7002();
                        boolean zIsEmpty = interfaceC4851M7003.isEmpty();
                        if (zM70022 && zIsEmpty) {
                            this.current = null;
                            this.upstream.request(1L);
                            innerQueuedSubscriberPoll = null;
                            z = true;
                        }
                    }
                    j = 0;
                }
                if (j2 != j && j3 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                if (z) {
                    innerQueuedSubscriber = innerQueuedSubscriberPoll;
                    iAddAndGet = i;
                } else {
                    iAddAndGet = addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    } else {
                        innerQueuedSubscriber = innerQueuedSubscriberPoll;
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC2877
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo6406(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.m7003().offer(r)) {
                mo6405();
            } else {
                innerQueuedSubscriber.cancel();
                mo6407(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // defpackage.InterfaceC2877
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo6407(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            innerQueuedSubscriber.m7005();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            mo6405();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6408() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> innerQueuedSubscriberPoll = this.subscribers.poll();
                if (innerQueuedSubscriberPoll == null) {
                    return;
                } else {
                    innerQueuedSubscriberPoll.cancel();
                }
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6409() {
            if (getAndIncrement() == 0) {
                do {
                    m6408();
                } while (decrementAndGet() != 0);
            }
        }
    }

    public FlowableConcatMapEager(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, int i2, ErrorMode errorMode) {
        super(abstractC3630);
        this.f6903 = interfaceC2368;
        this.f6904 = i;
        this.f6905 = i2;
        this.f6906 = errorMode;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f6903, this.f6904, this.f6905, this.f6906));
    }
}
