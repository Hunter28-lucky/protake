package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C5341r;
import com.xiaomi.push.service.am;
import com.xiaomi.push.t;
import java.util.Locale;

/* loaded from: classes2.dex */
public class p {
    public final int a;

    /* renamed from: a, reason: collision with other field name */
    public final String f6473a;
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final String f17903e;
    public final String f;

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f6473a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f17903e = str5;
        this.f = str6;
        this.a = i;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m5731b(), "c");
        return bVar;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        bVar.f6404a = context.getPackageName();
        bVar.f6407b = this.f6473a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f6406a = false;
        t.a aVar = new t.a();
        aVar.a("sdk_ver", 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a("country_code", b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", com.xiaomi.push.j.f()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m5745a(context))).a("systemui_vc", Integer.valueOf(C5341r.a(context)));
        if (com.xiaomi.push.j.m5697e()) {
            aVar.a("os_vm", com.xiaomi.push.j.c());
            aVar.a("os_vc", Integer.valueOf(com.xiaomi.push.j.b()));
        }
        String strA = a(context);
        if (!TextUtils.isEmpty(strA)) {
            aVar.a("latest_country_code", strA);
        }
        String strG = com.xiaomi.push.j.g();
        if (!TextUtils.isEmpty(strG)) {
            aVar.a("device_ch", strG);
        }
        String strH = com.xiaomi.push.j.h();
        if (!TextUtils.isEmpty(strH)) {
            aVar.a("device_mfr", strH);
        }
        bVar.f17900e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.d;
        t.a aVar2 = new t.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m5806a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f = aVar2.toString();
        bVar.f6403a = hVar;
        return bVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5806a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean a() {
        try {
            return com.xiaomi.push.s.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String strM5687a = com.xiaomi.push.j.m5687a("ro.miui.region");
            return TextUtils.isEmpty(strM5687a) ? com.xiaomi.push.j.m5687a("ro.product.locale.region") : strM5687a;
        }
        return com.xiaomi.push.j.m5692b();
    }
}
