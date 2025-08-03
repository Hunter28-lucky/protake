package io.reactivex.internal.disposables;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC4478;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CancellableDisposable extends AtomicReference<InterfaceC2672> implements InterfaceC4478 {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(InterfaceC2672 interfaceC2672) {
        super(interfaceC2672);
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        InterfaceC2672 andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            C4089.m13026(e2);
            C3671.m11803(e2);
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get() == null;
    }
}
