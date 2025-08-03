package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* loaded from: classes2.dex */
public class OpenIDSDK {
    public static void a(Context context) {
        a.b = c.a.a.a(context.getApplicationContext());
        a.a = true;
    }

    public static String c(Context context) {
        if (a.a) {
            return c.a.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.a) {
            return a.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
