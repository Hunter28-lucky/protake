package defpackage;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: TaskRunner.kt */
/* loaded from: classes2.dex */
public final class m1 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Logger f7971;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f7973;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f7974;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f7975;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<l1> f7976;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<l1> f7977;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Runnable f7978;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2172 f7979;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C2173 f7972 = new C2173(null);

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final m1 f7970 = new m1(new C2174(i5.m6266(i5.f6771 + " TaskRunner", true)));

    /* compiled from: TaskRunner.kt */
    /* renamed from: m1$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2172 {
        void execute(Runnable runnable);

        long nanoTime();

        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo7530(m1 m1Var);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo7531(m1 m1Var, long j);
    }

    /* compiled from: TaskRunner.kt */
    /* renamed from: m1$Ԩ, reason: contains not printable characters */
    public static final class C2173 {
        public C2173() {
        }

        public /* synthetic */ C2173(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Logger m7532() {
            return m1.f7971;
        }
    }

    /* compiled from: TaskRunner.kt */
    /* renamed from: m1$Ԫ, reason: contains not printable characters */
    public static final class C2174 implements InterfaceC2172 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ThreadPoolExecutor f7980;

        public C2174(ThreadFactory threadFactory) {
            C3921.m12667(threadFactory, "threadFactory");
            this.f7980 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // defpackage.m1.InterfaceC2172
        public void execute(Runnable runnable) {
            C3921.m12667(runnable, "runnable");
            this.f7980.execute(runnable);
        }

        @Override // defpackage.m1.InterfaceC2172
        public long nanoTime() {
            return System.nanoTime();
        }

        @Override // defpackage.m1.InterfaceC2172
        /* renamed from: Ϳ */
        public void mo7530(m1 m1Var) {
            C3921.m12667(m1Var, "taskRunner");
            m1Var.notify();
        }

        @Override // defpackage.m1.InterfaceC2172
        /* renamed from: Ԩ */
        public void mo7531(m1 m1Var, long j) throws InterruptedException {
            C3921.m12667(m1Var, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                m1Var.wait(j2, (int) j3);
            }
        }
    }

    /* compiled from: TaskRunner.kt */
    /* renamed from: m1$Ԭ, reason: contains not printable characters */
    public static final class RunnableC2175 implements Runnable {
        public RunnableC2175() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f1 f1VarM7523;
            while (true) {
                synchronized (m1.this) {
                    f1VarM7523 = m1.this.m7523();
                }
                if (f1VarM7523 == null) {
                    return;
                }
                l1 l1VarM6032 = f1VarM7523.m6032();
                if (l1VarM6032 == null) {
                    C3921.m12675();
                }
                long jNanoTime = -1;
                boolean zIsLoggable = m1.f7972.m7532().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jNanoTime = l1VarM6032.m7466().m7526().nanoTime();
                    j1.m7071(f1VarM7523, l1VarM6032, "starting");
                }
                try {
                    try {
                        m1.this.m7529(f1VarM7523);
                        i4 i4Var = i4.f6762;
                        if (zIsLoggable) {
                            j1.m7071(f1VarM7523, l1VarM6032, "finished run in " + j1.m7070(l1VarM6032.m7466().m7526().nanoTime() - jNanoTime));
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        j1.m7071(f1VarM7523, l1VarM6032, "failed a run in " + j1.m7070(l1VarM6032.m7466().m7526().nanoTime() - jNanoTime));
                    }
                    throw th;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(m1.class.getName());
        C3921.m12663(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f7971 = logger;
    }

    public m1(InterfaceC2172 interfaceC2172) {
        C3921.m12667(interfaceC2172, "backend");
        this.f7979 = interfaceC2172;
        this.f7973 = ModuleDescriptor.MODULE_VERSION;
        this.f7976 = new ArrayList();
        this.f7977 = new ArrayList();
        this.f7978 = new RunnableC2175();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m7522(f1 f1Var, long j) {
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        l1 l1VarM6032 = f1Var.m6032();
        if (l1VarM6032 == null) {
            C3921.m12675();
        }
        if (!(l1VarM6032.m7461() == f1Var)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zM7462 = l1VarM6032.m7462();
        l1VarM6032.m7470(false);
        l1VarM6032.m7469(null);
        this.f7976.remove(l1VarM6032);
        if (j != -1 && !zM7462 && !l1VarM6032.m7465()) {
            l1VarM6032.m7468(f1Var, j, true);
        }
        if (!l1VarM6032.m7463().isEmpty()) {
            this.f7977.add(l1VarM6032);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final f1 m7523() {
        boolean z;
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        while (!this.f7977.isEmpty()) {
            long jNanoTime = this.f7979.nanoTime();
            long jMin = Long.MAX_VALUE;
            Iterator<l1> it = this.f7977.iterator();
            f1 f1Var = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                f1 f1Var2 = it.next().m7463().get(0);
                long jMax = Math.max(0L, f1Var2.m6031() - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (f1Var != null) {
                        z = true;
                        break;
                    }
                    f1Var = f1Var2;
                }
            }
            if (f1Var != null) {
                m7524(f1Var);
                if (z || (!this.f7974 && (!this.f7977.isEmpty()))) {
                    this.f7979.execute(this.f7978);
                }
                return f1Var;
            }
            if (this.f7974) {
                if (jMin < this.f7975 - jNanoTime) {
                    this.f7979.mo7530(this);
                }
                return null;
            }
            this.f7974 = true;
            this.f7975 = jNanoTime + jMin;
            try {
                try {
                    this.f7979.mo7531(this, jMin);
                } catch (InterruptedException unused) {
                    m7525();
                }
            } finally {
                this.f7974 = false;
            }
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m7524(f1 f1Var) {
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        f1Var.m6035(-1L);
        l1 l1VarM6032 = f1Var.m6032();
        if (l1VarM6032 == null) {
            C3921.m12675();
        }
        l1VarM6032.m7463().remove(f1Var);
        this.f7977.remove(l1VarM6032);
        l1VarM6032.m7469(f1Var);
        this.f7976.add(l1VarM6032);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m7525() {
        for (int size = this.f7976.size() - 1; size >= 0; size--) {
            this.f7976.get(size).m7460();
        }
        for (int size2 = this.f7977.size() - 1; size2 >= 0; size2--) {
            l1 l1Var = this.f7977.get(size2);
            l1Var.m7460();
            if (l1Var.m7463().isEmpty()) {
                this.f7977.remove(size2);
            }
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2172 m7526() {
        return this.f7979;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m7527(l1 l1Var) {
        C3921.m12667(l1Var, "taskQueue");
        if (i5.f6770 && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (l1Var.m7461() == null) {
            if (!l1Var.m7463().isEmpty()) {
                i5.m6231(this.f7977, l1Var);
            } else {
                this.f7977.remove(l1Var);
            }
        }
        if (this.f7974) {
            this.f7979.mo7530(this);
        } else {
            this.f7979.execute(this.f7978);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final l1 m7528() {
        int i;
        synchronized (this) {
            i = this.f7973;
            this.f7973 = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new l1(this, sb.toString());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m7529(f1 f1Var) {
        if (i5.f6770 && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            C3921.m12663(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        C3921.m12663(threadCurrentThread2, "currentThread");
        String name = threadCurrentThread2.getName();
        threadCurrentThread2.setName(f1Var.m6030());
        try {
            long jMo6034 = f1Var.mo6034();
            synchronized (this) {
                m7522(f1Var, jMo6034);
                i4 i4Var = i4.f6762;
            }
            threadCurrentThread2.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                m7522(f1Var, -1L);
                i4 i4Var2 = i4.f6762;
                threadCurrentThread2.setName(name);
                throw th;
            }
        }
    }
}
