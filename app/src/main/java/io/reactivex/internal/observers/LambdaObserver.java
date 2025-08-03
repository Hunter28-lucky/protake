package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class LambdaObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
    private static final long serialVersionUID = -7251123623727029452L;
    public final InterfaceC3809 onComplete;
    public final InterfaceC2857<? super Throwable> onError;
    public final InterfaceC2857<? super T> onNext;
    public final InterfaceC2857<? super InterfaceC4478> onSubscribe;

    public LambdaObserver(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC2857<? super InterfaceC4478> interfaceC28573) {
        this.onNext = interfaceC2857;
        this.onError = interfaceC28572;
        this.onComplete = interfaceC3809;
        this.onSubscribe = interfaceC28573;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (isDisposed()) {
            C3671.m11803(th);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(th, th2));
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            C4089.m13026(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.setOnce(this, interfaceC4478)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                interfaceC4478.dispose();
                onError(th);
            }
        }
    }
}
