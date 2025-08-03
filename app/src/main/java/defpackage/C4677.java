package defpackage;

/* compiled from: SingleContains.java */
/* renamed from: ഋ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4677<T> extends AbstractC4838<Boolean> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f15874;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Object f15875;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<Object, Object> f15876;

    /* compiled from: SingleContains.java */
    /* renamed from: ഋ$Ϳ, reason: contains not printable characters */
    public final class C4678 implements InterfaceC4782<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4782<? super Boolean> f15877;

        public C4678(InterfaceC4782<? super Boolean> interfaceC4782) {
            this.f15877 = interfaceC4782;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.f15877.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f15877.onSubscribe(interfaceC4478);
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                C4677 c4677 = C4677.this;
                this.f15877.onSuccess(Boolean.valueOf(c4677.f15876.test(t, c4677.f15875)));
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15877.onError(th);
            }
        }
    }

    public C4677(InterfaceC3951<T> interfaceC3951, Object obj, InterfaceC5324<Object, Object> interfaceC5324) {
        this.f15874 = interfaceC3951;
        this.f15875 = obj;
        this.f15876 = interfaceC5324;
    }

    @Override // defpackage.AbstractC4838
    public void subscribeActual(InterfaceC4782<? super Boolean> interfaceC4782) {
        this.f15874.subscribe(new C4678(interfaceC4782));
    }
}
