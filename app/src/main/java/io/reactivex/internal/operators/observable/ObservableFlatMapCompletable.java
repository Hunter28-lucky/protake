package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7358;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7359;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements InterfaceC5102<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;
        public InterfaceC4478 upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final C2527 set = new C2527();

        public final class InnerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // defpackage.InterfaceC5053
            public void onComplete() {
                FlatMapCompletableMainObserver.this.m6777(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.m6778(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public FlatMapCompletableMainObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return true;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thM7019 = this.errors.m7019();
                if (thM7019 != null) {
                    this.downstream.onError(thM7019);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.downstream.onError(this.errors.m7019());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.downstream.onError(this.errors.m7019());
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            try {
                InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.disposed || !this.set.mo9333(innerObserver)) {
                    return;
                }
                interfaceC2837.mo10180(innerObserver);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            return null;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6777(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.mo9335(innerObserver);
            onComplete();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6778(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.mo9335(innerObserver);
            onError(th);
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return i & 2;
        }
    }

    public ObservableFlatMapCompletable(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        super(interfaceC2856);
        this.f7358 = interfaceC2368;
        this.f7359 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new FlatMapCompletableMainObserver(interfaceC5102, this.f7358, this.f7359));
    }
}
