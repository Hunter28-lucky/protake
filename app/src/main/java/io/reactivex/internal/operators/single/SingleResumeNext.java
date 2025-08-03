package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C4495;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class SingleResumeNext<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7610;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends InterfaceC3951<? extends T>> f7611;

    public static final class ResumeMainSingleObserver<T> extends AtomicReference<InterfaceC4478> implements InterfaceC4782<T>, InterfaceC4478 {
        private static final long serialVersionUID = -5314538511045349925L;
        public final InterfaceC4782<? super T> downstream;
        public final InterfaceC2368<? super Throwable, ? extends InterfaceC3951<? extends T>> nextFunction;

        public ResumeMainSingleObserver(InterfaceC4782<? super T> interfaceC4782, InterfaceC2368<? super Throwable, ? extends InterfaceC3951<? extends T>> interfaceC2368) {
            this.downstream = interfaceC4782;
            this.nextFunction = interfaceC2368;
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
            try {
                ((InterfaceC3951) C4246.m13353(this.nextFunction.apply(th), "The nextFunction returned a null SingleSource.")).subscribe(new C4495(this, this.downstream));
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.setOnce(this, interfaceC4478)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleResumeNext(InterfaceC3951<? extends T> interfaceC3951, InterfaceC2368<? super Throwable, ? extends InterfaceC3951<? extends T>> interfaceC2368) {
        this.f7610 = interfaceC3951;
        this.f7611 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f7610.subscribe(new ResumeMainSingleObserver(interfaceC4782, this.f7611));
    }
}
