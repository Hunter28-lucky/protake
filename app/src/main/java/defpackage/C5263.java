package defpackage;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: QueueDrainHelper.java */
/* renamed from: თ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5263 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U> boolean m15302(boolean z, boolean z2, InterfaceC5102<?> interfaceC5102, boolean z3, InterfaceC4851<?> interfaceC4851, InterfaceC4478 interfaceC4478, InterfaceC3556<T, U> interfaceC3556) {
        if (interfaceC3556.mo11500()) {
            interfaceC4851.clear();
            interfaceC4478.dispose();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            Throwable thMo11501 = interfaceC3556.mo11501();
            if (thMo11501 != null) {
                interfaceC5102.onError(thMo11501);
            } else {
                interfaceC5102.onComplete();
            }
            return true;
        }
        Throwable thMo115012 = interfaceC3556.mo11501();
        if (thMo115012 != null) {
            interfaceC4851.clear();
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            interfaceC5102.onError(thMo115012);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
        }
        interfaceC5102.onComplete();
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, U> boolean m15303(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, InterfaceC4851<?> interfaceC4851, InterfaceC2541<T, U> interfaceC2541) {
        if (interfaceC2541.mo9361()) {
            interfaceC4851.clear();
            return true;
        }
        if (!z) {
            return false;
        }
        if (z3) {
            if (!z2) {
                return false;
            }
            Throwable thMo9362 = interfaceC2541.mo9362();
            if (thMo9362 != null) {
                subscriber.onError(thMo9362);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        Throwable thMo93622 = interfaceC2541.mo9362();
        if (thMo93622 != null) {
            interfaceC4851.clear();
            subscriber.onError(thMo93622);
            return true;
        }
        if (!z2) {
            return false;
        }
        subscriber.onComplete();
        return true;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> InterfaceC4851<T> m15304(int i) {
        return i < 0 ? new d(-i) : new SpscArrayQueue(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r1 = r15.mo11502(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        return;
     */
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void m15305(defpackage.InterfaceC2475<T> r11, defpackage.InterfaceC5102<? super U> r12, boolean r13, defpackage.InterfaceC4478 r14, defpackage.InterfaceC3556<T, U> r15) {
        /*
            r0 = 1
            r1 = r0
        L2:
            boolean r2 = r15.mo11499()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = m15302(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.mo11499()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = r0
            goto L24
        L22:
            r4 = 0
            r10 = r4
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = m15302(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.mo11502(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.mo10684(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C5263.m15305(ǅ, ဏ, boolean, ப, ڢ):void");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T, U> void m15306(InterfaceC2475<T> interfaceC2475, Subscriber<? super U> subscriber, boolean z, InterfaceC4478 interfaceC4478, InterfaceC2541<T, U> interfaceC2541) {
        int iMo9363 = 1;
        while (true) {
            boolean zMo9360 = interfaceC2541.mo9360();
            T tPoll = interfaceC2475.poll();
            boolean z2 = tPoll == null;
            if (m15303(zMo9360, z2, subscriber, z, interfaceC2475, interfaceC2541)) {
                if (interfaceC4478 != null) {
                    interfaceC4478.dispose();
                    return;
                }
                return;
            } else if (z2) {
                iMo9363 = interfaceC2541.mo9363(-iMo9363);
                if (iMo9363 == 0) {
                    return;
                }
            } else {
                long jMo9364 = interfaceC2541.mo9364();
                if (jMo9364 == 0) {
                    interfaceC2475.clear();
                    if (interfaceC4478 != null) {
                        interfaceC4478.dispose();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
                if (interfaceC2541.mo9365(subscriber, tPoll) && jMo9364 != Long.MAX_VALUE) {
                    interfaceC2541.mo9366(1L);
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m15307(InterfaceC2881 interfaceC2881) {
        try {
            return interfaceC2881.mo6378();
        } catch (Throwable th) {
            C4089.m13026(th);
            return true;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static <T> void m15308(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, InterfaceC2881 interfaceC2881) {
        long j;
        long j2;
        if (queue.isEmpty()) {
            subscriber.onComplete();
            return;
        }
        if (m15309(atomicLong.get(), subscriber, queue, atomicLong, interfaceC2881)) {
            return;
        }
        do {
            j = atomicLong.get();
            if ((j & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j2 = j | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j, j2));
        if (j != 0) {
            m15309(j2, subscriber, queue, atomicLong, interfaceC2881);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> boolean m15309(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, InterfaceC2881 interfaceC2881) {
        long j2 = j & Long.MIN_VALUE;
        while (true) {
            if (j2 != j) {
                if (m15307(interfaceC2881)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(tPoll);
                j2++;
            } else {
                if (m15307(interfaceC2881)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j = atomicLong.get();
                if (j == j2) {
                    long jAddAndGet = atomicLong.addAndGet(-(j2 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j = jAddAndGet;
                    j2 = jAddAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> boolean m15310(long j, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, InterfaceC2881 interfaceC2881) {
        long j2;
        do {
            j2 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j2, C5153.m15071(Long.MAX_VALUE & j2, j) | (j2 & Long.MIN_VALUE)));
        if (j2 != Long.MIN_VALUE) {
            return false;
        }
        m15309(j | Long.MIN_VALUE, subscriber, queue, atomicLong, interfaceC2881);
        return true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m15311(Subscription subscription, int i) {
        subscription.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
