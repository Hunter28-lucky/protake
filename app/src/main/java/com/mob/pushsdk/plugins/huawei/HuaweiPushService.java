package com.mob.pushsdk.plugins.huawei;

import android.text.TextUtils;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.mob.MobSDK;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public class HuaweiPushService extends HmsMessageService {
    private void a(String str) {
        c.a().doPluginRecevier(MobSDK.getContext(), 2, str);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        PLog.getInstance().d("MobPush HUAWEI onMessageReceived:" + remoteMessage.toString(), new Object[0]);
    }

    public void onMessageSent(String str) {
        PLog.getInstance().d("MobPush HUAWEI onMessageSent:" + str, new Object[0]);
    }

    public void onNewToken(String str) {
        PLog.getInstance().d("MobPush HUAWEI received refresh token:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str);
    }

    public void onSendError(String str, Exception exc) {
        PLog.getInstance().d("MobPush HUAWEI onSendError msgid:" + str + ",Exception:" + exc, new Object[0]);
    }

    public void onTokenError(Exception exc) {
        super.onTokenError(exc);
        com.mob.pushsdk.b.d.a().d("[HUAWEI] onTokenError Exception:" + exc);
    }
}
