package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.C1793;

/* renamed from: ԉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3142 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public int f11157;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f11158;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f11159;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f11160;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f11161;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f11162;

    /* renamed from: އ, reason: contains not printable characters */
    public int f11163;

    /* renamed from: ԉ$Ϳ, reason: contains not printable characters */
    public class RunnableC3143 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f11164;

        public RunnableC3143(float[] fArr) {
            this.f11164 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3142 c3142 = C3142.this;
            c3142.m4819(c3142.f11163, this.f11164);
        }
    }

    /* renamed from: ԉ$Ԩ, reason: contains not printable characters */
    public class RunnableC3144 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f11166;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f11167;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f11168;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ int f11169;

        public RunnableC3144(int i, int i2, int i3, int i4) {
            this.f11166 = i;
            this.f11167 = i2;
            this.f11168 = i3;
            this.f11169 = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.f11166);
            GLES20.glUniform1i(C3142.this.f11157, 1);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.f11167);
            GLES20.glUniform1i(C3142.this.f11158, 2);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f11168);
            GLES20.glUniform1i(C3142.this.f11159, 3);
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f11169);
            GLES20.glUniform1i(C3142.this.f11160, 4);
        }
    }

    /* renamed from: ԉ$Ԫ, reason: contains not printable characters */
    public class RunnableC3145 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f11171;

        public RunnableC3145(float[] fArr) {
            this.f11171 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3142 c3142 = C3142.this;
            c3142.m4820(c3142.f11161, this.f11171);
        }
    }

    /* renamed from: ԉ$Ԭ, reason: contains not printable characters */
    public class RunnableC3146 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f11173;

        public RunnableC3146(float[] fArr) {
            this.f11173 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3142 c3142 = C3142.this;
            c3142.m4820(c3142.f11162, this.f11173);
        }
    }

    public C3142() {
        super(m10737(), m10736());
        this.f11157 = -1;
        this.f11158 = -1;
        this.f11159 = -1;
        this.f11160 = -1;
        this.f11161 = -1;
        this.f11162 = -1;
        this.f11163 = -1;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m10736() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDDgRHR0ocLAoMGiQLPBEGBgBcR3VBLwgACj4GQRMNGAk="));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m10737() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OgoVGyUACkU="));
        this.f11157 = iGlGetUniformLocation;
        C3624.m11697(iGlGetUniformLocation, C4625.m14082("OgoVGyUACkU="));
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OgoVGyUACkY="));
        this.f11158 = iGlGetUniformLocation2;
        C3624.m11697(iGlGetUniformLocation2, C4625.m14082("OgoVGyUACkY="));
        int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OgoVGyUACkc="));
        this.f11159 = iGlGetUniformLocation3;
        C3624.m11697(iGlGetUniformLocation3, C4625.m14082("OgoVGyUACkc="));
        int iGlGetUniformLocation4 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OgoVGyUACkA="));
        this.f11160 = iGlGetUniformLocation4;
        C3624.m11697(iGlGetUniformLocation4, C4625.m14082("OgoVGyUACkA="));
        int iGlGetUniformLocation5 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("KgYAHA=="));
        this.f11161 = iGlGetUniformLocation5;
        C3624.m11697(iGlGetUniformLocation5, C4625.m14082("KgYAHA=="));
        int iGlGetUniformLocation6 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("PRsfCj4VGxw="));
        this.f11162 = iGlGetUniformLocation6;
        C3624.m11697(iGlGetUniformLocation6, C4625.m14082("PRsfCj4VGxw="));
        this.f11163 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("PQYXCg=="));
        C3624.m11697(this.f11162, C4625.m14082("PQYXChwdDA=="));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m10748(int i, int i2, int i3, int i4) {
        m4816(new RunnableC3144(i, i2, i3, i4));
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m10749(float[] fArr) {
        m4816(new RunnableC3143(fArr));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m10750(float[] fArr) {
        m4816(new RunnableC3146(fArr));
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m10751(float[] fArr) {
        m4816(new RunnableC3145(fArr));
    }
}
