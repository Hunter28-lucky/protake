package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: SingleDoAfterSuccess.java */
/* renamed from: ඏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4783<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f16121;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f16122;

    /* compiled from: SingleDoAfterSuccess.java */
    /* renamed from: ඏ$Ϳ, reason: contains not printable characters */
    public static final class C4784<T> implements InterfaceC4782<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16123;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f16124;

        /* renamed from: ԭ, reason: contains not printable characters */
        public InterfaceC4478 f16125;

        public C4784(InterfaceC4782<? super T> interfaceC4782, InterfaceC2857<? super T> interfaceC2857) {
            this.f16123 = interfaceC4782;
            this.f16124 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f16125.dispose();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f16125.isDisposed();
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f16123.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.f16125, interfaceC4478)) {
                this.f16125 = interfaceC4478;
                this.f16123.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f16123.onSuccess(t);
            try {
                this.f16124.accept(t);
            } catch (Throwable th) {
                C4089.m13026(th);
                C3671.m11803(th);
            }
        }
    }

    public C4783(InterfaceC3951<T> interfaceC3951, InterfaceC2857<? super T> interfaceC2857) {
        this.f16121 = interfaceC3951;
        this.f16122 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16121.subscribe(new C4784(interfaceC4782, this.f16122));
    }
}
