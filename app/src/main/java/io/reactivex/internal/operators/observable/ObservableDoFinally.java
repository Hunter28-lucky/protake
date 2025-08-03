package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3164;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* loaded from: classes2.dex */
public final class ObservableDoFinally<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f7351;

    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements InterfaceC5102<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC3809 onFinally;
        public InterfaceC3164<T> qd;
        public boolean syncFused;
        public InterfaceC4478 upstream;

        public DoFinallyObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC3809 interfaceC3809) {
            this.downstream = interfaceC5102;
            this.onFinally = interfaceC3809;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.qd.clear();
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.upstream.dispose();
            m6766();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
            m6766();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
            m6766();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                if (interfaceC4478 instanceof InterfaceC3164) {
                    this.qd = (InterfaceC3164) interfaceC4478;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.qd.poll();
            if (tPoll == null && this.syncFused) {
                m6766();
            }
            return tPoll;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6766() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    C4089.m13026(th);
                    C3671.m11803(th);
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            InterfaceC3164<T> interfaceC3164 = this.qd;
            if (interfaceC3164 == null || (i & 4) != 0) {
                return 0;
            }
            int iMo6310 = interfaceC3164.mo6310(i);
            if (iMo6310 != 0) {
                this.syncFused = iMo6310 == 1;
            }
            return iMo6310;
        }
    }

    public ObservableDoFinally(InterfaceC2856<T> interfaceC2856, InterfaceC3809 interfaceC3809) {
        super(interfaceC2856);
        this.f7351 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new DoFinallyObserver(interfaceC5102, this.f7351));
    }
}
