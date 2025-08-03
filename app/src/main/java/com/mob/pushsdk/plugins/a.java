package com.mob.pushsdk.plugins;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;

/* loaded from: classes2.dex */
public abstract class a {
    public String appId = "";
    public String appKey = "";
    public Context context = MobSDK.getContext();

    public a() {
        d.a().a("[" + getName() + "] channel start init");
    }

    public abstract void addTags(String str);

    public void cancelAllNotification() {
        d.a().c("[" + getName() + "] channel does not support the cancelAllNotification API.");
    }

    public void cancelNotificationById(String str, int i) {
        d.a().c("[" + getName() + "] channel does not support the cancelNotificationById API.");
    }

    public abstract void cleanTags(String... strArr);

    public void debugPluginRegId(String str) {
        d.a().a("[" + getName() + "] channel regId: " + str);
    }

    public abstract void deleteAlias(String... strArr);

    public abstract void deleteTags(String str);

    public abstract void getAlias();

    public void getConfigFromManifest(String str, String str2) {
        Bundle bundle;
        try {
            bundle = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 128).applicationInfo.metaData;
        } catch (Throwable th) {
            th.printStackTrace();
            PLog.getInstance().d(th);
            bundle = null;
        }
        if (TextUtils.isEmpty(this.appId) && bundle != null) {
            String strValueOf = bundle.get(str) == null ? null : String.valueOf(bundle.get(str));
            this.appId = strValueOf;
            if (!TextUtils.isEmpty(strValueOf) && this.appId.endsWith("/")) {
                String str3 = this.appId;
                this.appId = str3.substring(0, str3.indexOf("/"));
            }
        }
        if (TextUtils.isEmpty(this.appKey) && bundle != null) {
            String strValueOf2 = bundle.get(str2) != null ? String.valueOf(bundle.get(str2)) : null;
            this.appKey = strValueOf2;
            if (!TextUtils.isEmpty(strValueOf2) && this.appKey.endsWith("/")) {
                String str4 = this.appKey;
                this.appKey = str4.substring(0, str4.indexOf(47));
            }
        }
        d.a().a("Check push channel [" + getName() + "] configuration information, appId:" + this.appId + ", appKey:" + this.appKey);
    }

    public abstract String getName();

    public abstract void getRegistrationId(MobPushCallback<String> mobPushCallback);

    public abstract void getTags();

    public abstract boolean isPushStopped();

    public abstract boolean isSupport();

    public abstract void pluginsInit();

    public abstract void restartPush();

    public abstract void setAlias(String str);

    public abstract void setReceiveNormalMsg(boolean z);

    public abstract void setReceiveNotifyMsg(boolean z);

    public abstract void setSilenceTime(int i, int i2, int i3, int i4);

    public abstract void stopPush();

    public abstract void unRegistrationId();
}
