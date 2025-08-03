package defpackage;

/* compiled from: _Strings.kt */
/* loaded from: classes2.dex */
public class g0 extends f0 {
    /* renamed from: ࢨ, reason: contains not printable characters */
    public static final String m6072(String str, int i) {
        C3921.m12666(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(0, C4542.m13945(i, str.length()));
            C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
