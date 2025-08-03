package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class cr {
    private static int a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m5314a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z, long j, int i, long j2, int i2, String str2, int i3) {
        SharedPreferences sharedPreferencesM5314a = m5314a(context);
        long j3 = sharedPreferencesM5314a.getLong("start_time_for_day", 0L);
        if (j3 == 0) {
            co.a("recordDisconnection not initialized");
            return;
        }
        if (j - sharedPreferencesM5314a.getLong("last_discnt_time", 0L) < 60000) {
            co.a("recordDisconnection anti-shake");
            return;
        }
        if (j - j3 < 86400000) {
            int i4 = sharedPreferencesM5314a.getInt("discnt_count_in_day", 0);
            if (i4 > 100) {
                co.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                return;
            } else {
                sharedPreferencesM5314a.edit().putInt("discnt_count_in_day", i4 + 1).apply();
            }
        } else {
            co.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
        }
        int i5 = sharedPreferencesM5314a.getInt("discnt_count", 0);
        if (i5 == sharedPreferencesM5314a.getInt("cnt_count", 0)) {
            a(context, str, a(z), j, i, j2, i2, str2, i3);
            sharedPreferencesM5314a.edit().putLong("last_discnt_time", j).putInt("discnt_count", i5 + 1).apply();
        }
        co.a("recordDisconnection complete");
    }

    public static void a(final Context context, final String str, final boolean z, final long j, final int i, final long j2, final int i2, final String str2, final int i3) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cr.c(context, str, z, j, i, j2, i2, str2, i3);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("DisconnectStatsSP onDisconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void a(final Context context, final long j) {
        af.a(context).a(new Runnable() { // from class: com.xiaomi.push.cr.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cr.c(context, j);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("DisconnectStatsSP onReconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context) {
        co.a("resetAfterUpload");
        m5314a(context).edit().putString("host", null).putString("network_state", null).putString("reason", null).putString("ping_interval", null).putString(com.umeng.analytics.pro.am.T, null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    private static void a(Context context, String str, int i, long j, int i2, long j2, int i3, String str2, int i4) {
        co.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), str2, Integer.valueOf(i4)));
        SharedPreferences sharedPreferencesM5314a = m5314a(context);
        String string = sharedPreferencesM5314a.getString("host", null);
        String string2 = sharedPreferencesM5314a.getString("network_state", null);
        String string3 = sharedPreferencesM5314a.getString("reason", null);
        String string4 = sharedPreferencesM5314a.getString("ping_interval", null);
        String string5 = sharedPreferencesM5314a.getString(com.umeng.analytics.pro.am.T, null);
        String string6 = sharedPreferencesM5314a.getString("wifi_digest", null);
        String string7 = sharedPreferencesM5314a.getString("connected_network_type", null);
        String string8 = sharedPreferencesM5314a.getString("disconnect_time", null);
        String string9 = sharedPreferencesM5314a.getString("xmsf_vc", null);
        String string10 = sharedPreferencesM5314a.getString("android_vc", null);
        String strA = a(string, str);
        String strA2 = a(string2, i);
        String strA3 = a(string3, i2);
        String strA4 = a(string4, j2);
        String strA5 = a(string5, i3);
        String strA6 = a(string6, str2);
        String strA7 = a(string7, i4);
        String strA8 = a(string8, j);
        sharedPreferencesM5314a.edit().putString("host", strA).putString("network_state", strA2).putString("reason", strA3).putString("ping_interval", strA4).putString(com.umeng.analytics.pro.am.T, strA5).putString("wifi_digest", strA6).putString("connected_network_type", strA7).putString("disconnect_time", strA8).putString("xmsf_vc", a(string9, a(context))).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, long j) {
        SharedPreferences sharedPreferencesM5314a = m5314a(context);
        long j2 = sharedPreferencesM5314a.getLong("start_time_for_day", 0L);
        if (j2 == 0) {
            sharedPreferencesM5314a.edit().putLong("start_time_for_day", j).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
            return;
        }
        int i = sharedPreferencesM5314a.getInt("discnt_count", 0);
        int i2 = sharedPreferencesM5314a.getInt("cnt_count", 0);
        if (i > i2) {
            sharedPreferencesM5314a.edit().putInt("cnt_count", i2 + 1).putString("connected_time", a(sharedPreferencesM5314a.getString("connected_time", null), j)).apply();
        }
        if (j - j2 >= 86400000) {
            sharedPreferencesM5314a.edit().putLong("start_time_for_day", j).putInt("discnt_count_in_day", 0).apply();
            m5316a(context);
        } else if (i >= 10) {
            m5316a(context);
        }
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = "null";
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    private static String a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    private static String a(String str, long j) {
        return a(str, String.valueOf(j));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m5316a(Context context) {
        co.a("upload");
        new cq().a(context, m5315a(context));
        b(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static List<cp> m5315a(Context context) {
        SharedPreferences sharedPreferencesM5314a = m5314a(context);
        String[] strArrA = a(sharedPreferencesM5314a.getString("host", null));
        if (strArrA != null && strArrA.length > 0) {
            String[] strArrA2 = a(sharedPreferencesM5314a.getString("network_state", null));
            String[] strArrA3 = a(sharedPreferencesM5314a.getString("reason", null));
            String[] strArrA4 = a(sharedPreferencesM5314a.getString("ping_interval", null));
            String[] strArrA5 = a(sharedPreferencesM5314a.getString(com.umeng.analytics.pro.am.T, null));
            String[] strArrA6 = a(sharedPreferencesM5314a.getString("wifi_digest", null));
            String[] strArrA7 = a(sharedPreferencesM5314a.getString("connected_network_type", null));
            String[] strArrA8 = a(sharedPreferencesM5314a.getString("disconnect_time", null));
            String[] strArrA9 = a(sharedPreferencesM5314a.getString("connected_time", null));
            String[] strArrA10 = a(sharedPreferencesM5314a.getString("xmsf_vc", null));
            String[] strArrA11 = a(sharedPreferencesM5314a.getString("android_vc", null));
            if (strArrA2 != null && strArrA3 != null && strArrA4 != null && strArrA5 != null && strArrA6 != null && strArrA7 != null && strArrA8 != null && strArrA9 != null && strArrA10 != null && strArrA11 != null && strArrA.length == strArrA2.length && strArrA.length == strArrA3.length && strArrA.length == strArrA4.length && strArrA.length == strArrA5.length && strArrA.length == strArrA6.length && strArrA.length == strArrA7.length && strArrA.length == strArrA8.length && strArrA.length == strArrA9.length && strArrA.length == strArrA10.length && strArrA.length == strArrA11.length) {
                ArrayList arrayList = new ArrayList(strArrA.length);
                int i = 0;
                while (i < strArrA.length) {
                    cp cpVar = new cp();
                    cpVar.a(1);
                    cpVar.a(strArrA[i]);
                    cpVar.b(t.a(strArrA2[i], -1));
                    cpVar.c(t.a(strArrA3[i], -1));
                    String[] strArr = strArrA2;
                    String[] strArr2 = strArrA;
                    ArrayList arrayList2 = arrayList;
                    cpVar.a(t.a(strArrA4[i], -1L));
                    cpVar.d(t.a(strArrA5[i], -1));
                    cpVar.b(strArrA6[i]);
                    cpVar.e(t.a(strArrA7[i], -1));
                    long jA = t.a(strArrA8[i], -1L);
                    long jA2 = t.a(strArrA9[i], -1L);
                    cpVar.b(jA2 - jA);
                    cpVar.c(jA);
                    cpVar.d(jA2);
                    cpVar.f(t.a(strArrA10[i], -1));
                    cpVar.g(t.a(strArrA11[i], -1));
                    arrayList2.add(cpVar);
                    i++;
                    strArrA2 = strArr;
                    arrayList = arrayList2;
                    strArrA4 = strArrA4;
                    strArrA3 = strArrA3;
                    strArrA = strArr2;
                    strArrA5 = strArrA5;
                }
                return arrayList;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    private static int a(Context context) {
        if (a <= 0) {
            a = j.b(context);
        }
        return a;
    }
}
