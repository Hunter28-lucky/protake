package defpackage;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.RunnableC2161;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: Dispatcher.kt */
/* renamed from: ಗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4611 extends ExecutorCoroutineDispatcher {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f15713;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f15714;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final long f15715;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String f15716;

    /* renamed from: ՠ, reason: contains not printable characters */
    public CoroutineScheduler f15717;

    public C4611(int i, int i2, long j, String str) {
        this.f15713 = i;
        this.f15714 = i2;
        this.f15715 = j;
        this.f15716 = str;
        this.f15717 = m14070();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.m7376(this.f15717, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            RunnableC2161.f7926.dispatch(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            CoroutineScheduler.m7376(this.f15717, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            RunnableC2161.f7926.dispatchYield(coroutineContext, runnable);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final CoroutineScheduler m14070() {
        return new CoroutineScheduler(this.f15713, this.f15714, this.f15715, this.f15716);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m14071(Runnable runnable, h1 h1Var, boolean z) {
        try {
            this.f15717.m7382(runnable, h1Var, z);
        } catch (RejectedExecutionException unused) {
            RunnableC2161.f7926.m7444(this.f15717.m7380(runnable, h1Var));
        }
    }

    public /* synthetic */ C4611(int i, int i2, String str, int i3, C4184 c4184) {
        this((i3 & 1) != 0 ? n1.f8042 : i, (i3 & 2) != 0 ? n1.f8043 : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public C4611(int i, int i2, String str) {
        this(i, i2, n1.f8044, str);
    }
}
