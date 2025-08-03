package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
/* renamed from: ऩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4084 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m13020(CoroutineContext coroutineContext, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.f7854);
            if (coroutineExceptionHandler == null) {
                C4930.m14662(coroutineContext, th);
            } else {
                coroutineExceptionHandler.handleException(coroutineContext, th);
            }
        } catch (Throwable th2) {
            C4930.m14662(coroutineContext, m13021(th, th2));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Throwable m13021(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        C4147.m13130(runtimeException, th);
        return runtimeException;
    }
}
