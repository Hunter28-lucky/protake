package defpackage;

/* compiled from: JobSupport.kt */
/* renamed from: ટ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4343 implements InterfaceC2528 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean f14893;

    public C4343(boolean z) {
        this.f14893 = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(mo9339() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }

    @Override // defpackage.InterfaceC2528
    /* renamed from: Ϳ */
    public boolean mo9339() {
        return this.f14893;
    }

    @Override // defpackage.InterfaceC2528
    /* renamed from: ԫ */
    public C4268 mo9340() {
        return null;
    }
}
