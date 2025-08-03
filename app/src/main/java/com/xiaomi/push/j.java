package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class j {
    private static volatile int a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, n> f6313a = null;
    private static int b = -1;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5689a() {
        return a() == 1;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5694b() {
        return a() == 2;
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m5695c() {
        if (b < 0) {
            b = !m5698f() ? 1 : 0;
        }
        return b > 0;
    }

    /* renamed from: d, reason: collision with other method in class */
    public static boolean m5696d() {
        return !n.China.name().equalsIgnoreCase(a(m5692b()).name());
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m5697e() {
        return a(1);
    }

    public static String f() {
        return m5687a("ro.miui.ui.version.name");
    }

    public static String g() {
        return m5687a("ro.build.characteristics");
    }

    public static String h() {
        return m5687a("ro.product.manufacturer");
    }

    public static int a() {
        if (a == 0) {
            try {
                int i = 1;
                if (!((TextUtils.isEmpty(m5687a("ro.miui.ui.version.code")) && TextUtils.isEmpty(m5687a("ro.miui.ui.version.name")) && TextUtils.isEmpty(m5687a("ro.mi.os.version.code")) && TextUtils.isEmpty(m5687a("ro.mi.os.version.name"))) ? false : true)) {
                    i = 2;
                }
                a = i;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                a = 0;
            }
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
        }
        return a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m5692b() {
        String strA = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m5693b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m5113a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m5687a("ro.mi.os.version.incremental");
    }

    public static String e() {
        return m5697e() ? d() : Build.VERSION.INCREMENTAL;
    }

    /* renamed from: f, reason: collision with other method in class */
    public static boolean m5698f() {
        String strA;
        String strA2 = "";
        try {
            strA = q.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            try {
                strA2 = q.a("ro.mi.os.version.code", "");
            } catch (Exception unused2) {
            }
        } else {
            strA2 = strA;
        }
        return !TextUtils.isEmpty(strA2);
    }

    public static String c() {
        return m5687a("ro.mi.os.version.name");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5686a() {
        int iA = s.a();
        return (!m5689a() || iA <= 0) ? "" : iA < 2 ? "alpha" : iA < 3 ? "development" : "stable";
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5687a(String str) {
        try {
            try {
                return (String) ax.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e2);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5690a(Context context) {
        return context != null && m5691a(context.getPackageName());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5691a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static n a(String str) {
        n nVarB = b(str);
        return nVarB == null ? n.Global : nVarB;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m5688a() {
        if (f6313a != null) {
            return;
        }
        HashMap map = new HashMap();
        f6313a = map;
        map.put("CN", n.China);
        Map<String, n> map2 = f6313a;
        n nVar = n.Europe;
        map2.put("FI", nVar);
        f6313a.put("SE", nVar);
        f6313a.put("NO", nVar);
        f6313a.put("FO", nVar);
        f6313a.put("EE", nVar);
        f6313a.put("LV", nVar);
        f6313a.put("LT", nVar);
        f6313a.put("BY", nVar);
        f6313a.put("MD", nVar);
        f6313a.put("UA", nVar);
        f6313a.put("PL", nVar);
        f6313a.put("CZ", nVar);
        f6313a.put("SK", nVar);
        f6313a.put("HU", nVar);
        f6313a.put("DE", nVar);
        f6313a.put("AT", nVar);
        f6313a.put("CH", nVar);
        f6313a.put("LI", nVar);
        f6313a.put("GB", nVar);
        f6313a.put("IE", nVar);
        f6313a.put("NL", nVar);
        f6313a.put("BE", nVar);
        f6313a.put("LU", nVar);
        f6313a.put("FR", nVar);
        f6313a.put("RO", nVar);
        f6313a.put("BG", nVar);
        f6313a.put("RS", nVar);
        f6313a.put("MK", nVar);
        f6313a.put("AL", nVar);
        f6313a.put("GR", nVar);
        f6313a.put("SI", nVar);
        f6313a.put("HR", nVar);
        f6313a.put("IT", nVar);
        f6313a.put("SM", nVar);
        f6313a.put("MT", nVar);
        f6313a.put("ES", nVar);
        f6313a.put("PT", nVar);
        f6313a.put("AD", nVar);
        f6313a.put("CY", nVar);
        f6313a.put("DK", nVar);
        f6313a.put("IS", nVar);
        f6313a.put("UK", nVar);
        f6313a.put("EL", nVar);
        f6313a.put("RU", n.Russia);
        f6313a.put("IN", n.India);
    }

    private static n b(String str) {
        m5688a();
        return f6313a.get(str.toUpperCase());
    }

    public static int b() {
        String strM5687a = m5687a("ro.mi.os.version.code");
        if (TextUtils.isEmpty(strM5687a) || !TextUtils.isDigitsOnly(strM5687a)) {
            return 0;
        }
        return Integer.parseInt(strM5687a);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    private static String m5693b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM5687a = m5687a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(strM5687a) || !TextUtils.isDigitsOnly(strM5687a)) {
            return 0;
        }
        return Integer.parseInt(strM5687a);
    }

    public static boolean a(int i) {
        String strM5687a = m5687a("ro.mi.os.version.code");
        return !TextUtils.isEmpty(strM5687a) && TextUtils.isDigitsOnly(strM5687a) && Integer.parseInt(strM5687a) >= i;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + MyUTIL.white_space + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
