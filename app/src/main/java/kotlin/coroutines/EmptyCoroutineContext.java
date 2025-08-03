package kotlin.coroutines;

import com.umeng.analytics.pro.d;
import defpackage.C3921;
import defpackage.InterfaceC2849;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final EmptyCoroutineContext f7835 = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f7835;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, InterfaceC2849<? super R, ? super CoroutineContext.InterfaceC2140, ? extends R> interfaceC2849) {
        C3921.m12666(interfaceC2849, "operation");
        return r;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.InterfaceC2140> E get(CoroutineContext.InterfaceC2142<E> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        C3921.m12666(interfaceC2142, "key");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        C3921.m12666(coroutineContext, d.R);
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
