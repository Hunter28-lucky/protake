package io.reactivex.internal.operators.single;

import defpackage.AbstractC4585;
import defpackage.AbstractC4838;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleTimer extends AbstractC4838<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final long f7621;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final TimeUnit f7622;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AbstractC4585 f7623;

    public static final class TimerDisposable extends AtomicReference<InterfaceC4478> implements InterfaceC4478, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        public final InterfaceC4782<? super Long> downstream;

        public TimerDisposable(InterfaceC4782<? super Long> interfaceC4782) {
            this.downstream = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onSuccess(0L);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6962(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }
    }

    public SingleTimer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7621 = j;
        this.f7622 = timeUnit;
        this.f7623 = abstractC4585;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Long> interfaceC4782) {
        TimerDisposable timerDisposable = new TimerDisposable(interfaceC4782);
        interfaceC4782.onSubscribe(timerDisposable);
        timerDisposable.m6962(this.f7623.mo6988(timerDisposable, this.f7621, this.f7622));
    }
}
