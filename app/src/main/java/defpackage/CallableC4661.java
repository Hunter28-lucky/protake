package defpackage;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableFromCallable.java */
/* renamed from: ೞ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class CallableC4661<T> extends AbstractC4262<T> implements Callable<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Callable<? extends T> f15857;

    public CallableC4661(Callable<? extends T> callable) {
        this.f15857 = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) C4246.m13353(this.f15857.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(interfaceC5102);
        interfaceC5102.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.m6368(C4246.m13353(this.f15857.call(), "Callable returned null"));
        } catch (Throwable th) {
            C4089.m13026(th);
            if (deferredScalarDisposable.isDisposed()) {
                C3671.m11803(th);
            } else {
                interfaceC5102.onError(th);
            }
        }
    }
}
