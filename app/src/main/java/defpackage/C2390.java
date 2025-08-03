package defpackage;

import android.opengl.GLES20;
import android.util.Log;
import jp.co.cyberagent.android.gpuimage.RenderException;

/* compiled from: Framebuffer.java */
/* renamed from: ũ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2390 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int[] f8943;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3880 f8944;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f8945;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f8946;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f8947;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f8948;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f8949;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public long f8950;

    public C2390(int i, int i2, boolean z) {
        this(i, i2, 6408);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C2390 m8876(int i, int i2, int i3) {
        return new C2390(i2, i3, 0, 0, i);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static C2390 m8877(int i) {
        return new C2390(0, 0, 0, i, -1);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m8878() {
        GLES20.glBindFramebuffer(36160, m8881());
        GLES20.glViewport(0, 0, this.f8945, this.f8946);
        GLES20.glScissor(0, 0, this.f8945, this.f8946);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8879() {
        if (C4650.m14125() == this.f8950) {
            return;
        }
        Log.e("Framebuffer", "FBO context mismatch");
        throw new RenderException("FBO context mismatch");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized void m8880() {
        this.f8949 = true;
        if (this.f8948) {
            C3880 c3880 = this.f8944;
            if (c3880 != null) {
                c3880.m12326();
                this.f8944 = null;
            }
            m8879();
            int[] iArr = this.f8943;
            if (iArr[0] != 0) {
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.f8943[0] = 0;
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m8881() {
        m8879();
        if (!this.f8949) {
            return this.f8943[0];
        }
        Log.e("Framebuffer", "fbo already destroyed");
        return 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m8882() {
        return this.f8944.m12327();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int m8883() {
        int iM8882 = m8882();
        this.f8944 = null;
        return iM8882;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m8884() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public C2390(int i, int i2, int i3) {
        int[] iArr = {0};
        this.f8943 = iArr;
        this.f8945 = i;
        this.f8946 = i2;
        this.f8947 = i3;
        this.f8948 = true;
        this.f8950 = C4650.m14125();
        this.f8944 = new C3880(i, i2, i3);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, m8882(), 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            throw new RuntimeException("framebuffer incomplete.");
        }
        Log.d("Framebuffer", String.format("allocated a new fbo:%d for texture:%dwidth:%d height:%d", Integer.valueOf(iArr[0]), Integer.valueOf(m8882()), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public C2390(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = {0};
        this.f8943 = iArr;
        this.f8945 = i;
        this.f8946 = i2;
        this.f8947 = i3;
        this.f8950 = C4650.m14125();
        iArr[0] = i4;
        this.f8944 = new C3880(i, i2, i3, i5);
        this.f8948 = false;
    }
}
