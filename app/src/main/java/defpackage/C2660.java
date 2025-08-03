package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAllSingle.java */
/* renamed from: ʊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2660<T> extends AbstractC4838<Boolean> implements InterfaceC2325<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f9914;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f9915;

    /* compiled from: ObservableAllSingle.java */
    /* renamed from: ʊ$Ϳ, reason: contains not printable characters */
    public static final class C2661<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f9916;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f9917;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f9918;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f9919;

        public C2661(InterfaceC4782<? super Boolean> interfaceC4782, InterfaceC4178<? super T> interfaceC4178) {
            this.f9916 = interfaceC4782;
            this.f9917 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f9918.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f9918.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f9919) {
                return;
            }
            this.f9919 = true;
            this.f9916.onSuccess(Boolean.TRUE);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f9919) {
                C3671.m11803(th);
            } else {
                this.f9919 = true;
                this.f9916.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f9919) {
                return;
            }
            try {
                if (this.f9917.test(t)) {
                    return;
                }
                this.f9919 = true;
                this.f9918.dispose();
                this.f9916.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f9918.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f9918, interfaceC4478)) {
                this.f9918 = interfaceC4478;
                this.f9916.onSubscribe(this);
            }
        }
    }

    public C2660(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        this.f9914 = interfaceC2856;
        this.f9915 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        this.f9914.subscribe(new C2661(interfaceC4782, this.f9915));
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<Boolean> mo6779() {
        return C3671.m11798(new C5283(this.f9914, this.f9915));
    }
}
