package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class bc {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Object f143;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Class<?> f144;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Method f145;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Method f146;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Method f147;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static Method f148;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f144 = cls;
            f143 = cls.newInstance();
            f145 = f144.getMethod("getUDID", Context.class);
            f146 = f144.getMethod("getOAID", Context.class);
            f147 = f144.getMethod("getVAID", Context.class);
            f148 = f144.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m163(Context context, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = f143;
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

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m164() {
        return (f144 == null || f143 == null) ? false : true;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m165(Context context) {
        return m163(context, f146);
    }
}
