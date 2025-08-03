package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.InterfaceC5102;
import defpackage.InterfaceCallableC5143;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* compiled from: ObservableJust.java */
/* renamed from: io.reactivex.internal.operators.observable.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2105<T> extends AbstractC4262<T> implements InterfaceCallableC5143<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T f7565;

    public C2105(T t) {
        this.f7565 = t;
    }

    @Override // defpackage.InterfaceCallableC5143, java.util.concurrent.Callable
    public T call() {
        return this.f7565;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(interfaceC5102, this.f7565);
        interfaceC5102.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
