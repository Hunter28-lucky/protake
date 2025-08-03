package com.mob.pushsdk.plugins.vivo;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.b.d;
import com.vivo.push.model.UPSNotificationMessage;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class a extends com.mob.pushsdk.plugins.a.a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, int i, Object obj) {
        if (i != 0) {
            if (i != 2) {
                return;
            }
            String str = (String) obj;
            d.a().a("[VIVO] channel regId: " + str);
            bindPlugin("VIVO", str);
            return;
        }
        if (obj == null) {
            return;
        }
        UPSNotificationMessage uPSNotificationMessage = (UPSNotificationMessage) obj;
        MobPushNotifyMessage mobPushNotifyMessage = new MobPushNotifyMessage();
        mobPushNotifyMessage.setChannel(5);
        mobPushNotifyMessage.setTimestamp(System.currentTimeMillis());
        mobPushNotifyMessage.setStyle(0);
        mobPushNotifyMessage.setStyleContent(null);
        mobPushNotifyMessage.setInboxStyleContent(null);
        mobPushNotifyMessage.setMessageId(String.valueOf(Math.abs(uPSNotificationMessage.getMsgId())));
        mobPushNotifyMessage.setContent(uPSNotificationMessage.getContent());
        mobPushNotifyMessage.setTitle(uPSNotificationMessage.getTitle());
        mobPushNotifyMessage.setExtrasMap((HashMap) uPSNotificationMessage.getParams());
        int notifyType = uPSNotificationMessage.getNotifyType();
        if (notifyType == 1) {
            mobPushNotifyMessage.setVoice(false);
            mobPushNotifyMessage.setLight(false);
            mobPushNotifyMessage.setShake(false);
        } else if (notifyType == 2) {
            mobPushNotifyMessage.setLight(false);
            mobPushNotifyMessage.setShake(false);
        } else if (notifyType == 3) {
            mobPushNotifyMessage.setVoice(false);
            mobPushNotifyMessage.setLight(false);
        } else if (notifyType == 4) {
            mobPushNotifyMessage.setLight(false);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
        this.pushSDKImpl.a(bundle);
    }
}
