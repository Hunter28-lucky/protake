package defpackage;

import android.net.Uri;
import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jcodec.platform.Platform;

/* compiled from: ScanFromWebPageManager.java */
/* renamed from: ఋ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4505 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final CharSequence f15422 = "{CODE}";

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final CharSequence f15423 = "{RAWCODE}";

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final CharSequence f15424 = "{META}";

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final CharSequence f15425 = "{FORMAT}";

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final CharSequence f15426 = "{TYPE}";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f15427;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f15428;

    public C4505(Uri uri) {
        this.f15427 = uri.getQueryParameter("ret");
        this.f15428 = uri.getQueryParameter("raw") != null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m13803(CharSequence charSequence, CharSequence charSequence2, String str) throws UnsupportedEncodingException {
        if (charSequence2 == null) {
            charSequence2 = "";
        }
        try {
            charSequence2 = URLEncoder.encode(charSequence2.toString(), Platform.UTF_8);
        } catch (UnsupportedEncodingException unused) {
        }
        return str.replace(charSequence, charSequence2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m13804(Result result, AbstractC4118 abstractC4118) {
        return m13803(f15424, String.valueOf(result.getResultMetadata()), m13803(f15426, abstractC4118.m13064().toString(), m13803(f15425, result.getBarcodeFormat().toString(), m13803(f15423, result.getText(), m13803(f15422, this.f15428 ? result.getText() : abstractC4118.m13062(), this.f15427)))));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m13805() {
        return this.f15427 != null;
    }
}
