package com.mob.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class ExecutorDispatcher implements com.mob.tools.utils.a {
    private static volatile ExecutorDispatcher b;
    private final com.mob.tools.utils.a a = new a();

    public static abstract class SafeRunnable implements Runnable {
        public void afterRun() {
        }

        public void beforeRun() {
        }

        public void handleException(Throwable th) {
        }

        public String name() {
            return "";
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strName = name();
                if (!TextUtils.isEmpty(strName)) {
                    Thread.currentThread().setName(strName);
                }
                beforeRun();
                safeRun();
                afterRun();
            } catch (Throwable th) {
                try {
                    handleException(th);
                } catch (Throwable unused) {
                }
            }
        }

        public abstract void safeRun();
    }

    public static final class a implements com.mob.tools.utils.a {
        private final ExecutorService a;
        private final ExecutorService b;
        private final ExecutorService c;
        private final Handler d;

        @Override // com.mob.tools.utils.a
        public <T extends SafeRunnable> void executeDelayed(final T t, long j) {
            if (t == null) {
                return;
            }
            try {
                this.d.postDelayed(new SafeRunnable() { // from class: com.mob.tools.utils.ExecutorDispatcher.a.1
                    @Override // com.mob.tools.utils.ExecutorDispatcher.SafeRunnable
                    public void safeRun() {
                        a.this.executeImmediately(t);
                    }
                }, j);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }

        @Override // com.mob.tools.utils.a
        public <T extends SafeRunnable> void executeDuctile(T t) {
            try {
                this.b.execute(t);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }

        @Override // com.mob.tools.utils.a
        public <T extends SafeRunnable> void executeImmediately(T t) {
            try {
                this.a.execute(t);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }

        @Override // com.mob.tools.utils.a
        public <T extends SafeRunnable> void executeSerial(T t) {
            try {
                this.c.execute(t);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }

        private a() {
            this.d = new Handler(Looper.getMainLooper());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, timeUnit, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.a = threadPoolExecutor;
            this.b = new ThreadPoolExecutor(2, 2, 10L, timeUnit, new LinkedBlockingQueue());
            this.c = Executors.newSingleThreadExecutor();
        }
    }

    public static com.mob.tools.utils.a getInstance() {
        if (b == null) {
            synchronized (ExecutorDispatcher.class) {
                if (b == null) {
                    b = new ExecutorDispatcher();
                }
            }
        }
        return b;
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeDelayed(T t, long j) {
        if (t == null) {
            return;
        }
        try {
            if (j <= 0) {
                this.a.executeDuctile(t);
            } else {
                this.a.executeDelayed(t, j);
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeDuctile(T t) {
        if (t == null) {
            return;
        }
        try {
            this.a.executeDuctile(t);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeImmediately(T t) {
        if (t == null) {
            return;
        }
        try {
            this.a.executeImmediately(t);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    @Override // com.mob.tools.utils.a
    public <T extends SafeRunnable> void executeSerial(T t) {
        if (t == null) {
            return;
        }
        try {
            this.a.executeSerial(t);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
