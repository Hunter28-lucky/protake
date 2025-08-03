package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeFilterSingle.java */
/* renamed from: ಙ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4614<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f15723;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f15724;

    /* compiled from: MaybeFilterSingle.java */
    /* renamed from: ಙ$Ϳ, reason: contains not printable characters */
    public static final class C4615<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f15725;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f15726;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15727;

        public C4615(InterfaceC5216<? super T> interfaceC5216, InterfaceC4178<? super T> interfaceC4178) {
            this.f15725 = interfaceC5216;
            this.f15726 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InterfaceC4478 interfaceC4478 = this.f15727;
            this.f15727 = DisposableHelper.DISPOSED;
            interfaceC4478.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15727.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f15725.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15727, interfaceC4478)) {
                this.f15727 = interfaceC4478;
                this.f15725.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                if (this.f15726.test(t)) {
                    this.f15725.onSuccess(t);
                } else {
                    this.f15725.onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15725.onError(th);
            }
        }
    }

    public C4614(InterfaceC3951<T> interfaceC3951, InterfaceC4178<? super T> interfaceC4178) {
        this.f15723 = interfaceC3951;
        this.f15724 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f15723.subscribe(new C4615(interfaceC5216, this.f15724));
    }
}
