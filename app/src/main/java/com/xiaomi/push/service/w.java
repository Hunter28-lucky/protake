package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.ct;
import com.xiaomi.push.es;
import com.xiaomi.push.fb;
import com.xiaomi.push.fj;
import com.xiaomi.push.fp;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hv;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class w {
    public static void a(XMPushService xMPushService) {
        p pVarM5807a = q.m5807a(xMPushService.getApplicationContext());
        if (pVarM5807a != null) {
            am.b bVarA = q.m5807a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m5113a("prepare account. " + bVarA.f6404a);
            a(xMPushService, bVarA);
            am.a().a(bVarA);
            a(xMPushService, pVarM5807a, 172800);
        }
    }

    public static <T extends hr<T, ?>> hc b(String str, String str2, T t, gg ggVar) {
        return a(str, str2, t, ggVar, false);
    }

    public static hc b(String str, String str2) {
        hf hfVar = new hf();
        hfVar.b(str2);
        hfVar.c(gq.AppDataCleared.f6003a);
        hfVar.a(aj.a());
        hfVar.a(false);
        return a(str, str2, hfVar, gg.Notification);
    }

    private static void a(final XMPushService xMPushService, final p pVar, int i) {
        ay.a(xMPushService).a(new ay.a("MSAID", i) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.ay.a
            public void a(ay ayVar) {
                com.xiaomi.push.ao aoVarA = com.xiaomi.push.ao.a(xMPushService);
                String strA = ayVar.a("MSAID", "msaid");
                String strMo5201a = aoVarA.mo5201a();
                if (TextUtils.isEmpty(strMo5201a) || TextUtils.equals(strA, strMo5201a)) {
                    return;
                }
                ayVar.a("MSAID", "msaid", strMo5201a);
                hf hfVar = new hf();
                hfVar.b(pVar.d);
                hfVar.c(gq.ClientInfoUpdate.f6003a);
                hfVar.a(aj.a());
                hfVar.a(new HashMap());
                aoVarA.a(hfVar.m5609a());
                byte[] bArrA = hq.a(w.a(xMPushService.getPackageName(), pVar.d, hfVar, gg.Notification));
                XMPushService xMPushService2 = xMPushService;
                xMPushService2.a(xMPushService2.getPackageName(), bArrA, true);
            }
        });
    }

    private static String a(hc hcVar) {
        Map<String, String> map;
        gt gtVar = hcVar.f6124a;
        if (gtVar != null && (map = gtVar.f6042b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hcVar.f6130b;
    }

    public static es a(p pVar, Context context, hc hcVar) throws NumberFormatException {
        try {
            es esVar = new es();
            esVar.a(5);
            esVar.c(pVar.f6473a);
            esVar.b(a(hcVar));
            esVar.a("SECMSG", "message");
            String str = pVar.f6473a;
            hcVar.f6125a.f6052a = str.substring(0, str.indexOf("@"));
            hcVar.f6125a.f6056c = str.substring(str.indexOf("/") + 1);
            esVar.a(hq.a(hcVar), pVar.c);
            esVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m5113a("try send mi push message. packagename:" + hcVar.f6130b + " action:" + hcVar.f6123a);
            return esVar;
        } catch (NullPointerException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static es a(XMPushService xMPushService, byte[] bArr) {
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            return a(q.m5807a((Context) xMPushService), xMPushService, hcVar);
        } catch (hv e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static <T extends hr<T, ?>> hc a(String str, String str2, T t, gg ggVar) {
        return a(str, str2, t, ggVar, true);
    }

    private static <T extends hr<T, ?>> hc a(String str, String str2, T t, gg ggVar, boolean z) {
        byte[] bArrA = hq.a(t);
        hc hcVar = new hc();
        gv gvVar = new gv();
        gvVar.f6051a = 5L;
        gvVar.f6052a = "fakeid";
        hcVar.a(gvVar);
        hcVar.a(ByteBuffer.wrap(bArrA));
        hcVar.a(ggVar);
        hcVar.b(z);
        hcVar.b(str);
        hcVar.a(false);
        hcVar.a(str2);
        return hcVar;
    }

    public static hc a(String str, String str2) {
        hf hfVar = new hf();
        hfVar.b(str2);
        hfVar.c("package uninstalled");
        hfVar.a(fp.i());
        hfVar.a(false);
        return a(str, str2, hfVar, gg.Notification);
    }

    public static void a(final XMPushService xMPushService, am.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.am.b.a
            public void a(am.c cVar, am.c cVar2, int i) throws InterruptedException {
                if (cVar2 == am.c.binded) {
                    t.a(xMPushService, true);
                    t.a(xMPushService);
                } else if (cVar2 == am.c.unbind) {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("onChange unbind");
                    t.a(xMPushService, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        ct.a(str, xMPushService.getApplicationContext(), bArr);
        fb fbVarM5726a = xMPushService.m5726a();
        if (fbVarM5726a != null) {
            if (fbVarM5726a.mo5472a()) {
                es esVarA = a(xMPushService, bArr);
                if (esVarA != null) {
                    fbVarM5726a.b(esVarA);
                    return;
                } else {
                    t.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                    return;
                }
            }
            throw new fj("Don't support XMPP connection.");
        }
        throw new fj("try send msg while connection is null.");
    }

    public static void a(XMPushService xMPushService, hc hcVar) {
        ct.a(hcVar.b(), xMPushService.getApplicationContext(), hcVar, -1);
        fb fbVarM5726a = xMPushService.m5726a();
        if (fbVarM5726a != null) {
            if (fbVarM5726a.mo5472a()) {
                es esVarA = a(q.m5807a((Context) xMPushService), xMPushService, hcVar);
                if (esVarA != null) {
                    fbVarM5726a.b(esVarA);
                    return;
                }
                return;
            }
            throw new fj("Don't support XMPP connection.");
        }
        throw new fj("try send msg while connection is null.");
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
