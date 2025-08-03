package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaterializeSingleObserver.java */
/* renamed from: ਧ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4265<T> implements InterfaceC4782<T>, InterfaceC5216<T>, InterfaceC5053, InterfaceC4478 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC4782<? super C3906<T>> f14627;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4478 f14628;

    public C4265(InterfaceC4782<? super C3906<T>> interfaceC4782) {
        this.f14627 = interfaceC4782;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        this.f14628.dispose();
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return this.f14628.isDisposed();
    }

    @Override // defpackage.InterfaceC5216
    public void onComplete() {
        this.f14627.onSuccess(C3906.m12645());
    }

    @Override // defpackage.InterfaceC4782
    public void onError(Throwable th) {
        this.f14627.onSuccess(C3906.m12646(th));
    }

    @Override // defpackage.InterfaceC4782
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.validate(this.f14628, interfaceC4478)) {
            this.f14628 = interfaceC4478;
            this.f14627.onSubscribe(this);
        }
    }

    @Override // defpackage.InterfaceC4782
    public void onSuccess(T t) {
        this.f14627.onSuccess(C3906.m12647(t));
    }
}
