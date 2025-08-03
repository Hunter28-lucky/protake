package kotlinx.coroutines.flow;

import defpackage.C2666;
import defpackage.C4184;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3167;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: Builders.kt */
/* loaded from: classes2.dex */
public final class CallbackFlowBuilder<T> extends C2666<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2849<InterfaceC3167<? super T>, InterfaceC4355<? super i4>, Object> f7875;

    public /* synthetic */ CallbackFlowBuilder(InterfaceC2849 interfaceC2849, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, C4184 c4184) {
        this(interfaceC2849, (i2 & 2) != 0 ? EmptyCoroutineContext.f7835 : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.C2666, kotlinx.coroutines.flow.internal.ChannelFlow
    /* renamed from: Ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo7356(defpackage.InterfaceC3167<? super T> r5, defpackage.InterfaceC4355<? super defpackage.i4> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = (kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1 r0 = new kotlinx.coroutines.flow.CallbackFlowBuilder$collectTo$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = defpackage.C5199.m15170()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ԣ r5 = (defpackage.InterfaceC3167) r5
            defpackage.C4817.m14542(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            defpackage.C4817.m14542(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = super.mo7356(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.mo9343()
            if (r5 == 0) goto L4c
            i4 r5 = defpackage.i4.f6762
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.CallbackFlowBuilder.mo7356(ԣ, ન):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(InterfaceC2849<? super InterfaceC3167<? super T>, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(interfaceC2849, coroutineContext, i, bufferOverflow);
        this.f7875 = interfaceC2849;
    }
}
