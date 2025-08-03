package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.AbstractC5177;
import defpackage.AbstractC5179;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2697;
import defpackage.InterfaceC3899;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableMap.java */
/* renamed from: io.reactivex.internal.operators.flowable.Ԩ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2065<T, U> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends U> f7212;

    /* compiled from: FlowableMap.java */
    /* renamed from: io.reactivex.internal.operators.flowable.Ԩ$Ϳ, reason: contains not printable characters */
    public static final class C2066<T, U> extends AbstractC5177<T, U> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends U> f7213;

        public C2066(InterfaceC2697<? super U> interfaceC2697, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
            super(interfaceC2697);
            this.f7213 = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17138) {
                return;
            }
            if (this.f17139 != 0) {
                this.f17135.onNext(null);
                return;
            }
            try {
                this.f17135.onNext(C4246.m13353(this.f7213.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m15120(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public U poll() throws Exception {
            T tPoll = this.f17137.poll();
            if (tPoll != null) {
                return (U) C4246.m13353(this.f7213.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
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
            try {
                return this.f17135.mo6426(C4246.m13353(this.f7213.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m15120(th);
                return true;
            }
        }
    }

    /* compiled from: FlowableMap.java */
    /* renamed from: io.reactivex.internal.operators.flowable.Ԩ$Ԩ, reason: contains not printable characters */
    public static final class C2067<T, U> extends AbstractC5179<T, U> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends U> f7214;

        public C2067(Subscriber<? super U> subscriber, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
            super(subscriber);
            this.f7214 = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17148) {
                return;
            }
            if (this.f17149 != 0) {
                this.f17145.onNext(null);
                return;
            }
            try {
                this.f17145.onNext(C4246.m13353(this.f7214.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                m15128(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public U poll() throws Exception {
            T tPoll = this.f17147.poll();
            if (tPoll != null) {
                return (U) C4246.m13353(this.f7214.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15129(i);
        }
    }

    public C2065(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
        super(abstractC3630);
        this.f7212 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (subscriber instanceof InterfaceC2697) {
            this.f11385.subscribe((InterfaceC3899) new C2066((InterfaceC2697) subscriber, this.f7212));
        } else {
            this.f11385.subscribe((InterfaceC3899) new C2067(subscriber, this.f7212));
        }
    }
}
