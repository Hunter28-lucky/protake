package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class ObservableTakeLastTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7499;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7500;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final TimeUnit f7501;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7502;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f7503;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean f7504;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final long count;
        public final boolean delayError;
        public final InterfaceC5102<? super T> downstream;
        public Throwable error;
        public final d<Object> queue;
        public final AbstractC4585 scheduler;
        public final long time;
        public final TimeUnit unit;
        public InterfaceC4478 upstream;

        public TakeLastTimedObserver(InterfaceC5102<? super T> interfaceC5102, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
            this.downstream = interfaceC5102;
            this.count = j;
            this.time = j2;
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
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            m6910();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.error = th;
            m6910();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            d<Object> dVar = this.queue;
            long jM14050 = this.scheduler.m14050(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            dVar.m5884(Long.valueOf(jM14050), t);
            while (!dVar.isEmpty()) {
                if (((Long) dVar.m5885()).longValue() > jM14050 - j && (z || (dVar.m5887() >> 1) <= j2)) {
                    return;
                }
                dVar.poll();
                dVar.poll();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6910() {
            Throwable th;
            if (compareAndSet(false, true)) {
                InterfaceC5102<? super T> interfaceC5102 = this.downstream;
                d<Object> dVar = this.queue;
                boolean z = this.delayError;
                long jM14050 = this.scheduler.m14050(this.unit) - this.time;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        dVar.clear();
                        interfaceC5102.onError(th);
                        return;
                    }
                    Object objPoll = dVar.poll();
                    if (objPoll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            interfaceC5102.onError(th2);
                            return;
                        } else {
                            interfaceC5102.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = dVar.poll();
                    if (((Long) objPoll).longValue() >= jM14050) {
                        interfaceC5102.onNext(objPoll2);
                    }
                }
                dVar.clear();
            }
        }
    }

    public ObservableTakeLastTimed(InterfaceC2856<T> interfaceC2856, long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, boolean z) {
        super(interfaceC2856);
        this.f7499 = j;
        this.f7500 = j2;
        this.f7501 = timeUnit;
        this.f7502 = abstractC4585;
        this.f7503 = i;
        this.f7504 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new TakeLastTimedObserver(interfaceC5102, this.f7499, this.f7500, this.f7501, this.f7502, this.f7503, this.f7504));
    }
}
