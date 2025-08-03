package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* compiled from: EglCore.java */
/* renamed from: ŝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2377 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public EGLDisplay f8931;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLContext f8932;

    /* renamed from: ԩ, reason: contains not printable characters */
    public EGLConfig f8933;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f8934;

    public C2377(EGLContext eGLContext, int i) {
        EGLConfig eGLConfigM8852;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f8931 = eGLDisplay;
        this.f8932 = EGL14.EGL_NO_CONTEXT;
        this.f8933 = null;
        this.f8934 = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f8931 = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f8931 = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (eGLConfigM8852 = m8852(i, 3)) != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f8931, eGLConfigM8852, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.f8933 = eGLConfigM8852;
                this.f8932 = eGLContextEglCreateContext;
                this.f8934 = 3;
            }
        }
        if (this.f8932 == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigM88522 = m8852(i, 2);
            if (eGLConfigM88522 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.f8931, eGLConfigM88522, eGLContext, new int[]{12440, 2, 12344}, 0);
            m8849("eglCreateContext");
            this.f8933 = eGLConfigM88522;
            this.f8932 = eGLContextEglCreateContext2;
            this.f8934 = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f8931, this.f8932, 12440, iArr2, 0);
        Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f8931 != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                m8854();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m8849(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLSurface m8850(int i, int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f8931, this.f8933, new int[]{12375, i, 12374, i2, 12344}, 0);
        m8849("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public EGLSurface m8851(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f8931, this.f8933, obj, new int[]{12344}, 0);
        m8849("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final EGLConfig m8852(int i, int i2) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f8931, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m8853(EGLSurface eGLSurface) {
        if (this.f8931 == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f8931, eGLSurface, eGLSurface, this.f8932)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m8854() {
        EGLDisplay eGLDisplay = this.f8931;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f8931, this.f8932);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f8931);
        }
        this.f8931 = EGL14.EGL_NO_DISPLAY;
        this.f8932 = EGL14.EGL_NO_CONTEXT;
        this.f8933 = null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m8855(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f8931, eGLSurface);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m8856(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f8931, eGLSurface, j);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m8857(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f8931, eGLSurface);
    }
}
