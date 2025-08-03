package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableScalarXMap.java */
/* renamed from: ќ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2930 {

    /* compiled from: FlowableScalarXMap.java */
    /* renamed from: ќ$Ϳ, reason: contains not printable characters */
    public static final class C2931<T, R> extends AbstractC3630<R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final T f10639;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f10640;

        public C2931(T t, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
            this.f10639 = t;
            this.f10640 = interfaceC2368;
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) C4246.m13353(this.f10640.apply(this.f10639), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    publisher.subscribe(subscriber);
                    return;
                }
                try {
                    Object objCall = ((Callable) publisher).call();
                    if (objCall == null) {
                        EmptySubscription.complete(subscriber);
                    } else {
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, objCall));
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U> AbstractC3630<U> m10332(T t, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368) {
        return C3671.m11796(new C2931(t, interfaceC2368));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, R> boolean m10333(Publisher<T> publisher, Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            a aVar = (Object) ((Callable) publisher).call();
            if (aVar == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) C4246.m13353(interfaceC2368.apply(aVar), "The mapper returned a null Publisher");
                if (publisher2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) publisher2).call();
                        if (objCall == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, objCall));
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        EmptySubscription.error(th, subscriber);
                        return true;
                    }
                } else {
                    publisher2.subscribe(subscriber);
                }
                return true;
            } catch (Throwable th2) {
                C4089.m13026(th2);
                EmptySubscription.error(th2, subscriber);
                return true;
            }
        } catch (Throwable th3) {
            C4089.m13026(th3);
            EmptySubscription.error(th3, subscriber);
            return true;
        }
    }
}
