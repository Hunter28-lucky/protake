package defpackage;

/* compiled from: CancellableContinuation.kt */
/* renamed from: ৡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4215 extends AbstractC5189 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3469 f14507;

    public C4215(C3469 c3469) {
        this.f14507 = c3469;
    }

    @Override // defpackage.InterfaceC2392
    public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
        mo7352(th);
        return i4.f6762;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.f14507 + ']';
    }

    @Override // defpackage.AbstractC3825
    /* renamed from: Ϳ */
    public void mo7352(Throwable th) {
        this.f14507.mo9075();
    }
}
