package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.C5263;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2968;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<? extends R>> f7051;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7052;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean f7053;

    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        public final Subscriber<? super T> downstream;
        public long emitted;
        public final C2042<T> parent;

        public MulticastSubscription(Subscriber<? super T> subscriber, C2042<T> c2042) {
            this.downstream = subscriber;
            this.parent = c2042;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m6569(this);
                this.parent.m6567();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15070(this, j);
                this.parent.m6567();
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6564() {
            return get() == Long.MIN_VALUE;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$Ϳ, reason: contains not printable characters */
    public static final class C2042<T> extends AbstractC3630<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ށ, reason: contains not printable characters */
        public static final MulticastSubscription[] f7054 = new MulticastSubscription[0];

        /* renamed from: ނ, reason: contains not printable characters */
        public static final MulticastSubscription[] f7055 = new MulticastSubscription[0];

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f7058;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final int f7059;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean f7060;

        /* renamed from: ֈ, reason: contains not printable characters */
        public volatile InterfaceC4851<T> f7062;

        /* renamed from: ֏, reason: contains not printable characters */
        public int f7063;

        /* renamed from: ׯ, reason: contains not printable characters */
        public volatile boolean f7064;

        /* renamed from: ؠ, reason: contains not printable characters */
        public Throwable f7065;

        /* renamed from: ހ, reason: contains not printable characters */
        public int f7066;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicInteger f7056 = new AtomicInteger();

        /* renamed from: ՠ, reason: contains not printable characters */
        public final AtomicReference<Subscription> f7061 = new AtomicReference<>();

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AtomicReference<MulticastSubscription<T>[]> f7057 = new AtomicReference<>(f7054);

        public C2042(int i, boolean z) {
            this.f7058 = i;
            this.f7059 = i - (i >> 2);
            this.f7060 = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InterfaceC4851<T> interfaceC4851;
            SubscriptionHelper.cancel(this.f7061);
            if (this.f7056.getAndIncrement() != 0 || (interfaceC4851 = this.f7062) == null) {
                return;
            }
            interfaceC4851.clear();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f7061.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f7064) {
                return;
            }
            this.f7064 = true;
            m6567();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f7064) {
                C3671.m11803(th);
                return;
            }
            this.f7065 = th;
            this.f7064 = true;
            m6567();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f7064) {
                return;
            }
            if (this.f7063 != 0 || this.f7062.offer(t)) {
                m6567();
            } else {
                this.f7061.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f7061, subscription)) {
                if (subscription instanceof InterfaceC2968) {
                    InterfaceC2968 interfaceC2968 = (InterfaceC2968) subscription;
                    int iMo6310 = interfaceC2968.mo6310(3);
                    if (iMo6310 == 1) {
                        this.f7063 = iMo6310;
                        this.f7062 = interfaceC2968;
                        this.f7064 = true;
                        m6567();
                        return;
                    }
                    if (iMo6310 == 2) {
                        this.f7063 = iMo6310;
                        this.f7062 = interfaceC2968;
                        C5263.m15311(subscription, this.f7058);
                        return;
                    }
                }
                this.f7062 = C5263.m15304(this.f7058);
                C5263.m15311(subscription, this.f7058);
            }
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (m6565(multicastSubscription)) {
                if (multicastSubscription.m6564()) {
                    m6569(multicastSubscription);
                    return;
                } else {
                    m6567();
                    return;
                }
            }
            Throwable th = this.f7065;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m6565(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.f7057.get();
                if (multicastSubscriptionArr == f7055) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!C4905.m14631(this.f7057, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6566() {
            for (MulticastSubscription<T> multicastSubscription : this.f7057.getAndSet(f7055)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onComplete();
                }
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6567() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            Throwable th2;
            if (this.f7056.getAndIncrement() != 0) {
                return;
            }
            InterfaceC4851<T> interfaceC4851 = this.f7062;
            int i = this.f7066;
            int i2 = this.f7059;
            boolean z = this.f7063 != 1;
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.f7057;
            MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int iAddAndGet = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (interfaceC4851 == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j = Long.MAX_VALUE;
                    long j2 = Long.MAX_VALUE;
                    int i3 = 0;
                    while (i3 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i3];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.emitted;
                        if (j3 == Long.MIN_VALUE) {
                            length--;
                        } else if (j2 > j3) {
                            j2 = j3;
                        }
                        i3++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (length == 0) {
                        j2 = 0;
                    }
                    while (j2 != j4) {
                        if (isDisposed()) {
                            interfaceC4851.clear();
                            return;
                        }
                        boolean z2 = this.f7064;
                        if (z2 && !this.f7060 && (th2 = this.f7065) != null) {
                            m6568(th2);
                            return;
                        }
                        try {
                            T tPoll = interfaceC4851.poll();
                            boolean z3 = tPoll == null;
                            if (z2 && z3) {
                                Throwable th3 = this.f7065;
                                if (th3 != null) {
                                    m6568(th3);
                                    return;
                                } else {
                                    m6566();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i4 = 0;
                            boolean z4 = false;
                            while (i4 < length3) {
                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i4];
                                long j5 = multicastSubscription2.get();
                                if (j5 != Long.MIN_VALUE) {
                                    if (j5 != j) {
                                        multicastSubscription2.emitted++;
                                    }
                                    multicastSubscription2.downstream.onNext(tPoll);
                                } else {
                                    z4 = true;
                                }
                                i4++;
                                j = Long.MAX_VALUE;
                            }
                            j2--;
                            if (z && (i = i + 1) == i2) {
                                this.f7061.get().request(i2);
                                i = 0;
                            }
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (z4 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            } else {
                                j4 = 0;
                                j = Long.MAX_VALUE;
                            }
                        } catch (Throwable th4) {
                            C4089.m13026(th4);
                            SubscriptionHelper.cancel(this.f7061);
                            m6568(th4);
                            return;
                        }
                    }
                    if (j2 == j4) {
                        if (isDisposed()) {
                            interfaceC4851.clear();
                            return;
                        }
                        boolean z5 = this.f7064;
                        if (z5 && !this.f7060 && (th = this.f7065) != null) {
                            m6568(th);
                            return;
                        }
                        if (z5 && interfaceC4851.isEmpty()) {
                            Throwable th5 = this.f7065;
                            if (th5 != null) {
                                m6568(th5);
                                return;
                            } else {
                                m6566();
                                return;
                            }
                        }
                    }
                }
                this.f7066 = i;
                iAddAndGet = this.f7056.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (interfaceC4851 == null) {
                    interfaceC4851 = this.f7062;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6568(Throwable th) {
            for (MulticastSubscription<T> multicastSubscription : this.f7057.getAndSet(f7055)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.downstream.onError(th);
                }
            }
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6569(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.f7057.get();
                int length = multicastSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (multicastSubscriptionArr[i2] == multicastSubscription) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = f7054;
                } else {
                    MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                    System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!C4905.m14631(this.f7057, multicastSubscriptionArr, multicastSubscriptionArr2));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$Ԩ, reason: contains not printable characters */
    public static final class C2043<R> implements InterfaceC3899<R>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super R> f7067;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2042<?> f7068;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Subscription f7069;

        public C2043(Subscriber<? super R> subscriber, C2042<?> c2042) {
            this.f7067 = subscriber;
            this.f7068 = c2042;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f7069.cancel();
            this.f7068.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f7067.onComplete();
            this.f7068.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f7067.onError(th);
            this.f7068.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.f7067.onNext(r);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f7069, subscription)) {
                this.f7069 = subscription;
                this.f7067.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f7069.request(j);
        }
    }

    public FlowablePublishMulticast(AbstractC3630<T> abstractC3630, InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
        super(abstractC3630);
        this.f7051 = interfaceC2368;
        this.f7052 = i;
        this.f7053 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        C2042 c2042 = new C2042(this.f7052, this.f7053);
        try {
            ((Publisher) C4246.m13353(this.f7051.apply(c2042), "selector returned a null Publisher")).subscribe(new C2043(subscriber, c2042));
            this.f11385.subscribe((InterfaceC3899) c2042);
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
