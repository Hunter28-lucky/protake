package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class cq {
    private final String a = "disconnection_event";
    private final String b = "count";
    private final String c = "host";
    private final String d = "network_state";

    /* renamed from: e, reason: collision with root package name */
    private final String f17846e = "reason";
    private final String f = "ping_interval";
    private final String g = com.umeng.analytics.pro.am.T;
    private final String h = "wifi_digest";
    private final String i = "duration";
    private final String j = "disconnect_time";
    private final String k = "connect_time";
    private final String l = "xmsf_vc";
    private final String m = "android_vc";
    private final String n = "uuid";

    public void a(Context context, List<cp> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        co.a("upload size = " + list.size());
        String strM5808a = com.xiaomi.push.service.q.m5808a(context);
        for (cp cpVar : list) {
            HashMap map = new HashMap();
            map.put("count", Integer.valueOf(cpVar.a()));
            map.put("host", cpVar.m5309a());
            map.put("network_state", Integer.valueOf(cpVar.b()));
            map.put("reason", Integer.valueOf(cpVar.c()));
            map.put("ping_interval", Long.valueOf(cpVar.m5308a()));
            map.put(com.umeng.analytics.pro.am.T, Integer.valueOf(cpVar.d()));
            map.put("wifi_digest", cpVar.m5311b());
            map.put("connected_network_type", Integer.valueOf(cpVar.e()));
            map.put("duration", Long.valueOf(cpVar.m5310b()));
            map.put("disconnect_time", Long.valueOf(cpVar.m5312c()));
            map.put("connect_time", Long.valueOf(cpVar.m5313d()));
            map.put("xmsf_vc", Integer.valueOf(cpVar.f()));
            map.put("android_vc", Integer.valueOf(cpVar.g()));
            map.put("uuid", strM5808a);
            ei.a().a("disconnection_event", map);
        }
    }
}
