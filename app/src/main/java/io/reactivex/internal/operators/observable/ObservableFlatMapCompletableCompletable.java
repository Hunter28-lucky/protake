package io.reactivex.internal.operators.observable;

import defpackage.AbstractC2900;
import defpackage.AbstractC4262;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2325;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends AbstractC2900 implements InterfaceC2325<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f7360;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7361;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7362;

    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements InterfaceC4478, InterfaceC5102<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final InterfaceC5053 downstream;
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
                FlatMapCompletableMainObserver.this.m6780(this);
            }

            @Override // defpackage.InterfaceC5053
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.m6781(this, th);
            }

            @Override // defpackage.InterfaceC5053
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public FlatMapCompletableMainObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
            this.downstream = interfaceC5053;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
            lazySet(1);
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

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6780(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.mo9335(innerObserver);
            onComplete();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6781(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.mo9335(innerObserver);
            onError(th);
        }
    }

    public ObservableFlatMapCompletableCompletable(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        this.f7360 = interfaceC2856;
        this.f7361 = interfaceC2368;
        this.f7362 = z;
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ, reason: contains not printable characters */
    public AbstractC4262<T> mo6779() {
        return C3671.m11798(new ObservableFlatMapCompletable(this.f7360, this.f7361, this.f7362));
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f7360.subscribe(new FlatMapCompletableMainObserver(interfaceC5053, this.f7361, this.f7362));
    }
}
