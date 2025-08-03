package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.C2503;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnection;

/* compiled from: RealConnectionPool.kt */
/* renamed from: ϼ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2861 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2862 f10489 = new C2862(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final long f10490;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final l1 f10491;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2863 f10492;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final ConcurrentLinkedQueue<RealConnection> f10493;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f10494;

    /* compiled from: RealConnectionPool.kt */
    /* renamed from: ϼ$Ϳ, reason: contains not printable characters */
    public static final class C2862 {
        public C2862() {
        }

        public /* synthetic */ C2862(C4184 c4184) {
            this();
        }
    }

    /* compiled from: RealConnectionPool.kt */
    /* renamed from: ϼ$Ԩ, reason: contains not printable characters */
    public static final class C2863 extends f1 {
        public C2863(String str) {
            super(str, false, 2, null);
        }

        @Override // defpackage.f1
        /* renamed from: Ԭ */
        public long mo6034() {
            return C2861.this.m10199(System.nanoTime());
        }
    }

    public C2861(m1 m1Var, int i, long j, TimeUnit timeUnit) {
        C3921.m12667(m1Var, "taskRunner");
        C3921.m12667(timeUnit, "timeUnit");
        this.f10494 = i;
        this.f10490 = timeUnit.toNanos(j);
        this.f10491 = m1Var.m7528();
        this.f10492 = new C2863(i5.f6771 + " ConnectionPool");
        this.f10493 = new ConcurrentLinkedQueue<>();
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m10198(C3972 c3972, C2503 c2503, List<C4799> list, boolean z) {
        C3921.m12667(c3972, "address");
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> it = this.f10493.iterator();
        while (it.hasNext()) {
            RealConnection next = it.next();
            C3921.m12663(next, "connection");
            synchronized (next) {
                if (z) {
                    if (!next.m7819()) {
                    }
                    i4 i4Var = i4.f6762;
                }
                if (next.m7817(c3972, list)) {
                    c2503.m9225(next);
                    return true;
                }
                i4 i4Var2 = i4.f6762;
            }
        }
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final long m10199(long j) throws IOException {
        Iterator<RealConnection> it = this.f10493.iterator();
        int i = 0;
        long j2 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i2 = 0;
        while (it.hasNext()) {
            RealConnection next = it.next();
            C3921.m12663(next, "connection");
            synchronized (next) {
                if (m10201(next, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long jM7812 = j - next.m7812();
                    if (jM7812 > j2) {
                        i4 i4Var = i4.f6762;
                        realConnection = next;
                        j2 = jM7812;
                    } else {
                        i4 i4Var2 = i4.f6762;
                    }
                }
            }
        }
        long j3 = this.f10490;
        if (j2 < j3 && i <= this.f10494) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        if (realConnection == null) {
            C3921.m12675();
        }
        synchronized (realConnection) {
            if (!realConnection.m7811().isEmpty()) {
                return 0L;
            }
            if (realConnection.m7812() + j2 != j) {
                return 0L;
            }
            realConnection.m7826(true);
            this.f10493.remove(realConnection);
            i5.m6241(realConnection.m7827());
            if (this.f10493.isEmpty()) {
                this.f10491.m7459();
            }
            return 0L;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m10200(RealConnection realConnection) {
        C3921.m12667(realConnection, "connection");
        if (i5.f6770 && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        if (!realConnection.m7813() && this.f10494 != 0) {
            l1.m7458(this.f10491, this.f10492, 0L, 2, null);
            return false;
        }
        realConnection.m7826(true);
        this.f10493.remove(realConnection);
        if (!this.f10493.isEmpty()) {
            return true;
        }
        this.f10491.m7459();
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m10201(RealConnection realConnection, long j) {
        if (i5.f6770 && !Thread.holdsLock(realConnection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnection);
            throw new AssertionError(sb.toString());
        }
        List<Reference<C2503>> listM7811 = realConnection.m7811();
        int i = 0;
        while (i < listM7811.size()) {
            Reference<C2503> reference = listM7811.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C2708.f10025.m9964().mo9956("A connection to " + realConnection.m7823().m14511().m12820() + " was leaked. Did you forget to close a response body?", ((C2503.C2505) reference).m9255());
                listM7811.remove(i);
                realConnection.m7826(true);
                if (listM7811.isEmpty()) {
                    realConnection.m7825(j - this.f10490);
                    return 0;
                }
            }
        }
        return listM7811.size();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m10202(RealConnection realConnection) {
        C3921.m12667(realConnection, "connection");
        if (!i5.f6770 || Thread.holdsLock(realConnection)) {
            this.f10493.add(realConnection);
            l1.m7458(this.f10491, this.f10492, 0L, 2, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnection);
        throw new AssertionError(sb.toString());
    }
}
