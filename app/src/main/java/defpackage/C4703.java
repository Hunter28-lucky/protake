package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: MaybeMap.java */
/* renamed from: ച, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4703<T, R> extends AbstractC3265<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends R> f15965;

    /* compiled from: MaybeMap.java */
    /* renamed from: ച$Ϳ, reason: contains not printable characters */
    public static final class C4704<T, R> implements InterfaceC5216<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super R> f15966;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends R> f15967;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15968;

        public C4704(InterfaceC5216<? super R> interfaceC5216, InterfaceC2368<? super T, ? extends R> interfaceC2368) {
            this.f15966 = interfaceC5216;
            this.f15967 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            InterfaceC4478 interfaceC4478 = this.f15968;
            this.f15968 = DisposableHelper.DISPOSED;
            interfaceC4478.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15968.isDisposed();
        }

        @Override // defpackage.InterfaceC5216
        public void onComplete() {
            this.f15966.onComplete();
        }

        @Override // defpackage.InterfaceC5216
        public void onError(Throwable th) {
            this.f15966.onError(th);
        }

        @Override // defpackage.InterfaceC5216
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15968, interfaceC4478)) {
                this.f15968 = interfaceC4478;
                this.f15966.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5216
        public void onSuccess(T t) {
            try {
                this.f15966.onSuccess(C4246.m13353(this.f15967.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15966.onError(th);
            }
        }
    }

    public C4703(InterfaceC3517<T> interfaceC3517, InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        super(interfaceC3517);
        this.f15965 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super R> interfaceC5216) {
        this.f11449.mo11463(new C4704(interfaceC5216, this.f15965));
    }
}
