package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import io.jsonwebtoken.Header;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class h {
    public static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();
    private static final Map<String, String> c = new HashMap();
    private static int d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, a> f17738e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    /* compiled from: ProGuard */
    public static class a {
        public long a = 0;
        public int b = 0;
        public Map<String, String> c = new HashMap();
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17739e;
        private boolean f;

        public a(String str, boolean z, boolean z2) {
            this.f17739e = false;
            this.f = false;
            this.d = str;
            this.f17739e = z;
            this.f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        public final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        public final String b(String str) {
            String strA = a(str);
            return strA == null ? "" : strA;
        }

        public final boolean c(String str) throws NumberFormatException {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long jC = 0;
            HashMap map = new HashMap();
            Map mapC = h.c(str);
            int iC = 0;
            for (String str3 : mapC.keySet()) {
                String str4 = (String) mapC.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.f17739e && str3.equals("up")) {
                    jC = g.c(str4);
                } else if (this.f17739e && str3.equals("pid")) {
                    iC = (int) g.c(str4);
                } else {
                    map.put(str3, str4);
                }
            }
            String str5 = this.d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.a = jC;
            this.b = iC;
            this.d = str2;
            this.c = map;
            return true;
        }

        public final void a(String str, long j) {
            long jD = d(str) + j;
            if (jD <= 100) {
                j = jD < 0 ? 0L : jD;
            }
            a(str, String.valueOf(j));
        }

        public final boolean a(a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long jD = aVar.d(str);
                    if (jD == 0) {
                        a(str, aVar.a(str));
                    } else if (jD < 100) {
                        a(str, jD);
                    }
                }
            }
            return true;
        }

        public final String a(String str) {
            return this.c.get(str);
        }

        public final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, am.w, com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long jO = h.o();
                h.a(sb, "ram", jO);
                h.b(sb, "aram", h.a(jO));
                h.b(sb, "cver", "3.3.2.2");
                h.b(sb, "cseq", "211215141717");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.T());
                h.b(sb, "sver", com.uc.crashsdk.g.U());
                h.b(sb, "seq", com.uc.crashsdk.g.V());
                h.b(sb, "grd", com.uc.crashsdk.b.A() ? "fg" : "bg");
                h.b(sb, am.x, "android");
                h.b(sb, "dn", com.uc.crashsdk.e.q());
                String strAb = com.uc.crashsdk.g.ab();
                if (TextUtils.isEmpty(strAb)) {
                    strAb = com.uc.crashsdk.e.q();
                }
                h.b(sb, "k_uid", strAb);
                String strAc = com.uc.crashsdk.g.ac();
                if (!TextUtils.isEmpty(strAc)) {
                    h.b(sb, "k_channel", strAc);
                }
                sb.append("\n");
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.c);
            if (this.f17739e && !z2) {
                long j = this.a;
                if (j != 0) {
                    h.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i = this.b;
                    if (i != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i)));
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static /* synthetic */ String a(long j2) {
        if (j2 < 524288) {
            return "512M";
        }
        return String.format(Locale.US, "%dG", Long.valueOf(((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + 512) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    public static /* synthetic */ Map c(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] strArrSplit = str2.split("=", 3);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return map;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(303));
        }
    }

    public static byte[] j() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, 31};
    }

    public static void k() {
        synchronized (k) {
            l = null;
        }
    }

    private static String m() {
        return com.uc.crashsdk.g.W() + "pv.wa";
    }

    private static String n() {
        return com.uc.crashsdk.g.W() + "cdt.wa";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long o() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                    return 0L;
                }
            }
        }
    }

    public static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.Q()) {
            f.a(1, new e(301, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static boolean c(String str, String str2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean z;
        String string;
        byte[] bArrA;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        try {
            byte[] bArr = new byte[16];
            c.a(bArr, 0, c.a());
            c.a(bArr, 4, j());
            c.a(bArr, 8, com.uc.crashsdk.a.f());
            c.a(bArr, 12, d.d());
            bArrA2 = c.a(bytes, bArr);
        } catch (Throwable th) {
            g.a(th);
        }
        if (bArrA2 != null) {
            bytes = bArrA2;
            z = true;
        } else {
            z = false;
        }
        if (str == null) {
            str = "unknown";
        }
        String str3 = com.uc.crashsdk.g.R() ? "4ea4e41a3993" : "28ef1713347d";
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strD = g.d(str3 + str + strValueOf + "AppChk#2014");
        if (strD == null) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(com.uc.crashsdk.g.z());
            sb.append("?chk=");
            sb.append(strD.substring(strD.length() - 8, strD.length()));
            sb.append("&vno=");
            sb.append(strValueOf);
            sb.append("&uuid=");
            sb.append(str);
            sb.append("&app=");
            sb.append(str3);
            if (z) {
                sb.append("&enc=aes");
            }
            string = sb.toString();
        }
        return (string == null || (bArrA = c.a(string, bytes)) == null || !new String(bArrA).contains("retcode=0")) ? false : true;
    }

    private static boolean d(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean zC;
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String strA = next.a("prc");
            if (!g.a(strA)) {
                Map<String, a> map = f17738e;
                a aVar = map.get(strA);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(strA, next);
                }
            }
        }
        Map<String, a> map2 = f17738e;
        StringBuilder sbA = a((Iterable<a>) map2.values(), true, false);
        if (com.uc.crashsdk.g.aa()) {
            zC = b(com.uc.crashsdk.e.q(), sbA.toString());
        } else {
            zC = c(com.uc.crashsdk.e.q(), sbA.toString());
        }
        g.b(file);
        if (zC || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    public static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    public static void a(String str) {
        synchronized (b) {
            File file = new File(m());
            a aVar = new a("pv", true, true);
            String strC = g.c(file);
            if (!g.a(strC)) {
                aVar.c(strC);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    public static boolean b(int i2, Object[] objArr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        switch (i2) {
            case 351:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                if (iIntValue == 1) {
                    if (j) {
                        return false;
                    }
                    j = true;
                }
                if (!com.uc.crashsdk.g.Z()) {
                    return false;
                }
                File file = new File(str);
                ArrayList<a> arrayListA = a(file, "crp", 100);
                if (iIntValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (iIntValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.I()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.J()));
                    } else if (iIntValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (iIntValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a("imp", com.uc.crashsdk.b.F() ? "1" : "0");
                    a(aVar);
                    arrayListA.add(0, aVar);
                }
                if (!arrayListA.isEmpty()) {
                    boolean zC = c(com.uc.crashsdk.e.q(), a((Iterable<a>) arrayListA, true, false).toString());
                    g.b(file);
                    if (!zC) {
                        g.a(file, a((Iterable<a>) arrayListA, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean zC2 = c(com.uc.crashsdk.e.q(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (zC2) {
                    g.b(file2);
                }
                return zC2;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.H() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.F()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            String strReplaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            Map<String, String> map = c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i2 = d;
                    if (i2 >= 20) {
                        return false;
                    }
                    d = i2 + 1;
                }
                map.put(str3, strReplaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "dt.wa";
        com.uc.crashsdk.b.a(f, str, new e(352, new Object[]{str}));
        String strN = n();
        com.uc.crashsdk.b.a(g, strN, new e(354, new Object[]{strN}));
    }

    private static boolean b(String str, String str2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean z;
        byte[] bArrA;
        byte[] bArrA2;
        if (g.a(str2)) {
            return true;
        }
        byte[] bytes = str2.getBytes();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strD = g.d(com.uc.crashsdk.g.e() + str + jCurrentTimeMillis + "AppChk#2014");
        try {
            bArrA2 = c.a(bytes, strD.substring(strD.length() - 16, strD.length()).getBytes());
        } catch (Throwable th) {
            g.a(th);
        }
        if (bArrA2 != null) {
            bytes = bArrA2;
            z = true;
        } else {
            z = false;
        }
        String strSubstring = strD.substring(strD.length() - 8, strD.length());
        StringBuilder sb = new StringBuilder();
        sb.append(com.uc.crashsdk.g.z());
        sb.append("/api/v1/crashtrack/upload?chk=");
        sb.append(strSubstring);
        sb.append("&vno=");
        sb.append(jCurrentTimeMillis);
        sb.append("&uuid=");
        sb.append(str);
        sb.append("&app=");
        sb.append(com.uc.crashsdk.g.e());
        if (z) {
            sb.append("&enc=aes");
        }
        String string = sb.toString();
        return (string == null || (bArrA = c.a(string, bytes)) == null || !new String(bArrA).contains("retcode=0")) ? false : true;
    }

    private static void a(a aVar) {
        Map<String, String> map = c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, c.get(str));
            }
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (!com.uc.crashsdk.b.d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(n());
        ArrayList<a> arrayListA = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = arrayListA.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b(Header.TYPE))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a(Header.TYPE, str2);
            a(aVar);
            arrayListA.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) arrayListA, false, false).toString());
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.W() + "cr.wa";
        com.uc.crashsdk.b.a(b, str, new e(351, new Object[]{str, Integer.valueOf(i2)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0040 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a5 A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:17:0x001d, B:19:0x0028, B:21:0x002c, B:53:0x00c9, B:22:0x002e, B:24:0x0038, B:26:0x0040, B:28:0x005a, B:30:0x005f, B:37:0x0070, B:38:0x0077, B:44:0x008b, B:46:0x0097, B:51:0x00af, B:52:0x00c2, B:49:0x00a5, B:43:0x0083), top: B:68:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    public static void b(String str) {
        synchronized (k) {
            l = str;
            b.a(com.uc.crashsdk.b.k(), str + "\n");
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.g.Q()) {
            synchronized (f) {
                Map<String, a> map = f17738e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, "pv");
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.Q()) {
            return false;
        }
        return com.uc.crashsdk.b.a(g, n(), new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> arrayListA = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = arrayListA.iterator();
        while (it.hasNext()) {
            String next = it.next();
            a aVar = new a(str, false, false);
            if (aVar.c(next)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
