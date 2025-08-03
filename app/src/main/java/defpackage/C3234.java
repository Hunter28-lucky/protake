package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

/* renamed from: ե, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3234 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f11390 = C4625.m14082("CR0MCTkZDg==");

    /* renamed from: Ϳ, reason: contains not printable characters */
    public EGLDisplay f11391;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLContext f11392;

    /* renamed from: ԩ, reason: contains not printable characters */
    public EGLConfig f11393;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f11394;

    public C3234(EGLContext eGLContext, int i) {
        EGLConfig eGLConfigM10896;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.f11391 = eGLDisplay;
        this.f11392 = EGL14.EGL_NO_CONTEXT;
        this.f11393 = null;
        this.f11394 = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException(C4625.m14082("CyghTzEeHREADxwSQFZHbhod"));
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f11391 = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException(C4625.m14082("OwEMDTwXTwAOSwJXRxN2CSNcW3AWBgcRBwRL"));
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.f11391 = null;
            throw new RuntimeException(C4625.m14082("OwEMDTwXTwAOSwxcWkdaLwMEFTVSKjMtWlE="));
        }
        if ((i & 2) != 0 && (eGLConfigM10896 = m10896(i, 3)) != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f11391, eGLConfigM10896, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.f11393 = eGLConfigM10896;
                this.f11392 = eGLContextEglCreateContext;
                this.f11394 = 3;
            }
        }
        if (this.f11392 == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigM108962 = m10896(i, 2);
            if (eGLConfigM108962 == null) {
                throw new RuntimeException(C4625.m14082("GwEMDTwXTwAOSwNbXVcTL08eGjkGDhYNDkV3dH9wIQELBjc="));
            }
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.f11391, eGLConfigM108962, eGLContext, new int[]{12440, 2, 12344}, 0);
            m10894(C4625.m14082("KwgBLCIXDgAEKApcR1ZLOg=="));
            this.f11393 = eGLConfigM108962;
            this.f11392 = eGLContextEglCreateContext2;
            this.f11394 = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f11391, this.f11392, 12440, iArr2, 0);
        Log.d(C4625.m14082("CR0MCTkZDg=="), C4625.m14082("CyghLD8cGxEZH0VRQVZSOgoJQ3ARAx0EBRESRVZBPQYCAXA=") + iArr2[0]);
    }

    public void finalize() throws Throwable {
        try {
            if (this.f11391 != EGL14.EGL_NO_DISPLAY) {
                Log.w(f11390, C4625.m14082("GS4/IRk8KE5BLgJecFxBK08aDiNSARsVSwBKQ19aLQYZAylSHRENDgRBVlcTY0JNHCQTGxFBBgRLE1FWbgMIDjsXCw=="));
                m10899();
            }
        } finally {
            super.finalize();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m10894(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + C4625.m14082("dE8oKBxSCgYTBBcIEwNL") + Integer.toHexString(iEglGetError));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLSurface m10895(int i, int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f11391, this.f11393, new int[]{12375, i, 12374, i2, 12344}, 0);
        m10894(C4625.m14082("KwgBLCIXDgAEOwdHVVVWPDwYHTYTDBE="));
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new RuntimeException(C4625.m14082("PRofCTERClQWChYSXUZfIg=="));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final EGLConfig m10896(int i, int i2) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f11391, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w(f11390, C4625.m14082("OwEMDTwXTwAOSwNbXVcTHCgvV2hKV1ROSw==") + i2 + C4625.m14082("bioqIxMdARIIDA=="));
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m10897(EGLSurface eGLSurface) {
        if (this.f11391 == EGL14.EGL_NO_DISPLAY) {
            Log.d(f11390, C4625.m14082("ACA5KmpSAhUKDiZHQUFWIBtNGH8dTxAIGBVeUko="));
        }
        if (!EGL14.eglMakeCurrent(this.f11391, eGLSurface, eGLSurface, this.f11392)) {
            throw new RuntimeException(C4625.m14082("KwgBIjEZCjcUGRdXXUcTKA4EAzUW"));
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m10898() {
        EGLDisplay eGLDisplay = this.f11391;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException(C4625.m14082("KwgBIjEZCjcUGRdXXUcTKA4EAzUW"));
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m10899() {
        EGLDisplay eGLDisplay = this.f11391;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f11391, this.f11392);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f11391);
        }
        this.f11391 = EGL14.EGL_NO_DISPLAY;
        this.f11392 = EGL14.EGL_NO_CONTEXT;
        this.f11393 = null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m10900(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f11391, eGLSurface);
    }
}
