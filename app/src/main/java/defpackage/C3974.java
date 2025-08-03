package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.AbstractC1792;
import com.blink.academy.filter.core.C1791;

/* renamed from: ࢪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3974 extends AbstractC1792 {

    /* renamed from: އ, reason: contains not printable characters */
    public int f13906;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f13907;

    /* renamed from: މ, reason: contains not printable characters */
    public int f13908;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f13909;

    /* renamed from: ދ, reason: contains not printable characters */
    public float[] f13910;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f13911;

    /* renamed from: ލ, reason: contains not printable characters */
    public float f13912;

    /* renamed from: ގ, reason: contains not printable characters */
    public float[] f13913;

    /* renamed from: ࢪ$Ϳ, reason: contains not printable characters */
    public class RunnableC3975 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f13914;

        public RunnableC3975(float[] fArr) {
            this.f13914 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3974 c3974 = C3974.this;
            c3974.m4820(c3974.f13909, this.f13914);
        }
    }

    /* renamed from: ࢪ$Ԩ, reason: contains not printable characters */
    public class RunnableC3976 implements Runnable {
        public RunnableC3976() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3974 c3974 = C3974.this;
            c3974.m4818(c3974.f13908, C3974.this.f13912);
        }
    }

    /* renamed from: ࢪ$Ԫ, reason: contains not printable characters */
    public class RunnableC3977 implements Runnable {
        public RunnableC3977() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3974 c3974 = C3974.this;
            c3974.m4818(c3974.f13907, C3974.this.f13911);
        }
    }

    /* renamed from: ࢪ$Ԭ, reason: contains not printable characters */
    public class RunnableC3978 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float[] f13918;

        public RunnableC3978(float[] fArr) {
            this.f13918 = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3974 c3974 = C3974.this;
            c3974.m4822(c3974.f13906, this.f13918);
        }
    }

    public C3974() {
        super(m12828(), m12827());
        this.f13906 = -1;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m12827() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsNHhEdUlVBNzABAD8ZGgQ+DRdTVF5WIBtDCDwBAw=="));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m12828() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsNHhEdUlVBNzABAD8ZGgQ+HQBAR1ZLYAgBHDw="));
    }

    @Override // com.blink.academy.filter.core.AbstractC1792, com.blink.academy.filter.core.C1795, com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        super.mo4803();
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("OzsIFx0TGwYIEw=="));
        this.f13906 = iGlGetUniformLocation;
        C3624.m11697(iGlGetUniformLocation, C4625.m14082("OzsIFx0TGwYIEw=="));
        this.f13907 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("JwEZCj4BBgAY"));
        this.f13908 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("JxwvAQc="));
        this.f13909 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("KgYAHA=="));
        m12836(C2498.f9252);
        m12833(C1791.f5121);
        m12834(1.0f);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m12833(float[] fArr) {
        this.f13913 = fArr;
        m4816(new RunnableC3975(fArr));
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m12834(float f) {
        this.f13911 = f;
        m4816(new RunnableC3977());
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m12835(float f) {
        this.f13912 = f;
        m4816(new RunnableC3976());
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m12836(float[] fArr) {
        this.f13910 = fArr;
        m4816(new RunnableC3978(fArr));
    }
}
