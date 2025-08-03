package defpackage;

/* compiled from: Observer.java */
/* renamed from: ဏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC5102<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(InterfaceC4478 interfaceC4478);
}
