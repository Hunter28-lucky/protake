package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* compiled from: Builders.kt */
/* renamed from: ʏ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2666<T> extends ChannelFlow<T> {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC2849<InterfaceC3167<? super T>, InterfaceC4355<? super i4>, Object> f9921;

    /* JADX WARN: Multi-variable type inference failed */
    public C2666(InterfaceC2849<? super InterfaceC3167<? super T>, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f9921 = interfaceC2849;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static /* synthetic */ Object m9807(C2666 c2666, InterfaceC3167 interfaceC3167, InterfaceC4355 interfaceC4355) {
        Object objInvoke = c2666.f9921.invoke(interfaceC3167, interfaceC4355);
        return objInvoke == C5199.m15170() ? objInvoke : i4.f6762;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return "block[" + this.f9921 + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    /* renamed from: Ԫ */
    public Object mo7356(InterfaceC3167<? super T> interfaceC3167, InterfaceC4355<? super i4> interfaceC4355) {
        return m9807(this, interfaceC3167, interfaceC4355);
    }
}
