package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class co {
    private static int a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static cs f5676a;

    /* renamed from: a, reason: collision with other field name */
    private static String f5677a;

    public static void a(Context context, fb fbVar) {
        if (m5307a(context)) {
            if (f5676a == null) {
                f5676a = new cs(context);
            }
            fbVar.a(f5676a);
            a("startStats");
        }
    }

    public static void b(Context context, fb fbVar) {
        cs csVar = f5676a;
        if (csVar != null) {
            fbVar.b(csVar);
            f5676a = null;
            a("stopStats");
        }
    }

    private static synchronized void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = f5677a;
            if (str2 == null || !str2.startsWith("W-")) {
                f5677a = null;
            }
        } else {
            f5677a = str;
        }
        a("updateNetId new networkId = " + str + ", finally netId = " + f5677a);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5307a(Context context) {
        return cl.a(context);
    }

    public static void a(Context context, String str, int i) {
        if (!m5307a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        cr.a(context, str, av.b(context), System.currentTimeMillis(), i, com.xiaomi.push.service.m.a(context).m5792b(), a(context), a(), a);
        a("onDisconnection");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5306a(Context context) {
        if (!m5307a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a = a(context);
        cr.a(context, jCurrentTimeMillis);
        a("onReconnection connectedNetworkType = " + a);
    }

    public static void a(Context context, String str) {
        if (!m5307a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("W-" + str);
    }

    private static int a(Context context) {
        String str;
        try {
            aw awVarM5209a = av.m5209a();
            if (awVarM5209a != null) {
                if (awVarM5209a.a() == 0) {
                    String strM5221b = awVarM5209a.m5221b();
                    if (TextUtils.isEmpty(strM5221b) || "UNKNOWN".equalsIgnoreCase(strM5221b)) {
                        str = null;
                    } else {
                        str = "M-" + strM5221b;
                    }
                    b(str);
                    return 0;
                }
                if (awVarM5209a.a() != 1 && awVarM5209a.a() != 6) {
                    b(null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b(null);
            return -1;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e2.getMessage());
            b(null);
            return -1;
        }
    }

    private static synchronized String a() {
        return f5677a;
    }

    public static void a(String str) {
        cl.a("Push-DiscntStats", str);
    }
}
