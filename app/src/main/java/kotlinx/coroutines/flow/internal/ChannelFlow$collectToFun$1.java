package kotlinx.coroutines.flow.internal;

import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3167;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ChannelFlow.kt */
@InterfaceC3540(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ChannelFlow$collectToFun$1<T> extends SuspendLambda implements InterfaceC2849<InterfaceC3167<? super T>, InterfaceC4355<? super i4>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, InterfaceC4355<? super ChannelFlow$collectToFun$1> interfaceC4355) {
        super(2, interfaceC4355);
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, interfaceC4355);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(InterfaceC3167<? super T> interfaceC3167, InterfaceC4355<? super i4> interfaceC4355) {
        return ((ChannelFlow$collectToFun$1) create(interfaceC3167, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM15170 = C5199.m15170();
        int i = this.label;
        if (i == 0) {
            C4817.m14542(obj);
            InterfaceC3167<? super T> interfaceC3167 = (InterfaceC3167) this.L$0;
            ChannelFlow<T> channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.mo7356(interfaceC3167, this) == objM15170) {
                return objM15170;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4817.m14542(obj);
        }
        return i4.f6762;
    }
}
