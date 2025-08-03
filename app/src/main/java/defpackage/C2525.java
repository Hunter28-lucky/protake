package defpackage;

/* compiled from: CompletableFromSingle.java */
/* renamed from: ț, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2525<T> extends AbstractC2900 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f9349;

    /* compiled from: CompletableFromSingle.java */
    /* renamed from: ț$Ϳ, reason: contains not printable characters */
    public static final class C2526<T> implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5053 f9350;

        public C2526(InterfaceC5053 interfaceC5053) {
            this.f9350 = interfaceC5053;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f9350.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f9350.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            this.f9350.onComplete();
        }
    }

    public C2525(InterfaceC3951<T> interfaceC3951) {
        this.f9349 = interfaceC3951;
    }

    @Override // defpackage.AbstractC2900
    /* renamed from: އ */
    public void mo6373(InterfaceC5053 interfaceC5053) {
        this.f9349.subscribe(new C2526(interfaceC5053));
    }
}
