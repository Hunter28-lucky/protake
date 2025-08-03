package com.mob.pushsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.MobPushCustomNotification;
import com.mob.pushsdk.MobPushLocalNotification;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushResult;
import com.mob.pushsdk.MobPushTailorNotification;
import com.mob.pushsdk.base.PLog;
import com.mob.pushsdk.impl.o;
import com.mob.socketservice.ConnectManager;
import com.mob.socketservice.MobConnect;
import com.mob.socketservice.ServiceMessageData;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class m {
    private final int[] a;
    private volatile boolean b;
    private volatile c c;
    private com.mob.pushsdk.plugins.b d;

    /* renamed from: e, reason: collision with root package name */
    private g f17700e;
    private HashMap<String, com.mob.pushsdk.MobPushReceiver> f;
    private Handler g;
    private WeakReference<MobPushCallback> h;
    private ExecutorService i;

    public static class a {
        private static m a = new m();
    }

    public abstract class b {
        public String d;

        public b(String str) {
            this.d = str;
        }

        public abstract boolean a(boolean z) throws Throwable;
    }

    private void n() {
        PLog.getInstance().d("MobPush start clean badge", new Object[0]);
        l.a().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Set<ReceivedMsg> setU = com.mob.pushsdk.biz.d.u();
        if (setU == null) {
            return;
        }
        HashSet<ReceivedMsg> hashSet = new HashSet();
        hashSet.addAll(setU);
        for (ReceivedMsg receivedMsg : hashSet) {
            if (receivedMsg.isExpired()) {
                setU.remove(receivedMsg);
            }
        }
        com.mob.pushsdk.biz.d.a(setU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.g = MobHandlerThread.newHandler(new Handler.Callback() { // from class: com.mob.pushsdk.impl.m.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                PLog.getInstance().d("MobPush implHandler message:" + message.toString(), new Object[0]);
                int i = message.what;
                if (i == 0) {
                    m.this.a((o.a) null);
                } else if (i == 1) {
                    d.a().b();
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BroadcastReceiver q() {
        return new BroadcastReceiver() { // from class: com.mob.pushsdk.impl.m.23
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, final Intent intent) {
                MobPushNotifyMessage mobPushNotifyMessage;
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                PLog.getInstance().d(context.getPackageName() + " action: " + action, new Object[0]);
                if (!action.equals("com.mob.push.intent.NOTIFICATION_OPENED")) {
                    if (action.equals("android.intent.action.USER_PRESENT") || action.equals("android.net.conn.CONNECTIVITY_CHANGE") || action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED") || action.equals("android.intent.action.ACTION_POWER_CONNECTED") || action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        if (m.this.g != null) {
                            m.this.g.sendEmptyMessage(0);
                            return;
                        } else {
                            m.this.p();
                            return;
                        }
                    }
                    return;
                }
                if (m.this.a(new b("setNotificationOpened") { // from class: com.mob.pushsdk.impl.m.23.1
                    {
                        m mVar = m.this;
                    }

                    @Override // com.mob.pushsdk.impl.m.b
                    public boolean a(boolean z) throws Throwable {
                        MobPushNotifyMessage mobPushNotifyMessage2;
                        if (z) {
                            try {
                                mobPushNotifyMessage2 = (MobPushNotifyMessage) ResHelper.forceCast(intent.getExtras().getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
                            } catch (Throwable th) {
                                PLog.getInstance().d(th);
                            }
                            if (e.c.contains(mobPushNotifyMessage2.getMessageId())) {
                                PLog.getInstance().d(mobPushNotifyMessage2.getMessageId() + ",hasCb", new Object[0]);
                                return true;
                            }
                            e.c.add(mobPushNotifyMessage2.getMessageId());
                            m.this.c.a(intent.getExtras());
                        }
                        return true;
                    }
                }) || m.this.f17700e == null) {
                    return;
                }
                try {
                    mobPushNotifyMessage = (MobPushNotifyMessage) ResHelper.forceCast(intent.getExtras().getSerializable(NotificationCompat.CATEGORY_MESSAGE), null);
                } catch (Throwable th) {
                    PLog.getInstance().d(th);
                }
                if (!e.c.contains(mobPushNotifyMessage.getMessageId())) {
                    e.c.add(mobPushNotifyMessage.getMessageId());
                    m.this.f17700e.a(MobSDK.getContext(), intent);
                    return;
                }
                PLog.getInstance().d(mobPushNotifyMessage.getMessageId() + ",hasCb", new Object[0]);
            }
        };
    }

    private synchronized void r() {
        try {
            PLog.getInstance().d("MobPush --PushPluginsManager init--", new Object[0]);
            if (this.d == null) {
                this.d = new com.mob.pushsdk.plugins.b();
            }
        } finally {
        }
    }

    public void j() {
        a(new b("cleanTags") { // from class: com.mob.pushsdk.impl.m.24
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.h();
            }
        });
    }

    public void k() {
        a(new b("removeTailorNotification") { // from class: com.mob.pushsdk.impl.m.26
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.j();
            }
        });
    }

    public boolean l() {
        return a(new b("clearLocalNotifications") { // from class: com.mob.pushsdk.impl.m.29
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.i();
            }
        });
    }

    public boolean m() {
        return com.mob.pushsdk.biz.d.t();
    }

    private m() {
        this.a = new int[]{-1};
        this.b = false;
        this.f = new HashMap<>();
        this.i = Executors.newFixedThreadPool(5);
        if (com.mob.pushsdk.b.h.a().d()) {
            new Thread() { // from class: com.mob.pushsdk.impl.m.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    m.this.o();
                    if (com.mob.pushsdk.biz.d.h()) {
                        return;
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
                    intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                    intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                    intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                    intentFilter.addAction("com.mob.push.intent.NOTIFICATION_OPENED");
                    try {
                        ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", m.this.q(), intentFilter);
                    } catch (Throwable th) {
                        PLog.getInstance().e(th.toString(), new Object[0]);
                    }
                    m.this.a((o.a) null);
                    com.mob.pushsdk.b.c.a().b();
                }
            }.start();
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(o.a aVar) {
        try {
            r();
            n();
            this.f17700e = new g();
            this.f17700e.a((com.mob.pushsdk.MobPushReceiver) Proxy.newProxyInstance(AnonymousClass34.class.getClassLoader(), this.f17700e.getClass().getInterfaces(), new InvocationHandler() { // from class: com.mob.pushsdk.impl.m.34
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, final Method method, final Object[] objArr) throws Throwable {
                    if (com.mob.pushsdk.biz.d.h()) {
                        return null;
                    }
                    for (final Map.Entry entry : m.this.f.entrySet()) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.pushsdk.impl.m.34.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                try {
                                    method.invoke(entry.getValue(), objArr);
                                    return false;
                                } catch (Throwable th) {
                                    PLog.getInstance().d(th);
                                    return false;
                                }
                            }
                        });
                    }
                    return null;
                }
            }));
            if (this.c == null) {
                this.c = c.a();
                this.c.a(this.f17700e);
                String strI = com.mob.pushsdk.biz.a.i();
                PLog.getInstance().d("MobPush realBindService2 rid:" + strI + ",process:" + Process.myPid(), new Object[0]);
                ServiceMessageData serviceMessageData = new ServiceMessageData();
                serviceMessageData.setRid(strI);
                serviceMessageData.setAppKey(MobSDK.getAppkey());
                serviceMessageData.setAppSecret(MobSDK.getAppSecret());
                HashMap<Integer, String> map = new HashMap<>();
                map.put(9001, "content");
                serviceMessageData.setTypeMap(map);
                serviceMessageData.setTokenMap(com.mob.pushsdk.biz.a.a(false));
                MobConnect.bindService(MobSDK.getContext(), serviceMessageData, d(aVar));
            }
        } finally {
        }
    }

    private ConnectManager.ServiceConnectionListener d(final o.a aVar) {
        return new ConnectManager.ServiceConnectionListener() { // from class: com.mob.pushsdk.impl.PushSDKImpl$6
            @Override // com.mob.socketservice.ConnectManager.ServiceConnectionListener
            public void onPushTcpStatus(boolean z) {
                MobPushCallback mobPushCallback;
                try {
                    if (this.this$0.h == null || (mobPushCallback = (MobPushCallback) this.this$0.h.get()) == null) {
                        return;
                    }
                    mobPushCallback.onCallback(Boolean.valueOf(z));
                } catch (Throwable th) {
                    PLog.getInstance().e(th);
                }
            }

            @Override // com.mob.socketservice.ConnectManager.ServiceConnectionListener
            public void onServiceConnected() {
                if (this.this$0.g != null) {
                    this.this$0.g.sendEmptyMessage(1);
                }
                o.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.mob.socketservice.ConnectManager.ServiceConnectionListener
            public void onServiceDisconnected() {
                o.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.mob.socketservice.ConnectManager.ServiceConnectionListener
            public void onServiceResponseMessage(Message message) {
                try {
                    if (message.what != 9001) {
                        return;
                    }
                    if (com.mob.pushsdk.biz.d.h()) {
                        PLog.getInstance().d("MobPush onServiceResponseMessage isPushServiceStopped", new Object[0]);
                        return;
                    }
                    PLog.getInstance().d("MobPush realBindService2 onServiceResponseMessage:" + message.toString(), new Object[0]);
                    k.a().a(message);
                } catch (Throwable th) {
                    PLog.getInstance().e(th.toString(), new Object[0]);
                }
            }
        };
    }

    public void e() {
        a(new b("restartPush") { // from class: com.mob.pushsdk.impl.m.9
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.c();
            }
        });
        r();
        com.mob.pushsdk.plugins.b bVar = this.d;
        if (bVar != null) {
            bVar.d();
        }
    }

    public boolean f() {
        return this.c != null ? this.c.d() : com.mob.pushsdk.biz.d.h();
    }

    public void g() {
        a(new b("getAlias") { // from class: com.mob.pushsdk.impl.m.13
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.e();
            }
        });
    }

    public void h() {
        a(new b("deleteAlias") { // from class: com.mob.pushsdk.impl.m.14
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.f();
            }
        });
    }

    public void i() {
        a(new b("getTags") { // from class: com.mob.pushsdk.impl.m.17
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.g();
            }
        });
    }

    public void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        } else {
            p();
        }
    }

    public void d() {
        a(new b("stopPush") { // from class: com.mob.pushsdk.impl.m.8
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.b();
            }
        });
        r();
        com.mob.pushsdk.plugins.b bVar = this.d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public static m a() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(o.a aVar) {
        try {
            MobConnect.init();
            if (this.c == null) {
                b(aVar);
            }
        } catch (Throwable th) {
            com.mob.pushsdk.b.d.a().d("MobConnect not import:" + th.toString());
        }
    }

    private synchronized void b(final o.a aVar) {
        new Thread() { // from class: com.mob.pushsdk.impl.m.33
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    synchronized (m.this.a) {
                        if (m.this.a[0] == -1) {
                            m.this.a[0] = com.mob.pushsdk.impl.a.a(500, Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 30) ? 1 : 0;
                            if (m.this.a[0] == 1) {
                                m.this.c(aVar);
                            } else {
                                o.a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.b();
                                }
                            }
                        } else if (m.this.a[0] == 1) {
                            m.this.c(aVar);
                        } else {
                            m.this.a[0] = com.mob.pushsdk.impl.a.a() ? 1 : 0;
                            if (m.this.a[0] == 1) {
                                m.this.c(aVar);
                            } else {
                                o.a aVar3 = aVar;
                                if (aVar3 != null) {
                                    aVar3.b();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    PLog.getInstance().e(th);
                }
            }
        }.start();
    }

    public void e(int i) {
        try {
            com.mob.pushsdk.biz.d.a(i);
            PLog.getInstance().d("setDomainAbroad：" + i, new Object[0]);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public void d(final Bundle bundle) {
        a(new b("askHWPushClick") { // from class: com.mob.pushsdk.impl.m.21
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.e(bundle);
            }
        });
    }

    public void d(int i) {
        l.a().b(i);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.mob.pushsdk.b.d.a().c("MobPush setDeviceToken deviceToken is null");
            return;
        }
        com.mob.pushsdk.b.d.a().a("MobPush setDeviceToken:" + str + ",channel:" + com.mob.pushsdk.biz.d.f());
        com.mob.pushsdk.biz.d.c(str);
        new Thread(new Runnable() { // from class: com.mob.pushsdk.impl.m.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.mob.pushsdk.biz.e.b(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.m.2.1
                        @Override // com.mob.pushsdk.biz.b
                        public void b(Object obj) {
                            super.b(obj);
                            com.mob.pushsdk.biz.a.h();
                        }
                    });
                } catch (Throwable th) {
                    PLog.getInstance().d(th);
                }
            }
        }).start();
    }

    public void d(final boolean z) {
        a(new b("setAppForegroundHiddenNotification") { // from class: com.mob.pushsdk.impl.m.30
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z2) throws Throwable {
                return z2 && m.this.c.b(z);
            }
        });
    }

    public void e(final boolean z) {
        a(new b("setShowBadge") { // from class: com.mob.pushsdk.impl.m.31
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z2) throws Throwable {
                return z2 && m.this.c.c(z);
            }
        });
    }

    public void d(MobPushCallback mobPushCallback) {
        if (mobPushCallback != null) {
            this.h = new WeakReference<>(mobPushCallback);
        }
        MobConnect.checkTcpStatus();
    }

    public void a(final String str) {
        try {
            PLog.getInstance().d("MobPush bindPlugin:" + str, new Object[0]);
            if (TextUtils.isEmpty(com.mob.pushsdk.biz.d.e())) {
                PLog.getInstance().d("MobPush bindPlugin refresh new DeviceToken:" + str, new Object[0]);
                com.mob.pushsdk.biz.d.c(str);
                new Thread(new Runnable() { // from class: com.mob.pushsdk.impl.m.35
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.mob.pushsdk.biz.e.b(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.m.35.1
                                @Override // com.mob.pushsdk.biz.b
                                public void b(Object obj) {
                                    super.b(obj);
                                    com.mob.pushsdk.biz.a.h();
                                }
                            });
                        } catch (Throwable th) {
                            PLog.getInstance().e(th);
                        }
                    }
                }).start();
            }
            a(new b("bindPlugin") { // from class: com.mob.pushsdk.impl.m.36
                @Override // com.mob.pushsdk.impl.m.b
                public boolean a(boolean z) throws Throwable {
                    return z && m.this.c.b(str);
                }
            });
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    private void b(String str, String str2) {
        if (str == null) {
            com.mob.pushsdk.b.d.a().d("notificationClickAck id is null");
            return;
        }
        com.mob.pushsdk.b.d.a().a("notificationClickAck id:" + str + ",ch:" + str2);
        com.mob.pushsdk.biz.e.a(new String[]{str}, str2, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.m.3
            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                super.b(obj);
                com.mob.pushsdk.b.d.a().a("notificationClickAck success");
            }
        });
    }

    public void b(final MobPushCallback<String> mobPushCallback) {
        a(new b("getPhoneNum") { // from class: com.mob.pushsdk.impl.m.6
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(mobPushCallback);
            }
        });
    }

    public void a(final MobPushCallback<String> mobPushCallback) {
        String strE = com.mob.pushsdk.biz.d.e();
        if (!TextUtils.isEmpty(strE)) {
            com.mob.pushsdk.b.d.a().a("MobPush getDeviceToken:" + strE);
            mobPushCallback.onCallback(strE);
            return;
        }
        new Thread(new Runnable() { // from class: com.mob.pushsdk.impl.m.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strE2 = com.mob.pushsdk.biz.d.e();
                    if (com.mob.pushsdk.plugins.b.b() != null && TextUtils.isEmpty(strE2)) {
                        int i = ((int) 3000) / 500;
                        while (TextUtils.isEmpty(strE2) && i > 0) {
                            i--;
                            try {
                                Thread.sleep(500L);
                            } catch (Throwable th) {
                                PLog.getInstance().e(th);
                            }
                            strE2 = com.mob.pushsdk.biz.d.e();
                            com.mob.pushsdk.b.d.a().a("MobPush getDeviceToken:" + strE2 + ",maxCount:" + i);
                        }
                    }
                    com.mob.pushsdk.b.d.a().a("MobPush getDeviceToken:" + strE2);
                    mobPushCallback.onCallback(strE2);
                } catch (Throwable th2) {
                    PLog.getInstance().e(th2);
                    mobPushCallback.onCallback("");
                }
            }
        }).start();
    }

    public void b(com.mob.pushsdk.MobPushReceiver mobPushReceiver) {
        if (mobPushReceiver != null) {
            this.f.remove(mobPushReceiver.getClass().getName());
        }
    }

    public void b(final boolean z) {
        a(new b("setClickNotificationToLaunchMainActivity") { // from class: com.mob.pushsdk.impl.m.7
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z2) throws Throwable {
                return z2 && m.this.c.a(z ^ true);
            }
        });
    }

    public void b(final String[] strArr) {
        a(new b("addTags") { // from class: com.mob.pushsdk.impl.m.16
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.b(strArr);
            }
        });
    }

    public void b(final Bundle bundle) {
        a(new b("doPluginOperation") { // from class: com.mob.pushsdk.impl.m.19
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.c(bundle);
            }
        });
    }

    public boolean b(final int i) {
        return a(new b("removeLocalNotification") { // from class: com.mob.pushsdk.impl.m.28
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(i);
            }
        });
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.mob.pushsdk.b.d.a().c("MobPush setDeviceToken channel is null");
        } else {
            com.mob.pushsdk.biz.d.d(str);
            b(str2);
        }
    }

    public void c() {
        com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
        if (aVarB != null) {
            aVarB.cancelAllNotification();
        }
        l();
    }

    public void a(Intent intent) {
        Uri data;
        if (intent == null) {
            return;
        }
        try {
            Bundle extras = intent.getExtras();
            if (intent.getBooleanExtra("from_tcp", false)) {
                return;
            }
            if (extras != null) {
                if (com.mob.pushsdk.plugins.b.a().g()) {
                    for (String str : extras.keySet()) {
                        if (PushMessageHelper.KEY_MESSAGE.equals(str)) {
                            Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
                            MiPushMessage miPushMessage = (MiPushMessage) extras.getSerializable(str);
                            if (miPushMessage != null && miPushMessage.getExtra() != null && miPushMessage.getExtra().containsKey("id")) {
                                b(miPushMessage.getExtra().get("id"), miPushMessage.getExtra().get("channel"));
                                return;
                            }
                        }
                    }
                } else if (com.mob.pushsdk.plugins.b.a().f()) {
                    for (String str2 : extras.keySet()) {
                        if (NotificationCompat.CATEGORY_MESSAGE.equals(str2)) {
                            Class.forName("com.mob.pushsdk.MobPushNotifyMessage");
                            MobPushNotifyMessage mobPushNotifyMessage = (MobPushNotifyMessage) extras.getSerializable(str2);
                            if (mobPushNotifyMessage != null && mobPushNotifyMessage.getExtrasMap() != null && mobPushNotifyMessage.getExtrasMap().containsKey("id")) {
                                String str3 = mobPushNotifyMessage.getExtrasMap().get("id").split("_")[0];
                                String str4 = mobPushNotifyMessage.getExtrasMap().get("channel");
                                if (!TextUtils.isEmpty(str3)) {
                                    b(str3, str4);
                                    return;
                                }
                            }
                        }
                    }
                }
                b(extras.getString("id", "").split("_")[0], extras.getString("channel"));
                return;
            }
            if (!com.mob.pushsdk.plugins.b.a().e() || (data = intent.getData()) == null) {
                return;
            }
            b(data.getQueryParameter("id"), data.getQueryParameter("channel"));
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
    }

    public void c(final MobPushCallback<String> mobPushCallback) {
        a(new b("getRegistrationId") { // from class: com.mob.pushsdk.impl.m.10
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                if (z) {
                    m.this.c.b(mobPushCallback);
                    return true;
                }
                MobPushCallback mobPushCallback2 = mobPushCallback;
                if (mobPushCallback2 == null) {
                    return true;
                }
                mobPushCallback2.onCallback(null);
                return true;
            }
        });
    }

    public void c(final String str) {
        a(new b("setAlias") { // from class: com.mob.pushsdk.impl.m.11
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(str);
            }
        });
    }

    public void c(final Bundle bundle) {
        a(new b("doPluginShowNotify") { // from class: com.mob.pushsdk.impl.m.20
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.d(bundle);
            }
        });
    }

    public void c(final String[] strArr) {
        a(new b("deleteTags") { // from class: com.mob.pushsdk.impl.m.22
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.c(strArr);
            }
        });
    }

    public void c(int i) {
        l.a().a(i);
    }

    public void c(boolean z) {
        l.a().a(z);
    }

    public void a(boolean z) {
        com.mob.pushsdk.biz.d.a(z);
    }

    public void a(final MobPushLocalNotification mobPushLocalNotification, final MobPushCallback<MobPushResult> mobPushCallback) {
        if (mobPushLocalNotification == null) {
            mobPushCallback.onCallback(new MobPushResult(-3, "local notification is null"));
        } else {
            a(new b("sendLocalNotification") { // from class: com.mob.pushsdk.impl.m.4
                @Override // com.mob.pushsdk.impl.m.b
                public boolean a(boolean z) throws Throwable {
                    if (z) {
                        m.this.c.a(mobPushLocalNotification, mobPushCallback);
                        return true;
                    }
                    MobPushCallback mobPushCallback2 = mobPushCallback;
                    if (mobPushCallback2 == null) {
                        return true;
                    }
                    mobPushCallback2.onCallback(new MobPushResult(-1, "local notification failed, please try again later"));
                    return true;
                }
            });
        }
    }

    public void a(int i) {
        try {
            com.mob.pushsdk.plugins.a aVarB = com.mob.pushsdk.plugins.b.b();
            if (com.mob.pushsdk.biz.d.t()) {
                if (aVarB != null && (aVarB instanceof com.mob.pushsdk.plugins.fcm.b)) {
                    i = 0;
                }
                com.mob.pushsdk.impl.b.a().a(i);
                return;
            }
            com.mob.pushsdk.impl.b.a().a(0);
        } catch (Throwable th) {
            PLog.getInstance().e("synchronize badge count, error: " + th.getMessage(), new Object[0]);
        }
    }

    public void a(final String str, final MobPushCallback<Boolean> mobPushCallback) {
        a(new b("bindPhoneNum") { // from class: com.mob.pushsdk.impl.m.5
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                if (z) {
                    m.this.c.a(str, mobPushCallback);
                    return true;
                }
                MobPushCallback mobPushCallback2 = mobPushCallback;
                if (mobPushCallback2 == null) {
                    return true;
                }
                mobPushCallback2.onCallback(null);
                return true;
            }
        });
    }

    public void a(com.mob.pushsdk.MobPushReceiver mobPushReceiver) {
        if (mobPushReceiver != null) {
            String name = mobPushReceiver.getClass().getName();
            if (this.f.containsKey(name)) {
                return;
            }
            this.f.put(name, mobPushReceiver);
        }
    }

    public void a(final String[] strArr) {
        a(new b("replaceTags") { // from class: com.mob.pushsdk.impl.m.15
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(strArr);
            }
        });
    }

    public void a(final Bundle bundle) {
        a(new b("doPluginReceiver") { // from class: com.mob.pushsdk.impl.m.18
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.b(bundle);
            }
        });
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i < 0 || i > 23) {
            i = 0;
        }
        if (i2 < 0 || i2 > 59) {
            i2 = 0;
        }
        if (i3 < 0 || i3 > 23) {
            i3 = 0;
        }
        if (i4 < 0 || i4 > 59) {
            i4 = 0;
        }
        l.a().a(i, i2, i3, i4);
    }

    public void a(MobPushCustomNotification mobPushCustomNotification) {
        l.a().a(mobPushCustomNotification);
    }

    public <T extends MobPushTailorNotification> void a(final Class<T> cls) {
        a(new b("setTailorNotification") { // from class: com.mob.pushsdk.impl.m.25
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(cls);
            }
        });
    }

    public boolean a(final MobPushLocalNotification mobPushLocalNotification) {
        return a(new b("addLocalNotification") { // from class: com.mob.pushsdk.impl.m.27
            @Override // com.mob.pushsdk.impl.m.b
            public boolean a(boolean z) throws Throwable {
                return z && m.this.c.a(mobPushLocalNotification);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final b bVar) {
        if (!com.mob.pushsdk.b.h.a().d() || bVar == null) {
            return false;
        }
        if (this.c != null) {
            try {
                boolean zA = bVar.a(true);
                PLog.getInstance().d(bVar.d + ":getService success", new Object[0]);
                return zA;
            } catch (Throwable th) {
                PLog.getInstance().e(th);
                this.c = null;
                return false;
            }
        }
        this.i.execute(new Runnable() { // from class: com.mob.pushsdk.impl.m.32
            @Override // java.lang.Runnable
            public void run() {
                m.this.a(new o.a() { // from class: com.mob.pushsdk.impl.m.32.1
                    @Override // com.mob.pushsdk.impl.o.a
                    public void a() {
                        if (m.this.c == null) {
                            try {
                                PLog.getInstance().d(bVar.d + ":getService failed", new Object[0]);
                                bVar.a(false);
                                return;
                            } catch (Throwable th2) {
                                PLog.getInstance().e(th2);
                                return;
                            }
                        }
                        try {
                            bVar.a(true);
                            PLog.getInstance().d(bVar.d + ":getService success", new Object[0]);
                        } catch (Throwable th3) {
                            PLog.getInstance().e(th3);
                            PLog.getInstance().e(bVar.d + ":getService failed", new Object[0]);
                            try {
                                bVar.a(false);
                            } catch (Throwable th4) {
                                PLog.getInstance().e(th4);
                            }
                        }
                    }

                    @Override // com.mob.pushsdk.impl.o.a
                    public void b() {
                        PLog.getInstance().d(bVar.d + ":getService disconnected", new Object[0]);
                        try {
                            bVar.a(false);
                        } catch (Throwable th2) {
                            PLog.getInstance().e(th2);
                        }
                    }
                });
            }
        });
        return true;
    }
}
