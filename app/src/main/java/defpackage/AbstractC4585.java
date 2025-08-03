package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.C2116;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* renamed from: ౠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4585 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final long f15670 = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    /* renamed from: ౠ$Ϳ, reason: contains not printable characters */
    public static final class RunnableC4586 implements InterfaceC4478, Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Runnable f15671;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4588 f15672;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Thread f15673;

        public RunnableC4586(Runnable runnable, AbstractC4588 abstractC4588) {
            this.f15671 = runnable;
            this.f15672 = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.f15673 == Thread.currentThread()) {
                AbstractC4588 abstractC4588 = this.f15672;
                if (abstractC4588 instanceof C2116) {
                    ((C2116) abstractC4588).m6998();
                    return;
                }
            }
            this.f15672.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15672.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15673 = Thread.currentThread();
            try {
                this.f15671.run();
            } finally {
                dispose();
                this.f15673 = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: ౠ$Ԩ, reason: contains not printable characters */
    public static final class RunnableC4587 implements InterfaceC4478, Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Runnable f15674;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4588 f15675;

        /* renamed from: ԭ, reason: contains not printable characters */
        public volatile boolean f15676;

        public RunnableC4587(Runnable runnable, AbstractC4588 abstractC4588) {
            this.f15674 = runnable;
            this.f15675 = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15676 = true;
            this.f15675.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15676;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15676) {
                return;
            }
            try {
                this.f15674.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15675.dispose();
                throw ExceptionHelper.m7024(th);
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* renamed from: ౠ$Ԫ, reason: contains not printable characters */
    public static abstract class AbstractC4588 implements InterfaceC4478 {

        /* compiled from: Scheduler.java */
        /* renamed from: ౠ$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC4589 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final Runnable f15677;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final SequentialDisposable f15678;

            /* renamed from: ԭ, reason: contains not printable characters */
            public final long f15679;

            /* renamed from: Ԯ, reason: contains not printable characters */
            public long f15680;

            /* renamed from: ԯ, reason: contains not printable characters */
            public long f15681;

            /* renamed from: ՠ, reason: contains not printable characters */
            public long f15682;

            public RunnableC4589(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.f15677 = runnable;
                this.f15678 = sequentialDisposable;
                this.f15679 = j3;
                this.f15681 = j2;
                this.f15682 = j;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r12 = this;
                    java.lang.Runnable r0 = r12.f15677
                    r0.run()
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f15678
                    boolean r0 = r0.isDisposed()
                    if (r0 != 0) goto L51
                    ౠ$Ԫ r0 = defpackage.AbstractC4585.AbstractC4588.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r2 = r0.m14051(r1)
                    long r4 = defpackage.AbstractC4585.f15670
                    long r6 = r2 + r4
                    long r8 = r12.f15681
                    int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    r6 = 1
                    if (r0 < 0) goto L34
                    long r10 = r12.f15679
                    long r8 = r8 + r10
                    long r8 = r8 + r4
                    int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r0 < 0) goto L2a
                    goto L34
                L2a:
                    long r4 = r12.f15682
                    long r8 = r12.f15680
                    long r8 = r8 + r6
                    r12.f15680 = r8
                    long r8 = r8 * r10
                    long r4 = r4 + r8
                    goto L43
                L34:
                    long r4 = r12.f15679
                    long r8 = r2 + r4
                    long r10 = r12.f15680
                    long r10 = r10 + r6
                    r12.f15680 = r10
                    long r4 = r4 * r10
                    long r4 = r8 - r4
                    r12.f15682 = r4
                    r4 = r8
                L43:
                    r12.f15681 = r2
                    long r4 = r4 - r2
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f15678
                    ౠ$Ԫ r2 = defpackage.AbstractC4585.AbstractC4588.this
                    ப r1 = r2.mo6991(r12, r4, r1)
                    r0.m6311(r1)
                L51:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC4585.AbstractC4588.RunnableC4589.run():void");
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long m14051(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* renamed from: Ԩ */
        public InterfaceC4478 mo6990(Runnable runnable) {
            return mo6991(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        /* renamed from: ԩ */
        public abstract InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit);

        /* renamed from: Ԫ */
        public InterfaceC4478 mo11922(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableM11805 = C3671.m11805(runnable);
            long nanos = timeUnit.toNanos(j2);
            long jM14051 = m14051(TimeUnit.NANOSECONDS);
            InterfaceC4478 interfaceC4478Mo6991 = mo6991(new RunnableC4589(jM14051 + timeUnit.toNanos(j), runnableM11805, jM14051, sequentialDisposable2, nanos), j, timeUnit);
            if (interfaceC4478Mo6991 == EmptyDisposable.INSTANCE) {
                return interfaceC4478Mo6991;
            }
            sequentialDisposable.m6311(interfaceC4478Mo6991);
            return sequentialDisposable2;
        }
    }

    /* renamed from: Ϳ */
    public abstract AbstractC4588 mo6986();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long m14050(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: ԩ */
    public InterfaceC4478 mo6987(Runnable runnable) {
        return mo6988(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) {
        AbstractC4588 abstractC4588Mo6986 = mo6986();
        RunnableC4586 runnableC4586 = new RunnableC4586(C3671.m11805(runnable), abstractC4588Mo6986);
        abstractC4588Mo6986.mo6991(runnableC4586, j, timeUnit);
        return runnableC4586;
    }

    /* renamed from: ԫ */
    public InterfaceC4478 mo6989(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        AbstractC4588 abstractC4588Mo6986 = mo6986();
        RunnableC4587 runnableC4587 = new RunnableC4587(C3671.m11805(runnable), abstractC4588Mo6986);
        InterfaceC4478 interfaceC4478Mo11922 = abstractC4588Mo6986.mo11922(runnableC4587, j, j2, timeUnit);
        return interfaceC4478Mo11922 == EmptyDisposable.INSTANCE ? interfaceC4478Mo11922 : runnableC4587;
    }

    /* renamed from: Ԭ */
    public void mo7000() {
    }
}
