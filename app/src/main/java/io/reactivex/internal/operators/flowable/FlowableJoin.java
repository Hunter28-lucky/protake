package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3232;
import defpackage.AbstractC3630;
import defpackage.C2527;
import defpackage.C3671;
import defpackage.C4089;
import defpackage.C4246;
import defpackage.C5153;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5247;
import defpackage.a;
import defpackage.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC3232<TLeft, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends TRight> f7008;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> f7009;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> f7010;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5247<? super TLeft, ? super TRight, ? extends R> f7011;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.InterfaceC2024 {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Integer f7012 = 1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Integer f7013 = 2;

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final Integer f7014 = 3;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final Integer f7015 = 4;
        public volatile boolean cancelled;
        public final Subscriber<? super R> downstream;
        public final InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final InterfaceC5247<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        public int rightIndex;
        public final AtomicLong requested = new AtomicLong();
        public final C2527 disposables = new C2527();
        public final d<Object> queue = new d<>(AbstractC3630.bufferSize());
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public JoinSubscription(Subscriber<? super R> subscriber, InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super TRight, ? extends R> interfaceC5247) {
            this.downstream = subscriber;
            this.leftEnd = interfaceC2368;
            this.rightEnd = interfaceC23682;
            this.resultSelector = interfaceC5247;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            m6519();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                C5153.m15069(this.requested, j);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: Ϳ */
        public void mo6481(Throwable th) {
            if (!ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                this.active.decrementAndGet();
                m6520();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: Ԩ */
        public void mo6482(Throwable th) {
            if (ExceptionHelper.m7020(this.error, th)) {
                m6520();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: ԩ */
        public void mo6483(boolean z, Object obj) {
            synchronized (this) {
                this.queue.m5884(z ? f7012 : f7013, obj);
            }
            m6520();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: Ԫ */
        public void mo6484(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.m5884(z ? f7014 : f7015, leftRightEndSubscriber);
            }
            m6520();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: ԫ */
        public void mo6485(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.disposables.mo9335(leftRightSubscriber);
            this.active.decrementAndGet();
            m6520();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6519() {
            this.disposables.dispose();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6520() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<Object> dVar = this.queue;
            Subscriber<? super R> subscriber = this.downstream;
            boolean z = true;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    dVar.clear();
                    m6519();
                    m6521(subscriber);
                    return;
                }
                boolean z2 = this.active.get() == 0 ? z : false;
                Integer num = (Integer) dVar.poll();
                boolean z3 = num == null ? z : false;
                if (z2 && z3) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = dVar.poll();
                    if (num == f7012) {
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), objPoll);
                        try {
                            Publisher publisher = (Publisher) C4246.m13353(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z, i);
                            this.disposables.mo9333(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6519();
                                m6521(subscriber);
                                return;
                            }
                            long j = this.requested.get();
                            Iterator<TRight> it = this.rights.values().iterator();
                            long j2 = 0;
                            while (it.hasNext()) {
                                try {
                                    a aVar = (Object) C4246.m13353(this.resultSelector.apply(objPoll, it.next()), "The resultSelector returned a null value");
                                    if (j2 == j) {
                                        ExceptionHelper.m7020(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        dVar.clear();
                                        m6519();
                                        m6521(subscriber);
                                        return;
                                    }
                                    subscriber.onNext(aVar);
                                    j2++;
                                } catch (Throwable th) {
                                    m6522(th, subscriber, dVar);
                                    return;
                                }
                            }
                            if (j2 != 0) {
                                C5153.m15073(this.requested, j2);
                            }
                        } catch (Throwable th2) {
                            m6522(th2, subscriber, dVar);
                            return;
                        }
                    } else if (num == f7013) {
                        int i2 = this.rightIndex;
                        this.rightIndex = i2 + 1;
                        this.rights.put(Integer.valueOf(i2), objPoll);
                        try {
                            Publisher publisher2 = (Publisher) C4246.m13353(this.rightEnd.apply(objPoll), "The rightEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i2);
                            this.disposables.mo9333(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6519();
                                m6521(subscriber);
                                return;
                            }
                            long j3 = this.requested.get();
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            long j4 = 0;
                            while (it2.hasNext()) {
                                try {
                                    a aVar2 = (Object) C4246.m13353(this.resultSelector.apply(it2.next(), objPoll), "The resultSelector returned a null value");
                                    if (j4 == j3) {
                                        ExceptionHelper.m7020(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        dVar.clear();
                                        m6519();
                                        m6521(subscriber);
                                        return;
                                    }
                                    subscriber.onNext(aVar2);
                                    j4++;
                                } catch (Throwable th3) {
                                    m6522(th3, subscriber, dVar);
                                    return;
                                }
                            }
                            if (j4 != 0) {
                                C5153.m15073(this.requested, j4);
                            }
                        } catch (Throwable th4) {
                            m6522(th4, subscriber, dVar);
                            return;
                        }
                    } else if (num == f7014) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.mo9334(leftRightEndSubscriber3);
                    } else if (num == f7015) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.mo9334(leftRightEndSubscriber4);
                    }
                    z = true;
                }
            }
            dVar.clear();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6521(Subscriber<?> subscriber) {
            Throwable thM7021 = ExceptionHelper.m7021(this.error);
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(thM7021);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6522(Throwable th, Subscriber<?> subscriber, InterfaceC4851<?> interfaceC4851) {
            C4089.m13026(th);
            ExceptionHelper.m7020(this.error, th);
            interfaceC4851.clear();
            m6519();
            m6521(subscriber);
        }
    }

    public FlowableJoin(AbstractC3630<TLeft> abstractC3630, Publisher<? extends TRight> publisher, InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super TRight, ? extends R> interfaceC5247) {
        super(abstractC3630);
        this.f7008 = publisher;
        this.f7009 = interfaceC2368;
        this.f7010 = interfaceC23682;
        this.f7011 = interfaceC5247;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.f7009, this.f7010, this.f7011);
        subscriber.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.mo9333(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.mo9333(leftRightSubscriber2);
        this.f11385.subscribe((InterfaceC3899) leftRightSubscriber);
        this.f7008.subscribe(leftRightSubscriber2);
    }
}
