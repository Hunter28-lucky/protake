package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.fb;
import defpackage.pc;
import defpackage.sf;
import defpackage.ua;
import java.util.UUID;

/* loaded from: classes.dex */
public class h {
    public static String a = "";

    public static long a(Context context) {
        String strM6065 = fb.m6065(context, "vkeyid_settings", "update_time_interval");
        if (!ua.m8373(strM6065)) {
            return 86400000L;
        }
        try {
            return Long.parseLong(strM6065);
        } catch (Exception unused) {
            return 86400000L;
        }
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void a(Context context, String str, long j) {
        fb.m6066(context, "vkeyid_settings", "vkey_valid" + str, String.valueOf(j));
    }

    public static void a(Context context, String str, String str2) {
        fb.m6066(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    public static String b(Context context) {
        return fb.m6065(context, "vkeyid_settings", "last_apdid_env");
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static boolean c(Context context) {
        String strM6065 = fb.m6065(context, "vkeyid_settings", "log_switch");
        return strM6065 != null && "1".equals(strM6065);
    }

    public static String d(Context context) {
        return fb.m6065(context, "vkeyid_settings", "dynamic_key");
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static String e(Context context) {
        return fb.m6065(context, "vkeyid_settings", "apse_degrade");
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static String f(Context context) {
        String str;
        SharedPreferences.Editor editorEdit;
        synchronized (h.class) {
            if (ua.m8370(a)) {
                String strM8239 = sf.m8239(context, "alipay_vkey_random", "random", "");
                a = strM8239;
                if (ua.m8370(strM8239)) {
                    String strM7968 = pc.m7968(UUID.randomUUID().toString());
                    a = strM7968;
                    if (strM7968 != null && (editorEdit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        editorEdit.putString("random", strM7968);
                        editorEdit.commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(Context context, String str) {
        try {
            String strM6065 = fb.m6065(context, "vkeyid_settings", "vkey_valid" + str);
            if (ua.m8370(strM6065)) {
                return 0L;
            }
            return Long.parseLong(strM6065);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
