package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class OpenIdHelper {
    private static Method b;

    public static final boolean a() throws NoSuchMethodException, SecurityException {
        Context context = null;
        try {
            if (b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                b = method;
                method.setAccessible(true);
            }
            context = (Context) b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static String b(Context context) {
        b bVarA = b.a();
        return bVarA.a(context.getApplicationContext(), bVarA.b);
    }
}
