package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: Produce.kt */
/* renamed from: ಹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4659 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <E> InterfaceC4230<E> m14142(InterfaceC3539 interfaceC3539, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, InterfaceC2392<? super Throwable, i4> interfaceC2392, InterfaceC2849<? super InterfaceC3167<? super E>, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C4214 c4214 = new C4214(C3079.m10651(interfaceC3539, coroutineContext), C3078.m10648(i, bufferOverflow, null, 4, null));
        if (interfaceC2392 != null) {
            c4214.m9861(interfaceC2392);
        }
        c4214.m10781(coroutineStart, c4214, interfaceC2849);
        return c4214;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC4230 m14143(InterfaceC3539 interfaceC3539, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, InterfaceC2392 interfaceC2392, InterfaceC2849 interfaceC2849, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f7835;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 16) != 0) {
            interfaceC2392 = null;
        }
        return m14142(interfaceC3539, coroutineContext2, i3, bufferOverflow2, coroutineStart2, interfaceC2392, interfaceC2849);
    }
}
