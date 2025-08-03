package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.JobCancellationException;

/* compiled from: ChannelCoroutine.kt */
/* renamed from: ہ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3620<E> extends AbstractC3173<i4> implements InterfaceC3523<E> {

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3523<E> f12568;

    public C3620(CoroutineContext coroutineContext, InterfaceC3523<E> interfaceC3523, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.f12568 = interfaceC3523;
    }

    @Override // defpackage.C2680, defpackage.InterfaceC5238
    /* renamed from: Ԩ */
    public final void mo9832(CancellationException cancellationException) {
        if (m9862()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo9846(), null, this);
        }
        mo9843(cancellationException);
    }

    @Override // defpackage.InterfaceC4230
    /* renamed from: Ԭ */
    public Object mo7332(InterfaceC4355<? super C2351<? extends E>> interfaceC4355) {
        Object objMo7332 = this.f12568.mo7332(interfaceC4355);
        C5199.m15170();
        return objMo7332;
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: Ԯ */
    public Object mo9341(E e2, InterfaceC4355<? super i4> interfaceC4355) {
        return this.f12568.mo9341(e2, interfaceC4355);
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: ՠ */
    public boolean mo9342(Throwable th) {
        return this.f12568.mo9342(th);
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: ށ */
    public boolean mo9343() {
        return this.f12568.mo9343();
    }

    @Override // defpackage.C2680
    /* renamed from: ދ */
    public void mo9843(Throwable th) {
        CancellationException cancellationExceptionM9830 = C2680.m9830(this, th, null, 1, null);
        this.f12568.mo7331(cancellationExceptionM9830);
        m9841(cancellationExceptionM9830);
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public final InterfaceC3523<E> m11676() {
        return this.f12568;
    }
}
