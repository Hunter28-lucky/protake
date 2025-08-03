package defpackage;

/* compiled from: MaybeObserver.java */
/* renamed from: Ⴓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC5216<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(InterfaceC4478 interfaceC4478);

    void onSuccess(T t);
}
