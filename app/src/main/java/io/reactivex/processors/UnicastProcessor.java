package io.reactivex.processors;

import defpackage.AbstractC2892;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class UnicastProcessor<T> extends AbstractC2892<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final d<T> f7697;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<Runnable> f7698;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7699;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public volatile boolean f7700;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Throwable f7701;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final AtomicReference<Subscriber<? super T>> f7702;

    /* renamed from: ֈ, reason: contains not printable characters */
    public volatile boolean f7703;

    /* renamed from: ֏, reason: contains not printable characters */
    public final AtomicBoolean f7704;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final BasicIntQueueSubscription<T> f7705;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final AtomicLong f7706;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f7707;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.f7703) {
                return;
            }
            UnicastProcessor.this.f7703 = true;
            UnicastProcessor.this.m7030();
            UnicastProcessor.this.f7702.lazySet(null);
            if (UnicastProcessor.this.f7705.getAndIncrement() == 0) {
                UnicastProcessor.this.f7702.lazySet(null);
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (unicastProcessor.f7707) {
                    return;
                }
                unicastProcessor.f7697.clear();
            }
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            UnicastProcessor.this.f7697.clear();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return UnicastProcessor.this.f7697.isEmpty();
        }

        @Override // defpackage.InterfaceC4851
        public T poll() {
            return UnicastProcessor.this.f7697.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(UnicastProcessor.this.f7706, j);
                UnicastProcessor.this.m7031();
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f7707 = true;
            return 2;
        }
    }

    public UnicastProcessor(int i) {
        this(i, null, true);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> UnicastProcessor<T> m7026() {
        return new UnicastProcessor<>(AbstractC3630.bufferSize());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> UnicastProcessor<T> m7027(int i) {
        return new UnicastProcessor<>(i);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> UnicastProcessor<T> m7028(int i, Runnable runnable) {
        C4246.m13353(runnable, "onTerminate");
        return new UnicastProcessor<>(i, runnable);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f7700 || this.f7703) {
            return;
        }
        this.f7700 = true;
        m7030();
        m7031();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        C4246.m13353(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f7700 || this.f7703) {
            C3671.m11803(th);
            return;
        }
        this.f7701 = th;
        this.f7700 = true;
        m7030();
        m7031();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        C4246.m13353(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f7700 || this.f7703) {
            return;
        }
        this.f7697.offer(t);
        m7031();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.f7700 || this.f7703) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f7704.get() || !this.f7704.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.f7705);
        this.f7702.set(subscriber);
        if (this.f7703) {
            this.f7702.lazySet(null);
        } else {
            m7031();
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m7029(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, d<T> dVar) {
        if (this.f7703) {
            dVar.clear();
            this.f7702.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.f7701 != null) {
            dVar.clear();
            this.f7702.lazySet(null);
            subscriber.onError(this.f7701);
            return true;
        }
        if (!z3) {
            return false;
        }
        Throwable th = this.f7701;
        this.f7702.lazySet(null);
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
        return true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m7030() {
        Runnable andSet = this.f7698.getAndSet(null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m7031() {
        if (this.f7705.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        Subscriber<? super T> subscriber = this.f7702.get();
        while (subscriber == null) {
            iAddAndGet = this.f7705.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                subscriber = this.f7702.get();
            }
        }
        if (this.f7707) {
            m7032(subscriber);
        } else {
            m7033(subscriber);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m7032(Subscriber<? super T> subscriber) {
        d<T> dVar = this.f7697;
        int iAddAndGet = 1;
        boolean z = !this.f7699;
        while (!this.f7703) {
            boolean z2 = this.f7700;
            if (z && z2 && this.f7701 != null) {
                dVar.clear();
                this.f7702.lazySet(null);
                subscriber.onError(this.f7701);
                return;
            }
            subscriber.onNext(null);
            if (z2) {
                this.f7702.lazySet(null);
                Throwable th = this.f7701;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f7705.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        this.f7702.lazySet(null);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m7033(Subscriber<? super T> subscriber) {
        long j;
        d<T> dVar = this.f7697;
        boolean z = true;
        boolean z2 = !this.f7699;
        int iAddAndGet = 1;
        while (true) {
            long j2 = this.f7706.get();
            long j3 = 0;
            while (true) {
                if (j2 == j3) {
                    j = j3;
                    break;
                }
                boolean z3 = this.f7700;
                T tPoll = dVar.poll();
                boolean z4 = tPoll == null ? z : false;
                j = j3;
                if (m7029(z2, z3, z4, subscriber, dVar)) {
                    return;
                }
                if (z4) {
                    break;
                }
                subscriber.onNext(tPoll);
                j3 = 1 + j;
                z = true;
            }
            if (j2 == j3 && m7029(z2, this.f7700, dVar.isEmpty(), subscriber, dVar)) {
                return;
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.f7706.addAndGet(-j);
            }
            iAddAndGet = this.f7705.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                z = true;
            }
        }
    }

    public UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, true);
    }

    public UnicastProcessor(int i, Runnable runnable, boolean z) {
        this.f7697 = new d<>(C4246.m13354(i, "capacityHint"));
        this.f7698 = new AtomicReference<>(runnable);
        this.f7699 = z;
        this.f7702 = new AtomicReference<>();
        this.f7704 = new AtomicBoolean();
        this.f7705 = new UnicastQueueSubscription();
        this.f7706 = new AtomicLong();
    }
}
