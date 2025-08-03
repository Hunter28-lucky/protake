package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableReduceMaybe.java */
/* renamed from: ഖ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4698<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f15947;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<T, T, T> f15948;

    /* compiled from: ObservableReduceMaybe.java */
    /* renamed from: ഖ$Ϳ, reason: contains not printable characters */
    public static final class C4699<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f15949;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<T, T, T> f15950;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f15951;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public T f15952;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC4478 f15953;

        public C4699(InterfaceC5216<? super T> interfaceC5216, InterfaceC5247<T, T, T> interfaceC5247) {
            this.f15949 = interfaceC5216;
            this.f15950 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15953.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15953.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f15951) {
                return;
            }
            this.f15951 = true;
            T t = this.f15952;
            this.f15952 = null;
            if (t != null) {
                this.f15949.onSuccess(t);
            } else {
                this.f15949.onComplete();
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f15951) {
                C3671.m11803(th);
                return;
            }
            this.f15951 = true;
            this.f15952 = null;
            this.f15949.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f15951) {
                return;
            }
            T t2 = this.f15952;
            if (t2 == null) {
                this.f15952 = t;
                return;
            }
            try {
                this.f15952 = (T) C4246.m13353(this.f15950.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15953.dispose();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15953, interfaceC4478)) {
                this.f15953 = interfaceC4478;
                this.f15949.onSubscribe(this);
            }
        }
    }

    public C4698(InterfaceC2856<T> interfaceC2856, InterfaceC5247<T, T, T> interfaceC5247) {
        this.f15947 = interfaceC2856;
        this.f15948 = interfaceC5247;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f15947.subscribe(new C4699(interfaceC5216, this.f15948));
    }
}
