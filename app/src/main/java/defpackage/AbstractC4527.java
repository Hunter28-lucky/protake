package defpackage;

import android.graphics.Point;
import android.opengl.GLES20;
import com.blink.academy.film.support.douyin.Drawable2d;

/* compiled from: Program.java */
/* renamed from: ఛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4527 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f15498;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int[] f15500;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int[] f15501;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Point f15503;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f15502 = 1;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Drawable2d f15499 = mo1884();

    public AbstractC4527(String str, String str2) {
        this.f15498 = C2662.m9802(str, str2);
        mo1885();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m13869(int i, int i2, int i3, int i4) {
        GLES20.glBindTexture(3553, i);
        GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m13870() {
        int[] iArr = this.f15501;
        if (iArr != null) {
            GLES20.glDeleteTextures(this.f15502, iArr, 0);
            this.f15501 = null;
        }
        int[] iArr2 = this.f15500;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(this.f15502, iArr2, 0);
            this.f15500 = null;
        }
    }

    /* renamed from: ԩ */
    public abstract int mo1883(int i, int i2, int i3, float[] fArr);

    /* renamed from: Ԫ */
    public abstract Drawable2d mo1884();

    /* renamed from: ԫ */
    public abstract void mo1885();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m13871(int i, int i2) {
        Point point = this.f15503;
        boolean z = true;
        boolean z2 = (point != null && point.x == i && point.y == i2) ? false : true;
        if (this.f15500 != null && this.f15501 != null) {
            z = z2;
        }
        if (z) {
            int i3 = this.f15502;
            int[] iArr = new int[i3];
            this.f15500 = iArr;
            this.f15501 = new int[i3];
            GLES20.glGenFramebuffers(i3, iArr, 0);
            GLES20.glGenTextures(this.f15502, this.f15501, 0);
            for (int i4 = 0; i4 < this.f15502; i4++) {
                m13869(this.f15501[i4], this.f15500[i4], i, i2);
            }
            this.f15503 = new Point(i, i2);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m13872() {
        m13870();
        GLES20.glDeleteProgram(this.f15498);
        this.f15498 = -1;
    }
}
