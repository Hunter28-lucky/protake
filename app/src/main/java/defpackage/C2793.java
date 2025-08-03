package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.videotools.C0851;
import com.blink.academy.filter.core.Drawable2d;

/* compiled from: DecoderSurface.java */
/* renamed from: Ξ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2793 extends Thread implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public SurfaceTexture f10184;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Surface f10185;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C2377 f10188;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C0851.C0852 f10189;

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC2794 f10192;

    /* renamed from: ؠ, reason: contains not printable characters */
    public DecoderParamsBean f10193;

    /* renamed from: ނ, reason: contains not printable characters */
    public C4874 f10196;

    /* renamed from: ރ, reason: contains not printable characters */
    public Drawable2d f10197;

    /* renamed from: ބ, reason: contains not printable characters */
    public Looper f10198;

    /* renamed from: ޅ, reason: contains not printable characters */
    public C0851.C0853 f10199;

    /* renamed from: ކ, reason: contains not printable characters */
    public Handler f10200;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f10186 = 0;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public EGLSurface f10187 = null;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Object f10190 = new Object();

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f10191 = false;

    /* renamed from: ހ, reason: contains not printable characters */
    public final float[] f10194 = new float[16];

    /* renamed from: ށ, reason: contains not printable characters */
    public final float[] f10195 = new float[16];

    /* renamed from: އ, reason: contains not printable characters */
    public int[] f10201 = new int[1];

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f10202 = false;

    /* compiled from: DecoderSurface.java */
    /* renamed from: Ξ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2794 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo10104(C0851.C0853 c0853);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo10105(C0851.C0852 c0852);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo10106(C0851.C0852 c0852);
    }

    public C2793(DecoderParamsBean decoderParamsBean, InterfaceC2794 interfaceC2794) {
        this.f10192 = interfaceC2794;
        this.f10193 = decoderParamsBean;
        start();
        synchronized (this) {
            while (this.f10185 == null) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f10190) {
            if (this.f10202) {
                return;
            }
            if (!this.f10191) {
                this.f10184.updateTexImage();
                this.f10184.getTransformMatrix(this.f10194);
                int[] iArr = {0};
                GLES20.glGenFramebuffers(1, iArr, 0);
                GLES20.glBindFramebuffer(36160, iArr[0]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f10189.f1879, 0);
                C3732.m11943("attach texture to framebuffer");
                C0851.C0852 c0852 = this.f10189;
                int i = c0852.f1877;
                int i2 = c0852.f1878;
                GLES20.glScissor(0, 0, i, i2);
                GLES20.glViewport(0, 0, i, i2);
                this.f10196.mo4802(this.f10186, this.f10195, this.f10194, this.f10197);
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                GLES20.glFinish();
                this.f10192.mo10105(this.f10189);
                this.f10189 = null;
                this.f10190.notifyAll();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.f10198 = Looper.myLooper();
        synchronized (this) {
            m10100();
            C0851.C0853 c0853 = new C0851.C0853(30, this.f10193.m475(), this.f10193.m473());
            this.f10199 = c0853;
            this.f10192.mo10104(c0853);
            this.f10184 = new SurfaceTexture(this.f10186);
            Handler handler = new Handler(this.f10198);
            this.f10200 = handler;
            this.f10184.setOnFrameAvailableListener(this, handler);
            this.f10185 = new Surface(this.f10184);
            notifyAll();
        }
        Looper.loop();
        C0851.C0853 c08532 = this.f10199;
        if (c08532 != null) {
            c08532.m2106();
        }
        C2377 c2377 = this.f10188;
        if (c2377 != null) {
            EGLSurface eGLSurface = this.f10187;
            if (eGLSurface != null) {
                c2377.m8855(eGLSurface);
                this.f10187 = EGL14.EGL_NO_SURFACE;
            }
            this.f10188.m8854();
            this.f10188 = null;
        }
        SurfaceTexture surfaceTexture = this.f10184;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f10184 = null;
        }
        Surface surface = this.f10185;
        if (surface != null) {
            surface.release();
            this.f10185 = null;
        }
        Handler handler2 = this.f10200;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.f10200 = null;
        }
        GLES20.glDeleteTextures(1, new int[]{this.f10186}, 0);
        C4650.m14122("codecoutputsurface1");
        C4874 c4874 = this.f10196;
        if (c4874 != null) {
            c4874.mo4800();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m10098(int i, int i2) {
        GLES20.glGenTextures(1, this.f10201, 0);
        this.f10186 = this.f10201[0];
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f10186);
        GLES20.glTexImage2D(3553, 0, 34842, i, i2, 0, 6408, 5126, null);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        C3732.m11942("glBindTexture mTextureID");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Surface m10099() {
        return this.f10185;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m10100() {
        int iM475 = this.f10193.m475();
        int i = iM475 - (iM475 % 2);
        int iM473 = this.f10193.m473();
        int i2 = iM473 - (iM473 % 2);
        C2377 c2377 = new C2377(C3732.m11945().m11954(), 1);
        this.f10188 = c2377;
        EGLSurface eGLSurfaceM8850 = c2377.m8850(i, i2);
        this.f10187 = eGLSurfaceM8850;
        this.f10188.m8853(eGLSurfaceM8850);
        m10098(i, i2);
        Matrix.setIdentityM(this.f10195, 0);
        Matrix.setIdentityM(this.f10194, 0);
        this.f10196 = new C4874();
        this.f10197 = new Drawable2d();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m10101() throws InterruptedException {
        this.f10202 = true;
        this.f10198.quit();
        try {
            join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m10102(C0851.C0852 c0852) {
        if (c0852 == null) {
            throw new RuntimeException("cannot add null render buffer");
        }
        if (this.f10189 != null) {
            throw new RuntimeException("existing render buffer");
        }
        synchronized (this.f10190) {
            if (this.f10191) {
                this.f10192.mo10106(c0852);
            } else {
                this.f10189 = c0852;
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m10103() {
        synchronized (this.f10190) {
            while (!this.f10191 && this.f10189 != null) {
                try {
                    this.f10190.wait(500L);
                    if (this.f10189 != null) {
                        Log.w("CodecOutputSurface", "frame not available yet");
                    }
                } catch (InterruptedException unused) {
                    throw new RuntimeException("wait interrupted");
                }
            }
        }
    }
}
