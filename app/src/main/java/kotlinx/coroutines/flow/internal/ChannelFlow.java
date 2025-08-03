package kotlinx.coroutines.flow.internal;

import defpackage.C2316;
import defpackage.C2543;
import defpackage.C2945;
import defpackage.C3921;
import defpackage.C4659;
import defpackage.C5199;
import defpackage.InterfaceC2715;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3167;
import defpackage.InterfaceC3421;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC4230;
import defpackage.InterfaceC4355;
import defpackage.i4;
import java.util.ArrayList;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes2.dex */
public abstract class ChannelFlow<T> implements InterfaceC2715 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CoroutineContext f7876;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f7877;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final BufferOverflow f7878;

    public ChannelFlow(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.f7876 = coroutineContext;
        this.f7877 = i;
        this.f7878 = bufferOverflow;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ Object m7360(ChannelFlow channelFlow, InterfaceC3421 interfaceC3421, InterfaceC4355 interfaceC4355) throws Throwable {
        Object objM10347 = C2945.m10347(new ChannelFlow$collect$2(interfaceC3421, channelFlow, null), interfaceC4355);
        return objM10347 == C5199.m15170() ? objM10347 : i4.f6762;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strM7362 = m7362();
        if (strM7362 != null) {
            arrayList.add(strM7362);
        }
        CoroutineContext coroutineContext = this.f7876;
        if (coroutineContext != EmptyCoroutineContext.f7835) {
            arrayList.add(C3921.m12673("context=", coroutineContext));
        }
        int i = this.f7877;
        if (i != -3) {
            arrayList.add(C3921.m12673("capacity=", Integer.valueOf(i)));
        }
        BufferOverflow bufferOverflow = this.f7878;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add(C3921.m12673("onBufferOverflow=", bufferOverflow));
        }
        return C2316.m8690(this) + '[' + C2543.m9374(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    @Override // defpackage.InterfaceC2715
    /* renamed from: Ϳ, reason: contains not printable characters */
    public Object mo7361(InterfaceC3421<? super T> interfaceC3421, InterfaceC4355<? super i4> interfaceC4355) {
        return m7360(this, interfaceC3421, interfaceC4355);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m7362() {
        return null;
    }

    /* renamed from: Ԫ */
    public abstract Object mo7356(InterfaceC3167<? super T> interfaceC3167, InterfaceC4355<? super i4> interfaceC4355);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2849<InterfaceC3167<? super T>, InterfaceC4355<? super i4>, Object> m7363() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m7364() {
        int i = this.f7877;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC4230<T> m7365(InterfaceC3539 interfaceC3539) {
        return C4659.m14143(interfaceC3539, this.f7876, m7364(), this.f7878, CoroutineStart.ATOMIC, null, m7363(), 16, null);
    }
}
