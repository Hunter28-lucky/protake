package defpackage;

import io.reactivex.disposables.C1972;

/* compiled from: CompletableFromRunnable.java */
/* renamed from: ཙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5047 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Runnable f16819;

    public C5047(Runnable runnable) {
        this.f16819 = runnable;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        InterfaceC4478 interfaceC4478M6300 = C1972.m6300();
        interfaceC5053.onSubscribe(interfaceC4478M6300);
        try {
            this.f16819.run();
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
