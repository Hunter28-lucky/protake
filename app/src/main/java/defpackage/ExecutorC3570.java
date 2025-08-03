package defpackage;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* renamed from: ڪ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class ExecutorC3570 extends ExecutorCoroutineDispatcher implements h1, Executor {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f12441 = AtomicIntegerFieldUpdater.newUpdater(ExecutorC3570.class, "inFlightTasks");

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4611 f12442;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f12443;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String f12444;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f12445;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final ConcurrentLinkedQueue<Runnable> f12446 = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public ExecutorC3570(C4611 c4611, int i, String str, int i2) {
        this.f12442 = c4611;
        this.f12443 = i;
        this.f12444 = str;
        this.f12445 = i2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m11523(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        m11523(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m11523(runnable, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.f12444;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f12442 + ']';
    }

    @Override // defpackage.h1
    /* renamed from: ԩ */
    public void mo6177() {
        Runnable runnablePoll = this.f12446.poll();
        if (runnablePoll != null) {
            this.f12442.m14071(runnablePoll, this, true);
            return;
        }
        f12441.decrementAndGet(this);
        Runnable runnablePoll2 = this.f12446.poll();
        if (runnablePoll2 == null) {
            return;
        }
        m11523(runnablePoll2, true);
    }

    @Override // defpackage.h1
    /* renamed from: ԫ */
    public int mo6178() {
        return this.f12445;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m11523(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f12441;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f12443) {
                this.f12442.m14071(runnable, this, z);
                return;
            }
            this.f12446.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f12443) {
                return;
            } else {
                runnable = this.f12446.poll();
            }
        } while (runnable != null);
    }
}
