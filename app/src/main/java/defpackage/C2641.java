package defpackage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import com.blink.academy.gpuimage.TexDecrypt;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* compiled from: GPUImageLookupFilter8.java */
/* renamed from: ʀ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2641 extends C3222 {

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f9822;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f9823;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f9824;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f9825;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f9826;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f9827;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f9828;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f9829;

    /* renamed from: ޗ, reason: contains not printable characters */
    public float[] f9830;

    /* renamed from: ޘ, reason: contains not printable characters */
    public float f9831;

    /* renamed from: ޙ, reason: contains not printable characters */
    public ByteBuffer f9832;

    /* renamed from: ޚ, reason: contains not printable characters */
    public float f9833;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float f9834;

    /* renamed from: ޜ, reason: contains not printable characters */
    public float f9835;

    /* renamed from: ޝ, reason: contains not printable characters */
    public float[] f9836;

    /* renamed from: ޞ, reason: contains not printable characters */
    public float[] f9837;

    /* compiled from: GPUImageLookupFilter8.java */
    /* renamed from: ʀ$Ϳ, reason: contains not printable characters */
    public class RunnableC2642 implements Runnable {
        public RunnableC2642() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2641 c2641 = C2641.this;
            if (c2641.f11349 == -1) {
                int iTexDecrypt_createTexture = TexDecrypt.TexDecrypt_createTexture(c2641.f9832);
                GLES20.glActiveTexture(33987);
                C4462.m13724(iTexDecrypt_createTexture, "lut", 4096, 64, 4);
                C2641.this.m10885(iTexDecrypt_createTexture);
            }
        }
    }

    public C2641() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nuniform highp mat4 uMVPMatrix;\n    uniform highp mat4 uTexMatrix;\n    \n    uniform lowp float wOffset;\n    uniform lowp float hOffset;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n    \n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n    \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    centerCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    \n        topLeftCoordinate = centerCoordinate + vec2(-wOffset, -hOffset);\n        topRightCoordinate = centerCoordinate + vec2(-wOffset, hOffset);\n        bottomLeftCoordinate = centerCoordinate + vec2(wOffset, -hOffset);\n        bottomRightCoordinate = centerCoordinate + vec2(wOffset, hOffset);\n}", "precision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n \n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n\n\n    #define luminanceVec   vec3(0.2126, 0.7152, 0.0722)\n    \n    uniform lowp float mode;\n    \n uniform lowp float intensity;\n uniform lowp float isBnW;\n uniform lowp vec4 dims;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     lowp vec4 newColor = clamp(textureColor,vec4(0.0),vec4(1.0));\n     newColor.rgb *= dims.x;\n     highp float flr = floor(newColor.b);\n     highp vec2 xy = (0.5 + vec2(newColor.rg)) * dims.wz;\n     xy.x += (flr * dims.z);\n     lowp vec4 newColor1 = texture2D(inputImageTexture2, xy);\n     xy.x += dims.z;\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, xy);\n     newColor = mix(newColor1, newColor2, newColor.b - flr);\n     newColor = clamp(mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity),vec4(0.0),vec4(1.0));\n    \n        if(mode==1.0){        newColor.a = dot(textureColor.xyz, luminanceVec);       }else if(mode==2.0){\n        lowp vec4 topLeftSample = texture2D(inputImageTexture, topLeftCoordinate);\n        lowp vec4 topRightSample = texture2D(inputImageTexture, topRightCoordinate);\n        lowp vec4 bottomLeftSample = texture2D(inputImageTexture, bottomLeftCoordinate);\n        lowp vec4 bottomRightSample = texture2D(inputImageTexture, bottomRightCoordinate);\n        newColor.a = min(1.25, length(topLeftSample - bottomRightSample) + length(topRightSample - bottomLeftSample))/1.25;       }\ngl_FragColor = newColor; }");
        this.f9831 = 1.0f;
        m9739();
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        C2390 c2390M9741 = m9741(c2390, c23902, floatBuffer, floatBuffer2);
        C2390 c23903 = this.f11355;
        if (c23903 != null) {
            C3439.f11831.m11213(c23903);
            this.f11355 = null;
        }
        return c2390M9741;
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m9740();
        m13482(this.f9827, this.f9835);
        m13482(this.f9826, this.f9834);
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ށ, reason: contains not printable characters */
    public void mo9737() {
        super.mo9737();
        m9744(this.f9831);
        Log.d("GPUImageOesLookupFilter", String.format("onInitialized : %s", Float.valueOf(this.f14865)));
        m9745(this.f14865);
        m9742();
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ނ */
    public void mo9491(int i, int i2) {
        super.mo9491(i, i2);
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f9834 = 1.0f / i;
        float f = 1.0f / i2;
        this.f9835 = f;
        m13482(this.f9827, f);
        m13482(this.f9826, this.f9834);
    }

    @Override // defpackage.C3222
    /* renamed from: ތ, reason: contains not printable characters */
    public void mo9738(Bitmap bitmap) {
        super.mo9738(bitmap);
        if (bitmap.getWidth() % bitmap.getHeight() != 0) {
            throw new RuntimeException("LUT size is incorrect.");
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m9739() {
        this.f9822 = m13476("intensity");
        this.f9823 = m13476("isBnW");
        this.f9824 = m13476("uMVPMatrix");
        this.f9825 = m13476("uTexMatrix");
        this.f9826 = m13476("wOffset");
        this.f9827 = m13476("hOffset");
        this.f9828 = m13476("mode");
        this.f9829 = m13476("dims");
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f9836 = fArr;
        this.f9837 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f9834 = 0.0f;
        this.f9835 = 0.0f;
        this.f9833 = 0.0f;
        this.f9830 = C5083.f16883;
        m13485(this.f9824, fArr);
        m13485(this.f9825, this.f9837);
        m13482(this.f9827, this.f9835);
        m13482(this.f9826, this.f9834);
        m13482(this.f9828, this.f9833);
        m13483(this.f9829, this.f9830);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m9740() {
        m13480(new RunnableC2642());
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public C2390 m9741(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f14863) {
            Log.e("GPUImageOesLookupFilter", "rendering filter without initialization!");
            return c23902;
        }
        if (c2390 == null) {
            c2390 = C3439.f11831.m11214(this.f14861, this.f14862, 6408);
        }
        GLES20.glBindFramebuffer(36160, c2390.m8881());
        GLES20.glUseProgram(this.f14856);
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
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glDisableVertexAttribArray(this.f14860);
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
        return c2390;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m9742() {
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m9743(float[] fArr) {
        System.arraycopy(fArr, 0, this.f9830, 0, fArr.length);
        m13483(this.f9829, this.f9830);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m9744(float f) {
        this.f9831 = f;
        m13482(this.f9822, f);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m9745(float f) {
        this.f14865 = f;
        Log.d("GPUImageOesLookupFilter", String.format("isBnW == %s", Float.valueOf(f)));
        m13482(this.f9823, this.f14865);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m9746(float f) {
        this.f9833 = f;
        m13482(this.f9828, f);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m9747(float[] fArr) {
        System.arraycopy(fArr, 0, this.f9837, 0, fArr.length);
        m13485(this.f9825, this.f9837);
    }
}
