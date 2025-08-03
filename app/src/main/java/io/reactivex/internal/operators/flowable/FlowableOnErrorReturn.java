package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableOnErrorReturn<T> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends T> f7037;

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;
        public final InterfaceC2368<? super Throwable, ? extends T> valueSupplier;

        public OnErrorReturnSubscriber(Subscriber<? super T> subscriber, InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
            super(subscriber);
            this.valueSupplier = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                m7006(C4246.m13353(this.valueSupplier.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }
    }

    public FlowableOnErrorReturn(AbstractC3630<T> abstractC3630, InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
        super(abstractC3630);
        this.f7037 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new OnErrorReturnSubscriber(subscriber, this.f7037));
    }
}
