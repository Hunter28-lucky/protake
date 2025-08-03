package defpackage;

/* compiled from: BlockingLastSubscriber.java */
/* renamed from: Ι, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2792<T> extends AbstractC3496<T> {
    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f12248 = null;
        this.f12249 = th;
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        this.f12248 = t;
    }
}
