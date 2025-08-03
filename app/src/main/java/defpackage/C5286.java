package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableDematerialize.java */
/* renamed from: ს, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5286<T, R> extends AbstractC3232<T, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends C3906<R>> f17470;

    /* compiled from: FlowableDematerialize.java */
    /* renamed from: ს$Ϳ, reason: contains not printable characters */
    public static final class C5287<T, R> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super R> f17471;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends C3906<R>> f17472;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f17473;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f17474;

        public C5287(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends C3906<R>> interfaceC2368) {
            this.f17471 = subscriber;
            this.f17472 = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f17474.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17473) {
                return;
            }
            this.f17473 = true;
            this.f17471.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17473) {
                C3671.m11803(th);
            } else {
                this.f17473 = true;
                this.f17471.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f17473) {
                if (t instanceof C3906) {
                    C3906 c3906 = (C3906) t;
                    if (c3906.m12651()) {
                        C3671.m11803(c3906.m12648());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                C3906 c39062 = (C3906) C4246.m13353(this.f17472.apply(t), "The selector returned a null Notification");
                if (c39062.m12651()) {
                    this.f17474.cancel();
                    onError(c39062.m12648());
                } else if (!c39062.m12650()) {
                    this.f17471.onNext((Object) c39062.m12649());
                } else {
                    this.f17474.cancel();
                    onComplete();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f17474.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17474, subscription)) {
                this.f17474 = subscription;
                this.f17471.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f17474.request(j);
        }
    }

    public C5286(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, ? extends C3906<R>> interfaceC2368) {
        super(abstractC3630);
        this.f17470 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5287(subscriber, this.f17470));
    }
}
