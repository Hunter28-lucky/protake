package defpackage;

import com.alipay.sdk.m.j.c;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class rg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8197(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th) {
            hf.m6205(th);
        }
        return "?";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Map<String, String> m8198() {
        c cVarB = c.b(c.CANCELED.m342());
        HashMap map = new HashMap();
        map.put("resultStatus", Integer.toString(cVarB.m342()));
        map.put("memo", cVarB.m341());
        map.put("result", "");
        return map;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Map<String, String> m8199(pa paVar, String str) {
        Map<String, String> mapM8198 = m8198();
        try {
            return m8200(str);
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "FormatResultEx", th);
            return mapM8198;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Map<String, String> m8200(String str) {
        String[] strArrSplit = str.split(";");
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String strSubstring = str2.substring(0, str2.indexOf("={"));
            map.put(strSubstring, m8201(str2, strSubstring));
        }
        return map;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m8201(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }
}
