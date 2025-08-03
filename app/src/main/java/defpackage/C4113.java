package defpackage;

/* compiled from: ObservableMap.java */
/* renamed from: ॡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4113<T, U> extends AbstractC3414<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends U> f14258;

    /* compiled from: ObservableMap.java */
    /* renamed from: ॡ$Ϳ, reason: contains not printable characters */
    public static final class C4114<T, U> extends AbstractC5178<T, U> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends U> f14259;

        public C4114(InterfaceC5102<? super U> interfaceC5102, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
            super(interfaceC5102);
            this.f14259 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f17143) {
                return;
            }
            if (this.f17144 != 0) {
                this.f17140.onNext(null);
                return;
            }
            try {
                this.f17140.onNext(C4246.m13353(this.f14259.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m15124(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public U poll() throws Exception {
            T tPoll = this.f17142.poll();
            if (tPoll != null) {
                return (U) C4246.m13353(this.f14259.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15125(i);
        }
    }

    public C4113(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
        super(interfaceC2856);
        this.f14258 = interfaceC2368;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super U> interfaceC5102) {
        this.f11778.subscribe(new C4114(interfaceC5102, this.f14258));
    }
}
