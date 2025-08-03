package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DisposableObserver.java */
/* renamed from: ဒ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC5105<T> implements InterfaceC5102<T>, InterfaceC4478 {
    public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        DisposableHelper.dispose(this.upstream);
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    public void onStart() {
    }

    @Override // defpackage.InterfaceC5102
    public final void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (C2889.m10247(this.upstream, interfaceC4478, getClass())) {
            onStart();
        }
    }
}
