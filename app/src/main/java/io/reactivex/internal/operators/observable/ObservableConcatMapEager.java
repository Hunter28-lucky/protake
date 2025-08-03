package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4111;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractC3414<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f7332;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ErrorMode f7333;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7334;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f7335;

    public static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478, InterfaceC4111<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        public int activeCount;
        public volatile boolean cancelled;
        public InnerQueuedObserver<R> current;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final ErrorMode errorMode;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public InterfaceC4851<T> queue;
        public int sourceMode;
        public InterfaceC4478 upstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        public ConcatMapEagerMainObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, int i2, ErrorMode errorMode) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            m6760();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            mo6756();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                this.done = true;
                mo6756();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            mo6756();
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
                        mo6756();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
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
        public void m6755() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> innerQueuedObserverPoll = this.observers.poll();
                if (innerQueuedObserverPoll == null) {
                    return;
                } else {
                    innerQueuedObserverPoll.dispose();
                }
            }
        }

        @Override // defpackage.InterfaceC4111
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6756() {
            R rPoll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC4851<T> interfaceC4851 = this.queue;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                int i = this.activeCount;
                while (i != this.maxConcurrency) {
                    if (this.cancelled) {
                        interfaceC4851.clear();
                        m6755();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                        interfaceC4851.clear();
                        m6755();
                        interfaceC5102.onError(this.error.m7019());
                        return;
                    }
                    try {
                        T tPoll = interfaceC4851.poll();
                        if (tPoll == null) {
                            break;
                        }
                        InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                        InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                        arrayDeque.offer(innerQueuedObserver);
                        interfaceC2856.subscribe(innerQueuedObserver);
                        i++;
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.upstream.dispose();
                        interfaceC4851.clear();
                        m6755();
                        this.error.m7018(th);
                        interfaceC5102.onError(this.error.m7019());
                        return;
                    }
                }
                this.activeCount = i;
                if (this.cancelled) {
                    interfaceC4851.clear();
                    m6755();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    interfaceC4851.clear();
                    m6755();
                    interfaceC5102.onError(this.error.m7019());
                    return;
                }
                InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                        interfaceC4851.clear();
                        m6755();
                        interfaceC5102.onError(this.error.m7019());
                        return;
                    }
                    boolean z2 = this.done;
                    InnerQueuedObserver<R> innerQueuedObserverPoll = arrayDeque.poll();
                    boolean z3 = innerQueuedObserverPoll == null;
                    if (z2 && z3) {
                        if (this.error.get() == null) {
                            interfaceC5102.onComplete();
                            return;
                        }
                        interfaceC4851.clear();
                        m6755();
                        interfaceC5102.onError(this.error.m7019());
                        return;
                    }
                    if (!z3) {
                        this.current = innerQueuedObserverPoll;
                    }
                    innerQueuedObserver2 = innerQueuedObserverPoll;
                }
                if (innerQueuedObserver2 != null) {
                    InterfaceC4851<R> interfaceC4851M6371 = innerQueuedObserver2.m6371();
                    while (!this.cancelled) {
                        boolean zM6370 = innerQueuedObserver2.m6370();
                        if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            interfaceC4851.clear();
                            m6755();
                            interfaceC5102.onError(this.error.m7019());
                            return;
                        }
                        try {
                            rPoll = interfaceC4851M6371.poll();
                            z = rPoll == null;
                        } catch (Throwable th2) {
                            C4089.m13026(th2);
                            this.error.m7018(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (zM6370 && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            interfaceC5102.onNext(rPoll);
                        }
                    }
                    interfaceC4851.clear();
                    m6755();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // defpackage.InterfaceC4111
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo6757(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.dispose();
            }
            innerQueuedObserver.m6372();
            mo6756();
        }

        @Override // defpackage.InterfaceC4111
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo6758(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.m6372();
            mo6756();
        }

        @Override // defpackage.InterfaceC4111
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo6759(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.m6371().offer(r);
            mo6756();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6760() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    m6755();
                } while (decrementAndGet() != 0);
            }
        }
    }

    public ObservableConcatMapEager(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, ErrorMode errorMode, int i, int i2) {
        super(interfaceC2856);
        this.f7332 = interfaceC2368;
        this.f7333 = errorMode;
        this.f7334 = i;
        this.f7335 = i2;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        this.f11778.subscribe(new ConcatMapEagerMainObserver(interfaceC5102, this.f7332, this.f7334, this.f7335, this.f7333));
    }
}
