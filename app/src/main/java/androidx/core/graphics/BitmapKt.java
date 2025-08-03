package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.am;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Bitmap.kt */
/* loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, InterfaceC2392<? super Canvas, i4> interfaceC2392) {
        C3921.m12666(bitmap, "<this>");
        C3921.m12666(interfaceC2392, "block");
        interfaceC2392.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i;
        C3921.m12666(bitmap, "<this>");
        C3921.m12666(point, am.ax);
        int width = bitmap.getWidth();
        int i2 = point.x;
        return (i2 >= 0 && i2 < width) && (i = point.y) >= 0 && i < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config) {
        C3921.m12666(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        C3921.m12665(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        C3921.m12666(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        C3921.m12665(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static final int get(Bitmap bitmap, int i, int i2) {
        C3921.m12666(bitmap, "<this>");
        return bitmap.getPixel(i, i2);
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        C3921.m12666(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        C3921.m12665(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        C3921.m12666(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, z);
        C3921.m12665(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void set(Bitmap bitmap, int i, int i2, @ColorInt int i3) {
        C3921.m12666(bitmap, "<this>");
        bitmap.setPixel(i, i2, i3);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        C3921.m12666(bitmap, "<this>");
        C3921.m12666(pointF, am.ax);
        float f = pointF.x;
        if (f >= 0.0f && f < bitmap.getWidth()) {
            float f2 = pointF.y;
            if (f2 >= 0.0f && f2 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace) {
        C3921.m12666(config, "config");
        C3921.m12666(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        C3921.m12665(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i2, Bitmap.Config config, boolean z, ColorSpace colorSpace, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            C3921.m12665(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        C3921.m12666(config, "config");
        C3921.m12666(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config, z, colorSpace);
        C3921.m12665(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }
}
