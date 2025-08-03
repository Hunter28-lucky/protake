package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* compiled from: DrawableToBitmapConverter.java */
/* renamed from: ɔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2572 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC2731 f9577 = new C2573();

    /* compiled from: DrawableToBitmapConverter.java */
    /* renamed from: ɔ$Ϳ, reason: contains not printable characters */
    public class C2573 extends C3912 {
        @Override // defpackage.C3912, defpackage.InterfaceC2731
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo9428(Bitmap bitmap) {
        }
    }

    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static InterfaceC4536<Bitmap> m9426(InterfaceC2731 interfaceC2731, Drawable drawable, int i, int i2) {
        Bitmap bitmapM9427;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapM9427 = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapM9427 = null;
        } else {
            bitmapM9427 = m9427(interfaceC2731, current, i, i2);
            z = true;
        }
        if (!z) {
            interfaceC2731 = f9577;
        }
        return C2739.m9994(bitmapM9427, interfaceC2731);
    }

    @Nullable
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Bitmap m9427(InterfaceC2731 interfaceC2731, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock lockM117 = b3.m117();
        lockM117.lock();
        Bitmap bitmapMo9982 = interfaceC2731.mo9982(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapMo9982);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapMo9982;
        } finally {
            lockM117.unlock();
        }
    }
}
