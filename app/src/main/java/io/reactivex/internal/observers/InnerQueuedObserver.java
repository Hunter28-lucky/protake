package io.reactivex.internal.observers;

import defpackage.C5263;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC4111;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478 {
    private static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final InterfaceC4111<T> parent;
    public final int prefetch;
    public InterfaceC4851<T> queue;

    public InnerQueuedObserver(InterfaceC4111<T> interfaceC4111, int i) {
        this.parent = interfaceC4111;
        this.prefetch = i;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // defpackage.InterfaceC5102
    public void onComplete() {
        this.parent.mo6758(this);
    }

    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        this.parent.mo6757(this, th);
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.mo6759(this, t);
        } else {
            this.parent.mo6756();
        }
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.setOnce(this, interfaceC4478)) {
            if (interfaceC4478 instanceof InterfaceC3164) {
                InterfaceC3164 interfaceC3164 = (InterfaceC3164) interfaceC4478;
                int iMo6310 = interfaceC3164.mo6310(3);
                if (iMo6310 == 1) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC3164;
                    this.done = true;
                    this.parent.mo6758(this);
                    return;
                }
                if (iMo6310 == 2) {
                    this.fusionMode = iMo6310;
                    this.queue = interfaceC3164;
                    return;
                }
            }
            this.queue = C5263.m15304(-this.prefetch);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m6370() {
        return this.done;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4851<T> m6371() {
        return this.queue;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m6372() {
        this.done = true;
    }
}
