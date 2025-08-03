package defpackage;

import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: Channel.kt */
/* renamed from: ү, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3078 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <E> InterfaceC3523<E> m10647(int i, BufferOverflow bufferOverflow, InterfaceC2392<? super E, i4> interfaceC2392) {
        if (i == -2) {
            return new C4942(bufferOverflow == BufferOverflow.SUSPEND ? InterfaceC3523.f12314.m11465() : 1, bufferOverflow, interfaceC2392);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? (i == 1 && bufferOverflow == BufferOverflow.DROP_OLDEST) ? new C3692(interfaceC2392) : new C4942(i, bufferOverflow, interfaceC2392) : new C5266(interfaceC2392) : bufferOverflow == BufferOverflow.SUSPEND ? new C4688(interfaceC2392) : new C4942(1, bufferOverflow, interfaceC2392);
        }
        if ((bufferOverflow != BufferOverflow.SUSPEND ? 0 : 1) != 0) {
            return new C3692(interfaceC2392);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC3523 m10648(int i, BufferOverflow bufferOverflow, InterfaceC2392 interfaceC2392, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            interfaceC2392 = null;
        }
        return m10647(i, bufferOverflow, interfaceC2392);
    }
}
