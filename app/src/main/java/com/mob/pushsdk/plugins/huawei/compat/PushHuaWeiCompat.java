package com.mob.pushsdk.plugins.huawei.compat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.push.HuaweiPush;
import com.huawei.hms.support.api.push.HuaweiPushApiImp;
import com.huawei.hms.support.api.push.TokenResult;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.biz.PushErrorCode;
import com.mob.pushsdk.plugins.a;
import com.mob.tools.proguard.ClassKeeper;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes2.dex */
public class PushHuaWeiCompat extends a implements ClassKeeper {
    public static final String NAME = "HUAWEI";
    private HuaweiApiClient client;
    public String registrationId = null;
    private HuaweiPushApiImp huaweiPushApiImp = new HuaweiPushApiImp();

    public PushHuaWeiCompat() {
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
        return NAME;
    }

    @Override // com.mob.pushsdk.plugins.a
    public void getRegistrationId(MobPushCallback<String> mobPushCallback) {
        PendingResult token = null;
        if (!this.client.isConnected()) {
            this.client.connect((Activity) null);
            return;
        }
        try {
            if (this.huaweiPushApiImp == null) {
                this.huaweiPushApiImp = new HuaweiPushApiImp();
            }
            token = this.huaweiPushApiImp.getToken(this.client);
        } catch (NoSuchFieldError e2) {
            try {
                token = HuaweiPush.HUAWEI_PUSH_API.getToken(this.client);
            } catch (Throwable unused) {
                PLog.getInstance().d("MobPush-HUAWEI: getToken HUAWEI_PUSH_API error: " + e2, new Object[0]);
            }
        } catch (Throwable th) {
            PLog.getInstance().d("MobPush-HUAWEI: getToken HuaweiPushApi error: " + th, new Object[0]);
        }
        if (token != null) {
            token.setResultCallback(new ResultCallback<TokenResult>() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.3
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(TokenResult tokenResult) {
                    try {
                        int retCode = tokenResult.getTokenRes().getRetCode();
                        PLog.getInstance().i("MobPush-HUAWEI GET_TOKEN code:" + retCode, new Object[0]);
                    } catch (Throwable th2) {
                        PLog.getInstance().i("MobPush-HUAWEI GET_TOKEN error:" + th2, new Object[0]);
                    }
                }
            });
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
        HuaweiApiClient huaweiApiClientBuild = new HuaweiApiClient.Builder(this.context).addApi(HuaweiPush.PUSH_API).addConnectionCallbacks(new HuaweiApiClient.ConnectionCallbacks() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.2
            public void onConnected() {
                d.a().b("[HUAWEI] channel connection successful.");
                PushHuaWeiCompat.this.getRegistrationId(null);
            }

            public void onConnectionSuspended(int i) {
                PLog.getInstance().d("MobPush HuaweiApiClient connection suspended, Reconnecting...  " + i, new Object[0]);
                if (PushHuaWeiCompat.this.client != null) {
                    PushHuaWeiCompat.this.client.connect((Activity) null);
                }
            }
        }).addOnConnectionFailedListener(new HuaweiApiClient.OnConnectionFailedListener() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.1
            public void onConnectionFailed(ConnectionResult connectionResult) {
                try {
                    if (HuaweiApiAvailability.getInstance().isUserResolvableError(connectionResult.getErrorCode())) {
                        final int errorCode = connectionResult.getErrorCode();
                        new Handler(PushHuaWeiCompat.this.context.getMainLooper()).post(new Runnable() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Intent intent = new Intent();
                                intent.putExtra("errorCode", errorCode);
                                new com.mob.pushsdk.plugins.huawei.a().show(PushHuaWeiCompat.this.context, intent);
                            }
                        });
                    }
                    d.a().c("[HUAWEI] channel connection failure, errorCode: " + connectionResult.getErrorCode());
                    int stringRes = ResHelper.getStringRes(PushHuaWeiCompat.this.context, PushErrorCode.valueOf((long) connectionResult.getErrorCode()).getMsgRes());
                    if (stringRes > 0) {
                        d.a().c("[HUAWEI] channel connection failure, errorMessage:" + PushHuaWeiCompat.this.context.getString(stringRes));
                    }
                } catch (Throwable th) {
                    d.a().c("[HUAWEI] channel connection failure, error: " + th.getMessage());
                }
            }
        }).build();
        this.client = huaweiApiClientBuild;
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
    public void setReceiveNormalMsg(final boolean z) {
        new Thread() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    try {
                        HuaweiPush.HuaweiPushApi.enableReceiveNormalMsg(PushHuaWeiCompat.this.client, z);
                    } catch (NoSuchFieldError unused) {
                        HuaweiPush.HUAWEI_PUSH_API.enableReceiveNormalMsg(PushHuaWeiCompat.this.client, z);
                    } catch (Throwable th) {
                        PLog.getInstance().i("MobPush-HUAWEI: HuaweiPushApi enableReceiveNormalMsg error:" + th, new Object[0]);
                    }
                } catch (Throwable th2) {
                    PLog.getInstance().i("MobPush-HUAWEI: HUAWEI_PUSH_API enableReceiveNormalMsg error:" + th2, new Object[0]);
                }
            }
        }.start();
    }

    @Override // com.mob.pushsdk.plugins.a
    public void setReceiveNotifyMsg(final boolean z) {
        new Thread() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    try {
                        HuaweiPush.HuaweiPushApi.enableReceiveNotifyMsg(PushHuaWeiCompat.this.client, z);
                    } catch (NoSuchFieldError unused) {
                        HuaweiPush.HUAWEI_PUSH_API.enableReceiveNotifyMsg(PushHuaWeiCompat.this.client, z);
                    } catch (Throwable th) {
                        PLog.getInstance().i("MobPush-HUAWEI: HuaweiPushApi enableReceiveNotifyMsg error:" + th, new Object[0]);
                    }
                } catch (Throwable th2) {
                    PLog.getInstance().i("MobPush-HUAWEI: HUAWEI_PUSH_API enableReceiveNotifyMsg error:" + th2, new Object[0]);
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
            new Thread() { // from class: com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat.6
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    PLog.getInstance().d("MobPush HuaweiApiClient delete token: " + PushHuaWeiCompat.this.registrationId, new Object[0]);
                    if (TextUtils.isEmpty(PushHuaWeiCompat.this.registrationId)) {
                        return;
                    }
                    try {
                        try {
                            HuaweiPush.HuaweiPushApi.deleteToken(PushHuaWeiCompat.this.client, PushHuaWeiCompat.this.registrationId);
                        } catch (NoSuchFieldError unused) {
                            HuaweiPush.HUAWEI_PUSH_API.deleteToken(PushHuaWeiCompat.this.client, PushHuaWeiCompat.this.registrationId);
                        } catch (Throwable th) {
                            PLog.getInstance().d("MobPush HuaweiApiClient HuaweiPushApi deleteToken error: " + th.getMessage(), new Object[0]);
                        }
                    } catch (Throwable th2) {
                        PLog.getInstance().i("MobPush-HUAWEI: HUAWEI_PUSH_API deleteToken error:" + th2.getMessage(), new Object[0]);
                    }
                }
            }.start();
        } else {
            PLog.getInstance().d("MobPush HuaweiApiClient not surviving", new Object[0]);
            this.client.connect((Activity) null);
        }
    }
}
