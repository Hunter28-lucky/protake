package defpackage;

import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableBufferExactBoundary.java */
/* renamed from: ړ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3532<T, U extends Collection<? super T>, B> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<B> f12319;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<U> f12320;

    /* compiled from: FlowableBufferExactBoundary.java */
    /* renamed from: ړ$Ϳ, reason: contains not printable characters */
    public static final class C3533<T, U extends Collection<? super T>, B> extends AbstractC2399<B> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C3534<T, U, B> f12321;

        public C3533(C3534<T, U, B> c3534) {
            this.f12321 = c3534;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f12321.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f12321.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            this.f12321.m11472();
        }
    }

    /* compiled from: FlowableBufferExactBoundary.java */
    /* renamed from: ړ$Ԩ, reason: contains not printable characters */
    public static final class C3534<T, U extends Collection<? super T>, B> extends AbstractC3894<T, U, U> implements Subscription, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<U> f12322;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final Publisher<B> f12323;

        /* renamed from: ؠ, reason: contains not printable characters */
        public Subscription f12324;

        /* renamed from: ހ, reason: contains not printable characters */
        public InterfaceC4478 f12325;

        /* renamed from: ށ, reason: contains not printable characters */
        public U f12326;

        public C3534(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.f12322 = callable;
            this.f12323 = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f13476) {
                return;
            }
            this.f13476 = true;
            this.f12325.dispose();
            this.f12324.cancel();
            if (m12561()) {
                this.f13475.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            cancel();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f13476;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                U u = this.f12326;
                if (u == null) {
                    return;
                }
                this.f12326 = null;
                this.f13475.offer(u);
                this.f13477 = true;
                if (m12561()) {
                    C5263.m15306(this.f13475, this.f13474, false, this, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.f12326;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f12324, subscription)) {
                this.f12324 = subscription;
                try {
                    this.f12326 = (U) C4246.m13353(this.f12322.call(), "The buffer supplied is null");
                    C3533 c3533 = new C3533(this);
                    this.f12325 = c3533;
                    this.f13474.onSubscribe(this);
                    if (this.f13476) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    this.f12323.subscribe(c3533);
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f13476 = true;
                    subscription.cancel();
                    EmptySubscription.error(th, this.f13474);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // defpackage.AbstractC3894, defpackage.InterfaceC2541
        /* renamed from: ؠ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public boolean mo9365(Subscriber<? super U> subscriber, U u) {
            this.f13474.onNext(u);
            return true;
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public void m11472() {
            try {
                U u = (U) C4246.m13353(this.f12322.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.f12326;
                    if (u2 == null) {
                        return;
                    }
                    this.f12326 = u;
                    m12563(u2, false, this);
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                cancel();
                this.f13474.onError(th);
            }
        }
    }

    public C3532(AbstractC3630<T> abstractC3630, Publisher<B> publisher, Callable<U> callable) {
        super(abstractC3630);
        this.f12319 = publisher;
        this.f12320 = callable;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C3534(new C4056(subscriber), this.f12320, this.f12319));
    }
}
