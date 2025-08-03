package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.push.ag;
import com.xiaomi.push.cj;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.fz;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ax {
    private static ax a = new ax();

    /* renamed from: a, reason: collision with other field name */
    private static String f6421a;

    /* renamed from: a, reason: collision with other field name */
    private ag.b f6422a;

    /* renamed from: a, reason: collision with other field name */
    private dp.a f6423a;

    /* renamed from: a, reason: collision with other field name */
    private List<a> f6424a = new ArrayList();

    public static abstract class a {
        public void a(dp.a aVar) {
        }

        public void a(dq.b bVar) {
        }
    }

    private ax() {
    }

    private void b() throws Throwable {
        if (this.f6423a == null) {
            d();
        }
    }

    private void c() {
        if (this.f6422a != null) {
            return;
        }
        ag.b bVar = new ag.b() { // from class: com.xiaomi.push.service.ax.1

            /* renamed from: a, reason: collision with other field name */
            public boolean f6425a = false;

            @Override // com.xiaomi.push.ag.b
            public void b() {
                try {
                    dp.a aVarA = dp.a.a(Base64.decode(cj.a(com.xiaomi.push.s.m5702a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<com.xiaomi.push.au>) null), 10));
                    if (aVarA != null) {
                        ax.this.f6423a = aVarA;
                        this.f6425a = true;
                        ax.this.e();
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("fetch config failure: " + e2.getMessage());
                }
            }

            @Override // com.xiaomi.push.ag.b
            /* renamed from: c */
            public void mo5330c() {
                a[] aVarArr;
                ax.this.f6422a = null;
                if (this.f6425a) {
                    synchronized (ax.this) {
                        aVarArr = (a[]) ax.this.f6424a.toArray(new a[ax.this.f6424a.size()]);
                    }
                    for (a aVar : aVarArr) {
                        aVar.a(ax.this.f6423a);
                    }
                }
            }
        };
        this.f6422a = bVar;
        fz.a(bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.s.m5702a()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            com.xiaomi.push.b r0 = com.xiaomi.push.b.a(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            com.xiaomi.push.dp$a r0 = com.xiaomi.push.dp.a.b(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f6423a = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            com.xiaomi.push.x.a(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            com.xiaomi.channel.commonutils.logger.b.m5113a(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            com.xiaomi.push.dp$a r0 = r4.f6423a
            if (r0 != 0) goto L4e
            com.xiaomi.push.dp$a r0 = new com.xiaomi.push.dp$a
            r0.<init>()
            r4.f6423a = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            com.xiaomi.push.x.a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws IOException {
        try {
            if (this.f6423a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.s.m5702a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c cVarA = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f6423a.a(cVarA);
                cVarA.m5261a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("save config failure: " + e2.getMessage());
        }
    }

    public static ax a() {
        return a;
    }

    public synchronized void a(a aVar) {
        this.f6424a.add(aVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5776a() {
        this.f6424a.clear();
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m5774a() throws Throwable {
        b();
        dp.a aVar = this.f6423a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public dp.a m5775a() throws Throwable {
        b();
        return this.f6423a;
    }

    public void a(dq.b bVar) {
        a[] aVarArr;
        if (bVar.m5365d() && bVar.d() > m5774a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f6424a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized String m5771a() {
        if (f6421a == null) {
            SharedPreferences sharedPreferences = com.xiaomi.push.s.m5702a().getSharedPreferences("XMPushServiceConfig", 0);
            String string = sharedPreferences.getString("DeviceUUID", null);
            f6421a = string;
            if (string == null) {
                String strA = com.xiaomi.push.i.a(com.xiaomi.push.s.m5702a(), false);
                f6421a = strA;
                if (strA != null) {
                    sharedPreferences.edit().putString("DeviceUUID", f6421a).commit();
                }
            }
        }
        return f6421a;
    }
}
