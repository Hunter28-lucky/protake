package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5312;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.a;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatMap<T, U> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> f7329;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7330;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ErrorMode f7331;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -6951100001833242599L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> mapper;
        public final DelayErrorInnerObserver<R> observer;
        public InterfaceC4851<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;
        public InterfaceC4478 upstream;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            public final InterfaceC5102<? super R> downstream;
            public final ConcatMapDelayErrorObserver<?, R> parent;

            public DelayErrorInnerObserver(InterfaceC5102<? super R> interfaceC5102, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = interfaceC5102;
                this.parent = concatMapDelayErrorObserver;
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.m6750();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (!concatMapDelayErrorObserver.error.m7018(th)) {
                    C3671.m11803(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.tillTheEnd) {
                    concatMapDelayErrorObserver.upstream.dispose();
                }
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.m6750();
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(R r) {
                this.downstream.onNext(r);
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6751() {
                DisposableHelper.dispose(this);
            }
        }

        public ConcatMapDelayErrorObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.bufferSize = i;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(interfaceC5102, this);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.m6751();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6750();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                m6750();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            m6750();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                if (interfaceC4478 instanceof InterfaceC3164) {
                    InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                    int iMo6310 = interfaceC3164.mo6310(3);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        m6750();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new d(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6750() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            InterfaceC4851<T> interfaceC4851 = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        interfaceC4851.clear();
                        return;
                    }
                    if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        interfaceC4851.clear();
                        this.cancelled = true;
                        interfaceC5102.onError(atomicThrowable.m7019());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T tPoll = interfaceC4851.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable thM7019 = atomicThrowable.m7019();
                            if (thM7019 != null) {
                                interfaceC5102.onError(thM7019);
                                return;
                            } else {
                                interfaceC5102.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                if (interfaceC2856 instanceof Callable) {
                                    try {
                                        a aVar = (Object) ((Callable) interfaceC2856).call();
                                        if (aVar != null && !this.cancelled) {
                                            interfaceC5102.onNext(aVar);
                                        }
                                    } catch (Throwable th) {
                                        C4089.m13026(th);
                                        atomicThrowable.m7018(th);
                                    }
                                } else {
                                    this.active = true;
                                    interfaceC2856.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                C4089.m13026(th2);
                                this.cancelled = true;
                                this.upstream.dispose();
                                interfaceC4851.clear();
                                atomicThrowable.m7018(th2);
                                interfaceC5102.onError(atomicThrowable.m7019());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        C4089.m13026(th3);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.m7018(th3);
                        interfaceC5102.onError(atomicThrowable.m7019());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = 8828587559905699186L;
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public final InterfaceC5102<? super U> downstream;
        public int fusionMode;
        public final InnerObserver<U> inner;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> mapper;
        public InterfaceC4851<T> queue;
        public InterfaceC4478 upstream;

        public static final class InnerObserver<U> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            public final InterfaceC5102<? super U> downstream;
            public final SourceObserver<?, ?> parent;

            public InnerObserver(InterfaceC5102<? super U> interfaceC5102, SourceObserver<?, ?> sourceObserver) {
                this.downstream = interfaceC5102;
                this.parent = sourceObserver;
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                this.parent.m6753();
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(U u) {
                this.downstream.onNext(u);
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this, interfaceC4478);
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6754() {
                DisposableHelper.dispose(this);
            }
        }

        public SourceObserver(InterfaceC5102<? super U> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, int i) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.bufferSize = i;
            this.inner = new InnerObserver<>(interfaceC5102, this);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            this.inner.m6754();
            this.upstream.dispose();
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
            if (this.done) {
                return;
            }
            this.done = true;
            m6752();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            m6752();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                if (interfaceC4478 instanceof InterfaceC3164) {
                    InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                    int iMo6310 = interfaceC3164.mo6310(3);
                    if (iMo6310 == 1) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        m6752();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.fusionMode = iMo6310;
                        this.queue = interfaceC3164;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new d(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6752() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T tPoll = this.queue.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                interfaceC2856.subscribe(this.inner);
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        C4089.m13026(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
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
        public void m6753() {
            this.active = false;
            m6752();
        }
    }

    public ObservableConcatMap(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, int i, ErrorMode errorMode) {
        super(interfaceC2856);
        this.f7329 = interfaceC2368;
        this.f7331 = errorMode;
        this.f7330 = Math.max(8, i);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        if (ObservableScalarXMap.m6895(this.f11778, interfaceC5102, this.f7329)) {
            return;
        }
        if (this.f7331 == ErrorMode.IMMEDIATE) {
            this.f11778.subscribe(new SourceObserver(new C5312(interfaceC5102), this.f7329, this.f7330));
        } else {
            this.f11778.subscribe(new ConcatMapDelayErrorObserver(interfaceC5102, this.f7329, this.f7330, this.f7331 == ErrorMode.END));
        }
    }
}
