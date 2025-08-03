package defpackage;

import java.util.List;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes2.dex */
public class u3 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static List m8338(Object obj) {
        if (obj instanceof InterfaceC4947) {
            m8345(obj, "kotlin.collections.MutableList");
        }
        return m8340(obj);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Object m8339(Object obj, int i) {
        if (obj != null && !m8342(obj, i)) {
            m8345(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static List m8340(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw m8344(e2);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m8341(Object obj) {
        if (obj instanceof InterfaceC5139) {
            return ((InterfaceC5139) obj).getArity();
        }
        if (obj instanceof InterfaceC4090) {
            return 0;
        }
        if (obj instanceof InterfaceC2392) {
            return 1;
        }
        if (obj instanceof InterfaceC2849) {
            return 2;
        }
        if (obj instanceof InterfaceC3697) {
            return 3;
        }
        if (obj instanceof InterfaceC4365) {
            return 4;
        }
        if (obj instanceof InterfaceC5304) {
            return 5;
        }
        if (obj instanceof InterfaceC2481) {
            return 6;
        }
        if (obj instanceof InterfaceC2484) {
            return 7;
        }
        if (obj instanceof InterfaceC2466) {
            return 8;
        }
        if (obj instanceof InterfaceC2550) {
            return 9;
        }
        if (obj instanceof InterfaceC5004) {
            return 10;
        }
        if (obj instanceof InterfaceC2391) {
            return 11;
        }
        if (obj instanceof InterfaceC2482) {
            return 12;
        }
        if (obj instanceof InterfaceC2393) {
            return 13;
        }
        if (obj instanceof InterfaceC4941) {
            return 14;
        }
        if (obj instanceof InterfaceC3908) {
            return 15;
        }
        if (obj instanceof InterfaceC2424) {
            return 16;
        }
        if (obj instanceof InterfaceC4981) {
            return 17;
        }
        if (obj instanceof InterfaceC4206) {
            return 18;
        }
        if (obj instanceof InterfaceC4458) {
            return 19;
        }
        if (obj instanceof InterfaceC3267) {
            return 20;
        }
        if (obj instanceof InterfaceC4959) {
            return 21;
        }
        return obj instanceof InterfaceC4338 ? 22 : -1;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m8342(Object obj, int i) {
        return (obj instanceof InterfaceC2486) && m8341(obj) == i;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T extends Throwable> T m8343(T t) {
        return (T) C3921.m12672(t, u3.class.getName());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static ClassCastException m8344(ClassCastException classCastException) {
        throw ((ClassCastException) m8343(classCastException));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m8345(Object obj, String str) {
        m8346((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m8346(String str) {
        throw m8344(new ClassCastException(str));
    }
}
