package com.mob.pushsdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.mob.tools.proguard.ClassKeeper;

/* loaded from: classes2.dex */
public abstract class MobPushTailorNotification implements ClassKeeper {
    public Notification getNotification(Context context, NotificationManager notificationManager, MobPushNotifyMessage mobPushNotifyMessage) {
        return null;
    }
}
