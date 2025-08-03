package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTimeoutTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7516;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7517;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7518;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f7519;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478, InterfaceC2097 {
        private static final long serialVersionUID = 3764492702657003550L;
        public final InterfaceC5102<? super T> downstream;
        public InterfaceC2856<? extends T> fallback;
        public final long timeout;
        public final TimeUnit unit;
        public final AbstractC4585.AbstractC4588 worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicLong index = new AtomicLong();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public TimeoutFallbackObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
            this.fallback = interfaceC2856;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
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
                this.worker.dispose();
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
            this.worker.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    m6918(j2);
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
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                InterfaceC2856<? extends T> interfaceC2856 = this.fallback;
                this.fallback = null;
                interfaceC2856.subscribe(new C2096(this.downstream, this));
                this.worker.dispose();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6918(long j) {
            this.task.m6311(this.worker.mo6991(new RunnableC2098(j, this), this.timeout, this.unit));
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements InterfaceC5102<T>, InterfaceC4478, InterfaceC2097 {
        private static final long serialVersionUID = 3764492702657003550L;
        public final InterfaceC5102<? super T> downstream;
        public final long timeout;
        public final TimeUnit unit;
        public final AbstractC4585.AbstractC4588 worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

        public TimeoutObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.downstream = interfaceC5102;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
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
                this.worker.dispose();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                C3671.m11803(th);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t);
                    m6919(j2);
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
                this.downstream.onError(new TimeoutException(ExceptionHelper.m7023(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6919(long j) {
            this.task.m6311(this.worker.mo6991(new RunnableC2098(j, this), this.timeout, this.unit));
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimeoutTimed$Ϳ, reason: contains not printable characters */
    public static final class C2096<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f7520;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f7521;

        public C2096(InterfaceC5102<? super T> interfaceC5102, AtomicReference<InterfaceC4478> atomicReference) {
            this.f7520 = interfaceC5102;
            this.f7521 = atomicReference;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7520.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7520.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f7520.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this.f7521, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimeoutTimed$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2097 {
        /* renamed from: Ϳ */
        void mo6914(long j);
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimeoutTimed$Ԫ, reason: contains not printable characters */
    public static final class RunnableC2098 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2097 f7522;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f7523;

        public RunnableC2098(long j, InterfaceC2097 interfaceC2097) {
            this.f7523 = j;
            this.f7522 = interfaceC2097;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7522.mo6914(this.f7523);
        }
    }

    public ObservableTimeoutTimed(AbstractC4262<T> abstractC4262, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, InterfaceC2856<? extends T> interfaceC2856) {
        super(abstractC4262);
        this.f7516 = j;
        this.f7517 = timeUnit;
        this.f7518 = abstractC4585;
        this.f7519 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        if (this.f7519 == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(interfaceC5102, this.f7516, this.f7517, this.f7518.mo6986());
            interfaceC5102.onSubscribe(timeoutObserver);
            timeoutObserver.m6919(0L);
            this.f11778.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(interfaceC5102, this.f7516, this.f7517, this.f7518.mo6986(), this.f7519);
        interfaceC5102.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.m6918(0L);
        this.f11778.subscribe(timeoutFallbackObserver);
    }
}
