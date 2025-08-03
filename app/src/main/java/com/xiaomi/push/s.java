package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.AnalyticsConstants;

/* loaded from: classes2.dex */
public class s {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static String f6326a;

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5706b() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static String c() {
        String strA = q.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("ColorOS_")) {
            f6326a = "ColorOS_" + strA;
        }
        return f6326a;
    }

    private static String d() {
        String strA = q.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(strA) && !strA.startsWith("FuntouchOS_")) {
            f6326a = "FuntouchOS_" + strA;
        }
        return f6326a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Context m5702a() {
        return a;
    }

    public static int a() {
        try {
            Class<?> clsA = a(null, "miui.os.Build");
            if (clsA.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return clsA.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String b() {
        String strA = q.a("ro.build.version.emui", "");
        f6326a = strA;
        return strA;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5705a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5704a() {
        return TextUtils.equals((String) ax.a("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m5703a() {
        String str = f6326a;
        if (str != null) {
            return str;
        }
        String strE = j.e();
        if (a() <= 0) {
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                strB = c();
                if (TextUtils.isEmpty(strB)) {
                    strB = d();
                    if (TextUtils.isEmpty(strB)) {
                        strE = String.valueOf(q.a("ro.product.brand", AnalyticsConstants.SDK_TYPE) + "_" + strE);
                    }
                }
                strE = strB;
            } else {
                strE = strB;
            }
        }
        f6326a = strE;
        return strE;
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        if (str != null && str.trim().length() != 0) {
            boolean z = context != null;
            if (z && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }
}
