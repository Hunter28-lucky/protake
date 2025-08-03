package jp.co.cyberagent.android.gpuimage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.uc.crashsdk.export.LogType;
import defpackage.C4327;
import defpackage.C4462;
import defpackage.C4650;
import defpackage.b2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.GPUImage;

/* compiled from: GPUImageRenderer.java */
@TargetApi(11)
/* renamed from: jp.co.cyberagent.android.gpuimage.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2130 implements GLSurfaceView.Renderer, Camera.PreviewCallback {

    /* renamed from: އ, reason: contains not printable characters */
    public static final float[] f7782 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C4327 f7783;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final FloatBuffer f7787;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final FloatBuffer f7788;

    /* renamed from: ԭ, reason: contains not printable characters */
    public IntBuffer f7789;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f7790;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f7791;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f7792;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f7793;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f7794;

    /* renamed from: ހ, reason: contains not printable characters */
    public Rotation f7797;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f7798;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f7799;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object f7784 = new Object();

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f7785 = -1;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public SurfaceTexture f7786 = null;

    /* renamed from: ރ, reason: contains not printable characters */
    public GPUImage.ScaleType f7800 = GPUImage.ScaleType.CENTER_CROP;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f7801 = 0.0f;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f7802 = 0.0f;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f7803 = 0.0f;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final Queue<Runnable> f7795 = new LinkedList();

    /* renamed from: ؠ, reason: contains not printable characters */
    public final Queue<Runnable> f7796 = new LinkedList();

    /* compiled from: GPUImageRenderer.java */
    /* renamed from: jp.co.cyberagent.android.gpuimage.Ϳ$Ϳ, reason: contains not printable characters */
    public class RunnableC2131 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ byte[] f7804;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Camera.Size f7805;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ Camera f7806;

        public RunnableC2131(byte[] bArr, Camera.Size size, Camera camera) {
            this.f7804 = bArr;
            this.f7805 = size;
            this.f7806 = camera;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = this.f7804;
            Camera.Size size = this.f7805;
            GPUImageNativeLibrary.YUVtoRBGA(bArr, size.width, size.height, C2130.this.f7789.array());
            C2130 c2130 = C2130.this;
            c2130.f7785 = C4650.m14129(c2130.f7789, this.f7805, C2130.this.f7785);
            this.f7806.addCallbackBuffer(this.f7804);
            int i = C2130.this.f7792;
            int i2 = this.f7805.width;
            if (i != i2) {
                C2130.this.f7792 = i2;
                C2130.this.f7793 = this.f7805.height;
                C2130.this.m7159();
            }
        }
    }

    /* compiled from: GPUImageRenderer.java */
    /* renamed from: jp.co.cyberagent.android.gpuimage.Ϳ$Ԩ, reason: contains not printable characters */
    public class RunnableC2132 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C4327 f7808;

        public RunnableC2132(C4327 c4327) {
            this.f7808 = c4327;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4327 c4327 = C2130.this.f7783;
            C2130.this.f7783 = this.f7808;
            if (c4327 != null) {
                c4327.m13471();
            }
            C2130.this.f7783.m13477();
            GLES20.glUseProgram(C2130.this.f7783.m13475());
            C2130.this.f7783.mo9491(C2130.this.f7790, C2130.this.f7791);
        }
    }

    /* compiled from: GPUImageRenderer.java */
    /* renamed from: jp.co.cyberagent.android.gpuimage.Ϳ$Ԫ, reason: contains not printable characters */
    public class RunnableC2133 implements Runnable {
        public RunnableC2133() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glDeleteTextures(1, new int[]{C2130.this.f7785}, 0);
            C4462.m13723(C2130.this.f7785);
            C2130.this.f7785 = -1;
        }
    }

    /* compiled from: GPUImageRenderer.java */
    /* renamed from: jp.co.cyberagent.android.gpuimage.Ϳ$Ԭ, reason: contains not printable characters */
    public class RunnableC2134 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Bitmap f7811;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f7812;

        public RunnableC2134(Bitmap bitmap, boolean z) {
            this.f7811 = bitmap;
            this.f7812 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap = null;
            if (this.f7811.getWidth() % 2 == 1) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f7811.getWidth() + 1, this.f7811.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawARGB(0, 0, 0, 0);
                canvas.drawBitmap(this.f7811, 0.0f, 0.0f, (Paint) null);
                C2130.this.f7794 = 1;
                bitmap = bitmapCreateBitmap;
            } else {
                C2130.this.f7794 = 0;
            }
            C2130 c2130 = C2130.this;
            c2130.f7785 = C4650.m14128(bitmap != null ? bitmap : this.f7811, c2130.f7785, this.f7812);
            if (bitmap != null) {
                bitmap.recycle();
            }
            C2130.this.f7792 = this.f7811.getWidth();
            C2130.this.f7793 = this.f7811.getHeight();
            C2130.this.m7159();
        }
    }

    public C2130(C4327 c4327) {
        this.f7783 = c4327;
        float[] fArr = f7782;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f7787 = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f7788 = ByteBuffer.allocateDirect(b2.f99.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        m7168(Rotation.NORMAL, false, false);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(LogType.UNEXP_RESTART);
        m7163(this.f7795);
        this.f7783.m13479(this.f7785, this.f7787, this.f7788);
        m7163(this.f7796);
        SurfaceTexture surfaceTexture = this.f7786;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (this.f7789 == null) {
            this.f7789 = IntBuffer.allocate(previewSize.width * previewSize.height);
        }
        if (this.f7795.isEmpty()) {
            m7164(new RunnableC2131(bArr, previewSize, camera));
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f7790 = i;
        this.f7791 = i2;
        GLES20.glViewport(0, 0, i, i2);
        GLES20.glUseProgram(this.f7783.m13475());
        this.f7783.mo9491(i, i2);
        m7159();
        synchronized (this.f7784) {
            this.f7784.notifyAll();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(this.f7801, this.f7802, this.f7803, 1.0f);
        GLES20.glDisable(2929);
        this.f7783.m13477();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final float m7158(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m7159() {
        int i = this.f7790;
        float f = i;
        int i2 = this.f7791;
        float f2 = i2;
        Rotation rotation = this.f7797;
        if (rotation == Rotation.ROTATION_270 || rotation == Rotation.ROTATION_90) {
            f = i2;
            f2 = i;
        }
        float fMax = Math.max(f / this.f7792, f2 / this.f7793);
        float fRound = Math.round(this.f7792 * fMax) / f;
        float fRound2 = Math.round(this.f7793 * fMax) / f2;
        float[] fArr = f7782;
        float[] fArrM111 = b2.m111(this.f7797, this.f7798, this.f7799);
        if (this.f7800 == GPUImage.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / fRound)) / 2.0f;
            float f4 = (1.0f - (1.0f / fRound2)) / 2.0f;
            fArrM111 = new float[]{m7158(fArrM111[0], f3), m7158(fArrM111[1], f4), m7158(fArrM111[2], f3), m7158(fArrM111[3], f4), m7158(fArrM111[4], f3), m7158(fArrM111[5], f4), m7158(fArrM111[6], f3), m7158(fArrM111[7], f4)};
        } else {
            fArr = new float[]{fArr[0] / fRound2, fArr[1] / fRound, fArr[2] / fRound2, fArr[3] / fRound, fArr[4] / fRound2, fArr[5] / fRound, fArr[6] / fRound2, fArr[7] / fRound};
        }
        this.f7787.clear();
        this.f7787.put(fArr).position(0);
        this.f7788.clear();
        this.f7788.put(fArrM111).position(0);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m7160() {
        m7164(new RunnableC2133());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public int m7161() {
        return this.f7791;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m7162() {
        return this.f7790;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m7163(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m7164(Runnable runnable) {
        synchronized (this.f7795) {
            this.f7795.add(runnable);
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m7165(C4327 c4327) {
        m7164(new RunnableC2132(c4327));
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m7166(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return;
        }
        m7164(new RunnableC2134(bitmap, z));
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m7167(Rotation rotation) {
        this.f7797 = rotation;
        m7159();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m7168(Rotation rotation, boolean z, boolean z2) {
        this.f7798 = z;
        this.f7799 = z2;
        m7167(rotation);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m7169(GPUImage.ScaleType scaleType) {
        this.f7800 = scaleType;
    }
}
