package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C5312;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7506;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f7507;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final AbstractC4585 f7508;

    public static final class DebounceTimedObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<T>, InterfaceC4478, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        public boolean done;
        public final InterfaceC5102<? super T> downstream;
        public volatile boolean gate;
        public final long timeout;
        public final TimeUnit unit;
        public InterfaceC4478 upstream;
        public final AbstractC4585.AbstractC4588 worker;

        public DebounceTimedObserver(InterfaceC5102<? super T> interfaceC5102, long j, TimeUnit timeUnit, AbstractC4585.AbstractC4588 abstractC4588) {
            this.downstream = interfaceC5102;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = abstractC4588;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.done) {
                C3671.m11803(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.downstream.onNext(t);
            InterfaceC4478 interfaceC4478 = get();
            if (interfaceC4478 != null) {
                interfaceC4478.dispose();
            }
            DisposableHelper.replace(this, this.worker.mo6991(this, this.timeout, this.unit));
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
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(InterfaceC2856<T> interfaceC2856, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(interfaceC2856);
        this.f7506 = j;
        this.f7507 = timeUnit;
        this.f7508 = abstractC4585;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new DebounceTimedObserver(new C5312(interfaceC5102), this.f7506, this.f7507, this.f7508.mo6986()));
    }
}
