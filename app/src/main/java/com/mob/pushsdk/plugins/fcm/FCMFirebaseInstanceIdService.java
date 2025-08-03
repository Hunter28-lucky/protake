package com.mob.pushsdk.plugins.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class FCMFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        try {
            String token = FirebaseInstanceId.getInstance().getToken();
            PLog.getInstance().d("MobPush-FCM token: " + token, new Object[0]);
            com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
            if (aVarB == null || !(aVarB instanceof b)) {
                return;
            }
            a.a().doPluginRecevier(MobSDK.getContext(), 2, token);
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-FCM: In InstanceId getToken error " + th.getMessage(), new Object[0]);
        }
    }
}
