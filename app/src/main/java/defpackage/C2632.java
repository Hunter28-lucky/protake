package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.google.android.gms.common.internal.ImagesContract;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: Cookie.kt */
/* renamed from: ɼ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2632 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f9795;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f9796;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final long f9797;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f9798;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f9799;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f9800;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f9801;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f9802;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f9803;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final C2634 f9794 = new C2634(null);

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final Pattern f9790 = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final Pattern f9791 = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: ֏, reason: contains not printable characters */
    public static final Pattern f9792 = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final Pattern f9793 = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: Cookie.kt */
    /* renamed from: ɼ$Ϳ, reason: contains not printable characters */
    public static final class C2633 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f9804;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f9805;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f9807;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f9809;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f9810;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f9811;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f9812;

        /* renamed from: ԩ, reason: contains not printable characters */
        public long f9806 = 253402300799999L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public String f9808 = "/";

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2632 m9702() {
            String str = this.f9804;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.f9805;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.f9806;
            String str3 = this.f9807;
            if (str3 != null) {
                return new C2632(str, str2, j, str3, this.f9808, this.f9809, this.f9810, this.f9811, this.f9812, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C2633 m9703(String str) {
            C3921.m12667(str, "domain");
            return m9704(str, false);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C2633 m9704(String str, boolean z) {
            String strM13710 = C4446.m13710(str);
            if (strM13710 != null) {
                this.f9807 = strM13710;
                this.f9812 = z;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C2633 m9705(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > 253402300799999L) {
                j = 253402300799999L;
            }
            this.f9806 = j;
            this.f9811 = true;
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2633 m9706(String str) {
            C3921.m12667(str, "domain");
            return m9704(str, true);
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2633 m9707() {
            this.f9810 = true;
            return this;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C2633 m9708(String str) {
            C3921.m12667(str, "name");
            if (!C3921.m12662(StringsKt__StringsKt.m7319(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.f9804 = str;
            return this;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final C2633 m9709(String str) {
            C3921.m12667(str, "path");
            if (!e0.m5980(str, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.f9808 = str;
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final C2633 m9710() {
            this.f9809 = true;
            return this;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C2633 m9711(String str) {
            C3921.m12667(str, "value");
            if (!C3921.m12662(StringsKt__StringsKt.m7319(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.f9805 = str;
            return this;
        }
    }

    /* compiled from: Cookie.kt */
    /* renamed from: ɼ$Ԩ, reason: contains not printable characters */
    public static final class C2634 {
        public C2634() {
        }

        public /* synthetic */ C2634(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int m9712(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean m9713(String str, String str2) {
            if (C3921.m12662(str, str2)) {
                return true;
            }
            return e0.m5966(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !i5.m6236(str);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C2632 m9714(C3573 c3573, String str) {
            C3921.m12667(c3573, ImagesContract.URL);
            C3921.m12667(str, "setCookie");
            return m9715(System.currentTimeMillis(), c3573, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[PHI: r1
          0x00dc: PHI (r1v25 long) = (r1v8 long), (r1v12 long) binds: [B:45:0x00da, B:56:0x0102] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: Ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final defpackage.C2632 m9715(long r26, defpackage.C3573 r28, java.lang.String r29) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 379
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C2632.C2634.m9715(long, ڭ, java.lang.String):ɼ");
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final List<C2632> m9716(C3573 c3573, C5207 c5207) {
            C3921.m12667(c3573, ImagesContract.URL);
            C3921.m12667(c5207, "headers");
            List<String> listM15186 = c5207.m15186(HttpHeaders.HEAD_KEY_SET_COOKIE);
            int size = listM15186.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                C2632 c2632M9714 = m9714(c3573, listM15186.get(i));
                if (c2632M9714 != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c2632M9714);
                }
            }
            if (arrayList == null) {
                return C3131.m10712();
            }
            List<C2632> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            C3921.m12663(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
            return listUnmodifiableList;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final String m9717(String str) {
            if (!(!e0.m5966(str, ".", false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strM13710 = C4446.m13710(StringsKt__StringsKt.m7300(str, "."));
            if (strM13710 != null) {
                return strM13710;
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final long m9718(String str, int i, int i2) throws NumberFormatException {
            int iM9712 = m9712(str, i, i2, false);
            Matcher matcher = C2632.f9793.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iM7286 = -1;
            int i6 = -1;
            int i7 = -1;
            while (iM9712 < i2) {
                int iM97122 = m9712(str, iM9712 + 1, i2, true);
                matcher.region(iM9712, iM97122);
                if (i4 == -1 && matcher.usePattern(C2632.f9793).matches()) {
                    String strGroup = matcher.group(1);
                    C3921.m12663(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    C3921.m12663(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    C3921.m12663(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(C2632.f9792).matches()) {
                    String strGroup4 = matcher.group(1);
                    C3921.m12663(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iM7286 == -1 && matcher.usePattern(C2632.f9791).matches()) {
                    String strGroup5 = matcher.group(1);
                    C3921.m12663(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    C3921.m12663(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = C2632.f9791.pattern();
                    C3921.m12663(strPattern, "MONTH_PATTERN.pattern()");
                    iM7286 = StringsKt__StringsKt.m7286(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i3 == -1 && matcher.usePattern(C2632.f9790).matches()) {
                    String strGroup6 = matcher.group(1);
                    C3921.m12663(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
                iM9712 = m9712(str, iM97122 + 1, i2, false);
            }
            if (70 <= i3 && 99 >= i3) {
                i3 += 1900;
            }
            if (i3 >= 0 && 69 >= i3) {
                i3 += 2000;
            }
            if (!(i3 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iM7286 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i5 && 31 >= i5)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i4 >= 0 && 23 >= i4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i6 >= 0 && 59 >= i6)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i7 >= 0 && 59 >= i7)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(i5.f6768);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iM7286 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final long m9719(String str) throws NumberFormatException {
            try {
                long j = Long.parseLong(str);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e2) {
                if (new Regex("-?\\d+").m7263(str)) {
                    return e0.m5980(str, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e2;
            }
        }
    }

    public C2632(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9795 = str;
        this.f9796 = str2;
        this.f9797 = j;
        this.f9798 = str3;
        this.f9799 = str4;
        this.f9800 = z;
        this.f9801 = z2;
        this.f9802 = z3;
        this.f9803 = z4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2632) {
            C2632 c2632 = (C2632) obj;
            if (C3921.m12662(c2632.f9795, this.f9795) && C3921.m12662(c2632.f9796, this.f9796) && c2632.f9797 == this.f9797 && C3921.m12662(c2632.f9798, this.f9798) && C3921.m12662(c2632.f9799, this.f9799) && c2632.f9800 == this.f9800 && c2632.f9801 == this.f9801 && c2632.f9802 == this.f9802 && c2632.f9803 == this.f9803) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.f9795.hashCode()) * 31) + this.f9796.hashCode()) * 31) + C2649.m9750(this.f9797)) * 31) + this.f9798.hashCode()) * 31) + this.f9799.hashCode()) * 31) + C3176.m10784(this.f9800)) * 31) + C3176.m10784(this.f9801)) * 31) + C3176.m10784(this.f9802)) * 31) + C3176.m10784(this.f9803);
    }

    public String toString() {
        return m9700(false);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String m9692() {
        return this.f9798;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long m9693() {
        return this.f9797;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m9694() {
        return this.f9803;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m9695() {
        return this.f9801;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m9696() {
        return this.f9795;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final String m9697() {
        return this.f9799;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m9698() {
        return this.f9802;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m9699() {
        return this.f9800;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final String m9700(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9795);
        sb.append('=');
        sb.append(this.f9796);
        if (this.f9802) {
            if (this.f9797 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(C4711.m14250(new Date(this.f9797)));
            }
        }
        if (!this.f9803) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f9798);
        }
        sb.append("; path=");
        sb.append(this.f9799);
        if (this.f9800) {
            sb.append("; secure");
        }
        if (this.f9801) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        C3921.m12663(string, "toString()");
        return string;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final String m9701() {
        return this.f9796;
    }

    public /* synthetic */ C2632(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, C4184 c4184) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }
}
