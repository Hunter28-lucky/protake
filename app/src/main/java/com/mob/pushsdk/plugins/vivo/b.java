package com.mob.pushsdk.plugins.vivo;

import android.os.Bundle;
import android.text.TextUtils;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.b.h;
import com.mob.pushsdk.b.j;
import com.mob.pushsdk.base.PLog;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.util.VivoPushException;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class b extends com.mob.pushsdk.plugins.a {
    private h a;
    private PushClient b;

    public b() {
        PLog.getInstance().d("MobPush-Vivo plugins initing", new Object[0]);
        this.a = h.a();
        try {
            PushClient pushClient = PushClient.getInstance(this.context);
            this.b = pushClient;
            pushClient.checkManifest();
            restartPush();
        } catch (VivoPushException e2) {
            PLog.getInstance().e("MobPush-Vivo: vivo channel manifest error code:" + e2.getCode() + ", reason: " + e2.getMessage(), new Object[0]);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void addTags(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String[] strArrB = j.b(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (final int i = 0; i < strArrB.length; i++) {
            final String str2 = strArrB[i];
            this.b.setTopic(str2, new IPushActionListener() { // from class: com.mob.pushsdk.plugins.vivo.b.4
                public void onStateChanged(int i2) {
                    PLog.getInstance().d("MobPush-Vivo: vivo channel set Tag [" + str2 + "] result code " + i2, new Object[0]);
                    if (i == strArrB.length - 1) {
                        if (i2 == 0 || i2 == 1) {
                            Bundle bundle = new Bundle();
                            bundle.putString("operation", "tags");
                            bundle.putBoolean("result", true);
                            a.a().doPluginRecevier(b.this.context, 5, bundle);
                        }
                    }
                }
            });
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cleanTags(final String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (final int i = 0; i < strArr.length; i++) {
            final String str = strArr[i];
            this.b.delTopic(str, new IPushActionListener() { // from class: com.mob.pushsdk.plugins.vivo.b.6
                public void onStateChanged(int i2) {
                    PLog.getInstance().d("MobPush-Vivo: vivo channel delete Tag [" + str + "] result code " + i2, new Object[0]);
                    if (i == strArr.length - 1) {
                        if (i2 == 0 || i2 == 1) {
                            Bundle bundle = new Bundle();
                            bundle.putString("operation", "tags");
                            bundle.putBoolean("result", true);
                            a.a().doPluginRecevier(b.this.context, 5, bundle);
                        }
                    }
                }
            });
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteAlias(String... strArr) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void deleteTags(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String[] strArrB = j.b(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        for (final int i = 0; i < strArrB.length; i++) {
            final String str2 = strArrB[i];
            this.b.delTopic(str2, new IPushActionListener() { // from class: com.mob.pushsdk.plugins.vivo.b.5
                public void onStateChanged(int i2) {
                    PLog.getInstance().d("MobPush-Vivo: vivo channel delete Tag [" + str2 + "] result code " + i2, new Object[0]);
                    if (i == strArrB.length - 1) {
                        if (i2 == 0 || i2 == 1) {
                            Bundle bundle = new Bundle();
                            bundle.putString("operation", "tags");
                            bundle.putBoolean("result", true);
                            a.a().doPluginRecevier(b.this.context, 5, bundle);
                        }
                    }
                }
            });
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getAlias() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public String getName() {
        return "VIVO";
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(final MobPushCallback<String> mobPushCallback) {
        new Thread(new Runnable() { // from class: com.mob.pushsdk.plugins.vivo.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String regId = b.this.b.getRegId();
                    b.this.debugPluginRegId(regId);
                    if (TextUtils.isEmpty(regId)) {
                        return;
                    }
                    a.a().doPluginRecevier(b.this.context, 2, regId);
                    MobPushCallback mobPushCallback2 = mobPushCallback;
                    if (mobPushCallback2 != null) {
                        mobPushCallback2.onCallback(regId);
                    }
                } catch (Throwable th) {
                    d.a().d(th.toString());
                }
            }
        }).start();
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
            PushClient.getInstance(this.context).checkManifest();
            return PushClient.getInstance(this.context).isSupport();
        } catch (Throwable th) {
            PLog.getInstance().e("MobPush: check support vivo error:" + th.getMessage(), new Object[0]);
            return false;
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        if (this.a.d()) {
            this.b.initialize();
            getRegistrationId(null);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
        this.b.turnOnPush(new IPushActionListener() { // from class: com.mob.pushsdk.plugins.vivo.b.3
            public void onStateChanged(int i) {
                PLog.getInstance().d("MobPush-Vivo: vivo channel restart push result code " + i, new Object[0]);
            }
        });
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
        this.b.turnOffPush(new IPushActionListener() { // from class: com.mob.pushsdk.plugins.vivo.b.2
            public void onStateChanged(int i) {
                PLog.getInstance().d("MobPush-Vivo: vivo channel stop push result code " + i, new Object[0]);
            }
        });
    }

    @Override // com.mob.pushsdk.plugins.a
    public void unRegistrationId() {
    }
}
