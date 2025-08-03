package io.reactivex.internal.subscriptions;

import defpackage.C4246;
import defpackage.C5153;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;
    public Subscription actual;
    public final boolean cancelOnReplace;
    public volatile boolean cancelled;
    public long requested;
    public boolean unbounded;
    public final AtomicReference<Subscription> missedSubscription = new AtomicReference<>();
    public final AtomicLong missedRequested = new AtomicLong();
    public final AtomicLong missedProduced = new AtomicLong();

    public SubscriptionArbiter(boolean z) {
        this.cancelOnReplace = z;
    }

    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        m7010();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            C5153.m15069(this.missedRequested, j);
            m7010();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long jM15071 = C5153.m15071(j2, j);
            this.requested = jM15071;
            if (jM15071 == Long.MAX_VALUE) {
                this.unbounded = true;
            }
        }
        Subscription subscription = this.actual;
        if (decrementAndGet() != 0) {
            m7011();
        }
        if (subscription != null) {
            subscription.request(j);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    final void m7010() {
        if (getAndIncrement() != 0) {
            return;
        }
        m7011();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    final void m7011() {
        int iAddAndGet = 1;
        Subscription subscription = null;
        long jM15071 = 0;
        do {
            Subscription andSet = this.missedSubscription.get();
            if (andSet != null) {
                andSet = this.missedSubscription.getAndSet(null);
            }
            long andSet2 = this.missedRequested.get();
            if (andSet2 != 0) {
                andSet2 = this.missedRequested.getAndSet(0L);
            }
            long andSet3 = this.missedProduced.get();
            if (andSet3 != 0) {
                andSet3 = this.missedProduced.getAndSet(0L);
            }
            Subscription subscription2 = this.actual;
            if (this.cancelled) {
                if (subscription2 != null) {
                    subscription2.cancel();
                    this.actual = null;
                }
                if (andSet != null) {
                    andSet.cancel();
                }
            } else {
                long jM150712 = this.requested;
                if (jM150712 != Long.MAX_VALUE) {
                    jM150712 = C5153.m15071(jM150712, andSet2);
                    if (jM150712 != Long.MAX_VALUE) {
                        jM150712 -= andSet3;
                        if (jM150712 < 0) {
                            SubscriptionHelper.reportMoreProduced(jM150712);
                            jM150712 = 0;
                        }
                    }
                    this.requested = jM150712;
                }
                if (andSet != null) {
                    if (subscription2 != null && this.cancelOnReplace) {
                        subscription2.cancel();
                    }
                    this.actual = andSet;
                    if (jM150712 != 0) {
                        jM15071 = C5153.m15071(jM15071, jM150712);
                        subscription = andSet;
                    }
                } else if (subscription2 != null && andSet2 != 0) {
                    jM15071 = C5153.m15071(jM15071, andSet2);
                    subscription = subscription2;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jM15071 != 0) {
            subscription.request(jM15071);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean m7012() {
        return this.cancelled;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m7013() {
        return this.unbounded;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m7014(long j) {
        if (this.unbounded) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            C5153.m15069(this.missedProduced, j);
            m7010();
            return;
        }
        long j2 = this.requested;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                SubscriptionHelper.reportMoreProduced(j3);
                j3 = 0;
            }
            this.requested = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        m7011();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m7015(Subscription subscription) {
        if (this.cancelled) {
            subscription.cancel();
            return;
        }
        C4246.m13353(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.missedSubscription.getAndSet(subscription);
            if (andSet != null && this.cancelOnReplace) {
                andSet.cancel();
            }
            m7010();
            return;
        }
        Subscription subscription2 = this.actual;
        if (subscription2 != null && this.cancelOnReplace) {
            subscription2.cancel();
        }
        this.actual = subscription;
        long j = this.requested;
        if (decrementAndGet() != 0) {
            m7011();
        }
        if (j != 0) {
            subscription.request(j);
        }
    }
}
