package com.xiaomi.push.service;

import android.content.Context;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class bd implements XMPushService.n {
    private static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static final boolean f6443a = Log.isLoggable("UNDatas", 3);

    /* renamed from: a, reason: collision with other field name */
    private static final Map<Integer, Map<String, List<String>>> f6442a = new HashMap();

    public bd(Context context) {
        a = context;
    }

    private static void b() {
        HashMap map = new HashMap();
        map.putAll(f6442a);
        if (map.size() > 0) {
            for (Integer num : map.keySet()) {
                Map map2 = (Map) map.get(num);
                if (map2 != null && map2.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str : map2.keySet()) {
                        sb.append(str);
                        sb.append(Constants.COLON_SEPARATOR);
                        List list = (List) map2.get(str);
                        if (!com.xiaomi.push.t.a(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                if (i != 0) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                                sb.append((String) list.get(i));
                            }
                        }
                        sb.append(";");
                    }
                    hf hfVarA = a(null, aj.a(), gq.NotificationRemoved.f6003a, null);
                    hfVarA.a("removed_reason", String.valueOf(num));
                    hfVarA.a("all_delete_msgId_appId", sb.toString());
                    com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload all removed messages reason: " + num + " allIds: " + sb.toString());
                    a(a, hfVarA);
                }
                f6442a.remove(num);
            }
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a */
    public void mo5522a() {
        Map<Integer, Map<String, List<String>>> map = f6442a;
        if (map.size() > 0) {
            synchronized (map) {
                b();
            }
        }
    }

    private static void a(Context context, final hf hfVar) {
        if (f6443a) {
            com.xiaomi.channel.commonutils.logger.b.b("UNDatas upload message notification:" + hfVar);
        }
        com.xiaomi.push.af.a(context).a(new Runnable() { // from class: com.xiaomi.push.service.bd.1
            @Override // java.lang.Runnable
            public void run() {
                byte[] bArrA = hq.a(w.a(hfVar.d(), hfVar.b(), hfVar, gg.Notification));
                if (bd.a instanceof XMPushService) {
                    ((XMPushService) bd.a).a(hfVar.d(), bArrA, true);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m5113a("UNDatas UploadNotificationDatas failed because not xmsf");
                }
            }
        });
    }

    private static hf a(String str, String str2, String str3, String str4) {
        hf hfVar = new hf();
        if (str3 != null) {
            hfVar.c(str3);
        }
        if (str != null) {
            hfVar.b(str);
        }
        if (str2 != null) {
            hfVar.a(str2);
        }
        if (str4 != null) {
            hfVar.d(str4);
        }
        hfVar.a(false);
        return hfVar;
    }
}
