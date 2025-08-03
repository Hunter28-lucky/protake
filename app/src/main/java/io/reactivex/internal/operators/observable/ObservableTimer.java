package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableTimer extends AbstractC4262<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f7524;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7525;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7526;

    public static final class TimerObserver extends AtomicReference<InterfaceC4478> implements InterfaceC4478, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public final InterfaceC5102<? super Long> downstream;

        public TimerObserver(InterfaceC5102<? super Long> interfaceC5102) {
            this.downstream = interfaceC5102;
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
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6920(InterfaceC4478 interfaceC4478) {
            DisposableHelper.trySet(this, interfaceC4478);
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7525 = j;
        this.f7526 = timeUnit;
        this.f7524 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Long> interfaceC5102) {
        TimerObserver timerObserver = new TimerObserver(interfaceC5102);
        interfaceC5102.onSubscribe(timerObserver);
        timerObserver.m6920(this.f7524.mo6988(timerObserver, this.f7525, this.f7526));
    }
}
