package io.reactivex.internal.subscribers;

import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Subscription {
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Object f7674 = new Object();
    public final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(f7674);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        get().request(j);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m7001() {
        return get() == SubscriptionHelper.CANCELLED;
    }
}
