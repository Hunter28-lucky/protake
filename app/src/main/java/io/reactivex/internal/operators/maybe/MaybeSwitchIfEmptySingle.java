package io.reactivex.internal.operators.maybe;

import defpackage.AbstractC4838;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MaybeSwitchIfEmptySingle<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3517<T> f7221;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7222;

    public static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC5216<T>, InterfaceC4478 {
        private static final long serialVersionUID = 4603919676453758899L;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC3951<? extends T> other;

        /* renamed from: io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$Ϳ, reason: contains not printable characters */
        public static final class C2071<T> implements InterfaceC4782<T> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final InterfaceC4782<? super T> f7223;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final AtomicReference<InterfaceC4478> f7224;

            public C2071(InterfaceC4782<? super T> interfaceC4782, AtomicReference<InterfaceC4478> atomicReference) {
                this.f7223 = interfaceC4782;
                this.f7224 = atomicReference;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.f7223.onError(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(this.f7224, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(T t) {
                this.f7223.onSuccess(t);
            }
        }

        public SwitchIfEmptyMaybeObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC3951<? extends T> interfaceC3951) {
            this.downstream = interfaceC4782;
            this.other = interfaceC3951;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5216
        public void onComplete() {
            InterfaceC4478 interfaceC4478 = get();
            if (interfaceC4478 == DisposableHelper.DISPOSED || !compareAndSet(interfaceC4478, null)) {
                return;
            }
            this.other.subscribe(new C2071(this.downstream, this));
        }

        @Override // defpackage.InterfaceC5216
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmptySingle(InterfaceC3517<T> interfaceC3517, InterfaceC3951<? extends T> interfaceC3951) {
        this.f7221 = interfaceC3517;
        this.f7222 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7221.mo11463(new SwitchIfEmptyMaybeObserver(interfaceC4782, this.f7222));
    }
}
