package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4053;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatMapCompletable<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f7259;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7260;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ErrorMode f7261;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7262;

    public static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 3610901111000061034L;
        public volatile boolean active;
        public volatile boolean disposed;
        public volatile boolean done;
        public final InterfaceC5053 downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;
        public final int prefetch;
        public InterfaceC4851<T> queue;
        public InterfaceC4478 upstream;

        public static final class ConcatMapInnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053 {
            private static final long serialVersionUID = 5638352172918776687L;
            public final ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                this.parent.m6704();
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                this.parent.m6705(th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6706() {
                DisposableHelper.dispose(this);
            }
        }

        public ConcatMapCompletableObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, ErrorMode errorMode, int i) {
            this.downstream = interfaceC5053;
            this.mapper = interfaceC2368;
            this.errorMode = errorMode;
            this.prefetch = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.m6706();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6703();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.done = true;
                m6703();
                return;
            }
            this.disposed = true;
            this.inner.m6706();
            Throwable thM7019 = this.errors.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            m6703();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                if (interfaceC4478 instanceof InterfaceC3164) {
                    InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                    int iMo6310 = interfaceC3164.mo6310(3);
                    if (iMo6310 == 1) {
                        this.queue = interfaceC3164;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        m6703();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.queue = interfaceC3164;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new d(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6703() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.errors;
            ErrorMode errorMode = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.disposed = true;
                        this.queue.clear();
                        this.downstream.onError(atomicThrowable.m7019());
                        return;
                    }
                    boolean z2 = this.done;
                    InterfaceC2837 interfaceC2837 = null;
                    try {
                        T tPoll = this.queue.poll();
                        if (tPoll != null) {
                            interfaceC2837 = (InterfaceC2837) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z2 && z) {
                            this.disposed = true;
                            Throwable thM7019 = atomicThrowable.m7019();
                            if (thM7019 != null) {
                                this.downstream.onError(thM7019);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        if (!z) {
                            this.active = true;
                            interfaceC2837.mo10180(this.inner);
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.disposed = true;
                        this.queue.clear();
                        this.upstream.dispose();
                        atomicThrowable.m7018(th);
                        this.downstream.onError(atomicThrowable.m7019());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6704() {
            this.active = false;
            m6703();
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6705(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode != ErrorMode.IMMEDIATE) {
                this.active = false;
                m6703();
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            Throwable thM7019 = this.errors.m7019();
            if (thM7019 != ExceptionHelper.f7687) {
                this.downstream.onError(thM7019);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public ObservableConcatMapCompletable(AbstractC4262<T> abstractC4262, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, ErrorMode errorMode, int i) {
        this.f7259 = abstractC4262;
        this.f7260 = interfaceC2368;
        this.f7261 = errorMode;
        this.f7262 = i;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        if (C4053.m12972(this.f7259, this.f7260, interfaceC5053)) {
            return;
        }
        this.f7259.subscribe(new ConcatMapCompletableObserver(interfaceC5053, this.f7260, this.f7261, this.f7262));
    }
}
