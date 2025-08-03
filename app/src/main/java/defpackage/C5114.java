package defpackage;

import com.blink.academy.filter.core.AbstractC1792;

/* renamed from: ဘ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5114 extends AbstractC1792 {

    /* renamed from: އ, reason: contains not printable characters */
    public int f16954;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f16955;

    /* renamed from: މ, reason: contains not printable characters */
    public float f16956;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f16957;

    /* renamed from: ဘ$Ϳ, reason: contains not printable characters */
    public class RunnableC5115 implements Runnable {
        public RunnableC5115() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5114 c5114 = C5114.this;
            c5114.m4818(c5114.f16954, C5114.this.f16955);
            C5114 c51142 = C5114.this;
            c51142.m4818(c51142.f16957, C5114.this.f16956);
        }
    }

    public C5114() {
        super(m14940(), m14939());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m14939() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEY+DRdTVB1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m14940() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEY+HQBAHVRfPQM="));
    }

    @Override // com.blink.academy.filter.core.AbstractC1792, com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        this.f16954 = m4815(C4625.m14082("OQYJGzg9CRISDhE="));
        this.f16957 = m4815(C4625.m14082("JgoECDgGIBIHGABG"));
        this.f16955 = 0.0017361111f;
        this.f16956 = 0.0030864198f;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m14947(float f, float f2) {
        this.f16955 = f;
        this.f16956 = f2;
        m4816(new RunnableC5115());
    }
}
