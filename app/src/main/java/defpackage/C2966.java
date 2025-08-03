package defpackage;

import android.opengl.Matrix;

/* compiled from: MatrixGLUtils.java */
/* renamed from: ң, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2966 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[] f10730;

    static {
        float[] fArr = new float[16];
        f10730 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m10378(float[] fArr, int i, int i2, int i3, int i4) {
        if (i2 <= 0 || i <= 0 || i3 <= 0 || i4 <= 0) {
            return;
        }
        float f = i3 / i4;
        float f2 = i / i2;
        if (f > f2) {
            Matrix.orthoM(fArr, 0, (-f) / f2, f / f2, -1.0f, 1.0f, -1.0f, 1.0f);
        } else {
            Matrix.orthoM(fArr, 0, -1.0f, 1.0f, (-f2) / f, f2 / f, -1.0f, 1.0f);
        }
    }
}
