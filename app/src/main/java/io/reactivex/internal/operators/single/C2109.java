package io.reactivex.internal.operators.single;

import defpackage.AbstractC4838;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;

/* compiled from: SingleMap.java */
/* renamed from: io.reactivex.internal.operators.single.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2109<T, R> extends AbstractC4838<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<? extends T> f7635;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends R> f7636;

    /* compiled from: SingleMap.java */
    /* renamed from: io.reactivex.internal.operators.single.Ϳ$Ϳ, reason: contains not printable characters */
    public static final class C2110<T, R> implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super R> f7637;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends R> f7638;

        public C2110(InterfaceC4782<? super R> interfaceC4782, InterfaceC2368<? super T, ? extends R> interfaceC2368) {
            this.f7637 = interfaceC4782;
            this.f7638 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f7637.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f7637.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                this.f7637.onSuccess(C4246.m13353(this.f7638.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                C4089.m13026(th);
                onError(th);
            }
        }
    }

    public C2109(InterfaceC3951<? extends T> interfaceC3951, InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        this.f7635 = interfaceC3951;
        this.f7636 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super R> interfaceC4782) {
        this.f7635.subscribe(new C2110(interfaceC4782, this.f7636));
    }
}
