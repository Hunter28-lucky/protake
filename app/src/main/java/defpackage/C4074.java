package defpackage;

import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableFlatMapPublisher.java */
/* renamed from: ठ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4074<T, U> extends AbstractC3630<U> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f14161;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends U>> f14162;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f14163;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f14164;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f14165;

    public C4074(Publisher<T> publisher, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, boolean z, int i, int i2) {
        this.f14161 = publisher;
        this.f14162 = interfaceC2368;
        this.f14163 = z;
        this.f14164 = i;
        this.f14165 = i2;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (C2930.m10333(this.f14161, subscriber, this.f14162)) {
            return;
        }
        this.f14161.subscribe(FlowableFlatMap.m6428(subscriber, this.f14162, this.f14163, this.f14164, this.f14165));
    }
}
