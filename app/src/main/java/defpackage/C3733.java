package defpackage;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;

/* compiled from: ReflectionFactory.java */
/* renamed from: ݜ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3733 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC2457 m11962(FunctionReference functionReference) {
        return functionReference;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC2623 m11963(Class cls) {
        return new C2690(cls);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC3686 m11964(Class cls, String str) {
        return new C4031(cls, str);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m11965(InterfaceC5139 interfaceC5139) {
        String string = interfaceC5139.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public String m11966(Lambda lambda) {
        return m11965(lambda);
    }
}
