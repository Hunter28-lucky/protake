package defpackage;

import io.reactivex.disposables.C1972;

/* compiled from: CompletableFromAction.java */
/* renamed from: ױ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3419 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3809 f11779;

    public C3419(InterfaceC3809 interfaceC3809) {
        this.f11779 = interfaceC3809;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        InterfaceC4478 interfaceC4478M6300 = C1972.m6300();
        interfaceC5053.onSubscribe(interfaceC4478M6300);
        try {
            this.f11779.run();
            if (interfaceC4478M6300.isDisposed()) {
                return;
            }
            interfaceC5053.onComplete();
        } catch (Throwable th) {
            C4089.m13026(th);
            if (interfaceC4478M6300.isDisposed()) {
                C3671.m11803(th);
            } else {
                interfaceC5053.onError(th);
            }
        }
    }
}
