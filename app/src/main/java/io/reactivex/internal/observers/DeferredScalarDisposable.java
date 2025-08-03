package io.reactivex.internal.observers;

import defpackage.C3671;
import defpackage.InterfaceC5102;

/* loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;
    public final InterfaceC5102<? super T> downstream;
    public T value;

    public DeferredScalarDisposable(InterfaceC5102<? super T> interfaceC5102) {
        this.downstream = interfaceC5102;
    }

    @Override // defpackage.InterfaceC4851
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        set(4);
        this.value = null;
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // defpackage.InterfaceC4851
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // defpackage.InterfaceC4851
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m6367() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.downstream.onComplete();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m6368(T t) {
        int i = get();
        if ((i & 54) != 0) {
            return;
        }
        InterfaceC5102<? super T> interfaceC5102 = this.downstream;
        if (i == 8) {
            this.value = t;
            lazySet(16);
            interfaceC5102.onNext(null);
        } else {
            lazySet(2);
            interfaceC5102.onNext(t);
        }
        if (get() != 4) {
            interfaceC5102.onComplete();
        }
    }

    @Override // defpackage.InterfaceC3460
    /* renamed from: ԩ */
    public final int mo6310(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m6369(Throwable th) {
        if ((get() & 54) != 0) {
            C3671.m11803(th);
        } else {
            lazySet(2);
            this.downstream.onError(th);
        }
    }
}
