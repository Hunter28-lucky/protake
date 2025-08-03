package io.reactivex.internal.operators.single;

import defpackage.AbstractC4274;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleFlatMapMaybe<T, R> extends AbstractC4274<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7596;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> f7597;

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5843758257109742742L;
        public final InterfaceC5216<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> mapper;

        public FlatMapSingleObserver(InterfaceC5216<? super R> interfaceC5216, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
            this.downstream = interfaceC5216;
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
                InterfaceC3517 interfaceC3517 = (InterfaceC3517) C4246.m13353(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC3517.mo11463(new C2107(this, this.downstream));
            } catch (Throwable th) {
                C4089.m13026(th);
                onError(th);
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleFlatMapMaybe$Ϳ, reason: contains not printable characters */
    public static final class C2107<R> implements InterfaceC5216<R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f7598;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5216<? super R> f7599;

        public C2107(AtomicReference<InterfaceC4478> atomicReference, InterfaceC5216<? super R> interfaceC5216) {
            this.f7598 = atomicReference;
            this.f7599 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC5216
        public void onComplete() {
            this.f7599.onComplete();
        }

        @Override // defpackage.InterfaceC5216
        public void onError(Throwable th) {
            this.f7599.onError(th);
        }

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this.f7598, interfaceC4478);
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(R r) {
            this.f7599.onSuccess(r);
        }
    }

    public SingleFlatMapMaybe(InterfaceC3951<? extends T> interfaceC3951, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        this.f7597 = interfaceC2368;
        this.f7596 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super R> interfaceC5216) {
        this.f7596.subscribe(new FlatMapSingleObserver(interfaceC5216, this.f7597));
    }
}
