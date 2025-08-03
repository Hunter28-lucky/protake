package com.mob.pushsdk.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushLocalNotification;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;

/* loaded from: classes2.dex */
public class h {
    private static h a;
    private SharePrefrenceHelper b;
    private SharePrefrenceHelper c;
    private Handler d;

    /* renamed from: e, reason: collision with root package name */
    private int f17695e = 0;

    private h() {
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.b = sharePrefrenceHelper;
        sharePrefrenceHelper.open("db_local_notification");
        SharePrefrenceHelper sharePrefrenceHelper2 = new SharePrefrenceHelper(MobSDK.getContext());
        this.c = sharePrefrenceHelper2;
        sharePrefrenceHelper2.open("db_show_local_notification");
        Handler handlerNewHandler = MobHandlerThread.newHandler(c());
        this.d = handlerNewHandler;
        handlerNewHandler.sendEmptyMessage(0);
        try {
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", e(), new IntentFilter("com.mob.push.intent.TIMING_LOCAL_NOTIFICATION"));
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
    }

    private BroadcastReceiver e() {
        return new BroadcastReceiver() { // from class: com.mob.pushsdk.impl.h.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    int intExtra = intent.getIntExtra("notificationId", 0);
                    MobPushNotifyMessage mobPushNotifyMessageB = h.this.b(intExtra);
                    PLog.getInstance().d("LocalNotificationPool receiver nid = " + intExtra + " msg = " + mobPushNotifyMessageB, new Object[0]);
                    if (mobPushNotifyMessageB == null) {
                        return;
                    }
                    h.this.d(intExtra);
                    if (!h.a(mobPushNotifyMessageB)) {
                        h.this.a(intExtra, mobPushNotifyMessageB);
                        h.this.b(mobPushNotifyMessageB, intExtra);
                        return;
                    }
                    Message message = new Message();
                    message.obj = mobPushNotifyMessageB;
                    message.arg1 = intExtra;
                    message.what = 4;
                    h.this.d.sendMessage(message);
                } catch (Throwable th) {
                    PLog.getInstance().d(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    private Handler.Callback c() {
        return new Handler.Callback() { // from class: com.mob.pushsdk.impl.h.1
            /* JADX WARN: Removed duplicated region for block: B:70:0x017c  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x017d  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x01ac A[Catch: all -> 0x01f4, TryCatch #0 {all -> 0x01f4, blocks: (B:23:0x0099, B:25:0x009f, B:27:0x00af, B:29:0x00b7, B:31:0x00bd, B:32:0x00c4, B:34:0x00ca, B:36:0x00cd, B:39:0x00d2, B:41:0x00d7, B:43:0x00db, B:45:0x00e3, B:47:0x00f0, B:46:0x00ec, B:48:0x00f3, B:49:0x00f6, B:51:0x00fc, B:53:0x0102, B:54:0x0109, B:56:0x0144, B:57:0x014b, B:59:0x0156, B:68:0x0174, B:72:0x017e, B:74:0x01ac, B:75:0x01af, B:77:0x01d3, B:79:0x01d9, B:80:0x01dc, B:81:0x01e8, B:61:0x015c, B:63:0x0162, B:67:0x016b), top: B:113:0x0099 }] */
            /* JADX WARN: Removed duplicated region for block: B:77:0x01d3 A[Catch: all -> 0x01f4, TryCatch #0 {all -> 0x01f4, blocks: (B:23:0x0099, B:25:0x009f, B:27:0x00af, B:29:0x00b7, B:31:0x00bd, B:32:0x00c4, B:34:0x00ca, B:36:0x00cd, B:39:0x00d2, B:41:0x00d7, B:43:0x00db, B:45:0x00e3, B:47:0x00f0, B:46:0x00ec, B:48:0x00f3, B:49:0x00f6, B:51:0x00fc, B:53:0x0102, B:54:0x0109, B:56:0x0144, B:57:0x014b, B:59:0x0156, B:68:0x0174, B:72:0x017e, B:74:0x01ac, B:75:0x01af, B:77:0x01d3, B:79:0x01d9, B:80:0x01dc, B:81:0x01e8, B:61:0x015c, B:63:0x0162, B:67:0x016b), top: B:113:0x0099 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x01e8 A[Catch: all -> 0x01f4, TRY_LEAVE, TryCatch #0 {all -> 0x01f4, blocks: (B:23:0x0099, B:25:0x009f, B:27:0x00af, B:29:0x00b7, B:31:0x00bd, B:32:0x00c4, B:34:0x00ca, B:36:0x00cd, B:39:0x00d2, B:41:0x00d7, B:43:0x00db, B:45:0x00e3, B:47:0x00f0, B:46:0x00ec, B:48:0x00f3, B:49:0x00f6, B:51:0x00fc, B:53:0x0102, B:54:0x0109, B:56:0x0144, B:57:0x014b, B:59:0x0156, B:68:0x0174, B:72:0x017e, B:74:0x01ac, B:75:0x01af, B:77:0x01d3, B:79:0x01d9, B:80:0x01dc, B:81:0x01e8, B:61:0x015c, B:63:0x0162, B:67:0x016b), top: B:113:0x0099 }] */
            @Override // android.os.Handler.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean handleMessage(android.os.Message r24) {
                /*
                    Method dump skipped, instructions count: 737
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.h.AnonymousClass1.handleMessage(android.os.Message):boolean");
            }
        };
    }

    private boolean d() {
        if (com.mob.pushsdk.b.a.a(MobSDK.getContext())) {
            return com.mob.pushsdk.biz.d.s();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MobPushNotifyMessage e(int i) {
        MobPushNotifyMessage mobPushNotifyMessageC;
        synchronized (this.c) {
            mobPushNotifyMessageC = c(i);
            this.c.remove(String.valueOf(i));
        }
        return mobPushNotifyMessageC;
    }

    private void c(MobPushNotifyMessage mobPushNotifyMessage) {
        try {
            PLog.getInstance().d("LocalNotificationPool sendLocalNotificationCallBack= " + mobPushNotifyMessage, new Object[0]);
            Message message = new Message();
            Bundle bundle = new Bundle();
            message.what = 1002;
            bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
            message.setData(bundle);
            k.a().b(message);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MobPushNotifyMessage d(int i) {
        MobPushNotifyMessage mobPushNotifyMessageB;
        synchronized (this.b) {
            mobPushNotifyMessageB = b(i);
            this.b.remove(String.valueOf(i));
        }
        return mobPushNotifyMessageB;
    }

    public static boolean b(MobPushNotifyMessage mobPushNotifyMessage) {
        String styleContent = mobPushNotifyMessage.getStyleContent();
        if (styleContent == null) {
            return false;
        }
        if (!styleContent.startsWith("http://") && !styleContent.startsWith("https://")) {
            return false;
        }
        try {
            String strDownloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), styleContent);
            if (TextUtils.isEmpty(strDownloadBitmap)) {
                return false;
            }
            mobPushNotifyMessage.setStyleContent(strDownloadBitmap);
            return true;
        } catch (Throwable th) {
            com.mob.pushsdk.b.d.a().d("uploadPic download picture failed:" + th);
            PLog.getInstance().e(th);
            return false;
        }
    }

    public static synchronized h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    public static boolean a(MobPushNotifyMessage mobPushNotifyMessage) {
        return mobPushNotifyMessage != null && mobPushNotifyMessage.getStyle() == 2 && !TextUtils.isEmpty(mobPushNotifyMessage.getStyleContent()) && (mobPushNotifyMessage.getStyleContent().startsWith("http://") || mobPushNotifyMessage.getStyleContent().startsWith("https://"));
    }

    public void a(MobPushLocalNotification mobPushLocalNotification) {
        Message message = new Message();
        message.what = 1;
        message.obj = mobPushLocalNotification;
        this.d.sendMessage(message);
    }

    public MobPushNotifyMessage c(int i) {
        MobPushNotifyMessage mobPushNotifyMessage;
        synchronized (this.c) {
            mobPushNotifyMessage = (MobPushNotifyMessage) this.c.get(String.valueOf(i));
        }
        return mobPushNotifyMessage;
    }

    public void b() {
        this.d.removeCallbacksAndMessages(null);
        this.d.sendEmptyMessage(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MobPushNotifyMessage mobPushNotifyMessage, int i) {
        boolean zD = d();
        PLog.getInstance().d("LocalNotificationPool show hidden:" + zD, new Object[0]);
        if (mobPushNotifyMessage == null || zD) {
            return;
        }
        if (!a(mobPushNotifyMessage) || b(mobPushNotifyMessage)) {
            mobPushNotifyMessage.setTimestamp(System.currentTimeMillis());
            l.a().a(mobPushNotifyMessage, i);
            c(mobPushNotifyMessage);
            String messageId = mobPushNotifyMessage.getMessageId();
            if (TextUtils.isEmpty(messageId) || "DEFAULT_LOCAL_NOTIFICATION_TAG".equals(messageId)) {
                return;
            }
            PLog.getInstance().d("LocalNotificationPool reAck messageId= " + messageId, new Object[0]);
            j.a().a(mobPushNotifyMessage, true);
        }
    }

    public void a(int i) {
        Message message = new Message();
        message.what = 2;
        message.arg1 = i;
        this.d.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MobPushNotifyMessage a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 2)));
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return (MobPushNotifyMessage) object;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, MobPushNotifyMessage mobPushNotifyMessage) {
        synchronized (this.b) {
            this.b.put(String.valueOf(i), mobPushNotifyMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MobPushNotifyMessage mobPushNotifyMessage, int i) {
        try {
            PLog.getInstance().d("LocalNotificationPool doFutureMessage:" + mobPushNotifyMessage.toString(), new Object[0]);
            this.f17695e = this.f17695e + 1;
            Intent intent = new Intent("com.mob.push.intent.TIMING_LOCAL_NOTIFICATION");
            intent.putExtra("notificationId", i);
            PendingIntent pendingIntentB = com.mob.pushsdk.b.g.b(MobSDK.getContext(), this.f17695e, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) MobSDK.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.setTimeInMillis(mobPushNotifyMessage.getTimestamp());
            alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), pendingIntentB);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public MobPushNotifyMessage b(int i) {
        MobPushNotifyMessage mobPushNotifyMessage;
        synchronized (this.b) {
            mobPushNotifyMessage = (MobPushNotifyMessage) this.b.get(String.valueOf(i));
        }
        return mobPushNotifyMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, MobPushNotifyMessage mobPushNotifyMessage) {
        synchronized (this.c) {
            this.c.put(String.valueOf(i), mobPushNotifyMessage);
        }
    }
}
