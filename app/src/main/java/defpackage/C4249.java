package defpackage;

import com.blink.academy.filter.core.AbstractC1792;

/* renamed from: ਛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4249 extends AbstractC1792 {

    /* renamed from: އ, reason: contains not printable characters */
    public float f14578;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f14579;

    /* renamed from: ਛ$Ϳ, reason: contains not printable characters */
    public class RunnableC4250 implements Runnable {
        public RunnableC4250() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4249 c4249 = C4249.this;
            c4249.m4818(c4249.f14579, C4249.this.f14578);
        }
    }

    public C4249() {
        super(m13358(), m13357());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m13357() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEE+DRdTVB1UIhwB"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m13358() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsSBgpdR1scPQICACQaMEE+HQBAHVRfPQM="));
    }

    @Override // com.blink.academy.filter.core.AbstractC1792, com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        this.f14579 = m4815(C4625.m14082("PRsfCj4VGxw="));
        this.f14578 = 0.5f;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13362(float f) {
        this.f14578 = f;
        m4816(new RunnableC4250());
    }
}
