package com.mob.pushsdk;

import android.content.Context;

/* loaded from: classes2.dex */
public interface MobPushReceiver {
    void onAliasCallback(Context context, String str, int i, int i2);

    void onCustomMessageReceive(Context context, MobPushCustomMessage mobPushCustomMessage);

    void onNotifyMessageOpenedReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage);

    void onNotifyMessageReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage);

    void onTagsCallback(Context context, String[] strArr, int i, int i2);
}
