package kotlin;

import defpackage.C3921;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4870;

/* compiled from: LazyJVM.kt */
/* renamed from: kotlin.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2146 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> InterfaceC4870<T> m7323(InterfaceC4090<? extends T> interfaceC4090) {
        C3921.m12666(interfaceC4090, "initializer");
        return new SynchronizedLazyImpl(interfaceC4090, null, 2, null);
    }
}
