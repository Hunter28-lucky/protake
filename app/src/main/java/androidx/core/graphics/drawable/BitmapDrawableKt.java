package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import defpackage.C3921;

/* compiled from: BitmapDrawable.kt */
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        C3921.m12666(bitmap, "<this>");
        C3921.m12666(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
