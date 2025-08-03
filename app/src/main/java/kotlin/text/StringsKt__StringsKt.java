package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.C2523;
import defpackage.C2543;
import defpackage.C3181;
import defpackage.C3527;
import defpackage.C3535;
import defpackage.C3921;
import defpackage.C4119;
import defpackage.C4362;
import defpackage.C4542;
import defpackage.C4955;
import defpackage.C4962;
import defpackage.C5042;
import defpackage.C5064;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC4590;
import defpackage.e0;
import defpackage.r3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public class StringsKt__StringsKt extends e0 {
    /* renamed from: ތ, reason: contains not printable characters */
    public static final boolean m7272(CharSequence charSequence, char c, boolean z) {
        C3921.m12666(charSequence, "<this>");
        return m7285(charSequence, c, 0, z, 2, null) >= 0;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static final boolean m7273(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (m7286(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (m7284(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static /* synthetic */ boolean m7274(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m7272(charSequence, c, z);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static /* synthetic */ boolean m7275(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m7273(charSequence, charSequence2, z);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static final boolean m7276(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? e0.m5966((String) charSequence, (String) charSequence2, false, 2, null) : m7299(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static /* synthetic */ boolean m7277(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m7276(charSequence, charSequence2, z);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final Pair<Integer, String> m7278(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) C2543.m9378(collection);
            int iM7286 = !z2 ? m7286(charSequence, str, i, false, 4, null) : m7291(charSequence, str, i, false, 4, null);
            if (iM7286 < 0) {
                return null;
            }
            return r3.m8147(Integer.valueOf(iM7286), str);
        }
        C3181 c2523 = !z2 ? new C2523(C4542.m13943(i, 0), charSequence.length()) : C4542.m13948(C4542.m13945(i, m7280(charSequence)), 0);
        if (charSequence instanceof String) {
            int iM10810 = c2523.m10810();
            int iM10811 = c2523.m10811();
            int iM10812 = c2523.m10812();
            if ((iM10812 > 0 && iM10810 <= iM10811) || (iM10812 < 0 && iM10811 <= iM10810)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (e0.m5970(str2, 0, (String) charSequence, iM10810, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iM10810 == iM10811) {
                            break;
                        }
                        iM10810 += iM10812;
                    } else {
                        return r3.m8147(Integer.valueOf(iM10810), str3);
                    }
                }
            }
        } else {
            int iM108102 = c2523.m10810();
            int iM108112 = c2523.m10811();
            int iM108122 = c2523.m10812();
            if ((iM108122 > 0 && iM108102 <= iM108112) || (iM108122 < 0 && iM108112 <= iM108102)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (m7299(str4, 0, charSequence, iM108102, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iM108102 == iM108112) {
                            break;
                        }
                        iM108102 += iM108122;
                    } else {
                        return r3.m8147(Integer.valueOf(iM108102), str5);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final C2523 m7279(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return new C2523(0, charSequence.length() - 1);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final int m7280(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final int m7281(CharSequence charSequence, char c, int i, boolean z) {
        C3921.m12666(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m7287(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static final int m7282(CharSequence charSequence, String str, int i, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(str, TypedValues.Custom.S_STRING);
        return (z || !(charSequence instanceof String)) ? m7284(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static final int m7283(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C3181 c2523 = !z2 ? new C2523(C4542.m13943(i, 0), C4542.m13945(i2, charSequence.length())) : C4542.m13948(C4542.m13945(i, m7280(charSequence)), C4542.m13943(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iM10810 = c2523.m10810();
            int iM10811 = c2523.m10811();
            int iM10812 = c2523.m10812();
            if ((iM10812 <= 0 || iM10810 > iM10811) && (iM10812 >= 0 || iM10811 > iM10810)) {
                return -1;
            }
            while (!e0.m5970((String) charSequence2, 0, (String) charSequence, iM10810, charSequence2.length(), z)) {
                if (iM10810 == iM10811) {
                    return -1;
                }
                iM10810 += iM10812;
            }
            return iM10810;
        }
        int iM108102 = c2523.m10810();
        int iM108112 = c2523.m10811();
        int iM108122 = c2523.m10812();
        if ((iM108122 <= 0 || iM108102 > iM108112) && (iM108122 >= 0 || iM108112 > iM108102)) {
            return -1;
        }
        while (!m7299(charSequence2, 0, charSequence, iM108102, charSequence2.length(), z)) {
            if (iM108102 == iM108112) {
                return -1;
            }
            iM108102 += iM108122;
        }
        return iM108102;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static /* synthetic */ int m7284(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return m7283(charSequence, charSequence2, i, i2, z, z2);
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static /* synthetic */ int m7285(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m7281(charSequence, c, i, z);
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static /* synthetic */ int m7286(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m7282(charSequence, str, i, z);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static final int m7287(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(C4962.m14744(cArr), i);
        }
        int iM13943 = C4542.m13943(i, 0);
        int iM7280 = m7280(charSequence);
        if (iM13943 > iM7280) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iM13943);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (C3527.m11467(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iM13943;
            }
            if (iM13943 == iM7280) {
                return -1;
            }
            iM13943++;
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public static final int m7288(CharSequence charSequence, char c, int i, boolean z) {
        C3921.m12666(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m7292(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public static final int m7289(CharSequence charSequence, String str, int i, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(str, TypedValues.Custom.S_STRING);
        return (z || !(charSequence instanceof String)) ? m7283(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public static /* synthetic */ int m7290(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m7280(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m7288(charSequence, c, i, z);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public static /* synthetic */ int m7291(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m7280(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m7289(charSequence, str, i, z);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public static final int m7292(CharSequence charSequence, char[] cArr, int i, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C4962.m14744(cArr), i);
        }
        for (int iM13945 = C4542.m13945(i, m7280(charSequence)); -1 < iM13945; iM13945--) {
            char cCharAt = charSequence.charAt(iM13945);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (C3527.m11467(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iM13945;
            }
        }
        return -1;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public static final InterfaceC4590<String> m7293(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return m7307(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public static final List<String> m7294(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        return C4119.m13080(m7293(charSequence));
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public static final InterfaceC4590<C2523> m7295(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        m7302(i2);
        return new C3535(charSequence, i, i2, new InterfaceC2849<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.InterfaceC2849
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return m7320(charSequence2, num.intValue());
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final Pair<Integer, Integer> m7320(CharSequence charSequence2, int i3) {
                C3921.m12666(charSequence2, "$this$$receiver");
                int iM7287 = StringsKt__StringsKt.m7287(charSequence2, cArr, i3, z);
                if (iM7287 < 0) {
                    return null;
                }
                return r3.m8147(Integer.valueOf(iM7287), 1);
            }
        });
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public static final InterfaceC4590<C2523> m7296(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        m7302(i2);
        final List listM14725 = C4955.m14725(strArr);
        return new C3535(charSequence, i, i2, new InterfaceC2849<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.InterfaceC2849
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return m7321(charSequence2, num.intValue());
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final Pair<Integer, Integer> m7321(CharSequence charSequence2, int i3) {
                C3921.m12666(charSequence2, "$this$$receiver");
                Pair pairM7278 = StringsKt__StringsKt.m7278(charSequence2, listM14725, i3, z, false);
                if (pairM7278 != null) {
                    return r3.m8147(pairM7278.m7209(), Integer.valueOf(((String) pairM7278.m7210()).length()));
                }
                return null;
            }
        });
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC4590 m7297(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m7295(charSequence, cArr, i, z, i2);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC4590 m7298(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m7296(charSequence, strArr, i, z, i2);
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public static final boolean m7299(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C3527.m11467(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public static final String m7300(String str, CharSequence charSequence) {
        C3921.m12666(str, "<this>");
        C3921.m12666(charSequence, "prefix");
        if (!m7309(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        C3921.m12665(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public static final String m7301(String str, CharSequence charSequence) {
        C3921.m12666(str, "<this>");
        C3921.m12666(charSequence, "suffix");
        if (!m7277(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public static final void m7302(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public static final List<String> m7303(CharSequence charSequence, char[] cArr, boolean z, int i) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(cArr, "delimiters");
        if (cArr.length == 1) {
            return m7304(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableM13073 = C4119.m13073(m7297(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(C4362.m13522(iterableM13073, 10));
        Iterator it = iterableM13073.iterator();
        while (it.hasNext()) {
            arrayList.add(m7310(charSequence, (C2523) it.next()));
        }
        return arrayList;
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public static final List<String> m7304(CharSequence charSequence, String str, boolean z, int i) {
        m7302(i);
        int length = 0;
        int iM7282 = m7282(charSequence, str, 0, z);
        if (iM7282 == -1 || i == 1) {
            return C5064.m14877(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? C4542.m13945(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iM7282).toString());
            length = str.length() + iM7282;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iM7282 = m7282(charSequence, str, length, z);
        } while (iM7282 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public static /* synthetic */ List m7305(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m7303(charSequence, cArr, z, i);
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public static final InterfaceC4590<String> m7306(final CharSequence charSequence, String[] strArr, boolean z, int i) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(strArr, "delimiters");
        return C4119.m13078(m7298(charSequence, strArr, 0, z, i, 2, null), new InterfaceC2392<C2523, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.InterfaceC2392
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final String invoke(C2523 c2523) {
                C3921.m12666(c2523, "it");
                return StringsKt__StringsKt.m7310(charSequence, c2523);
            }
        });
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC4590 m7307(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m7306(charSequence, strArr, z, i);
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public static final boolean m7308(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? e0.m5980((String) charSequence, (String) charSequence2, false, 2, null) : m7299(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public static /* synthetic */ boolean m7309(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m7308(charSequence, charSequence2, z);
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public static final String m7310(CharSequence charSequence, C2523 c2523) {
        C3921.m12666(charSequence, "<this>");
        C3921.m12666(c2523, "range");
        return charSequence.subSequence(c2523.getStart().intValue(), c2523.getEndInclusive().intValue() + 1).toString();
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public static final String m7311(String str, String str2, String str3) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "delimiter");
        C3921.m12666(str3, "missingDelimiterValue");
        int iM7286 = m7286(str, str2, 0, false, 6, null);
        if (iM7286 == -1) {
            return str3;
        }
        String strSubstring = str.substring(iM7286 + str2.length(), str.length());
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public static /* synthetic */ String m7312(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m7311(str, str2, str3);
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public static final String m7313(String str, char c, String str2) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "missingDelimiterValue");
        int iM7290 = m7290(str, c, 0, false, 6, null);
        if (iM7290 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iM7290 + 1, str.length());
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public static /* synthetic */ String m7314(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m7313(str, c, str2);
    }

    /* renamed from: ࢣ, reason: contains not printable characters */
    public static final String m7315(String str, char c, String str2) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "missingDelimiterValue");
        int iM7285 = m7285(str, c, 0, false, 6, null);
        if (iM7285 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iM7285);
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ࢤ, reason: contains not printable characters */
    public static final String m7316(String str, String str2, String str3) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "delimiter");
        C3921.m12666(str3, "missingDelimiterValue");
        int iM7286 = m7286(str, str2, 0, false, 6, null);
        if (iM7286 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iM7286);
        C3921.m12665(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ࢥ, reason: contains not printable characters */
    public static /* synthetic */ String m7317(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m7315(str, c, str2);
    }

    /* renamed from: ࢦ, reason: contains not printable characters */
    public static /* synthetic */ String m7318(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return m7316(str, str2, str3);
    }

    /* renamed from: ࢧ, reason: contains not printable characters */
    public static final CharSequence m7319(CharSequence charSequence) {
        C3921.m12666(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zM14850 = C5042.m14850(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zM14850) {
                    break;
                }
                length--;
            } else if (zM14850) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
