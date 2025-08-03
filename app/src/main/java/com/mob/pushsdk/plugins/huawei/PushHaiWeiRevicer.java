package com.mob.pushsdk.plugins.huawei;

import android.content.Context;
import android.os.Bundle;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.plugins.huawei.compat.InnerHuaWeiReceiverCompat;
import com.mob.pushsdk.plugins.huawei.compat.PushReceiver;

/* loaded from: classes2.dex */
public class PushHaiWeiRevicer extends PushReceiver {
    @Override // com.mob.pushsdk.plugins.huawei.compat.PushReceiver
    public void a(Context context, PushReceiver.Event event, Bundle bundle) {
        if (PushReceiver.Event.NOTIFICATION_OPENED.equals(event)) {
            InnerHuaWeiReceiverCompat.getInstance().doPluginRecevier(context, 0, bundle);
            PLog.getInstance().d("MobPush-HUAWEI bundle:" + bundle.toString(), new Object[0]);
        }
    }

    @Override // com.mob.pushsdk.plugins.huawei.compat.PushReceiver
    public boolean a(Context context, byte[] bArr, Bundle bundle) {
        return false;
    }

    @Override // com.mob.pushsdk.plugins.huawei.compat.PushReceiver
    public void a(Context context, String str, Bundle bundle) {
        String string = bundle.getString("belongId");
        PLog.getInstance().d("MobPush-HUAWEI token:" + str + " belongId:" + string, new Object[0]);
        InnerHuaWeiReceiverCompat.getInstance().doPluginRecevier(context, 2, str);
    }
}
