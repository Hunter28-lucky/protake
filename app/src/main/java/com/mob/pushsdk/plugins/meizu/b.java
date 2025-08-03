package com.mob.pushsdk.plugins.meizu;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.PushManager;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.b.j;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.meizu.c;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class b extends com.mob.pushsdk.plugins.a {
    private h a;
    private Context b = MobSDK.getContext();

    public b() {
        PLog.getInstance().d("MobPush-MEIZU plugins initing", new Object[0]);
        this.a = h.a();
        getConfigFromManifest("com.mob.push.meizu.appid", "com.mob.push.meizu.appkey");
    }

    private String a() {
        return PushManager.getPushId(this.b);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void addTags(String str) {
        if (!TextUtils.isEmpty(a())) {
            PushManager.subScribeTags(this.b, this.appId, this.appKey, a(), str);
        } else {
            a(str, 5, 1);
            pluginsInit();
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cancelAllNotification() {
        PushManager.clearNotification(MobSDK.getContext());
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cancelNotificationById(String str, int i) {
        PushManager.clearNotification(MobSDK.getContext(), new int[]{i});
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cleanTags(String... strArr) {
        if (!TextUtils.isEmpty(a())) {
            PushManager.unSubScribeAllTags(this.b, this.appId, this.appKey, a());
        } else {
            a(j.a(strArr, Constants.ACCEPT_TIME_SEPARATOR_SP), 5, 3);
            pluginsInit();
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteAlias(String... strArr) {
        if (TextUtils.isEmpty(a())) {
            a(j.a(strArr, Constants.ACCEPT_TIME_SEPARATOR_SP), 4, 2);
            pluginsInit();
        } else {
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            for (String str : strArr) {
                PushManager.unSubScribeAlias(this.b, this.appId, this.appKey, a(), str);
            }
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteTags(String str) {
        if (!TextUtils.isEmpty(a())) {
            PushManager.unSubScribeTags(this.b, this.appId, this.appKey, a(), str);
        } else {
            a(str, 5, 2);
            pluginsInit();
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
        return "MEIZU";
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        String pushId = PushManager.getPushId(this.b);
        debugPluginRegId(pushId);
        if (TextUtils.isEmpty(pushId)) {
            return;
        }
        mobPushCallback.onCallback(pushId);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getTags() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isPushStopped() {
        PushManager.checkPush(this.b, this.appId, this.appKey, a());
        return true;
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isSupport() {
        return true;
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        if (this.a.d()) {
            PushManager.register(this.b, this.appId, this.appKey);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
        PushManager.switchPush(this.b, this.appId, this.appKey, a(), 0, true);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setAlias(String str) {
        if (!TextUtils.isEmpty(a())) {
            PushManager.subScribeAlias(this.b, this.appId, this.appKey, a(), str);
        } else {
            a(str, 4, 1);
            pluginsInit();
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNormalMsg(boolean z) {
        PushManager.switchPush(this.b, this.appId, this.appKey, a(), 1, false);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNotifyMsg(boolean z) {
        PushManager.switchPush(this.b, this.appId, this.appKey, a(), 0, z);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setSilenceTime(int i, int i2, int i3, int i4) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void stopPush() {
        PushManager.switchPush(this.b, this.appId, this.appKey, a(), 0, false);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void unRegistrationId() {
        PushManager.unRegister(this.b, this.appId, this.appKey);
    }

    private void a(String str, int i, int i2) {
        c.a().a(new c.a(str, i, i2));
    }
}
