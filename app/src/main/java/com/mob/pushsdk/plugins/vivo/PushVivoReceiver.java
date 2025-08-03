package com.mob.pushsdk.plugins.vivo;

import android.content.Context;
import com.mob.pushsdk.base.PLog;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

/* loaded from: classes2.dex */
public class PushVivoReceiver extends OpenClientPushMessageReceiver {
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        PLog.getInstance().d("MobPush-Vivo: receiver notification clicked message: " + uPSNotificationMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 0, uPSNotificationMessage);
    }

    public void onReceiveRegId(Context context, String str) {
        PLog.getInstance().d("MobPush-Vivo: receiver regId: " + str, new Object[0]);
        a.a().doPluginRecevier(context, 2, str);
    }
}
