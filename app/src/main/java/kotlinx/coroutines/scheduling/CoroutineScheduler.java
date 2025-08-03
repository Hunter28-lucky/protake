package kotlinx.coroutines.scheduling;

import defpackage.C2316;
import defpackage.C3583;
import defpackage.C3694;
import defpackage.C3782;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.C4542;
import defpackage.g1;
import defpackage.h1;
import defpackage.i1;
import defpackage.i4;
import defpackage.n1;
import defpackage.r0;
import defpackage.z8;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.random.Random;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes2.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    public volatile /* synthetic */ long controlState;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f7891;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7892;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7893;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String f7894;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C3694 f7895;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C3694 f7896;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final AtomicReferenceArray<C2155> f7897;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final C2153 f7886 = new C2153(null);

    /* renamed from: ށ, reason: contains not printable characters */
    public static final r0 f7890 = new r0("NOT_IN_STACK");

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicLongFieldUpdater f7887 = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicLongFieldUpdater f7888 = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: ހ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7889 = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static WorkerState[] valuesCustom() {
            WorkerState[] workerStateArrValuesCustom = values();
            return (WorkerState[]) Arrays.copyOf(workerStateArrValuesCustom, workerStateArrValuesCustom.length);
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$Ϳ, reason: contains not printable characters */
    public static final class C2153 {
        public C2153() {
        }

        public /* synthetic */ C2153(C4184 c4184) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$Ԩ, reason: contains not printable characters */
    public /* synthetic */ class C2154 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f7904;

        static {
            int[] iArr = new int[WorkerState.valuesCustom().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f7904 = iArr;
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.f7891 = i;
        this.f7892 = i2;
        this.f7893 = j;
        this.f7894 = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f7895 = new C3694();
        this.f7896 = new C3694();
        this.parkedWorkersStack = 0L;
        this.f7897 = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ void m7376(CoroutineScheduler coroutineScheduler, Runnable runnable, h1 h1Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            h1Var = C3583.f12495;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.m7382(runnable, h1Var, z);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static /* synthetic */ boolean m7377(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.m7392(j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        m7388(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m7376(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        int length = this.f7897.length();
        int i5 = 0;
        if (1 < length) {
            i2 = 0;
            int i6 = 0;
            i3 = 0;
            i4 = 0;
            int i7 = 1;
            while (true) {
                int i8 = i7 + 1;
                C2155 c2155 = this.f7897.get(i7);
                if (c2155 != null) {
                    int iM8653 = c2155.f7906.m8653();
                    int i9 = C2154.f7904[c2155.f7907.ordinal()];
                    if (i9 == 1) {
                        i5++;
                    } else if (i9 == 2) {
                        i2++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(iM8653);
                        sb.append('b');
                        arrayList.add(sb.toString());
                    } else if (i9 == 3) {
                        i6++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(iM8653);
                        sb2.append('c');
                        arrayList.add(sb2.toString());
                    } else if (i9 == 4) {
                        i3++;
                        if (iM8653 > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(iM8653);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (i9 == 5) {
                        i4++;
                    }
                }
                if (i8 >= length) {
                    break;
                }
                i7 = i8;
            }
            i = i5;
            i5 = i6;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        long j = this.controlState;
        return this.f7894 + '@' + C2316.m8691(this) + "[Pool Size {core = " + this.f7891 + ", max = " + this.f7892 + "}, Worker States {CPU = " + i5 + ", blocking = " + i2 + ", parked = " + i + ", dormant = " + i3 + ", terminated = " + i4 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f7895.m13370() + ", global blocking queue size = " + this.f7896.m13370() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f7891 - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m7378(g1 g1Var) {
        return g1Var.f6646.mo6178() == 1 ? this.f7896.m13368(g1Var) : this.f7895.m13368(g1Var);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m7379() {
        synchronized (this.f7897) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int iM13943 = C4542.m13943(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (iM13943 >= this.f7891) {
                return 0;
            }
            if (i >= this.f7892) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.f7897.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            C2155 c2155 = new C2155(i2);
            this.f7897.set(i2, c2155);
            if (!(i2 == ((int) (2097151 & f7888.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c2155.start();
            return iM13943 + 1;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final g1 m7380(Runnable runnable, h1 h1Var) {
        long jMo13951 = n1.f8045.mo13951();
        if (!(runnable instanceof g1)) {
            return new i1(runnable, jMo13951, h1Var);
        }
        g1 g1Var = (g1) runnable;
        g1Var.f6645 = jMo13951;
        g1Var.f6646 = h1Var;
        return g1Var;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2155 m7381() {
        Thread threadCurrentThread = Thread.currentThread();
        C2155 c2155 = threadCurrentThread instanceof C2155 ? (C2155) threadCurrentThread : null;
        if (c2155 != null && C3921.m12662(CoroutineScheduler.this, this)) {
            return c2155;
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m7382(Runnable runnable, h1 h1Var, boolean z) {
        C3782.m12100();
        g1 g1VarM7380 = m7380(runnable, h1Var);
        C2155 c2155M7381 = m7381();
        g1 g1VarM7391 = m7391(c2155M7381, g1VarM7380, z);
        if (g1VarM7391 != null && !m7378(g1VarM7391)) {
            throw new RejectedExecutionException(C3921.m12673(this.f7894, " was terminated"));
        }
        boolean z2 = z && c2155M7381 != null;
        if (g1VarM7380.f6646.mo6178() != 0) {
            m7389(z2);
        } else {
            if (z2) {
                return;
            }
            m7390();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int m7383(C2155 c2155) {
        Object objM7401 = c2155.m7401();
        while (objM7401 != f7890) {
            if (objM7401 == null) {
                return 0;
            }
            C2155 c21552 = (C2155) objM7401;
            int iM7400 = c21552.m7400();
            if (iM7400 != 0) {
                return iM7400;
            }
            objM7401 = c21552.m7401();
        }
        return -1;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C2155 m7384() {
        while (true) {
            long j = this.parkedWorkersStack;
            C2155 c2155 = this.f7897.get((int) (2097151 & j));
            if (c2155 == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iM7383 = m7383(c2155);
            if (iM7383 >= 0 && f7887.compareAndSet(this, j, iM7383 | j2)) {
                c2155.m7409(f7890);
                return c2155;
            }
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m7385(C2155 c2155) {
        long j;
        int iM7400;
        if (c2155.m7401() != f7890) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            iM7400 = c2155.m7400();
            c2155.m7409(this.f7897.get((int) (2097151 & j)));
        } while (!f7887.compareAndSet(this, j, ((2097152 + j) & (-2097152)) | iM7400));
        return true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m7386(C2155 c2155, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iM7383 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iM7383 == i) {
                iM7383 = i2 == 0 ? m7383(c2155) : i2;
            }
            if (iM7383 >= 0 && f7887.compareAndSet(this, j, j2 | iM7383)) {
                return;
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m7387(g1 g1Var) {
        try {
            g1Var.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m7388(long j) throws InterruptedException {
        int i;
        if (f7889.compareAndSet(this, 0, 1)) {
            C2155 c2155M7381 = m7381();
            synchronized (this.f7897) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    int i3 = i2 + 1;
                    C2155 c2155 = this.f7897.get(i2);
                    C3921.m12664(c2155);
                    if (c2155 != c2155M7381) {
                        while (c2155.isAlive()) {
                            LockSupport.unpark(c2155);
                            c2155.join(j);
                        }
                        c2155.f7906.m8654(this.f7896);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            this.f7896.m13369();
            this.f7895.m13369();
            while (true) {
                g1 g1VarM7399 = c2155M7381 == null ? null : c2155M7381.m7399(true);
                if (g1VarM7399 == null) {
                    g1VarM7399 = this.f7895.m13371();
                }
                if (g1VarM7399 == null && (g1VarM7399 = this.f7896.m13371()) == null) {
                    break;
                } else {
                    m7387(g1VarM7399);
                }
            }
            if (c2155M7381 != null) {
                c2155M7381.m7412(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m7389(boolean z) {
        long jAddAndGet = f7888.addAndGet(this, 2097152L);
        if (z || m7393() || m7392(jAddAndGet)) {
            return;
        }
        m7393();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m7390() {
        if (m7393() || m7377(this, 0L, 1, null)) {
            return;
        }
        m7393();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final g1 m7391(C2155 c2155, g1 g1Var, boolean z) {
        if (c2155 == null || c2155.f7907 == WorkerState.TERMINATED) {
            return g1Var;
        }
        if (g1Var.f6646.mo6178() == 0 && c2155.f7907 == WorkerState.BLOCKING) {
            return g1Var;
        }
        c2155.f7911 = true;
        return c2155.f7906.m8649(g1Var, z);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final boolean m7392(long j) {
        if (C4542.m13943(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f7891) {
            int iM7379 = m7379();
            if (iM7379 == 1 && this.f7891 > 1) {
                m7379();
            }
            if (iM7379 > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final boolean m7393() {
        C2155 c2155M7384;
        do {
            c2155M7384 = m7384();
            if (c2155M7384 == null) {
                return false;
            }
        } while (!C2155.f7905.compareAndSet(c2155M7384, -1, 0));
        LockSupport.unpark(c2155M7384);
        return true;
    }

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: kotlinx.coroutines.scheduling.CoroutineScheduler$Ԫ, reason: contains not printable characters */
    public final class C2155 extends Thread {

        /* renamed from: ֏, reason: contains not printable characters */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f7905 = AtomicIntegerFieldUpdater.newUpdater(C2155.class, "workerCtl");
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        public volatile /* synthetic */ int workerCtl;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final z8 f7906;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public WorkerState f7907;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f7908;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public long f7909;

        /* renamed from: ԯ, reason: contains not printable characters */
        public int f7910;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f7911;

        public C2155() {
            setDaemon(true);
            this.f7906 = new z8();
            this.f7907 = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f7890;
            this.f7910 = Random.f7841.mo7258();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m7407();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m7395(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.f7888.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.f7907 != WorkerState.TERMINATED) {
                this.f7907 = WorkerState.DORMANT;
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m7396(int i) {
            if (i != 0 && m7412(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.m7390();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final void m7397(g1 g1Var) {
            int iMo6178 = g1Var.f6646.mo6178();
            m7402(iMo6178);
            m7396(iMo6178);
            CoroutineScheduler.this.m7387(g1Var);
            m7395(iMo6178);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final g1 m7398(boolean z) {
            g1 g1VarM7406;
            g1 g1VarM74062;
            if (z) {
                boolean z2 = m7404(CoroutineScheduler.this.f7891 * 2) == 0;
                if (z2 && (g1VarM74062 = m7406()) != null) {
                    return g1VarM74062;
                }
                g1 g1VarM8655 = this.f7906.m8655();
                if (g1VarM8655 != null) {
                    return g1VarM8655;
                }
                if (!z2 && (g1VarM7406 = m7406()) != null) {
                    return g1VarM7406;
                }
            } else {
                g1 g1VarM74063 = m7406();
                if (g1VarM74063 != null) {
                    return g1VarM74063;
                }
            }
            return m7413(false);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final g1 m7399(boolean z) {
            g1 g1VarM13371;
            if (m7410()) {
                return m7398(z);
            }
            if (!z || (g1VarM13371 = this.f7906.m8655()) == null) {
                g1VarM13371 = CoroutineScheduler.this.f7896.m13371();
            }
            return g1VarM13371 == null ? m7413(true) : g1VarM13371;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int m7400() {
            return this.indexInArray;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final Object m7401() {
            return this.nextParkedWorker;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final void m7402(int i) {
            this.f7908 = 0L;
            if (this.f7907 == WorkerState.PARKING) {
                this.f7907 = WorkerState.BLOCKING;
            }
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m7403() {
            return this.nextParkedWorker != CoroutineScheduler.f7890;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final int m7404(int i) {
            int i2 = this.f7910;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f7910 = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final void m7405() {
            if (this.f7908 == 0) {
                this.f7908 = System.nanoTime() + CoroutineScheduler.this.f7893;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f7893);
            if (System.nanoTime() - this.f7908 >= 0) {
                this.f7908 = 0L;
                m7414();
            }
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final g1 m7406() {
            if (m7404(2) == 0) {
                g1 g1VarM13371 = CoroutineScheduler.this.f7895.m13371();
                return g1VarM13371 == null ? CoroutineScheduler.this.f7896.m13371() : g1VarM13371;
            }
            g1 g1VarM133712 = CoroutineScheduler.this.f7896.m13371();
            return g1VarM133712 == null ? CoroutineScheduler.this.f7895.m13371() : g1VarM133712;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final void m7407() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f7907 != WorkerState.TERMINATED) {
                    g1 g1VarM7399 = m7399(this.f7911);
                    if (g1VarM7399 != null) {
                        this.f7909 = 0L;
                        m7397(g1VarM7399);
                    } else {
                        this.f7911 = false;
                        if (this.f7909 == 0) {
                            m7411();
                        } else if (z) {
                            m7412(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f7909);
                            this.f7909 = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            m7412(WorkerState.TERMINATED);
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public final void m7408(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f7894);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public final void m7409(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public final boolean m7410() {
            boolean z;
            if (this.f7907 != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (CoroutineScheduler.f7888.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f7907 = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public final void m7411() {
            if (!m7403()) {
                CoroutineScheduler.this.m7385(this);
                return;
            }
            this.workerCtl = -1;
            while (m7403() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f7907 != WorkerState.TERMINATED) {
                m7412(WorkerState.PARKING);
                Thread.interrupted();
                m7405();
            }
        }

        /* renamed from: ރ, reason: contains not printable characters */
        public final boolean m7412(WorkerState workerState) {
            WorkerState workerState2 = this.f7907;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f7888.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f7907 = workerState;
            }
            return z;
        }

        /* renamed from: ބ, reason: contains not printable characters */
        public final g1 m7413(boolean z) {
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iM7404 = m7404(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                iM7404++;
                if (iM7404 > i) {
                    iM7404 = 1;
                }
                C2155 c2155 = coroutineScheduler.f7897.get(iM7404);
                if (c2155 != null && c2155 != this) {
                    long jM8658 = z ? this.f7906.m8658(c2155.f7906) : this.f7906.m8659(c2155.f7906);
                    if (jM8658 == -1) {
                        return this.f7906.m8655();
                    }
                    if (jM8658 > 0) {
                        jMin = Math.min(jMin, jM8658);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f7909 = jMin;
            return null;
        }

        /* renamed from: ޅ, reason: contains not printable characters */
        public final void m7414() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f7897) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.f7891) {
                    return;
                }
                if (f7905.compareAndSet(this, -1, 1)) {
                    int iM7400 = m7400();
                    m7408(0);
                    coroutineScheduler.m7386(this, iM7400, 0);
                    int andDecrement = (int) (CoroutineScheduler.f7888.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != iM7400) {
                        C2155 c2155 = coroutineScheduler.f7897.get(andDecrement);
                        C3921.m12664(c2155);
                        coroutineScheduler.f7897.set(iM7400, c2155);
                        c2155.m7408(iM7400);
                        coroutineScheduler.m7386(c2155, andDecrement, iM7400);
                    }
                    coroutineScheduler.f7897.set(andDecrement, null);
                    i4 i4Var = i4.f6762;
                    this.f7907 = WorkerState.TERMINATED;
                }
            }
        }

        public C2155(int i) {
            this();
            m7408(i);
        }
    }
}
