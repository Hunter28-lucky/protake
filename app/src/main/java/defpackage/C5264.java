package defpackage;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableTimeInterval.java */
/* renamed from: ი, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5264<T> extends AbstractC3232<T, o2<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AbstractC4585 f17418;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final TimeUnit f17419;

    /* compiled from: FlowableTimeInterval.java */
    /* renamed from: ი$Ϳ, reason: contains not printable characters */
    public static final class C5265<T> implements InterfaceC3899<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super o2<T>> f17420;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final TimeUnit f17421;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final AbstractC4585 f17422;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f17423;

        /* renamed from: ԯ, reason: contains not printable characters */
        public long f17424;

        public C5265(Subscriber<? super o2<T>> subscriber, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f17420 = subscriber;
            this.f17422 = abstractC4585;
            this.f17421 = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f17423.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f17420.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f17420.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long jM14050 = this.f17422.m14050(this.f17421);
            long j = this.f17424;
            this.f17424 = jM14050;
            this.f17420.onNext(new o2(t, jM14050 - j, this.f17421));
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17423, subscription)) {
                this.f17424 = this.f17422.m14050(this.f17421);
                this.f17423 = subscription;
                this.f17420.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f17423.request(j);
        }
    }

    public C5264(AbstractC3630<T> abstractC3630, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        super(abstractC3630);
        this.f17418 = abstractC4585;
        this.f17419 = timeUnit;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super o2<T>> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5265(subscriber, this.f17419, this.f17418));
    }
}
