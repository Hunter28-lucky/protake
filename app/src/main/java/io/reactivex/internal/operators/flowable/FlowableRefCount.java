package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC3731;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.InterfaceC4514;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRefCount<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3731<T> f7075;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7076;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7077;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7078;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7079;

    /* renamed from: ՠ, reason: contains not printable characters */
    public RefConnection f7080;

    public static final class RefConnection extends AtomicReference<InterfaceC4478> implements Runnable, InterfaceC2857<InterfaceC4478> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final FlowableRefCount<?> parent;
        public long subscriberCount;
        public InterfaceC4478 timer;

        public RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.m6580(this);
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(InterfaceC4478 interfaceC4478) throws Exception {
            DisposableHelper.replace(this, interfaceC4478);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((InterfaceC4503) this.parent.f7075).mo6557(interfaceC4478);
                }
            }
        }
    }

    public static final class RefCountSubscriber<T> extends AtomicBoolean implements InterfaceC3899<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final Subscriber<? super T> downstream;
        public final FlowableRefCount<T> parent;
        public Subscription upstream;

        public RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.m6576(this.connection);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.m6579(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                C3671.m11803(th);
            } else {
                this.parent.m6579(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
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
            this.upstream.request(j);
        }
    }

    public FlowableRefCount(AbstractC3731<T> abstractC3731) {
        this(abstractC3731, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        InterfaceC4478 interfaceC4478;
        synchronized (this) {
            refConnection = this.f7080;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f7080 = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (interfaceC4478 = refConnection.timer) != null) {
                interfaceC4478.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.f7076) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f7075.subscribe((InterfaceC3899) new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.f7075.mo6552(refConnection);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6576(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f7080;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.f7077 == 0) {
                        m6580(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.m6311(this.f7079.mo6988(refConnection, this.f7077, this.f7078));
                }
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6577(RefConnection refConnection) {
        InterfaceC4478 interfaceC4478 = refConnection.timer;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
            refConnection.timer = null;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m6578(RefConnection refConnection) {
        AbstractC3731<T> abstractC3731 = this.f7075;
        if (abstractC3731 instanceof InterfaceC4478) {
            ((InterfaceC4478) abstractC3731).dispose();
        } else if (abstractC3731 instanceof InterfaceC4503) {
            ((InterfaceC4503) abstractC3731).mo6557(refConnection.get());
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m6579(RefConnection refConnection) {
        synchronized (this) {
            if (this.f7075 instanceof InterfaceC4514) {
                RefConnection refConnection2 = this.f7080;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f7080 = null;
                    m6577(refConnection);
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    m6578(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f7080;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    m6577(refConnection);
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.f7080 = null;
                        m6578(refConnection);
                    }
                }
            }
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m6580(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f7080) {
                this.f7080 = null;
                InterfaceC4478 interfaceC4478 = refConnection.get();
                DisposableHelper.dispose(refConnection);
                AbstractC3731<T> abstractC3731 = this.f7075;
                if (abstractC3731 instanceof InterfaceC4478) {
                    ((InterfaceC4478) abstractC3731).dispose();
                } else if (abstractC3731 instanceof InterfaceC4503) {
                    if (interfaceC4478 == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((InterfaceC4503) abstractC3731).mo6557(interfaceC4478);
                    }
                }
            }
        }
    }

    public FlowableRefCount(AbstractC3731<T> abstractC3731, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7075 = abstractC3731;
        this.f7076 = i;
        this.f7077 = j;
        this.f7078 = timeUnit;
        this.f7079 = abstractC4585;
    }
}
