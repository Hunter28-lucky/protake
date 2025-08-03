package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import defpackage.C3921;

/* compiled from: SpannedString.kt */
/* loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        C3921.m12666(spanned, "<this>");
        C3921.m12670(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) spanned.getSpans(i, i2, Object.class);
        C3921.m12665(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        C3921.m12666(spanned, "<this>");
        C3921.m12670(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        C3921.m12665(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        C3921.m12665(spannedStringValueOf, "valueOf(this)");
        return spannedStringValueOf;
    }
}
