package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* renamed from: Ⴠ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC5238 extends CoroutineContext.InterfaceC2140 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C5240 f17362 = C5240.f17363;

    /* compiled from: Job.kt */
    /* renamed from: Ⴠ$Ϳ, reason: contains not printable characters */
    public static final class C5239 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static /* synthetic */ void m15254(InterfaceC5238 interfaceC5238, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            interfaceC5238.mo9832(cancellationException);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static <R> R m15255(InterfaceC5238 interfaceC5238, R r, InterfaceC2849<? super R, ? super CoroutineContext.InterfaceC2140, ? extends R> interfaceC2849) {
            return (R) CoroutineContext.InterfaceC2140.C2141.m7249(interfaceC5238, r, interfaceC2849);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static <E extends CoroutineContext.InterfaceC2140> E m15256(InterfaceC5238 interfaceC5238, CoroutineContext.InterfaceC2142<E> interfaceC2142) {
            return (E) CoroutineContext.InterfaceC2140.C2141.m7250(interfaceC5238, interfaceC2142);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static /* synthetic */ InterfaceC2645 m15257(InterfaceC5238 interfaceC5238, boolean z, boolean z2, InterfaceC2392 interfaceC2392, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return interfaceC5238.mo9833(z, z2, interfaceC2392);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public static CoroutineContext m15258(InterfaceC5238 interfaceC5238, CoroutineContext.InterfaceC2142<?> interfaceC2142) {
            return CoroutineContext.InterfaceC2140.C2141.m7251(interfaceC5238, interfaceC2142);
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static CoroutineContext m15259(InterfaceC5238 interfaceC5238, CoroutineContext coroutineContext) {
            return CoroutineContext.InterfaceC2140.C2141.m7252(interfaceC5238, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    /* renamed from: Ⴠ$Ԩ, reason: contains not printable characters */
    public static final class C5240 implements CoroutineContext.InterfaceC2142<InterfaceC5238> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final /* synthetic */ C5240 f17363 = new C5240();
    }

    boolean start();

    /* renamed from: Ϳ */
    boolean mo9831();

    /* renamed from: Ԩ */
    void mo9832(CancellationException cancellationException);

    /* renamed from: Ԫ */
    InterfaceC2645 mo9833(boolean z, boolean z2, InterfaceC2392<? super Throwable, i4> interfaceC2392);

    /* renamed from: ԭ */
    CancellationException mo9834();

    /* renamed from: ހ */
    InterfaceC3243 mo9837(InterfaceC4999 interfaceC4999);
}
