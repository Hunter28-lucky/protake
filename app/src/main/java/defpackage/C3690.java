package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableReduceSeedSingle.java */
/* renamed from: ܩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3690<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f12810;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final R f12811;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5247<R, ? super T, R> f12812;

    /* compiled from: ObservableReduceSeedSingle.java */
    /* renamed from: ܩ$Ϳ, reason: contains not printable characters */
    public static final class C3691<T, R> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super R> f12813;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<R, ? super T, R> f12814;

        /* renamed from: ԭ, reason: contains not printable characters */
        public R f12815;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public InterfaceC4478 f12816;

        public C3691(InterfaceC4782<? super R> interfaceC4782, InterfaceC5247<R, ? super T, R> interfaceC5247, R r) {
            this.f12813 = interfaceC4782;
            this.f12815 = r;
            this.f12814 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12816.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12816.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            R r = this.f12815;
            if (r != null) {
                this.f12815 = null;
                this.f12813.onSuccess(r);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f12815 == null) {
                C3671.m11803(th);
            } else {
                this.f12815 = null;
                this.f12813.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            R r = this.f12815;
            if (r != null) {
                try {
                    this.f12815 = (R) C4246.m13353(this.f12814.apply(r, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f12816.dispose();
                    onError(th);
                }
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f12816, interfaceC4478)) {
                this.f12816 = interfaceC4478;
                this.f12813.onSubscribe(this);
            }
        }
    }

    public C3690(InterfaceC2856<T> interfaceC2856, R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        this.f12810 = interfaceC2856;
        this.f12811 = r;
        this.f12812 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        this.f12810.subscribe(new C3691(interfaceC4782, this.f12812, this.f12811));
    }
}
