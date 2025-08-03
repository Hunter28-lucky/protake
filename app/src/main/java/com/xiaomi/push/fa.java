package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.dq;
import com.xiaomi.push.fb;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public class fa implements fk {
    public static boolean a = false;

    /* renamed from: a, reason: collision with other field name */
    private fb f5894a;

    /* renamed from: a, reason: collision with other field name */
    private SimpleDateFormat f5897a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a, reason: collision with other field name */
    private a f5893a = null;
    private a b = null;

    /* renamed from: a, reason: collision with other field name */
    private fe f5895a = null;

    /* renamed from: a, reason: collision with other field name */
    private final String f5896a = "[Slim] ";

    public fa(fb fbVar) {
        this.f5894a = fbVar;
        a();
    }

    private void a() {
        this.f5893a = new a(true);
        this.b = new a(false);
        fb fbVar = this.f5894a;
        a aVar = this.f5893a;
        fbVar.a(aVar, aVar);
        fb fbVar2 = this.f5894a;
        a aVar2 = this.b;
        fbVar2.b(aVar2, aVar2);
        this.f5895a = new fe() { // from class: com.xiaomi.push.fa.1
            @Override // com.xiaomi.push.fe
            public void a(fb fbVar3, int i, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + " Connection closed (" + fa.this.f5894a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fe
            public void b(fb fbVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + " Connection reconnected (" + fa.this.f5894a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.fe
            public void a(fb fbVar3, Exception exc) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + " Reconnection failed due to an exception (" + fa.this.f5894a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.fe
            public void a(fb fbVar3) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + " Connection started (" + fa.this.f5894a.hashCode() + ")");
            }
        };
    }

    public class a implements fg, fl {

        /* renamed from: a, reason: collision with other field name */
        public String f5898a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f5899a;

        public a(boolean z) {
            this.f5899a = z;
            this.f5898a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fg
        public void a(fp fpVar) {
            if (fa.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + this.f5898a + " PKT " + fpVar.mo5496a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + this.f5898a + " PKT [" + fpVar.k() + Constants.ACCEPT_TIME_SEPARATOR_SP + fpVar.j() + "]");
        }

        @Override // com.xiaomi.push.fl
        /* renamed from: a */
        public boolean mo5305a(fp fpVar) {
            return true;
        }

        @Override // com.xiaomi.push.fg
        public void a(es esVar) throws NumberFormatException {
            if (fa.a) {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + this.f5898a + esVar.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.c("[Slim] " + fa.this.f5897a.format(new Date()) + this.f5898a + " Blob [" + esVar.m5455a() + Constants.ACCEPT_TIME_SEPARATOR_SP + esVar.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.push.service.aj.a(esVar.e()) + "]");
            }
            if (esVar == null || esVar.a() != 99999) {
                return;
            }
            String strM5455a = esVar.m5455a();
            es esVar2 = null;
            if (!this.f5899a) {
                if ("BIND".equals(strM5455a)) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("build binded result for loopback.");
                    dq.d dVar = new dq.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b("success");
                    dVar.a("success");
                    es esVar3 = new es();
                    esVar3.a(dVar.m5437a(), (String) null);
                    esVar3.a((short) 2);
                    esVar3.a(99999);
                    esVar3.a("BIND", (String) null);
                    esVar3.a(esVar.e());
                    esVar3.b((String) null);
                    esVar3.c(esVar.g());
                    esVar2 = esVar3;
                } else if (!"UBND".equals(strM5455a) && "SECMSG".equals(strM5455a)) {
                    es esVar4 = new es();
                    esVar4.a(99999);
                    esVar4.a("SECMSG", (String) null);
                    esVar4.c(esVar.g());
                    esVar4.a(esVar.e());
                    esVar4.a(esVar.m5457a());
                    esVar4.b(esVar.f());
                    esVar4.a(esVar.m5460a(com.xiaomi.push.service.am.a().a(String.valueOf(99999), esVar.g()).h), (String) null);
                    esVar2 = esVar4;
                }
            }
            if (esVar2 != null) {
                for (Map.Entry<fg, fb.a> entry : fa.this.f5894a.m5480a().entrySet()) {
                    if (fa.this.f5893a != entry.getKey()) {
                        entry.getValue().a(esVar2);
                    }
                }
            }
        }
    }
}
