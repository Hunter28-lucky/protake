package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes2.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.InterfaceC2140 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C2147 f7854 = C2147.f7855;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$Ϳ, reason: contains not printable characters */
    public static final class C2147 implements CoroutineContext.InterfaceC2142<CoroutineExceptionHandler> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final /* synthetic */ C2147 f7855 = new C2147();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
