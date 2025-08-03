package defpackage;

/* compiled from: BlockingLastObserver.java */
/* renamed from: ǐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2480<T> extends AbstractC2743<T> {
    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        this.f10074 = null;
        this.f10075 = th;
        countDown();
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        this.f10074 = t;
    }
}
