package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.C2116;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* renamed from: ʗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2674 extends AbstractC4585 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final RxThreadFactory f9927;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final RxThreadFactory f9928;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C2677 f9931;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final RunnableC2675 f9932;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ThreadFactory f9933;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final AtomicReference<RunnableC2675> f9934;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final TimeUnit f9930 = TimeUnit.SECONDS;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final long f9929 = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* compiled from: IoScheduler.java */
    /* renamed from: ʗ$Ϳ, reason: contains not printable characters */
    public static final class RunnableC2675 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final long f9935;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final ConcurrentLinkedQueue<C2677> f9936;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C2527 f9937;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final ScheduledExecutorService f9938;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final Future<?> f9939;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final ThreadFactory f9940;

        public RunnableC2675(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f9935 = nanos;
            this.f9936 = new ConcurrentLinkedQueue<>();
            this.f9937 = new C2527();
            this.f9940 = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, C2674.f9928);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f9938 = scheduledExecutorServiceNewScheduledThreadPool;
            this.f9939 = scheduledFutureScheduleWithFixedDelay;
        }

        @Override // java.lang.Runnable
        public void run() {
            m9817();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m9817() {
            if (this.f9936.isEmpty()) {
                return;
            }
            long jM9819 = m9819();
            Iterator<C2677> it = this.f9936.iterator();
            while (it.hasNext()) {
                C2677 next = it.next();
                if (next.m9822() > jM9819) {
                    return;
                }
                if (this.f9936.remove(next)) {
                    this.f9937.mo9334(next);
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C2677 m9818() {
            if (this.f9937.isDisposed()) {
                return C2674.f9931;
            }
            while (!this.f9936.isEmpty()) {
                C2677 c2677Poll = this.f9936.poll();
                if (c2677Poll != null) {
                    return c2677Poll;
                }
            }
            C2677 c2677 = new C2677(this.f9940);
            this.f9937.mo9333(c2677);
            return c2677;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public long m9819() {
            return System.nanoTime();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m9820(C2677 c2677) {
            c2677.m9823(m9819() + this.f9935);
            this.f9936.offer(c2677);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m9821() {
            this.f9937.dispose();
            Future<?> future = this.f9939;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f9938;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: ʗ$Ԩ, reason: contains not printable characters */
    public static final class C2676 extends AbstractC4585.AbstractC4588 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final RunnableC2675 f9942;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final C2677 f9943;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AtomicBoolean f9944 = new AtomicBoolean();

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2527 f9941 = new C2527();

        public C2676(RunnableC2675 runnableC2675) {
            this.f9942 = runnableC2675;
            this.f9943 = runnableC2675.m9818();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f9944.compareAndSet(false, true)) {
                this.f9941.dispose();
                this.f9942.m9820(this.f9943);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f9944.get();
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.f9941.isDisposed() ? EmptyDisposable.INSTANCE : this.f9943.m6995(runnable, j, timeUnit, this.f9941);
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: ʗ$Ԫ, reason: contains not printable characters */
    public static final class C2677 extends C2116 {

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f9945;

        public C2677(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f9945 = 0L;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public long m9822() {
            return this.f9945;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public void m9823(long j) {
            this.f9945 = j;
        }
    }

    static {
        C2677 c2677 = new C2677(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f9931 = c2677;
        c2677.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f9927 = rxThreadFactory;
        f9928 = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        RunnableC2675 runnableC2675 = new RunnableC2675(0L, null, rxThreadFactory);
        f9932 = runnableC2675;
        runnableC2675.m9821();
    }

    public C2674() {
        this(f9927);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C2676(this.f9934.get());
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԭ */
    public void mo7000() {
        RunnableC2675 runnableC2675;
        RunnableC2675 runnableC26752;
        do {
            runnableC2675 = this.f9934.get();
            runnableC26752 = f9932;
            if (runnableC2675 == runnableC26752) {
                return;
            }
        } while (!C4905.m14631(this.f9934, runnableC2675, runnableC26752));
        runnableC2675.m9821();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m9816() {
        RunnableC2675 runnableC2675 = new RunnableC2675(f9929, f9930, this.f9933);
        if (C4905.m14631(this.f9934, f9932, runnableC2675)) {
            return;
        }
        runnableC2675.m9821();
    }

    public C2674(ThreadFactory threadFactory) {
        this.f9933 = threadFactory;
        this.f9934 = new AtomicReference<>(f9932);
        m9816();
    }
}
