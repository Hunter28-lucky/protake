package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* renamed from: ࠨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3914 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Bitmap m12654(Bitmap bitmap, float f, float f2) {
        Matrix matrix = new Matrix();
        matrix.preScale(f, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
