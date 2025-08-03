package defpackage;

import io.reactivex.internal.util.ExceptionHelper;

/* compiled from: Exceptions.java */
/* renamed from: म, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4089 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static RuntimeException m13025(Throwable th) {
        throw ExceptionHelper.m7024(th);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13026(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
