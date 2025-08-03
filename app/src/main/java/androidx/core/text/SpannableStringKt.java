package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import defpackage.C2523;
import defpackage.C3921;

/* compiled from: SpannableString.kt */
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        C3921.m12666(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        C3921.m12665(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        C3921.m12666(spannable, "<this>");
        C3921.m12666(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        C3921.m12665(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(Spannable spannable, C2523 c2523, Object obj) {
        C3921.m12666(spannable, "<this>");
        C3921.m12666(c2523, "range");
        C3921.m12666(obj, "span");
        spannable.setSpan(obj, c2523.getStart().intValue(), c2523.getEndInclusive().intValue(), 17);
    }
}
