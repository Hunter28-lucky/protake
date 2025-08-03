package com.mob.pushsdk.plugins.xiaomi;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.b.j;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.a.c;
import com.mob.pushsdk.plugins.a.e;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;

/* loaded from: classes2.dex */
public class b extends com.mob.pushsdk.plugins.a {
    private h a;
    private Context b = MobSDK.getContext();

    public b() {
        PLog.getInstance().d("Mob-XIAOMI plugins initing", new Object[0]);
        this.a = h.a();
        getConfigFromManifest("com.mob.push.xiaomi.appid", "com.mob.push.xiaomi.appkey");
    }

    @Override // com.mob.pushsdk.plugins.a
    public void addTags(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            MiPushClient.subscribe(this.b, str, null);
            return;
        }
        String[] strArrB = j.b(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (strArrB == null || strArrB.length <= 0) {
            return;
        }
        for (String str2 : strArrB) {
            MiPushClient.subscribe(this.b, str2, null);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cancelAllNotification() {
        MiPushClient.clearNotification(MobSDK.getContext());
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cancelNotificationById(String str, int i) {
        MiPushClient.clearNotification(MobSDK.getContext(), i);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cleanTags(String... strArr) {
        List<String> allTopic = MiPushClient.getAllTopic(this.b);
        if (allTopic == null || allTopic.size() <= 0) {
            e.a().a(true, (List<String>) null);
            return;
        }
        for (int i = 0; i < allTopic.size(); i++) {
            MiPushClient.unsubscribe(this.b, allTopic.get(i), null);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteAlias(String... strArr) {
        List<String> allAlias = MiPushClient.getAllAlias(this.b);
        if (allAlias == null || allAlias.size() <= 0) {
            c.a().a(true, (List<String>) null);
            return;
        }
        for (int i = 0; i < allAlias.size(); i++) {
            MiPushClient.unsetAlias(this.b, allAlias.get(i), null);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteTags(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            MiPushClient.unsubscribe(this.b, str, null);
            return;
        }
        String[] strArrB = j.b(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (strArrB == null || strArrB.length <= 0) {
            return;
        }
        for (String str2 : strArrB) {
            MiPushClient.unsubscribe(this.b, str2, null);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getAlias() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getConfigFromManifest(String str, String str2) {
        super.getConfigFromManifest(str, str2);
    }

    @Override // com.mob.pushsdk.plugins.a
    public String getName() {
        return "XIAOMI";
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        String regId = MiPushClient.getRegId(this.b);
        debugPluginRegId(regId);
        if (TextUtils.isEmpty(regId)) {
            return;
        }
        mobPushCallback.onCallback(regId);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getTags() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isPushStopped() {
        return true;
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isSupport() {
        return true;
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        if (this.a.d()) {
            MiPushClient.registerPush(this.b, this.appId, this.appKey);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
        MiPushClient.resumePush(this.b, null);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setAlias(String str) {
        MiPushClient.setAlias(this.b, str, null);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNormalMsg(boolean z) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNotifyMsg(boolean z) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setSilenceTime(int i, int i2, int i3, int i4) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void stopPush() {
        MiPushClient.pausePush(this.b, null);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void unRegistrationId() {
        MiPushClient.unregisterPush(this.b);
    }
}
