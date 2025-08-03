package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.du;
import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.fm;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.ga;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class u {
    private static void b(Context context, hc hcVar, byte[] bArr) {
        if (x.m5823a(hcVar)) {
            return;
        }
        String strA = x.a(hcVar);
        if (TextUtils.isEmpty(strA) || a(context, strA, bArr)) {
            return;
        }
        du.a(context).b(strA, x.b(hcVar), hcVar.m5593a().m5559a(), "1");
    }

    private static boolean c(hc hcVar) {
        if (hcVar.m5593a() == null || hcVar.m5593a().m5560a() == null) {
            return false;
        }
        return "1".equals(hcVar.m5593a().m5560a().get("obslete_ads_message"));
    }

    private static void d(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    hc hcVarA = u.a((Context) xMPushService, hcVar);
                    hcVarA.m5593a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, hcVarA);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(Context context, am.b bVar, boolean z, int i, String str) {
        p pVarM5807a;
        if (z || (pVarM5807a = q.m5807a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        q.a(context, pVarM5807a.f, pVarM5807a.d, pVarM5807a.f17903e);
    }

    private static void c(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    hc hcVarA = u.a((Context) xMPushService, hcVar);
                    hcVarA.m5593a().a("message_obsleted", "1");
                    w.a(xMPushService, hcVarA);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, fp fpVar, am.b bVar) {
        if (fpVar instanceof fo) {
            fo foVar = (fo) fpVar;
            fm fmVarA = foVar.a(com.umeng.analytics.pro.am.aB);
            if (fmVarA != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.h, foVar.j()), fmVarA.c()), ga.a(fpVar.mo5496a()));
                    return;
                } catch (IllegalArgumentException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    return;
                }
            }
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("not a mipush message");
    }

    private static boolean b(hc hcVar) {
        Map<String, String> mapM5560a = hcVar.m5593a().m5560a();
        return mapM5560a != null && mapM5560a.containsKey("notify_effect");
    }

    private static void b(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                Map<String, String> mapA = null;
                try {
                    if (com.xiaomi.push.j.m5690a((Context) xMPushService)) {
                        try {
                            mapA = v.a((Context) xMPushService, hcVar);
                        } catch (Throwable th) {
                            com.xiaomi.channel.commonutils.logger.b.d("error creating params for ack message :" + th);
                        }
                    }
                    w.a(xMPushService, u.a(xMPushService, hcVar, mapA));
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("error sending ack message :" + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, es esVar, am.b bVar) {
        try {
            byte[] bArrM5460a = esVar.m5460a(bVar.h);
            HashMap map = null;
            if (e.b(esVar)) {
                map = new HashMap();
                map.put("t_im", String.valueOf(esVar.m5461b()));
                map.put("t_rt", String.valueOf(esVar.m5454a()));
            }
            a(xMPushService, bArrM5460a, esVar.c(), map);
        } catch (IllegalArgumentException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) throws NumberFormatException {
        a(xMPushService, bArr, j, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.xiaomi.push.service.XMPushService r19, byte[] r20, long r21, java.util.Map<java.lang.String, java.lang.String> r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, byte[], long, java.util.Map):void");
    }

    public static Intent a(byte[] bArr, long j) {
        hc hcVarA = a(bArr);
        if (hcVarA == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(hcVarA.f6130b);
        return intent;
    }

    public static hc a(byte[] bArr) {
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            return hcVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0448  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    public static void a(Context context, hc hcVar, byte[] bArr) {
        try {
            x.c cVarM5819a = x.m5819a(context, hcVar, bArr);
            if (cVarM5819a.a > 0 && !TextUtils.isEmpty(cVarM5819a.f6501a)) {
                ga.a(context, cVarM5819a.f6501a, cVarM5819a.a, true, false, System.currentTimeMillis());
            }
            if (com.xiaomi.push.j.m5690a(context) && v.a(context, hcVar, cVarM5819a.f6502a)) {
                v.m5814a(context, hcVar);
                com.xiaomi.channel.commonutils.logger.b.m5113a("consume this broadcast by tts");
            } else {
                b(context, hcVar, bArr);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("notify push msg error " + e2);
            e2.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!com.xiaomi.push.g.m5513a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("meet error when broadcast message arrived. " + e2);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, hc hcVar, gt gtVar) {
        boolean z = true;
        if (gtVar != null && gtVar.m5560a() != null && gtVar.m5560a().containsKey("__check_alive") && gtVar.m5560a().containsKey("__awake")) {
            hf hfVar = new hf();
            hfVar.b(hcVar.m5594a());
            hfVar.d(str);
            hfVar.c(gq.AwakeSystemApp.f6003a);
            hfVar.a(gtVar.m5559a());
            hfVar.f6142a = new HashMap();
            boolean zM5513a = com.xiaomi.push.g.m5513a(xMPushService.getApplicationContext(), str);
            hfVar.f6142a.put("app_running", Boolean.toString(zM5513a));
            if (!zM5513a) {
                boolean z2 = Boolean.parseBoolean(gtVar.m5560a().get("__awake"));
                hfVar.f6142a.put("awaked", Boolean.toString(z2));
                if (!z2) {
                    z = false;
                }
            }
            try {
                w.a(xMPushService, w.a(hcVar.b(), hcVar.m5594a(), hfVar, gg.Notification));
            } catch (fj e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        return z;
    }

    private static void a(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    w.a(xMPushService, w.a(hcVar.b(), hcVar.m5594a()));
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static boolean a(hc hcVar) {
        return "com.xiaomi.xmsf".equals(hcVar.f6130b) && hcVar.m5593a() != null && hcVar.m5593a().m5560a() != null && hcVar.m5593a().m5560a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (listQueryBroadcastReceivers.isEmpty()) {
                if (listQueryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return false;
        }
    }

    private static void a(final XMPushService xMPushService, final hc hcVar, final String str) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    hc hcVarA = u.a((Context) xMPushService, hcVar);
                    hcVarA.m5593a().a("absent_target_package", str);
                    w.a(xMPushService, hcVarA);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hc hcVar, final String str, final String str2) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    hc hcVarA = u.a((Context) xMPushService, hcVar);
                    hcVarA.f6124a.a(com.umeng.analytics.pro.d.O, str);
                    hcVarA.f6124a.a("reason", str2);
                    w.a(xMPushService, hcVarA);
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hc hcVar, final hf hfVar) {
        xMPushService.a(new XMPushService.j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo5444a() {
                try {
                    gx gxVar = new gx();
                    gxVar.c(gq.CancelPushMessageACK.f6003a);
                    gxVar.a(hfVar.m5608a());
                    gxVar.a(hfVar.a());
                    gxVar.b(hfVar.b());
                    gxVar.e(hfVar.d());
                    gxVar.a(0L);
                    gxVar.d("success clear push message.");
                    w.a(xMPushService, w.b(hcVar.b(), hcVar.m5594a(), gxVar, gg.Notification));
                } catch (fj e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("clear push message. " + e2);
                    xMPushService.a(10, e2);
                }
            }
        });
    }

    public static hc a(Context context, hc hcVar) {
        return a(context, hcVar, (Map<String, String>) null);
    }

    public static hc a(Context context, hc hcVar, Map<String, String> map) {
        gw gwVar = new gw();
        gwVar.b(hcVar.m5594a());
        gt gtVarM5593a = hcVar.m5593a();
        if (gtVarM5593a != null) {
            gwVar.a(gtVarM5593a.m5559a());
            gwVar.a(gtVarM5593a.m5557a());
            if (!TextUtils.isEmpty(gtVarM5593a.m5564b())) {
                gwVar.c(gtVarM5593a.m5564b());
            }
        }
        gwVar.a(hq.a(context, hcVar));
        hc hcVarA = w.a(hcVar.b(), hcVar.m5594a(), gwVar, gg.AckMessage);
        gt gtVarM5593a2 = hcVar.m5593a();
        if (gtVarM5593a2 != null) {
            gtVarM5593a2 = au.a(gtVarM5593a2.m5558a());
            Map<String, String> mapM5560a = gtVarM5593a2.m5560a();
            String str = mapM5560a != null ? mapM5560a.get("channel_id") : null;
            gtVarM5593a2.a("mat", Long.toString(System.currentTimeMillis()));
            gtVarM5593a2.a("cs", String.valueOf(f.a(context, hcVar.f6130b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        gtVarM5593a2.a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("error adding params to ack message :" + th);
            }
        }
        hcVarA.a(gtVarM5593a2);
        return hcVarA;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (listQueryBroadcastReceivers != null) {
                if (!listQueryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
