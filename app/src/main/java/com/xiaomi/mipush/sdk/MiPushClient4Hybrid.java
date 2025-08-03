package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.bc;
import com.xiaomi.push.ee;
import com.xiaomi.push.g;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
public class MiPushClient4Hybrid {
    private static MiPushCallback sCallback;
    private static Map<String, b.a> dataMap = new HashMap();
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int iIntValue = TextUtils.isEmpty(str) ? 0 : Integer.valueOf(str).intValue();
        if (!z) {
            iIntValue = (iIntValue & (-4)) + g.b.NOT_ALLOWED.a();
        }
        return (short) iIntValue;
    }

    public static boolean isRegistered(Context context, String str) {
        return b.m5140a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, hh hhVar) {
        b.a aVar;
        String strC = hhVar.c();
        if (hhVar.a() == 0 && (aVar = dataMap.get(strC)) != null) {
            aVar.a(hhVar.f6198e, hhVar.f6199f);
            b.m5140a(context).a(strC, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(hhVar.f6198e)) {
            arrayList = new ArrayList();
            arrayList.add(hhVar.f6198e);
        }
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f5830a, arrayList, hhVar.f6186a, hhVar.f6197d, null, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(strC, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, hn hnVar) {
        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_UNREGISTER.f5830a, null, hnVar.f6264a, hnVar.f6272d, null, null);
        String strA = hnVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(strA, miPushCommandMessageGenerateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (b.m5140a(context).m5145a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            b.a aVarA = b.m5140a(context).a(str);
            if (aVarA != null) {
                arrayList.add(aVarA.c);
                MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f5830a, arrayList, 0L, null, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, miPushCommandMessageGenerateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                hf hfVar = new hf();
                hfVar.b(str2);
                hfVar.c(gq.PullOfflineMessage.f6003a);
                hfVar.a(aj.a());
                hfVar.a(false);
                u.a(context).a(hfVar, gg.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0L)) < 5000) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(jCurrentTimeMillis));
        String strA = bc.a(6);
        b.a aVar = new b.a(context);
        aVar.c(str2, str3, strA);
        dataMap.put(str, aVar);
        hg hgVar = new hg();
        hgVar.a(aj.a());
        hgVar.b(str2);
        hgVar.e(str3);
        hgVar.d(str);
        hgVar.f(strA);
        hgVar.c(com.xiaomi.push.g.m5511a(context, context.getPackageName()));
        hgVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        hgVar.h(BuildConfig.VERSION_NAME);
        hgVar.a(BuildConfig.VERSION_CODE);
        hgVar.a(gu.Init);
        if (!com.xiaomi.push.j.m5696d()) {
            String strC = com.xiaomi.push.i.c(context);
            if (!TextUtils.isEmpty(strC)) {
                hgVar.i(bc.a(strC));
            }
        }
        int iA = com.xiaomi.push.i.a();
        if (iA >= 0) {
            hgVar.c(iA);
        }
        hf hfVar2 = new hf();
        hfVar2.c(gq.HybridRegister.f6003a);
        hfVar2.b(b.m5140a(context).m5141a());
        hfVar2.d(context.getPackageName());
        hfVar2.a(hq.a(hgVar));
        hfVar2.a(aj.a());
        u.a(context).a((u) hfVar2, gg.Notification, (gt) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String messageId = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(messageId)) {
            messageId = miPushMessage.getMessageId();
        }
        t.a(context, messageId);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("do not ack message, message is null");
            return;
        }
        try {
            gw gwVar = new gw();
            gwVar.b(b.m5140a(context).m5141a());
            gwVar.a(miPushMessage.getMessageId());
            gwVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            gwVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                gwVar.c(miPushMessage.getTopic());
            }
            u.a(context).a((u) gwVar, gg.AckMessage, false, au.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1L)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        b.a aVarA = b.m5140a(context).a(str);
        if (aVarA == null) {
            return;
        }
        hm hmVar = new hm();
        hmVar.a(aj.a());
        hmVar.d(str);
        hmVar.b(aVarA.f5519a);
        hmVar.c(aVarA.c);
        hmVar.e(aVarA.b);
        hf hfVar = new hf();
        hfVar.c(gq.HybridUnregister.f6003a);
        hfVar.b(b.m5140a(context).m5141a());
        hfVar.d(context.getPackageName());
        hfVar.a(hq.a(hmVar));
        hfVar.a(aj.a());
        u.a(context).a((u) hfVar, gg.Notification, (gt) null);
        b.m5140a(context).b(str);
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        x.a(context, linkedList);
    }
}
