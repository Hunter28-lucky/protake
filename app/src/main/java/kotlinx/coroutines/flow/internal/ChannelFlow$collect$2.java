package kotlinx.coroutines.flow.internal;

import defpackage.C3743;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3421;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4230;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: ChannelFlow.kt */
@InterfaceC3540(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ChannelFlow$collect$2 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
    public final /* synthetic */ InterfaceC3421<T> $collector;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlow$collect$2(InterfaceC3421<? super T> interfaceC3421, ChannelFlow<T> channelFlow, InterfaceC4355<? super ChannelFlow$collect$2> interfaceC4355) {
        super(2, interfaceC4355);
        this.$collector = interfaceC3421;
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, interfaceC4355);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
        return ((ChannelFlow$collect$2) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM15170 = C5199.m15170();
        int i = this.label;
        if (i == 0) {
            C4817.m14542(obj);
            InterfaceC3539 interfaceC3539 = (InterfaceC3539) this.L$0;
            InterfaceC3421<T> interfaceC3421 = this.$collector;
            InterfaceC4230 interfaceC4230M7365 = this.this$0.m7365(interfaceC3539);
            this.label = 1;
            if (C3743.m11991(interfaceC3421, interfaceC4230M7365, this) == objM15170) {
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
