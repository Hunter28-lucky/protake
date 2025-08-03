package defpackage;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableOnErrorReturn.java */
/* renamed from: ڲ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3585<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends T> f12500;

    /* compiled from: ObservableOnErrorReturn.java */
    /* renamed from: ڲ$Ϳ, reason: contains not printable characters */
    public static final class C3586<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f12501;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super Throwable, ? extends T> f12502;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f12503;

        public C3586(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
            this.f12501 = interfaceC5102;
            this.f12502 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12503.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12503.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f12501.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            try {
                T tApply = this.f12502.apply(th);
                if (tApply != null) {
                    this.f12501.onNext(tApply);
                    this.f12501.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f12501.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f12501.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f12501.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f12503, interfaceC4478)) {
                this.f12503 = interfaceC4478;
                this.f12501.onSubscribe(this);
            }
        }
    }

    public C3585(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
        super(interfaceC2856);
        this.f12500 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C3586(interfaceC5102, this.f12500));
    }
}
