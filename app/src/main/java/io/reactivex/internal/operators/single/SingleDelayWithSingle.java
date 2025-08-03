package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4495;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleDelayWithSingle<T, U> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7580;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<U> f7581;

    public static final class OtherObserver<T, U> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<U>, InterfaceC4478 {
        private static final long serialVersionUID = -8565274649390031272L;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3951<T> source;

        public OtherObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<T> interfaceC3951) {
            this.downstream = interfaceC4782;
            this.source = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(U u) {
            this.source.subscribe(new C4495(this, this.downstream));
        }
    }

    public SingleDelayWithSingle(InterfaceC3951<T> interfaceC3951, InterfaceC3951<U> interfaceC39512) {
        this.f7580 = interfaceC3951;
        this.f7581 = interfaceC39512;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7581.subscribe(new OtherObserver(interfaceC4782, this.f7580));
    }
}
