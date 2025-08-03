package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAnySingle.java */
/* renamed from: ఏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4508<T> extends AbstractC4838<Boolean> implements InterfaceC2325<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15445;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f15446;

    /* compiled from: ObservableAnySingle.java */
    /* renamed from: ఏ$Ϳ, reason: contains not printable characters */
    public static final class C4509<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f15447;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f15448;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15449;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f15450;

        public C4509(InterfaceC4782<? super Boolean> interfaceC4782, InterfaceC4178<? super T> interfaceC4178) {
            this.f15447 = interfaceC4782;
            this.f15448 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15449.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15449.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15450) {
                return;
            }
            this.f15450 = true;
            this.f15447.onSuccess(Boolean.FALSE);
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15450) {
                C3671.m11803(th);
            } else {
                this.f15450 = true;
                this.f15447.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15450) {
                return;
            }
            try {
                if (this.f15448.test(t)) {
                    this.f15450 = true;
                    this.f15449.dispose();
                    this.f15447.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15449.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15449, interfaceC4478)) {
                this.f15449 = interfaceC4478;
                this.f15447.onSubscribe(this);
            }
        }
    }

    public C4508(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        this.f15445 = interfaceC2856;
        this.f15446 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        this.f15445.subscribe(new C4509(interfaceC4782, this.f15446));
    }

    @Override // defpackage.InterfaceC2325
    /* renamed from: Ϳ */
    public AbstractC4262<Boolean> mo6779() {
        return C3671.m11798(new C2594(this.f15445, this.f15446));
    }
}
