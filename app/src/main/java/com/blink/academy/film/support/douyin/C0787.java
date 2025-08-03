package com.blink.academy.film.support.douyin;

import android.opengl.GLES20;
import com.blink.academy.film.support.douyin.Drawable2d;
import defpackage.AbstractC2364;
import defpackage.AbstractC4527;
import java.nio.Buffer;

/* compiled from: ProgramTextureOES.java */
/* renamed from: com.blink.academy.film.support.douyin.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0787 extends AbstractC4527 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1552;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1553;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f1554;

    public C0787() {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = aTextureCoord;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: ԩ */
    public int mo1883(int i, int i2, int i3, float[] fArr) {
        AbstractC2364.m8831("draw start");
        GLES20.glBindFramebuffer(36160, 0);
        m13871(i2, i3);
        AbstractC2364.m8831("initFrameBufferIfNeed");
        GLES20.glUseProgram(this.f15498);
        AbstractC2364.m8831("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        AbstractC2364.m8831("glBindTexture");
        GLES20.glBindFramebuffer(36160, this.f15500[0]);
        AbstractC2364.m8831("glBindFramebuffer");
        GLES20.glUniformMatrix4fv(this.f1552, 1, false, fArr, 0);
        AbstractC2364.m8831("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f1553);
        AbstractC2364.m8831("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1553, 2, 5126, false, 8, (Buffer) this.f15499.m1880());
        AbstractC2364.m8831("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f1554);
        AbstractC2364.m8831("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1554, 2, 5126, false, 8, (Buffer) this.f15499.m1879());
        AbstractC2364.m8831("glVertexAttribPointer");
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glDrawArrays(5, 0, this.f15499.m1881());
        AbstractC2364.m8831("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f1553);
        GLES20.glDisableVertexAttribArray(this.f1554);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.f15501[0];
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: Ԫ */
    public Drawable2d mo1884() {
        return new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: ԫ */
    public void mo1885() {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f15498, "aPosition");
        this.f1553 = iGlGetAttribLocation;
        AbstractC2364.m8832(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.f15498, "aTextureCoord");
        this.f1554 = iGlGetAttribLocation2;
        AbstractC2364.m8832(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f15498, "uMVPMatrix");
        this.f1552 = iGlGetUniformLocation;
        AbstractC2364.m8832(iGlGetUniformLocation, "uMVPMatrix");
    }
}
