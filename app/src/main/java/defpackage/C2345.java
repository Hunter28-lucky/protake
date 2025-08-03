package defpackage;

/* compiled from: BlockingFirstSubscriber.java */
/* renamed from: ı, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2345<T> extends AbstractC3496<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f12248 == null) {
            this.f12249 = th;
        } else {
            C3671.m11803(th);
        }
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.f12248 == null) {
            this.f12248 = t;
            this.f12250.cancel();
            countDown();
        }
    }
}
