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
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.MobPushCustomMessage;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class k {
    private static k a;
    private ThreadPoolExecutor b;
    private SharePrefrenceHelper c;
    private Handler d;

    /* renamed from: e, reason: collision with root package name */
    private int f17698e;
    private byte[] f = null;
    private Set<ReceivedMsg> g;

    public static class a implements Runnable {
        public byte[] a;

        private String a() throws Throwable {
            return new String(this.a, Platform.UTF_8);
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x02e0 A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x030b  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x01fb A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0223  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0231 A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x025b  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0272 A[Catch: all -> 0x037b, TRY_ENTER, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x02a0 A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x02c6 A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x02d5 A[Catch: all -> 0x037b, TryCatch #1 {all -> 0x037b, blocks: (B:3:0x000e, B:6:0x005e, B:8:0x00b7, B:10:0x00bf, B:12:0x00c5, B:14:0x00cb, B:18:0x0123, B:21:0x012a, B:25:0x0144, B:27:0x0151, B:29:0x017b, B:31:0x0184, B:33:0x018c, B:37:0x0195, B:56:0x01f5, B:58:0x01fb, B:68:0x0237, B:72:0x025e, B:75:0x0272, B:77:0x0278, B:82:0x028f, B:83:0x0296, B:85:0x02a0, B:87:0x02a6, B:92:0x02bd, B:94:0x02c6, B:96:0x02cc, B:97:0x02cf, B:99:0x02d5, B:100:0x02da, B:102:0x02e0, B:104:0x02ef, B:106:0x02f7, B:107:0x0300, B:111:0x0322, B:119:0x0369, B:121:0x0372, B:109:0x030d, B:110:0x031f, B:67:0x0231, B:40:0x01aa, B:44:0x01bd, B:50:0x01db, B:114:0x0331, B:116:0x0352, B:118:0x0366, B:46:0x01ca, B:89:0x02ac, B:79:0x027e), top: B:129:0x000e, inners: #0, #2, #3 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 900
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.k.a.run():void");
        }

        private a(byte[] bArr) {
            this.a = bArr;
        }

        private void a(Map<String, Object> map, MobPushNotifyMessage mobPushNotifyMessage) {
            if (map == null || map.isEmpty() || mobPushNotifyMessage == null) {
                return;
            }
            if (map.containsKey("image")) {
                mobPushNotifyMessage.setImage((String) map.get("image"));
            }
            if (map.containsKey("icon")) {
                mobPushNotifyMessage.setIcon((String) map.get("icon"));
            }
            if (map.containsKey("iconC")) {
                mobPushNotifyMessage.setIconColor((String) ResHelper.forceCast(map.get("iconC"), ""));
            }
            if (map.containsKey("androidBadgeType")) {
                mobPushNotifyMessage.setAndroidBadgeType(((Integer) ResHelper.forceCast(map.get("androidBadgeType"), 0)).intValue());
            }
            if (map.containsKey("androidBadge")) {
                mobPushNotifyMessage.setAndroidBadge(((Integer) ResHelper.forceCast(map.get("androidBadge"), 0)).intValue());
            }
            if (map.containsKey("androidChannelId")) {
                mobPushNotifyMessage.setAndroidChannelId((String) map.get("androidChannelId"));
            }
        }

        private boolean a(HashMap<String, Object> map) {
            if (!map.containsKey("dt")) {
                return false;
            }
            int iIntValue = ((Integer) map.get("dt")).intValue();
            return iIntValue == 2 || iIntValue == 3;
        }
    }

    private k() {
        this.f17698e = 0;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 6, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
        this.c = sharePrefrenceHelper;
        sharePrefrenceHelper.open("db_msg_task");
        Handler handlerNewHandler = MobHandlerThread.newHandler(c());
        this.d = handlerNewHandler;
        handlerNewHandler.sendEmptyMessage(0);
        this.f17698e = com.mob.pushsdk.biz.d.l();
        try {
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", e(), new IntentFilter("com.mob.push.intent.TIMING_MESSAGE"));
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
        this.g = new HashSet();
        if (com.mob.pushsdk.biz.d.u() != null) {
            this.g.addAll(com.mob.pushsdk.biz.d.u());
        }
    }

    private BroadcastReceiver e() {
        return new BroadcastReceiver() { // from class: com.mob.pushsdk.impl.k.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Object objA;
                try {
                    int intExtra = intent.getIntExtra("pushType", 0);
                    int intExtra2 = intent.getIntExtra("showTemplate", 0);
                    String stringExtra = intent.getStringExtra("msgId");
                    if ((intExtra == 1 || intExtra == 2) && (objA = k.this.a(stringExtra)) != null) {
                        k.this.b(stringExtra);
                        Bundle bundle = new Bundle();
                        Message message = new Message();
                        if (intExtra == 1) {
                            message.what = 1002;
                            MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) objA;
                            if (h.a(mobPushNotifyMessage)) {
                                Message message2 = new Message();
                                message2.obj = mobPushNotifyMessage;
                                message2.what = 4;
                                k.this.d.sendMessage(message2);
                                return;
                            }
                            k.a(mobPushNotifyMessage);
                            bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
                        } else if (intExtra == 2) {
                            message.what = 1001;
                            MobPushCustomMessage mobPushCustomMessage = (MobPushCustomMessage) objA;
                            bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushCustomMessage);
                            if (intExtra2 > 0) {
                                k.a(mobPushCustomMessage, intExtra2);
                            }
                        }
                        message.setData(bundle);
                        k.this.b(message);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    PLog.getInstance().e(th);
                }
            }
        };
    }

    private Handler.Callback c() {
        return new Handler.Callback() { // from class: com.mob.pushsdk.impl.k.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    k.this.d();
                    return false;
                }
                if (i == 1) {
                    k.this.b.submit(new a((byte[]) message.obj));
                    return false;
                }
                if (i != 4) {
                    return false;
                }
                try {
                    MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) message.obj;
                    k.a(mobPushNotifyMessage);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(NotificationCompat.CATEGORY_MESSAGE, mobPushNotifyMessage);
                    Message message2 = new Message();
                    message2.setData(bundle);
                    k.this.b(message2);
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    PLog.getInstance().e(th);
                    return false;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this.c) {
            ArrayList arrayList = (ArrayList) this.c.get("unreadMsg");
            NLog pLog = PLog.getInstance();
            Object[] objArr = new Object[1];
            objArr[0] = arrayList == null ? null : String.valueOf(arrayList.size());
            pLog.d(String.format("MessagePool last unread message task %s", objArr), new Object[0]);
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a((byte[]) it.next());
                }
                this.c.remove("unreadMsg");
            }
        }
    }

    public static boolean b() {
        if (com.mob.pushsdk.biz.d.s()) {
            return com.mob.pushsdk.b.a.a(MobSDK.getContext());
        }
        return false;
    }

    public void b(Message message) throws Throwable {
        if (message == null) {
            return;
        }
        int i = message.what;
        if (i > 0 && i < 101) {
            throw new Throwable("msg.what in [1, 100] is the keep field");
        }
        c.a().a(message);
    }

    public static synchronized k a() {
        if (a == null) {
            a = new k();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            return;
        }
        int dropType = mobPushNotifyMessage.getDropType();
        if (dropType == 2) {
            l.a().a(mobPushNotifyMessage);
        } else {
            if (dropType != 3) {
                return;
            }
            l.a().a(mobPushNotifyMessage.getDropId(), 0);
        }
    }

    public static void a(MobPushNotifyMessage mobPushNotifyMessage) {
        if (mobPushNotifyMessage == null) {
            return;
        }
        PLog.getInstance().d("ShowNotification --- \n" + mobPushNotifyMessage.toString(), new Object[0]);
        if ((!h.a(mobPushNotifyMessage) || h.b(mobPushNotifyMessage)) && !b()) {
            l.a().b(mobPushNotifyMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.c.remove(str);
    }

    public static void a(MobPushCustomMessage mobPushCustomMessage, int i) {
        if (mobPushCustomMessage == null) {
            return;
        }
        PLog.getInstance().d("ShowAdNotification --- \n" + mobPushCustomMessage.toString(), new Object[0]);
        if (b() || MobPush.Channels.VIVO.equalsIgnoreCase(com.mob.pushsdk.b.h.a().c())) {
            return;
        }
        com.mob.pushsdk.a.a.a().a(mobPushCustomMessage, i);
    }

    public void a(Message message) {
        final byte[] byteArray;
        try {
            Bundle data = message.getData();
            if (data == null || (byteArray = data.getByteArray("content")) == null) {
                return;
            }
            String strI = com.mob.pushsdk.biz.a.i();
            if (strI == null) {
                com.mob.pushsdk.biz.e.b(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.k.2
                    @Override // com.mob.pushsdk.biz.b
                    public void b(Object obj) {
                        super.b(obj);
                        k.this.a((String) obj, byteArray);
                    }
                });
            } else {
                a(strI, byteArray);
            }
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr) {
        try {
            byte[] bArrDecode = Base64.decode(bArr, 2);
            PLog.getInstance().d("MobPush parseSocketMessage rid:" + str, new Object[0]);
            byte[] bArrAES128Decode = Data.AES128Decode(String.format("%16s", str).replaceAll(MyUTIL.white_space, "0").getBytes(), bArrDecode);
            String str2 = new String(bArrAES128Decode, "utf-8");
            PLog.getInstance().d("MobPush parseSocketMessage result:" + str2, new Object[0]);
            if (((HashMap) new Hashon().fromJson(str2).get("data")) == null) {
                return;
            }
            a(bArrAES128Decode);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public void a(byte[] bArr) {
        Message message = new Message();
        message.what = 1;
        message.obj = bArr;
        this.d.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(String str, int i, boolean z, int i2) {
        for (ReceivedMsg receivedMsg : this.g) {
            if (TextUtils.isEmpty(receivedMsg.msgId)) {
                return true;
            }
            if (receivedMsg.msgId.equals(str)) {
                return true;
            }
        }
        if (j.a().a(str, i, z, i2 == 1)) {
            return true;
        }
        ReceivedMsg receivedMsg2 = new ReceivedMsg(str);
        a().g.add(receivedMsg2);
        com.mob.pushsdk.biz.d.a(receivedMsg2);
        return false;
    }

    public void a(int i, int i2, MobPushCustomMessage mobPushCustomMessage, MobPushNotifyMessage mobPushNotifyMessage, long j) {
        try {
            int i3 = this.f17698e + 1;
            this.f17698e = i3;
            com.mob.pushsdk.biz.d.b(i3);
            Intent intent = new Intent("com.mob.push.intent.TIMING_MESSAGE");
            intent.putExtra("pushType", i2);
            intent.putExtra("count", this.f17698e);
            intent.putExtra("showTemplate", i);
            if (i2 == 1) {
                if (mobPushNotifyMessage != null && !TextUtils.isEmpty(mobPushNotifyMessage.getMessageId())) {
                    a(mobPushNotifyMessage.getMessageId(), mobPushNotifyMessage);
                    intent.putExtra("msgId", mobPushNotifyMessage.getMessageId());
                }
            } else if (mobPushCustomMessage != null && !TextUtils.isEmpty(mobPushCustomMessage.getMessageId())) {
                a(mobPushCustomMessage.getMessageId(), mobPushCustomMessage);
                intent.putExtra("msgId", mobPushCustomMessage.getMessageId());
            }
            PendingIntent pendingIntentB = com.mob.pushsdk.b.g.b(MobSDK.getContext(), this.f17698e, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) MobSDK.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.setTimeInMillis(j);
            alarmManager.setExactAndAllowWhileIdle(0, calendar.getTimeInMillis(), pendingIntentB);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    private void a(String str, Object obj) {
        this.c.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str) {
        return this.c.get(str);
    }
}
