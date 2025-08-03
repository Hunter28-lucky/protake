package defpackage;

import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: SubscriberCompletableObserver.java */
/* loaded from: classes2.dex */
public final class l0<T> implements InterfaceC5053, Subscription {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Subscriber<? super T> f7935;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC4478 f7936;

    public l0(Subscriber<? super T> subscriber) {
        this.f7935 = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f7936.dispose();
    }

    @Override // defpackage.InterfaceC5053
    public void onComplete() {
        this.f7935.onComplete();
    }

    @Override // defpackage.InterfaceC5053
    public void onError(Throwable th) {
        this.f7935.onError(th);
    }

    @Override // defpackage.InterfaceC5053
    public void onSubscribe(InterfaceC4478 interfaceC4478) {
        if (DisposableHelper.validate(this.f7936, interfaceC4478)) {
            this.f7936 = interfaceC4478;
            this.f7935.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
