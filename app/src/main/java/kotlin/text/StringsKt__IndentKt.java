package kotlin.text;

import defpackage.C2543;
import defpackage.C3131;
import defpackage.C3921;
import defpackage.C5042;
import defpackage.InterfaceC2392;
import defpackage.e0;
import defpackage.x;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Indent.kt */
/* loaded from: classes2.dex */
public class StringsKt__IndentKt extends x {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final InterfaceC2392<String, String> m7265(final String str) {
        return str.length() == 0 ? new InterfaceC2392<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // defpackage.InterfaceC2392
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final String invoke(String str2) {
                C3921.m12666(str2, "line");
                return str2;
            }
        } : new InterfaceC2392<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.InterfaceC2392
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public final String invoke(String str2) {
                C3921.m12666(str2, "line");
                return str + str2;
            }
        };
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final String m7266(String str, String str2, String str3) {
        int i;
        String strInvoke;
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "newIndent");
        C3921.m12666(str3, "marginPrefix");
        if (!(!e0.m5969(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listM7294 = StringsKt__StringsKt.m7294(str);
        int length = str.length() + (str2.length() * listM7294.size());
        InterfaceC2392<String, String> interfaceC2392M7265 = m7265(str2);
        int iM10713 = C3131.m10713(listM7294);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listM7294) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C3131.m10719();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iM10713) && e0.m5969(str4)) {
                str4 = null;
            } else {
                int length2 = str4.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!C5042.m14850(str4.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (e0.m5979(str4, str3, i, false, 4, null)) {
                        strSubstring = str4.substring(i5 + str3.length());
                        C3921.m12665(strSubstring, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = interfaceC2392M7265.invoke(strSubstring)) != null) {
                    str4 = strInvoke;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) C2543.m9371(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        C3921.m12665(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String m7267(String str, String str2) {
        C3921.m12666(str, "<this>");
        C3921.m12666(str2, "marginPrefix");
        return m7266(str, "", str2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static /* synthetic */ String m7268(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return m7267(str, str2);
    }
}
