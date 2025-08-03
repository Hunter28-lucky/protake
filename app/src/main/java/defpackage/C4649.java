package defpackage;

/* compiled from: JobSupport.kt */
/* renamed from: ರ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4649 extends C2680 implements InterfaceC4073 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f15816;

    public C4649(InterfaceC5238 interfaceC5238) {
        super(true);
        m9860(interfaceC5238);
        this.f15816 = m14119();
    }

    @Override // defpackage.C2680
    /* renamed from: ޗ */
    public boolean mo9854() {
        return this.f15816;
    }

    @Override // defpackage.C2680
    /* renamed from: ޘ */
    public boolean mo9855() {
        return true;
    }

    /* renamed from: ࢧ, reason: contains not printable characters */
    public final boolean m14119() {
        InterfaceC3243 interfaceC3243M9857 = m9857();
        C3931 c3931 = interfaceC3243M9857 instanceof C3931 ? (C3931) interfaceC3243M9857 : null;
        if (c3931 == null) {
            return false;
        }
        C2680 c2680M12027 = c3931.m12027();
        while (!c2680M12027.mo9854()) {
            InterfaceC3243 interfaceC3243M98572 = c2680M12027.m9857();
            C3931 c39312 = interfaceC3243M98572 instanceof C3931 ? (C3931) interfaceC3243M98572 : null;
            if (c39312 == null) {
                return false;
            }
            c2680M12027 = c39312.m12027();
        }
        return true;
    }
}
