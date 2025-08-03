package com.mob.pushsdk.plugins.fcm;

import android.text.TextUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mob.MobSDK;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.b.f;
import com.mob.pushsdk.b.k;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.Hashon;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class FCMFirebaseMessagingService extends FirebaseMessagingService {
    public void onDeletedMessages() {
        PLog.getInstance().d("MobPush-FCM onDeletedMessages", new Object[0]);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage == null || remoteMessage.getNotification() == null) {
            return;
        }
        PLog.getInstance().d("MobPush-FCM onMessageReceived: " + new Hashon().fromObject(remoteMessage), new Object[0]);
        a.a().doPluginRecevier(MobSDK.getContext(), 1, remoteMessage);
    }

    public void onMessageSent(String str) {
        PLog.getInstance().d("MobPush-FCM onMessageSent:" + str, new Object[0]);
    }

    public void onNewToken(final String str) {
        d.a().a("MobPush-FCM onNewToken");
        PLog.getInstance().d("MobPush-FCM token: " + str, new Object[0]);
        k.b(new k.a() { // from class: com.mob.pushsdk.plugins.fcm.FCMFirebaseMessagingService.1
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                d.a().a("MobPush-FCM wait auth...");
                if (!com.mob.pushsdk.impl.a.a(500, Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 30, false)) {
                    d.a().a("MobPush-FCM auth failed...");
                    return;
                }
                d.a().a("MobPush-FCM auth success...");
                com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
                if (!f.b(aVarB) || !(aVarB instanceof b) || TextUtils.isEmpty(str)) {
                    d.a().a("[FCM] channel register failure.");
                } else {
                    d.a().a("[FCM] channel register successful.");
                    a.a().doPluginRecevier(MobSDK.getContext(), 2, str);
                }
            }
        });
    }

    public void onSendError(String str, Exception exc) {
        PLog.getInstance().d("MobPush-FCM onSendError:" + str + ",Exception:" + exc.getMessage(), new Object[0]);
    }
}
