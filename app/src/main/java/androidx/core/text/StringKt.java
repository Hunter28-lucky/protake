package androidx.core.text;

import android.text.TextUtils;
import defpackage.C3921;

/* compiled from: String.kt */
/* loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        C3921.m12666(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        C3921.m12665(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
