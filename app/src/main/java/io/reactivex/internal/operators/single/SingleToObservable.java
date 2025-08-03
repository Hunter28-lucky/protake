package io.reactivex.internal.operators.single;

import defpackage.AbstractC4262;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* loaded from: classes2.dex */
public final class SingleToObservable<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7625;

    public static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements InterfaceC4782<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        public InterfaceC4478 upstream;

        public SingleToObservableObserver(InterfaceC5102<? super T> interfaceC5102) {
            super(interfaceC5102);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, defpackage.InterfaceC4478
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            m6369(th);
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
            m6368(t);
        }
    }

    public SingleToObservable(InterfaceC3951<? extends T> interfaceC3951) {
        this.f7625 = interfaceC3951;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> InterfaceC4782<T> m6963(InterfaceC5102<? super T> interfaceC5102) {
        return new SingleToObservableObserver(interfaceC5102);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f7625.subscribe(m6963(interfaceC5102));
    }
}
