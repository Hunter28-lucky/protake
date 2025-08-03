package defpackage;

import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableSwitchIfEmpty.java */
/* renamed from: ʦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2706<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2856<? extends T> f10018;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* renamed from: ʦ$Ϳ, reason: contains not printable characters */
    public static final class C2707<T> implements InterfaceC5102<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f10019;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2856<? extends T> f10020;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10022 = true;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final SequentialDisposable f10021 = new SequentialDisposable();

        public C2707(InterfaceC5102<? super T> interfaceC5102, InterfaceC2856<? extends T> interfaceC2856) {
            this.f10019 = interfaceC5102;
            this.f10020 = interfaceC2856;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            if (!this.f10022) {
                this.f10019.onComplete();
            } else {
                this.f10022 = false;
                this.f10020.subscribe(this);
            }
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f10019.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f10022) {
                this.f10022 = false;
            }
            this.f10019.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f10021.m6312(interfaceC4478);
        }
    }

    public C2706(InterfaceC2856<T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562) {
        super(interfaceC2856);
        this.f10018 = interfaceC28562;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C2707 c2707 = new C2707(interfaceC5102, this.f10018);
        interfaceC5102.onSubscribe(c2707.f10021);
        this.f11778.subscribe(c2707);
    }
}
