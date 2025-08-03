package io.reactivex.internal.subscribers;

import defpackage.C3671;
import defpackage.C4089;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4478;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements InterfaceC3899<T>, InterfaceC4478 {
    private static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final InterfaceC3809 onComplete;
    public final InterfaceC2857<? super Throwable> onError;
    public final InterfaceC4178<? super T> onNext;

    public ForEachWhileSubscriber(InterfaceC4178<? super T> interfaceC4178, InterfaceC2857<? super Throwable> interfaceC2857, InterfaceC3809 interfaceC3809) {
        this.onNext = interfaceC4178;
        this.onError = interfaceC2857;
        this.onComplete = interfaceC3809;
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
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.done) {
            C3671.m11803(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            C4089.m13026(th2);
            C3671.m11803(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            C4089.m13026(th);
            dispose();
            onError(th);
        }
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
