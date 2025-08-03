package androidx.core.text;

import android.text.TextUtils;
import defpackage.C3921;

/* compiled from: CharSequence.kt */
/* loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
