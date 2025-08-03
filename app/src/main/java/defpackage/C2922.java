package defpackage;

import com.blink.academy.filter.core.C1793;

/* renamed from: і, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2922 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public int f10625;

    /* renamed from: і$Ϳ, reason: contains not printable characters */
    public class RunnableC2923 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f10626;

        public RunnableC2923(float[] fArr) {
            this.f10626 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2922 c2922 = C2922.this;
            c2922.m4819(c2922.f10625, this.f10626);
        }
    }

    public C2922() {
        super(m10319(), m10318());
        this.f10625 = -1;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m10318() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHFFcNjAPAyUAMBITCgJfVl1HYAgBHDw="));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m10319() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        int iM4814 = m4814(this.f5130, C4625.m14082("PQcECSQ="));
        this.f10625 = iM4814;
        C3624.m11697(iM4814, C4625.m14082("PQcECSQ+ABc="));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m10320(float[] fArr) {
        m4816(new RunnableC2923(fArr));
    }
}
