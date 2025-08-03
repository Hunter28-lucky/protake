package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Headers.kt */
/* renamed from: Ⴌ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5207 implements Iterable<Pair<? extends String, ? extends String>>, InterfaceC4947 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C5209 f17261 = new C5209(null);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String[] f17262;

    /* compiled from: Headers.kt */
    /* renamed from: Ⴌ$Ϳ, reason: contains not printable characters */
    public static final class C5208 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<String> f17263 = new ArrayList(20);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C5208 m15187(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            C5209 c5209 = C5207.f17261;
            c5209.m15199(str);
            c5209.m15200(str2, str);
            m15189(str, str2);
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5208 m15188(String str) {
            C3921.m12667(str, "line");
            int iM7285 = StringsKt__StringsKt.m7285(str, ':', 1, false, 4, null);
            if (iM7285 != -1) {
                String strSubstring = str.substring(0, iM7285);
                C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iM7285 + 1);
                C3921.m12663(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                m15189(strSubstring, strSubstring2);
            } else if (str.charAt(0) == ':') {
                String strSubstring3 = str.substring(1);
                C3921.m12663(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                m15189("", strSubstring3);
            } else {
                m15189("", str);
            }
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C5208 m15189(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            this.f17263.add(str);
            this.f17263.add(StringsKt__StringsKt.m7319(str2).toString());
            return this;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C5208 m15190(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            C5207.f17261.m15199(str);
            m15189(str, str2);
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C5207 m15191() {
            Object[] array = this.f17263.toArray(new String[0]);
            if (array != null) {
                return new C5207((String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final String m15192(String str) {
            C3921.m12667(str, "name");
            C3181 c3181M13949 = C4542.m13949(C4542.m13948(this.f17263.size() - 2, 0), 2);
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
            while (!e0.m5967(str, this.f17263.get(iM10810), true)) {
                if (iM10810 == iM10811) {
                    return null;
                }
                iM10810 += iM10812;
            }
            return this.f17263.get(iM10810 + 1);
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final List<String> m15193() {
            return this.f17263;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final C5208 m15194(String str) {
            C3921.m12667(str, "name");
            int i = 0;
            while (i < this.f17263.size()) {
                if (e0.m5967(str, this.f17263.get(i), true)) {
                    this.f17263.remove(i);
                    this.f17263.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final C5208 m15195(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            C5209 c5209 = C5207.f17261;
            c5209.m15199(str);
            c5209.m15200(str2, str);
            m15194(str);
            m15189(str, str2);
            return this;
        }
    }

    /* compiled from: Headers.kt */
    /* renamed from: Ⴌ$Ԩ, reason: contains not printable characters */
    public static final class C5209 {
        public C5209() {
        }

        public /* synthetic */ C5209(C4184 c4184) {
            this();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m15199(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(i5.m6247("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m15200(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(i5.m6247("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final String m15201(String[] strArr, String str) {
            C3181 c3181M13949 = C4542.m13949(C4542.m13948(strArr.length - 2, 0), 2);
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
            while (!e0.m5967(str, strArr[iM10810], true)) {
                if (iM10810 == iM10811) {
                    return null;
                }
                iM10810 += iM10812;
            }
            return strArr[iM10810 + 1];
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C5207 m15202(String... strArr) throws CloneNotSupportedException {
            C3921.m12667(strArr, "namesAndValues");
            if (!(strArr.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr2 = (String[]) objClone;
            int length = strArr2.length;
            for (int i = 0; i < length; i++) {
                String str = strArr2[i];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr2[i] = StringsKt__StringsKt.m7319(str).toString();
            }
            C3181 c3181M13949 = C4542.m13949(C4542.m13950(0, strArr2.length), 2);
            int iM10810 = c3181M13949.m10810();
            int iM10811 = c3181M13949.m10811();
            int iM10812 = c3181M13949.m10812();
            if (iM10812 < 0 ? iM10810 >= iM10811 : iM10810 <= iM10811) {
                while (true) {
                    String str2 = strArr2[iM10810];
                    String str3 = strArr2[iM10810 + 1];
                    m15199(str2);
                    m15200(str3, str2);
                    if (iM10810 == iM10811) {
                        break;
                    }
                    iM10810 += iM10812;
                }
            }
            return new C5207(strArr2, null);
        }
    }

    public C5207(String[] strArr) {
        this.f17262 = strArr;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C5207 m15181(String... strArr) {
        return f17261.m15202(strArr);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C5207) && Arrays.equals(this.f17262, ((C5207) obj).f17262);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f17262);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = r3.m8147(m15183(i), m15185(i));
        }
        return C4948.m14719(pairArr);
    }

    public final int size() {
        return this.f17262.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(m15183(i));
            sb.append(": ");
            sb.append(m15185(i));
            sb.append("\n");
        }
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m15182(String str) {
        C3921.m12667(str, "name");
        return f17261.m15201(this.f17262, str);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m15183(int i) {
        return this.f17262[i * 2];
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C5208 m15184() {
        C5208 c5208 = new C5208();
        C3864.m12312(c5208.m15193(), this.f17262);
        return c5208;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String m15185(int i) {
        return this.f17262[(i * 2) + 1];
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<String> m15186(String str) {
        C3921.m12667(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (e0.m5967(str, m15183(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m15185(i));
            }
        }
        if (arrayList == null) {
            return C3131.m10712();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        C3921.m12663(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    public /* synthetic */ C5207(String[] strArr, C4184 c4184) {
        this(strArr);
    }
}
