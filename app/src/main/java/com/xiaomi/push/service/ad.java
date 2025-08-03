package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.xiaomi.push.gl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
/* loaded from: classes2.dex */
class ad {
    private static ad a = new ad();

    /* renamed from: a, reason: collision with other field name */
    private SpannableString f6377a;

    public class a {

        /* renamed from: a, reason: collision with other field name */
        public List<b> f6378a;
        public List<b> b;

        private a() {
            this.f6378a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    public class b {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public Notification f6379a;

        public b(int i, Notification notification) {
            this.a = i;
            this.f6379a = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private ad() {
    }

    public static ad a() {
        return a;
    }

    private boolean b(Context context) {
        return ah.a(context).a(gl.NotificationAutoGroupSwitch.a(), true);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5739a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Context context) {
        if (b(context) && af.m5745a(context)) {
            return ah.a(context).a(gl.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m5741b(notification) ? a(notification) : notification.getGroup();
    }

    /* renamed from: b, reason: collision with other method in class */
    private boolean m5741b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5740a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object objA = com.xiaomi.push.ax.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (objA instanceof Boolean) {
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    private void b(Context context, int i, Notification notification) {
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("group restore not extract pkg from notification:" + i);
            return;
        }
        af afVarA = af.a(context, strC);
        List<StatusBarNotification> listA = a(afVarA);
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : listA) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m5741b(notification2) && statusBarNotification.getId() != i) {
                Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                builderRecoverBuilder.setGroup(a(notification2));
                ag.a(builderRecoverBuilder, m5740a(notification2));
                afVarA.a(statusBarNotification.getId(), builderRecoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!m5739a() || !a(context)) {
            return str;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", jCurrentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(jCurrentTimeMillis), str);
    }

    public void a(Context context, int i, Notification notification) {
        if (m5739a()) {
            if (a(context)) {
                try {
                    b(context, i, notification);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("group notify handle auto error " + e3);
                }
            }
        }
    }

    private void a(Context context, int i, Notification notification, boolean z) {
        Notification notification2;
        String strC = ag.c(notification);
        if (TextUtils.isEmpty(strC)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("group auto not extract pkg from notification:" + i);
            return;
        }
        List<StatusBarNotification> listA = a(af.a(context, strC));
        if (listA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("group auto not get notifications");
            return;
        }
        String strB = b(notification);
        HashMap map = new HashMap();
        for (StatusBarNotification statusBarNotification : listA) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                a(map, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(strB) && !m5741b(notification)) {
                    b bVar = new b(i, notification);
                    if (m5740a(notification)) {
                        value.b.add(bVar);
                    } else {
                        value.f6378a.add(bVar);
                    }
                }
                int size = value.f6378a.size();
                if (value.b.size() <= 0) {
                    if (z && size >= 2) {
                        a(context, strC, key, value.f6378a.get(0).f6379a);
                    }
                } else if (size <= 0) {
                    a(context, strC, key);
                } else if (ah.a(context).a(gl.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = value.b.get(0).f6379a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, strC, key, notification2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String strB = b(statusBarNotification.getNotification());
        a aVar = map.get(strB);
        if (aVar == null) {
            aVar = new a();
            map.put(strB, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m5740a(statusBarNotification.getNotification())) {
            aVar.b.add(bVar);
        } else {
            aVar.f6378a.add(bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private SpannableString m5738a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int iMax;
        if (this.f6377a == null) {
            int i = 200;
            if (context != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null && (iMax = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) > 0) {
                i = iMax / 16;
            }
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i + 12);
            sb.append(str);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f6377a = spannableString;
        }
        return this.f6377a;
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("group show summary group is null");
                return;
            }
            int iA = ag.a(context, str);
            if (iA == 0) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("group show summary not get icon from " + str);
                return;
            }
            af afVarA = af.a(context, str);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                String strC = afVarA.c(notification.getChannelId(), "groupSummary");
                NotificationChannel notificationChannelM5747a = afVarA.m5747a(strC);
                if ("groupSummary".equals(strC) && notificationChannelM5747a == null) {
                    afVarA.a(new NotificationChannel(strC, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, strC);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ag.a(defaults, true);
            Notification notificationBuild = defaults.setContentTitle(m5738a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, iA)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i >= 31) {
                notificationBuild.contentIntent = a(context, str);
            }
            if (!com.xiaomi.push.j.m5695c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ag.m5754a(notificationBuild, str);
            }
            int iA2 = a(str, str2);
            afVarA.a(iA2, notificationBuild);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + iA2);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("group show summary error " + e2);
        }
    }

    private PendingIntent a(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 31) {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 33554432);
            } else {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
            }
            return activity;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        af.a(context, str).a(a(str, str2));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private List<StatusBarNotification> a(af afVar) {
        List<StatusBarNotification> listM5753b = afVar != null ? afVar.m5753b() : null;
        if (listM5753b == null || listM5753b.size() == 0) {
            return null;
        }
        return listM5753b;
    }
}
