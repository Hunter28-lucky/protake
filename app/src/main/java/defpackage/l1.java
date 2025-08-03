package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* compiled from: TaskQueue.kt */
/* loaded from: classes2.dex */
public final class l1 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f7937;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public f1 f7938;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<f1> f7939;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f7940;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final m1 f7941;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String f7942;

    public l1(m1 m1Var, String str) {
        C3921.m12667(m1Var, "taskRunner");
        C3921.m12667(str, "name");
        this.f7941 = m1Var;
        this.f7942 = str;
        this.f7939 = new ArrayList();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static /* synthetic */ void m7458(l1 l1Var, f1 f1Var, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        l1Var.m7467(f1Var, j);
    }

    public String toString() {
        return this.f7942;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m7459() {
        if (!i5.f6770 || !Thread.holdsLock(this)) {
            synchronized (this.f7941) {
                if (m7460()) {
                    this.f7941.m7527(this);
                }
                i4 i4Var = i4.f6762;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m7460() {
        f1 f1Var = this.f7938;
        if (f1Var != null) {
            if (f1Var == null) {
                C3921.m12675();
            }
            if (f1Var.m6029()) {
                this.f7940 = true;
            }
        }
        boolean z = false;
        for (int size = this.f7939.size() - 1; size >= 0; size--) {
            if (this.f7939.get(size).m6029()) {
                f1 f1Var2 = this.f7939.get(size);
                if (m1.f7972.m7532().isLoggable(Level.FINE)) {
                    j1.m7071(f1Var2, this, "canceled");
                }
                this.f7939.remove(size);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final f1 m7461() {
        return this.f7938;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m7462() {
        return this.f7940;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<f1> m7463() {
        return this.f7939;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m7464() {
        return this.f7942;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m7465() {
        return this.f7937;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final m1 m7466() {
        return this.f7941;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m7467(f1 f1Var, long j) {
        C3921.m12667(f1Var, "task");
        synchronized (this.f7941) {
            if (!this.f7937) {
                if (m7468(f1Var, j, false)) {
                    this.f7941.m7527(this);
                }
                i4 i4Var = i4.f6762;
            } else if (f1Var.m6029()) {
                if (m1.f7972.m7532().isLoggable(Level.FINE)) {
                    j1.m7071(f1Var, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (m1.f7972.m7532().isLoggable(Level.FINE)) {
                    j1.m7071(f1Var, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m7468(f1 f1Var, long j, boolean z) {
        String str;
        C3921.m12667(f1Var, "task");
        f1Var.m6033(this);
        long jNanoTime = this.f7941.m7526().nanoTime();
        long j2 = jNanoTime + j;
        int iIndexOf = this.f7939.indexOf(f1Var);
        if (iIndexOf != -1) {
            if (f1Var.m6031() <= j2) {
                if (m1.f7972.m7532().isLoggable(Level.FINE)) {
                    j1.m7071(f1Var, this, "already scheduled");
                }
                return false;
            }
            this.f7939.remove(iIndexOf);
        }
        f1Var.m6035(j2);
        if (m1.f7972.m7532().isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + j1.m7070(j2 - jNanoTime);
            } else {
                str = "scheduled after " + j1.m7070(j2 - jNanoTime);
            }
            j1.m7071(f1Var, this, str);
        }
        Iterator<f1> it = this.f7939.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().m6031() - jNanoTime > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f7939.size();
        }
        this.f7939.add(size, f1Var);
        return size == 0;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m7469(f1 f1Var) {
        this.f7938 = f1Var;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m7470(boolean z) {
        this.f7940 = z;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m7471() {
        if (!i5.f6770 || !Thread.holdsLock(this)) {
            synchronized (this.f7941) {
                this.f7937 = true;
                if (m7460()) {
                    this.f7941.m7527(this);
                }
                i4 i4Var = i4.f6762;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }
}
