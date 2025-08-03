package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class zb {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Method f8786;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean m8669() throws NoSuchMethodException, SecurityException {
        Context context = null;
        try {
            if (f8786 == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f8786 = method;
                method.setAccessible(true);
            }
            context = (Context) f8786.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return wf.m8573().m8579(context, false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8670(Context context) {
        wf wfVarM8573 = wf.m8573();
        return wfVarM8573.m8578(context.getApplicationContext(), wfVarM8573.f8727);
    }
}
