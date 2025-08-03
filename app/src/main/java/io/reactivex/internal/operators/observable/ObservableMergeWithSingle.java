package io.reactivex.internal.operators.observable;

import defpackage.AbstractC3414;
import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.InterfaceC2475;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import defpackage.a;
import defpackage.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableMergeWithSingle<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7401;

    public static final class MergeWithObserver<T> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -4592979584110982903L;
        public volatile boolean disposed;
        public final InterfaceC5102<? super T> downstream;
        public volatile boolean mainDone;
        public volatile int otherState;
        public volatile InterfaceC2475<T> queue;
        public T singleItem;
        public final AtomicReference<InterfaceC4478> mainDisposable = new AtomicReference<>();
        public final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        public final AtomicThrowable error = new AtomicThrowable();

        public static final class OtherObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithObserver<T> parent;

            public OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.parent.m6826(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(T t) {
                this.parent.m6827(t);
            }
        }

        public MergeWithObserver(InterfaceC5102<? super T> interfaceC5102) {
            this.downstream = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.mainDone = true;
            m6823();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this.otherObserver);
                m6823();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                m6825().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6824();
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.setOnce(this.mainDisposable, interfaceC4478);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m6823() {
            if (getAndIncrement() == 0) {
                m6824();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6824() {
            InterfaceC5102<? super T> interfaceC5102 = this.downstream;
            int iAddAndGet = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    interfaceC5102.onError(this.error.m7019());
                    return;
                }
                int i = this.otherState;
                if (i == 1) {
                    T t = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    interfaceC5102.onNext(t);
                    i = 2;
                }
                boolean z = this.mainDone;
                InterfaceC2475<T> interfaceC2475 = this.queue;
                a aVarPoll = interfaceC2475 != null ? interfaceC2475.poll() : null;
                boolean z2 = aVarPoll == null;
                if (z && z2 && i == 2) {
                    this.queue = null;
                    interfaceC5102.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    interfaceC5102.onNext(aVarPoll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public InterfaceC2475<T> m6825() {
            InterfaceC2475<T> interfaceC2475 = this.queue;
            if (interfaceC2475 != null) {
                return interfaceC2475;
            }
            d dVar = new d(AbstractC4262.bufferSize());
            this.queue = dVar;
            return dVar;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6826(Throwable th) {
            if (!this.error.m7018(th)) {
                C3671.m11803(th);
            } else {
                DisposableHelper.dispose(this.mainDisposable);
                m6823();
            }
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m6827(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            m6824();
        }
    }

    public ObservableMergeWithSingle(AbstractC4262<T> abstractC4262, InterfaceC3951<? extends T> interfaceC3951) {
        super(abstractC4262);
        this.f7401 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(interfaceC5102);
        interfaceC5102.onSubscribe(mergeWithObserver);
        this.f11778.subscribe(mergeWithObserver);
        this.f7401.subscribe(mergeWithObserver.otherObserver);
    }
}
