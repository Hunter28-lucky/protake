package kotlinx.coroutines;

import defpackage.C3782;
import defpackage.C3921;
import defpackage.C4542;
import defpackage.d0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C2160;

/* compiled from: CommonPool.kt */
/* renamed from: kotlinx.coroutines.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2160 extends ExecutorCoroutineDispatcher {
    private static volatile Executor pool;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2160 f7923 = new C2160();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final int f7924;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean f7925;

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property == null) {
            iIntValue = -1;
        } else {
            Integer numM5892 = d0.m5892(property);
            if (numM5892 == null || numM5892.intValue() < 1) {
                throw new IllegalStateException(C3921.m12673("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", property).toString());
            }
            iIntValue = numM5892.intValue();
        }
        f7924 = iIntValue;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final Thread m7427(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, C3921.m12673("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final void m7428() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executorM7431 = pool;
            if (executorM7431 == null) {
                executorM7431 = m7431();
            }
            C3782.m12100();
            executorM7431.execute(runnable);
        } catch (RejectedExecutionException unused) {
            C3782.m12100();
            RunnableC2161.f7926.m7444(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "CommonPool";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final ExecutorService m7429() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return Executors.newFixedThreadPool(m7432(), new ThreadFactory() { // from class: ڊ
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C2160.m7427(atomicInteger, runnable);
            }
        });
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final ExecutorService m7430() {
        Class<?> cls;
        Object objInvoke;
        if (System.getSecurityManager() != null) {
            return m7429();
        }
        ExecutorService executorService = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return m7429();
        }
        if (!f7925 && f7924 < 0) {
            try {
                objInvoke = cls.getMethod("commonPool", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused2) {
            }
            ExecutorService executorService2 = objInvoke instanceof ExecutorService ? (ExecutorService) objInvoke : null;
            if (executorService2 != null) {
                if (!f7923.m7433(cls, executorService2)) {
                    executorService2 = null;
                }
                if (executorService2 != null) {
                    return executorService2;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f7923.m7432()));
            if (objNewInstance instanceof ExecutorService) {
                executorService = (ExecutorService) objNewInstance;
            }
        } catch (Throwable unused3) {
        }
        return executorService == null ? m7429() : executorService;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final synchronized Executor m7431() {
        Executor executorM7430;
        executorM7430 = pool;
        if (executorM7430 == null) {
            executorM7430 = m7430();
            pool = executorM7430;
        }
        return executorM7430;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final int m7432() {
        Integer numValueOf = Integer.valueOf(f7924);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf == null ? C4542.m13943(Runtime.getRuntime().availableProcessors() - 1, 1) : numValueOf.intValue();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final boolean m7433(Class<?> cls, ExecutorService executorService) {
        executorService.submit(new Runnable() { // from class: ࠔ
            @Override // java.lang.Runnable
            public final void run() {
                C2160.m7428();
            }
        });
        Integer num = null;
        try {
            Object objInvoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (objInvoke instanceof Integer) {
                num = (Integer) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }
}
