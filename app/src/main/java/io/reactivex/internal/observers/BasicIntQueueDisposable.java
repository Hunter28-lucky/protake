package io.reactivex.internal.observers;

import defpackage.InterfaceC3164;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements InterfaceC3164<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // defpackage.InterfaceC4851
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
