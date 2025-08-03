package io.reactivex.internal.schedulers;

import defpackage.AbstractC4585;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4877;
import defpackage.FutureC2470;
import defpackage.InterfaceC2806;
import defpackage.InterfaceC4478;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ExecutorScheduler extends AbstractC4585 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final AbstractC4585 f7647 = C4877.m14603();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f7648;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Executor f7649;

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, InterfaceC4478 {
        private static final long serialVersionUID = -4101336210206799084L;
        public final SequentialDisposable direct;
        public final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (getAndSet(null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.timed;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.direct.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    this.timed.lazySet(DisposableHelper.DISPOSED);
                    this.direct.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class ExecutorWorker extends AbstractC4585.AbstractC4588 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final boolean f7650;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Executor f7651;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f7653;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AtomicInteger f7654 = new AtomicInteger();

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C2527 f7655 = new C2527();

        /* renamed from: ԭ, reason: contains not printable characters */
        public final MpscLinkedQueue<Runnable> f7652 = new MpscLinkedQueue<>();

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, InterfaceC4478 {
            private static final long serialVersionUID = -2421395018820541164L;
            public final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                lazySet(true);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, InterfaceC4478 {
            private static final long serialVersionUID = -3603436687413320876L;
            public final Runnable run;
            public final InterfaceC2806 tasks;
            public volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, InterfaceC2806 interfaceC2806) {
                this.run = runnable;
                this.tasks = interfaceC2806;
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            m6992();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.thread;
                        if (thread != null) {
                            thread.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        m6992();
                        return;
                    }
                }
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.thread = null;
                        return;
                    }
                    try {
                        this.run.run();
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            m6992();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        this.thread = null;
                        if (compareAndSet(1, 2)) {
                            m6992();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                        throw th;
                    }
                }
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6992() {
                InterfaceC2806 interfaceC2806 = this.tasks;
                if (interfaceC2806 != null) {
                    interfaceC2806.mo9335(this);
                }
            }
        }

        /* renamed from: io.reactivex.internal.schedulers.ExecutorScheduler$ExecutorWorker$Ϳ, reason: contains not printable characters */
        public final class RunnableC2113 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final SequentialDisposable f7656;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final Runnable f7657;

            public RunnableC2113(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f7656 = sequentialDisposable;
                this.f7657 = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7656.m6311(ExecutorWorker.this.mo6990(this.f7657));
            }
        }

        public ExecutorWorker(Executor executor, boolean z) {
            this.f7651 = executor;
            this.f7650 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f7653) {
                return;
            }
            this.f7653 = true;
            this.f7655.dispose();
            if (this.f7654.getAndIncrement() == 0) {
                this.f7652.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7653;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.f7652;
            int iAddAndGet = 1;
            while (!this.f7653) {
                do {
                    Runnable runnablePoll = mpscLinkedQueue.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    } else if (this.f7653) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        iAddAndGet = this.f7654.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f7653);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: Ԩ, reason: contains not printable characters */
        public InterfaceC4478 mo6990(Runnable runnable) {
            InterfaceC4478 booleanRunnable;
            if (this.f7653) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableM11805 = C3671.m11805(runnable);
            if (this.f7650) {
                booleanRunnable = new InterruptibleRunnable(runnableM11805, this.f7655);
                this.f7655.mo9333(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableM11805);
            }
            this.f7652.offer(booleanRunnable);
            if (this.f7654.getAndIncrement() == 0) {
                try {
                    this.f7651.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f7653 = true;
                    this.f7652.clear();
                    C3671.m11803(e2);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ, reason: contains not printable characters */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo6990(runnable);
            }
            if (this.f7653) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new RunnableC2113(sequentialDisposable2, C3671.m11805(runnable)), this.f7655);
            this.f7655.mo9333(scheduledRunnable);
            Executor executor = this.f7651;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.m6994(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f7653 = true;
                    C3671.m11803(e2);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.m6994(new FutureC2470(ExecutorScheduler.f7647.mo6988(scheduledRunnable, j, timeUnit)));
            }
            sequentialDisposable.m6311(scheduledRunnable);
            return sequentialDisposable2;
        }
    }

    /* renamed from: io.reactivex.internal.schedulers.ExecutorScheduler$Ϳ, reason: contains not printable characters */
    public final class RunnableC2114 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final DelayedRunnable f7659;

        public RunnableC2114(DelayedRunnable delayedRunnable) {
            this.f7659 = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f7659;
            delayedRunnable.direct.m6311(ExecutorScheduler.this.mo6987(delayedRunnable));
        }
    }

    public ExecutorScheduler(Executor executor, boolean z) {
        this.f7649 = executor;
        this.f7648 = z;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ, reason: contains not printable characters */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new ExecutorWorker(this.f7649, this.f7648);
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԩ, reason: contains not printable characters */
    public InterfaceC4478 mo6987(Runnable runnable) {
        Runnable runnableM11805 = C3671.m11805(runnable);
        try {
            if (this.f7649 instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableM11805);
                scheduledDirectTask.m6985(((ExecutorService) this.f7649).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f7648) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableM11805, null);
                this.f7649.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableM11805);
            this.f7649.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e2) {
            C3671.m11803(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable runnableM11805 = C3671.m11805(runnable);
        if (!(this.f7649 instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableM11805);
            delayedRunnable.timed.m6311(f7647.mo6988(new RunnableC2114(delayedRunnable), j, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableM11805);
            scheduledDirectTask.m6985(((ScheduledExecutorService) this.f7649).schedule(scheduledDirectTask, j, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e2) {
            C3671.m11803(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4478 mo6989(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.f7649 instanceof ScheduledExecutorService)) {
            return super.mo6989(runnable, j, j2, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(C3671.m11805(runnable));
            scheduledDirectPeriodicTask.m6985(((ScheduledExecutorService) this.f7649).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            C3671.m11803(e2);
            return EmptyDisposable.INSTANCE;
        }
    }
}
