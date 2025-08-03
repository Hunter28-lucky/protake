package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bc;
import com.xiaomi.push.bo;
import com.xiaomi.push.ct;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.gu;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hb;
import com.xiaomi.push.hc;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hj;
import com.xiaomi.push.hl;
import com.xiaomi.push.hn;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hv;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.au;
import com.xiaomi.push.service.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class t {
    private static t a;

    /* renamed from: a, reason: collision with other field name */
    private static Object f5538a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static Queue<String> f5539a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5540a;

    /* renamed from: com.xiaomi.mipush.sdk.t$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[gg.values().length];
            a = iArr;
            try {
                iArr[gg.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[gg.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[gg.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[gg.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[gg.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[gg.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[gg.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5540a = applicationContext;
        if (applicationContext == null) {
            this.f5540a = context;
        }
    }

    public static t a(Context context) {
        if (a == null) {
            a = new t(context);
        }
        return a;
    }

    private void b(gx gxVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + gxVar.toString());
        String strA = gxVar.a();
        Map<String, String> mapM5574a = gxVar.m5574a();
        if (mapM5574a != null) {
            String str = mapM5574a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + q.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : receive fcm token sync ack");
                Context context = this.f5540a;
                d dVar = d.ASSEMBLE_PUSH_FCM;
                f.b(context, dVar, str);
                a(strA, gxVar.f6081a, dVar);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("brand:");
            q qVar = q.HUAWEI;
            sb.append(qVar.name());
            if (!str.contains(sb.toString())) {
                if (!str.contains("channel:" + qVar.name())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("brand:");
                    q qVar2 = q.OPPO;
                    sb2.append(qVar2.name());
                    if (!str.contains(sb2.toString())) {
                        if (!str.contains("channel:" + qVar2.name())) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("brand:");
                            q qVar3 = q.VIVO;
                            sb3.append(qVar3.name());
                            if (!str.contains(sb3.toString())) {
                                if (!str.contains("channel:" + qVar3.name())) {
                                    return;
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            Context context2 = this.f5540a;
                            d dVar2 = d.ASSEMBLE_PUSH_FTOS;
                            f.b(context2, dVar2, str);
                            a(strA, gxVar.f6081a, dVar2);
                            return;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : receive COS token sync ack");
                    Context context3 = this.f5540a;
                    d dVar3 = d.ASSEMBLE_PUSH_COS;
                    f.b(context3, dVar3, str);
                    a(strA, gxVar.f6081a, dVar3);
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m5113a("ASSEMBLE_PUSH : receive hw token sync ack");
            Context context4 = this.f5540a;
            d dVar4 = d.ASSEMBLE_PUSH_HUAWEI;
            f.b(context4, dVar4, str);
            a(strA, gxVar.f6081a, dVar4);
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m5113a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, "12");
                return null;
            }
            hc hcVar = new hc();
            try {
                hq.a(hcVar, byteArrayExtra);
                b bVarM5140a = b.m5140a(this.f5540a);
                gt gtVarM5593a = hcVar.m5593a();
                gg ggVarA = hcVar.a();
                gg ggVar = gg.SendMessage;
                if (ggVarA == ggVar && gtVarM5593a != null && !bVarM5140a.m5151e() && !booleanExtra) {
                    gtVarM5593a.a("mrt", stringExtra);
                    gtVarM5593a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m5172a(hcVar)) {
                        b(hcVar);
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        gtVarM5593a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(gtVarM5593a.m5557a()));
                        gtVarM5593a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) hq.a(this.f5540a, hcVar)));
                    }
                }
                if (hcVar.a() == ggVar && !hcVar.m5601b()) {
                    if (x.m5823a(hcVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = hcVar.b();
                        objArr[1] = gtVarM5593a != null ? gtVarM5593a.m5559a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, String.format("13: %1$s", hcVar.b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = hcVar.b();
                        objArr2[1] = gtVarM5593a != null ? gtVarM5593a.m5559a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, String.format("14: %1$s", hcVar.b()));
                    }
                    j.a(this.f5540a, hcVar, intent, booleanExtra);
                    return null;
                }
                if (hcVar.a() == ggVar && hcVar.m5601b() && x.m5823a(hcVar) && (!booleanExtra || gtVarM5593a == null || gtVarM5593a.m5560a() == null || !gtVarM5593a.m5560a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = hcVar.b();
                    objArr3[1] = gtVarM5593a != null ? gtVarM5593a.m5559a() : "";
                    com.xiaomi.channel.commonutils.logger.b.m5113a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, String.format("25: %1$s", hcVar.b()));
                    j.b(this.f5540a, hcVar, intent, booleanExtra);
                    return null;
                }
                if (!bVarM5140a.m5149c() && hcVar.f6123a != gg.Registration) {
                    if (x.m5823a(hcVar)) {
                        return a(hcVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    j.f(this.f5540a, hcVar, intent, booleanExtra);
                    boolean zM5150d = bVarM5140a.m5150d();
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + zM5150d);
                    du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, "15");
                    if (zM5150d) {
                        a();
                    }
                } else if (bVarM5140a.m5149c() && bVarM5140a.m5152f()) {
                    if (hcVar.f6123a == gg.UnRegistration) {
                        if (hcVar.m5601b()) {
                            bVarM5140a.m5142a();
                            MiPushClient.clearExtras(this.f5540a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else {
                        j.f(this.f5540a, hcVar, intent, booleanExtra);
                        MiPushClient.unregisterPush(this.f5540a);
                    }
                } else {
                    return a(hcVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                }
            } catch (hv e2) {
                du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, "16");
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            } catch (Exception e3) {
                du.a(this.f5540a).a(this.f5540a.getPackageName(), intent, "17");
                com.xiaomi.channel.commonutils.logger.b.a(e3);
            }
        } else {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                hc hcVar2 = new hc();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        hq.a(hcVar2, byteArrayExtra2);
                    }
                } catch (hv unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(hcVar2.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            }
            if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                hc hcVar3 = new hc();
                try {
                    hq.a(hcVar3, byteArrayExtra3);
                    b bVarM5140a2 = b.m5140a(this.f5540a);
                    if (x.m5823a(hcVar3)) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                    } else if (!bVarM5140a2.m5149c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                    } else if (bVarM5140a2.m5149c() && bVarM5140a2.m5152f()) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                    } else {
                        return a(hcVar3, byteArrayExtra3);
                    }
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e4);
                }
            }
        }
        return null;
    }

    private void b(hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        if (gtVarM5593a != null) {
            gtVarM5593a = au.a(gtVarM5593a.m5558a());
        }
        gw gwVar = new gw();
        gwVar.b(hcVar.m5594a());
        gwVar.a(gtVarM5593a.m5559a());
        gwVar.a(gtVarM5593a.m5557a());
        if (!TextUtils.isEmpty(gtVarM5593a.m5564b())) {
            gwVar.c(gtVarM5593a.m5564b());
        }
        gwVar.a(hq.a(this.f5540a, hcVar));
        u.a(this.f5540a).a((u) gwVar, gg.AckMessage, false, gtVarM5593a);
    }

    private void b(hf hfVar) {
        Map<String, String> mapM5609a = hfVar.m5609a();
        if (mapM5609a == null) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("detect failed because null");
            return;
        }
        String str = (String) ag.a(mapM5609a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("detect failed because empty");
            return;
        }
        Map<String, String> mapM5512a = com.xiaomi.push.g.m5512a(this.f5540a, str);
        if (mapM5512a != null) {
            String str2 = mapM5512a.get("alive");
            String str3 = mapM5512a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                hf hfVar2 = new hf();
                hfVar2.a(hfVar.m5608a());
                hfVar2.b(hfVar.b());
                hfVar2.d(hfVar.d());
                hfVar2.c(gq.DetectAppAliveResult.f6003a);
                HashMap map = new HashMap();
                hfVar2.f6142a = map;
                map.put("alive", str2);
                if (Boolean.parseBoolean((String) ag.a(mapM5609a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
                    hfVar2.f6142a.put("notAlive", str3);
                }
                u.a(this.f5540a).a((u) hfVar2, gg.Notification, false, (gt) null);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("detect failed because get status illegal");
    }

    private PushMessageHandler.a a(hc hcVar, byte[] bArr) {
        String str = null;
        try {
            hr hrVarA = r.a(this.f5540a, hcVar);
            if (hrVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + hcVar.f6123a);
                return null;
            }
            gg ggVarA = hcVar.a();
            com.xiaomi.channel.commonutils.logger.b.m5113a("message arrived: processing an arrived message, action=" + ggVarA);
            if (AnonymousClass1.a[ggVarA.ordinal()] != 1) {
                return null;
            }
            if (!hcVar.m5601b()) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            hj hjVar = (hj) hrVarA;
            gs gsVarA = hjVar.a();
            if (gsVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            gt gtVar = hcVar.f6124a;
            if (gtVar != null && gtVar.m5560a() != null) {
                str = hcVar.f6124a.f6038a.get("jobkey");
            }
            MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hjVar, hcVar.m5593a(), false);
            miPushMessageGenerateMessage.setArrivedMessage(true);
            com.xiaomi.channel.commonutils.logger.b.m5113a("message arrived: receive a message, msgid=" + gsVarA.m5551a() + ", jobkey=" + str);
            return miPushMessageGenerateMessage;
        } catch (l e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (hv e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    private PushMessageHandler.a a(hc hcVar, boolean z, byte[] bArr, String str, int i, Intent intent) throws NumberFormatException {
        String strM5551a;
        String str2;
        MiPushMessage miPushMessage;
        boolean z2;
        boolean z3;
        gt gtVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        try {
            hr hrVarA = r.a(this.f5540a, hcVar);
            if (hrVarA == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + hcVar.f6123a);
                du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "18");
                j.c(this.f5540a, hcVar, intent, z);
                return null;
            }
            gg ggVarA = hcVar.a();
            com.xiaomi.channel.commonutils.logger.b.m5115a("processing a message, action=", ggVarA, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.a[ggVarA.ordinal()]) {
                case 1:
                    if (!hcVar.m5601b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (b.m5140a(this.f5540a).m5151e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("receive a message in pause state. drop it");
                        du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, "12");
                        return null;
                    }
                    hj hjVar = (hj) hrVarA;
                    gs gsVarA = hjVar.a();
                    if (gsVarA == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "22");
                        j.d(this.f5540a, hcVar, intent, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (x.m5823a(hcVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f5540a, gsVarA.m5551a(), hcVar.m5593a(), hcVar.f6130b, gsVarA.b());
                        } else {
                            if (hcVar.m5593a() != null) {
                                gtVar = new gt(hcVar.m5593a());
                            } else {
                                gtVar = new gt();
                            }
                            if (gtVar.m5560a() == null) {
                                gtVar.a(new HashMap());
                            }
                            gtVar.m5560a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f5540a, gsVarA.m5551a(), gtVar, gsVarA.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(hjVar.d()) && MiPushClient.aliasSetTime(this.f5540a, hjVar.d()) < 0) {
                            MiPushClient.addAlias(this.f5540a, hjVar.d());
                        } else if (!TextUtils.isEmpty(hjVar.c()) && MiPushClient.topicSubscribedTime(this.f5540a, hjVar.c()) < 0) {
                            MiPushClient.addTopic(this.f5540a, hjVar.c());
                        }
                    }
                    gt gtVar2 = hcVar.f6124a;
                    if (gtVar2 == null || gtVar2.m5560a() == null) {
                        strM5551a = null;
                        str2 = null;
                    } else {
                        strM5551a = hcVar.f6124a.f6038a.get("jobkey");
                        str2 = strM5551a;
                    }
                    if (TextUtils.isEmpty(strM5551a)) {
                        strM5551a = gsVarA.m5551a();
                    }
                    if (!z && m5171a(this.f5540a, strM5551a)) {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("drop a duplicate message, key=" + strM5551a);
                        du.a(this.f5540a).c(this.f5540a.getPackageName(), dt.m5422a(i), str, "2:" + strM5551a);
                        miPushMessage = null;
                    } else {
                        MiPushMessage miPushMessageGenerateMessage = PushMessageHelper.generateMessage(hjVar, hcVar.m5593a(), z);
                        if (miPushMessageGenerateMessage.getPassThrough() == 0 && !z && x.m5824a(miPushMessageGenerateMessage.getExtra())) {
                            x.m5819a(this.f5540a, hcVar, bArr);
                            return null;
                        }
                        String strA = x.a(miPushMessageGenerateMessage.getExtra(), intExtra);
                        com.xiaomi.channel.commonutils.logger.b.m5115a("receive a message, msgid=", gsVarA.m5551a(), ", jobkey=", strM5551a, ", btn=", Integer.valueOf(intExtra), ", typeId=", strA, ", hasNotified=", Boolean.valueOf(z));
                        if (z && miPushMessageGenerateMessage.getExtra() != null && !TextUtils.isEmpty(strA)) {
                            Map<String, String> extra = miPushMessageGenerateMessage.getExtra();
                            if (intExtra != 0 && hcVar.m5593a() != null) {
                                u.a(this.f5540a).a(hcVar.m5593a().c(), intExtra);
                            }
                            if (x.m5823a(hcVar)) {
                                Intent intentA = a(this.f5540a, hcVar.f6130b, extra, intExtra);
                                if (intentA == null) {
                                    j.e(this.f5540a, hcVar, intent, true);
                                    com.xiaomi.channel.commonutils.logger.b.m5113a("Getting Intent fail from ignore reg message. ");
                                    du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "23");
                                    return null;
                                }
                                intentA.putExtra("eventMessageType", i);
                                intentA.putExtra("messageId", str);
                                intentA.putExtra("jobkey", str2);
                                Bundle extras = intentA.getExtras();
                                if (a(extras, "pushTargetComponent")) {
                                    z3 = true;
                                } else {
                                    z3 = true;
                                    intentA.putExtra("pushTargetComponent", true);
                                }
                                if (!a(extras, "mipush_notified")) {
                                    intentA.putExtra("mipush_notified", z3);
                                }
                                String strC = gsVarA.c();
                                if (!TextUtils.isEmpty(strC)) {
                                    intentA.putExtra("payload", strC);
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                this.f5540a.startActivity(intentA);
                                j.a(this.f5540a, hcVar, intent, jCurrentTimeMillis);
                                du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, 3006, strA);
                                com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f5540a;
                                Intent intentA2 = a(context, context.getPackageName(), extra, intExtra);
                                if (intentA2 != null) {
                                    if (!strA.equals(an.c)) {
                                        intentA2.putExtra(PushMessageHelper.KEY_MESSAGE, miPushMessageGenerateMessage);
                                        intentA2.putExtra("eventMessageType", i);
                                        intentA2.putExtra("messageId", str);
                                        intentA2.putExtra("jobkey", str2);
                                        Bundle extras2 = intentA2.getExtras();
                                        if (a(extras2, "pushTargetComponent")) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                            intentA2.putExtra("pushTargetComponent", true);
                                        }
                                        if (!a(extras2, "mipush_notified")) {
                                            intentA2.putExtra("mipush_notified", z2);
                                        }
                                    }
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    this.f5540a.startActivity(intentA2);
                                    j.a(this.f5540a, hcVar, intent, jCurrentTimeMillis2);
                                    com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageProcessor", "start activity succ");
                                    du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, 1006, strA);
                                    if (strA.equals(an.c)) {
                                        du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, "13");
                                    }
                                } else {
                                    j.e(this.f5540a, hcVar, intent, true);
                                    com.xiaomi.channel.commonutils.logger.b.d("PushMessageProcessor", "missing target intent for message: " + gsVarA.m5551a() + ", typeId=" + strA);
                                }
                            }
                            com.xiaomi.channel.commonutils.logger.b.m5114a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = miPushMessageGenerateMessage;
                    }
                    if (hcVar.m5593a() == null && !z) {
                        a(hjVar, hcVar);
                    }
                    return miPushMessage;
                case 2:
                    hh hhVar = (hh) hrVarA;
                    String str3 = b.m5140a(this.f5540a).f5516a;
                    if (!TextUtils.isEmpty(str3) && TextUtils.equals(str3, hhVar.m5623a())) {
                        long jM5181a = u.a(this.f5540a).m5181a();
                        if (jM5181a > 0 && SystemClock.elapsedRealtime() - jM5181a > 900000) {
                            com.xiaomi.channel.commonutils.logger.b.m5113a("The received registration result has expired.");
                            du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "26");
                            return null;
                        }
                        b.m5140a(this.f5540a).f5516a = null;
                        if (hhVar.f6186a == 0) {
                            b.m5140a(this.f5540a).b(hhVar.f6198e, hhVar.f6199f, hhVar.f6205l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f5540a);
                            du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, 6006, "1");
                        } else {
                            du.a(this.f5540a).a(this.f5540a.getPackageName(), dt.m5422a(i), str, 6006, "2");
                        }
                        if (TextUtils.isEmpty(hhVar.f6198e)) {
                            arrayList = null;
                        } else {
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(hhVar.f6198e);
                            arrayList = arrayList4;
                        }
                        MiPushCommandMessage miPushCommandMessageGenerateCommandMessage = PushMessageHelper.generateCommandMessage(ee.COMMAND_REGISTER.f5830a, arrayList, hhVar.f6186a, hhVar.f6197d, null, hhVar.m5624a());
                        u.a(this.f5540a).m5190d();
                        return miPushCommandMessageGenerateCommandMessage;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m5113a("bad Registration result:");
                    du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "21");
                    return null;
                case 3:
                    if (!hcVar.m5601b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((hn) hrVarA).f6264a == 0) {
                        b.m5140a(this.f5540a).m5142a();
                        MiPushClient.clearExtras(this.f5540a);
                    }
                    PushMessageHandler.a();
                    return null;
                case 4:
                    hl hlVar = (hl) hrVarA;
                    if (hlVar.f6239a == 0) {
                        MiPushClient.addTopic(this.f5540a, hlVar.b());
                    }
                    if (TextUtils.isEmpty(hlVar.b())) {
                        arrayList2 = null;
                    } else {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(hlVar.b());
                        arrayList2 = arrayList5;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("resp-cmd:");
                    ee eeVar = ee.COMMAND_SUBSCRIBE_TOPIC;
                    sb.append(eeVar);
                    sb.append(", ");
                    sb.append(hlVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb.toString());
                    return PushMessageHelper.generateCommandMessage(eeVar.f5830a, arrayList2, hlVar.f6239a, hlVar.f6245d, hlVar.c(), null);
                case 5:
                    hp hpVar = (hp) hrVarA;
                    if (hpVar.f6284a == 0) {
                        MiPushClient.removeTopic(this.f5540a, hpVar.b());
                    }
                    if (TextUtils.isEmpty(hpVar.b())) {
                        arrayList3 = null;
                    } else {
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.add(hpVar.b());
                        arrayList3 = arrayList6;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("resp-cmd:");
                    ee eeVar2 = ee.COMMAND_UNSUBSCRIBE_TOPIC;
                    sb2.append(eeVar2);
                    sb2.append(", ");
                    sb2.append(hpVar.a());
                    com.xiaomi.channel.commonutils.logger.b.e(sb2.toString());
                    return PushMessageHelper.generateCommandMessage(eeVar2.f5830a, arrayList3, hpVar.f6284a, hpVar.f6290d, hpVar.c(), null);
                case 6:
                    ct.a(this.f5540a.getPackageName(), this.f5540a, hrVarA, gg.Command, bArr.length);
                    hb hbVar = (hb) hrVarA;
                    String strB = hbVar.b();
                    List<String> listM5587a = hbVar.m5587a();
                    if (hbVar.f6111a == 0) {
                        if (TextUtils.equals(strB, ee.COMMAND_SET_ACCEPT_TIME.f5830a) && listM5587a != null && listM5587a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f5540a, listM5587a.get(0), listM5587a.get(1));
                            if ("00:00".equals(listM5587a.get(0)) && "00:00".equals(listM5587a.get(1))) {
                                b.m5140a(this.f5540a).a(true);
                            } else {
                                b.m5140a(this.f5540a).a(false);
                            }
                            listM5587a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), listM5587a);
                        } else if (TextUtils.equals(strB, ee.COMMAND_SET_ALIAS.f5830a) && listM5587a != null && listM5587a.size() > 0) {
                            MiPushClient.addAlias(this.f5540a, listM5587a.get(0));
                        } else if (TextUtils.equals(strB, ee.COMMAND_UNSET_ALIAS.f5830a) && listM5587a != null && listM5587a.size() > 0) {
                            MiPushClient.removeAlias(this.f5540a, listM5587a.get(0));
                        } else if (TextUtils.equals(strB, ee.COMMAND_SET_ACCOUNT.f5830a) && listM5587a != null && listM5587a.size() > 0) {
                            MiPushClient.addAccount(this.f5540a, listM5587a.get(0));
                        } else if (TextUtils.equals(strB, ee.COMMAND_UNSET_ACCOUNT.f5830a) && listM5587a != null && listM5587a.size() > 0) {
                            MiPushClient.removeAccount(this.f5540a, listM5587a.get(0));
                        } else if (TextUtils.equals(strB, ee.COMMAND_CHK_VDEVID.f5830a)) {
                            return null;
                        }
                    }
                    List<String> list = listM5587a;
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + strB + ", " + hbVar.a());
                    return PushMessageHelper.generateCommandMessage(strB, list, hbVar.f6111a, hbVar.f6119d, hbVar.c(), null);
                case 7:
                    ct.a(this.f5540a.getPackageName(), this.f5540a, hrVarA, gg.Notification, bArr.length);
                    if (hrVarA instanceof gx) {
                        gx gxVar = (gx) hrVarA;
                        String strA2 = gxVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + gxVar.b() + ", code:" + gxVar.f6081a + ", " + strA2);
                        if (gq.DisablePushMessage.f6003a.equalsIgnoreCase(gxVar.f6088d)) {
                            if (gxVar.f6081a == 0) {
                                synchronized (p.class) {
                                    if (p.a(this.f5540a).m5170a(strA2)) {
                                        p.a(this.f5540a).c(strA2);
                                        p pVarA = p.a(this.f5540a);
                                        v vVar = v.DISABLE_PUSH;
                                        if ("syncing".equals(pVarA.a(vVar))) {
                                            p.a(this.f5540a).a(vVar, "synced");
                                            MiPushClient.clearNotification(this.f5540a);
                                            MiPushClient.clearLocalNotificationType(this.f5540a);
                                            PushMessageHandler.a();
                                            u.a(this.f5540a).m5187b();
                                        }
                                    }
                                }
                                return null;
                            }
                            if ("syncing".equals(p.a(this.f5540a).a(v.DISABLE_PUSH))) {
                                synchronized (p.class) {
                                    if (p.a(this.f5540a).m5170a(strA2)) {
                                        if (p.a(this.f5540a).a(strA2) < 10) {
                                            p.a(this.f5540a).b(strA2);
                                            u.a(this.f5540a).a(true, strA2);
                                        } else {
                                            p.a(this.f5540a).c(strA2);
                                        }
                                    }
                                }
                                return null;
                            }
                            p.a(this.f5540a).c(strA2);
                            return null;
                        }
                        if (!gq.EnablePushMessage.f6003a.equalsIgnoreCase(gxVar.f6088d)) {
                            if (gq.ThirdPartyRegUpdate.f6003a.equalsIgnoreCase(gxVar.f6088d)) {
                                b(gxVar);
                                return null;
                            }
                            if (!gq.UploadTinyData.f6003a.equalsIgnoreCase(gxVar.f6088d)) {
                                return null;
                            }
                            a(gxVar);
                            return null;
                        }
                        if (gxVar.f6081a == 0) {
                            synchronized (p.class) {
                                if (p.a(this.f5540a).m5170a(strA2)) {
                                    p.a(this.f5540a).c(strA2);
                                    p pVarA2 = p.a(this.f5540a);
                                    v vVar2 = v.ENABLE_PUSH;
                                    if ("syncing".equals(pVarA2.a(vVar2))) {
                                        p.a(this.f5540a).a(vVar2, "synced");
                                    }
                                }
                            }
                            return null;
                        }
                        if ("syncing".equals(p.a(this.f5540a).a(v.ENABLE_PUSH))) {
                            synchronized (p.class) {
                                if (p.a(this.f5540a).m5170a(strA2)) {
                                    if (p.a(this.f5540a).a(strA2) < 10) {
                                        p.a(this.f5540a).b(strA2);
                                        u.a(this.f5540a).a(false, strA2);
                                    } else {
                                        p.a(this.f5540a).c(strA2);
                                    }
                                }
                            }
                            return null;
                        }
                        p.a(this.f5540a).c(strA2);
                        return null;
                    }
                    if (!(hrVarA instanceof hf)) {
                        return null;
                    }
                    hf hfVar = (hf) hrVarA;
                    if ("registration id expired".equalsIgnoreCase(hfVar.f6147d)) {
                        List<String> allAlias = MiPushClient.getAllAlias(this.f5540a);
                        List<String> allTopic = MiPushClient.getAllTopic(this.f5540a);
                        List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f5540a);
                        String acceptTime = MiPushClient.getAcceptTime(this.f5540a);
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hfVar.f6147d + ", " + hfVar.m5608a());
                        MiPushClient.reInitialize(this.f5540a, gu.RegIdExpired);
                        for (String str4 : allAlias) {
                            MiPushClient.removeAlias(this.f5540a, str4);
                            MiPushClient.setAlias(this.f5540a, str4, null);
                        }
                        for (String str5 : allTopic) {
                            MiPushClient.removeTopic(this.f5540a, str5);
                            MiPushClient.subscribe(this.f5540a, str5, null);
                        }
                        for (String str6 : allUserAccount) {
                            MiPushClient.removeAccount(this.f5540a, str6);
                            MiPushClient.setUserAccount(this.f5540a, str6, null);
                        }
                        String[] strArrSplit = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        if (strArrSplit.length != 2) {
                            return null;
                        }
                        MiPushClient.removeAcceptTime(this.f5540a);
                        MiPushClient.addAcceptTime(this.f5540a, strArrSplit[0], strArrSplit[1]);
                        return null;
                    }
                    if (gq.ClientInfoUpdateOk.f6003a.equalsIgnoreCase(hfVar.f6147d)) {
                        if (hfVar.m5609a() == null || !hfVar.m5609a().containsKey("app_version")) {
                            return null;
                        }
                        b.m5140a(this.f5540a).m5143a(hfVar.m5609a().get("app_version"));
                        return null;
                    }
                    try {
                        if (gq.NormalClientConfigUpdate.f6003a.equalsIgnoreCase(hfVar.f6147d)) {
                            he heVar = new he();
                            hq.a(heVar, hfVar.m5614a());
                            ai.a(ah.a(this.f5540a), heVar);
                        } else if (gq.CustomClientConfigUpdate.f6003a.equalsIgnoreCase(hfVar.f6147d)) {
                            hd hdVar = new hd();
                            hq.a(hdVar, hfVar.m5614a());
                            ai.a(ah.a(this.f5540a), hdVar);
                        } else {
                            if (gq.SyncInfoResult.f6003a.equalsIgnoreCase(hfVar.f6147d)) {
                                w.a(this.f5540a, hfVar);
                                return null;
                            }
                            if (gq.ForceSync.f6003a.equalsIgnoreCase(hfVar.f6147d)) {
                                com.xiaomi.channel.commonutils.logger.b.m5113a("receive force sync notification");
                                w.a(this.f5540a, false);
                                return null;
                            }
                            if (gq.CancelPushMessage.f6003a.equals(hfVar.f6147d)) {
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hfVar.f6147d + ", " + hfVar.m5608a());
                                if (hfVar.m5609a() != null) {
                                    int i2 = -2;
                                    if (hfVar.m5609a().containsKey(an.R)) {
                                        String str7 = hfVar.m5609a().get(an.R);
                                        if (!TextUtils.isEmpty(str7)) {
                                            try {
                                                i2 = Integer.parseInt(str7);
                                            } catch (NumberFormatException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    if (i2 >= -1) {
                                        MiPushClient.clearNotification(this.f5540a, i2);
                                    } else {
                                        MiPushClient.clearNotification(this.f5540a, hfVar.m5609a().containsKey(an.P) ? hfVar.m5609a().get(an.P) : "", hfVar.m5609a().containsKey(an.Q) ? hfVar.m5609a().get(an.Q) : "");
                                    }
                                }
                                a(hfVar);
                                return null;
                            }
                            if (gq.HybridRegisterResult.f6003a.equals(hfVar.f6147d)) {
                                try {
                                    hh hhVar2 = new hh();
                                    hq.a(hhVar2, hfVar.m5614a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f5540a, hhVar2);
                                    return null;
                                } catch (hv e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    return null;
                                }
                            }
                            if (gq.HybridUnregisterResult.f6003a.equals(hfVar.f6147d)) {
                                try {
                                    hn hnVar = new hn();
                                    hq.a(hnVar, hfVar.m5614a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f5540a, hnVar);
                                    return null;
                                } catch (hv e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    return null;
                                }
                            }
                            if (gq.PushLogUpload.f6003a.equals(hfVar.f6147d)) {
                                return null;
                            }
                            if (gq.DetectAppAlive.f6003a.equals(hfVar.f6147d)) {
                                com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                b(hfVar);
                                return null;
                            }
                            if (!com.xiaomi.push.service.g.a(hfVar)) {
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                            return null;
                        }
                        return null;
                    } catch (hv unused) {
                        return null;
                    }
                default:
                    return null;
            }
        } catch (l e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            a(hcVar);
            du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "19");
            j.c(this.f5540a, hcVar, intent, z);
            return null;
        } catch (hv e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            du.a(this.f5540a).b(this.f5540a.getPackageName(), dt.m5422a(i), str, "20");
            j.c(this.f5540a, hcVar, intent, z);
            return null;
        }
    }

    private boolean a(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return bundle.containsKey(str);
    }

    private void a(String str, long j, d dVar) {
        v vVarM5166a = g.m5166a(dVar);
        if (vVarM5166a == null) {
            return;
        }
        if (j == 0) {
            synchronized (p.class) {
                if (p.a(this.f5540a).m5170a(str)) {
                    p.a(this.f5540a).c(str);
                    if ("syncing".equals(p.a(this.f5540a).a(vVarM5166a))) {
                        p.a(this.f5540a).a(vVarM5166a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(p.a(this.f5540a).a(vVarM5166a))) {
            synchronized (p.class) {
                if (p.a(this.f5540a).m5170a(str)) {
                    if (p.a(this.f5540a).a(str) < 10) {
                        p.a(this.f5540a).b(str);
                        u.a(this.f5540a).a(str, vVarM5166a, dVar, "retry");
                    } else {
                        p.a(this.f5540a).c(str);
                    }
                }
            }
            return;
        }
        p.a(this.f5540a).c(str);
    }

    private void a(gx gxVar) {
        String strA = gxVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + strA);
        Map<String, String> mapM5574a = gxVar.m5574a();
        if (mapM5574a != null) {
            String str = mapM5574a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + strA + "  realSource = " + str);
            bo.a(this.f5540a).a(strA, str, Boolean.valueOf(gxVar.f6081a == 0));
        }
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) throws NumberFormatException {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long j = ((((Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long j2 = ((((Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        return arrayList;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f5540a.getSharedPreferences("mipush_extra", 0);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f5540a, gu.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, jCurrentTimeMillis).commit();
        }
    }

    private void a(hc hcVar) {
        com.xiaomi.channel.commonutils.logger.b.m5113a("receive a message but decrypt failed. report now.");
        hf hfVar = new hf(hcVar.m5593a().f6036a, false);
        hfVar.c(gq.DecryptMessageFail.f6003a);
        hfVar.b(hcVar.m5594a());
        hfVar.d(hcVar.f6130b);
        HashMap map = new HashMap();
        hfVar.f6142a = map;
        map.put("regid", MiPushClient.getRegId(this.f5540a));
        u.a(this.f5540a).a((u) hfVar, gg.Notification, false, (gt) null);
    }

    private void a(hj hjVar, hc hcVar) {
        gt gtVarM5593a = hcVar.m5593a();
        if (gtVarM5593a != null) {
            gtVarM5593a = au.a(gtVarM5593a.m5558a());
        }
        gw gwVar = new gw();
        gwVar.b(hjVar.b());
        gwVar.a(hjVar.m5632a());
        gwVar.a(hjVar.a().a());
        if (!TextUtils.isEmpty(hjVar.c())) {
            gwVar.c(hjVar.c());
        }
        if (!TextUtils.isEmpty(hjVar.d())) {
            gwVar.d(hjVar.d());
        }
        gwVar.a(hq.a(this.f5540a, hcVar));
        u.a(this.f5540a).a((u) gwVar, gg.AckMessage, gtVarM5593a);
    }

    private void a(hf hfVar) {
        gx gxVar = new gx();
        gxVar.c(gq.CancelPushMessageACK.f6003a);
        gxVar.a(hfVar.m5608a());
        gxVar.a(hfVar.a());
        gxVar.b(hfVar.b());
        gxVar.e(hfVar.d());
        gxVar.a(0L);
        gxVar.d("success clear push message.");
        u.a(this.f5540a).a(gxVar, gg.Notification, false, true, null, false, this.f5540a.getPackageName(), b.m5140a(this.f5540a).m5141a(), false);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5171a(Context context, String str) {
        synchronized (f5538a) {
            b.m5140a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            if (f5539a == null) {
                String[] strArrSplit = sharedPreferencesA.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f5539a = new LinkedList();
                for (String str2 : strArrSplit) {
                    f5539a.add(str2);
                }
            }
            if (f5539a.contains(str)) {
                return true;
            }
            f5539a.add(str);
            if (f5539a.size() > 25) {
                f5539a.poll();
            }
            String strA = bc.a(f5539a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
            return false;
        }
    }

    public static void a(Context context, String str) {
        synchronized (f5538a) {
            f5539a.remove(str);
            b.m5140a(context);
            SharedPreferences sharedPreferencesA = b.a(context);
            String strA = bc.a(f5539a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putString("pref_msg_ids", strA);
            com.xiaomi.push.p.a(editorEdit);
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return x.a(context, str, map, i);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5172a(hc hcVar) {
        Map<String, String> mapM5560a = hcVar.m5593a() == null ? null : hcVar.m5593a().m5560a();
        if (mapM5560a == null) {
            return false;
        }
        String str = mapM5560a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }
}
