package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: SingleDetach.java */
/* renamed from: ఝ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4530<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f15510;

    /* compiled from: SingleDetach.java */
    /* renamed from: ఝ$Ϳ, reason: contains not printable characters */
    public static final class C4531<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public InterfaceC4782<? super T> f15511;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f15512;

        public C4531(InterfaceC4782<? super T> interfaceC4782) {
            this.f15511 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15511 = null;
            this.f15512.dispose();
            this.f15512 = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15512.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f15512 = DisposableHelper.DISPOSED;
            InterfaceC4782<? super T> interfaceC4782 = this.f15511;
            if (interfaceC4782 != null) {
                this.f15511 = null;
                interfaceC4782.onError(th);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f15512, interfaceC4478)) {
                this.f15512 = interfaceC4478;
                this.f15511.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f15512 = DisposableHelper.DISPOSED;
            InterfaceC4782<? super T> interfaceC4782 = this.f15511;
            if (interfaceC4782 != null) {
                this.f15511 = null;
                interfaceC4782.onSuccess(t);
            }
        }
    }

    public C4530(InterfaceC3951<T> interfaceC3951) {
        this.f15510 = interfaceC3951;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f15510.subscribe(new C4531(interfaceC4782));
    }
}
