package defpackage;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: FlowableFromObservable.java */
/* renamed from: ჺ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5321<T> extends AbstractC3630<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC4262<T> f17610;

    /* compiled from: FlowableFromObservable.java */
    /* renamed from: ჺ$Ϳ, reason: contains not printable characters */
    public static final class C5322<T> implements InterfaceC5102<T>, Subscription {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<? super T> f17611;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public InterfaceC4478 f17612;

        public C5322(Subscriber<? super T> subscriber) {
            this.f17611 = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f17612.dispose();
        }

        @Override // defpackage.InterfaceC5102
        public void onComplete() {
            this.f17611.onComplete();
        }

        @Override // defpackage.InterfaceC5102
        public void onError(Throwable th) {
            this.f17611.onError(th);
        }

        @Override // defpackage.InterfaceC5102
        public void onNext(T t) {
            this.f17611.onNext(t);
        }

        @Override // defpackage.InterfaceC5102
        public void onSubscribe(InterfaceC4478 interfaceC4478) {
            this.f17612 = interfaceC4478;
            this.f17611.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
        }
    }

    public C5321(AbstractC4262<T> abstractC4262) {
        this.f17610 = abstractC4262;
    }

    @Override // defpackage.AbstractC3630
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f17610.subscribe(new C5322(subscriber));
    }
}
