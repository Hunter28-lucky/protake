package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleFlatMap<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7586;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> f7587;

    public static final class SingleFlatMapCallback<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = 3258103020495908596L;
        public final InterfaceC4782<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> mapper;

        /* renamed from: io.reactivex.internal.operators.single.SingleFlatMap$SingleFlatMapCallback$Ϳ, reason: contains not printable characters */
        public static final class C2106<R> implements InterfaceC4782<R> {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final AtomicReference<InterfaceC4478> f7588;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final InterfaceC4782<? super R> f7589;

            public C2106(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4782<? super R> interfaceC4782) {
                this.f7588 = atomicReference;
                this.f7589 = interfaceC4782;
            }

            @Override // defpackage.InterfaceC4782
            public void onError(Throwable th) {
                this.f7589.onError(th);
            }

            @Override // defpackage.InterfaceC4782
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.replace(this.f7588, interfaceC4478);
            }

            @Override // defpackage.InterfaceC4782
            public void onSuccess(R r) {
                this.f7589.onSuccess(r);
            }
        }

        public SingleFlatMapCallback(InterfaceC4782<? super R> interfaceC4782, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
            this.downstream = interfaceC4782;
            this.mapper = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                InterfaceC3951 interfaceC3951 = (InterfaceC3951) C4246.m13353(this.mapper.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                interfaceC3951.subscribe(new C2106(this, this.downstream));
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }
    }

    public SingleFlatMap(InterfaceC3951<? extends T> interfaceC3951, InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        this.f7587 = interfaceC2368;
        this.f7586 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        this.f7586.subscribe(new SingleFlatMapCallback(interfaceC4782, this.f7587));
    }
}
