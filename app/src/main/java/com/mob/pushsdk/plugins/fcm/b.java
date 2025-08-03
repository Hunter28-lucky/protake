package com.mob.pushsdk.plugins.fcm;

import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.MobPushException;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class b extends com.mob.pushsdk.plugins.a {
    public b() {
        PLog.getInstance().d("Mob-FCM plugins initing", new Object[0]);
    }

    private void b(final MobPushCallback<String> mobPushCallback) {
        try {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.mob.pushsdk.plugins.fcm.b.2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<String> task) {
                    if (task.isSuccessful()) {
                        b.this.a(task.getResult(), mobPushCallback);
                        return;
                    }
                    PLog.getInstance().d("MobPush-FCM: getToken failed:" + task.getException(), new Object[0]);
                }
            });
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-FCM: get fcm token error:" + th.getMessage(), new Object[0]);
            d.a().c("[FCM] channel register failure, error:" + th.getMessage());
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void addTags(String str) {
        try {
            String[] strArrSplit = str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? str.split(Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
            if (strArrSplit == null && !TextUtils.isEmpty(str)) {
                strArrSplit = new String[]{str};
            }
            for (String str2 : strArrSplit) {
                try {
                    FirebaseMessaging.getInstance().subscribeToTopic(str2);
                } catch (IllegalArgumentException unused) {
                    throw new MobPushException(MobPushException.MobPushError.INVALIDFCMTAGS);
                }
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void cleanTags(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String[] strArrSplit = null;
        if (strArr.length == 1 && strArr[0].contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            strArrSplit = strArr[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (strArrSplit == null) {
            return;
        }
        for (String str : strArrSplit) {
            deleteTags(str);
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
        String[] strArrSplit = str.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) ? str.split(Constants.ACCEPT_TIME_SEPARATOR_SP) : null;
        if (strArrSplit == null) {
            strArrSplit = new String[]{str};
        }
        for (String str2 : strArrSplit) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(str2);
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getAlias() {
    }

    @Override // com.mob.pushsdk.plugins.a
    public String getName() {
        return "FCM";
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        try {
            if (a()) {
                a(mobPushCallback);
            } else {
                b(mobPushCallback);
            }
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-FCM: get fcm token error:" + th.getMessage(), new Object[0]);
            d.a().c("[FCM] channel register failure, error:" + th.getMessage());
        }
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
            return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.context) == 0;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return false;
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        FirebaseApp.initializeApp(this.context);
        getRegistrationId(null);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
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
    }

    @Override // com.mob.pushsdk.plugins.a
    public void unRegistrationId() {
    }

    private boolean a() {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceId");
            return true;
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return false;
        }
    }

    private void a(final MobPushCallback<String> mobPushCallback) {
        try {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() { // from class: com.mob.pushsdk.plugins.fcm.b.1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<InstanceIdResult> task) {
                    if (task.isSuccessful()) {
                        b.this.a(task.getResult().getToken(), mobPushCallback);
                        return;
                    }
                    PLog.getInstance().d("MobPush-FCM: getInstanceId failed:" + task.getException(), new Object[0]);
                }
            });
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-FCM: get fcm getInstanceId error:" + th.getMessage(), new Object[0]);
            d.a().c("[FCM] channel register failure, error:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MobPushCallback<String> mobPushCallback) {
        debugPluginRegId(str);
        if (mobPushCallback != null) {
            mobPushCallback.onCallback(str);
        }
        if (!TextUtils.isEmpty(str)) {
            d.a().a("[FCM] channel register successful.");
            a.a().doPluginRecevier(this.context, 2, str);
        } else {
            d.a().c("[FCM] channel register failure.");
        }
    }
}
