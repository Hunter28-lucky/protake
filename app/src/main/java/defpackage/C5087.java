package defpackage;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableWindowBoundarySelector.java */
/* renamed from: စ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5087<T, B, V> extends AbstractC3232<T, AbstractC3630<T>> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<B> f16894;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super B, ? extends Publisher<V>> f16895;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f16896;

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: စ$Ϳ, reason: contains not printable characters */
    public static final class C5088<T, V> extends AbstractC2399<V> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5090<T, ?, V> f16897;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final UnicastProcessor<T> f16898;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f16899;

        public C5088(C5090<T, ?, V> c5090, UnicastProcessor<T> unicastProcessor) {
            this.f16897 = c5090;
            this.f16898 = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f16899) {
                return;
            }
            this.f16899 = true;
            this.f16897.m14917(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f16899) {
                C3671.m11803(th);
            } else {
                this.f16899 = true;
                this.f16897.m14919(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V v) {
            m8890();
            onComplete();
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: စ$Ԩ, reason: contains not printable characters */
    public static final class C5089<T, B> extends AbstractC2399<B> {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final C5090<T, B, ?> f16900;

        public C5089(C5090<T, B, ?> c5090) {
            this.f16900 = c5090;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f16900.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f16900.m14919(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            this.f16900.m14920(b);
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: စ$Ԫ, reason: contains not printable characters */
    public static final class C5090<T, B, V> extends AbstractC3894<T, Object, AbstractC3630<T>> implements Subscription {

        /* renamed from: ֏, reason: contains not printable characters */
        public final Publisher<B> f16901;

        /* renamed from: ׯ, reason: contains not printable characters */
        public final InterfaceC2368<? super B, ? extends Publisher<V>> f16902;

        /* renamed from: ؠ, reason: contains not printable characters */
        public final int f16903;

        /* renamed from: ހ, reason: contains not printable characters */
        public final C2527 f16904;

        /* renamed from: ށ, reason: contains not printable characters */
        public Subscription f16905;

        /* renamed from: ނ, reason: contains not printable characters */
        public final AtomicReference<InterfaceC4478> f16906;

        /* renamed from: ރ, reason: contains not printable characters */
        public final List<UnicastProcessor<T>> f16907;

        /* renamed from: ބ, reason: contains not printable characters */
        public final AtomicLong f16908;

        /* renamed from: ޅ, reason: contains not printable characters */
        public final AtomicBoolean f16909;

        public C5090(Subscriber<? super AbstractC3630<T>> subscriber, Publisher<B> publisher, InterfaceC2368<? super B, ? extends Publisher<V>> interfaceC2368, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.f16906 = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.f16908 = atomicLong;
            this.f16909 = new AtomicBoolean();
            this.f16901 = publisher;
            this.f16902 = interfaceC2368;
            this.f16903 = i;
            this.f16904 = new C2527();
            this.f16907 = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f16909.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f16906);
                if (this.f16908.decrementAndGet() == 0) {
                    this.f16905.cancel();
                }
            }
        }

        public void dispose() {
            this.f16904.dispose();
            DisposableHelper.dispose(this.f16906);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f13477) {
                return;
            }
            this.f13477 = true;
            if (m12561()) {
                m14918();
            }
            if (this.f16908.decrementAndGet() == 0) {
                this.f16904.dispose();
            }
            this.f13474.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f13477) {
                C3671.m11803(th);
                return;
            }
            this.f13478 = th;
            this.f13477 = true;
            if (m12561()) {
                m14918();
            }
            if (this.f16908.decrementAndGet() == 0) {
                this.f16904.dispose();
            }
            this.f13474.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f13477) {
                return;
            }
            if (m12562()) {
                Iterator<UnicastProcessor<T>> it = this.f16907.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (mo9363(-1) == 0) {
                    return;
                }
            } else {
                this.f13475.offer(NotificationLite.next(t));
                if (!m12561()) {
                    return;
                }
            }
            m14918();
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16905, subscription)) {
                this.f16905 = subscription;
                this.f13474.onSubscribe(this);
                if (this.f16909.get()) {
                    return;
                }
                C5089 c5089 = new C5089(this);
                if (C4905.m14631(this.f16906, null, c5089)) {
                    subscription.request(Long.MAX_VALUE);
                    this.f16901.subscribe(c5089);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            m12565(j);
        }

        @Override // defpackage.AbstractC3894, defpackage.InterfaceC2541
        /* renamed from: Ԭ */
        public boolean mo9365(Subscriber<? super AbstractC3630<T>> subscriber, Object obj) {
            return false;
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public void m14917(C5088<T, V> c5088) {
            this.f16904.mo9335(c5088);
            this.f13475.offer(new C5091(c5088.f16898, null));
            if (m12561()) {
                m14918();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: ހ, reason: contains not printable characters */
        public void m14918() {
            InterfaceC4851 interfaceC4851 = this.f13475;
            Subscriber<? super V> subscriber = this.f13474;
            List<UnicastProcessor<T>> list = this.f16907;
            int iMo9363 = 1;
            while (true) {
                boolean z = this.f13477;
                Object objPoll = interfaceC4851.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    dispose();
                    Throwable th = this.f13478;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    iMo9363 = mo9363(-iMo9363);
                    if (iMo9363 == 0) {
                        return;
                    }
                } else if (objPoll instanceof C5091) {
                    C5091 c5091 = (C5091) objPoll;
                    UnicastProcessor<T> unicastProcessor = c5091.f16910;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            c5091.f16910.onComplete();
                            if (this.f16908.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f16909.get()) {
                        UnicastProcessor<T> unicastProcessorM7027 = UnicastProcessor.m7027(this.f16903);
                        long jMo9364 = mo9364();
                        if (jMo9364 != 0) {
                            list.add(unicastProcessorM7027);
                            subscriber.onNext(unicastProcessorM7027);
                            if (jMo9364 != Long.MAX_VALUE) {
                                mo9366(1L);
                            }
                            try {
                                Publisher publisher = (Publisher) C4246.m13353(this.f16902.apply(c5091.f16911), "The publisher supplied is null");
                                C5088 c5088 = new C5088(this, unicastProcessorM7027);
                                if (this.f16904.mo9333(c5088)) {
                                    this.f16908.getAndIncrement();
                                    publisher.subscribe(c5088);
                                }
                            } catch (Throwable th2) {
                                cancel();
                                subscriber.onError(th2);
                            }
                        } else {
                            cancel();
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(NotificationLite.getValue(objPoll));
                    }
                }
            }
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public void m14919(Throwable th) {
            this.f16905.cancel();
            this.f16904.dispose();
            DisposableHelper.dispose(this.f16906);
            this.f13474.onError(th);
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public void m14920(B b) {
            this.f13475.offer(new C5091(null, b));
            if (m12561()) {
                m14918();
            }
        }
    }

    /* compiled from: FlowableWindowBoundarySelector.java */
    /* renamed from: စ$Ԭ, reason: contains not printable characters */
    public static final class C5091<T, B> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final UnicastProcessor<T> f16910;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final B f16911;

        public C5091(UnicastProcessor<T> unicastProcessor, B b) {
            this.f16910 = unicastProcessor;
            this.f16911 = b;
        }
    }

    public C5087(AbstractC3630<T> abstractC3630, Publisher<B> publisher, InterfaceC2368<? super B, ? extends Publisher<V>> interfaceC2368, int i) {
        super(abstractC3630);
        this.f16894 = publisher;
        this.f16895 = interfaceC2368;
        this.f16896 = i;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super AbstractC3630<T>> subscriber) {
        this.f11385.subscribe((InterfaceC3899) new C5090(new C4056(subscriber), this.f16894, this.f16895, this.f16896));
    }
}
