package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.InterfaceC2368;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableConcatMapEagerPublisher.java */
/* renamed from: io.reactivex.internal.operators.flowable.Ϳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2064<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f7207;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f7208;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f7209;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f7210;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final ErrorMode f7211;

    public C2064(Publisher<T> publisher, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, int i2, ErrorMode errorMode) {
        this.f7207 = publisher;
        this.f7208 = interfaceC2368;
        this.f7209 = i;
        this.f7210 = i2;
        this.f7211 = errorMode;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f7207.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f7208, this.f7209, this.f7210, this.f7211));
    }
}
