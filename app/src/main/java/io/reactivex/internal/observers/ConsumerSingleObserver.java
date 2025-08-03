package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
    private static final long serialVersionUID = -7012088219455310787L;
    public final InterfaceC2857<? super Throwable> onError;
    public final InterfaceC2857<? super T> onSuccess;

    public ConsumerSingleObserver(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        this.onSuccess = interfaceC2857;
        this.onError = interfaceC28572;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(th, th2));
        }
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this, interfaceC4478);
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }
}
