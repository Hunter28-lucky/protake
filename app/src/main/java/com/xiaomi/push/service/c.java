package com.xiaomi.push.service;

import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes2.dex */
class c extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a, reason: collision with other field name */
    private es[] f6444a;

    public c(XMPushService xMPushService, es[] esVarArr) {
        super(4);
        this.a = xMPushService;
        this.f6444a = esVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "batch send message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo5444a() {
        try {
            es[] esVarArr = this.f6444a;
            if (esVarArr != null) {
                this.a.a(esVarArr);
            }
        } catch (fj e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            this.a.a(10, e2);
        }
    }
}
