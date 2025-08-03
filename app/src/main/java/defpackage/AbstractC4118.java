package defpackage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.net.MailTo;
import com.google.android.gms.actions.SearchIntents;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ResultParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jcodec.platform.Platform;

/* compiled from: ResultHandler.java */
/* renamed from: ॴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4118 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f14261 = "ॴ";

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final String[] f14262 = {"home", "work", "mobile"};

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final String[] f14263 = {"home", "work", "mobile", "fax", "pager", "main"};

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final String[] f14264 = {"home", "work"};

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final int[] f14265 = {1, 2, 4};

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final int[] f14266 = {1, 3, 2, 4, 6, 12};

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final int[] f14267 = {1, 2};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ParsedResult f14268;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Activity f14269;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Result f14270;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f14271 = m13067();

    public AbstractC4118(Activity activity, ParsedResult parsedResult, Result result) {
        this.f14268 = parsedResult;
        this.f14269 = activity;
        this.f14270 = result;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m13059(Intent intent, String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        intent.putExtra(str, str2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m13060(String str) throws UnsupportedEncodingException {
        if (this.f14271 == null) {
            return str;
        }
        try {
            str = URLEncoder.encode(str, Platform.UTF_8);
        } catch (UnsupportedEncodingException unused) {
        }
        String strReplaceFirst = this.f14271;
        Result result = this.f14270;
        if (result != null) {
            strReplaceFirst = strReplaceFirst.replaceFirst("%f(?![0-9a-f])", result.getBarcodeFormat().toString());
            if (strReplaceFirst.contains("%t")) {
                strReplaceFirst = strReplaceFirst.replace("%t", ResultParser.parseResult(this.f14270).getType().toString());
            }
        }
        return strReplaceFirst.replace("%s", str);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Integer m13061() {
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public CharSequence m13062() {
        return this.f14268.getDisplayResult().replace("\r", "");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final ParsedResult m13063() {
        return this.f14268;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final ParsedResultType m13064() {
        return this.f14268.getType();
    }

    /* renamed from: Ԭ */
    public abstract void mo7996(int i);

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m13065(Intent intent) {
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m13066(String str) {
        if (str.startsWith("HTTP://")) {
            str = "http" + str.substring(4);
        } else if (str.startsWith("HTTPS://")) {
            str = "https" + str.substring(5);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            m13065(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w(f14261, "Nothing available to handle " + intent);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m13067() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.f14269).getString("preferences_custom_product_search", null);
        if (string == null || !string.trim().isEmpty()) {
            return string;
        }
        return null;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m13068(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND", Uri.parse(MailTo.MAILTO_SCHEME));
        if (strArr != null && strArr.length != 0) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        if (strArr2 != null && strArr2.length != 0) {
            intent.putExtra("android.intent.extra.CC", strArr2);
        }
        if (strArr3 != null && strArr3.length != 0) {
            intent.putExtra("android.intent.extra.BCC", strArr3);
        }
        m13059(intent, "android.intent.extra.SUBJECT", str);
        m13059(intent, "android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        m13065(intent);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m13069(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        m13059(intent, "sms_body", str2);
        intent.putExtra("compose_mode", true);
        m13065(intent);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m13070(String str) {
        m13068(null, null, null, null, str);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m13071(String str) {
        m13069("smsto:", str);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m13072(String str) {
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.putExtra(SearchIntents.EXTRA_QUERY, str);
        m13065(intent);
    }
}
