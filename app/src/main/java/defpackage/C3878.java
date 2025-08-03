package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableMaterialize.java */
/* renamed from: ࠁ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3878<T> extends AbstractC3414<T, C3906<T>> {

    /* compiled from: ObservableMaterialize.java */
    /* renamed from: ࠁ$Ϳ, reason: contains not printable characters */
    public static final class C3879<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super C3906<T>> f13344;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f13345;

        public C3879(InterfaceC5102<? super C3906<T>> interfaceC5102) {
            this.f13344 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f13345.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13345.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f13344.onNext(C3906.m12645());
            this.f13344.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f13344.onNext(C3906.m12646(th));
            this.f13344.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f13344.onNext(C3906.m12647(t));
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f13345, interfaceC4478)) {
                this.f13345 = interfaceC4478;
                this.f13344.onSubscribe(this);
            }
        }
    }

    public C3878(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super C3906<T>> interfaceC5102) {
        this.f11778.subscribe(new C3879(interfaceC5102));
    }
}
