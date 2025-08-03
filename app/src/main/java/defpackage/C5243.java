package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.blink.academy.filter.core.TextureFormat;

/* compiled from: EffectRender.java */
/* renamed from: Ⴣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5243 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int[] f17374;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int[] f17375;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4243 f17377;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f17378;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f17379;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public volatile float[] f17373 = new float[16];

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f17376 = 1;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m15262() {
        int[] iArr = this.f17375;
        if (iArr != null) {
            GLES20.glDeleteTextures(this.f17376, iArr, 0);
            this.f17375 = null;
        }
        int[] iArr2 = this.f17374;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(this.f17376, iArr2, 0);
            this.f17374 = null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m15263(int i, TextureFormat textureFormat, int i2, int i3, int i4, boolean z, boolean z2) {
        if (this.f17377 == null) {
            this.f17377 = new C4243();
        }
        Matrix.setIdentityM(this.f17373, 0);
        AbstractC2364.m8834(this.f17373, z, z2);
        AbstractC2364.m8835(this.f17373, i4);
        return this.f17377.m13347(textureFormat).mo1883(i, i2, i3, this.f17373);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m15264() {
        m15262();
        C4243 c4243 = this.f17377;
        if (c4243 != null) {
            c4243.m13348();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m15265(int i, int i2) {
        this.f17378 = i;
        this.f17379 = i2;
    }
}
