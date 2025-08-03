package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C5312;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSampleWithObservable<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<?> f7462;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7463;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public volatile boolean done;
        public final AtomicInteger wip;

        public SampleMainEmitLast(InterfaceC5102<? super T> interfaceC5102, InterfaceC2856<?> interfaceC2856) {
            super(interfaceC5102, interfaceC2856);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6888() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                m6891();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo6889() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    m6891();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(InterfaceC5102<? super T> interfaceC5102, InterfaceC2856<?> interfaceC2856) {
            super(interfaceC5102, interfaceC2856);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        /* renamed from: Ԩ */
        public void mo6888() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        /* renamed from: ԫ */
        public void mo6889() {
            m6891();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -3517602651313910099L;
        public final InterfaceC5102<? super T> downstream;
        public final AtomicReference<InterfaceC4478> other = new AtomicReference<>();
        public final InterfaceC2856<?> sampler;
        public InterfaceC4478 upstream;

        public SampleMainObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2856<?> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.sampler = interfaceC2856;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            mo6888();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
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
                if (this.other.get() == null) {
                    this.sampler.subscribe(new C2090(this));
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6890() {
            this.upstream.dispose();
            mo6888();
        }

        /* renamed from: Ԩ */
        public abstract void mo6888();

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6891() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6892(Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        /* renamed from: ԫ */
        public abstract void mo6889();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean m6893(InterfaceC4478 interfaceC4478) {
            return DisposableHelper.setOnce(this.other, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSampleWithObservable$Ϳ, reason: contains not printable characters */
    public static final class C2090<T> implements InterfaceC5102<Object> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final SampleMainObserver<T> f7464;

        public C2090(SampleMainObserver<T> sampleMainObserver) {
            this.f7464 = sampleMainObserver;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f7464.m6890();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f7464.m6892(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            this.f7464.mo6889();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f7464.m6893(interfaceC4478);
        }
    }

    public ObservableSampleWithObservable(InterfaceC2856<T> interfaceC2856, InterfaceC2856<?> interfaceC28562, boolean z) {
        super(interfaceC2856);
        this.f7462 = interfaceC28562;
        this.f7463 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C5312 c5312 = new C5312(interfaceC5102);
        if (this.f7463) {
            this.f11778.subscribe(new SampleMainEmitLast(c5312, this.f7462));
        } else {
            this.f11778.subscribe(new SampleMainNoLast(c5312, this.f7462));
        }
    }
}
