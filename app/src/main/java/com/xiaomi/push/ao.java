package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class ao implements aj {
    private static volatile ao a;

    /* renamed from: a, reason: collision with other field name */
    private int f5590a = an.a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5591a;

    /* renamed from: a, reason: collision with other field name */
    private aj f5592a;

    private ao(Context context) {
        this.f5591a = context.getApplicationContext();
        this.f5592a = an.a(context);
        com.xiaomi.channel.commonutils.logger.b.m5113a("create id manager is: " + this.f5590a);
    }

    public static ao a(Context context) {
        if (a == null) {
            synchronized (ao.class) {
                if (a == null) {
                    a = new ao(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public boolean mo5202a() {
        return this.f5592a.mo5202a();
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public String mo5201a() {
        return j.m5690a(this.f5591a) ? a(this.f5592a.mo5201a()) : "";
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo5201a = mo5201a();
        if (!TextUtils.isEmpty(strMo5201a)) {
            map.put("oaid", strMo5201a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f5590a));
    }
}
