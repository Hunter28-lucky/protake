package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.pushsdk.MobPush;
import com.xiaomi.push.av;
import com.xiaomi.push.ax;
import com.xiaomi.push.bb;
import com.xiaomi.push.ct;
import com.xiaomi.push.du;
import com.xiaomi.push.gg;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class u {
    private static u a = null;

    /* renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f5541a = new ArrayList<>();
    private static boolean b = false;

    /* renamed from: a, reason: collision with other field name */
    private long f5542a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5543a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f5545a;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f5546a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5550a;

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f5549a = new ArrayList();
    private boolean c = false;

    /* renamed from: b, reason: collision with other field name */
    private String f5551b = null;

    /* renamed from: a, reason: collision with other field name */
    private Intent f5544a = null;

    /* renamed from: a, reason: collision with other field name */
    private Integer f5547a = null;

    /* renamed from: a, reason: collision with other field name */
    private String f5548a = null;

    /* renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[v.values().length];
            a = iArr;
            try {
                iArr[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class a<T extends hr<T, ?>> {
        public gg a;

        /* renamed from: a, reason: collision with other field name */
        public T f5552a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f5553a;
    }

    private u(Context context) {
        this.f5550a = false;
        this.f5545a = null;
        this.f5543a = context.getApplicationContext();
        this.f5550a = m5178c();
        b = m5179d();
        this.f5545a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (p.class) {
                    if (p.a(u.this.f5543a).m5170a(str)) {
                        if (p.a(u.this.f5543a).a(str) < 10) {
                            String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                            v vVar = v.DISABLE_PUSH;
                            if (vVar.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar))) {
                                u.this.a(str, vVar, true, (HashMap<String, String>) null);
                            } else {
                                v vVar2 = v.ENABLE_PUSH;
                                if (vVar2.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar2))) {
                                    u.this.a(str, vVar2, true, (HashMap<String, String>) null);
                                } else {
                                    v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                    if (vVar3.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar3))) {
                                        HashMap<String, String> mapM5159a = f.m5159a(u.this.f5543a, d.ASSEMBLE_PUSH_HUAWEI);
                                        mapM5159a.put("third_sync_reason", string);
                                        u.this.a(str, vVar3, false, mapM5159a);
                                    } else {
                                        v vVar4 = v.UPLOAD_FCM_TOKEN;
                                        if (vVar4.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar4))) {
                                            u uVar = u.this;
                                            uVar.a(str, vVar4, false, f.m5159a(uVar.f5543a, d.ASSEMBLE_PUSH_FCM));
                                        } else {
                                            v vVar5 = v.UPLOAD_COS_TOKEN;
                                            if (vVar5.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar5))) {
                                                HashMap<String, String> mapM5159a2 = f.m5159a(u.this.f5543a, d.ASSEMBLE_PUSH_COS);
                                                mapM5159a2.put("third_sync_reason", string);
                                                u.this.a(str, vVar5, false, mapM5159a2);
                                            } else {
                                                v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                if (vVar6.ordinal() == i && "syncing".equals(p.a(u.this.f5543a).a(vVar6))) {
                                                    HashMap<String, String> mapM5159a3 = f.m5159a(u.this.f5543a, d.ASSEMBLE_PUSH_FTOS);
                                                    mapM5159a3.put("third_sync_reason", string);
                                                    u.this.a(str, vVar6, false, mapM5159a3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            p.a(u.this.f5543a).b(str);
                        } else {
                            p.a(u.this.f5543a).c(str);
                        }
                    }
                }
            }
        };
        if (com.xiaomi.push.j.m5690a(context)) {
            com.xiaomi.push.service.g.a(new g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent intentB = b();
        if (intentB != null) {
            b(intentB);
        }
    }

    private synchronized void c(int i) {
        this.f5543a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f5543a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m5176a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f5543a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f5543a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void g() {
        this.f5542a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f5543a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f5543a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f5543a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f5543a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public final void m5187b() {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(intentM5173a);
    }

    public void f() {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM5173a.putExtra(an.G, this.f5543a.getPackageName());
        intentM5173a.putExtra(an.L, bb.b(this.f5543a.getPackageName()));
        c(intentM5173a);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f5543a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m5178c() {
        try {
            PackageInfo packageInfo = this.f5543a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m5191e() {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) ax.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f5543a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5113a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        intentM5173a.putExtra(an.G, packageName);
        c(intentM5173a);
    }

    private Intent c() {
        if (m5185a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m5190d() {
        ArrayList<a> arrayList = f5541a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f5552a, next.a, next.f5553a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f5541a.clear();
        }
    }

    public void b(int i) {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM5173a.putExtra(an.G, this.f5543a.getPackageName());
        intentM5173a.putExtra(an.J, i);
        intentM5173a.putExtra(an.L, bb.b(this.f5543a.getPackageName() + i));
        c(intentM5173a);
    }

    public static synchronized u a(Context context) {
        if (a == null) {
            a = new u(context);
        }
        return a;
    }

    private synchronized int a() {
        return this.f5543a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m5189c() {
        if (this.f5544a != null) {
            g();
            c(this.f5544a);
            this.f5544a = null;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m5179d() {
        if (m5185a()) {
            try {
                return this.f5543a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5188b() {
        if (!m5185a() || !m5180e()) {
            return true;
        }
        if (this.f5547a == null) {
            Integer numValueOf = Integer.valueOf(ap.a(this.f5543a).a());
            this.f5547a = numValueOf;
            if (numValueOf.intValue() == 0) {
                this.f5543a.getContentResolver().registerContentObserver(ap.a(this.f5543a).m5766a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        u uVar = u.this;
                        uVar.f5547a = Integer.valueOf(ap.a(uVar.f5543a).a());
                        if (u.this.f5547a.intValue() != 0) {
                            u.this.f5543a.getContentResolver().unregisterContentObserver(this);
                            if (av.m5216a(u.this.f5543a)) {
                                u.this.m5189c();
                            }
                        }
                    }
                });
            }
        }
        return this.f5547a.intValue() != 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5181a() {
        return this.f5542a;
    }

    private void c(Intent intent) {
        ah ahVarA = ah.a(this.f5543a);
        int iA = gl.ServiceBootMode.a();
        gh ghVar = gh.START;
        int iA2 = ahVarA.a(iA, ghVar.a());
        int iA3 = a();
        gh ghVar2 = gh.BIND;
        boolean z = iA2 == ghVar2.a() && b;
        int iA4 = z ? ghVar2.a() : ghVar.a();
        if (iA4 != iA3) {
            m5186a(iA4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m5180e() {
        String packageName = this.f5543a.getPackageName();
        return packageName.contains("miui") || packageName.contains(MobPush.Channels.XIAOMI) || (this.f5543a.getApplicationInfo().flags & 1) != 0;
    }

    public final void a(hg hgVar, boolean z) {
        du.a(this.f5543a.getApplicationContext()).a(this.f5543a.getPackageName(), "E100003", hgVar.a(), 6001, null);
        this.f5544a = null;
        b.m5140a(this.f5543a).f5516a = hgVar.a();
        Intent intentM5173a = m5173a();
        byte[] bArrA = hq.a(r.a(this.f5543a, hgVar, gg.Registration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("register fail, because msgBytes is null.");
            return;
        }
        intentM5173a.setAction("com.xiaomi.mipush.REGISTER_APP");
        intentM5173a.putExtra("mipush_app_id", b.m5140a(this.f5543a).m5141a());
        intentM5173a.putExtra("mipush_payload", bArrA);
        intentM5173a.putExtra("mipush_session", this.f5548a);
        intentM5173a.putExtra("mipush_env_chanage", z);
        intentM5173a.putExtra("mipush_env_type", b.m5140a(this.f5543a).a());
        if (av.m5216a(this.f5543a) && m5188b()) {
            g();
            c(intentM5173a);
        } else {
            this.f5544a = intentM5173a;
        }
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message messageA = a(intent);
            if (this.f5549a.size() >= 50) {
                this.f5549a.remove(0);
            }
            this.f5549a.add(messageA);
            return;
        }
        if (this.f5546a == null) {
            this.f5543a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (u.this) {
                        u.this.f5546a = new Messenger(iBinder);
                        u.this.c = false;
                        Iterator it = u.this.f5549a.iterator();
                        while (it.hasNext()) {
                            try {
                                u.this.f5546a.send((Message) it.next());
                            } catch (RemoteException e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                        u.this.f5549a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    u.this.f5546a = null;
                    u.this.c = false;
                }
            }, 1);
            this.c = true;
            this.f5549a.clear();
            this.f5549a.add(a(intent));
        } else {
            try {
                this.f5546a.send(a(intent));
            } catch (RemoteException unused) {
                this.f5546a = null;
                this.c = false;
            }
        }
    }

    private void b(Intent intent) {
        try {
            if (!com.xiaomi.push.j.m5689a() && Build.VERSION.SDK_INT >= 26) {
                d(intent);
            } else {
                this.f5543a.startService(intent);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5182a() {
        b(m5173a());
    }

    public final void a(hm hmVar) {
        byte[] bArrA = hq.a(r.a(this.f5543a, hmVar, gg.UnRegistration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        intentM5173a.putExtra("mipush_app_id", b.m5140a(this.f5543a).m5141a());
        intentM5173a.putExtra("mipush_payload", bArrA);
        c(intentM5173a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            p pVarA = p.a(this.f5543a);
            v vVar = v.DISABLE_PUSH;
            pVarA.a(vVar, "syncing");
            p.a(this.f5543a).a(v.ENABLE_PUSH, "");
            a(str, vVar, true, (HashMap<String, String>) null);
            return;
        }
        p pVarA2 = p.a(this.f5543a);
        v vVar2 = v.ENABLE_PUSH;
        pVarA2.a(vVar2, "syncing");
        p.a(this.f5543a).a(v.DISABLE_PUSH, "");
        a(str, vVar2, true, (HashMap<String, String>) null);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5183a(Context context) {
        if (com.xiaomi.push.j.m5689a()) {
            return;
        }
        q qVarA = h.a(context);
        if (q.HUAWEI.equals(qVarA)) {
            a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(qVarA)) {
            a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(qVarA)) {
            a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f5543a).a(vVar, "syncing");
        HashMap<String, String> mapM5159a = f.m5159a(this.f5543a, dVar);
        mapM5159a.put("third_sync_reason", str2);
        a(str, vVar, false, mapM5159a);
    }

    public void a(int i, String str) {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.thirdparty");
        intentM5173a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        intentM5173a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(intentM5173a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, v vVar, boolean z, HashMap<String, String> map) {
        hf hfVar;
        String strA = str;
        if (b.m5140a(this.f5543a).m5147b() && av.m5216a(this.f5543a)) {
            hf hfVar2 = new hf();
            hfVar2.a(true);
            Intent intentM5173a = m5173a();
            if (TextUtils.isEmpty(str)) {
                strA = aj.a();
                hfVar2.a(strA);
                hfVar = z ? new hf(strA, true) : null;
                synchronized (p.class) {
                    p.a(this.f5543a).m5169a(strA);
                }
            } else {
                hfVar2.a(strA);
                hfVar = z ? new hf(strA, true) : null;
            }
            switch (AnonymousClass5.a[vVar.ordinal()]) {
                case 1:
                    gq gqVar = gq.DisablePushMessage;
                    hfVar2.c(gqVar.f6003a);
                    hfVar.c(gqVar.f6003a);
                    if (map != null) {
                        hfVar2.a(map);
                        hfVar.a(map);
                    }
                    intentM5173a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    gq gqVar2 = gq.EnablePushMessage;
                    hfVar2.c(gqVar2.f6003a);
                    hfVar.c(gqVar2.f6003a);
                    if (map != null) {
                        hfVar2.a(map);
                        hfVar.a(map);
                    }
                    intentM5173a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    hfVar2.c(gq.ThirdPartyRegUpdate.f6003a);
                    if (map != null) {
                        hfVar2.a(map);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + vVar + ", " + strA);
            hfVar2.b(b.m5140a(this.f5543a).m5141a());
            hfVar2.d(this.f5543a.getPackageName());
            gg ggVar = gg.Notification;
            a((u) hfVar2, ggVar, false, (gt) null);
            if (z) {
                hfVar.b(b.m5140a(this.f5543a).m5141a());
                hfVar.d(this.f5543a.getPackageName());
                Context context = this.f5543a;
                byte[] bArrA = hq.a(r.a(context, hfVar, ggVar, false, context.getPackageName(), b.m5140a(this.f5543a).m5141a()));
                if (bArrA != null) {
                    ct.a(this.f5543a.getPackageName(), this.f5543a, hfVar, ggVar, bArrA.length);
                    intentM5173a.putExtra("mipush_payload", bArrA);
                    intentM5173a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    intentM5173a.putExtra("mipush_app_id", b.m5140a(this.f5543a).m5141a());
                    intentM5173a.putExtra("mipush_app_token", b.m5140a(this.f5543a).b());
                    c(intentM5173a);
                }
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 19;
            int iOrdinal = vVar.ordinal();
            messageObtain.obj = strA;
            messageObtain.arg1 = iOrdinal;
            if (map != null && map.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", map.get("third_sync_reason"));
                messageObtain.setData(bundle);
            }
            this.f5545a.sendMessageDelayed(messageObtain, 5000L);
        }
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, gt gtVar) {
        a((u) t, ggVar, !ggVar.equals(gg.Registration), gtVar);
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, gt gtVar, boolean z2) {
        a(t, ggVar, z, true, gtVar, z2);
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, gt gtVar) {
        a(t, ggVar, z, true, gtVar, true);
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, boolean z2, gt gtVar, boolean z3) {
        a(t, ggVar, z, z2, gtVar, z3, this.f5543a.getPackageName(), b.m5140a(this.f5543a).m5141a());
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, boolean z2, gt gtVar, boolean z3, String str, String str2) {
        a(t, ggVar, z, z2, gtVar, z3, str, str2, true);
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, boolean z2, gt gtVar, boolean z3, String str, String str2, boolean z4) {
        a(t, ggVar, z, z2, gtVar, z3, str, str2, z4, true);
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, boolean z2, gt gtVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        a(t, ggVar, z, z2, gtVar, z3, str, str2, z4, z5, "com.xiaomi.mipush.SEND_MESSAGE");
    }

    public final <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z, boolean z2, gt gtVar, boolean z3, String str, String str2, boolean z4, boolean z5, String str3) {
        hc hcVarB;
        if (z5 && !b.m5140a(this.f5543a).m5149c()) {
            if (z2) {
                a((u) t, ggVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m5113a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            hcVarB = r.a(this.f5543a, t, ggVar, z, str, str2);
        } else {
            hcVarB = r.b(this.f5543a, t, ggVar, z, str, str2);
        }
        if (gtVar != null) {
            hcVarB.a(gtVar);
        }
        byte[] bArrA = hq.a(hcVarB);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("send message fail, because msgBytes is null.");
            return;
        }
        ct.a(this.f5543a.getPackageName(), this.f5543a, t, ggVar, bArrA.length);
        Intent intentM5173a = m5173a();
        intentM5173a.setAction(str3);
        intentM5173a.putExtra("mipush_payload", bArrA);
        intentM5173a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(intentM5173a);
    }

    public final void a(gk gkVar) {
        Intent intentM5173a = m5173a();
        byte[] bArrA = hq.a(gkVar);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        intentM5173a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        intentM5173a.putExtra("mipush_payload", bArrA);
        b(intentM5173a);
    }

    /* renamed from: a, reason: collision with other method in class */
    private Intent m5173a() {
        if (m5185a() && !"com.xiaomi.xmsf".equals(this.f5543a.getPackageName())) {
            return d();
        }
        return e();
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m5176a() {
        String str = this.f5551b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f5543a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f5551b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f5551b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5185a() {
        return this.f5550a && 1 == b.m5140a(this.f5543a).a();
    }

    public <T extends hr<T, ?>> void a(T t, gg ggVar, boolean z) {
        a aVar = new a();
        aVar.f5552a = t;
        aVar.a = ggVar;
        aVar.f5553a = z;
        ArrayList<a> arrayList = f5541a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM5173a.putExtra(an.G, this.f5543a.getPackageName());
        intentM5173a.putExtra(an.H, i);
        intentM5173a.putExtra(an.I, i2);
        c(intentM5173a);
    }

    public void a(String str, String str2) {
        Intent intentM5173a = m5173a();
        intentM5173a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM5173a.putExtra(an.G, this.f5543a.getPackageName());
        intentM5173a.putExtra(an.M, str);
        intentM5173a.putExtra(an.N, str2);
        c(intentM5173a);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5184a(Intent intent) {
        intent.fillIn(m5173a(), 24);
        c(intent);
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5186a(int i) {
        if (!b.m5140a(this.f5543a).m5147b()) {
            return false;
        }
        c(i);
        hf hfVar = new hf();
        hfVar.a(aj.a());
        hfVar.b(b.m5140a(this.f5543a).m5141a());
        hfVar.d(this.f5543a.getPackageName());
        hfVar.c(gq.ClientABTest.f6003a);
        HashMap map = new HashMap();
        hfVar.f6142a = map;
        map.put("boot_mode", i + "");
        a(this.f5543a).a((u) hfVar, gg.Notification, false, (gt) null);
        return true;
    }
}
