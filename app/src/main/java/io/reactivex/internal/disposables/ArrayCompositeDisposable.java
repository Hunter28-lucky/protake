package io.reactivex.internal.disposables;

import defpackage.InterfaceC4478;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<InterfaceC4478> implements InterfaceC4478 {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        InterfaceC4478 andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                InterfaceC4478 interfaceC4478 = get(i);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (interfaceC4478 != disposableHelper && (andSet = getAndSet(i, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m6309(int i, InterfaceC4478 interfaceC4478) {
        InterfaceC4478 interfaceC44782;
        do {
            interfaceC44782 = get(i);
            if (interfaceC44782 == DisposableHelper.DISPOSED) {
                interfaceC4478.dispose();
                return false;
            }
        } while (!compareAndSet(i, interfaceC44782, interfaceC4478));
        if (interfaceC44782 == null) {
            return true;
        }
        interfaceC44782.dispose();
        return true;
    }
}
