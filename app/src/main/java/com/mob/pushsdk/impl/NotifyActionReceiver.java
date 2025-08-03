package com.mob.pushsdk.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.b.k;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public class NotifyActionReceiver extends BroadcastReceiver {
    private HashSet<String> a = new HashSet<>();
    private HashSet<String> b = new HashSet<>();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) ResHelper.forceCast(intent.getExtras().getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
            if ("com.mob.push.intent.NOTIFICATION_OPENED".equals(intent.getAction())) {
                a(mobPushNotifyMessage);
            }
            if (!e.b.contains(mobPushNotifyMessage.getMessageId())) {
                e.b.add(mobPushNotifyMessage.getMessageId());
                b(context, intent);
                return;
            }
            PLog.getInstance().d(mobPushNotifyMessage.getMessageId() + ",hasOpened", new Object[0]);
        } catch (Throwable th) {
            PLog.getInstance().d(th);
        }
    }

    private void a(final MobPushNotifyMessage mobPushNotifyMessage) {
        if (!e.c.contains(mobPushNotifyMessage.getMessageId())) {
            e.c.add(mobPushNotifyMessage.getMessageId());
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.pushsdk.impl.NotifyActionReceiver.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (com.mob.pushsdk.b.b.a(e.a)) {
                        return false;
                    }
                    for (com.mob.pushsdk.MobPushReceiver mobPushReceiver : e.a) {
                        if (com.mob.pushsdk.b.f.b(mobPushReceiver)) {
                            mobPushReceiver.onNotifyMessageOpenedReceive(MobSDK.getContext(), mobPushNotifyMessage);
                        }
                    }
                    return false;
                }
            });
            return;
        }
        PLog.getInstance().d(mobPushNotifyMessage.getMessageId() + ",hasCB", new Object[0]);
    }

    private void b(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (!action.equals("com.mob.push.intent.NOTIFICATION_OPENED")) {
                if (action.equals("com.mob.push.intent.NOTIFICATION_DELETE")) {
                    l.a().c(intent.getExtras().getInt("requestCode"));
                    return;
                }
                return;
            }
            Bundle extras = intent.getExtras();
            if ((extras.containsKey("type") ? extras.getInt("type") : 1) == 2) {
                a(context, extras);
                return;
            }
            int i = extras.getInt("requestCode");
            extras.remove("requestCode");
            MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) ResHelper.forceCast(extras.getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
            a(context, mobPushNotifyMessage);
            if (mobPushNotifyMessage != null && mobPushNotifyMessage.getChannel() == 0) {
                b(mobPushNotifyMessage);
            }
            l.a().c(i);
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
    }

    private void a(Context context, Bundle bundle) throws PendingIntent.CanceledException {
        Intent intent;
        Intent intent2 = null;
        MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) ResHelper.forceCast(bundle.getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
        HashMap<String, String> extrasMap = mobPushNotifyMessage.getExtrasMap();
        if (extrasMap != null && !extrasMap.isEmpty()) {
            String str = extrasMap.containsKey("mobpush_link_k") ? extrasMap.get("mobpush_link_k") : "";
            String str2 = extrasMap.containsKey("mobpush_link_pkg") ? extrasMap.get("mobpush_link_pkg") : "";
            String str3 = extrasMap.containsKey("mobpush_link_url") ? extrasMap.get("mobpush_link_url") : "";
            if (!TextUtils.isEmpty(str2)) {
                if (DeviceHelper.getInstance(context).isPackageInstalled(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent2 = intent;
                    }
                } else if (!TextUtils.isEmpty(str3)) {
                    intent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
                    intent2 = intent;
                }
            } else if (!TextUtils.isEmpty(str3)) {
                intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str3));
            }
            if (intent2 != null) {
                com.mob.pushsdk.b.a.a(intent2);
            }
        }
        b(mobPushNotifyMessage);
    }

    private void b(MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            return;
        }
        PLog.getInstance().d("pushClickAck - message: " + mobPushNotifyMessage.toString(), new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (mobPushNotifyMessage.getOfflineFlag() == 1) {
            arrayList.add(mobPushNotifyMessage.getMessageId());
        }
        PLog.getInstance().d("pushClickAck - msgClickAskedSet: " + this.a.toString() + ", msgOfflineAskedSet:" + this.b.toString(), new Object[0]);
        if (arrayList.size() != 0 && !this.b.contains(mobPushNotifyMessage.getMessageId())) {
            this.b.add(mobPushNotifyMessage.getMessageId());
            com.mob.pushsdk.biz.e.d((String[]) arrayList.toArray(new String[0]), null);
        }
        if (!this.a.contains(mobPushNotifyMessage.getMessageId())) {
            this.a.add(mobPushNotifyMessage.getMessageId());
            if (mobPushNotifyMessage.isGuardMsg()) {
                com.mob.pushsdk.biz.e.a(new String[]{mobPushNotifyMessage.getMessageId()}, (com.mob.pushsdk.biz.b) null);
            } else {
                com.mob.pushsdk.biz.e.b(new String[]{mobPushNotifyMessage.getMessageId()}, null);
            }
        }
        new Thread(new Runnable() { // from class: com.mob.pushsdk.impl.NotifyActionReceiver.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                try {
                    Thread.sleep(3000L);
                    PLog.getInstance().d("pushClickAck - clear set", new Object[0]);
                    NotifyActionReceiver.this.a.clear();
                    NotifyActionReceiver.this.b.clear();
                } catch (InterruptedException e2) {
                    PLog.getInstance().e("pushClickAck - error:" + e2, new Object[0]);
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r10, com.mob.pushsdk.MobPushNotifyMessage r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.NotifyActionReceiver.a(android.content.Context, com.mob.pushsdk.MobPushNotifyMessage):void");
    }

    private Intent a() {
        Context context = MobSDK.getContext();
        String packageName = context.getPackageName();
        Intent intent = new Intent(packageName + ".default.MAIN");
        if (!com.mob.pushsdk.b.a.a(context, packageName, intent).booleanValue()) {
            intent = null;
        }
        if (intent == null) {
            intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        }
        if (intent != null) {
            intent.addFlags(67108864);
        }
        return intent;
    }

    public void a(final Context context, final Intent intent) {
        com.mob.pushsdk.b.k.a(new k.a() { // from class: com.mob.pushsdk.impl.NotifyActionReceiver.3
            @Override // com.mob.pushsdk.b.k.a
            public void a() {
                if (MobSDK.isForb()) {
                    return;
                }
                NotifyActionReceiver.this.onReceive(context, intent);
            }
        });
    }
}
