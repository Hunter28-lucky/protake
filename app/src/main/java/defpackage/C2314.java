package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;

/* compiled from: MediaType.kt */
/* renamed from: ą, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2314 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f8798;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f8799;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f8800;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String[] f8801;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C2315 f8797 = new C2315(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Pattern f8795 = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Pattern f8796 = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: MediaType.kt */
    /* renamed from: ą$Ϳ, reason: contains not printable characters */
    public static final class C2315 {
        public C2315() {
        }

        public /* synthetic */ C2315(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2314 m8688(String str) {
            C3921.m12667(str, "$this$toMediaType");
            Matcher matcher = C2314.f8795.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            C3921.m12663(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            C3921.m12663(locale, "Locale.US");
            if (strGroup == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            C3921.m12663(strGroup2, "typeSubtype.group(2)");
            C3921.m12663(locale, "Locale.US");
            if (strGroup2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = strGroup2.toLowerCase(locale);
            C3921.m12663(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = C2314.f8796.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (e0.m5980(strGroup4, "'", false, 2, null) && e0.m5966(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        C3921.m12663(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new C2314(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C2314 m8689(String str) {
            C3921.m12667(str, "$this$toMediaTypeOrNull");
            try {
                return m8688(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public C2314(String str, String str2, String str3, String[] strArr) {
        this.f8798 = str;
        this.f8799 = str2;
        this.f8800 = str3;
        this.f8801 = strArr;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ Charset m8682(C2314 c2314, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return c2314.m8684(charset);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2314 m8683(String str) {
        return f8797.m8689(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2314) && C3921.m12662(((C2314) obj).f8798, this.f8798);
    }

    public int hashCode() {
        return this.f8798.hashCode();
    }

    public String toString() {
        return this.f8798;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Charset m8684(Charset charset) {
        String strM8685 = m8685("charset");
        if (strM8685 == null) {
            return charset;
        }
        try {
            return Charset.forName(strM8685);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String m8685(String str) {
        C3921.m12667(str, "name");
        C3181 c3181M13949 = C4542.m13949(C4962.m14741(this.f8801), 2);
        int iM10810 = c3181M13949.m10810();
        int iM10811 = c3181M13949.m10811();
        int iM10812 = c3181M13949.m10812();
        if (iM10812 >= 0) {
            if (iM10810 > iM10811) {
                return null;
            }
        } else if (iM10810 < iM10811) {
            return null;
        }
        while (!e0.m5967(this.f8801[iM10810], str, true)) {
            if (iM10810 == iM10811) {
                return null;
            }
            iM10810 += iM10812;
        }
        return this.f8801[iM10810 + 1];
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String m8686() {
        return this.f8800;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m8687() {
        return this.f8799;
    }

    public /* synthetic */ C2314(String str, String str2, String str3, String[] strArr, C4184 c4184) {
        this(str, str2, str3, strArr);
    }
}
