package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC4262;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CompletableAndThenObservable<R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f7226;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends R> f7227;

    public static final class AndThenObservableObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<R>, InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = -8948264376121066672L;
        public final InterfaceC5102<? super R> downstream;
        public InterfaceC2856<? extends R> other;

        public AndThenObservableObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2856<? extends R> interfaceC2856) {
            this.other = interfaceC2856;
            this.downstream = interfaceC5102;
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
            InterfaceC2856<? extends R> interfaceC2856 = this.other;
            if (interfaceC2856 == null) {
                this.downstream.onComplete();
            } else {
                this.other = null;
                interfaceC2856.subscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }
    }

    public CompletableAndThenObservable(InterfaceC2837 interfaceC2837, InterfaceC2856<? extends R> interfaceC2856) {
        this.f7226 = interfaceC2837;
        this.f7227 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(interfaceC5102, this.f7227);
        interfaceC5102.onSubscribe(andThenObservableObserver);
        this.f7226.mo10180(andThenObservableObserver);
    }
}
