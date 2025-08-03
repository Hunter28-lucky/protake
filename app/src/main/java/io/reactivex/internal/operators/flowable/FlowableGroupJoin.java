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
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4851;
import defpackage.InterfaceC5247;
import defpackage.a;
import defpackage.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
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
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractC3232<TLeft, R> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Publisher<? extends TRight> f6962;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> f6963;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> f6964;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC5247<? super TLeft, ? super AbstractC3630<TRight>, ? extends R> f6965;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, InterfaceC2024 {
        private static final long serialVersionUID = -6071216598687999801L;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Integer f6966 = 1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static final Integer f6967 = 2;

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final Integer f6968 = 3;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public static final Integer f6969 = 4;
        public volatile boolean cancelled;
        public final Subscriber<? super R> downstream;
        public final InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final InterfaceC5247<? super TLeft, ? super AbstractC3630<TRight>, ? extends R> resultSelector;
        public final InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> rightEnd;
        public int rightIndex;
        public final AtomicLong requested = new AtomicLong();
        public final C2527 disposables = new C2527();
        public final d<Object> queue = new d<>(AbstractC3630.bufferSize());
        public final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public GroupJoinSubscription(Subscriber<? super R> subscriber, InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super AbstractC3630<TRight>, ? extends R> interfaceC5247) {
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
            m6486();
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
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo6481(Throwable th) {
            if (!ExceptionHelper.m7020(this.error, th)) {
                C3671.m11803(th);
            } else {
                this.active.decrementAndGet();
                m6487();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo6482(Throwable th) {
            if (ExceptionHelper.m7020(this.error, th)) {
                m6487();
            } else {
                C3671.m11803(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo6483(boolean z, Object obj) {
            synchronized (this) {
                this.queue.m5884(z ? f6966 : f6967, obj);
            }
            m6487();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo6484(boolean z, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.m5884(z ? f6968 : f6969, leftRightEndSubscriber);
            }
            m6487();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.InterfaceC2024
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo6485(LeftRightSubscriber leftRightSubscriber) {
            this.disposables.mo9335(leftRightSubscriber);
            this.active.decrementAndGet();
            m6487();
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m6486() {
            this.disposables.dispose();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m6487() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<Object> dVar = this.queue;
            Subscriber<? super R> subscriber = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    dVar.clear();
                    m6486();
                    m6488(subscriber);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) dVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<UnicastProcessor<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = dVar.poll();
                    if (num == f6966) {
                        UnicastProcessor unicastProcessorM7026 = UnicastProcessor.m7026();
                        int i = this.leftIndex;
                        this.leftIndex = i + 1;
                        this.lefts.put(Integer.valueOf(i), unicastProcessorM7026);
                        try {
                            Publisher publisher = (Publisher) C4246.m13353(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i);
                            this.disposables.mo9333(leftRightEndSubscriber);
                            publisher.subscribe(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6486();
                                m6488(subscriber);
                                return;
                            }
                            try {
                                a aVar = (Object) C4246.m13353(this.resultSelector.apply(objPoll, unicastProcessorM7026), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    m6489(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, dVar);
                                    return;
                                }
                                subscriber.onNext(aVar);
                                C5153.m15073(this.requested, 1L);
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    unicastProcessorM7026.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                m6489(th, subscriber, dVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            m6489(th2, subscriber, dVar);
                            return;
                        }
                    } else if (num == f6967) {
                        int i2 = this.rightIndex;
                        this.rightIndex = i2 + 1;
                        this.rights.put(Integer.valueOf(i2), objPoll);
                        try {
                            Publisher publisher2 = (Publisher) C4246.m13353(this.rightEnd.apply(objPoll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i2);
                            this.disposables.mo9333(leftRightEndSubscriber2);
                            publisher2.subscribe(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                dVar.clear();
                                m6486();
                                m6488(subscriber);
                                return;
                            } else {
                                Iterator<UnicastProcessor<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            m6489(th3, subscriber, dVar);
                            return;
                        }
                    } else if (num == f6968) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) objPoll;
                        UnicastProcessor<TRight> unicastProcessorRemove = this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.mo9334(leftRightEndSubscriber3);
                        if (unicastProcessorRemove != null) {
                            unicastProcessorRemove.onComplete();
                        }
                    } else if (num == f6969) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.mo9334(leftRightEndSubscriber4);
                    }
                }
            }
            dVar.clear();
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m6488(Subscriber<?> subscriber) {
            Throwable thM7021 = ExceptionHelper.m7021(this.error);
            Iterator<UnicastProcessor<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thM7021);
            }
            this.lefts.clear();
            this.rights.clear();
            subscriber.onError(thM7021);
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public void m6489(Throwable th, Subscriber<?> subscriber, InterfaceC4851<?> interfaceC4851) {
            C4089.m13026(th);
            ExceptionHelper.m7020(this.error, th);
            interfaceC4851.clear();
            m6486();
            m6488(subscriber);
        }
    }

    public static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final InterfaceC2024 parent;

        public LeftRightEndSubscriber(InterfaceC2024 interfaceC2024, boolean z, int i) {
            this.parent = interfaceC2024;
            this.isLeft = z;
            this.index = i;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.mo6484(this.isLeft, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.mo6482(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.mo6484(this.isLeft, this);
            }
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class LeftRightSubscriber extends AtomicReference<Subscription> implements InterfaceC3899<Object>, InterfaceC4478 {
        private static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final InterfaceC2024 parent;

        public LeftRightSubscriber(InterfaceC2024 interfaceC2024, boolean z) {
            this.parent = interfaceC2024;
            this.isLeft = z;
        }

        @Override // defpackage.InterfaceC4478
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // defpackage.InterfaceC4478
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.parent.mo6485(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.parent.mo6481(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.parent.mo6483(this.isLeft, obj);
        }

        @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableGroupJoin$Ϳ, reason: contains not printable characters */
    public interface InterfaceC2024 {
        /* renamed from: Ϳ */
        void mo6481(Throwable th);

        /* renamed from: Ԩ */
        void mo6482(Throwable th);

        /* renamed from: ԩ */
        void mo6483(boolean z, Object obj);

        /* renamed from: Ԫ */
        void mo6484(boolean z, LeftRightEndSubscriber leftRightEndSubscriber);

        /* renamed from: ԫ */
        void mo6485(LeftRightSubscriber leftRightSubscriber);
    }

    public FlowableGroupJoin(AbstractC3630<TLeft> abstractC3630, Publisher<? extends TRight> publisher, InterfaceC2368<? super TLeft, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super TLeft, ? super AbstractC3630<TRight>, ? extends R> interfaceC5247) {
        super(abstractC3630);
        this.f6962 = publisher;
        this.f6963 = interfaceC2368;
        this.f6964 = interfaceC23682;
        this.f6965 = interfaceC5247;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.f6963, this.f6964, this.f6965);
        subscriber.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.disposables.mo9333(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.disposables.mo9333(leftRightSubscriber2);
        this.f11385.subscribe((InterfaceC3899) leftRightSubscriber);
        this.f6962.subscribe(leftRightSubscriber2);
    }
}
