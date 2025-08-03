package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.af;
import com.xiaomi.push.dw;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class bb {
    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i, String str2, Notification notification) {
        af afVarA;
        Notification notificationA;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (notificationA = a(notification, i, str2, (afVarA = af.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (notificationA.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.ax.a((Object) notificationA, "mGroupAlertBehavior", (Object) 1);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = notificationA.extras.getLong("mipush_org_when", 0L);
        int i2 = notificationA.extras.getInt("mipush_n_top_fre", 0);
        int i3 = notificationA.extras.getInt("mipush_n_top_prd", 0);
        if (i3 <= 0 || i3 < i2) {
            return;
        }
        long j2 = (i3 * 1000) + j;
        int iMin = (j >= jCurrentTimeMillis || jCurrentTimeMillis >= j2) ? 0 : i2 > 0 ? (int) Math.min((j2 - jCurrentTimeMillis) / 1000, i2) : i3;
        if (!z) {
            if (iMin > 0) {
                notificationA.when = jCurrentTimeMillis;
                com.xiaomi.channel.commonutils.logger.b.m5113a("update top notification: " + str2);
                afVarA.a(i, notificationA);
            } else {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, notificationA);
                builderRecoverBuilder.setPriority(0);
                builderRecoverBuilder.setWhen(jCurrentTimeMillis);
                Bundle extras = builderRecoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    builderRecoverBuilder.setExtras(extras);
                }
                com.xiaomi.channel.commonutils.logger.b.m5113a("update top notification to common: " + str2);
                afVarA.a(i, builderRecoverBuilder.build());
            }
        }
        if (iMin > 0) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("schedule top notification next update delay: " + iMin);
            com.xiaomi.push.af.a(context).m5196a(b(i, str2));
            com.xiaomi.push.af.a(context).b(a(context, str, i, str2, (Notification) null), iMin);
        }
    }

    public static void a(Context context, Map<String, String> map, dw dwVar, long j) {
        if (map == null || dwVar == null || !com.xiaomi.push.j.m5690a(context) || !m5780a(map)) {
            return;
        }
        int iA = a(map);
        int iB = b(map);
        if (iA <= 0 || iB > iA) {
            com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + iA + " frequency:" + iB);
            return;
        }
        dwVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (iB > 0) {
            bundle.putInt("mipush_n_top_fre", iB);
        }
        bundle.putInt("mipush_n_top_prd", iA);
        dwVar.addExtras(bundle);
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.t.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, String str) {
        return "n_top_update_" + i + "_" + str;
    }

    @TargetApi(19)
    /* renamed from: a, reason: collision with other method in class */
    public static void m5779a(Context context, String str, int i, String str2, Notification notification) {
        if (com.xiaomi.push.j.m5690a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i, str2, notification);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5780a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = Boolean.parseBoolean(str);
        com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + z);
        return z;
    }

    private static int a(Map<String, String> map) {
        return Math.max(0, com.xiaomi.push.t.a(map.get("notification_top_period"), 0));
    }

    @TargetApi(19)
    private static Notification a(Notification notification, int i, String str, af afVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> listM5753b = afVar.m5753b();
        if (listM5753b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : listM5753b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    private static af.a a(final Context context, final String str, final int i, final String str2, final Notification notification) {
        return new af.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.af.a
            /* renamed from: a */
            public String mo5248a() {
                return bb.b(i, str2);
            }

            @Override // java.lang.Runnable
            @TargetApi(19)
            public void run() {
                bb.c(context, str, i, str2, notification);
            }
        };
    }
}
