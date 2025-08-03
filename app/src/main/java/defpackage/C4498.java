package defpackage;

import android.opengl.GLES20;
import com.blink.academy.filter.core.C1793;
import com.blink.academy.filter.core.Drawable2d;
import defpackage.C4374;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;

/* renamed from: ఇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4498 extends C1793 {

    /* renamed from: ށ, reason: contains not printable characters */
    public int f15410;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f15411;

    /* renamed from: ރ, reason: contains not printable characters */
    public HashMap<String, Integer> f15412;

    /* renamed from: ఇ$Ϳ, reason: contains not printable characters */
    public class RunnableC4499 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f15413;

        public RunnableC4499(float f) {
            this.f15413 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4498 c4498 = C4498.this;
            c4498.m4818(c4498.f15410, this.f15413);
        }
    }

    /* renamed from: ఇ$Ԩ, reason: contains not printable characters */
    public class RunnableC4500 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f15415;

        public RunnableC4500(int i) {
            this.f15415 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4498 c4498 = C4498.this;
            c4498.m4821(c4498.f15411, this.f15415);
        }
    }

    /* renamed from: ఇ$Ԫ, reason: contains not printable characters */
    public class RunnableC4501 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ List f15417;

        public RunnableC4501(List list) {
            this.f15417 = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f15417.size(); i++) {
                C4374.C4376 c4376 = (C4374.C4376) this.f15417.get(i);
                C4498.this.m4821(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcR0pDKw=="), Integer.valueOf(i)))).intValue(), c4376.f15052);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVxfIg=="), Integer.valueOf(i)))).intValue(), c4376.f15053);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcWl1HKwEeBiQL"), Integer.valueOf(i)))).intValue(), c4376.f15054);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcQEdBKwEKGzg="), Integer.valueOf(i)))).intValue(), c4376.f15055);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcUl1UIgo="), Integer.valueOf(i)))).intValue(), c4376.f15056);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcUFZdOgofNw=="), Integer.valueOf(i)))).intValue(), c4376.f15057.f15050);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcUFZdOgofNg=="), Integer.valueOf(i)))).intValue(), c4376.f15057.f15051);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVJXJwA1"), Integer.valueOf(i)))).intValue(), c4376.f15058.f15050);
                C4498.this.m4818(((Integer) C4498.this.f15412.get(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVJXJwA0"), Integer.valueOf(i)))).intValue(), c4376.f15058.f15051);
            }
        }
    }

    public C4498() {
        super(m13786(), m13785());
        this.f15410 = -1;
        this.f15411 = -1;
        this.f15412 = new HashMap<>();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m13785() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDDgRHR0ocLAoMGiQLIx0QHgB/UlhWCB0MCD0XAQBPDAlBXw=="));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m13786() {
        return C4596.m14056(C4625.m14082("KAYBGzUAHFsDChZXHEBaIx8BCg8ECgYVDh0cVF9AIg=="));
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: Ԫ */
    public void mo4802(int i, float[] fArr, float[] fArr2, Drawable2d drawable2d) {
        if (!this.f5131) {
            mo4803();
        }
        C3624.m11696(C4625.m14082("Kh0MGHABGxUTHw=="));
        GLES20.glUseProgram(this.f5130);
        C3624.m11696(C4625.m14082("KQM4HDUiHRsGGQRf"));
        m4817();
        GLES20.glUniformMatrix4fv(this.f5133, 1, false, fArr, 0);
        C3624.m11696(C4625.m14082("KQM4ATkUAAYMJgRGQVpLegkb"));
        GLES20.glUniformMatrix4fv(this.f5134, 1, false, fArr2, 0);
        C3624.m11696(C4625.m14082("KQM4ATkUAAYMJgRGQVpLegkb"));
        GLES20.glEnableVertexAttribArray(this.f5136);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5136, drawable2d.m4774(), 5126, false, drawable2d.m4779(), (Buffer) drawable2d.m4777());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glEnableVertexAttribArray(this.f5137);
        C3624.m11696(C4625.m14082("KQMoATEQAxE3DhdGVktyOhsfBjIzHQYAEg=="));
        GLES20.glVertexAttribPointer(this.f5137, drawable2d.m4774(), 5126, false, drawable2d.m4776(), (Buffer) drawable2d.m4775());
        C3624.m11696(C4625.m14082("KQM7CiIGCgwgHxFAWlFjIQYDGzUA"));
        GLES20.glDrawArrays(5, 0, drawable2d.m4778());
        C3624.m11696(C4625.m14082("KQMpHTEFLgYTChxB"));
        GLES20.glDisableVertexAttribArray(this.f5136);
        GLES20.glDisableVertexAttribArray(this.f5137);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
    }

    @Override // com.blink.academy.filter.core.C1793
    /* renamed from: ׯ */
    public void mo4803() {
        if (this.f5131) {
            return;
        }
        int iM9464 = C2584.m9464(this.f5128, this.f5129);
        this.f5130 = iM9464;
        int iM4814 = m4814(iM9464, C4625.m14082("OyI7Px0TGwYIEw=="));
        this.f5133 = iM4814;
        C3624.m11697(iM4814, C4625.m14082("OyI7Px0TGwYIEw=="));
        int iM48142 = m4814(this.f5130, C4625.m14082("OzsIFx0TGwYIEw=="));
        this.f5134 = iM48142;
        C3624.m11697(iM48142, C4625.m14082("OzsIFx0TGwYIEw=="));
        int iM4810 = m4810(this.f5130, C4625.m14082("Lz8CHDkGBhsP"));
        this.f5136 = iM4810;
        C3624.m11697(iM4810, C4625.m14082("Lz8CHDkGBhsP"));
        int iM48102 = m4810(this.f5130, C4625.m14082("LzsIFyQHHREiBApAVw=="));
        this.f5137 = iM48102;
        C3624.m11697(iM48102, C4625.m14082("LzsIFyQHHREiBApAVw=="));
        this.f5131 = true;
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("LxwdCjMGPRUVAgo="));
        this.f15410 = iGlGetUniformLocation;
        C3624.m11697(iGlGetUniformLocation, C4625.m14082("LxwdCjMGPRUVAgo="));
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f5130, C4625.m14082("LQAYASQB"));
        this.f15411 = iGlGetUniformLocation2;
        C3624.m11697(iGlGetUniformLocation2, C4625.m14082("LQAYASQB"));
        for (int i = 0; i < 12; i++) {
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcR0pDKw=="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVxfIg=="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcWl1HKwEeBiQL"), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcQEdBKwEKGzg="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcUl1UIgo="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcUFZdOgofNw=="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcUFZdOgofNg=="), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVJXJwA1"), Integer.valueOf(i)));
            m13801(String.format(C4625.m14082("OzAEATYdHC9EGDgcQVJXJwA0"), Integer.valueOf(i)));
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m13799(float f) {
        m4816(new RunnableC4499(f));
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m13800(int i) {
        m4816(new RunnableC4500(i));
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m13801(String str) {
        this.f15412.put(str, Integer.valueOf(GLES20.glGetUniformLocation(this.f5130, str)));
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m13802(List<C4374.C4376> list) {
        m4816(new RunnableC4501(list));
    }
}
