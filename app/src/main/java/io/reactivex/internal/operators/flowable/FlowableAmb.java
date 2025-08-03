package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableAmb<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<? extends T>[] f6854;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Iterable<? extends Publisher<? extends T>> f6855;

    public static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;
        public final Subscriber<? super T> downstream;
        public final int index;
        public final AtomicLong missedRequested = new AtomicLong();
        public final C2013<T> parent;
        public boolean won;

        public AmbInnerSubscriber(C2013<T> c2013, int i, Subscriber<? super T> subscriber) {
            this.parent = c2013;
            this.index = i;
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (!this.parent.m6377(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.m6377(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                get().cancel();
                C3671.m11803(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.m6377(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableAmb$Ϳ, reason: contains not printable characters */
    public static final class C2013<T> implements Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f6856;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AmbInnerSubscriber<T>[] f6857;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AtomicInteger f6858 = new AtomicInteger();

        public C2013(Subscriber<? super T> subscriber, int i) {
            this.f6856 = subscriber;
            this.f6857 = new AmbInnerSubscriber[i];
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f6858.get() != -1) {
                this.f6858.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.f6857) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.f6858.get();
                if (i > 0) {
                    this.f6857[i - 1].request(j);
                    return;
                }
                if (i == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.f6857) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6376(Publisher<? extends T>[] publisherArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f6857;
            int length = ambInnerSubscriberArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerSubscriberArr[i] = new AmbInnerSubscriber<>(this, i2, this.f6856);
                i = i2;
            }
            this.f6858.lazySet(0);
            this.f6856.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.f6858.get() == 0; i3++) {
                publisherArr[i3].subscribe(ambInnerSubscriberArr[i3]);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6377(int i) {
            int i2 = 0;
            if (this.f6858.get() != 0 || !this.f6858.compareAndSet(0, i)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.f6857;
            int length = ambInnerSubscriberArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    ambInnerSubscriberArr[i2].cancel();
                }
                i2 = i3;
            }
            return true;
        }
    }

    public FlowableAmb(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable) {
        this.f6854 = publisherArr;
        this.f6855 = iterable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.f6854;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<? extends T> publisher : this.f6855) {
                    if (publisher == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
                    }
                    int i = length + 1;
                    publisherArr[length] = publisher;
                    length = i;
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                EmptySubscription.error(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
        } else if (length == 1) {
            publisherArr[0].subscribe(subscriber);
        } else {
            new C2013(subscriber, length).m6376(publisherArr);
        }
    }
}
