package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import defpackage.C3921;

/* compiled from: Html.kt */
/* loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        C3921.m12666(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        C3921.m12665(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        C3921.m12666(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        C3921.m12665(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static final String toHtml(Spanned spanned, int i) {
        C3921.m12666(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        C3921.m12665(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        C3921.m12666(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        C3921.m12665(html, "toHtml(this, option)");
        return html;
    }
}
