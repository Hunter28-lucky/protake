package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fj;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.XMPushService.b;
import com.xiaomi.push.service.am;
import java.util.Collection;

/* loaded from: classes2.dex */
public class s extends XMPushService.j {
    private XMPushService a;

    /* renamed from: a, reason: collision with other field name */
    private String f6478a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f6479a;
    private String b;
    private String c;

    public s(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f6478a = str;
        this.f6479a = bArr;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String a() {
        return "register app";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo5444a() {
        am.b next;
        p pVarM5807a = q.m5807a((Context) this.a);
        if (pVarM5807a == null) {
            try {
                pVarM5807a = q.a(this.a, this.f6478a, this.b, this.c);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to register push account. " + e2);
            }
        }
        if (pVarM5807a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("no account for registration.");
            t.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("do registration now.");
        Collection<am.b> collectionM5759a = am.a().m5759a("5");
        if (collectionM5759a.isEmpty()) {
            next = pVarM5807a.a(this.a);
            w.a(this.a, next);
            am.a().a(next);
        } else {
            next = collectionM5759a.iterator().next();
        }
        if (!this.a.m5734c()) {
            t.a(this.f6478a, this.f6479a);
            this.a.a(true);
            return;
        }
        try {
            am.c cVar = next.f6402a;
            if (cVar == am.c.binded) {
                w.a(this.a, this.f6478a, this.f6479a);
            } else if (cVar == am.c.unbind) {
                t.a(this.f6478a, this.f6479a);
                XMPushService xMPushService = this.a;
                xMPushService.getClass();
                xMPushService.a(xMPushService.new b(next));
            }
        } catch (fj e3) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error, disconnect connection. " + e3);
            this.a.a(10, e3);
        }
    }
}
