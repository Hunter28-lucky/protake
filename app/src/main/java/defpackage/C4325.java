package defpackage;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableDistinct.java */
/* renamed from: ગ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4325<T, K> extends AbstractC3232<T, T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, K> f14846;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<? extends Collection<? super K>> f14847;

    /* compiled from: FlowableDistinct.java */
    /* renamed from: ગ$Ϳ, reason: contains not printable characters */
    public static final class C4326<T, K> extends AbstractC5179<T, T> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final Collection<? super K> f14848;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, K> f14849;

        public C4326(Subscriber<? super T> subscriber, InterfaceC2368<? super T, K> interfaceC2368, Collection<? super K> collection) {
            super(subscriber);
            this.f14849 = interfaceC2368;
            this.f14848 = collection;
        }

        @Override // defpackage.AbstractC5179, defpackage.InterfaceC4851
        public void clear() {
            this.f14848.clear();
            super.clear();
        }

        @Override // defpackage.AbstractC5179, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f17148) {
                return;
            }
            this.f17148 = true;
            this.f14848.clear();
            this.f17145.onComplete();
        }

        @Override // defpackage.AbstractC5179, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f17148) {
                C3671.m11803(th);
                return;
            }
            this.f17148 = true;
            this.f14848.clear();
            this.f17145.onError(th);
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
                if (this.f14848.add(C4246.m13353(this.f14849.apply(t), "The keySelector returned a null key"))) {
                    this.f17145.onNext(t);
                } else {
                    this.f17146.request(1L);
                }
            } catch (Throwable th) {
                m15128(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public T poll() throws Exception {
            T tPoll;
            while (true) {
                tPoll = this.f17147.poll();
                if (tPoll == null || this.f14848.add((Object) C4246.m13353(this.f14849.apply(tPoll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f17149 == 2) {
                    this.f17146.request(1L);
                }
            }
            return tPoll;
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            return m15129(i);
        }
    }

    public C4325(AbstractC3630<T> abstractC3630, InterfaceC2368<? super T, K> interfaceC2368, Callable<? extends Collection<? super K>> callable) {
        super(abstractC3630);
        this.f14846 = interfaceC2368;
        this.f14847 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            this.f11385.subscribe((InterfaceC3899) new C4326(subscriber, this.f14846, (Collection) C4246.m13353(this.f14847.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            C4089.m13026(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
