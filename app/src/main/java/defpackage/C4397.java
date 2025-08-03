package defpackage;

/* compiled from: ObservableFilter.java */
/* renamed from: ଐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4397<T> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f15125;

    /* compiled from: ObservableFilter.java */
    /* renamed from: ଐ$Ϳ, reason: contains not printable characters */
    public static final class C4398<T> extends AbstractC5178<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f15126;

        public C4398(InterfaceC5102<? super T> interfaceC5102, InterfaceC4178<? super T> interfaceC4178) {
            super(interfaceC5102);
            this.f15126 = interfaceC4178;
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f17144 != 0) {
                this.f17140.onNext(null);
                return;
            }
            try {
                if (this.f15126.test(t)) {
                    this.f17140.onNext(t);
                }
            } catch (Throwable th) {
                m15124(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f17142.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f15126.test(tPoll));
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15125(i);
        }
    }

    public C4397(InterfaceC2856<T> interfaceC2856, InterfaceC4178<? super T> interfaceC4178) {
        super(interfaceC2856);
        this.f15125 = interfaceC4178;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4398(interfaceC5102, this.f15125));
    }
}
