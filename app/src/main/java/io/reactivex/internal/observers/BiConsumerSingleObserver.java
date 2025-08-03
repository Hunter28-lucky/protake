package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5246;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
    private static final long serialVersionUID = 4943102778943297569L;
    public final InterfaceC5246<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(InterfaceC5246<? super T, ? super Throwable> interfaceC5246) {
        this.onCallback = interfaceC5246;
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
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(null, th);
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
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.onCallback.accept(t, null);
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }
}
