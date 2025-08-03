package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;

/* compiled from: EglSurfaceBase.java */
/* renamed from: š, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2379 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C2377 f8935;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLSurface f8936 = EGL14.EGL_NO_SURFACE;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f8937 = -1;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f8938 = -1;

    public C2379(C2377 c2377) {
        this.f8935 = c2377;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m8859(Object obj) {
        if (this.f8936 != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.f8936 = this.f8935.m8851(obj);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8860() {
        this.f8935.m8853(this.f8936);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m8861() {
        this.f8935.m8855(this.f8936);
        this.f8936 = EGL14.EGL_NO_SURFACE;
        this.f8938 = -1;
        this.f8937 = -1;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m8862(long j) {
        this.f8935.m8856(this.f8936, j);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m8863() {
        boolean zM8857 = this.f8935.m8857(this.f8936);
        if (!zM8857) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return zM8857;
    }
}
