package defpackage;

import com.google.android.gms.common.internal.ImagesContract;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.containers.mps.MPSUtils;

/* compiled from: HttpUrl.kt */
/* renamed from: ڭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3573 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f12454;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f12455;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f12456;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f12457;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f12458;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f12459;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final List<String> f12460;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final List<String> f12461;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String f12462;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final String f12463;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final C3576 f12453 = new C3576(null);

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final char[] f12452 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    /* renamed from: ڭ$Ϳ, reason: contains not printable characters */
    public static final class C3574 {

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final C3575 f12464 = new C3575(null);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f12465;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f12468;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final List<String> f12470;

        /* renamed from: ԭ, reason: contains not printable characters */
        public List<String> f12471;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public String f12472;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f12466 = "";

        /* renamed from: ԩ, reason: contains not printable characters */
        public String f12467 = "";

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f12469 = -1;

        /* compiled from: HttpUrl.kt */
        /* renamed from: ڭ$Ϳ$Ϳ, reason: contains not printable characters */
        public static final class C3575 {
            public C3575() {
            }

            public /* synthetic */ C3575(C4184 c4184) {
                this();
            }

            /* renamed from: ԫ, reason: contains not printable characters */
            public final int m11574(String str, int i, int i2) throws NumberFormatException {
                try {
                    int i3 = Integer.parseInt(C3576.m11578(C3573.f12453, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 <= i3 && 65535 >= i3) {
                        return i3;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final int m11575(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == ':') {
                        return i;
                    }
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                }
                return i2;
            }

            /* renamed from: ԭ, reason: contains not printable characters */
            public final int m11576(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i);
                if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i);
                    if ('a' > cCharAt2 || 'z' < cCharAt2) {
                        if ('A' > cCharAt2 || 'Z' < cCharAt2) {
                            if ('0' > cCharAt2 || '9' < cCharAt2) {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* renamed from: Ԯ, reason: contains not printable characters */
            public final int m11577(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }
        }

        public C3574() {
            ArrayList arrayList = new ArrayList();
            this.f12470 = arrayList;
            arrayList.add("");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0097  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.f12465
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.f12466
                int r1 = r1.length()
                r2 = 1
                r3 = 0
                if (r1 <= 0) goto L23
                r1 = r2
                goto L24
            L23:
                r1 = r3
            L24:
                r4 = 58
                if (r1 != 0) goto L35
                java.lang.String r1 = r6.f12467
                int r1 = r1.length()
                if (r1 <= 0) goto L32
                r1 = r2
                goto L33
            L32:
                r1 = r3
            L33:
                if (r1 == 0) goto L53
            L35:
                java.lang.String r1 = r6.f12466
                r0.append(r1)
                java.lang.String r1 = r6.f12467
                int r1 = r1.length()
                if (r1 <= 0) goto L43
                goto L44
            L43:
                r2 = r3
            L44:
                if (r2 == 0) goto L4e
                r0.append(r4)
                java.lang.String r1 = r6.f12467
                r0.append(r1)
            L4e:
                r1 = 64
                r0.append(r1)
            L53:
                java.lang.String r1 = r6.f12468
                if (r1 == 0) goto L79
                if (r1 != 0) goto L5c
                defpackage.C3921.m12675()
            L5c:
                r2 = 2
                r5 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.m7274(r1, r4, r3, r2, r5)
                if (r1 == 0) goto L74
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.f12468
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L79
            L74:
                java.lang.String r1 = r6.f12468
                r0.append(r1)
            L79:
                int r1 = r6.f12469
                r2 = -1
                if (r1 != r2) goto L82
                java.lang.String r1 = r6.f12465
                if (r1 == 0) goto L9d
            L82:
                int r1 = r6.m11549()
                java.lang.String r2 = r6.f12465
                if (r2 == 0) goto L97
                ڭ$Ԩ r3 = defpackage.C3573.f12453
                if (r2 != 0) goto L91
                defpackage.C3921.m12675()
            L91:
                int r2 = r3.m11581(r2)
                if (r1 == r2) goto L9d
            L97:
                r0.append(r4)
                r0.append(r1)
            L9d:
                ڭ$Ԩ r1 = defpackage.C3573.f12453
                java.util.List<java.lang.String> r2 = r6.f12470
                r1.m11586(r2, r0)
                java.util.List<java.lang.String> r2 = r6.f12471
                if (r2 == 0) goto Lb7
                r2 = 63
                r0.append(r2)
                java.util.List<java.lang.String> r2 = r6.f12471
                if (r2 != 0) goto Lb4
                defpackage.C3921.m12675()
            Lb4:
                r1.m11588(r2, r0)
            Lb7:
                java.lang.String r1 = r6.f12472
                if (r1 == 0) goto Lc5
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.f12472
                r0.append(r1)
            Lc5:
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
                defpackage.C3921.m12663(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3573.C3574.toString():java.lang.String");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3574 m11546(String str, String str2) {
            C3921.m12667(str, "encodedName");
            if (this.f12471 == null) {
                this.f12471 = new ArrayList();
            }
            List<String> list = this.f12471;
            if (list == null) {
                C3921.m12675();
            }
            C3576 c3576 = C3573.f12453;
            list.add(C3576.m11578(c3576, str, 0, 0, " \"'<>#&=", true, false, true, false, null, JpegConst.RST3, null));
            List<String> list2 = this.f12471;
            if (list2 == null) {
                C3921.m12675();
            }
            list2.add(str2 != null ? C3576.m11578(c3576, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, JpegConst.RST3, null) : null);
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3574 m11547(String str, String str2) {
            C3921.m12667(str, "name");
            if (this.f12471 == null) {
                this.f12471 = new ArrayList();
            }
            List<String> list = this.f12471;
            if (list == null) {
                C3921.m12675();
            }
            C3576 c3576 = C3573.f12453;
            list.add(C3576.m11578(c3576, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, JpegConst.DQT, null));
            List<String> list2 = this.f12471;
            if (list2 == null) {
                C3921.m12675();
            }
            list2.add(str2 != null ? C3576.m11578(c3576, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, JpegConst.DQT, null) : null);
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C3573 m11548() {
            ArrayList arrayList;
            String str = this.f12465;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            C3576 c3576 = C3573.f12453;
            String strM11579 = C3576.m11579(c3576, this.f12466, 0, 0, false, 7, null);
            String strM115792 = C3576.m11579(c3576, this.f12467, 0, 0, false, 7, null);
            String str2 = this.f12468;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iM11549 = m11549();
            List<String> list = this.f12470;
            ArrayList arrayList2 = new ArrayList(C4362.m13522(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(C3576.m11579(C3573.f12453, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.f12471;
            if (list2 != null) {
                arrayList = new ArrayList(C4362.m13522(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? C3576.m11579(C3573.f12453, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.f12472;
            return new C3573(str, strM11579, strM115792, str2, iM11549, arrayList2, arrayList, str4 != null ? C3576.m11579(C3573.f12453, str4, 0, 0, false, 7, null) : null, toString());
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final int m11549() {
            int i = this.f12469;
            if (i != -1) {
                return i;
            }
            C3576 c3576 = C3573.f12453;
            String str = this.f12465;
            if (str == null) {
                C3921.m12675();
            }
            return c3576.m11581(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
        /* renamed from: ԫ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final defpackage.C3573.C3574 m11550(java.lang.String r14) {
            /*
                r13 = this;
                if (r14 == 0) goto L1d
                ڭ$Ԩ r12 = defpackage.C3573.f12453
                r2 = 0
                r3 = 0
                r5 = 1
                r6 = 0
                r7 = 1
                r8 = 0
                r9 = 0
                r10 = 211(0xd3, float:2.96E-43)
                r11 = 0
                java.lang.String r4 = " \"'<>#"
                r0 = r12
                r1 = r14
                java.lang.String r14 = defpackage.C3573.C3576.m11578(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L1d
                java.util.List r14 = r12.m11587(r14)
                goto L1e
            L1d:
                r14 = 0
            L1e:
                r13.f12471 = r14
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3573.C3574.m11550(java.lang.String):ڭ$Ϳ");
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final List<String> m11551() {
            return this.f12470;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C3574 m11552(String str) {
            C3921.m12667(str, "host");
            String strM13710 = C4446.m13710(C3576.m11579(C3573.f12453, str, 0, 0, false, 7, null));
            if (strM13710 != null) {
                this.f12468 = strM13710;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean m11553(String str) {
            return C3921.m12662(str, ".") || e0.m5967(str, "%2e", true);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m11554(String str) {
            return C3921.m12662(str, "..") || e0.m5967(str, "%2e.", true) || e0.m5967(str, ".%2e", true) || e0.m5967(str, "%2e%2e", true);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C3574 m11555(C3573 c3573, String str) throws NumberFormatException {
            int iM6244;
            int i;
            int i2;
            String str2;
            boolean z;
            int i3;
            String str3;
            int i4;
            boolean z2;
            boolean z3;
            C3921.m12667(str, "input");
            int iM6254 = i5.m6254(str, 0, 0, 3, null);
            int iM6256 = i5.m6256(str, iM6254, 0, 2, null);
            C3575 c3575 = f12464;
            int iM11576 = c3575.m11576(str, iM6254, iM6256);
            String str4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            char c = 65535;
            boolean z4 = true;
            if (iM11576 != -1) {
                if (e0.m5977(str, "https:", iM6254, true)) {
                    this.f12465 = "https";
                    iM6254 += 6;
                } else {
                    if (!e0.m5977(str, "http:", iM6254, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str.substring(0, iM11576);
                        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f12465 = "http";
                    iM6254 += 5;
                }
            } else {
                if (c3573 == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f12465 = c3573.m11543();
            }
            int iM11577 = c3575.m11577(str, iM6254, iM6256);
            char c2 = '?';
            char c3 = '#';
            if (iM11577 >= 2 || c3573 == null || (!C3921.m12662(c3573.m11543(), this.f12465))) {
                int i5 = iM6254 + iM11577;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    iM6244 = i5.m6244(str, "@/\\?#", i5, iM6256);
                    char cCharAt = iM6244 != iM6256 ? str.charAt(iM6244) : c;
                    if (cCharAt == c || cCharAt == c3 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c2) {
                        break;
                    }
                    if (cCharAt != '@') {
                        z = z4;
                        str3 = str4;
                        i3 = iM6256;
                    } else {
                        if (z5) {
                            z = z4;
                            i3 = iM6256;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f12467);
                            sb2.append("%40");
                            str3 = str4;
                            i4 = iM6244;
                            sb2.append(C3576.m11578(C3573.f12453, str, i5, iM6244, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.f12467 = sb2.toString();
                            z2 = z6;
                        } else {
                            int iM6243 = i5.m6243(str, ':', i5, iM6244);
                            C3576 c3576 = C3573.f12453;
                            z = z4;
                            i3 = iM6256;
                            String str5 = str4;
                            String strM11578 = C3576.m11578(c3576, str, i5, iM6243, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z6) {
                                strM11578 = this.f12466 + "%40" + strM11578;
                            }
                            this.f12466 = strM11578;
                            if (iM6243 != iM6244) {
                                this.f12467 = C3576.m11578(c3576, str, iM6243 + 1, iM6244, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z3 = z;
                            } else {
                                z3 = z5;
                            }
                            z5 = z3;
                            str3 = str5;
                            z2 = z;
                            i4 = iM6244;
                        }
                        i5 = i4 + 1;
                        z6 = z2;
                    }
                    str4 = str3;
                    z4 = z;
                    iM6256 = i3;
                    c3 = '#';
                    c2 = '?';
                    c = 65535;
                }
                boolean z7 = z4;
                String str6 = str4;
                i = iM6256;
                C3575 c35752 = f12464;
                int iM11575 = c35752.m11575(str, i5, iM6244);
                int i6 = iM11575 + 1;
                if (i6 < iM6244) {
                    i2 = i5;
                    this.f12468 = C4446.m13710(C3576.m11579(C3573.f12453, str, i5, iM11575, false, 4, null));
                    int iM11574 = c35752.m11574(str, i6, iM6244);
                    this.f12469 = iM11574;
                    if (!(iM11574 != -1 ? z7 : false)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String strSubstring2 = str.substring(i6, iM6244);
                        C3921.m12663(strSubstring2, str6);
                        sb3.append(strSubstring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                    str2 = str6;
                } else {
                    i2 = i5;
                    str2 = str6;
                    C3576 c35762 = C3573.f12453;
                    this.f12468 = C4446.m13710(C3576.m11579(c35762, str, i2, iM11575, false, 4, null));
                    String str7 = this.f12465;
                    if (str7 == null) {
                        C3921.m12675();
                    }
                    this.f12469 = c35762.m11581(str7);
                }
                if (!(this.f12468 != null ? z7 : false)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String strSubstring3 = str.substring(i2, iM11575);
                    C3921.m12663(strSubstring3, str2);
                    sb4.append(strSubstring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                iM6254 = iM6244;
            } else {
                this.f12466 = c3573.m11531();
                this.f12467 = c3573.m11527();
                this.f12468 = c3573.m11532();
                this.f12469 = c3573.m11537();
                this.f12470.clear();
                this.f12470.addAll(c3573.m11529());
                if (iM6254 == iM6256 || str.charAt(iM6254) == '#') {
                    m11550(c3573.m11530());
                }
                i = iM6256;
            }
            int i7 = i;
            int iM62442 = i5.m6244(str, "?#", iM6254, i7);
            m11561(str, iM6254, iM62442);
            if (iM62442 < i7 && str.charAt(iM62442) == '?') {
                int iM62432 = i5.m6243(str, '#', iM62442, i7);
                C3576 c35763 = C3573.f12453;
                this.f12471 = c35763.m11587(C3576.m11578(c35763, str, iM62442 + 1, iM62432, " \"'<>#", true, false, true, false, null, JpegConst.RST0, null));
                iM62442 = iM62432;
            }
            if (iM62442 < i7 && str.charAt(iM62442) == '#') {
                this.f12472 = C3576.m11578(C3573.f12453, str, iM62442 + 1, i7, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final C3574 m11556(String str) {
            C3921.m12667(str, "password");
            this.f12467 = C3576.m11578(C3573.f12453, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final void m11557() {
            List<String> list = this.f12470;
            if (!(list.remove(list.size() - 1).length() == 0) || !(!this.f12470.isEmpty())) {
                this.f12470.add("");
            } else {
                List<String> list2 = this.f12470;
                list2.set(list2.size() - 1, "");
            }
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final C3574 m11558(int i) {
            if (1 <= i && 65535 >= i) {
                this.f12469 = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final void m11559(String str, int i, int i2, boolean z, boolean z2) {
            String strM11578 = C3576.m11578(C3573.f12453, str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, false, null, 240, null);
            if (m11553(strM11578)) {
                return;
            }
            if (m11554(strM11578)) {
                m11557();
                return;
            }
            List<String> list = this.f12470;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.f12470;
                list2.set(list2.size() - 1, strM11578);
            } else {
                this.f12470.add(strM11578);
            }
            if (z) {
                this.f12470.add("");
            }
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public final C3574 m11560() {
            String str = this.f12468;
            this.f12468 = str != null ? new Regex("[\"<>^`{|}]").m7264(str, "") : null;
            int size = this.f12470.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.f12470;
                list.set(i, C3576.m11578(C3573.f12453, list.get(i), 0, 0, "[]", true, true, false, false, null, JpegConst.APP3, null));
            }
            List<String> list2 = this.f12471;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? C3576.m11578(C3573.f12453, str2, 0, 0, "\\^`{|}", true, true, true, false, null, JpegConst.SOF3, null) : null);
                }
            }
            String str3 = this.f12472;
            this.f12472 = str3 != null ? C3576.m11578(C3573.f12453, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public final void m11561(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f12470.clear();
                this.f12470.add("");
                i++;
            } else {
                List<String> list = this.f12470;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = i5.m6244(str, "/\\", i3, i2);
                boolean z = i < i2;
                m11559(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public final C3574 m11562(String str) {
            C3921.m12667(str, "scheme");
            if (e0.m5967(str, "http", true)) {
                this.f12465 = "http";
            } else {
                if (!e0.m5967(str, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f12465 = "https";
            }
            return this;
        }

        /* renamed from: ރ, reason: contains not printable characters */
        public final void m11563(String str) {
            this.f12472 = str;
        }

        /* renamed from: ބ, reason: contains not printable characters */
        public final void m11564(String str) {
            C3921.m12667(str, "<set-?>");
            this.f12467 = str;
        }

        /* renamed from: ޅ, reason: contains not printable characters */
        public final void m11565(String str) {
            C3921.m12667(str, "<set-?>");
            this.f12466 = str;
        }

        /* renamed from: ކ, reason: contains not printable characters */
        public final void m11566(String str) {
            this.f12468 = str;
        }

        /* renamed from: އ, reason: contains not printable characters */
        public final void m11567(int i) {
            this.f12469 = i;
        }

        /* renamed from: ވ, reason: contains not printable characters */
        public final void m11568(String str) {
            this.f12465 = str;
        }

        /* renamed from: މ, reason: contains not printable characters */
        public final C3574 m11569(String str) {
            C3921.m12667(str, "username");
            this.f12466 = C3576.m11578(C3573.f12453, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    /* compiled from: HttpUrl.kt */
    /* renamed from: ڭ$Ԩ, reason: contains not printable characters */
    public static final class C3576 {
        public C3576() {
        }

        public /* synthetic */ C3576(C4184 c4184) {
            this();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static /* synthetic */ String m11578(C3576 c3576, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return c3576.m11580(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static /* synthetic */ String m11579(C3576 c3576, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return c3576.m11585(str, i, i2, z);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String m11580(java.lang.String r14, int r15, int r16, java.lang.String r17, boolean r18, boolean r19, boolean r20, boolean r21, java.nio.charset.Charset r22) {
            /*
                r13 = this;
                r2 = r14
                r4 = r16
                r5 = r17
                java.lang.String r0 = "$this$canonicalize"
                defpackage.C3921.m12667(r14, r0)
                java.lang.String r0 = "encodeSet"
                defpackage.C3921.m12667(r5, r0)
                r3 = r15
            L10:
                if (r3 >= r4) goto L6f
                int r0 = r14.codePointAt(r3)
                r1 = 32
                if (r0 < r1) goto L4c
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 == r1) goto L4c
                r1 = 128(0x80, float:1.8E-43)
                if (r0 < r1) goto L24
                if (r21 == 0) goto L4c
            L24:
                char r1 = (char) r0
                r6 = 0
                r7 = 2
                r8 = 0
                boolean r1 = kotlin.text.StringsKt__StringsKt.m7274(r5, r1, r6, r7, r8)
                if (r1 != 0) goto L4c
                r1 = 37
                if (r0 != r1) goto L3e
                if (r18 == 0) goto L4c
                if (r19 == 0) goto L3e
                r11 = r13
                boolean r1 = r13.m11583(r14, r3, r4)
                if (r1 == 0) goto L4d
                goto L3f
            L3e:
                r11 = r13
            L3f:
                r1 = 43
                if (r0 != r1) goto L46
                if (r20 == 0) goto L46
                goto L4d
            L46:
                int r0 = java.lang.Character.charCount(r0)
                int r3 = r3 + r0
                goto L10
            L4c:
                r11 = r13
            L4d:
                okio.Buffer r12 = new okio.Buffer
                r12.<init>()
                r0 = r15
                r12.writeUtf8(r14, r15, r3)
                r0 = r13
                r1 = r12
                r2 = r14
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r10 = r22
                r0.m11589(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                java.lang.String r0 = r12.readUtf8()
                return r0
            L6f:
                r11 = r13
                r0 = r15
                java.lang.String r0 = r14.substring(r15, r16)
                java.lang.String r1 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
                defpackage.C3921.m12663(r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3573.C3576.m11580(java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):java.lang.String");
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int m11581(String str) {
            C3921.m12667(str, "scheme");
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && str.equals("https")) {
                    return MPSUtils.SYSTEM;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C3573 m11582(String str) {
            C3921.m12667(str, "$this$toHttpUrl");
            return new C3574().m11555(null, str).m11548();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final boolean m11583(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && i5.m6261(str.charAt(i + 1)) != -1 && i5.m6261(str.charAt(i3)) != -1;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C3573 m11584(String str) {
            C3921.m12667(str, "$this$toHttpUrlOrNull");
            try {
                return m11582(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final String m11585(String str, int i, int i2, boolean z) {
            C3921.m12667(str, "$this$percentDecode");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, i3);
                    m11590(buffer, str, i3, i2, z);
                    return buffer.readUtf8();
                }
            }
            String strSubstring = str.substring(i, i2);
            C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final void m11586(List<String> list, StringBuilder sb) {
            C3921.m12667(list, "$this$toPathString");
            C3921.m12667(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append(list.get(i));
            }
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final List<String> m11587(String str) {
            C3921.m12667(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iM7285 = StringsKt__StringsKt.m7285(str, '&', i, false, 4, null);
                if (iM7285 == -1) {
                    iM7285 = str.length();
                }
                int i2 = iM7285;
                int iM72852 = StringsKt__StringsKt.m7285(str, '=', i, false, 4, null);
                if (iM72852 == -1 || iM72852 > i2) {
                    String strSubstring = str.substring(i, i2);
                    C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iM72852);
                    C3921.m12663(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iM72852 + 1, i2);
                    C3921.m12663(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final void m11588(List<String> list, StringBuilder sb) {
            C3921.m12667(list, "$this$toQueryString");
            C3921.m12667(sb, "out");
            C3181 c3181M13949 = C4542.m13949(C4542.m13950(0, list.size()), 2);
            int iM10810 = c3181M13949.m10810();
            int iM10811 = c3181M13949.m10811();
            int iM10812 = c3181M13949.m10812();
            if (iM10812 >= 0) {
                if (iM10810 > iM10811) {
                    return;
                }
            } else if (iM10810 < iM10811) {
                return;
            }
            while (true) {
                String str = list.get(iM10810);
                String str2 = list.get(iM10810 + 1);
                if (iM10810 > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iM10810 == iM10811) {
                    return;
                } else {
                    iM10810 += iM10812;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0093 A[LOOP:1: B:51:0x008d->B:53:0x0093, LOOP_END] */
        /* renamed from: ֏, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m11589(okio.Buffer r15, java.lang.String r16, int r17, int r18, java.lang.String r19, boolean r20, boolean r21, boolean r22, boolean r23, java.nio.charset.Charset r24) {
            /*
                r14 = this;
                r0 = r15
                r1 = r16
                r2 = r18
                r3 = r24
                r4 = 0
                r5 = r17
                r6 = r4
            Lb:
                if (r5 >= r2) goto Lc5
                if (r1 == 0) goto Lbc
                int r7 = r1.codePointAt(r5)
                if (r20 == 0) goto L2b
                r8 = 9
                if (r7 == r8) goto L26
                r8 = 10
                if (r7 == r8) goto L26
                r8 = 12
                if (r7 == r8) goto L26
                r8 = 13
                if (r7 == r8) goto L26
                goto L2b
            L26:
                r8 = r14
                r12 = r19
                goto Lb5
            L2b:
                r8 = 43
                if (r7 != r8) goto L3c
                if (r22 == 0) goto L3c
                if (r20 == 0) goto L36
                java.lang.String r8 = "+"
                goto L38
            L36:
                java.lang.String r8 = "%2B"
            L38:
                r15.writeUtf8(r8)
                goto L26
            L3c:
                r8 = 32
                r9 = 37
                if (r7 < r8) goto L6c
                r8 = 127(0x7f, float:1.78E-43)
                if (r7 == r8) goto L6c
                r8 = 128(0x80, float:1.8E-43)
                if (r7 < r8) goto L4c
                if (r23 == 0) goto L6c
            L4c:
                char r8 = (char) r7
                r10 = 0
                r11 = 2
                r12 = r19
                boolean r8 = kotlin.text.StringsKt__StringsKt.m7274(r12, r8, r10, r11, r4)
                if (r8 != 0) goto L6a
                if (r7 != r9) goto L65
                if (r20 == 0) goto L6a
                if (r21 == 0) goto L65
                r8 = r14
                boolean r10 = r14.m11583(r1, r5, r2)
                if (r10 != 0) goto L66
                goto L6f
            L65:
                r8 = r14
            L66:
                r15.writeUtf8CodePoint(r7)
                goto Lb5
            L6a:
                r8 = r14
                goto L6f
            L6c:
                r8 = r14
                r12 = r19
            L6f:
                if (r6 != 0) goto L76
                okio.Buffer r6 = new okio.Buffer
                r6.<init>()
            L76:
                if (r3 == 0) goto L8a
                java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
                boolean r10 = defpackage.C3921.m12662(r3, r10)
                if (r10 == 0) goto L81
                goto L8a
            L81:
                int r10 = java.lang.Character.charCount(r7)
                int r10 = r10 + r5
                r6.writeString(r1, r5, r10, r3)
                goto L8d
            L8a:
                r6.writeUtf8CodePoint(r7)
            L8d:
                boolean r10 = r6.exhausted()
                if (r10 != 0) goto Lb5
                byte r10 = r6.readByte()
                r10 = r10 & 255(0xff, float:3.57E-43)
                r15.writeByte(r9)
                char[] r11 = defpackage.C3573.m11524()
                int r13 = r10 >> 4
                r13 = r13 & 15
                char r11 = r11[r13]
                r15.writeByte(r11)
                char[] r11 = defpackage.C3573.m11524()
                r10 = r10 & 15
                char r10 = r11[r10]
                r15.writeByte(r10)
                goto L8d
            Lb5:
                int r7 = java.lang.Character.charCount(r7)
                int r5 = r5 + r7
                goto Lb
            Lbc:
                r8 = r14
                kotlin.TypeCastException r0 = new kotlin.TypeCastException
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)
                throw r0
            Lc5:
                r8 = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3573.C3576.m11589(okio.Buffer, java.lang.String, int, int, java.lang.String, boolean, boolean, boolean, boolean, java.nio.charset.Charset):void");
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final void m11590(Buffer buffer, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int iM6261 = i5.m6261(str.charAt(i + 1));
                    int iM62612 = i5.m6261(str.charAt(i3));
                    if (iM6261 == -1 || iM62612 == -1) {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        buffer.writeByte((iM6261 << 4) + iM62612);
                        i = Character.charCount(iCodePointAt) + i3;
                    }
                } else if (iCodePointAt == 43 && z) {
                    buffer.writeByte(32);
                    i++;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }
    }

    public C3573(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        C3921.m12667(str, "scheme");
        C3921.m12667(str2, "username");
        C3921.m12667(str3, "password");
        C3921.m12667(str4, "host");
        C3921.m12667(list, "pathSegments");
        C3921.m12667(str6, ImagesContract.URL);
        this.f12455 = str;
        this.f12456 = str2;
        this.f12457 = str3;
        this.f12458 = str4;
        this.f12459 = i;
        this.f12460 = list;
        this.f12461 = list2;
        this.f12462 = str5;
        this.f12463 = str6;
        this.f12454 = C3921.m12662(str, "https");
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final C3573 m11525(String str) {
        return f12453.m11584(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3573) && C3921.m12662(((C3573) obj).f12463, this.f12463);
    }

    public int hashCode() {
        return this.f12463.hashCode();
    }

    public String toString() {
        return this.f12463;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m11526() {
        if (this.f12462 == null) {
            return null;
        }
        int iM7285 = StringsKt__StringsKt.m7285(this.f12463, '#', 0, false, 6, null) + 1;
        String str = this.f12463;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iM7285);
        C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m11527() {
        if (this.f12457.length() == 0) {
            return "";
        }
        int iM7285 = StringsKt__StringsKt.m7285(this.f12463, ':', this.f12455.length() + 3, false, 4, null) + 1;
        int iM72852 = StringsKt__StringsKt.m7285(this.f12463, '@', 0, false, 6, null);
        String str = this.f12463;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iM7285, iM72852);
        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String m11528() {
        int iM7285 = StringsKt__StringsKt.m7285(this.f12463, '/', this.f12455.length() + 3, false, 4, null);
        String str = this.f12463;
        int iM6244 = i5.m6244(str, "?#", iM7285, str.length());
        String str2 = this.f12463;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iM7285, iM6244);
        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<String> m11529() {
        int iM7285 = StringsKt__StringsKt.m7285(this.f12463, '/', this.f12455.length() + 3, false, 4, null);
        String str = this.f12463;
        int iM6244 = i5.m6244(str, "?#", iM7285, str.length());
        ArrayList arrayList = new ArrayList();
        while (iM7285 < iM6244) {
            int i = iM7285 + 1;
            int iM6243 = i5.m6243(this.f12463, '/', i, iM6244);
            String str2 = this.f12463;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iM6243);
            C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iM7285 = iM6243;
        }
        return arrayList;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m11530() {
        if (this.f12461 == null) {
            return null;
        }
        int iM7285 = StringsKt__StringsKt.m7285(this.f12463, '?', 0, false, 6, null) + 1;
        String str = this.f12463;
        int iM6243 = i5.m6243(str, '#', iM7285, str.length());
        String str2 = this.f12463;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iM7285, iM6243);
        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String m11531() {
        if (this.f12456.length() == 0) {
            return "";
        }
        int length = this.f12455.length() + 3;
        String str = this.f12463;
        int iM6244 = i5.m6244(str, ":@", length, str.length());
        String str2 = this.f12463;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iM6244);
        C3921.m12663(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m11532() {
        return this.f12458;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m11533() {
        return this.f12454;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C3574 m11534() {
        C3574 c3574 = new C3574();
        c3574.m11568(this.f12455);
        c3574.m11565(m11531());
        c3574.m11564(m11527());
        c3574.m11566(this.f12458);
        c3574.m11567(this.f12459 != f12453.m11581(this.f12455) ? this.f12459 : -1);
        c3574.m11551().clear();
        c3574.m11551().addAll(m11529());
        c3574.m11550(m11530());
        c3574.m11563(m11526());
        return c3574;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C3574 m11535(String str) {
        C3921.m12667(str, "link");
        try {
            return new C3574().m11555(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final List<String> m11536() {
        return this.f12460;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int m11537() {
        return this.f12459;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final String m11538() {
        if (this.f12461 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        f12453.m11588(this.f12461, sb);
        return sb.toString();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final Set<String> m11539() {
        if (this.f12461 == null) {
            return C5094.m14922();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C3181 c3181M13949 = C4542.m13949(C4542.m13950(0, this.f12461.size()), 2);
        int iM10810 = c3181M13949.m10810();
        int iM10811 = c3181M13949.m10811();
        int iM10812 = c3181M13949.m10812();
        if (iM10812 < 0 ? iM10810 >= iM10811 : iM10810 <= iM10811) {
            while (true) {
                String str = this.f12461.get(iM10810);
                if (str == null) {
                    C3921.m12675();
                }
                linkedHashSet.add(str);
                if (iM10810 == iM10811) {
                    break;
                }
                iM10810 += iM10812;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        C3921.m12663(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final List<String> m11540(String str) {
        C3921.m12667(str, "name");
        if (this.f12461 == null) {
            return C3131.m10712();
        }
        ArrayList arrayList = new ArrayList();
        C3181 c3181M13949 = C4542.m13949(C4542.m13950(0, this.f12461.size()), 2);
        int iM10810 = c3181M13949.m10810();
        int iM10811 = c3181M13949.m10811();
        int iM10812 = c3181M13949.m10812();
        if (iM10812 < 0 ? iM10810 >= iM10811 : iM10810 <= iM10811) {
            while (true) {
                if (C3921.m12662(str, this.f12461.get(iM10810))) {
                    arrayList.add(this.f12461.get(iM10810 + 1));
                }
                if (iM10810 == iM10811) {
                    break;
                }
                iM10810 += iM10812;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        C3921.m12663(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final String m11541() {
        C3574 c3574M11535 = m11535("/...");
        if (c3574M11535 == null) {
            C3921.m12675();
        }
        return c3574M11535.m11569("").m11556("").m11548().toString();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final C3573 m11542(String str) {
        C3921.m12667(str, "link");
        C3574 c3574M11535 = m11535(str);
        if (c3574M11535 != null) {
            return c3574M11535.m11548();
        }
        return null;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final String m11543() {
        return this.f12455;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final URI m11544() {
        String string = m11534().m11560().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").m7264(string, ""));
                C3921.m12663(uriCreate, "URI.create(stripped)");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final URL m11545() {
        try {
            return new URL(this.f12463);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }
}
