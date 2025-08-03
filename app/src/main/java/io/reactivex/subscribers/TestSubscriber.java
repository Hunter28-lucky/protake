package io.reactivex.subscribers;

import defpackage.AbstractC5174;
import defpackage.C4905;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public class TestSubscriber<T> extends AbstractC5174<T, TestSubscriber<T>> implements InterfaceC3899<T>, Subscription {

    /* renamed from: ׯ, reason: contains not printable characters */
    public final Subscriber<? super T> f7722;

    /* renamed from: ؠ, reason: contains not printable characters */
    public volatile boolean f7723;

    /* renamed from: ހ, reason: contains not printable characters */
    public final AtomicReference<Subscription> f7724;

    /* renamed from: ށ, reason: contains not printable characters */
    public final AtomicLong f7725;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC2968<T> f7726;

    public enum EmptySubscriber implements InterfaceC3899<Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f7723) {
            return;
        }
        this.f7723 = true;
        SubscriptionHelper.cancel(this.f7724);
    }

    @Override // defpackage.InterfaceC4478
    public final void dispose() {
        cancel();
    }

    @Override // defpackage.InterfaceC4478
    public final boolean isDisposed() {
        return this.f7723;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7724.get() == null) {
                this.f17127.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17129 = Thread.currentThread();
            this.f17128++;
            this.f7722.onComplete();
        } finally {
            this.f17125.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7724.get() == null) {
                this.f17127.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17129 = Thread.currentThread();
            this.f17127.add(th);
            if (th == null) {
                this.f17127.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f7722.onError(th);
        } finally {
            this.f17125.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (!this.f17130) {
            this.f17130 = true;
            if (this.f7724.get() == null) {
                this.f17127.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f17129 = Thread.currentThread();
        if (this.f17132 != 2) {
            this.f17126.add(t);
            if (t == null) {
                this.f17127.add(new NullPointerException("onNext received a null value"));
            }
            this.f7722.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f7726.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f17126.add(tPoll);
                }
            } catch (Throwable th) {
                this.f17127.add(th);
                this.f7726.cancel();
                return;
            }
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        this.f17129 = Thread.currentThread();
        if (subscription == null) {
            this.f17127.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!C4905.m14631(this.f7724, null, subscription)) {
            subscription.cancel();
            if (this.f7724.get() != SubscriptionHelper.CANCELLED) {
                this.f17127.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                return;
            }
            return;
        }
        int i = this.f17131;
        if (i != 0 && (subscription instanceof InterfaceC2968)) {
            InterfaceC2968<T> interfaceC2968 = (InterfaceC2968) subscription;
            this.f7726 = interfaceC2968;
            int iMo6310 = interfaceC2968.mo6310(i);
            this.f17132 = iMo6310;
            if (iMo6310 == 1) {
                this.f17130 = true;
                this.f17129 = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f7726.poll();
                        if (tPoll == null) {
                            this.f17128++;
                            return;
                        }
                        this.f17126.add(tPoll);
                    } catch (Throwable th) {
                        this.f17127.add(th);
                        return;
                    }
                }
            }
        }
        this.f7722.onSubscribe(subscription);
        long andSet = this.f7725.getAndSet(0L);
        if (andSet != 0) {
            subscription.request(andSet);
        }
        m7049();
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.f7724, this.f7725, j);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m7049() {
    }

    public TestSubscriber(long j) {
        this(EmptySubscriber.INSTANCE, j);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long j) {
        if (j >= 0) {
            this.f7722 = subscriber;
            this.f7724 = new AtomicReference<>();
            this.f7725 = new AtomicLong(j);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
