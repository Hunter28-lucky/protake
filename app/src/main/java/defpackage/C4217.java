package defpackage;

import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* compiled from: HalfSerializer.java */
/* renamed from: ৱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4217 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13296(InterfaceC5102<?> interfaceC5102, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thM7019 = atomicThrowable.m7019();
            if (thM7019 != null) {
                interfaceC5102.onError(thM7019);
            } else {
                interfaceC5102.onComplete();
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13297(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thM7019 = atomicThrowable.m7019();
            if (thM7019 != null) {
                subscriber.onError(thM7019);
            } else {
                subscriber.onComplete();
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m13298(InterfaceC5102<?> interfaceC5102, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.m7018(th)) {
            C3671.m11803(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            interfaceC5102.onError(atomicThrowable.m7019());
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13299(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.m7018(th)) {
            C3671.m11803(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.m7019());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> void m13300(InterfaceC5102<? super T> interfaceC5102, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            interfaceC5102.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thM7019 = atomicThrowable.m7019();
                if (thM7019 != null) {
                    interfaceC5102.onError(thM7019);
                } else {
                    interfaceC5102.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> void m13301(Subscriber<? super T> subscriber, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thM7019 = atomicThrowable.m7019();
                if (thM7019 != null) {
                    subscriber.onError(thM7019);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }
}
