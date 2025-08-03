package io.reactivex.internal.operators.single;

import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleTimeout<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7616;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7617;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7618;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7619;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7620;

    public static final class TimeoutMainObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, Runnable, InterfaceC4478 {
        private static final long serialVersionUID = 37497744973048446L;
        public final InterfaceC4782<? super T> downstream;
        public final TimeoutFallbackObserver<T> fallback;
        public InterfaceC3951<? extends T> other;
        public final AtomicReference<InterfaceC4478> task = new AtomicReference<>();
        public final long timeout;
        public final TimeUnit unit;

        public static final class TimeoutFallbackObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T> {
            private static final long serialVersionUID = 2071387740092105509L;
            public final InterfaceC4782<? super T> downstream;

            public TimeoutFallbackObserver(InterfaceC4782<? super T> interfaceC4782) {
                this.downstream = interfaceC4782;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.downstream.onError(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(T t) {
                this.downstream.onSuccess(t);
            }
        }

        public TimeoutMainObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<? extends T> interfaceC3951, long j, TimeUnit timeUnit) {
            this.downstream = interfaceC4782;
            this.other = interfaceC3951;
            this.timeout = j;
            this.unit = timeUnit;
            if (interfaceC3951 != null) {
                this.fallback = new TimeoutFallbackObserver<>(interfaceC4782);
            } else {
                this.fallback = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.task);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.fallback;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || !compareAndSet(interfaceC4478, disposableHelper)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this.task);
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || !compareAndSet(interfaceC4478, disposableHelper)) {
                return;
            }
            DisposableHelper.dispose(this.task);
            this.downstream.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper || !compareAndSet(interfaceC4478, disposableHelper)) {
                return;
            }
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            InterfaceC3951<? extends T> interfaceC3951 = this.other;
            if (interfaceC3951 == null) {
                this.downstream.onError(new TimeoutException(ExceptionHelper.m7023(this.timeout, this.unit)));
            } else {
                this.other = null;
                interfaceC3951.subscribe(this.fallback);
            }
        }
    }

    public SingleTimeout(InterfaceC3951<T> interfaceC3951, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, InterfaceC3951<? extends T> interfaceC39512) {
        this.f7616 = interfaceC3951;
        this.f7617 = j;
        this.f7618 = timeUnit;
        this.f7619 = abstractC4585;
        this.f7620 = interfaceC39512;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(interfaceC4782, this.f7620, this.f7617, this.f7618);
        interfaceC4782.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.task, this.f7619.mo6988(timeoutMainObserver, this.f7617, this.f7618));
        this.f7616.subscribe(timeoutMainObserver);
    }
}
