package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: CompletableError.java */
/* renamed from: દ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4353 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Throwable f14910;

    public C4353(Throwable th) {
        this.f14910 = th;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        EmptyDisposable.error(this.f14910, interfaceC5053);
    }
}
