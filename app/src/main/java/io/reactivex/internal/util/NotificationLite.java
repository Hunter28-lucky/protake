package io.reactivex.internal.util;

import defpackage.C4246;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        public final InterfaceC4478 upstream;

        public DisposableNotification(InterfaceC4478 interfaceC4478) {
            this.upstream = interfaceC4478;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e, reason: collision with root package name */
        public final Throwable f17906e;

        public ErrorNotification(Throwable th) {
            this.f17906e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return C4246.m13351(this.f17906e, ((ErrorNotification) obj).f17906e);
            }
            return false;
        }

        public int hashCode() {
            return this.f17906e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f17906e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        public final Subscription upstream;

        public SubscriptionNotification(Subscription subscription) {
            this.upstream = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f17906e);
            return true;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f17906e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            subscriber.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        }
        subscriber.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(InterfaceC4478 interfaceC4478) {
        return new DisposableNotification(interfaceC4478);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static InterfaceC4478 getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f17906e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, InterfaceC5102<? super T> interfaceC5102) {
        if (obj == COMPLETE) {
            interfaceC5102.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            interfaceC5102.onError(((ErrorNotification) obj).f17906e);
            return true;
        }
        interfaceC5102.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, InterfaceC5102<? super T> interfaceC5102) {
        if (obj == COMPLETE) {
            interfaceC5102.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            interfaceC5102.onError(((ErrorNotification) obj).f17906e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            interfaceC5102.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        interfaceC5102.onNext(obj);
        return false;
    }
}
