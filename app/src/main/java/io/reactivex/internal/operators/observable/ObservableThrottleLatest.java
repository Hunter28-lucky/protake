package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.AbstractC4585;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableThrottleLatest<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7509;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7510;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7511;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean f7512;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final InterfaceC5102<? super T> downstream;
        public final boolean emitLast;
        public Throwable error;
        public final AtomicReference<T> latest = new AtomicReference<>();
        public final long timeout;
        public volatile boolean timerFired;
        public boolean timerRunning;
        public final TimeUnit unit;
        public InterfaceC4478 upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public ThrottleLatestObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588, boolean z) {
            this.downstream = interfaceC5102;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
            this.emitLast = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6913();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6913();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.latest.set(t);
            m6913();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            m6913();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6913() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.latest;
            InterfaceC5102<? super T> interfaceC5102 = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.error != null) {
                    atomicReference.lazySet(null);
                    interfaceC5102.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                boolean z2 = atomicReference.get() == null;
                if (z) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z2 && this.emitLast) {
                        interfaceC5102.onNext(andSet);
                    }
                    interfaceC5102.onComplete();
                    this.worker.dispose();
                    return;
                }
                if (z2) {
                    if (this.timerFired) {
                        this.timerRunning = false;
                        this.timerFired = false;
                    }
                } else if (!this.timerRunning || this.timerFired) {
                    interfaceC5102.onNext(atomicReference.getAndSet(null));
                    this.timerFired = false;
                    this.timerRunning = true;
                    this.worker.mo6991(this, this.timeout, this.unit);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }
    }

    public ObservableThrottleLatest(AbstractC4262<T> abstractC4262, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        super(abstractC4262);
        this.f7509 = j;
        this.f7510 = timeUnit;
        this.f7511 = abstractC4585;
        this.f7512 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new ThrottleLatestObserver(interfaceC5102, this.f7509, this.f7510, this.f7511.mo6986(), this.f7512));
    }
}
