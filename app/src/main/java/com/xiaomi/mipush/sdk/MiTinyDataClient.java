package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {
        private static volatile a a;

        /* renamed from: a, reason: collision with other field name */
        private Context f5492a;

        /* renamed from: a, reason: collision with other field name */
        private Boolean f5494a;

        /* renamed from: a, reason: collision with other field name */
        private String f5495a;

        /* renamed from: a, reason: collision with other field name */
        private C1935a f5493a = new C1935a();

        /* renamed from: a, reason: collision with other field name */
        private final ArrayList<gk> f5496a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a, reason: collision with other inner class name */
        public class C1935a {

            /* renamed from: a, reason: collision with other field name */
            private ScheduledFuture<?> f5499a;

            /* renamed from: a, reason: collision with other field name */
            private ScheduledThreadPoolExecutor f5500a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a, reason: collision with other field name */
            public final ArrayList<gk> f5498a = new ArrayList<>();

            /* renamed from: a, reason: collision with other field name */
            private final Runnable f5497a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C1935a.this.f5498a.size() != 0) {
                        C1935a.this.b();
                    } else if (C1935a.this.f5499a != null) {
                        C1935a.this.f5499a.cancel(false);
                        C1935a.this.f5499a = null;
                    }
                }
            };

            public C1935a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                gk gkVarRemove = this.f5498a.remove(0);
                for (hf hfVar : az.a(Arrays.asList(gkVarRemove), a.this.f5492a.getPackageName(), b.m5140a(a.this.f5492a).m5141a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + gkVarRemove.d());
                    u.a(a.this.f5492a).a((u) hfVar, gg.Notification, true, (gt) null);
                }
            }

            public void a(final gk gkVar) {
                this.f5500a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1935a.this.f5498a.add(gkVar);
                        C1935a.this.a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f5499a == null) {
                    this.f5499a = this.f5500a.scheduleAtFixedRate(this.f5497a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f5496a) {
                arrayList.addAll(this.f5496a);
                this.f5496a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m5134a((gk) it.next());
            }
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

        /* renamed from: a, reason: collision with other method in class */
        public void m5132a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f5492a = context;
            this.f5494a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        private boolean b(Context context) {
            return b.m5140a(context).m5141a() == null && !a(this.f5492a);
        }

        private boolean b(gk gkVar) {
            if (az.a(gkVar, false)) {
                return false;
            }
            if (this.f5494a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gkVar.d());
                u.a(this.f5492a).a(gkVar);
                return true;
            }
            this.f5493a.a(gkVar);
            return true;
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f5495a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        private boolean a(Context context) throws PackageManager.NameNotFoundException {
            if (!u.a(context).m5185a()) {
                return true;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 108;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5133a() {
            return this.f5492a != null;
        }

        /* renamed from: a, reason: collision with other method in class */
        public synchronized boolean m5134a(gk gkVar) {
            if (gkVar == null) {
                return false;
            }
            if (az.a(gkVar, true)) {
                return false;
            }
            boolean z = TextUtils.isEmpty(gkVar.m5527a()) && TextUtils.isEmpty(this.f5495a);
            boolean z2 = !m5133a();
            Context context = this.f5492a;
            boolean z3 = context == null || b(context);
            if (!z2 && !z && !z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item immediately." + gkVar.d());
                if (TextUtils.isEmpty(gkVar.d())) {
                    gkVar.f(aj.a());
                }
                if (TextUtils.isEmpty(gkVar.m5527a())) {
                    gkVar.a(this.f5495a);
                }
                if (TextUtils.isEmpty(gkVar.c())) {
                    gkVar.e(this.f5492a.getPackageName());
                }
                if (gkVar.a() <= 0) {
                    gkVar.b(System.currentTimeMillis());
                }
                return b(gkVar);
            }
            if (z) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_CHANNEL);
            } else if (z2) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_INIT);
            } else if (z3) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + gkVar.b() + " reason is " + MiTinyDataClient.PENDING_REASON_APPID);
            }
            a(gkVar);
            return true;
        }

        private void a(gk gkVar) {
            synchronized (this.f5496a) {
                if (!this.f5496a.contains(gkVar)) {
                    this.f5496a.add(gkVar);
                    if (this.f5496a.size() > 100) {
                        this.f5496a.remove(0);
                    }
                }
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m5132a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j);
        gkVar.b(str3);
        return a.a().m5134a(gkVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        gk gkVar = new gk();
        gkVar.d(str);
        gkVar.c(str2);
        gkVar.a(j);
        gkVar.b(str3);
        gkVar.a(true);
        gkVar.a("push_sdk_channel");
        return upload(context, gkVar);
    }

    public static boolean upload(Context context, gk gkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + gkVar.d());
        if (!a.a().m5133a()) {
            a.a().m5132a(context);
        }
        return a.a().m5134a(gkVar);
    }
}
