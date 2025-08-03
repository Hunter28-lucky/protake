package defpackage;

import org.reactivestreams.Subscriber;

/* compiled from: FlowableDistinctUntilChanged.java */
/* renamed from: မ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5116<T, K> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, K> f16959;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC5324<? super K, ? super K> f16960;

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* renamed from: မ$Ϳ, reason: contains not printable characters */
    public static final class C5117<T, K> extends AbstractC5177<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, K> f16961;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC5324<? super K, ? super K> f16962;

        /* renamed from: ֏, reason: contains not printable characters */
        public K f16963;

        /* renamed from: ׯ, reason: contains not printable characters */
        public boolean f16964;

        public C5117(InterfaceC2697<? super T> interfaceC2697, InterfaceC2368<? super T, K> interfaceC2368, InterfaceC5324<? super K, ? super K> interfaceC5324) {
            super(interfaceC2697);
            this.f16961 = interfaceC2368;
            this.f16962 = interfaceC5324;
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
            while (true) {
                T tPoll = this.f17137.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f16961.apply(tPoll);
                if (!this.f16964) {
                    this.f16964 = true;
                    this.f16963 = kApply;
                    return tPoll;
                }
                if (!this.f16962.test(this.f16963, kApply)) {
                    this.f16963 = kApply;
                    return tPoll;
                }
                this.f16963 = kApply;
                if (this.f17139 != 1) {
                    this.f17136.request(1L);
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
                return this.f17135.mo6426(t);
            }
            try {
                K kApply = this.f16961.apply(t);
                if (this.f16964) {
                    boolean zTest = this.f16962.test(this.f16963, kApply);
                    this.f16963 = kApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.f16964 = true;
                    this.f16963 = kApply;
                }
                this.f17135.onNext(t);
                return true;
            } catch (Throwable th) {
                m15120(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableDistinctUntilChanged.java */
    /* renamed from: မ$Ԩ, reason: contains not printable characters */
    public static final class C5118<T, K> extends AbstractC5179<T, T> implements InterfaceC2697<T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, K> f16965;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC5324<? super K, ? super K> f16966;

        /* renamed from: ֏, reason: contains not printable characters */
        public K f16967;

        /* renamed from: ׯ, reason: contains not printable characters */
        public boolean f16968;

        public C5118(Subscriber<? super T> subscriber, InterfaceC2368<? super T, K> interfaceC2368, InterfaceC5324<? super K, ? super K> interfaceC5324) {
            super(subscriber);
            this.f16965 = interfaceC2368;
            this.f16966 = interfaceC5324;
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
            while (true) {
                T tPoll = this.f17147.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f16965.apply(tPoll);
                if (!this.f16968) {
                    this.f16968 = true;
                    this.f16967 = kApply;
                    return tPoll;
                }
                if (!this.f16966.test(this.f16967, kApply)) {
                    this.f16967 = kApply;
                    return tPoll;
                }
                this.f16967 = kApply;
                if (this.f17149 != 1) {
                    this.f17146.request(1L);
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
                this.f17145.onNext(t);
                return true;
            }
            try {
                K kApply = this.f16965.apply(t);
                if (this.f16968) {
                    boolean zTest = this.f16966.test(this.f16967, kApply);
                    this.f16967 = kApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.f16968 = true;
                    this.f16967 = kApply;
                }
                this.f17145.onNext(t);
                return true;
            } catch (Throwable th) {
                m15128(th);
                return true;
            }
        }
    }

    public C5116(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, K> interfaceC2368, InterfaceC5324<? super K, ? super K> interfaceC5324) {
        super(abstractC3630);
        this.f16959 = interfaceC2368;
        this.f16960 = interfaceC5324;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new C5117((InterfaceC2697) subscriber, this.f16959, this.f16960));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C5118(subscriber, this.f16959, this.f16960));
        }
    }
}
