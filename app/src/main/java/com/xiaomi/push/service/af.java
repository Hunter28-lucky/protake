package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.gl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class af {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static Object f6384a;

    /* renamed from: a, reason: collision with other field name */
    private static WeakHashMap<Integer, af> f6385a = new WeakHashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private static boolean f6386a;

    /* renamed from: a, reason: collision with other field name */
    private String f6387a;
    private String b;

    private af(String str) {
        this.f6387a = str;
    }

    public static String b(String str, String str2) {
        return a(m5744a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Context m5748a() {
        return a;
    }

    public String c(String str, String str2) {
        return m5744a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f6387a + "}";
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5749a() {
        return this.f6387a;
    }

    public static af a(Context context, String str) {
        a(context);
        int iHashCode = str.hashCode();
        af afVar = f6385a.get(Integer.valueOf(iHashCode));
        if (afVar != null) {
            return afVar;
        }
        af afVar2 = new af(str);
        f6385a.put(Integer.valueOf(iHashCode), afVar2);
        return afVar2;
    }

    private String b(String str) {
        return b(this.f6387a, str);
    }

    public String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = b("default");
        }
        return this.b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public List<StatusBarNotification> m5753b() {
        String str = this.f6387a;
        NotificationManager notificationManagerA = a();
        List<StatusBarNotification> list = null;
        try {
            if (m5744a()) {
                int iA = com.xiaomi.push.i.a();
                if (iA != -1) {
                    list = (List) a(com.xiaomi.push.ax.a(f6384a, "getAppActiveNotifications", str, Integer.valueOf(iA)));
                }
            } else {
                StatusBarNotification[] activeNotifications = notificationManagerA.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        for (StatusBarNotification statusBarNotification : activeNotifications) {
                            if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                                arrayList.add(statusBarNotification);
                            }
                        }
                        list = arrayList;
                    } catch (Throwable th) {
                        th = th;
                        list = arrayList;
                        m5743a("getActiveNotifications error " + th);
                        return list;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return list;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5745a(Context context) {
        a(context);
        return m5744a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = a("mipush|%s|%s", str2, "");
        return str.startsWith(strA) ? a("mipush_%s_%s", str2, str.replace(strA, "")) : str;
    }

    private static void a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager notificationManagerA = a();
            Boolean bool = (Boolean) com.xiaomi.push.ax.a((Object) notificationManagerA, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            m5743a("fwk is support.init:" + bool);
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            f6386a = zBooleanValue;
            if (zBooleanValue) {
                f6384a = com.xiaomi.push.ax.a((Object) notificationManagerA, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) a.getSystemService("notification");
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5744a() {
        if (com.xiaomi.push.j.m5689a() && ah.a(a).a(gl.NotificationBelongToAppSwitch.a(), true)) {
            return f6386a;
        }
        return false;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5752a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(b(""));
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5750a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return com.xiaomi.push.j.m5690a(m5748a()) ? b(str) : str;
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f6387a;
        try {
            if (m5744a()) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.ax.b(f6384a, "createNotificationChannelsForPackage", str, Integer.valueOf(iA), a(Arrays.asList(notificationChannel)));
                }
            } else {
                a().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e2) {
            m5743a("createNotificationChannel error" + e2);
        }
    }

    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public NotificationChannel m5747a(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (m5744a()) {
                List<NotificationChannel> listM5751a = m5751a();
                if (listM5751a != null) {
                    Iterator<NotificationChannel> it = listM5751a.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            NotificationChannel next = it.next();
                            if (str.equals(next.getId())) {
                                notificationChannel = next;
                                break;
                            }
                        }
                    }
                }
            } else {
                notificationChannel = a().getNotificationChannel(str);
            }
            break;
        } catch (Exception e2) {
            m5743a("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @TargetApi(26)
    /* renamed from: a, reason: collision with other method in class */
    public List<NotificationChannel> m5751a() {
        String str;
        String str2 = this.f6387a;
        List<NotificationChannel> notificationChannels = null;
        try {
            if (m5744a()) {
                int iA = a(str2);
                if (iA != -1) {
                    Object obj = f6384a;
                    Object[] objArr = {str2, Integer.valueOf(iA), Boolean.FALSE};
                    str = "mipush|%s|%s";
                    notificationChannels = (List) a(com.xiaomi.push.ax.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                notificationChannels = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.j.m5689a() || notificationChannels == null) {
                return notificationChannels;
            }
            ArrayList arrayList = new ArrayList();
            String strA = a(str, str2, "");
            for (NotificationChannel notificationChannel : notificationChannels) {
                if (notificationChannel.getId().startsWith(strA)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (Exception e2) {
            m5743a("getNotificationChannels error " + e2);
            return notificationChannels;
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f6387a;
        try {
            if (z) {
                int iA = a(str);
                if (iA != -1) {
                    com.xiaomi.push.ax.b(f6384a, "updateNotificationChannelForPackage", str, Integer.valueOf(iA), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e2) {
            m5743a("updateNotificationChannel error " + e2);
        }
    }

    public void a(int i, Notification notification) {
        String str = this.f6387a;
        NotificationManager notificationManagerA = a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (m5744a()) {
                notification.extras.putString("xmsf_target_package", str);
                if (i2 >= 29) {
                    notificationManagerA.notifyAsPackage(str, null, i, notification);
                } else {
                    notificationManagerA.notify(i, notification);
                }
            } else {
                notificationManagerA.notify(i, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i) {
        String str = this.f6387a;
        try {
            if (m5744a()) {
                int iA = com.xiaomi.push.i.a();
                String packageName = m5748a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    com.xiaomi.push.ax.b(f6384a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(iA));
                } else {
                    com.xiaomi.push.ax.b(f6384a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(iA));
                }
                m5743a("cancel succ:" + i);
                return;
            }
            a().cancel(i);
        } catch (Exception e2) {
            m5743a("cancel error" + e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private StatusBarNotification[] m5746a() {
        if (!com.xiaomi.push.j.m5690a(m5748a())) {
            return null;
        }
        try {
            Object objA = com.xiaomi.push.ax.a(f6384a, "getActiveNotifications", m5748a().getPackageName());
            if (objA instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) objA;
            }
            return null;
        } catch (Throwable th) {
            m5743a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5743a(String str) {
        com.xiaomi.channel.commonutils.logger.b.m5113a("NMHelper:" + str);
    }
}
