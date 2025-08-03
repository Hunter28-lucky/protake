package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.InterfaceC2368;
import io.reactivex.internal.operators.flowable.C2065;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableMapPublisher.java */
/* renamed from: io.reactivex.internal.operators.flowable.Ԫ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2068<T, U> extends AbstractC3630<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f7215;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends U> f7216;

    public C2068(Publisher<T> publisher, InterfaceC2368<? super T, ? extends U> interfaceC2368) {
        this.f7215 = publisher;
        this.f7216 = interfaceC2368;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f7215.subscribe(new C2065.C2067(subscriber, this.f7216));
    }
}
