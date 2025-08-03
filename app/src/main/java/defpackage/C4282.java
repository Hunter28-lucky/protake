package defpackage;

/* compiled from: ObservableFromArray.java */
/* renamed from: ਖ਼, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4282<T> extends AbstractC4262<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T[] f14677;

    /* compiled from: ObservableFromArray.java */
    /* renamed from: ਖ਼$Ϳ, reason: contains not printable characters */
    public static final class C4283<T> extends AbstractC5180<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<? super T> f14678;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T[] f14679;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f14680;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f14681;

        /* renamed from: ԯ, reason: contains not printable characters */
        public volatile boolean f14682;

        public C4283(InterfaceC5102<? super T> interfaceC5102, T[] tArr) {
            this.f14678 = interfaceC5102;
            this.f14679 = tArr;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.f14680 = this.f14679.length;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f14682 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f14682;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.f14680 == this.f14679.length;
        }

        @Override // defpackage.InterfaceC4851
        public T poll() {
            int i = this.f14680;
            T[] tArr = this.f14679;
            if (i == tArr.length) {
                return null;
            }
            this.f14680 = i + 1;
            return (T) C4246.m13353(tArr[i], "The array element is null");
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m13398() {
            T[] tArr = this.f14679;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.f14678.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.f14678.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f14678.onComplete();
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f14681 = true;
            return 1;
        }
    }

    public C4282(T[] tArr) {
        this.f14677 = tArr;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        C4283 c4283 = new C4283(interfaceC5102, this.f14677);
        interfaceC5102.onSubscribe(c4283);
        if (c4283.f14681) {
            return;
        }
        c4283.m13398();
    }
}
