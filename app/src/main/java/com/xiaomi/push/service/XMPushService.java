package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.bi;
import com.xiaomi.push.ch;
import com.xiaomi.push.co;
import com.xiaomi.push.cu;
import com.xiaomi.push.cy;
import com.xiaomi.push.dc;
import com.xiaomi.push.dq;
import com.xiaomi.push.du;
import com.xiaomi.push.ea;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.ez;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fe;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.ge;
import com.xiaomi.push.gg;
import com.xiaomi.push.gl;
import com.xiaomi.push.hc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.n;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class XMPushService extends Service implements fe {
    private static boolean b = false;

    /* renamed from: a, reason: collision with other field name */
    private ContentObserver f6339a;

    /* renamed from: a, reason: collision with other field name */
    private ez f6341a;

    /* renamed from: a, reason: collision with other field name */
    private fb f6342a;

    /* renamed from: a, reason: collision with other field name */
    private fc f6343a;

    /* renamed from: a, reason: collision with other field name */
    private a f6345a;

    /* renamed from: a, reason: collision with other field name */
    private f f6346a;

    /* renamed from: a, reason: collision with other field name */
    private k f6347a;

    /* renamed from: a, reason: collision with other field name */
    private r f6348a;

    /* renamed from: a, reason: collision with other field name */
    private t f6349a;

    /* renamed from: a, reason: collision with other field name */
    private as f6351a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.h f6352a;

    /* renamed from: a, reason: collision with other field name */
    private Object f6355a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f6358a = false;
    private int a = 0;

    /* renamed from: b, reason: collision with other field name */
    private int f6359b = 0;

    /* renamed from: a, reason: collision with other field name */
    private long f6338a = 0;

    /* renamed from: a, reason: collision with other field name */
    public Class f6354a = XMJobService.class;
    private int c = -1;

    /* renamed from: a, reason: collision with other field name */
    private ak f6350a = null;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.n f6353a = null;

    /* renamed from: a, reason: collision with other field name */
    public Messenger f6340a = null;

    /* renamed from: a, reason: collision with other field name */
    private Collection<aa> f6357a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<n> f6356a = new ArrayList<>();

    /* renamed from: a, reason: collision with other field name */
    private fg f6344a = new fg() { // from class: com.xiaomi.push.service.XMPushService.1
        @Override // com.xiaomi.push.fg
        public void a(fp fpVar) {
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new m(fpVar));
        }

        @Override // com.xiaomi.push.fg
        public void a(es esVar) {
            if (com.xiaomi.push.service.e.a(esVar)) {
                at.a().a(esVar.e(), SystemClock.elapsedRealtime(), XMPushService.this.m5725a());
            }
            XMPushService xMPushService = XMPushService.this;
            xMPushService.a(xMPushService.new d(esVar));
        }
    };

    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with other field name */
        private final Object f6365a;

        private a() {
            this.f6365a = new Object();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!an.r.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] cancel the old ping timer");
                ea.a();
                return;
            }
            if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(3000L);
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable unused) {
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f6365a) {
                try {
                    this.f6365a.wait(j);
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] interrupt from waiting state. " + e2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f6365a) {
                try {
                    this.f6365a.notifyAll();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] notify lock. " + e2);
                }
            }
        }
    }

    public static class c extends j {
        private final am.b a;

        public c(am.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            this.a.a(am.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).a.g, this.a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.a.g.hashCode();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind time out. chid=" + this.a.g;
        }
    }

    public class d extends j {
        private es a;

        public d(es esVar) {
            super(8);
            this.a = esVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.f6350a.a(this.a);
            if (com.xiaomi.push.service.e.a(this.a)) {
                XMPushService.this.a(new at.a(), 15000L);
            }
        }
    }

    public class e extends j {
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            if (XMPushService.this.m5729a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("should not connect. quit the job.");
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.av.m5215a();
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class g extends j {

        /* renamed from: a, reason: collision with other field name */
        public Exception f6368a;
        public int b;

        public g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f6368a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.a(this.b, this.f6368a);
        }
    }

    public class h extends j {
        public h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.c();
        }
    }

    public class i extends j {
        private long a;

        /* renamed from: a, reason: collision with other field name */
        private Intent f6369a;

        public i(Intent intent) {
            super(15);
            this.f6369a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() throws PackageManager.NameNotFoundException, NumberFormatException {
            XMPushService.this.a(this.f6369a, this.a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "Handle intent action = " + this.f6369a.getAction();
        }

        public void a(long j) {
            this.a = j;
        }
    }

    public static abstract class j extends n.b {
        public j(int i) {
            super(i);
        }

        public abstract String a();

        /* renamed from: a */
        public abstract void mo5444a();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.a;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.m5114a(com.xiaomi.channel.commonutils.logger.a.a, a());
            }
            mo5444a();
        }
    }

    public class k extends BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.f6353a.m5796a();
        }
    }

    public class m extends j {
        private fp a;

        public m(fp fpVar) {
            super(8);
            this.a = fpVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.f6350a.a(this.a);
        }
    }

    public interface n {
        /* renamed from: a */
        void mo5522a();
    }

    public class o extends j {

        /* renamed from: a, reason: collision with other field name */
        public boolean f6372a;

        public o(boolean z) {
            super(4);
            this.f6372a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            if (XMPushService.this.m5734c()) {
                try {
                    if (!this.f6372a) {
                        eq.a();
                    }
                    XMPushService.this.f6342a.b(this.f6372a);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
        }
    }

    public class q extends j {
        public q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m5729a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    public class r extends BroadcastReceiver {
        public r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    public class t extends BroadcastReceiver {
        public t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f6358a) {
                XMPushService.this.f6358a = true;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    private void d() {
        com.xiaomi.push.aw awVarM5209a = com.xiaomi.push.av.m5209a();
        com.xiaomi.push.service.m.a(getApplicationContext()).a(awVarM5209a);
        if (awVarM5209a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[type: " + awVarM5209a.m5219a() + "[" + awVarM5209a.m5221b() + "], state: " + awVarM5209a.m5218a() + "/" + awVarM5209a.m5217a());
            com.xiaomi.channel.commonutils.logger.b.m5114a("XMPushService", sb.toString());
            NetworkInfo.State stateM5218a = awVarM5209a.m5218a();
            if (stateM5218a == NetworkInfo.State.SUSPENDED || stateM5218a == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m5114a("XMPushService", "network changed, no active network");
        }
        if (ep.a() != null) {
            ep.a().m5446a();
        }
        ga.m5520a((Context) this);
        this.f6341a.d();
        if (com.xiaomi.push.av.m5216a((Context) this)) {
            if (m5734c() && m5721f()) {
                b(false);
            }
            if (!m5734c() && !m5735d()) {
                this.f6353a.a(1);
                a(new e());
            }
            dc.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m5729a()) {
            ea.a();
        } else {
            if (ea.m5438a()) {
                return;
            }
            ea.a(true);
        }
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m5721f() {
        if (SystemClock.elapsedRealtime() - this.f6338a < 30000) {
            return false;
        }
        return com.xiaomi.push.av.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: collision with other method in class */
    public boolean m5722g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h, reason: collision with other method in class */
    private boolean m5723h() {
        boolean zEquals;
        String packageName = getPackageName();
        if ("com.xiaomi.xmsf".equals(packageName)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("current sdk expect region is cn");
            zEquals = com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.b.a(getApplicationContext()).a());
        } else {
            zEquals = !com.xiaomi.push.service.r.a(this).m5812b(packageName);
        }
        if (!zEquals) {
            com.xiaomi.channel.commonutils.logger.b.m5115a("XMPushService", "-->isPushEnabled(): isEnabled=", Boolean.valueOf(zEquals), ", package=", packageName, ", region=", com.xiaomi.push.service.b.a(getApplicationContext()).a());
        }
        return zEquals;
    }

    /* renamed from: i, reason: collision with other method in class */
    private boolean m5724i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m5684b((Context) this) && !com.xiaomi.push.i.m5681a(getApplicationContext());
    }

    private boolean j() {
        int iIntValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.a;
        int i3 = this.f6359b;
        if (i2 > i3) {
            if (iIntValue >= i2 || iIntValue < i3) {
                return true;
            }
        } else if (i2 < i3 && iIntValue >= i2 && iIntValue < i3) {
            return true;
        }
        return false;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ah.a(this).a(gl.ForegroundServiceSwitch.a(), false);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f6340a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] strArrSplit;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.s.a((Context) this);
        com.xiaomi.push.service.p pVarM5807a = com.xiaomi.push.service.q.m5807a((Context) this);
        if (pVarM5807a != null) {
            com.xiaomi.push.y.a(pVarM5807a.a);
        }
        if (com.xiaomi.push.j.m5690a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f6345a = new a();
            com.xiaomi.push.m.a(this, this.f6345a, new IntentFilter(an.r), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            b = true;
            handler.post(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PackageManager packageManager = XMPushService.this.getApplicationContext().getPackageManager();
                        ComponentName componentName = new ComponentName(XMPushService.this.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
                        if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                            packageManager.setComponentEnabledSetting(componentName, 2, 1);
                        }
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("[Alarm] disable ping receiver may be failure. " + th);
                    }
                }
            });
        }
        this.f6340a = new Messenger(new Handler() { // from class: com.xiaomi.push.service.XMPushService.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 == 17) {
                            Object obj = message.obj;
                            if (obj != null) {
                                XMPushService.this.onStart((Intent) obj, 1);
                            }
                        } else if (i2 == 18) {
                            Message messageObtain = Message.obtain((Handler) null, 0);
                            messageObtain.what = 18;
                            Bundle bundle = new Bundle();
                            bundle.putString("xmsf_region", com.xiaomi.push.service.b.a(XMPushService.this.getApplicationContext()).a());
                            messageObtain.setData(bundle);
                            message.replyTo.send(messageObtain);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        ao.a(this);
        fc fcVar = new fc(null, 5222, "xiaomi.com", null) { // from class: com.xiaomi.push.service.XMPushService.9
            @Override // com.xiaomi.push.fc
            /* renamed from: a */
            public byte[] mo5487a() {
                try {
                    dq.b bVar = new dq.b();
                    bVar.a(ax.a().m5774a());
                    return bVar.m5437a();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("getOBBString err: " + e2.toString());
                    return null;
                }
            }
        };
        this.f6343a = fcVar;
        fcVar.a(true);
        this.f6341a = new ez(this, this.f6343a);
        this.f6352a = m5727a();
        ea.a(this);
        this.f6341a.a(this);
        this.f6350a = new ak(this);
        this.f6351a = new as(this);
        new com.xiaomi.push.service.i().a();
        ep.m5447a().a(this);
        this.f6353a = new com.xiaomi.push.service.n("Connection Controller Thread");
        am amVarA = am.a();
        amVarA.b();
        amVarA.a(new am.a() { // from class: com.xiaomi.push.service.XMPushService.10
            @Override // com.xiaomi.push.service.am.a
            public void a() {
                XMPushService.this.e();
                if (am.a().m5757a() <= 0) {
                    XMPushService xMPushService = XMPushService.this;
                    xMPushService.a(xMPushService.new g(12, null));
                }
            }
        });
        if (k()) {
            h();
        }
        ge.a(this).a(new com.xiaomi.push.service.o(this), "UPLOADER_PUSH_CHANNEL");
        a(new gb(this));
        a(new bd(this));
        if (com.xiaomi.push.j.m5690a((Context) this)) {
            a(new al());
            if (com.xiaomi.push.i.m5680a()) {
                a(new n() { // from class: com.xiaomi.push.service.XMPushService.11
                    @Override // com.xiaomi.push.service.XMPushService.n
                    /* renamed from: a */
                    public void mo5522a() {
                        bi.a(XMPushService.this.getApplicationContext());
                    }
                });
            }
        }
        a(new h());
        this.f6357a.add(ay.a(this));
        if (m5723h()) {
            this.f6346a = new f();
            com.xiaomi.push.m.a(this, this.f6346a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (String) null, (Handler) null);
            this.f6355a = com.xiaomi.push.av.m5211a((Context) this);
        }
        if (com.xiaomi.push.j.m5690a(getApplicationContext())) {
            this.f6349a = new t();
            com.xiaomi.push.m.a(this, this.f6349a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            k kVar = new k();
            this.f6347a = kVar;
            com.xiaomi.push.m.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f6339a = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.push.service.XMPushService.12
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        super.onChange(z);
                        boolean zM5722g = XMPushService.this.m5722g();
                        com.xiaomi.channel.commonutils.logger.b.m5113a("SuperPowerMode:" + zM5722g);
                        XMPushService.this.e();
                        if (!zM5722g) {
                            XMPushService.this.a(true);
                        } else {
                            XMPushService xMPushService = XMPushService.this;
                            xMPushService.a(xMPushService.new g(24, null));
                        }
                    }
                };
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f6339a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] iArrM5718a = m5718a();
            if (iArrM5718a != null) {
                this.f6348a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                com.xiaomi.push.m.a(this, this.f6348a, intentFilter, (String) null, (Handler) null);
                this.a = iArrM5718a[0];
                this.f6359b = iArrM5718a[1];
                com.xiaomi.channel.commonutils.logger.b.m5113a("falldown initialized: " + this.a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f6359b);
            }
        }
        co.a(this, this.f6341a);
        cu.a(this, this.f6341a);
        String str = "";
        if (pVarM5807a != null) {
            try {
                if (!TextUtils.isEmpty(pVarM5807a.f6473a) && (strArrSplit = pVarM5807a.f6473a.split("@")) != null && strArrSplit.length > 0) {
                    str = strArrSplit[0];
                }
            } catch (Exception unused) {
            }
        }
        cy.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f6346a;
        if (fVar != null) {
            a(fVar);
            this.f6346a = null;
        }
        Object obj = this.f6355a;
        if (obj != null) {
            com.xiaomi.push.av.a(this, obj);
            this.f6355a = null;
        }
        t tVar = this.f6349a;
        if (tVar != null) {
            a(tVar);
            this.f6349a = null;
        }
        k kVar = this.f6347a;
        if (kVar != null) {
            a(kVar);
            this.f6347a = null;
        }
        r rVar = this.f6348a;
        if (rVar != null) {
            a(rVar);
            this.f6348a = null;
        }
        a aVar = this.f6345a;
        if (aVar != null) {
            a(aVar);
            this.f6345a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f6339a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f6339a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f6357a.clear();
        this.f6353a.m5799b();
        a(new j(2) { // from class: com.xiaomi.push.service.XMPushService.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "disconnect for service destroy.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                if (XMPushService.this.f6342a != null) {
                    XMPushService.this.f6342a.b(15, (Exception) null);
                    XMPushService.this.f6342a = null;
                }
            }
        });
        a(new l());
        am.a().b();
        am.a().a(this, 15);
        am.a().m5761a();
        this.f6341a.b(this);
        ax.a().m5776a();
        ea.a();
        i();
        co.b(this, this.f6341a);
        cu.b(this, this.f6341a);
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m5113a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                String stringExtra = intent.getStringExtra(an.w);
                String stringExtra2 = intent.getStringExtra(an.G);
                String stringExtra3 = intent.getStringExtra("mipush_app_package");
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || "miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m5114a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s, intent = %s", intent.getAction(), stringExtra, stringExtra2, stringExtra3, com.xiaomi.push.j.a(intent)));
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m5114a("XMPushService", String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), stringExtra, stringExtra2, stringExtra3));
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f6353a.m5797a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    am.a().a(this, 14);
                    stopSelf();
                } else {
                    a(new i(intent));
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                i iVar = new i(intent);
                iVar.a(jCurrentTimeMillis);
                a(iVar);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jCurrentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + jCurrentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return com.xiaomi.push.j.m5690a((Context) this) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)(1:5)|6|(2:12|(3:14|(1:16)(1:17)|18)(10:19|20|(1:22)|23|(1:25)|36|26|(1:28)|32|(2:34|35)(1:38)))(1:10)|11|20|(0)|23|(0)|36|26|(0)|32|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e5, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00de A[Catch: Exception -> 0x00e4, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e4, blocks: (B:26:0x00d8, B:28:0x00de), top: B:36:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r10 = this;
            com.xiaomi.push.ch r0 = com.xiaomi.push.ch.a()
            r0.m5302d()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.m r0 = com.xiaomi.push.service.m.a(r0)
            r0.m5790a()
            android.content.Context r0 = r10.getApplicationContext()
            com.xiaomi.push.service.b r0 = com.xiaomi.push.service.b.a(r0)
            java.lang.String r1 = r0.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "region of cache is "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "XMPushService"
            com.xiaomi.channel.commonutils.logger.b.m5114a(r3, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r4 = ""
            if (r2 == 0) goto L4c
            java.lang.String r1 = r10.b()
            com.xiaomi.push.n r2 = com.xiaomi.push.j.a(r1)
            java.lang.String r2 = r2.name()
            r9 = r2
            r2 = r1
            r1 = r9
            goto L4d
        L4c:
            r2 = r4
        L4d:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r6 = "CN"
            java.lang.String r7 = "com.xiaomi.xmsf"
            r8 = 1
            if (r5 != 0) goto L6c
            com.xiaomi.push.n r5 = com.xiaomi.push.n.China
            java.lang.String r5 = r5.name()
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L6c
            r0.a(r1, r8)
            r0.b(r6, r8)
        L6a:
            r2 = r6
            goto L92
        L6c:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L8c
            java.lang.String r1 = r10.getPackageName()
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L7e
            r6 = r4
            goto L84
        L7e:
            com.xiaomi.push.n r1 = com.xiaomi.push.n.China
            java.lang.String r4 = r1.name()
        L84:
            r0.a(r4, r8)
            r0.b(r6, r8)
            r1 = r4
            goto L6a
        L8c:
            com.xiaomi.push.n r0 = com.xiaomi.push.n.China
            java.lang.String r1 = r0.name()
        L92:
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r4 = 0
            java.lang.String r5 = "after check, appRegion is "
            r0[r4] = r5
            r0[r8] = r1
            r4 = 2
            java.lang.String r5 = ", countryCode="
            r0[r4] = r5
            r4 = 3
            r0[r4] = r2
            com.xiaomi.channel.commonutils.logger.b.m5115a(r3, r0)
            com.xiaomi.push.n r0 = com.xiaomi.push.n.China
            java.lang.String r0 = r0.name()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb8
            java.lang.String r0 = "cn.app.chat.xiaomi.net"
            com.xiaomi.push.fc.a(r0)
        Lb8:
            a(r1)
            boolean r0 = r10.m5723h()
            if (r0 == 0) goto Ld8
            java.lang.String r0 = "-->postOnCreate(): try trigger connect now"
            com.xiaomi.channel.commonutils.logger.b.m5114a(r3, r0)
            com.xiaomi.push.service.XMPushService$13 r0 = new com.xiaomi.push.service.XMPushService$13
            r1 = 11
            r0.<init>(r1)
            r10.a(r0)
            com.xiaomi.push.service.XMPushService$14 r1 = new com.xiaomi.push.service.XMPushService$14
            r1.<init>()
            com.xiaomi.push.service.q.a(r1)
        Ld8:
            boolean r0 = com.xiaomi.push.s.m5704a()     // Catch: java.lang.Exception -> Le4
            if (r0 == 0) goto Le8
            com.xiaomi.push.service.h r0 = r10.f6352a     // Catch: java.lang.Exception -> Le4
            r0.a(r10)     // Catch: java.lang.Exception -> Le4
            goto Le8
        Le4:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        Le8:
            java.lang.String r0 = r10.getPackageName()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto Lf9
            android.content.pm.ApplicationInfo r0 = r10.getApplicationInfo()
            com.xiaomi.push.g.a(r10, r0, r8)
        Lf9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c():void");
    }

    private String b() {
        String strA;
        com.xiaomi.push.ah.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            ap apVarA = ap.a(this);
            String strA2 = null;
            while (true) {
                if (!TextUtils.isEmpty(strA2) && apVarA.a() != 0) {
                    strA = a();
                    break;
                }
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException unused) {
                }
                i2++;
            }
        } else {
            strA = "CN";
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("wait coutrycode :" + strA + " cost = " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , count = " + i2);
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        fb fbVar = this.f6342a;
        if (fbVar != null && fbVar.m5483b()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while connecting.");
            return;
        }
        fb fbVar2 = this.f6342a;
        if (fbVar2 != null && fbVar2.m5484c()) {
            com.xiaomi.channel.commonutils.logger.b.d("try to connect while is connected.");
            return;
        }
        this.f6343a.b(com.xiaomi.push.av.m5212a((Context) this));
        g();
        if (this.f6342a == null) {
            am.a().a(this);
            c(false);
        }
    }

    private void g() {
        try {
            this.f6341a.a(this.f6344a, new fl() { // from class: com.xiaomi.push.service.XMPushService.5
                @Override // com.xiaomi.push.fl
                /* renamed from: a */
                public boolean mo5305a(fp fpVar) {
                    return true;
                }
            });
            this.f6341a.e();
            this.f6342a = this.f6341a;
        } catch (fj e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f6341a.b(3, e2);
        }
    }

    private void i() {
        synchronized (this.f6356a) {
            this.f6356a.clear();
        }
    }

    public class p extends j {

        /* renamed from: a, reason: collision with other field name */
        public am.b f6373a;

        public p(am.b bVar) {
            super(4);
            this.f6373a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            try {
                this.f6373a.a(am.c.unbind, 1, 16, (String) null, (String) null);
                fb fbVar = XMPushService.this.f6342a;
                am.b bVar = this.f6373a;
                fbVar.a(bVar.g, bVar.f6407b);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(xMPushService.new b(this.f6373a), 300L);
            } catch (fj e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                XMPushService.this.a(10, e2);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "rebind the client. " + this.f6373a.g;
        }
    }

    public class s extends j {

        /* renamed from: a, reason: collision with other field name */
        public am.b f6374a;

        /* renamed from: a, reason: collision with other field name */
        public String f6375a;
        public int b;

        /* renamed from: b, reason: collision with other field name */
        public String f6376b;

        public s(am.b bVar, int i, String str, String str2) {
            super(9);
            this.f6374a = bVar;
            this.b = i;
            this.f6375a = str;
            this.f6376b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            if (this.f6374a.f6402a != am.c.unbind && XMPushService.this.f6342a != null) {
                try {
                    fb fbVar = XMPushService.this.f6342a;
                    am.b bVar = this.f6374a;
                    fbVar.a(bVar.g, bVar.f6407b);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    XMPushService.this.a(10, e2);
                }
            }
            this.f6374a.a(am.c.unbind, this.b, 0, this.f6376b, this.f6375a);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "unbind the channel. " + this.f6374a.g;
        }
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m5720e() {
        return b;
    }

    public class b extends j {

        /* renamed from: a, reason: collision with other field name */
        public am.b f6366a;

        public b(am.b bVar) {
            super(9);
            this.f6366a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo5444a() {
            try {
                if (XMPushService.this.m5734c()) {
                    am amVarA = am.a();
                    am.b bVar = this.f6366a;
                    am.b bVarA = amVarA.a(bVar.g, bVar.f6407b);
                    if (bVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("ignore bind because the channel " + this.f6366a.g + " is removed ");
                    } else if (bVarA.f6402a == am.c.unbind) {
                        bVarA.a(am.c.binding, 0, 0, (String) null, (String) null);
                        XMPushService.this.f6342a.a(bVarA);
                        eq.a(XMPushService.this, bVarA);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("trying duplicate bind, ingore! " + bVarA.f6402a);
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e2);
                XMPushService.this.a(10, e2);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            return "bind the client. " + this.f6366a.g;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m5725a() {
        if (this.c < 0) {
            this.c = com.xiaomi.push.g.a((Context) this, "com.xiaomi.xmsf");
        }
        return this.c;
    }

    /* renamed from: a, reason: collision with other method in class */
    private int[] m5718a() {
        String[] strArrSplit;
        String strA = ah.a(getApplicationContext()).a(gl.FallDownTimeRange.a(), "");
        if (!TextUtils.isEmpty(strA) && (strArrSplit = strA.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && strArrSplit.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(strArrSplit[0]).intValue();
                int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                iArr[1] = iIntValue;
                int i2 = iArr[0];
                if (i2 >= 0 && i2 <= 23 && iIntValue >= 0 && iIntValue <= 23 && i2 != iIntValue) {
                    return iArr;
                }
            } catch (NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
            }
        }
        return null;
    }

    private void b(boolean z) {
        this.f6338a = SystemClock.elapsedRealtime();
        if (!m5734c()) {
            a(true);
        } else if (com.xiaomi.push.av.m5216a((Context) this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    private String a() {
        String strM5687a = com.xiaomi.push.j.m5687a("ro.miui.region");
        return TextUtils.isEmpty(strM5687a) ? com.xiaomi.push.j.m5687a("ro.product.locale.region") : strM5687a;
    }

    private void b(Intent intent) throws NumberFormatException {
        long j2;
        String stringExtra = intent.getStringExtra(an.G);
        String stringExtra2 = intent.getStringExtra(an.K);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        am amVarA = am.a();
        es esVarA = null;
        if (bundleExtra != null) {
            fo foVar = (fo) a(new fo(bundleExtra), stringExtra, stringExtra2);
            if (foVar == null) {
                return;
            } else {
                esVarA = es.a(foVar, amVarA.a(foVar.k(), foVar.m()).h);
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(an.t));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(an.u);
                String stringExtra4 = intent.getStringExtra(an.v);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                am.b bVarA = amVarA.a(stringExtra5, String.valueOf(j2));
                if (bVarA != null) {
                    es esVar = new es();
                    try {
                        esVar.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    esVar.a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    esVar.a(j2, stringExtra3, stringExtra4);
                    esVar.a(intent.getStringExtra("ext_pkt_id"));
                    esVar.a(byteArrayExtra, bVarA.h);
                    com.xiaomi.channel.commonutils.logger.b.m5113a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    esVarA = esVar;
                }
            }
        }
        if (esVarA != null) {
            c(new aw(this, esVarA));
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.n.China.name().equals(str)) {
            ch.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            ch.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            ch.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            ch.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            ch.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            ch.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            ch.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5735d() {
        fb fbVar = this.f6342a;
        return fbVar != null && fbVar.m5483b();
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(an.G);
        String stringExtra2 = intent.getStringExtra(an.K);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        fo[] foVarArr = new fo[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            fo foVar = new fo((Bundle) parcelableArrayExtra[i2]);
            foVarArr[i2] = foVar;
            fo foVar2 = (fo) a(foVar, stringExtra, stringExtra2);
            foVarArr[i2] = foVar2;
            if (foVar2 == null) {
                return;
            }
        }
        am amVarA = am.a();
        es[] esVarArr = new es[length];
        for (int i3 = 0; i3 < length; i3++) {
            fo foVar3 = foVarArr[i3];
            esVarArr[i3] = es.a(foVar3, amVarA.a(foVar3.k(), foVar3.m()).h);
        }
        c(new com.xiaomi.push.service.c(this, esVarArr));
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        com.xiaomi.push.service.m.a(getApplicationContext()).m5791a(string);
        co.a(this, string);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5728a() {
        if (SystemClock.elapsedRealtime() - this.f6338a >= fh.a() && com.xiaomi.push.av.c(this)) {
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:151:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:369:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Intent r16, long r17) throws android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.a(android.content.Intent, long):void");
    }

    private void c(j jVar) {
        this.f6353a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.s.m5704a()) {
                if (z) {
                    if (com.xiaomi.push.j.m5690a((Context) this)) {
                        Intent intent = new Intent("miui.intent.action.NETWORK_CONNECTED");
                        intent.addFlags(1073741824);
                        sendBroadcast(intent);
                    }
                    for (aa aaVar : (aa[]) this.f6357a.toArray(new aa[0])) {
                        aaVar.mo5778a();
                    }
                    return;
                }
                if (com.xiaomi.push.j.m5690a((Context) this)) {
                    Intent intent2 = new Intent("miui.intent.action.NETWORK_BLOCKED");
                    intent2.addFlags(1073741824);
                    sendBroadcast(intent2);
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5733b() {
        try {
            Class<?> clsA = com.xiaomi.push.s.a(this, "miui.os.Build");
            Field field = clsA.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = clsA.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = clsA.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public com.xiaomi.push.service.h m5731b() {
        return this.f6352a;
    }

    public void b(j jVar) {
        this.f6353a.a(jVar.a, jVar);
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        ep.a().b(fbVar);
        c(true);
        this.f6351a.m5769a();
        if (!ea.m5438a() && !m5724i()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("reconnection successful, reactivate alarm.");
            ea.a(true);
        }
        Iterator<am.b> it = am.a().m5758a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f6358a || !com.xiaomi.push.j.m5690a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.af.a(getApplicationContext()).a(new Runnable() { // from class: com.xiaomi.push.service.XMPushService.6
            @Override // java.lang.Runnable
            public void run() {
                XMPushService.this.f6358a = true;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("try to trigger the wifi digest broadcast.");
                    Object systemService = XMPushService.this.getApplicationContext().getSystemService("MiuiWifiService");
                    if (systemService != null) {
                        com.xiaomi.push.ax.b(systemService, "sendCurrentWifiDigestInfo", new Object[0]);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5734c() {
        fb fbVar = this.f6342a;
        return fbVar != null && fbVar.m5484c();
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5732b() {
        com.xiaomi.push.service.m.a(getApplicationContext()).m5795d();
        Iterator it = new ArrayList(this.f6356a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo5522a();
        }
    }

    public void a(final String str, final byte[] bArr, boolean z) {
        Collection<am.b> collectionM5759a = am.a().m5759a("5");
        if (collectionM5759a.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.t.b(str, bArr);
            }
        } else if (collectionM5759a.iterator().next().f6402a == am.c.binded) {
            a(new j(4) { // from class: com.xiaomi.push.service.XMPushService.3
                @Override // com.xiaomi.push.service.XMPushService.j
                public String a() {
                    return "send mi push message";
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                /* renamed from: a */
                public void mo5444a() {
                    try {
                        w.a(XMPushService.this, str, bArr);
                    } catch (fj e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        XMPushService.this.a(10, e2);
                    }
                }
            });
        } else if (z) {
            com.xiaomi.push.service.t.b(str, bArr);
        }
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m5113a("register request without payload");
            return;
        }
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            if (hcVar.f6123a == gg.Registration) {
                hg hgVar = new hg();
                try {
                    hq.a(hgVar, hcVar.m5599a());
                    a(new com.xiaomi.push.service.s(this, hcVar.b(), hgVar.b(), hgVar.c(), bArr));
                    du.a(getApplicationContext()).a(hcVar.b(), "E100003", hgVar.a(), 6002, null);
                } catch (hv e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                    com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m5113a("register request with invalid payload");
            }
        } catch (hv e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
            com.xiaomi.push.service.t.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    private fp a(fp fpVar, String str, String str2) {
        am amVarA = am.a();
        List<String> listM5760a = amVarA.m5760a(str);
        if (listM5760a.isEmpty()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("open channel should be called first before sending a packet, pkg=" + str);
            return null;
        }
        fpVar.o(str);
        String strK = fpVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = listM5760a.get(0);
            fpVar.l(strK);
        }
        am.b bVarA = amVarA.a(strK, fpVar.m());
        if (!m5734c()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("drop a packet as the channel is not connected, chid=" + strK);
            return null;
        }
        if (bVarA != null && bVarA.f6402a == am.c.binded) {
            if (TextUtils.equals(str2, bVarA.i)) {
                return fpVar;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("invalid session. " + str2);
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("drop a packet as the channel is not opened, chid=" + strK);
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5717a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.t));
        boolean z = false;
        if (bVarA != null && str != null) {
            String stringExtra = intent.getStringExtra(an.K);
            String stringExtra2 = intent.getStringExtra(an.C);
            if (!TextUtils.isEmpty(bVarA.i) && !TextUtils.equals(stringExtra, bVarA.i)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("session changed. old session=" + bVarA.i + ", new session=" + stringExtra + " chid = " + str);
                z = true;
            }
            if (!stringExtra2.equals(bVarA.h)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bb.a(stringExtra2));
                return true;
            }
        }
        return z;
    }

    private am.b a(String str, Intent intent) {
        am.b bVarA = am.a().a(str, intent.getStringExtra(an.t));
        if (bVarA == null) {
            bVarA = new am.b(this);
        }
        bVarA.g = intent.getStringExtra(an.w);
        bVarA.f6407b = intent.getStringExtra(an.t);
        bVarA.c = intent.getStringExtra(an.A);
        bVarA.f6404a = intent.getStringExtra(an.G);
        bVarA.f17900e = intent.getStringExtra(an.E);
        bVarA.f = intent.getStringExtra(an.F);
        bVarA.f6406a = intent.getBooleanExtra(an.D, false);
        bVarA.h = intent.getStringExtra(an.C);
        bVarA.i = intent.getStringExtra(an.K);
        bVarA.d = intent.getStringExtra(an.B);
        bVarA.f6403a = this.f6352a;
        bVarA.a((Messenger) intent.getParcelableExtra(an.O));
        bVarA.f6396a = getApplicationContext();
        am.a().a(bVarA);
        return bVarA;
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        am.b bVarA = am.a().a(str, str2);
        if (bVarA != null) {
            a(new s(bVarA, i2, str4, str3));
        }
        am.a().m5763a(str, str2);
    }

    private void a(String str, int i2) {
        Collection<am.b> collectionM5759a = am.a().m5759a(str);
        if (collectionM5759a != null) {
            for (am.b bVar : collectionM5759a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        am.a().m5762a(str);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f6353a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("can't execute job err = " + e2.getMessage());
        }
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public void a(es esVar) throws fj {
        fb fbVar = this.f6342a;
        if (fbVar != null) {
            fbVar.b(esVar);
            return;
        }
        throw new fj("try send msg while connection is null.");
    }

    public void a(es[] esVarArr) throws fj {
        fb fbVar = this.f6342a;
        if (fbVar != null) {
            fbVar.a(esVarArr);
            return;
        }
        throw new fj("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.f6351a.a(z);
    }

    public void a(am.b bVar) {
        if (bVar != null) {
            long jA = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m5113a("schedule rebind job in " + (jA / 1000));
            a(new b(bVar), jA);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fb fbVar = this.f6342a;
        sb.append(fbVar == null ? null : Integer.valueOf(fbVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
        fb fbVar2 = this.f6342a;
        if (fbVar2 != null) {
            fbVar2.b(i2, exc);
            this.f6342a = null;
        }
        a(7);
        a(4);
        am.a().a(this, i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5729a() {
        boolean zM5216a = com.xiaomi.push.av.m5216a((Context) this);
        boolean z = am.a().m5757a() > 0;
        boolean z2 = !m5733b();
        boolean zM5723h = m5723h();
        boolean z3 = !m5722g();
        boolean z4 = zM5216a && z && z2 && zM5723h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(zM5216a), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(zM5723h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a, reason: collision with other method in class */
    public com.xiaomi.push.service.h m5727a() {
        return new com.xiaomi.push.service.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) throws InterruptedException {
        try {
            com.xiaomi.push.ah.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.av.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public fb m5726a() {
        return this.f6342a;
    }

    public void a(int i2) {
        this.f6353a.a(i2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5730a(int i2) {
        return this.f6353a.m5798a(i2);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        ep.a().a(fbVar);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i2, Exception exc) {
        ep.a().a(fbVar, i2, exc);
        if (m5724i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
        ep.a().a(fbVar, exc);
        c(false);
        if (m5724i()) {
            return;
        }
        a(false);
    }

    public void a(n nVar) {
        synchronized (this.f6356a) {
            this.f6356a.add(nVar);
        }
    }
}
