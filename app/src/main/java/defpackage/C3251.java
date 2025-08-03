package defpackage;

import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletableOnErrorComplete.java */
/* renamed from: ո, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3251 extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2837 f11430;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super Throwable> f11431;

    /* compiled from: CompletableOnErrorComplete.java */
    /* renamed from: ո$Ϳ, reason: contains not printable characters */
    public final class C3252 implements InterfaceC5053 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f11432;

        public C3252(InterfaceC5053 interfaceC5053) {
            this.f11432 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC5053
        public void onComplete() {
            this.f11432.onComplete();
        }

        @Override // defpackage.InterfaceC5053
        public void onError(Throwable th) {
            try {
                if (C3251.this.f11431.test(th)) {
                    this.f11432.onComplete();
                } else {
                    this.f11432.onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.f11432.onError(new CompositeException(th, th2));
            }
        }

        @Override // defpackage.InterfaceC5053
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f11432.onSubscribe(interfaceC4478);
        }
    }

    public C3251(InterfaceC2837 interfaceC2837, InterfaceC4178<? super Throwable> interfaceC4178) {
        this.f11430 = interfaceC2837;
        this.f11431 = interfaceC4178;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f11430.mo10180(new C3252(interfaceC5053));
    }
}
