package io.reactivex.internal.operators.observable;

import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
    private static final long serialVersionUID = -8612022020200669122L;
    public final InterfaceC5102<? super T> downstream;
    public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(InterfaceC5102<? super T> interfaceC5102) {
        this.downstream = interfaceC5102;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.setOnce(this.upstream, interfaceC4478)) {
            this.downstream.onSubscribe(this);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m6945(InterfaceC4478 interfaceC4478) {
        DisposableHelper.set(this, interfaceC4478);
    }
}
