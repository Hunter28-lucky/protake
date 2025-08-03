package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: SingleDematerialize.java */
/* renamed from: ѹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2947<T, R> extends AbstractC4274<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4838<T> f10664;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, C3906<R>> f10665;

    /* compiled from: SingleDematerialize.java */
    /* renamed from: ѹ$Ϳ, reason: contains not printable characters */
    public static final class C2948<T, R> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super R> f10666;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, C3906<R>> f10667;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f10668;

        public C2948(InterfaceC5216<? super R> interfaceC5216, InterfaceC2368<? super T, C3906<R>> interfaceC2368) {
            this.f10666 = interfaceC5216;
            this.f10667 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10668.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10668.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f10666.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f10668, interfaceC4478)) {
                this.f10668 = interfaceC4478;
                this.f10666.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                C3906 c3906 = (C3906) C4246.m13353(this.f10667.apply(t), "The selector returned a null Notification");
                if (c3906.m12652()) {
                    this.f10666.onSuccess((Object) c3906.m12649());
                } else if (c3906.m12650()) {
                    this.f10666.onComplete();
                } else {
                    this.f10666.onError(c3906.m12648());
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f10666.onError(th);
            }
        }
    }

    public C2947(AbstractC4838<T> abstractC4838, InterfaceC2368<? super T, C3906<R>> interfaceC2368) {
        this.f10664 = abstractC4838;
        this.f10665 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super R> interfaceC5216) {
        this.f10664.subscribe(new C2948(interfaceC5216, this.f10665));
    }
}
