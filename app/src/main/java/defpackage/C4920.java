package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: CloseGuard.kt */
/* renamed from: ะ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4920 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C4921 f16603 = new C4921(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Method f16604;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Method f16605;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Method f16606;

    /* compiled from: CloseGuard.kt */
    /* renamed from: ะ$Ϳ, reason: contains not printable characters */
    public static final class C4921 {
        public C4921() {
        }

        public /* synthetic */ C4921(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4920 m14649() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C4920(method3, method2, method);
        }
    }

    public C4920(Method method, Method method2, Method method3) {
        this.f16604 = method;
        this.f16605 = method2;
        this.f16606 = method3;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object m14647(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C3921.m12667(str, "closer");
        Method method = this.f16604;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.f16605;
                if (method2 == null) {
                    C3921.m12675();
                }
                method2.invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m14648(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f16606;
            if (method == null) {
                C3921.m12675();
            }
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
