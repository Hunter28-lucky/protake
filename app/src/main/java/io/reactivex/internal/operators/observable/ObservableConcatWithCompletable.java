package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2837 f7336;

    public static final class ConcatWithObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = -1953724749712440952L;
        public final InterfaceC5102<? super T> downstream;
        public boolean inCompletable;
        public InterfaceC2837 other;

        public ConcatWithObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2837 interfaceC2837) {
            this.downstream = interfaceC5102;
            this.other = interfaceC2837;
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
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            InterfaceC2837 interfaceC2837 = this.other;
            this.other = null;
            interfaceC2837.mo10180(this);
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
            if (!DisposableHelper.setOnce(this, interfaceC4478) || this.inCompletable) {
                return;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public ObservableConcatWithCompletable(AbstractC4262<T> abstractC4262, InterfaceC2837 interfaceC2837) {
        super(abstractC4262);
        this.f7336 = interfaceC2837;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new ConcatWithObserver(interfaceC5102, this.f7336));
    }
}
