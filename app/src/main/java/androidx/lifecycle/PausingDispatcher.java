package androidx.lifecycle;

import com.umeng.analytics.pro.d;
import defpackage.C2888;
import defpackage.C3921;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        C3921.m12666(coroutineContext, d.R);
        C3921.m12666(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        C3921.m12666(coroutineContext, d.R);
        if (C2888.m10244().mo10951().isDispatchNeeded(coroutineContext)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
