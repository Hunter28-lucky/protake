package defpackage;

import io.reactivex.disposables.C1972;

/* compiled from: MaybeError.java */
/* renamed from: ѡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2934<T> extends AbstractC4274<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Throwable f10644;

    public C2934(Throwable th) {
        this.f10644 = th;
    }

    @Override // defpackage.AbstractC4274
    /* renamed from: Ԯ */
    public void mo6675(InterfaceC5216<? super T> interfaceC5216) {
        interfaceC5216.onSubscribe(C1972.m6299());
        interfaceC5216.onError(this.f10644);
    }
}
