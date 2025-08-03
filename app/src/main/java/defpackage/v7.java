package defpackage;

import android.opengl.GLES20;
import com.umeng.commonsdk.internal.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: WaveFormRGBFilter.java */
/* loaded from: classes.dex */
public class v7 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int f8666;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f8667;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f8668;

    /* renamed from: އ, reason: contains not printable characters */
    public float f8669;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f8670;

    /* renamed from: މ, reason: contains not printable characters */
    public float f8671;

    /* renamed from: ފ, reason: contains not printable characters */
    public float[] f8672;

    /* renamed from: ދ, reason: contains not printable characters */
    public float[] f8673;

    /* renamed from: ތ, reason: contains not printable characters */
    public FloatBuffer f8674;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f8675;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f8676;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f8677;

    /* renamed from: ސ, reason: contains not printable characters */
    public float[] f8678;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f8679;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float[] f8680;

    public v7(int i) {
        super(C4982.m14767(m8471()), C4982.m14767(m8472()));
        this.f8666 = i;
        this.f8675 = m13476("strength");
        this.f8677 = m13476("factors");
        this.f8679 = m13476("factors2");
        this.f8676 = 0.033000004f;
        m8475(0);
        this.f8668 = 0.0f;
        this.f8670 = 1.0f;
        this.f8667 = 0.0f;
        this.f8669 = 1.0f;
        this.f8671 = 0.01f;
        this.f8672 = new float[]{0.0f, 0.0f - 0.01f, 1.0f, 0.0f - 0.01f, 0.0f, 1.0f + 0.01f, 1.0f, 1.0f + 0.01f};
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static String m8471() {
        return "waveform_rgb_vertex.glsl";
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static String m8472() {
        return "waveform_rgb_frag.glsl";
    }

    @Override // defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f14863) {
            return c23902;
        }
        if (c2390 == null) {
            c2390 = C3439.f11831.m11214(this.f14861, this.f14862, 6408);
        }
        GLES20.glBindFramebuffer(36160, c2390.m8881());
        GLES20.glUseProgram(this.f14856);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glEnable(3042);
        GLES20.glBlendEquationSeparate(a.k, a.k);
        GLES20.glBlendFunc(1, 1);
        m13481();
        if (c23902.m8882() != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, c23902.m8882());
            GLES20.glUniform1i(m13474(this.f14858), 0);
        }
        mo10879();
        this.f8674.position(0);
        GLES20.glVertexAttribPointer(this.f14857, 2, 5126, false, 0, (Buffer) this.f8674);
        GLES20.glEnableVertexAttribArray(this.f14857);
        GLES20.glDrawArrays(0, 0, this.f8666 * 360 * 3);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisable(3042);
        GLES20.glBlendFunc(1, 0);
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
        return c2390;
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m8474();
        m13482(this.f8675, this.f8676);
        m13483(this.f8677, this.f8678);
        m13483(this.f8679, this.f8680);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final FloatBuffer m8473(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m8474() {
        int i = this.f8666 * 3;
        if (this.f8673 == null || this.f8674 == null) {
            this.f8673 = new float[i * 360 * 2];
            float f = 3.0f / i;
            float f2 = 1.0f / 360;
            for (int i2 = 0; i2 < 360; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = (i2 * i * 2) + (i3 * 2);
                    float[] fArr = this.f8673;
                    fArr[i4] = i3 * f;
                    fArr[i4 + 1] = i2 * f2;
                }
            }
            this.f8674 = m8473(this.f8673);
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m8475(int i) {
        float[] fArr = new float[4];
        this.f8678 = fArr;
        float[] fArr2 = new float[4];
        this.f8680 = fArr2;
        if (i == 0) {
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        } else if (i == 1) {
            fArr[0] = 0.0f;
            fArr[1] = 1.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr2[0] = 0.0f;
            fArr2[1] = 1.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
        } else if (i == 2) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 1.0f;
            fArr[3] = 0.0f;
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 1.0f;
            fArr2[3] = 0.0f;
        } else if (i == 3) {
            fArr[0] = 0.2125f;
            fArr[1] = 0.7152f;
            fArr[2] = 0.0721f;
            fArr[3] = 0.0f;
            fArr2[0] = 1.0f;
            fArr2[1] = 1.0f;
            fArr2[2] = 1.0f;
            fArr2[3] = 0.0f;
        }
        m13483(this.f8677, fArr);
        m13483(this.f8679, this.f8680);
    }
}
