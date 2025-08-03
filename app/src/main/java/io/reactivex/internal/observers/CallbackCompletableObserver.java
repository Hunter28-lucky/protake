package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5053;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CallbackCompletableObserver extends AtomicReference<InterfaceC4478> implements InterfaceC5053, InterfaceC4478, InterfaceC2857<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    public final InterfaceC3809 onComplete;
    public final InterfaceC2857<? super Throwable> onError;

    public CallbackCompletableObserver(InterfaceC2857<? super Throwable> interfaceC2857, InterfaceC3809 interfaceC3809) {
        this.onError = interfaceC2857;
        this.onComplete = interfaceC3809;
    }

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
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // defpackage.InterfaceC5053
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // defpackage.InterfaceC5053
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        DisposableHelper.setOnce(this, interfaceC4478);
    }

    @Override // defpackage.InterfaceC2857
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        C3671.m11803(new OnErrorNotImplementedException(th));
    }
}
