package defpackage;

import com.blink.academy.filter.core.C1795;

/* renamed from: ಖ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4609 extends C1795 {

    /* renamed from: ރ, reason: contains not printable characters */
    public int f15708;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f15709;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f15710;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f15711;

    /* renamed from: ಖ$Ϳ, reason: contains not printable characters */
    public class RunnableC4610 implements Runnable {
        public RunnableC4610() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4609 c4609 = C4609.this;
            c4609.m4818(c4609.f15708, C4609.this.f15709);
            C4609 c46092 = C4609.this;
            c46092.m4818(c46092.f15711, C4609.this.f15710);
        }
    }

    public C4609() {
        super(m14062(), m14061());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m14061() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEU+DRdTVB1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m14062() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEU+HQBAHVRfPQM="));
    }

    @Override // com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        this.f15708 = m4815(C4625.m14082("OQYJGzg9CRISDhE="));
        this.f15711 = m4815(C4625.m14082("JgoECDgGIBIHGABG"));
        this.f15709 = 0.0017361111f;
        this.f15710 = 0.0030864198f;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m14069(float f, float f2) {
        this.f15709 = f;
        this.f15710 = f2;
        m4816(new RunnableC4610());
    }
}
