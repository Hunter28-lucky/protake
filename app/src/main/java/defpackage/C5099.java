package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollectSingle.java */
/* renamed from: ဍ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5099<T, U> extends AbstractC4838<U> implements InterfaceC2325<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f16931;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends U> f16932;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5246<? super U, ? super T> f16933;

    /* compiled from: ObservableCollectSingle.java */
    /* renamed from: ဍ$Ϳ, reason: contains not printable characters */
    public static final class C5100<T, U> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super U> f16934;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5246<? super U, ? super T> f16935;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final U f16936;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f16937;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f16938;

        public C5100(InterfaceC4782<? super U> interfaceC4782, U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
            this.f16934 = interfaceC4782;
            this.f16935 = interfaceC5246;
            this.f16936 = u;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16937.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16937.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f16938) {
                return;
            }
            this.f16938 = true;
            this.f16934.onSuccess(this.f16936);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f16938) {
                C3671.m11803(th);
            } else {
                this.f16938 = true;
                this.f16934.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f16938) {
                return;
            }
            try {
                this.f16935.accept(this.f16936, t);
            } catch (Throwable th) {
                this.f16937.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16937, interfaceC4478)) {
                this.f16937 = interfaceC4478;
                this.f16934.onSubscribe(this);
            }
        }
    }

    public C5099(InterfaceC2856<T> interfaceC2856, Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        this.f16931 = interfaceC2856;
        this.f16932 = callable;
        this.f16933 = interfaceC5246;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super U> interfaceC4782) {
        try {
            this.f16931.subscribe(new C5100(interfaceC4782, C4246.m13353(this.f16932.call(), "The initialSupplier returned a null value"), this.f16933));
        } catch (Throwable th) {
            EmptyDisposable.error(th, interfaceC4782);
        }
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<U> mo6779() {
        return C3671.m11798(new C4287(this.f16931, this.f16932, this.f16933));
    }
}
