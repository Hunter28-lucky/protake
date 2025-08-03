package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTimeout<T, U, V> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<U> f7513;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<V>> f7514;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7515;

    public static final class TimeoutConsumer extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 8708641127342403073L;
        public final long idx;
        public final InterfaceC2095 parent;

        public TimeoutConsumer(long j, InterfaceC2095 interfaceC2095) {
            this.idx = j;
            this.parent = interfaceC2095;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.mo6914(this.idx);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper) {
                C3671.m11803(th);
            } else {
                lazySet(disposableHelper);
                this.parent.mo6915(this.idx, th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            InterfaceC4478 interfaceC4478 = (InterfaceC4478) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 != disposableHelper) {
                interfaceC4478.dispose();
                lazySet(disposableHelper);
                this.parent.mo6914(this.idx);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478, InterfaceC2095 {
        private static final long serialVersionUID = -7508389464265974549L;
        public final InterfaceC5102<? super T> downstream;
        public InterfaceC2856<? extends T> fallback;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicLong index = new AtomicLong();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public TimeoutFallbackObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<?>> interfaceC2368, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.itemTimeoutIndicator = interfaceC2368;
            this.fallback = interfaceC2856;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.task.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    InterfaceC4478 interfaceC4478 = this.task.get();
                    if (interfaceC4478 != null) {
                        interfaceC4478.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.m6311(timeoutConsumer)) {
                            interfaceC2856.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.upstream.get().dispose();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.InterfaceC2097
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6914(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                InterfaceC2856<? extends T> interfaceC2856 = this.fallback;
                this.fallback = null;
                interfaceC2856.subscribe(new ObservableTimeoutTimed.C2096(this.downstream, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.InterfaceC2095
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6915(long j, Throwable th) {
            if (!this.index.compareAndSet(j, Long.MAX_VALUE)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onError(th);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6916(InterfaceC2856<?> interfaceC2856) {
            if (interfaceC2856 != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.m6311(timeoutConsumer)) {
                    interfaceC2856.subscribe(timeoutConsumer);
                }
            }
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements InterfaceC5102<T>, InterfaceC4478, InterfaceC2095 {
        private static final long serialVersionUID = 3764492702657003550L;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<?>> itemTimeoutIndicator;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public TimeoutObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<?>> interfaceC2368) {
            this.downstream = interfaceC5102;
            this.itemTimeoutIndicator = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.task.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
            } else {
                this.task.dispose();
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    InterfaceC4478 interfaceC4478 = this.task.get();
                    if (interfaceC4478 != null) {
                        interfaceC4478.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.m6311(timeoutConsumer)) {
                            interfaceC2856.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.upstream.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.upstream, interfaceC4478);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.InterfaceC2097
        /* renamed from: Ϳ */
        public void mo6914(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.InterfaceC2095
        /* renamed from: Ԩ */
        public void mo6915(long j, Throwable th) {
            if (!compareAndSet(j, Long.MAX_VALUE)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(th);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6917(InterfaceC2856<?> interfaceC2856) {
            if (interfaceC2856 != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.task.m6311(timeoutConsumer)) {
                    interfaceC2856.subscribe(timeoutConsumer);
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimeout$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2095 extends ObservableTimeoutTimed.InterfaceC2097 {
        /* renamed from: Ԩ */
        void mo6915(long j, Throwable th);
    }

    public ObservableTimeout(AbstractC4262<T> abstractC4262, InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368, InterfaceC2856<? extends T> interfaceC28562) {
        super(abstractC4262);
        this.f7513 = interfaceC2856;
        this.f7514 = interfaceC2368;
        this.f7515 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        if (this.f7515 == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(interfaceC5102, this.f7514);
            interfaceC5102.onSubscribe(timeoutObserver);
            timeoutObserver.m6917(this.f7513);
            this.f11778.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(interfaceC5102, this.f7514, this.f7515);
        interfaceC5102.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.m6916(this.f7513);
        this.f11778.subscribe(timeoutFallbackObserver);
    }
}
