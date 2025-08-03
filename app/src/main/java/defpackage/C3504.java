package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* renamed from: ټ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3504 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m11441(CoroutineContext coroutineContext, CancellationException cancellationException) {
        InterfaceC5238 interfaceC5238 = (InterfaceC5238) coroutineContext.get(InterfaceC5238.f17362);
        if (interfaceC5238 == null) {
            return;
        }
        interfaceC5238.mo9832(cancellationException);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ void m11442(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        C4428.m13660(coroutineContext, cancellationException);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final void m11443(InterfaceC5238 interfaceC5238) {
        if (!interfaceC5238.mo9831()) {
            throw interfaceC5238.mo9834();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final void m11444(CoroutineContext coroutineContext) {
        InterfaceC5238 interfaceC5238 = (InterfaceC5238) coroutineContext.get(InterfaceC5238.f17362);
        if (interfaceC5238 == null) {
            return;
        }
        C4428.m13662(interfaceC5238);
    }
}
