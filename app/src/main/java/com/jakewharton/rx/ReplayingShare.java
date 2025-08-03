package com.jakewharton.rx;

import defpackage.AbstractC3630;
import defpackage.AbstractC4262;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5242;
import defpackage.InterfaceC5298;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ReplayingShare<T> implements InterfaceC5298<T, T>, InterfaceC5242<T, T> {
    private static final ReplayingShare<Object> INSTANCE = new ReplayingShare<>(null);
    private final T defaultValue;

    public static final class LastSeen<T> implements InterfaceC5102<T>, Subscriber<T> {
        private final T defaultValue;
        public volatile T value;

        public LastSeen(T t) {
            this.defaultValue = t;
            this.value = t;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.value = this.defaultValue;
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.value = this.defaultValue;
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.value = t;
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
        }
    }

    public static final class LastSeenFlowable<T> extends AbstractC3630<T> {
        private final LastSeen<T> lastSeen;
        private final AbstractC3630<T> upstream;

        public LastSeenFlowable(AbstractC3630<T> abstractC3630, LastSeen<T> lastSeen) {
            this.upstream = abstractC3630;
            this.lastSeen = lastSeen;
        }

        @Override // defpackage.AbstractC3630
        public void subscribeActual(Subscriber<? super T> subscriber) {
            this.upstream.subscribe(new LastSeenSubscriber(subscriber, this.lastSeen));
        }
    }

    public static final class LastSeenObservable<T> extends AbstractC4262<T> {
        private final LastSeen<T> lastSeen;
        private final AbstractC4262<T> upstream;

        public LastSeenObservable(AbstractC4262<T> abstractC4262, LastSeen<T> lastSeen) {
            this.upstream = abstractC4262;
            this.lastSeen = lastSeen;
        }

        @Override // defpackage.AbstractC4262
        public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
            this.upstream.subscribe(new LastSeenObserver(interfaceC5102, this.lastSeen));
        }
    }

    public static final class LastSeenObserver<T> implements InterfaceC5102<T> {
        private final InterfaceC5102<? super T> downstream;
        private final LastSeen<T> lastSeen;

        public LastSeenObserver(InterfaceC5102<? super T> interfaceC5102, LastSeen<T> lastSeen) {
            this.downstream = interfaceC5102;
            this.lastSeen = lastSeen;
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.downstream.onSubscribe(interfaceC4478);
            T t = this.lastSeen.value;
            if (t == null || interfaceC4478.isDisposed()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    public static final class LastSeenSubscriber<T> implements Subscriber<T>, Subscription {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean cancelled;
        private final Subscriber<? super T> downstream;
        private boolean first = true;
        private final LastSeen<T> lastSeen;
        private Subscription subscription;

        public LastSeenSubscriber(Subscriber<? super T> subscriber, LastSeen<T> lastSeen) {
            this.downstream = subscriber;
            this.lastSeen = lastSeen;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.subscription;
            this.cancelled = true;
            subscription.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.subscription = subscription;
            this.downstream.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (j == 0) {
                return;
            }
            if (this.first) {
                this.first = false;
                T t = this.lastSeen.value;
                if (t != null && !this.cancelled) {
                    this.downstream.onNext(t);
                    if (j != Long.MAX_VALUE) {
                        j--;
                        if (j == 0) {
                            return;
                        }
                    }
                }
            }
            this.subscription.request(j);
        }
    }

    private ReplayingShare(T t) {
        this.defaultValue = t;
    }

    public static <T> ReplayingShare<T> createWithDefault(T t) {
        if (t != null) {
            return new ReplayingShare<>(t);
        }
        throw new NullPointerException("defaultValue == null");
    }

    public static <T> ReplayingShare<T> instance() {
        return (ReplayingShare<T>) INSTANCE;
    }

    @Override // defpackage.InterfaceC5298
    public AbstractC4262<T> apply(AbstractC4262<T> abstractC4262) {
        LastSeen lastSeen = new LastSeen(this.defaultValue);
        return new LastSeenObservable(abstractC4262.doOnEach(lastSeen).share(), lastSeen);
    }

    @Override // defpackage.InterfaceC5242
    public AbstractC3630<T> apply(AbstractC3630<T> abstractC3630) {
        LastSeen lastSeen = new LastSeen(this.defaultValue);
        return new LastSeenFlowable(abstractC3630.doOnEach(lastSeen).share(), lastSeen);
    }
}
