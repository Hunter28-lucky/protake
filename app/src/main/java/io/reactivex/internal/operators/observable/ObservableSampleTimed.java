package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.C5312;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSampleTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7458;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7459;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7460;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7461;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger wip;

        public SampleTimedEmitLast(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(interfaceC5102, j, timeUnit, abstractC4585);
            this.wip = new AtomicInteger(1);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                m6887();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6885() {
            m6887();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(interfaceC5102, j, timeUnit, abstractC4585);
        }

        @Override // java.lang.Runnable
        public void run() {
            m6887();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        /* renamed from: Ԩ */
        public void mo6885() {
            this.downstream.onComplete();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final InterfaceC5102<? super T> downstream;
        public final long period;
        public final AbstractC4585 scheduler;
        public final AtomicReference<InterfaceC4478> timer = new AtomicReference<>();
        public final TimeUnit unit;
        public InterfaceC4478 upstream;

        public SampleTimedObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.downstream = interfaceC5102;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = abstractC4585;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            m6886();
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            m6886();
            mo6885();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            m6886();
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
                AbstractC4585 abstractC4585 = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, abstractC4585.mo6989(this, j, j, this.unit));
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6886() {
            DisposableHelper.dispose(this.timer);
        }

        /* renamed from: Ԩ */
        public abstract void mo6885();

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6887() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    public ObservableSampleTimed(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(interfaceC2856);
        this.f7458 = j;
        this.f7459 = timeUnit;
        this.f7460 = abstractC4585;
        this.f7461 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C5312 c5312 = new C5312(interfaceC5102);
        if (this.f7461) {
            this.f11778.subscribe(new SampleTimedEmitLast(c5312, this.f7458, this.f7459, this.f7460));
        } else {
            this.f11778.subscribe(new SampleTimedNoLast(c5312, this.f7458, this.f7459, this.f7460));
        }
    }
}
