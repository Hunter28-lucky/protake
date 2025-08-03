package io.reactivex.internal.disposables;

import defpackage.InterfaceC4478;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SequentialDisposable extends AtomicReference<InterfaceC4478> implements InterfaceC4478 {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m6311(InterfaceC4478 interfaceC4478) {
        return DisposableHelper.replace(this, interfaceC4478);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m6312(InterfaceC4478 interfaceC4478) {
        return DisposableHelper.set(this, interfaceC4478);
    }

    public SequentialDisposable(InterfaceC4478 interfaceC4478) {
        lazySet(interfaceC4478);
    }
}
