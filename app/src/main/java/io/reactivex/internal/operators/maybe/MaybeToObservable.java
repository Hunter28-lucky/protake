package io.reactivex.internal.operators.maybe;

import defpackage.AbstractC4262;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class MaybeToObservable<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3517<T> f7225;

    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements InterfaceC5216<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        public InterfaceC4478 upstream;

        public MaybeToObservableObserver(InterfaceC5102<? super T> interfaceC5102) {
            super(interfaceC5102);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, defpackage.InterfaceC4478
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC5216
        public void onComplete() {
            m6367();
        }

        @Override // defpackage.InterfaceC5216
        public void onError(Throwable th) {
            m6369(th);
        }

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            m6368(t);
        }
    }

    public MaybeToObservable(InterfaceC3517<T> interfaceC3517) {
        this.f7225 = interfaceC3517;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> InterfaceC5216<T> m6676(InterfaceC5102<? super T> interfaceC5102) {
        return new MaybeToObservableObserver(interfaceC5102);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f7225.mo11463(m6676(interfaceC5102));
    }
}
