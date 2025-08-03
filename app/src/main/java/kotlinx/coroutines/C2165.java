package kotlinx.coroutines;

import defpackage.b9;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Unconfined.kt */
/* renamed from: kotlinx.coroutines.Ԭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2165 extends CoroutineDispatcher {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C2165 f7934 = new C2165();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b9 b9Var = (b9) coroutineContext.get(b9.f135);
        if (b9Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        b9Var.f136 = true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
