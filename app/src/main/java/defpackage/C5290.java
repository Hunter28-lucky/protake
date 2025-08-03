package defpackage;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SchedulerPoolFactory.java */
/* renamed from: ფ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5290 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean f17482;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int f17483;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AtomicReference<ScheduledExecutorService> f17484 = new AtomicReference<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Map<ScheduledThreadPoolExecutor, Object> f17485 = new ConcurrentHashMap();

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: ფ$Ϳ, reason: contains not printable characters */
    public static final class RunnableC5291 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(C5290.f17485.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    C5290.f17485.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* compiled from: SchedulerPoolFactory.java */
    /* renamed from: ფ$Ԩ, reason: contains not printable characters */
    public static final class C5292 implements InterfaceC2368<String, String> {
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        C5292 c5292 = new C5292();
        boolean zM15333 = m15333(true, "rx2.purge-enabled", true, true, c5292);
        f17482 = zM15333;
        f17483 = m15334(zM15333, "rx2.purge-period-seconds", 1, 1, c5292);
        m15335();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ScheduledExecutorService m15332(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        m15336(f17482, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m15333(boolean z, String str, boolean z2, boolean z3, InterfaceC2368<String, String> interfaceC2368) {
        if (!z) {
            return z3;
        }
        try {
            String strApply = interfaceC2368.apply(str);
            return strApply == null ? z2 : "true".equals(strApply);
        } catch (Throwable unused) {
            return z2;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m15334(boolean z, String str, int i, int i2, InterfaceC2368<String, String> interfaceC2368) {
        if (!z) {
            return i2;
        }
        try {
            String strApply = interfaceC2368.apply(str);
            return strApply == null ? i : Integer.parseInt(strApply);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m15335() {
        m15337(f17482);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m15336(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f17485.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m15337(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f17484;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (C4905.m14631(atomicReference, scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                RunnableC5291 runnableC5291 = new RunnableC5291();
                int i = f17483;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(runnableC5291, i, i, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
