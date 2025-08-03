package io.reactivex.disposables;

import defpackage.C4246;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;

/* compiled from: Disposables.java */
/* renamed from: io.reactivex.disposables.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C1972 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static InterfaceC4478 m6299() {
        return EmptyDisposable.INSTANCE;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InterfaceC4478 m6300() {
        return m6302(Functions.f6797);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static InterfaceC4478 m6301(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "run is null");
        return new ActionDisposable(interfaceC3809);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static InterfaceC4478 m6302(Runnable runnable) {
        C4246.m13353(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
