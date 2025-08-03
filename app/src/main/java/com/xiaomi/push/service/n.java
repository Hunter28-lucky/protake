package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public class n {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: a, reason: collision with other field name */
    private final a f6461a;

    /* renamed from: a, reason: collision with other field name */
    private final c f6462a;

    public static final class a {
        private final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public void finalize() throws Throwable {
            try {
                synchronized (this.a) {
                    this.a.c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {
        public int a;

        public b(int i) {
            this.a = i;
        }
    }

    public static final class c extends Thread {

        /* renamed from: b, reason: collision with other field name */
        private boolean f6465b;
        private boolean c;
        private volatile long a = 0;

        /* renamed from: a, reason: collision with other field name */
        private volatile boolean f6464a = false;
        private long b = 50;

        /* renamed from: a, reason: collision with other field name */
        private a f6463a = new a();

        public static final class a {
            private int a;

            /* renamed from: a, reason: collision with other field name */
            private d[] f6466a;
            private int b;
            private int c;

            private a() {
                this.a = 256;
                this.f6466a = new d[256];
                this.b = 0;
                this.c = 0;
            }

            private void c() {
                int i = this.b - 1;
                int i2 = (i - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f6466a;
                    d dVar = dVarArr[i];
                    long j = dVar.f6467a;
                    d dVar2 = dVarArr[i2];
                    if (j >= dVar2.f6467a) {
                        return;
                    }
                    dVarArr[i] = dVar2;
                    dVarArr[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public void b(int i) {
                int i2;
                if (i < 0 || i >= (i2 = this.b)) {
                    return;
                }
                d[] dVarArr = this.f6466a;
                int i3 = i2 - 1;
                this.b = i3;
                dVarArr[i] = dVarArr[i3];
                dVarArr[i3] = null;
                c(i);
            }

            public d a() {
                return this.f6466a[0];
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m5804a() {
                return this.b == 0;
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m5803a(d dVar) {
                d[] dVarArr = this.f6466a;
                int length = dVarArr.length;
                int i = this.b;
                if (length == i) {
                    d[] dVarArr2 = new d[i * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i);
                    this.f6466a = dVarArr2;
                }
                d[] dVarArr3 = this.f6466a;
                int i2 = this.b;
                this.b = i2 + 1;
                dVarArr3[i2] = dVar;
                c();
            }

            public void b() {
                int i = 0;
                while (i < this.b) {
                    if (this.f6466a[i].f6470a) {
                        this.c++;
                        b(i);
                        i--;
                    }
                    i++;
                }
            }

            private void c(int i) {
                int i2 = (i * 2) + 1;
                while (true) {
                    int i3 = this.b;
                    if (i2 >= i3 || i3 <= 0) {
                        return;
                    }
                    int i4 = i2 + 1;
                    if (i4 < i3) {
                        d[] dVarArr = this.f6466a;
                        if (dVarArr[i4].f6467a < dVarArr[i2].f6467a) {
                            i2 = i4;
                        }
                    }
                    d[] dVarArr2 = this.f6466a;
                    d dVar = dVarArr2[i];
                    long j = dVar.f6467a;
                    d dVar2 = dVarArr2[i2];
                    if (j < dVar2.f6467a) {
                        return;
                    }
                    dVarArr2[i] = dVar2;
                    dVarArr2[i2] = dVar;
                    int i5 = i2;
                    i2 = (i2 * 2) + 1;
                    i = i5;
                }
            }

            /* renamed from: a, reason: collision with other method in class */
            public boolean m5805a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (this.f6466a[i2].a == i) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f6466a[i2];
                    if (dVar.a == i) {
                        dVar.a();
                    }
                }
                b();
            }

            public void a(int i, b bVar) {
                for (int i2 = 0; i2 < this.b; i2++) {
                    d dVar = this.f6466a[i2];
                    if (dVar.f6468a == bVar) {
                        dVar.a();
                    }
                }
                b();
            }

            /* renamed from: a, reason: collision with other method in class */
            public void m5802a() {
                this.f6466a = new d[this.a];
                this.b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i = 0;
                while (true) {
                    d[] dVarArr = this.f6466a;
                    if (i >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i] == dVar) {
                        return i;
                    }
                    i++;
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
        
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f6464a = true;
            r2.f6468a.run();
            r10.f6464a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
        
            r10.f6465b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a8, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 181
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f6463a.m5803a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f6465b = true;
            this.f6463a.m5802a();
            notify();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5801a() {
            return this.f6464a && SystemClock.uptimeMillis() - this.a > 600000;
        }
    }

    static {
        long jElapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = jElapsedRealtime;
        b = jElapsedRealtime;
    }

    public n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        c cVar = new c(str, z);
        this.f6462a = cVar;
        this.f6461a = new a(cVar);
    }

    public static synchronized long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = b;
        if (jElapsedRealtime > j) {
            a += jElapsedRealtime - j;
        }
        b = jElapsedRealtime;
        return a;
    }

    private static synchronized long b() {
        long j;
        j = c;
        c = 1 + j;
        return j;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5799b() {
        synchronized (this.f6462a) {
            this.f6462a.f6463a.m5802a();
        }
    }

    public static class d {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public long f6467a;

        /* renamed from: a, reason: collision with other field name */
        public b f6468a;

        /* renamed from: a, reason: collision with other field name */
        public final Object f6469a = new Object();

        /* renamed from: a, reason: collision with other field name */
        public boolean f6470a;
        private long b;

        public void a(long j) {
            synchronized (this.f6469a) {
                this.b = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f6469a) {
                z = !this.f6470a && this.f6467a > 0;
                this.f6470a = true;
            }
            return z;
        }
    }

    public n(String str) {
        this(str, false);
    }

    private void b(b bVar, long j) {
        synchronized (this.f6462a) {
            if (!this.f6462a.f6465b) {
                long jA = j + a();
                if (jA >= 0) {
                    d dVar = new d();
                    dVar.a = bVar.a;
                    dVar.f6468a = bVar;
                    dVar.f6467a = jA;
                    this.f6462a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5796a() {
        com.xiaomi.channel.commonutils.logger.b.m5113a("quit. finalizer:" + this.f6461a);
        this.f6462a.a();
    }

    public n() {
        this(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5798a(int i) {
        boolean zM5805a;
        synchronized (this.f6462a) {
            zM5805a = this.f6462a.f6463a.m5805a(i);
        }
        return zM5805a;
    }

    public void a(int i) {
        synchronized (this.f6462a) {
            this.f6462a.f6463a.a(i);
        }
    }

    public void a(int i, b bVar) {
        synchronized (this.f6462a) {
            this.f6462a.f6463a.a(i, bVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5797a() {
        return this.f6462a.m5801a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f6462a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j) {
        if (j >= 0) {
            b(bVar, j);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j);
    }
}
