package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.C5263;
import defpackage.InterfaceC2881;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractC3232<T, C> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f6860;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f6861;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Callable<C> f6862;

    public static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements InterfaceC3899<T>, Subscription, InterfaceC2881 {
        private static final long serialVersionUID = -7370244972039324525L;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public boolean done;
        public final Subscriber<? super C> downstream;
        public int index;
        public long produced;
        public final int size;
        public final int skip;
        public Subscription upstream;
        public final AtomicBoolean once = new AtomicBoolean();
        public final ArrayDeque<C> buffers = new ArrayDeque<>();

        public PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            long j = this.produced;
            if (j != 0) {
                C5153.m15073(this, j);
            }
            C5263.m15308(this.downstream, this.buffers, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.buffers;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((Collection) C4246.m13353(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.downstream.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j) || C5263.m15310(j, this.downstream, this.buffers, this, this)) {
                return;
            }
            if (this.once.get() || !this.once.compareAndSet(false, true)) {
                this.upstream.request(C5153.m15072(this.skip, j));
            } else {
                this.upstream.request(C5153.m15071(this.size, C5153.m15072(this.skip, j - 1)));
            }
        }

        @Override // defpackage.InterfaceC2881
        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean mo6378() {
            return this.cancelled;
        }
    }

    public static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        public C buffer;
        public final Callable<C> bufferSupplier;
        public boolean done;
        public final Subscriber<? super C> downstream;
        public int index;
        public final int size;
        public final int skip;
        public Subscription upstream;

        public PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            if (c != null) {
                this.downstream.onNext(c);
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            C c = this.buffer;
            int i = this.index;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) C4246.m13353(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
                    this.buffer = c;
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c);
                }
            }
            if (i2 == this.skip) {
                i2 = 0;
            }
            this.index = i2;
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.upstream.request(C5153.m15072(this.skip, j));
                    return;
                }
                this.upstream.request(C5153.m15071(C5153.m15072(j, this.size), C5153.m15072(this.skip - this.size, j - 1)));
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableBuffer$Ϳ, reason: contains not printable characters */
    public static final class C2014<T, C extends Collection<? super T>> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super C> f6863;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Callable<C> f6864;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final int f6865;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C f6866;

        /* renamed from: ԯ, reason: contains not printable characters */
        public Subscription f6867;

        /* renamed from: ՠ, reason: contains not printable characters */
        public boolean f6868;

        /* renamed from: ֈ, reason: contains not printable characters */
        public int f6869;

        public C2014(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.f6863 = subscriber;
            this.f6865 = i;
            this.f6864 = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f6867.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f6868) {
                return;
            }
            this.f6868 = true;
            C c = this.f6866;
            if (c != null && !c.isEmpty()) {
                this.f6863.onNext(c);
            }
            this.f6863.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f6868) {
                C3671.m11803(th);
            } else {
                this.f6868 = true;
                this.f6863.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f6868) {
                return;
            }
            C c = this.f6866;
            if (c == null) {
                try {
                    c = (C) C4246.m13353(this.f6864.call(), "The bufferSupplier returned a null buffer");
                    this.f6866 = c;
                } catch (Throwable th) {
                    C4089.m13026(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.f6869 + 1;
            if (i != this.f6865) {
                this.f6869 = i;
                return;
            }
            this.f6869 = 0;
            this.f6866 = null;
            this.f6863.onNext(c);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f6867, subscription)) {
                this.f6867 = subscription;
                this.f6863.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.f6867.request(C5153.m15072(j, this.f6865));
            }
        }
    }

    public FlowableBuffer(AbstractC3630<T> abstractC3630, int i, int i2, Callable<C> callable) {
        super(abstractC3630);
        this.f6860 = i;
        this.f6861 = i2;
        this.f6862 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i = this.f6860;
        int i2 = this.f6861;
        if (i == i2) {
            this.f11385.subscribe((InterfaceC3899) new C2014(subscriber, i, this.f6862));
        } else if (i2 > i) {
            this.f11385.subscribe((InterfaceC3899) new PublisherBufferSkipSubscriber(subscriber, this.f6860, this.f6861, this.f6862));
        } else {
            this.f11385.subscribe((InterfaceC3899) new PublisherBufferOverlappingSubscriber(subscriber, this.f6860, this.f6861, this.f6862));
        }
    }
}
