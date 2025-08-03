package io.reactivex.internal.operators.observable;

import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.AbstractC4945;
import defpackage.C3671;
import defpackage.InterfaceC2664;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4503;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableRefCount<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4945<T> f7426;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f7427;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7428;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7429;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7430;

    /* renamed from: ՠ, reason: contains not printable characters */
    public RefConnection f7431;

    public static final class RefConnection extends AtomicReference<InterfaceC4478> implements Runnable, InterfaceC2857<InterfaceC4478> {
        private static final long serialVersionUID = -4552101107598366241L;
        public boolean connected;
        public boolean disconnectedEarly;
        public final ObservableRefCount<?> parent;
        public long subscriberCount;
        public InterfaceC4478 timer;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.m6846(this);
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(InterfaceC4478 interfaceC4478) throws Exception {
            DisposableHelper.replace(this, interfaceC4478);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((InterfaceC4503) this.parent.f7426).mo6557(interfaceC4478);
                }
            }
        }
    }

    public static final class RefCountObserver<T> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -7419642935409022375L;
        public final RefConnection connection;
        public final InterfaceC5102<? super T> downstream;
        public final ObservableRefCount<T> parent;
        public InterfaceC4478 upstream;

        public RefCountObserver(InterfaceC5102<? super T> interfaceC5102, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = interfaceC5102;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.m6842(this.connection);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.m6845(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                C3671.m11803(th);
            } else {
                this.parent.m6845(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(AbstractC4945<T> abstractC4945) {
        this(abstractC4945, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        RefConnection refConnection;
        boolean z;
        InterfaceC4478 interfaceC4478;
        synchronized (this) {
            refConnection = this.f7431;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f7431 = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (interfaceC4478 = refConnection.timer) != null) {
                interfaceC4478.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.f7427) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f7426.subscribe(new RefCountObserver(interfaceC5102, this, refConnection));
        if (z) {
            this.f7426.mo6834(refConnection);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m6842(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f7431;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.f7428 == 0) {
                        m6846(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.m6311(this.f7430.mo6988(refConnection, this.f7428, this.f7429));
                }
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6843(RefConnection refConnection) {
        InterfaceC4478 interfaceC4478 = refConnection.timer;
        if (interfaceC4478 != null) {
            interfaceC4478.dispose();
            refConnection.timer = null;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m6844(RefConnection refConnection) {
        AbstractC4945<T> abstractC4945 = this.f7426;
        if (abstractC4945 instanceof InterfaceC4478) {
            ((InterfaceC4478) abstractC4945).dispose();
        } else if (abstractC4945 instanceof InterfaceC4503) {
            ((InterfaceC4503) abstractC4945).mo6557(refConnection.get());
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m6845(RefConnection refConnection) {
        synchronized (this) {
            if (this.f7426 instanceof InterfaceC2664) {
                RefConnection refConnection2 = this.f7431;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f7431 = null;
                    m6843(refConnection);
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    m6844(refConnection);
                }
            } else {
                RefConnection refConnection3 = this.f7431;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    m6843(refConnection);
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.f7431 = null;
                        m6844(refConnection);
                    }
                }
            }
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m6846(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f7431) {
                this.f7431 = null;
                InterfaceC4478 interfaceC4478 = refConnection.get();
                DisposableHelper.dispose(refConnection);
                AbstractC4945<T> abstractC4945 = this.f7426;
                if (abstractC4945 instanceof InterfaceC4478) {
                    ((InterfaceC4478) abstractC4945).dispose();
                } else if (abstractC4945 instanceof InterfaceC4503) {
                    if (interfaceC4478 == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((InterfaceC4503) abstractC4945).mo6557(interfaceC4478);
                    }
                }
            }
        }
    }

    public ObservableRefCount(AbstractC4945<T> abstractC4945, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        this.f7426 = abstractC4945;
        this.f7427 = i;
        this.f7428 = j;
        this.f7429 = timeUnit;
        this.f7430 = abstractC4585;
    }
}
