package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class i {
    private static String a = null;

    /* renamed from: a, reason: collision with other field name */
    private static final Set<String> f6306a;
    private static String b = null;
    private static String c = "";
    private static String d;

    /* renamed from: e, reason: collision with root package name */
    private static String f17896e;
    private static final String f = String.valueOf((char) 2);

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f6307a = {"--", "a-", "u-", "v-", "o-", "g-", "d-"};

    static {
        HashSet hashSet = new HashSet();
        f6306a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
    }

    private static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m5679a(int i) {
        if (i > 0) {
            String[] strArr = f6307a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f6307a[0];
    }

    public static int b() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArrSplit;
        int i = 0;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
                try {
                    String line = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(line) && (strArrSplit = line.split("\\s+")) != null && strArrSplit.length >= 2 && TextUtils.isDigitsOnly(strArrSplit[1])) {
                        i = Integer.parseInt(strArrSplit[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return i;
    }

    @Deprecated
    public static String b(Context context) {
        return null;
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return "";
    }

    public static String f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    private static String g(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strH = h(context);
        a(context, strH);
        return strH;
    }

    private static String h(Context context) {
        return az.a(Build.BRAND + "_" + k.a() + "_" + Build.VERSION.SDK_INT + "_" + Build.VERSION.RELEASE + "_" + j.e() + "_" + a() + "_" + context.getPackageName() + "_" + System.currentTimeMillis() + "_" + bc.a(16));
    }

    public static synchronized String a(Context context, boolean z) {
        int i;
        if (d == null) {
            String strMo5201a = ao.a(context).mo5201a();
            if (TextUtils.isEmpty(strMo5201a) || strMo5201a.startsWith("00000000-0000-0000-0000-000000000000")) {
                strMo5201a = a(context);
                if (TextUtils.isEmpty(strMo5201a)) {
                    strMo5201a = g(context);
                    i = 6;
                } else {
                    i = 5;
                }
            } else {
                i = 4;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                d = strMo5201a;
            } else {
                d = m5679a(i) + bc.b(strMo5201a);
            }
        }
        return d;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m5683b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    public static String a(Context context) {
        if (!j.m5690a(context)) {
            return null;
        }
        String str = b;
        if (str != null) {
            return str;
        }
        try {
            b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("failure to get androidId: " + th);
        }
        return b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m5684b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    @TargetApi(17)
    public static int a() {
        Object objA = ax.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (objA == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(objA)).intValue();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5678a() {
        return a(b()) + "GB";
    }

    private static float a(int i) {
        float f2 = ((((((i + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5681a(Context context) {
        Intent intentA = m.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (intentA == null) {
            return false;
        }
        int intExtra = intentA.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5680a() {
        return a() <= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5682a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) ax.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("default_id exist,do not change it.");
        }
    }
}
