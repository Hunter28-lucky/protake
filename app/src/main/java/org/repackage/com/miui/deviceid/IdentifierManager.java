package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class IdentifierManager {
    private static Object b;
    private static Class<?> c;
    private static Method d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f17909e;
    private static Method f;
    private static Method g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
            d = c.getMethod("getUDID", Context.class);
            f17909e = c.getMethod("getOAID", Context.class);
            f = c.getMethod("getVAID", Context.class);
            g = c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f17909e);
    }

    private static String a(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
