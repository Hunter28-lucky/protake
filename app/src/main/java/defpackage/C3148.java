package defpackage;

import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: FlowableConcatMapPublisher.java */
/* renamed from: ԍ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3148<T, R> extends AbstractC3630<R> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Publisher<T> f11175;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2368<? super T, ? extends Publisher<? extends R>> f11176;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f11177;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final ErrorMode f11178;

    public C3148(Publisher<T> publisher, InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, ErrorMode errorMode) {
        this.f11175 = publisher;
        this.f11176 = interfaceC2368;
        this.f11177 = i;
        this.f11178 = errorMode;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (C2930.m10333(this.f11175, subscriber, this.f11176)) {
            return;
        }
        this.f11175.subscribe(FlowableConcatMap.m6398(subscriber, this.f11176, this.f11177, this.f11178));
    }
}
