package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import defpackage.af;
import defpackage.hb;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        hb hbVarB = b(context, str, str2, str3);
        af.m38(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", hbVarB.toString());
    }

    public static synchronized void a(String str) {
        af.m37(str);
    }

    public static synchronized void a(Throwable th) {
        af.m39(th);
    }

    public static hb b(Context context, String str, String str2, String str3) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        return new hb(Build.MODEL, packageName, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202206130311", str, str2, str3);
    }
}
