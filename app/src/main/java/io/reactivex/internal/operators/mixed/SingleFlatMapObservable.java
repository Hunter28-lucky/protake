package io.reactivex.internal.operators.mixed;

import defpackage.AbstractC4262;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5102;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleFlatMapObservable<T, R> extends AbstractC4262<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7290;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> f7291;

    public static final class FlatMapObserver<T, R> extends AtomicReference<InterfaceC4478> implements InterfaceC5102<R>, InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -8948264376121066672L;
        public final InterfaceC5102<? super R> downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> mapper;

        public FlatMapObserver(InterfaceC5102<? super R> interfaceC5102, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
            this.downstream = interfaceC5102;
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

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                ((InterfaceC2856) C4246.m13353(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }
    }

    public SingleFlatMapObservable(InterfaceC3951<T> interfaceC3951, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        this.f7290 = interfaceC3951;
        this.f7291 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super R> interfaceC5102) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(interfaceC5102, this.f7291);
        interfaceC5102.onSubscribe(flatMapObserver);
        this.f7290.subscribe(flatMapObserver);
    }
}
