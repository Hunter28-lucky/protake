package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import defpackage.C3921;

/* compiled from: PorterDuff.kt */
/* loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i) {
        C3921.m12666(mode, "<this>");
        return new PorterDuffColorFilter(i, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        C3921.m12666(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
