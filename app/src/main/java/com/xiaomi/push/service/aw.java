package com.xiaomi.push.service;

import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
public class aw extends XMPushService.j {
    private es a;

    /* renamed from: a, reason: collision with other field name */
    private XMPushService f6420a;

    public aw(XMPushService xMPushService, es esVar) {
        super(4);
        this.f6420a = xMPushService;
        this.a = esVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "send a message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo5444a() {
        try {
            es esVar = this.a;
            if (esVar != null) {
                if (e.a(esVar)) {
                    this.a.c(System.currentTimeMillis() - this.a.m5454a());
                }
                this.f6420a.a(this.a);
            }
        } catch (fj e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.f6420a.a(10, e2);
        }
    }
}
