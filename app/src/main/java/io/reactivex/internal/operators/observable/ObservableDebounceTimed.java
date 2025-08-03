package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C5312;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableDebounceTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7340;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7341;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7342;

    public static final class DebounceEmitter<T> extends AtomicReference<InterfaceC4478> implements Runnable, InterfaceC4478 {
        private static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final C2075<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, C2075<T> c2075) {
            this.value = t;
            this.idx = j;
            this.parent = c2075;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.m6765(this.idx, this.value, this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6764(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableDebounceTimed$Ϳ, reason: contains not printable characters */
    public static final class C2075<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f7343;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f7344;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f7345;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f7346;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4478 f7347;

        /* renamed from: ՠ, reason: contains not printable characters */
        public InterfaceC4478 f7348;

        /* renamed from: ֈ, reason: contains not printable characters */
        public volatile long f7349;

        /* renamed from: ֏, reason: contains not printable characters */
        public boolean f7350;

        public C2075(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.f7343 = interfaceC5102;
            this.f7344 = j;
            this.f7345 = timeUnit;
            this.f7346 = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f7347.dispose();
            this.f7346.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7346.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f7350) {
                return;
            }
            this.f7350 = true;
            InterfaceC4478 interfaceC4478 = this.f7348;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) interfaceC4478;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f7343.onComplete();
            this.f7346.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f7350) {
                C3671.m11803(th);
                return;
            }
            InterfaceC4478 interfaceC4478 = this.f7348;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            this.f7350 = true;
            this.f7343.onError(th);
            this.f7346.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f7350) {
                return;
            }
            long j = this.f7349 + 1;
            this.f7349 = j;
            InterfaceC4478 interfaceC4478 = this.f7348;
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
            this.f7348 = debounceEmitter;
            debounceEmitter.m6764(this.f7346.mo6991(debounceEmitter, this.f7344, this.f7345));
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f7347, interfaceC4478)) {
                this.f7347 = interfaceC4478;
                this.f7343.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6765(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.f7349) {
                this.f7343.onNext(t);
                debounceEmitter.dispose();
            }
        }
    }

    public ObservableDebounceTimed(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(interfaceC2856);
        this.f7340 = j;
        this.f7341 = timeUnit;
        this.f7342 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C2075(new C5312(interfaceC5102), this.f7340, this.f7341, this.f7342.mo6986()));
    }
}
