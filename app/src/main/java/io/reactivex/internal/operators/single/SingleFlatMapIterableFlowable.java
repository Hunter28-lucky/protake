package io.reactivex.internal.operators.single;

import defpackage.AbstractC3630;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class SingleFlatMapIterableFlowable<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC3951<T> f7592;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> f7593;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements InterfaceC4782<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public volatile boolean cancelled;
        public final Subscriber<? super R> downstream;
        public volatile Iterator<? extends R> it;
        public final InterfaceC2368<? super T, ? extends Iterable<? extends R>> mapper;
        public boolean outputFused;
        public final AtomicLong requested = new AtomicLong();
        public InterfaceC4478 upstream;

        public FlatMapIterableObserver(Subscriber<? super R> subscriber, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
            this.downstream = subscriber;
            this.mapper = interfaceC2368;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // defpackage.InterfaceC4851
        public void clear() {
            this.it = null;
        }

        @Override // defpackage.InterfaceC4851
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // defpackage.InterfaceC4782
        public void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC4782
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            if (DisposableHelper.validate(this.upstream, interfaceC4478)) {
                this.upstream = interfaceC4478;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.InterfaceC4782
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.downstream.onComplete();
                } else {
                    this.it = it;
                    m6952();
                }
            } catch (Throwable th) {
                C4089.m13026(th);
                this.downstream.onError(th);
            }
        }

        @Override // defpackage.InterfaceC4851
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it == null) {
                return null;
            }
            R r = (R) C4246.m13353(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.it = null;
            }
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
                m6952();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m6952() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.downstream;
            Iterator<? extends R> it = this.it;
            if (this.outputFused && it != null) {
                subscriber.onNext(null);
                subscriber.onComplete();
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                if (it != null) {
                    long j = this.requested.get();
                    if (j == Long.MAX_VALUE) {
                        m6953(subscriber, it);
                        return;
                    }
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            subscriber.onNext((Object) C4246.m13353(it.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j2++;
                            try {
                                if (!it.hasNext()) {
                                    subscriber.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                C4089.m13026(th);
                                subscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            C4089.m13026(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        C5153.m15073(this.requested, j2);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (it == null) {
                    it = this.it;
                }
            }
        }

        @Override // defpackage.InterfaceC3460
        /* renamed from: ԩ */
        public int mo6310(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m6953(Subscriber<? super R> subscriber, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    subscriber.onNext(it.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        C4089.m13026(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    C4089.m13026(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }
    }

    public SingleFlatMapIterableFlowable(InterfaceC3951<T> interfaceC3951, InterfaceC2368<? super T, ? extends Iterable<? extends R>> interfaceC2368) {
        this.f7592 = interfaceC3951;
        this.f7593 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7592.subscribe(new FlatMapIterableObserver(subscriber, this.f7593));
    }
}
