package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class lg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7508(pa paVar, Context context) {
        String strM7657 = ng.m7657(paVar, context, "pref_trade_token", "");
        hf.m6207("mspl", "get trade token: " + strM7657);
        return strM7657;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7509(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        for (int i = 0; i < strArrSplit.length; i++) {
            if (strArrSplit[i].startsWith("result={") && strArrSplit[i].endsWith("}")) {
                String[] strArrSplit2 = strArrSplit[i].substring(8, r3.length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= strArrSplit2.length) {
                        break;
                    }
                    if (strArrSplit2[i2].startsWith("trade_token=\"") && strArrSplit2[i2].endsWith("\"")) {
                        strSubstring = strArrSplit2[i2].substring(13, r1.length() - 1);
                        break;
                    }
                    if (strArrSplit2[i2].startsWith("trade_token=")) {
                        strSubstring = strArrSplit2[i2].substring(12);
                        break;
                    }
                    i2++;
                }
            }
        }
        return strSubstring;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m7510(pa paVar, Context context, String str) {
        try {
            String strM7509 = m7509(str);
            hf.m6207("mspl", "trade token: " + strM7509);
            if (TextUtils.isEmpty(strM7509)) {
                return;
            }
            ng.m7659(paVar, context, "pref_trade_token", strM7509);
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "SaveTradeTokenError", th);
            hf.m6205(th);
        }
    }
}
