package defpackage;

import io.jsonwebtoken.JwtParser;
import java.util.Comparator;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class e0 extends d0 {
    /* renamed from: ՠ, reason: contains not printable characters */
    public static final boolean m5965(String str, String str2, boolean z) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "suffix");
        return !z ? str.endsWith(str2) : m5970(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static /* synthetic */ boolean m5966(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m5965(str, str2, z);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final boolean m5967(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final Comparator<String> m5968(t tVar) {
        C3921.m12666(tVar, "<this>");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        C3921.m12665(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: ؠ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean m5969(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "<this>"
            defpackage.C3921.m12666(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            ș r0 = kotlin.text.StringsKt__StringsKt.m7279(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = r2
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            ķ r3 = (defpackage.AbstractC2348) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = defpackage.C5042.m14850(r3)
            if (r3 != 0) goto L24
            r4 = r1
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e0.m5969(java.lang.CharSequence):boolean");
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static final boolean m5970(String str, int i, String str2, int i2, int i3, boolean z) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static /* synthetic */ boolean m5971(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return m5970(str, i, str2, i2, i3, z);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static final String m5972(CharSequence charSequence, int i) {
        C3921.m12666(charSequence, "<this>");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + JwtParser.SEPARATOR_CHAR).toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        C3921.m12665(string, "{\n                    va…tring()\n                }");
        return string;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static final String m5973(String str, char c, char c2, boolean z) {
        C3921.m12666(str, "<this>");
        if (!z) {
            String strReplace = str.replace(c, c2);
            C3921.m12665(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (C3527.m11467(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        C3921.m12665(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static final String m5974(String str, String str2, String str3, boolean z) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "oldValue");
        C3921.m12666(str3, "newValue");
        int i = 0;
        int iM7282 = StringsKt__StringsKt.m7282(str, str2, 0, z);
        if (iM7282 < 0) {
            return str;
        }
        int length = str2.length();
        int iM13943 = C4542.m13943(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iM7282);
            sb.append(str3);
            i = iM7282 + length;
            if (iM7282 >= str.length()) {
                break;
            }
            iM7282 = StringsKt__StringsKt.m7282(str, str2, iM7282 + iM13943, z);
        } while (iM7282 > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        C3921.m12665(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static /* synthetic */ String m5975(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m5973(str, c, c2, z);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static /* synthetic */ String m5976(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m5974(str, str2, str3, z);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static final boolean m5977(String str, String str2, int i, boolean z) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "prefix");
        return !z ? str.startsWith(str2, i) : m5970(str, i, str2, 0, str2.length(), z);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static final boolean m5978(String str, String str2, boolean z) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "prefix");
        return !z ? str.startsWith(str2) : m5970(str, 0, str2, 0, str2.length(), z);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static /* synthetic */ boolean m5979(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m5977(str, str2, i, z);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static /* synthetic */ boolean m5980(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m5978(str, str2, z);
    }
}
