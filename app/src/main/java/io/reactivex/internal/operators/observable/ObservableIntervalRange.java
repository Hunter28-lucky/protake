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
public final class ObservableIntervalRange extends AbstractC4262<Long> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4585 f7385;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7386;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7387;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final long f7388;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final long f7389;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final TimeUnit f7390;

    public static final class IntervalRangeObserver extends AtomicReference<InterfaceC4478> implements InterfaceC4478, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        public long count;
        public final InterfaceC5102<? super Long> downstream;
        public final long end;

        public IntervalRangeObserver(InterfaceC5102<? super Long> interfaceC5102, long j, long j2) {
            this.downstream = interfaceC5102;
            this.count = j;
            this.end = j2;
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
            long j = this.count;
            this.downstream.onNext(Long.valueOf(j));
            if (j != this.end) {
                this.count = j + 1;
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6810(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7388 = j3;
        this.f7389 = j4;
        this.f7390 = timeUnit;
        this.f7385 = abstractC4585;
        this.f7386 = j;
        this.f7387 = j2;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super Long> interfaceC5102) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(interfaceC5102, this.f7386, this.f7387);
        interfaceC5102.onSubscribe(intervalRangeObserver);
        AbstractC4585 abstractC4585 = this.f7385;
        if (!(abstractC4585 instanceof y2)) {
            intervalRangeObserver.m6810(abstractC4585.mo6989(intervalRangeObserver, this.f7388, this.f7389, this.f7390));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = abstractC4585.mo6986();
        intervalRangeObserver.m6810(abstractC4588Mo6986);
        abstractC4588Mo6986.mo11922(intervalRangeObserver, this.f7388, this.f7389, this.f7390);
    }
}
