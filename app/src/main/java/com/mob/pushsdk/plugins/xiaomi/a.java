package com.mob.pushsdk.plugins.xiaomi;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.b.d;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.biz.PushErrorCode;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends com.mob.pushsdk.plugins.a.a {
    private static final a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    @Override // com.mob.pushsdk.plugins.a.a
    public void doPluginRecevier(Context context, int i, Object obj) {
        if (i != 0) {
            boolean z = true;
            if (i != 1) {
                if (i == 2) {
                    try {
                        MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) obj;
                        String command = miPushCommandMessage.getCommand();
                        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
                        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                            if (miPushCommandMessage.getResultCode() != 0) {
                                d.a().a("[XIAOMI] channel register failure, errorcode " + miPushCommandMessage.getResultCode());
                                return;
                            }
                            d.a().a("[XIAOMI] channel regId: " + str);
                            bindPlugin("XIAOMI", str);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        PLog.getInstance().e("MobPush-XIAOMI: receiver notification message error " + th.getMessage(), new Object[0]);
                        return;
                    }
                }
                if (i != 3) {
                    return;
                }
                try {
                    MiPushCommandMessage miPushCommandMessage2 = (MiPushCommandMessage) obj;
                    if (miPushCommandMessage2.getResultCode() != 0) {
                        int stringRes = ResHelper.getStringRes(context, PushErrorCode.valueOf(miPushCommandMessage2.getResultCode()).getMsgRes());
                        if (stringRes > 0) {
                            PLog.getInstance().e("MobPush-XIAOMI: command result error " + context.getString(stringRes), new Object[0]);
                        } else {
                            PLog.getInstance().e("MobPush-XIAOMI: command result errorcode " + miPushCommandMessage2.getResultCode(), new Object[0]);
                        }
                    }
                    if (!MiPushClient.COMMAND_SET_ALIAS.equals(miPushCommandMessage2.getCommand()) && !MiPushClient.COMMAND_UNSET_ALIAS.equals(miPushCommandMessage2.getCommand())) {
                        if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(miPushCommandMessage2.getCommand()) || MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(miPushCommandMessage2.getCommand())) {
                            List<String> allTopic = MiPushClient.getAllTopic(MobSDK.getContext());
                            Bundle bundle = new Bundle();
                            bundle.putString("operation", "tags");
                            bundle.putSerializable("extra", (Serializable) allTopic);
                            if (miPushCommandMessage2.getResultCode() != 0) {
                                z = false;
                            }
                            bundle.putBoolean("result", z);
                            this.pushSDKImpl.b(bundle);
                            return;
                        }
                        return;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("operation", "alias");
                    if (miPushCommandMessage2.getResultCode() != 0) {
                        z = false;
                    }
                    bundle2.putBoolean("result", z);
                    this.pushSDKImpl.b(bundle2);
                    return;
                } catch (Throwable th2) {
                    PLog.getInstance().e("MobPush-XIAOMI: command result error " + th2.getMessage(), new Object[0]);
                    return;
                }
            }
        }
        try {
            MiPushMessage miPushMessage = (MiPushMessage) obj;
            MobPushNotifyMessage mobPushNotifyMessage = new MobPushNotifyMessage();
            mobPushNotifyMessage.setMessageId(miPushMessage.getMessageId());
            mobPushNotifyMessage.setTitle(miPushMessage.getTitle());
            mobPushNotifyMessage.setContent(miPushMessage.getDescription());
            switch (miPushMessage.getNotifyType()) {
                case 1:
                    mobPushNotifyMessage.setLight(false);
                    mobPushNotifyMessage.setShake(false);
                    break;
                case 2:
                    mobPushNotifyMessage.setLight(false);
                    mobPushNotifyMessage.setVoice(false);
                    break;
                case 3:
                    mobPushNotifyMessage.setLight(false);
                    break;
                case 4:
                    mobPushNotifyMessage.setShake(false);
                    mobPushNotifyMessage.setVoice(false);
                    break;
                case 5:
                    mobPushNotifyMessage.setShake(false);
                    break;
                case 6:
                    mobPushNotifyMessage.setVoice(false);
                    break;
            }
            mobPushNotifyMessage.setChannel(2);
            HashMap<String, String> map = (HashMap) miPushMessage.getExtra();
            if (map.containsKey("callback")) {
                map.remove("callback");
            }
            if (map.containsKey("callback.param")) {
                map.remove("callback.param");
            }
            map.put("notifyId", String.valueOf(miPushMessage.getNotifyId()));
            mobPushNotifyMessage.setExtrasMap(map);
            if (i == 0) {
                com.mob.pushsdk.b.a.a(mobPushNotifyMessage);
            }
            Bundle bundle3 = new Bundle();
            bundle3.putInt("action", i);
            bundle3.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
            this.pushSDKImpl.a(bundle3);
        } catch (Throwable th3) {
            PLog.getInstance().e("MobPush-XIAOMI: register error " + th3.getMessage(), new Object[0]);
        }
    }
}
