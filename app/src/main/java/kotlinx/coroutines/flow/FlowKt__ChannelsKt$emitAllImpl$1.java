package kotlinx.coroutines.flow;

import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: Channels.kt */
@InterfaceC3540(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt")
/* loaded from: classes2.dex */
public final class FlowKt__ChannelsKt$emitAllImpl$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public boolean Z$0;
    public int label;
    public /* synthetic */ Object result;

    public FlowKt__ChannelsKt$emitAllImpl$1(InterfaceC4355<? super FlowKt__ChannelsKt$emitAllImpl$1> interfaceC4355) {
        super(interfaceC4355);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__ChannelsKt.m7359(null, null, false, this);
    }
}
