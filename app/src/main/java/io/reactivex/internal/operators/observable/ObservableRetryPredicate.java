package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class ObservableRetryPredicate<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super Throwable> f7455;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final long f7456;

    public static final class RepeatObserver<T> extends AtomicInteger implements InterfaceC5102<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final InterfaceC5102<? super T> downstream;
        public final InterfaceC4178<? super Throwable> predicate;
        public long remaining;
        public final InterfaceC2856<? extends T> source;
        public final SequentialDisposable upstream;

        public RepeatObserver(InterfaceC5102<? super T> interfaceC5102, long j, InterfaceC4178<? super Throwable> interfaceC4178, SequentialDisposable sequentialDisposable, InterfaceC2856<? extends T> interfaceC2856) {
            this.downstream = interfaceC5102;
            this.upstream = sequentialDisposable;
            this.source = interfaceC2856;
            this.predicate = interfaceC4178;
            this.remaining = j;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th);
                return;
            }
            try {
                if (this.predicate.test(th)) {
                    m6880();
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
        public void m6880() {
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

    public ObservableRetryPredicate(AbstractC4262<T> abstractC4262, long j, InterfaceC4178<? super Throwable> interfaceC4178) {
        super(abstractC4262);
        this.f7455 = interfaceC4178;
        this.f7456 = j;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        interfaceC5102.onSubscribe(sequentialDisposable);
        new RepeatObserver(interfaceC5102, this.f7456, this.f7455, sequentialDisposable, this.f11778).m6880();
    }
}
