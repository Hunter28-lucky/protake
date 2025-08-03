package defpackage;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: GPUImageFilter2.java */
/* renamed from: Ⴁ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5194 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int f17238;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float[] f17239;

    public C5194() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform highp mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    highp vec4 col = texture2D(inputImageTexture, textureCoordinate);\n    if(textureCoordinate.x < 0.0 || textureCoordinate.y < 0.0 || textureCoordinate.x > 1.0 || textureCoordinate.y > 1.0) {\n       col = vec4(0.0, 0.0, 0.0, 1.0);\n    }\n    gl_FragColor = col;\n}\n");
        this.f17238 = m13476("uTexMatrix");
        this.f17239 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    @Override // defpackage.C4327
    /* renamed from: ׯ */
    public C2390 mo8360(C2390 c2390, C2390 c23902, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
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
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindTexture(3553, c23902.m8882());
        GLES20.glUniform1i(m13474(this.f14858), 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f14857);
        GLES20.glDisableVertexAttribArray(this.f14860);
        GLES20.glBindTexture(3553, 0);
        C3439.f11831.m11213(c23902);
        return c2390;
    }

    @Override // defpackage.C4327
    /* renamed from: ށ */
    public void mo9737() {
        super.mo9737();
        m13485(this.f17238, this.f17239);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m15167(float[] fArr) {
        System.arraycopy(fArr, 0, this.f17239, 0, fArr.length);
        m13485(this.f17238, this.f17239);
    }
}
