package io.reactivex.internal.subscriptions;

import defpackage.C3671;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
            return;
        }
        if (validate(j)) {
            C5153.m15069(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        subscription.request(andSet);
        return true;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!C4905.m14631(atomicReference, subscription2, subscription));
        return true;
    }

    public static void reportMoreProduced(long j) {
        C3671.m11803(new ProtocolViolationException("More produced than requested: " + j));
    }

    public static void reportSubscriptionSet() {
        C3671.m11803(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!C4905.m14631(atomicReference, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        C4246.m13353(subscription, "s is null");
        if (C4905.m14631(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        reportSubscriptionSet();
        return false;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            C3671.m11803(new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        C3671.m11803(new IllegalArgumentException("n > 0 required but it was " + j));
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long j) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j);
        return true;
    }
}
