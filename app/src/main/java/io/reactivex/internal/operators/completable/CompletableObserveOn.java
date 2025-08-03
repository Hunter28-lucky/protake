package io.reactivex.internal.operators.completable;

import defpackage.AbstractC2900;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableObserveOn extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f6847;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f6848;

    public static final class ObserveOnCompletableObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        public final InterfaceC5053 downstream;
        public Throwable error;
        public final AbstractC4585 scheduler;

        public ObserveOnCompletableObserver(InterfaceC5053 interfaceC5053, AbstractC4585 abstractC4585) {
            this.downstream = interfaceC5053;
            this.scheduler = abstractC4585;
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
            DisposableHelper.replace(this, this.scheduler.mo6987(this));
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            this.error = th;
            DisposableHelper.replace(this, this.scheduler.mo6987(this));
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.error;
            if (th == null) {
                this.downstream.onComplete();
            } else {
                this.error = null;
                this.downstream.onError(th);
            }
        }
    }

    public CompletableObserveOn(InterfaceC2837 interfaceC2837, AbstractC4585 abstractC4585) {
        this.f6847 = interfaceC2837;
        this.f6848 = abstractC4585;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f6847.mo10180(new ObserveOnCompletableObserver(interfaceC5053, this.f6848));
    }
}
