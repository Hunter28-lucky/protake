package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<U> f7308;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends Open> f7309;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super Open, ? extends InterfaceC2856<? extends Close>> f7310;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -8466418554264089604L;
        public final InterfaceC2368<? super Open, ? extends InterfaceC2856<? extends Close>> bufferClose;
        public final InterfaceC2856<? extends Open> bufferOpen;
        public final Callable<C> bufferSupplier;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final InterfaceC5102<? super C> downstream;
        public long index;
        public final d<C> queue = new d<>(AbstractC4262.bufferSize());
        public final C2527 observers = new C2527();
        public final AtomicReference<InterfaceC4478> upstream = new AtomicReference<>();
        public Map<Long, C> buffers = new LinkedHashMap();
        public final AtomicThrowable errors = new AtomicThrowable();

        public static final class BufferOpenObserver<Open> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Open>, InterfaceC4478 {
            private static final long serialVersionUID = -8498650778633225126L;
            public final BufferBoundaryObserver<?, ?, Open, ?> parent;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // defpackage.InterfaceC4478
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // defpackage.InterfaceC4478
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // defpackage.InterfaceC5102
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.m6738(this);
            }

            @Override // defpackage.InterfaceC5102
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.m6734(this, th);
            }

            @Override // defpackage.InterfaceC5102
            public void onNext(Open open) {
                this.parent.m6737(open);
            }

            @Override // defpackage.InterfaceC5102
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }
        }

        public BufferBoundaryObserver(InterfaceC5102<? super C> interfaceC5102, InterfaceC2856<? extends Open> interfaceC2856, InterfaceC2368<? super Open, ? extends InterfaceC2856<? extends Close>> interfaceC2368, Callable<C> callable) {
            this.downstream = interfaceC5102;
            this.bufferSupplier = callable;
            this.bufferOpen = interfaceC2856;
            this.bufferClose = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                m6736();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            m6736();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this.upstream, interfaceC4478)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.mo9333(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6734(InterfaceC4478 interfaceC4478, Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.observers.mo9335(interfaceC4478);
            onError(th);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6735(BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            boolean z;
            this.observers.mo9335(bufferCloseObserver);
            if (this.observers.m9338() == 0) {
                DisposableHelper.dispose(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                this.queue.offer(map.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                m6736();
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6736() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super C> interfaceC5102 = this.downstream;
            d<C> dVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.errors.get() != null) {
                    dVar.clear();
                    interfaceC5102.onError(this.errors.m7019());
                    return;
                }
                C cPoll = dVar.poll();
                boolean z2 = cPoll == null;
                if (z && z2) {
                    interfaceC5102.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    interfaceC5102.onNext(cPoll);
                }
            }
            dVar.clear();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6737(Open open) {
            try {
                Collection collection = (Collection) C4246.m13353(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                InterfaceC2856 interfaceC2856 = (InterfaceC2856) C4246.m13353(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
                    this.observers.mo9333(bufferCloseObserver);
                    interfaceC2856.subscribe(bufferCloseObserver);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                DisposableHelper.dispose(this.upstream);
                onError(th);
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6738(BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.mo9335(bufferOpenObserver);
            if (this.observers.m9338() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                m6736();
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<Object>, InterfaceC4478 {
        private static final long serialVersionUID = -8498650778633225126L;
        public final long index;
        public final BufferBoundaryObserver<T, C, ?, ?> parent;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.parent = bufferBoundaryObserver;
            this.index = j;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.m6735(this, this.index);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 == disposableHelper) {
                C3671.m11803(th);
            } else {
                lazySet(disposableHelper);
                this.parent.m6734(this, th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(Object obj) {
            InterfaceC4478 interfaceC4478 = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (interfaceC4478 != disposableHelper) {
                lazySet(disposableHelper);
                interfaceC4478.dispose();
                this.parent.m6735(this, this.index);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this, interfaceC4478);
        }
    }

    public ObservableBufferBoundary(InterfaceC2856<T> interfaceC2856, InterfaceC2856<? extends Open> interfaceC28562, InterfaceC2368<? super Open, ? extends InterfaceC2856<? extends Close>> interfaceC2368, Callable<U> callable) {
        super(interfaceC2856);
        this.f7309 = interfaceC28562;
        this.f7310 = interfaceC2368;
        this.f7308 = callable;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(interfaceC5102, this.f7309, this.f7310, this.f7308);
        interfaceC5102.onSubscribe(bufferBoundaryObserver);
        this.f11778.subscribe(bufferBoundaryObserver);
    }
}
