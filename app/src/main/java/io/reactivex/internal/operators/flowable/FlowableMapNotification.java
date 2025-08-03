package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class FlowableMapNotification<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends R> f7017;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super Throwable, ? extends R> f7018;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Callable<? extends R> f7019;

    public static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        public final Callable<? extends R> onCompleteSupplier;
        public final InterfaceC2368<? super Throwable, ? extends R> onErrorMapper;
        public final InterfaceC2368<? super T, ? extends R> onNextMapper;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends R> interfaceC2368, InterfaceC2368<? super Throwable, ? extends R> interfaceC23682, Callable<? extends R> callable) {
            super(subscriber);
            this.onNextMapper = interfaceC2368;
            this.onErrorMapper = interfaceC23682;
            this.onCompleteSupplier = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                m7006(C4246.m13353(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                m7006(C4246.m13353(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                C4089.m13026(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Object objM13353 = C4246.m13353(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(objM13353);
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }
    }

    public FlowableMapNotification(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends R> interfaceC2368, InterfaceC2368<? super Throwable, ? extends R> interfaceC23682, Callable<? extends R> callable) {
        super(abstractC3630);
        this.f7017 = interfaceC2368;
        this.f7018 = interfaceC23682;
        this.f7019 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new MapNotificationSubscriber(subscriber, this.f7017, this.f7018, this.f7019));
    }
}
