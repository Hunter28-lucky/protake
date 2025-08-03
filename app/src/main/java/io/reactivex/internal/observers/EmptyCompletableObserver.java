package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class EmptyCompletableObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478 {
    private static final long serialVersionUID = -7545121636549663526L;

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // defpackage.InterfaceC5053
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // defpackage.InterfaceC5053
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        C3671.m11803(new OnErrorNotImplementedException(th));
    }

    @Override // defpackage.InterfaceC5053
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this, interfaceC4478);
    }
}
