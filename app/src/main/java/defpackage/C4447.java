package defpackage;

import io.reactivex.internal.operators.flowable.FlowableReduce;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* compiled from: FlowableReduceMaybe.java */
/* renamed from: ୱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4447<T> extends AbstractC4274<T> implements InterfaceC2583<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC3630<T> f15325;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC5247<T, T, T> f15326;

    /* compiled from: FlowableReduceMaybe.java */
    /* renamed from: ୱ$Ϳ, reason: contains not printable characters */
    public static final class C4448<T> implements InterfaceC3899<T>, InterfaceC4478 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5216<? super T> f15327;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5247<T, T, T> f15328;

        /* renamed from: ԭ, reason: contains not printable characters */
        public T f15329;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Subscription f15330;

        /* renamed from: ԯ, reason: contains not printable characters */
        public boolean f15331;

        public C4448(InterfaceC5216<? super T> interfaceC5216, InterfaceC5247<T, T, T> interfaceC5247) {
            this.f15327 = interfaceC5216;
            this.f15328 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f15330.cancel();
            this.f15331 = true;
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f15331;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f15331) {
                return;
            }
            this.f15331 = true;
            T t = this.f15329;
            if (t != null) {
                this.f15327.onSuccess(t);
            } else {
                this.f15327.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f15331) {
                C3671.m11803(th);
            } else {
                this.f15331 = true;
                this.f15327.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f15331) {
                return;
            }
            T t2 = this.f15329;
            if (t2 == null) {
                this.f15329 = t;
                return;
            }
            try {
                this.f15329 = (T) C4246.m13353(this.f15328.apply(t2, t), "The reducer returned a null value");
            } catch (Throwable th) {
                C4089.m13026(th);
                this.f15330.cancel();
                onError(th);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15330, subscription)) {
                this.f15330 = subscription;
                this.f15327.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public C4447(AbstractC3630<T> abstractC3630, InterfaceC5247<T, T, T> interfaceC5247) {
        this.f15325 = abstractC3630;
        this.f15326 = interfaceC5247;
    }

    @Override // defpackage.InterfaceC2583
    /* renamed from: ԩ */
    public AbstractC3630<T> mo6444() {
        return C3671.m11796(new FlowableReduce(this.f15325, this.f15326));
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        this.f15325.subscribe((InterfaceC3899) new C4448(interfaceC5216, this.f15326));
    }
}
