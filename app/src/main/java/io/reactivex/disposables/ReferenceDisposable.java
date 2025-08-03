package io.reactivex.disposables;

import defpackage.C4246;
import defpackage.InterfaceC4478;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements InterfaceC4478 {
    private static final long serialVersionUID = 6537757548749041217L;

    public ReferenceDisposable(T t) {
        super(C4246.m13353(t, "value is null"));
    }

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        mo6296(andSet);
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return get() == null;
    }

    /* renamed from: Ϳ */
    public abstract void mo6296(T t);
}
