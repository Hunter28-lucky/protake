package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC2900;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMapCompletable<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7228;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7229;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ErrorMode f7230;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7231;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements InterfaceC3899<T>, InterfaceC4478 {
        private static final long serialVersionUID = 3610901111000061034L;
        public volatile boolean active;
        public int consumed;
        public volatile boolean disposed;
        public volatile boolean done;
        public final InterfaceC5053 downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;
        public final int prefetch;
        public final InterfaceC2475<T> queue;
        public Subscription upstream;

        public static final class ConcatMapInnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6678();
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6679(th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6680() {
                DisposableHelper.dispose(this);
            }
        }

        public ConcatMapCompletableObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, ErrorMode errorMode, int i) {
            this.downstream = interfaceC5053;
            this.mapper = interfaceC2368;
            this.errorMode = errorMode;
            this.prefetch = i;
            this.queue = new SpscArrayQueue(i);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.m6680();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            m6677();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.done = true;
                m6677();
                return;
            }
            this.inner.m6680();
            Throwable thM7019 = this.errors.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                m6677();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(this.prefetch);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6677() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    if (this.errorMode == ErrorMode.BOUNDARY && this.errors.get() != null) {
                        this.queue.clear();
                        this.downstream.onError(this.errors.m7019());
                        return;
                    }
                    boolean z = this.done;
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
                        int i = this.prefetch;
                        int i2 = i - (i >> 1);
                        int i3 = this.consumed + 1;
                        if (i3 == i2) {
                            this.consumed = 0;
                            this.upstream.request(i2);
                        } else {
                            this.consumed = i3;
                        }
                        try {
                            InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                            this.active = true;
                            interfaceC2837.mo10180(this.inner);
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            this.queue.clear();
                            this.upstream.cancel();
                            this.errors.m7018(th);
                            this.downstream.onError(this.errors.m7019());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6678() {
            this.active = false;
            m6677();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6679(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.active = false;
                m6677();
                return;
            }
            this.upstream.cancel();
            Throwable thM7019 = this.errors.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public FlowableConcatMapCompletable(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, ErrorMode errorMode, int i) {
        this.f7228 = abstractC3630;
        this.f7229 = interfaceC2368;
        this.f7230 = errorMode;
        this.f7231 = i;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f7228.subscribe((InterfaceC3899) new ConcatMapCompletableObserver(interfaceC5053, this.f7229, this.f7230, this.f7231));
    }
}
