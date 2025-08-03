package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.md;
import defpackage.sf;
import defpackage.ua;

/* loaded from: classes.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        String strM8239 = sf.m8239(context, "openapi_file_pri", "openApi" + str, "");
        if (ua.m8370(strM8239)) {
            return "";
        }
        String strM7560 = md.m7560(md.m7556(), strM8239);
        return ua.m8370(strM7560) ? "" : strM7560;
    }

    public static synchronized void a() {
    }

    public static synchronized void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
        if (editorEdit != null) {
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.putString("openApi" + str, md.m7557(md.m7556(), str2));
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
