package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import defpackage.md;
import defpackage.sf;
import defpackage.ua;
import defpackage.wd;
import defpackage.yc;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || ua.m8370(str) || ua.m8370(str2)) {
            return null;
        }
        try {
            String strM8239 = sf.m8239(context, str, str2, "");
            if (ua.m8370(strM8239)) {
                return null;
            }
            return md.m7560(md.m7556(), strM8239);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (ua.m8370(str) || ua.m8370(str2)) {
                return null;
            }
            try {
                String strM8631 = yc.m8631(str);
                if (ua.m8370(strM8631)) {
                    return null;
                }
                String string = new JSONObject(strM8631).getString(str2);
                if (ua.m8370(string)) {
                    return null;
                }
                return md.m7560(md.m7556(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (ua.m8370(str) || ua.m8370(str2) || context == null) {
            return;
        }
        try {
            String strM7557 = md.m7557(md.m7556(), str3);
            HashMap map = new HashMap();
            map.put(str2, strM7557);
            sf.m8240(context, str, map);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (ua.m8370(str) || ua.m8370(str2)) {
                return;
            }
            try {
                String strM8631 = yc.m8631(str);
                JSONObject jSONObject = new JSONObject();
                if (ua.m8373(strM8631)) {
                    try {
                        jSONObject = new JSONObject(strM8631);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, md.m7557(md.m7556(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (wd.m8571()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (wd.m8571()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
