package defpackage;

/* compiled from: ObservableDistinctUntilChanged.java */
/* renamed from: ฬ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4915<T, K> extends AbstractC3414<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, K> f16585;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super K, ? super K> f16586;

    /* compiled from: ObservableDistinctUntilChanged.java */
    /* renamed from: ฬ$Ϳ, reason: contains not printable characters */
    public static final class C4916<T, K> extends AbstractC5178<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, K> f16587;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC5324<? super K, ? super K> f16588;

        /* renamed from: ֏, reason: contains not printable characters */
        public K f16589;

        /* renamed from: ׯ, reason: contains not printable characters */
        public boolean f16590;

        public C4916(InterfaceC5102<? super T> interfaceC5102, InterfaceC2368<? super T, K> interfaceC2368, InterfaceC5324<? super K, ? super K> interfaceC5324) {
            super(interfaceC5102);
            this.f16587 = interfaceC2368;
            this.f16588 = interfaceC5324;
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            if (this.f17143) {
                return;
            }
            if (this.f17144 != 0) {
                this.f17140.onNext(t);
                return;
            }
            try {
                K kApply = this.f16587.apply(t);
                if (this.f16590) {
                    boolean zTest = this.f16588.test(this.f16589, kApply);
                    this.f16589 = kApply;
                    if (zTest) {
                        return;
                    }
                } else {
                    this.f16590 = true;
                    this.f16589 = kApply;
                }
                this.f17140.onNext(t);
            } catch (Throwable th) {
                m15124(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f17142.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f16587.apply(tPoll);
                if (!this.f16590) {
                    this.f16590 = true;
                    this.f16589 = kApply;
                    return tPoll;
                }
                if (!this.f16588.test(this.f16589, kApply)) {
                    this.f16589 = kApply;
                    return tPoll;
                }
                this.f16589 = kApply;
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15125(i);
        }
    }

    public C4915(InterfaceC2856<T> interfaceC2856, InterfaceC2368<? super T, K> interfaceC2368, InterfaceC5324<? super K, ? super K> interfaceC5324) {
        super(interfaceC2856);
        this.f16585 = interfaceC2368;
        this.f16586 = interfaceC5324;
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.f11778.subscribe(new C4916(interfaceC5102, this.f16585, this.f16586));
    }
}
