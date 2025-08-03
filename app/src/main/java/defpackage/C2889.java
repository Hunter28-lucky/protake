package defpackage;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* compiled from: EndConsumerHelper.java */
/* renamed from: л, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2889 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m10245(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m10246(Class<?> cls) {
        C3671.m11803(new ProtocolViolationException(m10245(cls.getName())));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m10247(AtomicReference<InterfaceC4478> atomicReference, InterfaceC4478 interfaceC4478, Class<?> cls) {
        C4246.m13353(interfaceC4478, "next is null");
        if (C4905.m14631(atomicReference, null, interfaceC4478)) {
            return true;
        }
        interfaceC4478.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        m10246(cls);
        return false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m10248(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        C4246.m13353(subscription, "next is null");
        if (C4905.m14631(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        m10246(cls);
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m10249(InterfaceC4478 interfaceC4478, InterfaceC4478 interfaceC44782, Class<?> cls) {
        C4246.m13353(interfaceC44782, "next is null");
        if (interfaceC4478 == null) {
            return true;
        }
        interfaceC44782.dispose();
        if (interfaceC4478 == DisposableHelper.DISPOSED) {
            return false;
        }
        m10246(cls);
        return false;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m10250(Subscription subscription, Subscription subscription2, Class<?> cls) {
        C4246.m13353(subscription2, "next is null");
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        if (subscription == SubscriptionHelper.CANCELLED) {
            return false;
        }
        m10246(cls);
        return false;
    }
}
