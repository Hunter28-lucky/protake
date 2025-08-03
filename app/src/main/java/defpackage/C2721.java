package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import defpackage.C2420;
import java.nio.IntBuffer;

/* compiled from: BitmapUtils.java */
/* renamed from: ʳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2721 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Bitmap m9975(int i, int i2, final int i3, final int i4) throws InterruptedException {
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        C2420.m8914().m8915(i3, i4, new C2420.InterfaceC2421() { // from class: ˀ
            @Override // defpackage.C2420.InterfaceC2421
            /* renamed from: Ϳ */
            public final void mo8916(IntBuffer intBuffer) {
                C2721.m9977(i3, i4, bitmapCreateBitmap, intBuffer);
            }
        });
        return m9978(bitmapCreateBitmap, i, i2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Bitmap m9976(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        matrix.postRotate(-90.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ void m9977(int i, int i2, Bitmap bitmap, IntBuffer intBuffer) {
        GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, intBuffer);
        bitmap.copyPixelsFromBuffer(intBuffer);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Bitmap m9978(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        C2735.m9988(bitmap);
        return bitmapCreateScaledBitmap;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static float m9979(int i, int i2, int i3, int i4) {
        return Math.min(1.5f, Math.max(i3 / i, i4 / i2));
    }
}
