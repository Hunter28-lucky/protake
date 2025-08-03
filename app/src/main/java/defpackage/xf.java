package defpackage;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class xf {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Pattern f8747 = Pattern.compile("([\t\r\n])+");

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m8612(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m8613(String str) {
        return str == null || str.length() <= 0;
    }
}
