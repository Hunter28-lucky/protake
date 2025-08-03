package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import java.nio.Buffer;

/* renamed from: ࡎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3934 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public int f13566;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f13567;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f13568;

    /* renamed from: ࡎ$Ϳ, reason: contains not printable characters */
    public class RunnableC3935 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f13569;

        public RunnableC3935(int i) {
            this.f13569 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.f13569);
            GLES20.glUniform1i(C3934.this.f13566, 1);
            C3624.m11696(C4625.m14082("KQMvBj4WOxEZHxBAVhN0AjA5KggmOiYkWg=="));
        }
    }

    /* renamed from: ࡎ$Ԩ, reason: contains not printable characters */
    public class RunnableC3936 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f13571;

        public RunnableC3936(float[] fArr) {
            this.f13571 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3934 c3934 = C3934.this;
            c3934.m4819(c3934.f13568, this.f13571);
        }
    }

    /* renamed from: ࡎ$Ԫ, reason: contains not printable characters */
    public class RunnableC3937 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Drawable2d f13573;

        public RunnableC3937(Drawable2d drawable2d) {
            this.f13573 = drawable2d;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glEnableVertexAttribArray(C3934.this.f13567);
            GLES20.glVertexAttribPointer(C3934.this.f13567, this.f13573.m4774(), 5126, false, this.f13573.m4776(), (Buffer) this.f13573.m4775());
        }
    }

    public C3934() {
        super(m12704(), m12703());
        this.f13566 = -1;
        this.f13567 = -1;
        this.f13568 = -1;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m12703() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDDgRHR0ocLAoMGiQLIx0QHgB0QVJUIwoDG34VAwcN"));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m12704() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDDgRHR0ocLAoMGiQLIx0QHgBtRVZBOgoVQTceHBg="));
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f5130, C4625.m14082("LzsIFyQHHREiBApAVwE="));
        this.f13567 = iGlGetAttribLocation;
        C3624.m11697(iGlGetAttribLocation, C4625.m14082("LzsIFyQHHREiBApAVwE="));
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OgoVGyUACkY="));
        this.f13566 = iGlGetUniformLocation;
        C3624.m11697(iGlGetUniformLocation, C4625.m14082("OgoVGyUACkY="));
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("PAgeBioX"));
        this.f13568 = iGlGetUniformLocation2;
        C3624.m11697(iGlGetUniformLocation2, C4625.m14082("PAgeBioX"));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m12709(int i) {
        m4816(new RunnableC3935(i));
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m12710(Drawable2d drawable2d) {
        m4816(new RunnableC3937(drawable2d));
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m12711(float[] fArr) {
        m4816(new RunnableC3936(fArr));
    }
}
