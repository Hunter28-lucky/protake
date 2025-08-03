package com.mob.commons;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class u {
    public static final String a = "M-" + i.a("002 jfjk");
    public static final String b = "M-" + i.a("003Gijgmjk");
    public static final ThreadPoolExecutor c;
    public static final ThreadPoolExecutor d;

    /* renamed from: e, reason: collision with root package name */
    public static final ExecutorService f17687e;
    public static final ExecutorService f;
    public static final ExecutorService g;

    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                com.mob.commons.a.d.a().c(500L, runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements ThreadFactory {
        private static final AtomicInteger a = new AtomicInteger(1);
        private final ThreadGroup b;
        private final AtomicInteger c = new AtomicInteger(1);
        private final String d;

        public b(int i) {
            SecurityManager securityManager = System.getSecurityManager();
            this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (TextUtils.isEmpty("M-")) {
                this.d = i.a("005gKgegegfjk") + a.getAndIncrement() + i.a("008Ejk%fe,fjAk4fhEj?jk");
                return;
            }
            this.d = u.b + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a.getAndIncrement() + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.b, runnable, this.d + this.c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int iMax = Math.max(2, 5);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        c = new ThreadPoolExecutor(2, iMax, 60L, timeUnit, new SynchronousQueue(), new b(0), new a());
        d = new ThreadPoolExecutor(1, 1, 120L, timeUnit, new LinkedBlockingQueue(), new b(1));
        f17687e = Executors.newCachedThreadPool(new b(2));
        f = Executors.newCachedThreadPool(new b(3));
        g = Executors.newCachedThreadPool(new b(4));
    }
}
