package defpackage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import com.blink.academy.gpuimage.TexDecrypt;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* compiled from: GPUImageOesLookupFilter3.java */
/* renamed from: ມ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4972 extends C3222 {

    /* renamed from: ޏ, reason: contains not printable characters */
    public int f16710;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f16711;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f16712;

    /* renamed from: ޒ, reason: contains not printable characters */
    public int f16713;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f16714;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f16715;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int f16716;

    /* renamed from: ޖ, reason: contains not printable characters */
    public int f16717;

    /* renamed from: ޗ, reason: contains not printable characters */
    public float[] f16718;

    /* renamed from: ޘ, reason: contains not printable characters */
    public float f16719;

    /* renamed from: ޙ, reason: contains not printable characters */
    public ByteBuffer f16720;

    /* renamed from: ޚ, reason: contains not printable characters */
    public float f16721;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float f16722;

    /* renamed from: ޜ, reason: contains not printable characters */
    public float f16723;

    /* renamed from: ޝ, reason: contains not printable characters */
    public float[] f16724;

    /* renamed from: ޞ, reason: contains not printable characters */
    public float[] f16725;

    /* compiled from: GPUImageOesLookupFilter3.java */
    /* renamed from: ມ$Ϳ, reason: contains not printable characters */
    public class RunnableC4973 implements Runnable {
        public RunnableC4973() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4972 c4972 = C4972.this;
            if (c4972.f11349 == -1) {
                int iM4831 = TexDecrypt.m4831(c4972.f16720);
                GLES20.glActiveTexture(33987);
                C4462.m13724(iM4831, "lut", 4096, 64, 4);
                C4972.this.m10885(iM4831);
            }
        }
    }

    public C4972() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nuniform highp mat4 uMVPMatrix;\n    uniform highp mat4 uTexMatrix;\n    \n    uniform lowp float wOffset;\n    uniform lowp float hOffset;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n    \n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n    \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    centerCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n    \n        topLeftCoordinate = centerCoordinate + vec2(-wOffset, -hOffset);\n        topRightCoordinate = centerCoordinate + vec2(-wOffset, hOffset);\n        bottomLeftCoordinate = centerCoordinate + vec2(wOffset, -hOffset);\n        bottomRightCoordinate = centerCoordinate + vec2(wOffset, hOffset);\n}", "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform samplerExternalOES inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n \n    varying vec2 centerCoordinate;\n    varying vec2 topLeftCoordinate;\n    varying vec2 topRightCoordinate;\n    varying vec2 bottomLeftCoordinate;\n    varying vec2 bottomRightCoordinate;\n\n\n    #define luminanceVec   vec3(0.2126, 0.7152, 0.0722)\n    \n    uniform lowp float mode;\n    \n uniform lowp float intensity;\n uniform lowp float isBnW;\n uniform lowp vec4 dims;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     lowp vec4 newColor = clamp(textureColor,vec4(0.0),vec4(1.0));\n     newColor.rgb *= dims.x;\n     highp float flr = floor(newColor.b);\n     highp vec2 xy = (0.5 + vec2(newColor.rg)) * dims.wz;\n     xy.x += (flr * dims.z);\n     lowp vec4 newColor1 = texture2D(inputImageTexture2, xy);\n     xy.x += dims.z;\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, xy);\n     newColor = mix(newColor1, newColor2, newColor.b - flr);\n     newColor = clamp(mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity),vec4(0.0),vec4(1.0));\n    \n        if(mode==1.0){        newColor.a = dot(textureColor.xyz, luminanceVec);       }else if(mode==2.0){\n        lowp vec4 topLeftSample = texture2D(inputImageTexture, topLeftCoordinate);\n        lowp vec4 topRightSample = texture2D(inputImageTexture, topRightCoordinate);\n        lowp vec4 bottomLeftSample = texture2D(inputImageTexture, bottomLeftCoordinate);\n        lowp vec4 bottomRightSample = texture2D(inputImageTexture, bottomRightCoordinate);\n        newColor.a = min(1.25, length(topLeftSample - bottomRightSample) + length(topRightSample - bottomLeftSample))/1.25;       }\ngl_FragColor = newColor; }");
        this.f16719 = 1.0f;
        m14752();
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        C2390 c2390M14754 = m14754(c2390, c23902, floatBuffer, floatBuffer2);
        C2390 c23903 = this.f11355;
        if (c23903 != null) {
            C3439.f11831.m11213(c23903);
            this.f11355 = null;
        }
        return c2390M14754;
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        m14753();
        m13482(this.f16715, this.f16723);
        m13482(this.f16714, this.f16722);
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ށ */
    public void mo9737() {
        super.mo9737();
        m14757(this.f16719);
        Log.d("GPUImageOesLookupFilter", String.format("onInitialized : %s", Float.valueOf(this.f14865)));
        m14758(this.f14865);
        m14755();
    }

    @Override // defpackage.C3222, defpackage.C4327
    /* renamed from: ނ */
    public void mo9491(int i, int i2) {
        super.mo9491(i, i2);
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f16722 = 1.0f / i;
        float f = 1.0f / i2;
        this.f16723 = f;
        m13482(this.f16715, f);
        m13482(this.f16714, this.f16722);
    }

    @Override // defpackage.C3222
    /* renamed from: ތ */
    public void mo9738(Bitmap bitmap) {
        super.mo9738(bitmap);
        if (bitmap.getWidth() % bitmap.getHeight() != 0) {
            throw new RuntimeException("LUT size is incorrect.");
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m14752() {
        this.f16710 = m13476("intensity");
        this.f16711 = m13476("isBnW");
        this.f16712 = m13476("uMVPMatrix");
        this.f16713 = m13476("uTexMatrix");
        this.f16714 = m13476("wOffset");
        this.f16715 = m13476("hOffset");
        this.f16716 = m13476("mode");
        this.f16717 = m13476("dims");
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f16724 = fArr;
        this.f16725 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.f16722 = 0.0f;
        this.f16723 = 0.0f;
        this.f16721 = 0.0f;
        this.f16718 = C5083.f16883;
        m13485(this.f16712, fArr);
        m13485(this.f16713, this.f16725);
        m13482(this.f16715, this.f16723);
        m13482(this.f16714, this.f16722);
        m13482(this.f16716, this.f16721);
        m13483(this.f16717, this.f16718);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m14753() {
        m13480(new RunnableC4973());
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public C2390 m14754(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
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
            GLES20.glBindTexture(36197, c23902.m8882());
            GLES20.glUniform1i(m13474(this.f14858), 0);
        }
        mo10879();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glDisableVertexAttribArray(this.f14860);
        GLES20.glBindTexture(36197, 0);
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
    public final void m14755() {
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m14756(float[] fArr) {
        System.arraycopy(fArr, 0, this.f16718, 0, fArr.length);
        m13483(this.f16717, this.f16718);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m14757(float f) {
        this.f16719 = f;
        m13482(this.f16710, f);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public void m14758(float f) {
        this.f14865 = f;
        Log.d("GPUImageOesLookupFilter", String.format("isBnW == %s", Float.valueOf(f)));
        m13482(this.f16711, this.f14865);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m14759(float f) {
        this.f16721 = f;
        m13482(this.f16716, f);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m14760(float[] fArr) {
        System.arraycopy(fArr, 0, this.f16725, 0, fArr.length);
        m13485(this.f16713, this.f16725);
    }
}
