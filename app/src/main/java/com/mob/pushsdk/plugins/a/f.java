package com.mob.pushsdk.plugins.a;

import android.text.TextUtils;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.ReflectHelper;

/* loaded from: classes2.dex */
public class f {
    private static final String[] a = {"com.huawei.hms.api.HuaweiApiClient", "com.huawei.hms.aaid.HmsInstanceId", "com.huawei.hms.api.HuaweiApiAvailability", "com.huawei.hms.push.HmsMessaging", "com.huawei.agconnect.config.AGConnectServicesConfig"};
    private static final String[] b = {"com.huawei.hms.api.HuaweiApiClient", "com.huawei.hms.api.ConnectionResult", "com.huawei.hms.api.HuaweiApiAvailability", "com.huawei.hms.support.api.client.PendingResult", "com.huawei.hms.support.api.client.ResultCallback", "com.huawei.hms.support.api.push.PushException", "com.huawei.hms.support.api.push.TokenResult", "com.huawei.hms.support.api.push.HuaweiPush"};
    private static final String[] c = {"com.xiaomi.mipush.sdk.MiPushClient"};
    private static final String[] d = {"com.meizu.cloud.pushsdk.PushManager"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f17704e = {"com.google.firebase.FirebaseApp", "com.google.firebase.messaging.FirebaseMessaging", "com.google.android.gms.tasks.Task"};
    private static final String[] f = {"com.heytap.msp.push.HeytapPushManager", "com.heytap.msp.push.callback.ICallBackResultService"};
    private static final String[] g = {"com.vivo.push.PushClient"};
    private static final String[] h = {"com.mob.guard.MobGuard"};

    public static boolean a() {
        return a(h);
    }

    public static boolean b() {
        return a(b);
    }

    public static boolean c() {
        return a(a);
    }

    public static boolean d() {
        return a(c);
    }

    public static boolean e() {
        return a(d);
    }

    public static boolean f() {
        return a(f17704e);
    }

    public static boolean g() {
        return a(f);
    }

    public static boolean h() {
        return a(g);
    }

    public static boolean a(String[] strArr) {
        try {
            return b(strArr);
        } catch (Throwable th) {
            PLog.getInstance().d("PluginWrapper check import Plugin " + th.getMessage() + " not find.", new Object[0]);
            return false;
        }
    }

    private static boolean b(String[] strArr) throws Throwable {
        if (strArr == null || strArr.length <= 0) {
            throw new Throwable("PluginWrapper check import Plugin path is null");
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(ReflectHelper.importClass(str))) {
                return false;
            }
        }
        return true;
    }
}
