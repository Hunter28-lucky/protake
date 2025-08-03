package defpackage;

import com.blink.academy.filter.core.C1793;

/* loaded from: classes.dex */
public class t3 extends s3 {

    /* renamed from: t3$Ϳ, reason: contains not printable characters */
    public class RunnableC2284 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C1793 f8567;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f8568;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ float f8569;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f8570;

        public RunnableC2284(C1793 c1793, int i, float f, int i2) {
            this.f8567 = c1793;
            this.f8568 = i;
            this.f8569 = f;
            this.f8570 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8567.m4818(this.f8568, this.f8569 / t3.this.m4813());
            this.f8567.m4818(this.f8570, 0.0f);
        }
    }

    /* renamed from: t3$Ԩ, reason: contains not printable characters */
    public class RunnableC2285 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C1793 f8572;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f8573;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f8574;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ float f8575;

        public RunnableC2285(C1793 c1793, int i, int i2, float f) {
            this.f8572 = c1793;
            this.f8573 = i;
            this.f8574 = i2;
            this.f8575 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8572.m4818(this.f8573, 0.0f);
            this.f8572.m4818(this.f8574, this.f8575 / t3.this.m4812());
        }
    }

    public t3(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
    }

    @Override // com.blink.academy.filter.core.C1794, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        m8285();
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public float m8283() {
        return 1.0f;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public float m8284() {
        return 1.0f;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m8285() {
        float fM8283 = m8283();
        C1793 c1793 = this.f5141.get(1);
        c1793.m4816(new RunnableC2284(c1793, c1793.m4815(C4625.m14082("OgoVCjwlBhAVAypUVUBWOg==")), fM8283, c1793.m4815(C4625.m14082("OgoVCjw6Ch0GAxF9VVVAKxs="))));
        float fM8284 = m8284();
        C1793 c17932 = this.f5141.get(0);
        c17932.m4816(new RunnableC2285(c17932, c17932.m4815(C4625.m14082("OgoVCjwlBhAVAypUVUBWOg==")), c17932.m4815(C4625.m14082("OgoVCjw6Ch0GAxF9VVVAKxs=")), fM8284));
    }
}
