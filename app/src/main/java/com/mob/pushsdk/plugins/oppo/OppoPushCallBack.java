package com.mob.pushsdk.plugins.oppo;

import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;
import defpackage.InterfaceC2917;

/* loaded from: classes2.dex */
public class OppoPushCallBack implements InterfaceC2917 {
    @Override // defpackage.InterfaceC2917
    public void onGetNotificationStatus(int i, int i2) {
        if (i == 0 && i2 == 0) {
            d.a().a("[OPPO] notification status: code=" + i + ",status=" + i2);
            return;
        }
        d.a().a("[OPPO] notification status error: code=" + i + ",status=" + i2);
    }

    @Override // defpackage.InterfaceC2917
    public void onGetPushStatus(int i, int i2) {
        if (i == 0 && i2 == 0) {
            d.a().a("[OPPO] push status: code=" + i + ",status=" + i2);
            return;
        }
        d.a().a("[OPPO] push status error:code=" + i + ",status=" + i2);
    }

    @Override // defpackage.InterfaceC2917
    public void onRegister(int i, String str) {
        PLog.getInstance().d("MobPush-OPPO register id:" + str, new Object[0]);
        PLog.getInstance().d("MobPush-OPPO responseCode:" + i, new Object[0]);
        if (i == 0 && !TextUtils.isEmpty(str)) {
            d.a().a("[OPPO] channel rigister successful.");
            InnerOppoReceiver.getInstance().doPluginRecevier(MobSDK.getContext(), 2, str);
            return;
        }
        d.a().a("[OPPO] channel rigister failure:" + i);
    }

    @Override // defpackage.InterfaceC2917
    public void onSetPushTime(int i, String str) {
        d.a().a("[OPPO]  SetPushTime:code=" + i + ",result:" + str);
    }

    @Override // defpackage.InterfaceC2917
    public void onUnRegister(int i) {
        d.a().a("MobPush-OPPO onUnRegister:" + i);
    }
}
