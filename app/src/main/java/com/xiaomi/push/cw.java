package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class cw {
    private final String a = "power_consumption_stats";
    private final String b = "off_up_ct";
    private final String c = "off_dn_ct";
    private final String d = "off_ping_ct";

    /* renamed from: e, reason: collision with root package name */
    private final String f17848e = "off_pong_ct";
    private final String f = "off_dur";
    private final String g = "on_up_ct";
    private final String h = "on_dn_ct";
    private final String i = "on_ping_ct";
    private final String j = "on_pong_ct";
    private final String k = "on_dur";
    private final String l = com.umeng.analytics.pro.d.p;
    private final String m = com.umeng.analytics.pro.d.q;
    private final String n = "xmsf_vc";
    private final String o = "android_vc";
    private final String p = "uuid";

    public void a(Context context, cv cvVar) {
        if (cvVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("off_up_ct", Integer.valueOf(cvVar.a()));
        map.put("off_dn_ct", Integer.valueOf(cvVar.b()));
        map.put("off_ping_ct", Integer.valueOf(cvVar.c()));
        map.put("off_pong_ct", Integer.valueOf(cvVar.d()));
        map.put("off_dur", Long.valueOf(cvVar.m5319a()));
        map.put("on_up_ct", Integer.valueOf(cvVar.e()));
        map.put("on_dn_ct", Integer.valueOf(cvVar.f()));
        map.put("on_ping_ct", Integer.valueOf(cvVar.g()));
        map.put("on_pong_ct", Integer.valueOf(cvVar.h()));
        map.put("on_dur", Long.valueOf(cvVar.m5320b()));
        map.put(com.umeng.analytics.pro.d.p, Long.valueOf(cvVar.m5321c()));
        map.put(com.umeng.analytics.pro.d.q, Long.valueOf(cvVar.m5322d()));
        map.put("xmsf_vc", Integer.valueOf(cvVar.i()));
        map.put("android_vc", Integer.valueOf(cvVar.j()));
        map.put("uuid", com.xiaomi.push.service.q.m5808a(context));
        ei.a().a("power_consumption_stats", map);
    }
}
