package com.mob.pushsdk.plugins.xiaomi;

import android.content.Context;
import com.mob.pushsdk.base.PLog;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/* loaded from: classes2.dex */
public class PushXiaoMiRevicer extends PushMessageReceiver {
    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        PLog.getInstance().d("MobPush-XIAOMI onCommandResult:" + miPushCommandMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 3, miPushCommandMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        PLog.getInstance().d("MobPush-XIAOMI Arrived extras:" + miPushMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 1, miPushMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        PLog.getInstance().d("MobPush-XIAOMI  Clicked extras:" + miPushMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 0, miPushMessage);
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        PLog.getInstance().d("MobPush-XIAOMI onReceiveRegisterResult:" + miPushCommandMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 2, miPushCommandMessage);
    }
}
