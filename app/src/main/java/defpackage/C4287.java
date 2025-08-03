package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollect.java */
/* renamed from: ਫ਼, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4287<T, U> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends U> f14684;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5246<? super U, ? super T> f14685;

    /* compiled from: ObservableCollect.java */
    /* renamed from: ਫ਼$Ϳ, reason: contains not printable characters */
    public static final class C4288<T, U> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super U> f14686;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5246<? super U, ? super T> f14687;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final U f14688;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f14689;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f14690;

        public C4288(InterfaceC5102<? super U> interfaceC5102, U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
            this.f14686 = interfaceC5102;
            this.f14687 = interfaceC5246;
            this.f14688 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14689.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14689.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f14690) {
                return;
            }
            this.f14690 = true;
            this.f14686.onNext(this.f14688);
            this.f14686.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f14690) {
                C3671.m11803(th);
            } else {
                this.f14690 = true;
                this.f14686.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f14690) {
                return;
            }
            try {
                this.f14687.accept(this.f14688, t);
            } catch (Throwable th) {
                this.f14689.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f14689, interfaceC4478)) {
                this.f14689 = interfaceC4478;
                this.f14686.onSubscribe(this);
            }
        }
    }

    public C4287(InterfaceC2856<T> interfaceC2856, Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        super(interfaceC2856);
        this.f14684 = callable;
        this.f14685 = interfaceC5246;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        try {
            this.f11778.subscribe(new C4288(interfaceC5102, C4246.m13353(this.f14684.call(), "The initialSupplier returned a null value"), this.f14685));
        } catch (Throwable th) {
            EmptyDisposable.error(th, interfaceC5102);
        }
    }
}
