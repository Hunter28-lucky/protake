package defpackage;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor.java */
/* renamed from: Ɏ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class ExecutorServiceC2561 implements ExecutorService {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final long f9560 = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: ԭ, reason: contains not printable characters */
    public static volatile int f9561;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final ExecutorService f9562;

    /* compiled from: GlideExecutor.java */
    /* renamed from: Ɏ$Ϳ, reason: contains not printable characters */
    public static final class ThreadFactoryC2562 implements ThreadFactory {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final String f9563;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2564 f9564;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean f9565;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public int f9566;

        /* compiled from: GlideExecutor.java */
        /* renamed from: Ɏ$Ϳ$Ϳ, reason: contains not printable characters */
        public class C2563 extends Thread {
            public C2563(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                if (ThreadFactoryC2562.this.f9565) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC2562.this.f9564.mo9423(th);
                }
            }
        }

        public ThreadFactoryC2562(String str, InterfaceC2564 interfaceC2564, boolean z) {
            this.f9563 = str;
            this.f9564 = interfaceC2564;
            this.f9565 = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C2563 c2563;
            c2563 = new C2563(runnable, "glide-" + this.f9563 + "-thread-" + this.f9566);
            this.f9566 = this.f9566 + 1;
            return c2563;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: Ɏ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2564 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final InterfaceC2564 f9568 = new C2565();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final InterfaceC2564 f9569;

        /* renamed from: ԩ, reason: contains not printable characters */
        public static final InterfaceC2564 f9570;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final InterfaceC2564 f9571;

        /* compiled from: GlideExecutor.java */
        /* renamed from: Ɏ$Ԩ$Ϳ, reason: contains not printable characters */
        public class C2565 implements InterfaceC2564 {
            @Override // defpackage.ExecutorServiceC2561.InterfaceC2564
            /* renamed from: Ϳ */
            public void mo9423(Throwable th) {
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: Ɏ$Ԩ$Ԩ, reason: contains not printable characters */
        public class C2566 implements InterfaceC2564 {
            @Override // defpackage.ExecutorServiceC2561.InterfaceC2564
            /* renamed from: Ϳ */
            public void mo9423(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: Ɏ$Ԩ$Ԫ, reason: contains not printable characters */
        public class C2567 implements InterfaceC2564 {
            @Override // defpackage.ExecutorServiceC2561.InterfaceC2564
            /* renamed from: Ϳ */
            public void mo9423(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C2566 c2566 = new C2566();
            f9569 = c2566;
            f9570 = new C2567();
            f9571 = c2566;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo9423(Throwable th);
    }

    @VisibleForTesting
    public ExecutorServiceC2561(ExecutorService executorService) {
        this.f9562 = executorService;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m9415() {
        if (f9561 == 0) {
            f9561 = Math.min(4, C4816.m14540());
        }
        return f9561;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9416() {
        return m9417(m9415() >= 4 ? 2 : 1, InterfaceC2564.f9571);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9417(int i, InterfaceC2564 interfaceC2564) {
        return new ExecutorServiceC2561(new ThreadPoolExecutor(0, i, f9560, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC2562("animation", interfaceC2564, true)));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9418() {
        return m9419(1, "disk-cache", InterfaceC2564.f9571);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9419(int i, String str, InterfaceC2564 interfaceC2564) {
        return new ExecutorServiceC2561(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC2562(str, interfaceC2564, true)));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9420() {
        return m9421(m9415(), "source", InterfaceC2564.f9571);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9421(int i, String str, InterfaceC2564 interfaceC2564) {
        return new ExecutorServiceC2561(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC2562(str, interfaceC2564, false)));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static ExecutorServiceC2561 m9422() {
        return new ExecutorServiceC2561(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f9560, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC2562("source-unlimited", InterfaceC2564.f9571, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f9562.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f9562.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f9562.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f9562.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f9562.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f9562.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f9562.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f9562.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f9562.submit(runnable);
    }

    public String toString() {
        return this.f9562.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f9562.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f9562.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f9562.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f9562.submit(callable);
    }
}
