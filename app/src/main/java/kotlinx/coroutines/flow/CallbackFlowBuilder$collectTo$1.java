package kotlinx.coroutines.flow;

import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: Builders.kt */
@InterfaceC3540(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {355}, m = "collectTo")
/* loaded from: classes2.dex */
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CallbackFlowBuilder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, InterfaceC4355<? super CallbackFlowBuilder$collectTo$1> interfaceC4355) {
        super(interfaceC4355);
        this.this$0 = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo7356(null, this);
    }
}
