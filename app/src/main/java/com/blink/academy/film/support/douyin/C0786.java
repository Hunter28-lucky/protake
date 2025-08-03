package com.blink.academy.film.support.douyin;

import android.opengl.GLES20;
import com.blink.academy.film.support.douyin.Drawable2d;
import defpackage.AbstractC2364;
import defpackage.AbstractC4527;
import java.nio.Buffer;

/* compiled from: ProgramTexture2d.java */
/* renamed from: com.blink.academy.film.support.douyin.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0786 extends AbstractC4527 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1549;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1550;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f1551;

    public C0786() {
        super("uniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\nfloat scale = 1.05;\nmat4 s = mat4(scale, 0.0, 0.0, 0.0,\n0.0, scale, 0.0, 0.0,\n0.0, 0.0, scale, 0.0,\n0.0, 0.0, 0.0, 1.0);\n    gl_Position = uMVPMatrix * s * aPosition;\n    vTextureCoord = aTextureCoord;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: ԩ, reason: contains not printable characters */
    public int mo1883(int i, int i2, int i3, float[] fArr) {
        AbstractC2364.m8831("draw start");
        m13871(i2, i3);
        AbstractC2364.m8831("initFrameBufferIfNeed");
        GLES20.glUseProgram(this.f15498);
        AbstractC2364.m8831("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        AbstractC2364.m8831("glBindTexture");
        GLES20.glBindFramebuffer(36160, this.f15500[0]);
        AbstractC2364.m8831("glBindFramebuffer");
        GLES20.glUniformMatrix4fv(this.f1549, 1, false, fArr, 0);
        AbstractC2364.m8831("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f1550);
        AbstractC2364.m8831("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1550, 2, 5126, false, 8, (Buffer) this.f15499.m1880());
        AbstractC2364.m8831("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f1551);
        AbstractC2364.m8831("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f1551, 2, 5126, false, 8, (Buffer) this.f15499.m1879());
        AbstractC2364.m8831("glVertexAttribPointer");
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glDrawArrays(5, 0, this.f15499.m1881());
        AbstractC2364.m8831("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f1550);
        GLES20.glDisableVertexAttribArray(this.f1551);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.f15501[0];
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: Ԫ, reason: contains not printable characters */
    public Drawable2d mo1884() {
        return new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    }

    @Override // defpackage.AbstractC4527
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo1885() {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f15498, "aPosition");
        this.f1550 = iGlGetAttribLocation;
        AbstractC2364.m8832(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(this.f15498, "aTextureCoord");
        this.f1551 = iGlGetAttribLocation2;
        AbstractC2364.m8832(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f15498, "uMVPMatrix");
        this.f1549 = iGlGetUniformLocation;
        AbstractC2364.m8832(iGlGetUniformLocation, "uMVPMatrix");
    }
}
