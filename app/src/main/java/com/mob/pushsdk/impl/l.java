package com.mob.pushsdk.impl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCustomNotification;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushTailorNotification;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class l {
    private static l a;
    private int b;
    private int c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private NotificationManager f17699e;
    private int f = 0;
    private boolean g;
    private MobPushCustomNotification h;
    private MobPushTailorNotification i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private com.mob.pushsdk.plugins.a o;
    private Map<String, String> p;

    private l() {
        this.g = false;
        try {
            this.f17699e = (NotificationManager) MobSDK.getContext().getSystemService("notification");
            String packageName = MobSDK.getContext().getPackageName();
            PackageManager packageManager = MobSDK.getContext().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            this.d = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
            if (com.mob.pushsdk.biz.d.n() < 1) {
                this.b = applicationInfo.icon;
            } else {
                this.b = com.mob.pushsdk.biz.d.n();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            this.b = 0;
            PLog.getInstance().e(e2);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
        this.c = com.mob.pushsdk.biz.d.o();
        this.g = com.mob.pushsdk.biz.d.p();
        int[] iArrI = com.mob.pushsdk.biz.d.i();
        if (iArrI != null && iArrI.length == 4) {
            this.j = iArrI[0];
            this.k = iArrI[1];
            this.l = iArrI[2];
            this.m = iArrI[3];
        }
        String strJ = com.mob.pushsdk.biz.d.j();
        if (!TextUtils.isEmpty(strJ)) {
            try {
                String[] strArrSplit = strJ.split("\\|");
                ReflectHelper.importClass(strArrSplit[0]);
                try {
                    this.h = (MobPushCustomNotification) ReflectHelper.newInstance(strArrSplit[1], new Object[0]);
                } catch (Throwable unused) {
                    this.h = (MobPushCustomNotification) ReflectHelper.newInstance(strArrSplit[1], MobSDK.getContext());
                }
            } catch (Throwable th2) {
                PLog.getInstance().d(th2);
            }
            if (this.h == null) {
                com.mob.pushsdk.biz.d.e((String) null);
            }
        }
        PLog.getInstance().d("NofityManager notifyName = " + strJ + ", notification = " + this.h, new Object[0]);
        String strK = com.mob.pushsdk.biz.d.k();
        if (!TextUtils.isEmpty(strK)) {
            try {
                String[] strArrSplit2 = strK.split("\\|");
                ReflectHelper.importClass(strArrSplit2[0]);
                try {
                    this.i = (MobPushTailorNotification) ReflectHelper.newInstance(strArrSplit2[1], new Object[0]);
                } catch (Throwable unused2) {
                    this.i = (MobPushTailorNotification) ReflectHelper.newInstance(strArrSplit2[1], MobSDK.getContext());
                }
            } catch (Throwable th3) {
                PLog.getInstance().d(th3);
            }
            if (this.i == null) {
                com.mob.pushsdk.biz.d.f((String) null);
            }
        }
        this.o = com.mob.pushsdk.plugins.b.b();
        this.p = new HashMap();
        d();
        e();
    }

    public static synchronized l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    private Notification.Builder c(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new Notification.Builder(MobSDK.getContext());
        }
        NotificationChannel notificationChannel = !TextUtils.isEmpty(str) ? this.f17699e.getNotificationChannel(str) : null;
        if (notificationChannel == null) {
            PLog.getInstance().d("NotificationManager  notificationChannelId=" + str + " is not exist!", new Object[0]);
            f();
            str = "MobPush";
            notificationChannel = this.f17699e.getNotificationChannel("MobPush");
        }
        if (notificationChannel != null) {
            return new Notification.Builder(MobSDK.getContext(), str);
        }
        return null;
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 26) {
            PLog.getInstance().d("NotifyManager createDefaultNotificationChannel", new Object[0]);
            NotificationChannel notificationChannel = new NotificationChannel("MobPush", "MobPush", 3);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 400, 700, 10, 300, 100, 500});
            this.f17699e.createNotificationChannel(notificationChannel);
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.f17699e.getNotificationChannel("mobpush_notify") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_none") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_none");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_only_light") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_only_light");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_only_shake") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_only_shake");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_only_sound") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_only_sound");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_shake_light") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_shake_light");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_sound_light") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_sound_light");
            }
            if (this.f17699e.getNotificationChannel("mobpush_notify_sound_shake") != null) {
                this.f17699e.deleteNotificationChannel("mobpush_notify_sound_shake");
            }
        }
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 26 || this.f17699e.getNotificationChannel("MobPush") != null) {
            return;
        }
        d();
    }

    public void b(int i) {
        this.c = i;
        com.mob.pushsdk.biz.d.d(i);
    }

    public void b(MobPushNotifyMessage mobPushNotifyMessage) {
        synchronized (l.class) {
            a(mobPushNotifyMessage, 0);
            c(mobPushNotifyMessage);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        com.mob.pushsdk.biz.d.a(new int[]{i, i2, i3, i4});
        com.mob.pushsdk.a.a.a().a(i, i2, i3, i4);
    }

    private boolean b(String str) {
        return Build.VERSION.SDK_INT < 26 && !TextUtils.isEmpty(str);
    }

    public void b() {
        try {
            com.mob.pushsdk.plugins.a aVar = this.o;
            if (aVar != null && (aVar instanceof com.mob.pushsdk.plugins.fcm.b)) {
                this.n = 0;
            }
            if (com.mob.pushsdk.biz.d.t()) {
                b.a().a(this.n);
            } else {
                b.a().a(0);
            }
        } catch (Throwable th) {
            PLog.getInstance().e("synchronize badge count, error: " + th.getMessage(), new Object[0]);
        }
    }

    public void c() {
        com.mob.pushsdk.plugins.a aVar = this.o;
        if (aVar == null || (aVar != null && (aVar instanceof com.mob.pushsdk.plugins.meizu.b))) {
            int i = this.n;
            this.n = i >= 0 ? 1 + i : 1;
            PLog.getInstance().d("show badge " + com.mob.pushsdk.biz.d.t() + ", badge count:" + this.n, new Object[0]);
            if (com.mob.pushsdk.biz.d.t()) {
                b.a().a(this.n);
            }
        }
    }

    public void a(MobPushCustomNotification mobPushCustomNotification) {
        String str;
        this.h = mobPushCustomNotification;
        if (mobPushCustomNotification == null) {
            str = null;
        } else {
            str = mobPushCustomNotification.getClass().getName() + "|" + mobPushCustomNotification.getClass().getSimpleName();
        }
        com.mob.pushsdk.biz.d.e(str);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("\\|");
                ReflectHelper.importClass(strArrSplit[0]);
                try {
                    this.i = (MobPushTailorNotification) ReflectHelper.newInstance(strArrSplit[1], new Object[0]);
                } catch (Throwable unused) {
                    this.i = (MobPushTailorNotification) ReflectHelper.newInstance(strArrSplit[1], MobSDK.getContext());
                }
            } catch (Throwable th) {
                PLog.getInstance().d(th);
            }
            if (this.i == null) {
                com.mob.pushsdk.biz.d.f((String) null);
                return;
            }
            return;
        }
        this.i = null;
    }

    public void c(MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            c();
            return;
        }
        com.mob.pushsdk.plugins.a aVar = this.o;
        if (aVar == null || !(aVar == null || (aVar instanceof com.mob.pushsdk.plugins.meizu.b))) {
            if (this.n < 0) {
                this.n = 0;
            }
            if (1 == mobPushNotifyMessage.getAndroidBadgeType()) {
                this.n = mobPushNotifyMessage.getAndroidBadge();
            } else if (2 == mobPushNotifyMessage.getAndroidBadgeType()) {
                this.n += mobPushNotifyMessage.getAndroidBadge();
            } else {
                this.n++;
            }
            PLog.getInstance().d("show badge " + com.mob.pushsdk.biz.d.t() + ", badge count:" + this.n, new Object[0]);
            if (com.mob.pushsdk.biz.d.t()) {
                b.a().a(this.n);
            }
        }
    }

    public void a(int i) {
        this.b = i;
        com.mob.pushsdk.biz.d.c(i);
        com.mob.pushsdk.a.a.a().a(i);
    }

    public void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.g = z;
            com.mob.pushsdk.biz.d.d(z);
        }
    }

    public void c(int i) {
        com.mob.pushsdk.plugins.a aVar = this.o;
        if (aVar != null && (aVar instanceof com.mob.pushsdk.plugins.fcm.b)) {
            this.n = 0;
            return;
        }
        synchronized (l.class) {
            if (!this.p.isEmpty() && this.p.containsKey(String.valueOf(i))) {
                int i2 = this.n - 1;
                this.n = i2;
                if (i2 < 0) {
                    this.n = 0;
                    return;
                }
                if (com.mob.pushsdk.biz.d.t()) {
                    b.a().a(this.n);
                }
                if (this.p.containsKey(String.valueOf(i))) {
                    this.p.remove(String.valueOf(i));
                }
                if (i > 0) {
                    this.f17699e.cancel(i);
                }
            }
        }
    }

    public void a(MobPushNotifyMessage mobPushNotifyMessage) {
        a(mobPushNotifyMessage, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[PHI: r19
      0x0099: PHI (r19v4 boolean) = (r19v0 boolean), (r19v0 boolean), (r19v0 boolean), (r19v0 boolean), (r19v0 boolean), (r19v6 boolean), (r19v6 boolean) binds: [B:39:0x00b7, B:41:0x00bb, B:28:0x00a2, B:30:0x00a6, B:32:0x00aa, B:20:0x0092, B:22:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b A[PHI: r19
      0x009b: PHI (r19v1 boolean) = 
      (r19v0 boolean)
      (r19v0 boolean)
      (r19v0 boolean)
      (r19v0 boolean)
      (r19v6 boolean)
      (r19v6 boolean)
      (r19v6 boolean)
      (r19v7 boolean)
     binds: [B:42:0x00bd, B:38:0x00b5, B:36:0x00b1, B:33:0x00ac, B:18:0x008e, B:19:0x0090, B:23:0x0098, B:15:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.mob.pushsdk.MobPushNotifyMessage r35, int r36) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.l.a(com.mob.pushsdk.MobPushNotifyMessage, int):void");
    }

    private Notification a(long j, String str, String str2, String str3, PendingIntent pendingIntent, int i, String str4, String[] strArr, boolean z, boolean z2, boolean z3, PendingIntent pendingIntent2, String str5, MobPushNotifyMessage mobPushNotifyMessage) {
        String androidChannelId = mobPushNotifyMessage.getAndroidChannelId();
        String imagePath = mobPushNotifyMessage.getImagePath();
        String iconPath = mobPushNotifyMessage.getIconPath();
        Notification.Builder builderC = c(androidChannelId);
        if (Build.VERSION.SDK_INT < 26) {
            if (z && z2 && z3) {
                if (b(str5)) {
                    builderC.setDefaults(6);
                    a(builderC, str5);
                } else {
                    builderC.setDefaults(7);
                }
            } else if (z && z2) {
                if (b(str5)) {
                    builderC.setDefaults(2);
                    a(builderC, str5);
                } else {
                    builderC.setDefaults(3);
                }
            } else if (z && z3) {
                if (b(str5)) {
                    builderC.setDefaults(4);
                    a(builderC, str5);
                } else {
                    builderC.setDefaults(5);
                }
            } else if (z2 && z3) {
                builderC.setDefaults(6);
            } else if (z) {
                if (b(str5)) {
                    a(builderC, str5);
                } else {
                    builderC.setDefaults(1);
                }
            } else if (z2) {
                builderC.setDefaults(2);
            } else if (z3) {
                builderC.setDefaults(4);
            } else {
                builderC.setLights(0, 0, 0);
                builderC.setSound(null);
                builderC.setVibrate(null);
            }
        }
        builderC.setTicker(str);
        PLog.getInstance().d("NotifyManager getDefaultNotify icon:" + this.b + ",largeIcon:" + this.c, new Object[0]);
        String icon = mobPushNotifyMessage.getIcon();
        if (!TextUtils.isEmpty(iconPath)) {
            try {
                builderC.setSmallIcon(Icon.createWithBitmap(BitmapHelper.getBitmap(iconPath)));
            } catch (Throwable th) {
                PLog.getInstance().e(th);
            }
        } else if (!TextUtils.isEmpty(icon) && !icon.startsWith("http://") && !icon.startsWith("https://")) {
            int rawRes = ResHelper.getRawRes(MobSDK.getContext(), icon);
            if (rawRes < 1) {
                rawRes = ResHelper.getBitmapRes(MobSDK.getContext(), icon);
            }
            builderC.setSmallIcon(rawRes);
        } else {
            int i2 = this.b;
            if (i2 < 1) {
                try {
                    Drawable applicationIcon = MobSDK.getContext().getPackageManager().getApplicationIcon(MobSDK.getContext().getPackageName());
                    if (applicationIcon != null) {
                        builderC.setSmallIcon(Icon.createWithBitmap(com.mob.pushsdk.b.a.a(applicationIcon)));
                    }
                } catch (Throwable th2) {
                    PLog.getInstance().e(th2);
                }
            } else {
                builderC.setSmallIcon(i2);
            }
        }
        if (!TextUtils.isEmpty(imagePath)) {
            builderC.setLargeIcon(BitmapFactory.decodeFile(imagePath));
        } else if (this.c > 0) {
            builderC.setLargeIcon(BitmapFactory.decodeResource(MobSDK.getContext().getResources(), this.c));
        } else {
            PLog.getInstance().d("no bigIcon", new Object[0]);
        }
        CharSequence charSequence = TextUtils.isEmpty(str2) ? this.d : str2;
        builderC.setContentTitle(charSequence);
        builderC.setContentText(str3);
        builderC.setWhen(j);
        builderC.setColor(0);
        try {
            if (!TextUtils.isEmpty(mobPushNotifyMessage.getIconColor())) {
                builderC.setColor(Color.parseColor(mobPushNotifyMessage.getIconColor()));
            }
        } catch (Throwable th3) {
            PLog.getInstance().d(th3);
        }
        builderC.setContentIntent(pendingIntent);
        builderC.setDeleteIntent(pendingIntent2);
        builderC.setAutoCancel(true);
        if (i == 1) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(charSequence).bigText(str4);
            builderC.setStyle(bigTextStyle);
        } else if (i == 3) {
            Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
            inboxStyle.setBigContentTitle(charSequence);
            if (strArr != null && strArr.length > 0) {
                for (String str6 : strArr) {
                    if (str6 == null) {
                        str6 = "";
                    }
                    inboxStyle.addLine(str6);
                }
            }
            builderC.setStyle(inboxStyle);
        } else if (i == 2) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str4);
            PLog.getInstance().d("NotifyManager notify image bitmap = " + bitmapDecodeFile + ", path = " + str3, new Object[0]);
            if (bitmapDecodeFile != null) {
                bigPictureStyle.setBigContentTitle(charSequence).bigPicture(bitmapDecodeFile);
            }
            builderC.setStyle(bigPictureStyle);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            builderC.setBadgeIconType(1);
        }
        return a(builderC);
    }

    private void a(Notification.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setSound(Uri.parse("android.resource://" + MobSDK.getContext().getPackageName() + "/raw/" + str));
    }

    private Notification a(Notification.Builder builder) {
        return builder.build();
    }

    public void a(String str, int i) {
        NotificationManager notificationManager = this.f17699e;
        if (notificationManager != null) {
            notificationManager.cancel(str, i);
        }
    }
}
