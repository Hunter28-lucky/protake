package com.mob.pushsdk.plugins.meizu;

import android.content.Context;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.log.NLog;

/* loaded from: classes2.dex */
public class PushMeiZuRevicer extends MzPushMessageReceiver {
    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        PLog.getInstance().d("Mob-MEIZU Arrived extras:" + mzPushMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 1, mzPushMessage);
    }

    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
        PLog.getInstance().d("Mob-MEIZU Clicked extras:" + mzPushMessage.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 0, mzPushMessage);
    }

    public void onNotifyMessageArrived(Context context, String str) {
        super.onNotifyMessageArrived(context, str);
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        PLog.getInstance().d("MobPush-MEIZU onPushStatus: " + pushSwitchStatus.toString(), new Object[0]);
    }

    public void onRegister(Context context, String str) {
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        NLog pLog = PLog.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("MobPush-MEIZU onRegisterStatus: ");
        sb.append(registerStatus);
        pLog.d(sb.toString() == null ? null : registerStatus.toString(), new Object[0]);
        if (registerStatus == null || !"200".equals(registerStatus.getCode())) {
            return;
        }
        a.a().doPluginRecevier(context, 2, registerStatus);
    }

    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
        PLog.getInstance().d("MobPush-MEIZU SubAliasStatus: " + subAliasStatus.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 4, subAliasStatus);
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
        PLog.getInstance().d("MobPush-MEIZU SubTagsStatus: " + subTagsStatus.toString(), new Object[0]);
        a.a().doPluginRecevier(context, 5, subTagsStatus);
    }

    public void onUnRegister(Context context, boolean z) {
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
        PLog.getInstance().d("MobPush-MEIZU onUnRegisterStatus: " + unRegisterStatus.toString(), new Object[0]);
    }
}
