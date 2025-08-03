package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleDoOnDispose<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7584;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f7585;

    public static final class DoOnDisposeObserver<T> extends AtomicReference<InterfaceC3809> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -8583764624474935784L;
        public final InterfaceC4782<? super T> downstream;
        public InterfaceC4478 upstream;

        public DoOnDisposeObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3809 interfaceC3809) {
            this.downstream = interfaceC4782;
            lazySet(interfaceC3809);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InterfaceC3809 andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
                this.upstream.dispose();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleDoOnDispose(InterfaceC3951<T> interfaceC3951, InterfaceC3809 interfaceC3809) {
        this.f7584 = interfaceC3951;
        this.f7585 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7584.subscribe(new DoOnDisposeObserver(interfaceC4782, this.f7585));
    }
}
