package defpackage;

import android.opengl.GLES20;
import com.umeng.commonsdk.internal.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: WaveFormRGBBrightFilter.java */
/* loaded from: classes.dex */
public class u7 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int f8623;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f8624;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f8625;

    /* renamed from: އ, reason: contains not printable characters */
    public float f8626;

    /* renamed from: ވ, reason: contains not printable characters */
    public float f8627;

    /* renamed from: މ, reason: contains not printable characters */
    public float f8628;

    /* renamed from: ފ, reason: contains not printable characters */
    public float[] f8629;

    /* renamed from: ދ, reason: contains not printable characters */
    public float[] f8630;

    /* renamed from: ތ, reason: contains not printable characters */
    public FloatBuffer f8631;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f8632;

    /* renamed from: ގ, reason: contains not printable characters */
    public float f8633;

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f8634;

    /* renamed from: ސ, reason: contains not printable characters */
    public float[] f8635;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f8636;

    /* renamed from: ޒ, reason: contains not printable characters */
    public float[] f8637;

    public u7(int i) {
        super("attribute vec2 position;\n uniform sampler2D inputImageTexture;\n uniform vec4 factors;\n \n void main()\n{\n    vec4 color = texture2D(inputImageTexture,vec2(position.x,position.y));\n    float y = color.b * 2.0 - 1.0;\n    float s = (dot(color,factors)*256.0)/256.0;\n    gl_Position = vec4(position.x * 2.0 - 1.0,s*2.0-1.0,0.0,1.0);\n    gl_PointSize = 1.5;}", "precision highp float;uniform lowp float strength;uniform lowp vec4 factors2;void main(){\n    vec4 outColor = vec4(factors2.rgb*strength,0.0);\n    gl_FragColor = outColor;\n}");
        this.f8623 = i;
        this.f8632 = m13476("strength");
        this.f8634 = m13476("factors");
        this.f8636 = m13476("factors2");
        this.f8633 = 0.1f;
        m8364(3);
        this.f8625 = 0.0f;
        this.f8627 = 1.0f;
        this.f8624 = 0.0f;
        this.f8626 = 1.0f;
        this.f8628 = 0.01f;
        this.f8629 = new float[]{0.0f, 0.0f - 0.01f, 1.0f, 0.0f - 0.01f, 0.0f, 1.0f + 0.01f, 1.0f, 1.0f + 0.01f};
    }

    @Override // defpackage.C4327
    /* renamed from: ׯ, reason: contains not printable characters */
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
        this.f8631.position(0);
        GLES20.glVertexAttribPointer(this.f14857, 2, 5126, false, 0, (Buffer) this.f8631);
        GLES20.glEnableVertexAttribArray(this.f14857);
        GLES20.glDrawArrays(0, 0, this.f8623 * 360);
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
    /* renamed from: ހ, reason: contains not printable characters */
    public void mo8361() {
        super.mo8361();
        m8363();
        m13482(this.f8632, this.f8633);
        m13483(this.f8634, this.f8635);
        m13483(this.f8636, this.f8637);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final FloatBuffer m8362(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m8363() {
        int i = this.f8623;
        if (this.f8630 == null || this.f8631 == null) {
            this.f8630 = new float[i * 360 * 2];
            float f = 1.0f / i;
            float f2 = 1.0f / 360;
            for (int i2 = 0; i2 < 360; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    int i4 = (i2 * i * 2) + (i3 * 2);
                    float[] fArr = this.f8630;
                    fArr[i4] = i3 * f;
                    fArr[i4 + 1] = i2 * f2;
                }
            }
            this.f8631 = m8362(this.f8630);
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m8364(int i) {
        float[] fArr = new float[4];
        this.f8635 = fArr;
        float[] fArr2 = new float[4];
        this.f8637 = fArr2;
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
        m13483(this.f8634, fArr);
        m13483(this.f8636, this.f8637);
    }
}
