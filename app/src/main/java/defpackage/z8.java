package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: WorkQueue.kt */
/* loaded from: classes2.dex */
public final class z8 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8780 = AtomicReferenceFieldUpdater.newUpdater(z8.class, Object.class, "lastScheduledTask");

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8781 = AtomicIntegerFieldUpdater.newUpdater(z8.class, "producerIndex");

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8782 = AtomicIntegerFieldUpdater.newUpdater(z8.class, "consumerIndex");

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8783 = AtomicIntegerFieldUpdater.newUpdater(z8.class, "blockingTasksInBuffer");

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AtomicReferenceArray<g1> f8784 = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ g1 m8648(z8 z8Var, g1 g1Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return z8Var.m8649(g1Var, z);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final g1 m8649(g1 g1Var, boolean z) {
        if (z) {
            return m8650(g1Var);
        }
        g1 g1Var2 = (g1) f8780.getAndSet(this, g1Var);
        if (g1Var2 == null) {
            return null;
        }
        return m8650(g1Var2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final g1 m8650(g1 g1Var) {
        if (g1Var.f6646.mo6178() == 1) {
            f8783.incrementAndGet(this);
        }
        if (m8652() == 127) {
            return g1Var;
        }
        int i = this.producerIndex & 127;
        while (this.f8784.get(i) != null) {
            Thread.yield();
        }
        this.f8784.lazySet(i, g1Var);
        f8781.incrementAndGet(this);
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m8651(g1 g1Var) {
        if (g1Var != null) {
            if (g1Var.f6646.mo6178() == 1) {
                f8783.decrementAndGet(this);
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m8652() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m8653() {
        return this.lastScheduledTask != null ? m8652() + 1 : m8652();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m8654(C3694 c3694) {
        g1 g1Var = (g1) f8780.getAndSet(this, null);
        if (g1Var != null) {
            c3694.m13368(g1Var);
        }
        while (m8657(c3694)) {
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final g1 m8655() {
        g1 g1Var = (g1) f8780.getAndSet(this, null);
        return g1Var == null ? m8656() : g1Var;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final g1 m8656() {
        g1 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (f8782.compareAndSet(this, i, i + 1) && (andSet = this.f8784.getAndSet(i2, null)) != null) {
                m8651(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m8657(C3694 c3694) {
        g1 g1VarM8656 = m8656();
        if (g1VarM8656 == null) {
            return false;
        }
        c3694.m13368(g1VarM8656);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        return m8660(r9, true);
     */
    /* renamed from: ֈ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m8658(defpackage.z8 r9) {
        /*
            r8 = this;
            int r0 = r9.consumerIndex
            int r1 = r9.producerIndex
            java.util.concurrent.atomic.AtomicReferenceArray<g1> r2 = r9.f8784
        L6:
            r3 = 1
            if (r0 == r1) goto L3b
            r4 = r0 & 127(0x7f, float:1.78E-43)
            int r5 = r9.blockingTasksInBuffer
            if (r5 != 0) goto L10
            goto L3b
        L10:
            java.lang.Object r5 = r2.get(r4)
            g1 r5 = (defpackage.g1) r5
            if (r5 == 0) goto L38
            h1 r6 = r5.f6646
            int r6 = r6.mo6178()
            r7 = 0
            if (r6 != r3) goto L22
            goto L23
        L22:
            r3 = r7
        L23:
            if (r3 == 0) goto L38
            r3 = 0
            boolean r4 = defpackage.y8.m8628(r2, r4, r5, r3)
            if (r4 == 0) goto L38
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.z8.f8783
            r0.decrementAndGet(r9)
            r9 = 2
            m8648(r8, r5, r7, r9, r3)
            r0 = -1
            return r0
        L38:
            int r0 = r0 + 1
            goto L6
        L3b:
            long r0 = r8.m8660(r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z8.m8658(z8):long");
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final long m8659(z8 z8Var) {
        g1 g1VarM8656 = z8Var.m8656();
        if (g1VarM8656 == null) {
            return m8660(z8Var, false);
        }
        m8648(this, g1VarM8656, false, 2, null);
        return -1L;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final long m8660(z8 z8Var, boolean z) {
        g1 g1Var;
        do {
            g1Var = (g1) z8Var.lastScheduledTask;
            if (g1Var == null) {
                return -2L;
            }
            if (z) {
                if (!(g1Var.f6646.mo6178() == 1)) {
                    return -2L;
                }
            }
            long jMo13951 = n1.f8045.mo13951() - g1Var.f6645;
            long j = n1.f8040;
            if (jMo13951 < j) {
                return j - jMo13951;
            }
        } while (!C3777.m12082(f8780, z8Var, g1Var, null));
        m8648(this, g1Var, false, 2, null);
        return -1L;
    }
}
