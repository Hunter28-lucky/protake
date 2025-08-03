package kotlinx.coroutines;

import defpackage.AbstractC2333;
import defpackage.C3782;
import defpackage.C4542;
import defpackage.e2;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: DefaultExecutor.kt */
/* renamed from: kotlinx.coroutines.Ԩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class RunnableC2161 extends AbstractC2162 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final RunnableC2161 f7926;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final long f7927;

    static {
        Long l;
        RunnableC2161 runnableC2161 = new RunnableC2161();
        f7926 = runnableC2161;
        AbstractC2333.m8738(runnableC2161, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f7927 = timeUnit.toNanos(l.longValue());
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zM7446;
        e2.f6600.m5987(this);
        C3782.m12100();
        try {
            if (!m7438()) {
                if (zM7446) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jM7447 = m7447();
                if (jM7447 == Long.MAX_VALUE) {
                    C3782.m12100();
                    long jNanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = f7927 + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        m7435();
                        C3782.m12100();
                        if (m7446()) {
                            return;
                        }
                        mo7434();
                        return;
                    }
                    jM7447 = C4542.m13946(jM7447, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jM7447 > 0) {
                    if (m7437()) {
                        _thread = null;
                        m7435();
                        C3782.m12100();
                        if (m7446()) {
                            return;
                        }
                        mo7434();
                        return;
                    }
                    C3782.m12100();
                    LockSupport.parkNanos(this, jM7447);
                }
            }
        } finally {
            _thread = null;
            m7435();
            C3782.m12100();
            if (!m7446()) {
                mo7434();
            }
        }
    }

    @Override // defpackage.AbstractC3077
    /* renamed from: ކ, reason: contains not printable characters */
    public Thread mo7434() {
        Thread thread = _thread;
        return thread == null ? m7436() : thread;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final synchronized void m7435() {
        if (m7437()) {
            debugStatus = 3;
            m7449();
            notifyAll();
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final synchronized Thread m7436() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final boolean m7437() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final synchronized boolean m7438() {
        if (m7437()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }
}
