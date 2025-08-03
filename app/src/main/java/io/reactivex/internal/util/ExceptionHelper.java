package io.reactivex.internal.util;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import defpackage.C4905;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ExceptionHelper {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Throwable f7687 = new Termination();

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> boolean m7020(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        do {
            th2 = atomicReference.get();
            if (th2 == f7687) {
                return false;
            }
        } while (!C4905.m14631(atomicReference, th2, th2 == null ? th : new CompositeException(th2, th)));
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> Throwable m7021(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f7687;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <E extends Throwable> Exception m7022(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7023(long j, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j + MyUTIL.white_space + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static RuntimeException m7024(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }
}
