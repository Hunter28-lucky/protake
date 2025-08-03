package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: FlowableDoAfterNext.java */
/* renamed from: ঠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4180<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2857<? super T> f14440;

    /* compiled from: FlowableDoAfterNext.java */
    /* renamed from: ঠ$Ϳ, reason: contains not printable characters */
    public static final class C4181<T> extends AbstractC5177<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f14441;

        public C4181(InterfaceC2697<? super T> interfaceC2697, InterfaceC2857<? super T> interfaceC2857) {
            super(interfaceC2697);
            this.f14441 = interfaceC2857;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f17135.onNext(t);
            if (this.f17139 == 0) {
                try {
                    this.f14441.accept(t);
                } catch (Throwable th) {
                    m15120(th);
                }
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.f17137.poll();
            if (tPoll != null) {
                this.f14441.accept(tPoll);
            }
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15121(i);
        }

        @Override // defpackage.InterfaceC2697
        /* renamed from: ԭ */
        public boolean mo6426(T t) {
            boolean zMo6426 = this.f17135.mo6426(t);
            try {
                this.f14441.accept(t);
            } catch (Throwable th) {
                m15120(th);
            }
            return zMo6426;
        }
    }

    /* compiled from: FlowableDoAfterNext.java */
    /* renamed from: ঠ$Ԩ, reason: contains not printable characters */
    public static final class C4182<T> extends AbstractC5179<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2857<? super T> f14442;

        public C4182(Subscriber<? super T> subscriber, InterfaceC2857<? super T> interfaceC2857) {
            super(subscriber);
            this.f14442 = interfaceC2857;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17148) {
                return;
            }
            this.f17145.onNext(t);
            if (this.f17149 == 0) {
                try {
                    this.f14442.accept(t);
                } catch (Throwable th) {
                    m15128(th);
                }
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll = this.f17147.poll();
            if (tPoll != null) {
                this.f14442.accept(tPoll);
            }
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15129(i);
        }
    }

    public C4180(AbstractC3630<T> abstractC3630, InterfaceC2857<? super T> interfaceC2857) {
        super(abstractC3630);
        this.f14440 = interfaceC2857;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new C4181((InterfaceC2697) subscriber, this.f14440));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C4182(subscriber, this.f14440));
        }
    }
}
