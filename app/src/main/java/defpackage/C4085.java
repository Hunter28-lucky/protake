package defpackage;

import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* renamed from: प, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4085 extends C4611 {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final C4085 f14213;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final CoroutineDispatcher f14214;

    static {
        C4085 c4085 = new C4085();
        f14213 = c4085;
        f14214 = new ExecutorC3570(c4085, w0.m8500("kotlinx.coroutines.io.parallelism", C4542.m13943(64, u0.m8329()), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public C4085() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final CoroutineDispatcher m13022() {
        return f14214;
    }
}
