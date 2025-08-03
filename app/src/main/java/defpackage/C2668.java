package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeLastOne.java */
/* renamed from: ʑ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2668<T> extends AbstractC3414<T, T> {

    /* compiled from: ObservableTakeLastOne.java */
    /* renamed from: ʑ$Ϳ, reason: contains not printable characters */
    public static final class C2669<T> implements InterfaceC5102<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f9922;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f9923;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f9924;

        public C2669(InterfaceC5102<? super T> interfaceC5102) {
            this.f9922 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f9924 = null;
            this.f9923.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f9923.isDisposed();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            m9810();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f9924 = null;
            this.f9922.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f9924 = t;
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f9923, interfaceC4478)) {
                this.f9923 = interfaceC4478;
                this.f9922.onSubscribe(this);
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m9810() {
            T t = this.f9924;
            if (t != null) {
                this.f9924 = null;
                this.f9922.onNext(t);
            }
            this.f9922.onComplete();
        }
    }

    public C2668(InterfaceC2856<T> interfaceC2856) {
        super(interfaceC2856);
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C2669(interfaceC5102));
    }
}
