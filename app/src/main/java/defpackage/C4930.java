package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* renamed from: ใ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4930 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final List<CoroutineExceptionHandler> f16620 = C4119.m13080(SequencesKt__SequencesKt.m7260(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m14662(CoroutineContext coroutineContext, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = f16620.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, C4084.m13021(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
