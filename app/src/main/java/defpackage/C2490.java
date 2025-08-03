package defpackage;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableFromFuture.java */
/* renamed from: Ǥ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2490<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Future<? extends T> f9188;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f9189;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f9190;

    public C2490(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f9188 = future;
        this.f9189 = j;
        this.f9190 = timeUnit;
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
            TimeUnit timeUnit = this.f9190;
            deferredScalarDisposable.m6368(C4246.m13353(timeUnit != null ? this.f9188.get(this.f9189, timeUnit) : this.f9188.get(), "Future returned null"));
        } catch (Throwable th) {
            C4089.m13026(th);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            interfaceC5102.onError(th);
        }
    }
}
