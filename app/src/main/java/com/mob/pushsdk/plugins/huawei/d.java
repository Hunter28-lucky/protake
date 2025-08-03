package com.mob.pushsdk.plugins.huawei;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.biz.PushErrorCode;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class d extends com.mob.pushsdk.plugins.a {
    public String a = null;
    private HuaweiApiClient b;

    public d() {
        PLog.getInstance().d("Mob-HUAWEI plugins initing", new Object[0]);
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
        return PushHuaWeiCompat.NAME;
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        if (!this.b.isConnected()) {
            this.b.connect((Activity) null);
            return;
        }
        try {
            new Thread(new Runnable() { // from class: com.mob.pushsdk.plugins.huawei.d.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String string = AGConnectServicesConfig.fromContext(d.this.context).getString("client/app_id");
                        com.mob.pushsdk.b.d.a().a("[HUAWEI] channel appId==" + string);
                        String token = HmsInstanceId.getInstance(d.this.context).getToken(string, "HCM");
                        com.mob.pushsdk.b.d.a().a("[HUAWEI] channel token==" + token);
                        if (TextUtils.isEmpty(token)) {
                            return;
                        }
                        c.a().doPluginRecevier(MobSDK.getContext(), 2, token);
                    } catch (ApiException e2) {
                        com.mob.pushsdk.b.d.a().d("[HUAWEI] channel error==" + e2);
                    }
                }
            }).start();
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-HUAWEI: getToken HuaweiPushApi error: " + th, new Object[0]);
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
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            int iIntValue = packageInfo != null ? Integer.valueOf(((String) packageInfo.versionName.subSequence(0, 5)).replace(".", "")).intValue() : 0;
            PLog.getInstance().d("MobPush-HuaWei com.huawei.hwid versionName: " + iIntValue, new Object[0]);
            if (iIntValue > 253) {
                return true;
            }
            PLog.getInstance().i("MobPush-HuaWei: HMS version is too low ", new Object[0]);
            return false;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return true;
        }
    }

    @Override // com.mob.pushsdk.plugins.a
    public void pluginsInit() {
        HuaweiApiClient huaweiApiClientBuild = new HuaweiApiClient.Builder(this.context).addApi(b.a).addConnectionCallbacks(new HuaweiApiClient.ConnectionCallbacks() { // from class: com.mob.pushsdk.plugins.huawei.d.2
            public void onConnected() {
                com.mob.pushsdk.b.d.a().a("[HUAWEI] channel connection successful.");
                d.this.getRegistrationId(null);
            }

            public void onConnectionSuspended(int i) {
                PLog.getInstance().d("MobPush HuaweiApiClient connection suspended, Reconnecting...  " + i, new Object[0]);
                if (d.this.b != null) {
                    d.this.b.connect((Activity) null);
                }
            }
        }).addOnConnectionFailedListener(new HuaweiApiClient.OnConnectionFailedListener() { // from class: com.mob.pushsdk.plugins.huawei.d.1
            public void onConnectionFailed(ConnectionResult connectionResult) {
                try {
                    if (HuaweiApiAvailability.getInstance().isUserResolvableError(connectionResult.getErrorCode())) {
                        final int errorCode = connectionResult.getErrorCode();
                        new Handler(d.this.context.getMainLooper()).post(new Runnable() { // from class: com.mob.pushsdk.plugins.huawei.d.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Intent intent = new Intent();
                                intent.putExtra("errorCode", errorCode);
                                new a().show(d.this.context, intent);
                            }
                        });
                    }
                    com.mob.pushsdk.b.d.a().a("[HUAWEI] channel connection failure, errorCode: " + connectionResult.getErrorCode());
                    int stringRes = ResHelper.getStringRes(d.this.context, PushErrorCode.valueOf((long) connectionResult.getErrorCode()).getMsgRes());
                    if (stringRes > 0) {
                        com.mob.pushsdk.b.d.a().a("[HUAWEI] channel connection failure, errorMessage:" + d.this.context.getString(stringRes));
                    }
                } catch (Throwable th) {
                    com.mob.pushsdk.b.d.a().a("[HUAWEI] channel connection failure, error: " + th.getMessage());
                }
            }
        }).build();
        this.b = huaweiApiClientBuild;
        huaweiApiClientBuild.connect((Activity) null);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void restartPush() {
        setReceiveNormalMsg(true);
        setReceiveNotifyMsg(true);
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setAlias(String str) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNormalMsg(boolean z) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNotifyMsg(final boolean z) {
        new Thread() { // from class: com.mob.pushsdk.plugins.huawei.d.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (z) {
                        HmsMessaging.getInstance(d.this.context).turnOnPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.mob.pushsdk.plugins.huawei.d.4.1
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    com.mob.pushsdk.b.d.a().a("[HUAWEI] setReceiveNotifyMsg true success");
                                } else {
                                    com.mob.pushsdk.b.d.a().a("[HUAWEI] setReceiveNotifyMsg true failed");
                                }
                            }
                        });
                    } else {
                        HmsMessaging.getInstance(d.this.context).turnOffPush().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.mob.pushsdk.plugins.huawei.d.4.2
                            public void onComplete(Task<Void> task) {
                                if (task.isSuccessful()) {
                                    com.mob.pushsdk.b.d.a().a("[HUAWEI] setReceiveNotifyMsg false success");
                                } else {
                                    com.mob.pushsdk.b.d.a().a("[HUAWEI] setReceiveNotifyMsg false failed");
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    PLog.getInstance().i("MobPush-HUAWEI: HuaweiPushApi enableReceiveNotifyMsg error:" + th, new Object[0]);
                }
            }
        }.start();
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setSilenceTime(int i, int i2, int i3, int i4) {
    }

    @Override // com.mob.pushsdk.plugins.a
    public void stopPush() {
        setReceiveNormalMsg(false);
        setReceiveNotifyMsg(false);
    }

    @Override // com.mob.pushsdk.plugins.a
    @Deprecated
    public void unRegistrationId() {
        if (isPushStopped()) {
            new Thread() { // from class: com.mob.pushsdk.plugins.huawei.d.5
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    PLog.getInstance().d("MobPush HuaweiApiClient delete token: " + d.this.a, new Object[0]);
                    try {
                        HmsInstanceId.getInstance(d.this.context).deleteToken(AGConnectServicesConfig.fromContext(d.this.context).getString("client/app_id"), "HCM");
                    } catch (Throwable th) {
                        PLog.getInstance().d("MobPush HuaweiApiClient HuaweiPushApi deleteToken error: " + th.getMessage(), new Object[0]);
                    }
                }
            }.start();
            return;
        }
        PLog.getInstance().d("MobPush HuaweiApiClient not surviving", new Object[0]);
        HuaweiApiClient huaweiApiClient = this.b;
        if (huaweiApiClient != null) {
            huaweiApiClient.disconnect();
        }
    }
}
