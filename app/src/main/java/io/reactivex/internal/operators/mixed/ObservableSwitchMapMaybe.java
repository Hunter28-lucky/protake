package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4053;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapMaybe<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f7282;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> f7283;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7284;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapMaybeObserver<Object> f7285 = new SwitchMapMaybeObserver<>(null);
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
        public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> mapper;
        public InterfaceC4478 upstream;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC5216<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapMaybeMainObserver<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.parent = switchMapMaybeMainObserver;
            }

            @Override // defpackage.InterfaceC5216
            public void onComplete() {
                this.parent.m6722(this);
            }

            @Override // defpackage.InterfaceC5216
            public void onError(Throwable th) {
                this.parent.m6723(this, th);
            }

            @Override // defpackage.InterfaceC5216
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC5216
            public void onSuccess(R r) {
                this.item = r;
                this.parent.m6721();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6724() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapMaybeMainObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            m6720();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6721();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6720();
            }
            this.done = true;
            m6721();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.m6724();
            }
            try {
                InterfaceC3517 interfaceC3517 = (InterfaceC3517) C4246.m13353(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == f7285) {
                        return;
                    }
                } while (!C4905.m14631(this.inner, switchMapMaybeObserver, switchMapMaybeObserver3));
                interfaceC3517.mo11463(switchMapMaybeObserver3);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.dispose();
                this.inner.getAndSet(f7285);
                onError(th);
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
        public void m6720() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f7285;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            switchMapMaybeObserver2.m6724();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6721() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    interfaceC5102.onError(atomicThrowable.m7019());
                    return;
                }
                boolean z = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
                if (z && z2) {
                    Throwable thM7019 = atomicThrowable.m7019();
                    if (thM7019 != null) {
                        interfaceC5102.onError(thM7019);
                        return;
                    } else {
                        interfaceC5102.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapMaybeObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    C4905.m14631(atomicReference, switchMapMaybeObserver, null);
                    interfaceC5102.onNext(switchMapMaybeObserver.item);
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6722(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (C4905.m14631(this.inner, switchMapMaybeObserver, null)) {
                m6721();
            }
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6723(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!C4905.m14631(this.inner, switchMapMaybeObserver, null) || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                m6720();
            }
            m6721();
        }
    }

    public ObservableSwitchMapMaybe(AbstractC4262<T> abstractC4262, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
        this.f7282 = abstractC4262;
        this.f7283 = interfaceC2368;
        this.f7284 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        if (C4053.m12973(this.f7282, this.f7283, interfaceC5102)) {
            return;
        }
        this.f7282.subscribe(new SwitchMapMaybeMainObserver(interfaceC5102, this.f7283, this.f7284));
    }
}
