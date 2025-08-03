package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes2.dex */
public abstract class fi extends fb {
    public Exception a;

    /* renamed from: a, reason: collision with other field name */
    public Socket f5920a;
    public XMPushService b;
    private int c;

    /* renamed from: c, reason: collision with other field name */
    public String f5921c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f17862e;
    public volatile long f;
    public volatile long g;
    private long h;

    public fi(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
        this.a = null;
        this.f5921c = null;
        this.f17862e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    public Context a() {
        return this.b;
    }

    /* renamed from: a */
    public abstract void mo5471a(boolean z);

    @Override // com.xiaomi.push.fb
    public void b(boolean z) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        mo5471a(z);
        com.xiaomi.push.service.m.a(this.b).m5794c();
        if (z) {
            return;
        }
        this.b.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fi.1
            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                Thread.yield();
                if (!fi.this.m5484c() || fi.this.a(jElapsedRealtime)) {
                    return;
                }
                com.xiaomi.push.service.m.a(fi.this.b).m5793b();
                fi.this.b.a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "check the ping-pong." + jCurrentTimeMillis;
            }
        }, 10000L);
    }

    public String c() {
        return ((fb) this).f5906a;
    }

    public synchronized void e() {
        try {
            if (!m5484c() && !m5483b()) {
                a(0, 0, (Exception) null);
                a(((fb) this).f5903a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new fj(e2);
        }
    }

    public void f() {
        this.f17862e = SystemClock.elapsedRealtime();
    }

    public void g() {
        this.f = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.fb
    /* renamed from: a */
    public String mo5479a() {
        return this.d;
    }

    public void c(final int i, final Exception exc) {
        av.b();
        this.b.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fi.2
            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                fi.this.b.a(i, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "shutdown the connection. " + i + ", " + exc;
            }
        });
    }

    public synchronized void a(int i, Exception exc) {
        if (b() == 2) {
            return;
        }
        a(2, i, exc);
        ((fb) this).f5906a = "";
        try {
            this.f5920a.close();
        } catch (Throwable unused) {
        }
        this.f17862e = 0L;
        this.f = 0L;
    }

    @Override // com.xiaomi.push.fb
    public void b(int i, Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.g != 0) {
            a(exc);
        }
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.g < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL) {
            if (av.m5216a((Context) this.b)) {
                int i = this.c + 1;
                this.c = i;
                if (i >= 2) {
                    String strMo5479a = mo5479a();
                    com.xiaomi.channel.commonutils.logger.b.m5113a("max short conn time reached, sink down current host:" + strMo5479a);
                    a(strMo5479a, 0L, exc);
                    this.c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.c = 0;
    }

    public void a(String str, long j, Exception exc) {
        cd cdVarA = ch.a().a(fc.a(), false);
        if (cdVarA != null) {
            cdVarA.b(str, j, 0L, exc);
            ch.a().m5301c();
        }
    }

    @Override // com.xiaomi.push.fb
    public void a(es[] esVarArr) throws fj {
        throw new fj("Don't support send Blob");
    }

    private void a(fc fcVar) throws Throwable {
        a(fcVar.c(), fcVar.m5485a());
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0276 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0276 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0351  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r32, int r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 860
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fi.a(java.lang.String, int):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void mo5491a() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public Socket m5490a() {
        return new Socket();
    }

    public cd a(final String str) {
        cd cdVarA = ch.a().a(str, false);
        if (!cdVarA.b()) {
            fz.a(new Runnable() { // from class: com.xiaomi.push.fi.3
                @Override // java.lang.Runnable
                public void run() {
                    ch.a().a(str, true);
                }
            });
        }
        return cdVarA;
    }
}
