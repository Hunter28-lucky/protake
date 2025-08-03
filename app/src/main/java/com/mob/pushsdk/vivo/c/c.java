package com.mob.pushsdk.vivo.c;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;

/* loaded from: classes2.dex */
public class c {
    private static NotificationManager a = null;
    private static int b = 20000000;

    public static void a() {
        a(b);
    }

    private static synchronized void b() {
        NotificationManager notificationManager;
        try {
            if (a == null) {
                a = (NotificationManager) MobSDK.getContext().getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = a) != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("default");
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if ("推送通知".equals(name) || "PUSH".equals(name)) {
                        a.deleteNotificationChannel("default");
                    }
                }
                NotificationChannel notificationChannel2 = a.getNotificationChannel("vivo_push_channel");
                d dVarA = d.a();
                StringBuilder sb = new StringBuilder();
                sb.append("initAdapter PRIMARY_CHANNEL yi exist ？= ");
                sb.append(notificationChannel2 == null);
                dVarA.a(sb.toString(), new Object[0]);
                if (notificationChannel2 == null) {
                    NotificationChannel notificationChannel3 = new NotificationChannel("vivo_push_channel", DH.SyncMtd.getOSLanguage().endsWith("zh") ? "推送通知" : "PUSH", 4);
                    notificationChannel3.setLightColor(-16711936);
                    notificationChannel3.enableVibration(true);
                    notificationChannel3.setLockscreenVisibility(1);
                    a.createNotificationChannel(notificationChannel3);
                }
            }
        } finally {
        }
    }

    private static void a(int i) {
        b();
        NotificationManager notificationManager = a;
        if (notificationManager == null) {
            return;
        }
        notificationManager.cancel(i);
    }
}
