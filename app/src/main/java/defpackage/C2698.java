package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: SingleDoAfterTerminate.java */
/* renamed from: ʣ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2698<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f9998;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC3809 f9999;

    /* compiled from: SingleDoAfterTerminate.java */
    /* renamed from: ʣ$Ϳ, reason: contains not printable characters */
    public static final class C2699<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f10000;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC3809 f10001;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f10002;

        public C2699(InterfaceC4782<? super T> interfaceC4782, InterfaceC3809 interfaceC3809) {
            this.f10000 = interfaceC4782;
            this.f10001 = interfaceC3809;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10002.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10002.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f10000.onError(th);
            m9923();
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f10002, interfaceC4478)) {
                this.f10002 = interfaceC4478;
                this.f10000.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f10000.onSuccess(t);
            m9923();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m9923() {
            try {
                this.f10001.run();
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }
    }

    public C2698(InterfaceC3951<T> interfaceC3951, InterfaceC3809 interfaceC3809) {
        this.f9998 = interfaceC3951;
        this.f9999 = interfaceC3809;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f9998.subscribe(new C2699(interfaceC4782, this.f9999));
    }
}
