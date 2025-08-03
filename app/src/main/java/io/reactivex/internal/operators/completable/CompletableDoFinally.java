package io.reactivex.internal.operators.completable;

import defpackage.AbstractC2900;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class CompletableDoFinally extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f6845;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f6846;

    public static final class DoFinallyObserver extends AtomicInteger implements InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = 4109457741734051389L;
        public final InterfaceC5053 downstream;
        public final InterfaceC3809 onFinally;
        public InterfaceC4478 upstream;

        public DoFinallyObserver(InterfaceC5053 interfaceC5053, InterfaceC3809 interfaceC3809) {
            this.downstream = interfaceC5053;
            this.onFinally = interfaceC3809;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            m6374();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.downstream.onComplete();
            m6374();
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            this.downstream.onError(th);
            m6374();
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6374() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }
    }

    public CompletableDoFinally(InterfaceC2837 interfaceC2837, InterfaceC3809 interfaceC3809) {
        this.f6845 = interfaceC2837;
        this.f6846 = interfaceC3809;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f6845.mo10180(new DoFinallyObserver(interfaceC5053, this.f6846));
    }
}
