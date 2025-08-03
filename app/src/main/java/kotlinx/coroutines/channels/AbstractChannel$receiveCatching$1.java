package kotlinx.coroutines.channels;

import defpackage.C2351;
import defpackage.C5199;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* compiled from: AbstractChannel.kt */
@InterfaceC3540(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {632}, m = "receiveCatching-JP2dKIU")
/* loaded from: classes2.dex */
public final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AbstractChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, InterfaceC4355<? super AbstractChannel$receiveCatching$1> interfaceC4355) {
        super(interfaceC4355);
        this.this$0 = abstractChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo7332 = this.this$0.mo7332(this);
        return objMo7332 == C5199.m15170() ? objMo7332 : C2351.m8799(objMo7332);
    }
}
