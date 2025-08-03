package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import java.util.Locale;

/* compiled from: Locale.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale locale) {
        C3921.m12666(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
