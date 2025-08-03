package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableRepeat<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7432;

    public static final class RepeatObserver<T> extends AtomicInteger implements InterfaceC5102<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final InterfaceC5102<? super T> downstream;
        public long remaining;
        public final SequentialDisposable sd;
        public final InterfaceC2856<? extends T> source;

        public RepeatObserver(InterfaceC5102<? super T> interfaceC5102, long j, SequentialDisposable sequentialDisposable, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.sd = sequentialDisposable;
            this.source = interfaceC2856;
            this.remaining = j;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                m6848();
            } else {
                this.downstream.onComplete();
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
            this.sd.m6311(interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6848() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRepeat(AbstractC4262<T> abstractC4262, long j) {
        super(abstractC4262);
        this.f7432 = j;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC5102.onSubscribe(sequentialDisposable);
        long j = this.f7432;
        new RepeatObserver(interfaceC5102, j != Long.MAX_VALUE ? j - 1 : Long.MAX_VALUE, sequentialDisposable, this.f11778).m6848();
    }
}
