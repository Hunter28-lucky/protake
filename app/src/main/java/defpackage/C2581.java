package defpackage;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: Histogram2DFilter2.java */
/* renamed from: ɝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2581 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f9611;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float[] f9612;

    /* renamed from: ކ, reason: contains not printable characters */
    public FloatBuffer f9613;

    /* renamed from: އ, reason: contains not printable characters */
    public ByteBuffer f9614;

    @Override // defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f14863) {
            return c23902;
        }
        C2390 c2390M11214 = c2390 == null ? C3439.f11831.m11214(this.f14861, this.f14862, 6408) : c2390;
        GLES20.glBindFramebuffer(36160, c2390M11214.m8881());
        GLES20.glUseProgram(this.f14856);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        m13481();
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f14857, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f14857);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f14860, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.f14860);
        if (c23902.m8882() != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, c23902.m8882());
            GLES20.glUniform1i(m13474(this.f14858), 0);
        }
        mo10879();
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f14857, 2, 5126, false, 0, (Buffer) floatBuffer);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.f14860, 2, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glDisableVertexAttribArray(this.f14860);
        if (!this.f9611) {
            if (this.f9614 == null) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(230400);
                this.f9614 = byteBufferAllocateDirect;
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            }
            GLES20.glReadPixels(0, 0, 320, MPEGConst.SEQUENCE_ERROR_CODE, 6408, 5121, this.f9614);
            this.f9614.rewind();
            this.f9611 = true;
        }
        GLES20.glBindTexture(3553, 0);
        C3439.f11831.m11213(c23902);
        long jNanoTime = System.nanoTime();
        if (C4327.f14850 == 0) {
            C4327.f14850 = jNanoTime;
        }
        if (jNanoTime - C4327.f14850 > 8000000) {
            C4327.f14850 = jNanoTime;
            GLES20.glFinish();
            Thread.yield();
        }
        return c2390M11214;
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m9457();
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final FloatBuffer m9456(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m9457() {
        if (this.f9612 == null || this.f9613 == null) {
            this.f9612 = new float[115200];
            float f = 1.0f / 320;
            float f2 = 1.0f / MPEGConst.SEQUENCE_ERROR_CODE;
            for (int i = 0; i < 180; i++) {
                for (int i2 = 0; i2 < 320; i2++) {
                    int i3 = (i * 320 * 2) + (i2 * 2);
                    float[] fArr = this.f9612;
                    fArr[i3] = i2 * f;
                    fArr[i3 + 1] = i * f2;
                }
            }
            this.f9613 = m9456(this.f9612);
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public synchronized byte[] m9458() {
        byte[] bArrArray;
        ByteBuffer byteBuffer = this.f9614;
        if (byteBuffer == null) {
            bArrArray = null;
        } else {
            this.f9611 = false;
            bArrArray = byteBuffer.array();
        }
        return bArrArray;
    }
}
