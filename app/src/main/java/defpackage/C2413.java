package defpackage;

import com.blink.academy.filter.core.C1795;

/* renamed from: ƍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2413 extends C1795 {

    /* renamed from: ރ, reason: contains not printable characters */
    public int f8998;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f8999;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f9000;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f9001;

    /* renamed from: ƍ$Ϳ, reason: contains not printable characters */
    public class RunnableC2414 implements Runnable {
        public RunnableC2414() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2413 c2413 = C2413.this;
            c2413.m4818(c2413.f8998, C2413.this.f8999);
            C2413 c24132 = C2413.this;
            c24132.m4818(c24132.f9001, C2413.this.f9000);
        }
    }

    public C2413() {
        super(m8904(), m8903());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m8903() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEc+DRdTVB1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m8904() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEc+HQBAHVRfPQM="));
    }

    @Override // com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        this.f8998 = m4815(C4625.m14082("OQYJGzg9CRISDhE="));
        this.f9001 = m4815(C4625.m14082("JgoECDgGIBIHGABG"));
        this.f8999 = 0.0017361111f;
        this.f9000 = 0.0030864198f;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m8911(float f, float f2) {
        this.f8999 = f;
        this.f9000 = f2;
        m4816(new RunnableC2414());
    }
}
