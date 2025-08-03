package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ax;

/* loaded from: classes2.dex */
public class h {
    private static int a = -1;

    public static q a(Context context) {
        return m5168a(context) ? q.HUAWEI : c(context) ? q.OPPO : d(context) ? q.VIVO : q.OTHER;
    }

    public static boolean b(Context context) {
        Object objA = ax.a(ax.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object objA2 = ax.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (objA2 == null || !(objA2 instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            a = 0;
            return false;
        }
        int iIntValue = ((Integer) Integer.class.cast(objA2)).intValue();
        if (objA != null) {
            if (objA instanceof Integer) {
                a = ((Integer) Integer.class.cast(objA)).intValue() == iIntValue ? 1 : 0;
            } else {
                a = 0;
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(a > 0);
        com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        return a > 0;
    }

    public static boolean c(Context context) {
        boolean zBooleanValue = false;
        Object objA = ax.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (objA != null && (objA instanceof Boolean)) {
            zBooleanValue = ((Boolean) Boolean.class.cast(objA)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + zBooleanValue);
        return zBooleanValue;
    }

    public static boolean d(Context context) {
        boolean zBooleanValue = false;
        Object objA = ax.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (objA != null && (objA instanceof Boolean)) {
            zBooleanValue = ((Boolean) Boolean.class.cast(objA)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + zBooleanValue);
        return zBooleanValue;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5168a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (a()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean a() {
        try {
            String str = (String) ax.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return false;
    }
}
