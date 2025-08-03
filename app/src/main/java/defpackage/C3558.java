package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSingleMaybe.java */
/* renamed from: ڤ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3558<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2856<T> f12371;

    /* compiled from: ObservableSingleMaybe.java */
    /* renamed from: ڤ$Ϳ, reason: contains not printable characters */
    public static final class C3559<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f12372;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f12373;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f12374;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f12375;

        public C3559(InterfaceC5216<? super T> interfaceC5216) {
            this.f12372 = interfaceC5216;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f12373.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f12373.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (this.f12375) {
                return;
            }
            this.f12375 = true;
            T t = this.f12374;
            this.f12374 = null;
            if (t == null) {
                this.f12372.onComplete();
            } else {
                this.f12372.onSuccess(t);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            if (this.f12375) {
                C3671.m11803(th);
            } else {
                this.f12375 = true;
                this.f12372.onError(th);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f12375) {
                return;
            }
            if (this.f12374 == null) {
                this.f12374 = t;
                return;
            }
            this.f12375 = true;
            this.f12373.dispose();
            this.f12372.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f12373, interfaceC4478)) {
                this.f12373 = interfaceC4478;
                this.f12372.onSubscribe(this);
            }
        }
    }

    public C3558(InterfaceC2856<T> interfaceC2856) {
        this.f12371 = interfaceC2856;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f12371.subscribe(new C3559(interfaceC5216));
    }
}
