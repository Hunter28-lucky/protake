package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC4262;
import defpackage.C3671;
import defpackage.C4053;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4905;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class ObservableSwitchMapSingle<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f7286;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7287;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f7288;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements InterfaceC5102<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final SwitchMapSingleObserver<Object> f7289 = new SwitchMapSingleObserver<>(null);
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final InterfaceC5102<? super R> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;
        public InterfaceC4478 upstream;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapSingleMainObserver<?, R> parent;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.parent = switchMapSingleMainObserver;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.parent.m6727(this, th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                this.item = r;
                this.parent.m6726();
            }

            /* renamed from: Ϳ, reason: contains not printable characters */
            public void m6728() {
                DisposableHelper.dispose(this);
            }
        }

        public SwitchMapSingleMainObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
            this.downstream = interfaceC5102;
            this.mapper = interfaceC2368;
            this.delayErrors = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            m6725();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.done = true;
            m6726();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (!this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                m6725();
            }
            this.done = true;
            m6726();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.m6728();
            }
            try {
                InterfaceC3951 interfaceC3951 = (InterfaceC3951) C4246.m13353(this.mapper.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == f7289) {
                        return;
                    }
                } while (!C4905.m14631(this.inner, switchMapSingleObserver, switchMapSingleObserver3));
                interfaceC3951.subscribe(switchMapSingleObserver3);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.upstream.dispose();
                this.inner.getAndSet(f7289);
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
        public void m6725() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f7289;
            SwitchMapSingleObserver<Object> switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            switchMapSingleObserver2.m6728();
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6726() {
            if (getAndIncrement() != 0) {
                return;
            }
            InterfaceC5102<? super R> interfaceC5102 = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    interfaceC5102.onError(atomicThrowable.m7019());
                    return;
                }
                boolean z = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
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
                if (z2 || switchMapSingleObserver.item == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    C4905.m14631(atomicReference, switchMapSingleObserver, null);
                    interfaceC5102.onNext(switchMapSingleObserver.item);
                }
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m6727(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!C4905.m14631(this.inner, switchMapSingleObserver, null) || !this.errors.m7018(th)) {
                C3671.m11803(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                m6725();
            }
            m6726();
        }
    }

    public ObservableSwitchMapSingle(AbstractC4262<T> abstractC4262, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        this.f7286 = abstractC4262;
        this.f7287 = interfaceC2368;
        this.f7288 = z;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        if (C4053.m12974(this.f7286, this.f7287, interfaceC5102)) {
            return;
        }
        this.f7286.subscribe(new SwitchMapSingleMainObserver(interfaceC5102, this.f7287, this.f7288));
    }
}
