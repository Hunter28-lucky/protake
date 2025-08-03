package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC3731;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.o2;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableReplay<T> extends AbstractC3731<T> implements InterfaceC4503 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Callable f7084 = new CallableC2045();

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f7085;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AtomicReference<ReplaySubscriber<T>> f7086;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<? extends InterfaceC2048<T>> f7087;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Publisher<T> f7088;

    public static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements InterfaceC2048<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public long index;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        public final void complete() {
            Object objMo6596 = mo6596(NotificationLite.complete());
            long j = this.index + 1;
            this.index = j;
            m6595(new Node(objMo6596, j));
            mo6603();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void mo6592(T t) {
            Object objMo6596 = mo6596(NotificationLite.next(t));
            long j = this.index + 1;
            this.index = j;
            m6595(new Node(objMo6596, j));
            mo6602();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void mo6593(Throwable th) {
            Object objMo6596 = mo6596(NotificationLite.error(th));
            long j = this.index + 1;
            this.index = j;
            m6595(new Node(objMo6596, j));
            mo6603();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: ԩ, reason: contains not printable characters */
        public final void mo6594(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                while (!innerSubscription.isDisposed()) {
                    long j = innerSubscription.get();
                    boolean z = j == Long.MAX_VALUE;
                    Node nodeMo6597 = (Node) innerSubscription.m6604();
                    if (nodeMo6597 == null) {
                        nodeMo6597 = mo6597();
                        innerSubscription.index = nodeMo6597;
                        C5153.m15069(innerSubscription.totalRequested, nodeMo6597.index);
                    }
                    long j2 = 0;
                    while (j != 0 && (node = nodeMo6597.get()) != null) {
                        Object objMo6598 = mo6598(node.value);
                        try {
                            if (NotificationLite.accept(objMo6598, innerSubscription.child)) {
                                innerSubscription.index = null;
                                return;
                            }
                            j2++;
                            j--;
                            if (innerSubscription.isDisposed()) {
                                innerSubscription.index = null;
                                return;
                            }
                            nodeMo6597 = node;
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            innerSubscription.index = null;
                            innerSubscription.dispose();
                            if (NotificationLite.isError(objMo6598) || NotificationLite.isComplete(objMo6598)) {
                                return;
                            }
                            innerSubscription.child.onError(th);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.index = nodeMo6597;
                        if (!z) {
                            innerSubscription.m6605(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
                innerSubscription.index = null;
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final void m6595(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public Object mo6596(Object obj) {
            return obj;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public Node mo6597() {
            return get();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public Object mo6598(Object obj) {
            return obj;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final void m6599() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.size--;
            m6600(node);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final void m6600(Node node) {
            set(node);
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final void m6601() {
            Node node = get();
            if (node.value != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public void mo6602() {
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public void mo6603() {
            m6601();
        }
    }

    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, InterfaceC4478 {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> child;
        public boolean emitting;
        public Object index;
        public boolean missed;
        public final ReplaySubscriber<T> parent;
        public final AtomicLong totalRequested = new AtomicLong();

        public InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m6608(this);
                this.parent.m6607();
                this.index = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j) || C5153.m15070(this, j) == Long.MIN_VALUE) {
                return;
            }
            C5153.m15069(this.totalRequested, j);
            this.parent.m6607();
            this.parent.buffer.mo6594(this);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public <U> U m6604() {
            return (U) this.index;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public long m6605(long j) {
            return C5153.m15074(this, j);
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final long index;
        public final Object value;

        public Node(Object obj, long j) {
            this.value = obj;
            this.index = j;
        }
    }

    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, InterfaceC4478 {
        private static final long serialVersionUID = 7224554242710036740L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final InnerSubscription[] f7089 = new InnerSubscription[0];

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final InnerSubscription[] f7090 = new InnerSubscription[0];
        public final InterfaceC2048<T> buffer;
        public boolean done;
        public long maxChildRequested;
        public long maxUpstreamRequested;
        public final AtomicInteger management = new AtomicInteger();
        public final AtomicReference<InnerSubscription<T>[]> subscribers = new AtomicReference<>(f7089);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplaySubscriber(InterfaceC2048<T> interfaceC2048) {
            this.buffer = interfaceC2048;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.subscribers.set(f7090);
            SubscriptionHelper.cancel(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.subscribers.get() == f7090;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.buffer.complete();
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f7090)) {
                this.buffer.mo6594(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.buffer.mo6593(th);
            for (InnerSubscription<T> innerSubscription : this.subscribers.getAndSet(f7090)) {
                this.buffer.mo6594(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            this.buffer.mo6592(t);
            for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                this.buffer.mo6594(innerSubscription);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                m6607();
                for (InnerSubscription<T> innerSubscription : this.subscribers.get()) {
                    this.buffer.mo6594(innerSubscription);
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m6606(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            innerSubscription.getClass();
            do {
                innerSubscriptionArr = this.subscribers.get();
                if (innerSubscriptionArr == f7090) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!C4905.m14631(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6607() {
            if (this.management.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (!isDisposed()) {
                InnerSubscription<T>[] innerSubscriptionArr = this.subscribers.get();
                long j = this.maxChildRequested;
                long jMax = j;
                for (InnerSubscription<T> innerSubscription : innerSubscriptionArr) {
                    jMax = Math.max(jMax, innerSubscription.totalRequested.get());
                }
                long j2 = this.maxUpstreamRequested;
                Subscription subscription = get();
                long j3 = jMax - j;
                if (j3 != 0) {
                    this.maxChildRequested = jMax;
                    if (subscription == null) {
                        long j4 = j2 + j3;
                        if (j4 < 0) {
                            j4 = Long.MAX_VALUE;
                        }
                        this.maxUpstreamRequested = j4;
                    } else if (j2 != 0) {
                        this.maxUpstreamRequested = 0L;
                        subscription.request(j2 + j3);
                    } else {
                        subscription.request(j3);
                    }
                } else if (j2 != 0 && subscription != null) {
                    this.maxUpstreamRequested = 0L;
                    subscription.request(j2);
                }
                iAddAndGet = this.management.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6608(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.subscribers.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i2].equals(innerSubscription)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = f7089;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i);
                    System.arraycopy(innerSubscriptionArr, i + 1, innerSubscriptionArr3, i, (length - i) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!C4905.m14631(this.subscribers, innerSubscriptionArr, innerSubscriptionArr2));
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final AbstractC4585 scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.scheduler = abstractC4585;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: ԫ */
        public Object mo6596(Object obj) {
            return new o2(obj, this.scheduler.m14050(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: Ԭ */
        public Node mo6597() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                o2 o2Var = (o2) node2.value;
                if (NotificationLite.isComplete(o2Var.m7668()) || NotificationLite.isError(o2Var.m7668()) || o2Var.m7667() > jM14050) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: ԭ */
        public Object mo6598(Object obj) {
            return ((o2) obj).m7668();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: ֈ */
        public void mo6602() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i2 = this.size;
                if (i2 > this.limit && i2 > 1) {
                    i++;
                    this.size = i2 - 1;
                    node3 = node2.get();
                } else {
                    if (((o2) node2.value).m7667() > jM14050) {
                        break;
                    }
                    i++;
                    this.size--;
                    node3 = node2.get();
                }
            }
            if (i != 0) {
                m6600(node);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: ֏ */
        public void mo6603() {
            Node node;
            long jM14050 = this.scheduler.m14050(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.size <= 1 || ((o2) node2.value).m7667() > jM14050) {
                    break;
                }
                i++;
                this.size--;
                node3 = node2.get();
            }
            if (i != 0) {
                m6600(node);
            }
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /* renamed from: ֈ */
        public void mo6602() {
            if (this.size > this.limit) {
                m6599();
            }
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements InterfaceC2048<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: Ϳ */
        public void mo6592(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: Ԩ */
        public void mo6593(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.InterfaceC2048
        /* renamed from: ԩ */
        public void mo6594(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.emitting) {
                    innerSubscription.missed = true;
                    return;
                }
                innerSubscription.emitting = true;
                Subscriber<? super T> subscriber = innerSubscription.child;
                while (!innerSubscription.isDisposed()) {
                    int i = this.size;
                    Integer num = (Integer) innerSubscription.m6604();
                    int iIntValue = num != null ? num.intValue() : 0;
                    long j = innerSubscription.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && iIntValue < i) {
                        Object obj = get(iIntValue);
                        try {
                            if (NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                return;
                            }
                            iIntValue++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            C4089.m13026(th);
                            innerSubscription.dispose();
                            if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                                return;
                            }
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        innerSubscription.index = Integer.valueOf(iIntValue);
                        if (j != Long.MAX_VALUE) {
                            innerSubscription.m6605(j3);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.missed) {
                            innerSubscription.emitting = false;
                            return;
                        }
                        innerSubscription.missed = false;
                    }
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ϳ, reason: contains not printable characters */
    public static final class C2044<T> extends AbstractC3731<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3731<T> f7091;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC3630<T> f7092;

        public C2044(AbstractC3731<T> abstractC3731, AbstractC3630<T> abstractC3630) {
            this.f7091 = abstractC3731;
            this.f7092 = abstractC3630;
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.f7092.subscribe(subscriber);
        }

        @Override // defpackage.AbstractC3731
        /* renamed from: Ԫ */
        public void mo6552(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
            this.f7091.mo6552(interfaceC2857);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ԩ, reason: contains not printable characters */
    public static final class CallableC2045 implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ԫ, reason: contains not printable characters */
    public static final class C2046<R, U> extends AbstractC3630<R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Callable<? extends AbstractC3731<U>> f7093;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super AbstractC3630<U>, ? extends Publisher<R>> f7094;

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ԫ$Ϳ, reason: contains not printable characters */
        public final class C2047 implements InterfaceC2857<InterfaceC4478> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final SubscriberResourceWrapper<R> f7095;

            public C2047(SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.f7095 = subscriberResourceWrapper;
            }

            @Override // defpackage.InterfaceC2857
            /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void accept(InterfaceC4478 interfaceC4478) {
                this.f7095.m7007(interfaceC4478);
            }
        }

        public C2046(Callable<? extends AbstractC3731<U>> callable, InterfaceC2368<? super AbstractC3630<U>, ? extends Publisher<R>> interfaceC2368) {
            this.f7093 = callable;
            this.f7094 = interfaceC2368;
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                AbstractC3731 abstractC3731 = (AbstractC3731) C4246.m13353(this.f7093.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) C4246.m13353(this.f7094.apply(abstractC3731), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    abstractC3731.mo6552(new C2047(subscriberResourceWrapper));
                } catch (Throwable th) {
                    C4089.m13026(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ԭ, reason: contains not printable characters */
    public interface InterfaceC2048<T> {
        void complete();

        /* renamed from: Ϳ */
        void mo6592(T t);

        /* renamed from: Ԩ */
        void mo6593(Throwable th);

        /* renamed from: ԩ */
        void mo6594(InnerSubscription<T> innerSubscription);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$Ԯ, reason: contains not printable characters */
    public static final class CallableC2049<T> implements Callable<InterfaceC2048<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f7097;

        public CallableC2049(int i) {
            this.f7097 = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2048<T> call() {
            return new SizeBoundReplayBuffer(this.f7097);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$ՠ, reason: contains not printable characters */
    public static final class C2050<T> implements Publisher<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<ReplaySubscriber<T>> f7098;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Callable<? extends InterfaceC2048<T>> f7099;

        public C2050(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends InterfaceC2048<T>> callable) {
            this.f7098 = atomicReference;
            this.f7099 = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.f7098.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.f7099.call());
                    if (C4905.m14631(this.f7098, null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
            subscriber.onSubscribe(innerSubscription);
            replaySubscriber.m6606(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.m6608(innerSubscription);
            } else {
                replaySubscriber.m6607();
                replaySubscriber.buffer.mo6594(innerSubscription);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReplay$ֈ, reason: contains not printable characters */
    public static final class CallableC2051<T> implements Callable<InterfaceC2048<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f7100;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f7101;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f7102;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585 f7103;

        public CallableC2051(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f7100 = i;
            this.f7101 = j;
            this.f7102 = timeUnit;
            this.f7103 = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2048<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f7100, this.f7101, this.f7102, this.f7103);
        }
    }

    public FlowableReplay(Publisher<T> publisher, AbstractC3630<T> abstractC3630, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends InterfaceC2048<T>> callable) {
        this.f7088 = publisher;
        this.f7085 = abstractC3630;
        this.f7086 = atomicReference;
        this.f7087 = callable;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6585(AbstractC3630<T> abstractC3630, int i) {
        return i == Integer.MAX_VALUE ? m6589(abstractC3630) : m6588(abstractC3630, new CallableC2049(i));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6586(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return m6587(abstractC3630, j, timeUnit, abstractC4585, Integer.MAX_VALUE);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6587(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        return m6588(abstractC3630, new CallableC2051(i, j, timeUnit, abstractC4585));
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6588(AbstractC3630<T> abstractC3630, Callable<? extends InterfaceC2048<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return C3671.m11794(new FlowableReplay(new C2050(atomicReference, callable), abstractC3630, atomicReference, callable));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6589(AbstractC3630<? extends T> abstractC3630) {
        return m6588(abstractC3630, f7084);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <U, R> AbstractC3630<R> m6590(Callable<? extends AbstractC3731<U>> callable, InterfaceC2368<? super AbstractC3630<U>, ? extends Publisher<R>> interfaceC2368) {
        return new C2046(callable, interfaceC2368);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T> AbstractC3731<T> m6591(AbstractC3731<T> abstractC3731, AbstractC4585 abstractC4585) {
        return C3671.m11794(new C2044(abstractC3731, abstractC3731.observeOn(abstractC4585)));
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f7088.subscribe(subscriber);
    }

    @Override // defpackage.InterfaceC4503
    /* renamed from: ԩ */
    public void mo6557(InterfaceC4478 interfaceC4478) {
        C4905.m14631(this.f7086, (ReplaySubscriber) interfaceC4478, null);
    }

    @Override // defpackage.AbstractC3731
    /* renamed from: Ԫ */
    public void mo6552(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.f7086.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.f7087.call());
                if (C4905.m14631(this.f7086, replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                C4089.m13026(th);
                RuntimeException runtimeExceptionM7024 = ExceptionHelper.m7024(th);
            }
        }
        boolean z = !replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true);
        try {
            interfaceC2857.accept(replaySubscriber);
            if (z) {
                this.f7085.subscribe((InterfaceC3899) replaySubscriber);
            }
        } catch (Throwable th) {
            if (z) {
                replaySubscriber.shouldConnect.compareAndSet(true, false);
            }
            throw ExceptionHelper.m7024(th);
        }
    }
}
