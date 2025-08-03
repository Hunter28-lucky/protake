package defpackage;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: DebugMetadata.kt */
/* renamed from: ࡏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3938 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3938 f13575 = new C3938();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C3939 f13576 = new C3939(null, null, null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C3939 f13577;

    /* compiled from: DebugMetadata.kt */
    /* renamed from: ࡏ$Ϳ, reason: contains not printable characters */
    public static final class C3939 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Method f13578;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Method f13579;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final Method f13580;

        public C3939(Method method, Method method2, Method method3) {
            this.f13578 = method;
            this.f13579 = method2;
            this.f13580 = method3;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3939 m12712(BaseContinuationImpl baseContinuationImpl) {
        try {
            C3939 c3939 = new C3939(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f13577 = c3939;
            return c3939;
        } catch (Exception unused) {
            C3939 c39392 = f13576;
            f13577 = c39392;
            return c39392;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m12713(BaseContinuationImpl baseContinuationImpl) {
        C3921.m12666(baseContinuationImpl, "continuation");
        C3939 c3939M12712 = f13577;
        if (c3939M12712 == null) {
            c3939M12712 = m12712(baseContinuationImpl);
        }
        if (c3939M12712 == f13576) {
            return null;
        }
        Method method = c3939M12712.f13578;
        Object objInvoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = c3939M12712.f13579;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = c3939M12712.f13580;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
