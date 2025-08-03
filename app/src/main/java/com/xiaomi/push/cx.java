package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes2.dex */
public class cx {
    private static int a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f5696a = true;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m5323a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    public static void b(final Context context, final long j, final boolean z) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cx.j(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("PowerStatsSP onReceiveMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void c(final Context context, final long j, final boolean z) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cx.k(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("PowerStatsSP onPing exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void d(final Context context, final long j, final boolean z) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cx.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cx.l(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("PowerStatsSP onPong exception: " + e2.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context, long j, boolean z) {
        int i;
        cu.a("recordSendMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM5323a = m5323a(context);
        long j2 = sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM5323a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM5323a.getInt("on_up_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("on_up_count", i).apply();
        } else {
            i = sharedPreferencesM5323a.getInt("off_up_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("off_up_count", i).apply();
        }
        a(context, j2, j, i, iA);
        cu.a("recordSendMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void j(Context context, long j, boolean z) {
        int i;
        cu.a("recordReceiveMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM5323a = m5323a(context);
        long j2 = sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM5323a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM5323a.getInt("on_down_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("on_down_count", i).apply();
        } else {
            i = sharedPreferencesM5323a.getInt("off_down_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("off_down_count", i).apply();
        }
        a(context, j2, j, i, iA);
        cu.a("recordReceiveMsg complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k(Context context, long j, boolean z) {
        int i;
        cu.a("recordPing start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM5323a = m5323a(context);
        long j2 = sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM5323a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM5323a.getInt("on_ping_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("on_ping_count", i).apply();
        } else {
            i = sharedPreferencesM5323a.getInt("off_ping_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("off_ping_count", i).apply();
        }
        a(context, j2, j, i, iA);
        cu.a("recordPing complete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context, long j, boolean z) {
        int i;
        cu.a("recordPong start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM5323a = m5323a(context);
        long j2 = sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j2 <= 0) {
            a(context, sharedPreferencesM5323a, j, iA);
        }
        if (iA == 1) {
            i = sharedPreferencesM5323a.getInt("on_pong_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("on_pong_count", i).apply();
        } else {
            i = sharedPreferencesM5323a.getInt("off_pong_count", 0) + 1;
            sharedPreferencesM5323a.edit().putInt("off_pong_count", i).apply();
        }
        a(context, j2, j, i, iA);
        cu.a("recordPong complete");
    }

    public static void a(final Context context, final long j, final boolean z) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cx.i(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("PowerStatsSP onSendMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context, long j, int i) {
        cu.a("reset");
        m5323a(context).edit().clear().putLong(com.umeng.analytics.pro.d.p, j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j, int i) {
        cu.a("recordInit");
        sharedPreferences.edit().putLong(com.umeng.analytics.pro.d.p, j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j, long j2, int i, int i2) {
        if (j > 0) {
            if (m5325a(context) || i >= 1073741823 || j2 - j >= 86400000) {
                m5323a(context).edit().putLong(com.umeng.analytics.pro.d.q, j2).apply();
                a(context, j2, i2);
            }
        }
    }

    private static void a(Context context, long j, int i) {
        cu.a("upload");
        new cw().a(context, m5324a(context));
        b(context, j, i);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static cv m5324a(Context context) {
        SharedPreferences sharedPreferencesM5323a = m5323a(context);
        cv cvVar = new cv();
        cvVar.a(sharedPreferencesM5323a.getInt("off_up_count", 0));
        cvVar.b(sharedPreferencesM5323a.getInt("off_down_count", 0));
        cvVar.c(sharedPreferencesM5323a.getInt("off_ping_count", 0));
        cvVar.d(sharedPreferencesM5323a.getInt("off_pong_count", 0));
        cvVar.a(sharedPreferencesM5323a.getLong("off_duration", 0L));
        cvVar.e(sharedPreferencesM5323a.getInt("on_up_count", 0));
        cvVar.f(sharedPreferencesM5323a.getInt("on_down_count", 0));
        cvVar.g(sharedPreferencesM5323a.getInt("on_ping_count", 0));
        cvVar.h(sharedPreferencesM5323a.getInt("on_pong_count", 0));
        cvVar.b(sharedPreferencesM5323a.getLong("on_duration", 0L));
        cvVar.c(sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.p, 0L));
        cvVar.d(sharedPreferencesM5323a.getLong(com.umeng.analytics.pro.d.q, 0L));
        cvVar.i(sharedPreferencesM5323a.getInt("xmsf_vc", 0));
        cvVar.j(sharedPreferencesM5323a.getInt("android_vc", 0));
        return cvVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5325a(Context context) {
        boolean z = false;
        if (f5696a) {
            f5696a = false;
            SharedPreferences sharedPreferencesM5323a = m5323a(context);
            int i = sharedPreferencesM5323a.getInt("xmsf_vc", 0);
            int i2 = sharedPreferencesM5323a.getInt("android_vc", 0);
            if (i != 0 && i2 != 0 && (i != a(context) || i2 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        cu.a("isVcChanged = " + z);
        return z;
    }

    private static int a(Context context) {
        if (a <= 0) {
            a = j.b(context);
        }
        return a;
    }
}
