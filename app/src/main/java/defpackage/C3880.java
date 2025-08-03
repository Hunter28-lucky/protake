package defpackage;

import android.opengl.GLES20;

/* compiled from: FramebufferTexture.java */
/* renamed from: ࠂ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3880 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f13346;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f13347;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f13348;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f13349;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int[] f13350;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int[] f13351;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f13352;

    public C3880(int i, int i2, int i3) {
        this.f13346 = false;
        int[] iArr = {-1};
        this.f13350 = iArr;
        this.f13351 = new int[1];
        this.f13347 = i;
        this.f13348 = i2;
        this.f13349 = i3;
        this.f13352 = true;
        C4650.m14123("before texture alloc");
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            C4462.m13724(iArr[0], "texture", i, i2, i3 == 6408 ? 4 : 3);
            return;
        }
        throw new RuntimeException("got error during texture allocation:" + iGlGetError);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12326() {
        if (this.f13352) {
            int[] iArr = this.f13350;
            if (iArr[0] != -1) {
                GLES20.glDeleteTextures(1, iArr, 0);
                C4462.m13723(this.f13350[0]);
                this.f13350[0] = -1;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m12327() {
        return this.f13350[0];
    }

    public C3880(int i, int i2, int i3, int i4) {
        this.f13346 = false;
        int[] iArr = {-1};
        this.f13350 = iArr;
        this.f13351 = new int[1];
        this.f13347 = i;
        this.f13348 = i2;
        this.f13349 = i3;
        this.f13352 = false;
        iArr[0] = i4;
    }
}
