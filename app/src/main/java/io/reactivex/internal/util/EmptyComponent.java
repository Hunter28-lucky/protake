package io.reactivex.internal.util;

import defpackage.C3671;
import defpackage.InterfaceC3899;
import defpackage.InterfaceC4478;
import defpackage.InterfaceC4782;
import defpackage.InterfaceC5053;
import defpackage.InterfaceC5102;
import defpackage.InterfaceC5216;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public enum EmptyComponent implements InterfaceC3899<Object>, InterfaceC5102<Object>, InterfaceC5216<Object>, InterfaceC4782<Object>, InterfaceC5053, Subscription, InterfaceC4478 {
    INSTANCE;

    public static <T> InterfaceC5102<T> asObserver() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // defpackage.InterfaceC4478
    public void dispose() {
    }

    @Override // defpackage.InterfaceC4478
    public boolean isDisposed() {
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        C3671.m11803(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(Object obj) {
    }

    @Override // defpackage.InterfaceC5102
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        interfaceC4478.dispose();
    }

    @Override // defpackage.InterfaceC5216
    public void onSuccess(Object obj) {
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }

    @Override // defpackage.InterfaceC3899, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        subscription.cancel();
    }
}
