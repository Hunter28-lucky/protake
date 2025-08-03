package defpackage;

import defpackage.AbstractC4585;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableBufferTimed.java */
/* renamed from: ت, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3434<T, U extends Collection<? super T>> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f11796;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f11797;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f11798;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f11799;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Callable<U> f11800;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f11801;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f11802;

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: ت$Ϳ, reason: contains not printable characters */
    public static final class RunnableC3435<T, U extends Collection<? super T>> extends AbstractC3894<T, U, U> implements Subscription, Runnable, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<U> f11803;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final long f11804;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final TimeUnit f11805;

        /* renamed from: ހ, reason: contains not printable characters */
        public final int f11806;

        /* renamed from: ށ, reason: contains not printable characters */
        public final boolean f11807;

        /* renamed from: ނ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f11808;

        /* renamed from: ރ, reason: contains not printable characters */
        public U f11809;

        /* renamed from: ބ, reason: contains not printable characters */
        public InterfaceC4478 f11810;

        /* renamed from: ޅ, reason: contains not printable characters */
        public Subscription f11811;

        /* renamed from: ކ, reason: contains not printable characters */
        public long f11812;

        /* renamed from: އ, reason: contains not printable characters */
        public long f11813;

        public RunnableC3435(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, AbstractC4585.AbstractC4588 abstractC4588) {
            super(subscriber, new MpscLinkedQueue());
            this.f11803 = callable;
            this.f11804 = j;
            this.f11805 = timeUnit;
            this.f11806 = i;
            this.f11807 = z;
            this.f11808 = abstractC4588;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f13476) {
                return;
            }
            this.f13476 = true;
            dispose();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            synchronized (this) {
                this.f11809 = null;
            }
            this.f11811.cancel();
            this.f11808.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11808.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.f11809;
                this.f11809 = null;
            }
            if (u != null) {
                this.f13475.offer(u);
                this.f13477 = true;
                if (m12561()) {
                    C5263.m15306(this.f13475, this.f13474, false, this, this);
                }
                this.f11808.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                this.f11809 = null;
            }
            this.f13474.onError(th);
            this.f11808.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f11809;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.f11806) {
                    return;
                }
                this.f11809 = null;
                this.f11812++;
                if (this.f11807) {
                    this.f11810.dispose();
                }
                m12564(u, false, this);
                try {
                    U u2 = (U) C4246.m13353(this.f11803.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.f11809 = u2;
                        this.f11813++;
                    }
                    if (this.f11807) {
                        AbstractC4585.AbstractC4588 abstractC4588 = this.f11808;
                        long j = this.f11804;
                        this.f11810 = abstractC4588.mo11922(this, j, j, this.f11805);
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    this.f13474.onError(th);
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11811, subscription)) {
                this.f11811 = subscription;
                try {
                    this.f11809 = (U) C4246.m13353(this.f11803.call(), "The supplied buffer is null");
                    this.f13474.onSubscribe(this);
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f11808;
                    long j = this.f11804;
                    this.f11810 = abstractC4588.mo11922(this, j, j, this.f11805);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f11808.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.f13474);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) C4246.m13353(this.f11803.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.f11809;
                    if (u2 != null && this.f11812 == this.f11813) {
                        this.f11809 = u;
                        m12564(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                this.f13474.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.AbstractC3894, defpackage.InterfaceC2541
        /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean mo9365(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: ت$Ԩ, reason: contains not printable characters */
    public static final class RunnableC3436<T, U extends Collection<? super T>> extends AbstractC3894<T, U, U> implements Subscription, Runnable, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<U> f11814;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final long f11815;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final TimeUnit f11816;

        /* renamed from: ހ, reason: contains not printable characters */
        public final AbstractC4585 f11817;

        /* renamed from: ށ, reason: contains not printable characters */
        public Subscription f11818;

        /* renamed from: ނ, reason: contains not printable characters */
        public U f11819;

        /* renamed from: ރ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f11820;

        public RunnableC3436(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            super(subscriber, new MpscLinkedQueue());
            this.f11820 = new AtomicReference<>();
            this.f11814 = callable;
            this.f11815 = j;
            this.f11816 = timeUnit;
            this.f11817 = abstractC4585;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f13476 = true;
            this.f11818.cancel();
            DisposableHelper.dispose(this.f11820);
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            cancel();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f11820.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.f11820);
            synchronized (this) {
                U u = this.f11819;
                if (u == null) {
                    return;
                }
                this.f11819 = null;
                this.f13475.offer(u);
                this.f13477 = true;
                if (m12561()) {
                    C5263.m15306(this.f13475, this.f13474, false, null, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.f11820);
            synchronized (this) {
                this.f11819 = null;
            }
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f11819;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11818, subscription)) {
                this.f11818 = subscription;
                try {
                    this.f11819 = (U) C4246.m13353(this.f11814.call(), "The supplied buffer is null");
                    this.f13474.onSubscribe(this);
                    if (this.f13476) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    AbstractC4585 abstractC4585 = this.f11817;
                    long j = this.f11815;
                    InterfaceC4478 interfaceC4478Mo6989 = abstractC4585.mo6989(this, j, j, this.f11816);
                    if (C4905.m14631(this.f11820, null, interfaceC4478Mo6989)) {
                        return;
                    }
                    interfaceC4478Mo6989.dispose();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    EmptySubscription.error(th, this.f13474);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) C4246.m13353(this.f11814.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.f11819;
                    if (u2 == null) {
                        return;
                    }
                    this.f11819 = u;
                    m12563(u2, false, this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                this.f13474.onError(th);
            }
        }

        @Override // defpackage.AbstractC3894, defpackage.InterfaceC2541
        /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean mo9365(Subscriber<? super U> subscriber, U u) {
            this.f13474.onNext(u);
            return true;
        }
    }

    /* compiled from: FlowableBufferTimed.java */
    /* renamed from: ت$Ԫ, reason: contains not printable characters */
    public static final class RunnableC3437<T, U extends Collection<? super T>> extends AbstractC3894<T, U, U> implements Subscription, Runnable {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<U> f11821;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final long f11822;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final long f11823;

        /* renamed from: ހ, reason: contains not printable characters */
        public final TimeUnit f11824;

        /* renamed from: ށ, reason: contains not printable characters */
        public final AbstractC4585.AbstractC4588 f11825;

        /* renamed from: ނ, reason: contains not printable characters */
        public final List<U> f11826;

        /* renamed from: ރ, reason: contains not printable characters */
        public Subscription f11827;

        /* compiled from: FlowableBufferTimed.java */
        /* renamed from: ت$Ԫ$Ϳ, reason: contains not printable characters */
        public final class RunnableC3438 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final U f11828;

            public RunnableC3438(U u) {
                this.f11828 = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (RunnableC3437.this) {
                    RunnableC3437.this.f11826.remove(this.f11828);
                }
                RunnableC3437 runnableC3437 = RunnableC3437.this;
                runnableC3437.m12564(this.f11828, false, runnableC3437.f11825);
            }
        }

        public RunnableC3437(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            super(subscriber, new MpscLinkedQueue());
            this.f11821 = callable;
            this.f11822 = j;
            this.f11823 = j2;
            this.f11824 = timeUnit;
            this.f11825 = abstractC4588;
            this.f11826 = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f13476 = true;
            this.f11827.cancel();
            this.f11825.dispose();
            m11205();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f11826);
                this.f11826.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f13475.offer((Collection) it.next());
            }
            this.f13477 = true;
            if (m12561()) {
                C5263.m15306(this.f13475, this.f13474, false, this.f11825, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f13477 = true;
            this.f11825.dispose();
            m11205();
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.f11826.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f11827, subscription)) {
                this.f11827 = subscription;
                try {
                    Collection collection = (Collection) C4246.m13353(this.f11821.call(), "The supplied buffer is null");
                    this.f11826.add(collection);
                    this.f13474.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    AbstractC4585.AbstractC4588 abstractC4588 = this.f11825;
                    long j = this.f11823;
                    abstractC4588.mo11922(this, j, j, this.f11824);
                    this.f11825.mo6991(new RunnableC3438(collection), this.f11822, this.f11824);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f11825.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.f13474);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13476) {
                return;
            }
            try {
                Collection collection = (Collection) C4246.m13353(this.f11821.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.f13476) {
                        return;
                    }
                    this.f11826.add(collection);
                    this.f11825.mo6991(new RunnableC3438(collection), this.f11822, this.f11824);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                this.f13474.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.AbstractC3894, defpackage.InterfaceC2541
        /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean mo9365(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public void m11205() {
            synchronized (this) {
                this.f11826.clear();
            }
        }
    }

    public C3434(AbstractC3630<T> abstractC3630, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, Callable<U> callable, int i, boolean z) {
        super(abstractC3630);
        this.f11796 = j;
        this.f11797 = j2;
        this.f11798 = timeUnit;
        this.f11799 = abstractC4585;
        this.f11800 = callable;
        this.f11801 = i;
        this.f11802 = z;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.f11796 == this.f11797 && this.f11801 == Integer.MAX_VALUE) {
            this.f11385.subscribe((InterfaceC3899) new RunnableC3436(new C4056(subscriber), this.f11800, this.f11796, this.f11798, this.f11799));
            return;
        }
        AbstractC4585.AbstractC4588 abstractC4588Mo6986 = this.f11799.mo6986();
        if (this.f11796 == this.f11797) {
            this.f11385.subscribe((InterfaceC3899) new RunnableC3435(new C4056(subscriber), this.f11800, this.f11796, this.f11798, this.f11801, this.f11802, abstractC4588Mo6986));
        } else {
            this.f11385.subscribe((InterfaceC3899) new RunnableC3437(new C4056(subscriber), this.f11800, this.f11796, this.f11797, this.f11798, abstractC4588Mo6986));
        }
    }
}
