package defpackage;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class ka {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m7182(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.split("&");
        if (strArrSplit.length == 0) {
            return "";
        }
        String strM7186 = null;
        String strM7185 = null;
        String strM7187 = null;
        String strM7184 = null;
        for (String str2 : strArrSplit) {
            if (TextUtils.isEmpty(strM7186)) {
                strM7186 = m7186(str2);
            }
            if (TextUtils.isEmpty(strM7185)) {
                strM7185 = m7185(str2);
            }
            if (TextUtils.isEmpty(strM7187)) {
                strM7187 = m7187(str2);
            }
            if (TextUtils.isEmpty(strM7184)) {
                strM7184 = m7184(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(strM7186)) {
            sb.append("biz_type=" + strM7186 + ";");
        }
        if (!TextUtils.isEmpty(strM7185)) {
            sb.append("biz_no=" + strM7185 + ";");
        }
        if (!TextUtils.isEmpty(strM7187)) {
            sb.append("trade_no=" + strM7187 + ";");
        }
        if (!TextUtils.isEmpty(strM7184)) {
            sb.append("app_userid=" + strM7184 + ";");
        }
        String string = sb.toString();
        return string.endsWith(";") ? string.substring(0, string.length() - 1) : string;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m7183(String str) {
        String[] strArrSplit = str.split("=");
        if (strArrSplit.length <= 1) {
            return null;
        }
        String str2 = strArrSplit[1];
        return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m7184(String str) {
        if (str.contains("app_userid")) {
            return m7183(str);
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7185(String str) {
        if (str.contains("biz_no")) {
            return m7183(str);
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m7186(String str) {
        if (str.contains("biz_type")) {
            return m7183(str);
        }
        return null;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m7187(String str) {
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
            return null;
        }
        return m7183(str);
    }
}
