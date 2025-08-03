package defpackage;

import kotlin.Result;

/* compiled from: Result.kt */
/* renamed from: ඪ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4817 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Object m14541(Throwable th) {
        C3921.m12666(th, "exception");
        return new Result.Failure(th);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final void m14542(Object obj) throws Throwable {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
