package defpackage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ForkThreadPoolExecutor.java */
/* renamed from: ƅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2407 extends ThreadPoolExecutor {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f8985 = C2407.class.getSimpleName();

    public C2407(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void terminated() {
        super.terminated();
    }
}
