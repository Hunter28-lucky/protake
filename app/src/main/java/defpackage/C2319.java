package defpackage;

import androidx.core.app.NotificationCompat;
import defpackage.C2503;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Dispatcher.kt */
/* renamed from: č, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2319 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public Runnable f8816;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ExecutorService f8817;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8814 = 64;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f8815 = 5;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final ArrayDeque<C2503.RunnableC2504> f8818 = new ArrayDeque<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final ArrayDeque<C2503.RunnableC2504> f8819 = new ArrayDeque<>();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final ArrayDeque<C2503> f8820 = new ArrayDeque<>();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m8713(C2503.RunnableC2504 runnableC2504) {
        C2503.RunnableC2504 runnableC2504M8716;
        C3921.m12667(runnableC2504, NotificationCompat.CATEGORY_CALL);
        synchronized (this) {
            this.f8818.add(runnableC2504);
            if (!runnableC2504.m9251().m9236() && (runnableC2504M8716 = m8716(runnableC2504.m9253())) != null) {
                runnableC2504.m9254(runnableC2504M8716);
            }
            i4 i4Var = i4.f6762;
        }
        m8720();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized void m8714(C2503 c2503) {
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        this.f8820.add(c2503);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final synchronized ExecutorService m8715() {
        ExecutorService executorService;
        if (this.f8817 == null) {
            this.f8817 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), i5.m6266(i5.f6771 + " Dispatcher", false));
        }
        executorService = this.f8817;
        if (executorService == null) {
            C3921.m12675();
        }
        return executorService;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2503.RunnableC2504 m8716(String str) {
        Iterator<C2503.RunnableC2504> it = this.f8819.iterator();
        while (it.hasNext()) {
            C2503.RunnableC2504 next = it.next();
            if (C3921.m12662(next.m9253(), str)) {
                return next;
            }
        }
        Iterator<C2503.RunnableC2504> it2 = this.f8818.iterator();
        while (it2.hasNext()) {
            C2503.RunnableC2504 next2 = it2.next();
            if (C3921.m12662(next2.m9253(), str)) {
                return next2;
            }
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final <T> void m8717(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f8816;
            i4 i4Var = i4.f6762;
        }
        if (m8720() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m8718(C2503.RunnableC2504 runnableC2504) {
        C3921.m12667(runnableC2504, NotificationCompat.CATEGORY_CALL);
        runnableC2504.m9252().decrementAndGet();
        m8717(this.f8819, runnableC2504);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m8719(C2503 c2503) {
        C3921.m12667(c2503, NotificationCompat.CATEGORY_CALL);
        m8717(this.f8820, c2503);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m8720() {
        int i;
        boolean z;
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
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<C2503.RunnableC2504> it = this.f8818.iterator();
            C3921.m12663(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                C2503.RunnableC2504 next = it.next();
                if (this.f8819.size() >= this.f8814) {
                    break;
                }
                if (next.m9252().get() < this.f8815) {
                    it.remove();
                    next.m9252().incrementAndGet();
                    C3921.m12663(next, "asyncCall");
                    arrayList.add(next);
                    this.f8819.add(next);
                }
            }
            z = m8721() > 0;
            i4 i4Var = i4.f6762;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((C2503.RunnableC2504) arrayList.get(i)).m9250(m8715());
        }
        return z;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final synchronized int m8721() {
        return this.f8819.size() + this.f8820.size();
    }
}
