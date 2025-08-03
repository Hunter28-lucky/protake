package defpackage;

import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins.java */
/* renamed from: ڛ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3548 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static volatile InterfaceC2368<Callable<AbstractC4585>, AbstractC4585> f12344;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static volatile InterfaceC2368<AbstractC4585, AbstractC4585> f12345;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, R> R m11487(InterfaceC2368<T, R> interfaceC2368, T t) {
        try {
            return interfaceC2368.apply(t);
        } catch (Throwable th) {
            throw C4089.m13025(th);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static AbstractC4585 m11488(InterfaceC2368<Callable<AbstractC4585>, AbstractC4585> interfaceC2368, Callable<AbstractC4585> callable) {
        AbstractC4585 abstractC4585 = (AbstractC4585) m11487(interfaceC2368, callable);
        if (abstractC4585 != null) {
            return abstractC4585;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static AbstractC4585 m11489(Callable<AbstractC4585> callable) {
        try {
            AbstractC4585 abstractC4585Call = callable.call();
            if (abstractC4585Call != null) {
                return abstractC4585Call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw C4089.m13025(th);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static AbstractC4585 m11490(Callable<AbstractC4585> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC2368<Callable<AbstractC4585>, AbstractC4585> interfaceC2368 = f12344;
        return interfaceC2368 == null ? m11489(callable) : m11488(interfaceC2368, callable);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static AbstractC4585 m11491(AbstractC4585 abstractC4585) {
        if (abstractC4585 == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC2368<AbstractC4585, AbstractC4585> interfaceC2368 = f12345;
        return interfaceC2368 == null ? abstractC4585 : (AbstractC4585) m11487(interfaceC2368, abstractC4585);
    }
}
