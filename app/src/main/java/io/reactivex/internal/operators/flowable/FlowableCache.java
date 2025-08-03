package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCache<T> extends AbstractC3232<T, T> implements InterfaceC3899<T> {

    /* renamed from: ހ, reason: contains not printable characters */
    public static final CacheSubscription[] f6873 = new CacheSubscription[0];

    /* renamed from: ށ, reason: contains not printable characters */
    public static final CacheSubscription[] f6874 = new CacheSubscription[0];

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicBoolean f6875;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6876;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AtomicReference<CacheSubscription<T>[]> f6877;

    /* renamed from: ԯ, reason: contains not printable characters */
    public volatile long f6878;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C2015<T> f6879;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C2015<T> f6880;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f6881;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Throwable f6882;

    /* renamed from: ؠ, reason: contains not printable characters */
    public volatile boolean f6883;

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;
        public final Subscriber<? super T> downstream;
        public long index;
        public C2015<T> node;
        public int offset;
        public final FlowableCache<T> parent;
        public final AtomicLong requested = new AtomicLong();

        public CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.f6879;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m6385(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15070(this.requested, j);
                this.parent.m6386(this);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCache$Ϳ, reason: contains not printable characters */
    public static final class C2015<T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final T[] f6884;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public volatile C2015<T> f6885;

        public C2015(int i) {
            this.f6884 = (T[]) new Object[i];
        }
    }

    public FlowableCache(AbstractC3630<T> abstractC3630, int i) {
        super(abstractC3630);
        this.f6876 = i;
        this.f6875 = new AtomicBoolean();
        C2015<T> c2015 = new C2015<>(i);
        this.f6879 = c2015;
        this.f6880 = c2015;
        this.f6877 = new AtomicReference<>(f6873);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f6883 = true;
        for (CacheSubscription<T> cacheSubscription : this.f6877.getAndSet(f6874)) {
            m6386(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f6883) {
            C3671.m11803(th);
            return;
        }
        this.f6882 = th;
        this.f6883 = true;
        for (CacheSubscription<T> cacheSubscription : this.f6877.getAndSet(f6874)) {
            m6386(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        int i = this.f6881;
        if (i == this.f6876) {
            C2015<T> c2015 = new C2015<>(i);
            c2015.f6884[0] = t;
            this.f6881 = 1;
            this.f6880.f6885 = c2015;
            this.f6880 = c2015;
        } else {
            this.f6880.f6884[i] = t;
            this.f6881 = i + 1;
        }
        this.f6878++;
        for (CacheSubscription<T> cacheSubscription : this.f6877.get()) {
            m6386(cacheSubscription);
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        CacheSubscription<T> cacheSubscription = new CacheSubscription<>(subscriber, this);
        subscriber.onSubscribe(cacheSubscription);
        m6384(cacheSubscription);
        if (this.f6875.get() || !this.f6875.compareAndSet(false, true)) {
            m6386(cacheSubscription);
        } else {
            this.f11385.subscribe((InterfaceC3899) this);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6384(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.f6877.get();
            if (cacheSubscriptionArr == f6874) {
                return;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new CacheSubscription[length + 1];
            System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!C4905.m14631(this.f6877, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6385(CacheSubscription<T> cacheSubscription) {
        CacheSubscription<T>[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = this.f6877.get();
            int length = cacheSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (cacheSubscriptionArr[i2] == cacheSubscription) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheSubscriptionArr2 = f6873;
            } else {
                CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[length - 1];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i);
                System.arraycopy(cacheSubscriptionArr, i + 1, cacheSubscriptionArr3, i, (length - i) - 1);
                cacheSubscriptionArr2 = cacheSubscriptionArr3;
            }
        } while (!C4905.m14631(this.f6877, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m6386(CacheSubscription<T> cacheSubscription) {
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j = cacheSubscription.index;
        int i = cacheSubscription.offset;
        C2015<T> c2015 = cacheSubscription.node;
        AtomicLong atomicLong = cacheSubscription.requested;
        Subscriber<? super T> subscriber = cacheSubscription.downstream;
        int i2 = this.f6876;
        int iAddAndGet = 1;
        while (true) {
            boolean z = this.f6883;
            boolean z2 = this.f6878 == j;
            if (z && z2) {
                cacheSubscription.node = null;
                Throwable th = this.f6882;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z2) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    cacheSubscription.node = null;
                    return;
                } else if (j2 != j) {
                    if (i == i2) {
                        c2015 = c2015.f6885;
                        i = 0;
                    }
                    subscriber.onNext(c2015.f6884[i]);
                    i++;
                    j++;
                }
            }
            cacheSubscription.index = j;
            cacheSubscription.offset = i;
            cacheSubscription.node = c2015;
            iAddAndGet = cacheSubscription.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }
}
