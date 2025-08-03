package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2930;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMap<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f6896;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6897;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ErrorMode f6898;

    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements InterfaceC3899<T>, InterfaceC2018<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        public volatile boolean active;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final int limit;
        public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> mapper;
        public final int prefetch;
        public InterfaceC4851<T> queue;
        public int sourceMode;
        public Subscription upstream;
        public final ConcatMapInner<R> inner = new ConcatMapInner<>(this);
        public final AtomicThrowable errors = new AtomicThrowable();

        public BaseConcatMapSubscriber(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
            this.mapper = interfaceC2368;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.done = true;
            mo6400();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.sourceMode == 2 || this.queue.offer(t)) {
                mo6400();
            } else {
                this.upstream.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.done = true;
                        mo6401();
                        mo6400();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        mo6401();
                        subscription.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                mo6401();
                subscription.request(this.prefetch);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.InterfaceC2018
        /* renamed from: ԩ, reason: contains not printable characters */
        public final void mo6399() {
            this.active = false;
            mo6400();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public abstract void mo6400();

        /* renamed from: ԫ, reason: contains not printable characters */
        public abstract void mo6401();
    }

    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        public final Subscriber<? super R> downstream;
        public final boolean veryEnd;

        public ConcatMapDelayed(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
            super(interfaceC2368, i);
            this.downstream = subscriber;
            this.veryEnd = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                mo6400();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.InterfaceC2018
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6402(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.veryEnd) {
                this.upstream.cancel();
                this.done = true;
            }
            this.active = false;
            mo6400();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.InterfaceC2018
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6403(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        /* renamed from: Ԫ */
        public void mo6400() {
            Object objCall;
            if (getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        if (z && !this.veryEnd && this.errors.get() != null) {
                            this.downstream.onError(this.errors.m7019());
                            return;
                        }
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                Throwable thM7019 = this.errors.m7019();
                                if (thM7019 != null) {
                                    this.downstream.onError(thM7019);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            objCall = ((Callable) publisher).call();
                                        } catch (Throwable th) {
                                            C4089.m13026(th);
                                            this.errors.m7018(th);
                                            if (!this.veryEnd) {
                                                this.upstream.cancel();
                                                this.downstream.onError(this.errors.m7019());
                                                return;
                                            }
                                            objCall = null;
                                        }
                                        if (objCall == null) {
                                            continue;
                                        } else if (this.inner.m7013()) {
                                            this.downstream.onNext(objCall);
                                        } else {
                                            this.active = true;
                                            ConcatMapInner<R> concatMapInner = this.inner;
                                            concatMapInner.m7015(new C2019(objCall, concatMapInner));
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    C4089.m13026(th2);
                                    this.upstream.cancel();
                                    this.errors.m7018(th2);
                                    this.downstream.onError(this.errors.m7019());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            C4089.m13026(th3);
                            this.upstream.cancel();
                            this.errors.m7018(th3);
                            this.downstream.onError(this.errors.m7019());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        /* renamed from: ԫ */
        public void mo6401() {
            this.downstream.onSubscribe(this);
        }
    }

    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        public final Subscriber<? super R> downstream;
        public final AtomicInteger wip;

        public ConcatMapImmediate(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
            super(interfaceC2368, i);
            this.downstream = subscriber;
            this.wip = new AtomicInteger();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.inner.cancel();
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.m7019());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.inner.request(j);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.InterfaceC2018
        /* renamed from: Ϳ */
        public void mo6402(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.downstream.onError(this.errors.m7019());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.InterfaceC2018
        /* renamed from: Ԩ */
        public void mo6403(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.downstream.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.downstream.onError(this.errors.m7019());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        /* renamed from: Ԫ */
        public void mo6400() {
            if (this.wip.getAndIncrement() == 0) {
                while (!this.cancelled) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            T tPoll = this.queue.poll();
                            boolean z2 = tPoll == null;
                            if (z && z2) {
                                this.downstream.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null Publisher");
                                    if (this.sourceMode != 1) {
                                        int i = this.consumed + 1;
                                        if (i == this.limit) {
                                            this.consumed = 0;
                                            this.upstream.request(i);
                                        } else {
                                            this.consumed = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) publisher).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.inner.m7013()) {
                                                this.active = true;
                                                ConcatMapInner<R> concatMapInner = this.inner;
                                                concatMapInner.m7015(new C2019(objCall, concatMapInner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.downstream.onNext(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.downstream.onError(this.errors.m7019());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            C4089.m13026(th);
                                            this.upstream.cancel();
                                            this.errors.m7018(th);
                                            this.downstream.onError(this.errors.m7019());
                                            return;
                                        }
                                    } else {
                                        this.active = true;
                                        publisher.subscribe(this.inner);
                                    }
                                } catch (Throwable th2) {
                                    C4089.m13026(th2);
                                    this.upstream.cancel();
                                    this.errors.m7018(th2);
                                    this.downstream.onError(this.errors.m7019());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            C4089.m13026(th3);
                            this.upstream.cancel();
                            this.errors.m7018(th3);
                            this.downstream.onError(this.errors.m7019());
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        /* renamed from: ԫ */
        public void mo6401() {
            this.downstream.onSubscribe(this);
        }
    }

    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements InterfaceC3899<R> {
        private static final long serialVersionUID = 897683679971470653L;
        public final InterfaceC2018<R> parent;
        public long produced;

        public ConcatMapInner(InterfaceC2018<R> interfaceC2018) {
            super(false);
            this.parent = interfaceC2018;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                m7014(j);
            }
            this.parent.mo6399();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.produced;
            if (j != 0) {
                this.produced = 0L;
                m7014(j);
            }
            this.parent.mo6402(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.produced++;
            this.parent.mo6403(r);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            m7015(subscription);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2017 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f6899;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            f6899 = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6899[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2018<T> {
        /* renamed from: Ϳ */
        void mo6402(Throwable th);

        /* renamed from: Ԩ */
        void mo6403(T t);

        /* renamed from: ԩ */
        void mo6399();
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$Ԫ, reason: contains not printable characters */
    public static final class C2019<T> implements Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f6900;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f6901;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f6902;

        public C2019(T t, Subscriber<? super T> subscriber) {
            this.f6901 = t;
            this.f6900 = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (j <= 0 || this.f6902) {
                return;
            }
            this.f6902 = true;
            Subscriber<? super T> subscriber = this.f6900;
            subscriber.onNext(this.f6901);
            subscriber.onComplete();
        }
    }

    public FlowableConcatMap(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, ErrorMode errorMode) {
        super(abstractC3630);
        this.f6896 = interfaceC2368;
        this.f6897 = i;
        this.f6898 = errorMode;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T, R> Subscriber<T> m6398(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, ErrorMode errorMode) {
        int i2 = C2017.f6899[errorMode.ordinal()];
        return i2 != 1 ? i2 != 2 ? new ConcatMapImmediate(subscriber, interfaceC2368, i) : new ConcatMapDelayed(subscriber, interfaceC2368, i, true) : new ConcatMapDelayed(subscriber, interfaceC2368, i, false);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (C2930.m10333(this.f11385, subscriber, this.f6896)) {
            return;
        }
        this.f11385.subscribe(m6398(subscriber, this.f6896, this.f6897, this.f6898));
    }
}
