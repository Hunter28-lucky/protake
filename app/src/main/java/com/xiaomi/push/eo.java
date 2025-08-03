package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
public class eo implements fe {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    public fb f5857a;

    /* renamed from: a, reason: collision with other field name */
    public XMPushService f5858a;

    /* renamed from: a, reason: collision with other field name */
    private Exception f5859a;

    /* renamed from: e, reason: collision with root package name */
    private long f17859e;
    private long f;

    /* renamed from: a, reason: collision with other field name */
    private long f5856a = 0;
    private long b = 0;
    private long c = 0;
    private long d = 0;

    /* renamed from: a, reason: collision with other field name */
    private String f5860a = "";

    public eo(XMPushService xMPushService) {
        this.f17859e = 0L;
        this.f = 0L;
        this.f5858a = xMPushService;
        b();
        int iMyUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(iMyUid);
            this.f17859e = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Failed to obtain traffic data during initialization: " + e2);
            this.f = -1L;
            this.f17859e = -1L;
        }
    }

    private void b() {
        this.b = 0L;
        this.d = 0L;
        this.f5856a = 0L;
        this.c = 0L;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (av.m5216a((Context) this.f5858a)) {
            this.f5856a = jElapsedRealtime;
        }
        if (this.f5858a.m5734c()) {
            this.c = jElapsedRealtime;
        }
    }

    private synchronized void c() {
        com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f5860a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
        ek ekVar = new ek();
        ekVar.f5835a = (byte) 0;
        ekVar.a(ej.CHANNEL_ONLINE_RATE.a());
        ekVar.a(this.f5860a);
        ekVar.d((int) (System.currentTimeMillis() / 1000));
        ekVar.b((int) (this.b / 1000));
        ekVar.c((int) (this.d / 1000));
        ep.m5447a().a(ekVar);
        b();
    }

    public Exception a() {
        return this.f5859a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5446a() {
        XMPushService xMPushService = this.f5858a;
        if (xMPushService == null) {
            return;
        }
        String strM5212a = av.m5212a((Context) xMPushService);
        boolean zB = av.b(this.f5858a);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f5856a;
        if (j > 0) {
            this.b += jElapsedRealtime - j;
            this.f5856a = 0L;
        }
        long j2 = this.c;
        if (j2 != 0) {
            this.d += jElapsedRealtime - j2;
            this.c = 0L;
        }
        if (zB) {
            if ((!TextUtils.equals(this.f5860a, strM5212a) && this.b > 30000) || this.b > 5400000) {
                c();
            }
            this.f5860a = strM5212a;
            if (this.f5856a == 0) {
                this.f5856a = jElapsedRealtime;
            }
            if (this.f5858a.m5734c()) {
                this.c = jElapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        m5446a();
        this.c = SystemClock.elapsedRealtime();
        eq.a(0, ej.CONN_SUCCESS.a(), fbVar.mo5479a(), fbVar.a());
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
        this.a = 0;
        this.f5859a = null;
        this.f5857a = fbVar;
        this.f5860a = av.m5212a((Context) this.f5858a);
        eq.a(0, ej.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i, Exception exc) {
        long uidTxBytes;
        if (this.a == 0 && this.f5859a == null) {
            this.a = i;
            this.f5859a = exc;
            eq.b(fbVar.mo5479a(), exc);
        }
        if (i == 22 && this.c != 0) {
            long jM5477a = fbVar.m5477a() - this.c;
            if (jM5477a < 0) {
                jM5477a = 0;
            }
            this.d += jM5477a + (fh.b() / 2);
            this.c = 0L;
        }
        m5446a();
        int iMyUid = Process.myUid();
        long uidRxBytes = -1;
        try {
            uidRxBytes = TrafficStats.getUidRxBytes(iMyUid);
            uidTxBytes = TrafficStats.getUidTxBytes(iMyUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Failed to obtain traffic data: " + e2);
            uidTxBytes = -1L;
        }
        com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (uidRxBytes - this.f) + ", tx=" + (uidTxBytes - this.f17859e));
        this.f = uidRxBytes;
        this.f17859e = uidTxBytes;
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
        eq.a(0, ej.CHANNEL_CON_FAIL.a(), 1, fbVar.mo5479a(), av.b(this.f5858a) ? 1 : 0);
        m5446a();
    }
}
