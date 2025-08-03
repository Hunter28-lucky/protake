package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableBufferBoundarySupplier.java */
/* renamed from: ζ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2814<T, U extends Collection<? super T>, B> extends AbstractC3232<T, U> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Callable<? extends Publisher<B>> f10278;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Callable<U> f10279;

    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* renamed from: ζ$Ϳ, reason: contains not printable characters */
    public static final class C2815<T, U extends Collection<? super T>, B> extends AbstractC2399<B> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C2816<T, U, B> f10280;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f10281;

        public C2815(C2816<T, U, B> c2816) {
            this.f10280 = c2816;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f10281) {
                return;
            }
            this.f10281 = true;
            this.f10280.m10158();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f10281) {
                C3671.m11803(th);
            } else {
                this.f10281 = true;
                this.f10280.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.f10281) {
                return;
            }
            this.f10281 = true;
            m8890();
            this.f10280.m10158();
        }
    }

    /* compiled from: FlowableBufferBoundarySupplier.java */
    /* renamed from: ζ$Ԩ, reason: contains not printable characters */
    public static final class C2816<T, U extends Collection<? super T>, B> extends AbstractC3894<T, U, U> implements Subscription, InterfaceC4478 {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Callable<U> f10282;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final Callable<? extends Publisher<B>> f10283;

        /* renamed from: ؠ, reason: contains not printable characters */
        public Subscription f10284;

        /* renamed from: ހ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f10285;

        /* renamed from: ށ, reason: contains not printable characters */
        public U f10286;

        public C2816(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.f10285 = new AtomicReference<>();
            this.f10282 = callable;
            this.f10283 = callable2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f13476) {
                return;
            }
            this.f13476 = true;
            this.f10284.cancel();
            m10157();
            if (m12561()) {
                this.f13475.clear();
            }
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            this.f10284.cancel();
            m10157();
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return this.f10285.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                U u = this.f10286;
                if (u == null) {
                    return;
                }
                this.f10286 = null;
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
                U u = this.f10286;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10284, subscription)) {
                this.f10284 = subscription;
                Subscriber<? super V> subscriber = this.f13474;
                try {
                    this.f10286 = (U) C4246.m13353(this.f10282.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) C4246.m13353(this.f10283.call(), "The boundary publisher supplied is null");
                        C2815 c2815 = new C2815(this);
                        this.f10285.set(c2815);
                        subscriber.onSubscribe(this);
                        if (this.f13476) {
                            return;
                        }
                        subscription.request(Long.MAX_VALUE);
                        publisher.subscribe(c2815);
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        this.f13476 = true;
                        subscription.cancel();
                        EmptySubscription.error(th, subscriber);
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    this.f13476 = true;
                    subscription.cancel();
                    EmptySubscription.error(th2, subscriber);
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
        public void m10157() {
            DisposableHelper.dispose(this.f10285);
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public void m10158() {
            try {
                U u = (U) C4246.m13353(this.f10282.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) C4246.m13353(this.f10283.call(), "The boundary publisher supplied is null");
                    C2815 c2815 = new C2815(this);
                    if (DisposableHelper.replace(this.f10285, c2815)) {
                        synchronized (this) {
                            U u2 = this.f10286;
                            if (u2 == null) {
                                return;
                            }
                            this.f10286 = u;
                            publisher.subscribe(c2815);
                            m12563(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    C4089.m13026(th);
                    this.f13476 = true;
                    this.f10284.cancel();
                    this.f13474.onError(th);
                }
            } catch (Throwable th2) {
                C4089.m13026(th2);
                cancel();
                this.f13474.onError(th2);
            }
        }
    }

    public C2814(AbstractC3630<T> abstractC3630, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(abstractC3630);
        this.f10278 = callable;
        this.f10279 = callable2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C2816(new C4056(subscriber), this.f10279, this.f10278));
    }
}
