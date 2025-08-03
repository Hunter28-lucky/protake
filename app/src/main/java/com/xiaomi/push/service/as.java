package com.xiaomi.push.service;

import com.xiaomi.push.ep;
import com.xiaomi.push.service.XMPushService.e;

/* loaded from: classes2.dex */
class as {
    private static int d = 300000;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f6418a;
    private int b = 0;
    private int c = 0;
    private int a = 500;

    /* renamed from: a, reason: collision with other field name */
    private long f6417a = 0;

    public as(XMPushService xMPushService) {
        this.f6418a = xMPushService;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5769a() {
        this.f6417a = System.currentTimeMillis();
        this.f6418a.a(1);
        this.b = 0;
    }

    public void a(boolean z) {
        if (!this.f6418a.m5729a()) {
            com.xiaomi.channel.commonutils.logger.b.c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f6418a.m5730a(1)) {
                this.b++;
            }
            this.f6418a.a(1);
            com.xiaomi.channel.commonutils.logger.b.m5114a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f6418a;
            xMPushService.getClass();
            xMPushService.a(xMPushService.new e());
            return;
        }
        if (this.f6418a.m5730a(1)) {
            return;
        }
        int iA = a();
        this.b++;
        com.xiaomi.channel.commonutils.logger.b.m5113a("schedule reconnect in " + iA + "ms");
        XMPushService xMPushService2 = this.f6418a;
        xMPushService2.getClass();
        xMPushService2.a(xMPushService2.new e(), (long) iA);
        if (this.b == 2 && ep.m5447a().m5452a()) {
            z.b();
        }
        if (this.b == 3) {
            z.a();
        }
    }

    private int a() {
        double d2;
        if (this.b > 8) {
            return 300000;
        }
        double dRandom = (Math.random() * 2.0d) + 1.0d;
        int i = this.b;
        if (i > 4) {
            d2 = 60000.0d;
        } else {
            if (i <= 1) {
                if (this.f6417a == 0) {
                    return 0;
                }
                if (System.currentTimeMillis() - this.f6417a < 310000) {
                    int i2 = this.a;
                    int i3 = d;
                    if (i2 >= i3) {
                        return i2;
                    }
                    int i4 = this.c + 1;
                    this.c = i4;
                    if (i4 >= 4) {
                        return i3;
                    }
                    this.a = (int) (i2 * 1.5d);
                    return i2;
                }
                this.a = 1000;
                this.c = 0;
                return 0;
            }
            d2 = 10000.0d;
        }
        return (int) (dRandom * d2);
    }
}
