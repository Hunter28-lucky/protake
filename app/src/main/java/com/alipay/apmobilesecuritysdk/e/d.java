package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.umeng.umcrash.UMCrash;
import defpackage.ua;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {
    public static c a(String str) {
        try {
            if (!ua.m8370(str)) {
                JSONObject jSONObject = new JSONObject(str);
                return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString(UMCrash.SP_KEY_TIMESTAMP), jSONObject.optString("tid"), jSONObject.optString("utdid"));
            }
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
        }
        return null;
    }

    public static synchronized void a() {
    }

    public static synchronized void a(Context context) {
        com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
        com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
    }

    public static synchronized void a(Context context, c cVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apdid", cVar.a);
            jSONObject.put("deviceInfoHash", cVar.b);
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, cVar.c);
            jSONObject.put("tid", cVar.d);
            jSONObject.put("utdid", cVar.f17632e);
            String string = jSONObject.toString();
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", string);
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", string);
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
        }
    }

    public static synchronized c b() {
        String strA = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
        if (ua.m8370(strA)) {
            return null;
        }
        return a(strA);
    }

    public static synchronized c b(Context context) {
        String strA;
        strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
        if (ua.m8370(strA)) {
            strA = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
        }
        return a(strA);
    }

    public static synchronized c c(Context context) {
        String strA = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
        if (ua.m8370(strA)) {
            return null;
        }
        return a(strA);
    }
}
