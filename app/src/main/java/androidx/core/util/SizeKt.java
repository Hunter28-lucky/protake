package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: Size.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        C3921.m12666(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        C3921.m12666(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        C3921.m12666(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        C3921.m12666(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final float component1(SizeFCompat sizeFCompat) {
        C3921.m12666(sizeFCompat, "<this>");
        return sizeFCompat.getWidth();
    }

    public static final float component2(SizeFCompat sizeFCompat) {
        C3921.m12666(sizeFCompat, "<this>");
        return sizeFCompat.getHeight();
    }
}
