package defpackage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import jp.co.cyberagent.android.gpuimage.Rotation;

/* compiled from: GPUImageTwoInputFilter.java */
/* renamed from: Պ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3222 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int f11347;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f11348;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f11349;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f11350;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f11351;

    /* renamed from: މ, reason: contains not printable characters */
    public ByteBuffer f11352;

    /* renamed from: ފ, reason: contains not printable characters */
    public Bitmap f11353;

    /* renamed from: ދ, reason: contains not printable characters */
    public C4327 f11354;

    /* renamed from: ތ, reason: contains not printable characters */
    public C2390 f11355;

    /* renamed from: ލ, reason: contains not printable characters */
    public FloatBuffer f11356;

    /* renamed from: ގ, reason: contains not printable characters */
    public float[] f11357;

    /* compiled from: GPUImageTwoInputFilter.java */
    /* renamed from: Պ$Ϳ, reason: contains not printable characters */
    public class RunnableC3223 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Bitmap f11358;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f11359;

        public RunnableC3223(Bitmap bitmap, boolean z) {
            this.f11358 = bitmap;
            this.f11359 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (C3222.this.f11349 != -1 || (bitmap = this.f11358) == null || bitmap.isRecycled()) {
                return;
            }
            GLES20.glActiveTexture(33987);
            C3222.this.f11349 = C4650.m14128(this.f11358, -1, this.f11359);
        }
    }

    public C3222(String str, String str2) {
        super(str, str2);
        this.f11349 = -1;
        this.f11350 = false;
        this.f11351 = false;
        this.f11356 = ByteBuffer.allocateDirect(b2.f99.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f11357 = null;
        m10883(Rotation.NORMAL, false, false);
        this.f11348 = m13476("inputImageTexture2");
    }

    @Override // defpackage.C4327
    /* renamed from: ԩ, reason: contains not printable characters */
    public void mo10877() {
        C4327 c4327 = this.f11354;
        if (c4327 != null) {
            c4327.mo10877();
        }
        if (this.f11350) {
            m10881();
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ֈ, reason: contains not printable characters */
    public void mo10878() {
        C4327 c4327 = this.f11354;
        if (c4327 != null) {
            c4327.m13471();
        } else if (!this.f11350) {
            m10881();
        }
        super.mo10878();
    }

    @Override // defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        C3439 c3439 = C3439.f11831;
        if (this.f11354 != null) {
            c3439.m11212(c23902);
            this.f11355 = this.f11354.mo8360(null, c23902, floatBuffer, this.f11356);
            c3439.m11215(c23902);
        }
        C2390 c2390Mo8360 = super.mo8360(c2390, c23902, floatBuffer, floatBuffer2);
        C2390 c23903 = this.f11355;
        if (c23903 != null) {
            C3439.f11831.m11213(c23903);
            this.f11355 = null;
        }
        return c2390Mo8360;
    }

    @Override // defpackage.C4327
    /* renamed from: ؠ, reason: contains not printable characters */
    public void mo10879() {
        int i = this.f11347;
        if (i != -1) {
            GLES20.glEnableVertexAttribArray(i);
        }
        GLES20.glActiveTexture(33987);
        C2390 c2390 = this.f11355;
        if (c2390 != null) {
            GLES20.glBindTexture(3553, c2390.m8882());
        } else {
            GLES20.glBindTexture(3553, this.f11349);
        }
        GLES20.glUniform1i(m13474(this.f11348), 3);
        if (this.f11347 != -1) {
            this.f11352.position(0);
            GLES20.glVertexAttribPointer(this.f11347, 2, 5126, false, 0, (Buffer) this.f11352);
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(m13475(), "inputTextureCoordinate2");
        this.f11347 = iGlGetAttribLocation;
        if (iGlGetAttribLocation != -1) {
            GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        }
        Bitmap bitmap = this.f11353;
        if (bitmap != null && !bitmap.isRecycled()) {
            mo9738(this.f11353);
        }
        this.f11356.put(b2.f98).position(0);
        C4327 c4327 = this.f11354;
        if (c4327 != null) {
            c4327.m13477();
            m10883(Rotation.NORMAL, false, true);
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ށ */
    public void mo9737() {
        super.mo9737();
        float[] fArr = this.f11357;
        if (fArr != null) {
            m10886(fArr);
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ނ */
    public void mo9491(int i, int i2) {
        super.mo9491(i, i2);
        C4327 c4327 = this.f11354;
        if (c4327 != null) {
            c4327.mo9491(i, i2);
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final ByteBuffer m10880(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        byteBufferAllocateDirect.asFloatBuffer().put(fArr);
        return byteBufferAllocateDirect;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m10881() {
        int i = this.f11349;
        if (i == -1 || this.f11351) {
            return;
        }
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        C4462.m13723(this.f11349);
        this.f11349 = -1;
    }

    /* renamed from: ތ */
    public void mo9738(Bitmap bitmap) {
        m10882(bitmap, false);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m10882(Bitmap bitmap, boolean z) {
        if (bitmap == null || !bitmap.isRecycled()) {
            this.f11353 = bitmap;
            if (bitmap == null) {
                return;
            }
            m13480(new RunnableC3223(bitmap, z));
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m10883(Rotation rotation, boolean z, boolean z2) {
        float[] fArrM111 = b2.m111(rotation, z, z2);
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferOrder.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArrM111);
        floatBufferAsFloatBuffer.flip();
        this.f11352 = byteBufferOrder;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m10884(int i) {
        this.f11349 = i;
        this.f11350 = true;
        this.f11351 = false;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m10885(int i) {
        this.f11349 = i;
        this.f11350 = false;
        this.f11351 = false;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m10886(float[] fArr) {
        this.f11357 = fArr;
        this.f11352 = m10880(fArr);
    }
}
