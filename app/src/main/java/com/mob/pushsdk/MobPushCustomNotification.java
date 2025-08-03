package com.mob.pushsdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

@Deprecated
/* loaded from: classes2.dex */
public interface MobPushCustomNotification {
    Notification getNotification(Context context, NotificationManager notificationManager, long j, String str, String str2, String str3, int i, int i2, String str4, String[] strArr, boolean z, boolean z2, boolean z3);
}
