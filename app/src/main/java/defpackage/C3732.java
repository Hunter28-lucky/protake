package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: EGL10Helper.java */
/* renamed from: ݛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3732 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C3732 f12927;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static Object f12928 = new Object();

    /* renamed from: ֈ, reason: contains not printable characters */
    public static EGLDisplay f12929 = EGL14.eglGetDisplay(0);

    /* renamed from: ֏, reason: contains not printable characters */
    public static final ThreadLocal<C3732> f12930;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static ArrayList<C3732> f12931;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C2953<C3732> f12932;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f12933;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public EGLContext f12934;

    /* renamed from: ԩ, reason: contains not printable characters */
    public EGLConfig[] f12935;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f12936;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f12937;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public EGLSurface f12938;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f12939;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<EGLSurface> f12940 = new ArrayList<>();

    static {
        ThreadLocal<C3732> threadLocal = new ThreadLocal<>();
        f12930 = threadLocal;
        f12931 = new ArrayList<>();
        f12932 = new C2953<>();
        f12927 = new C3732("shared");
        EGLDisplay eGLDisplay = f12929;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        threadLocal.set(null);
    }

    public C3732(String str) {
        this.f12936 = str;
        Log.d("EGL10Helper", String.format("New EGL for %s, currently %d instances", str, Integer.valueOf(f12931.size())));
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(f12929, iArr, 0, iArr, 1)) {
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        this.f12935 = eGLConfigArr;
        if (!EGL14.eglChooseConfig(f12929, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        int[] iArr2 = {12440, 2, 12344};
        EGLDisplay eGLDisplay = f12929;
        EGLConfig eGLConfig = this.f12935[0];
        C3732 c3732 = f12927;
        this.f12934 = EGL14.eglCreateContext(eGLDisplay, eGLConfig, c3732 != null ? c3732.f12934 : EGL14.EGL_NO_CONTEXT, iArr2, 0);
        m11948("eglCreateContext");
        if (this.f12934 == null) {
            throw new RuntimeException("null context");
        }
        EGLSurface eGLSurfaceM11950 = m11950(16, 16);
        this.f12938 = eGLSurfaceM11950;
        m11957(eGLSurfaceM11950);
        this.f12933 = GLES20.glGetString(7937).startsWith("Adreno");
        f12931.add(this);
        m11946();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m11941() {
        if (EGL14.eglGetCurrentContext() == null) {
            throw new RuntimeException("no egl context");
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m11942(String str) {
        boolean z = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            Log.e("EGL10Helper", str + ": GL error: 0x" + Integer.toHexString(iGlGetError));
            z = true;
        }
        if (z) {
            throw new RuntimeException("GL error encountered (see log)");
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m11943(String str) {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            Log.e("EGL10Helper", str + ": GL error: 0x" + Integer.toHexString(iGlGetError));
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static C3732 m11944(String str) {
        C3732 c3732;
        synchronized (f12928) {
            Log.d("EGL10Helper", String.format("New EGL for %s", str));
            c3732 = new C3732(str);
            m11947();
        }
        return c3732;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static synchronized C3732 m11945() {
        if (f12927 == null) {
            f12927 = new C3732("shared");
        }
        return f12927;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static synchronized void m11946() {
        Log.d("EGL10Helper", String.format("----- egl: %d instances -----", Integer.valueOf(f12931.size())));
        Iterator<C3732> it = f12931.iterator();
        while (it.hasNext()) {
            C3732 next = it.next();
            Log.d("EGL10Helper", String.format("instance:%s handle:%d", next.f12936, Long.valueOf(C4650.m14124(next.f12934))));
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static void m11947() {
        m11943("resetGLState 1");
        GLES20.glBlendFunc(1, 0);
        GLES20.glDisable(3042);
        GLES20.glDisable(3089);
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindTexture(3553, 0);
        m11943("resetGLState 2");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m11948(String str) {
        boolean z = false;
        while (true) {
            int iEglGetError = EGL14.eglGetError();
            if (iEglGetError == 12288) {
                break;
            }
            Log.e("EGL10Helper", str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11949(String str) {
        while (true) {
            int iEglGetError = EGL14.eglGetError();
            if (iEglGetError == 12288) {
                return;
            }
            Log.e("EGL10Helper", str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized EGLSurface m11950(int i, int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(f12929, this.f12935[0], new int[]{12375, i, 12374, i2, 12344}, 0);
        this.f12940.add(eGLSurfaceEglCreatePbufferSurface);
        m11948("eglCreatePbufferSurface");
        return eGLSurfaceEglCreatePbufferSurface;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public synchronized EGLSurface m11951(Surface surface) {
        return m11952(surface, true);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public synchronized EGLSurface m11952(Surface surface, boolean z) {
        EGLSurface eGLSurfaceEglCreateWindowSurface;
        eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(f12929, this.f12935[0], surface, new int[]{12344}, 0);
        m11948("createSurface");
        if (z) {
            this.f12940.add(eGLSurfaceEglCreateWindowSurface);
        }
        return eGLSurfaceEglCreateWindowSurface;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public synchronized void m11953(EGLSurface eGLSurface) {
        this.f12940.remove(eGLSurface);
        EGL14.eglDestroySurface(f12929, eGLSurface);
        m11948("destroySurface");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public EGLContext m11954() {
        return this.f12934;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public int m11955() {
        int[] iArr = new int[1];
        EGL14.eglGetConfigAttrib(f12929, this.f12935[0], 12330, iArr, 0);
        return iArr[0];
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public int m11956() {
        int[] iArr = new int[1];
        EGL14.eglGetConfigAttrib(f12929, this.f12935[0], 12332, iArr, 0);
        return iArr[0];
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m11957(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return;
        }
        EGL14.eglMakeCurrent(f12929, eGLSurface, eGLSurface, this.f12934);
        m11948("eglMakeCurrent");
        if (this.f12937) {
            return;
        }
        Log.d("EGL10Helper", String.format("GL_RENDERER:%s", GLES20.glGetString(7937)));
        Log.d("EGL10Helper", String.format("GL_VENDOR:%s", GLES20.glGetString(7936)));
        Log.d("EGL10Helper", String.format("GL_VERSION:%s", GLES20.glGetString(7938)));
        this.f12937 = true;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m11958() {
        m11957(this.f12938);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m11959() {
        if (this.f12939) {
            throw new RuntimeException("releasing frozen context");
        }
        synchronized (f12928) {
            C3439.f11831.m11208();
            Log.d("EGL10Helper", String.format("release EGL for user:%s handle:%d", this.f12936, Long.valueOf(C4650.m14125())));
            m11961();
            f12931.remove(this);
            m11946();
            Log.d("EGL10Helper", String.format("Delete EGL, now %d instances", Integer.valueOf(f12931.size())));
            EGLSurface eGLSurface = this.f12938;
            if (eGLSurface != null) {
                m11953(eGLSurface);
                this.f12938 = null;
            }
            EGLContext eGLContext = this.f12934;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(f12929, eGLContext);
                this.f12934 = null;
            } else {
                Log.d("EGL10Helper", "Deleting already deleted EGL context");
            }
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean m11960(EGLSurface eGLSurface) {
        boolean zEglSwapBuffers = EGL14.eglSwapBuffers(f12929, eGLSurface);
        m11949("eglSwapBuffers");
        return zEglSwapBuffers;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m11961() {
        if (C4650.m14125() != C4650.m14124(this.f12934)) {
            Log.e("EGL10Helper", "releasing EGL when not current!");
            m11958();
        }
        if (this.f12940.size() != 1) {
            Log.e("EGL10Helper", String.format("not all EGL surfaces free when releasing egl", new Object[0]));
            throw new RuntimeException("surfaces remaining when releasing egl");
        }
        EGLDisplay eGLDisplay = f12929;
        if (eGLDisplay != null) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        f12930.set(null);
    }
}
