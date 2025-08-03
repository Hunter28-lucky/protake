package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: FlowableFilter.java */
/* renamed from: ก, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4858<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4178<? super T> f16380;

    /* compiled from: FlowableFilter.java */
    /* renamed from: ก$Ϳ, reason: contains not printable characters */
    public static final class C4859<T> extends AbstractC5177<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f16381;

        public C4859(InterfaceC2697<? super T> interfaceC2697, InterfaceC4178<? super T> interfaceC4178) {
            super(interfaceC2697);
            this.f16381 = interfaceC4178;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (mo6426(t)) {
                return;
            }
            this.f17136.request(1L);
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            InterfaceC2968<T> interfaceC2968 = this.f17137;
            InterfaceC4178<? super T> interfaceC4178 = this.f16381;
            while (true) {
                T tPoll = interfaceC2968.poll();
                if (tPoll == null) {
                    return null;
                }
                if (interfaceC4178.test(tPoll)) {
                    return tPoll;
                }
                if (this.f17139 == 2) {
                    interfaceC2968.request(1L);
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15121(i);
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            if (this.f17138) {
                return false;
            }
            if (this.f17139 != 0) {
                return this.f17135.mo6426(null);
            }
            try {
                return this.f16381.test(t) && this.f17135.mo6426(t);
            } catch (Throwable th) {
                m15120(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableFilter.java */
    /* renamed from: ก$Ԩ, reason: contains not printable characters */
    public static final class C4860<T> extends AbstractC5179<T, T> implements InterfaceC2697<T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC4178<? super T> f16382;

        public C4860(Subscriber<? super T> subscriber, InterfaceC4178<? super T> interfaceC4178) {
            super(subscriber);
            this.f16382 = interfaceC4178;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (mo6426(t)) {
                return;
            }
            this.f17146.request(1L);
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            InterfaceC2968<T> interfaceC2968 = this.f17147;
            InterfaceC4178<? super T> interfaceC4178 = this.f16382;
            while (true) {
                T tPoll = interfaceC2968.poll();
                if (tPoll == null) {
                    return null;
                }
                if (interfaceC4178.test(tPoll)) {
                    return tPoll;
                }
                if (this.f17149 == 2) {
                    interfaceC2968.request(1L);
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15129(i);
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            if (this.f17148) {
                return false;
            }
            if (this.f17149 != 0) {
                this.f17145.onNext(null);
                return true;
            }
            try {
                boolean zTest = this.f16382.test(t);
                if (zTest) {
                    this.f17145.onNext(t);
                }
                return zTest;
            } catch (Throwable th) {
                m15128(th);
                return true;
            }
        }
    }

    public C4858(AbstractC3630<T> abstractC3630, InterfaceC4178<? super T> interfaceC4178) {
        super(abstractC3630);
        this.f16380 = interfaceC4178;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new C4859((InterfaceC2697) subscriber, this.f16380));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C4860(subscriber, this.f16380));
        }
    }
}
