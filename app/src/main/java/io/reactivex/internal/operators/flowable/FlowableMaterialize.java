package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C3671;
import defpackage.C3906;
import defpackage.InterfaceC3899;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableMaterialize<T> extends AbstractC3232<T, C3906<T>> {

    public static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, C3906<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        public MaterializeSubscriber(Subscriber<? super C3906<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            m7006(C3906.m12645());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            m7006(C3906.m12646(th));
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(C3906.m12647(t));
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo6523(C3906<T> c3906) {
            if (c3906.m12651()) {
                C3671.m11803(c3906.m12648());
            }
        }
    }

    public FlowableMaterialize(AbstractC3630<T> abstractC3630) {
        super(abstractC3630);
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super C3906<T>> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new MaterializeSubscriber(subscriber));
    }
}
