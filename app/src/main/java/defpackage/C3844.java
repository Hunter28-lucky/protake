package defpackage;

import android.graphics.Color;

/* compiled from: PaintCodeColor.java */
/* renamed from: ߘ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3844 extends Color {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m12260(int i, float f, int i2) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((f2 * Color.blue(i)) + (Color.blue(i2) * f)));
    }
}
