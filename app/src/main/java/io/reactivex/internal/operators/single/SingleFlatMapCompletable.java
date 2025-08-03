package io.reactivex.internal.operators.single;

import defpackage.AbstractC2900;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2837;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5053;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleFlatMapCompletable<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7590;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends InterfaceC2837> f7591;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC5053, InterfaceC4478 {
        private static final long serialVersionUID = -2177128922851101253L;
        public final InterfaceC5053 downstream;
        public final InterfaceC2368<? super T, ? extends InterfaceC2837> mapper;

        public FlatMapCompletableObserver(InterfaceC5053 interfaceC5053, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
            this.downstream = interfaceC5053;
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

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            DisposableHelper.replace(this, interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                InterfaceC2837 interfaceC2837 = (InterfaceC2837) C4246.m13353(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                interfaceC2837.mo10180(this);
            } catch (Throwable th) {
                C4089.m13026(th);
                onError(th);
            }
        }
    }

    public SingleFlatMapCompletable(InterfaceC3951<T> interfaceC3951, InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        this.f7590 = interfaceC3951;
        this.f7591 = interfaceC2368;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(interfaceC5053, this.f7591);
        interfaceC5053.onSubscribe(flatMapCompletableObserver);
        this.f7590.subscribe(flatMapCompletableObserver);
    }
}
