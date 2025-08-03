package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4217;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2697;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<?>[] f7198;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Iterable<? extends Publisher<?>> f7199;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super Object[], R> f7200;

    public static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements InterfaceC2697<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;
        public final InterfaceC2368<? super Object[], R> combiner;
        public volatile boolean done;
        public final Subscriber<? super R> downstream;
        public final AtomicThrowable error;
        public final AtomicLong requested;
        public final WithLatestInnerSubscriber[] subscribers;
        public final AtomicReference<Subscription> upstream;
        public final AtomicReferenceArray<Object> values;

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super Object[], R> interfaceC2368, int i) {
            this.downstream = subscriber;
            this.combiner = interfaceC2368;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerSubscriberArr[i2] = new WithLatestInnerSubscriber(this, i2);
            }
            this.subscribers = withLatestInnerSubscriberArr;
            this.values = new AtomicReferenceArray<>(i);
            this.upstream = new AtomicReference<>();
            this.requested = new AtomicLong();
            this.error = new AtomicThrowable();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.subscribers) {
                withLatestInnerSubscriber.m6670();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            m6665(-1);
            C4217.m13297(this.downstream, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            m6665(-1);
            C4217.m13299(this.downstream, th, this, this.error);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (mo6426(t) || this.done) {
                return;
            }
            this.upstream.get().request(1L);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6665(int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < withLatestInnerSubscriberArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerSubscriberArr[i2].m6670();
                }
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6666(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            m6665(i);
            C4217.m13297(this.downstream, this, this.error);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6667(int i, Throwable th) {
            this.done = true;
            SubscriptionHelper.cancel(this.upstream);
            m6665(i);
            C4217.m13299(this.downstream, th, this, this.error);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6668(int i, Object obj) {
            this.values.set(i, obj);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6669(Publisher<?>[] publisherArr, int i) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.subscribers;
            AtomicReference<Subscription> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && atomicReference.get() != SubscriptionHelper.CANCELLED; i2++) {
                publisherArr[i2].subscribe(withLatestInnerSubscriberArr[i2]);
            }
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            if (this.done) {
                return false;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = t;
            int i = 0;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return false;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                C4217.m13301(this.downstream, C4246.m13353(this.combiner.apply(objArr), "The combiner returned a null value"), this, this.error);
                return true;
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                onError(th);
                return false;
            }
        }
    }

    public static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        public boolean hasValue;
        public final int index;
        public final WithLatestFromSubscriber<?, ?> parent;

        public WithLatestInnerSubscriber(WithLatestFromSubscriber<?, ?> withLatestFromSubscriber, int i) {
            this.parent = withLatestFromSubscriber;
            this.index = i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.m6666(this.index, this.hasValue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.m6667(this.index, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.m6668(this.index, obj);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6670() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$Ϳ, reason: contains not printable characters */
    public final class C2063 implements InterfaceC2368<T, R> {
        public C2063() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // defpackage.InterfaceC2368
        public R apply(T t) throws Exception {
            return (R) C4246.m13353(FlowableWithLatestFromMany.this.f7200.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    public FlowableWithLatestFromMany(AbstractC3630<T> abstractC3630, Publisher<?>[] publisherArr, InterfaceC2368<? super Object[], R> interfaceC2368) {
        super(abstractC3630);
        this.f7198 = publisherArr;
        this.f7199 = null;
        this.f7200 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<?>[] publisherArr = this.f7198;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher<?> publisher : this.f7199) {
                    if (length == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (length >> 1) + length);
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
            new C2065(this.f11385, new C2063()).subscribeActual(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f7200, length);
        subscriber.onSubscribe(withLatestFromSubscriber);
        withLatestFromSubscriber.m6669(publisherArr, length);
        this.f11385.subscribe((InterfaceC3899) withLatestFromSubscriber);
    }

    public FlowableWithLatestFromMany(AbstractC3630<T> abstractC3630, Iterable<? extends Publisher<?>> iterable, InterfaceC2368<? super Object[], R> interfaceC2368) {
        super(abstractC3630);
        this.f7198 = null;
        this.f7199 = iterable;
        this.f7200 = interfaceC2368;
    }
}
