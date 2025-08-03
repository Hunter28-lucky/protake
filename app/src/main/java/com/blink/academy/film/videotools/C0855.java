package com.blink.academy.film.videotools;

import android.graphics.Bitmap;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import defpackage.C2735;
import defpackage.C3220;
import defpackage.C3732;
import defpackage.C4092;
import defpackage.C5128;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: PictureDecoder.java */
/* renamed from: com.blink.academy.film.videotools.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0855 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f1889 = "PictureDecoder";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f1890 = true;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Bitmap f1891;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f1892;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f1893;

    public C0855(Bitmap bitmap, int i, int i2) {
        this.f1891 = bitmap;
        this.f1892 = i2;
        this.f1893 = i;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2107(int i) {
        int iAbs;
        int i2 = this.f1893;
        if (i2 == 0) {
            iAbs = Math.abs(this.f1892 - 270);
        } else if (i2 != 1) {
            iAbs = i2 != 2 ? Math.abs(this.f1892 - 270) : Math.abs(this.f1892 + MPEGConst.SEQUENCE_ERROR_CODE) % MPEGConst.SEQUENCE_ERROR_CODE;
        } else {
            iAbs = (-(360 - this.f1892)) % 360;
            if (iAbs == 0) {
                iAbs = -1;
            }
        }
        this.f1891 = C2735.m9986(this.f1891, iAbs);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C0851 m2108(C3732 c3732) {
        int height;
        int width;
        Bitmap bitmap = this.f1891;
        if (bitmap == null) {
            return null;
        }
        int i = this.f1893;
        if (i == 0) {
            int i2 = this.f1892;
            if (i2 == 0 || i2 == 180) {
                height = bitmap.getHeight();
                width = this.f1891.getWidth();
            } else {
                height = bitmap.getWidth();
                width = this.f1891.getHeight();
            }
        } else if (i == 1) {
            int i3 = this.f1892;
            if (i3 == 0 || i3 == 180) {
                height = bitmap.getHeight();
                width = this.f1891.getWidth();
            } else {
                height = bitmap.getWidth();
                width = this.f1891.getHeight();
            }
        } else if (i != 2) {
            int i4 = this.f1892;
            if (i4 == 0 || i4 == 180) {
                height = bitmap.getHeight();
                width = this.f1891.getWidth();
            } else {
                height = bitmap.getWidth();
                width = this.f1891.getHeight();
            }
        } else {
            int i5 = this.f1892;
            if (i5 == 0 || 180 == i5) {
                height = bitmap.getWidth();
                width = this.f1891.getHeight();
            } else {
                height = bitmap.getHeight();
                width = this.f1891.getWidth();
            }
        }
        int iM13041 = C4092.m13041();
        if (height > iM13041) {
            width = (int) (((width * iM13041) * 1.0f) / height);
            height = iM13041;
        } else if (width > iM13041) {
            height = (int) (((height * iM13041) * 1.0f) / width);
            width = iM13041;
        }
        int[] iArrM10876 = C3220.m10876(height + (height % 2), width + (width % 2), c3732);
        int i6 = iArrM10876[0];
        int i7 = iArrM10876[1];
        EGLSurface eGLSurfaceM11950 = c3732.m11950(i6, i7);
        if (eGLSurfaceM11950 == null) {
            throw new RuntimeException("surface was null");
        }
        c3732.m11957(eGLSurfaceM11950);
        C0851 c0851 = new C0851();
        c0851.m2093(1, i6, i7);
        c0851.f1861 = i6;
        c0851.f1862 = i7;
        c0851.f1863 = i6;
        c0851.f1864 = i7;
        c0851.f1865 = 10;
        GLES20.glScissor(0, 0, i6, i7);
        GLES20.glViewport(0, 0, i6, i7);
        C5128 c5128 = new C5128();
        long jNanoTime = System.nanoTime();
        m2107(0);
        c3732.m11957(eGLSurfaceM11950);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glScissor(0, 0, i6, i7);
        GLES20.glViewport(0, 0, i6, i7);
        c5128.m15046(this.f1891, i6, i7);
        c0851.m2095(jNanoTime);
        c5128.m15047();
        c3732.m11953(eGLSurfaceM11950);
        C2735.m9988(this.f1891);
        return c0851;
    }
}
