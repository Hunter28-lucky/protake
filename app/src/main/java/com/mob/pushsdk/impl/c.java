package com.mob.pushsdk.impl;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPushCallback;
import com.mob.pushsdk.MobPushLocalNotification;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.MobPushResult;
import com.mob.pushsdk.MobPushTailorNotification;
import com.mob.pushsdk.base.PLog;
import com.mob.socketservice.ConnectManager;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class c extends o {
    private g a;
    private Set<MobPushCallback<String>> b;
    private volatile Object c;
    private Set<MobPushCallback<Boolean>> d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f17694e;
    private String f;
    private HashMap<String, MobPushCallback<MobPushResult>> g;

    /* renamed from: com.mob.pushsdk.impl.c$13, reason: invalid class name */
    public class AnonymousClass13 extends com.mob.pushsdk.biz.b {
        public final /* synthetic */ MobPushCallback a;

        public AnonymousClass13(MobPushCallback mobPushCallback) {
            this.a = mobPushCallback;
        }

        @Override // com.mob.pushsdk.biz.b
        public void a(final int i, final Throwable th) {
            super.a(i, th);
            UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.13.2
                @Override // com.mob.pushsdk.impl.f
                public boolean a(Message message) {
                    com.mob.pushsdk.b.d.a().d("getMobile error:" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + th.toString());
                    AnonymousClass13.this.a.onCallback(null);
                    return false;
                }
            });
        }

        @Override // com.mob.pushsdk.biz.b
        public void b(final Object obj) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.pushsdk.impl.c.13.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    try {
                        HashMap map = (HashMap) obj;
                        if (map != null) {
                            AnonymousClass13.this.a.onCallback((String) map.get("mobile"));
                        }
                    } catch (Throwable th) {
                        AnonymousClass13.this.a(0, th);
                    }
                    return false;
                }
            });
        }
    }

    /* renamed from: com.mob.pushsdk.impl.c$14, reason: invalid class name */
    public class AnonymousClass14 extends Thread {
        public final /* synthetic */ MobPushCallback a;

        public AnonymousClass14(MobPushCallback mobPushCallback) {
            this.a = mobPushCallback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                com.mob.pushsdk.biz.e.b(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.14.1
                    @Override // com.mob.pushsdk.biz.b
                    public void b(final Object obj) {
                        if (c.this.b == null || c.this.b.size() <= 0) {
                            return;
                        }
                        UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.14.1.1
                            @Override // com.mob.pushsdk.impl.f
                            public boolean a(Message message) {
                                if (c.this.b == null || c.this.b.size() <= 0) {
                                    return false;
                                }
                                Iterator it = c.this.b.iterator();
                                while (it.hasNext()) {
                                    ((MobPushCallback) it.next()).onCallback(obj);
                                }
                                c.this.b.clear();
                                c.this.b = null;
                                return false;
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                PLog.getInstance().e(th);
                if (this.a != null) {
                    UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.14.2
                        @Override // com.mob.pushsdk.impl.f
                        public boolean a(Message message) {
                            if (c.this.b == null) {
                                return false;
                            }
                            AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                            if (anonymousClass14.a == null) {
                                return false;
                            }
                            c.this.b.remove(AnonymousClass14.this.a);
                            AnonymousClass14.this.a.onCallback(null);
                            return false;
                        }
                    });
                }
            }
        }
    }

    public static class a {
        private static final c a = new c();
    }

    public boolean e() throws Throwable {
        com.mob.pushsdk.biz.e.c(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.16
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putInt("errorCode", i);
                bundle.putInt("operation", 0);
                bundle.putBoolean("result", false);
                c.this.a(3003, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    HashMap map = (HashMap) obj;
                    String str = map == null ? null : (String) map.get("alias");
                    Bundle bundle = new Bundle();
                    bundle.putString("alias", str);
                    bundle.putInt("operation", 0);
                    bundle.putBoolean("result", true);
                    c.this.a(3003, bundle);
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean f() throws Throwable {
        com.mob.pushsdk.biz.e.a((String) null, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.17
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 2);
                bundle.putBoolean("result", false);
                bundle.putInt("errorCode", i);
                c.this.a(3004, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                Bundle bundle = new Bundle();
                bundle.putString("last_alias", com.mob.pushsdk.biz.d.q());
                bundle.putInt("operation", 2);
                bundle.putBoolean("result", true);
                c.this.a(3004, bundle);
                com.mob.pushsdk.biz.d.g("");
            }
        });
        return true;
    }

    public boolean g() throws Throwable {
        com.mob.pushsdk.biz.e.d(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.4
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 0);
                bundle.putInt("errorCode", i);
                bundle.putBoolean("result", false);
                c.this.a(3006, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    HashMap map = (HashMap) obj;
                    ArrayList arrayList = map == null ? null : (ArrayList) map.get("tags");
                    Bundle bundle = new Bundle();
                    if (arrayList == null || arrayList.size() <= 0) {
                        bundle.putStringArray("tags", null);
                    } else {
                        bundle.putStringArray("tags", (String[]) arrayList.toArray((String[]) arrayList.toArray(new String[arrayList.size()])));
                    }
                    bundle.putInt("operation", 0);
                    bundle.putBoolean("result", true);
                    c.this.a(3006, bundle);
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean h() throws Throwable {
        com.mob.pushsdk.biz.e.d(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.6
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 3);
                bundle.putInt("errorCode", i);
                bundle.putBoolean("result", false);
                c.this.a(3008, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    HashMap map = (HashMap) obj;
                    ArrayList arrayList = map == null ? null : (ArrayList) map.get("tags");
                    if (arrayList != null && arrayList.size() > 0) {
                        com.mob.pushsdk.biz.e.a((String[]) arrayList.toArray(new String[0]), 2, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.6.1
                            @Override // com.mob.pushsdk.biz.b
                            public void a(int i, Throwable th) {
                                super.a(i, th);
                                Bundle bundle = new Bundle();
                                bundle.putInt("operation", 3);
                                bundle.putInt("errorCode", i);
                                bundle.putBoolean("result", false);
                                c.this.a(3008, bundle);
                            }

                            @Override // com.mob.pushsdk.biz.b
                            public void b(Object obj2) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("operation", 3);
                                bundle.putString("last_tags", com.mob.pushsdk.biz.d.r());
                                bundle.putBoolean("result", true);
                                c.this.a(3008, bundle);
                                com.mob.pushsdk.biz.d.h("");
                            }
                        });
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("operation", 3);
                    bundle.putString("last_tags", "");
                    bundle.putBoolean("result", true);
                    c.this.a(3008, bundle);
                    com.mob.pushsdk.biz.d.h("");
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean i() throws Throwable {
        HashMap<String, MobPushCallback<MobPushResult>> map = this.g;
        if (map != null) {
            map.clear();
        }
        h.a().b();
        return true;
    }

    public boolean j() throws Throwable {
        com.mob.pushsdk.biz.d.f("");
        l.a().a((String) null);
        return true;
    }

    private c() {
        this.c = new Object();
        this.f17694e = new Object();
        this.f = "";
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.mob.push.intent.NOTIFICATION_OPENED");
            intentFilter.addAction("com.mob.push.intent.NOTIFICATION_DELETE");
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", new Object[]{new NotifyActionReceiver(), intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
        } catch (Throwable th) {
            PLog.getInstance().e(th.toString(), new Object[0]);
        }
    }

    public boolean c(boolean z) throws Throwable {
        com.mob.pushsdk.biz.d.f(z);
        l.a().b();
        return true;
    }

    public boolean d() {
        return com.mob.pushsdk.biz.d.h();
    }

    public boolean e(Bundle bundle) throws Throwable {
        com.mob.pushsdk.biz.e.b(bundle.getStringArray("hwId"), bundle.getString("mobRegId"), (com.mob.pushsdk.biz.b) null);
        return true;
    }

    public boolean b(boolean z) throws Throwable {
        com.mob.pushsdk.biz.d.e(z);
        PLog.getInstance().d("setAppForegroundHiddenNotification：" + z, new Object[0]);
        return true;
    }

    public boolean d(Bundle bundle) throws Throwable {
        if (bundle == null) {
            return false;
        }
        k.a((MobPushNotifyMessage) bundle.getSerializable(NotificationCompat.CATEGORY_MESSAGE));
        if (bundle.getInt("action") == -1) {
            return false;
        }
        a(2104, bundle);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final MobPushCallback<Boolean> mobPushCallback) {
        UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.11
            @Override // com.mob.pushsdk.impl.f
            public boolean a(Message message) {
                if (c.this.d == null || mobPushCallback == null) {
                    return false;
                }
                c.this.d.remove(mobPushCallback);
                mobPushCallback.onCallback(Boolean.FALSE);
                return false;
            }
        });
    }

    public boolean b() throws Throwable {
        PLog.getInstance().d("MobPush clientWorker stopPush", new Object[0]);
        com.mob.pushsdk.biz.d.b(true);
        ConnectManager.getInstance().setPushServiceCloseStatus(true);
        com.mob.pushsdk.biz.a.f();
        return true;
    }

    public boolean c() throws Throwable {
        PLog.getInstance().d("MobPush clientWorker restartPush", new Object[0]);
        com.mob.pushsdk.biz.d.b(false);
        ConnectManager.getInstance().setPushServiceCloseStatus(false);
        com.mob.pushsdk.biz.a.f();
        return true;
    }

    public static c a() {
        return a.a;
    }

    public boolean a(boolean z) throws Throwable {
        com.mob.pushsdk.biz.d.c(z);
        return true;
    }

    public void a(g gVar) {
        this.a = gVar;
    }

    public void a(final MobPushLocalNotification mobPushLocalNotification, final MobPushCallback<MobPushResult> mobPushCallback) {
        if (this.g == null) {
            this.g = new HashMap<>();
        }
        if (this.g.containsKey(String.valueOf(mobPushLocalNotification.getNotificationId()))) {
            mobPushCallback.onCallback(new MobPushResult(-4, "notificationId already exists"));
        } else {
            this.g.put(String.valueOf(mobPushLocalNotification.getNotificationId()), mobPushCallback);
            new Thread() { // from class: com.mob.pushsdk.impl.c.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    final int i;
                    try {
                        if (h.a().b(mobPushLocalNotification.getNotificationId()) != null) {
                            i = 0;
                        } else {
                            h.a().a(mobPushLocalNotification);
                            i = 1;
                        }
                        if (mobPushCallback != null) {
                            UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.1.1
                                @Override // com.mob.pushsdk.impl.f
                                public boolean a(Message message) {
                                    mobPushCallback.onCallback(i == 0 ? new MobPushResult(-5, "local notification failed") : new MobPushResult(0, "send local notification successful."));
                                    return false;
                                }
                            });
                        }
                    } catch (Throwable th) {
                        PLog.getInstance().e(th);
                        if (mobPushCallback != null) {
                            UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.1.2
                                @Override // com.mob.pushsdk.impl.f
                                public boolean a(Message message) {
                                    c.this.g.remove(String.valueOf(mobPushLocalNotification.getNotificationId()));
                                    mobPushCallback.onCallback(new MobPushResult(-1, "local notification failed, please try again later"));
                                    return false;
                                }
                            });
                        }
                    }
                }
            }.start();
        }
    }

    public void b(MobPushCallback<String> mobPushCallback) throws Throwable {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    HashSet hashSet = new HashSet();
                    this.b = hashSet;
                    this.b = Collections.synchronizedSet(hashSet);
                }
            }
        }
        if (mobPushCallback != null) {
            this.b.add(mobPushCallback);
        }
        new AnonymousClass14(mobPushCallback).start();
    }

    public boolean c(final String[] strArr) throws Throwable {
        com.mob.pushsdk.biz.e.a(strArr, 2, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.5
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putStringArray("tags", strArr);
                bundle.putInt("operation", 2);
                bundle.putInt("errorCode", i);
                bundle.putBoolean("result", false);
                c.this.a(3007, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    String strR = com.mob.pushsdk.biz.d.r();
                    if (strArr != null && !TextUtils.isEmpty(strR)) {
                        List listAsList = Arrays.asList(strR.split(Constants.ACCEPT_TIME_SEPARATOR_SP));
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(listAsList);
                        for (String str : strArr) {
                            if (arrayList.contains(str)) {
                                arrayList.remove(str);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                            int length = strArr2.length;
                            int i = 0;
                            String string = "";
                            while (i < length) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(string);
                                sb.append(strArr2[i]);
                                sb.append(i == length + (-1) ? "" : Constants.ACCEPT_TIME_SEPARATOR_SP);
                                string = sb.toString();
                                i++;
                            }
                            com.mob.pushsdk.biz.d.h(string);
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("tags", strArr);
                    bundle.putInt("operation", 2);
                    bundle.putBoolean("result", true);
                    c.this.a(3007, bundle);
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean c(Bundle bundle) throws Throwable {
        try {
            boolean z = bundle.getBoolean("result");
            if ("alias".equals(bundle.getString("operation"))) {
                com.mob.pushsdk.plugins.a.c.a().a(z, (List<String>) null);
            } else {
                com.mob.pushsdk.plugins.a.e.a().a(z, (List<String>) bundle.getSerializable("extra"));
            }
            return true;
        } catch (Throwable th) {
            PLog.getInstance().e(th);
            return true;
        }
    }

    public void a(final String str, final MobPushCallback<Boolean> mobPushCallback) throws Throwable {
        this.f = str;
        if (this.d == null) {
            synchronized (this.f17694e) {
                if (this.d == null) {
                    HashSet hashSet = new HashSet();
                    this.d = hashSet;
                    this.d = Collections.synchronizedSet(hashSet);
                }
            }
        }
        if (mobPushCallback != null) {
            this.d.add(mobPushCallback);
        }
        new Thread() { // from class: com.mob.pushsdk.impl.c.10
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    com.mob.pushsdk.biz.e.b(new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.10.1
                        @Override // com.mob.pushsdk.biz.b
                        public void b(Object obj) {
                            String str2 = (String) ResHelper.forceCast(obj, null);
                            if (!TextUtils.isEmpty(str2)) {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                c.this.a(str2, str);
                            } else {
                                com.mob.pushsdk.b.d.a().c("MobPush: bind mobile failed, rid is null!");
                                AnonymousClass10 anonymousClass102 = AnonymousClass10.this;
                                c.this.c((MobPushCallback<Boolean>) mobPushCallback);
                            }
                        }
                    });
                } catch (Throwable th) {
                    PLog.getInstance().e(th);
                    c.this.c((MobPushCallback<Boolean>) mobPushCallback);
                }
            }
        }.start();
    }

    public boolean b(final String[] strArr) throws Throwable {
        com.mob.pushsdk.biz.e.a(strArr, 1, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.3
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putStringArray("tags", strArr);
                bundle.putInt("operation", 1);
                bundle.putBoolean("result", false);
                bundle.putInt("errorCode", i);
                c.this.a(3005, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    ArrayList arrayList = new ArrayList(com.mob.pushsdk.b.j.a(com.mob.pushsdk.biz.d.r(), Constants.ACCEPT_TIME_SEPARATOR_SP));
                    if (arrayList.size() == 1 && TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                        arrayList.clear();
                    }
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        int length = strArr2.length;
                        for (int i = 0; i < length; i++) {
                            if (!arrayList.contains(strArr[i])) {
                                arrayList.add(strArr[i]);
                            }
                        }
                    }
                    com.mob.pushsdk.biz.d.h(com.mob.pushsdk.b.j.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP));
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("tags", strArr);
                    bundle.putInt("operation", 1);
                    bundle.putBoolean("result", true);
                    c.this.a(3005, bundle);
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean b(Bundle bundle) throws Throwable {
        a(2104, bundle);
        return true;
    }

    public boolean b(String str) throws Throwable {
        PLog.getInstance().d("MobPush ServerWorker deviceToken:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.mob.pushsdk.biz.d.c(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final String str2) {
        com.mob.pushsdk.biz.e.a(str, str2, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.12
            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                PLog.getInstance().d("MobPush: bind mobile success, result is " + obj, new Object[0]);
                UIHandler.sendEmptyMessage(0, new f() { // from class: com.mob.pushsdk.impl.c.12.1
                    @Override // com.mob.pushsdk.impl.f
                    public boolean a(Message message) {
                        com.mob.pushsdk.b.d.a().a("MobPush: current bind Phone is " + c.this.f + ", response resultMobile: " + str2);
                        if (c.this.d == null || c.this.d.size() <= 0) {
                            return false;
                        }
                        Iterator it = c.this.d.iterator();
                        while (it.hasNext()) {
                            ((MobPushCallback) it.next()).onCallback(Boolean.TRUE);
                        }
                        c.this.d.clear();
                        c.this.d = null;
                        return false;
                    }
                });
            }
        });
    }

    public boolean a(MobPushCallback<String> mobPushCallback) {
        PLog.getInstance().d("MobPush clientWorker getPhoneNum", new Object[0]);
        com.mob.pushsdk.biz.e.a(new AnonymousClass13(mobPushCallback));
        return true;
    }

    public boolean a(Bundle bundle) throws Throwable {
        Message message = new Message();
        message.what = 1003;
        message.setData(bundle);
        a(message);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bundle bundle) {
        Message message = new Message();
        message.setData(bundle);
        message.what = i;
        a(message);
    }

    public boolean a(final String str) throws Throwable {
        com.mob.pushsdk.biz.e.a(str, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.15
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putString("alias", str);
                bundle.putInt("operation", 1);
                bundle.putInt("errorCode", i);
                bundle.putBoolean("result", false);
                c.this.a(3002, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                com.mob.pushsdk.biz.d.g(str);
                Bundle bundle = new Bundle();
                bundle.putString("alias", str);
                bundle.putInt("operation", 1);
                bundle.putBoolean("result", true);
                c.this.a(3002, bundle);
            }
        });
        return true;
    }

    public boolean a(final String[] strArr) throws Throwable {
        com.mob.pushsdk.biz.e.c(strArr, new com.mob.pushsdk.biz.b() { // from class: com.mob.pushsdk.impl.c.2
            @Override // com.mob.pushsdk.biz.b
            public void a(int i, Throwable th) {
                super.a(i, th);
                Bundle bundle = new Bundle();
                bundle.putStringArray("tags", strArr);
                bundle.putInt("operation", 1);
                bundle.putBoolean("result", false);
                bundle.putInt("errorCode", i);
                c.this.a(3010, bundle);
            }

            @Override // com.mob.pushsdk.biz.b
            public void b(Object obj) {
                try {
                    ArrayList arrayList = new ArrayList(com.mob.pushsdk.b.j.a(com.mob.pushsdk.biz.d.r(), Constants.ACCEPT_TIME_SEPARATOR_SP));
                    if (arrayList.size() == 1 && TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                        arrayList.clear();
                    }
                    String[] strArr2 = strArr;
                    if (strArr2 != null && strArr2.length > 0) {
                        for (String str : strArr2) {
                            if (!arrayList.contains(str)) {
                                arrayList.add(str);
                            }
                        }
                    }
                    com.mob.pushsdk.biz.d.h(com.mob.pushsdk.b.j.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP));
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("tags", strArr);
                    bundle.putInt("operation", 1);
                    bundle.putBoolean("result", true);
                    c.this.a(3010, bundle);
                } catch (Throwable th) {
                    a(0, th);
                }
            }
        });
        return true;
    }

    public boolean a(MobPushLocalNotification mobPushLocalNotification) throws Throwable {
        if (mobPushLocalNotification == null) {
            return true;
        }
        h.a().a(mobPushLocalNotification);
        return true;
    }

    public boolean a(int i) throws Throwable {
        HashMap<String, MobPushCallback<MobPushResult>> map = this.g;
        if (map != null && map.containsKey(String.valueOf(i))) {
            this.g.remove(String.valueOf(i));
        }
        h.a().a(i);
        return true;
    }

    public <T extends MobPushTailorNotification> boolean a(Class<T> cls) throws Throwable {
        String str = cls.getName() + "|" + cls.getSimpleName();
        com.mob.pushsdk.biz.d.f(str);
        l.a().a(str);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r14) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.c.a(android.os.Message):void");
    }
}
