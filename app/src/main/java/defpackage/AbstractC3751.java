package defpackage;

/* compiled from: JobSupport.kt */
/* renamed from: ݨ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3751 extends AbstractC5076 implements InterfaceC2645, InterfaceC2528 {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C2680 f12970;

    @Override // defpackage.InterfaceC2645
    public void dispose() {
        m12027().m9877(this);
    }

    @Override // defpackage.C3469
    public String toString() {
        return C2316.m8690(this) + '@' + C2316.m8691(this) + "[job@" + C2316.m8691(m12027()) + ']';
    }

    @Override // defpackage.InterfaceC2528
    /* renamed from: Ϳ */
    public boolean mo9339() {
        return true;
    }

    @Override // defpackage.InterfaceC2528
    /* renamed from: ԫ */
    public C4268 mo9340() {
        return null;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final C2680 m12027() {
        C2680 c2680 = this.f12970;
        if (c2680 != null) {
            return c2680;
        }
        C3921.m12681("job");
        throw null;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m12028(C2680 c2680) {
        this.f12970 = c2680;
    }
}
