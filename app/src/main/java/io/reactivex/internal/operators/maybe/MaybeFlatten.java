package io.reactivex.internal.operators.maybe;

import defpackage.AbstractC3265;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3517;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5216;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MaybeFlatten<T, R> extends AbstractC3265<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> f7219;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC5216<T>, InterfaceC4478 {
        private static final long serialVersionUID = 4375739915521278546L;
        public final InterfaceC5216<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> mapper;
        public InterfaceC4478 upstream;

        /* renamed from: io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver$Ϳ, reason: contains not printable characters */
        public final class C2070 implements InterfaceC5216<R> {
            public C2070() {
            }

            @Override // defpackage.InterfaceC5216
            public void onComplete() {
                FlatMapMaybeObserver.this.downstream.onComplete();
            }

            @Override // defpackage.InterfaceC5216
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.downstream.onError(th);
            }

            @Override // defpackage.InterfaceC5216
            public void onSubscribe(InterfaceC4478 interfaceC4478) {
                DisposableHelper.setOnce(FlatMapMaybeObserver.this, interfaceC4478);
            }

            @Override // defpackage.InterfaceC5216
            public void onSuccess(R r) {
                FlatMapMaybeObserver.this.downstream.onSuccess(r);
            }
        }

        public FlatMapMaybeObserver(InterfaceC5216<? super R> interfaceC5216, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
            this.downstream = interfaceC5216;
            this.mapper = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // defpackage.InterfaceC5216
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5216
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            try {
                InterfaceC3517 interfaceC3517 = (InterfaceC3517) C4246.m13353(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC3517.mo11463(new C2070());
            } catch (Exception e2) {
                C4089.m13026(e2);
                this.downstream.onError(e2);
            }
        }
    }

    public MaybeFlatten(InterfaceC3517<T> interfaceC3517, InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        super(interfaceC3517);
        this.f7219 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ, reason: contains not printable characters */
    public void mo6675(InterfaceC5216<? super R> interfaceC5216) {
        this.f11449.mo11463(new FlatMapMaybeObserver(interfaceC5216, this.f7219));
    }
}
