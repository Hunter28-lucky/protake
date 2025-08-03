package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableSkipLastTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7486;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7487;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7488;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f7489;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean f7490;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public final InterfaceC5102<? super T> downstream;
        public Throwable error;
        public final d<Object> queue;
        public final AbstractC4585 scheduler;
        public final long time;
        public final TimeUnit unit;
        public InterfaceC4478 upstream;

        public SkipLastTimedObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = abstractC4585;
            this.queue = new d<>(i);
            this.delayError = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6904();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m6904();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.queue.m5884(Long.valueOf(this.scheduler.m14050(this.unit)), t);
            m6904();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6904() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super T> interfaceC5102 = this.downstream;
            d<Object> dVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            AbstractC4585 abstractC4585 = this.scheduler;
            long j = this.time;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l = (Long) dVar.m5885();
                boolean z3 = l == null;
                long jM14050 = abstractC4585.m14050(timeUnit);
                if (!z3 && l.longValue() > jM14050 - j) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            interfaceC5102.onError(th);
                            return;
                        } else if (z3) {
                            interfaceC5102.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            interfaceC5102.onError(th2);
                            return;
                        } else {
                            interfaceC5102.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    dVar.poll();
                    interfaceC5102.onNext(dVar.poll());
                }
            }
            this.queue.clear();
        }
    }

    public ObservableSkipLastTimed(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
        super(interfaceC2856);
        this.f7486 = j;
        this.f7487 = timeUnit;
        this.f7488 = abstractC4585;
        this.f7489 = i;
        this.f7490 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new SkipLastTimedObserver(interfaceC5102, this.f7486, this.f7487, this.f7488, this.f7489, this.f7490));
    }
}
