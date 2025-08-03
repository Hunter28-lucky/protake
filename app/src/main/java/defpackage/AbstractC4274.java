package defpackage;

import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeToObservable;

/* compiled from: Maybe.java */
/* renamed from: ਲ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4274<T> implements InterfaceC3517<T> {
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> AbstractC4274<T> m13385(Throwable th) {
        C4246.m13353(th, "exception is null");
        return C3671.m11797(new C2934(th));
    }

    @Override // defpackage.InterfaceC3517
    /* renamed from: Ԩ */
    public final void mo11463(InterfaceC5216<? super T> interfaceC5216) {
        C4246.m13353(interfaceC5216, "observer is null");
        InterfaceC5216<? super T> interfaceC5216M11808 = C3671.m11808(this, interfaceC5216);
        C4246.m13353(interfaceC5216M11808, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            mo6675(interfaceC5216M11808);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4089.m13026(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final T m13386() {
        C2350 c2350 = new C2350();
        mo11463(c2350);
        return (T) c2350.m8797();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final <R> AbstractC4274<R> m13387(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11797(new MaybeFlatten(this, interfaceC2368));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final <R> AbstractC4274<R> m13388(InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11797(new C4703(this, interfaceC2368));
    }

    /* renamed from: Ԯ */
    public abstract void mo6675(InterfaceC5216<? super T> interfaceC5216);

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC4838<T> m13389(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11800(new MaybeSwitchIfEmptySingle(this, interfaceC3951));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ՠ, reason: contains not printable characters */
    public final AbstractC4262<T> m13390() {
        return this instanceof InterfaceC2325 ? ((InterfaceC2325) this).mo6779() : C3671.m11798(new MaybeToObservable(this));
    }
}
