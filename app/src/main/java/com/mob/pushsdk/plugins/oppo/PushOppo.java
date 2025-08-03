package com.mob.pushsdk.plugins.oppo;

import android.text.TextUtils;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.a;
import defpackage.C3607;

/* loaded from: classes2.dex */
public class PushOppo extends a {
    private static final String KEY_NAME = "com.mob.push.oppo.appkey";
    public static final String NAME = "OPPO";
    private static final String SECRET_NAME = "com.mob.push.oppo.appsecret";
    private h helper;

    public PushOppo() {
        PLog.getInstance().d("MobPush-OPPO plugins initing", new Object[0]);
        this.helper = h.a();
        getConfigFromManifest(KEY_NAME, SECRET_NAME);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void addTags(String str) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cleanTags(String... strArr) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteAlias(String... strArr) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteTags(String str) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getAlias() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public String getName() {
        return NAME;
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        String strM11640 = C3607.m11640();
        debugPluginRegId(strM11640);
        if (TextUtils.isEmpty(strM11640)) {
            return;
        }
        mobPushCallback.onCallback(strM11640);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getTags() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isPushStopped() {
        return false;
    }

    @Override // com.mob.pushsdk.plugins.a
    public boolean isSupport() {
        try {
            C3607.m11642(this.context, true);
            return C3607.m11643();
        } catch (Throwable th) {
            d.a().d("MobPush: check support oppo error:" + th.getMessage());
            return false;
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        if (this.helper.d()) {
            try {
                C3607.m11646(this.context, this.appId, this.appKey, new OppoPushCallBack());
                d.a().a("[OPPO] channel getSDKVersion:" + C3607.m11641());
            } catch (Throwable th) {
                d.a().d(th.getMessage());
            }
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
        C3607.m11648();
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setAlias(String str) {
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
        C3607.m11644();
    }

    @Override // com.mob.pushsdk.plugins.a
    public void unRegistrationId() {
    }
}
