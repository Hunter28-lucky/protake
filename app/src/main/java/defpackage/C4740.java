package defpackage;

import android.graphics.LinearGradient;
import android.graphics.Shader;

/* compiled from: PaintCodeGradient.java */
/* renamed from: ഹ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4740 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int[] f16004;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float[] f16005;

    public C4740(int[] iArr, float[] fArr) {
        int length = iArr.length;
        if (fArr == null) {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = i / (length - 1);
            }
        }
        this.f16004 = iArr;
        this.f16005 = fArr;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public LinearGradient m14279(float f, float f2, float f3, float f4) {
        return new LinearGradient(f, f2, f3, f4, this.f16004, this.f16005, Shader.TileMode.CLAMP);
    }
}
