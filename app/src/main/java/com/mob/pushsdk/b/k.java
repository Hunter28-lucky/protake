package com.mob.pushsdk.b;

import android.text.TextUtils;
import com.mob.pushsdk.base.PLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class k {
    private static ThreadPoolExecutor a;
    private static ExecutorService b = Executors.newSingleThreadExecutor();

    public static abstract class a implements Runnable {
        public abstract void a();

        public void a(Throwable th) {
        }

        public String b() {
            return "";
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (!TextUtils.isEmpty(b())) {
                    Thread.currentThread().setName(b());
                }
                a();
            } catch (Throwable th) {
                try {
                    a(th);
                } catch (Throwable unused) {
                }
                PLog.getInstance().e(th);
            }
        }
    }

    private static void a() {
        if (f.a(a)) {
            synchronized (k.class) {
                if (f.a(a)) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue());
                    a = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
    }

    public static void b(Runnable runnable) {
        if (f.a(runnable)) {
            return;
        }
        try {
            a();
            a.execute(runnable);
        } catch (Exception e2) {
            PLog.getInstance().e(e2);
        }
    }

    public static void a(Runnable runnable) {
        if (f.a(runnable)) {
            return;
        }
        try {
            b.execute(runnable);
        } catch (Exception e2) {
            PLog.getInstance().e(e2);
        }
    }
}
