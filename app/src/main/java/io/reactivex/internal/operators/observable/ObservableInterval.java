package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.y2;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableInterval extends AbstractC4262<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f7381;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7382;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7383;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7384;

    public static final class IntervalObserver extends AtomicReference<InterfaceC4478> implements InterfaceC4478, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        public long count;
        public final InterfaceC5102<? super Long> downstream;

        public IntervalObserver(InterfaceC5102<? super Long> interfaceC5102) {
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
            if (get() != DisposableHelper.DISPOSED) {
                InterfaceC5102<? super Long> interfaceC5102 = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                interfaceC5102.onNext(Long.valueOf(j));
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6809(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7382 = j;
        this.f7383 = j2;
        this.f7384 = timeUnit;
        this.f7381 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Long> interfaceC5102) {
        IntervalObserver intervalObserver = new IntervalObserver(interfaceC5102);
        interfaceC5102.onSubscribe(intervalObserver);
        AbstractC4585 abstractC4585 = this.f7381;
        if (!(abstractC4585 instanceof y2)) {
            intervalObserver.m6809(abstractC4585.mo6989(intervalObserver, this.f7382, this.f7383, this.f7384));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = abstractC4585.mo6986();
        intervalObserver.m6809(abstractC4588Mo6986);
        abstractC4588Mo6986.mo11922(intervalObserver, this.f7382, this.f7383, this.f7384);
    }
}
