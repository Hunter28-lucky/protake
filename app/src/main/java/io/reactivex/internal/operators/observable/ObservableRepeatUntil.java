package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC2881;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableRepeatUntil<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2881 f7433;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements InterfaceC5102<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC2856<? extends T> source;
        public final InterfaceC2881 stop;
        public final SequentialDisposable upstream;

        public RepeatUntilObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC2881 interfaceC2881, SequentialDisposable sequentialDisposable, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.upstream = sequentialDisposable;
            this.source = interfaceC2856;
            this.stop = interfaceC2881;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            try {
                if (this.stop.mo6378()) {
                    this.downstream.onComplete();
                } else {
                    m6849();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.upstream.m6311(interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6849() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public ObservableRepeatUntil(AbstractC4262<T> abstractC4262, InterfaceC2881 interfaceC2881) {
        super(abstractC4262);
        this.f7433 = interfaceC2881;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC5102.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(interfaceC5102, this.f7433, sequentialDisposable, this.f11778).m6849();
    }
}
