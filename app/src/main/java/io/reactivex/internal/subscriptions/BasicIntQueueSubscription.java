package io.reactivex.internal.subscriptions;

import defpackage.InterfaceC2968;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements InterfaceC2968<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // defpackage.InterfaceC4851
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
