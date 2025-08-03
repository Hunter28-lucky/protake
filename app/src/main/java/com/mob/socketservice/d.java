package com.mob.socketservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.mob.MobSDK;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class d {
    private static final String[] a = {"com.mob.guard.MobGuard"};
    private static final String[] b = {"com.mob.pushsdk.MobPush"};

    public static Notification a(Context context, String str, String str2) {
        Notification.Builder builder;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, str2, 2);
            notificationChannel.enableLights(false);
            notificationChannel.setLightColor(-65536);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(MobSDK.getContext(), str);
        } else {
            builder = new Notification.Builder(context);
        }
        builder.setSmallIcon(c.a().c());
        builder.setContentTitle(DeviceHelper.getInstance(context).getAppName());
        builder.setContentText(DeviceHelper.getInstance(context).getAppName() + " 正在后台运行...");
        return builder.build();
    }

    public static boolean b() {
        return a(a);
    }

    public static HashMap<String, Object> c() {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add("k.tcp.push.mob.com:8230");
        arrayList.add("k.tcp.push.mob.com:8260");
        arrayList.add("k.tcp.push.mob.com:9230");
        arrayList.add("l.tcp.push.mob.com:8231");
        arrayList.add("l.tcp.push.mob.com:9231");
        arrayList.add("l.tcp.push.mob.com:9291");
        map.put("domainList", arrayList);
        return map;
    }

    public static void d() {
        if (a()) {
            try {
                ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("com.mob.pushsdk.MobPush"), "requestTokenAsync", new Object[0]);
            } catch (Throwable th) {
                CLog.getInstance().e(th);
            }
        }
    }

    public static HashMap<String, Object> e() {
        if (!a()) {
            return null;
        }
        try {
            return (HashMap) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("com.mob.pushsdk.MobPush"), "requestTokenSync", new Object[0]);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
            return null;
        }
    }

    public static String f() {
        if (!b()) {
            return null;
        }
        try {
            return (String) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("com.mob.guard.MobGuard"), "getGuardId", new Object[0]);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
            return null;
        }
    }

    public static int g() {
        String networkType = DeviceHelper.getInstance(MobSDK.getContext()).getNetworkType();
        boolean z = Looper.getMainLooper() != Looper.myLooper();
        CLog.getInstance().i("isNeedWait:" + z, new Object[0]);
        int i = 30;
        while (z && networkType == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(100L);
            } catch (Throwable th) {
                CLog.getInstance().e(th);
            }
            CLog.getInstance().i("getNetworkType Wait:" + i2, new Object[0]);
            networkType = DeviceHelper.getInstance(MobSDK.getContext()).getNetworkType();
            i = i2;
        }
        CLog.getInstance().i("NetworkType:" + networkType, new Object[0]);
        if (NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(networkType)) {
            return 1;
        }
        if ("4G".equalsIgnoreCase(networkType)) {
            return 4;
        }
        if ("3G".equalsIgnoreCase(networkType)) {
            return 3;
        }
        if ("2G".equalsIgnoreCase(networkType)) {
            return 2;
        }
        return "5G".equalsIgnoreCase(networkType) ? 5 : 0;
    }

    private static boolean b(String[] strArr) throws Throwable {
        if (strArr == null || strArr.length <= 0) {
            throw new Throwable("ServiceHelper check import path is null");
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(ReflectHelper.importClass(str))) {
                return false;
            }
        }
        return true;
    }

    public static String a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).applicationInfo.metaData;
            if (bundle != null && !bundle.isEmpty() && bundle.get(str) != null) {
                return String.valueOf(bundle.get(str));
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            CLog.getInstance().e(th);
            return null;
        }
    }

    public static boolean a() {
        return a(b);
    }

    private static boolean a(String[] strArr) {
        try {
            return b(strArr);
        } catch (Throwable th) {
            CLog.getInstance().d("ServiceHelper check import " + th.getMessage() + " not find.", new Object[0]);
            return false;
        }
    }
}
