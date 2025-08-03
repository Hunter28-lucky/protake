package defpackage;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;

/* compiled from: Reflection.java */
/* renamed from: ഫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4725 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3733 f15992;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final InterfaceC2623[] f15993;

    static {
        C3733 c3733 = null;
        try {
            c3733 = (C3733) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c3733 == null) {
            c3733 = new C3733();
        }
        f15992 = c3733;
        f15993 = new InterfaceC2623[0];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static InterfaceC2457 m14264(FunctionReference functionReference) {
        return f15992.m11962(functionReference);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InterfaceC2623 m14265(Class cls) {
        return f15992.m11963(cls);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static InterfaceC3686 m14266(Class cls) {
        return f15992.m11964(cls, "");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m14267(InterfaceC5139 interfaceC5139) {
        return f15992.m11965(interfaceC5139);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m14268(Lambda lambda) {
        return f15992.m11966(lambda);
    }
}
