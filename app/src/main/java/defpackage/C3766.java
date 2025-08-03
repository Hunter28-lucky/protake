package defpackage;

import com.blink.academy.filter.core.C1795;

/* renamed from: ݶ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3766 extends C1795 {

    /* renamed from: ރ, reason: contains not printable characters */
    public int f12999;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f13000;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f13001;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f13002;

    /* renamed from: ݶ$Ϳ, reason: contains not printable characters */
    public class RunnableC3767 implements Runnable {
        public RunnableC3767() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3766 c3766 = C3766.this;
            c3766.m4818(c3766.f12999, C3766.this.f13000);
            C3766 c37662 = C3766.this;
            c37662.m4818(c37662.f13002, C3766.this.f13001);
        }
    }

    public C3766() {
        super(m12055(), m12054());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m12054() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEA+DRdTVB1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m12055() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEA+HQBAHVRfPQM="));
    }

    @Override // com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        this.f12999 = m4815(C4625.m14082("OQYJGzg9CRISDhE="));
        this.f13002 = m4815(C4625.m14082("JgoECDgGIBIHGABG"));
        this.f13000 = 0.0017361111f;
        this.f13001 = 0.0030864198f;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m12062(float f, float f2) {
        this.f13000 = f;
        this.f13001 = f2;
        m4816(new RunnableC3767());
    }
}
