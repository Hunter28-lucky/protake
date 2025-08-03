package defpackage;

import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: SingleDoOnSubscribe.java */
/* renamed from: ඐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4785<T> extends AbstractC4838<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f16126;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super InterfaceC4478> f16127;

    /* compiled from: SingleDoOnSubscribe.java */
    /* renamed from: ඐ$Ϳ, reason: contains not printable characters */
    public static final class C4786<T> implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super T> f16128;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2857<? super InterfaceC4478> f16129;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f16130;

        public C4786(InterfaceC4782<? super T> interfaceC4782, InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
            this.f16128 = interfaceC4782;
            this.f16129 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            if (this.f16130) {
                C3671.m11803(th);
            } else {
                this.f16128.onError(th);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            try {
                this.f16129.accept(interfaceC4478);
                this.f16128.onSubscribe(interfaceC4478);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f16130 = true;
                interfaceC4478.dispose();
                EmptyDisposable.error(th, this.f16128);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            if (this.f16130) {
                return;
            }
            this.f16128.onSuccess(t);
        }
    }

    public C4785(InterfaceC3951<T> interfaceC3951, InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        this.f16126 = interfaceC3951;
        this.f16127 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super T> interfaceC4782) {
        this.f16126.subscribe(new C4786(interfaceC4782, this.f16127));
    }
}
