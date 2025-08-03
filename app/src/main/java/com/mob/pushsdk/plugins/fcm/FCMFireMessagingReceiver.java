package com.mob.pushsdk.plugins.fcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mob.pushsdk.b.f;
import com.mob.pushsdk.b.k;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.impl.i;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class FCMFireMessagingReceiver extends BroadcastReceiver {
    private void a(final Intent intent) {
        if (f.a(intent)) {
            return;
        }
        k.b(new k.a() { // from class: com.mob.pushsdk.plugins.fcm.FCMFireMessagingReceiver.1
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                PLog.getInstance().d("MobPush-FCM-Message check auth...", new Object[0]);
                if (!com.mob.pushsdk.impl.a.a(500, Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 30, false)) {
                    PLog.getInstance().d("MobPush-FCM-Message auth failed...", new Object[0]);
                    return;
                }
                PLog.getInstance().d("MobPush-FCM-Message check auth success...", new Object[0]);
                if (f.a(intent)) {
                    return;
                }
                Bundle extras = intent.getExtras();
                if (f.a(extras)) {
                    return;
                }
                String str = extras.containsKey("id") ? extras.getString("id").split("_")[0] : "";
                String string = extras.containsKey("google.message_id") ? extras.getString("google.message_id") : "";
                PLog.getInstance().e("fcm pushId=" + str + ";messageID=" + string, new Object[0]);
                i.a().a(str);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a(intent);
    }
}
