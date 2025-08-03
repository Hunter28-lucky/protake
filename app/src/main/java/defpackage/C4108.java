package defpackage;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: ड़, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4108 extends AbstractC3820 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2392<Throwable, i4> f14257;

    /* JADX WARN: Multi-variable type inference failed */
    public C4108(InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        this.f14257 = interfaceC2392;
    }

    @Override // defpackage.InterfaceC2392
    public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
        mo7352(th);
        return i4.f6762;
    }

    public String toString() {
        return "InvokeOnCancel[" + C2316.m8690(this.f14257) + '@' + C2316.m8691(this) + ']';
    }

    @Override // defpackage.AbstractC3825
    /* renamed from: Ϳ */
    public void mo7352(Throwable th) {
        this.f14257.invoke(th);
    }
}
