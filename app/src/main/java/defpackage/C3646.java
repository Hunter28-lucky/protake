package defpackage;

/* compiled from: BlockingFirstObserver.java */
/* renamed from: ۦ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3646<T> extends AbstractC2743<T> {
    @Override // defpackage.InterfaceC5102
    public void onError(Throwable th) {
        if (this.f10074 == null) {
            this.f10075 = th;
        }
        countDown();
    }

    @Override // defpackage.InterfaceC5102
    public void onNext(T t) {
        if (this.f10074 == null) {
            this.f10074 = t;
            this.f10076.dispose();
            countDown();
        }
    }
}
