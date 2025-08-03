package defpackage;

import kotlin.Result;

/* compiled from: DebugStrings.kt */
/* renamed from: ć, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2316 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String m8690(Object obj) {
        return obj.getClass().getSimpleName();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String m8691(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final String m8692(InterfaceC4355<?> interfaceC4355) {
        Object objM7211;
        if (interfaceC4355 instanceof C2317) {
            return interfaceC4355.toString();
        }
        try {
            Result.C2137 c2137 = Result.f7828;
            objM7211 = Result.m7211(interfaceC4355 + '@' + m8691(interfaceC4355));
        } catch (Throwable th) {
            Result.C2137 c21372 = Result.f7828;
            objM7211 = Result.m7211(C4817.m14541(th));
        }
        if (Result.m7213(objM7211) != null) {
            objM7211 = ((Object) interfaceC4355.getClass().getName()) + '@' + m8691(interfaceC4355);
        }
        return (String) objM7211;
    }
}
