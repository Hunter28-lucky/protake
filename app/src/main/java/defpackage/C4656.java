package defpackage;

/* compiled from: ObservableDoAfterNext.java */
/* renamed from: ಷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4656<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f15850;

    /* compiled from: ObservableDoAfterNext.java */
    /* renamed from: ಷ$Ϳ, reason: contains not printable characters */
    public static final class C4657<T> extends AbstractC5178<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f15851;

        public C4657(InterfaceC5102<? super T> interfaceC5102, InterfaceC2857<? super T> interfaceC2857) {
            super(interfaceC5102);
            this.f15851 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f17140.onNext(t);
            if (this.f17144 == 0) {
                try {
                    this.f15851.accept(t);
                } catch (Throwable th) {
                    m15124(th);
                }
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.f17142.poll();
            if (tPoll != null) {
                this.f15851.accept(tPoll);
            }
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15125(i);
        }
    }

    public C4656(InterfaceC2856<T> interfaceC2856, InterfaceC2857<? super T> interfaceC2857) {
        super(interfaceC2856);
        this.f15850 = interfaceC2857;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4657(interfaceC5102, this.f15850));
    }
}
