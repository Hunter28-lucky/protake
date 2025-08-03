package io.reactivex.internal.schedulers;

import defpackage.InterfaceC2806;
import defpackage.InterfaceC4478;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, InterfaceC4478 {
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Object f7661 = new Object();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Object f7662 = new Object();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Object f7663 = new Object();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final Object f7664 = new Object();
    public final Runnable actual;

    public ScheduledRunnable(Runnable runnable, InterfaceC2806 interfaceC2806) {
        super(3);
        this.actual = runnable;
        lazySet(0, interfaceC2806);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f7664 || obj5 == (obj3 = f7662) || obj5 == (obj4 = f7663)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f7664 || obj == (obj2 = f7661) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((InterfaceC2806) obj).mo9335(this);
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == f7661 || obj == f7664;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != f7661) {
                    ((InterfaceC2806) obj4).mo9335(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != f7662) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj5, f7664));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != f7661 && compareAndSet(0, obj4, f7664) && obj4 != null) {
            ((InterfaceC2806) obj4).mo9335(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != f7662 || obj5 == f7663) {
                return;
            }
        } while (!compareAndSet(1, obj5, f7664));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m6994(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f7664) {
                return;
            }
            if (obj == f7662) {
                future.cancel(false);
                return;
            } else if (obj == f7663) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
