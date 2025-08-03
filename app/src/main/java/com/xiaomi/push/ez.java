package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.dq;
import com.xiaomi.push.fb;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ez extends fi {
    private eu a;

    /* renamed from: a, reason: collision with other field name */
    private ev f5890a;

    /* renamed from: a, reason: collision with other field name */
    private Thread f5891a;

    /* renamed from: a, reason: collision with other field name */
    private byte[] f5892a;

    public ez(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
    }

    private void h() throws fj {
        try {
            this.a = new eu(((fi) this).f5920a.getInputStream(), this);
            this.f5890a = new ev(((fi) this).f5920a.getOutputStream(), this);
            Thread thread = new Thread("Blob Reader (" + ((fb) this).b + ")") { // from class: com.xiaomi.push.ez.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ez.this.a.m5467a();
                    } catch (Exception e2) {
                        ez.this.c(9, e2);
                    }
                }
            };
            this.f5891a = thread;
            thread.start();
        } catch (Exception e2) {
            throw new fj("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.fb
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5472a() {
        return true;
    }

    public void b(fp fpVar) {
        if (fpVar == null) {
            return;
        }
        Iterator<fb.a> it = ((fb) this).f5909a.values().iterator();
        while (it.hasNext()) {
            it.next().a(fpVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized byte[] m5473a() {
        if (this.f5892a == null && !TextUtils.isEmpty(((fb) this).f5906a)) {
            String strM5771a = com.xiaomi.push.service.ax.m5771a();
            StringBuilder sb = new StringBuilder();
            String str = ((fb) this).f5906a;
            sb.append(str.substring(str.length() / 2));
            sb.append(strM5771a.substring(strM5771a.length() / 2));
            this.f5892a = com.xiaomi.push.service.ar.a(((fb) this).f5906a.getBytes(), sb.toString().getBytes());
        }
        return this.f5892a;
    }

    @Override // com.xiaomi.push.fb
    public void b(es esVar) throws fj {
        ev evVar = this.f5890a;
        if (evVar != null) {
            try {
                int iA = evVar.a(esVar);
                ((fb) this).d = SystemClock.elapsedRealtime();
                String strF = esVar.f();
                if (!TextUtils.isEmpty(strF)) {
                    ga.a(((fb) this).f5905a, strF, iA, false, true, System.currentTimeMillis());
                }
                Iterator<fb.a> it = ((fb) this).f5912b.values().iterator();
                while (it.hasNext()) {
                    it.next().a(esVar);
                }
                return;
            } catch (Exception e2) {
                throw new fj(e2);
            }
        }
        throw new fj("the writer is null.");
    }

    private es a(boolean z) {
        ey eyVar = new ey();
        if (z) {
            eyVar.a("1");
        }
        byte[] bArrM5453a = eq.m5453a();
        if (bArrM5453a != null) {
            dq.j jVar = new dq.j();
            jVar.a(a.a(bArrM5453a));
            eyVar.a(jVar.m5437a(), (String) null);
        }
        return eyVar;
    }

    @Override // com.xiaomi.push.fi
    /* renamed from: a, reason: collision with other method in class */
    public void mo5471a(boolean z) throws fj {
        if (this.f5890a != null) {
            es esVarA = a(z);
            com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] SND ping id=" + esVarA.e());
            b(esVarA);
            f();
            return;
        }
        throw new fj("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.fb
    public synchronized void a(am.b bVar) {
        er.a(bVar, c(), this);
    }

    @Override // com.xiaomi.push.fb
    public synchronized void a(String str, String str2) {
        er.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fi
    public synchronized void a(int i, Exception exc) {
        eu euVar = this.a;
        if (euVar != null) {
            euVar.b();
            this.a = null;
        }
        ev evVar = this.f5890a;
        if (evVar != null) {
            try {
                evVar.b();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e2);
            }
            this.f5890a = null;
            this.f5892a = null;
            super.a(i, exc);
        } else {
            this.f5892a = null;
            super.a(i, exc);
        }
    }

    @Override // com.xiaomi.push.fi, com.xiaomi.push.fb
    public void a(es[] esVarArr) throws fj {
        for (es esVar : esVarArr) {
            b(esVar);
        }
    }

    @Override // com.xiaomi.push.fb
    @Deprecated
    public void a(fp fpVar) throws fj {
        b(es.a(fpVar, (String) null));
    }

    @Override // com.xiaomi.push.fi
    /* renamed from: a */
    public synchronized void mo5491a() {
        h();
        this.f5890a.a();
    }

    public void a(es esVar) {
        if (esVar == null) {
            return;
        }
        if (com.xiaomi.push.service.e.a(esVar)) {
            es esVar2 = new es();
            esVar2.a(esVar.a());
            esVar2.a("SYNC", "ACK_RTT");
            esVar2.a(esVar.e());
            esVar2.b(esVar.m5461b());
            esVar2.a(esVar.m5464c());
            XMPushService xMPushService = ((fb) this).f5905a;
            xMPushService.a(new com.xiaomi.push.service.aw(xMPushService, esVar2));
        }
        if (esVar.m5458a()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] RCV blob chid=" + esVar.a() + "; id=" + esVar.e() + "; errCode=" + esVar.b() + "; err=" + esVar.m5465c());
        }
        if (esVar.a() == 0) {
            if ("PING".equals(esVar.m5455a())) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("[Slim] RCV ping id=" + esVar.e());
                g();
            } else if ("CLOSE".equals(esVar.m5455a())) {
                c(13, null);
            }
        }
        Iterator<fb.a> it = ((fb) this).f5909a.values().iterator();
        while (it.hasNext()) {
            it.next().a(esVar);
        }
    }
}
