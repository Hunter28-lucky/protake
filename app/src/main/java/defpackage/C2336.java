package defpackage;

import java.util.concurrent.CountDownLatch;

/* compiled from: BlockingHelper.java */
/* renamed from: ī, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2336 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8747(CountDownLatch countDownLatch, InterfaceC4478 interfaceC4478) throws InterruptedException {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            m8748();
            countDownLatch.await();
        } catch (InterruptedException e2) {
            interfaceC4478.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8748() {
        if (C3671.m11792()) {
            if ((Thread.currentThread() instanceof InterfaceC4434) || C3671.m11801()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}
