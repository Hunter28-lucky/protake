package defpackage;

import android.opengl.Matrix;

/* renamed from: Ǵ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2498 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[] f9252;

    static {
        float[] fArr = new float[16];
        f9252 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float[] m9208(float[] fArr, boolean z, boolean z2) {
        if (z || z2) {
            Matrix.scaleM(fArr, 0, z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
        }
        return fArr;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float m9209(float f, float f2, float f3) {
        return (f * (1.0f - f3)) + (f2 * f3);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float[] m9210(float[] fArr, float f) {
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return fArr;
    }
}
