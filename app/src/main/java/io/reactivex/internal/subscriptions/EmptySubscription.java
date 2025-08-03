package io.reactivex.internal.subscriptions;

import defpackage.InterfaceC2968;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public enum EmptySubscription implements InterfaceC2968<Object> {
    INSTANCE;

    public static void complete(Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onComplete();
    }

    public static void error(Throwable th, Subscriber<?> subscriber) {
        subscriber.onSubscribe(INSTANCE);
        subscriber.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // defpackage.InterfaceC4851
    public void clear() {
    }

    @Override // defpackage.InterfaceC4851
    public boolean isEmpty() {
        return true;
    }

    @Override // defpackage.InterfaceC4851
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.InterfaceC4851
    public Object poll() {
        return null;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // defpackage.InterfaceC3460
    /* renamed from: ԩ */
    public int mo6310(int i) {
        return i & 2;
    }
}
