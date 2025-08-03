package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class g {
    private static a a;

    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a, reason: collision with other method in class */
        boolean m5516a(Context context, String str);

        boolean b(Context context, String str);
    }

    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a, reason: collision with other field name */
        private final int f5949a;

        b(int i) {
            this.f5949a = i;
        }

        public int a() {
            return this.f5949a;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5511a(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : com.umeng.umcrash.BuildConfig.VERSION_NAME;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5515b(Context context, String str) {
        a aVar = a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m5514b(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    public static int a(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    @TargetApi(19)
    public static b a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b bVarA;
        b bVar;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.equals(context.getPackageName())) {
                    applicationInfo = context.getApplicationInfo();
                } else {
                    applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                }
                bVarA = a(context, applicationInfo);
                bVar = b.UNKNOWN;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("get app op error " + th);
            }
            if (bVarA != bVar) {
                return bVarA;
            }
            Integer num = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return bVar;
            }
            Integer num2 = (Integer) ax.a(context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) ax.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", num2, i, i2));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i) ? b.ALLOWED : b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    public static int b(Context context, String str) {
        ApplicationInfo applicationInfoM5509a = m5509a(context, str);
        if (applicationInfoM5509a == null) {
            return 0;
        }
        int i = applicationInfoM5509a.icon;
        return i == 0 ? applicationInfoM5509a.logo : i;
    }

    private static b a(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo != null && i >= 24) {
            Boolean boolValueOf = null;
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    boolValueOf = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
                } else {
                    if (i >= 29) {
                        systemService = ax.a(context.getSystemService("notification"), "getService", new Object[0]);
                    } else {
                        systemService = context.getSystemService("security");
                    }
                    if (systemService != null) {
                        boolValueOf = (Boolean) ax.b(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    }
                }
                if (boolValueOf != null) {
                    return boolValueOf.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("are notifications enabled error " + e2);
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    public static void a(Context context, ApplicationInfo applicationInfo, boolean z) {
        Object systemService;
        int i = Build.VERSION.SDK_INT;
        if (b.ALLOWED != a(context, applicationInfo)) {
            try {
                if (i >= 29) {
                    systemService = ax.a(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    ax.b(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("set notifications enabled error " + e2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5513a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!j.m5689a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = a;
        return aVar != null && aVar.m5516a(context, str);
    }

    public static boolean a(Context context) {
        String strA = a();
        if (TextUtils.isEmpty(strA) || context == null) {
            return false;
        }
        return strA.equals(context.getPackageName());
    }

    public static String a() {
        String processName;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Application.getProcessName();
        } else {
            processName = (String) ax.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        return !TextUtils.isEmpty(processName) ? processName : "";
    }

    /* renamed from: a, reason: collision with other method in class */
    private static ApplicationInfo m5509a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Drawable m5510a(Context context, String str) {
        ApplicationInfo applicationInfoM5509a = m5509a(context, str);
        Drawable drawableLoadIcon = null;
        if (applicationInfoM5509a != null) {
            try {
                drawableLoadIcon = applicationInfoM5509a.loadIcon(context.getPackageManager());
                if (drawableLoadIcon == null) {
                    drawableLoadIcon = applicationInfoM5509a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("get app icon drawable failed, " + e2);
            }
        }
        return drawableLoadIcon != null ? drawableLoadIcon : new ColorDrawable(0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static Map<String, String> m5512a(Context context, String str) {
        a aVar = a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }
}
