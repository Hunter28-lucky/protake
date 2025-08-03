package com.mob.pushsdk.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class g implements com.mob.pushsdk.MobPushReceiver {
    private com.mob.pushsdk.MobPushReceiver a;

    public boolean a() {
        return (this.a == null || com.mob.pushsdk.biz.d.h()) ? false : true;
    }

    @Override // com.mob.pushsdk.MobPushReceiver
    public void onAliasCallback(Context context, String str, int i, int i2) {
        this.a.onAliasCallback(context, str, i, i2);
    }

    @Override // com.mob.pushsdk.MobPushReceiver
    public void onCustomMessageReceive(Context context, MobPushCustomMessage mobPushCustomMessage) {
        this.a.onCustomMessageReceive(context, mobPushCustomMessage);
    }

    @Override // com.mob.pushsdk.MobPushReceiver
    public void onNotifyMessageOpenedReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            return;
        }
        HashMap<String, String> extrasMap = mobPushNotifyMessage.getExtrasMap();
        if (extrasMap != null && extrasMap.containsKey("awMobKeyFlag") && "1".equals(extrasMap.get("awMobKeyFlag"))) {
            return;
        }
        this.a.onNotifyMessageOpenedReceive(context, mobPushNotifyMessage);
    }

    @Override // com.mob.pushsdk.MobPushReceiver
    public void onNotifyMessageReceive(Context context, MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            return;
        }
        HashMap<String, String> extrasMap = mobPushNotifyMessage.getExtrasMap();
        if (extrasMap != null && extrasMap.containsKey("awMobKeyFlag") && "1".equals(extrasMap.get("awMobKeyFlag"))) {
            return;
        }
        this.a.onNotifyMessageReceive(context, mobPushNotifyMessage);
    }

    @Override // com.mob.pushsdk.MobPushReceiver
    public void onTagsCallback(Context context, String[] strArr, int i, int i2) {
        this.a.onTagsCallback(context, strArr, i, i2);
    }

    public final void a(Context context, Intent intent) {
        try {
            boolean zH = com.mob.pushsdk.biz.d.h();
            PLog.getInstance().d("onReceive action: " + intent.getAction() + ", extras = " + intent.getExtras() + ", isPushStopped = " + zH, new Object[0]);
            if (this.a != null && !zH) {
                String action = intent.getAction();
                Bundle extras = intent.getExtras();
                if ("com.mob.push.intent.MESSAGE_RECEIVED".equals(action)) {
                    MobPushCustomMessage mobPushCustomMessage = (MobPushCustomMessage) ResHelper.forceCast(extras.getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
                    if (mobPushCustomMessage != null) {
                        onCustomMessageReceive(context, mobPushCustomMessage);
                    }
                } else if ("com.mob.push.intent.NOTIFICATION_RECEIVED".equals(action)) {
                    MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) ResHelper.forceCast(extras.getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
                    if (mobPushNotifyMessage != null) {
                        onNotifyMessageReceive(context, mobPushNotifyMessage);
                    }
                } else if ("com.mob.push.intent.NOTIFICATION_OPENED".equals(action)) {
                    MobPushNotifyMessage mobPushNotifyMessage2 = (MobPushNotifyMessage) ResHelper.forceCast(extras.getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
                    if (mobPushNotifyMessage2 != null) {
                        onNotifyMessageOpenedReceive(context, mobPushNotifyMessage2);
                    }
                } else {
                    int i = -1;
                    if ("com.mob.push.intent.OPERATE_TAGS".equals(action)) {
                        String[] stringArray = extras.getStringArray("tags");
                        int i2 = extras.getInt("operation");
                        boolean z = extras.getBoolean("result");
                        int i3 = extras.getInt("errorCode", 0);
                        if (z || i3 != 0) {
                            i = i3;
                        }
                        onTagsCallback(context, stringArray, i2, i);
                    } else if ("com.mob.push.intent.OPERATE_ALIAS".equals(action)) {
                        String string = extras.getString("alias");
                        int i4 = extras.getInt("operation");
                        boolean z2 = extras.getBoolean("result");
                        int i5 = extras.getInt("errorCode", 0);
                        if (z2 || i5 != 0) {
                            i = i5;
                        }
                        onAliasCallback(context, string, i4, i);
                    }
                }
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public void a(com.mob.pushsdk.MobPushReceiver mobPushReceiver) {
        this.a = mobPushReceiver;
    }
}
