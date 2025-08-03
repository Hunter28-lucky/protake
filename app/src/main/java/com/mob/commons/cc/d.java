package com.mob.commons.cc;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/* loaded from: classes2.dex */
public class d implements r<NotificationManager> {
    @Override // com.mob.commons.cc.r
    public boolean a(NotificationManager notificationManager, Class<NotificationManager> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("createNotificationChannel".equals(str) && Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof NotificationChannel) {
                notificationManager.createNotificationChannel((NotificationChannel) obj);
                return true;
            }
        }
        if ("notify".equals(str)) {
            if (objArr.length == 2) {
                notificationManager.notify(((Integer) objArr[0]).intValue(), (Notification) objArr[1]);
                return true;
            }
            if (objArr.length == 3) {
                notificationManager.notify((String) objArr[0], ((Integer) objArr[1]).intValue(), (Notification) objArr[2]);
                return true;
            }
        } else {
            if ("deleteNotificationChannel".equals(str) && Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
                notificationManager.deleteNotificationChannel((String) objArr[0]);
                return true;
            }
            if ("cancel".equals(str)) {
                if (objArr.length == 1) {
                    notificationManager.cancel(((Integer) objArr[0]).intValue());
                    return true;
                }
                if (objArr.length == 2) {
                    notificationManager.cancel((String) objArr[0], ((Integer) objArr[1]).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
