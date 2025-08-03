package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3517<? extends T> f7337;

    public static final class ConcatWithObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC5216<T>, InterfaceC4478 {
        private static final long serialVersionUID = -1953724749712440952L;
        public final InterfaceC5102<? super T> downstream;
        public boolean inMaybe;
        public InterfaceC3517<? extends T> other;

        public ConcatWithObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC3517<? extends T> interfaceC3517) {
            this.downstream = interfaceC5102;
            this.other = interfaceC3517;
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
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            InterfaceC3517<? extends T> interfaceC3517 = this.other;
            this.other = null;
            interfaceC3517.mo11463(this);
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
            if (!DisposableHelper.setOnce(this, interfaceC4478) || this.inMaybe) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithMaybe(AbstractC4262<T> abstractC4262, InterfaceC3517<? extends T> interfaceC3517) {
        super(abstractC4262);
        this.f7337 = interfaceC3517;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new ConcatWithObserver(interfaceC5102, this.f7337));
    }
}
