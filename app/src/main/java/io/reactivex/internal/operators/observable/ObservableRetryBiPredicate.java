package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5324;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super Integer, ? super Throwable> f7454;

    public static final class RetryBiObserver<T> extends AtomicInteger implements InterfaceC5102<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC5324<? super Integer, ? super Throwable> predicate;
        public int retries;
        public final InterfaceC2856<? extends T> source;
        public final SequentialDisposable upstream;

        public RetryBiObserver(InterfaceC5102<? super T> interfaceC5102, InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324, SequentialDisposable sequentialDisposable, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.upstream = sequentialDisposable;
            this.source = interfaceC2856;
            this.predicate = interfaceC5324;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            try {
                InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324 = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (interfaceC5324.test(Integer.valueOf(i), th)) {
                    m6879();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
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
        public void m6879() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryBiPredicate(AbstractC4262<T> abstractC4262, InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324) {
        super(abstractC4262);
        this.f7454 = interfaceC5324;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC5102.onSubscribe(sequentialDisposable);
        new RetryBiObserver(interfaceC5102, this.f7454, sequentialDisposable, this.f11778).m6879();
    }
}
