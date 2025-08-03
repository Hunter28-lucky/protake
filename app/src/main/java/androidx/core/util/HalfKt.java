package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;
import defpackage.C3921;

/* compiled from: Half.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s) {
        Half halfValueOf = Half.valueOf(s);
        C3921.m12665(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        Half halfValueOf = Half.valueOf(f);
        C3921.m12665(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        C3921.m12666(str, "<this>");
        Half halfValueOf = Half.valueOf(str);
        C3921.m12665(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        Half halfValueOf = Half.valueOf((float) d);
        C3921.m12665(halfValueOf, "valueOf(this)");
        return halfValueOf;
    }
}
