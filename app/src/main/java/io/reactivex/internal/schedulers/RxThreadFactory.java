package io.reactivex.internal.schedulers;

import defpackage.InterfaceC4434;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    /* renamed from: io.reactivex.internal.schedulers.RxThreadFactory$Ϳ, reason: contains not printable characters */
    public static final class C2115 extends Thread implements InterfaceC4434 {
        public C2115(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.prefix + '-' + incrementAndGet();
        Thread c2115 = this.nonBlocking ? new C2115(runnable, str) : new Thread(runnable, str);
        c2115.setPriority(this.priority);
        c2115.setDaemon(true);
        return c2115;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public RxThreadFactory(String str, int i) {
        this(str, i, false);
    }

    public RxThreadFactory(String str, int i, boolean z) {
        this.prefix = str;
        this.priority = i;
        this.nonBlocking = z;
    }
}
