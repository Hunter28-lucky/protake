package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatWithSingle<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7338;

    public static final class ConcatWithObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -1953724749712440952L;
        public final InterfaceC5102<? super T> downstream;
        public boolean inSingle;
        public InterfaceC3951<? extends T> other;

        public ConcatWithObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC3951<? extends T> interfaceC3951) {
            this.downstream = interfaceC5102;
            this.other = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.inSingle = true;
            DisposableHelper.replace(this, null);
            InterfaceC3951<? extends T> interfaceC3951 = this.other;
            this.other = null;
            interfaceC3951.subscribe(this);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (!DisposableHelper.setOnce(this, interfaceC4478) || this.inSingle) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithSingle(AbstractC4262<T> abstractC4262, InterfaceC3951<? extends T> interfaceC3951) {
        super(abstractC4262);
        this.f7338 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new ConcatWithObserver(interfaceC5102, this.f7338));
    }
}
