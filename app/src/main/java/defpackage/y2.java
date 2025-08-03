package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.disposables.C1972;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes2.dex */
public final class y2 extends AbstractC4585 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final y2 f8748 = new y2();

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: y2$Ϳ, reason: contains not printable characters */
    public static final class RunnableC2303 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Runnable f8749;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2305 f8750;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final long f8751;

        public RunnableC2303(Runnable runnable, C2305 c2305, long j) {
            this.f8749 = runnable;
            this.f8750 = c2305;
            this.f8751 = j;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (this.f8750.f8759) {
                return;
            }
            long jM14051 = this.f8750.m14051(TimeUnit.MILLISECONDS);
            long j = this.f8751;
            if (j > jM14051) {
                try {
                    Thread.sleep(j - jM14051);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    C3671.m11803(e2);
                    return;
                }
            }
            if (this.f8750.f8759) {
                return;
            }
            this.f8749.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: y2$Ԩ, reason: contains not printable characters */
    public static final class C2304 implements Comparable<C2304> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Runnable f8752;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f8753;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f8754;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f8755;

        public C2304(Runnable runnable, Long l, int i) {
            this.f8752 = runnable;
            this.f8753 = l.longValue();
            this.f8754 = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compareTo(C2304 c2304) {
            int iM13350 = C4246.m13350(this.f8753, c2304.f8753);
            return iM13350 == 0 ? C4246.m13349(this.f8754, c2304.f8754) : iM13350;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* renamed from: y2$Ԫ, reason: contains not printable characters */
    public static final class C2305 extends AbstractC4585.AbstractC4588 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final PriorityBlockingQueue<C2304> f8756 = new PriorityBlockingQueue<>();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicInteger f8757 = new AtomicInteger();

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicInteger f8758 = new AtomicInteger();

        /* renamed from: Ԯ, reason: contains not printable characters */
        public volatile boolean f8759;

        /* compiled from: TrampolineScheduler.java */
        /* renamed from: y2$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC2306 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final C2304 f8760;

            public RunnableC2306(C2304 c2304) {
                this.f8760 = c2304;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8760.f8755 = true;
                C2305.this.f8756.remove(this.f8760);
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f8759 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f8759;
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: Ԩ */
        public InterfaceC4478 mo6990(Runnable runnable) {
            return m8619(runnable, m14051(TimeUnit.MILLISECONDS));
        }

        @Override // defpackage.AbstractC4585.AbstractC4588
        /* renamed from: ԩ */
        public InterfaceC4478 mo6991(Runnable runnable, long j, TimeUnit timeUnit) {
            long jM14051 = m14051(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return m8619(new RunnableC2303(runnable, this, jM14051), jM14051);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public InterfaceC4478 m8619(Runnable runnable, long j) {
            if (this.f8759) {
                return EmptyDisposable.INSTANCE;
            }
            C2304 c2304 = new C2304(runnable, Long.valueOf(j), this.f8758.incrementAndGet());
            this.f8756.add(c2304);
            if (this.f8757.getAndIncrement() != 0) {
                return C1972.m6302(new RunnableC2306(c2304));
            }
            int iAddAndGet = 1;
            while (!this.f8759) {
                C2304 c2304Poll = this.f8756.poll();
                if (c2304Poll == null) {
                    iAddAndGet = this.f8757.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!c2304Poll.f8755) {
                    c2304Poll.f8752.run();
                }
            }
            this.f8756.clear();
            return EmptyDisposable.INSTANCE;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static y2 m8617() {
        return f8748;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ϳ */
    public AbstractC4585.AbstractC4588 mo6986() {
        return new C2305();
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: ԩ */
    public InterfaceC4478 mo6987(Runnable runnable) {
        C3671.m11805(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // defpackage.AbstractC4585
    /* renamed from: Ԫ */
    public InterfaceC4478 mo6988(Runnable runnable, long j, TimeUnit timeUnit) throws InterruptedException {
        try {
            timeUnit.sleep(j);
            C3671.m11805(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            C3671.m11803(e2);
        }
        return EmptyDisposable.INSTANCE;
    }
}
