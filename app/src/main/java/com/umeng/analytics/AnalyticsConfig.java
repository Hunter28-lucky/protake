package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_SP_FILE = "um_rtd_conf";
    public static final String RTD_START_TIME = "startTime";
    public static double[] a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f17747e = 0;
    public static boolean enable = true;
    private static Object f = new Object();
    private static boolean g = false;
    private static String h = "";
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    public static void a(String str) {
        c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f) {
            str = h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(d)) {
            d = com.umeng.common.b.a(context).c();
        }
        return d;
    }

    public static int getVerticalType(Context context) {
        if (f17747e == 0) {
            f17747e = com.umeng.common.b.a(context).d();
        }
        return f17747e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f) {
            z = g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f) {
            g = false;
            h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f) {
            g = true;
            if (map != null && map.containsKey("debugkey")) {
                h = map.get("debugkey");
            }
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            d = str;
            com.umeng.common.b.a(context).a(d);
        }
    }

    public static void a(Context context, int i) {
        f17747e = i;
        com.umeng.common.b.a(context).a(f17747e);
    }
}
