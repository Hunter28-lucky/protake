package com.mob.pushsdk;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class MobPushLocalNotification extends MobPushNotifyMessage {
    private int notificationId;

    public MobPushLocalNotification() {
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }

    public MobPushLocalNotification(int i, String str, String str2, String str3, String[] strArr, HashMap<String, String> map, String str4, long j, boolean z, boolean z2, boolean z3) {
        super(i, str, str2, str3, strArr, map, str4, j, z, z2, z3);
    }
}
