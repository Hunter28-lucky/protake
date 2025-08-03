package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC3731;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4514;
import defpackage.InterfaceC4851;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowablePublish<T> extends AbstractC3731<T> implements InterfaceC4514<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7038;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<PublishSubscriber<T>> f7039;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7040;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Publisher<T> f7041;

    public static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> child;
        public long emitted;
        public volatile PublishSubscriber<T> parent;

        public InnerSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber<T> publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.parent) == null) {
                return;
            }
            publishSubscriber.m6556(this);
            publishSubscriber.m6555();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15070(this, j);
                PublishSubscriber<T> publishSubscriber = this.parent;
                if (publishSubscriber != null) {
                    publishSubscriber.m6555();
                }
            }
        }
    }

    public static final class PublishSubscriber<T> extends AtomicInteger implements InterfaceC3899<T>, InterfaceC4478 {
        private static final long serialVersionUID = -202316842419149694L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerSubscriber[] f7042 = new InnerSubscriber[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerSubscriber[] f7043 = new InnerSubscriber[0];
        public final int bufferSize;
        public final AtomicReference<PublishSubscriber<T>> current;
        public volatile InterfaceC4851<T> queue;
        public int sourceMode;
        public volatile Object terminalEvent;
        public final AtomicReference<Subscription> upstream = new AtomicReference<>();
        public final AtomicReference<InnerSubscriber<T>[]> subscribers = new AtomicReference<>(f7042);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.current = atomicReference;
            this.bufferSize = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InnerSubscriber<T>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<T>[] innerSubscriberArr2 = f7043;
            if (innerSubscriberArr == innerSubscriberArr2 || this.subscribers.getAndSet(innerSubscriberArr2) == innerSubscriberArr2) {
                return;
            }
            C4905.m14631(this.current, this, null);
            SubscriptionHelper.cancel(this.upstream);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.subscribers.get() == f7043;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = NotificationLite.complete();
                m6555();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                C3671.m11803(th);
            } else {
                this.terminalEvent = NotificationLite.error(th);
                m6555();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                m6555();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(7);
                    if (iMo6310 == 1) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        this.terminalEvent = NotificationLite.complete();
                        m6555();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.sourceMode = iMo6310;
                        this.queue = interfaceC2968;
                        subscription.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.bufferSize);
                subscription.request(this.bufferSize);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6553(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == f7043) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!C4905.m14631(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m6554(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.isComplete(obj)) {
                    Throwable error = NotificationLite.getError(obj);
                    C4905.m14631(this.current, this, null);
                    InnerSubscriber<T>[] andSet = this.subscribers.getAndSet(f7043);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(error);
                            i++;
                        }
                    } else {
                        C3671.m11803(error);
                    }
                    return true;
                }
                if (z) {
                    C4905.m14631(this.current, this, null);
                    InnerSubscriber<T>[] andSet2 = this.subscribers.getAndSet(f7043);
                    int length2 = andSet2.length;
                    while (i < length2) {
                        andSet2[i].child.onComplete();
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:73:0x0124, code lost:
        
            if (r11 == 0) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0129, code lost:
        
            if (r25.sourceMode == 1) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x012b, code lost:
        
            r25.upstream.get().request(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0137, code lost:
        
            r4 = r0;
            r3 = true;
         */
        /* renamed from: ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m6555() {
            /*
                Method dump skipped, instructions count: 362
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.m6555():void");
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6556(InnerSubscriber<T> innerSubscriber) {
            InnerSubscriber<T>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2].equals(innerSubscriber)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f7042;
                } else {
                    InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!C4905.m14631(this.subscribers, innerSubscriberArr, innerSubscriberArr2));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublish$Ϳ, reason: contains not printable characters */
    public static final class C2041<T> implements Publisher<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<PublishSubscriber<T>> f7044;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f7045;

        public C2041(AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
            this.f7044 = atomicReference;
            this.f7045 = i;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            PublishSubscriber<T> publishSubscriber;
            InnerSubscriber<T> innerSubscriber = new InnerSubscriber<>(subscriber);
            subscriber.onSubscribe(innerSubscriber);
            while (true) {
                publishSubscriber = this.f7044.get();
                if (publishSubscriber == null || publishSubscriber.isDisposed()) {
                    PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f7044, this.f7045);
                    if (C4905.m14631(this.f7044, publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.m6553(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.m6556(innerSubscriber);
            } else {
                innerSubscriber.parent = publishSubscriber;
            }
            publishSubscriber.m6555();
        }
    }

    public FlowablePublish(Publisher<T> publisher, AbstractC3630<T> abstractC3630, AtomicReference<PublishSubscriber<T>> atomicReference, int i) {
        this.f7041 = publisher;
        this.f7038 = abstractC3630;
        this.f7039 = atomicReference;
        this.f7040 = i;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6549(AbstractC3630<T> abstractC3630, int i) {
        AtomicReference atomicReference = new AtomicReference();
        return C3671.m11794(new FlowablePublish(new C2041(atomicReference, i), abstractC3630, atomicReference, i));
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f7041.subscribe(subscriber);
    }

    @Override // defpackage.InterfaceC4514
    /* renamed from: Ϳ, reason: contains not printable characters */
    public Publisher<T> mo6550() {
        return this.f7038;
    }

    @Override // defpackage.InterfaceC4514
    /* renamed from: Ԩ, reason: contains not printable characters */
    public int mo6551() {
        return this.f7040;
    }

    @Override // defpackage.AbstractC3731
    /* renamed from: Ԫ, reason: contains not printable characters */
    public void mo6552(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.f7039.get();
            if (publishSubscriber != null && !publishSubscriber.isDisposed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.f7039, this.f7040);
            if (C4905.m14631(this.f7039, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z = !publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC2857.accept(publishSubscriber);
            if (z) {
                this.f7038.subscribe((InterfaceC3899) publishSubscriber);
            }
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }
}
