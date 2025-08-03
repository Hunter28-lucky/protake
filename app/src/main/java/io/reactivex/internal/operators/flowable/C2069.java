package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableTakePublisher.java */
/* renamed from: io.reactivex.internal.operators.flowable.Ԭ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2069<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f7217;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final long f7218;

    public C2069(Publisher<T> publisher, long j) {
        this.f7217 = publisher;
        this.f7218 = j;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f7217.subscribe(new FlowableTake.TakeSubscriber(subscriber, this.f7218));
    }
}
