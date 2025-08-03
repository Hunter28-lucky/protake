package com.xiaomi.push.service;

import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.cd;
import com.xiaomi.push.ch;
import com.xiaomi.push.dc;
import com.xiaomi.push.dq;
import com.xiaomi.push.ej;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import com.xiaomi.push.fc;
import com.xiaomi.push.fm;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.service.am;
import java.util.Date;

/* loaded from: classes2.dex */
public class ak {
    private XMPushService a;

    public ak(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void c(es esVar) {
        am.b bVarA;
        String strG = esVar.g();
        String string = Integer.toString(esVar.a());
        if (TextUtils.isEmpty(strG) || TextUtils.isEmpty(string) || (bVarA = am.a().a(string, strG)) == null) {
            return;
        }
        ga.a(this.a, bVarA.f6404a, esVar.c(), true, true, System.currentTimeMillis());
    }

    public void a(fp fpVar) {
        if (!"5".equals(fpVar.k())) {
            b(fpVar);
        }
        String strK = fpVar.k();
        if (TextUtils.isEmpty(strK)) {
            strK = "1";
            fpVar.l("1");
        }
        if (strK.equals("0")) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Received wrong packet with chid = 0 : " + fpVar.mo5496a());
        }
        if (fpVar instanceof fn) {
            fm fmVarA = fpVar.a("kick");
            if (fmVarA != null) {
                String strL = fpVar.l();
                String strA = fmVarA.a("type");
                String strA2 = fmVarA.a("reason");
                com.xiaomi.channel.commonutils.logger.b.m5113a("kicked by server, chid=" + strK + " res=" + am.b.a(strL) + " type=" + strA + " reason=" + strA2);
                if (!"wait".equals(strA)) {
                    this.a.a(strK, strL, 3, strA2, strA);
                    am.a().m5763a(strK, strL);
                    return;
                }
                am.b bVarA = am.a().a(strK, strL);
                if (bVarA != null) {
                    this.a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strA2, strA);
                    return;
                }
                return;
            }
        } else if (fpVar instanceof fo) {
            fo foVar = (fo) fpVar;
            if ("redir".equals(foVar.b())) {
                fm fmVarA2 = foVar.a("hosts");
                if (fmVarA2 != null) {
                    a(fmVarA2);
                    return;
                }
                return;
            }
        }
        this.a.m5731b().a(this.a, strK, fpVar);
    }

    public void b(es esVar) throws RemoteException {
        String strM5455a = esVar.m5455a();
        if (esVar.a() == 0) {
            if ("PING".equals(strM5455a)) {
                byte[] bArrM5459a = esVar.m5459a();
                if (bArrM5459a != null && bArrM5459a.length > 0) {
                    dq.j jVarA = dq.j.a(bArrM5459a);
                    if (jVarA.m5413b()) {
                        ax.a().a(jVarA.m5411a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                    this.a.m5728a();
                }
                if ("1".equals(esVar.e())) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("received a server ping");
                } else {
                    eq.b();
                }
                this.a.m5732b();
                return;
            }
            if (!"SYNC".equals(strM5455a)) {
                if ("NOTIFY".equals(esVar.m5455a())) {
                    dq.h hVarA = dq.h.a(esVar.m5459a());
                    com.xiaomi.channel.commonutils.logger.b.m5113a("notify by server err = " + hVarA.c() + " desc = " + hVarA.m5405a());
                    return;
                }
                return;
            }
            if ("CONF".equals(esVar.m5462b())) {
                ax.a().a(dq.b.a(esVar.m5459a()));
                return;
            }
            if (TextUtils.equals("U", esVar.m5462b())) {
                dq.k kVarA = dq.k.a(esVar.m5459a());
                dc.a(this.a).a(kVarA.m5415a(), kVarA.m5418b(), new Date(kVarA.m5414a()), new Date(kVarA.m5417b()), kVarA.c() * 1024, kVarA.e());
                es esVar2 = new es();
                esVar2.a(0);
                esVar2.a(esVar.m5455a(), "UCA");
                esVar2.a(esVar.e());
                XMPushService xMPushService = this.a;
                xMPushService.a(new aw(xMPushService, esVar2));
                return;
            }
            if (TextUtils.equals("P", esVar.m5462b())) {
                dq.i iVarA = dq.i.a(esVar.m5459a());
                es esVar3 = new es();
                esVar3.a(0);
                esVar3.a(esVar.m5455a(), "PCA");
                esVar3.a(esVar.e());
                dq.i iVar = new dq.i();
                if (iVarA.m5409a()) {
                    iVar.a(iVarA.m5408a());
                }
                esVar3.a(iVar.m5437a(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new aw(xMPushService2, esVar3));
                com.xiaomi.channel.commonutils.logger.b.m5113a("ACK msgP: id = " + esVar.e());
                return;
            }
            return;
        }
        String string = Integer.toString(esVar.a());
        if ("SECMSG".equals(esVar.m5455a())) {
            if (!esVar.m5458a()) {
                this.a.m5731b().a(this.a, string, esVar);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("Recv SECMSG errCode = " + esVar.b() + " errStr = " + esVar.m5465c());
            return;
        }
        if (!"BIND".equals(strM5455a)) {
            if ("KICK".equals(strM5455a)) {
                dq.g gVarA = dq.g.a(esVar.m5459a());
                String strG = esVar.g();
                String strM5400a = gVarA.m5400a();
                String strM5402b = gVarA.m5402b();
                com.xiaomi.channel.commonutils.logger.b.m5113a("kicked by server, chid=" + string + " res= " + am.b.a(strG) + " type=" + strM5400a + " reason=" + strM5402b);
                if (!"wait".equals(strM5400a)) {
                    this.a.a(string, strG, 3, strM5402b, strM5400a);
                    am.a().m5763a(string, strG);
                    return;
                }
                am.b bVarA = am.a().a(string, strG);
                if (bVarA != null) {
                    this.a.a(bVarA);
                    bVarA.a(am.c.unbind, 3, 0, strM5402b, strM5400a);
                    return;
                }
                return;
            }
            return;
        }
        dq.d dVarA = dq.d.a(esVar.m5459a());
        String strG2 = esVar.g();
        am.b bVarA2 = am.a().a(string, strG2);
        if (bVarA2 == null) {
            return;
        }
        if (dVarA.m5376a()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("SMACK: channel bind succeeded, chid=" + esVar.a());
            bVarA2.a(am.c.binded, 1, 0, (String) null, (String) null);
            return;
        }
        String strM5375a = dVarA.m5375a();
        if ("auth".equals(strM5375a)) {
            if ("invalid-sig".equals(dVarA.m5377b())) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("SMACK: bind error invalid-sig token = " + bVarA2.c + " sec = " + bVarA2.h);
                eq.a(0, ej.BIND_INVALID_SIG.a(), 1, null, 0);
            }
            bVarA2.a(am.c.unbind, 1, 5, dVarA.m5377b(), strM5375a);
            am.a().m5763a(string, strG2);
        } else if ("cancel".equals(strM5375a)) {
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m5377b(), strM5375a);
            am.a().m5763a(string, strG2);
        } else if ("wait".equals(strM5375a)) {
            this.a.a(bVarA2);
            bVarA2.a(am.c.unbind, 1, 7, dVarA.m5377b(), strM5375a);
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("SMACK: channel bind failed, chid=" + string + " reason=" + dVarA.m5377b());
    }

    public void a(es esVar) {
        if (5 != esVar.a()) {
            c(esVar);
        }
        try {
            b(esVar);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + esVar.a() + " cmd = " + esVar.m5455a() + " packetid = " + esVar.e() + " failure ", e2);
        }
    }

    private void a(fm fmVar) {
        String strC = fmVar.c();
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String[] strArrSplit = strC.split(";");
        cd cdVarA = ch.a().a(fc.a(), false);
        if (cdVarA == null || strArrSplit.length <= 0) {
            return;
        }
        cdVarA.a(strArrSplit);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(fp fpVar) {
        am.b bVarA;
        String strL = fpVar.l();
        String strK = fpVar.k();
        if (TextUtils.isEmpty(strL) || TextUtils.isEmpty(strK) || (bVarA = am.a().a(strK, strL)) == null) {
            return;
        }
        ga.a(this.a, bVarA.f6404a, ga.a(fpVar.mo5496a()), true, true, System.currentTimeMillis());
    }
}
